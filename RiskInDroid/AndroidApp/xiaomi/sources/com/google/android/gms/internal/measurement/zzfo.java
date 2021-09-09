package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

final class zzfo implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzajl;
    private final zzfm zzajm;
    private final Map<String, String> zzajn;
    private final /* synthetic */ zzfk zzajo;

    public zzfo(zzfk zzfk, String str, URL url2, byte[] bArr, Map<String, String> map, zzfm zzfm) {
        this.zzajo = zzfk;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url2);
        Preconditions.checkNotNull(zzfm);
        this.url = url2;
        this.zzajl = bArr;
        this.zzajm = zzfm;
        this.packageName = str;
        this.zzajn = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c6 A[SYNTHETIC, Splitter:B:45:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101 A[SYNTHETIC, Splitter:B:58:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011b  */
    public final void run() {
        Map<String, List<String>> map;
        IOException iOException;
        int i;
        HttpURLConnection httpURLConnection;
        zzgg zzgd;
        zzfn zzfn;
        Map<String, List<String>> map2;
        this.zzajo.zzfs();
        OutputStream outputStream = null;
        try {
            httpURLConnection = this.zzajo.zzb(this.url);
            try {
                if (this.zzajn != null) {
                    for (Map.Entry next : this.zzajn.entrySet()) {
                        httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                }
                if (this.zzajl != null) {
                    byte[] zza = this.zzajo.zzgb().zza(this.zzajl);
                    this.zzajo.zzge().zzit().zzg("Uploading data. size", Integer.valueOf(zza.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(zza.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(zza);
                        outputStream2.close();
                    } catch (IOException e) {
                        map2 = null;
                        iOException = e;
                        outputStream = outputStream2;
                    } catch (Throwable th) {
                        th = th;
                        map = null;
                        outputStream = outputStream2;
                        i = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                        throw th;
                    }
                }
                i = httpURLConnection.getResponseCode();
                try {
                    map = httpURLConnection.getHeaderFields();
                    try {
                        byte[] zza2 = zzfk.zzb(httpURLConnection);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzgd = this.zzajo.zzgd();
                        zzfn = new zzfn(this.packageName, this.zzajm, i, null, zza2, map);
                    } catch (IOException e2) {
                        e = e2;
                        iOException = e;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzgd = this.zzajo.zzgd();
                        zzfn = new zzfn(this.packageName, this.zzajm, i, iOException, null, map);
                        zzgd.zzc(zzfn);
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    map = null;
                    iOException = e;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzgd = this.zzajo.zzgd();
                    zzfn = new zzfn(this.packageName, this.zzajm, i, iOException, null, map);
                    zzgd.zzc(zzfn);
                } catch (Throwable th3) {
                    th = th3;
                    map = null;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                map2 = null;
                iOException = e;
                i = 0;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzgd = this.zzajo.zzgd();
                zzfn = new zzfn(this.packageName, this.zzajm, i, iOException, null, map);
                zzgd.zzc(zzfn);
            } catch (Throwable th4) {
                th = th4;
                map = null;
                i = 0;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection = null;
            map2 = null;
            iOException = e;
            i = 0;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                    this.zzajo.zzge().zzim().zze("Error closing HTTP compressed POST connection output stream. appId", zzfg.zzbm(this.packageName), e6);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzgd = this.zzajo.zzgd();
            zzfn = new zzfn(this.packageName, this.zzajm, i, iOException, null, map);
            zzgd.zzc(zzfn);
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            map = null;
            i = 0;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e7) {
                    this.zzajo.zzge().zzim().zze("Error closing HTTP compressed POST connection output stream. appId", zzfg.zzbm(this.packageName), e7);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
            throw th;
        }
        zzgd.zzc(zzfn);
    }
}
