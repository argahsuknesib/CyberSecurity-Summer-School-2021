package com.hzy.tvmao.ir.encode;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import bsh.Interpreter;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.StringUtil;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ZipCodeHelper {
    private static final SparseIntArray refMap = new SparseIntArray();
    private int frequency;
    private final SparseArray<FormatParam> keyFormatMap;
    private final FormatParam param;
    private boolean released = false;
    private final int remoteId;

    static {
        try {
            System.loadLibrary("kksdk");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static class KeyFormat {
        int functionId;
        int[][] status;

        private KeyFormat() {
        }
    }

    static class FormatParam {
        public String beanshellScript;
        public byte[] formateParam;
        public SparseArray<List<KeyFormat>> keyKeyMap;
        public String script;
        public SparseArray<List<KeyFormat>> statusKeyMap;
        public Map<String, byte[]> waveCodeMap;

        private FormatParam() {
        }
    }

    public int getRemoteId() {
        return this.remoteId;
    }

    public int getFrequency() {
        return this.frequency;
    }

    private SparseArray<List<KeyFormat>> getKeyKeyMap(FormatParam formatParam) {
        if (formatParam.keyKeyMap == null) {
            formatParam.keyKeyMap = new SparseArray<>();
        }
        return formatParam.keyKeyMap;
    }

    private SparseArray<List<KeyFormat>> getStatusKeyMap(FormatParam formatParam) {
        if (formatParam.statusKeyMap == null) {
            formatParam.statusKeyMap = new SparseArray<>();
        }
        return formatParam.statusKeyMap;
    }

    private void addKeyFormat(SparseArray<List<KeyFormat>> sparseArray, int i, KeyFormat keyFormat) {
        List list = sparseArray.get(i);
        if (list == null) {
            list = new ArrayList();
            sparseArray.put(i, list);
        }
        list.add(keyFormat);
    }

    private void sortKeyFormatList(SparseArray<List<KeyFormat>> sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            Collections.sort(sparseArray.valueAt(i), new Comparator<KeyFormat>() {
                /* class com.hzy.tvmao.ir.encode.ZipCodeHelper.AnonymousClass1 */

                public int compare(KeyFormat keyFormat, KeyFormat keyFormat2) {
                    if (keyFormat.status != null) {
                        return -1;
                    }
                    return keyFormat2.status != null ? 1 : 0;
                }
            });
        }
    }

    private FormatParam getFormatParam(Map<Integer, String> map, List<String> list) {
        int i;
        ZipCodeHelper zipCodeHelper = this;
        List<String> list2 = list;
        AnonymousClass1 r3 = null;
        FormatParam formatParam = new FormatParam();
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            String str = (String) next.getValue();
            char c = '&';
            int i2 = 0;
            int i3 = 1;
            if (intValue != 1510) {
                if (intValue == 1511) {
                    formatParam.beanshellScript = str.trim();
                } else if (intValue == 1514) {
                    formatParam.waveCodeMap = new HashMap();
                    for (String trim : str.trim().split("\\|")) {
                        String trim2 = trim.trim();
                        int indexOf = trim2.indexOf(38);
                        String trim3 = trim2.substring(0, indexOf).trim();
                        int i4 = indexOf + 1;
                        int indexOf2 = trim2.indexOf(38, i4);
                        String substring = trim2.substring(i4, indexOf2);
                        byte[] hex2Bytes = StringUtil.hex2Bytes(trim2.substring(indexOf2 + 1));
                        for (String str2 : substring.split(",")) {
                            formatParam.waveCodeMap.put(trim3 + "&" + str2, hex2Bytes);
                        }
                    }
                } else if (intValue == 1516) {
                    String[] split = str.trim().split("\\|");
                    int length = split.length;
                    int i5 = 0;
                    while (i5 < length) {
                        String trim4 = split[i5].trim();
                        int i6 = 0;
                        char c2 = 0;
                        while (true) {
                            if (i6 >= trim4.length()) {
                                i6 = 0;
                                break;
                            }
                            c2 = trim4.charAt(i6);
                            if (c2 == c || c2 == '@') {
                                break;
                            }
                            i6++;
                        }
                        int parseInt = Integer.parseInt(trim4.substring(i2, i6).trim());
                        int i7 = i6 + i3;
                        int indexOf3 = trim4.indexOf(c, i7);
                        String substring2 = trim4.substring(i7, indexOf3);
                        int parseInt2 = Integer.parseInt(trim4.substring(indexOf3 + i3).trim());
                        KeyFormat keyFormat = new KeyFormat();
                        keyFormat.functionId = parseInt2;
                        if (substring2.length() > 0) {
                            String[] split2 = substring2.split("$");
                            keyFormat.status = new int[split2.length][];
                            int i8 = 0;
                            while (i8 < split2.length) {
                                String str3 = split2[i8];
                                int indexOf4 = str3.indexOf(45);
                                int indexOf5 = str3.indexOf(44, indexOf4);
                                int parseInt3 = Integer.parseInt(str3.substring(i2, indexOf4));
                                int i9 = indexOf4 + 1;
                                if (indexOf5 > 0) {
                                    i = indexOf5;
                                } else {
                                    i = str3.length();
                                }
                                keyFormat.status[i8] = new int[]{parseInt3, Integer.parseInt(str3.substring(i9, i)), indexOf5 > 0 ? Integer.parseInt(str3.substring(indexOf5 + 1)) : 1};
                                i8++;
                                i2 = 0;
                            }
                        }
                        zipCodeHelper.addKeyFormat(c2 == '&' ? zipCodeHelper.getKeyKeyMap(formatParam) : zipCodeHelper.getStatusKeyMap(formatParam), parseInt, keyFormat);
                        i5++;
                        r3 = null;
                        c = '&';
                        i2 = 0;
                        i3 = 1;
                    }
                    if (formatParam.keyKeyMap != null) {
                        zipCodeHelper.sortKeyFormatList(formatParam.keyKeyMap);
                    }
                    if (formatParam.statusKeyMap != null) {
                        zipCodeHelper.sortKeyFormatList(formatParam.statusKeyMap);
                    }
                    r3 = null;
                } else if (intValue == 1518) {
                    formatParam.script = str.trim();
                } else if (intValue == 99999) {
                    formatParam.formateParam = StringUtil.hex2Bytes(str);
                } else if (list2 != null && intValue > 1000 && intValue < 1501) {
                    list2.add(intValue + "|" + str.trim());
                }
                list2 = list;
                r3 = null;
            } else if (!map.containsKey(1514)) {
                formatParam.waveCodeMap = new HashMap();
                int i10 = 1000000 / zipCodeHelper.frequency;
                for (String trim5 : str.trim().split("\\|")) {
                    String trim6 = trim5.trim();
                    int indexOf6 = trim6.indexOf(38);
                    String trim7 = trim6.substring(0, indexOf6).trim();
                    int i11 = indexOf6 + 1;
                    int indexOf7 = trim6.indexOf(38, i11);
                    String substring3 = trim6.substring(i11, indexOf7);
                    int[] parseIntArray = StringUtil.parseIntArray(trim6.substring(indexOf7 + 1), ",");
                    byte[] bArr = new byte[((parseIntArray.length * 2) + 1)];
                    bArr[0] = 0;
                    for (int i12 = 0; i12 < parseIntArray.length; i12++) {
                        int i13 = parseIntArray[i12] / i10;
                        int i14 = (i12 * 2) + 1;
                        bArr[i14] = (byte) (i13 >> 8);
                        bArr[i14 + 1] = (byte) (i13 & 255);
                    }
                    String[] split3 = substring3.split(",");
                    int length2 = split3.length;
                    int i15 = 0;
                    while (i15 < length2) {
                        formatParam.waveCodeMap.put(trim7 + "&" + split3[i15], bArr);
                        i15++;
                        split3 = split3;
                    }
                }
            }
            r3 = null;
            zipCodeHelper = this;
            list2 = list;
        }
        if (formatParam.script != null) {
            formatParam.beanshellScript = null;
        }
        return formatParam;
    }

    public ZipCodeHelper(int i, int i2, Map<Integer, String> map, Map<Integer, Map<Integer, String>> map2) {
        int i3;
        this.remoteId = i;
        this.frequency = i2 / 10;
        this.frequency *= 10;
        ArrayList arrayList = new ArrayList();
        this.param = getFormatParam(map, arrayList);
        if (map2 != null) {
            this.keyFormatMap = new SparseArray<>(map2.size());
            for (Map.Entry next : map2.entrySet()) {
                Map map3 = (Map) next.getValue();
                if (map3.size() > 0) {
                    this.keyFormatMap.put(((Integer) next.getKey()).intValue(), getFormatParam(map3, null));
                }
            }
        } else {
            this.keyFormatMap = null;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        synchronized (refMap) {
            i3 = refMap.get(i) + 1;
            refMap.put(i, i3);
        }
        if (i3 == 1) {
            CodeHelper.initRemote(i, 1, strArr);
        }
    }

    private byte[] addLeadZero(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 1)];
        bArr2[0] = 0;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0416  */
    public byte[] getKeyIr(int i, int i2, int i3, int i4, int i5, int i6, int i7, byte[] bArr, SparseIntArray sparseIntArray) {
        String str;
        String str2;
        int i8;
        FormatParam formatParam;
        int i9;
        int i10;
        SparseIntArray sparseIntArray2;
        List list;
        int i11;
        String str3;
        String str4;
        int[] iArr;
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i6;
        int i17 = i7;
        SparseIntArray sparseIntArray3 = sparseIntArray;
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        byte[] bArr2 = null;
        if (sparseIntArray3 == null || sparseIntArray.size() <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i18 = 0; i18 < sparseIntArray.size(); i18++) {
                int keyAt = sparseIntArray3.keyAt(i18);
                int i19 = sparseIntArray3.get(keyAt);
                sparseIntArray4.append(keyAt, i19);
                sb.append(keyAt);
                sb.append(',');
                sb.append(i19);
                sb.append('|');
            }
            sb.setLength(sb.length() - 1);
            str = sb.toString();
        }
        sparseIntArray4.append(1, i12);
        sparseIntArray4.append(2, i13);
        sparseIntArray4.append(3, i14);
        sparseIntArray4.append(4, i14);
        sparseIntArray4.append(5, i15);
        sparseIntArray4.append(7, i16);
        sparseIntArray4.append(6, i16);
        int i20 = sparseIntArray4.get(i17, -1);
        if (this.param.waveCodeMap != null && this.param.waveCodeMap.size() > 0) {
            byte[] bArr3 = this.param.waveCodeMap.get(i17 + "&" + i20);
            if (bArr3 == null) {
                bArr3 = this.param.waveCodeMap.get(i17 + "&");
            }
            if (bArr3 != null) {
                return bArr3;
            }
        }
        int i21 = i20;
        SparseIntArray sparseIntArray5 = sparseIntArray4;
        byte[][] enc = CodeHelper.enc(this.remoteId, i, i2, i3, i4, i5, i6, i7, bArr, str);
        StringBuilder sb2 = new StringBuilder("****byteArray:");
        String str5 = "null";
        if (enc == null) {
            str2 = str5;
        } else {
            str2 = "size=" + enc.length;
        }
        sb2.append(str2);
        LogUtil.i(sb2.toString());
        if (enc != null && enc.length > 0) {
            StringBuilder sb3 = new StringBuilder("****bytesArray[0]:");
            if (enc[0] != null) {
                str5 = "size=" + enc[0].length;
            }
            sb3.append(str5);
            LogUtil.i(sb3.toString());
            bArr2 = enc[0];
        }
        byte[] bArr4 = bArr2;
        String str6 = "evaluate script failed for remote ";
        String str7 = "CodeHelper";
        if (this.param.script == null || this.param.script.length() <= 0) {
            int i22 = i6;
            String str8 = str6;
            String str9 = str7;
            i8 = i7;
            if (this.param.beanshellScript != null && this.param.beanshellScript.length() > 0) {
                Interpreter interpreter = new Interpreter();
                try {
                    interpreter.O000000o("bytes", enc[0]);
                    interpreter.O000000o("power", i12);
                    interpreter.O000000o("mode", i13);
                    interpreter.O000000o("temperature", i14);
                    interpreter.O000000o("windSpeed", i15);
                    interpreter.O000000o("udWindMode", i22);
                    interpreter.O000000o("functionId", i8);
                    interpreter.O000000o(this.param.beanshellScript);
                } catch (Exception e) {
                    Log.e(str9, str8 + this.remoteId, e);
                }
            }
        } else {
            LuaState newLuaState = LuaStateFactory.newLuaState();
            try {
                newLuaState.openLibs();
                newLuaState.newTable();
                int i23 = 0;
                while (i23 < bArr4.length) {
                    str3 = str6;
                    String str10 = str7;
                    try {
                        newLuaState.pushNumber((double) (bArr4[i23] & 255));
                        i23++;
                        newLuaState.rawSetI(-2, (long) i23);
                        str6 = str3;
                        str7 = str10;
                    } catch (Exception e2) {
                        e = e2;
                        i8 = i7;
                        str4 = str10;
                        try {
                            Log.e(str4, str3 + this.remoteId, e);
                            newLuaState.close();
                            formatParam = this.param;
                            if (this.keyFormatMap != null) {
                            }
                            if (formatParam == this.param) {
                            }
                        } catch (Throwable th) {
                            newLuaState.close();
                            throw th;
                        }
                    }
                }
                str3 = str6;
                String str11 = str7;
                newLuaState.setGlobal("bytes");
                newLuaState.pushNumber((double) i12);
                newLuaState.setGlobal("power");
                newLuaState.pushNumber((double) i13);
                newLuaState.setGlobal("mode");
                newLuaState.pushNumber((double) i14);
                newLuaState.setGlobal("temperature");
                newLuaState.pushNumber((double) i15);
                newLuaState.setGlobal("windSpeed");
                try {
                    newLuaState.pushNumber((double) i6);
                    newLuaState.setGlobal("udWindMode");
                    i8 = i7;
                } catch (Exception e3) {
                    e = e3;
                    i8 = i7;
                    str4 = str11;
                    Log.e(str4, str3 + this.remoteId, e);
                    newLuaState.close();
                    formatParam = this.param;
                    if (this.keyFormatMap != null) {
                    }
                    if (formatParam == this.param) {
                    }
                }
                try {
                    newLuaState.pushNumber((double) i8);
                    newLuaState.setGlobal("functionId");
                    SparseIntArray sparseIntArray6 = sparseIntArray;
                    if (sparseIntArray6 != null && sparseIntArray.size() > 0) {
                        newLuaState.newTable();
                        for (int i24 = 0; i24 < sparseIntArray.size(); i24++) {
                            int keyAt2 = sparseIntArray6.keyAt(i24);
                            int i25 = sparseIntArray6.get(keyAt2);
                            newLuaState.pushNumber((double) keyAt2);
                            newLuaState.pushNumber((double) i25);
                            newLuaState.rawSet(-3);
                        }
                        newLuaState.setGlobal("exts");
                    }
                    int LdoString = newLuaState.LdoString(this.param.script);
                    if (LdoString == 0) {
                        try {
                            newLuaState.getGlobal("bytes");
                            newLuaState.pushNil();
                            ArrayList arrayList = new ArrayList();
                            while (newLuaState.next(-2) != 0) {
                                try {
                                    iArr = new int[2];
                                    iArr[0] = (int) newLuaState.toInteger(-2);
                                    try {
                                    } catch (Exception e4) {
                                        e = e4;
                                        str4 = str11;
                                        Log.e(str4, str3 + this.remoteId, e);
                                        newLuaState.close();
                                        formatParam = this.param;
                                        if (this.keyFormatMap != null) {
                                        }
                                        if (formatParam == this.param) {
                                        }
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    str4 = str11;
                                    Log.e(str4, str3 + this.remoteId, e);
                                    newLuaState.close();
                                    formatParam = this.param;
                                    if (this.keyFormatMap != null) {
                                    }
                                    if (formatParam == this.param) {
                                    }
                                }
                                try {
                                    iArr[1] = (int) newLuaState.toInteger(-1);
                                    arrayList.add(iArr);
                                    newLuaState.pop(1);
                                } catch (Exception e6) {
                                    e = e6;
                                    str4 = str11;
                                    Log.e(str4, str3 + this.remoteId, e);
                                    newLuaState.close();
                                    formatParam = this.param;
                                    if (this.keyFormatMap != null) {
                                    }
                                    if (formatParam == this.param) {
                                    }
                                }
                            }
                            Collections.sort(arrayList, new Comparator<int[]>() {
                                /* class com.hzy.tvmao.ir.encode.ZipCodeHelper.AnonymousClass2 */

                                public int compare(int[] iArr, int[] iArr2) {
                                    return iArr[0] - iArr2[0];
                                }
                            });
                            bArr4 = new byte[arrayList.size()];
                            for (int i26 = 0; i26 < arrayList.size(); i26++) {
                                bArr4[i26] = (byte) ((int[]) arrayList.get(i26))[1];
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str4 = str11;
                            Log.e(str4, str3 + this.remoteId, e);
                            newLuaState.close();
                            formatParam = this.param;
                            if (this.keyFormatMap != null) {
                            }
                            if (formatParam == this.param) {
                            }
                        }
                        newLuaState.close();
                    } else {
                        str4 = str11;
                        try {
                            Log.e(str4, "evaluate script return error (" + LdoString + ") for remote " + this.remoteId);
                        } catch (Exception e8) {
                            e = e8;
                        }
                        newLuaState.close();
                    }
                } catch (Exception e9) {
                    e = e9;
                    str4 = str11;
                    Log.e(str4, str3 + this.remoteId, e);
                    newLuaState.close();
                    formatParam = this.param;
                    if (this.keyFormatMap != null) {
                    }
                    if (formatParam == this.param) {
                    }
                }
            } catch (Exception e10) {
                e = e10;
                str3 = str6;
                str4 = str7;
                i8 = i7;
                Log.e(str4, str3 + this.remoteId, e);
                newLuaState.close();
                formatParam = this.param;
                if (this.keyFormatMap != null) {
                }
                if (formatParam == this.param) {
                }
            }
        }
        formatParam = this.param;
        if (this.keyFormatMap != null) {
            if (formatParam.keyKeyMap != null && (list = this.param.keyKeyMap.get(i8)) != null) {
                Iterator it = list.iterator();
                i10 = -1;
                while (true) {
                    if (!it.hasNext()) {
                        i9 = 1;
                        break;
                    }
                    KeyFormat keyFormat = (KeyFormat) it.next();
                    if (keyFormat.status != null) {
                        int[][] iArr2 = keyFormat.status;
                        int length = iArr2.length;
                        int i27 = 0;
                        while (true) {
                            if (i27 >= length) {
                                i11 = i21;
                                i9 = 1;
                                break;
                            }
                            int[] iArr3 = iArr2[i27];
                            i11 = i21;
                            if (iArr3[0] <= i11) {
                                i9 = 1;
                                if (iArr3[1] >= i11 && (i11 - iArr3[0]) % iArr3[2] == 0) {
                                    break;
                                }
                            }
                            i27++;
                            i21 = i11;
                        }
                    } else {
                        i11 = i21;
                        i9 = 1;
                    }
                    i10 = keyFormat.functionId;
                    if (i10 >= 0) {
                        break;
                    }
                    i21 = i11;
                }
            } else {
                i9 = 1;
                i10 = -1;
            }
            if (i10 < 0 && this.param.statusKeyMap != null) {
                int i28 = 0;
                while (i28 < this.param.statusKeyMap.size()) {
                    int keyAt3 = this.param.statusKeyMap.keyAt(i28);
                    List list2 = this.param.statusKeyMap.get(keyAt3);
                    if (list2 != null) {
                        sparseIntArray2 = sparseIntArray5;
                        int i29 = sparseIntArray2.get(keyAt3, -1);
                        if (i29 >= 0) {
                            Iterator it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                KeyFormat keyFormat2 = (KeyFormat) it2.next();
                                if (keyFormat2.status != null) {
                                    int[][] iArr4 = keyFormat2.status;
                                    int length2 = iArr4.length;
                                    int i30 = 0;
                                    while (true) {
                                        if (i30 >= length2) {
                                            break;
                                        }
                                        int[] iArr5 = iArr4[i30];
                                        if (iArr5[0] <= i29 && iArr5[i9] >= i29) {
                                            if ((i29 - iArr5[0]) % iArr5[2] == 0) {
                                                break;
                                            }
                                        }
                                        i30++;
                                    }
                                }
                                i10 = keyFormat2.functionId;
                                if (i10 >= 0) {
                                    break;
                                }
                            }
                            if (i10 >= 0) {
                                break;
                            }
                            i28++;
                            sparseIntArray5 = sparseIntArray2;
                        }
                    } else {
                        sparseIntArray2 = sparseIntArray5;
                    }
                    i28++;
                    sparseIntArray5 = sparseIntArray2;
                }
            }
            FormatParam formatParam2 = this.keyFormatMap.get(i10);
            if (formatParam2 != null) {
                formatParam = formatParam2;
            }
        } else {
            i9 = 1;
        }
        if (formatParam == this.param) {
            return addLeadZero(bArr4);
        }
        byte[] bArr5 = new byte[(formatParam.formateParam.length + i9 + bArr4.length)];
        bArr5[0] = (byte) formatParam.formateParam.length;
        System.arraycopy(formatParam.formateParam, 0, bArr5, i9, formatParam.formateParam.length);
        System.arraycopy(bArr4, 0, bArr5, formatParam.formateParam.length + i9, bArr4.length);
        return bArr5;
    }

    public synchronized void release() {
        int i;
        if (!this.released) {
            synchronized (refMap) {
                i = refMap.get(this.remoteId) - 1;
                if (i > 0) {
                    refMap.put(this.remoteId, i);
                } else {
                    refMap.delete(this.remoteId);
                }
            }
            if (i == 0) {
                CodeHelper.release(this.remoteId);
            }
            this.released = true;
        }
    }
}
