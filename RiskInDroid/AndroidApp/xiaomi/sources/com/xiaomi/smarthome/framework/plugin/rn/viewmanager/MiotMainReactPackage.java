package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fwy;
import _m_j.hkd;
import _m_j.icf;
import _m_j.icp;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.image.GlobalImageLoadListener;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.image.ReactImageView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.File;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MiotMainReactPackage extends MainReactPackage {

    /* renamed from: O000000o  reason: collision with root package name */
    fwy.O00000Oo f8499O000000o;

    class MiotReactImageView extends ReactImageView {
        boolean mFiltered = false;

        public MiotReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
            super(context, abstractDraweeControllerBuilder, globalImageLoadListener, obj);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            if (this.mFiltered) {
                getDrawable().setFilterBitmap(false);
                this.mFiltered = false;
            }
            super.onDraw(canvas);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f8500O000000o;

        private O000000o() {
            this.f8500O000000o = false;
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        static void O000000o(CookieManager cookieManager, String str, String str2, String str3) {
            if (str2 != null) {
                cookieManager.setCookie(str3, str + "=" + str2 + "; domain=" + str3);
            }
        }
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        HttpCookie O000000o2;
        O000000o o000000o = new O000000o((byte) 0);
        if (!o000000o.f8500O000000o) {
            o000000o.f8500O000000o = true;
            CookieSyncManager.createInstance(reactApplicationContext);
            CookieManager instance = CookieManager.getInstance();
            String O0000oO = CoreApi.O000000o().O0000oO();
            if (TextUtils.isEmpty(O0000oO) && (O000000o2 = icp.O000000o(icf.O000000o().f1176O000000o, "passToken", "")) != null) {
                O0000oO = O000000o2.getValue();
            }
            if (!TextUtils.isEmpty(O0000oO)) {
                O000000o.O000000o(instance, "passToken", O0000oO, ".account.xiaomi.com");
            }
            hkd.O000000o(instance, ".home.mi.com");
            hkd.O000000o(instance, ".account.xiaomi.com");
            hkd.O000000o(reactApplicationContext, instance);
            try {
                MiServiceTokenInfo O000000o3 = CoreApi.O000000o().O000000o("xiaomiio");
                if (O000000o3 != null) {
                    O000000o.O000000o(instance, "serviceToken", URLEncoder.encode(O000000o3.O00000o0, "UTF-8"), ".io.mi.com");
                }
                MiServiceTokenInfo O000000o4 = CoreApi.O000000o().O000000o("xiaomihome");
                if (O000000o4 != null) {
                    O000000o.O000000o(instance, "serviceToken", URLEncoder.encode(O000000o4.O00000o0, "UTF-8"), ".home.mi.com");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ArrayList<Pair> arrayList = new ArrayList<>();
        List<ViewManager> createViewManagers = super.createViewManagers(reactApplicationContext);
        for (ViewManager next : createViewManagers) {
            if (next instanceof ReactImageManager) {
                arrayList.add(new Pair(next, new ReactImageManager() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MiotMainReactPackage.AnonymousClass1 */

                    public ReactImageView createViewInstance(ThemedReactContext themedReactContext) {
                        return new MiotReactImageView(themedReactContext, getDraweeControllerBuilder(), null, getCallerContext()) {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MiotMainReactPackage.AnonymousClass1.AnonymousClass1 */
                        };
                    }

                    public void setResizeMode(ReactImageView reactImageView, String str) {
                        if ((reactImageView instanceof MiotReactImageView) && "stretch".equalsIgnoreCase(str)) {
                            ((MiotReactImageView) reactImageView).mFiltered = true;
                        }
                        super.setResizeMode(reactImageView, str);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
                    public void setSource(ReactImageView reactImageView, ReadableArray readableArray) {
                        HashMap<String, Object> hashMap;
                        if (readableArray != null && readableArray.size() > 0 && readableArray.getType(0) == ReadableType.Map) {
                            ReadableMap map = readableArray.getMap(0);
                            HashMap<String, Object> hashMap2 = null;
                            if (map.hasKey("uri")) {
                                String string = map.getString("uri");
                                if (string != null && string.startsWith("/")) {
                                    hashMap = map.toHashMap();
                                    hashMap.put("uri", "file://".concat(String.valueOf(string)));
                                }
                                if (hashMap2 != null) {
                                    ArrayList<Object> arrayList = readableArray.toArrayList();
                                    arrayList.remove(0);
                                    arrayList.add(0, hashMap2);
                                    readableArray = Arguments.makeNativeArray((List) arrayList);
                                }
                            } else {
                                if (map.hasKey("local")) {
                                    String string2 = map.getString("local");
                                    hashMap = map.toHashMap();
                                    hashMap.remove("local");
                                    hashMap.put("uri", "file://" + new File(MiotMainReactPackage.this.f8499O000000o.O000000o(), string2).getAbsolutePath());
                                }
                                if (hashMap2 != null) {
                                }
                            }
                            hashMap2 = hashMap;
                            if (hashMap2 != null) {
                            }
                        }
                        reactImageView.setSource(readableArray);
                    }
                }));
            }
        }
        for (Pair pair : arrayList) {
            createViewManagers.remove(pair.first);
            createViewManagers.add(pair.second);
        }
        return createViewManagers;
    }
}
