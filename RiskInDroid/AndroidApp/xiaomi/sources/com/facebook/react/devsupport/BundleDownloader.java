package com.facebook.react.devsupport;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbg;
import _m_j.jbm;
import android.util.Log;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.devsupport.BundleDeltaClient;
import com.facebook.react.devsupport.MultipartStreamReader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleDownloader {
    private BundleDeltaClient mBundleDeltaClient;
    private final OkHttpClient mClient;
    public Call mDownloadBundleFromURLCall;

    public static class BundleInfo {
        public String mDeltaClientName;
        public int mFilesChangedCount;
        public String mUrl;

        public static BundleInfo fromJSONString(String str) {
            if (str == null) {
                return null;
            }
            BundleInfo bundleInfo = new BundleInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundleInfo.mDeltaClientName = jSONObject.getString("deltaClient");
                bundleInfo.mUrl = jSONObject.getString("url");
                bundleInfo.mFilesChangedCount = jSONObject.getInt("filesChangedCount");
                return bundleInfo;
            } catch (JSONException e) {
                Log.e("BundleDownloader", "Invalid bundle info: ", e);
                return null;
            }
        }

        public String toJSONString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deltaClient", this.mDeltaClientName);
                jSONObject.put("url", this.mUrl);
                jSONObject.put("filesChangedCount", this.mFilesChangedCount);
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.e("BundleDownloader", "Can't serialize bundle info: ", e);
                return null;
            }
        }

        public String getDeltaClient() {
            return this.mDeltaClientName;
        }

        public String getUrl() {
            String str = this.mUrl;
            return str != null ? str : "unknown";
        }

        public int getFilesChangedCount() {
            return this.mFilesChangedCount;
        }
    }

    public BundleDownloader(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo, BundleDeltaClient.ClientType clientType) {
        downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, clientType, new Request.Builder());
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo, BundleDeltaClient.ClientType clientType, Request.Builder builder) {
        this.mDownloadBundleFromURLCall = (Call) Assertions.assertNotNull(this.mClient.newCall(builder.url(formatBundleUrl(str, clientType)).build()));
        final DevBundleDownloadListener devBundleDownloadListener2 = devBundleDownloadListener;
        final File file2 = file;
        final BundleInfo bundleInfo2 = bundleInfo;
        final BundleDeltaClient.ClientType clientType2 = clientType;
        this.mDownloadBundleFromURLCall.enqueue(new Callback() {
            /* class com.facebook.react.devsupport.BundleDownloader.AnonymousClass1 */

            public void onFailure(Call call, IOException iOException) {
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = call.request().url().toString();
                devBundleDownloadListener2.onFailure(DebugServerException.makeGeneric(httpUrl, "Could not connect to development server.", "URL: ".concat(String.valueOf(httpUrl)), iOException));
            }

            public void onResponse(Call call, Response response) throws IOException {
                Throwable th;
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = response.request().url().toString();
                Matcher matcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(response.header("content-type"));
                try {
                    if (matcher.find()) {
                        BundleDownloader.this.processMultipartResponse(httpUrl, response, matcher.group(1), file2, bundleInfo2, clientType2, devBundleDownloadListener2);
                    } else {
                        BundleDownloader.this.processBundleResult(httpUrl, response.code(), response.headers(), jbg.O000000o(response.body().source()), file2, bundleInfo2, clientType2, devBundleDownloadListener2);
                    }
                    if (response != null) {
                        response.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        });
    }

    private String formatBundleUrl(String str, BundleDeltaClient.ClientType clientType) {
        BundleDeltaClient bundleDeltaClient;
        return (!BundleDeltaClient.isDeltaUrl(str) || (bundleDeltaClient = this.mBundleDeltaClient) == null || !bundleDeltaClient.canHandle(clientType)) ? str : this.mBundleDeltaClient.extendUrlForDelta(str);
    }

    public void processMultipartResponse(String str, Response response, String str2, File file, BundleInfo bundleInfo, BundleDeltaClient.ClientType clientType, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        final Response response2 = response;
        final String str3 = str;
        final File file2 = file;
        final BundleInfo bundleInfo2 = bundleInfo;
        final BundleDeltaClient.ClientType clientType2 = clientType;
        final DevBundleDownloadListener devBundleDownloadListener2 = devBundleDownloadListener;
        if (!new MultipartStreamReader(response.body().source(), str2).readAllParts(new MultipartStreamReader.ChunkListener() {
            /* class com.facebook.react.devsupport.BundleDownloader.AnonymousClass2 */

            public void onChunkComplete(Map<String, String> map, jax jax, boolean z) throws IOException {
                if (z) {
                    int code = response2.code();
                    if (map.containsKey("X-Http-Status")) {
                        code = Integer.parseInt(map.get("X-Http-Status"));
                    }
                    BundleDownloader.this.processBundleResult(str3, code, Headers.of(map), jax, file2, bundleInfo2, clientType2, devBundleDownloadListener2);
                } else if (map.containsKey("Content-Type") && map.get("Content-Type").equals("application/json")) {
                    try {
                        JSONObject jSONObject = new JSONObject(jax.O0000o());
                        Integer num = null;
                        String string = jSONObject.has("status") ? jSONObject.getString("status") : null;
                        Integer valueOf = jSONObject.has("done") ? Integer.valueOf(jSONObject.getInt("done")) : null;
                        if (jSONObject.has("total")) {
                            num = Integer.valueOf(jSONObject.getInt("total"));
                        }
                        devBundleDownloadListener2.onProgress(string, valueOf, num);
                    } catch (JSONException e) {
                        FLog.e("ReactNative", "Error parsing progress JSON. " + e.toString());
                    }
                }
            }

            public void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException {
                if ("application/javascript".equals(map.get("Content-Type"))) {
                    devBundleDownloadListener2.onProgress("Downloading JavaScript bundle", Integer.valueOf((int) (j / 1024)), Integer.valueOf((int) (j2 / 1024)));
                }
            }
        })) {
            devBundleDownloadListener.onFailure(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + response.code() + "\n\nURL: " + str.toString() + "\n\n"));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: com.facebook.react.bridge.NativeDeltaClient} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void processBundleResult(String str, int i, Headers headers, jaz jaz, File file, BundleInfo bundleInfo, BundleDeltaClient.ClientType clientType, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        boolean z;
        if (i != 200) {
            String O0000o = jaz.O0000o();
            DebugServerException parse = DebugServerException.parse(str, O0000o);
            if (parse != null) {
                devBundleDownloadListener.onFailure(parse);
                return;
            }
            devBundleDownloadListener.onFailure(new DebugServerException("The development server returned response error code: " + i + "\n\nURL: " + str + "\n\nBody:\n" + O0000o));
            return;
        }
        if (bundleInfo != null) {
            populateBundleInfo(str, headers, clientType, bundleInfo);
        }
        File file2 = new File(file.getPath() + ".tmp");
        NativeDeltaClient nativeDeltaClient = null;
        if (BundleDeltaClient.isDeltaUrl(str)) {
            BundleDeltaClient bundleDeltaClient = getBundleDeltaClient(clientType);
            Assertions.assertNotNull(bundleDeltaClient);
            Pair<Boolean, NativeDeltaClient> processDelta = bundleDeltaClient.processDelta(headers, jaz, file2);
            z = ((Boolean) processDelta.first).booleanValue();
            nativeDeltaClient = processDelta.second;
        } else {
            this.mBundleDeltaClient = null;
            z = storePlainJSInFile(jaz, file2);
        }
        if (!z || file2.renameTo(file)) {
            devBundleDownloadListener.onSuccess(nativeDeltaClient);
            return;
        }
        throw new IOException("Couldn't rename " + file2 + " to " + file);
    }

    private BundleDeltaClient getBundleDeltaClient(BundleDeltaClient.ClientType clientType) {
        BundleDeltaClient bundleDeltaClient = this.mBundleDeltaClient;
        if (bundleDeltaClient == null || !bundleDeltaClient.canHandle(clientType)) {
            this.mBundleDeltaClient = BundleDeltaClient.create(clientType);
        }
        return this.mBundleDeltaClient;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    private static boolean storePlainJSInFile(jaz jaz, File file) throws IOException {
        jbm jbm;
        try {
            jbm = jbg.O00000Oo(file);
            try {
                jaz.O000000o(jbm);
                if (jbm == null) {
                    return true;
                }
                jbm.close();
                return true;
            } catch (Throwable th) {
                th = th;
                if (jbm != null) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            jbm = null;
            if (jbm != null) {
                jbm.close();
            }
            throw th;
        }
    }

    private static void populateBundleInfo(String str, Headers headers, BundleDeltaClient.ClientType clientType, BundleInfo bundleInfo) {
        String str2;
        if (clientType == BundleDeltaClient.ClientType.NONE) {
            str2 = null;
        } else {
            str2 = clientType.name();
        }
        bundleInfo.mDeltaClientName = str2;
        bundleInfo.mUrl = str;
        String str3 = headers.get("X-Metro-Files-Changed-Count");
        if (str3 != null) {
            try {
                bundleInfo.mFilesChangedCount = Integer.parseInt(str3);
            } catch (NumberFormatException unused) {
                bundleInfo.mFilesChangedCount = -2;
            }
        }
    }
}
