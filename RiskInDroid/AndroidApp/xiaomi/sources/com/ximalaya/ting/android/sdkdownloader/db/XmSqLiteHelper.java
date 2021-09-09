package com.ximalaya.ting.android.sdkdownloader.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Locale;

class XmSqLiteHelper extends SQLiteOpenHelper {
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public XmSqLiteHelper(Context context) {
        super(context, "xm_download_db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static String O000000o(String str) {
        return str.toLowerCase(Locale.US);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table Track (id integer primary key autoincrement,trackTitle text, trackTags text, trackIntro text, coverUrlLarge text, coverUrlMiddle text, coverUrlSmall text, playUrl64M4a text, downloadUrl text, downloadedSaveFilePath text, playUrl64 text, playUrl32 text, playUrl24M4a text, playSize64m4a text, playSize24M4a text, playPathHq text, updatedAt integer, uid integer default 0, createdAt integer, discountedPrice real default 0, downloadSize integer,  price real default 0, downloadTime integer, downloadedSize integer, duration integer, favoriteCount integer, free integer default 1, priceTypeId integer default 1, playSize64 integer, playSize32 integer, downloadStatus integer, downloadCount integer, isAutoPaused integer, playCount integer, orderPositon integer, commentCount integer, source integer, orderNum integer, authorized integer default 0,isPaid integer default 0, isLike integer, kind text, lastPlayedMills integer, dataId integer ,vsignature text, announcerPosition text, avatarUrl text, vdesc text, nickname text, annoucer_kind text, followingCount integer, releasedAlbumCount integer, releasedTrackCount integer, vCategoryId integer, followerCount integer, announcerId integer, verified integer ,albumTitle text, album_coverUrlLarge text, album_coverUrlMiddle text, album_coverUrlSmall text, albumId integer, uptoDateTime integer ,finishdownloadtime)".toLowerCase(Locale.US));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
