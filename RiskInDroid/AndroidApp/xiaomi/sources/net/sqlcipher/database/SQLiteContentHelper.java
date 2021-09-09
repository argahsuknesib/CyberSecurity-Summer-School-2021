package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import net.sqlcipher.Cursor;

public class SQLiteContentHelper {
    public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor;
        try {
            MemoryFile simpleQueryForBlobMemoryFile = simpleQueryForBlobMemoryFile(sQLiteDatabase, str, strArr);
            if (simpleQueryForBlobMemoryFile != null) {
                try {
                    Method declaredMethod = simpleQueryForBlobMemoryFile.getClass().getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
                    declaredMethod.setAccessible(true);
                    parcelFileDescriptor = (ParcelFileDescriptor) declaredMethod.invoke(simpleQueryForBlobMemoryFile, new Object[0]);
                } catch (Exception e) {
                    Log.i("SQLiteContentHelper", "SQLiteCursor.java: ".concat(String.valueOf(e)));
                    parcelFileDescriptor = null;
                }
                return new AssetFileDescriptor(parcelFileDescriptor, 0, (long) simpleQueryForBlobMemoryFile.length());
            }
            throw new FileNotFoundException("No results.");
        } catch (IOException e2) {
            throw new FileNotFoundException(e2.toString());
        }
    }

    private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws IOException {
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        if (rawQuery == null) {
            return null;
        }
        try {
            if (!rawQuery.moveToFirst()) {
                return null;
            }
            byte[] blob = rawQuery.getBlob(0);
            if (blob == null) {
                rawQuery.close();
                return null;
            }
            MemoryFile memoryFile = new MemoryFile(null, blob.length);
            memoryFile.writeBytes(blob, 0, 0, blob.length);
            rawQuery.close();
            return memoryFile;
        } finally {
            rawQuery.close();
        }
    }
}
