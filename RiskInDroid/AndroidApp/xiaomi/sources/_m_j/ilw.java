package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.UUID;

public final class ilw {

    /* renamed from: O000000o  reason: collision with root package name */
    String f1454O000000o;
    long O00000Oo;
    public volatile boolean O00000o = false;
    int O00000o0;
    public volatile int O00000oO;
    public volatile BitSet O00000oo;
    public volatile ArrayList<Integer> O0000O0o;
    public volatile ArrayList<Integer> O0000OOo;
    private String O0000Oo;
    private int O0000Oo0;
    private String O0000OoO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    public ilw(String str, String str2) throws IOException {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        imc.O000000o("dl_mp3", (Object) "======================FileDesc Constructor()");
        this.O0000OoO = str;
        this.f1454O000000o = str2;
        File file = new File(iml.O00000oO);
        if (!file.exists() && !file.mkdirs()) {
            imc.O000000o("dl_mp3", (Object) ("目录不存在，创建失败！" + iml.O00000oO));
        }
        String O00000Oo2 = imd.O00000Oo(str2);
        String str3 = str + "/" + O00000Oo2 + ".index";
        File file2 = new File(str3);
        File file3 = new File(str + "/" + O00000Oo2 + ".chunk");
        if (file2.exists() != file3.exists()) {
            file2.delete();
            file3.delete();
        }
        if (!file2.exists()) {
            O000000o(str, str2);
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str3);
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (Exception unused) {
                dataInputStream = null;
                fileInputStream2 = fileInputStream;
                try {
                    file2.delete();
                    file3.delete();
                    O000000o(str, str2);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (dataInputStream == null) {
                        dataInputStream.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                if (fileInputStream != null) {
                }
                if (dataInputStream != null) {
                }
                throw th;
            }
            try {
                this.f1454O000000o = dataInputStream.readUTF();
                if (this.f1454O000000o != null) {
                    if (imd.O00000Oo(this.f1454O000000o).equals(imd.O00000Oo(str2))) {
                        this.O00000Oo = dataInputStream.readLong();
                        this.O0000Oo = dataInputStream.readUTF();
                        int ceil = (int) Math.ceil((double) (((float) this.O00000Oo) / 65536.0f));
                        imc.O000000o("dl_mp3", (Object) ("calc002==comChunkNum==:" + this.O00000Oo + ", " + ceil));
                        this.O00000o0 = ceil;
                        this.O0000Oo0 = dataInputStream.readInt();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < this.O0000Oo0; i++) {
                            arrayList.add(Integer.valueOf(dataInputStream.readInt()));
                        }
                        if (this.O00000o0 > 0) {
                            this.O00000o = true;
                            O000000o(arrayList, ceil);
                        }
                        fileInputStream.close();
                        dataInputStream.close();
                    }
                }
                file2.delete();
                file3.delete();
                O000000o(str, str2);
                fileInputStream.close();
                dataInputStream.close();
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                }
                if (dataInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            dataInputStream = null;
            file2.delete();
            file3.delete();
            O000000o(str, str2);
            if (fileInputStream2 != null) {
            }
            if (dataInputStream == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            if (dataInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private void O000000o(String str, String str2) throws IOException {
        int i;
        CdnConfigModel cdnConfigModel;
        String uuid = UUID.randomUUID().toString();
        int i2 = 3;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            imo imo = new imo();
            HttpURLConnection httpURLConnection = null;
            try {
                String[] strArr = {str2};
                String host = TextUtils.isEmpty(str2) ? "" : Uri.parse(str2).getHost();
                httpURLConnection = imf.O000000o(strArr, null, 1, false, "HEAD");
                str2 = strArr[0];
                if (httpURLConnection == null) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (!this.O00000o && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                        cdnConfigModel = imq.f1481O000000o;
                        imq.O000000o(imo, cdnConfigModel);
                    }
                    i2 = i3;
                } else {
                    this.O00000oO = httpURLConnection.getResponseCode();
                    imo.O0000Ooo = "play_head_fail";
                    String url = httpURLConnection.getURL().toString();
                    imo.f1479O000000o = url;
                    imo.O00000o0 = imq.O000000o(url);
                    imo.O0000Oo0 = httpURLConnection.getHeaderField("via");
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.O00000oO);
                    imo.O0000OOo = sb.toString();
                    imo.O0000oO0 = host;
                    imo.O0000oO = uuid;
                    if (this.O00000oO < 400) {
                        this.O00000o = true;
                        this.O00000Oo = (long) httpURLConnection.getContentLength();
                        imo.O00000Oo = this.O00000Oo;
                        imc.O000000o("dl_mp3", (Object) ("conn.getContentLength():" + this.O00000Oo));
                        if (this.O00000Oo <= 0) {
                            imo.O0000O0o = "cdn_unknown_exception";
                            imo.O00000oo = "head request comFileLen<=0";
                            this.O00000o = false;
                        }
                        this.O0000Oo = httpURLConnection.getHeaderField("ETag");
                        if (this.O00000o) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (!this.O00000o && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                                imq.O000000o(imo, imq.f1481O000000o);
                            }
                        } else {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (!this.O00000o && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                                cdnConfigModel = imq.f1481O000000o;
                                imq.O000000o(imo, cdnConfigModel);
                            }
                            i2 = i3;
                        }
                    } else {
                        imc.O00000Oo("dl_mp3", "Error response code for get head for url: " + str2 + ",status code is: " + this.O00000oO + " in handler thread");
                        throw new IOException("http response status code is: " + this.O00000oO);
                    }
                }
            } catch (Exception e) {
                this.O00000o = false;
                imo.O0000O0o = "cdn_io_exception";
                imo.O00000oo = imq.O000000o(e);
                imo.O0000o = "failed";
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (!this.O00000o && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                    cdnConfigModel = imq.f1481O000000o;
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (!this.O00000o && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                    imq.O000000o(imo, imq.f1481O000000o);
                }
                throw th;
            }
        }
        if (!this.O00000o) {
            imc.O000000o("dl_mp3", (Object) ("valid0:" + this.O00000o + "comFileLen:" + this.O00000Oo + "statusCode:" + this.O00000oO));
            return;
        }
        imc.O000000o("dl_mp3", (Object) ("valid1:" + this.O00000o + "comFileLen:" + this.O00000Oo + "statusCode:" + this.O00000oO));
        this.O00000o0 = (int) Math.ceil((double) (((float) this.O00000Oo) / 65536.0f));
        imc.O000000o("dl_mp3", (Object) ("calc001==comFileLen==:" + this.O00000Oo + ",comChunkNum:" + this.O00000o0 + "statusCode:" + this.O00000oO));
        this.O0000Oo0 = 0;
        this.O00000oo = new BitSet(this.O00000o0);
        int i4 = this.O00000o0;
        if (i4 > 0) {
            this.O0000O0o = new ArrayList<>(i4);
            for (i = 0; i < this.O00000o0; i++) {
                this.O0000O0o.add(i, -1);
            }
            this.O0000OOo = new ArrayList<>();
            O00000Oo(str, imd.O00000Oo(str2));
            this.O00000o = true;
            return;
        }
        this.O00000o = false;
        this.O00000oO = 408;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ilw)) {
            return false;
        }
        ilw ilw = (ilw) obj;
        String str = this.f1454O000000o;
        if (str == null) {
            return false;
        }
        return str.equals(ilw.f1454O000000o);
    }

    public final int hashCode() {
        String str = this.f1454O000000o;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    private void O000000o(ArrayList<Integer> arrayList, int i) {
        this.O00000oo = new BitSet(i);
        this.O0000O0o = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.O0000O0o.add(i2, -1);
        }
        this.O0000OOo = arrayList;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.O00000oo.set(arrayList.get(i3).intValue());
            this.O0000O0o.set(arrayList.get(i3).intValue(), Integer.valueOf(i3));
        }
    }

    public final synchronized boolean O000000o(int i) {
        boolean z;
        z = false;
        if (this.O00000oo != null && i >= 0 && i < this.O00000oo.length()) {
            z = this.O00000oo.get(i);
        }
        return z;
    }

    public final boolean O000000o() {
        return this.O00000o && this.O00000o0 > 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    private synchronized void O00000Oo(String str, String str2) {
        String str3;
        imc.O000000o("dl_mp3", (Object) ("saveDescHeadToDisk(" + str + ", " + str2 + ", " + this.O00000Oo + ")"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str + "/" + str2 + ".index", false);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(this.f1454O000000o);
            dataOutputStream.writeLong(this.O00000Oo);
            if (this.O0000Oo == null) {
                str3 = "";
            } else {
                str3 = this.O0000Oo;
            }
            dataOutputStream.writeUTF(str3);
            dataOutputStream.writeInt(0);
            dataOutputStream.flush();
            dataOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            imc.O000000o("dl_mp3", (Object) ("exception: saveDescHeadToDisk" + e.getMessage()));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    private synchronized boolean O00000o0(String str, String str2) {
        String str3;
        imc.O000000o("dl_mp3", (Object) ("======================saveDescToDisk(" + str + ", " + str2 + ")"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str + "/" + str2 + ".index", false);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(this.f1454O000000o);
            dataOutputStream.writeLong(this.O00000Oo);
            if (this.O0000Oo == null) {
                str3 = "\"\"";
            } else {
                str3 = jdn.f1779O000000o + this.O0000Oo + jdn.f1779O000000o;
            }
            dataOutputStream.writeUTF(str3);
            dataOutputStream.writeInt(this.O0000Oo0);
            Iterator<Integer> it = this.O0000OOo.iterator();
            while (it.hasNext()) {
                dataOutputStream.writeInt(it.next().intValue());
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            fileOutputStream.close();
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    public final synchronized void O00000Oo(int i) {
        if (this.O00000oo != null) {
            int size = this.O0000OOo.size();
            this.O00000oo.set(i);
            this.O0000O0o.set(i, Integer.valueOf(size));
            this.O0000OOo.add(Integer.valueOf(i));
            this.O0000Oo0++;
            O00000o0(this.O0000OoO, imd.O00000Oo(this.f1454O000000o));
        }
    }

    public final synchronized int O00000Oo() {
        if (this.O0000OOo == null) {
            return 0;
        }
        return this.O0000OOo.size();
    }
}
