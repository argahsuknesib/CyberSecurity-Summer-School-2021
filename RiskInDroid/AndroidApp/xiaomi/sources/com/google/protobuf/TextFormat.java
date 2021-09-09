package com.google.protobuf;

import _m_j.jdn;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.TextFormatParseInfoTree;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class TextFormat {
    private static final Parser PARSER = Parser.newBuilder().build();
    public static final Logger logger = Logger.getLogger(TextFormat.class.getName());

    private static int digitValue(byte b) {
        if (48 <= b && b <= 57) {
            return b - 48;
        }
        return ((97 > b || b > 122) ? b - 65 : b - 97) + 10;
    }

    private static boolean isHex(byte b) {
        if (48 <= b && b <= 57) {
            return true;
        }
        if (97 > b || b > 102) {
            return 65 <= b && b <= 70;
        }
        return true;
    }

    private static boolean isOctal(byte b) {
        return 48 <= b && b <= 55;
    }

    private TextFormat() {
    }

    @Deprecated
    public static void print(MessageOrBuilder messageOrBuilder, Appendable appendable) throws IOException {
        printer().print(messageOrBuilder, appendable);
    }

    @Deprecated
    public static void print(UnknownFieldSet unknownFieldSet, Appendable appendable) throws IOException {
        printer().print(unknownFieldSet, appendable);
    }

    @Deprecated
    public static void printUnicode(MessageOrBuilder messageOrBuilder, Appendable appendable) throws IOException {
        printer().escapingNonAscii(false).print(messageOrBuilder, appendable);
    }

    @Deprecated
    public static void printUnicode(UnknownFieldSet unknownFieldSet, Appendable appendable) throws IOException {
        printer().escapingNonAscii(false).print(unknownFieldSet, appendable);
    }

    public static String shortDebugString(MessageOrBuilder messageOrBuilder) {
        return printer().shortDebugString(messageOrBuilder);
    }

    @Deprecated
    public static String shortDebugString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
        return printer().shortDebugString(fieldDescriptor, obj);
    }

    @Deprecated
    public static String shortDebugString(UnknownFieldSet unknownFieldSet) {
        return printer().shortDebugString(unknownFieldSet);
    }

    @Deprecated
    public static String printToString(MessageOrBuilder messageOrBuilder) {
        return printer().printToString(messageOrBuilder);
    }

    @Deprecated
    public static String printToString(UnknownFieldSet unknownFieldSet) {
        return printer().printToString(unknownFieldSet);
    }

    @Deprecated
    public static String printToUnicodeString(MessageOrBuilder messageOrBuilder) {
        return printer().escapingNonAscii(false).printToString(messageOrBuilder);
    }

    @Deprecated
    public static String printToUnicodeString(UnknownFieldSet unknownFieldSet) {
        return printer().escapingNonAscii(false).printToString(unknownFieldSet);
    }

    @Deprecated
    public static void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
        printer().printField(fieldDescriptor, obj, appendable);
    }

    @Deprecated
    public static String printFieldToString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
        return printer().printFieldToString(fieldDescriptor, obj);
    }

    @Deprecated
    public static void printUnicodeFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
        printer().escapingNonAscii(false).printFieldValue(fieldDescriptor, obj, appendable);
    }

    @Deprecated
    public static void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
        printer().printFieldValue(fieldDescriptor, obj, appendable);
    }

    public static void printUnknownFieldValue(int i, Object obj, Appendable appendable) throws IOException {
        printUnknownFieldValue(i, obj, multiLineOutput(appendable));
    }

    private static void printUnknownFieldValue(int i, Object obj, TextGenerator textGenerator) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            textGenerator.print(unsignedToString(((Long) obj).longValue()));
        } else if (tagWireType == 1) {
            textGenerator.print(String.format(null, "0x%016x", (Long) obj));
        } else if (tagWireType == 2) {
            try {
                UnknownFieldSet parseFrom = UnknownFieldSet.parseFrom((ByteString) obj);
                textGenerator.print("{");
                textGenerator.eol();
                textGenerator.indent();
                Printer.printUnknownFields(parseFrom, textGenerator);
                textGenerator.outdent();
                textGenerator.print("}");
            } catch (InvalidProtocolBufferException unused) {
                textGenerator.print(jdn.f1779O000000o);
                textGenerator.print(escapeBytes((ByteString) obj));
                textGenerator.print(jdn.f1779O000000o);
            }
        } else if (tagWireType == 3) {
            Printer.printUnknownFields((UnknownFieldSet) obj, textGenerator);
        } else if (tagWireType == 5) {
            textGenerator.print(String.format(null, "0x%08x", (Integer) obj));
        } else {
            throw new IllegalArgumentException("Bad tag: ".concat(String.valueOf(i)));
        }
    }

    public static Printer printer() {
        return Printer.DEFAULT;
    }

    public static final class Printer {
        public static final Printer DEFAULT = new Printer(true, TypeRegistry.getEmptyTypeRegistry());
        private final boolean escapeNonAscii;
        private final TypeRegistry typeRegistry;

        private Printer(boolean z, TypeRegistry typeRegistry2) {
            this.escapeNonAscii = z;
            this.typeRegistry = typeRegistry2;
        }

        public final Printer escapingNonAscii(boolean z) {
            return new Printer(z, this.typeRegistry);
        }

        public final Printer usingTypeRegistry(TypeRegistry typeRegistry2) {
            if (this.typeRegistry == TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(this.escapeNonAscii, typeRegistry2);
            }
            throw new IllegalArgumentException("Only one typeRegistry is allowed.");
        }

        public final void print(MessageOrBuilder messageOrBuilder, Appendable appendable) throws IOException {
            print(messageOrBuilder, TextFormat.multiLineOutput(appendable));
        }

        public final void print(UnknownFieldSet unknownFieldSet, Appendable appendable) throws IOException {
            printUnknownFields(unknownFieldSet, TextFormat.multiLineOutput(appendable));
        }

        private void print(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            if (!messageOrBuilder.getDescriptorForType().getFullName().equals("google.protobuf.Any") || !printAny(messageOrBuilder, textGenerator)) {
                printMessage(messageOrBuilder, textGenerator);
            }
        }

        private boolean printAny(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            Descriptors.Descriptor descriptorForType = messageOrBuilder.getDescriptorForType();
            Descriptors.FieldDescriptor findFieldByNumber = descriptorForType.findFieldByNumber(1);
            Descriptors.FieldDescriptor findFieldByNumber2 = descriptorForType.findFieldByNumber(2);
            if (findFieldByNumber != null && findFieldByNumber.getType() == Descriptors.FieldDescriptor.Type.STRING && findFieldByNumber2 != null && findFieldByNumber2.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
                String str = (String) messageOrBuilder.getField(findFieldByNumber);
                if (str.isEmpty()) {
                    return false;
                }
                Object field = messageOrBuilder.getField(findFieldByNumber2);
                try {
                    Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(str);
                    if (descriptorForTypeUrl == null) {
                        return false;
                    }
                    DynamicMessage.Builder newBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                    newBuilderForType.mergeFrom((ByteString) field);
                    textGenerator.print("[");
                    textGenerator.print(str);
                    textGenerator.print("] {");
                    textGenerator.eol();
                    textGenerator.indent();
                    print(newBuilderForType, textGenerator);
                    textGenerator.outdent();
                    textGenerator.print("}");
                    textGenerator.eol();
                    return true;
                } catch (InvalidProtocolBufferException unused) {
                }
            }
            return false;
        }

        public final String printFieldToString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            try {
                StringBuilder sb = new StringBuilder();
                printField(fieldDescriptor, obj, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public final void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
            printField(fieldDescriptor, obj, TextFormat.multiLineOutput(appendable));
        }

        private void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            if (fieldDescriptor.isRepeated()) {
                for (Object printSingleField : (List) obj) {
                    printSingleField(fieldDescriptor, printSingleField, textGenerator);
                }
                return;
            }
            printSingleField(fieldDescriptor, obj, textGenerator);
        }

        public final void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
            printFieldValue(fieldDescriptor, obj, TextFormat.multiLineOutput(appendable));
        }

        private void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            String str;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    textGenerator.print(((Integer) obj).toString());
                    return;
                case 4:
                case 5:
                case 6:
                    textGenerator.print(((Long) obj).toString());
                    return;
                case 7:
                    textGenerator.print(((Boolean) obj).toString());
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    textGenerator.print(((Float) obj).toString());
                    return;
                case 9:
                    textGenerator.print(((Double) obj).toString());
                    return;
                case 10:
                case 11:
                    textGenerator.print(TextFormat.unsignedToString(((Integer) obj).intValue()));
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                    textGenerator.print(TextFormat.unsignedToString(((Long) obj).longValue()));
                    return;
                case 14:
                    textGenerator.print(jdn.f1779O000000o);
                    if (this.escapeNonAscii) {
                        str = TextFormatEscaper.escapeText((String) obj);
                    } else {
                        str = TextFormat.escapeDoubleQuotesAndBackslashes((String) obj).replace("\n", "\\n");
                    }
                    textGenerator.print(str);
                    textGenerator.print(jdn.f1779O000000o);
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    textGenerator.print(jdn.f1779O000000o);
                    if (obj instanceof ByteString) {
                        textGenerator.print(TextFormat.escapeBytes((ByteString) obj));
                    } else {
                        textGenerator.print(TextFormat.escapeBytes((byte[]) obj));
                    }
                    textGenerator.print(jdn.f1779O000000o);
                    return;
                case 16:
                    textGenerator.print(((Descriptors.EnumValueDescriptor) obj).getName());
                    return;
                case 17:
                case 18:
                    print((Message) obj, textGenerator);
                    return;
                default:
                    return;
            }
        }

        public final String printToString(MessageOrBuilder messageOrBuilder) {
            try {
                StringBuilder sb = new StringBuilder();
                print(messageOrBuilder, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public final String printToString(UnknownFieldSet unknownFieldSet) {
            try {
                StringBuilder sb = new StringBuilder();
                print(unknownFieldSet, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public final String shortDebugString(MessageOrBuilder messageOrBuilder) {
            try {
                StringBuilder sb = new StringBuilder();
                print(messageOrBuilder, TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public final String shortDebugString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            try {
                StringBuilder sb = new StringBuilder();
                printField(fieldDescriptor, obj, TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public final String shortDebugString(UnknownFieldSet unknownFieldSet) {
            try {
                StringBuilder sb = new StringBuilder();
                printUnknownFields(unknownFieldSet, TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private static void printUnknownFieldValue(int i, Object obj, TextGenerator textGenerator) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                textGenerator.print(TextFormat.unsignedToString(((Long) obj).longValue()));
            } else if (tagWireType == 1) {
                textGenerator.print(String.format(null, "0x%016x", (Long) obj));
            } else if (tagWireType == 2) {
                try {
                    UnknownFieldSet parseFrom = UnknownFieldSet.parseFrom((ByteString) obj);
                    textGenerator.print("{");
                    textGenerator.eol();
                    textGenerator.indent();
                    printUnknownFields(parseFrom, textGenerator);
                    textGenerator.outdent();
                    textGenerator.print("}");
                } catch (InvalidProtocolBufferException unused) {
                    textGenerator.print(jdn.f1779O000000o);
                    textGenerator.print(TextFormat.escapeBytes((ByteString) obj));
                    textGenerator.print(jdn.f1779O000000o);
                }
            } else if (tagWireType == 3) {
                printUnknownFields((UnknownFieldSet) obj, textGenerator);
            } else if (tagWireType == 5) {
                textGenerator.print(String.format(null, "0x%08x", (Integer) obj));
            } else {
                throw new IllegalArgumentException("Bad tag: ".concat(String.valueOf(i)));
            }
        }

        private void printMessage(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            for (Map.Entry next : messageOrBuilder.getAllFields().entrySet()) {
                printField((Descriptors.FieldDescriptor) next.getKey(), next.getValue(), textGenerator);
            }
            printUnknownFields(messageOrBuilder.getUnknownFields(), textGenerator);
        }

        private void printSingleField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            if (fieldDescriptor.isExtension()) {
                textGenerator.print("[");
                if (!fieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || !fieldDescriptor.isOptional() || fieldDescriptor.getExtensionScope() != fieldDescriptor.getMessageType()) {
                    textGenerator.print(fieldDescriptor.getFullName());
                } else {
                    textGenerator.print(fieldDescriptor.getMessageType().getFullName());
                }
                textGenerator.print("]");
            } else if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
                textGenerator.print(fieldDescriptor.getMessageType().getName());
            } else {
                textGenerator.print(fieldDescriptor.getName());
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                textGenerator.print(" {");
                textGenerator.eol();
                textGenerator.indent();
            } else {
                textGenerator.print(": ");
            }
            printFieldValue(fieldDescriptor, obj, textGenerator);
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                textGenerator.outdent();
                textGenerator.print("}");
            }
            textGenerator.eol();
        }

        public static void printUnknownFields(UnknownFieldSet unknownFieldSet, TextGenerator textGenerator) throws IOException {
            for (Map.Entry next : unknownFieldSet.asMap().entrySet()) {
                int intValue = ((Integer) next.getKey()).intValue();
                UnknownFieldSet.Field field = (UnknownFieldSet.Field) next.getValue();
                printUnknownField(intValue, 0, field.getVarintList(), textGenerator);
                printUnknownField(intValue, 5, field.getFixed32List(), textGenerator);
                printUnknownField(intValue, 1, field.getFixed64List(), textGenerator);
                printUnknownField(intValue, 2, field.getLengthDelimitedList(), textGenerator);
                for (UnknownFieldSet printUnknownFields : field.getGroupList()) {
                    textGenerator.print(((Integer) next.getKey()).toString());
                    textGenerator.print(" {");
                    textGenerator.eol();
                    textGenerator.indent();
                    printUnknownFields(printUnknownFields, textGenerator);
                    textGenerator.outdent();
                    textGenerator.print("}");
                    textGenerator.eol();
                }
            }
        }

        private static void printUnknownField(int i, int i2, List<?> list, TextGenerator textGenerator) throws IOException {
            for (Object next : list) {
                textGenerator.print(String.valueOf(i));
                textGenerator.print(": ");
                printUnknownFieldValue(i2, next, textGenerator);
                textGenerator.eol();
            }
        }
    }

    /* renamed from: com.google.protobuf.TextFormat$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[Descriptors.FieldDescriptor.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String unsignedToString(int i) {
        if (i >= 0) {
            return Integer.toString(i);
        }
        return Long.toString(((long) i) & 4294967295L);
    }

    public static String unsignedToString(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }

    public static TextGenerator multiLineOutput(Appendable appendable) {
        return new TextGenerator(appendable, false, null);
    }

    public static TextGenerator singleLineOutput(Appendable appendable) {
        return new TextGenerator(appendable, true, null);
    }

    static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;
        private final boolean singleLineMode;

        /* synthetic */ TextGenerator(Appendable appendable, boolean z, AnonymousClass1 r3) {
            this(appendable, z);
        }

        private TextGenerator(Appendable appendable, boolean z) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = appendable;
            this.singleLineMode = z;
        }

        public final void indent() {
            this.indent.append("  ");
        }

        public final void outdent() {
            int length = this.indent.length();
            if (length != 0) {
                this.indent.setLength(length - 2);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public final void print(CharSequence charSequence) throws IOException {
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.singleLineMode ? " " : this.indent);
            }
            this.output.append(charSequence);
        }

        public final void eol() throws IOException {
            if (!this.singleLineMode) {
                this.output.append("\n");
            }
            this.atStartOfLine = true;
        }
    }

    static final class Tokenizer {
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private int column;
        public String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        /* synthetic */ Tokenizer(CharSequence charSequence, AnonymousClass1 r2) {
            this(charSequence);
        }

        private Tokenizer(CharSequence charSequence) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = charSequence;
            this.matcher = WHITESPACE.matcher(charSequence);
            skipWhitespace();
            nextToken();
        }

        /* access modifiers changed from: package-private */
        public final int getPreviousLine() {
            return this.previousLine;
        }

        /* access modifiers changed from: package-private */
        public final int getPreviousColumn() {
            return this.previousColumn;
        }

        /* access modifiers changed from: package-private */
        public final int getLine() {
            return this.line;
        }

        /* access modifiers changed from: package-private */
        public final int getColumn() {
            return this.column;
        }

        public final boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public final void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == 10) {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                Matcher matcher2 = this.matcher;
                matcher2.region(matcher2.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                Matcher matcher3 = this.matcher;
                matcher3.region(this.pos + 1, matcher3.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                Matcher matcher2 = this.matcher;
                matcher2.region(matcher2.end(), this.matcher.regionEnd());
            }
        }

        public final boolean tryConsume(String str) {
            if (!this.currentToken.equals(str)) {
                return false;
            }
            nextToken();
            return true;
        }

        public final void consume(String str) throws ParseException {
            if (!tryConsume(str)) {
                throw parseException("Expected \"" + str + "\".");
            }
        }

        public final boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char charAt = this.currentToken.charAt(0);
            if (('0' <= charAt && charAt <= '9') || charAt == '-' || charAt == '+') {
                return true;
            }
            return false;
        }

        public final boolean lookingAt(String str) {
            return this.currentToken.equals(str);
        }

        public final String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char charAt = this.currentToken.charAt(i);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && !(('0' <= charAt && charAt <= '9') || charAt == '_' || charAt == '.'))) {
                    throw parseException("Expected identifier. Found '" + this.currentToken + "'");
                }
            }
            String str = this.currentToken;
            nextToken();
            return str;
        }

        public final boolean tryConsumeIdentifier() {
            try {
                consumeIdentifier();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public final int consumeInt32() throws ParseException {
            try {
                int parseInt32 = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return parseInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final int consumeUInt32() throws ParseException {
            try {
                int parseUInt32 = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return parseUInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final long consumeInt64() throws ParseException {
            try {
                long parseInt64 = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return parseInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final boolean tryConsumeInt64() {
            try {
                consumeInt64();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public final long consumeUInt64() throws ParseException {
            try {
                long parseUInt64 = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return parseUInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final boolean tryConsumeUInt64() {
            try {
                consumeUInt64();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public final double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean startsWith = this.currentToken.startsWith("-");
                nextToken();
                return startsWith ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            } else {
                try {
                    double parseDouble = Double.parseDouble(this.currentToken);
                    nextToken();
                    return parseDouble;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public final boolean tryConsumeDouble() {
            try {
                consumeDouble();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public final float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean startsWith = this.currentToken.startsWith("-");
                nextToken();
                return startsWith ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            } else if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            } else {
                try {
                    float parseFloat = Float.parseFloat(this.currentToken);
                    nextToken();
                    return parseFloat;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public final boolean tryConsumeFloat() {
            try {
                consumeFloat();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public final boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("True") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            } else if (this.currentToken.equals("false") || this.currentToken.equals("False") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            } else {
                throw parseException("Expected \"true\" or \"false\". Found \"" + this.currentToken + "\".");
            }
        }

        public final String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public final boolean tryConsumeString() {
            try {
                consumeString();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public final ByteString consumeByteString() throws ParseException {
            ArrayList arrayList = new ArrayList();
            consumeByteString(arrayList);
            while (true) {
                if (!this.currentToken.startsWith("'") && !this.currentToken.startsWith(jdn.f1779O000000o)) {
                    return ByteString.copyFrom(arrayList);
                }
                consumeByteString(arrayList);
            }
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char c = 0;
            if (this.currentToken.length() > 0) {
                c = this.currentToken.charAt(0);
            }
            if (c == '\"' || c == '\'') {
                if (this.currentToken.length() >= 2) {
                    String str = this.currentToken;
                    if (str.charAt(str.length() - 1) == c) {
                        try {
                            ByteString unescapeBytes = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
                            nextToken();
                            list.add(unescapeBytes);
                            return;
                        } catch (InvalidEscapeSequenceException e) {
                            throw parseException(e.getMessage());
                        }
                    }
                }
                throw parseException("String missing ending quote.");
            }
            throw parseException("Expected string.");
        }

        public final ParseException parseException(String str) {
            return new ParseException(this.line + 1, this.column + 1, str);
        }

        public final ParseException parseExceptionPreviousToken(String str) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, str);
        }

        private ParseException integerParseException(NumberFormatException numberFormatException) {
            return parseException("Couldn't parse integer: " + numberFormatException.getMessage());
        }

        private ParseException floatParseException(NumberFormatException numberFormatException) {
            return parseException("Couldn't parse number: " + numberFormatException.getMessage());
        }

        public final UnknownFieldParseException unknownFieldParseExceptionPreviousToken(String str, String str2) {
            return new UnknownFieldParseException(this.previousLine + 1, this.previousColumn + 1, str, str2);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(String str) {
            this(-1, -1, str);
        }

        public ParseException(int i, int i2, String str) {
            super(Integer.toString(i) + ":" + i2 + ": " + str);
            this.line = i;
            this.column = i2;
        }

        public int getLine() {
            return this.line;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(String str) {
            this(-1, -1, "", str);
        }

        public UnknownFieldParseException(int i, int i2, String str, String str2) {
            super(i, i2, str2);
            this.unknownField = str;
        }

        public String getUnknownField() {
            return this.unknownField;
        }
    }

    public static Parser getParser() {
        return PARSER;
    }

    public static void merge(Readable readable, Message.Builder builder) throws IOException {
        PARSER.merge(readable, builder);
    }

    public static void merge(CharSequence charSequence, Message.Builder builder) throws ParseException {
        PARSER.merge(charSequence, builder);
    }

    public static <T extends Message> T parse(CharSequence charSequence, Class<T> cls) throws ParseException {
        Message.Builder newBuilderForType = ((Message) Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, newBuilderForType);
        return newBuilderForType.build();
    }

    public static void merge(Readable readable, ExtensionRegistry extensionRegistry, Message.Builder builder) throws IOException {
        PARSER.merge(readable, extensionRegistry, builder);
    }

    public static void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        PARSER.merge(charSequence, extensionRegistry, builder);
    }

    public static <T extends Message> T parse(CharSequence charSequence, ExtensionRegistry extensionRegistry, Class<T> cls) throws ParseException {
        Message.Builder newBuilderForType = ((Message) Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, extensionRegistry, newBuilderForType);
        return newBuilderForType.build();
    }

    public static class Parser {
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final SingularOverwritePolicy singularOverwritePolicy;
        private final TypeRegistry typeRegistry;

        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        /* synthetic */ Parser(TypeRegistry typeRegistry2, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy2, TextFormatParseInfoTree.Builder builder, AnonymousClass1 r7) {
            this(typeRegistry2, z, z2, z3, singularOverwritePolicy2, builder);
        }

        private Parser(TypeRegistry typeRegistry2, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy2, TextFormatParseInfoTree.Builder builder) {
            this.typeRegistry = typeRegistry2;
            this.allowUnknownFields = z;
            this.allowUnknownEnumValues = z2;
            this.allowUnknownExtensions = z3;
            this.singularOverwritePolicy = singularOverwritePolicy2;
            this.parseInfoTreeBuilder = builder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static class Builder {
            private boolean allowUnknownEnumValues = false;
            private boolean allowUnknownExtensions = false;
            private boolean allowUnknownFields = false;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
            private SingularOverwritePolicy singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
            private TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();

            public Builder setTypeRegistry(TypeRegistry typeRegistry2) {
                this.typeRegistry = typeRegistry2;
                return this;
            }

            public Builder setAllowUnknownFields(boolean z) {
                this.allowUnknownFields = z;
                return this;
            }

            public Builder setAllowUnknownExtensions(boolean z) {
                this.allowUnknownExtensions = z;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy singularOverwritePolicy2) {
                this.singularOverwritePolicy = singularOverwritePolicy2;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder builder) {
                this.parseInfoTreeBuilder = builder;
                return this;
            }

            public Parser build() {
                return new Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder, null);
            }
        }

        public void merge(Readable readable, Message.Builder builder) throws IOException {
            merge(readable, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(CharSequence charSequence, Message.Builder builder) throws ParseException {
            merge(charSequence, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(Readable readable, ExtensionRegistry extensionRegistry, Message.Builder builder) throws IOException {
            merge(toStringBuilder(readable), extensionRegistry, builder);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder}
         arg types: [java.nio.CharBuffer, int, int]
         candidates:
          ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
          ClspMth{java.lang.StringBuilder.append(char[], int, int):java.lang.StringBuilder}
          ClspMth{java.lang.Appendable.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
          ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder} */
        private static StringBuilder toStringBuilder(Readable readable) throws IOException {
            StringBuilder sb = new StringBuilder();
            CharBuffer allocate = CharBuffer.allocate(4096);
            while (true) {
                int read = readable.read(allocate);
                if (read == -1) {
                    return sb;
                }
                allocate.flip();
                sb.append((CharSequence) allocate, 0, read);
            }
        }

        static final class UnknownField {
            final String message;
            final Type type;

            enum Type {
                FIELD,
                EXTENSION
            }

            UnknownField(String str, Type type2) {
                this.message = str;
                this.type = type2;
            }
        }

        private void checkUnknownFields(List<UnknownField> list) throws ParseException {
            int i;
            boolean z;
            if (!list.isEmpty()) {
                StringBuilder sb = new StringBuilder("Input contains unknown fields and/or extensions:");
                for (UnknownField unknownField : list) {
                    sb.append(10);
                    sb.append(unknownField.message);
                }
                if (this.allowUnknownFields) {
                    TextFormat.logger.warning(sb.toString());
                    return;
                }
                if (this.allowUnknownExtensions) {
                    Iterator<UnknownField> it = list.iterator();
                    i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        } else if (it.next().type == UnknownField.Type.FIELD) {
                            z = false;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z) {
                        TextFormat.logger.warning(sb.toString());
                        return;
                    }
                } else {
                    i = 0;
                }
                String[] split = list.get(i).message.split(":");
                throw new ParseException(Integer.parseInt(split[0]), Integer.parseInt(split[1]), sb.toString());
            }
        }

        public void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
            Tokenizer tokenizer = new Tokenizer(charSequence, null);
            MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(builder);
            ArrayList arrayList = new ArrayList();
            while (!tokenizer.atEnd()) {
                mergeField(tokenizer, extensionRegistry, builderAdapter, arrayList);
            }
            checkUnknownFields(arrayList);
        }

        private void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, List<UnknownField> list) throws ParseException {
            mergeField(tokenizer, extensionRegistry, mergeTarget, this.parseInfoTreeBuilder, list);
        }

        private void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, TextFormatParseInfoTree.Builder builder, List<UnknownField> list) throws ParseException {
            ExtensionRegistry.ExtensionInfo extensionInfo;
            Descriptors.FieldDescriptor fieldDescriptor;
            Tokenizer tokenizer2 = tokenizer;
            TextFormatParseInfoTree.Builder builder2 = builder;
            List<UnknownField> list2 = list;
            int line = tokenizer.getLine();
            int column = tokenizer.getColumn();
            Descriptors.Descriptor descriptorForType = mergeTarget.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptor2 = null;
            if (tokenizer2.tryConsume("[")) {
                StringBuilder sb = new StringBuilder(tokenizer.consumeIdentifier());
                while (tokenizer2.tryConsume(".")) {
                    sb.append('.');
                    sb.append(tokenizer.consumeIdentifier());
                }
                ExtensionRegistry.ExtensionInfo findExtensionByName = mergeTarget.findExtensionByName(extensionRegistry, sb.toString());
                if (findExtensionByName == null) {
                    list2.add(new UnknownField((tokenizer.getPreviousLine() + 1) + ":" + (tokenizer.getPreviousColumn() + 1) + ":\t" + descriptorForType.getFullName() + ".[" + ((Object) sb) + "]", UnknownField.Type.EXTENSION));
                } else if (findExtensionByName.descriptor.getContainingType() == descriptorForType) {
                    fieldDescriptor2 = findExtensionByName.descriptor;
                } else {
                    throw tokenizer2.parseExceptionPreviousToken("Extension \"" + ((Object) sb) + "\" does not extend message type \"" + descriptorForType.getFullName() + "\".");
                }
                tokenizer2.consume("]");
                extensionInfo = findExtensionByName;
                fieldDescriptor = fieldDescriptor2;
            } else {
                String consumeIdentifier = tokenizer.consumeIdentifier();
                fieldDescriptor = descriptorForType.findFieldByName(consumeIdentifier);
                if (!(fieldDescriptor != null || (fieldDescriptor = descriptorForType.findFieldByName(consumeIdentifier.toLowerCase(Locale.US))) == null || fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP)) {
                    fieldDescriptor = null;
                }
                if (fieldDescriptor != null && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP && !fieldDescriptor.getMessageType().getName().equals(consumeIdentifier)) {
                    fieldDescriptor = null;
                }
                if (fieldDescriptor == null) {
                    list2.add(new UnknownField((tokenizer.getPreviousLine() + 1) + ":" + (tokenizer.getPreviousColumn() + 1) + ":\t" + descriptorForType.getFullName() + "." + consumeIdentifier, UnknownField.Type.FIELD));
                }
                extensionInfo = null;
            }
            if (fieldDescriptor != null) {
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    tokenizer2.tryConsume(":");
                    if (builder2 != null) {
                        consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder2.getBuilderForSubMessageField(fieldDescriptor), list);
                    } else {
                        consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list);
                    }
                } else {
                    tokenizer2.consume(":");
                    consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list);
                }
                if (builder2 != null) {
                    builder2.setLocation(fieldDescriptor, TextFormatParseLocation.create(line, column));
                }
                if (!tokenizer2.tryConsume(";")) {
                    tokenizer2.tryConsume(",");
                }
            } else if (!tokenizer2.tryConsume(":") || tokenizer2.lookingAt("{") || tokenizer2.lookingAt("<")) {
                skipFieldMessage(tokenizer);
            } else {
                skipFieldValue(tokenizer);
            }
        }

        private void consumeFieldValues(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, Descriptors.FieldDescriptor fieldDescriptor, ExtensionRegistry.ExtensionInfo extensionInfo, TextFormatParseInfoTree.Builder builder, List<UnknownField> list) throws ParseException {
            if (!fieldDescriptor.isRepeated() || !tokenizer.tryConsume("[")) {
                consumeFieldValue(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list);
            } else if (!tokenizer.tryConsume("]")) {
                while (true) {
                    consumeFieldValue(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list);
                    if (!tokenizer.tryConsume("]")) {
                        tokenizer.consume(",");
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Long] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Float] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Double] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Long] */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v10, types: [com.google.protobuf.ByteString] */
        /* JADX WARN: Type inference failed for: r3v11, types: [com.google.protobuf.Descriptors$EnumValueDescriptor] */
        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.protobuf.Descriptors$EnumValueDescriptor] */
        /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 3 */
        private void consumeFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, Descriptors.FieldDescriptor fieldDescriptor, ExtensionRegistry.ExtensionInfo extensionInfo, TextFormatParseInfoTree.Builder builder, List<UnknownField> list) throws ParseException {
            String str;
            MessageReflection.MergeTarget mergeTarget2 = mergeTarget;
            Descriptors.FieldDescriptor fieldDescriptor2 = fieldDescriptor;
            ExtensionRegistry.ExtensionInfo extensionInfo2 = extensionInfo;
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && !fieldDescriptor.isRepeated()) {
                if (mergeTarget.hasField(fieldDescriptor)) {
                    throw tokenizer.parseExceptionPreviousToken("Non-repeated field \"" + fieldDescriptor.getFullName() + "\" cannot be overwritten.");
                } else if (fieldDescriptor.getContainingOneof() != null && mergeTarget2.hasOneof(fieldDescriptor.getContainingOneof())) {
                    Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
                    throw tokenizer.parseExceptionPreviousToken("Field \"" + fieldDescriptor.getFullName() + "\" is specified along with field \"" + mergeTarget2.getOneofFieldDescriptor(containingOneof).getFullName() + "\", another member of oneof \"" + containingOneof.getName() + "\".");
                }
            }
            Message message = null;
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (tokenizer.tryConsume("<")) {
                    str = ">";
                } else {
                    tokenizer.consume("{");
                    str = "}";
                }
                String str2 = str;
                if (!fieldDescriptor.getMessageType().getFullName().equals("google.protobuf.Any") || !tokenizer.tryConsume("[")) {
                    if (extensionInfo2 != null) {
                        message = extensionInfo2.defaultInstance;
                    }
                    MessageReflection.MergeTarget newMergeTargetForField = mergeTarget2.newMergeTargetForField(fieldDescriptor2, message);
                    while (!tokenizer.tryConsume(str2)) {
                        if (!tokenizer.atEnd()) {
                            mergeField(tokenizer, extensionRegistry, newMergeTargetForField, builder, list);
                        } else {
                            throw tokenizer.parseException("Expected \"" + str2 + "\".");
                        }
                    }
                    message = newMergeTargetForField.finish();
                } else {
                    ? consumeAnyFieldValue = consumeAnyFieldValue(tokenizer, extensionRegistry, fieldDescriptor, builder, list);
                    tokenizer.consume(str2);
                    message = consumeAnyFieldValue;
                }
            } else {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        message = Integer.valueOf(tokenizer.consumeInt32());
                        break;
                    case 4:
                    case 5:
                    case 6:
                        message = Long.valueOf(tokenizer.consumeInt64());
                        break;
                    case 7:
                        message = Boolean.valueOf(tokenizer.consumeBoolean());
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        message = Float.valueOf(tokenizer.consumeFloat());
                        break;
                    case 9:
                        message = Double.valueOf(tokenizer.consumeDouble());
                        break;
                    case 10:
                    case 11:
                        message = Integer.valueOf(tokenizer.consumeUInt32());
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    case 13:
                        message = Long.valueOf(tokenizer.consumeUInt64());
                        break;
                    case 14:
                        message = tokenizer.consumeString();
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        message = tokenizer.consumeByteString();
                        break;
                    case 16:
                        Descriptors.EnumDescriptor enumType = fieldDescriptor.getEnumType();
                        if (tokenizer.lookingAtInteger()) {
                            int consumeInt32 = tokenizer.consumeInt32();
                            ? findValueByNumber = enumType.findValueByNumber(consumeInt32);
                            message = findValueByNumber;
                            if (findValueByNumber == 0) {
                                String str3 = "Enum type \"" + enumType.getFullName() + "\" has no value with number " + consumeInt32 + '.';
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(str3);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + consumeInt32 + '.');
                            }
                        } else {
                            String consumeIdentifier = tokenizer.consumeIdentifier();
                            ? findValueByName = enumType.findValueByName(consumeIdentifier);
                            message = findValueByName;
                            if (findValueByName == 0) {
                                String str4 = "Enum type \"" + enumType.getFullName() + "\" has no value named \"" + consumeIdentifier + "\".";
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(str4);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken(str4);
                            }
                        }
                        break;
                    case 17:
                    case 18:
                        throw new RuntimeException("Can't get here.");
                }
            }
            if (fieldDescriptor.isRepeated()) {
                mergeTarget2.addRepeatedField(fieldDescriptor2, message);
            } else {
                mergeTarget2.setField(fieldDescriptor2, message);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.String]
         candidates:
          com.google.protobuf.DynamicMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.DynamicMessage$Builder
          com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, com.google.protobuf.ByteString]
         candidates:
          com.google.protobuf.DynamicMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.DynamicMessage$Builder
          com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder */
        private Object consumeAnyFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseInfoTree.Builder builder, List<UnknownField> list) throws ParseException {
            String str;
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append(tokenizer.consumeIdentifier());
                if (tokenizer.tryConsume("]")) {
                    tokenizer.tryConsume(":");
                    if (tokenizer.tryConsume("<")) {
                        str = ">";
                    } else {
                        tokenizer.consume("{");
                        str = "}";
                    }
                    String sb2 = sb.toString();
                    try {
                        Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(sb2);
                        if (descriptorForTypeUrl != null) {
                            DynamicMessage.Builder newBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                            MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(newBuilderForType);
                            while (!tokenizer.tryConsume(str)) {
                                mergeField(tokenizer, extensionRegistry, builderAdapter, builder, list);
                            }
                            Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
                            DynamicMessage.Builder newBuilderForType2 = DynamicMessage.getDefaultInstance(messageType).newBuilderForType();
                            newBuilderForType2.setField(messageType.findFieldByName("type_url"), (Object) sb.toString());
                            newBuilderForType2.setField(messageType.findFieldByName("value"), (Object) newBuilderForType.build().toByteString());
                            return newBuilderForType2.build();
                        }
                        throw tokenizer.parseException("Unable to parse Any of type: " + sb2 + ". Please make sure that the TypeRegistry contains the descriptors for the given types.");
                    } catch (InvalidProtocolBufferException unused) {
                        throw tokenizer.parseException("Invalid valid type URL. Found: ".concat(String.valueOf(sb2)));
                    }
                } else if (tokenizer.tryConsume("/")) {
                    sb.append("/");
                } else if (tokenizer.tryConsume(".")) {
                    sb.append(".");
                } else {
                    throw tokenizer.parseExceptionPreviousToken("Expected a valid type URL.");
                }
            }
        }

        private void skipField(Tokenizer tokenizer) throws ParseException {
            if (tokenizer.tryConsume("[")) {
                do {
                    tokenizer.consumeIdentifier();
                } while (tokenizer.tryConsume("."));
                tokenizer.consume("]");
            } else {
                tokenizer.consumeIdentifier();
            }
            if (!tokenizer.tryConsume(":") || tokenizer.lookingAt("<") || tokenizer.lookingAt("{")) {
                skipFieldMessage(tokenizer);
            } else {
                skipFieldValue(tokenizer);
            }
            if (!tokenizer.tryConsume(";")) {
                tokenizer.tryConsume(",");
            }
        }

        private void skipFieldMessage(Tokenizer tokenizer) throws ParseException {
            String str;
            if (tokenizer.tryConsume("<")) {
                str = ">";
            } else {
                tokenizer.consume("{");
                str = "}";
            }
            while (!tokenizer.lookingAt(">") && !tokenizer.lookingAt("}")) {
                skipField(tokenizer);
            }
            tokenizer.consume(str);
        }

        private void skipFieldValue(Tokenizer tokenizer) throws ParseException {
            if (tokenizer.tryConsumeString()) {
                do {
                } while (tokenizer.tryConsumeString());
            } else if (!tokenizer.tryConsumeIdentifier() && !tokenizer.tryConsumeInt64() && !tokenizer.tryConsumeUInt64() && !tokenizer.tryConsumeDouble() && !tokenizer.tryConsumeFloat()) {
                throw tokenizer.parseException("Invalid field value: " + tokenizer.currentToken);
            }
        }
    }

    public static String escapeBytes(ByteString byteString) {
        return TextFormatEscaper.escapeBytes(byteString);
    }

    public static String escapeBytes(byte[] bArr) {
        return TextFormatEscaper.escapeBytes(bArr);
    }

    public static ByteString unescapeBytes(CharSequence charSequence) throws InvalidEscapeSequenceException {
        int i;
        int i2;
        int i3;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(charSequence.toString());
        byte[] bArr = new byte[copyFromUtf8.size()];
        int i4 = 0;
        int i5 = 0;
        while (i < copyFromUtf8.size()) {
            byte byteAt = copyFromUtf8.byteAt(i);
            if (byteAt == 92) {
                i++;
                if (i < copyFromUtf8.size()) {
                    byte byteAt2 = copyFromUtf8.byteAt(i);
                    if (isOctal(byteAt2)) {
                        int digitValue = digitValue(byteAt2);
                        int i6 = i + 1;
                        if (i6 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i6))) {
                            digitValue = (digitValue * 8) + digitValue(copyFromUtf8.byteAt(i6));
                            i = i6;
                        }
                        int i7 = i + 1;
                        if (i7 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i7))) {
                            digitValue = (digitValue * 8) + digitValue(copyFromUtf8.byteAt(i7));
                            i = i7;
                        }
                        i2 = i5 + 1;
                        bArr[i5] = (byte) digitValue;
                    } else {
                        if (byteAt2 == 34) {
                            i3 = i5 + 1;
                            bArr[i5] = 34;
                        } else if (byteAt2 == 39) {
                            i3 = i5 + 1;
                            bArr[i5] = 39;
                        } else if (byteAt2 == 92) {
                            i3 = i5 + 1;
                            bArr[i5] = 92;
                        } else if (byteAt2 == 102) {
                            i3 = i5 + 1;
                            bArr[i5] = 12;
                        } else if (byteAt2 == 110) {
                            i3 = i5 + 1;
                            bArr[i5] = 10;
                        } else if (byteAt2 == 114) {
                            i3 = i5 + 1;
                            bArr[i5] = 13;
                        } else if (byteAt2 == 116) {
                            i3 = i5 + 1;
                            bArr[i5] = 9;
                        } else if (byteAt2 == 118) {
                            i3 = i5 + 1;
                            bArr[i5] = 11;
                        } else if (byteAt2 == 120) {
                            i++;
                            if (i >= copyFromUtf8.size() || !isHex(copyFromUtf8.byteAt(i))) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                            int digitValue2 = digitValue(copyFromUtf8.byteAt(i));
                            int i8 = i + 1;
                            if (i8 < copyFromUtf8.size() && isHex(copyFromUtf8.byteAt(i8))) {
                                digitValue2 = (digitValue2 * 16) + digitValue(copyFromUtf8.byteAt(i8));
                                i = i8;
                            }
                            i2 = i5 + 1;
                            bArr[i5] = (byte) digitValue2;
                        } else if (byteAt2 == 97) {
                            i3 = i5 + 1;
                            bArr[i5] = 7;
                        } else if (byteAt2 == 98) {
                            i3 = i5 + 1;
                            bArr[i5] = 8;
                        } else {
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) byteAt2) + '\'');
                        }
                        i5 = i3;
                        i4 = i + 1;
                    }
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                i2 = i5 + 1;
                bArr[i5] = byteAt;
            }
            i5 = i2;
            i4 = i + 1;
        }
        if (bArr.length == i5) {
            return ByteString.wrap(bArr);
        }
        return ByteString.copyFrom(bArr, 0, i5);
    }

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    public static String escapeDoubleQuotesAndBackslashes(String str) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(str);
    }

    static String unescapeText(String str) throws InvalidEscapeSequenceException {
        return unescapeBytes(str).toStringUtf8();
    }

    static int parseInt32(String str) throws NumberFormatException {
        return (int) parseInteger(str, true, false);
    }

    static int parseUInt32(String str) throws NumberFormatException {
        return (int) parseInteger(str, false, false);
    }

    static long parseInt64(String str) throws NumberFormatException {
        return parseInteger(str, true, true);
    }

    static long parseUInt64(String str) throws NumberFormatException {
        return parseInteger(str, false, true);
    }

    private static long parseInteger(String str, boolean z, boolean z2) throws NumberFormatException {
        int i = 0;
        boolean z3 = true;
        if (!str.startsWith("-", 0)) {
            z3 = false;
        } else if (z) {
            i = 1;
        } else {
            throw new NumberFormatException("Number must be positive: ".concat(String.valueOf(str)));
        }
        int i2 = 10;
        if (str.startsWith("0x", i)) {
            i += 2;
            i2 = 16;
        } else if (str.startsWith("0", i)) {
            i2 = 8;
        }
        String substring = str.substring(i);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i2);
            if (z3) {
                parseLong = -parseLong;
            }
            if (z2) {
                return parseLong;
            }
            if (z) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(String.valueOf(str)));
            } else if (parseLong < 4294967296L && parseLong >= 0) {
                return parseLong;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(String.valueOf(str)));
            }
        } else {
            BigInteger bigInteger = new BigInteger(substring, i2);
            if (z3) {
                bigInteger = bigInteger.negate();
            }
            if (!z2) {
                if (z) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(String.valueOf(str)));
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(String.valueOf(str)));
                }
            } else if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(String.valueOf(str)));
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(String.valueOf(str)));
            }
            return bigInteger.longValue();
        }
    }
}
