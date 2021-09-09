package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.util.Pair;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.DevServerHelper;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DevSupportManagerImpl implements DevInternalSettings.Listener, DevServerHelper.PackagerCommandListener, DevSupportManager {
    public final Context mApplicationContext;
    public DevBundleDownloadListener mBundleDownloadListener;
    public InspectorPackagerConnection.BundleStatus mBundleStatus;
    public ReactContext mCurrentContext;
    private final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions;
    private Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    private DebugOverlayController mDebugOverlayController;
    private final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler;
    public final DevLoadingViewController mDevLoadingViewController;
    public boolean mDevLoadingViewVisible;
    public AlertDialog mDevOptionsDialog;
    public final DevServerHelper mDevServerHelper;
    public DevInternalSettings mDevSettings;
    private List<ErrorCustomizer> mErrorCustomizers;
    private final List<ExceptionLogger> mExceptionLoggers;
    private boolean mIsDevSupportEnabled;
    private boolean mIsReceiverRegistered;
    private boolean mIsSamplingProfilerEnabled;
    private boolean mIsShakeDetectorStarted;
    private final String mJSAppBundleName;
    private final File mJSBundleTempFile;
    public int mLastErrorCookie;
    private StackFrame[] mLastErrorStack;
    private String mLastErrorTitle;
    private ErrorType mLastErrorType;
    public final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;
    public RedBoxDialog mRedBoxDialog;
    public RedBoxHandler mRedBoxHandler;
    private final BroadcastReceiver mReloadAppBroadcastReceiver;
    private final ShakeDetector mShakeDetector;

    enum ErrorType {
        JS,
        NATIVE
    }

    interface ExceptionLogger {
        void log(Exception exc);
    }

    public void onPackagerConnected() {
    }

    public void onPackagerDisconnected() {
    }

    public DevSupportManagerImpl(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, int i) {
        this(context, reactInstanceManagerDevHelper, str, z, null, null, i, null);
    }

    public DevSupportManagerImpl(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map) {
        this.mIsSamplingProfilerEnabled = false;
        this.mExceptionLoggers = new ArrayList();
        this.mCustomDevOptions = new LinkedHashMap<>();
        this.mDevLoadingViewVisible = false;
        this.mIsReceiverRegistered = false;
        this.mIsShakeDetectorStarted = false;
        this.mIsDevSupportEnabled = false;
        this.mLastErrorCookie = 0;
        this.mReactInstanceManagerHelper = reactInstanceManagerDevHelper;
        this.mApplicationContext = context;
        this.mJSAppBundleName = str;
        this.mDevSettings = new DevInternalSettings(context, this);
        this.mBundleStatus = new InspectorPackagerConnection.BundleStatus();
        this.mDevServerHelper = new DevServerHelper(this.mDevSettings, this.mApplicationContext.getPackageName(), new InspectorPackagerConnection.BundleStatusProvider() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass1 */

            public InspectorPackagerConnection.BundleStatus getBundleStatus() {
                return DevSupportManagerImpl.this.mBundleStatus;
            }
        });
        this.mBundleDownloadListener = devBundleDownloadListener;
        this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass2 */

            public void onShake() {
                DevSupportManagerImpl.this.showDevOptionsDialog();
            }
        }, i);
        this.mCustomPackagerCommandHandlers = map;
        this.mReloadAppBroadcastReceiver = new BroadcastReceiver() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass3 */

            public void onReceive(Context context, Intent intent) {
                if (DevSupportManagerImpl.getReloadAppAction(context).equals(intent.getAction())) {
                    if (intent.getBooleanExtra("jsproxy", false)) {
                        DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(true);
                        DevSupportManagerImpl.this.mDevServerHelper.launchJSDevtools();
                    } else {
                        DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(false);
                    }
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            }
        };
        this.mJSBundleTempFile = new File(context.getFilesDir(), "ReactNativeDevBundle.js");
        this.mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();
        setDevSupportEnabled(z);
        this.mRedBoxHandler = redBoxHandler;
        this.mDevLoadingViewController = new DevLoadingViewController(context, reactInstanceManagerDevHelper);
        this.mExceptionLoggers.add(new JSExceptionLogger());
        if (!this.mDevSettings.isStartSamplingProfilerOnInit()) {
            return;
        }
        if (!this.mIsSamplingProfilerEnabled) {
            toggleJSSamplingProfiler();
        } else {
            Toast.makeText(this.mApplicationContext, "JS Sampling Profiler was already running, so did not start the sampling profiler", 1).show();
        }
    }

    public void handleException(Exception exc) {
        if (this.mIsDevSupportEnabled) {
            for (ExceptionLogger log : this.mExceptionLoggers) {
                log.log(exc);
            }
            return;
        }
        this.mDefaultNativeModuleCallExceptionHandler.handleException(exc);
    }

    class JSExceptionLogger implements ExceptionLogger {
        private JSExceptionLogger() {
        }

        public void log(Exception exc) {
            StringBuilder sb = new StringBuilder(exc.getMessage() == null ? "Exception in native call from JS" : exc.getMessage());
            for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                sb.append("\n\n");
                sb.append(cause.getMessage());
            }
            if (exc instanceof JSException) {
                FLog.e("ReactNative", "Exception in native call from JS", exc);
                String stack = ((JSException) exc).getStack();
                sb.append("\n\n");
                sb.append(stack);
                DevSupportManagerImpl.this.showNewError(sb.toString(), new StackFrame[0], -1, ErrorType.JS);
                return;
            }
            DevSupportManagerImpl.this.showNewJavaError(sb.toString(), exc);
        }
    }

    public void showNewJavaError(String str, Throwable th) {
        FLog.e("ReactNative", "Exception in native call", th);
        showNewError(str, StackTraceHelper.convertJavaStackTrace(th), -1, ErrorType.NATIVE);
    }

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
        this.mCustomDevOptions.put(str, devOptionHandler);
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
        showNewError(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
    }

    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
        if (this.mErrorCustomizers == null) {
            this.mErrorCustomizers = new ArrayList();
        }
        this.mErrorCustomizers.add(errorCustomizer);
    }

    public Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        List<ErrorCustomizer> list = this.mErrorCustomizers;
        if (list == null) {
            return pair;
        }
        for (ErrorCustomizer customizeErrorInfo : list) {
            Pair<String, StackFrame[]> customizeErrorInfo2 = customizeErrorInfo.customizeErrorInfo(pair);
            if (customizeErrorInfo2 != null) {
                pair = customizeErrorInfo2;
            }
        }
        return pair;
    }

    public void updateJSError(final String str, final ReadableArray readableArray, final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass4 */

            public void run() {
                if (DevSupportManagerImpl.this.mRedBoxDialog != null && DevSupportManagerImpl.this.mRedBoxDialog.isShowing() && i == DevSupportManagerImpl.this.mLastErrorCookie) {
                    StackFrame[] convertJsStackTrace = StackTraceHelper.convertJsStackTrace(readableArray);
                    Pair<String, StackFrame[]> processErrorCustomizers = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(str, convertJsStackTrace));
                    DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String) processErrorCustomizers.first, (StackFrame[]) processErrorCustomizers.second);
                    DevSupportManagerImpl.this.updateLastErrorInfo(str, convertJsStackTrace, i, ErrorType.JS);
                    if (DevSupportManagerImpl.this.mRedBoxHandler != null) {
                        DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(str, convertJsStackTrace, RedBoxHandler.ErrorType.JS);
                        DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
                    }
                    DevSupportManagerImpl.this.mRedBoxDialog.show();
                }
            }
        });
    }

    public void hideRedboxDialog() {
        RedBoxDialog redBoxDialog = this.mRedBoxDialog;
        if (redBoxDialog != null) {
            redBoxDialog.dismiss();
            this.mRedBoxDialog = null;
        }
    }

    private void hideDevOptionsDialog() {
        AlertDialog alertDialog = this.mDevOptionsDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mDevOptionsDialog = null;
        }
    }

    public void showNewError(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        final String str2 = str;
        final StackFrame[] stackFrameArr2 = stackFrameArr;
        final int i2 = i;
        final ErrorType errorType2 = errorType;
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass5 */

            public void run() {
                if (DevSupportManagerImpl.this.mRedBoxDialog == null) {
                    Activity currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        FLog.e("ReactNative", "Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: " + str2);
                        return;
                    }
                    DevSupportManagerImpl devSupportManagerImpl = DevSupportManagerImpl.this;
                    devSupportManagerImpl.mRedBoxDialog = new RedBoxDialog(currentActivity, devSupportManagerImpl, devSupportManagerImpl.mRedBoxHandler);
                }
                if (!DevSupportManagerImpl.this.mRedBoxDialog.isShowing()) {
                    Pair<String, StackFrame[]> processErrorCustomizers = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(str2, stackFrameArr2));
                    DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String) processErrorCustomizers.first, (StackFrame[]) processErrorCustomizers.second);
                    DevSupportManagerImpl.this.updateLastErrorInfo(str2, stackFrameArr2, i2, errorType2);
                    if (DevSupportManagerImpl.this.mRedBoxHandler != null && errorType2 == ErrorType.NATIVE) {
                        DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(str2, stackFrameArr2, RedBoxHandler.ErrorType.NATIVE);
                    }
                    DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
                    DevSupportManagerImpl.this.mRedBoxDialog.show();
                }
            }
        });
    }

    public void showDevOptionsDialog() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.mDevOptionsDialog == null && this.mIsDevSupportEnabled && !ActivityManager.isUserAMonkey()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_reload), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass6 */

                public void onOptionSelected() {
                    if (!DevSupportManagerImpl.this.mDevSettings.isJSDevModeEnabled() && DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled()) {
                        Toast.makeText(DevSupportManagerImpl.this.mApplicationContext, DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_hot_reloading_auto_disable), 1).show();
                        DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(false);
                    }
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
            if (this.mDevSettings.isNuclideJSDebugEnabled()) {
                if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                    str = this.mApplicationContext.getString(R.string.catalyst_debug_chrome_stop);
                } else {
                    str = this.mApplicationContext.getString(R.string.catalyst_debug_chrome);
                }
            } else if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                str = this.mApplicationContext.getString(R.string.catalyst_debug_stop);
            } else {
                str = this.mApplicationContext.getString(R.string.catalyst_debug);
            }
            linkedHashMap.put(str, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass7 */

                public void onOptionSelected() {
                    DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(!DevSupportManagerImpl.this.mDevSettings.isRemoteJSDebugEnabled());
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
            if (this.mDevSettings.isNuclideJSDebugEnabled()) {
                linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_debug_nuclide), new DevOptionHandler() {
                    /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass8 */

                    public void onOptionSelected() {
                        DevSupportManagerImpl.this.mDevServerHelper.attachDebugger(DevSupportManagerImpl.this.mApplicationContext, "ReactNative");
                    }
                });
            }
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_change_bundle_location), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass9 */

                public void onOptionSelected() {
                    Activity currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        FLog.e("ReactNative", "Unable to launch change bundle location because react activity is not available");
                        return;
                    }
                    final EditText editText = new EditText(currentActivity);
                    editText.setHint("localhost:8081");
                    new AlertDialog.Builder(currentActivity).setTitle(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                        /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass9.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            DevSupportManagerImpl.this.mDevSettings.getPackagerConnectionSettings().setDebugServerHost(editText.getText().toString());
                            DevSupportManagerImpl.this.handleReloadJS();
                        }
                    }).create().show();
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_inspector), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass10 */

                public void onOptionSelected() {
                    DevSupportManagerImpl.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerImpl.this.mReactInstanceManagerHelper.toggleElementInspector();
                }
            });
            if (this.mDevSettings.isHotModuleReplacementEnabled()) {
                str2 = this.mApplicationContext.getString(R.string.catalyst_hot_reloading_stop);
            } else {
                str2 = this.mApplicationContext.getString(R.string.catalyst_hot_reloading);
            }
            linkedHashMap.put(str2, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass11 */

                public void onOptionSelected() {
                    boolean z = !DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled();
                    DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    if (DevSupportManagerImpl.this.mCurrentContext != null) {
                        if (z) {
                            ((HMRClient) DevSupportManagerImpl.this.mCurrentContext.getJSModule(HMRClient.class)).enable();
                        } else {
                            ((HMRClient) DevSupportManagerImpl.this.mCurrentContext.getJSModule(HMRClient.class)).disable();
                        }
                    }
                    if (z && !DevSupportManagerImpl.this.mDevSettings.isJSDevModeEnabled()) {
                        Toast.makeText(DevSupportManagerImpl.this.mApplicationContext, DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_hot_reloading_auto_enable), 1).show();
                        DevSupportManagerImpl.this.mDevSettings.setJSDevModeEnabled(true);
                        DevSupportManagerImpl.this.handleReloadJS();
                    }
                }
            });
            if (this.mIsSamplingProfilerEnabled) {
                str3 = this.mApplicationContext.getString(R.string.catalyst_sample_profiler_disable);
            } else {
                str3 = this.mApplicationContext.getString(R.string.catalyst_sample_profiler_enable);
            }
            linkedHashMap.put(str3, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass12 */

                public void onOptionSelected() {
                    DevSupportManagerImpl.this.toggleJSSamplingProfiler();
                }
            });
            if (this.mDevSettings.isFpsDebugEnabled()) {
                str4 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor_stop);
            } else {
                str4 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor);
            }
            linkedHashMap.put(str4, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass13 */

                public void onOptionSelected() {
                    if (!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled()) {
                        Activity currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                        if (currentActivity == null) {
                            FLog.e("ReactNative", "Unable to get reference to react activity");
                        } else {
                            DebugOverlayController.requestPermission(currentActivity);
                        }
                    }
                    DevSupportManagerImpl.this.mDevSettings.setFpsDebugEnabled(!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled());
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_settings), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass14 */

                public void onOptionSelected() {
                    Intent intent = new Intent(DevSupportManagerImpl.this.mApplicationContext, DevSettingsActivity.class);
                    intent.setFlags(268435456);
                    DevSupportManagerImpl.this.mApplicationContext.startActivity(intent);
                }
            });
            if (this.mCustomDevOptions.size() > 0) {
                linkedHashMap.putAll(this.mCustomDevOptions);
            }
            final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
            Activity currentActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                FLog.e("ReactNative", "Unable to launch dev options menu because react activity isn't available");
                return;
            }
            this.mDevOptionsDialog = new AlertDialog.Builder(currentActivity).setItems((CharSequence[]) linkedHashMap.keySet().toArray(new String[0]), new DialogInterface.OnClickListener() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass16 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    devOptionHandlerArr[i].onOptionSelected();
                    DevSupportManagerImpl.this.mDevOptionsDialog = null;
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass15 */

                public void onCancel(DialogInterface dialogInterface) {
                    DevSupportManagerImpl.this.mDevOptionsDialog = null;
                }
            }).create();
            this.mDevOptionsDialog.show();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r6.mIsSamplingProfilerEnabled = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r1 = r6.mApplicationContext;
        android.widget.Toast.makeText(r1, r0.toString() + " does not support Sampling Profiler", 1).show();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0070 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
    public void toggleJSSamplingProfiler() {
        JavaScriptExecutorFactory javaScriptExecutorFactory;
        javaScriptExecutorFactory = this.mReactInstanceManagerHelper.getJavaScriptExecutorFactory();
        if (!this.mIsSamplingProfilerEnabled) {
            javaScriptExecutorFactory.startSamplingProfiler();
            Toast.makeText(this.mApplicationContext, "Starting Sampling Profiler", 0).show();
            this.mIsSamplingProfilerEnabled = true;
            return;
        }
        try {
            String path = File.createTempFile("sampling-profiler-trace", ".cpuprofile", this.mApplicationContext.getCacheDir()).getPath();
            javaScriptExecutorFactory.stopSamplingProfiler(path);
            Toast.makeText(this.mApplicationContext, "Saved results from Profiler to ".concat(String.valueOf(path)), 1).show();
            this.mIsSamplingProfilerEnabled = false;
        } catch (IOException unused) {
            FLog.e("ReactNative", "Could not create temporary file for saving results from Sampling Profiler");
            this.mIsSamplingProfilerEnabled = false;
        } catch (UnsupportedOperationException ) {
            Context context = this.mApplicationContext;
            Toast.makeText(context, javaScriptExecutorFactory.toString() + "does not support Sampling Profiler", 1).show();
            this.mIsSamplingProfilerEnabled = false;
        } catch (Throwable th) {
            this.mIsSamplingProfilerEnabled = false;
            throw th;
        }
    }

    public void setDevSupportEnabled(boolean z) {
        this.mIsDevSupportEnabled = z;
        reloadSettings();
    }

    public boolean getDevSupportEnabled() {
        return this.mIsDevSupportEnabled;
    }

    public DeveloperSettings getDevSettings() {
        return this.mDevSettings;
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
        resetCurrentContext(reactContext);
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
        if (reactContext == this.mCurrentContext) {
            resetCurrentContext(null);
        }
    }

    public String getSourceMapUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceMapUrl((String) Assertions.assertNotNull(str));
    }

    public String getSourceUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceUrl((String) Assertions.assertNotNull(str));
    }

    public String getJSBundleURLForRemoteDebugging() {
        return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    public String getDownloadedJSBundleFile() {
        return this.mJSBundleTempFile.getAbsolutePath();
    }

    public boolean hasUpToDateJSBundleInCache() {
        if (this.mIsDevSupportEnabled && this.mJSBundleTempFile.exists()) {
            try {
                String packageName = this.mApplicationContext.getPackageName();
                if (this.mJSBundleTempFile.lastModified() > this.mApplicationContext.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                    File file = new File(String.format(Locale.US, "/data/local/tmp/exopackage/%s//secondary-dex", packageName));
                    if (!file.exists() || this.mJSBundleTempFile.lastModified() > file.lastModified()) {
                        return true;
                    }
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                FLog.e("ReactNative", "DevSupport is unable to get current app info");
            }
        }
        return false;
    }

    public boolean hasBundleInAssets(String str) {
        try {
            String[] list = this.mApplicationContext.getAssets().list("");
            for (String equals : list) {
                if (equals.equals(str)) {
                    return true;
                }
            }
        } catch (IOException unused) {
            FLog.e("ReactNative", "Error while loading assets list");
        }
        return false;
    }

    private void resetCurrentContext(ReactContext reactContext) {
        if (this.mCurrentContext != reactContext) {
            this.mCurrentContext = reactContext;
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(false);
            }
            if (reactContext != null) {
                this.mDebugOverlayController = new DebugOverlayController(reactContext);
            }
            if (this.mCurrentContext != null) {
                try {
                    URL url = new URL(getSourceUrl());
                    ((HMRClient) this.mCurrentContext.getJSModule(HMRClient.class)).setup("android", url.getPath().substring(1), url.getHost(), url.getPort(), this.mDevSettings.isHotModuleReplacementEnabled());
                } catch (MalformedURLException e) {
                    showNewJavaError(e.getMessage(), e);
                }
            }
            reloadSettings();
        }
    }

    public void reloadSettings() {
        if (UiThreadUtil.isOnUiThread()) {
            reload();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass17 */

                public void run() {
                    DevSupportManagerImpl.this.reload();
                }
            });
        }
    }

    public void onInternalSettingsChanged() {
        reloadSettings();
    }

    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.RELOAD, this.mDevSettings.getPackagerConnectionSettings().getDebugServerHost());
        hideRedboxDialog();
        if (this.mDevSettings.isRemoteJSDebugEnabled()) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
            this.mDevLoadingViewController.showForRemoteJSEnabled();
            this.mDevLoadingViewVisible = true;
            reloadJSInProxyMode();
            return;
        }
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
        reloadJSFromServer(this.mDevServerHelper.getDevServerBundleURL((String) Assertions.assertNotNull(this.mJSAppBundleName)));
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        this.mDevServerHelper.isPackagerRunning(packagerStatusCallback);
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return this.mDevServerHelper.downloadBundleResourceFromUrlSync(str, file);
    }

    public String getLastErrorTitle() {
        return this.mLastErrorTitle;
    }

    public StackFrame[] getLastErrorStack() {
        return this.mLastErrorStack;
    }

    public void onPackagerReloadCommand() {
        this.mDevServerHelper.disableDebugger();
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass18 */

            public void run() {
                DevSupportManagerImpl.this.handleReloadJS();
            }
        });
    }

    public void onPackagerDevMenuCommand() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass19 */

            public void run() {
                DevSupportManagerImpl.this.showDevOptionsDialog();
            }
        });
    }

    public void onCaptureHeapCommand(final Responder responder) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass20 */

            public void run() {
                DevSupportManagerImpl.this.handleCaptureHeap(responder);
            }
        });
    }

    public Map<String, RequestHandler> customCommandHandlers() {
        return this.mCustomPackagerCommandHandlers;
    }

    public void handleCaptureHeap(final Responder responder) {
        ReactContext reactContext = this.mCurrentContext;
        if (reactContext != null) {
            ((JSCHeapCapture) reactContext.getNativeModule(JSCHeapCapture.class)).captureHeap(this.mApplicationContext.getCacheDir().getPath(), new JSCHeapCapture.CaptureCallback() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass21 */

                public void onSuccess(File file) {
                    responder.respond(file.toString());
                }

                public void onFailure(JSCHeapCapture.CaptureException captureException) {
                    responder.error(captureException.toString());
                }
            });
        }
    }

    public void updateLastErrorInfo(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        this.mLastErrorTitle = str;
        this.mLastErrorStack = stackFrameArr;
        this.mLastErrorCookie = i;
        this.mLastErrorType = errorType;
    }

    private void reloadJSInProxyMode() {
        this.mDevServerHelper.launchJSDevtools();
        this.mReactInstanceManagerHelper.onReloadWithJSDebugger(new JavaJSExecutor.Factory() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass22 */

            public JavaJSExecutor create() throws Exception {
                WebsocketJavaScriptExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                websocketJavaScriptExecutor.connect(DevSupportManagerImpl.this.mDevServerHelper.getWebsocketProxyURL(), DevSupportManagerImpl.this.getExecutorConnectCallback(simpleSettableFuture));
                try {
                    simpleSettableFuture.get(90, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (ExecutionException e) {
                    throw ((Exception) e.getCause());
                } catch (InterruptedException | TimeoutException e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    public WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> simpleSettableFuture) {
        return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass23 */

            public void onSuccess() {
                simpleSettableFuture.set(Boolean.TRUE);
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
            }

            public void onFailure(Throwable th) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                FLog.e("ReactNative", "Failed to connect to debugger!", th);
                simpleSettableFuture.setException(new IOException(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_debug_error), th));
            }
        };
    }

    public void reloadJSFromServer(String str) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        this.mDevLoadingViewController.showForUrl(str);
        this.mDevLoadingViewVisible = true;
        final BundleDownloader.BundleInfo bundleInfo = new BundleDownloader.BundleInfo();
        this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() {
            /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass24 */

            public void onSuccess(final NativeDeltaClient nativeDeltaClient) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl devSupportManagerImpl = DevSupportManagerImpl.this;
                devSupportManagerImpl.mDevLoadingViewVisible = false;
                synchronized (devSupportManagerImpl) {
                    DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = Boolean.TRUE;
                    DevSupportManagerImpl.this.mBundleStatus.updateTimestamp = System.currentTimeMillis();
                }
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onSuccess(nativeDeltaClient);
                }
                UiThreadUtil.runOnUiThread(new Runnable() {
                    /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass24.AnonymousClass1 */

                    public void run() {
                        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, bundleInfo.toJSONString());
                        DevSupportManagerImpl.this.mReactInstanceManagerHelper.onJSBundleLoadedFromServer(nativeDeltaClient);
                    }
                });
            }

            public void onProgress(String str, Integer num, Integer num2) {
                DevSupportManagerImpl.this.mDevLoadingViewController.updateProgress(str, num, num2);
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onProgress(str, num, num2);
                }
            }

            public void onFailure(final Exception exc) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl devSupportManagerImpl = DevSupportManagerImpl.this;
                devSupportManagerImpl.mDevLoadingViewVisible = false;
                synchronized (devSupportManagerImpl) {
                    DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = Boolean.FALSE;
                }
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onFailure(exc);
                }
                FLog.e("ReactNative", "Unable to download JS bundle", exc);
                UiThreadUtil.runOnUiThread(new Runnable() {
                    /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass24.AnonymousClass2 */

                    public void run() {
                        Exception exc = exc;
                        if (exc instanceof DebugServerException) {
                            DevSupportManagerImpl.this.showNewJavaError(((DebugServerException) exc).getMessage(), exc);
                        } else {
                            DevSupportManagerImpl.this.showNewJavaError(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_reload_error), exc);
                        }
                    }
                });
            }
        }, this.mJSBundleTempFile, str, bundleInfo);
    }

    public void startInspector() {
        if (this.mIsDevSupportEnabled) {
            this.mDevServerHelper.openInspectorConnection();
        }
    }

    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }

    public void setHotModuleReplacementEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass25 */

                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
        }
    }

    public void setRemoteJSDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass26 */

                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(z);
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
        }
    }

    public void setReloadOnJSChangeEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass27 */

                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setReloadOnJSChangeEnabled(z);
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
        }
    }

    public void setFpsDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass28 */

                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setFpsDebugEnabled(z);
                }
            });
        }
    }

    public void toggleElementInspector() {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass29 */

                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerImpl.this.mReactInstanceManagerHelper.toggleElementInspector();
                }
            });
        }
    }

    public void reload() {
        UiThreadUtil.assertOnUiThread();
        if (this.mIsDevSupportEnabled) {
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
            }
            if (!this.mIsShakeDetectorStarted) {
                this.mShakeDetector.start((SensorManager) this.mApplicationContext.getSystemService("sensor"));
                this.mIsShakeDetectorStarted = true;
            }
            if (!this.mIsReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(getReloadAppAction(this.mApplicationContext));
                this.mApplicationContext.registerReceiver(this.mReloadAppBroadcastReceiver, intentFilter);
                this.mIsReceiverRegistered = true;
            }
            if (this.mDevLoadingViewVisible) {
                this.mDevLoadingViewController.showMessage("Reloading...");
            }
            this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), this);
            if (this.mDevSettings.isReloadOnJSChangeEnabled()) {
                this.mDevServerHelper.startPollingOnChangeEndpoint(new DevServerHelper.OnServerContentChangeListener() {
                    /* class com.facebook.react.devsupport.DevSupportManagerImpl.AnonymousClass30 */

                    public void onServerContentChanged() {
                        DevSupportManagerImpl.this.handleReloadJS();
                    }
                });
            } else {
                this.mDevServerHelper.stopPollingOnChangeEndpoint();
            }
        } else {
            DebugOverlayController debugOverlayController2 = this.mDebugOverlayController;
            if (debugOverlayController2 != null) {
                debugOverlayController2.setFpsDebugViewVisible(false);
            }
            if (this.mIsShakeDetectorStarted) {
                this.mShakeDetector.stop();
                this.mIsShakeDetectorStarted = false;
            }
            if (this.mIsReceiverRegistered) {
                this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
                this.mIsReceiverRegistered = false;
            }
            hideRedboxDialog();
            hideDevOptionsDialog();
            this.mDevLoadingViewController.hide();
            this.mDevServerHelper.closePackagerConnection();
            this.mDevServerHelper.stopPollingOnChangeEndpoint();
        }
    }

    public static String getReloadAppAction(Context context) {
        return context.getPackageName() + ".RELOAD_APP_ACTION";
    }
}
