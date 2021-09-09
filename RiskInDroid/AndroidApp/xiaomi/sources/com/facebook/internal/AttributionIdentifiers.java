package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        Method methodQuietly;
        Object invokeMethodQuietly;
        try {
            if (!isGooglePlayServicesAvailable(context) || (methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class)) == null || (invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                return null;
            }
            Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", new Class[0]);
            Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (methodQuietly2 != null) {
                if (methodQuietly3 != null) {
                    AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                    attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                    attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0])).booleanValue();
                    return attributionIdentifiers;
                }
            }
            return null;
        } catch (Exception e) {
            Utility.logd("android_id", e);
            return null;
        }
    }

    public static boolean isTrackingLimited(Context context) {
        AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
        return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
    }

    private static boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
        return (invokeMethodQuietly instanceof Integer) && ((Integer) invokeMethodQuietly).intValue() == 0;
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd("android_id", e);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[Catch:{ Exception -> 0x00df, all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A[Catch:{ Exception -> 0x00df, all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078 A[Catch:{ Exception -> 0x00df, all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0102  */
    public static AttributionIdentifiers getAttributionIdentifiers(Context context) {
        Cursor cursor;
        Uri uri;
        String installerPackageName;
        Uri parse;
        AttributionIdentifiers androidId = getAndroidId(context);
        Cursor cursor2 = null;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
            } else if (recentlyFetchedIdentifiers != null && System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime < 3600000) {
                return recentlyFetchedIdentifiers;
            } else {
                String[] strArr = {"aid", "androidid", "limit_tracking"};
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                ProviderInfo resolveContentProvider2 = context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0);
                if (resolveContentProvider != null && FacebookSignatureValidator.validateSignature(context, resolveContentProvider.packageName)) {
                    parse = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                } else if (resolveContentProvider2 == null || !FacebookSignatureValidator.validateSignature(context, resolveContentProvider2.packageName)) {
                    uri = null;
                    installerPackageName = getInstallerPackageName(context);
                    if (installerPackageName != null) {
                        androidId.androidInstallerPackage = installerPackageName;
                    }
                    if (uri != null) {
                        return cacheAndReturnIdentifiers(androidId);
                    }
                    Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                int columnIndex = query.getColumnIndex("aid");
                                int columnIndex2 = query.getColumnIndex("androidid");
                                int columnIndex3 = query.getColumnIndex("limit_tracking");
                                androidId.attributionId = query.getString(columnIndex);
                                if (columnIndex2 > 0 && columnIndex3 > 0 && androidId.getAndroidAdvertiserId() == null) {
                                    androidId.androidAdvertiserId = query.getString(columnIndex2);
                                    androidId.limitTracking = Boolean.parseBoolean(query.getString(columnIndex3));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return cacheAndReturnIdentifiers(androidId);
                            }
                        } catch (Exception e) {
                            Exception exc = e;
                            cursor = query;
                            e = exc;
                            try {
                                Utility.logd(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            cursor2 = query;
                            th = th2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                    AttributionIdentifiers cacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
                    if (query != null) {
                        query.close();
                    }
                    return cacheAndReturnIdentifiers;
                } else {
                    parse = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                }
                uri = parse;
                installerPackageName = getInstallerPackageName(context);
                if (installerPackageName != null) {
                }
                if (uri != null) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
            Utility.logd(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static AttributionIdentifiers getCachedIdentifiers() {
        return recentlyFetchedIdentifiers;
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        if (!FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return null;
        }
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                return this.queue.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    static final class GoogleAdInfo implements IInterface {
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public final IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
