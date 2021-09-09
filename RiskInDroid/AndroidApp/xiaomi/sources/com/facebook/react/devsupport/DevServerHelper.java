package com.facebook.react.devsupport;

import _m_j.fkb;
import _m_j.jbg;
import _m_j.jbm;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.devsupport.BundleDeltaClient;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevServerHelper {
    private final BundleDownloader mBundleDownloader = new BundleDownloader(this.mClient);
    public InspectorPackagerConnection.BundleStatusProvider mBundlerStatusProvider;
    private final OkHttpClient mClient;
    public InspectorPackagerConnection mInspectorPackagerConnection;
    private OkHttpClient mOnChangePollingClient;
    public boolean mOnChangePollingEnabled;
    public OnServerContentChangeListener mOnServerContentChangeListener;
    public final String mPackageName;
    public JSPackagerClient mPackagerClient;
    public final Handler mRestartOnChangePollingHandler = new Handler(Looper.getMainLooper());
    public final DevInternalSettings mSettings;

    public interface OnServerContentChangeListener {
        void onServerContentChanged();
    }

    public interface PackagerCommandListener {
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    public interface PackagerCustomCommandProvider {
    }

    public interface SymbolicationListener {
        void onSymbolicationComplete(Iterable<StackFrame> iterable);
    }

    enum BundleType {
        BUNDLE("bundle"),
        DELTA("delta"),
        MAP("map");
        
        private final String mTypeID;

        private BundleType(String str) {
            this.mTypeID = str;
        }

        public final String typeID() {
            return this.mTypeID;
        }
    }

    public DevServerHelper(DevInternalSettings devInternalSettings, String str, InspectorPackagerConnection.BundleStatusProvider bundleStatusProvider) {
        this.mSettings = devInternalSettings;
        this.mBundlerStatusProvider = bundleStatusProvider;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.mClient = builder.connectTimeout(5000, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).build();
        this.mPackageName = str;
    }

    public void openPackagerConnection(final String str, final PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.w("ReactNative", "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("reload", new NotificationOnlyHandler() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass1 */

                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerReloadCommand();
                        }
                    });
                    hashMap.put("devMenu", new NotificationOnlyHandler() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass2 */

                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerDevMenuCommand();
                        }
                    });
                    hashMap.put("captureHeap", new RequestOnlyHandler() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass3 */

                        public void onRequest(Object obj, Responder responder) {
                            packagerCommandListener.onCaptureHeapCommand(responder);
                        }
                    });
                    Map<String, RequestHandler> customCommandHandlers = packagerCommandListener.customCommandHandlers();
                    if (customCommandHandlers != null) {
                        hashMap.putAll(customCommandHandlers);
                    }
                    hashMap.putAll(new FileIoHandler().handlers());
                    AnonymousClass4 r0 = new ReconnectingWebSocket.ConnectionCallback() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass4 */

                        public void onConnected() {
                            packagerCommandListener.onPackagerConnected();
                        }

                        public void onDisconnected() {
                            packagerCommandListener.onPackagerDisconnected();
                        }
                    };
                    DevServerHelper devServerHelper = DevServerHelper.this;
                    devServerHelper.mPackagerClient = new JSPackagerClient(str, devServerHelper.mSettings.getPackagerConnectionSettings(), hashMap, r0);
                    DevServerHelper.this.mPackagerClient.init();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void closePackagerConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mPackagerClient != null) {
                    DevServerHelper.this.mPackagerClient.close();
                    DevServerHelper.this.mPackagerClient = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.w("ReactNative", "Inspector connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass3 */

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    DevServerHelper devServerHelper = DevServerHelper.this;
                    devServerHelper.mInspectorPackagerConnection = new InspectorPackagerConnection(devServerHelper.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider);
                    DevServerHelper.this.mInspectorPackagerConnection.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void disableDebugger() {
        InspectorPackagerConnection inspectorPackagerConnection = this.mInspectorPackagerConnection;
        if (inspectorPackagerConnection != null) {
            inspectorPackagerConnection.sendEventToAllConnections("{ \"id\":1,\"method\":\"Debugger.disable\" }");
        }
    }

    public void closeInspectorConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                    DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                    DevServerHelper.this.mInspectorPackagerConnection = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void attachDebugger(final Context context, final String str) {
        new AsyncTask<Void, String, Boolean>() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(doSync());
            }

            public boolean doSync() {
                try {
                    new OkHttpClient().newCall(new Request.Builder().url(DevServerHelper.this.getInspectorAttachUrl(context, str)).build()).execute();
                    return true;
                } catch (IOException e) {
                    FLog.e("ReactNative", "Failed to send attach request to Inspector", e);
                    return false;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean bool) {
                if (!bool.booleanValue()) {
                    Toast.makeText(context, context.getString(R.string.catalyst_debug_nuclide_error), 1).show();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void symbolicateStackTrace(Iterable<StackFrame> iterable, final SymbolicationListener symbolicationListener) {
        try {
            String createSymbolicateURL = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
            JSONArray jSONArray = new JSONArray();
            for (StackFrame json : iterable) {
                jSONArray.put(json.toJSON());
            }
            ((Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createSymbolicateURL).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("stack", jSONArray).toString())).build()))).enqueue(new Callback() {
                /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass6 */

                public void onFailure(Call call, IOException iOException) {
                    FLog.w("ReactNative", "Got IOException when attempting symbolicate stack trace: " + iOException.getMessage());
                    symbolicationListener.onSymbolicationComplete(null);
                }

                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        symbolicationListener.onSymbolicationComplete(Arrays.asList(StackTraceHelper.convertJsStackTrace(new JSONObject(response.body().string()).getJSONArray("stack"))));
                    } catch (JSONException unused) {
                        symbolicationListener.onSymbolicationComplete(null);
                    }
                }
            });
        } catch (JSONException e) {
            FLog.w("ReactNative", "Got JSONException when attempting symbolicate stack trace: " + e.getMessage());
        }
    }

    public void openStackFrameCall(StackFrame stackFrame) {
        ((Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).post(RequestBody.create(MediaType.parse("application/json"), stackFrame.toJSON().toString())).build()))).enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass7 */

            public void onResponse(Call call, Response response) throws IOException {
            }

            public void onFailure(Call call, IOException iOException) {
                FLog.w("ReactNative", "Got IOException when attempting to open stack frame: " + iOException.getMessage());
            }
        });
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s", this.mSettings.getPackagerConnectionSettings().getInspectorServerHost(), AndroidInfoHelpers.getFriendlyDeviceName(), this.mPackageName);
    }

    public String getInspectorAttachUrl(Context context, String str) {
        return String.format(Locale.US, "http://%s/nuclide/attach-debugger-nuclide?title=%s&app=%s&device=%s", AndroidInfoHelpers.getServerHost(context), str, this.mPackageName, AndroidInfoHelpers.getFriendlyDeviceName());
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, getDeltaClientType());
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo, Request.Builder builder) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, getDeltaClientType(), builder);
    }

    private BundleDeltaClient.ClientType getDeltaClientType() {
        if (this.mSettings.isBundleDeltasCppEnabled()) {
            return BundleDeltaClient.ClientType.NATIVE;
        }
        if (this.mSettings.isBundleDeltasEnabled()) {
            return BundleDeltaClient.ClientType.DEV_SUPPORT;
        }
        return BundleDeltaClient.ClientType.NONE;
    }

    private String getHostForJSProxy() {
        String str = (String) Assertions.assertNotNull(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf < 0) {
            return "localhost";
        }
        return "localhost" + str.substring(lastIndexOf);
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        return String.format(Locale.US, "http://%s/%s.%s?platform=android&dev=%s&minify=%s", str2, str, bundleType.typeID(), Boolean.valueOf(getDevMode()), Boolean.valueOf(getJSMinifyMode()));
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    private static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", str, str2);
    }

    private static String createSymbolicateURL(String str) {
        return String.format(Locale.US, "http://%s/symbolicate", str);
    }

    private static String createOpenStackFrameURL(String str) {
        return String.format(Locale.US, "http://%s/open-stack-frame", str);
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, this.mSettings.isBundleDeltasEnabled() ? BundleType.DELTA : BundleType.BUNDLE, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        this.mClient.newCall(new Request.Builder().url(createPackagerStatusURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).build()).enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass8 */

            public void onFailure(Call call, IOException iOException) {
                FLog.w("ReactNative", "The packager does not seem to be running as we got an IOException requesting its status: " + iOException.getMessage());
                packagerStatusCallback.onPackagerStatusFetched(false);
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    FLog.e("ReactNative", "Got non-success http code from packager when requesting status: " + response.code());
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    FLog.e("ReactNative", "Got null body response from packager when requesting status");
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                String string = body.string();
                if (!"packager-status:running".equals(string)) {
                    FLog.e("ReactNative", "Got unexpected response from packager when requesting status: ".concat(String.valueOf(string)));
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                packagerStatusCallback.onPackagerStatusFetched(true);
            }
        });
    }

    private static String createPackagerStatusURL(String str) {
        return String.format(Locale.US, "http://%s/status", str);
    }

    public void stopPollingOnChangeEndpoint() {
        this.mOnChangePollingEnabled = false;
        this.mRestartOnChangePollingHandler.removeCallbacksAndMessages(null);
        OkHttpClient okHttpClient = this.mOnChangePollingClient;
        if (okHttpClient != null) {
            OkHttpCallUtil.cancelTag(okHttpClient, this);
            this.mOnChangePollingClient = null;
        }
        this.mOnServerContentChangeListener = null;
    }

    public void startPollingOnChangeEndpoint(OnServerContentChangeListener onServerContentChangeListener) {
        if (!this.mOnChangePollingEnabled) {
            this.mOnChangePollingEnabled = true;
            this.mOnServerContentChangeListener = onServerContentChangeListener;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            fkb.O000000o(builder);
            this.mOnChangePollingClient = builder.connectionPool(new ConnectionPool(1, 120000, TimeUnit.MILLISECONDS)).connectTimeout(5000, TimeUnit.MILLISECONDS).build();
            enqueueOnChangeEndpointLongPolling();
        }
    }

    public void handleOnChangePollingResponse(boolean z) {
        if (this.mOnChangePollingEnabled) {
            if (z) {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass9 */

                    public void run() {
                        if (DevServerHelper.this.mOnServerContentChangeListener != null) {
                            DevServerHelper.this.mOnServerContentChangeListener.onServerContentChanged();
                        }
                    }
                });
            }
            enqueueOnChangeEndpointLongPolling();
        }
    }

    private void enqueueOnChangeEndpointLongPolling() {
        ((OkHttpClient) Assertions.assertNotNull(this.mOnChangePollingClient)).newCall(new Request.Builder().url(createOnChangeEndpointUrl()).tag(this).build()).enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass10 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.facebook.common.logging.FLog.d(java.lang.String, java.lang.String, java.lang.Throwable):void
             arg types: [java.lang.String, java.lang.String, java.io.IOException]
             candidates:
              com.facebook.common.logging.FLog.d(java.lang.Class<?>, java.lang.String, java.lang.Object):void
              com.facebook.common.logging.FLog.d(java.lang.Class<?>, java.lang.String, java.lang.Throwable):void
              com.facebook.common.logging.FLog.d(java.lang.Class<?>, java.lang.String, java.lang.Object[]):void
              com.facebook.common.logging.FLog.d(java.lang.String, java.lang.String, java.lang.Object):void
              com.facebook.common.logging.FLog.d(java.lang.String, java.lang.String, java.lang.Object[]):void
              com.facebook.common.logging.FLog.d(java.lang.String, java.lang.String, java.lang.Throwable):void */
            public void onFailure(Call call, IOException iOException) {
                if (DevServerHelper.this.mOnChangePollingEnabled) {
                    FLog.d("ReactNative", "Error while requesting /onchange endpoint", (Throwable) iOException);
                    DevServerHelper.this.mRestartOnChangePollingHandler.postDelayed(new Runnable() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass10.AnonymousClass1 */

                        public void run() {
                            DevServerHelper.this.handleOnChangePollingResponse(false);
                        }
                    }, 5000);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                DevServerHelper.this.handleOnChangePollingResponse(response.code() == 205);
            }
        });
    }

    private String createOnChangeEndpointUrl() {
        return String.format(Locale.US, "http://%s/onchange", this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public void launchJSDevtools() {
        this.mClient.newCall(new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build()).enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass11 */

            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, this.mSettings.isBundleDeltasEnabled() ? BundleType.DELTA : BundleType.BUNDLE);
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
        r4 = r3;
        r3 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[SYNTHETIC, Splitter:B:25:0x0056] */
    public File downloadBundleResourceFromUrlSync(String str, File file) {
        Throwable th;
        Throwable th2;
        jbm jbm;
        try {
            Response execute = this.mClient.newCall(new Request.Builder().url(createResourceURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost(), str)).build()).execute();
            if (!execute.isSuccessful()) {
                if (execute != null) {
                    execute.close();
                }
                return null;
            }
            try {
                jbm = jbg.O00000Oo(file);
                try {
                    jbg.O000000o(execute.body().source()).O000000o(jbm);
                    if (jbm != null) {
                        jbm.close();
                    }
                    if (execute != null) {
                        execute.close();
                    }
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                    if (jbm != null) {
                        jbm.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                jbm = null;
                if (jbm != null) {
                }
                throw th;
            }
            if (execute != null) {
                if (th != null) {
                    try {
                        execute.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    execute.close();
                }
            }
            throw th2;
            throw th2;
        } catch (Exception e) {
            FLog.e("ReactNative", "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\"", str, file.getAbsolutePath(), e);
            return null;
        }
    }
}
