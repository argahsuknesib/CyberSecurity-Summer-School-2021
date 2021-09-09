package com.mibi.sdk.common.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.mibi.sdk.common.account.AccountUtils;
import com.mibi.sdk.common.account.loader.AccountLoader;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.storage.StorageDir;
import com.mibi.sdk.common.storage.UserStorage;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Session {
    private final AccountLoader mAccountLoader;
    private final ConcurrentHashMap<String, Object> mLockMap = new ConcurrentHashMap<>();
    private final MemoryStorage mMemoryStorage;
    private volatile Boolean mSessionClosed = Boolean.FALSE;
    private volatile int mSessionClosedCode;
    private volatile String mSessionClosedMessage;
    private volatile long mTimeStamp;
    private final UserStorage mUserStorage;
    private final String mUuid;
    private final Context sApplicationContext;

    Session(Context context, AccountLoader accountLoader) {
        this.sApplicationContext = context.getApplicationContext();
        this.mAccountLoader = accountLoader;
        this.mUuid = UUID.randomUUID().toString();
        this.mTimeStamp = System.currentTimeMillis();
        this.mUserStorage = UserStorage.newUserStorage(this.sApplicationContext, accountLoader.getUserId());
        this.mMemoryStorage = MemoryStorage.newMemoryStorage();
    }

    Session(Context context, SessionSaveData sessionSaveData) {
        this.sApplicationContext = context.getApplicationContext();
        this.mAccountLoader = sessionSaveData.mAccountLoader;
        this.mUuid = sessionSaveData.mUuid;
        this.mSessionClosed = Boolean.valueOf(sessionSaveData.mSessionClosed);
        this.mSessionClosedCode = sessionSaveData.mSessionClosedCode;
        this.mSessionClosedMessage = sessionSaveData.mSessionClosedMessage;
        this.mTimeStamp = sessionSaveData.mTimeStamp;
        this.mUserStorage = UserStorage.newUserStorage(this.sApplicationContext, this.mAccountLoader.getUserId());
        this.mMemoryStorage = sessionSaveData.mMemoryStorage;
    }

    static SessionSaveData saveSession(Session session) {
        SessionSaveData sessionSaveData;
        if (session != null) {
            synchronized (session) {
                session.mTimeStamp = System.currentTimeMillis();
                sessionSaveData = new SessionSaveData();
                sessionSaveData.mAccountLoader = session.mAccountLoader;
                sessionSaveData.mUuid = session.mUuid;
                sessionSaveData.mSessionClosed = session.mSessionClosed.booleanValue();
                sessionSaveData.mSessionClosedCode = session.mSessionClosedCode;
                sessionSaveData.mSessionClosedMessage = session.mSessionClosedMessage;
                sessionSaveData.mTimeStamp = session.mTimeStamp;
                sessionSaveData.mMemoryStorage = session.mMemoryStorage;
                Log.v("Session", "session " + session.mUuid + " saved at " + session.mTimeStamp);
            }
            return sessionSaveData;
        }
        throw new IllegalArgumentException("session to save is null");
    }

    /* access modifiers changed from: package-private */
    public void update(SessionSaveData sessionSaveData) {
        getMemoryStorage().update(sessionSaveData.mMemoryStorage);
        this.mSessionClosed = Boolean.valueOf(sessionSaveData.mSessionClosed);
        this.mSessionClosedCode = sessionSaveData.mSessionClosedCode;
        this.mSessionClosedMessage = sessionSaveData.mSessionClosedMessage;
        this.mTimeStamp = sessionSaveData.mTimeStamp;
    }

    public Object getLock(String str) {
        Object obj = this.mLockMap.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = new Object();
        Object putIfAbsent = this.mLockMap.putIfAbsent(str, obj2);
        return putIfAbsent == null ? obj2 : putIfAbsent;
    }

    public void load(Context context) throws PaymentException {
        this.mAccountLoader.load(context);
    }

    public void reload(Context context) throws PaymentException {
        this.mAccountLoader.reload(context);
    }

    public boolean isAccountChanged() {
        return this.mAccountLoader.isAccountChanged(this.sApplicationContext);
    }

    public synchronized void closeSession(int i, String str) {
        this.mSessionClosed = Boolean.TRUE;
        this.mSessionClosedCode = i;
        this.mSessionClosedMessage = str;
    }

    public boolean isSessionClosed() {
        return this.mSessionClosed.booleanValue();
    }

    public int getSessionClosedCode() {
        return this.mSessionClosedCode;
    }

    public String getSessionClosedMessage() {
        return this.mSessionClosedMessage;
    }

    public AccountLoader getAccountLoader() {
        return this.mAccountLoader;
    }

    public boolean isFakeAccountLoader() {
        return AccountUtils.getCurrentAccountLoader() instanceof FakeAccountLoader;
    }

    public String getUserId() {
        return getAccountLoader().getUserId();
    }

    public String getUuid() {
        return this.mUuid;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public Context getAppContext() {
        return this.sApplicationContext;
    }

    public StorageDir getUserStorage() {
        return this.mUserStorage.getStorageDir();
    }

    public StorageDir getUserStorage(String str) {
        return this.mUserStorage.getStorageDir(str);
    }

    public SharedPreferences getUserPreferences() {
        return this.mUserStorage.getPreference();
    }

    public SharedPreferences getUserPreferences(String str) {
        return this.mUserStorage.getPreference(str);
    }

    public MemoryStorage getMemoryStorage() {
        return this.mMemoryStorage;
    }

    public static final class SessionSaveData implements Parcelable {
        public static final Parcelable.Creator<SessionSaveData> CREATOR = new Parcelable.Creator<SessionSaveData>() {
            /* class com.mibi.sdk.common.session.Session.SessionSaveData.AnonymousClass1 */

            public final SessionSaveData[] newArray(int i) {
                return new SessionSaveData[i];
            }

            public final SessionSaveData createFromParcel(Parcel parcel) {
                SessionSaveData sessionSaveData = new SessionSaveData();
                sessionSaveData.mAccountLoader = (AccountLoader) parcel.readParcelable(AccountLoader.class.getClassLoader());
                sessionSaveData.mUuid = parcel.readString();
                sessionSaveData.mSessionClosed = parcel.readByte() != 0;
                sessionSaveData.mSessionClosedCode = parcel.readInt();
                sessionSaveData.mSessionClosedMessage = parcel.readString();
                sessionSaveData.mTimeStamp = parcel.readLong();
                sessionSaveData.mMemoryStorage = MemoryStorage.newMemoryStorage();
                sessionSaveData.mMemoryStorage.readFromParcel(parcel);
                return sessionSaveData;
            }
        };
        AccountLoader mAccountLoader;
        MemoryStorage mMemoryStorage;
        boolean mSessionClosed;
        int mSessionClosedCode;
        String mSessionClosedMessage;
        long mTimeStamp;
        String mUuid;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mAccountLoader, i);
            parcel.writeString(this.mUuid);
            parcel.writeByte(this.mSessionClosed ? (byte) 1 : 0);
            parcel.writeInt(this.mSessionClosedCode);
            parcel.writeString(this.mSessionClosedMessage);
            parcel.writeLong(this.mTimeStamp);
            this.mMemoryStorage.writeToParcel(parcel);
        }
    }
}
