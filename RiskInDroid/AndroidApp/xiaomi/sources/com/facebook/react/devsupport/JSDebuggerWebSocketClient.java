package com.facebook.react.devsupport;

import _m_j.fkb;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.JavascriptException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class JSDebuggerWebSocketClient extends WebSocketListener {
    private final ConcurrentHashMap<Integer, JSDebuggerCallback> mCallbacks = new ConcurrentHashMap<>();
    private JSDebuggerCallback mConnectCallback;
    private OkHttpClient mHttpClient;
    private final AtomicInteger mRequestID = new AtomicInteger();
    private WebSocket mWebSocket;

    public interface JSDebuggerCallback {
        void onFailure(Throwable th);

        void onSuccess(String str);
    }

    public void connect(String str, JSDebuggerCallback jSDebuggerCallback) {
        if (this.mHttpClient == null) {
            this.mConnectCallback = jSDebuggerCallback;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            fkb.O000000o(builder);
            this.mHttpClient = builder.connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MINUTES).build();
            this.mHttpClient.newWebSocket(new Request.Builder().url(str).build(), this);
            return;
        }
        throw new IllegalStateException("JSDebuggerWebSocketClient is already initialized.");
    }

    public void prepareJSRuntime(JSDebuggerCallback jSDebuggerCallback) {
        int andIncrement = this.mRequestID.getAndIncrement();
        this.mCallbacks.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
        try {
            StringWriter stringWriter = new StringWriter();
            new JsonWriter(stringWriter).beginObject().name("id").value((long) andIncrement).name("method").value("prepareJSRuntime").endObject().close();
            sendMessage(andIncrement, stringWriter.toString());
        } catch (IOException e) {
            triggerRequestFailure(andIncrement, e);
        }
    }

    public void loadApplicationScript(String str, HashMap<String, String> hashMap, JSDebuggerCallback jSDebuggerCallback) {
        int andIncrement = this.mRequestID.getAndIncrement();
        this.mCallbacks.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter beginObject = new JsonWriter(stringWriter).beginObject().name("id").value((long) andIncrement).name("method").value("executeApplicationScript").name("url").value(str).name("inject").beginObject();
            for (String next : hashMap.keySet()) {
                beginObject.name(next).value(hashMap.get(next));
            }
            beginObject.endObject().endObject().close();
            sendMessage(andIncrement, stringWriter.toString());
        } catch (IOException e) {
            triggerRequestFailure(andIncrement, e);
        }
    }

    public void executeJSCall(String str, String str2, JSDebuggerCallback jSDebuggerCallback) {
        int andIncrement = this.mRequestID.getAndIncrement();
        this.mCallbacks.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.beginObject().name("id").value((long) andIncrement).name("method").value(str);
            stringWriter.append((CharSequence) ",\"arguments\":").append((CharSequence) str2);
            jsonWriter.endObject().close();
            sendMessage(andIncrement, stringWriter.toString());
        } catch (IOException e) {
            triggerRequestFailure(andIncrement, e);
        }
    }

    public void closeQuietly() {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            try {
                webSocket.close(1000, "End of session");
            } catch (Exception unused) {
            }
            this.mWebSocket = null;
        }
    }

    private void sendMessage(int i, String str) {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket == null) {
            triggerRequestFailure(i, new IllegalStateException("WebSocket connection no longer valid"));
            return;
        }
        try {
            webSocket.send(str);
        } catch (Exception e) {
            triggerRequestFailure(i, e);
        }
    }

    private void triggerRequestFailure(int i, Throwable th) {
        JSDebuggerCallback jSDebuggerCallback = this.mCallbacks.get(Integer.valueOf(i));
        if (jSDebuggerCallback != null) {
            this.mCallbacks.remove(Integer.valueOf(i));
            jSDebuggerCallback.onFailure(th);
        }
    }

    private void triggerRequestSuccess(int i, String str) {
        JSDebuggerCallback jSDebuggerCallback = this.mCallbacks.get(Integer.valueOf(i));
        if (jSDebuggerCallback != null) {
            this.mCallbacks.remove(Integer.valueOf(i));
            jSDebuggerCallback.onSuccess(str);
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:30:0x000f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:25:0x000f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:29:0x000f */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void onMessage(WebSocket webSocket, String str) {
        Integer num = null;
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.beginObject();
            String str2 = num;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (JsonToken.NULL == jsonReader.peek()) {
                    jsonReader.skipValue();
                } else if ("replyID".equals(nextName)) {
                    num = Integer.valueOf(jsonReader.nextInt());
                } else if ("result".equals(nextName)) {
                    str2 = jsonReader.nextString();
                } else if ("error".equals(nextName)) {
                    String nextString = jsonReader.nextString();
                    abort(nextString, new JavascriptException(nextString));
                }
            }
            if (num != null) {
                triggerRequestSuccess(num.intValue(), str2);
            }
        } catch (IOException e) {
            if (num != null) {
                triggerRequestFailure(num.intValue(), e);
            } else {
                abort("Parsing response message from websocket failed", e);
            }
        }
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        abort("Websocket exception", th);
    }

    public void onOpen(WebSocket webSocket, Response response) {
        this.mWebSocket = webSocket;
        ((JSDebuggerCallback) Assertions.assertNotNull(this.mConnectCallback)).onSuccess(null);
        this.mConnectCallback = null;
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        this.mWebSocket = null;
    }

    private void abort(String str, Throwable th) {
        FLog.e("JSDebuggerWebSocketClient", "Error occurred, shutting down websocket connection: ".concat(String.valueOf(str)), th);
        closeQuietly();
        JSDebuggerCallback jSDebuggerCallback = this.mConnectCallback;
        if (jSDebuggerCallback != null) {
            jSDebuggerCallback.onFailure(th);
            this.mConnectCallback = null;
        }
        for (JSDebuggerCallback onFailure : this.mCallbacks.values()) {
            onFailure.onFailure(th);
        }
        this.mCallbacks.clear();
    }
}
