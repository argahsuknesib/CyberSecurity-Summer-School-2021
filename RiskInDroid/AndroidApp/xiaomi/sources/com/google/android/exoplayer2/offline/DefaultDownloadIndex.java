package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.offline.DownloadCursor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDownloadIndex implements WritableDownloadIndex {
    private static final String[] COLUMNS = {"id", "title", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"};
    private static final String WHERE_STATE_IS_TERMINAL = getStateQuery(3, 4);
    private final DatabaseProvider databaseProvider;
    private boolean initialized;
    private final String name;
    private final String tableName;

    public DefaultDownloadIndex(DatabaseProvider databaseProvider2) {
        this(databaseProvider2, "");
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider2, String str) {
        this.name = str;
        this.databaseProvider = databaseProvider2;
        this.tableName = "ExoPlayerDownloads".concat(String.valueOf(str));
    }

    public final Download getDownload(String str) throws DatabaseIOException {
        Cursor cursor;
        ensureInitialized();
        try {
            cursor = getCursor("id = ?", new String[]{str});
            if (cursor.getCount() == 0) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            cursor.moveToNext();
            Download downloadForCurrentRow = getDownloadForCurrentRow(cursor);
            if (cursor != null) {
                cursor.close();
            }
            return downloadForCurrentRow;
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        } catch (Throwable th) {
            r0.addSuppressed(th);
        }
        throw th;
    }

    public final DownloadCursor getDownloads(int... iArr) throws DatabaseIOException {
        ensureInitialized();
        return new DownloadCursorImpl(getCursor(getStateQuery(iArr), null));
    }

    public final void putDownload(Download download) throws DatabaseIOException {
        ensureInitialized();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.request.id);
        contentValues.put("title", download.request.type);
        contentValues.put("uri", download.request.uri.toString());
        contentValues.put("stream_keys", encodeStreamKeys(download.request.streamKeys));
        contentValues.put("custom_cache_key", download.request.customCacheKey);
        contentValues.put("data", download.request.data);
        contentValues.put("state", Integer.valueOf(download.state));
        contentValues.put("start_time_ms", Long.valueOf(download.startTimeMs));
        contentValues.put("update_time_ms", Long.valueOf(download.updateTimeMs));
        contentValues.put("content_length", Long.valueOf(download.contentLength));
        contentValues.put("stop_reason", Integer.valueOf(download.stopReason));
        contentValues.put("failure_reason", Integer.valueOf(download.failureReason));
        contentValues.put("percent_downloaded", Float.valueOf(download.getPercentDownloaded()));
        contentValues.put("bytes_downloaded", Long.valueOf(download.getBytesDownloaded()));
        try {
            this.databaseProvider.getWritableDatabase().replaceOrThrow(this.tableName, null, contentValues);
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    public final void removeDownload(String str) throws DatabaseIOException {
        ensureInitialized();
        try {
            this.databaseProvider.getWritableDatabase().delete(this.tableName, "id = ?", new String[]{str});
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final void setDownloadingStatesToQueued() throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues, "state = 2", null);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final void setStatesToRemoving() throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues, null, null);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public final void setStopReason(int i) throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues, WHERE_STATE_IS_TERMINAL, null);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public final void setStopReason(String str, int i) throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str2 = this.tableName;
            writableDatabase.update(str2, contentValues, WHERE_STATE_IS_TERMINAL + " AND id = ?", new String[]{str});
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    private void ensureInitialized() throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        if (!this.initialized) {
            try {
                if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 0, this.name) != 2) {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    VersionTable.setVersion(writableDatabase, 0, this.name, 2);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.tableName);
                    writableDatabase.execSQL("CREATE TABLE " + this.tableName + " (id TEXT PRIMARY KEY NOT NULL,title TEXT NOT NULL,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                this.initialized = true;
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    private Cursor getCursor(String str, String[] strArr) throws DatabaseIOException {
        try {
            return this.databaseProvider.getReadableDatabase().query(this.tableName, COLUMNS, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    private static String getStateQuery(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state IN (");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(iArr[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    public static Download getDownloadForCurrentRow(Cursor cursor) {
        DownloadRequest downloadRequest = new DownloadRequest(cursor.getString(0), cursor.getString(1), Uri.parse(cursor.getString(2)), decodeStreamKeys(cursor.getString(3)), cursor.getString(4), cursor.getBlob(5));
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new Download(downloadRequest, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    private static String encodeStreamKeys(List<StreamKey> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            StreamKey streamKey = list.get(i);
            sb.append(streamKey.periodIndex);
            sb.append('.');
            sb.append(streamKey.groupIndex);
            sb.append('.');
            sb.append(streamKey.trackIndex);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static List<StreamKey> decodeStreamKeys(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.isEmpty()) {
            return arrayList;
        }
        for (String split : Util.split(str, ",")) {
            String[] split2 = Util.split(split, "\\.");
            Assertions.checkState(split2.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), Integer.parseInt(split2[2])));
        }
        return arrayList;
    }

    static final class DownloadCursorImpl implements DownloadCursor {
        private final Cursor cursor;

        public /* synthetic */ boolean isAfterLast() {
            return DownloadCursor.CC.$default$isAfterLast(this);
        }

        public /* synthetic */ boolean isBeforeFirst() {
            return DownloadCursor.CC.$default$isBeforeFirst(this);
        }

        public /* synthetic */ boolean isFirst() {
            return DownloadCursor.CC.$default$isFirst(this);
        }

        public /* synthetic */ boolean isLast() {
            return DownloadCursor.CC.$default$isLast(this);
        }

        public /* synthetic */ boolean moveToFirst() {
            return DownloadCursor.CC.$default$moveToFirst(this);
        }

        public /* synthetic */ boolean moveToLast() {
            return DownloadCursor.CC.$default$moveToLast(this);
        }

        public /* synthetic */ boolean moveToNext() {
            return DownloadCursor.CC.$default$moveToNext(this);
        }

        public /* synthetic */ boolean moveToPrevious() {
            return DownloadCursor.CC.$default$moveToPrevious(this);
        }

        private DownloadCursorImpl(Cursor cursor2) {
            this.cursor = cursor2;
        }

        public final Download getDownload() {
            return DefaultDownloadIndex.getDownloadForCurrentRow(this.cursor);
        }

        public final int getCount() {
            return this.cursor.getCount();
        }

        public final int getPosition() {
            return this.cursor.getPosition();
        }

        public final boolean moveToPosition(int i) {
            return this.cursor.moveToPosition(i);
        }

        public final void close() {
            this.cursor.close();
        }

        public final boolean isClosed() {
            return this.cursor.isClosed();
        }
    }
}
