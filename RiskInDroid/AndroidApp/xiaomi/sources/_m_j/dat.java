package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.sdu.didi.openapi.DIOpenSDK;
import com.sdu.didi.openapi.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public final class dat {

    /* renamed from: O000000o  reason: collision with root package name */
    private static byte[] f14421O000000o = {102, 49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 55, 48, 56};
    private static dat O00000Oo;
    private String O00000o0;

    private dat() {
    }

    public static synchronized dat O000000o() {
        dat dat;
        synchronized (dat.class) {
            if (O00000Oo == null) {
                O00000Oo = new dat();
            }
            dat = O00000Oo;
        }
        return dat;
    }

    public final synchronized String O000000o(Context context) {
        if (!TextUtils.isEmpty(this.O00000o0)) {
            return this.O00000o0;
        }
        HashMap hashMap = new HashMap();
        dax O000000o2 = dau.O000000o().O000000o(context);
        if (O000000o2.O000000o()) {
            hashMap.put("openid", O000000o2.f14425O000000o);
            String timestamp = Utils.getTimestamp();
            hashMap.put("timestamp", timestamp);
            String randomString = Utils.getRandomString(10);
            hashMap.put("noncestr", randomString);
            hashMap.put("version", Utils.getCurrentVersion());
            DIOpenSDK instance = DIOpenSDK.getInstance();
            hashMap.put("sign", instance.getSDKSign(O000000o2.f14425O000000o + timestamp + randomString));
            String O000000o3 = daz.O000000o().O000000o("https://api.xiaojukeji.com/v1/permit/pGetKey", hashMap);
            if (!TextUtils.isEmpty(O000000o3)) {
                try {
                    JSONObject jSONObject = new JSONObject(O000000o3);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.O00000o0 = optJSONObject.optString("key");
                    }
                    DIOpenSDK.O000000o(context, jSONObject.getInt("errno"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.O00000o0;
    }

    /* access modifiers changed from: protected */
    public final synchronized String O000000o(String str) {
        String str2;
        str2 = null;
        if (!TextUtils.isEmpty(this.O00000o0)) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                byte[] bytes2 = this.O00000o0.getBytes("UTF-8");
                byte[] bArr = f14421O000000o;
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
                str2 = new String(instance.doFinal(bytes), "ISO-8859-1");
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (InvalidAlgorithmParameterException e3) {
                e3.printStackTrace();
            } catch (InvalidKeyException e4) {
                e4.printStackTrace();
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
            } catch (UnsupportedEncodingException e7) {
                e7.printStackTrace();
            }
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public final synchronized String O00000Oo(String str) {
        String str2;
        str2 = null;
        if (!TextUtils.isEmpty(this.O00000o0)) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                byte[] bytes2 = this.O00000o0.getBytes("UTF-8");
                byte[] bArr = f14421O000000o;
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
                str2 = new String(instance.doFinal(bytes), "UTF-8");
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (InvalidAlgorithmParameterException e3) {
                e3.printStackTrace();
            } catch (InvalidKeyException e4) {
                e4.printStackTrace();
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
            } catch (UnsupportedEncodingException e7) {
                e7.printStackTrace();
            }
        }
        return str2;
    }
}
