package _m_j;

import _m_j.fas;
import _m_j.gnk;
import _m_j.got;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp;
import com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.McuUpdateInfo;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ffr {

    /* renamed from: O000000o  reason: collision with root package name */
    static Map<String, String> f16241O000000o = new ConcurrentHashMap();
    private static Map<String, String> O00000Oo = new HashMap();

    public static void O000000o() {
        BleDevicePropCache.O000000o().O00000Oo();
    }

    private static String O000O0OO(String str) {
        return gms.O000000o().O00000o(fec.O00000o0().O000000o(), str);
    }

    private static String O000O0Oo(String str) {
        return gms.O000000o().O00000o0(fec.O00000o0().O000000o(), str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$12, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("name", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass12 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6817O000000o;

            {
                this.f6817O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6817O000000o.equals(bleDeviceProp.name)) {
                    return false;
                }
                bleDeviceProp.name = this.f6817O000000o;
                return true;
            }
        }, true);
    }

    public static void O000000o(fkv<Integer, Integer> fkv) throws Exception {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        if (fkv != null) {
            synchronized (O000000o2.O00000oo) {
                if (O000000o2.O00000oO == 3) {
                    fkv.call(Integer.valueOf(O000000o2.O00000oO));
                } else {
                    O000000o2.O00000oo.add(fkv);
                }
                if (O000000o2.O00000oO == 1) {
                    O000000o2.O00000Oo();
                }
            }
        }
    }

    public static String O000000o(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass23 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.name;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$52, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000Oo(String str, String str2) {
        String O0000O0o = gqb.O0000O0o(str2);
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("ownerName", O0000O0o) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass52 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6861O000000o;

            {
                this.f6861O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6861O000000o.equals(bleDeviceProp.ownerName)) {
                    return false;
                }
                bleDeviceProp.ownerName = this.f6861O000000o;
                return true;
            }
        }, true);
    }

    public static String O00000Oo(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass53 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.ownerName;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$54, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000o0(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("beaconName", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass54 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6863O000000o;

            {
                this.f6863O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6863O000000o.equals(bleDeviceProp.beaconName)) {
                    return false;
                }
                bleDeviceProp.beaconName = this.f6863O000000o;
                return true;
            }
        }, false);
    }

    public static String O00000o0(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass55 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.beaconName;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$4, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000o(String str, String str2) {
        String O0000O0o = gqb.O0000O0o(str2);
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("ownerId", O0000O0o) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass4 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6847O000000o;

            {
                this.f6847O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6847O000000o.equals(bleDeviceProp.ownerId)) {
                    return false;
                }
                bleDeviceProp.ownerId = this.f6847O000000o;
                return true;
            }
        }, true);
    }

    public static String O00000o(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.ownerId;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$15, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, int i) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("permitLevel", i) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass15 */

            /* renamed from: O000000o */
            final /* synthetic */ int f6820O000000o;

            {
                this.f6820O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6820O000000o == bleDeviceProp.permitLevel) {
                    return false;
                }
                bleDeviceProp.permitLevel = this.f6820O000000o;
                return true;
            }
        }, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$16, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T */
    public static int O00000oO(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Integer) O000000o2.O000000o(str, (BleDevicePropCache.O00000Oo) new BleDevicePropCache.O00000Oo<Integer>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass16 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Integer.valueOf(bleDeviceProp.permitLevel);
            }
        }, (Object) 0)).intValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$2, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000oO(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("did", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass2 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6825O000000o;

            {
                this.f6825O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6825O000000o.equals(bleDeviceProp.did)) {
                    return false;
                }
                bleDeviceProp.did = this.f6825O000000o;
                return true;
            }
        }, true);
    }

    public static String O00000oo(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.did;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$10, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000Oo(String str, int i) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("pid", i) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass10 */

            /* renamed from: O000000o */
            final /* synthetic */ int f6815O000000o;

            {
                this.f6815O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6815O000000o == bleDeviceProp.productId) {
                    return false;
                }
                bleDeviceProp.productId = this.f6815O000000o;
                return true;
            }
        }, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$11, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T */
    public static int O0000O0o(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Integer) O000000o2.O000000o(str, (BleDevicePropCache.O00000Oo) new BleDevicePropCache.O00000Oo<Integer>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass11 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Integer.valueOf(bleDeviceProp.productId);
            }
        }, (Object) 0)).intValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$6, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000oo(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("desc", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass6 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6865O000000o;

            {
                this.f6865O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6865O000000o.equals(bleDeviceProp.desc)) {
                    return false;
                }
                bleDeviceProp.desc = this.f6865O000000o;
                return true;
            }
        }, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$13, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000o0(String str, int i) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("rssi", i) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass13 */

            /* renamed from: O000000o */
            final /* synthetic */ int f6818O000000o;

            {
                this.f6818O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6818O000000o == bleDeviceProp.rssi) {
                    return false;
                }
                bleDeviceProp.rssi = this.f6818O000000o;
                return true;
            }
        }, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$14, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T */
    public static int O0000OOo(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Integer) O000000o2.O000000o(str, (BleDevicePropCache.O00000Oo) new BleDevicePropCache.O00000Oo<Integer>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass14 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Integer.valueOf(bleDeviceProp.rssi);
            }
        }, (Object) -60)).intValue();
    }

    public static String O0000Oo0(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass7 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.desc;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$8, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O0000O0o(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("model", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass8 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6867O000000o;

            {
                this.f6867O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6867O000000o.equals(bleDeviceProp.model)) {
                    return false;
                }
                bleDeviceProp.model = this.f6867O000000o;
                return true;
            }
        }, true);
    }

    public static String O0000Oo(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass9 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.model;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$34, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O0000OOo(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("smac", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass34 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6841O000000o;

            {
                this.f6841O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6841O000000o.equals(bleDeviceProp.smac)) {
                    return false;
                }
                bleDeviceProp.smac = this.f6841O000000o;
                return true;
            }
        }, true);
    }

    public static String O0000OoO(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass45 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.smac;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$17, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000o(String str, int i) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("boundStatus", i) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass17 */

            /* renamed from: O000000o */
            final /* synthetic */ int f6822O000000o;

            {
                this.f6822O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6822O000000o == bleDeviceProp.boundStatus) {
                    return false;
                }
                bleDeviceProp.boundStatus = this.f6822O000000o;
                return true;
            }
        }, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$40, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, byte[] bArr) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        if (!got.O00000o(bArr)) {
            O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("scanRecord", bArr) {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass40 */

                /* renamed from: O000000o */
                final /* synthetic */ byte[] f6848O000000o;

                {
                    this.f6848O000000o = r3;
                }

                public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                    String O00000o0 = got.O00000o0(this.f6848O000000o);
                    if (O00000o0.equalsIgnoreCase(bleDeviceProp.scanRecord)) {
                        return false;
                    }
                    bleDeviceProp.scanRecord = O00000o0;
                    return true;
                }
            }, false);
        }
    }

    public static byte[] O0000Ooo(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (byte[]) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<byte[]>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass39 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                String str = bleDeviceProp.scanRecord;
                return TextUtils.isEmpty(str) ? got.f18097O000000o : got.O000000o(str);
            }
        }, got.f18097O000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$42, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000oO(String str, int i) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("type", i) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass42 */

            /* renamed from: O000000o */
            final /* synthetic */ int f6850O000000o;

            {
                this.f6850O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6850O000000o == bleDeviceProp.type) {
                    return false;
                }
                bleDeviceProp.type = this.f6850O000000o;
                return true;
            }
        }, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$41, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T */
    public static int O0000o00(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Integer) O000000o2.O000000o(str, (BleDevicePropCache.O00000Oo) new BleDevicePropCache.O00000Oo<Integer>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass41 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Integer.valueOf(bleDeviceProp.type);
            }
        }, (Object) 0)).intValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$18, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T */
    public static int O0000o0(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Integer) O000000o2.O000000o(str, (BleDevicePropCache.O00000Oo) new BleDevicePropCache.O00000Oo<Integer>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass18 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Integer.valueOf(bleDeviceProp.boundStatus);
            }
        }, (Object) 0)).intValue();
    }

    public static String O0000o0O(String str) {
        if (fec.O00000oO().O000000o()) {
            String O000000o2 = fas.O000000o.f16038O000000o.O000000o(str);
            if (TextUtils.isEmpty(O000000o2)) {
                O000000o2 = O000O0OO(BleDevicePropCache.O000000o().O000000o(str));
                if (!TextUtils.isEmpty(O000000o2) && fas.O000000o.f16038O000000o.O000000o(str, O000000o2)) {
                    BleDevicePropCache.O000000o().O000000o(str, "");
                }
            }
            return O000000o2;
        }
        String O000000o3 = BleDevicePropCache.O000000o().O000000o(str);
        if (TextUtils.isEmpty(O000000o3)) {
            return fas.O000000o.f16038O000000o.O000000o(str);
        }
        return O000O0OO(O000000o3);
    }

    public static byte[] O0000o0o(String str) {
        String O0000o0O = O0000o0O(str);
        return TextUtils.isEmpty(O0000o0O) ? got.f18097O000000o : got.O000000o(O0000o0O);
    }

    public static void O0000Oo0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            fte.O00000Oo("BluetoothCache set prop token empty");
            fas.O000000o.f16038O000000o.O000000o(str, str2);
            BleDevicePropCache.O000000o().O000000o(str, O000O0Oo(str2));
            return;
        }
        if (!fec.O00000oO().O000000o()) {
            BleDevicePropCache.O000000o().O000000o(str, O000O0Oo(str2));
        }
        fas.O000000o.f16038O000000o.O000000o(str, str2);
        if (!TextUtils.equals(fas.O000000o.f16038O000000o.O000000o(str), str2)) {
            BleDevicePropCache.O000000o().O000000o(str, O000O0Oo(str2));
        }
    }

    public static void O00000Oo(String str, byte[] bArr) {
        O0000Oo0(str, got.O00000o0(bArr));
    }

    public static String O0000o(String str) {
        if (fec.O00000oO().O000000o()) {
            String O00000Oo2 = fas.O000000o.f16038O000000o.O00000Oo(str);
            if (TextUtils.isEmpty(O00000Oo2)) {
                O00000Oo2 = O000O0OO(BleDevicePropCache.O000000o().O00000Oo(str));
                if (!TextUtils.isEmpty(O00000Oo2) && fas.O000000o.f16038O000000o.O00000Oo(str, O00000Oo2)) {
                    BleDevicePropCache.O000000o().O00000Oo(str, "");
                }
            }
            return O00000Oo2;
        }
        String O00000Oo3 = BleDevicePropCache.O000000o().O00000Oo(str);
        if (TextUtils.isEmpty(O00000Oo3)) {
            return fas.O000000o.f16038O000000o.O00000Oo(str);
        }
        return O000O0OO(O00000Oo3);
    }

    public static byte[] O0000oO0(String str) {
        String O0000o = O0000o(str);
        return TextUtils.isEmpty(O0000o) ? got.f18097O000000o : got.O000000o(O0000o);
    }

    public static void O0000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            fas.O000000o.f16038O000000o.O00000Oo(str, str2);
            BleDevicePropCache.O000000o().O00000Oo(str, O000O0Oo(str2));
            return;
        }
        if (!fec.O00000oO().O000000o()) {
            BleDevicePropCache.O000000o().O00000Oo(str, O000O0Oo(str2));
        }
        fas.O000000o.f16038O000000o.O00000Oo(str, str2);
        if (!TextUtils.equals(str2, fas.O000000o.f16038O000000o.O00000Oo(str))) {
            BleDevicePropCache.O000000o().O00000Oo(str, O000O0Oo(str2));
        }
    }

    public static void O00000o0(String str, byte[] bArr) {
        O0000Oo(str, got.O00000o0(bArr));
    }

    public static String O0000oO(String str) {
        if (fec.O00000oO().O000000o()) {
            String O00000o0 = fas.O000000o.f16038O000000o.O00000o0(str);
            if (TextUtils.isEmpty(O00000o0)) {
                O00000o0 = O000O0OO(BleDevicePropCache.O000000o().O00000o0(str));
                if (!TextUtils.isEmpty(O00000o0) && fas.O000000o.f16038O000000o.O00000o0(str, O00000o0)) {
                    BleDevicePropCache.O000000o().O00000o0(str, "");
                }
            }
            return O00000o0;
        }
        String O00000o02 = BleDevicePropCache.O000000o().O00000o0(str);
        if (TextUtils.isEmpty(O00000o02)) {
            return fas.O000000o.f16038O000000o.O00000o0(str);
        }
        return O000O0OO(O00000o02);
    }

    public static void O0000OoO(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            String O000000o2 = O000000o(str);
            fte.O00000Oo(O000000o2 + " set pin code is empty");
            fas.O000000o.f16038O000000o.O00000o0(str, str2);
            BleDevicePropCache.O000000o().O00000o0(str, O000O0Oo(str2));
            return;
        }
        if (!fec.O00000oO().O000000o()) {
            BleDevicePropCache.O000000o().O00000o0(str, O000O0Oo(str2));
        }
        fas.O000000o.f16038O000000o.O00000o0(str, str2);
        if (!TextUtils.equals(str2, fas.O000000o.f16038O000000o.O00000o0(str))) {
            BleDevicePropCache.O000000o().O00000o0(str, O000O0Oo(str2));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$26, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T */
    public static int O0000oOO(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Integer) O000000o2.O000000o(str, (BleDevicePropCache.O00000Oo) new BleDevicePropCache.O00000Oo<Integer>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass26 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Integer.valueOf(bleDeviceProp.ltmkEncryptType);
            }
        }, (Object) 0)).intValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$27, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O00000oo(String str, int i) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("ltmkEncryptType", i) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass27 */

            /* renamed from: O000000o */
            final /* synthetic */ int f6833O000000o;

            {
                this.f6833O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6833O000000o == bleDeviceProp.ltmkEncryptType) {
                    return false;
                }
                bleDeviceProp.ltmkEncryptType = this.f6833O000000o;
                return true;
            }
        }, true);
    }

    public static boolean O0000oOo(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return ((Boolean) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<Boolean>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass28 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return Boolean.valueOf(bleDeviceProp.showPincode);
            }
        }, Boolean.TRUE)).booleanValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$29, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, boolean z) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("setShowPincode", z) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass29 */

            /* renamed from: O000000o */
            final /* synthetic */ boolean f6835O000000o;

            {
                this.f6835O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6835O000000o == bleDeviceProp.showPincode) {
                    return false;
                }
                bleDeviceProp.showPincode = this.f6835O000000o;
                return true;
            }
        }, true);
    }

    private static String O00oOoOo(String str) {
        if (fec.O00000oO().O000000o()) {
            String O00000o = fas.O000000o.f16038O000000o.O00000o(str);
            if (TextUtils.isEmpty(O00000o)) {
                O00000o = O000O0OO(BleDevicePropCache.O000000o().O00000o(str));
                if (!TextUtils.isEmpty(O00000o) && fas.O000000o.f16038O000000o.O00000o(str, O00000o)) {
                    BleDevicePropCache.O000000o().O00000o(str, "");
                }
            }
            return O00000o;
        }
        String O00000o2 = BleDevicePropCache.O000000o().O00000o(str);
        if (TextUtils.isEmpty(O00000o2)) {
            return fas.O000000o.f16038O000000o.O00000o(str);
        }
        return O000O0OO(O00000o2);
    }

    public static String O0000oo0(String str) {
        String str2 = f16241O000000o.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String O00oOoOo = O00oOoOo(str);
        f16241O000000o.put(str, O00oOoOo);
        return O00oOoOo;
    }

    public static byte[] O0000oo(String str) {
        String O0000oo0 = O0000oo0(str);
        return TextUtils.isEmpty(O0000oo0) ? got.f18097O000000o : got.O000000o(O0000oo0);
    }

    public static void O0000Ooo(String str, String str2) {
        f16241O000000o.put(str, str2);
        if (TextUtils.isEmpty(str2)) {
            fas.O000000o.f16038O000000o.O00000o(str, str2);
            BleDevicePropCache.O000000o().O00000o(str, O000O0Oo(str2));
            return;
        }
        if (!fec.O00000oO().O000000o()) {
            BleDevicePropCache.O000000o().O00000o(str, O000O0Oo(str2));
        }
        fas.O000000o.f16038O000000o.O00000o(str, str2);
        if (!TextUtils.equals(str2, fas.O000000o.f16038O000000o.O00000o(str))) {
            BleDevicePropCache.O000000o().O00000o(str, O000O0Oo(str2));
        }
    }

    public static void O00000o(String str, byte[] bArr) {
        O0000Ooo(str, got.O00000o0(bArr));
    }

    public static String O0000ooO(String str) {
        if (fec.O00000oO().O000000o()) {
            String O00000oO = fas.O000000o.f16038O000000o.O00000oO(str);
            if (TextUtils.isEmpty(O00000oO)) {
                O00000oO = O000O0OO(BleDevicePropCache.O000000o().O00000oO(str));
                if (!TextUtils.isEmpty(O00000oO) && fas.O000000o.f16038O000000o.O00000oO(str, O00000oO)) {
                    BleDevicePropCache.O000000o().O00000oO(str, "");
                }
            }
            return O00000oO;
        }
        String O00000oO2 = BleDevicePropCache.O000000o().O00000oO(str);
        if (TextUtils.isEmpty(O00000oO2)) {
            fas.O000000o.f16038O000000o.O00000oO(str);
        }
        return O000O0OO(O00000oO2);
    }

    public static void O0000o00(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            fas.O000000o.f16038O000000o.O00000oO(str, str2);
            BleDevicePropCache.O000000o().O00000oO(str, O000O0Oo(str2));
            return;
        }
        if (!fec.O00000oO().O000000o()) {
            BleDevicePropCache.O000000o().O00000oO(str, O000O0Oo(str2));
        }
        fas.O000000o.f16038O000000o.O00000oO(str, str2);
        if (!TextUtils.equals(str2, fas.O000000o.f16038O000000o.O00000oO(str))) {
            BleDevicePropCache.O000000o().O00000oO(str, O000O0Oo(str2));
        }
    }

    public static String O0000ooo(String str) {
        if (fec.O00000oO().O000000o()) {
            String O00000oo = fas.O000000o.f16038O000000o.O00000oo(str);
            if (TextUtils.isEmpty(O00000oo)) {
                O00000oo = O000O0OO(BleDevicePropCache.O000000o().O00000oo(str));
                if (!TextUtils.isEmpty(O00000oo) && fas.O000000o.f16038O000000o.O00000oo(str, O00000oo)) {
                    BleDevicePropCache.O000000o().O00000oo(str, "");
                }
            }
            return O00000oo;
        }
        String O00000oo2 = BleDevicePropCache.O000000o().O00000oo(str);
        if (TextUtils.isEmpty(O00000oo2)) {
            return fas.O000000o.f16038O000000o.O00000oo(str);
        }
        return O000O0OO(O00000oo2);
    }

    public static void O0000o0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            fas.O000000o.f16038O000000o.O00000oo(str, str2);
            BleDevicePropCache.O000000o().O00000oo(str, O000O0Oo(str2));
            return;
        }
        if (!fec.O00000oO().O000000o()) {
            BleDevicePropCache.O000000o().O00000oo(str, O000O0Oo(str2));
        }
        fas.O000000o.f16038O000000o.O00000oo(str, str2);
        if (!TextUtils.equals(fas.O000000o.f16038O000000o.O00000oo(str), str2)) {
            BleDevicePropCache.O000000o().O00000oo(str, O000O0Oo(str2));
        }
    }

    public static BleGattProfile O00oOooO(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (BleGattProfile) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<BleGattProfile>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass43 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.profile;
            }
        }, (Object) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$44, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, BleGattProfile bleGattProfile) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("GattProfile", bleGattProfile) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass44 */

            /* renamed from: O000000o */
            final /* synthetic */ BleGattProfile f6852O000000o;

            {
                this.f6852O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                bleDeviceProp.profile = this.f6852O000000o;
                return true;
            }
        }, false);
    }

    public static String O0000o0O(String str, String str2) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        return (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>(str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass47 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6855O000000o;

            {
                this.f6855O000000o = r2;
            }

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.O00000Oo(this.f6855O000000o, "");
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$48, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, String str2, String str3) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("String extra", str3, str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass48 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6856O000000o;
            final /* synthetic */ String O00000Oo;

            {
                this.f6856O000000o = r3;
                this.O00000Oo = r4;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6856O000000o.equals(bleDeviceProp.O00000Oo(this.O00000Oo, ""))) {
                    return false;
                }
                bleDeviceProp.O000000o(this.O00000Oo, this.f6856O000000o);
                return true;
            }
        }, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$46, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O000000o(String str, String str2, boolean z) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("boolean extra", z, str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass46 */

            /* renamed from: O000000o */
            final /* synthetic */ boolean f6854O000000o;
            final /* synthetic */ String O00000Oo;

            {
                this.f6854O000000o = r3;
                this.O00000Oo = r4;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (this.f6854O000000o == bleDeviceProp.O000000o(this.O00000Oo)) {
                    return false;
                }
                try {
                    bleDeviceProp.extras.put(this.O00000Oo, this.f6854O000000o);
                    return true;
                } catch (JSONException e) {
                    gnk.O00000Oo(gnk.O00000Oo(e));
                    return true;
                }
            }
        }, true);
    }

    public static ArrayList<BtDevice> O00000Oo() {
        final ArrayList<BtDevice> arrayList = new ArrayList<>();
        BleDevicePropCache.O000000o().O000000o(new BleDevicePropCache.O00000o() {
            /* class _m_j.ffr.AnonymousClass1 */

            public final boolean O000000o(String str, BleDeviceProp bleDeviceProp) {
                if (bleDeviceProp.boundStatus != 1 || "xiaomi.ble.v1".equalsIgnoreCase(bleDeviceProp.model)) {
                    return false;
                }
                BtDevice btDevice = new BtDevice(str);
                ffd.O000000o().O000000o(btDevice);
                ffh.O000000o().O000000o(btDevice);
                arrayList.add(btDevice);
                return false;
            }
        });
        return arrayList;
    }

    public static ArrayList<BtDevice> O00000o0() {
        final ArrayList<BtDevice> arrayList = new ArrayList<>();
        BleDevicePropCache.O000000o().O000000o(new BleDevicePropCache.O00000o() {
            /* class _m_j.ffr.AnonymousClass2 */

            public final boolean O000000o(String str, BleDeviceProp bleDeviceProp) {
                if (!bleDeviceProp.O000000o("key.local.removed")) {
                    return false;
                }
                BtDevice btDevice = new BtDevice(str);
                ffd.O000000o().O000000o(btDevice);
                arrayList.add(btDevice);
                return false;
            }
        });
        return arrayList;
    }

    public static ArrayList<BtDevice> O00000o() {
        final ArrayList<BtDevice> arrayList = new ArrayList<>();
        BleDevicePropCache.O000000o().O000000o(new BleDevicePropCache.O00000o() {
            /* class _m_j.ffr.AnonymousClass3 */

            public final boolean O000000o(String str, BleDeviceProp bleDeviceProp) {
                if (bleDeviceProp.boundStatus != 2) {
                    return false;
                }
                BtDevice btDevice = new BtDevice(str);
                ffd.O000000o().O000000o(btDevice);
                arrayList.add(btDevice);
                return false;
            }
        });
        return arrayList;
    }

    public static List<BtDevice> O00000oO() {
        final ArrayList arrayList = new ArrayList();
        BleDevicePropCache.O000000o().O000000o(new BleDevicePropCache.O00000o() {
            /* class _m_j.ffr.AnonymousClass4 */

            public final boolean O000000o(String str, BleDeviceProp bleDeviceProp) {
                if (!bleDeviceProp.O000000o("key.miui.bind")) {
                    return false;
                }
                BtDevice btDevice = new BtDevice(str);
                ffd.O000000o().O000000o(btDevice);
                arrayList.add(btDevice);
                return false;
            }
        });
        return arrayList;
    }

    public static void O0000o0o(String str, String str2) {
        O00000Oo.put(str, str2);
    }

    public static String O00oOooo(String str) {
        return O00000Oo.get(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$37, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public static void O0000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            gnk.O00000o("Ble-OTA: remove update info");
        }
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        O000000o2.O000000o(str, (BleDevicePropCache.O0000O0o) new BleDevicePropCache.O0000O0o("ble.firmware.update.info", str2) {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass37 */

            /* renamed from: O000000o */
            final /* synthetic */ String f6844O000000o;

            {
                this.f6844O000000o = r3;
            }

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                String str = this.f6844O000000o;
                if (str == null) {
                    bleDeviceProp.extras.remove("ble.firmware.update.info");
                    return true;
                } else if (str.equals(bleDeviceProp.O00000Oo("ble.firmware.update.info", ""))) {
                    return false;
                } else {
                    bleDeviceProp.O000000o("ble.firmware.update.info", this.f6844O000000o);
                    return true;
                }
            }
        }, false);
    }

    public static BleMeshFirmwareUpdateInfo O000O00o(String str) {
        BleDevicePropCache O000000o2 = BleDevicePropCache.O000000o();
        String str2 = (String) O000000o2.O000000o(str, new BleDevicePropCache.O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass38 */

            public final /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.O00000Oo("ble.firmware.update.info", "");
            }
        }, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo = new BleMeshFirmwareUpdateInfo();
            bleMeshFirmwareUpdateInfo.version = jSONObject.optString("version");
            bleMeshFirmwareUpdateInfo.safeUrl = jSONObject.optString("safe_url");
            bleMeshFirmwareUpdateInfo.timeout = jSONObject.optInt("time_out", 30);
            bleMeshFirmwareUpdateInfo.url = jSONObject.optString("url");
            bleMeshFirmwareUpdateInfo.changeLog = jSONObject.optString("changeLog");
            bleMeshFirmwareUpdateInfo.md5 = jSONObject.optString("md5");
            String optString = jSONObject.optString("mcu_version");
            String optString2 = jSONObject.optString("mcu_safe_url");
            String optString3 = jSONObject.optString("mcu_md5");
            if (!TextUtils.isEmpty(optString)) {
                McuUpdateInfo mcuUpdateInfo = new McuUpdateInfo();
                mcuUpdateInfo.version = optString;
                mcuUpdateInfo.url = optString2;
                mcuUpdateInfo.md5 = optString3;
                bleMeshFirmwareUpdateInfo.mcuUpdateInfo = mcuUpdateInfo;
            }
            return bleMeshFirmwareUpdateInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
