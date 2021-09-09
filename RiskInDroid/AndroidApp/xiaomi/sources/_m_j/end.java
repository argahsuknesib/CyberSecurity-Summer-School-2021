package _m_j;

import _m_j.elo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.at;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class end {
    private static volatile end O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    Context f15643O000000o;
    enc O00000Oo;
    ThreadPoolExecutor O00000o = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());
    final HashMap<String, enb> O00000o0 = new HashMap<>();
    /* access modifiers changed from: private */
    public final ArrayList<O000000o> O00000oo = new ArrayList<>();

    public static abstract class O00000Oo<T> extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private List<String> f15645O000000o;
        private String O00000oo;
        private String[] O0000O0o;
        private String O0000OOo;
        private String O0000Oo;
        private String O0000Oo0;
        private int O0000OoO;
        private List<T> O0000Ooo = new ArrayList();

        public O00000Oo(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f15645O000000o = list;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            this.O0000Oo = null;
            this.O0000OoO = 0;
        }

        public abstract T O000000o(Cursor cursor);

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.end.O00000Oo.O000000o(android.content.Context, java.util.List):void
         arg types: [android.content.Context, java.util.List<T>]
         candidates:
          _m_j.end.O00000Oo.O000000o(android.content.Context, android.database.sqlite.SQLiteDatabase):void
          _m_j.end.O000000o.O000000o(_m_j.enb, android.content.Context):void
          _m_j.end.O000000o.O000000o(android.content.Context, android.database.sqlite.SQLiteDatabase):void
          _m_j.end.O000000o.O000000o(android.content.Context, java.lang.Object):void
          _m_j.end.O00000Oo.O000000o(android.content.Context, java.util.List):void */
        public final void O000000o(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.O0000Ooo.clear();
            List<String> list = this.f15645O000000o;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f15645O000000o.size()];
                this.f15645O000000o.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.O0000OoO;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(this.O00000Oo, strArr, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, str);
            if (query != null && query.moveToFirst()) {
                do {
                    Object O000000o2 = O000000o(query);
                    if (O000000o2 != null) {
                        this.O0000Ooo.add(O000000o2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            O000000o(context, (List) this.O0000Ooo);
        }

        public abstract void O000000o(Context context, List<T> list);

        public final SQLiteDatabase O00000o0() {
            return this.O00000o0.getReadableDatabase();
        }
    }

    public static class O00000o extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private String f15646O000000o;
        protected String[] O00000oo;

        public O00000o(String str, String str2, String[] strArr) {
            super(str);
            this.f15646O000000o = str2;
            this.O00000oo = strArr;
        }

        public final void O000000o(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.O00000Oo, this.f15646O000000o, this.O00000oo);
        }
    }

    public static class O00000o0 extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private ArrayList<O000000o> f15647O000000o = new ArrayList<>();

        public O00000o0(String str, ArrayList<O000000o> arrayList) {
            super(str);
            this.f15647O000000o.addAll(arrayList);
        }

        public final void O000000o(Context context) {
            super.O000000o(context);
            Iterator<O000000o> it = this.f15647O000000o.iterator();
            while (it.hasNext()) {
                O000000o next = it.next();
                if (next != null) {
                    next.O000000o(context);
                }
            }
        }

        public final void O000000o(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<O000000o> it = this.f15647O000000o.iterator();
            while (it.hasNext()) {
                O000000o next = it.next();
                if (next != null) {
                    next.O000000o(context, sQLiteDatabase);
                }
            }
        }
    }

    public static class O0000O0o extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private ContentValues f15648O000000o;

        public O0000O0o(String str, ContentValues contentValues) {
            super(str);
            this.f15648O000000o = contentValues;
        }

        public final void O000000o(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.O00000Oo, null, this.f15648O000000o);
        }
    }

    private end(Context context) {
        this.f15643O000000o = context;
    }

    public static end O000000o(Context context) {
        if (O00000oO == null) {
            synchronized (end.class) {
                if (O00000oO == null) {
                    O00000oO = new end(context);
                }
            }
        }
        return O00000oO;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.elo.O000000o(_m_j.elo$O000000o, int):boolean
     arg types: [_m_j.ene, int]
     candidates:
      _m_j.elo.O000000o(java.lang.Runnable, int):void
      _m_j.elo.O000000o(_m_j.elo$O000000o, int):boolean */
    private void O000000o() {
        elo.O000000o(this.f15643O000000o).O000000o((elo.O000000o) new ene(this), at.a(this.f15643O000000o).a(hu.bm.a(), 5));
    }

    /* access modifiers changed from: package-private */
    public final enb O000000o(String str) {
        enb enb = this.O00000o0.get(str);
        if (enb == null) {
            synchronized (this.O00000o0) {
                if (enb == null) {
                    enb = this.O00000Oo.O000000o();
                    this.O00000o0.put(str, enb);
                }
            }
        }
        return enb;
    }

    public final void O000000o(Runnable runnable) {
        if (!this.O00000o.isShutdown()) {
            this.O00000o.execute(runnable);
        }
    }

    public static abstract class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<Context> f15644O000000o;
        protected String O00000Oo;
        String O00000o;
        protected enb O00000o0 = null;
        O000000o O00000oO;
        private Random O00000oo = new Random();
        private int O0000O0o = 0;

        public O000000o(String str) {
            this.O00000o = str;
        }

        public Object O000000o() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(enb enb, Context context) {
            this.O00000o0 = enb;
            this.O00000Oo = this.O00000o0.O000000o();
            this.f15644O000000o = new WeakReference<>(context);
        }

        /* access modifiers changed from: package-private */
        public void O000000o(Context context) {
            O000000o o000000o = this.O00000oO;
            if (o000000o != null) {
                o000000o.O000000o(context, O000000o());
            }
        }

        public abstract void O000000o(Context context, SQLiteDatabase sQLiteDatabase);

        public void O000000o(Context context, Object obj) {
            end.O000000o(context).O000000o(this);
        }

        public final boolean O00000Oo() {
            return this.O00000o0 == null || TextUtils.isEmpty(this.O00000Oo) || this.f15644O000000o == null;
        }

        public SQLiteDatabase O00000o0() {
            return this.O00000o0.getWritableDatabase();
        }

        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f15644O000000o;
            if (weakReference != null && (context = weakReference.get()) != null && context.getFilesDir() != null && this.O00000o0 != null && !TextUtils.isEmpty(this.O00000o)) {
                File file = new File(this.O00000o);
                new elc(context, new File(file.getParentFile(), emk.O00000Oo(file.getAbsolutePath())), new enf(this, context)).run();
            }
        }
    }

    public final void O000000o(O000000o o000000o) {
        enb enb;
        if (o000000o != null) {
            if (this.O00000Oo != null) {
                String str = o000000o.O00000o;
                synchronized (this.O00000o0) {
                    enb = this.O00000o0.get(str);
                    if (enb == null) {
                        enb = this.O00000Oo.O000000o();
                        this.O00000o0.put(str, enb);
                    }
                }
                if (!this.O00000o.isShutdown()) {
                    o000000o.O000000o(enb, this.f15643O000000o);
                    synchronized (this.O00000oo) {
                        this.O00000oo.add(o000000o);
                        O000000o();
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public final void O000000o(ArrayList<O000000o> arrayList) {
        if (this.O00000Oo != null) {
            HashMap hashMap = new HashMap();
            if (!this.O00000o.isShutdown()) {
                Iterator<O000000o> it = arrayList.iterator();
                while (it.hasNext()) {
                    O000000o next = it.next();
                    if (next.O00000Oo()) {
                        next.O000000o(O000000o(next.O00000o), this.f15643O000000o);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.O00000o);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.O00000o, arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        O00000o0 o00000o0 = new O00000o0(str, arrayList3);
                        o00000o0.O000000o(((O000000o) arrayList3.get(0)).O00000o0, this.f15643O000000o);
                        this.O00000o.execute(o00000o0);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }
}
