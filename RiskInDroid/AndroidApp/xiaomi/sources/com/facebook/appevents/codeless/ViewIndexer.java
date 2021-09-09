package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer {
    public static final String TAG = "com.facebook.appevents.codeless.ViewIndexer";
    private static ViewIndexer instance;
    public WeakReference<Activity> activityReference;
    public Timer indexingTimer;
    public String previousDigest = null;
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    public ViewIndexer(Activity activity) {
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    public void schedule() {
        final AnonymousClass1 r0 = new TimerTask() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass1 */

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007a */
            public void run() {
                String str;
                try {
                    Activity activity = ViewIndexer.this.activityReference.get();
                    if (activity != null) {
                        String simpleName = activity.getClass().getSimpleName();
                        View rootView = activity.getWindow().getDecorView().getRootView();
                        if (CodelessManager.getIsAppIndexingEnabled()) {
                            if (InternalSettings.isUnityApp()) {
                                UnityReflection.captureViewHierarchy();
                                return;
                            }
                            FutureTask futureTask = new FutureTask(new ScreenshotTaker(rootView));
                            ViewIndexer.this.uiThreadHandler.post(futureTask);
                            try {
                                str = (String) futureTask.get(1, TimeUnit.SECONDS);
                            } catch (Exception e) {
                                Log.e(ViewIndexer.TAG, "Failed to take screenshot.", e);
                                str = "";
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("screenname", simpleName);
                            jSONObject.put("screenshot", str);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                            jSONObject.put("view", jSONArray);
                            Log.e(ViewIndexer.TAG, "Failed to create JSONObject");
                            ViewIndexer.this.sendToServer(jSONObject.toString());
                        }
                    }
                } catch (Exception e2) {
                    Log.e(ViewIndexer.TAG, "UI Component tree indexing failure!", e2);
                }
            }
        };
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass2 */

            public void run() {
                try {
                    if (ViewIndexer.this.indexingTimer != null) {
                        ViewIndexer.this.indexingTimer.cancel();
                    }
                    ViewIndexer.this.previousDigest = null;
                    ViewIndexer.this.indexingTimer = new Timer();
                    ViewIndexer.this.indexingTimer.scheduleAtFixedRate(r0, 0, 1000);
                } catch (Exception e) {
                    Log.e(ViewIndexer.TAG, "Error scheduling indexing job", e);
                }
            }
        });
    }

    public void unschedule() {
        Timer timer;
        if (this.activityReference.get() != null && (timer = this.indexingTimer) != null) {
            try {
                timer.cancel();
                this.indexingTimer = null;
            } catch (Exception e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            }
        }
    }

    public static void sendToServerUnityInstance(String str) {
        ViewIndexer viewIndexer = instance;
        if (viewIndexer != null) {
            viewIndexer.sendToServerUnity(str);
        }
    }

    @Deprecated
    public void sendToServerUnity(String str) {
        instance.sendToServer(str);
    }

    public void sendToServer(final String str) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass3 */

            public void run() {
                GraphRequest buildAppIndexingRequest;
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if ((md5hash == null || !md5hash.equals(ViewIndexer.this.previousDigest)) && (buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), "app_indexing")) != null) {
                    GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            if ("true".equals(jSONObject.optString("success"))) {
                                Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                                ViewIndexer.this.previousDigest = md5hash;
                            }
                            if (jSONObject.has("is_app_indexing_enabled")) {
                                CodelessManager.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean("is_app_indexing_enabled")));
                                return;
                            }
                            return;
                        }
                        String str = ViewIndexer.TAG;
                        Log.e(str, "Error sending UI component tree to Facebook: " + executeAndWait.getError());
                    } catch (JSONException e) {
                        Log.e(ViewIndexer.TAG, "Error decoding server response.", e);
                    }
                }
            }
        });
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", str2), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("tree", str);
        parameters.putString("app_version", AppEventUtility.getAppVersion());
        parameters.putString("platform", "android");
        parameters.putString("request_type", str3);
        if (str3.equals("app_indexing")) {
            parameters.putString("device_session_id", CodelessManager.getCurrentDeviceSessionID());
        }
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new GraphRequest.Callback() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass4 */

            public final void onCompleted(GraphResponse graphResponse) {
                Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
            }
        });
        return newPostRequest;
    }

    static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        ScreenshotTaker(View view) {
            this.rootView = new WeakReference<>(view);
        }

        public String call() {
            View view = this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }
}
