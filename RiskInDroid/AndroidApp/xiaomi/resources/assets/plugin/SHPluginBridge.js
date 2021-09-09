(function() {

    var GLOBAL_NAME = 'SHPlugin';
    var MESSAGE_SCHEME = 'shpluginscheme://';
    var MESSAGE_SEMAPHORE = '_MESSAGE_SEMAPHORE_'
    var MESSAGE_QUEUE = '_MESSAGE_QUEUE_';
    var MESSAGE_SPLIT = '_MESSAGE_SPLIT_';

    var global = {};

    var messageQueue = [];
    var isSending = false;

    var util = function() {
        var ostring = Object.prototype.toString;
        return {
            getRandomKey: (function() {
                var n = 0;
                return function() {
                    return '_$@r' + (n++);
                }
            })(),
            isArray: function(it) {
                return ostring.call(it) === '[object Array]';
            },
            isObject: function(it) {
                return ostring.call(it) === '[object Object]';
            },
            isString: function(it) {
                return ostring.call(it) === '[object String]';
            },
            isNumber: function(it) {
                return ostring.call(it) === '[object Number]';
            },
            isDom: function(it) {
                return ostring.call(it) === '[object HTMLDivElement]';
            },
            isFunction: function(it) {
                return ostring.call(it) === '[object Function]';
            },
            isAndroid: function() {
                var ua = window.navigator.userAgent.toLowerCase();
                if (/android/.test(ua)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }();

    /**
     * 事件分发器
     */
    var dispatcher = function() {
        var allHandlers = {};

        return {
            /**
             * 监听事件
             * @param  {String} evt     事件类型
             * @param  {Function} handler 事件句柄
             * @return {Function}         事件句柄
             */
            on: function(evt, handler) {
                if (!allHandlers[evt]) {
                    allHandlers[evt] = [];
                }
                allHandlers[evt].push(handler);
                return handler;
            },
            /**
             * 移除监听事件
             * @param  {String} evt     事件类型
             * @param  {Function} handler 事件句柄
             */
            off: function(evt, handler) {
                var handlers = allHandlers[evt];

                if (!handlers) {
                    return;
                }

                for (var i = 0, n = handlers.length; i < n; i++) {
                    if (handlers[i] === handler) {
                        handlers.splice(i, 1);
                        break;
                    }
                }
            },
            /**
             * 移除监听事件
             * @param  {String} evt     事件类型
             * @param  {Function} handler 事件句柄
             */
            fire: function(evt, args, context) {

                var handlers = allHandlers[evt];
                if (!handlers) {
                    return;
                }

                for (var i = 0, n = handlers.length; i < n; i++) {
                    if (handlers[i].apply(context, args) === true) {
                        this.off(evt, handlers[i]);
                        i--;
                        n--;
                    }
                }
            },
            /**
             * 销毁事件对象，取消所有事件
             */
            destory: function() {
                allHandlers = {};
            }
        }
    }();



    var messagingIframe = null;
    var sendUrl = function(urlString) {
        if (!messagingIframe) {
            messagingIframe = document.createElement('iframe');
            messagingIframe.style.display = 'none';
            messagingIframe.src = urlString;
            document.documentElement.appendChild(messagingIframe);
        } else {
            messagingIframe.src = urlString;
        }
    }

    var kernel = {
        sendNotifyRequest: function() {
            if (isSending) {
                return;
            }
            isSending = true;

            //向native发送信号量，再由native发起获取数据的函数调用
            sendUrl(MESSAGE_SCHEME + MESSAGE_SEMAPHORE);

        }
    };

    var Bridge = {
        /**
         * Native获取消息
         * @param  {String} channel 通道,android传入"consoleLog"或"url",iPhone通过返回值
         * @return {[type]}         [description]
         */
        getMessage: function(channel) {
            isSending = false;

            var messageQueueString = messageQueue.join(MESSAGE_SPLIT);
            messageQueue = [];

            if (channel === "consoleLog") {
                //默认通道
                console.log(messageQueueString);
            } else if (channel === "url") {
                //部分机型不支持console log监听，比如HTC，使用此通道
                sendUrl(MESSAGE_SCHEME + MESSAGE_QUEUE + encodeURI(messageQueueString));
            }
            // ios使用返回值通道
            return messageQueueString;
        },
        notify: function(messageStr) {
            console.log("miio-app "+JSON.stringify(messageStr));
            var message = util.isString(messageStr) ? JSON.parse(messageStr) : messageStr;
            var eventName = message.invokeEvent || message.callbackEvent;
            var param = message.param || message.responseData || {};
            dispatcher.fire(eventName, [param]);
        }
    };

    var Api = {
        remove: function(listener) {
            return dispatcher.off(listener);
        },
        /**
         * 监听事件，该事件可能是由native发起或是js内部发起的
         * @param  {String}   eventName
         * @param  {Function} callback
         */
        listen: function(eventName, callback) {
            return dispatcher.on(eventName, callback);
        },
        /**
         * WebView正调Native
         * @param  {String}   invokeEvent   正调事件，request/getSystemInfo/changePage
         * @param  {Object}   param         正调参数
         * @param  {Function|String} callback       回调函数,若为String则指定回调事件名
         */
        notify: function(invokeEvent, param, callback) {
            var callbackEvent = "";
            if (util.isString(callback)) {
                callbackEvent = callback;
                callback = null;
            } else {
                callbackEvent = 'ce_' + util.getRandomKey();
            }

            if (callback) {
                //监听回调函数
                dispatcher.on(callbackEvent, function() {
                    callback && callback.apply(null, arguments);
                    return true;
                });
            }

            var message = {
                'invokeEvent': invokeEvent,
                'callbackEvent': callbackEvent,
                'param': param
            };
            messageQueue.push(JSON.stringify(message));

            kernel.sendNotifyRequest();
        }
    };

    global['Bridge'] = Bridge;
    global['Api'] = Api;


    window[GLOBAL_NAME] = global;

})();