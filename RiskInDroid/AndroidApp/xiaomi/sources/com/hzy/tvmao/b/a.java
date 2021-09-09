package com.hzy.tvmao.b;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.hzy.tvmao.u;
import com.hzy.tvmao.utils.LogUtil;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected static HashMap<String, b> f4409a = new HashMap<>();
    /* access modifiers changed from: private */
    public static ExecutorService b = Executors.newFixedThreadPool(5);

    public interface c {
        void a(com.hzy.tvmao.b.a.a aVar);
    }

    /* renamed from: com.hzy.tvmao.b.a$a  reason: collision with other inner class name */
    public abstract class C0035a extends b {
        public C0035a(c cVar, String str) {
            super(cVar, str);
        }

        public void a() {
            if (a.this.a()) {
                super.a();
            } else {
                onPostExecute((com.hzy.tvmao.b.a.a) null);
            }
        }
    }

    public abstract class b extends AsyncTask<Void, Integer, com.hzy.tvmao.b.a.a> {
        public c b;
        public String c;

        /* access modifiers changed from: protected */
        public abstract com.hzy.tvmao.b.a.a b();

        public b(c cVar, String str) {
            if (cVar != null) {
                this.b = cVar;
                this.c = str;
                a.f4409a.put(this.c, this);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final com.hzy.tvmao.b.a.a doInBackground(Void... voidArr) {
            try {
                return b();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @SuppressLint({"NewApi"})
        public void a() {
            LogUtil.i("Running Task ======> " + this.c);
            if (u.g < 11) {
                execute(new Void[0]);
            } else {
                executeOnExecutor(a.b, new Void[0]);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(com.hzy.tvmao.b.a.a aVar) {
            if (aVar == null) {
                aVar = new com.hzy.tvmao.b.a.a(0);
            }
            try {
                aVar.a(this.c);
                if (this.b != null) {
                    this.b.a(aVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.f4409a.remove(this);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            LogUtil.i("Task: " + this.c + " Has been cancled");
            super.onCancelled();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return com.hzy.tvmao.utils.b.a();
    }
}
