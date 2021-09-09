package _m_j;

import android.content.Context;
import android.provider.Settings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class buj {
    private static final Object O00000Oo = new Object();
    private static buj O00000o0 = null;
    private static final String O0000Oo = (".UTSystemConfig" + File.separator + "Global");

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f13287O000000o = null;
    private String O00000o = null;
    private bul O00000oO = null;
    private String O00000oo = "xx_utdid_key";
    private String O0000O0o = "xx_utdid_domain";
    private bvi O0000OOo = null;
    private bvi O0000Oo0 = null;
    private Pattern O0000OoO = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private buj(Context context) {
        this.f13287O000000o = context;
        this.O0000Oo0 = new bvi(context, O0000Oo, "Alvin2");
        this.O0000OOo = new bvi(context, ".DataStorage", "ContextData");
        this.O00000oO = new bul();
        this.O00000oo = String.format("K_%d", Integer.valueOf(bvf.O00000Oo(this.O00000oo)));
        this.O0000O0o = String.format("D_%d", Integer.valueOf(bvf.O00000Oo(this.O0000O0o)));
    }

    public static buj O000000o(Context context) {
        if (context != null && O00000o0 == null) {
            synchronized (O00000Oo) {
                if (O00000o0 == null) {
                    O00000o0 = new buj(context);
                }
            }
        }
        return O00000o0;
    }

    private void O00000Oo(String str) {
        bvi bvi;
        if (str != null && (bvi = this.O0000OOo) != null && !str.equals(bvi.O000000o(this.O00000oo))) {
            this.O0000OOo.O000000o(this.O00000oo, str);
            this.O0000OOo.O000000o();
        }
    }

    private final byte[] O00000Oo() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] O000000o2 = bvd.O000000o(currentTimeMillis);
        byte[] O000000o3 = bvd.O000000o(nextInt);
        byteArrayOutputStream.write(O000000o2, 0, 4);
        byteArrayOutputStream.write(O000000o3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = bve.O000000o(this.f13287O000000o);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(new Random().nextInt());
            str = sb.toString();
        }
        byteArrayOutputStream.write(bvd.O000000o(bvf.O00000Oo(str)), 0, 4);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        byteArrayOutputStream.write(bvd.O000000o(bvf.O00000Oo(bvc.O000000o(instance.doFinal(byteArray), 2))));
        return byteArrayOutputStream.toByteArray();
    }

    private void O00000o(String str) {
        if (this.f13287O000000o.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null && !str.equals(Settings.System.getString(this.f13287O000000o.getContentResolver(), "dxCRMxhQkdGePGnp"))) {
            Settings.System.putString(this.f13287O000000o.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        }
    }

    private void O00000o0(String str) {
        if (this.f13287O000000o.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && O00000oO(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !O00000oO(Settings.System.getString(this.f13287O000000o.getContentResolver(), "mqBRboGZkQPcAkyk"))) {
                Settings.System.putString(this.f13287O000000o.getContentResolver(), "mqBRboGZkQPcAkyk", str);
            }
        }
    }

    private boolean O00000oO(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && !this.O0000OoO.matcher(str).find();
        }
    }

    private void O000000o(String str) {
        bvi bvi;
        long j;
        if (O00000oO(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (bvi = this.O0000Oo0) != null) {
                String O000000o2 = bvi.O000000o("UTDID");
                String O000000o3 = this.O0000Oo0.O000000o("EI");
                if (bvf.O000000o(O000000o3)) {
                    O000000o3 = bve.O000000o(this.f13287O000000o);
                }
                String O000000o4 = this.O0000Oo0.O000000o("SI");
                if (bvf.O000000o(O000000o4)) {
                    O000000o4 = bve.O00000Oo(this.f13287O000000o);
                }
                String O000000o5 = this.O0000Oo0.O000000o("DID");
                if (bvf.O000000o(O000000o5)) {
                    O000000o5 = O000000o3;
                }
                if (O000000o2 == null || !O000000o2.equals(str)) {
                    buh buh = new buh();
                    buh.f13285O000000o = O000000o3;
                    buh.O00000Oo = O000000o4;
                    buh.O00000o = str;
                    buh.O00000o0 = O000000o5;
                    buh.O00000oO = System.currentTimeMillis();
                    this.O0000Oo0.O000000o("UTDID", str);
                    this.O0000Oo0.O000000o("EI", buh.f13285O000000o);
                    this.O0000Oo0.O000000o("SI", buh.O00000Oo);
                    this.O0000Oo0.O000000o("DID", buh.O00000o0);
                    this.O0000Oo0.O000000o("timestamp", buh.O00000oO);
                    bvi bvi2 = this.O0000Oo0;
                    String format = String.format("%s%s%s%s%s", buh.O00000o, buh.O00000o0, Long.valueOf(buh.O00000oO), buh.O00000Oo, buh.f13285O000000o);
                    if (!bvf.O000000o(format)) {
                        Adler32 adler32 = new Adler32();
                        adler32.reset();
                        adler32.update(format.getBytes());
                        j = adler32.getValue();
                    } else {
                        j = 0;
                    }
                    bvi2.O000000o("S", j);
                    this.O0000Oo0.O000000o();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa A[Catch:{ Exception -> 0x012b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bf A[SYNTHETIC, Splitter:B:49:0x00bf] */
    public final synchronized String O000000o() {
        String str;
        if (this.O00000o != null) {
            return this.O00000o;
        }
        String string = Settings.System.getString(this.f13287O000000o.getContentResolver(), "mqBRboGZkQPcAkyk");
        if (O00000oO(string)) {
            return string;
        }
        bum bum = new bum();
        boolean z = false;
        String string2 = Settings.System.getString(this.f13287O000000o.getContentResolver(), "dxCRMxhQkdGePGnp");
        if (!bvf.O000000o(string2)) {
            String O00000Oo2 = bum.O00000Oo(string2);
            if (O00000oO(O00000Oo2)) {
                O00000o0(O00000Oo2);
                return O00000Oo2;
            }
            String O000000o2 = bum.O000000o(string2);
            if (O00000oO(O000000o2)) {
                String O000000o3 = this.O00000oO.O000000o(O000000o2);
                if (!bvf.O000000o(O000000o3)) {
                    O00000o(O000000o3);
                    string2 = Settings.System.getString(this.f13287O000000o.getContentResolver(), "dxCRMxhQkdGePGnp");
                }
            }
            String O00000Oo3 = this.O00000oO.O00000Oo(string2);
            if (O00000oO(O00000Oo3)) {
                this.O00000o = O00000Oo3;
                O000000o(O00000Oo3);
                O00000Oo(string2);
                O00000o0(this.O00000o);
                return this.O00000o;
            }
        } else {
            z = true;
        }
        if (this.O0000Oo0 != null) {
            str = this.O0000Oo0.O000000o("UTDID");
            if (!bvf.O000000o(str) && this.O00000oO.O000000o(str) != null) {
                if (!O00000oO(str)) {
                    String O000000o4 = this.O00000oO.O000000o(str);
                    if (z) {
                        O00000o(O000000o4);
                    }
                    O00000o0(str);
                    O00000Oo(O000000o4);
                    this.O00000o = str;
                    return str;
                }
                String O000000o5 = this.O0000OOo.O000000o(this.O00000oo);
                if (!bvf.O000000o(O000000o5)) {
                    String O000000o6 = bum.O000000o(O000000o5);
                    if (!O00000oO(O000000o6)) {
                        O000000o6 = this.O00000oO.O00000Oo(O000000o5);
                    }
                    if (O00000oO(O000000o6)) {
                        String O000000o7 = this.O00000oO.O000000o(O000000o6);
                        if (!bvf.O000000o(O000000o6)) {
                            this.O00000o = O000000o6;
                            if (z) {
                                O00000o(O000000o7);
                            }
                            O000000o(this.O00000o);
                            return this.O00000o;
                        }
                    }
                }
                try {
                    byte[] O00000Oo4 = O00000Oo();
                    if (O00000Oo4 != null) {
                        this.O00000o = bvc.O000000o(O00000Oo4, 2);
                        O000000o(this.O00000o);
                        String O000000o8 = bvb.O000000o(this.O00000oO.f13291O000000o, bvc.O000000o(O00000Oo4, 2));
                        if (O000000o8 != null) {
                            if (z) {
                                O00000o(O000000o8);
                            }
                            O00000Oo(O000000o8);
                        }
                        return this.O00000o;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        str = null;
        if (!O00000oO(str)) {
        }
        return null;
    }
}
