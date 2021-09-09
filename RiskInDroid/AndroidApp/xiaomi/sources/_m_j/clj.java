package _m_j;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class clj extends ckx {
    public List<O000000o> O0000O0o = new CopyOnWriteArrayList();

    public final String O00000oO() {
        return "com.mijia.camera.LocalFileManager";
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f14070O000000o;
        public long O00000Oo;
        public String O00000o;
        public File O00000o0;
        public boolean O00000oO;

        public final boolean equals(Object obj) {
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return o000000o.O00000oO == this.O00000oO && this.O00000o.equals(o000000o.O00000o);
        }
    }

    public clj(dty dty) {
        super(dty);
    }

    public final void O000000o(String str) {
        O000000o O000000o2;
        File file = new File(str);
        if (file.exists() && (O000000o2 = O000000o(file)) != null) {
            this.O0000O0o.add(O000000o2);
            O00000o0();
        }
    }

    public final void O000000o(final Callback<Void> callback) {
        new AsyncTask<Void, Void, List<O000000o>>() {
            /* class _m_j.clj.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                List list = (List) obj;
                super.onPostExecute(list);
                clj.this.O0000O0o = new CopyOnWriteArrayList(list);
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
                clj.this.O00000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                ArrayList arrayList = new ArrayList();
                File[] listFiles = new File(me.O000000o(clj.this.O00000o.getDid())).listFiles(new FilenameFilter() {
                    /* class _m_j.clj.AnonymousClass2.AnonymousClass1 */

                    public final boolean accept(File file, String str) {
                        return str.endsWith(".jpg") || str.endsWith(".png") || str.endsWith(".mp4");
                    }
                });
                if (listFiles != null) {
                    for (File O000000o2 : listFiles) {
                        O000000o O000000o3 = clj.O000000o(O000000o2);
                        if (O000000o3 != null) {
                            arrayList.add(O000000o3);
                        }
                    }
                }
                Collections.sort(arrayList, new cli());
                return arrayList;
            }
        }.execute((Object[]) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clw.O000000o(java.lang.String, boolean):long
     arg types: [java.lang.String, int]
     candidates:
      _m_j.clw.O000000o(long, boolean):java.lang.String
      _m_j.clw.O000000o(java.lang.String, boolean):long */
    public static O000000o O000000o(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String name = file.getName();
        if (name.endsWith(".jpg") || name.endsWith(".png")) {
            O000000o o000000o = new O000000o();
            o000000o.O00000o0 = file;
            o000000o.O00000o = Uri.fromFile(file).toString();
            o000000o.O00000oO = false;
            o000000o.f14070O000000o = clw.O000000o().O000000o(name.substring(0, name.length() - 4), false);
            return o000000o;
        } else if (!name.endsWith(".mp4")) {
            return null;
        } else {
            O000000o o000000o2 = new O000000o();
            o000000o2.O00000o0 = file;
            o000000o2.O00000o = Uri.fromFile(file).toString();
            o000000o2.O00000oO = true;
            o000000o2.f14070O000000o = clw.O000000o().O000000o(name.substring(0, name.length() - 4), true);
            O00000Oo(o000000o2);
            return o000000o2;
        }
    }

    private static void O00000Oo(O000000o o000000o) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(o000000o.O00000o0.getAbsolutePath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                o000000o.O00000Oo = Long.valueOf(extractMetadata).longValue();
            }
        } catch (Exception e) {
            o000000o.O00000Oo = 0;
            e.printStackTrace();
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public final void O000000o(O000000o o000000o) {
        o000000o.O00000o0.delete();
        this.O0000O0o.remove(o000000o);
        O00000o0();
    }

    public final O000000o O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (O000000o next : this.O0000O0o) {
            if (next.O00000o.endsWith(str)) {
                return next;
            }
        }
        O000000o O000000o2 = O000000o(new File(str));
        if (O000000o2 != null) {
            this.O0000O0o.add(O000000o2);
            O00000o0();
        }
        return O000000o2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String
     arg types: [long, int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, int, java.lang.String):java.lang.String
      _m_j.me.O000000o(java.lang.String, java.lang.String, int):java.lang.String
      _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String */
    public final O000000o O000000o(long j) {
        for (O000000o next : this.O0000O0o) {
            if (next.f14070O000000o == j) {
                return next;
            }
        }
        O000000o O000000o2 = O000000o(new File(me.O000000o(j, true, this.O00000o.getDid())));
        if (O000000o2 != null) {
            this.O0000O0o.add(O000000o2);
            O00000o0();
        }
        return O000000o2;
    }

    public final void O00000o0(final Callback<Void> callback) {
        boolean z = this.f13974O000000o;
        new AsyncTask<Void, Void, List<O000000o>>() {
            /* class _m_j.clj.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                List list = (List) obj;
                super.onPostExecute(list);
                clj.this.O0000O0o = new CopyOnWriteArrayList(list);
                callback.onSuccess(null);
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                ArrayList arrayList = new ArrayList();
                File[] listFiles = new File(me.O000000o(clj.this.O00000o.getDid())).listFiles(new FilenameFilter() {
                    /* class _m_j.clj.AnonymousClass1.AnonymousClass1 */

                    public final boolean accept(File file, String str) {
                        return str.endsWith(".jpg") || str.endsWith(".png") || str.endsWith(".mp4");
                    }
                });
                if (listFiles != null) {
                    for (File O000000o2 : listFiles) {
                        O000000o O000000o3 = clj.O000000o(O000000o2);
                        if (O000000o3 != null) {
                            arrayList.add(O000000o3);
                        }
                    }
                }
                Collections.sort(arrayList, new cli());
                return arrayList;
            }
        }.execute((Object[]) null);
    }
}
