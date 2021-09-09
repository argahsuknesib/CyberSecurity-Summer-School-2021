package _m_j;

import android.content.SharedPreferences;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipSharedLoginConnector$5;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipSharedLoginConnector$6;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.io.ByteArrayInputStream;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.SecretKey;
import org.json.JSONObject;

public final class fhl extends fhd {
    private static final byte[] O0000Oo = {48, 0, 0, 0};
    private static final byte[] O0000OoO = {49, 0, 0, 0};
    private static final byte[] O0000Ooo = {50, 0, 0, 0};
    private static final byte[] O0000o0 = {52, 0, 0, 0};
    private static final byte[] O0000o00 = {51, 0, 0, 0};
    public String O0000Oo0;
    private PublicKey O0000o;
    private KeyPair O0000o0O;
    private byte[] O0000o0o;
    private X509Certificate O0000oO;
    private X509Certificate O0000oO0;
    private PublicKey O0000oOO;
    private byte[] O0000oOo;

    protected fhl(fgp fgp) {
        super(fgp);
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o0)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 10 ..., value = " + got.O00000o0(bArr));
            if (got.O00000Oo(bArr, O0000OoO)) {
                this.O0000OOo.removeMessages(4100);
                this.O00000oO.putByteArray("session_key", this.O0000oOo);
                O000000o(0);
            } else if (got.O00000Oo(bArr, O0000Ooo)) {
                this.O0000OOo.removeMessages(4100);
                O000000o(-24);
            } else if (got.O00000Oo(bArr, O0000o00)) {
                this.O0000OOo.removeMessages(4100);
                O000000o(-18);
            } else if (got.O00000Oo(bArr, fhg.O0000Oo0)) {
                this.O0000OOo.removeMessages(4100);
                O000000o(-16);
            }
        }
    }

    private static byte[] O00000Oo(byte[] bArr) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, "smartcfg-share-salt".getBytes());
            return O000000o2.O000000o("smartcfg-share-info".getBytes(), 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 4100) {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector notify timeout");
            O000000o(-7);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i) {
        if (this.O00000Oo) {
            O000000o(-2);
        } else if (i == 1) {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 6 ...");
            try {
                this.O0000oO0 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            } catch (CertificateException e) {
                e.printStackTrace();
            }
            this.O0000OOo.removeMessages(4100);
            this.O0000OOo.sendEmptyMessageDelayed(4100, 15000);
        } else if (i == 2) {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 7 ...");
            try {
                this.O0000oO = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            } catch (CertificateException e2) {
                e2.printStackTrace();
            }
            this.O0000OOo.removeMessages(4100);
            this.O0000OOo.sendEmptyMessageDelayed(4100, 15000);
        } else if (i == 3) {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 5 ...");
            this.O0000o0o = Arrays.copyOf(bArr, bArr.length);
            byte[] bArr2 = new byte[65];
            bArr2[0] = 4;
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            try {
                this.O0000o = fio.O000000o(bArr2, ((ECPublicKey) this.O0000o0O.getPublic()).getParams());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.O0000OOo.removeMessages(4100);
            this.O0000OOo.sendEmptyMessageDelayed(4100, 15000);
        } else if (i == 4) {
            if (!O000000o(bArr)) {
                O000000o(-23);
            } else if (this.O00000Oo) {
                O000000o(-2);
            } else {
                fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 9 ...");
                byte[] O000000o2 = fir.O000000o(Arrays.copyOfRange(this.O0000oOo, 16, 32), new byte[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}, got.O000000o(this.O0000Oo0));
                if (O000000o2 != null) {
                    this.O0000OOo.removeMessages(4100);
                    this.O0000OOo.sendEmptyMessageDelayed(4100, 15000);
                    if (O000000o(O000000o2, 6, new BleSecurityChipSharedLoginConnector$6(this))) {
                        return;
                    }
                }
                O000000o(-28);
            }
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 1 ...");
        String O0000ooO = ffr.O0000ooO(O00000o0());
        if (TextUtils.isEmpty(O0000ooO)) {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector shared key id is empty");
            O000000o(-25);
            return;
        }
        String O00000oo = ffr.O00000oo(O00000o0());
        if (TextUtils.isEmpty(O00000oo)) {
            fte.O00000Oo("BleSecurityChipSharedLoginConnector did is empty");
            O000000o(-12);
            return;
        }
        fgo.O000000o("share", O00000oo, O0000ooO, new feo<JSONObject, fes>() {
            /* class _m_j.fhl.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject != null ? jSONObject.optString("key") : "";
                if (TextUtils.isEmpty(optString)) {
                    fte.O00000Oo("BleSecurityChipSharedLoginConnector shared key is empty......");
                    fhl.this.O000000o(-19);
                    return;
                }
                fhl fhl = fhl.this;
                fhl.O0000Oo0 = optString;
                ffr.O00000o(fhl.O00000o0(), "".getBytes());
                fhl.O00000Oo(new BleNotifyResponse() {
                    /* class _m_j.fhl.AnonymousClass2 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fte.O00000Oo("BleSecurityChipSharedLoginConnector Step 1 onResponse: " + gmc.O000000o(i));
                        if (i == 0) {
                            fhl.this.O0000Ooo();
                        } else {
                            fhl.this.O000000o(-27);
                        }
                    }
                });
            }

            public final void O000000o(fes fes) {
                fte.O00000Oo("BleSecurityChipSharedLoginConnector fetch share key failed");
                if (fes == null || fes.f16189O000000o != -6 || fes.O00000Oo == null || !fes.O00000Oo.contains("key is out of date")) {
                    fhl.this.O000000o(-19);
                } else {
                    fhl.this.O000000o(-18);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 2 ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fhl.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleSecurityChipSharedLoginConnector Step 2 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhl.this.O0000o00();
                } else {
                    fhl.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000o00() {
        byte[] bArr;
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 3 ...");
        this.O0000o0O = fir.O000000o();
        String string = gpy.O000000o(glc.O0000O0o, "pref_device_cert").getString(O00000o0(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.O0000oOO = fio.O000000o(got.O000000o(string), ((ECPublicKey) this.O0000o0O.getPublic()).getParams());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.O0000oOO != null) {
            bArr = O0000Oo;
        } else {
            bArr = O0000o0;
        }
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr, new BleWriteResponse() {
            /* class _m_j.fhl.AnonymousClass4 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleSecurityChipSharedLoginConnector Step 3 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhl.this.O0000o0();
                } else {
                    fhl.this.O000000o(-28);
                }
            }
        });
    }

    public final void O0000o0() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 4 ...");
        if (!O000000o(fir.O000000o(this.O0000o0O.getPublic()), 3, new BleSecurityChipSharedLoginConnector$5(this))) {
            O000000o(-28);
        }
    }

    private boolean O000000o(byte[] bArr) {
        fte.O00000Oo("BleSecurityChipSharedLoginConnector Process Step 8 ...");
        this.O0000OOo.removeMessages(4100);
        if (this.O0000o == null) {
            return false;
        }
        if (this.O0000oOO == null && (this.O0000oO0 == null || this.O0000oO == null)) {
            return false;
        }
        if (this.O0000oOO == null) {
            if (!fiq.O000000o(fiq.O000000o(), this.O0000oO)) {
                fte.O00000Oo("BleSecurityChipSharedLoginConnector MijiaManufactureCERT is invalid");
                return false;
            } else if (!fiq.O000000o(this.O0000oO, this.O0000oO0)) {
                fte.O00000Oo("BleSecurityChipSharedLoginConnector MijiaDeviceCert is invalid");
                return false;
            } else {
                SharedPreferences.Editor edit = gpy.O000000o(glc.O0000O0o, "pref_device_cert").edit();
                this.O0000oOO = this.O0000oO0.getPublicKey();
                edit.putString(O00000o0(), got.O00000o0(fio.O000000o((ECPublicKey) this.O0000oOO)));
                edit.apply();
            }
        }
        SecretKey O000000o2 = fir.O000000o(this.O0000o, this.O0000o0O.getPrivate());
        if (O000000o2 == null) {
            return false;
        }
        try {
            if (!fir.O000000o(this.O0000o0o, fir.O000000o(bArr), this.O0000oOO)) {
                return false;
            }
            this.O0000oOo = O00000Oo(O000000o2.getEncoded());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
