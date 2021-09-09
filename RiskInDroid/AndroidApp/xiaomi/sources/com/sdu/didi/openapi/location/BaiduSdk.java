package com.sdu.didi.openapi.location;

import _m_j.gsy;
import android.content.Context;
import android.os.Looper;
import com.sdu.didi.openapi.location.LocationHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BaiduSdk extends SdkHub {
    private Context context;
    private Object listenerObject;
    private Object manageObject;

    public BaiduSdk(Context context2) {
        gsy.O000000o(6, "LocationSDK", "BAIDU");
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public Location parseLocation(Object obj) {
        Location location = new Location();
        try {
            Class<?> cls = Class.forName("com.baidu.location.BDLocation");
            int intValue = ((Integer) cls.getMethod("getLocType", new Class[0]).invoke(obj, new Object[0])).intValue();
            if (intValue == 61 || intValue == 161) {
                double doubleValue = ((Double) cls.getMethod("getLatitude", new Class[0]).invoke(obj, new Object[0])).doubleValue();
                double doubleValue2 = ((Double) cls.getMethod("getLongitude", new Class[0]).invoke(obj, new Object[0])).doubleValue();
                location.setLat(String.valueOf(doubleValue));
                location.setLng(String.valueOf(doubleValue2));
                location.setMapType("soso");
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
        return location;
    }

    public void registListener(Looper looper, final LocationHelper.LocationListener locationListener) {
        try {
            Class<?> cls = Class.forName("com.baidu.location.LocationClient");
            this.manageObject = cls.getConstructor(Context.class).newInstance(this.context.getApplicationContext());
            Class<?> cls2 = Class.forName("com.baidu.location.LocationClientOption");
            Object newInstance = cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method method = cls2.getMethod("setScanSpan", Integer.TYPE);
            cls2.getMethod("setIgnoreKillProcess", Boolean.TYPE).invoke(newInstance, Boolean.FALSE);
            Method method2 = cls2.getMethod("setIsNeedAddress", Boolean.TYPE);
            Method method3 = cls2.getMethod("setIsNeedLocationDescribe", Boolean.TYPE);
            Method method4 = cls2.getMethod("setLocationNotify", Boolean.TYPE);
            method2.invoke(newInstance, Boolean.TRUE);
            method3.invoke(newInstance, Boolean.TRUE);
            method4.invoke(newInstance, Boolean.TRUE);
            method.invoke(newInstance, 2000);
            cls.getMethod("setLocOption", cls2).invoke(this.manageObject, newInstance);
            Class<?> cls3 = Class.forName("com.baidu.location.BDLocationListener");
            this.listenerObject = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new InvocationHandler() {
                /* class com.sdu.didi.openapi.location.BaiduSdk.AnonymousClass1 */

                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    LocationHelper.LocationListener locationListener;
                    if (method.getName().equals("onReceiveLocation") && (locationListener = locationListener) != null) {
                        locationListener.location(BaiduSdk.this.parseLocation(objArr[0]));
                    }
                    return Boolean.TRUE;
                }
            });
            cls.getMethod("registerLocationListener", cls3).invoke(this.manageObject, this.listenerObject);
            cls.getMethod("start", new Class[0]).invoke(this.manageObject, new Object[0]);
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
            if (this.manageObject != null && this.listenerObject != null) {
                Class<?> cls = Class.forName("com.baidu.location.BDLocationListener");
                this.manageObject.getClass().getMethod("unRegisterLocationListener", cls).invoke(this.manageObject, this.listenerObject);
                this.manageObject.getClass().getMethod("stop", new Class[0]).invoke(this.manageObject, new Object[0]);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        }
    }
}
