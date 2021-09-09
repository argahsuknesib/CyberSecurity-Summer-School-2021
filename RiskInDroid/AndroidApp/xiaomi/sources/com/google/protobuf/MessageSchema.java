package com.google.protobuf;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import sun.misc.Unsafe;

final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & 268435456) != 0;
    }

    private static long offset(int i) {
        return (long) (i & 1048575);
    }

    private static int type(int i) {
        return (i & 267386880) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema2 != null && extensionSchema2.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        int i;
        int i2;
        char c;
        char c2;
        char c3;
        char c4;
        int[] iArr;
        int i3;
        char c5;
        char c6;
        int i4;
        int i5;
        String str;
        int i6;
        char c7;
        int i7;
        int i8;
        Class<?> cls;
        int i9;
        int i10;
        char c8;
        Field field;
        char charAt;
        int i11;
        int i12;
        Field field2;
        Field field3;
        int i13;
        char charAt2;
        int i14;
        char charAt3;
        int i15;
        char charAt4;
        int i16;
        char c9;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        char charAt5;
        int i22;
        char charAt6;
        int i23;
        char charAt7;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        char charAt12;
        char charAt13;
        char charAt14;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char charAt15 = stringInfo.charAt(0);
        char c10 = 55296;
        if (charAt15 >= 55296) {
            char c11 = charAt15 & 8191;
            int i24 = 1;
            int i25 = 13;
            while (true) {
                i = i24 + 1;
                charAt14 = stringInfo.charAt(i24);
                if (charAt14 < 55296) {
                    break;
                }
                c11 |= (charAt14 & 8191) << i25;
                i25 += 13;
                i24 = i;
            }
            charAt15 = (charAt14 << i25) | c11;
        } else {
            i = 1;
        }
        int i26 = i + 1;
        char charAt16 = stringInfo.charAt(i);
        if (charAt16 >= 55296) {
            char c12 = charAt16 & 8191;
            int i27 = 13;
            while (true) {
                i2 = i26 + 1;
                charAt13 = stringInfo.charAt(i26);
                if (charAt13 < 55296) {
                    break;
                }
                c12 |= (charAt13 & 8191) << i27;
                i27 += 13;
                i26 = i2;
            }
            charAt16 = c12 | (charAt13 << i27);
        } else {
            i2 = i26;
        }
        if (charAt16 == 0) {
            iArr = EMPTY_INT_ARRAY;
            c6 = 0;
            c5 = 0;
            i3 = 0;
            c4 = 0;
            c3 = 0;
            c2 = 0;
            c = 0;
        } else {
            int i28 = i2 + 1;
            char charAt17 = stringInfo.charAt(i2);
            if (charAt17 >= 55296) {
                char c13 = charAt17 & 8191;
                int i29 = 13;
                while (true) {
                    i16 = i28 + 1;
                    charAt12 = stringInfo.charAt(i28);
                    if (charAt12 < 55296) {
                        break;
                    }
                    c13 |= (charAt12 & 8191) << i29;
                    i29 += 13;
                    i28 = i16;
                }
                c9 = (charAt12 << i29) | c13;
            } else {
                i16 = i28;
                c9 = charAt17;
            }
            int i30 = i16 + 1;
            char charAt18 = stringInfo.charAt(i16);
            if (charAt18 >= 55296) {
                char c14 = charAt18 & 8191;
                int i31 = 13;
                while (true) {
                    i17 = i30 + 1;
                    charAt11 = stringInfo.charAt(i30);
                    if (charAt11 < 55296) {
                        break;
                    }
                    c14 |= (charAt11 & 8191) << i31;
                    i31 += 13;
                    i30 = i17;
                }
                charAt18 = c14 | (charAt11 << i31);
            } else {
                i17 = i30;
            }
            int i32 = i17 + 1;
            char charAt19 = stringInfo.charAt(i17);
            if (charAt19 >= 55296) {
                char c15 = charAt19 & 8191;
                int i33 = 13;
                while (true) {
                    i18 = i32 + 1;
                    charAt10 = stringInfo.charAt(i32);
                    if (charAt10 < 55296) {
                        break;
                    }
                    c15 |= (charAt10 & 8191) << i33;
                    i33 += 13;
                    i32 = i18;
                }
                charAt19 = (charAt10 << i33) | c15;
            } else {
                i18 = i32;
            }
            int i34 = i18 + 1;
            char charAt20 = stringInfo.charAt(i18);
            if (charAt20 >= 55296) {
                char c16 = charAt20 & 8191;
                int i35 = 13;
                while (true) {
                    i19 = i34 + 1;
                    charAt9 = stringInfo.charAt(i34);
                    if (charAt9 < 55296) {
                        break;
                    }
                    c16 |= (charAt9 & 8191) << i35;
                    i35 += 13;
                    i34 = i19;
                }
                charAt20 = (charAt9 << i35) | c16;
            } else {
                i19 = i34;
            }
            int i36 = i19 + 1;
            c4 = stringInfo.charAt(i19);
            if (c4 >= 55296) {
                char c17 = c4 & 8191;
                int i37 = 13;
                while (true) {
                    i20 = i36 + 1;
                    charAt8 = stringInfo.charAt(i36);
                    if (charAt8 < 55296) {
                        break;
                    }
                    c17 |= (charAt8 & 8191) << i37;
                    i37 += 13;
                    i36 = i20;
                }
                c4 = (charAt8 << i37) | c17;
            } else {
                i20 = i36;
            }
            int i38 = i20 + 1;
            c3 = stringInfo.charAt(i20);
            if (c3 >= 55296) {
                char c18 = c3 & 8191;
                int i39 = 13;
                while (true) {
                    i23 = i38 + 1;
                    charAt7 = stringInfo.charAt(i38);
                    if (charAt7 < 55296) {
                        break;
                    }
                    c18 |= (charAt7 & 8191) << i39;
                    i39 += 13;
                    i38 = i23;
                }
                c3 = (charAt7 << i39) | c18;
                i38 = i23;
            }
            int i40 = i38 + 1;
            char charAt21 = stringInfo.charAt(i38);
            if (charAt21 >= 55296) {
                char c19 = charAt21 & 8191;
                int i41 = 13;
                while (true) {
                    i22 = i40 + 1;
                    charAt6 = stringInfo.charAt(i40);
                    if (charAt6 < 55296) {
                        break;
                    }
                    c19 |= (charAt6 & 8191) << i41;
                    i41 += 13;
                    i40 = i22;
                }
                charAt21 = c19 | (charAt6 << i41);
                i40 = i22;
            }
            int i42 = i40 + 1;
            c2 = stringInfo.charAt(i40);
            if (c2 >= 55296) {
                int i43 = 13;
                int i44 = i42;
                char c20 = c2 & 8191;
                int i45 = i44;
                while (true) {
                    i21 = i45 + 1;
                    charAt5 = stringInfo.charAt(i45);
                    if (charAt5 < 55296) {
                        break;
                    }
                    c20 |= (charAt5 & 8191) << i43;
                    i43 += 13;
                    i45 = i21;
                }
                c2 = c20 | (charAt5 << i43);
                i42 = i21;
            }
            i3 = (c9 * 2) + charAt18;
            int i46 = i42;
            c = c9;
            c6 = charAt19;
            i2 = i46;
            char c21 = charAt20;
            iArr = new int[(c2 + c3 + charAt21)];
            c5 = c21;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects2 = rawMessageInfo.getObjects();
        Class<?> cls2 = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[(c4 * 3)];
        Object[] objArr = new Object[(c4 * 2)];
        int i47 = c3 + c2;
        int i48 = i47;
        char c22 = c2;
        int i49 = 0;
        int i50 = 0;
        while (i2 < length) {
            int i51 = i2 + 1;
            int charAt22 = stringInfo.charAt(i2);
            if (charAt22 >= c10) {
                int i52 = 13;
                int i53 = i51;
                int i54 = charAt22 & 8191;
                int i55 = i53;
                while (true) {
                    i15 = i55 + 1;
                    charAt4 = stringInfo.charAt(i55);
                    if (charAt4 < c10) {
                        break;
                    }
                    i54 |= (charAt4 & 8191) << i52;
                    i52 += 13;
                    i55 = i15;
                }
                charAt22 = i54 | (charAt4 << i52);
                i4 = i15;
            } else {
                i4 = i51;
            }
            int i56 = i4 + 1;
            char charAt23 = stringInfo.charAt(i4);
            int i57 = length;
            char c23 = 55296;
            if (charAt23 >= 55296) {
                int i58 = 13;
                int i59 = i56;
                char c24 = charAt23 & 8191;
                int i60 = i59;
                while (true) {
                    i14 = i60 + 1;
                    charAt3 = stringInfo.charAt(i60);
                    if (charAt3 < c23) {
                        break;
                    }
                    c24 |= (charAt3 & 8191) << i58;
                    i58 += 13;
                    i60 = i14;
                    c23 = 55296;
                }
                charAt23 = c24 | (charAt3 << i58);
                i5 = i14;
            } else {
                i5 = i56;
            }
            int i61 = i47;
            char c25 = charAt23 & 255;
            char c26 = c2;
            if ((charAt23 & 1024) != 0) {
                iArr[i49] = i50;
                i49++;
            }
            boolean z2 = z;
            if (c25 >= '3') {
                int i62 = i5 + 1;
                char charAt24 = stringInfo.charAt(i5);
                char c27 = 55296;
                if (charAt24 >= 55296) {
                    char c28 = charAt24 & 8191;
                    int i63 = 13;
                    while (true) {
                        i13 = i62 + 1;
                        charAt2 = stringInfo.charAt(i62);
                        if (charAt2 < c27) {
                            break;
                        }
                        c28 |= (charAt2 & 8191) << i63;
                        i63 += 13;
                        i62 = i13;
                        c27 = 55296;
                    }
                    charAt24 = c28 | (charAt2 << i63);
                    i62 = i13;
                }
                int i64 = c25 - '3';
                int i65 = i62;
                if (i64 == 9 || i64 == 17) {
                    i12 = i3 + 1;
                    objArr[((i50 / 3) * 2) + 1] = objects2[i3];
                } else if (i64 == 12 && (charAt15 & 1) == 1) {
                    i12 = i3 + 1;
                    objArr[((i50 / 3) * 2) + 1] = objects2[i3];
                } else {
                    i12 = i3;
                }
                int i66 = charAt24 * 2;
                Object obj = objects2[i66];
                if (obj instanceof Field) {
                    field2 = (Field) obj;
                } else {
                    field2 = reflectField(cls2, (String) obj);
                    objects2[i66] = field2;
                }
                int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                int i67 = i66 + 1;
                Object obj2 = objects2[i67];
                int i68 = objectFieldOffset;
                if (obj2 instanceof Field) {
                    field3 = (Field) obj2;
                } else {
                    field3 = reflectField(cls2, (String) obj2);
                    objects2[i67] = field3;
                }
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(field3);
                str = stringInfo;
                c8 = charAt15;
                i7 = i12;
                i8 = i68;
                i6 = i65;
                c7 = c5;
                cls = cls2;
                i9 = objectFieldOffset2;
                i10 = 0;
            } else {
                i7 = i3 + 1;
                Field reflectField = reflectField(cls2, (String) objects2[i3]);
                if (c25 == 9 || c25 == 17) {
                    c7 = c5;
                    objArr[((i50 / 3) * 2) + 1] = reflectField.getType();
                } else {
                    if (c25 == 27 || c25 == '1') {
                        c7 = c5;
                        i11 = i7 + 1;
                        objArr[((i50 / 3) * 2) + 1] = objects2[i7];
                    } else if (c25 == 12 || c25 == 30 || c25 == ',') {
                        c7 = c5;
                        if ((charAt15 & 1) == 1) {
                            i11 = i7 + 1;
                            objArr[((i50 / 3) * 2) + 1] = objects2[i7];
                        }
                    } else if (c25 == '2') {
                        int i69 = c22 + 1;
                        iArr[c22] = i50;
                        int i70 = (i50 / 3) * 2;
                        int i71 = i7 + 1;
                        objArr[i70] = objects2[i7];
                        if ((charAt23 & 2048) != 0) {
                            i7 = i71 + 1;
                            objArr[i70 + 1] = objects2[i71];
                            c7 = c5;
                            c22 = i69;
                        } else {
                            c22 = i69;
                            i7 = i71;
                            c7 = c5;
                        }
                    } else {
                        c7 = c5;
                    }
                    i7 = i11;
                }
                i8 = (int) unsafe.objectFieldOffset(reflectField);
                if ((charAt15 & 1) != 1 || c25 > 17) {
                    str = stringInfo;
                    c8 = charAt15;
                    cls = cls2;
                    i6 = i5;
                    i10 = 0;
                    i9 = 0;
                } else {
                    int i72 = i5 + 1;
                    char charAt25 = stringInfo.charAt(i5);
                    if (charAt25 >= 55296) {
                        char c29 = charAt25 & 8191;
                        int i73 = 13;
                        while (true) {
                            i6 = i72 + 1;
                            charAt = stringInfo.charAt(i72);
                            if (charAt < 55296) {
                                break;
                            }
                            c29 |= (charAt & 8191) << i73;
                            i73 += 13;
                            i72 = i6;
                        }
                        charAt25 = c29 | (charAt << i73);
                    } else {
                        i6 = i72;
                    }
                    int i74 = (c * 2) + (charAt25 / ' ');
                    Object obj3 = objects2[i74];
                    str = stringInfo;
                    if (obj3 instanceof Field) {
                        field = (Field) obj3;
                    } else {
                        field = reflectField(cls2, (String) obj3);
                        objects2[i74] = field;
                    }
                    c8 = charAt15;
                    cls = cls2;
                    i9 = (int) unsafe.objectFieldOffset(field);
                    i10 = charAt25 % ' ';
                }
                if (c25 >= 18 && c25 <= '1') {
                    iArr[i48] = i8;
                    i48++;
                }
            }
            int i75 = i50 + 1;
            iArr2[i50] = charAt22;
            int i76 = i75 + 1;
            iArr2[i75] = ((charAt23 & 256) != 0 ? 268435456 : 0) | ((charAt23 & 512) != 0 ? 536870912 : 0) | (c25 << 20) | i8;
            i50 = i76 + 1;
            iArr2[i76] = (i10 << 20) | i9;
            charAt15 = c8;
            cls2 = cls;
            i3 = i7;
            i47 = i61;
            length = i57;
            c2 = c26;
            c5 = c7;
            i2 = i6;
            z = z2;
            stringInfo = str;
            c10 = 55296;
        }
        return new MessageSchema(iArr2, objArr, c6, c5, rawMessageInfo.getDefaultInstance(), z, false, iArr, c2, i47, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        int i;
        int i2;
        int i3;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i2 = 0;
            i = 0;
        } else {
            i2 = fields[0].getFieldNumber();
            i = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i4++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = null;
        int[] iArr3 = i4 > 0 ? new int[i4] : null;
        if (i5 > 0) {
            iArr2 = new int[i5];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fields.length) {
            FieldInfo fieldInfo2 = fields[i6];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i7, z, objArr);
            if (i8 < checkInitialized.length && checkInitialized[i8] == fieldNumber) {
                checkInitialized[i8] = i7;
                i8++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr3[i9] = i7;
                i9++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i3 = i7;
                iArr2[i10] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i10++;
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr3.length + iArr2.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length, iArr3.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length + iArr3.length, iArr2.length);
        return new MessageSchema(iArr, objArr, i2, i, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr3.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc  */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, boolean z, Object[] objArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        OneofInfo oneof = fieldInfo.getOneof();
        int i6 = 0;
        if (oneof != null) {
            i3 = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            i4 = fieldInfo.getType().id() + 51;
            i2 = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fieldInfo.getType();
            i3 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            i4 = type.id();
            if (!z && !type.isList() && !type.isMap()) {
                i2 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getPresenceField());
                i5 = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
                iArr[i] = fieldInfo.getFieldNumber();
                int i7 = i + 1;
                int i8 = !fieldInfo.isEnforceUtf8() ? 536870912 : 0;
                if (fieldInfo.isRequired()) {
                    i6 = 268435456;
                }
                iArr[i7] = i6 | i8 | (i4 << 20) | i3;
                iArr[i + 2] = i2 | (i5 << 20);
                Class<?> messageFieldClass = fieldInfo.getMessageFieldClass();
                if (fieldInfo.getMapDefaultEntry() == null) {
                    int i9 = (i / 3) * 2;
                    objArr[i9] = fieldInfo.getMapDefaultEntry();
                    if (messageFieldClass != null) {
                        objArr[i9 + 1] = messageFieldClass;
                        return;
                    } else if (fieldInfo.getEnumVerifier() != null) {
                        objArr[i9 + 1] = fieldInfo.getEnumVerifier();
                        return;
                    } else {
                        return;
                    }
                } else if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                } else {
                    return;
                }
            } else if (fieldInfo.getCachedSizeField() == null) {
                i2 = 0;
            } else {
                i2 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
        }
        i5 = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        int i72 = i + 1;
        if (!fieldInfo.isEnforceUtf8()) {
        }
        if (fieldInfo.isRequired()) {
        }
        iArr[i72] = i6 | i8 | (i4 << 20) | i3;
        iArr[i + 2] = i2 | (i5 << 20);
        Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() == null) {
        }
    }

    public final T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    public final boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, offset));
            case 1:
                return arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat(t, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, offset));
            case 2:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 3:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 4:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 5:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 6:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 7:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean(t, offset) == UnsafeUtil.getBoolean(t2, offset);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 9:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 10:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 11:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 13:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 14:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 16:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 17:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            default:
                return true;
        }
    }

    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.buffer.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i4);
            int numberAt = numberAt(i4);
            long offset = offset(typeAndOffsetAt);
            int i5 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i2 = i3 * 53;
                    i = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(UnsafeUtil.getFloat(t, offset));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = Internal.hashBoolean(UnsafeUtil.getBoolean(t, offset));
                    i3 = i2 + i;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    i2 = i3 * 53;
                    i = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, offset);
                    if (object != null) {
                        i5 = object.hashCode();
                    }
                    i3 = (i3 * 53) + i5;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getObject(t, offset).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, offset);
                    if (object2 != null) {
                        i5 = object2.hashCode();
                    }
                    i3 = (i3 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getObject(t, offset).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getObject(t, offset).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, offset)));
                        i3 = i2 + i;
                        break;
                    }
                case 52:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(oneofFloatAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 53:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 55:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    }
                case 56:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 57:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    }
                case 58:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashBoolean(oneofBooleanAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = UnsafeUtil.getObject(t, offset).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = UnsafeUtil.getObject(t, offset).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 62:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    }
                case 63:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    }
                case 64:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    }
                case 65:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 66:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    }
                case 67:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!isOneofPresent(t, numberAt, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = UnsafeUtil.getObject(t, offset).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : hashCode;
    }

    public final void mergeFrom(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.buffer.length; i += 3) {
                mergeSingleField(t, t2, i);
            }
            SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
            if (this.hasExtensions) {
                SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private void mergeSingleField(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, offset, UnsafeUtil.getDouble(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, offset, UnsafeUtil.getFloat(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, offset, UnsafeUtil.getBoolean(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 9:
                mergeMessage(t, t2, i);
                return;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 17:
                mergeMessage(t, t2, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t, t2, i);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t, t2, i);
                return;
            default:
                return;
        }
    }

    private void mergeMessage(T t, T t2, int i) {
        long offset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        int numberAt = numberAt(i);
        long offset = offset(typeAndOffsetAt);
        if (isOneofPresent(t2, numberAt, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, numberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setOneofPresent(t, numberAt, i);
            }
        }
    }

    public final int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int computeDoubleSize;
        int i3;
        int i4;
        int i5;
        T t2 = t;
        Unsafe unsafe = UNSAFE;
        int i6 = 0;
        int i7 = -1;
        int i8 = 0;
        for (int i9 = 0; i9 < this.buffer.length; i9 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i9);
            int numberAt = numberAt(i9);
            int type = type(typeAndOffsetAt);
            if (type <= 17) {
                i2 = this.buffer[i9 + 2];
                int i10 = 1048575 & i2;
                int i11 = 1 << (i2 >>> 20);
                if (i10 != i7) {
                    i8 = unsafe.getInt(t2, (long) i10);
                    i7 = i10;
                }
                i = i11;
            } else {
                i2 = (!this.useCachedSizeField || type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i9 + 2] & 1048575;
                i = 0;
            }
            long offset = offset(typeAndOffsetAt);
            switch (type) {
                case 0:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 1:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 2:
                    long j = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(t2, j));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 3:
                    long j2 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(t2, j2));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 4:
                    long j3 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(t2, j3));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 5:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 7:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i6 += computeDoubleSize;
                        break;
                    }
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    long j4 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t2, j4);
                        computeDoubleSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object) : CodedOutputStream.computeStringSize(numberAt, (String) object);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 9:
                    long j5 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t2, j5), getMessageFieldSchema(i9));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 10:
                    long j6 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t2, j6));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 11:
                    long j7 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(t2, j7));
                        i6 += computeDoubleSize;
                        break;
                    }
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    long j8 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(t2, j8));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 13:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 14:
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    long j9 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(t2, j9));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 16:
                    long j10 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(t2, j10));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 17:
                    long j11 = offset;
                    if ((i8 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t2, j11), getMessageFieldSchema(i9));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 18:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 19:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 20:
                    computeDoubleSize = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 21:
                    computeDoubleSize = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 22:
                    computeDoubleSize = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 23:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 24:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 25:
                    computeDoubleSize = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 26:
                    computeDoubleSize = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(t2, offset));
                    i6 += computeDoubleSize;
                    break;
                case 27:
                    computeDoubleSize = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(t2, offset), getMessageFieldSchema(i9));
                    i6 += computeDoubleSize;
                    break;
                case 28:
                    computeDoubleSize = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(t2, offset));
                    i6 += computeDoubleSize;
                    break;
                case 29:
                    computeDoubleSize = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 30:
                    computeDoubleSize = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 31:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 32:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 33:
                    computeDoubleSize = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 34:
                    computeDoubleSize = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(t2, offset), false);
                    i6 += computeDoubleSize;
                    break;
                case 35:
                    i5 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i5 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i5 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i5 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i5 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i5 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i5 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i5 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i5 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i5 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i5 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i5 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i5 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i5 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i5 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i2, i5);
                        }
                        i4 = CodedOutputStream.computeTagSize(numberAt);
                        i3 = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        i6 += i4 + i3 + i5;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    computeDoubleSize = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(t2, offset), getMessageFieldSchema(i9));
                    i6 += computeDoubleSize;
                    break;
                case 50:
                    computeDoubleSize = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(t2, offset), getMapFieldDefaultEntry(i9));
                    i6 += computeDoubleSize;
                    break;
                case 51:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 52:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 53:
                    long j12 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t2, j12));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 54:
                    long j13 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t2, j13));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 55:
                    long j14 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t2, j14));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 56:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 57:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 58:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 59:
                    long j15 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t2, j15);
                        computeDoubleSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 60:
                    long j16 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t2, j16), getMessageFieldSchema(i9));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 61:
                    long j17 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t2, j17));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 62:
                    long j18 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t2, j18));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 63:
                    long j19 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t2, j19));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 64:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 65:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 66:
                    long j20 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t2, j20));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 67:
                    long j21 = offset;
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t2, j21));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 68:
                    if (!isOneofPresent(t2, numberAt, i9)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t2, offset), getMessageFieldSchema(i9));
                        i6 += computeDoubleSize;
                        break;
                    }
            }
        }
        int unknownFieldsSerializedSize = i6 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t2);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t2).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int computeDoubleSize;
        int i;
        int i2;
        int i3;
        T t2 = t;
        Unsafe unsafe = UNSAFE;
        int i4 = 0;
        for (int i5 = 0; i5 < this.buffer.length; i5 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i5);
            long offset = offset(typeAndOffsetAt);
            int i6 = (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i5 + 2] & 1048575;
            switch (type) {
                case 0:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, UnsafeUtil.getLong(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, UnsafeUtil.getLong(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, UnsafeUtil.getInt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        break;
                    } else {
                        continue;
                    }
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (isFieldPresent(t2, i5)) {
                        Object object = UnsafeUtil.getObject(t2, offset);
                        if (!(object instanceof ByteString)) {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t2, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, UnsafeUtil.getInt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, UnsafeUtil.getInt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, UnsafeUtil.getInt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, UnsafeUtil.getLong(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if (isFieldPresent(t2, i5)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t2, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t2, offset), false);
                    break;
                case 19:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t2, offset), false);
                    break;
                case 20:
                    computeDoubleSize = SchemaUtil.computeSizeInt64List(numberAt, listAt(t2, offset), false);
                    break;
                case 21:
                    computeDoubleSize = SchemaUtil.computeSizeUInt64List(numberAt, listAt(t2, offset), false);
                    break;
                case 22:
                    computeDoubleSize = SchemaUtil.computeSizeInt32List(numberAt, listAt(t2, offset), false);
                    break;
                case 23:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t2, offset), false);
                    break;
                case 24:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t2, offset), false);
                    break;
                case 25:
                    computeDoubleSize = SchemaUtil.computeSizeBoolList(numberAt, listAt(t2, offset), false);
                    break;
                case 26:
                    computeDoubleSize = SchemaUtil.computeSizeStringList(numberAt, listAt(t2, offset));
                    break;
                case 27:
                    computeDoubleSize = SchemaUtil.computeSizeMessageList(numberAt, listAt(t2, offset), getMessageFieldSchema(i5));
                    break;
                case 28:
                    computeDoubleSize = SchemaUtil.computeSizeByteStringList(numberAt, listAt(t2, offset));
                    break;
                case 29:
                    computeDoubleSize = SchemaUtil.computeSizeUInt32List(numberAt, listAt(t2, offset), false);
                    break;
                case 30:
                    computeDoubleSize = SchemaUtil.computeSizeEnumList(numberAt, listAt(t2, offset), false);
                    break;
                case 31:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t2, offset), false);
                    break;
                case 32:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t2, offset), false);
                    break;
                case 33:
                    computeDoubleSize = SchemaUtil.computeSizeSInt32List(numberAt, listAt(t2, offset), false);
                    break;
                case 34:
                    computeDoubleSize = SchemaUtil.computeSizeSInt64List(numberAt, listAt(t2, offset), false);
                    break;
                case 35:
                    i2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 36:
                    i2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 37:
                    i2 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 38:
                    i2 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 39:
                    i2 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 40:
                    i2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 41:
                    i2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 42:
                    i2 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 43:
                    i2 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 44:
                    i2 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    i2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 46:
                    i2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 47:
                    i2 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 48:
                    i2 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t2, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t2, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 49:
                    computeDoubleSize = SchemaUtil.computeSizeGroupList(numberAt, listAt(t2, offset), getMessageFieldSchema(i5));
                    break;
                case 50:
                    computeDoubleSize = this.mapFieldSchema.getSerializedSize(numberAt, UnsafeUtil.getObject(t2, offset), getMapFieldDefaultEntry(i5));
                    break;
                case 51:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 56:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        Object object2 = UnsafeUtil.getObject(t2, offset);
                        if (!(object2 instanceof ByteString)) {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object2);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t2, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 62:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 63:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 64:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 67:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t2, offset));
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (isOneofPresent(t2, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t2, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i4 += computeDoubleSize;
        }
        return i4 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t2);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t));
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    public final void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) throws IOException {
        Map.Entry entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        Map.Entry entry2;
        int i;
        int i2;
        int i3;
        int i4;
        T t2 = t;
        Writer writer2 = writer;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t2);
            if (!extensions.isEmpty()) {
                it = extensions.iterator();
                entry = it.next();
                int i5 = -1;
                length = this.buffer.length;
                Unsafe unsafe = UNSAFE;
                entry2 = entry;
                int i6 = 0;
                for (i = 0; i < length; i = i4 + 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    int type = type(typeAndOffsetAt);
                    if (this.proto3 || type > 17) {
                        i2 = i;
                        i3 = 0;
                    } else {
                        int i7 = this.buffer[i + 2];
                        int i8 = i7 & 1048575;
                        if (i8 != i5) {
                            i2 = i;
                            i6 = unsafe.getInt(t2, (long) i8);
                            i5 = i8;
                        } else {
                            i2 = i;
                        }
                        i3 = 1 << (i7 >>> 20);
                    }
                    while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer2, entry2);
                        entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long offset = offset(typeAndOffsetAt);
                    switch (type) {
                        case 0:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeDouble(numberAt, doubleAt(t2, offset));
                                continue;
                            }
                        case 1:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeFloat(numberAt, floatAt(t2, offset));
                            } else {
                                continue;
                            }
                        case 2:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeInt64(numberAt, unsafe.getLong(t2, offset));
                            } else {
                                continue;
                            }
                        case 3:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeUInt64(numberAt, unsafe.getLong(t2, offset));
                            } else {
                                continue;
                            }
                        case 4:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeInt32(numberAt, unsafe.getInt(t2, offset));
                            } else {
                                continue;
                            }
                        case 5:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeFixed64(numberAt, unsafe.getLong(t2, offset));
                            } else {
                                continue;
                            }
                        case 6:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeFixed32(numberAt, unsafe.getInt(t2, offset));
                            } else {
                                continue;
                            }
                        case 7:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeBool(numberAt, booleanAt(t2, offset));
                            } else {
                                continue;
                            }
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writeString(numberAt, unsafe.getObject(t2, offset), writer2);
                            } else {
                                continue;
                            }
                        case 9:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeMessage(numberAt, unsafe.getObject(t2, offset), getMessageFieldSchema(i4));
                            } else {
                                continue;
                            }
                        case 10:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeBytes(numberAt, (ByteString) unsafe.getObject(t2, offset));
                            } else {
                                continue;
                            }
                        case 11:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeUInt32(numberAt, unsafe.getInt(t2, offset));
                            } else {
                                continue;
                            }
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeEnum(numberAt, unsafe.getInt(t2, offset));
                            } else {
                                continue;
                            }
                        case 13:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeSFixed32(numberAt, unsafe.getInt(t2, offset));
                            } else {
                                continue;
                            }
                        case 14:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeSFixed64(numberAt, unsafe.getLong(t2, offset));
                            } else {
                                continue;
                            }
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeSInt32(numberAt, unsafe.getInt(t2, offset));
                            } else {
                                continue;
                            }
                        case 16:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeSInt64(numberAt, unsafe.getLong(t2, offset));
                            } else {
                                continue;
                            }
                        case 17:
                            i4 = i2;
                            if ((i3 & i6) != 0) {
                                writer2.writeGroup(numberAt, unsafe.getObject(t2, offset), getMessageFieldSchema(i4));
                            } else {
                                continue;
                            }
                        case 18:
                            i4 = i2;
                            SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 19:
                            i4 = i2;
                            SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 20:
                            i4 = i2;
                            SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 21:
                            i4 = i2;
                            SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 22:
                            i4 = i2;
                            SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 23:
                            i4 = i2;
                            SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 24:
                            i4 = i2;
                            SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 25:
                            i4 = i2;
                            SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            continue;
                        case 26:
                            i4 = i2;
                            SchemaUtil.writeStringList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2);
                            break;
                        case 27:
                            i4 = i2;
                            SchemaUtil.writeMessageList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, getMessageFieldSchema(i4));
                            break;
                        case 28:
                            i4 = i2;
                            SchemaUtil.writeBytesList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2);
                            break;
                        case 29:
                            i4 = i2;
                            SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            break;
                        case 30:
                            i4 = i2;
                            SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            break;
                        case 31:
                            i4 = i2;
                            SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            break;
                        case 32:
                            i4 = i2;
                            SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            break;
                        case 33:
                            i4 = i2;
                            SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            break;
                        case 34:
                            i4 = i2;
                            SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, false);
                            break;
                        case 35:
                            i4 = i2;
                            SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 36:
                            i4 = i2;
                            SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 37:
                            i4 = i2;
                            SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 38:
                            i4 = i2;
                            SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 39:
                            i4 = i2;
                            SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 40:
                            i4 = i2;
                            SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 41:
                            i4 = i2;
                            SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 42:
                            i4 = i2;
                            SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 43:
                            i4 = i2;
                            SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 44:
                            i4 = i2;
                            SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 45:
                            i4 = i2;
                            SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 46:
                            i4 = i2;
                            SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 47:
                            i4 = i2;
                            SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 48:
                            i4 = i2;
                            SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, true);
                            break;
                        case 49:
                            i4 = i2;
                            SchemaUtil.writeGroupList(numberAt(i4), (List) unsafe.getObject(t2, offset), writer2, getMessageFieldSchema(i4));
                            break;
                        case 50:
                            i4 = i2;
                            writeMapHelper(writer2, numberAt, unsafe.getObject(t2, offset), i4);
                            break;
                        case 51:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeDouble(numberAt, oneofDoubleAt(t2, offset));
                                break;
                            }
                            break;
                        case 52:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeFloat(numberAt, oneofFloatAt(t2, offset));
                                break;
                            }
                            break;
                        case 53:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeInt64(numberAt, oneofLongAt(t2, offset));
                                break;
                            }
                            break;
                        case 54:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeUInt64(numberAt, oneofLongAt(t2, offset));
                                break;
                            }
                            break;
                        case 55:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeInt32(numberAt, oneofIntAt(t2, offset));
                                break;
                            }
                            break;
                        case 56:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeFixed64(numberAt, oneofLongAt(t2, offset));
                                break;
                            }
                            break;
                        case 57:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeFixed32(numberAt, oneofIntAt(t2, offset));
                                break;
                            }
                            break;
                        case 58:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeBool(numberAt, oneofBooleanAt(t2, offset));
                                break;
                            }
                            break;
                        case 59:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writeString(numberAt, unsafe.getObject(t2, offset), writer2);
                                break;
                            }
                            break;
                        case 60:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeMessage(numberAt, unsafe.getObject(t2, offset), getMessageFieldSchema(i4));
                                break;
                            }
                            break;
                        case 61:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeBytes(numberAt, (ByteString) unsafe.getObject(t2, offset));
                                break;
                            }
                            break;
                        case 62:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeUInt32(numberAt, oneofIntAt(t2, offset));
                                break;
                            }
                            break;
                        case 63:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeEnum(numberAt, oneofIntAt(t2, offset));
                                break;
                            }
                            break;
                        case 64:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeSFixed32(numberAt, oneofIntAt(t2, offset));
                                break;
                            }
                            break;
                        case 65:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeSFixed64(numberAt, oneofLongAt(t2, offset));
                                break;
                            }
                            break;
                        case 66:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeSInt32(numberAt, oneofIntAt(t2, offset));
                                break;
                            }
                            break;
                        case 67:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeSInt64(numberAt, oneofLongAt(t2, offset));
                                break;
                            }
                            break;
                        case 68:
                            i4 = i2;
                            if (isOneofPresent(t2, numberAt, i4)) {
                                writer2.writeGroup(numberAt, unsafe.getObject(t2, offset), getMessageFieldSchema(i4));
                                break;
                            }
                            break;
                        default:
                            i4 = i2;
                            break;
                    }
                }
                while (entry2 != null) {
                    this.extensionSchema.serializeExtension(writer2, entry2);
                    entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                writeUnknownInMessageTo(this.unknownFieldSchema, t2, writer2);
            }
        }
        it = null;
        entry = null;
        int i52 = -1;
        length = this.buffer.length;
        Unsafe unsafe2 = UNSAFE;
        entry2 = entry;
        int i62 = 0;
        while (i < length) {
        }
        while (entry2 != null) {
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t2, writer2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0589  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) throws IOException {
        Map.Entry entry;
        Iterator it;
        int length;
        Map.Entry entry2;
        int i;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
                length = this.buffer.length;
                entry2 = entry;
                for (i = 0; i < length; i += 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry2);
                        entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, doubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 1:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeFloat(numberAt, floatAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 2:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 3:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeUInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 4:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 5:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 6:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 7:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeBool(numberAt, booleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            }
                        case 9:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            }
                        case 10:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 11:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeUInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeEnum(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 13:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeSFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 14:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeSFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeSInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 16:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeSInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 17:
                            if (!isFieldPresent(t, i)) {
                                break;
                            } else {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(i));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(i));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), i);
                            break;
                        case 51:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 52:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 53:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 54:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 55:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 56:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 57:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 58:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 59:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            }
                        case 60:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            }
                        case 61:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 62:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 63:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 64:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 65:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 66:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 67:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 68:
                            if (!isOneofPresent(t, numberAt, i)) {
                                break;
                            } else {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            }
                    }
                }
                while (entry2 != null) {
                    this.extensionSchema.serializeExtension(writer, entry2);
                    entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
            }
        }
        it = null;
        entry = null;
        length = this.buffer.length;
        entry2 = entry;
        while (i < length) {
        }
        while (entry2 != null) {
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    private void writeFieldsInDescendingOrder(T t, Writer writer) throws IOException {
        Map.Entry entry;
        Iterator it;
        int length;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.descendingIterator();
                entry = (Map.Entry) it.next();
                for (length = this.buffer.length - 3; length >= 0; length -= 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(length);
                    int numberAt = numberAt(length);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) > numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, doubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 1:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeFloat(numberAt, floatAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 2:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 3:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeUInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 4:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 5:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 6:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 7:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeBool(numberAt, booleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            }
                        case 9:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            }
                        case 10:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 11:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeUInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeEnum(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 13:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeSFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 14:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeSFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeSInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 16:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeSInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 17:
                            if (!isFieldPresent(t, length)) {
                                break;
                            } else {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), length);
                            break;
                        case 51:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 52:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 53:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 54:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 55:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 56:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 57:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 58:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 59:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            }
                        case 60:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            }
                        case 61:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 62:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 63:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 64:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 65:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 66:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 67:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            }
                        case 68:
                            if (!isOneofPresent(t, numberAt, length)) {
                                break;
                            } else {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    public final void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (extensionRegistryLite != null) {
            mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
            return;
        }
        throw new NullPointerException();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.protobuf.ExtensionSchema<ET> r18, T r19, com.google.protobuf.Reader r20, com.google.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.getFieldNumber()     // Catch:{ all -> 0x060f }
            int r3 = r8.positionForFieldNumber(r1)     // Catch:{ all -> 0x060f }
            if (r3 >= 0) goto L_0x008c
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.checkInitializedCount
        L_0x001e:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.setBuilderToMessage(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.hasExtensions     // Catch:{ all -> 0x060f }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            com.google.protobuf.MessageLite r2 = r8.defaultInstance     // Catch:{ all -> 0x060f }
            r15 = r18
            java.lang.Object r1 = r15.findExtensionByNumber(r11, r2, r1)     // Catch:{ all -> 0x060f }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004d
            com.google.protobuf.FieldSet r1 = r18.getMutableExtensions(r19)     // Catch:{ all -> 0x060f }
            r14 = r1
        L_0x004d:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.parseExtension(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x060f }
            goto L_0x000d
        L_0x005c:
            boolean r1 = r9.shouldDiscardUnknownFields(r0)     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x0075
            goto L_0x000d
        L_0x0069:
            if (r13 != 0) goto L_0x006f
            java.lang.Object r13 = r9.getBuilderFromMessage(r10)     // Catch:{ all -> 0x060f }
        L_0x006f:
            boolean r1 = r9.mergeOneFieldFrom(r13, r0)     // Catch:{ all -> 0x060f }
            if (r1 != 0) goto L_0x000d
        L_0x0075:
            int r0 = r8.checkInitializedCount
        L_0x0077:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x0086
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0077
        L_0x0086:
            if (r13 == 0) goto L_0x008b
            r9.setBuilderToMessage(r10, r13)
        L_0x008b:
            return
        L_0x008c:
            r15 = r18
            int r4 = r8.typeAndOffsetAt(r3)     // Catch:{ all -> 0x060f }
            int r2 = type(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            switch(r2) {
                case 0: goto L_0x059b;
                case 1: goto L_0x058b;
                case 2: goto L_0x057b;
                case 3: goto L_0x056b;
                case 4: goto L_0x055b;
                case 5: goto L_0x054b;
                case 6: goto L_0x053b;
                case 7: goto L_0x052b;
                case 8: goto L_0x0523;
                case 9: goto L_0x04ec;
                case 10: goto L_0x04dc;
                case 11: goto L_0x04cc;
                case 12: goto L_0x04a9;
                case 13: goto L_0x0499;
                case 14: goto L_0x0489;
                case 15: goto L_0x0479;
                case 16: goto L_0x0469;
                case 17: goto L_0x0432;
                case 18: goto L_0x0423;
                case 19: goto L_0x0414;
                case 20: goto L_0x0405;
                case 21: goto L_0x03f6;
                case 22: goto L_0x03e7;
                case 23: goto L_0x03d8;
                case 24: goto L_0x03c9;
                case 25: goto L_0x03ba;
                case 26: goto L_0x03b5;
                case 27: goto L_0x03a3;
                case 28: goto L_0x0394;
                case 29: goto L_0x0385;
                case 30: goto L_0x036e;
                case 31: goto L_0x035f;
                case 32: goto L_0x0350;
                case 33: goto L_0x0341;
                case 34: goto L_0x0332;
                case 35: goto L_0x0323;
                case 36: goto L_0x0314;
                case 37: goto L_0x0305;
                case 38: goto L_0x02f6;
                case 39: goto L_0x02e7;
                case 40: goto L_0x02d8;
                case 41: goto L_0x02c9;
                case 42: goto L_0x02ba;
                case 43: goto L_0x02ab;
                case 44: goto L_0x0294;
                case 45: goto L_0x0285;
                case 46: goto L_0x0276;
                case 47: goto L_0x0267;
                case 48: goto L_0x0258;
                case 49: goto L_0x0242;
                case 50: goto L_0x0231;
                case 51: goto L_0x021d;
                case 52: goto L_0x0209;
                case 53: goto L_0x01f5;
                case 54: goto L_0x01e1;
                case 55: goto L_0x01cd;
                case 56: goto L_0x01b9;
                case 57: goto L_0x01a5;
                case 58: goto L_0x0191;
                case 59: goto L_0x0189;
                case 60: goto L_0x0150;
                case 61: goto L_0x0140;
                case 62: goto L_0x012c;
                case 63: goto L_0x0105;
                case 64: goto L_0x00f1;
                case 65: goto L_0x00dd;
                case 66: goto L_0x00c9;
                case 67: goto L_0x00b5;
                case 68: goto L_0x00a1;
                default: goto L_0x0099;
            }     // Catch:{ InvalidWireTypeException -> 0x05c8 }
        L_0x0099:
            if (r13 != 0) goto L_0x05ab
            java.lang.Object r13 = r17.newBuilder()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x05ab
        L_0x00a1:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.readGroupBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00b5:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00c9:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00dd:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00f1:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0105:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x011c
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x0116
            goto L_0x011c
        L_0x0116:
            java.lang.Object r13 = com.google.protobuf.SchemaUtil.storeUnknownEnum(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x011c:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x012c:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0140:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.ByteString r2 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0150:
            boolean r2 = r8.isOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r2 == 0) goto L_0x0172
            long r5 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = com.google.protobuf.UnsafeUtil.getObject(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r5 = r0.readMessageBySchemaWithCheck(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = com.google.protobuf.Internal.mergeMessage(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x0184
        L_0x0172:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.readMessageBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
        L_0x0184:
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0189:
            r8.readString(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0191:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            boolean r2 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01a5:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01b9:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01cd:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01e1:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01f5:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0209:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x021d:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0231:
            java.lang.Object r4 = r8.getMapFieldDefaultEntry(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.mergeMap(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0242:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r6 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0258:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0267:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0276:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0285:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0294:
            com.google.protobuf.ListFieldSchema r2 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r2 = r2.mutableListAt(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r3 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r13 = com.google.protobuf.SchemaUtil.filterUnknownEnumList(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02ab:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02ba:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02c9:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02d8:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02e7:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02f6:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0305:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0314:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0323:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0332:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0341:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0350:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x035f:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x036e:
            com.google.protobuf.ListFieldSchema r2 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r2 = r2.mutableListAt(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r3 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r13 = com.google.protobuf.SchemaUtil.filterUnknownEnumList(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0385:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0394:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03a3:
            com.google.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.readMessageList(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03b5:
            r8.readStringList(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03ba:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03c9:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03d8:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03e7:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03f6:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0405:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0414:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0423:
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0432:
            boolean r1 = r8.isFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r1 == 0) goto L_0x0455
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.UnsafeUtil.getObject(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.readGroupBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.Internal.mergeMessage(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0455:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r4 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r4 = r0.readGroupBySchemaWithCheck(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0469:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putLong(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0479:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putInt(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0489:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putLong(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0499:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putInt(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04a9:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x04c0
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x04ba
            goto L_0x04c0
        L_0x04ba:
            java.lang.Object r13 = com.google.protobuf.SchemaUtil.storeUnknownEnum(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04c0:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putInt(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04cc:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putInt(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04dc:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.ByteString r4 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04ec:
            boolean r1 = r8.isFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r1 == 0) goto L_0x050f
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.UnsafeUtil.getObject(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.readMessageBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.Internal.mergeMessage(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x050f:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Schema r4 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r4 = r0.readMessageBySchemaWithCheck(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putObject(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0523:
            r8.readString(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x052b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            boolean r4 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putBoolean(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x053b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putInt(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x054b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putLong(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x055b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putInt(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x056b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putLong(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x057b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putLong(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x058b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putFloat(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x059b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.UnsafeUtil.putDouble(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x05ab:
            boolean r1 = r9.mergeOneFieldFrom(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.checkInitializedCount
        L_0x05b3:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x05c2
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05b3
        L_0x05c2:
            if (r13 == 0) goto L_0x05c7
            r9.setBuilderToMessage(r10, r13)
        L_0x05c7:
            return
        L_0x05c8:
            boolean r1 = r9.shouldDiscardUnknownFields(r0)     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x05eb
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x060f }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.checkInitializedCount
        L_0x05d6:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x05e5
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05d6
        L_0x05e5:
            if (r13 == 0) goto L_0x05ea
            r9.setBuilderToMessage(r10, r13)
        L_0x05ea:
            return
        L_0x05eb:
            if (r13 != 0) goto L_0x05f2
            java.lang.Object r1 = r9.getBuilderFromMessage(r10)     // Catch:{ all -> 0x060f }
            r13 = r1
        L_0x05f2:
            boolean r1 = r9.mergeOneFieldFrom(r13, r0)     // Catch:{ all -> 0x060f }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.checkInitializedCount
        L_0x05fa:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x0609
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fa
        L_0x0609:
            if (r13 == 0) goto L_0x060e
            r9.setBuilderToMessage(r10, r13)
        L_0x060e:
            return
        L_0x060f:
            r0 = move-exception
            int r1 = r8.checkInitializedCount
        L_0x0612:
            int r2 = r8.repeatedFieldOffsetStart
            if (r1 >= r2) goto L_0x0621
            int[] r2 = r8.intArray
            r2 = r2[r1]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0612
        L_0x0621:
            if (r13 == 0) goto L_0x0626
            r9.setBuilderToMessage(r10, r13)
        L_0x0626:
            goto L_0x0628
        L_0x0627:
            throw r0
        L_0x0628:
            goto L_0x0627
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];

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
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case GmsLogger.MAX_PII_TAG_LENGTH:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int i3;
        byte[] bArr2 = bArr;
        int i4 = i2;
        MapEntryLite.Metadata<K, V> metadata2 = metadata;
        ArrayDecoders.Registers registers2 = registers;
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers2);
        int i5 = registers2.int1;
        if (i5 < 0 || i5 > i4 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = decodeVarint32 + i5;
        K k = metadata2.defaultKey;
        V v = metadata2.defaultValue;
        while (decodeVarint32 < i6) {
            int i7 = decodeVarint32 + 1;
            byte b = bArr2[decodeVarint32];
            if (b < 0) {
                i3 = ArrayDecoders.decodeVarint32(b, bArr, i7, registers2);
                b = registers2.int1;
            } else {
                i3 = i7;
            }
            int i8 = b >>> 3;
            byte b2 = b & 7;
            if (i8 != 1) {
                if (i8 == 2 && b2 == metadata2.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i3, i2, metadata2.valueType, metadata2.defaultValue.getClass(), registers);
                    v = registers2.object1;
                }
            } else if (b2 == metadata2.keyType.getWireType()) {
                decodeVarint32 = decodeMapEntryValue(bArr, i3, i2, metadata2.keyType, null, registers);
                k = registers2.object1;
            }
            decodeVarint32 = ArrayDecoders.skipField(b, bArr, i3, i4, registers2);
        }
        if (decodeVarint32 == i6) {
            map.put(k, v);
            return i6;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int i8;
        T t2 = t;
        int i9 = i;
        int i10 = i5;
        int i11 = i6;
        long j3 = j2;
        ArrayDecoders.Registers registers2 = registers;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) UNSAFE.getObject(t, j3);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UNSAFE.putObject(t, j3, protobufList);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers2);
                }
                if (i10 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers2);
                }
                if (i10 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers2);
                }
                if (i10 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers2);
                }
                if (i10 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 26:
                if (i10 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 27:
                if (i10 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i11), i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 28:
                if (i10 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i10 == 2) {
                    i8 = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers2);
                } else if (i10 == 0) {
                    i8 = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t2;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, protobufList, getEnumFieldVerifier(i11), unknownFieldSetLite, this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return i8;
            case 33:
            case 47:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 49:
                if (i10 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i11), i3, bArr, i, i2, protobufList, registers);
                }
                break;
        }
        return i9;
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        long j2 = j;
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j2);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t, j2, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        int i9;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        long j2 = j;
        int i14 = i8;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = UNSAFE;
        long j3 = (long) (this.buffer[i14 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 53:
            case 54:
                if (i13 == 0) {
                    i9 = ArrayDecoders.decodeVarint64(bArr2, i10, registers2);
                    unsafe.putObject(t2, j2, Long.valueOf(registers2.long1));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 55:
            case 62:
                if (i13 == 0) {
                    i9 = ArrayDecoders.decodeVarint32(bArr2, i10, registers2);
                    unsafe.putObject(t2, j2, Integer.valueOf(registers2.int1));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 58:
                if (i13 == 0) {
                    i9 = ArrayDecoders.decodeVarint64(bArr2, i10, registers2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(registers2.long1 != 0));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 59:
                if (i13 == 2) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i10, registers2);
                    int i15 = registers2.int1;
                    if (i15 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || Utf8.isValidUtf8(bArr2, decodeVarint32, decodeVarint32 + i15)) {
                        unsafe.putObject(t2, j2, new String(bArr2, decodeVarint32, i15, Internal.UTF_8));
                        decodeVarint32 += i15;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putInt(t2, j3, i12);
                    return decodeVarint32;
                }
                return i10;
            case 60:
                if (i13 == 2) {
                    int decodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i14), bArr2, i10, i2, registers2);
                    Object object = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, registers2.object1);
                    } else {
                        unsafe.putObject(t2, j2, Internal.mergeMessage(object, registers2.object1));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return decodeMessageField;
                }
                return i10;
            case 61:
                if (i13 == 2) {
                    i9 = ArrayDecoders.decodeBytes(bArr2, i10, registers2);
                    unsafe.putObject(t2, j2, registers2.object1);
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 63:
                if (i13 == 0) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr2, i10, registers2);
                    int i16 = registers2.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i14);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i16)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i16));
                        i9 = decodeVarint322;
                        unsafe.putInt(t2, j3, i12);
                        return i9;
                    }
                    getMutableUnknownFields(t).storeField(i11, Long.valueOf((long) i16));
                    return decodeVarint322;
                }
                return i10;
            case 66:
                if (i13 == 0) {
                    i9 = ArrayDecoders.decodeVarint32(bArr2, i10, registers2);
                    unsafe.putObject(t2, j2, Integer.valueOf(CodedInputStream.decodeZigZag32(registers2.int1)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 67:
                if (i13 == 0) {
                    i9 = ArrayDecoders.decodeVarint64(bArr2, i10, registers2);
                    unsafe.putObject(t2, j2, Long.valueOf(CodedInputStream.decodeZigZag64(registers2.long1)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 68:
                if (i13 == 3) {
                    i9 = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i14), bArr, i, i2, (i11 & -8) | 4, registers);
                    Object object2 = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, registers2.object1);
                    } else {
                        unsafe.putObject(t2, j2, Internal.mergeMessage(object2, registers2.object1));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            default:
                return i10;
        }
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaFor;
        return schemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /* JADX WARN: Type inference failed for: r34v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0349, code lost:
        if (r0 == r15) goto L_0x03b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0394, code lost:
        if (r0 == r15) goto L_0x03b9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03c0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03f1  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final int parseProto2Message(T t, byte[] bArr, int i, int i2, int r34, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        byte b;
        MessageSchema messageSchema;
        int i3;
        int i4;
        int i5;
        int i6;
        T t2;
        byte b2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        byte b3;
        byte b4;
        ArrayDecoders.Registers registers2;
        int i13;
        byte[] bArr2;
        int i14;
        byte b5;
        int i15;
        int i16;
        int i17;
        byte b6;
        int decodeUnknownField;
        byte[] bArr3;
        byte b7;
        int i18;
        int decodeMessageList;
        byte b8;
        int i19;
        int i20;
        int i21;
        byte b9;
        int i22;
        int i23;
        int i24;
        byte[] bArr4;
        int i25;
        MessageSchema messageSchema2 = this;
        T t3 = t;
        byte[] bArr5 = bArr;
        int i26 = i2;
        byte b10 = r34;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe2 = UNSAFE;
        int i27 = i;
        int i28 = -1;
        int i29 = 0;
        byte b11 = 0;
        int i30 = 0;
        int i31 = -1;
        while (true) {
            if (i27 < i26) {
                int i32 = i27 + 1;
                byte b12 = bArr5[i27];
                if (b12 < 0) {
                    i7 = ArrayDecoders.decodeVarint32(b12, bArr5, i32, registers3);
                    b2 = registers3.int1;
                } else {
                    b2 = b12;
                    i7 = i32;
                }
                int i33 = b2 >>> 3;
                byte b13 = b2 & 7;
                if (i33 > i28) {
                    i8 = messageSchema2.positionForFieldNumber(i33, i29 / 3);
                } else {
                    i8 = messageSchema2.positionForFieldNumber(i33);
                }
                int i34 = i8;
                if (i34 == -1) {
                    i12 = i33;
                    i3 = i7;
                    b3 = b2;
                    i9 = i30;
                    i11 = i31;
                    unsafe = unsafe2;
                    b4 = b10;
                    i10 = 0;
                    if (b3 == b4 || b4 == 0) {
                        byte b14 = b4;
                        if (!this.hasExtensions) {
                            registers2 = registers;
                            if (registers2.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                                decodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(b3, bArr, i3, i2, t, this.defaultInstance, this.unknownFieldSchema, registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b14;
                            }
                        } else {
                            registers2 = registers;
                        }
                        decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                        t3 = t;
                        bArr2 = bArr;
                        i14 = i2;
                        b5 = b3;
                        messageSchema2 = this;
                        registers3 = registers2;
                        i15 = i12;
                        i31 = i11;
                        i16 = i10;
                        i17 = i9;
                        b6 = b14;
                    } else {
                        i6 = -1;
                        messageSchema = this;
                        b = b4;
                        b11 = b3;
                        i4 = i11;
                        i5 = i9;
                    }
                } else {
                    int i35 = messageSchema2.buffer[i34 + 1];
                    int type = type(i35);
                    long offset = offset(i35);
                    byte b15 = b2;
                    int i36 = i35;
                    if (type <= 17) {
                        int i37 = messageSchema2.buffer[i34 + 2];
                        int i38 = 1 << (i37 >>> 20);
                        int i39 = i37 & 1048575;
                        if (i39 != i31) {
                            if (i31 != -1) {
                                i21 = i34;
                                unsafe2.putInt(t3, (long) i31, i30);
                            } else {
                                i21 = i34;
                            }
                            i30 = unsafe2.getInt(t3, (long) i39);
                            i31 = i39;
                        } else {
                            i21 = i34;
                        }
                        switch (type) {
                            case 0:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j = offset;
                                bArr3 = bArr;
                                i22 = i7;
                                if (b13 == 1) {
                                    UnsafeUtil.putDouble(t3, j, ArrayDecoders.decodeDouble(bArr3, i22));
                                    decodeMessageList = i22 + 8;
                                    i30 |= i38;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b142 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b142;
                                break;
                            case 1:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j2 = offset;
                                bArr3 = bArr;
                                i22 = i7;
                                if (b13 == 5) {
                                    UnsafeUtil.putFloat(t3, j2, ArrayDecoders.decodeFloat(bArr3, i22));
                                    decodeMessageList = i22 + 4;
                                    i30 |= i38;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b1422 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b1422;
                                break;
                            case 2:
                            case 3:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j3 = offset;
                                bArr4 = bArr;
                                i22 = i7;
                                if (b13 == 0) {
                                    i24 = ArrayDecoders.decodeVarint64(bArr4, i22, registers3);
                                    unsafe2.putLong(t, j3, registers3.long1);
                                    i30 |= i38;
                                    i29 = i23;
                                    i27 = i24;
                                    b11 = b9;
                                    i28 = i12;
                                    i26 = i2;
                                    b10 = r34;
                                }
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b14222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b14222;
                                break;
                            case 4:
                            case 11:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j4 = offset;
                                bArr3 = bArr;
                                i22 = i7;
                                if (b13 == 0) {
                                    decodeMessageList = ArrayDecoders.decodeVarint32(bArr3, i22, registers3);
                                    unsafe2.putInt(t3, j4, registers3.int1);
                                    i30 |= i38;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b142222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b142222;
                                break;
                            case 5:
                            case 14:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j5 = offset;
                                bArr3 = bArr;
                                if (b13 == 1) {
                                    i22 = i7;
                                    unsafe2.putLong(t, j5, ArrayDecoders.decodeFixed64(bArr3, i7));
                                    decodeMessageList = i22 + 8;
                                    i30 |= i38;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b1422222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b1422222;
                                break;
                            case 6:
                            case 13:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j6 = offset;
                                bArr5 = bArr;
                                i25 = i2;
                                if (b13 == 5) {
                                    unsafe2.putInt(t3, j6, ArrayDecoders.decodeFixed32(bArr5, i7));
                                    i27 = i7 + 4;
                                    i30 |= i38;
                                    i29 = i23;
                                    b11 = b9;
                                    i28 = i12;
                                    i26 = i25;
                                    b10 = r34;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b14222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b14222222;
                                break;
                            case 7:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j7 = offset;
                                bArr5 = bArr;
                                i25 = i2;
                                if (b13 == 0) {
                                    i27 = ArrayDecoders.decodeVarint64(bArr5, i7, registers3);
                                    UnsafeUtil.putBoolean(t3, j7, registers3.long1 != 0);
                                    i30 |= i38;
                                    i29 = i23;
                                    b11 = b9;
                                    i28 = i12;
                                    i26 = i25;
                                    b10 = r34;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b142222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b142222222;
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j8 = offset;
                                bArr5 = bArr;
                                i25 = i2;
                                if (b13 == 2) {
                                    if ((i36 & 536870912) == 0) {
                                        i27 = ArrayDecoders.decodeString(bArr5, i7, registers3);
                                    } else {
                                        i27 = ArrayDecoders.decodeStringRequireUtf8(bArr5, i7, registers3);
                                    }
                                    unsafe2.putObject(t3, j8, registers3.object1);
                                    i30 |= i38;
                                    i29 = i23;
                                    b11 = b9;
                                    i28 = i12;
                                    i26 = i25;
                                    b10 = r34;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b1422222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b1422222222;
                                break;
                            case 9:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j9 = offset;
                                bArr5 = bArr;
                                if (b13 != 2) {
                                    i22 = i7;
                                    b4 = r34;
                                    i9 = i30;
                                    i11 = i31;
                                    i10 = i23;
                                    unsafe = unsafe2;
                                    i3 = i22;
                                    b3 = b9;
                                    if (b3 == b4) {
                                    }
                                    byte b14222222222 = b4;
                                    if (!this.hasExtensions) {
                                    }
                                    decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                    t3 = t;
                                    bArr2 = bArr;
                                    i14 = i2;
                                    b5 = b3;
                                    messageSchema2 = this;
                                    registers3 = registers2;
                                    i15 = i12;
                                    i31 = i11;
                                    i16 = i10;
                                    i17 = i9;
                                    b6 = b14222222222;
                                    break;
                                } else {
                                    i25 = i2;
                                    i27 = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i23), bArr5, i7, i25, registers3);
                                    if ((i30 & i38) == 0) {
                                        unsafe2.putObject(t3, j9, registers3.object1);
                                    } else {
                                        unsafe2.putObject(t3, j9, Internal.mergeMessage(unsafe2.getObject(t3, j9), registers3.object1));
                                    }
                                    i30 |= i38;
                                    i29 = i23;
                                    b11 = b9;
                                    i28 = i12;
                                    i26 = i25;
                                    b10 = r34;
                                }
                                break;
                            case 10:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j10 = offset;
                                bArr3 = bArr;
                                if (b13 == 2) {
                                    decodeMessageList = ArrayDecoders.decodeBytes(bArr3, i7, registers3);
                                    unsafe2.putObject(t3, j10, registers3.object1);
                                    i30 |= i38;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b142222222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b142222222222;
                                break;
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j11 = offset;
                                bArr3 = bArr;
                                if (b13 == 0) {
                                    decodeMessageList = ArrayDecoders.decodeVarint32(bArr3, i7, registers3);
                                    int i40 = registers3.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i23);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i40)) {
                                        unsafe2.putInt(t3, j11, i40);
                                        i30 |= i38;
                                        b10 = r34;
                                        i20 = i23;
                                        b8 = b9;
                                        i19 = i12;
                                        break;
                                    } else {
                                        getMutableUnknownFields(t).storeField(b9, Long.valueOf((long) i40));
                                        b10 = r34;
                                        i20 = i23;
                                        b8 = b9;
                                        i19 = i12;
                                    }
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b1422222222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b1422222222222;
                                break;
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                long j12 = offset;
                                bArr3 = bArr;
                                if (b13 == 0) {
                                    decodeMessageList = ArrayDecoders.decodeVarint32(bArr3, i7, registers3);
                                    unsafe2.putInt(t3, j12, CodedInputStream.decodeZigZag32(registers3.int1));
                                    i30 |= i38;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b14222222222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b14222222222222;
                                break;
                            case 16:
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                if (b13 == 0) {
                                    long j13 = offset;
                                    bArr4 = bArr;
                                    i24 = ArrayDecoders.decodeVarint64(bArr4, i7, registers3);
                                    unsafe2.putLong(t, j13, CodedInputStream.decodeZigZag64(registers3.long1));
                                    i30 |= i38;
                                    i29 = i23;
                                    i27 = i24;
                                    b11 = b9;
                                    i28 = i12;
                                    i26 = i2;
                                    b10 = r34;
                                }
                                i22 = i7;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b142222222222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b142222222222222;
                                break;
                            case 17:
                                if (b13 != 3) {
                                    i23 = i21;
                                    b9 = b15;
                                    i12 = i33;
                                    i22 = i7;
                                    b4 = r34;
                                    i9 = i30;
                                    i11 = i31;
                                    i10 = i23;
                                    unsafe = unsafe2;
                                    i3 = i22;
                                    b3 = b9;
                                    if (b3 == b4) {
                                    }
                                    byte b1422222222222222 = b4;
                                    if (!this.hasExtensions) {
                                    }
                                    decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                    t3 = t;
                                    bArr2 = bArr;
                                    i14 = i2;
                                    b5 = b3;
                                    messageSchema2 = this;
                                    registers3 = registers2;
                                    i15 = i12;
                                    i31 = i11;
                                    i16 = i10;
                                    i17 = i9;
                                    b6 = b1422222222222222;
                                    break;
                                } else {
                                    int i41 = i21;
                                    i23 = i41;
                                    i12 = i33;
                                    b9 = b15;
                                    decodeMessageList = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(i41), bArr, i7, i2, (i33 << 3) | 4, registers);
                                    if ((i30 & i38) == 0) {
                                        unsafe2.putObject(t3, offset, registers3.object1);
                                    } else {
                                        unsafe2.putObject(t3, offset, Internal.mergeMessage(unsafe2.getObject(t3, offset), registers3.object1));
                                    }
                                    i30 |= i38;
                                    bArr3 = bArr;
                                    b10 = r34;
                                    i20 = i23;
                                    b8 = b9;
                                    i19 = i12;
                                    break;
                                }
                                break;
                            default:
                                i22 = i7;
                                i23 = i21;
                                b9 = b15;
                                i12 = i33;
                                b4 = r34;
                                i9 = i30;
                                i11 = i31;
                                i10 = i23;
                                unsafe = unsafe2;
                                i3 = i22;
                                b3 = b9;
                                if (b3 == b4) {
                                }
                                byte b14222222222222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b14222222222222222;
                                break;
                        }
                    } else {
                        int i42 = i34;
                        i12 = i33;
                        long j14 = offset;
                        byte b16 = b15;
                        bArr3 = bArr;
                        int i43 = i7;
                        if (type != 27) {
                            i10 = i42;
                            i9 = i30;
                            if (type <= 49) {
                                long j15 = (long) i36;
                                i11 = i31;
                                unsafe = unsafe2;
                                int i44 = i43;
                                b7 = b16;
                                i13 = parseRepeatedField(t, bArr, i43, i2, b16, i12, b13, i10, j15, type, j14, registers);
                            } else {
                                byte b17 = b13;
                                long j16 = j14;
                                unsafe = unsafe2;
                                i18 = i43;
                                b7 = b16;
                                int i45 = i36;
                                i11 = i31;
                                int i46 = type;
                                if (i46 != 50) {
                                    i13 = parseOneofField(t, bArr, i18, i2, b7, i12, b17, i45, i46, j16, i10, registers);
                                    if (i13 != i18) {
                                        messageSchema2 = this;
                                        t3 = t;
                                        bArr2 = bArr;
                                        i14 = i2;
                                        b6 = r34;
                                        registers3 = registers;
                                        b5 = b7;
                                        i15 = i12;
                                        i31 = i11;
                                        i16 = i10;
                                        i17 = i9;
                                    }
                                } else if (b17 == 2) {
                                    i13 = parseMapField(t, bArr, i18, i2, i10, j16, registers);
                                }
                                i3 = i13;
                                b3 = b7;
                                b4 = r34;
                                if (b3 == b4) {
                                }
                                byte b142222222222222222 = b4;
                                if (!this.hasExtensions) {
                                }
                                decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i14 = i2;
                                b5 = b3;
                                messageSchema2 = this;
                                registers3 = registers2;
                                i15 = i12;
                                i31 = i11;
                                i16 = i10;
                                i17 = i9;
                                b6 = b142222222222222222;
                            }
                            messageSchema2 = this;
                            t3 = t;
                            bArr2 = bArr;
                            i14 = i2;
                            b6 = r34;
                            registers3 = registers;
                            i15 = i12;
                            b5 = b7;
                            i31 = i11;
                            i16 = i10;
                            i17 = i9;
                        } else if (b13 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t3, j14);
                            if (!protobufList.isModifiable()) {
                                int size = protobufList.size();
                                protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t3, j14, protobufList);
                            }
                            decodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i42), b16, bArr, i43, i2, protobufList, registers);
                            b10 = r34;
                            b8 = b16;
                            i19 = i12;
                            i20 = i42;
                            i30 = i30;
                        } else {
                            i10 = i42;
                            i9 = i30;
                            i11 = i31;
                            unsafe = unsafe2;
                            i18 = i43;
                            b7 = b16;
                        }
                        b4 = r34;
                        i3 = i18;
                        b3 = b7;
                        if (b3 == b4) {
                        }
                        byte b1422222222222222222 = b4;
                        if (!this.hasExtensions) {
                        }
                        decodeUnknownField = ArrayDecoders.decodeUnknownField(b3, bArr, i3, i2, getMutableUnknownFields(t), registers);
                        t3 = t;
                        bArr2 = bArr;
                        i14 = i2;
                        b5 = b3;
                        messageSchema2 = this;
                        registers3 = registers2;
                        i15 = i12;
                        i31 = i11;
                        i16 = i10;
                        i17 = i9;
                        b6 = b1422222222222222222;
                    }
                    i26 = i2;
                }
                unsafe2 = unsafe;
            } else {
                unsafe = unsafe2;
                b = b10;
                messageSchema = messageSchema2;
                i3 = i27;
                i4 = i31;
                i5 = i30;
                i6 = -1;
            }
        }
        if (i4 != i6) {
            long j17 = (long) i4;
            t2 = t;
            unsafe.putInt(t2, j17, i5);
        } else {
            t2 = t;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i47 = messageSchema.checkInitializedCount; i47 < messageSchema.repeatedFieldOffsetStart; i47++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i47], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (b == 0) {
            if (i3 != i2) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i3 > i2 || b11 != b) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i3;
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01dc, code lost:
        if (r0 == r15) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0209, code lost:
        if (r0 == r15) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0228, code lost:
        if (r0 == r15) goto L_0x022a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int decodeUnknownField;
        int i8;
        int i9;
        int i10;
        int i11;
        MessageSchema messageSchema = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = UNSAFE;
        int i13 = -1;
        int i14 = i;
        int i15 = -1;
        int i16 = 0;
        while (i14 < i12) {
            int i17 = i14 + 1;
            byte b2 = bArr2[i14];
            if (b2 < 0) {
                i3 = ArrayDecoders.decodeVarint32(b2, bArr2, i17, registers2);
                b = registers2.int1;
            } else {
                b = b2;
                i3 = i17;
            }
            int i18 = b >>> 3;
            byte b3 = b & 7;
            if (i18 > i15) {
                i4 = messageSchema.positionForFieldNumber(i18, i16 / 3);
            } else {
                i4 = messageSchema.positionForFieldNumber(i18);
            }
            int i19 = i4;
            if (i19 == i13) {
                i5 = i18;
                i7 = i3;
                unsafe = unsafe2;
                i6 = 0;
            } else {
                int i20 = messageSchema.buffer[i19 + 1];
                int type = type(i20);
                long offset = offset(i20);
                if (type <= 17) {
                    boolean z = true;
                    switch (type) {
                        case 0:
                            long j = offset;
                            i9 = i19;
                            if (b3 == 1) {
                                UnsafeUtil.putDouble(t2, j, ArrayDecoders.decodeDouble(bArr2, i3));
                                i10 = i3 + 8;
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i6 = i9;
                            i7 = i8;
                            break;
                        case 1:
                            long j2 = offset;
                            i9 = i19;
                            if (b3 == 5) {
                                UnsafeUtil.putFloat(t2, j2, ArrayDecoders.decodeFloat(bArr2, i3));
                                i10 = i3 + 4;
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i6 = i9;
                            i7 = i8;
                            break;
                        case 2:
                        case 3:
                            long j3 = offset;
                            i9 = i19;
                            if (b3 == 0) {
                                i11 = ArrayDecoders.decodeVarint64(bArr2, i3, registers2);
                                unsafe2.putLong(t, j3, registers2.long1);
                                i10 = i11;
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i6 = i9;
                            i7 = i8;
                            break;
                        case 4:
                        case 11:
                            long j4 = offset;
                            i9 = i19;
                            if (b3 == 0) {
                                i10 = ArrayDecoders.decodeVarint32(bArr2, i3, registers2);
                                unsafe2.putInt(t2, j4, registers2.int1);
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i6 = i9;
                            i7 = i8;
                            break;
                        case 5:
                        case 14:
                            long j5 = offset;
                            if (b3 == 1) {
                                i9 = i19;
                                unsafe2.putLong(t, j5, ArrayDecoders.decodeFixed64(bArr2, i3));
                                i10 = i3 + 8;
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        case 6:
                        case 13:
                            long j6 = offset;
                            if (b3 == 5) {
                                unsafe2.putInt(t2, j6, ArrayDecoders.decodeFixed32(bArr2, i3));
                                i14 = i3 + 4;
                                i16 = i19;
                                i15 = i18;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        case 7:
                            long j7 = offset;
                            if (b3 == 0) {
                                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i3, registers2);
                                if (registers2.long1 == 0) {
                                    z = false;
                                }
                                UnsafeUtil.putBoolean(t2, j7, z);
                                i14 = decodeVarint64;
                                i16 = i19;
                                i15 = i18;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            long j8 = offset;
                            if (b3 == 2) {
                                if ((536870912 & i20) == 0) {
                                    i14 = ArrayDecoders.decodeString(bArr2, i3, registers2);
                                } else {
                                    i14 = ArrayDecoders.decodeStringRequireUtf8(bArr2, i3, registers2);
                                }
                                unsafe2.putObject(t2, j8, registers2.object1);
                                i16 = i19;
                                i15 = i18;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        case 9:
                            long j9 = offset;
                            if (b3 == 2) {
                                i14 = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(i19), bArr2, i3, i12, registers2);
                                Object object = unsafe2.getObject(t2, j9);
                                if (object == null) {
                                    unsafe2.putObject(t2, j9, registers2.object1);
                                } else {
                                    unsafe2.putObject(t2, j9, Internal.mergeMessage(object, registers2.object1));
                                }
                                i16 = i19;
                                i15 = i18;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        case 10:
                            long j10 = offset;
                            if (b3 == 2) {
                                i14 = ArrayDecoders.decodeBytes(bArr2, i3, registers2);
                                unsafe2.putObject(t2, j10, registers2.object1);
                                i16 = i19;
                                i15 = i18;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            long j11 = offset;
                            i9 = i19;
                            if (b3 == 0) {
                                i10 = ArrayDecoders.decodeVarint32(bArr2, i3, registers2);
                                unsafe2.putInt(t2, j11, registers2.int1);
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i6 = i9;
                            i7 = i8;
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            long j12 = offset;
                            i9 = i19;
                            if (b3 == 0) {
                                i10 = ArrayDecoders.decodeVarint32(bArr2, i3, registers2);
                                unsafe2.putInt(t2, j12, CodedInputStream.decodeZigZag32(registers2.int1));
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i6 = i9;
                            i7 = i8;
                            break;
                        case 16:
                            if (b3 == 0) {
                                i11 = ArrayDecoders.decodeVarint64(bArr2, i3, registers2);
                                i9 = i19;
                                unsafe2.putLong(t, offset, CodedInputStream.decodeZigZag64(registers2.long1));
                                i10 = i11;
                                i15 = i18;
                                i16 = i9;
                                break;
                            }
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                        default:
                            i6 = i19;
                            i5 = i18;
                            i8 = i3;
                            unsafe = unsafe2;
                            i7 = i8;
                            break;
                    }
                } else if (type == 27) {
                    if (b3 == 2) {
                        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t2, offset);
                        if (!protobufList.isModifiable()) {
                            int size = protobufList.size();
                            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t2, offset, protobufList);
                        }
                        i14 = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i19), b, bArr, i3, i2, protobufList, registers);
                        i15 = i18;
                        i16 = i19;
                    }
                    i6 = i19;
                    i5 = i18;
                    i8 = i3;
                    unsafe = unsafe2;
                    i7 = i8;
                } else {
                    i6 = i19;
                    if (type <= 49) {
                        long j13 = (long) i20;
                        byte b4 = b3;
                        i5 = i18;
                        int i21 = i3;
                        unsafe = unsafe2;
                        decodeUnknownField = parseRepeatedField(t, bArr, i3, i2, b, i18, b4, i6, j13, type, offset, registers);
                    } else {
                        long j14 = offset;
                        byte b5 = b3;
                        i5 = i18;
                        i8 = i3;
                        unsafe = unsafe2;
                        int i22 = type;
                        if (i22 == 50) {
                            if (b5 == 2) {
                                decodeUnknownField = parseMapField(t, bArr, i8, i2, i6, j14, registers);
                            }
                            i7 = i8;
                        } else {
                            decodeUnknownField = parseOneofField(t, bArr, i8, i2, b, i5, b5, i20, i22, j14, i6, registers);
                        }
                    }
                    i7 = decodeUnknownField;
                }
                i13 = -1;
            }
            decodeUnknownField = ArrayDecoders.decodeUnknownField(b, bArr, i7, i2, getMutableUnknownFields(t), registers);
            i13 = -1;
            messageSchema = this;
            t2 = t;
            bArr2 = bArr;
            i12 = i2;
            registers2 = registers;
            unsafe2 = unsafe;
            i16 = i6;
            i15 = i5;
        }
        if (i14 == i12) {
            return i14;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    public final void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    public final void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i2 >= i) {
                break;
            }
            long offset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, offset);
            if (object != null) {
                UnsafeUtil.putObject(t, offset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, (long) this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) {
            return ub;
        }
        return filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema2);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema2.newBuilder();
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub, i2, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean isInitialized(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.checkInitializedCount; i4++) {
            int i5 = this.intArray[i4];
            int numberAt = numberAt(i5);
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            if (!this.proto3) {
                int i6 = this.buffer[i5 + 2];
                int i7 = 1048575 & i6;
                i = 1 << (i6 >>> 20);
                if (i7 != i2) {
                    i3 = UNSAFE.getInt(t, (long) i7);
                    i2 = i7;
                }
            } else {
                i = 0;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t, i5, i3, i)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t, numberAt, i5) && !isInitialized(t, typeAndOffsetAt, getMessageFieldSchema(i5))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t, typeAndOffsetAt, i5)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t, typeAndOffsetAt, i5)) {
                    return false;
                }
            } else if (isFieldPresent(t, i5, i3, i) && !isInitialized(t, typeAndOffsetAt, getMessageFieldSchema(i5))) {
                return false;
            }
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor((Class) next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3) {
        if (this.proto3) {
            return isFieldPresent(t, i);
        }
        return (i2 & i3) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        if (this.proto3) {
            int typeAndOffsetAt = typeAndOffsetAt(i);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t, offset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t, offset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t, offset);
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    Object object = UnsafeUtil.getObject(t, offset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject(t, offset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, offset));
                case 11:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t, offset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
            return (UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt & 1048575)) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
    }

    private void setFieldPresent(T t, int i) {
        if (!this.proto3) {
            int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
            long j = (long) (presenceMaskAndOffsetAt & 1048575);
            UnsafeUtil.putInt(t, j, UnsafeUtil.getInt(t, j) | (1 << (presenceMaskAndOffsetAt >>> 20)));
        }
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i) & 1048575);
        return UnsafeUtil.getInt(t, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, presenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575), i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int numberAt = numberAt(i4);
            if (i == numberAt) {
                return i4;
            }
            if (i < numberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
