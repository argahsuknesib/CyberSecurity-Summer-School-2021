package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

final class dmk implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ List f14786O000000o;
    final /* synthetic */ dmh O00000Oo;
    final /* synthetic */ dmi O00000o0;

    dmk(dmi dmi, List list, dmh dmh) {
        this.O00000o0 = dmi;
        this.f14786O000000o = list;
        this.O00000Oo = dmh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0349, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x034a, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void run() {
        String str;
        dmi dmi = this.O00000o0;
        List list = this.f14786O000000o;
        dmh dmh = this.O00000Oo;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            dmi.O00000o.delete(0, dmi.O00000o.length());
            dmi.O00000o.append("[");
            for (int i = 0; i < size; i++) {
                dmi.O00000o.append(list.get(i).toString());
                if (i != size - 1) {
                    dmi.O00000o.append(",");
                }
            }
            dmi.O00000o.append("]");
            String sb = dmi.O00000o.toString();
            int length = sb.length();
            String str2 = dkd.O0000o0o() + "/?index=" + dmi.O00000oo;
            dmi.O00000oo++;
            if (dkd.O00000Oo()) {
                dmi.f14784O000000o.O000000o("[" + str2 + "]Send request(" + length + "bytes), content:" + sb);
            }
            HttpPost httpPost = new HttpPost(str2);
            httpPost.addHeader("Accept-Encoding", "gzip");
            httpPost.setHeader("Connection", "Keep-Alive");
            httpPost.removeHeaders("Cache-Control");
            HttpHost httpHost = dkg.O000000o(dmi.O00000oO).O00000o;
            httpPost.addHeader("Content-Encoding", "rc4");
            if (httpHost == null) {
                dmi.O00000Oo.getParams().removeParameter("http.route.default-proxy");
                str = "ncts";
            } else {
                if (dkd.O00000Oo()) {
                    str = "ncts";
                    dmi.f14784O000000o.O0000O0o("proxy:" + httpHost.toHostString());
                } else {
                    str = "ncts";
                }
                httpPost.addHeader("X-Content-Encoding", "rc4");
                dmi.O00000Oo.getParams().setParameter("http.route.default-proxy", httpHost);
                httpPost.addHeader("X-Online-Host", dkd.O0000Ooo);
                httpPost.addHeader("Accept", "*/*");
                httpPost.addHeader("Content-Type", "json");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
            byte[] bytes = sb.getBytes("UTF-8");
            int length2 = bytes.length;
            if (length > dkd.O0000o0o) {
                httpPost.removeHeaders("Content-Encoding");
                String str3 = "rc4" + ",gzip";
                httpPost.addHeader("Content-Encoding", str3);
                if (httpHost != null) {
                    httpPost.removeHeaders("X-Content-Encoding");
                    httpPost.addHeader("X-Content-Encoding", str3);
                }
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                if (dkd.O00000Oo()) {
                    dmi.f14784O000000o.O0000O0o("before Gzip:" + length2 + " bytes, after Gzip:" + bytes.length + " bytes");
                }
            }
            httpPost.setEntity(new ByteArrayEntity(dlq.O000000o(bytes)));
            HttpResponse execute = dmi.O00000Oo.execute(httpPost);
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            if (dkd.O00000Oo()) {
                dmi.f14784O000000o.O000000o("http recv response status code:" + statusCode + ", content length:" + contentLength);
            }
            if (contentLength <= 0) {
                dmi.f14784O000000o.O00000oO("Server response no data.");
                if (dmh != null) {
                    dmh.O00000Oo();
                }
                EntityUtils.toString(entity);
                return;
            }
            if (contentLength > 0) {
                InputStream content = entity.getContent();
                DataInputStream dataInputStream = new DataInputStream(content);
                byte[] bArr = new byte[((int) entity.getContentLength())];
                dataInputStream.readFully(bArr);
                content.close();
                dataInputStream.close();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader != null) {
                    if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                        bArr = dlq.O00000Oo(dlv.O000000o(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                        bArr = dlv.O000000o(dlq.O00000Oo(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                        bArr = dlv.O000000o(bArr);
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                        bArr = dlq.O00000Oo(bArr);
                    }
                }
                String str4 = new String(bArr, "UTF-8");
                if (dkd.O00000Oo()) {
                    dmi.f14784O000000o.O000000o("http get response data:".concat(str4));
                }
                JSONObject jSONObject = new JSONObject(str4);
                if (statusCode == 200) {
                    try {
                        String optString = jSONObject.optString("mid");
                        if (dgi.O00000Oo(optString)) {
                            if (dkd.O00000Oo()) {
                                dmi.f14784O000000o.O000000o("update mid:".concat(String.valueOf(optString)));
                            }
                            dgh.O000000o(dmi.O00000oO).O000000o(optString);
                        }
                        if (!jSONObject.isNull("cfg")) {
                            dkd.O000000o(dmi.O00000oO, jSONObject.getJSONObject("cfg"));
                        }
                        String str5 = str;
                        if (!jSONObject.isNull(str5)) {
                            int i2 = jSONObject.getInt(str5);
                            int currentTimeMillis = (int) (((long) i2) - (System.currentTimeMillis() / 1000));
                            if (dkd.O00000Oo()) {
                                dmi.f14784O000000o.O000000o("server time:" + i2 + ", diff time:" + currentTimeMillis);
                            }
                            dlv.O0000oo(dmi.O00000oO);
                            dlv.O000000o(dmi.O00000oO, currentTimeMillis);
                        }
                    } catch (Throwable th) {
                        dmi.f14784O000000o.O00000o0(th);
                    }
                    if (dmh != null) {
                        if (jSONObject.optInt("ret") == 0) {
                            dmh.O000000o();
                        } else {
                            dmi.f14784O000000o.O00000o("response error data.");
                        }
                    }
                    content.close();
                } else {
                    dmi.f14784O000000o.O00000o("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                    if (dmh != null) {
                    }
                    content.close();
                }
                dmh.O00000Oo();
                content.close();
            } else {
                EntityUtils.toString(entity);
            }
            byteArrayOutputStream.close();
            Throwable th2 = null;
            if (th2 != null) {
                dmi.f14784O000000o.O000000o(th2);
                if (dmh != null) {
                    try {
                        dmh.O00000Oo();
                    } catch (Throwable th3) {
                        dmi.f14784O000000o.O00000Oo(th3);
                    }
                }
                if (th2 instanceof OutOfMemoryError) {
                    System.gc();
                    dmi.O00000o = null;
                    dmi.O00000o = new StringBuilder(2048);
                }
                dkg O000000o2 = dkg.O000000o(dmi.O00000oO);
                O000000o2.O00000oO = (O000000o2.O00000oO + 1) % O000000o2.f14740O000000o.size();
            }
        }
    }
}
