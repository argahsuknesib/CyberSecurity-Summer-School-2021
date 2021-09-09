package com.xiaomi.idm.uwb.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.xiaomi.idm.uwb.proto.UwbData;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class MiCloseRange {

    public interface CallbackMessageOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        String getName();

        ByteString getNameBytes();
    }

    public interface OnScanningOrBuilder extends MessageLiteOrBuilder {
        UwbData.MeasurementData getMeasurementData(int i);

        int getMeasurementDataCount();

        List<UwbData.MeasurementData> getMeasurementDataList();
    }

    public interface PayLoadOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        int getFlag();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface UwbCommandOrBuilder extends MessageLiteOrBuilder {
        ByteString getCommandBytes();

        String getCommandName();

        ByteString getCommandNameBytes();
    }

    public interface UwbCommandResultOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        String getName();

        ByteString getNameBytes();

        int getStatus();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface UwbResultOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        int getDataType();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private MiCloseRange() {
    }

    public static final class UwbCommand extends GeneratedMessageLite<UwbCommand, Builder> implements UwbCommandOrBuilder {
        public static final UwbCommand DEFAULT_INSTANCE;
        private static volatile Parser<UwbCommand> PARSER;
        private ByteString commandBytes_ = ByteString.EMPTY;
        private String commandName_ = "";

        private UwbCommand() {
        }

        public final String getCommandName() {
            return this.commandName_;
        }

        public final ByteString getCommandNameBytes() {
            return ByteString.copyFromUtf8(this.commandName_);
        }

        public final void setCommandName(String str) {
            if (str != null) {
                this.commandName_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearCommandName() {
            this.commandName_ = getDefaultInstance().getCommandName();
        }

        public final void setCommandNameBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.commandName_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final ByteString getCommandBytes() {
            return this.commandBytes_;
        }

        public final void setCommandBytes(ByteString byteString) {
            if (byteString != null) {
                this.commandBytes_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearCommandBytes() {
            this.commandBytes_ = getDefaultInstance().getCommandBytes();
        }

        public static UwbCommand parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UwbCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UwbCommand parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UwbCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UwbCommand parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UwbCommand parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UwbCommand parseFrom(InputStream inputStream) throws IOException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UwbCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UwbCommand parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UwbCommand) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UwbCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbCommand) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UwbCommand parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UwbCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UwbCommand uwbCommand) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(uwbCommand);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UwbCommand, Builder> implements UwbCommandOrBuilder {
            private Builder() {
                super(UwbCommand.DEFAULT_INSTANCE);
            }

            public final String getCommandName() {
                return ((UwbCommand) this.instance).getCommandName();
            }

            public final ByteString getCommandNameBytes() {
                return ((UwbCommand) this.instance).getCommandNameBytes();
            }

            public final Builder setCommandName(String str) {
                copyOnWrite();
                ((UwbCommand) this.instance).setCommandName(str);
                return this;
            }

            public final Builder clearCommandName() {
                copyOnWrite();
                ((UwbCommand) this.instance).clearCommandName();
                return this;
            }

            public final Builder setCommandNameBytes(ByteString byteString) {
                copyOnWrite();
                ((UwbCommand) this.instance).setCommandNameBytes(byteString);
                return this;
            }

            public final ByteString getCommandBytes() {
                return ((UwbCommand) this.instance).getCommandBytes();
            }

            public final Builder setCommandBytes(ByteString byteString) {
                copyOnWrite();
                ((UwbCommand) this.instance).setCommandBytes(byteString);
                return this;
            }

            public final Builder clearCommandBytes() {
                copyOnWrite();
                ((UwbCommand) this.instance).clearCommandBytes();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UwbCommand();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"commandName_", "commandBytes_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UwbCommand> parser = PARSER;
                    if (parser == null) {
                        synchronized (UwbCommand.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UwbCommand uwbCommand = new UwbCommand();
            DEFAULT_INSTANCE = uwbCommand;
            GeneratedMessageLite.registerDefaultInstance(UwbCommand.class, uwbCommand);
        }

        public static UwbCommand getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UwbCommand> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UwbResult extends GeneratedMessageLite<UwbResult, Builder> implements UwbResultOrBuilder {
        public static final UwbResult DEFAULT_INSTANCE;
        private static volatile Parser<UwbResult> PARSER;
        private int dataType_;
        private ByteString data_ = ByteString.EMPTY;

        private UwbResult() {
        }

        public final int getDataType() {
            return this.dataType_;
        }

        public final void setDataType(int i) {
            this.dataType_ = i;
        }

        public final void clearDataType() {
            this.dataType_ = 0;
        }

        public final ByteString getData() {
            return this.data_;
        }

        public final void setData(ByteString byteString) {
            if (byteString != null) {
                this.data_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static UwbResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UwbResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UwbResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UwbResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UwbResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UwbResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UwbResult parseFrom(InputStream inputStream) throws IOException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UwbResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UwbResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UwbResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UwbResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UwbResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UwbResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UwbResult uwbResult) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(uwbResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UwbResult, Builder> implements UwbResultOrBuilder {
            private Builder() {
                super(UwbResult.DEFAULT_INSTANCE);
            }

            public final int getDataType() {
                return ((UwbResult) this.instance).getDataType();
            }

            public final Builder setDataType(int i) {
                copyOnWrite();
                ((UwbResult) this.instance).setDataType(i);
                return this;
            }

            public final Builder clearDataType() {
                copyOnWrite();
                ((UwbResult) this.instance).clearDataType();
                return this;
            }

            public final ByteString getData() {
                return ((UwbResult) this.instance).getData();
            }

            public final Builder setData(ByteString byteString) {
                copyOnWrite();
                ((UwbResult) this.instance).setData(byteString);
                return this;
            }

            public final Builder clearData() {
                copyOnWrite();
                ((UwbResult) this.instance).clearData();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UwbResult();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\n", new Object[]{"dataType_", "data_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UwbResult> parser = PARSER;
                    if (parser == null) {
                        synchronized (UwbResult.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UwbResult uwbResult = new UwbResult();
            DEFAULT_INSTANCE = uwbResult;
            GeneratedMessageLite.registerDefaultInstance(UwbResult.class, uwbResult);
        }

        public static UwbResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UwbResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class OnScanning extends GeneratedMessageLite<OnScanning, Builder> implements OnScanningOrBuilder {
        public static final OnScanning DEFAULT_INSTANCE;
        private static volatile Parser<OnScanning> PARSER;
        private Internal.ProtobufList<UwbData.MeasurementData> measurementData_ = emptyProtobufList();

        private OnScanning() {
        }

        public final List<UwbData.MeasurementData> getMeasurementDataList() {
            return this.measurementData_;
        }

        public final List<? extends UwbData.MeasurementDataOrBuilder> getMeasurementDataOrBuilderList() {
            return this.measurementData_;
        }

        public final int getMeasurementDataCount() {
            return this.measurementData_.size();
        }

        public final UwbData.MeasurementData getMeasurementData(int i) {
            return this.measurementData_.get(i);
        }

        public final UwbData.MeasurementDataOrBuilder getMeasurementDataOrBuilder(int i) {
            return this.measurementData_.get(i);
        }

        private void ensureMeasurementDataIsMutable() {
            if (!this.measurementData_.isModifiable()) {
                this.measurementData_ = GeneratedMessageLite.mutableCopy(this.measurementData_);
            }
        }

        public final void setMeasurementData(int i, UwbData.MeasurementData measurementData) {
            if (measurementData != null) {
                ensureMeasurementDataIsMutable();
                this.measurementData_.set(i, measurementData);
                return;
            }
            throw new NullPointerException();
        }

        public final void setMeasurementData(int i, UwbData.MeasurementData.Builder builder) {
            ensureMeasurementDataIsMutable();
            this.measurementData_.set(i, builder.build());
        }

        public final void addMeasurementData(UwbData.MeasurementData measurementData) {
            if (measurementData != null) {
                ensureMeasurementDataIsMutable();
                this.measurementData_.add(measurementData);
                return;
            }
            throw new NullPointerException();
        }

        public final void addMeasurementData(int i, UwbData.MeasurementData measurementData) {
            if (measurementData != null) {
                ensureMeasurementDataIsMutable();
                this.measurementData_.add(i, measurementData);
                return;
            }
            throw new NullPointerException();
        }

        public final void addMeasurementData(UwbData.MeasurementData.Builder builder) {
            ensureMeasurementDataIsMutable();
            this.measurementData_.add(builder.build());
        }

        public final void addMeasurementData(int i, UwbData.MeasurementData.Builder builder) {
            ensureMeasurementDataIsMutable();
            this.measurementData_.add(i, builder.build());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.addAll(java.lang.Iterable, java.util.List):void
         arg types: [java.lang.Iterable<? extends com.xiaomi.idm.uwb.proto.UwbData$MeasurementData>, com.google.protobuf.Internal$ProtobufList<com.xiaomi.idm.uwb.proto.UwbData$MeasurementData>]
         candidates:
          com.google.protobuf.AbstractMessageLite.addAll(java.lang.Iterable, java.util.Collection):void
          com.google.protobuf.AbstractMessageLite.addAll(java.lang.Iterable, java.util.List):void */
        public final void addAllMeasurementData(Iterable<? extends UwbData.MeasurementData> iterable) {
            ensureMeasurementDataIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.measurementData_);
        }

        public final void clearMeasurementData() {
            this.measurementData_ = emptyProtobufList();
        }

        public final void removeMeasurementData(int i) {
            ensureMeasurementDataIsMutable();
            this.measurementData_.remove(i);
        }

        public static OnScanning parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OnScanning parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OnScanning parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OnScanning parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OnScanning parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OnScanning parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OnScanning parseFrom(InputStream inputStream) throws IOException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnScanning parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnScanning parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OnScanning) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnScanning parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnScanning) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnScanning parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OnScanning parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnScanning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OnScanning onScanning) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(onScanning);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OnScanning, Builder> implements OnScanningOrBuilder {
            private Builder() {
                super(OnScanning.DEFAULT_INSTANCE);
            }

            public final List<UwbData.MeasurementData> getMeasurementDataList() {
                return Collections.unmodifiableList(((OnScanning) this.instance).getMeasurementDataList());
            }

            public final int getMeasurementDataCount() {
                return ((OnScanning) this.instance).getMeasurementDataCount();
            }

            public final UwbData.MeasurementData getMeasurementData(int i) {
                return ((OnScanning) this.instance).getMeasurementData(i);
            }

            public final Builder setMeasurementData(int i, UwbData.MeasurementData measurementData) {
                copyOnWrite();
                ((OnScanning) this.instance).setMeasurementData(i, measurementData);
                return this;
            }

            public final Builder setMeasurementData(int i, UwbData.MeasurementData.Builder builder) {
                copyOnWrite();
                ((OnScanning) this.instance).setMeasurementData(i, builder);
                return this;
            }

            public final Builder addMeasurementData(UwbData.MeasurementData measurementData) {
                copyOnWrite();
                ((OnScanning) this.instance).addMeasurementData(measurementData);
                return this;
            }

            public final Builder addMeasurementData(int i, UwbData.MeasurementData measurementData) {
                copyOnWrite();
                ((OnScanning) this.instance).addMeasurementData(i, measurementData);
                return this;
            }

            public final Builder addMeasurementData(UwbData.MeasurementData.Builder builder) {
                copyOnWrite();
                ((OnScanning) this.instance).addMeasurementData(builder);
                return this;
            }

            public final Builder addMeasurementData(int i, UwbData.MeasurementData.Builder builder) {
                copyOnWrite();
                ((OnScanning) this.instance).addMeasurementData(i, builder);
                return this;
            }

            public final Builder addAllMeasurementData(Iterable<? extends UwbData.MeasurementData> iterable) {
                copyOnWrite();
                ((OnScanning) this.instance).addAllMeasurementData(iterable);
                return this;
            }

            public final Builder clearMeasurementData() {
                copyOnWrite();
                ((OnScanning) this.instance).clearMeasurementData();
                return this;
            }

            public final Builder removeMeasurementData(int i) {
                copyOnWrite();
                ((OnScanning) this.instance).removeMeasurementData(i);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new OnScanning();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"measurementData_", UwbData.MeasurementData.class});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<OnScanning> parser = PARSER;
                    if (parser == null) {
                        synchronized (OnScanning.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            OnScanning onScanning = new OnScanning();
            DEFAULT_INSTANCE = onScanning;
            GeneratedMessageLite.registerDefaultInstance(OnScanning.class, onScanning);
        }

        public static OnScanning getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnScanning> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PayLoad extends GeneratedMessageLite<PayLoad, Builder> implements PayLoadOrBuilder {
        public static final PayLoad DEFAULT_INSTANCE;
        private static volatile Parser<PayLoad> PARSER;
        private ByteString data_ = ByteString.EMPTY;
        private int flag_;
        private String uwbAddress_ = "";

        private PayLoad() {
        }

        public final String getUwbAddress() {
            return this.uwbAddress_;
        }

        public final ByteString getUwbAddressBytes() {
            return ByteString.copyFromUtf8(this.uwbAddress_);
        }

        public final void setUwbAddress(String str) {
            if (str != null) {
                this.uwbAddress_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearUwbAddress() {
            this.uwbAddress_ = getDefaultInstance().getUwbAddress();
        }

        public final void setUwbAddressBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.uwbAddress_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final int getFlag() {
            return this.flag_;
        }

        public final void setFlag(int i) {
            this.flag_ = i;
        }

        public final void clearFlag() {
            this.flag_ = 0;
        }

        public final ByteString getData() {
            return this.data_;
        }

        public final void setData(ByteString byteString) {
            if (byteString != null) {
                this.data_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static PayLoad parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PayLoad parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PayLoad parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PayLoad parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PayLoad parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PayLoad parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PayLoad parseFrom(InputStream inputStream) throws IOException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PayLoad parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PayLoad parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PayLoad) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PayLoad parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PayLoad) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PayLoad parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PayLoad parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PayLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PayLoad payLoad) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(payLoad);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PayLoad, Builder> implements PayLoadOrBuilder {
            private Builder() {
                super(PayLoad.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((PayLoad) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((PayLoad) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((PayLoad) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((PayLoad) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((PayLoad) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final int getFlag() {
                return ((PayLoad) this.instance).getFlag();
            }

            public final Builder setFlag(int i) {
                copyOnWrite();
                ((PayLoad) this.instance).setFlag(i);
                return this;
            }

            public final Builder clearFlag() {
                copyOnWrite();
                ((PayLoad) this.instance).clearFlag();
                return this;
            }

            public final ByteString getData() {
                return ((PayLoad) this.instance).getData();
            }

            public final Builder setData(ByteString byteString) {
                copyOnWrite();
                ((PayLoad) this.instance).setData(byteString);
                return this;
            }

            public final Builder clearData() {
                copyOnWrite();
                ((PayLoad) this.instance).clearData();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new PayLoad();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\n", new Object[]{"uwbAddress_", "flag_", "data_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<PayLoad> parser = PARSER;
                    if (parser == null) {
                        synchronized (PayLoad.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PayLoad payLoad = new PayLoad();
            DEFAULT_INSTANCE = payLoad;
            GeneratedMessageLite.registerDefaultInstance(PayLoad.class, payLoad);
        }

        public static PayLoad getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PayLoad> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UwbCommandResult extends GeneratedMessageLite<UwbCommandResult, Builder> implements UwbCommandResultOrBuilder {
        public static final UwbCommandResult DEFAULT_INSTANCE;
        private static volatile Parser<UwbCommandResult> PARSER;
        private ByteString data_ = ByteString.EMPTY;
        private String name_ = "";
        private int status_;
        private String uwbAddress_ = "";

        private UwbCommandResult() {
        }

        public final String getName() {
            return this.name_;
        }

        public final ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        public final void setName(String str) {
            if (str != null) {
                this.name_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        public final void setNameBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final int getStatus() {
            return this.status_;
        }

        public final void setStatus(int i) {
            this.status_ = i;
        }

        public final void clearStatus() {
            this.status_ = 0;
        }

        public final String getUwbAddress() {
            return this.uwbAddress_;
        }

        public final ByteString getUwbAddressBytes() {
            return ByteString.copyFromUtf8(this.uwbAddress_);
        }

        public final void setUwbAddress(String str) {
            if (str != null) {
                this.uwbAddress_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearUwbAddress() {
            this.uwbAddress_ = getDefaultInstance().getUwbAddress();
        }

        public final void setUwbAddressBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.uwbAddress_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final ByteString getData() {
            return this.data_;
        }

        public final void setData(ByteString byteString) {
            if (byteString != null) {
                this.data_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static UwbCommandResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UwbCommandResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UwbCommandResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UwbCommandResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UwbCommandResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UwbCommandResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UwbCommandResult parseFrom(InputStream inputStream) throws IOException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UwbCommandResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UwbCommandResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UwbCommandResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UwbCommandResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbCommandResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UwbCommandResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UwbCommandResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UwbCommandResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UwbCommandResult uwbCommandResult) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(uwbCommandResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UwbCommandResult, Builder> implements UwbCommandResultOrBuilder {
            private Builder() {
                super(UwbCommandResult.DEFAULT_INSTANCE);
            }

            public final String getName() {
                return ((UwbCommandResult) this.instance).getName();
            }

            public final ByteString getNameBytes() {
                return ((UwbCommandResult) this.instance).getNameBytes();
            }

            public final Builder setName(String str) {
                copyOnWrite();
                ((UwbCommandResult) this.instance).setName(str);
                return this;
            }

            public final Builder clearName() {
                copyOnWrite();
                ((UwbCommandResult) this.instance).clearName();
                return this;
            }

            public final Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((UwbCommandResult) this.instance).setNameBytes(byteString);
                return this;
            }

            public final int getStatus() {
                return ((UwbCommandResult) this.instance).getStatus();
            }

            public final Builder setStatus(int i) {
                copyOnWrite();
                ((UwbCommandResult) this.instance).setStatus(i);
                return this;
            }

            public final Builder clearStatus() {
                copyOnWrite();
                ((UwbCommandResult) this.instance).clearStatus();
                return this;
            }

            public final String getUwbAddress() {
                return ((UwbCommandResult) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((UwbCommandResult) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((UwbCommandResult) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((UwbCommandResult) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((UwbCommandResult) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final ByteString getData() {
                return ((UwbCommandResult) this.instance).getData();
            }

            public final Builder setData(ByteString byteString) {
                copyOnWrite();
                ((UwbCommandResult) this.instance).setData(byteString);
                return this;
            }

            public final Builder clearData() {
                copyOnWrite();
                ((UwbCommandResult) this.instance).clearData();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UwbCommandResult();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\n", new Object[]{"name_", "status_", "uwbAddress_", "data_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UwbCommandResult> parser = PARSER;
                    if (parser == null) {
                        synchronized (UwbCommandResult.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UwbCommandResult uwbCommandResult = new UwbCommandResult();
            DEFAULT_INSTANCE = uwbCommandResult;
            GeneratedMessageLite.registerDefaultInstance(UwbCommandResult.class, uwbCommandResult);
        }

        public static UwbCommandResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UwbCommandResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class CallbackMessage extends GeneratedMessageLite<CallbackMessage, Builder> implements CallbackMessageOrBuilder {
        public static final CallbackMessage DEFAULT_INSTANCE;
        private static volatile Parser<CallbackMessage> PARSER;
        private ByteString data_ = ByteString.EMPTY;
        private String name_ = "";

        private CallbackMessage() {
        }

        public final String getName() {
            return this.name_;
        }

        public final ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        public final void setName(String str) {
            if (str != null) {
                this.name_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        public final void setNameBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final ByteString getData() {
            return this.data_;
        }

        public final void setData(ByteString byteString) {
            if (byteString != null) {
                this.data_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static CallbackMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CallbackMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CallbackMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CallbackMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CallbackMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CallbackMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CallbackMessage parseFrom(InputStream inputStream) throws IOException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CallbackMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CallbackMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CallbackMessage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CallbackMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CallbackMessage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CallbackMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CallbackMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CallbackMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CallbackMessage callbackMessage) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(callbackMessage);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CallbackMessage, Builder> implements CallbackMessageOrBuilder {
            private Builder() {
                super(CallbackMessage.DEFAULT_INSTANCE);
            }

            public final String getName() {
                return ((CallbackMessage) this.instance).getName();
            }

            public final ByteString getNameBytes() {
                return ((CallbackMessage) this.instance).getNameBytes();
            }

            public final Builder setName(String str) {
                copyOnWrite();
                ((CallbackMessage) this.instance).setName(str);
                return this;
            }

            public final Builder clearName() {
                copyOnWrite();
                ((CallbackMessage) this.instance).clearName();
                return this;
            }

            public final Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((CallbackMessage) this.instance).setNameBytes(byteString);
                return this;
            }

            public final ByteString getData() {
                return ((CallbackMessage) this.instance).getData();
            }

            public final Builder setData(ByteString byteString) {
                copyOnWrite();
                ((CallbackMessage) this.instance).setData(byteString);
                return this;
            }

            public final Builder clearData() {
                copyOnWrite();
                ((CallbackMessage) this.instance).clearData();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new CallbackMessage();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"name_", "data_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<CallbackMessage> parser = PARSER;
                    if (parser == null) {
                        synchronized (CallbackMessage.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            CallbackMessage callbackMessage = new CallbackMessage();
            DEFAULT_INSTANCE = callbackMessage;
            GeneratedMessageLite.registerDefaultInstance(CallbackMessage.class, callbackMessage);
        }

        public static CallbackMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CallbackMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
