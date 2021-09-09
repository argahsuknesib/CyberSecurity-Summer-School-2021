package com.sdu.didi.openapi.location;

import _m_j.gsy;
import android.content.Context;
import android.os.Looper;
import com.sdu.didi.openapi.location.LocationHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SosoSdk extends SdkHub {
    private Context context;
    private Object soso;
    private Class sosoManage;
    private Object sosoObject;

    public SosoSdk(Context context2) {
        gsy.O000000o(6, "LocationSDK", "SOSO");
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public Location parseLocation(Object obj) {
        Location location = new Location();
        try {
            Class<?> cls = Class.forName("com.tencent.map.geolocation.TencentLocation");
            double doubleValue = ((Double) cls.getMethod("getLatitude", new Class[0]).invoke(obj, new Object[0])).doubleValue();
            double doubleValue2 = ((Double) cls.getMethod("getLongitude", new Class[0]).invoke(obj, new Object[0])).doubleValue();
            location.setLat(String.valueOf(doubleValue));
            location.setLng(String.valueOf(doubleValue2));
            location.setMapType("soso");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        return location;
    }

    public void registListener(Looper looper, final LocationHelper.LocationListener locationListener) {
        try {
            this.sosoManage = Class.forName("com.tencent.map.geolocation.TencentLocationManager");
            this.sosoObject = this.sosoManage.getMethod("getInstance", Context.class).invoke(this.sosoManage, this.context);
            Class<?> cls = Class.forName("com.tencent.map.geolocation.TencentLocationListener");
            this.soso = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                /* class com.sdu.didi.openapi.location.SosoSdk.AnonymousClass1 */

                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    LocationHelper.LocationListener locationListener;
                    if (!method.getName().equals("onLocationChanged") || (locationListener = locationListener) == null) {
                        return null;
                    }
                    locationListener.location(SosoSdk.this.parseLocation(objArr[0]));
                    return null;
                }
            });
            Class<?> cls2 = Class.forName("com.tencent.map.geolocation.TencentLocationRequest");
            Object invoke = cls2.getMethod("create", new Class[0]).invoke(cls2, new Object[0]);
            cls2.getMethod("setInterval", Long.TYPE).invoke(invoke, 2000L);
            ((Integer) this.sosoManage.getMethod("requestLocationUpdates", cls2, cls, Looper.class).invoke(this.sosoObject, invoke, this.soso, looper)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unRegistListener() {
        try {
            Class<?> cls = Class.forName("com.tencent.map.geolocation.TencentLocationListener");
            if (this.sosoObject != null && this.soso != null) {
                this.sosoObject.getClass().getMethod("removeUpdates", cls).invoke(this.sosoObject, this.soso);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }
}
