package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseActivityLifecycleTracker {
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker";
    private static Application.ActivityLifecycleCallbacks callbacks;
    public static Boolean hasBiillingActivity = null;
    private static Boolean hasBillingService = null;
    public static Object inAppBillingObj;
    private static Intent intent;
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);
    private static ServiceConnection serviceConnection;

    public static void update() {
        initializeIfNotInitialized();
        if (hasBillingService.booleanValue() && AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            startTracking();
        }
    }

    private static void initializeIfNotInitialized() {
        if (hasBillingService == null) {
            try {
                Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                hasBillingService = Boolean.TRUE;
                try {
                    Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                    hasBiillingActivity = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    hasBiillingActivity = Boolean.FALSE;
                }
                InAppPurchaseEventManager.clearSkuDetailsCache();
                intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                serviceConnection = new ServiceConnection() {
                    /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass1 */

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), iBinder);
                    }
                };
                callbacks = new Application.ActivityLifecycleCallbacks() {
                    /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass2 */

                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public final void onActivityDestroyed(Activity activity) {
                    }

                    public final void onActivityPaused(Activity activity) {
                    }

                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public final void onActivityStarted(Activity activity) {
                    }

                    public final void onActivityResumed(Activity activity) {
                        try {
                            FacebookSdk.getExecutor().execute(new Runnable() {
                                /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass2.AnonymousClass1 */

                                public void run() {
                                    Context applicationContext = FacebookSdk.getApplicationContext();
                                    InAppPurchaseActivityLifecycleTracker.logPurchase(applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj), false);
                                    InAppPurchaseActivityLifecycleTracker.logPurchase(applicationContext, InAppPurchaseEventManager.getPurchasesSubs(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj), true);
                                }
                            });
                        } catch (Exception unused) {
                        }
                    }

                    public final void onActivityStopped(Activity activity) {
                        try {
                            if (InAppPurchaseActivityLifecycleTracker.hasBiillingActivity.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
                                FacebookSdk.getExecutor().execute(new Runnable() {
                                    /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass2.AnonymousClass2 */

                                    public void run() {
                                        Context applicationContext = FacebookSdk.getApplicationContext();
                                        ArrayList<String> purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                                        if (purchasesInapp.isEmpty()) {
                                            purchasesInapp = InAppPurchaseEventManager.getPurchaseHistoryInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                                        }
                                        InAppPurchaseActivityLifecycleTracker.logPurchase(applicationContext, purchasesInapp, false);
                                    }
                                });
                            }
                        } catch (Exception unused) {
                        }
                    }
                };
            } catch (ClassNotFoundException unused2) {
                hasBillingService = Boolean.FALSE;
            }
        }
    }

    private static void startTracking() {
        if (isTracking.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(callbacks);
                applicationContext.bindService(intent, serviceConnection, 1);
            }
        }
    }

    public static void logPurchase(Context context, ArrayList<String> arrayList, boolean z) {
        if (!arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    String string = new JSONObject(next).getString("productId");
                    hashMap.put(string, next);
                    arrayList2.add(string);
                } catch (JSONException e) {
                    Log.e(TAG, "Error parsing in-app purchase data.", e);
                }
            }
            for (Map.Entry next2 : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, z).entrySet()) {
                AutomaticAnalyticsLogger.logPurchase((String) hashMap.get(next2.getKey()), (String) next2.getValue(), z);
            }
        }
    }
}
