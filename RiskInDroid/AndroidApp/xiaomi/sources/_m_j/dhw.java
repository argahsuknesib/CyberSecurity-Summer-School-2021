package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class dhw extends SQLiteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f14651O000000o = "bugly_db";
    private static int O00000Oo = 13;
    private List<dgl> O00000o;
    private Context O00000o0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dhw(Context context, List<dgl> list) {
        super(context, f14651O000000o + "_", (SQLiteDatabase.CursorFactory) null, O00000Oo);
        dgs.O000000o(context).getClass();
        this.O00000o0 = context;
        this.O00000o = list;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm");
            sb.append(" int , _ut int , _tp");
            sb.append(" int , _dt blob , _pc");
            sb.append(" text ) ");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp");
            sb.append(" int , _tm int , _pc");
            sb.append(" text , _th text , _dt");
            sb.append(" blob ) ");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp");
            sb.append(" text , _tm int , _dt");
            sb.append(" blob,primary key(_id,_tp )) ");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm");
            sb.append(" int , _s1 text , _up");
            sb.append(" int , _me int , _uc");
            sb.append(" int , _dt blob ) ");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile");
            sb.append(" varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME");
            sb.append(" INTEGER)");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas");
            sb.append(" blob)");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp");
            sb.append(" text , _tm int , _dt");
            sb.append(" blob,primary key(_id,_tp )) ");
            did.O00000o0(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!did.O00000Oo(th)) {
                th.printStackTrace();
            }
        }
        if (this.O00000o != null) {
            Iterator<dgl> it = this.O00000o.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private synchronized boolean O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i = 0; i < 3; i++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i])), new String[0]);
            }
        } catch (Throwable th) {
            if (!did.O00000Oo(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0085, code lost:
        return;
     */
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        did.O00000o("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.O00000o != null) {
            for (dgl next : this.O00000o) {
                try {
                    next.O00000o0();
                    String[] O00000o02 = next.O00000o0();
                    for (int i3 = 0; i3 <= 0; i3++) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(O00000o02[0])));
                    }
                } catch (Throwable th) {
                    if (!did.O00000Oo(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (O000000o(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        did.O00000o("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.O00000o0.getDatabasePath(f14651O000000o);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008d, code lost:
        return;
     */
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (dgt.O00000o0() >= 11) {
            did.O00000o("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.O00000o != null) {
                for (dgl next : this.O00000o) {
                    try {
                        next.O00000o0();
                        String[] O00000o02 = next.O00000o0();
                        for (int i3 = 0; i3 <= 0; i3++) {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(O00000o02[0])));
                        }
                    } catch (Throwable th) {
                        if (!did.O00000Oo(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (O000000o(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            did.O00000o("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.O00000o0.getDatabasePath(f14651O000000o);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                did.O00000o("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    did.O00000oO("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                did.O00000o("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    did.O00000oO("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            did.O00000o("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }
}
