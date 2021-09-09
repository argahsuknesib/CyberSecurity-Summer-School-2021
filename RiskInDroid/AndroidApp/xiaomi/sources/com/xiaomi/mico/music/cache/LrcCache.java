package com.xiaomi.mico.music.cache;

import _m_j.ahh;
import _m_j.bnf;
import _m_j.gpg;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.common.util.AssertionUtil;
import com.xiaomi.mico.common.util.MD5;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LrcCache {
    private static LrcCache sInstance = new LrcCache();
    private bnf mDiskLruCache;
    public LongSparseArray<String> mIDToUrl = new LongSparseArray<>();

    public static LrcCache getInstance() {
        return sInstance;
    }

    private LrcCache() {
        try {
            this.mDiskLruCache = bnf.O000000o(MicoApplication.getInstance().getGlobalContext().getExternalFilesDir("lrc_cache"), 20170505, 1, 20971520);
        } catch (IOException unused) {
            this.mDiskLruCache = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Observable<String> get(final long j) {
        return MusicCache.getSong(j).flatMap(new Func1<Music.Song, Observable<String>>() {
            /* class com.xiaomi.mico.music.cache.LrcCache.AnonymousClass1 */

            public Observable<String> call(Music.Song song) {
                if (!"xiaowei".equalsIgnoreCase(song.origin)) {
                    return LrcCache.this.getV0(j);
                }
                try {
                    String innerGet = LrcCache.this.innerGet(String.valueOf(j));
                    if (!TextUtils.isEmpty(innerGet)) {
                        return Observable.just(innerGet);
                    }
                    return LrcCache.this.getQQLrc(song);
                } catch (Exception unused) {
                    return LrcCache.this.getQQLrc(song);
                }
            }
        });
    }

    public Observable<String> getQQLrc(final Music.Song song) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.music.cache.LrcCache.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super String> subscriber) {
                ApiHelper.getQQMusicLyric(song.originSongID, new ApiRequest.Listener<String>() {
                    /* class com.xiaomi.mico.music.cache.LrcCache.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(String str) {
                        LrcCache.this.mIDToUrl.put(song.songID, String.valueOf(song.songID));
                        LrcCache.this.innerSet(String.valueOf(song.songID), str.getBytes());
                        subscriber.onNext(str);
                        subscriber.onCompleted();
                    }

                    public void onFailure(ApiError apiError) {
                        subscriber.onNext("");
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }

    public Observable<String> getV0(final long j) {
        final String str = this.mIDToUrl.get(j);
        if (str == null) {
            return ObservableApiHelper.getSongInfo(j).map(new Func1<Music.Song, String>() {
                /* class com.xiaomi.mico.music.cache.LrcCache.AnonymousClass4 */

                public String call(Music.Song song) {
                    String str = song.lyricURL;
                    LrcCache.this.mIDToUrl.put(j, str);
                    return str;
                }
            }).observeOn(Schedulers.io()).map(new Func1<String, String>() {
                /* class com.xiaomi.mico.music.cache.LrcCache.AnonymousClass3 */

                public String call(String str) {
                    return LrcCache.this.get(str);
                }
            });
        }
        return Observable.create(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.music.cache.LrcCache.AnonymousClass5 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(LrcCache.this.get(str));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }

    public String get(String str) {
        bnf.O000000o O00000Oo;
        AssertionUtil.checkNotUiThread();
        if (this.mDiskLruCache == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String MD5_32 = MD5.MD5_32(str);
        try {
            String innerGet = innerGet(MD5_32);
            if (innerGet != null || (O00000Oo = this.mDiskLruCache.O00000Oo(MD5_32)) == null) {
                return innerGet;
            }
            if (downloadTo(str, O00000Oo.O000000o(0))) {
                O00000Oo.O000000o();
            } else {
                O00000Oo.O00000Oo();
            }
            this.mDiskLruCache.O00000o0();
            return innerGet(MD5_32);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean downloadTo(String str, OutputStream outputStream) throws IOException {
        Response execute = ApiManager.getInstance().getOkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
        if (execute.isSuccessful()) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(execute.body().byteStream());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            while (true) {
                int read = bufferedInputStream.read();
                if (read != -1) {
                    bufferedOutputStream.write(read);
                } else {
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    gpg.O000000o(execute);
                    return true;
                }
            }
        } else {
            gpg.O000000o(execute);
            return false;
        }
    }

    public String innerGet(String str) throws IOException {
        bnf.O00000o0 O000000o2 = this.mDiskLruCache.O000000o(str);
        if (O000000o2 == null) {
            return null;
        }
        return inputStreamToString(this.mDiskLruCache.O000000o(str).f13131O000000o[0], getCharsetName(O000000o2.f13131O000000o[0]));
    }

    public void innerSet(String str, byte[] bArr) {
        try {
            bnf.O000000o O00000Oo = this.mDiskLruCache.O00000Oo(str);
            OutputStream O000000o2 = O00000Oo.O000000o(0);
            O000000o2.write(bArr);
            O000000o2.close();
            O00000Oo.O000000o();
        } catch (Exception e) {
            ahh.O000000o(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[Catch:{ Exception -> 0x009b, all -> 0x0099 }, LOOP:0: B:33:0x0054->B:75:0x0054, LOOP_START] */
    private static String getCharsetName(InputStream inputStream) {
        int read;
        String str = "GBK";
        byte[] bArr = new byte[3];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            bufferedInputStream.mark(4);
            if (bufferedInputStream.read(bArr, 0, 3) == -1) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
            boolean z = true;
            if (bArr[0] == -1) {
                if (bArr[1] == -2) {
                    str = "UTF-16LE";
                    bufferedInputStream.reset();
                    if (!z) {
                        while (true) {
                            int read2 = bufferedInputStream.read();
                            if (read2 != -1 && read2 < 240 && (128 > read2 || read2 > 191)) {
                                if (192 <= read2 && read2 <= 223) {
                                    int read3 = bufferedInputStream.read();
                                    if (128 <= read3 && read3 <= 191) {
                                    }
                                } else if (224 <= read2 && read2 <= 239) {
                                    int read4 = bufferedInputStream.read();
                                    if (128 <= read4 && read4 <= 191 && 128 <= (read = bufferedInputStream.read()) && read <= 191) {
                                        str = "UTF-8";
                                    }
                                }
                            }
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                }
            }
            if (bArr[0] == -2 && bArr[1] == -1) {
                str = "UTF-16BE";
                bufferedInputStream.reset();
                if (!z) {
                }
                bufferedInputStream.close();
                return str;
            }
            if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
                str = "UTF-8";
            } else {
                z = false;
            }
            bufferedInputStream.reset();
            if (!z) {
            }
            bufferedInputStream.close();
            return str;
        } catch (Exception e3) {
            e3.printStackTrace();
            bufferedInputStream.close();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    private static String inputStreamToString(InputStream inputStream, String str) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName(str));
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            inputStreamReader.close();
        }
    }
}
