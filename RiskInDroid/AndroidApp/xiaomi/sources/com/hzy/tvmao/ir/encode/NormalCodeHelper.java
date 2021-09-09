package com.hzy.tvmao.ir.encode;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import bsh.Interpreter;
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

public class NormalCodeHelper {
    private static final SparseIntArray refMap = new SparseIntArray();
    private final SparseArray<FormatParam> keyFormatMap;
    private final FormatParam param;
    private boolean released = false;
    private final int remoteId;

    static class KeyFormat {
        int functionId;
        int[][] status;

        private KeyFormat() {
        }
    }

    static class FormatParam {
        public boolean addTrailerOne;
        public String beanshellScript;
        public SparseIntArray byteBitNums;
        int byteNum;
        public SparseArray<int[]> delayCodes;
        public SparseArray<List<KeyFormat>> keyKeyMap;
        public int[] leadCodes;
        public boolean littleEndian;
        public int[] oneCodes;
        int[][] patterns;
        public int repeatCount;
        public String script;
        public SparseArray<List<KeyFormat>> statusKeyMap;
        public Map<String, int[]> waveCodeMap;
        public int[] zeroCodes;

        private FormatParam() {
            this.repeatCount = 1;
            this.littleEndian = false;
            this.addTrailerOne = true;
            this.patterns = null;
            this.byteNum = 0;
        }
    }

    public int getRemoteId() {
        return this.remoteId;
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
                /* class com.hzy.tvmao.ir.encode.NormalCodeHelper.AnonymousClass1 */

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
        List<String> list2 = list;
        FormatParam formatParam = new FormatParam();
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            String str = (String) next.getValue();
            int i2 = 0;
            int i3 = 1;
            if (intValue == 306) {
                boolean z = true;
                if (Integer.parseInt(str.trim()) != 1) {
                    z = false;
                }
                formatParam.littleEndian = z;
            } else if (intValue == 307) {
                boolean z2 = true;
                if (Integer.parseInt(str.trim()) == 1) {
                    z2 = false;
                }
                formatParam.addTrailerOne = z2;
            } else if (intValue == 309) {
                String[] split = str.trim().split("\\|");
                ArrayList arrayList = new ArrayList();
                for (String trim : split) {
                    String trim2 = trim.trim();
                    if (trim2.length() != 0) {
                        arrayList.add(StringUtil.parseIntArray(trim2, ","));
                    }
                }
                formatParam.patterns = (int[][]) arrayList.toArray(new int[arrayList.size()][]);
            } else if (intValue != 310) {
                int i4 = 38;
                if (intValue == 1516) {
                    for (String trim3 : str.trim().split("\\|")) {
                        String trim4 = trim3.trim();
                        char c = 0;
                        int i5 = 0;
                        while (true) {
                            if (i5 < trim4.length()) {
                                c = trim4.charAt(i5);
                                if (!(c == '&' || c == '@')) {
                                    i5++;
                                }
                            } else {
                                i5 = 0;
                            }
                        }
                        int parseInt = Integer.parseInt(trim4.substring(0, i5).trim());
                        int i6 = i5 + 1;
                        int indexOf = trim4.indexOf(38, i6);
                        String substring = trim4.substring(i6, indexOf);
                        int parseInt2 = Integer.parseInt(trim4.substring(indexOf + 1).trim());
                        KeyFormat keyFormat = new KeyFormat();
                        keyFormat.functionId = parseInt2;
                        if (substring.length() > 0) {
                            String[] split2 = substring.split("$");
                            keyFormat.status = new int[split2.length][];
                            for (int i7 = 0; i7 < split2.length; i7++) {
                                String str2 = split2[i7];
                                int indexOf2 = str2.indexOf(45);
                                int indexOf3 = str2.indexOf(44, indexOf2);
                                int parseInt3 = Integer.parseInt(str2.substring(0, indexOf2));
                                int i8 = indexOf2 + 1;
                                if (indexOf3 > 0) {
                                    i = indexOf3;
                                } else {
                                    i = str2.length();
                                }
                                keyFormat.status[i7] = new int[]{parseInt3, Integer.parseInt(str2.substring(i8, i)), indexOf3 > 0 ? Integer.parseInt(str2.substring(indexOf3 + 1)) : 1};
                            }
                        }
                        addKeyFormat(c == '&' ? getKeyKeyMap(formatParam) : getStatusKeyMap(formatParam), parseInt, keyFormat);
                    }
                    if (formatParam.keyKeyMap != null) {
                        sortKeyFormatList(formatParam.keyKeyMap);
                    }
                    if (formatParam.statusKeyMap != null) {
                        sortKeyFormatList(formatParam.statusKeyMap);
                    }
                } else if (intValue != 1518) {
                    switch (intValue) {
                        case 300:
                            formatParam.leadCodes = StringUtil.parseIntArray(str.trim(), ",");
                            break;
                        case 301:
                            formatParam.zeroCodes = StringUtil.parseIntArray(str.trim(), ",");
                            break;
                        case 302:
                            formatParam.oneCodes = StringUtil.parseIntArray(str.trim(), ",");
                            break;
                        case 303:
                            formatParam.delayCodes = new SparseArray<>();
                            String[] split3 = str.trim().split("\\|");
                            for (String parseIntArray : split3) {
                                int[] parseIntArray2 = StringUtil.parseIntArray(parseIntArray, "[&,]");
                                int[] iArr = new int[(parseIntArray2.length - 1)];
                                System.arraycopy(parseIntArray2, 1, iArr, 0, iArr.length);
                                formatParam.delayCodes.put(parseIntArray2[0], iArr);
                            }
                            break;
                        default:
                            switch (intValue) {
                                case 1508:
                                    formatParam.repeatCount = Integer.parseInt(str.trim());
                                    break;
                                case 1509:
                                    formatParam.byteBitNums = new SparseIntArray();
                                    String[] split4 = str.trim().split("\\|");
                                    for (String parseIntArray3 : split4) {
                                        int[] parseIntArray4 = StringUtil.parseIntArray(parseIntArray3, "&");
                                        formatParam.byteBitNums.put(parseIntArray4[0], parseIntArray4[1]);
                                    }
                                    break;
                                case 1510:
                                    formatParam.waveCodeMap = new HashMap();
                                    String[] split5 = str.trim().split("\\|");
                                    int length = split5.length;
                                    int i9 = 0;
                                    while (i9 < length) {
                                        String trim5 = split5[i9].trim();
                                        int indexOf4 = trim5.indexOf(i4);
                                        String trim6 = trim5.substring(i2, indexOf4).trim();
                                        int i10 = indexOf4 + i3;
                                        int indexOf5 = trim5.indexOf(i4, i10);
                                        String substring2 = trim5.substring(i10, indexOf5);
                                        int[] parseIntArray5 = StringUtil.parseIntArray(trim5.substring(indexOf5 + i3), ",");
                                        for (String str3 : substring2.split(",")) {
                                            formatParam.waveCodeMap.put(trim6 + "&" + str3, parseIntArray5);
                                        }
                                        i9++;
                                        i2 = 0;
                                        i3 = 1;
                                        i4 = 38;
                                    }
                                    list2 = list;
                                    continue;
                                case 1511:
                                    formatParam.beanshellScript = str.trim();
                                    continue;
                                default:
                                    if (list2 != null && intValue > 1000 && intValue < 1501) {
                                        list2.add(intValue + "|" + str.trim());
                                    }
                            }
                    }
                } else {
                    formatParam.script = str.trim();
                }
            } else {
                formatParam.byteNum = Integer.parseInt(str.trim());
            }
            list2 = list;
        }
        if (formatParam.script != null) {
            formatParam.beanshellScript = null;
        }
        return formatParam;
    }

    public NormalCodeHelper(int i, Map<Integer, String> map, Map<Integer, Map<Integer, String>> map2) {
        int i2;
        this.remoteId = i;
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
            i2 = refMap.get(i) + 1;
            refMap.put(i, i2);
        }
        if (i2 == 1) {
            CodeHelper.initRemote(i, 1, strArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0263, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0264, code lost:
        r4 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x026b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x026c, code lost:
        r2 = r33;
        r4 = r1;
        r8 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0277, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x013d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0142, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0143, code lost:
        r4 = r26;
        r1 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014a, code lost:
        r2 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01b7, code lost:
        r4 = r26;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0277 A[ExcHandler: all (th java.lang.Throwable), PHI: r1 10  PHI: (r1v24 com.hzy.tvmao.ir.encode.NormalCodeHelper) = (r1v1 com.hzy.tvmao.ir.encode.NormalCodeHelper), (r1v1 com.hzy.tvmao.ir.encode.NormalCodeHelper), (r1v25 com.hzy.tvmao.ir.encode.NormalCodeHelper), (r1v25 com.hzy.tvmao.ir.encode.NormalCodeHelper) binds: [B:28:0x011b, B:29:?, B:31:0x0124, B:32:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:28:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0416 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013d A[Catch:{ Exception -> 0x0142, all -> 0x013d }, ExcHandler: all (th java.lang.Throwable), Splitter:B:34:0x0127] */
    public int[][] getWaveCodes(int i, int i2, int i3, int i4, int i5, int i6, int i7, byte[] bArr, SparseIntArray sparseIntArray) {
        String str;
        char c;
        char c2;
        NormalCodeHelper normalCodeHelper;
        int i8;
        SparseIntArray sparseIntArray2;
        FormatParam formatParam;
        FormatParam formatParam2;
        int i9;
        int i10;
        List list;
        String str2;
        int[] iArr;
        NormalCodeHelper normalCodeHelper2 = this;
        int i11 = i;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i6;
        int i16 = i7;
        SparseIntArray sparseIntArray3 = sparseIntArray;
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        if (sparseIntArray3 == null || sparseIntArray.size() <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i17 = 0; i17 < sparseIntArray.size(); i17++) {
                int keyAt = sparseIntArray3.keyAt(i17);
                int i18 = sparseIntArray3.get(keyAt);
                sparseIntArray4.append(keyAt, i18);
                sb.append(keyAt);
                sb.append(',');
                sb.append(i18);
                sb.append('|');
            }
            sb.setLength(sb.length() - 1);
            str = sb.toString();
        }
        sparseIntArray4.append(1, i11);
        sparseIntArray4.append(2, i12);
        sparseIntArray4.append(3, i13);
        sparseIntArray4.append(4, i13);
        sparseIntArray4.append(5, i14);
        sparseIntArray4.append(7, i15);
        sparseIntArray4.append(6, i15);
        int i19 = sparseIntArray4.get(i16, -1);
        if (normalCodeHelper2.param.waveCodeMap != null && normalCodeHelper2.param.waveCodeMap.size() > 0) {
            int[] iArr2 = normalCodeHelper2.param.waveCodeMap.get(i16 + "&" + i19);
            if (iArr2 == null) {
                Map<String, int[]> map = normalCodeHelper2.param.waveCodeMap;
                iArr2 = map.get(i16 + "&");
            }
            if (iArr2 != null) {
                return new int[][]{iArr2};
            }
        }
        int i20 = i19;
        SparseIntArray sparseIntArray5 = sparseIntArray4;
        byte[][] enc = CodeHelper.enc(normalCodeHelper2.remoteId, i, i2, i3, i4, i5, i6, i7, bArr, str);
        int[][] iArr3 = new int[enc.length][];
        int i21 = 0;
        while (i21 < enc.length) {
            byte[] bArr2 = enc[i21];
            int[][] iArr4 = iArr3;
            int i22 = i21;
            byte[][] bArr3 = enc;
            String str3 = "bytes";
            if (normalCodeHelper2.param.script == null || normalCodeHelper2.param.script.length() <= 0) {
                String str4 = str3;
                byte[] bArr4 = bArr2;
                c2 = 2;
                c = 1;
                i8 = i7;
                String str5 = "evaluate script failed for remote ";
                normalCodeHelper = normalCodeHelper2;
                int i23 = i6;
                String str6 = "CodeHelper";
                if (normalCodeHelper.param.beanshellScript != null && normalCodeHelper.param.beanshellScript.length() > 0) {
                    Interpreter interpreter = new Interpreter();
                    String str7 = str5;
                    try {
                        interpreter.O000000o(str4, bArr3[0]);
                        interpreter.O000000o("power", i11);
                        interpreter.O000000o("mode", i12);
                        interpreter.O000000o("temperature", i13);
                        interpreter.O000000o("windSpeed", i14);
                        interpreter.O000000o("udWindMode", i23);
                        interpreter.O000000o("functionId", i8);
                        interpreter.O000000o(normalCodeHelper.param.beanshellScript);
                    } catch (Exception e) {
                        Log.e(str6, str7 + normalCodeHelper.remoteId, e);
                    }
                }
                bArr2 = bArr4;
            } else {
                String str8 = "evaluate script failed for remote ";
                LuaState newLuaState = LuaStateFactory.newLuaState();
                try {
                    newLuaState.openLibs();
                    newLuaState.newTable();
                    String str9 = "CodeHelper";
                    int i24 = 0;
                    while (i24 < bArr2.length) {
                        try {
                            newLuaState.pushNumber((double) (bArr2[i24] & 255));
                            i24++;
                            newLuaState.rawSetI(-2, (long) i24);
                            normalCodeHelper2 = this;
                            str3 = str3;
                        } catch (Exception e2) {
                            e = e2;
                            normalCodeHelper = this;
                            SparseIntArray sparseIntArray6 = sparseIntArray;
                            str2 = str9;
                            try {
                                byte[] bArr5 = bArr2;
                                Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                                newLuaState.close();
                                bArr2 = bArr5;
                                c2 = 2;
                                c = 1;
                                FormatParam formatParam3 = normalCodeHelper.param;
                                if (normalCodeHelper.keyFormatMap != null) {
                                }
                                formatParam = formatParam2;
                                iArr4[i22] = getWaveCode(formatParam, bArr2);
                                enc = bArr3;
                                normalCodeHelper2 = normalCodeHelper;
                                sparseIntArray5 = sparseIntArray2;
                                iArr3 = iArr4;
                                i21 = i22 + 1;
                            } catch (Throwable th) {
                                th = th;
                                newLuaState.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                        }
                    }
                    String str10 = str3;
                    newLuaState.setGlobal(str10);
                    newLuaState.pushNumber((double) i11);
                    newLuaState.setGlobal("power");
                    newLuaState.pushNumber((double) i12);
                    newLuaState.setGlobal("mode");
                    newLuaState.pushNumber((double) i13);
                    newLuaState.setGlobal("temperature");
                    newLuaState.pushNumber((double) i14);
                    newLuaState.setGlobal("windSpeed");
                    newLuaState.pushNumber((double) i6);
                    newLuaState.setGlobal("udWindMode");
                    i8 = i7;
                    newLuaState.pushNumber((double) i8);
                    newLuaState.setGlobal("functionId");
                    SparseIntArray sparseIntArray7 = sparseIntArray;
                    if (sparseIntArray7 != null) {
                        if (sparseIntArray.size() > 0) {
                            newLuaState.newTable();
                            for (int i25 = 0; i25 < sparseIntArray.size(); i25++) {
                                int keyAt2 = sparseIntArray7.keyAt(i25);
                                int i26 = sparseIntArray7.get(keyAt2);
                                newLuaState.pushNumber((double) keyAt2);
                                newLuaState.pushNumber((double) i26);
                                newLuaState.rawSet(-3);
                            }
                            newLuaState.setGlobal("exts");
                        }
                    }
                    int i27 = -2;
                    normalCodeHelper = this;
                    try {
                        int LdoString = newLuaState.LdoString(normalCodeHelper.param.script);
                        if (LdoString == 0) {
                            try {
                                newLuaState.getGlobal(str10);
                                newLuaState.pushNil();
                                ArrayList arrayList = new ArrayList();
                                while (newLuaState.next(i27) != 0) {
                                    try {
                                        int[] iArr5 = new int[2];
                                        iArr5[0] = (int) newLuaState.toInteger(i27);
                                        iArr = iArr5;
                                    } catch (Exception e3) {
                                        e = e3;
                                        str2 = str9;
                                        byte[] bArr52 = bArr2;
                                        Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                                        newLuaState.close();
                                        bArr2 = bArr52;
                                        c2 = 2;
                                        c = 1;
                                        FormatParam formatParam32 = normalCodeHelper.param;
                                        if (normalCodeHelper.keyFormatMap != null) {
                                        }
                                        formatParam = formatParam2;
                                        iArr4[i22] = getWaveCode(formatParam, bArr2);
                                        enc = bArr3;
                                        normalCodeHelper2 = normalCodeHelper;
                                        sparseIntArray5 = sparseIntArray2;
                                        iArr3 = iArr4;
                                        i21 = i22 + 1;
                                    }
                                    try {
                                        try {
                                            iArr[1] = (int) newLuaState.toInteger(-1);
                                            arrayList.add(iArr);
                                            newLuaState.pop(1);
                                            i27 = -2;
                                        } catch (Exception e4) {
                                            e = e4;
                                            str2 = str9;
                                            byte[] bArr522 = bArr2;
                                            Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                                            newLuaState.close();
                                            bArr2 = bArr522;
                                            c2 = 2;
                                            c = 1;
                                            FormatParam formatParam322 = normalCodeHelper.param;
                                            if (normalCodeHelper.keyFormatMap != null) {
                                            }
                                            formatParam = formatParam2;
                                            iArr4[i22] = getWaveCode(formatParam, bArr2);
                                            enc = bArr3;
                                            normalCodeHelper2 = normalCodeHelper;
                                            sparseIntArray5 = sparseIntArray2;
                                            iArr3 = iArr4;
                                            i21 = i22 + 1;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        str2 = str9;
                                        byte[] bArr5222 = bArr2;
                                        Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                                        newLuaState.close();
                                        bArr2 = bArr5222;
                                        c2 = 2;
                                        c = 1;
                                        FormatParam formatParam3222 = normalCodeHelper.param;
                                        if (normalCodeHelper.keyFormatMap != null) {
                                        }
                                        formatParam = formatParam2;
                                        iArr4[i22] = getWaveCode(formatParam, bArr2);
                                        enc = bArr3;
                                        normalCodeHelper2 = normalCodeHelper;
                                        sparseIntArray5 = sparseIntArray2;
                                        iArr3 = iArr4;
                                        i21 = i22 + 1;
                                    }
                                }
                                Collections.sort(arrayList, new Comparator<int[]>() {
                                    /* class com.hzy.tvmao.ir.encode.NormalCodeHelper.AnonymousClass2 */

                                    public int compare(int[] iArr, int[] iArr2) {
                                        return iArr[0] - iArr2[0];
                                    }
                                });
                                bArr2 = new byte[arrayList.size()];
                                for (int i28 = 0; i28 < arrayList.size(); i28++) {
                                    bArr2[i28] = (byte) ((int[]) arrayList.get(i28))[1];
                                }
                            } catch (Exception e6) {
                                e = e6;
                                str2 = str9;
                                byte[] bArr52222 = bArr2;
                                Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                                newLuaState.close();
                                bArr2 = bArr52222;
                                c2 = 2;
                                c = 1;
                                FormatParam formatParam32222 = normalCodeHelper.param;
                                if (normalCodeHelper.keyFormatMap != null) {
                                }
                                formatParam = formatParam2;
                                iArr4[i22] = getWaveCode(formatParam, bArr2);
                                enc = bArr3;
                                normalCodeHelper2 = normalCodeHelper;
                                sparseIntArray5 = sparseIntArray2;
                                iArr3 = iArr4;
                                i21 = i22 + 1;
                            }
                        } else {
                            str2 = str9;
                            try {
                                Log.e(str2, "evaluate script return error (" + LdoString + ") for remote " + normalCodeHelper.remoteId);
                            } catch (Exception e7) {
                                e = e7;
                                byte[] bArr522222 = bArr2;
                                Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                                newLuaState.close();
                                bArr2 = bArr522222;
                                c2 = 2;
                                c = 1;
                                FormatParam formatParam322222 = normalCodeHelper.param;
                                if (normalCodeHelper.keyFormatMap != null) {
                                }
                                formatParam = formatParam2;
                                iArr4[i22] = getWaveCode(formatParam, bArr2);
                                enc = bArr3;
                                normalCodeHelper2 = normalCodeHelper;
                                sparseIntArray5 = sparseIntArray2;
                                iArr3 = iArr4;
                                i21 = i22 + 1;
                            }
                        }
                        newLuaState.close();
                    } catch (Exception e8) {
                        e = e8;
                        str2 = str9;
                        byte[] bArr5222222 = bArr2;
                        Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                        newLuaState.close();
                        bArr2 = bArr5222222;
                        c2 = 2;
                        c = 1;
                        FormatParam formatParam3222222 = normalCodeHelper.param;
                        if (normalCodeHelper.keyFormatMap != null) {
                        }
                        formatParam = formatParam2;
                        iArr4[i22] = getWaveCode(formatParam, bArr2);
                        enc = bArr3;
                        normalCodeHelper2 = normalCodeHelper;
                        sparseIntArray5 = sparseIntArray2;
                        iArr3 = iArr4;
                        i21 = i22 + 1;
                    }
                } catch (Exception e9) {
                    e = e9;
                    i8 = i7;
                    str2 = "CodeHelper";
                    NormalCodeHelper normalCodeHelper3 = normalCodeHelper2;
                    byte[] bArr52222222 = bArr2;
                    Log.e(str2, str8 + normalCodeHelper.remoteId, e);
                    newLuaState.close();
                    bArr2 = bArr52222222;
                    c2 = 2;
                    c = 1;
                    FormatParam formatParam32222222 = normalCodeHelper.param;
                    if (normalCodeHelper.keyFormatMap != null) {
                    }
                    formatParam = formatParam2;
                    iArr4[i22] = getWaveCode(formatParam, bArr2);
                    enc = bArr3;
                    normalCodeHelper2 = normalCodeHelper;
                    sparseIntArray5 = sparseIntArray2;
                    iArr3 = iArr4;
                    i21 = i22 + 1;
                } catch (Throwable th3) {
                }
                c2 = 2;
                c = 1;
            }
            FormatParam formatParam322222222 = normalCodeHelper.param;
            if (normalCodeHelper.keyFormatMap != null) {
                if (formatParam322222222.keyKeyMap != null && (list = normalCodeHelper.param.keyKeyMap.get(i8)) != null) {
                    Iterator it = list.iterator();
                    i9 = -1;
                    while (true) {
                        if (!it.hasNext()) {
                            formatParam2 = formatParam322222222;
                            i10 = i20;
                            break;
                        }
                        KeyFormat keyFormat = (KeyFormat) it.next();
                        if (keyFormat.status != null) {
                            int[][] iArr6 = keyFormat.status;
                            int length = iArr6.length;
                            int i29 = 0;
                            while (true) {
                                if (i29 >= length) {
                                    formatParam2 = formatParam322222222;
                                    i10 = i20;
                                    break;
                                }
                                int[] iArr7 = iArr6[i29];
                                formatParam2 = formatParam322222222;
                                i10 = i20;
                                if (iArr7[0] <= i10 && iArr7[c] >= i10 && (i10 - iArr7[0]) % iArr7[c2] == 0) {
                                    break;
                                }
                                i29++;
                                i20 = i10;
                                formatParam322222222 = formatParam2;
                            }
                        } else {
                            formatParam2 = formatParam322222222;
                            i10 = i20;
                        }
                        i9 = keyFormat.functionId;
                        if (i9 >= 0) {
                            break;
                        }
                        i20 = i10;
                        formatParam322222222 = formatParam2;
                    }
                } else {
                    formatParam2 = formatParam322222222;
                    i10 = i20;
                    i9 = -1;
                }
                if (i9 < 0 && normalCodeHelper.param.statusKeyMap != null) {
                    int i30 = 0;
                    while (true) {
                        if (i30 >= normalCodeHelper.param.statusKeyMap.size()) {
                            break;
                        }
                        int keyAt3 = normalCodeHelper.param.statusKeyMap.keyAt(i30);
                        List list2 = normalCodeHelper.param.statusKeyMap.get(keyAt3);
                        if (list2 != null) {
                            sparseIntArray2 = sparseIntArray5;
                            int i31 = sparseIntArray2.get(keyAt3, -1);
                            if (i31 >= 0) {
                                Iterator it2 = list2.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        i20 = i10;
                                        break;
                                    }
                                    KeyFormat keyFormat2 = (KeyFormat) it2.next();
                                    if (keyFormat2.status != null) {
                                        int[][] iArr8 = keyFormat2.status;
                                        int length2 = iArr8.length;
                                        i20 = i10;
                                        int i32 = 0;
                                        while (true) {
                                            if (i32 >= length2) {
                                                break;
                                            }
                                            int[] iArr9 = iArr8[i32];
                                            if (iArr9[0] <= i31 && iArr9[c] >= i31 && (i31 - iArr9[0]) % iArr9[c2] == 0) {
                                                break;
                                            }
                                            i32++;
                                        }
                                    } else {
                                        i20 = i10;
                                    }
                                    i9 = keyFormat2.functionId;
                                    if (i9 >= 0) {
                                        break;
                                    }
                                    i10 = i20;
                                }
                                if (i9 >= 0) {
                                    break;
                                }
                            } else {
                                i20 = i10;
                            }
                        } else {
                            i20 = i10;
                            sparseIntArray2 = sparseIntArray5;
                        }
                        i30++;
                        sparseIntArray5 = sparseIntArray2;
                        i10 = i20;
                    }
                    formatParam = normalCodeHelper.keyFormatMap.get(i9);
                    if (formatParam != null) {
                        iArr4[i22] = getWaveCode(formatParam, bArr2);
                        enc = bArr3;
                        normalCodeHelper2 = normalCodeHelper;
                        sparseIntArray5 = sparseIntArray2;
                        iArr3 = iArr4;
                        i21 = i22 + 1;
                    }
                }
                i20 = i10;
                sparseIntArray2 = sparseIntArray5;
                formatParam = normalCodeHelper.keyFormatMap.get(i9);
                if (formatParam != null) {
                }
            } else {
                formatParam2 = formatParam322222222;
                sparseIntArray2 = sparseIntArray5;
            }
            formatParam = formatParam2;
            iArr4[i22] = getWaveCode(formatParam, bArr2);
            enc = bArr3;
            normalCodeHelper2 = normalCodeHelper;
            sparseIntArray5 = sparseIntArray2;
            iArr3 = iArr4;
            i21 = i22 + 1;
        }
        return iArr3;
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

    private static void addArrayToList(int[] iArr, List<Integer> list) {
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                list.add(Integer.valueOf(valueOf));
            }
        }
    }

    private static void addDelayCodes(FormatParam formatParam, int i, List<Integer> list) {
        int[] iArr;
        if (formatParam.delayCodes != null && (iArr = formatParam.delayCodes.get(i)) != null) {
            addArrayToList(iArr, list);
        }
    }

    private static int[] getWaveCode(FormatParam formatParam, byte[] bArr) {
        int i;
        FormatParam formatParam2 = formatParam;
        byte[] bArr2 = bArr;
        ArrayList arrayList = new ArrayList();
        if (formatParam2.patterns != null) {
            int length = formatParam2.patterns.length;
            int i2 = 4;
            if (length > 16) {
                i2 = 8;
            } else if (length <= 4) {
                i2 = length > 2 ? 2 : 1;
            }
            int i3 = 8 / i2;
            int i4 = 0;
            int i5 = 0;
            loop0:
            while (i4 < bArr2.length) {
                int i6 = i5;
                for (int i7 = 0; i7 < i3; i7++) {
                    for (int i8 : formatParam2.patterns[(((bArr2[i4] << (i7 * i2)) & 255) >>> (8 - i2)) & 255]) {
                        if (arrayList.size() != 0 || i8 > 0) {
                            if (arrayList.size() % 2 == 1) {
                                if (i8 < 0) {
                                    arrayList.add(Integer.valueOf(-i8));
                                } else {
                                    arrayList.set(arrayList.size() - 1, Integer.valueOf(((Integer) arrayList.get(arrayList.size() - 1)).intValue() + i8));
                                }
                            } else if (i8 > 0) {
                                arrayList.add(Integer.valueOf(i8));
                            } else {
                                arrayList.set(arrayList.size() - 1, Integer.valueOf(((Integer) arrayList.get(arrayList.size() - 1)).intValue() - i8));
                            }
                        }
                    }
                    i6++;
                    if (formatParam2.byteNum > 0 && i6 >= formatParam2.byteNum) {
                        break loop0;
                    }
                }
                i4++;
                i5 = i6;
            }
        } else {
            addArrayToList(formatParam2.leadCodes, arrayList);
            int i9 = 0;
            while (i9 < bArr2.length) {
                String padStart = StringUtil.padStart(Integer.toBinaryString(bArr2[i9]), 8, '0');
                if (formatParam2.byteBitNums != null) {
                    int i10 = formatParam2.byteBitNums.get(i9, 8);
                    i = (i9 == bArr2.length - 1 && i10 == 8) ? formatParam2.byteBitNums.get(-1, 8) : i10;
                } else {
                    i = 8;
                }
                if (formatParam2.littleEndian) {
                    int length2 = padStart.length() - i;
                    for (int length3 = padStart.length() - 1; length3 >= length2; length3--) {
                        addArrayToList(padStart.charAt(length3) == '0' ? formatParam2.zeroCodes : formatParam2.oneCodes, arrayList);
                    }
                } else {
                    for (int length4 = padStart.length() - i; length4 < padStart.length(); length4++) {
                        addArrayToList(padStart.charAt(length4) == '0' ? formatParam2.zeroCodes : formatParam2.oneCodes, arrayList);
                    }
                }
                addDelayCodes(formatParam2, i9, arrayList);
                i9++;
            }
            if (formatParam2.addTrailerOne && formatParam2.oneCodes != null) {
                arrayList.add(Integer.valueOf(formatParam2.oneCodes[0]));
            }
            addDelayCodes(formatParam2, -1, arrayList);
        }
        if (arrayList.size() % 2 == 1) {
            arrayList.add(1000);
        }
        int[] iArr = new int[(formatParam2.repeatCount * arrayList.size())];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            iArr[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        for (int i12 = 1; i12 < formatParam2.repeatCount; i12++) {
            System.arraycopy(iArr, 0, iArr, arrayList.size() * i12, arrayList.size());
        }
        return iArr;
    }
}
