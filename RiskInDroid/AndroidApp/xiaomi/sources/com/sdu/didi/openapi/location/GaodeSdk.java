package com.sdu.didi.openapi.location;

import _m_j.gsy;
import android.content.Context;
import android.os.Looper;
import com.sdu.didi.openapi.location.LocationHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GaodeSdk extends SdkHub {
    private Context context;
    private Object listenObject;
    private Object manageObject;

    public GaodeSdk(Context context2) {
        this.context = context2;
        gsy.O000000o(6, "LocationSDK", "GAODE");
    }

    /* access modifiers changed from: protected */
    public Location parseLocation(Object obj) {
        Location location = new Location();
        try {
            Class<?> cls = obj.getClass();
            if (((Integer) cls.getMethod("getErrorCode", new Class[0]).invoke(obj, new Object[0])).intValue() == 0) {
                double doubleValue = ((Double) cls.getMethod("getLatitude", new Class[0]).invoke(obj, new Object[0])).doubleValue();
                location.setLng(String.valueOf(((Double) cls.getMethod("getLongitude", new Class[0]).invoke(obj, new Object[0])).doubleValue()));
                location.setLat(String.valueOf(doubleValue));
                location.setMapType("soso");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return location;
    }

    public void registListener(Looper looper, final LocationHelper.LocationListener locationListener) {
        try {
            Class<?> cls = Class.forName("com.amap.api.location.AMapLocationClient");
            this.manageObject = cls.getConstructor(Context.class).newInstance(this.context.getApplicationContext());
            Class<?> cls2 = Class.forName("com.amap.api.location.AMapLocationClientOption");
            Object newInstance = cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            cls2.getMethod("setInterval", Long.TYPE).invoke(newInstance, 2000L);
            cls.getMethod("setLocationOption", cls2).invoke(this.manageObject, newInstance);
            Class<?> cls3 = Class.forName("com.amap.api.location.AMapLocationListener");
            Method method = cls.getMethod("setLocationListener", cls3);
            this.listenObject = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new InvocationHandler() {
                /* class com.sdu.didi.openapi.location.GaodeSdk.AnonymousClass1 */

                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    LocationHelper.LocationListener locationListener;
                    if (!method.getName().equals("onLocationChanged") || objArr[0] == null || (locationListener = locationListener) == null) {
                        return null;
                    }
                    locationListener.location(GaodeSdk.this.parseLocation(objArr[0]));
                    return null;
                }
            });
            method.invoke(this.manageObject, this.listenObject);
            cls.getMethod("startLocation", new Class[0]).invoke(this.manageObject, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        }
    }

    public void unRegistListener() {
        try {
            if (this.manageObject != null && this.listenObject != null) {
                Class<?> cls = this.manageObject.getClass();
                cls.getMethod("stopLocation", new Class[0]).invoke(this.manageObject, new Object[0]);
                cls.getMethod("onDestroy", new Class[0]).invoke(this.manageObject, new Object[0]);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
