package com.mibi.sdk.common.storage;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

public class UserStorage {
    private Context mContext;
    private StorageDir mRootDir;
    private String mUserId;

    private UserStorage(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mUserId = str;
        File filesDir = context.getFilesDir();
        this.mRootDir = new StorageDir(filesDir, "users" + File.separator + str);
    }

    public static UserStorage newUserStorage(Context context, String str) {
        return new UserStorage(context, str);
    }

    public StorageDir getStorageDir() {
        return this.mRootDir;
    }

    public StorageDir getStorageDir(String str) {
        return new StorageDir(this.mRootDir, str);
    }

    public SharedPreferences getPreference() {
        return this.mContext.getSharedPreferences(this.mUserId, 0);
    }

    public SharedPreferences getPreference(String str) {
        Context context = this.mContext;
        return context.getSharedPreferences(this.mUserId + "_" + str, 0);
    }
}
