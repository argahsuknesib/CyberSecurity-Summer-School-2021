package _m_j;

import com.xiaomi.zxing.NotFoundException;

final class igc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f1266O000000o = new Object();
    private static final Object[][] O00000Oo = {new Object[]{"00", 18}, new Object[]{"01", 14}, new Object[]{"02", 14}, new Object[]{"10", f1266O000000o, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{"17", 6}, new Object[]{"20", 2}, new Object[]{"21", f1266O000000o, 20}, new Object[]{"22", f1266O000000o, 29}, new Object[]{"30", f1266O000000o, 8}, new Object[]{"37", f1266O000000o, 8}, new Object[]{"90", f1266O000000o, 30}, new Object[]{"91", f1266O000000o, 30}, new Object[]{"92", f1266O000000o, 30}, new Object[]{"93", f1266O000000o, 30}, new Object[]{"94", f1266O000000o, 30}, new Object[]{"95", f1266O000000o, 30}, new Object[]{"96", f1266O000000o, 30}, new Object[]{"97", f1266O000000o, 30}, new Object[]{"98", f1266O000000o, 30}, new Object[]{"99", f1266O000000o, 30}};
    private static final Object[][] O00000o = {new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", f1266O000000o, 15}, new Object[]{"391", f1266O000000o, 18}, new Object[]{"392", f1266O000000o, 15}, new Object[]{"393", f1266O000000o, 18}, new Object[]{"703", f1266O000000o, 30}};
    private static final Object[][] O00000o0 = {new Object[]{"240", f1266O000000o, 30}, new Object[]{"241", f1266O000000o, 30}, new Object[]{"242", f1266O000000o, 6}, new Object[]{"250", f1266O000000o, 30}, new Object[]{"251", f1266O000000o, 30}, new Object[]{"253", f1266O000000o, 17}, new Object[]{"254", f1266O000000o, 20}, new Object[]{"400", f1266O000000o, 30}, new Object[]{"401", f1266O000000o, 30}, new Object[]{"402", 17}, new Object[]{"403", f1266O000000o, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", f1266O000000o, 20}, new Object[]{"421", f1266O000000o, 15}, new Object[]{"422", 3}, new Object[]{"423", f1266O000000o, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};
    private static final Object[][] O00000oO = {new Object[]{"7001", 13}, new Object[]{"7002", f1266O000000o, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", f1266O000000o, 20}, new Object[]{"8003", f1266O000000o, 30}, new Object[]{"8004", f1266O000000o, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", f1266O000000o, 30}, new Object[]{"8008", f1266O000000o, 12}, new Object[]{"8018", 18}, new Object[]{"8020", f1266O000000o, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", f1266O000000o, 70}, new Object[]{"8200", f1266O000000o, 70}};

    static String O000000o(String str) throws NotFoundException {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() >= 2) {
            String substring = str.substring(0, 2);
            Object[][] objArr = O00000Oo;
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object[] objArr2 = objArr[i];
                if (!objArr2[0].equals(substring)) {
                    i++;
                } else if (objArr2[1] == f1266O000000o) {
                    return O00000Oo(2, ((Integer) objArr2[2]).intValue(), str);
                } else {
                    return O000000o(2, ((Integer) objArr2[1]).intValue(), str);
                }
            }
            if (str.length() >= 3) {
                String substring2 = str.substring(0, 3);
                Object[][] objArr3 = O00000o0;
                int length2 = objArr3.length;
                int i2 = 0;
                while (i2 < length2) {
                    Object[] objArr4 = objArr3[i2];
                    if (!objArr4[0].equals(substring2)) {
                        i2++;
                    } else if (objArr4[1] == f1266O000000o) {
                        return O00000Oo(3, ((Integer) objArr4[2]).intValue(), str);
                    } else {
                        return O000000o(3, ((Integer) objArr4[1]).intValue(), str);
                    }
                }
                Object[][] objArr5 = O00000o;
                int length3 = objArr5.length;
                int i3 = 0;
                while (i3 < length3) {
                    Object[] objArr6 = objArr5[i3];
                    if (!objArr6[0].equals(substring2)) {
                        i3++;
                    } else if (objArr6[1] == f1266O000000o) {
                        return O00000Oo(4, ((Integer) objArr6[2]).intValue(), str);
                    } else {
                        return O000000o(4, ((Integer) objArr6[1]).intValue(), str);
                    }
                }
                if (str.length() >= 4) {
                    String substring3 = str.substring(0, 4);
                    Object[][] objArr7 = O00000oO;
                    int length4 = objArr7.length;
                    int i4 = 0;
                    while (i4 < length4) {
                        Object[] objArr8 = objArr7[i4];
                        if (!objArr8[0].equals(substring3)) {
                            i4++;
                        } else if (objArr8[1] == f1266O000000o) {
                            return O00000Oo(4, ((Integer) objArr8[2]).intValue(), str);
                        } else {
                            return O000000o(4, ((Integer) objArr8[1]).intValue(), str);
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String O000000o(int i, int i2, String str) throws NotFoundException {
        if (str.length() >= i) {
            String substring = str.substring(0, i);
            int i3 = i2 + i;
            if (str.length() >= i3) {
                String substring2 = str.substring(i, i3);
                String str2 = "(" + substring + ')' + substring2;
                String O000000o2 = O000000o(str.substring(i3));
                if (O000000o2 == null) {
                    return str2;
                }
                return str2 + O000000o2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String O00000Oo(int i, int i2, String str) throws NotFoundException {
        String substring = str.substring(0, i);
        int i3 = i2 + i;
        if (str.length() < i3) {
            i3 = str.length();
        }
        String substring2 = str.substring(i, i3);
        String str2 = "(" + substring + ')' + substring2;
        String O000000o2 = O000000o(str.substring(i3));
        if (O000000o2 == null) {
            return str2;
        }
        return str2 + O000000o2;
    }
}
