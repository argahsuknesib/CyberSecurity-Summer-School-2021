package com.google.protobuf;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.StructuralMessageInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class DescriptorMessageInfoFactory implements MessageInfoFactory {
    private static final DescriptorMessageInfoFactory instance = new DescriptorMessageInfoFactory();
    private static IsInitializedCheckAnalyzer isInitializedCheckAnalyzer = new IsInitializedCheckAnalyzer();
    private static final Set<String> specialFieldNames = new HashSet(Arrays.asList("cached_size", "serialized_size", "class"));

    private DescriptorMessageInfoFactory() {
    }

    public static DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    public final boolean isSupported(Class<?> cls) {
        return GeneratedMessageV3.class.isAssignableFrom(cls);
    }

    public final MessageInfo messageInfoFor(Class<?> cls) {
        if (GeneratedMessageV3.class.isAssignableFrom(cls)) {
            return convert(cls, descriptorForType(cls));
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    private static Message getDefaultInstance(Class<?> cls) {
        try {
            return (Message) cls.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to get default instance for message class " + cls.getName(), e);
        }
    }

    private static Descriptors.Descriptor descriptorForType(Class<?> cls) {
        return getDefaultInstance(cls).getDescriptorForType();
    }

    private static MessageInfo convert(Class<?> cls, Descriptors.Descriptor descriptor) {
        int i = AnonymousClass3.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[descriptor.getFile().getSyntax().ordinal()];
        if (i == 1) {
            return convertProto2(cls, descriptor);
        }
        if (i == 2) {
            return convertProto3(cls, descriptor);
        }
        throw new IllegalArgumentException("Unsupported syntax: " + descriptor.getFile().getSyntax());
    }

    static class IsInitializedCheckAnalyzer {
        private int index = 0;
        private final Map<Descriptors.Descriptor, Node> nodeCache = new HashMap();
        private final Map<Descriptors.Descriptor, Boolean> resultCache = new ConcurrentHashMap();
        private final Stack<Node> stack = new Stack<>();

        IsInitializedCheckAnalyzer() {
        }

        public boolean needsIsInitializedCheck(Descriptors.Descriptor descriptor) {
            Boolean bool = this.resultCache.get(descriptor);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                Boolean bool2 = this.resultCache.get(descriptor);
                if (bool2 != null) {
                    boolean booleanValue = bool2.booleanValue();
                    return booleanValue;
                }
                boolean z = dfs(descriptor).component.needsIsInitializedCheck;
                return z;
            }
        }

        static class Node {
            StronglyConnectedComponent component = null;
            final Descriptors.Descriptor descriptor;
            final int index;
            int lowLink;

            Node(Descriptors.Descriptor descriptor2, int i) {
                this.descriptor = descriptor2;
                this.index = i;
                this.lowLink = i;
            }
        }

        static class StronglyConnectedComponent {
            final List<Descriptors.Descriptor> messages;
            boolean needsIsInitializedCheck;

            private StronglyConnectedComponent() {
                this.messages = new ArrayList();
                this.needsIsInitializedCheck = false;
            }
        }

        private Node dfs(Descriptors.Descriptor descriptor) {
            Node pop;
            int i = this.index;
            this.index = i + 1;
            Node node = new Node(descriptor, i);
            this.stack.push(node);
            this.nodeCache.put(descriptor, node);
            for (Descriptors.FieldDescriptor next : descriptor.getFields()) {
                if (next.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    Node node2 = this.nodeCache.get(next.getMessageType());
                    if (node2 == null) {
                        node.lowLink = Math.min(node.lowLink, dfs(next.getMessageType()).lowLink);
                    } else if (node2.component == null) {
                        node.lowLink = Math.min(node.lowLink, node2.lowLink);
                    }
                }
            }
            if (node.index == node.lowLink) {
                StronglyConnectedComponent stronglyConnectedComponent = new StronglyConnectedComponent();
                do {
                    pop = this.stack.pop();
                    pop.component = stronglyConnectedComponent;
                    stronglyConnectedComponent.messages.add(pop.descriptor);
                } while (pop != node);
                analyze(stronglyConnectedComponent);
            }
            return node;
        }

        private void analyze(StronglyConnectedComponent stronglyConnectedComponent) {
            boolean z;
            Iterator<Descriptors.Descriptor> it = stronglyConnectedComponent.messages.iterator();
            loop0:
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Descriptors.Descriptor next = it.next();
                if (next.isExtendable()) {
                    break;
                }
                Iterator<Descriptors.FieldDescriptor> it2 = next.getFields().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Descriptors.FieldDescriptor next2 = it2.next();
                        if (next2.isRequired()) {
                            break loop0;
                        } else if (next2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            Node node = this.nodeCache.get(next2.getMessageType());
                            if (node.component != stronglyConnectedComponent && node.component.needsIsInitializedCheck) {
                                break loop0;
                            }
                        }
                    }
                }
            }
            stronglyConnectedComponent.needsIsInitializedCheck = z;
            for (Descriptors.Descriptor put : stronglyConnectedComponent.messages) {
                this.resultCache.put(put, Boolean.valueOf(stronglyConnectedComponent.needsIsInitializedCheck));
            }
        }
    }

    private static boolean needsIsInitializedCheck(Descriptors.Descriptor descriptor) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(descriptor);
    }

    private static StructuralMessageInfo convertProto2(Class<?> cls, Descriptors.Descriptor descriptor) {
        Class<?> cls2 = cls;
        List<Descriptors.FieldDescriptor> fields = descriptor.getFields();
        StructuralMessageInfo.Builder newBuilder = StructuralMessageInfo.newBuilder(fields.size());
        newBuilder.withDefaultInstance(getDefaultInstance(cls));
        newBuilder.withSyntax(ProtoSyntax.PROTO2);
        newBuilder.withMessageSetWireFormat(descriptor.getOptions().getMessageSetWireFormat());
        AnonymousClass2 r4 = null;
        OneofState oneofState = new OneofState();
        Field field = null;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < fields.size()) {
            final Descriptors.FieldDescriptor fieldDescriptor = fields.get(i);
            boolean javaStringCheckUtf8 = fieldDescriptor.getFile().getOptions().getJavaStringCheckUtf8();
            Internal.EnumVerifier r14 = fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM ? new Internal.EnumVerifier() {
                /* class com.google.protobuf.DescriptorMessageInfoFactory.AnonymousClass1 */

                public final boolean isInRange(int i) {
                    return fieldDescriptor.getEnumType().findValueByNumber(i) != null;
                }
            } : r4;
            if (fieldDescriptor.getContainingOneof() != null) {
                newBuilder.withField(buildOneofMember(cls2, fieldDescriptor, oneofState, javaStringCheckUtf8, r14));
            } else {
                Field field2 = field(cls2, fieldDescriptor);
                int number = fieldDescriptor.getNumber();
                FieldType fieldType = getFieldType(fieldDescriptor);
                if (fieldDescriptor.isMapField()) {
                    final Descriptors.FieldDescriptor findFieldByNumber = fieldDescriptor.getMessageType().findFieldByNumber(2);
                    if (findFieldByNumber.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        r14 = new Internal.EnumVerifier() {
                            /* class com.google.protobuf.DescriptorMessageInfoFactory.AnonymousClass2 */

                            public final boolean isInRange(int i) {
                                return findFieldByNumber.getEnumType().findValueByNumber(i) != null;
                            }
                        };
                    }
                    newBuilder.withField(FieldInfo.forMapField(field2, number, SchemaUtil.getMapDefaultEntry(cls2, fieldDescriptor.getName()), r14));
                } else if (!fieldDescriptor.isRepeated()) {
                    if (field == null) {
                        field = bitField(cls2, i2);
                    }
                    if (fieldDescriptor.isRequired()) {
                        newBuilder.withField(FieldInfo.forProto2RequiredField(field2, number, fieldType, field, i3, javaStringCheckUtf8, r14));
                    } else {
                        newBuilder.withField(FieldInfo.forProto2OptionalField(field2, number, fieldType, field, i3, javaStringCheckUtf8, r14));
                    }
                } else if (r14 != null) {
                    if (fieldDescriptor.isPacked()) {
                        newBuilder.withField(FieldInfo.forPackedFieldWithEnumVerifier(field2, number, fieldType, r14, cachedSizeField(cls2, fieldDescriptor)));
                    } else {
                        newBuilder.withField(FieldInfo.forFieldWithEnumVerifier(field2, number, fieldType, r14));
                    }
                } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    newBuilder.withField(FieldInfo.forRepeatedMessageField(field2, number, fieldType, getTypeForRepeatedMessageField(cls2, fieldDescriptor)));
                } else if (fieldDescriptor.isPacked()) {
                    newBuilder.withField(FieldInfo.forPackedField(field2, number, fieldType, cachedSizeField(cls2, fieldDescriptor)));
                } else {
                    newBuilder.withField(FieldInfo.forField(field2, number, fieldType, javaStringCheckUtf8));
                }
                i++;
                r4 = null;
            }
            int i4 = i3 << 1;
            if (i4 == 0) {
                i2++;
                field = null;
                i3 = 1;
            } else {
                i3 = i4;
            }
            i++;
            r4 = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < fields.size(); i5++) {
            Descriptors.FieldDescriptor fieldDescriptor2 = fields.get(i5);
            if (fieldDescriptor2.isRequired() || (fieldDescriptor2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && needsIsInitializedCheck(fieldDescriptor2.getMessageType()))) {
                arrayList.add(Integer.valueOf(fieldDescriptor2.getNumber()));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        newBuilder.withCheckInitialized(iArr);
        return newBuilder.build();
    }

    private static StructuralMessageInfo convertProto3(Class<?> cls, Descriptors.Descriptor descriptor) {
        List<Descriptors.FieldDescriptor> fields = descriptor.getFields();
        StructuralMessageInfo.Builder newBuilder = StructuralMessageInfo.newBuilder(fields.size());
        newBuilder.withDefaultInstance(getDefaultInstance(cls));
        newBuilder.withSyntax(ProtoSyntax.PROTO3);
        OneofState oneofState = new OneofState();
        for (int i = 0; i < fields.size(); i++) {
            Descriptors.FieldDescriptor fieldDescriptor = fields.get(i);
            if (fieldDescriptor.getContainingOneof() != null) {
                newBuilder.withField(buildOneofMember(cls, fieldDescriptor, oneofState, true, null));
            } else if (fieldDescriptor.isMapField()) {
                newBuilder.withField(FieldInfo.forMapField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), SchemaUtil.getMapDefaultEntry(cls, fieldDescriptor.getName()), null));
            } else if (fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                newBuilder.withField(FieldInfo.forRepeatedMessageField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), getTypeForRepeatedMessageField(cls, fieldDescriptor)));
            } else if (fieldDescriptor.isPacked()) {
                newBuilder.withField(FieldInfo.forPackedField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), cachedSizeField(cls, fieldDescriptor)));
            } else {
                newBuilder.withField(FieldInfo.forField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), true));
            }
        }
        return newBuilder.build();
    }

    private static FieldInfo buildOneofMember(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor, OneofState oneofState, boolean z, Internal.EnumVerifier enumVerifier) {
        OneofInfo oneof = oneofState.getOneof(cls, fieldDescriptor.getContainingOneof());
        FieldType fieldType = getFieldType(fieldDescriptor);
        return FieldInfo.forOneofMemberField(fieldDescriptor.getNumber(), fieldType, oneof, getOneofStoredType(cls, fieldDescriptor, fieldType), z, enumVerifier);
    }

    private static Class<?> getOneofStoredType(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor, FieldType fieldType) {
        switch (AnonymousClass3.$SwitchMap$com$google$protobuf$JavaType[fieldType.getJavaType().ordinal()]) {
            case 1:
                return Boolean.class;
            case 2:
                return ByteString.class;
            case 3:
                return Double.class;
            case 4:
                return Float.class;
            case 5:
            case 6:
                return Integer.class;
            case 7:
                return Long.class;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return String.class;
            case 9:
                return getOneofStoredTypeForMessage(cls, fieldDescriptor);
            default:
                throw new IllegalArgumentException("Invalid type for oneof: ".concat(String.valueOf(fieldType)));
        }
    }

    /* renamed from: com.google.protobuf.DescriptorMessageInfoFactory$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[Descriptors.FieldDescriptor.Type.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax = new int[Descriptors.FileDescriptor.Syntax.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = new int[JavaType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|(3:77|78|80)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|(3:77|78|80)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|(3:77|78|80)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|(3:77|78|80)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|(3:77|78|80)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|(3:77|78|80)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(69:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|80) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x010b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0115 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0129 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0133 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0150 */
        static {
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 17;
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 18;
            } catch (NoSuchFieldError unused9) {
            }
            $SwitchMap$com$google$protobuf$JavaType[JavaType.BOOLEAN.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.BYTE_STRING.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.DOUBLE.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.FLOAT.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.ENUM.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.INT.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.LONG.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 8;
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused10) {
            }
            $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[Descriptors.FileDescriptor.Syntax.PROTO2.ordinal()] = 1;
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[Descriptors.FileDescriptor.Syntax.PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static FieldType getFieldType(Descriptors.FieldDescriptor fieldDescriptor) {
        switch (AnonymousClass3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
            case 1:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.BOOL;
                }
                return fieldDescriptor.isPacked() ? FieldType.BOOL_LIST_PACKED : FieldType.BOOL_LIST;
            case 2:
                return fieldDescriptor.isRepeated() ? FieldType.BYTES_LIST : FieldType.BYTES;
            case 3:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.DOUBLE;
                }
                return fieldDescriptor.isPacked() ? FieldType.DOUBLE_LIST_PACKED : FieldType.DOUBLE_LIST;
            case 4:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.ENUM;
                }
                return fieldDescriptor.isPacked() ? FieldType.ENUM_LIST_PACKED : FieldType.ENUM_LIST;
            case 5:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.FIXED32;
                }
                return fieldDescriptor.isPacked() ? FieldType.FIXED32_LIST_PACKED : FieldType.FIXED32_LIST;
            case 6:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.FIXED64;
                }
                return fieldDescriptor.isPacked() ? FieldType.FIXED64_LIST_PACKED : FieldType.FIXED64_LIST;
            case 7:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.FLOAT;
                }
                return fieldDescriptor.isPacked() ? FieldType.FLOAT_LIST_PACKED : FieldType.FLOAT_LIST;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return fieldDescriptor.isRepeated() ? FieldType.GROUP_LIST : FieldType.GROUP;
            case 9:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.INT32;
                }
                return fieldDescriptor.isPacked() ? FieldType.INT32_LIST_PACKED : FieldType.INT32_LIST;
            case 10:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.INT64;
                }
                return fieldDescriptor.isPacked() ? FieldType.INT64_LIST_PACKED : FieldType.INT64_LIST;
            case 11:
                if (fieldDescriptor.isMapField()) {
                    return FieldType.MAP;
                }
                return fieldDescriptor.isRepeated() ? FieldType.MESSAGE_LIST : FieldType.MESSAGE;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SFIXED32;
                }
                return fieldDescriptor.isPacked() ? FieldType.SFIXED32_LIST_PACKED : FieldType.SFIXED32_LIST;
            case 13:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SFIXED64;
                }
                return fieldDescriptor.isPacked() ? FieldType.SFIXED64_LIST_PACKED : FieldType.SFIXED64_LIST;
            case 14:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SINT32;
                }
                return fieldDescriptor.isPacked() ? FieldType.SINT32_LIST_PACKED : FieldType.SINT32_LIST;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SINT64;
                }
                return fieldDescriptor.isPacked() ? FieldType.SINT64_LIST_PACKED : FieldType.SINT64_LIST;
            case 16:
                return fieldDescriptor.isRepeated() ? FieldType.STRING_LIST : FieldType.STRING;
            case 17:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.UINT32;
                }
                return fieldDescriptor.isPacked() ? FieldType.UINT32_LIST_PACKED : FieldType.UINT32_LIST;
            case 18:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.UINT64;
                }
                return fieldDescriptor.isPacked() ? FieldType.UINT64_LIST_PACKED : FieldType.UINT64_LIST;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fieldDescriptor.getType());
        }
    }

    private static Field bitField(Class<?> cls, int i) {
        return field(cls, "bitField" + i + "_");
    }

    private static Field field(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        return field(cls, getFieldName(fieldDescriptor));
    }

    private static Field cachedSizeField(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        return field(cls, getCachedSizeFieldName(fieldDescriptor));
    }

    public static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    static String getFieldName(Descriptors.FieldDescriptor fieldDescriptor) {
        String str;
        if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
            str = fieldDescriptor.getMessageType().getName();
        } else {
            str = fieldDescriptor.getName();
        }
        String str2 = specialFieldNames.contains(str) ? "__" : "_";
        return snakeCaseToCamelCase(str) + str2;
    }

    private static String getCachedSizeFieldName(Descriptors.FieldDescriptor fieldDescriptor) {
        return snakeCaseToCamelCase(fieldDescriptor.getName()) + "MemoizedSerializedSize";
    }

    public static String snakeCaseToCamelCase(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 1);
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_') {
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else {
                    if (z) {
                        sb.append(Character.toUpperCase(charAt));
                        z = false;
                    } else if (i == 0) {
                        sb.append(Character.toLowerCase(charAt));
                    } else {
                        sb.append(charAt);
                    }
                }
            }
            z = true;
        }
        return sb.toString();
    }

    private static Class<?> getOneofStoredTypeForMessage(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        try {
            return cls.getDeclaredMethod(getterForField(fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.getMessageType().getName() : fieldDescriptor.getName()), new Class[0]).getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> getTypeForRepeatedMessageField(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        try {
            return cls.getDeclaredMethod(getterForField(fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.getMessageType().getName() : fieldDescriptor.getName()), Integer.TYPE).getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getterForField(String str) {
        String snakeCaseToCamelCase = snakeCaseToCamelCase(str);
        return "get" + Character.toUpperCase(snakeCaseToCamelCase.charAt(0)) + snakeCaseToCamelCase.substring(1, snakeCaseToCamelCase.length());
    }

    static final class OneofState {
        private OneofInfo[] oneofs;

        private OneofState() {
            this.oneofs = new OneofInfo[2];
        }

        /* access modifiers changed from: package-private */
        public final OneofInfo getOneof(Class<?> cls, Descriptors.OneofDescriptor oneofDescriptor) {
            int index = oneofDescriptor.getIndex();
            OneofInfo[] oneofInfoArr = this.oneofs;
            if (index >= oneofInfoArr.length) {
                this.oneofs = (OneofInfo[]) Arrays.copyOf(oneofInfoArr, index * 2);
            }
            OneofInfo oneofInfo = this.oneofs[index];
            if (oneofInfo != null) {
                return oneofInfo;
            }
            OneofInfo newInfo = newInfo(cls, oneofDescriptor);
            this.oneofs[index] = newInfo;
            return newInfo;
        }

        private static OneofInfo newInfo(Class<?> cls, Descriptors.OneofDescriptor oneofDescriptor) {
            String snakeCaseToCamelCase = DescriptorMessageInfoFactory.snakeCaseToCamelCase(oneofDescriptor.getName());
            return new OneofInfo(oneofDescriptor.getIndex(), DescriptorMessageInfoFactory.field(cls, snakeCaseToCamelCase + "Case_"), DescriptorMessageInfoFactory.field(cls, snakeCaseToCamelCase + "_"));
        }
    }
}
