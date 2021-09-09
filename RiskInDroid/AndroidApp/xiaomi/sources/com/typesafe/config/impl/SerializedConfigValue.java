package com.typesafe.config.impl;

import _m_j.dry;
import _m_j.dsf;
import _m_j.dsh;
import _m_j.dsi;
import _m_j.dsn;
import _m_j.dst;
import _m_j.dtj;
import com.google.android.exoplayer2.C;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class SerializedConfigValue extends AbstractConfigValue implements Externalizable {
    private static final long serialVersionUID = 1;
    private dsn value;
    private boolean wasConfig;

    public enum SerializedField {
        UNKNOWN,
        END_MARKER,
        ROOT_VALUE,
        ROOT_WAS_CONFIG,
        VALUE_DATA,
        VALUE_ORIGIN,
        ORIGIN_DESCRIPTION,
        ORIGIN_LINE_NUMBER,
        ORIGIN_END_LINE_NUMBER,
        ORIGIN_TYPE,
        ORIGIN_URL,
        ORIGIN_COMMENTS,
        ORIGIN_NULL_URL,
        ORIGIN_NULL_COMMENTS;

        static SerializedField forInt(int i) {
            if (i < values().length) {
                return values()[i];
            }
            return UNKNOWN;
        }
    }

    enum SerializedValueType {
        NULL(ConfigValueType.NULL),
        BOOLEAN(ConfigValueType.BOOLEAN),
        INT(ConfigValueType.NUMBER),
        LONG(ConfigValueType.NUMBER),
        DOUBLE(ConfigValueType.NUMBER),
        STRING(ConfigValueType.STRING),
        LIST(ConfigValueType.LIST),
        OBJECT(ConfigValueType.OBJECT);
        
        ConfigValueType configType;

        private SerializedValueType(ConfigValueType configValueType) {
            this.configType = configValueType;
        }

        static SerializedValueType forInt(int i) {
            if (i < values().length) {
                return values()[i];
            }
            return null;
        }

        static SerializedValueType forValue(dsn dsn) {
            ConfigValueType O00000o0 = dsn.O00000o0();
            if (O00000o0 != ConfigValueType.NUMBER) {
                for (SerializedValueType serializedValueType : values()) {
                    if (serializedValueType.configType == O00000o0) {
                        return serializedValueType;
                    }
                }
            } else if (dsn instanceof ConfigInt) {
                return INT;
            } else {
                if (dsn instanceof ConfigLong) {
                    return LONG;
                }
                if (dsn instanceof ConfigDouble) {
                    return DOUBLE;
                }
            }
            throw new ConfigException.BugOrBroken("don't know how to serialize ".concat(String.valueOf(dsn)));
        }
    }

    public SerializedConfigValue() {
        super(null);
    }

    SerializedConfigValue(dsn dsn) {
        this();
        this.value = dsn;
        this.wasConfig = false;
    }

    SerializedConfigValue(dry dry) {
        this(dry.O000000o());
        this.wasConfig = true;
    }

    private Object readResolve() throws ObjectStreamException {
        if (this.wasConfig) {
            return ((dsh) this.value).O000000o();
        }
        return this.value;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final SerializedField f5922O000000o;
        final ByteArrayOutputStream O00000Oo = new ByteArrayOutputStream();
        final DataOutput O00000o0 = new DataOutputStream(this.O00000Oo);

        O000000o(SerializedField serializedField) {
            this.f5922O000000o = serializedField;
        }
    }

    private static void O000000o(DataOutput dataOutput, SerializedField serializedField, Object obj) throws IOException {
        switch (AnonymousClass1.f5921O000000o[serializedField.ordinal()]) {
            case 1:
                dataOutput.writeUTF((String) obj);
                return;
            case 2:
                dataOutput.writeInt(((Integer) obj).intValue());
                return;
            case 3:
                dataOutput.writeInt(((Integer) obj).intValue());
                return;
            case 4:
                dataOutput.writeByte(((Integer) obj).intValue());
                return;
            case 5:
                dataOutput.writeUTF((String) obj);
                return;
            case 6:
                List<String> list = (List) obj;
                dataOutput.writeInt(list.size());
                for (String writeUTF : list) {
                    dataOutput.writeUTF(writeUTF);
                }
                return;
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return;
            default:
                throw new IOException("Unhandled field from origin: ".concat(String.valueOf(serializedField)));
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:41:0x00f7 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.String] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.util.ArrayList]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static dtj O000000o(DataInput dataInput, dtj dtj) throws IOException {
        Map<SerializedField, Object> map;
        EnumMap enumMap = new EnumMap(SerializedField.class);
        while (true) {
            SerializedField O000000o2 = O000000o(dataInput);
            ArrayList arrayList = null;
            switch (AnonymousClass1.f5921O000000o[O000000o2.ordinal()]) {
                case 1:
                    dataInput.readInt();
                    arrayList = dataInput.readUTF();
                    break;
                case 2:
                    dataInput.readInt();
                    arrayList = Integer.valueOf(dataInput.readInt());
                    break;
                case 3:
                    dataInput.readInt();
                    arrayList = Integer.valueOf(dataInput.readInt());
                    break;
                case 4:
                    dataInput.readInt();
                    arrayList = Integer.valueOf(dataInput.readUnsignedByte());
                    break;
                case 5:
                    dataInput.readInt();
                    arrayList = dataInput.readUTF();
                    break;
                case 6:
                    dataInput.readInt();
                    int readInt = dataInput.readInt();
                    arrayList = new ArrayList(readInt);
                    for (int i = 0; i < readInt; i++) {
                        arrayList.add(dataInput.readUTF());
                    }
                    break;
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    dataInput.readInt();
                    arrayList = "";
                    break;
                case 9:
                    if (dtj != null) {
                        map = dtj.O00000o();
                    } else {
                        map = Collections.emptyMap();
                    }
                    Map<SerializedField, Object> O000000o3 = dtj.O000000o(map, enumMap);
                    if (O000000o3.isEmpty()) {
                        return null;
                    }
                    String str = (String) O000000o3.get(SerializedField.ORIGIN_DESCRIPTION);
                    Integer num = (Integer) O000000o3.get(SerializedField.ORIGIN_LINE_NUMBER);
                    Integer num2 = (Integer) O000000o3.get(SerializedField.ORIGIN_END_LINE_NUMBER);
                    Number number = (Number) O000000o3.get(SerializedField.ORIGIN_TYPE);
                    if (number != null) {
                        return new dtj(str, num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1, OriginType.values()[number.byteValue()], (String) O000000o3.get(SerializedField.ORIGIN_URL), (List) O000000o3.get(SerializedField.ORIGIN_COMMENTS));
                    }
                    throw new IOException("Missing ORIGIN_TYPE field");
                case 10:
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                    throw new IOException("Not expecting this field here: ".concat(String.valueOf(O000000o2)));
                case 14:
                    O00000Oo(dataInput);
                    break;
            }
            if (arrayList != null) {
                enumMap.put((MMKVRecoverStrategic) O000000o2, (Integer) arrayList);
            }
        }
    }

    private static void O000000o(DataOutput dataOutput, dsn dsn) throws IOException {
        SerializedValueType forValue = SerializedValueType.forValue(dsn);
        dataOutput.writeByte(forValue.ordinal());
        switch (AnonymousClass1.O00000Oo[forValue.ordinal()]) {
            case 1:
                dataOutput.writeBoolean(((ConfigBoolean) dsn).value);
                return;
            case 2:
                return;
            case 3:
                dataOutput.writeInt(((ConfigInt) dsn).value);
                dataOutput.writeUTF(((ConfigNumber) dsn).O0000OoO());
                return;
            case 4:
                dataOutput.writeLong(((ConfigLong) dsn).value);
                dataOutput.writeUTF(((ConfigNumber) dsn).O0000OoO());
                return;
            case 5:
                dataOutput.writeDouble(((ConfigDouble) dsn).value);
                dataOutput.writeUTF(((ConfigNumber) dsn).O0000OoO());
                return;
            case 6:
                dataOutput.writeUTF(((ConfigString) dsn).value);
                return;
            case 7:
                dsf<dsn> dsf = (dsf) dsn;
                dataOutput.writeInt(dsf.size());
                for (dsn O000000o2 : dsf) {
                    O000000o(dataOutput, O000000o2, (dtj) dsf.O00000Oo());
                }
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                dsh dsh = (dsh) dsn;
                dataOutput.writeInt(dsh.size());
                for (Map.Entry entry : dsh.entrySet()) {
                    dataOutput.writeUTF((String) entry.getKey());
                    O000000o(dataOutput, (dsn) entry.getValue(), (dtj) dsh.O00000Oo());
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: com.typesafe.config.impl.SerializedConfigValue$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5921O000000o = new int[SerializedField.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[SerializedValueType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|(3:59|60|62)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(51:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|62) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00bb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00df */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00eb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f7 */
        static {
            try {
                O00000Oo[SerializedValueType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[SerializedValueType.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[SerializedValueType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[SerializedValueType.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                O00000Oo[SerializedValueType.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                O00000Oo[SerializedValueType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                O00000Oo[SerializedValueType.LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                O00000Oo[SerializedValueType.OBJECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f5921O000000o[SerializedField.ORIGIN_DESCRIPTION.ordinal()] = 1;
            f5921O000000o[SerializedField.ORIGIN_LINE_NUMBER.ordinal()] = 2;
            f5921O000000o[SerializedField.ORIGIN_END_LINE_NUMBER.ordinal()] = 3;
            f5921O000000o[SerializedField.ORIGIN_TYPE.ordinal()] = 4;
            f5921O000000o[SerializedField.ORIGIN_URL.ordinal()] = 5;
            f5921O000000o[SerializedField.ORIGIN_COMMENTS.ordinal()] = 6;
            f5921O000000o[SerializedField.ORIGIN_NULL_URL.ordinal()] = 7;
            f5921O000000o[SerializedField.ORIGIN_NULL_COMMENTS.ordinal()] = 8;
            f5921O000000o[SerializedField.END_MARKER.ordinal()] = 9;
            f5921O000000o[SerializedField.ROOT_VALUE.ordinal()] = 10;
            f5921O000000o[SerializedField.ROOT_WAS_CONFIG.ordinal()] = 11;
            f5921O000000o[SerializedField.VALUE_DATA.ordinal()] = 12;
            f5921O000000o[SerializedField.VALUE_ORIGIN.ordinal()] = 13;
            try {
                f5921O000000o[SerializedField.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static AbstractConfigValue O00000Oo(DataInput dataInput, dtj dtj) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        SerializedValueType forInt = SerializedValueType.forInt(readUnsignedByte);
        if (forInt != null) {
            int i = 0;
            switch (AnonymousClass1.O00000Oo[forInt.ordinal()]) {
                case 1:
                    return new ConfigBoolean(dtj, dataInput.readBoolean());
                case 2:
                    return new ConfigNull(dtj);
                case 3:
                    return new ConfigInt(dtj, dataInput.readInt(), dataInput.readUTF());
                case 4:
                    return new ConfigLong(dtj, dataInput.readLong(), dataInput.readUTF());
                case 5:
                    return new ConfigDouble(dtj, dataInput.readDouble(), dataInput.readUTF());
                case 6:
                    return new ConfigString(dtj, dataInput.readUTF());
                case 7:
                    int readInt = dataInput.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    while (i < readInt) {
                        arrayList.add(O00000o0(dataInput, dtj));
                        i++;
                    }
                    return new SimpleConfigList(dtj, arrayList);
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    int readInt2 = dataInput.readInt();
                    HashMap hashMap = new HashMap(readInt2);
                    while (i < readInt2) {
                        hashMap.put(dataInput.readUTF(), O00000o0(dataInput, dtj));
                        i++;
                    }
                    return new SimpleConfigObject(dtj, hashMap);
                default:
                    throw new IOException("Unhandled serialized value type: ".concat(String.valueOf(forInt)));
            }
        } else {
            throw new IOException("Unknown serialized value type: ".concat(String.valueOf(readUnsignedByte)));
        }
    }

    private static void O000000o(DataOutput dataOutput, dsn dsn, dtj dtj) throws IOException {
        O000000o o000000o = new O000000o(SerializedField.VALUE_ORIGIN);
        O000000o(o000000o.O00000o0, (dtj) dsn.O00000Oo(), dtj);
        O000000o(dataOutput, o000000o);
        O000000o o000000o2 = new O000000o(SerializedField.VALUE_DATA);
        O000000o(o000000o2.O00000o0, dsn);
        O000000o(dataOutput, o000000o2);
        O000000o(dataOutput);
    }

    private static AbstractConfigValue O00000o0(DataInput dataInput, dtj dtj) throws IOException {
        AbstractConfigValue abstractConfigValue = null;
        dtj dtj2 = null;
        while (true) {
            SerializedField O000000o2 = O000000o(dataInput);
            if (O000000o2 == SerializedField.END_MARKER) {
                if (abstractConfigValue != null) {
                    return abstractConfigValue;
                }
                throw new IOException("No value data found in serialization of value");
            } else if (O000000o2 == SerializedField.VALUE_DATA) {
                if (dtj2 != null) {
                    dataInput.readInt();
                    abstractConfigValue = O00000Oo(dataInput, dtj2);
                } else {
                    throw new IOException("Origin must be stored before value data");
                }
            } else if (O000000o2 == SerializedField.VALUE_ORIGIN) {
                dataInput.readInt();
                dtj2 = O000000o(dataInput, dtj);
            } else {
                O00000Oo(dataInput);
            }
        }
    }

    private static void O000000o(DataOutput dataOutput, O000000o o000000o) throws IOException {
        byte[] byteArray = o000000o.O00000Oo.toByteArray();
        dataOutput.writeByte(o000000o.f5922O000000o.ordinal());
        dataOutput.writeInt(byteArray.length);
        dataOutput.write(byteArray);
    }

    private static void O000000o(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(SerializedField.END_MARKER.ordinal());
    }

    private static SerializedField O000000o(DataInput dataInput) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte != SerializedField.UNKNOWN.ordinal()) {
            return SerializedField.forInt(readUnsignedByte);
        }
        throw new IOException("field code " + readUnsignedByte + " is not supposed to be on the wire");
    }

    private static void O00000Oo(DataInput dataInput) throws IOException {
        int readInt = dataInput.readInt();
        int skipBytes = dataInput.skipBytes(readInt);
        if (skipBytes < readInt) {
            dataInput.readFully(new byte[(readInt - skipBytes)]);
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        if (((AbstractConfigValue) this.value).O0000O0o() == ResolveStatus.RESOLVED) {
            O000000o o000000o = new O000000o(SerializedField.ROOT_VALUE);
            O000000o(o000000o.O00000o0, this.value, (dtj) null);
            O000000o(objectOutput, o000000o);
            O000000o o000000o2 = new O000000o(SerializedField.ROOT_WAS_CONFIG);
            o000000o2.O00000o0.writeBoolean(this.wasConfig);
            O000000o(objectOutput, o000000o2);
            O000000o(objectOutput);
            return;
        }
        throw new NotSerializableException("tried to serialize a value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        while (true) {
            SerializedField O000000o2 = O000000o(objectInput);
            if (O000000o2 != SerializedField.END_MARKER) {
                if (O000000o2 == SerializedField.ROOT_VALUE) {
                    objectInput.readInt();
                    this.value = O00000o0(objectInput, null);
                } else if (O000000o2 == SerializedField.ROOT_WAS_CONFIG) {
                    objectInput.readInt();
                    this.wasConfig = objectInput.readBoolean();
                } else {
                    O00000Oo((DataInput) objectInput);
                }
            } else {
                return;
            }
        }
    }

    private static ConfigException O000000o() {
        return new ConfigException.BugOrBroken(SerializedConfigValue.class.getName() + " should not exist outside of serialization");
    }

    public final ConfigValueType O00000o0() {
        throw O000000o();
    }

    public final Object O00000o() {
        throw O000000o();
    }

    public static void O000000o(DataOutput dataOutput, dtj dtj, dtj dtj2) throws IOException {
        Map map;
        Map<SerializedField, Object> map2;
        if (dtj != null) {
            if (dtj2 != null) {
                map2 = dtj2.O00000o();
            } else {
                map2 = Collections.emptyMap();
            }
            Map<SerializedField, Object> O00000o = dtj.O00000o();
            map = new EnumMap(O00000o);
            for (Map.Entry entry : map2.entrySet()) {
                SerializedField serializedField = (SerializedField) entry.getKey();
                if (map.containsKey(serializedField) && dst.O000000o(entry.getValue(), map.get(serializedField))) {
                    map.remove(serializedField);
                } else if (!map.containsKey(serializedField)) {
                    switch (dtj.AnonymousClass1.f14923O000000o[serializedField.ordinal()]) {
                        case 1:
                            throw new ConfigException.BugOrBroken("origin missing description field? ".concat(String.valueOf(O00000o)));
                        case 2:
                            map.put(SerializedField.ORIGIN_LINE_NUMBER, -1);
                            continue;
                        case 3:
                            map.put(SerializedField.ORIGIN_END_LINE_NUMBER, -1);
                            continue;
                        case 4:
                            throw new ConfigException.BugOrBroken("should always be an ORIGIN_TYPE field");
                        case 5:
                            map.put(SerializedField.ORIGIN_NULL_URL, "");
                            continue;
                        case 6:
                            map.put(SerializedField.ORIGIN_NULL_COMMENTS, "");
                            continue;
                        case 7:
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            throw new ConfigException.BugOrBroken("computing delta, base object should not contain " + serializedField + " " + map2);
                        case 9:
                        case 10:
                        case 11:
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        case 13:
                        case 14:
                            throw new ConfigException.BugOrBroken("should not appear here: ".concat(String.valueOf(serializedField)));
                    }
                } else {
                    continue;
                }
            }
        } else {
            map = Collections.emptyMap();
        }
        for (Map.Entry entry2 : map.entrySet()) {
            O000000o o000000o = new O000000o((SerializedField) entry2.getKey());
            O000000o(o000000o.O00000o0, o000000o.f5922O000000o, entry2.getValue());
            O000000o(dataOutput, o000000o);
        }
        O000000o(dataOutput);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        throw O000000o();
    }
}
