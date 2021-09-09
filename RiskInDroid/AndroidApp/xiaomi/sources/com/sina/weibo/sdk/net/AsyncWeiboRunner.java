package com.sina.weibo.sdk.net;

import _m_j.dbt;
import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.exception.WeiboException;

public class AsyncWeiboRunner {
    public Context mContext;

    public AsyncWeiboRunner(Context context) {
        this.mContext = context;
    }

    @Deprecated
    public void requestByThread(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        final String str3 = str;
        final String str4 = str2;
        final WeiboParameters weiboParameters2 = weiboParameters;
        final RequestListener requestListener2 = requestListener;
        new Thread() {
            /* class com.sina.weibo.sdk.net.AsyncWeiboRunner.AnonymousClass1 */

            public void run() {
                try {
                    String openUrl = HttpManager.openUrl(AsyncWeiboRunner.this.mContext, str3, str4, weiboParameters2);
                    if (requestListener2 != null) {
                        requestListener2.onComplete(openUrl);
                    }
                } catch (WeiboException e) {
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }

    public void request4RdirectURL(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        final String str3 = str;
        final String str4 = str2;
        final WeiboParameters weiboParameters2 = weiboParameters;
        final RequestListener requestListener2 = requestListener;
        new Thread() {
            /* class com.sina.weibo.sdk.net.AsyncWeiboRunner.AnonymousClass2 */

            public void run() {
                try {
                    String openRedirectUrl4LocationUri = HttpManager.openRedirectUrl4LocationUri(AsyncWeiboRunner.this.mContext, str3, str4, weiboParameters2);
                    if (requestListener2 != null) {
                        requestListener2.onComplete(openRedirectUrl4LocationUri);
                    }
                } catch (WeiboException e) {
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }

    public String request(String str, WeiboParameters weiboParameters, String str2) throws WeiboException {
        addAction(this.mContext, weiboParameters.getAppKey());
        return HttpManager.openUrl(this.mContext, str, str2, weiboParameters);
    }

    public String request(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4) throws WeiboException {
        if (!z) {
            return request(str3, weiboParameters, str4);
        }
        weiboParameters.put("source", str);
        weiboParameters.setAnonymousCookie(str2);
        return request(str3, weiboParameters, str4);
    }

    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        addAction(this.mContext, weiboParameters.getAppKey());
        new RequestRunner(this.mContext, str, weiboParameters, str2, requestListener).execute(null);
    }

    public void requestAsync(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4, RequestListener requestListener) {
        if (z) {
            weiboParameters.put("source", str);
            weiboParameters.setAnonymousCookie(str2);
        }
        requestAsync(str3, weiboParameters, str4, requestListener);
    }

    private void addAction(Context context, String str) {
        try {
            Class.forName("com.sina.weibo.sdk.cmd.WbAppActivator").getMethod("getInstance", Context.class, String.class).invoke(null, context, str).getClass().getMethod("activateApp", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
        private final Context mContext;
        private final String mHttpMethod;
        private final RequestListener mListener;
        private final WeiboParameters mParams;
        private final String mUrl;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            onPostExecute((AsyncTaskResult<String>) ((AsyncTaskResult) obj));
        }

        public RequestRunner(Context context, String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
            this.mContext = context;
            this.mUrl = str;
            this.mParams = weiboParameters;
            this.mHttpMethod = str2;
            this.mListener = requestListener;
        }

        /* access modifiers changed from: protected */
        public AsyncTaskResult<String> doInBackground(Void... voidArr) {
            try {
                return new AsyncTaskResult<>(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
            } catch (WeiboException e) {
                dbt.O00000o0("ContentValues", e.getMessage());
                return new AsyncTaskResult<>(e);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(AsyncTaskResult<String> asyncTaskResult) {
            WeiboException error = asyncTaskResult.getError();
            if (error != null) {
                this.mListener.onWeiboException(error);
            } else {
                this.mListener.onComplete(asyncTaskResult.getResult());
            }
        }
    }

    static class AsyncTaskResult<T> {
        private WeiboException error;
        private T result;

        public T getResult() {
            return this.result;
        }

        public WeiboException getError() {
            return this.error;
        }

        public AsyncTaskResult(T t) {
            this.result = t;
        }

        public AsyncTaskResult(WeiboException weiboException) {
            this.error = weiboException;
        }
    }
}
