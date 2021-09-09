package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class bms {
    private static bms O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    private Object f13114O000000o = null;
    private Context O00000Oo = null;

    private bms() {
        try {
            if (blw.f13081O000000o != null) {
                this.O00000Oo = blw.f13081O000000o;
                this.f13114O000000o = bna.O000000o(blw.f13081O000000o, bnd.O00000o0("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[]{String.class}, new Object[]{bnd.O00000o0("8f9790919a")});
            }
        } catch (Exception unused) {
        }
    }

    private static int O000000o(Object obj, String str, Object... objArr) {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    public static bms O000000o() {
        if (O00000o0 == null) {
            synchronized (bms.class) {
                if (O00000o0 == null) {
                    O00000o0 = new bms();
                }
            }
        }
        return O00000o0;
    }

    private static CellLocation O000000o(List<?> list) {
        List<?> list2 = list;
        if (list2 == null || list.isEmpty()) {
            return null;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i = 0;
        GsmCellLocation gsmCellLocation = null;
        CdmaCellLocation cdmaCellLocation = null;
        char c = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            Object obj = list2.get(i);
            if (obj != null) {
                try {
                    Class<?> loadClass = systemClassLoader.loadClass(bnd.O00000o0("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990b88c92"));
                    Class<?> loadClass2 = systemClassLoader.loadClass(bnd.O00000o0("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990a89c9b929e"));
                    Class<?> loadClass3 = systemClassLoader.loadClass(bnd.O00000o0("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990b38b9a"));
                    Class<?> loadClass4 = systemClassLoader.loadClass(bnd.O00000o0("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990bc9b929e"));
                    c = loadClass.isInstance(obj) ? 1 : loadClass2.isInstance(obj) ? 2 : loadClass3.isInstance(obj) ? 3 : loadClass4.isInstance(obj) ? (char) 4 : 0;
                    if (c > 0) {
                        Object O00000Oo2 = O00000Oo(c == 1 ? loadClass.cast(obj) : c == 2 ? loadClass2.cast(obj) : c == 3 ? loadClass3.cast(obj) : c == 4 ? loadClass4.cast(obj) : null, bnd.O00000o0("989a8bbc9a9393b69b9a918b968b86"), new Object[0]);
                        if (O00000Oo2 != null) {
                            if (c == 4) {
                                CdmaCellLocation cdmaCellLocation2 = new CdmaCellLocation();
                                try {
                                    cdmaCellLocation2.setCellLocationData(O000000o(O00000Oo2, bnd.O00000o0("989a8bbd9e8c9a8c8b9e8b969091b69b"), new Object[0]), O000000o(O00000Oo2, bnd.O00000o0("989a8bb39e8b968b8a9b9a"), new Object[0]), O000000o(O00000Oo2, bnd.O00000o0("989a8bb3909198968b8a9b9a"), new Object[0]), O000000o(O00000Oo2, bnd.O00000o0("989a8bac868c8b9a92b69b"), new Object[0]), O000000o(O00000Oo2, bnd.O00000o0("989a8bb19a8b88908d94b69b"), new Object[0]));
                                    cdmaCellLocation = cdmaCellLocation2;
                                    break;
                                } catch (Exception unused) {
                                    cdmaCellLocation = cdmaCellLocation2;
                                }
                            } else if (c == 3) {
                                try {
                                    int O000000o2 = O000000o(O00000Oo2, bnd.O00000o0("989a8bab9e9c"), new Object[0]);
                                    int O000000o3 = O000000o(O00000Oo2, bnd.O00000o0("989a8bbc96"), new Object[0]);
                                    GsmCellLocation gsmCellLocation2 = new GsmCellLocation();
                                    try {
                                        gsmCellLocation2.setLacAndCid(O000000o2, O000000o3);
                                        gsmCellLocation = gsmCellLocation2;
                                        break;
                                    } catch (Exception unused2) {
                                        gsmCellLocation = gsmCellLocation2;
                                    }
                                } catch (Exception unused3) {
                                    continue;
                                }
                            } else {
                                int O000000o4 = O000000o(O00000Oo2, bnd.O00000o0("989a8bb39e9c"), new Object[0]);
                                int O000000o5 = O000000o(O00000Oo2, bnd.O00000o0("989a8bbc969b"), new Object[0]);
                                GsmCellLocation gsmCellLocation3 = new GsmCellLocation();
                                try {
                                    gsmCellLocation3.setLacAndCid(O000000o4, O000000o5);
                                    gsmCellLocation = gsmCellLocation3;
                                    break;
                                } catch (Exception unused4) {
                                    gsmCellLocation = gsmCellLocation3;
                                }
                            }
                        }
                    }
                } catch (Exception unused5) {
                }
            }
            i++;
        }
        return c == 4 ? cdmaCellLocation : gsmCellLocation;
    }

    private Object O000000o(String str) {
        try {
            if (this.O00000Oo == null) {
                return null;
            }
            return bna.O000000o(this.O00000Oo.getApplicationContext(), bnd.O00000o0("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[]{String.class}, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object O00000Oo(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        Class<Integer>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    private static int O0000O0o() {
        try {
            Class.forName(bnd.O00000o0("9e919b8d90969bd18b9a939a8f97909186d1b2ac9692ab9a939a8f97909186b29e919e989a8d"));
            return 1;
        } catch (Exception unused) {
            try {
                Class.forName(bnd.O00000o0("9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8dcd"));
                return 2;
            } catch (SecurityException unused2) {
                return -1001;
            } catch (Exception unused3) {
                return 0;
            }
        }
    }

    private static Class<?> O0000OOo() {
        String str;
        String str2;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int O0000O0o = O0000O0o();
        if (O0000O0o == 0) {
            str2 = "9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8d";
        } else if (O0000O0o == 1) {
            str2 = "9e919b8d90969bd18b9a939a8f97909186d1b2ac9692ab9a939a8f97909186b29e919e989a8d";
        } else if (O0000O0o != 2) {
            str = null;
            return systemClassLoader.loadClass(str);
        } else {
            str2 = "9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8dcd";
        }
        str = bnd.O00000o0(str2);
        try {
            return systemClassLoader.loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String O000000o(int i) {
        try {
            bnd.O00000o0("b1b0afbaadb2");
            if (this.f13114O000000o == null) {
                return "";
            }
            return (String) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bbb9a89969c9ab69b"), new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        } catch (Exception | SecurityException unused) {
            return "";
        }
    }

    public final String O00000Oo() {
        String str;
        try {
            bnd.O00000o0("b1b0afbaadb2");
            return (this.f13114O000000o == null || (str = (String) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bbb9a89969c9ab69b"))) == null) ? "" : str;
        } catch (Exception | SecurityException unused) {
            return "";
        }
    }

    public final String O00000o() {
        String str;
        try {
            bnd.O00000o0("b1b0afbaadb2");
            return (this.f13114O000000o == null || (str = (String) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bac8a9d8c9c8d969d9a8db69b"))) == null) ? "" : str;
        } catch (Exception | SecurityException unused) {
            return "";
        }
    }

    public final String O00000o0() {
        try {
            if (this.f13114O000000o == null) {
                return "";
            }
            String str = (String) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bac9692b08f9a8d9e8b908d"));
            if (str != null) {
                try {
                    if (str.isEmpty()) {
                    }
                } catch (Exception unused) {
                }
                return str;
            }
            String str2 = (String) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bb19a8b88908d94b08f9a8d9e8b908db19e929a"));
            return str2 == null ? "" : str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public final String O00000oO() {
        String str;
        try {
            bnd.O00000o0("b1b0afbaadb2");
            return (this.f13114O000000o == null || (str = (String) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bac9692ac9a8d969e93b18a929d9a8d"))) == null) ? "" : str;
        } catch (Exception | SecurityException unused) {
            return "";
        }
    }

    public final HashMap<String, String> O00000oo() {
        String str;
        String O00000o02;
        int baseStationLongitude;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            PackageManager packageManager = this.O00000Oo.getPackageManager();
            int checkPermission = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", this.O00000Oo.getPackageName());
            int checkPermission2 = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", this.O00000Oo.getPackageName());
            if (checkPermission != 0 && checkPermission2 != 0) {
                return hashMap;
            }
            str = bnd.O00000o0("b1b0afbaadb2");
            try {
                CellLocation O0000Oo0 = O0000Oo0();
                if (O0000Oo0 == null && this.f13114O000000o != null) {
                    O0000Oo0 = (CellLocation) bna.O000000o(this.f13114O000000o, bnd.O00000o0("989a8bbc9a9393b3909c9e8b969091"));
                }
                if (O0000Oo0 != null) {
                    if (O0000Oo0 instanceof GsmCellLocation) {
                        hashMap.put("type", bnd.O00000o0("988c92"));
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) O0000Oo0;
                        hashMap.put(bnd.O00000o0("9c969b"), String.valueOf(gsmCellLocation.getCid()));
                        O00000o02 = bnd.O00000o0("939e9c");
                        baseStationLongitude = gsmCellLocation.getLac();
                    } else if (O0000Oo0 instanceof CdmaCellLocation) {
                        hashMap.put("type", bnd.O00000o0("9c9b929e"));
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) O0000Oo0;
                        hashMap.put(bnd.O00000o0("9d969b"), String.valueOf(cdmaCellLocation.getBaseStationId()));
                        hashMap.put(bnd.O00000o0("91969b"), String.valueOf(cdmaCellLocation.getNetworkId()));
                        hashMap.put(bnd.O00000o0("8c969b"), String.valueOf(cdmaCellLocation.getSystemId()));
                        hashMap.put(bnd.O00000o0("939e8b"), String.valueOf(cdmaCellLocation.getBaseStationLatitude()));
                        O00000o02 = bnd.O00000o0("939198");
                        baseStationLongitude = cdmaCellLocation.getBaseStationLongitude();
                    }
                    hashMap.put(O00000o02, String.valueOf(baseStationLongitude));
                }
            } catch (Exception unused) {
                hashMap.put("type", str);
                return hashMap;
            }
            return hashMap;
        } catch (Exception unused2) {
            str = "";
            hashMap.put("type", str);
            return hashMap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022 A[Catch:{ Exception -> 0x0097 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023 A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f A[Catch:{ Exception -> 0x0097 }] */
    private CellLocation O0000Oo0() {
        Object obj;
        CellLocation cellLocation;
        Object obj2;
        Object obj3;
        List list;
        String str;
        try {
            int O0000O0o = O0000O0o();
            if (O0000O0o == 0) {
                str = "8f9790919a";
            } else if (O0000O0o == 1) {
                str = "8f9790919aa0928c9692";
            } else if (O0000O0o != 2) {
                obj = null;
                if (obj != null) {
                    return null;
                }
                Class<?> O0000OOo = O0000OOo();
                if (O0000OOo.isInstance(obj)) {
                    Object cast = O0000OOo.cast(obj);
                    String O00000o02 = bnd.O00000o0("989a8bbc9a9393b3909c9e8b969091");
                    try {
                        obj2 = O00000Oo(cast, O00000o02, new Object[0]);
                    } catch (Exception unused) {
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        try {
                            obj2 = O00000Oo(cast, O00000o02, 0);
                            if (obj2 == null) {
                                obj2 = O00000Oo(cast, O00000o02, 1);
                            }
                        } catch (Exception e) {
                            bmz.O000000o(e);
                        }
                    }
                    if (obj2 == null) {
                        try {
                            obj3 = O00000Oo(cast, bnd.O00000o0("989a8bbc9a9393b3909c9e8b969091b89a92969196"), 1);
                        } catch (Exception unused2) {
                        }
                        if (obj3 != null) {
                            try {
                                list = (List) O00000Oo(cast, bnd.O00000o0("989a8bbe9393bc9a9393b6919990"), new Object[0]);
                            } catch (Exception unused3) {
                                list = null;
                            }
                            cellLocation = O000000o(list);
                        } else {
                            cellLocation = obj3;
                        }
                    }
                    obj3 = obj2;
                    if (obj3 != null) {
                    }
                } else {
                    cellLocation = null;
                }
                if (cellLocation != null) {
                    return cellLocation;
                }
                return null;
            } else {
                str = "8f9790919acd";
            }
            obj = O000000o(bnd.O00000o0(str));
            if (obj != null) {
            }
        } catch (Exception unused4) {
            return null;
        }
    }
}
