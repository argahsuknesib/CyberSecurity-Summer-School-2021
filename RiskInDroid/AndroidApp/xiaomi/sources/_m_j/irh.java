package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import io.realm.RealmFieldType;
import io.realm.internal.OsList;
import io.realm.internal.Table;
import java.util.Arrays;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class irh extends irs implements isg {

    /* renamed from: O000000o  reason: collision with root package name */
    private final irm<irh> f1585O000000o = new irm<>(this);

    irh(irf irf, isi isi) {
        irm<irh> irm = this.f1585O000000o;
        irm.O00000o0 = irf;
        irm.O00000Oo = isi;
        irm.f1590O000000o = false;
        irm.O00000o = null;
    }

    /* renamed from: _m_j.irh$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1586O000000o = new int[RealmFieldType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f1586O000000o[RealmFieldType.BOOLEAN.ordinal()] = 1;
            f1586O000000o[RealmFieldType.INTEGER.ordinal()] = 2;
            f1586O000000o[RealmFieldType.FLOAT.ordinal()] = 3;
            f1586O000000o[RealmFieldType.DOUBLE.ordinal()] = 4;
            f1586O000000o[RealmFieldType.STRING.ordinal()] = 5;
            f1586O000000o[RealmFieldType.BINARY.ordinal()] = 6;
            f1586O000000o[RealmFieldType.DATE.ordinal()] = 7;
            f1586O000000o[RealmFieldType.OBJECT.ordinal()] = 8;
            f1586O000000o[RealmFieldType.LIST.ordinal()] = 9;
            f1586O000000o[RealmFieldType.LINKING_OBJECTS.ordinal()] = 10;
            f1586O000000o[RealmFieldType.INTEGER_LIST.ordinal()] = 11;
            f1586O000000o[RealmFieldType.BOOLEAN_LIST.ordinal()] = 12;
            f1586O000000o[RealmFieldType.STRING_LIST.ordinal()] = 13;
            f1586O000000o[RealmFieldType.BINARY_LIST.ordinal()] = 14;
            f1586O000000o[RealmFieldType.DATE_LIST.ordinal()] = 15;
            f1586O000000o[RealmFieldType.FLOAT_LIST.ordinal()] = 16;
            f1586O000000o[RealmFieldType.DOUBLE_LIST.ordinal()] = 17;
        }
    }

    private String[] O00000Oo() {
        this.f1585O000000o.O00000o0.O00000o();
        String[] strArr = new String[((int) this.f1585O000000o.O00000Oo.getColumnCount())];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = this.f1585O000000o.O00000Oo.getColumnName((long) i);
        }
        return strArr;
    }

    public final int hashCode() {
        this.f1585O000000o.O00000o0.O00000o();
        String O00000oO = this.f1585O000000o.O00000o0.O00000oO();
        String O000000o2 = this.f1585O000000o.O00000Oo.getTable().O000000o();
        long index = this.f1585O000000o.O00000Oo.getIndex();
        int i = 0;
        int hashCode = ((O00000oO != null ? O00000oO.hashCode() : 0) + 527) * 31;
        if (O000000o2 != null) {
            i = O000000o2.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (index ^ (index >>> 32)));
    }

    public final boolean equals(Object obj) {
        this.f1585O000000o.O00000o0.O00000o();
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            irh irh = (irh) obj;
            String O00000oO = this.f1585O000000o.O00000o0.O00000oO();
            String O00000oO2 = irh.f1585O000000o.O00000o0.O00000oO();
            if (O00000oO == null ? O00000oO2 != null : !O00000oO.equals(O00000oO2)) {
                return false;
            }
            String O000000o2 = this.f1585O000000o.O00000Oo.getTable().O000000o();
            String O000000o3 = irh.f1585O000000o.O00000Oo.getTable().O000000o();
            if (O000000o2 == null ? O000000o3 != null : !O000000o2.equals(O000000o3)) {
                return false;
            }
            if (this.f1585O000000o.O00000Oo.getIndex() == irh.f1585O000000o.O00000Oo.getIndex()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: additional move instructions added (6) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    public final String toString() {
        this.f1585O000000o.O00000o0.O00000o();
        if (!this.f1585O000000o.O00000Oo.isAttached()) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder(Table.O00000Oo(this.f1585O000000o.O00000Oo.getTable().O000000o()) + " = dynamic[");
        for (String str : O00000Oo()) {
            long columnIndex = this.f1585O000000o.O00000Oo.getColumnIndex(str);
            RealmFieldType columnType = this.f1585O000000o.O00000Oo.getColumnType(columnIndex);
            sb.append("{");
            sb.append(str);
            sb.append(":");
            Object obj = "null";
            switch (AnonymousClass1.f1586O000000o[columnType.ordinal()]) {
                case 1:
                    Object obj2 = obj;
                    if (!this.f1585O000000o.O00000Oo.isNull(columnIndex)) {
                        obj2 = Boolean.valueOf(this.f1585O000000o.O00000Oo.getBoolean(columnIndex));
                    }
                    sb.append(obj2);
                    break;
                case 2:
                    Object obj3 = obj;
                    if (!this.f1585O000000o.O00000Oo.isNull(columnIndex)) {
                        obj3 = Long.valueOf(this.f1585O000000o.O00000Oo.getLong(columnIndex));
                    }
                    sb.append(obj3);
                    break;
                case 3:
                    Object obj4 = obj;
                    if (!this.f1585O000000o.O00000Oo.isNull(columnIndex)) {
                        obj4 = Float.valueOf(this.f1585O000000o.O00000Oo.getFloat(columnIndex));
                    }
                    sb.append(obj4);
                    break;
                case 4:
                    Object obj5 = obj;
                    if (!this.f1585O000000o.O00000Oo.isNull(columnIndex)) {
                        obj5 = Double.valueOf(this.f1585O000000o.O00000Oo.getDouble(columnIndex));
                    }
                    sb.append(obj5);
                    break;
                case 5:
                    sb.append(this.f1585O000000o.O00000Oo.getString(columnIndex));
                    break;
                case 6:
                    sb.append(Arrays.toString(this.f1585O000000o.O00000Oo.getBinaryByteArray(columnIndex)));
                    break;
                case 7:
                    Object obj6 = obj;
                    if (!this.f1585O000000o.O00000Oo.isNull(columnIndex)) {
                        obj6 = this.f1585O000000o.O00000Oo.getDate(columnIndex);
                    }
                    sb.append(obj6);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    String str2 = obj;
                    if (!this.f1585O000000o.O00000Oo.isNullLink(columnIndex)) {
                        str2 = Table.O00000Oo(this.f1585O000000o.O00000Oo.getTable().O00000o0(columnIndex).O000000o());
                    }
                    sb.append(str2);
                    break;
                case 9:
                    sb.append(String.format(Locale.US, "RealmList<%s>[%s]", Table.O00000Oo(this.f1585O000000o.O00000Oo.getTable().O00000o0(columnIndex).O000000o()), Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getModelList(columnIndex).f15343O000000o))));
                    break;
                case 10:
                default:
                    sb.append("?");
                    break;
                case 11:
                    sb.append(String.format(Locale.US, "RealmList<Long>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    sb.append(String.format(Locale.US, "RealmList<Boolean>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
                case 13:
                    sb.append(String.format(Locale.US, "RealmList<String>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
                case 14:
                    sb.append(String.format(Locale.US, "RealmList<byte[]>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    sb.append(String.format(Locale.US, "RealmList<Date>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
                case 16:
                    sb.append(String.format(Locale.US, "RealmList<Float>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
                case 17:
                    sb.append(String.format(Locale.US, "RealmList<Double>[%s]", Long.valueOf(OsList.nativeSize(this.f1585O000000o.O00000Oo.getValueList(columnIndex, columnType).f15343O000000o))));
                    break;
            }
            sb.append("},");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }

    public final irm O000000o() {
        return this.f1585O000000o;
    }
}
