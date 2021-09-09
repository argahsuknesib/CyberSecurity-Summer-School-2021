package com.facebook.imagepipeline.cache;

import _m_j.kq;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.MediaVariations;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class MediaVariationsIndexDatabase implements MediaVariationsIndex {
    private static final long MILLIS_IN_FIVE_DAYS = TimeUnit.DAYS.toMillis(5);
    private static final long MILLIS_IN_ONE_DAY = TimeUnit.DAYS.toMillis(1);
    private static final String[] PROJECTION = {"cache_choice", "cache_key", "width", "height"};
    private static final String TAG = "MediaVariationsIndexDatabase";
    private final Clock mClock;
    private final LazyIndexDbOpenHelper mDbHelper;
    private long mLastTrimTimestamp;
    private final Executor mReadExecutor;
    private final Executor mWriteExecutor;

    public MediaVariationsIndexDatabase(Context context, Executor executor, Executor executor2, Clock clock) {
        this.mDbHelper = new LazyIndexDbOpenHelper(context);
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mClock = clock;
    }

    public kq<MediaVariations> getCachedVariants(final String str, final MediaVariations.Builder builder) {
        try {
            return kq.O000000o(new Callable<MediaVariations>() {
                /* class com.facebook.imagepipeline.cache.MediaVariationsIndexDatabase.AnonymousClass1 */

                public MediaVariations call() throws Exception {
                    return MediaVariationsIndexDatabase.this.getCachedVariantsSync(str, builder);
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule query task for %s", str);
            return kq.O000000o(e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a A[SYNTHETIC, Splitter:B:43:0x009a] */
    @VisibleForTesting
    public MediaVariations getCachedVariantsSync(String str, MediaVariations.Builder builder) {
        ImageRequest.CacheChoice cacheChoice;
        MediaVariations.Builder builder2;
        synchronized (MediaVariationsIndexDatabase.class) {
            Cursor cursor = null;
            try {
                Cursor cursor2 = this.mDbHelper.getWritableDatabase().query("media_variations_index", PROJECTION, "media_id = ?", new String[]{str}, null, null, null);
                try {
                    if (cursor2.getCount() == 0) {
                        MediaVariations build = builder.build();
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    } else {
                        int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("cache_key");
                        int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("width");
                        int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("height");
                        int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow("cache_choice");
                        while (cursor2.moveToNext()) {
                            String string = cursor2.getString(columnIndexOrThrow4);
                            Uri parse = Uri.parse(cursor2.getString(columnIndexOrThrow));
                            int i = cursor2.getInt(columnIndexOrThrow2);
                            int i2 = cursor2.getInt(columnIndexOrThrow3);
                            if (TextUtils.isEmpty(string)) {
                                builder2 = builder;
                                cacheChoice = null;
                            } else {
                                cacheChoice = ImageRequest.CacheChoice.valueOf(string);
                                builder2 = builder;
                            }
                            builder2.addVariant(parse, i, i2, cacheChoice);
                        }
                        MediaVariations.Builder builder3 = builder;
                        MediaVariations build2 = builder.build();
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    }
                } catch (SQLException e) {
                    e = e;
                    cursor = cursor2;
                    try {
                        FLog.e(TAG, e, "Error reading for %s", str);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                FLog.e(TAG, e, "Error reading for %s", str);
                throw e;
            }
        }
    }

    public void saveCachedVariant(String str, ImageRequest.CacheChoice cacheChoice, CacheKey cacheKey, EncodedImage encodedImage) {
        final String str2 = str;
        final ImageRequest.CacheChoice cacheChoice2 = cacheChoice;
        final CacheKey cacheKey2 = cacheKey;
        final EncodedImage encodedImage2 = encodedImage;
        this.mWriteExecutor.execute(new Runnable() {
            /* class com.facebook.imagepipeline.cache.MediaVariationsIndexDatabase.AnonymousClass2 */

            public void run() {
                MediaVariationsIndexDatabase.this.saveCachedVariantSync(str2, cacheChoice2, cacheKey2, encodedImage2);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|19|20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|4|(4:5|6|(1:8)|9)|10|11|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x009c */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0097=Splitter:B:16:0x0097, B:21:0x009c=Splitter:B:21:0x009c} */
    public void saveCachedVariantSync(String str, ImageRequest.CacheChoice cacheChoice, CacheKey cacheKey, EncodedImage encodedImage) {
        synchronized (MediaVariationsIndexDatabase.class) {
            SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
            long now = this.mClock.now();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("media_id", str);
                contentValues.put("width", Integer.valueOf(encodedImage.getWidth()));
                contentValues.put("height", Integer.valueOf(encodedImage.getHeight()));
                contentValues.put("cache_choice", cacheChoice.name());
                contentValues.put("cache_key", cacheKey.getUriString());
                contentValues.put("resource_id", CacheKeyUtil.getFirstResourceId(cacheKey));
                contentValues.put("date", Long.valueOf(now));
                writableDatabase.replaceOrThrow("media_variations_index", null, contentValues);
                if (this.mLastTrimTimestamp <= now - MILLIS_IN_ONE_DAY) {
                    writableDatabase.delete("media_variations_index", "date < ?", new String[]{Long.toString(now - MILLIS_IN_FIVE_DAYS)});
                    this.mLastTrimTimestamp = now;
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                try {
                    FLog.e(TAG, e, "Error writing for %s", str);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.endTransaction();
        }
    }

    static final class IndexEntry implements BaseColumns {
        private IndexEntry() {
        }
    }

    static class LazyIndexDbOpenHelper {
        private final Context mContext;
        private IndexDbOpenHelper mIndexDbOpenHelper;

        private LazyIndexDbOpenHelper(Context context) {
            this.mContext = context;
        }

        public synchronized SQLiteDatabase getWritableDatabase() {
            if (this.mIndexDbOpenHelper == null) {
                this.mIndexDbOpenHelper = new IndexDbOpenHelper(this.mContext);
            }
            return this.mIndexDbOpenHelper.getWritableDatabase();
        }
    }

    static class IndexDbOpenHelper extends SQLiteOpenHelper {
        public IndexDbOpenHelper(Context context) {
            super(context, "FrescoMediaVariationsIndex.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("CREATE TABLE media_variations_index (_id INTEGER PRIMARY KEY,media_id TEXT,width INTEGER,height INTEGER,cache_choice TEXT,cache_key TEXT,resource_id TEXT UNIQUE,date INTEGER )");
                sQLiteDatabase.execSQL("CREATE INDEX index_media_id ON media_variations_index (media_id)");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }

        /* JADX INFO: finally extract failed */
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_variations_index");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
