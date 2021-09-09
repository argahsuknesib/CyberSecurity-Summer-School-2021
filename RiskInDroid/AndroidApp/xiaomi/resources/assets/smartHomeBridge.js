// notation: js file can only use this kind of comments
// since comments will cause error when use in webview.loadurl,
// comments will be remove by java use regexp
  console.log('MJApi init begin');
  if (!window.MJApi || !window.MJApi.callJavaHandler || !window.MJApi.callJavaResponse) {
    console.log('native must inject MJApi object first');
    return;
  }

  if (window.MJApi.isInit) {
    console.log('MJApi has init');
    window.MJApi.callHandler('default','init');
    return;
  }

  if(window.needWaitHandlerRegister){
     window.needWaitHandlerRegister=[...window.needWaitHandlerRegister,'onWebVisible'];
  }else{
     window.needWaitHandlerRegister=['onWebVisible']
  }
  var messageHandlers = {};
  var responseCallbacks = {};
  var uniqueId = 1;
  var waitMessageQueue={};

  // java call js Handler
  window.MJApi._handleMessageFromNative = function(messageJSON) {
    console.log(messageJSON);
    var message = JSON.parse(messageJSON);
    var responseCallback;
    // java call finished, now need to call js callback function
    if (message.responseId) {
      responseCallback = responseCallbacks[message.responseId];
      if (!responseCallback) {
        return;
      }
      responseCallback(message.responseData);
      delete responseCallbacks[message.responseId];
    } else {
      // 直接发送
      if (message.callbackId) {
        var callbackResponseId = message.callbackId;
        responseCallback = function(responseData) {
          window.MJApi.callJavaResponse(responseData, callbackResponseId);
          delete responseCallbacks[callbackResponseId];
        };
        responseCallbacks[callbackResponseId] = responseCallback;
      }

      var handler = null;
      if (message.handlerName) {
          handler = messageHandlers[message.handlerName];
      }
      if (!handler) {
        if(message.handlerName&&window.needWaitHandlerRegister&&window.needWaitHandlerRegister.indexOf(message.handlerName)>=0){
             waitMessageQueue[message.handlerName]={data:message.data,responseCallback:responseCallback};
             console.log('MJApi: wait for  handler:'+message.handlerName);
        }else{
         if (responseCallback && typeof responseCallback === 'function') {
                  responseCallback({ status: -1, data: 'no handler' });
           }
           console.log('MJApi: no handler');
        }

      } else {
        handler(message.data, responseCallback);
      }
    }
  };

    // js call java  handler
   window.MJApi.callHandler = function(handlerName, data, responseCallback) {
    var callbackId = '';
    if (responseCallback) {
      if (typeof responseCallback === 'string') {
        callbackId = responseCallback;
      } else if (typeof responseCallback === 'function') {
        callbackId = 'cb_' + (uniqueId++) + '_' + new Date().getTime();
        responseCallbacks[callbackId] = responseCallback;
      }
    }
    window.MJApi.callJavaHandler(handlerName, JSON.stringify(data), callbackId);
  };


  // 注册handler 往数组里面添加值
  window.MJApi.registerHandler = function(handlerName, handler) {
    console.log("js registerHandler:"+handlerName);
    messageHandlers[handlerName] = handler;
    var waitMessage=waitMessageQueue[handlerName];
    if(waitMessage){
         console.log("callhandler while register becuase has wait msg:"+handlerName+":data="+waitMessage.data+",callback="+waitMessage.responseCallback);
         handler(waitMessage.data,waitMessage.responseCallback);
         delete waitMessageQueue[handlerName];
    }
  };
  window.MJApi.unRegisterHandler = function(handlerName) {
  console.log("js unRegisterHandler:"+handlerName);
    if (messageHandlers[handlerName]) {
      delete messageHandlers[handlerName];
    }
    var waitMessage=waitMessageQueue[handlerName];
        if(waitMessage){
             delete waitMessageQueue[handlerName];
        }
  };

   window.MJApi.createAPI = function(funcName) {
      return function(data, callBackFun) {
        window.MJApi.callHandler(funcName, data, callBackFun);
      };
    };


