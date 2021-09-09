package _m_j;

import android.content.Context;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.File;
import java.io.IOException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;

public final class dtz {
    public static boolean O000000o(Context context, File file, File file2, String str) {
        try {
            if (!file.exists()) {
                return true;
            }
            File createTempFile = File.createTempFile("sql_cipher", "tmp", context.getCacheDir());
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), "", (SQLiteDatabase.CursorFactory) null, 0);
            openDatabase.rawExecSQL(String.format("ATTACH DATABASE '%s' AS encrypted KEY '%s';", createTempFile.getAbsolutePath(), str));
            openDatabase.rawExecSQL("SELECT sqlcipher_export('encrypted')");
            openDatabase.rawExecSQL("DETACH DATABASE encrypted;");
            int version = openDatabase.getVersion();
            openDatabase.close();
            SQLiteDatabase openDatabase2 = SQLiteDatabase.openDatabase(createTempFile.getAbsolutePath(), str, (SQLiteDatabase.CursorFactory) null, 0);
            openDatabase2.setVersion(version);
            openDatabase2.close();
            if (createTempFile.renameTo(file2)) {
                file.delete();
                AccountLog.i("SQLCipherManager", "migrate to encrypted database successful");
                return true;
            }
            throw new IOException(String.format("error rename file %s -> %s", createTempFile.toString(), file2.toString()));
        } catch (IOException e) {
            AccountLog.w("SQLCipherManager", "migrateToEncrypted() failed", e);
            if (eku.O000000o(context)) {
                throw new RuntimeException(e);
            }
            return false;
        } catch (SQLiteException e2) {
            AccountLog.w("SQLCipherManager", "migrateToEncrypted() failed", e2);
            if (eku.O000000o(context)) {
                throw e2;
            }
            return false;
        }
    }
}
