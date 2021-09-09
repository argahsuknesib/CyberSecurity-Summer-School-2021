package _m_j;

import _m_j.end;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

final class enf implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15650O000000o;
    final /* synthetic */ end.O000000o O00000Oo;

    enf(end.O000000o o000000o, Context context) {
        this.O00000Oo = o000000o;
        this.f15650O000000o = context;
    }

    public final void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase O00000o0 = this.O00000Oo.O00000o0();
            if (O00000o0 != null && O00000o0.isOpen()) {
                O00000o0.beginTransaction();
                this.O00000Oo.O000000o(this.f15650O000000o, O00000o0);
                O00000o0.setTransactionSuccessful();
            }
            if (O00000o0 != null) {
                try {
                    O00000o0.endTransaction();
                } catch (Exception e) {
                    e = e;
                    duv.O000000o(e);
                    this.O00000Oo.O000000o(this.f15650O000000o);
                }
            }
            if (this.O00000Oo.O00000o0 != null) {
                this.O00000Oo.O00000o0.close();
            }
        } catch (Exception e2) {
            duv.O000000o(e2);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    e = e3;
                    duv.O000000o(e);
                    this.O00000Oo.O000000o(this.f15650O000000o);
                }
            }
            if (this.O00000Oo.O00000o0 != null) {
                this.O00000Oo.O00000o0.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    duv.O000000o(e4);
                    this.O00000Oo.O000000o(this.f15650O000000o);
                    throw th;
                }
            }
            if (this.O00000Oo.O00000o0 != null) {
                this.O00000Oo.O00000o0.close();
            }
            this.O00000Oo.O000000o(this.f15650O000000o);
            throw th;
        }
        this.O00000Oo.O000000o(this.f15650O000000o);
    }
}
