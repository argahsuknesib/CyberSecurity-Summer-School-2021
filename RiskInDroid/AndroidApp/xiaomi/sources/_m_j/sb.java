package _m_j;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.TextUtils;
import java.util.ArrayList;

public final class sb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f2448O000000o = {"ENABLE", "LAT,", "LNG", "RADIUS", "TYPE"};

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2449O000000o;
        public op O00000Oo;
    }

    public static String[] O000000o(String str, os osVar, op opVar, int i) {
        String[] strArr = new String[5];
        strArr[0] = str;
        if (osVar != null) {
            strArr[1] = sa.O000000o(osVar.f2373O000000o);
            if (osVar.O00000Oo != null && osVar.O00000Oo.O000000o() > 0) {
                StringBuilder sb = new StringBuilder();
                int O000000o2 = osVar.O00000Oo.O000000o();
                for (int i2 = 0; i2 < O000000o2; i2++) {
                    ot otVar = osVar.O00000Oo.O00000o0.get(i2);
                    sb.append(otVar.f2374O000000o);
                    sb.append(",");
                    sb.append(otVar.O00000o0);
                    sb.append(";");
                }
                sb.deleteCharAt(sb.length() - 1);
                strArr[2] = sb.toString();
            }
        }
        if (opVar != null && opVar.O00000o()) {
            strArr[3] = opVar.O00000Oo + "," + opVar.f2369O000000o + "," + opVar.O00000o0 + "," + opVar.O00000oo;
        }
        strArr[4] = String.valueOf(i);
        return strArr;
    }

    public static os O000000o(String str, String str2) {
        os osVar = new os();
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":");
            oq oqVar = null;
            try {
                if (split.length == 3) {
                    oqVar = new oq(2, true);
                    oqVar.O00000oo = Integer.parseInt(split[0]);
                    oqVar.O0000O0o = Integer.parseInt(split[1]);
                    oqVar.O0000OOo = Integer.parseInt(split[2]);
                } else if (split.length == 4) {
                    oqVar = new oq(1, true);
                    oqVar.O00000Oo = Integer.parseInt(split[0]);
                    oqVar.O00000o0 = Integer.parseInt(split[1]);
                    oqVar.O00000o = Integer.parseInt(split[2]);
                    oqVar.O00000oO = Integer.parseInt(split[3]);
                }
                osVar.f2373O000000o.O00000o = oqVar;
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            try {
                int length = str2.length();
                do {
                    int indexOf = str2.indexOf(44, i);
                    if (indexOf == -1) {
                        break;
                    }
                    long parseLong = Long.parseLong(str2.substring(i, indexOf));
                    int i2 = indexOf + 1;
                    if (i2 < length) {
                        int indexOf2 = str2.indexOf(59, i2);
                        if (indexOf2 == -1) {
                            indexOf2 = length;
                        }
                        arrayList.add(new ot(parseLong, null, Integer.parseInt(str2.substring(i2, indexOf2)), 0, 0));
                        i = indexOf2 + 1;
                        continue;
                    } else {
                        i = i2;
                        continue;
                    }
                } while (i < length);
                osVar.O00000Oo.O00000o0 = arrayList;
            } catch (Exception unused2) {
            }
        }
        return osVar;
    }

    public static op O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            double parseDouble = Double.parseDouble(split[0]);
            double parseDouble2 = Double.parseDouble(split[1]);
            float parseFloat = Float.parseFloat(split[2]);
            String str2 = split[3];
            op opVar = new op();
            try {
                opVar.O00000oo = str2;
                opVar.O00000Oo(parseDouble);
                opVar.O000000o(parseDouble2);
                opVar.O000000o(parseFloat);
            } catch (Exception unused) {
            }
            return opVar;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Cursor O000000o(boolean z, op opVar) {
        MatrixCursor matrixCursor = new MatrixCursor(f2448O000000o);
        String[] strArr = f2448O000000o;
        Object[] objArr = new Object[strArr.length];
        objArr[matrixCursor.getColumnIndex(strArr[0])] = Integer.valueOf(z ? 1 : 0);
        if (z && opVar != null) {
            objArr[matrixCursor.getColumnIndex(f2448O000000o[1])] = Double.valueOf(opVar.O00000Oo);
            objArr[matrixCursor.getColumnIndex(f2448O000000o[2])] = Double.valueOf(opVar.f2369O000000o);
            objArr[matrixCursor.getColumnIndex(f2448O000000o[3])] = Integer.valueOf((int) opVar.O00000o0);
            objArr[matrixCursor.getColumnIndex(f2448O000000o[4])] = opVar.O00000oO;
        }
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    public static O000000o O000000o(Cursor cursor) {
        O000000o o000000o = new O000000o();
        if (cursor != null && cursor.moveToFirst()) {
            int i = 0;
            int columnIndex = cursor.getColumnIndex(f2448O000000o[0]);
            if (columnIndex != -1) {
                o000000o.f2449O000000o = cursor.getInt(columnIndex) == 1;
            }
            if (o000000o.f2449O000000o) {
                int columnIndex2 = cursor.getColumnIndex(f2448O000000o[1]);
                double d = 0.0d;
                double d2 = columnIndex2 != -1 ? cursor.getDouble(columnIndex2) : 0.0d;
                int columnIndex3 = cursor.getColumnIndex(f2448O000000o[2]);
                if (columnIndex3 != -1) {
                    d = cursor.getDouble(columnIndex3);
                }
                int columnIndex4 = cursor.getColumnIndex(f2448O000000o[3]);
                if (columnIndex4 != -1) {
                    i = cursor.getInt(columnIndex4);
                }
                int columnIndex5 = cursor.getColumnIndex(f2448O000000o[4]);
                String string = columnIndex5 != -1 ? cursor.getString(columnIndex5) : "";
                op opVar = new op();
                opVar.O00000o = System.currentTimeMillis();
                opVar.O00000o0();
                opVar.O00000oO = string;
                opVar.O00000Oo(d2);
                opVar.O000000o(d);
                opVar.O000000o((float) i);
                if (opVar.O00000o()) {
                    o000000o.O00000Oo = opVar;
                }
            }
        }
        return o000000o;
    }
}
