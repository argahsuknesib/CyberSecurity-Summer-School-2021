package com.mijia.model;

import _m_j.chp;
import _m_j.cid;
import _m_j.dxx;
import _m_j.gsy;
import _m_j.mf;
import _m_j.ml;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.P2pResponse;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraImageLoader extends BaseImageDownloader {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f5226O000000o = "camera://";
    public static String O00000Oo = "time:";
    private ExecutorService O00000o = Executors.newFixedThreadPool(3);
    private Context O00000o0;

    public CameraImageLoader(Context context) {
        super(context);
        this.O00000o0 = context.getApplicationContext();
    }

    public InputStream getStream(String str, Object obj) throws IOException {
        String str2;
        HttpURLConnection httpURLConnection;
        if (str.startsWith("fds://")) {
            String str3 = null;
            int lastIndexOf = str.lastIndexOf("?");
            if (lastIndexOf < 0) {
                str2 = str.substring(6);
            } else {
                String substring = str.substring(6, lastIndexOf);
                str3 = str.substring(lastIndexOf + 1);
                str2 = substring;
            }
            String O000000o2 = O000000o(str2);
            if (!TextUtils.isEmpty(O000000o2)) {
                URL url = new URL(O000000o2);
                int i = 0;
                if (mf.O000000o(XmPluginHostApi.instance().context())) {
                    HttpURLConnection.setFollowRedirects(false);
                    String O000000o3 = mf.O000000o(url);
                    String host = url.getHost();
                    URL url2 = new URL(O000000o3);
                    dxx.O000000o();
                    httpURLConnection = (HttpURLConnection) dxx.O000000o(url2);
                    httpURLConnection.setRequestProperty("X-Online-Host", host);
                    int responseCode = httpURLConnection.getResponseCode();
                    while (responseCode >= 300 && responseCode < 400) {
                        String headerField = httpURLConnection.getHeaderField("location");
                        if (TextUtils.isEmpty(headerField)) {
                            break;
                        }
                        URL url3 = new URL(headerField);
                        String O000000o4 = mf.O000000o(url3);
                        String host2 = url3.getHost();
                        URL url4 = new URL(O000000o4);
                        dxx.O000000o();
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) dxx.O000000o(url4);
                        httpURLConnection2.setRequestProperty("X-Online-Host", host2);
                        HttpURLConnection httpURLConnection3 = httpURLConnection2;
                        responseCode = httpURLConnection2.getResponseCode();
                        httpURLConnection = httpURLConnection3;
                    }
                } else {
                    dxx.O000000o();
                    httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
                    HttpURLConnection.setFollowRedirects(true);
                }
                httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                if (TextUtils.isEmpty(str3)) {
                    return inputStream;
                }
                int contentLength = httpURLConnection.getContentLength();
                byte[] bArr = new byte[contentLength];
                while (i < contentLength) {
                    int read = inputStream.read(bArr, i, contentLength - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                }
                return new ByteArrayInputStream(ml.O000000o(bArr, str3));
            }
            throw new IOException("not get url");
        } else if (str.startsWith(f5226O000000o)) {
            int indexOf = str.indexOf(f5226O000000o) + f5226O000000o.length();
            int indexOf2 = str.indexOf(O00000Oo);
            return O000000o(str.substring(indexOf, indexOf2), Long.valueOf(str.substring(indexOf2 + O00000Oo.length())).longValue());
        } else if ((str.contains("processor.smartcamera") || str.contains("business.smartcamera")) && this.O00000o0 != null) {
            return new ByteArrayInputStream(XmPluginHostApi.instance().sendImageDownloadRequest(this.O00000o0, str));
        } else {
            return super.getStream(str, obj);
        }
    }

    private InputStream O000000o(String str, long j) throws IOException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        InputStream[] inputStreamArr = {null};
        final long j2 = j;
        final String str2 = str;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final InputStream[] inputStreamArr2 = inputStreamArr;
        this.O00000o.execute(new Runnable() {
            /* class com.mijia.model.CameraImageLoader.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            byte[] f5227O000000o;
            int O00000Oo;

            public final void run() {
                byte[] intToByteArray = Packet.intToByteArray((int) (j2 / 1000), chp.O000000o());
                DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str2);
                if (deviceByDid == null) {
                    countDownLatch2.countDown();
                    return;
                }
                cid O000000o2 = cid.O000000o(deviceByDid, str2);
                if (O000000o2 == null || O000000o2.O0000ooo() == null) {
                    countDownLatch2.countDown();
                } else {
                    O000000o2.O0000ooo().sendMsg(5, 5, intToByteArray, new P2pResponse() {
                        /* class com.mijia.model.CameraImageLoader.AnonymousClass1.AnonymousClass1 */

                        public final void onResponse(int i, byte[] bArr) {
                            if (bArr == null) {
                                countDownLatch2.countDown();
                                return;
                            }
                            gsy.O000000o(3, "CameraImageLoader", "downloadFile:".concat(String.valueOf(i)));
                            if (AnonymousClass1.this.f5227O000000o == null) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                r0.f5227O000000o = new byte[(bArr.length + i)];
                                r0.O00000Oo = 0;
                            }
                            System.arraycopy(bArr, 0, AnonymousClass1.this.f5227O000000o, AnonymousClass1.this.O00000Oo, bArr.length);
                            AnonymousClass1.this.O00000Oo += bArr.length;
                            if (i == 0) {
                                inputStreamArr2[0] = new ByteArrayInputStream(AnonymousClass1.this.f5227O000000o);
                                AnonymousClass1 r5 = AnonymousClass1.this;
                                r5.f5227O000000o = null;
                                countDownLatch2.countDown();
                            } else if (i < 0) {
                                countDownLatch2.countDown();
                            }
                        }

                        public final void onError(int i) {
                            gsy.O000000o(3, "CameraImageLoader", "downloadFile failled:".concat(String.valueOf(i)));
                            inputStreamArr2[0] = null;
                            AnonymousClass1 r3 = AnonymousClass1.this;
                            r3.f5227O000000o = null;
                            countDownLatch2.countDown();
                        }
                    });
                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        if (inputStreamArr[0] != null) {
            return inputStreamArr[0];
        }
        throw new IOException("download cameraSdCard thumb file error");
    }

    private String O000000o(final String str) throws IOException {
        final String[] strArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.O00000o.execute(new Runnable() {
            /* class com.mijia.model.CameraImageLoader.AnonymousClass2 */

            public final void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("obj_name", str);
                } catch (JSONException unused) {
                }
                XmPluginHostApi.instance().callSmartHomeApi("mijia.camera.v1", "/home/getfileurl", jSONObject, new Callback<String>() {
                    /* class com.mijia.model.CameraImageLoader.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        strArr[0] = (String) obj;
                        countDownLatch.countDown();
                    }

                    public final void onFailure(int i, String str) {
                        strArr[0] = null;
                        countDownLatch.countDown();
                    }
                }, new Parser<String>() {
                    /* class com.mijia.model.CameraImageLoader.AnonymousClass2.AnonymousClass2 */

                    public final /* synthetic */ Object parse(String str) throws JSONException {
                        return new JSONObject(str).optString("url");
                    }
                });
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return strArr[0];
    }
}
