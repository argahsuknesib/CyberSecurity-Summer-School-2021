package com.lidroid.xutils.util;

import _m_j.brm;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PreferencesCookieStore implements CookieStore {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ConcurrentHashMap<String, Cookie> f4515O000000o = new ConcurrentHashMap<>();
    private final SharedPreferences O00000Oo;

    public PreferencesCookieStore(Context context) {
        Cookie O000000o2;
        this.O00000Oo = context.getSharedPreferences("CookiePrefsFile", 0);
        String string = this.O00000Oo.getString("names", null);
        if (string != null) {
            for (String str : TextUtils.split(string, ",")) {
                String string2 = this.O00000Oo.getString("cookie_".concat(String.valueOf(str)), null);
                if (!(string2 == null || (O000000o2 = O000000o(string2)) == null)) {
                    this.f4515O000000o.put(str, O000000o2);
                }
            }
            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie) {
        String name = cookie.getName();
        if (!cookie.isExpired(new Date())) {
            this.f4515O000000o.put(name, cookie);
        } else {
            this.f4515O000000o.remove(name);
        }
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        edit.putString("names", TextUtils.join(",", this.f4515O000000o.keySet()));
        edit.putString("cookie_".concat(String.valueOf(name)), O000000o(new SerializableCookie(cookie)));
        edit.commit();
    }

    public void clear() {
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        for (String valueOf : this.f4515O000000o.keySet()) {
            edit.remove("cookie_".concat(String.valueOf(valueOf)));
        }
        edit.remove("names");
        edit.commit();
        this.f4515O000000o.clear();
    }

    public boolean clearExpired(Date date) {
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        boolean z = false;
        for (Map.Entry next : this.f4515O000000o.entrySet()) {
            String str = (String) next.getKey();
            Cookie cookie = (Cookie) next.getValue();
            if (cookie.getExpiryDate() == null || cookie.isExpired(date)) {
                this.f4515O000000o.remove(str);
                edit.remove("cookie_".concat(String.valueOf(str)));
                z = true;
            }
        }
        if (z) {
            edit.putString("names", TextUtils.join(",", this.f4515O000000o.keySet()));
        }
        edit.commit();
        return z;
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.f4515O000000o.values());
    }

    private static String O000000o(SerializableCookie serializableCookie) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableCookie);
            return O000000o(byteArrayOutputStream.toByteArray());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String O000000o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            byte b2 = b & 255;
            if (b2 < 16) {
                stringBuffer.append('0');
            }
            stringBuffer.append(Integer.toHexString(b2));
        }
        return stringBuffer.toString().toUpperCase();
    }

    public class SerializableCookie implements Serializable {
        private static final long serialVersionUID = 6374381828722046732L;

        /* renamed from: O000000o  reason: collision with root package name */
        final transient Cookie f4516O000000o;
        transient BasicClientCookie O00000Oo;

        public SerializableCookie(Cookie cookie) {
            this.f4516O000000o = cookie;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f4516O000000o.getName());
            objectOutputStream.writeObject(this.f4516O000000o.getValue());
            objectOutputStream.writeObject(this.f4516O000000o.getComment());
            objectOutputStream.writeObject(this.f4516O000000o.getDomain());
            objectOutputStream.writeObject(this.f4516O000000o.getExpiryDate());
            objectOutputStream.writeObject(this.f4516O000000o.getPath());
            objectOutputStream.writeInt(this.f4516O000000o.getVersion());
            objectOutputStream.writeBoolean(this.f4516O000000o.isSecure());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.O00000Oo = new BasicClientCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
            this.O00000Oo.setComment((String) objectInputStream.readObject());
            this.O00000Oo.setDomain((String) objectInputStream.readObject());
            this.O00000Oo.setExpiryDate((Date) objectInputStream.readObject());
            this.O00000Oo.setPath((String) objectInputStream.readObject());
            this.O00000Oo.setVersion(objectInputStream.readInt());
            this.O00000Oo.setSecure(objectInputStream.readBoolean());
        }
    }

    private static Cookie O000000o(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        try {
            SerializableCookie serializableCookie = (SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            Cookie cookie = serializableCookie.f4516O000000o;
            if (serializableCookie.O00000Oo != null) {
                return serializableCookie.O00000Oo;
            }
            return cookie;
        } catch (Throwable th) {
            brm.O000000o(th.getMessage(), th);
            return null;
        }
    }
}
