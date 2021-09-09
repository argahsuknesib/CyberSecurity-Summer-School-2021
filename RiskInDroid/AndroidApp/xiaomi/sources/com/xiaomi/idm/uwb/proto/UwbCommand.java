package com.xiaomi.idm.uwb.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UwbCommand {

    public interface ConnectOrBuilder extends MessageLiteOrBuilder {
        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface DisconnectOrBuilder extends MessageLiteOrBuilder {
        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface EstablishSecurityLineOrBuilder extends MessageLiteOrBuilder {
        int getAppId();

        String getKey();

        ByteString getKeyBytes();

        int getMemberType();

        ByteString getUidHash();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface OnSendPayloadOrBuilder extends MessageLiteOrBuilder {
        int getTaskId();
    }

    public interface OnTagOTAOrBuilder extends MessageLiteOrBuilder {
        int getTaskId();
    }

    public interface SendPayloadOrBuilder extends MessageLiteOrBuilder {
        int getFlag();

        ByteString getPayload();

        int getTarget();

        int getTaskId();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface SetServerSecurityKeyOrBuilder extends MessageLiteOrBuilder {
        String getMemoryKey();

        ByteString getMemoryKeyBytes();

        String getStrangeKey();

        ByteString getStrangeKeyBytes();
    }

    public interface StartADVOrBuilder extends MessageLiteOrBuilder {
        int getProjectId();

        int getTimeout();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface StartScanOrBuilder extends MessageLiteOrBuilder {
        int getAppId();

        int getDeviceRole();

        int getProjectId();

        int getTimeout();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface StopUwbOrBuilder extends MessageLiteOrBuilder {
        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public interface SwitchCommunicationTypeOrBuilder extends MessageLiteOrBuilder {
        int getAppId();

        String getUwbAddress();

        ByteString getUwbAddressBytes();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private UwbCommand() {
    }

    public static final class SetServerSecurityKey extends GeneratedMessageLite<SetServerSecurityKey, Builder> implements SetServerSecurityKeyOrBuilder {
        public static final SetServerSecurityKey DEFAULT_INSTANCE;
        private static volatile Parser<SetServerSecurityKey> PARSER;
        private String memoryKey_ = "";
        private String strangeKey_ = "";

        private SetServerSecurityKey() {
        }

        public final String getMemoryKey() {
            return this.memoryKey_;
        }

        public final ByteString getMemoryKeyBytes() {
            return ByteString.copyFromUtf8(this.memoryKey_);
        }

        public final void setMemoryKey(String str) {
            if (str != null) {
                this.memoryKey_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearMemoryKey() {
            this.memoryKey_ = getDefaultInstance().getMemoryKey();
        }

        public final void setMemoryKeyBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.memoryKey_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final String getStrangeKey() {
            return this.strangeKey_;
        }

        public final ByteString getStrangeKeyBytes() {
            return ByteString.copyFromUtf8(this.strangeKey_);
        }

        public final void setStrangeKey(String str) {
            if (str != null) {
                this.strangeKey_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearStrangeKey() {
            this.strangeKey_ = getDefaultInstance().getStrangeKey();
        }

        public final void setStrangeKeyBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.strangeKey_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public static SetServerSecurityKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SetServerSecurityKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SetServerSecurityKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SetServerSecurityKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SetServerSecurityKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SetServerSecurityKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SetServerSecurityKey parseFrom(InputStream inputStream) throws IOException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetServerSecurityKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetServerSecurityKey parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SetServerSecurityKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetServerSecurityKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetServerSecurityKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetServerSecurityKey parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SetServerSecurityKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetServerSecurityKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SetServerSecurityKey setServerSecurityKey) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(setServerSecurityKey);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SetServerSecurityKey, Builder> implements SetServerSecurityKeyOrBuilder {
            private Builder() {
                super(SetServerSecurityKey.DEFAULT_INSTANCE);
            }

            public final String getMemoryKey() {
                return ((SetServerSecurityKey) this.instance).getMemoryKey();
            }

            public final ByteString getMemoryKeyBytes() {
                return ((SetServerSecurityKey) this.instance).getMemoryKeyBytes();
            }

            public final Builder setMemoryKey(String str) {
                copyOnWrite();
                ((SetServerSecurityKey) this.instance).setMemoryKey(str);
                return this;
            }

            public final Builder clearMemoryKey() {
                copyOnWrite();
                ((SetServerSecurityKey) this.instance).clearMemoryKey();
                return this;
            }

            public final Builder setMemoryKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((SetServerSecurityKey) this.instance).setMemoryKeyBytes(byteString);
                return this;
            }

            public final String getStrangeKey() {
                return ((SetServerSecurityKey) this.instance).getStrangeKey();
            }

            public final ByteString getStrangeKeyBytes() {
                return ((SetServerSecurityKey) this.instance).getStrangeKeyBytes();
            }

            public final Builder setStrangeKey(String str) {
                copyOnWrite();
                ((SetServerSecurityKey) this.instance).setStrangeKey(str);
                return this;
            }

            public final Builder clearStrangeKey() {
                copyOnWrite();
                ((SetServerSecurityKey) this.instance).clearStrangeKey();
                return this;
            }

            public final Builder setStrangeKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((SetServerSecurityKey) this.instance).setStrangeKeyBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new SetServerSecurityKey();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"memoryKey_", "strangeKey_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SetServerSecurityKey> parser = PARSER;
                    if (parser == null) {
                        synchronized (SetServerSecurityKey.class) {
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
            SetServerSecurityKey setServerSecurityKey = new SetServerSecurityKey();
            DEFAULT_INSTANCE = setServerSecurityKey;
            GeneratedMessageLite.registerDefaultInstance(SetServerSecurityKey.class, setServerSecurityKey);
        }

        public static SetServerSecurityKey getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetServerSecurityKey> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StartScan extends GeneratedMessageLite<StartScan, Builder> implements StartScanOrBuilder {
        public static final StartScan DEFAULT_INSTANCE;
        private static volatile Parser<StartScan> PARSER;
        private int appId_;
        private int deviceRole_;
        private int projectId_;
        private int timeout_;
        private String uwbAddress_ = "";

        private StartScan() {
        }

        public final int getAppId() {
            return this.appId_;
        }

        public final void setAppId(int i) {
            this.appId_ = i;
        }

        public final void clearAppId() {
            this.appId_ = 0;
        }

        public final int getDeviceRole() {
            return this.deviceRole_;
        }

        public final void setDeviceRole(int i) {
            this.deviceRole_ = i;
        }

        public final void clearDeviceRole() {
            this.deviceRole_ = 0;
        }

        public final int getProjectId() {
            return this.projectId_;
        }

        public final void setProjectId(int i) {
            this.projectId_ = i;
        }

        public final void clearProjectId() {
            this.projectId_ = 0;
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

        public final int getTimeout() {
            return this.timeout_;
        }

        public final void setTimeout(int i) {
            this.timeout_ = i;
        }

        public final void clearTimeout() {
            this.timeout_ = 0;
        }

        public static StartScan parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StartScan parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StartScan parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StartScan parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StartScan parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StartScan parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StartScan parseFrom(InputStream inputStream) throws IOException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartScan parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartScan parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StartScan) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartScan parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartScan) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartScan parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StartScan parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartScan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StartScan startScan) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(startScan);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StartScan, Builder> implements StartScanOrBuilder {
            private Builder() {
                super(StartScan.DEFAULT_INSTANCE);
            }

            public final int getAppId() {
                return ((StartScan) this.instance).getAppId();
            }

            public final Builder setAppId(int i) {
                copyOnWrite();
                ((StartScan) this.instance).setAppId(i);
                return this;
            }

            public final Builder clearAppId() {
                copyOnWrite();
                ((StartScan) this.instance).clearAppId();
                return this;
            }

            public final int getDeviceRole() {
                return ((StartScan) this.instance).getDeviceRole();
            }

            public final Builder setDeviceRole(int i) {
                copyOnWrite();
                ((StartScan) this.instance).setDeviceRole(i);
                return this;
            }

            public final Builder clearDeviceRole() {
                copyOnWrite();
                ((StartScan) this.instance).clearDeviceRole();
                return this;
            }

            public final int getProjectId() {
                return ((StartScan) this.instance).getProjectId();
            }

            public final Builder setProjectId(int i) {
                copyOnWrite();
                ((StartScan) this.instance).setProjectId(i);
                return this;
            }

            public final Builder clearProjectId() {
                copyOnWrite();
                ((StartScan) this.instance).clearProjectId();
                return this;
            }

            public final String getUwbAddress() {
                return ((StartScan) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((StartScan) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((StartScan) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((StartScan) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((StartScan) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final int getTimeout() {
                return ((StartScan) this.instance).getTimeout();
            }

            public final Builder setTimeout(int i) {
                copyOnWrite();
                ((StartScan) this.instance).setTimeout(i);
                return this;
            }

            public final Builder clearTimeout() {
                copyOnWrite();
                ((StartScan) this.instance).clearTimeout();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new StartScan();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004Ȉ\u0005\u0004", new Object[]{"appId_", "deviceRole_", "projectId_", "uwbAddress_", "timeout_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<StartScan> parser = PARSER;
                    if (parser == null) {
                        synchronized (StartScan.class) {
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
            StartScan startScan = new StartScan();
            DEFAULT_INSTANCE = startScan;
            GeneratedMessageLite.registerDefaultInstance(StartScan.class, startScan);
        }

        public static StartScan getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StartScan> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StartADV extends GeneratedMessageLite<StartADV, Builder> implements StartADVOrBuilder {
        public static final StartADV DEFAULT_INSTANCE;
        private static volatile Parser<StartADV> PARSER;
        private int projectId_;
        private int timeout_;
        private String uwbAddress_ = "";

        private StartADV() {
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

        public final int getTimeout() {
            return this.timeout_;
        }

        public final void setTimeout(int i) {
            this.timeout_ = i;
        }

        public final void clearTimeout() {
            this.timeout_ = 0;
        }

        public final int getProjectId() {
            return this.projectId_;
        }

        public final void setProjectId(int i) {
            this.projectId_ = i;
        }

        public final void clearProjectId() {
            this.projectId_ = 0;
        }

        public static StartADV parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StartADV parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StartADV parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StartADV parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StartADV parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StartADV parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StartADV parseFrom(InputStream inputStream) throws IOException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartADV parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartADV parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StartADV) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartADV parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartADV) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartADV parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StartADV parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartADV) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StartADV startADV) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(startADV);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StartADV, Builder> implements StartADVOrBuilder {
            private Builder() {
                super(StartADV.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((StartADV) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((StartADV) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((StartADV) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((StartADV) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((StartADV) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final int getTimeout() {
                return ((StartADV) this.instance).getTimeout();
            }

            public final Builder setTimeout(int i) {
                copyOnWrite();
                ((StartADV) this.instance).setTimeout(i);
                return this;
            }

            public final Builder clearTimeout() {
                copyOnWrite();
                ((StartADV) this.instance).clearTimeout();
                return this;
            }

            public final int getProjectId() {
                return ((StartADV) this.instance).getProjectId();
            }

            public final Builder setProjectId(int i) {
                copyOnWrite();
                ((StartADV) this.instance).setProjectId(i);
                return this;
            }

            public final Builder clearProjectId() {
                copyOnWrite();
                ((StartADV) this.instance).clearProjectId();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new StartADV();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004", new Object[]{"uwbAddress_", "timeout_", "projectId_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<StartADV> parser = PARSER;
                    if (parser == null) {
                        synchronized (StartADV.class) {
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
            StartADV startADV = new StartADV();
            DEFAULT_INSTANCE = startADV;
            GeneratedMessageLite.registerDefaultInstance(StartADV.class, startADV);
        }

        public static StartADV getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StartADV> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Connect extends GeneratedMessageLite<Connect, Builder> implements ConnectOrBuilder {
        public static final Connect DEFAULT_INSTANCE;
        private static volatile Parser<Connect> PARSER;
        private String uwbAddress_ = "";

        private Connect() {
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

        public static Connect parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Connect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Connect parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Connect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Connect parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Connect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Connect parseFrom(InputStream inputStream) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Connect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Connect parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Connect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Connect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Connect parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Connect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Connect connect) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(connect);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Connect, Builder> implements ConnectOrBuilder {
            private Builder() {
                super(Connect.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((Connect) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((Connect) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((Connect) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((Connect) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((Connect) this.instance).setUwbAddressBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new Connect();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"uwbAddress_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Connect> parser = PARSER;
                    if (parser == null) {
                        synchronized (Connect.class) {
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
            Connect connect = new Connect();
            DEFAULT_INSTANCE = connect;
            GeneratedMessageLite.registerDefaultInstance(Connect.class, connect);
        }

        public static Connect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Connect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Disconnect extends GeneratedMessageLite<Disconnect, Builder> implements DisconnectOrBuilder {
        public static final Disconnect DEFAULT_INSTANCE;
        private static volatile Parser<Disconnect> PARSER;
        private String uwbAddress_ = "";

        private Disconnect() {
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

        public static Disconnect parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Disconnect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Disconnect parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Disconnect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Disconnect parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Disconnect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Disconnect parseFrom(InputStream inputStream) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Disconnect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Disconnect parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Disconnect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Disconnect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Disconnect parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Disconnect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Disconnect disconnect) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(disconnect);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Disconnect, Builder> implements DisconnectOrBuilder {
            private Builder() {
                super(Disconnect.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((Disconnect) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((Disconnect) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((Disconnect) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((Disconnect) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((Disconnect) this.instance).setUwbAddressBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new Disconnect();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"uwbAddress_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Disconnect> parser = PARSER;
                    if (parser == null) {
                        synchronized (Disconnect.class) {
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
            Disconnect disconnect = new Disconnect();
            DEFAULT_INSTANCE = disconnect;
            GeneratedMessageLite.registerDefaultInstance(Disconnect.class, disconnect);
        }

        public static Disconnect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Disconnect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SendPayload extends GeneratedMessageLite<SendPayload, Builder> implements SendPayloadOrBuilder {
        public static final SendPayload DEFAULT_INSTANCE;
        private static volatile Parser<SendPayload> PARSER;
        private int flag_;
        private ByteString payload_ = ByteString.EMPTY;
        private int target_;
        private int taskId_;
        private String uwbAddress_ = "";

        private SendPayload() {
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

        public final ByteString getPayload() {
            return this.payload_;
        }

        public final void setPayload(ByteString byteString) {
            if (byteString != null) {
                this.payload_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearPayload() {
            this.payload_ = getDefaultInstance().getPayload();
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

        public final int getTarget() {
            return this.target_;
        }

        public final void setTarget(int i) {
            this.target_ = i;
        }

        public final void clearTarget() {
            this.target_ = 0;
        }

        public final int getTaskId() {
            return this.taskId_;
        }

        public final void setTaskId(int i) {
            this.taskId_ = i;
        }

        public final void clearTaskId() {
            this.taskId_ = 0;
        }

        public static SendPayload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SendPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SendPayload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SendPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SendPayload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SendPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SendPayload parseFrom(InputStream inputStream) throws IOException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SendPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SendPayload parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SendPayload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SendPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendPayload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SendPayload parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SendPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SendPayload sendPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(sendPayload);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SendPayload, Builder> implements SendPayloadOrBuilder {
            private Builder() {
                super(SendPayload.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((SendPayload) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((SendPayload) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((SendPayload) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((SendPayload) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((SendPayload) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final ByteString getPayload() {
                return ((SendPayload) this.instance).getPayload();
            }

            public final Builder setPayload(ByteString byteString) {
                copyOnWrite();
                ((SendPayload) this.instance).setPayload(byteString);
                return this;
            }

            public final Builder clearPayload() {
                copyOnWrite();
                ((SendPayload) this.instance).clearPayload();
                return this;
            }

            public final int getFlag() {
                return ((SendPayload) this.instance).getFlag();
            }

            public final Builder setFlag(int i) {
                copyOnWrite();
                ((SendPayload) this.instance).setFlag(i);
                return this;
            }

            public final Builder clearFlag() {
                copyOnWrite();
                ((SendPayload) this.instance).clearFlag();
                return this;
            }

            public final int getTarget() {
                return ((SendPayload) this.instance).getTarget();
            }

            public final Builder setTarget(int i) {
                copyOnWrite();
                ((SendPayload) this.instance).setTarget(i);
                return this;
            }

            public final Builder clearTarget() {
                copyOnWrite();
                ((SendPayload) this.instance).clearTarget();
                return this;
            }

            public final int getTaskId() {
                return ((SendPayload) this.instance).getTaskId();
            }

            public final Builder setTaskId(int i) {
                copyOnWrite();
                ((SendPayload) this.instance).setTaskId(i);
                return this;
            }

            public final Builder clearTaskId() {
                copyOnWrite();
                ((SendPayload) this.instance).clearTaskId();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new SendPayload();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\u0004\u0004\u0004\u0005\u0004", new Object[]{"uwbAddress_", "payload_", "flag_", "target_", "taskId_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SendPayload> parser = PARSER;
                    if (parser == null) {
                        synchronized (SendPayload.class) {
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
            SendPayload sendPayload = new SendPayload();
            DEFAULT_INSTANCE = sendPayload;
            GeneratedMessageLite.registerDefaultInstance(SendPayload.class, sendPayload);
        }

        public static SendPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SendPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EstablishSecurityLine extends GeneratedMessageLite<EstablishSecurityLine, Builder> implements EstablishSecurityLineOrBuilder {
        public static final EstablishSecurityLine DEFAULT_INSTANCE;
        private static volatile Parser<EstablishSecurityLine> PARSER;
        private int appId_;
        private String key_ = "";
        private int memberType_;
        private ByteString uidHash_ = ByteString.EMPTY;
        private String uwbAddress_ = "";

        private EstablishSecurityLine() {
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

        public final String getKey() {
            return this.key_;
        }

        public final ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        public final void setKey(String str) {
            if (str != null) {
                this.key_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        public final void setKeyBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.key_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final ByteString getUidHash() {
            return this.uidHash_;
        }

        public final void setUidHash(ByteString byteString) {
            if (byteString != null) {
                this.uidHash_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearUidHash() {
            this.uidHash_ = getDefaultInstance().getUidHash();
        }

        public final int getMemberType() {
            return this.memberType_;
        }

        public final void setMemberType(int i) {
            this.memberType_ = i;
        }

        public final void clearMemberType() {
            this.memberType_ = 0;
        }

        public final int getAppId() {
            return this.appId_;
        }

        public final void setAppId(int i) {
            this.appId_ = i;
        }

        public final void clearAppId() {
            this.appId_ = 0;
        }

        public static EstablishSecurityLine parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EstablishSecurityLine parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EstablishSecurityLine parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EstablishSecurityLine parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EstablishSecurityLine parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EstablishSecurityLine parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EstablishSecurityLine parseFrom(InputStream inputStream) throws IOException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EstablishSecurityLine parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EstablishSecurityLine parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EstablishSecurityLine) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EstablishSecurityLine parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EstablishSecurityLine) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EstablishSecurityLine parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EstablishSecurityLine parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EstablishSecurityLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EstablishSecurityLine establishSecurityLine) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(establishSecurityLine);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EstablishSecurityLine, Builder> implements EstablishSecurityLineOrBuilder {
            private Builder() {
                super(EstablishSecurityLine.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((EstablishSecurityLine) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((EstablishSecurityLine) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final String getKey() {
                return ((EstablishSecurityLine) this.instance).getKey();
            }

            public final ByteString getKeyBytes() {
                return ((EstablishSecurityLine) this.instance).getKeyBytes();
            }

            public final Builder setKey(String str) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setKey(str);
                return this;
            }

            public final Builder clearKey() {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).clearKey();
                return this;
            }

            public final Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setKeyBytes(byteString);
                return this;
            }

            public final ByteString getUidHash() {
                return ((EstablishSecurityLine) this.instance).getUidHash();
            }

            public final Builder setUidHash(ByteString byteString) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setUidHash(byteString);
                return this;
            }

            public final Builder clearUidHash() {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).clearUidHash();
                return this;
            }

            public final int getMemberType() {
                return ((EstablishSecurityLine) this.instance).getMemberType();
            }

            public final Builder setMemberType(int i) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setMemberType(i);
                return this;
            }

            public final Builder clearMemberType() {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).clearMemberType();
                return this;
            }

            public final int getAppId() {
                return ((EstablishSecurityLine) this.instance).getAppId();
            }

            public final Builder setAppId(int i) {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).setAppId(i);
                return this;
            }

            public final Builder clearAppId() {
                copyOnWrite();
                ((EstablishSecurityLine) this.instance).clearAppId();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new EstablishSecurityLine();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\n\u0004\u0004\u0005\u0004", new Object[]{"uwbAddress_", "key_", "uidHash_", "memberType_", "appId_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<EstablishSecurityLine> parser = PARSER;
                    if (parser == null) {
                        synchronized (EstablishSecurityLine.class) {
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
            EstablishSecurityLine establishSecurityLine = new EstablishSecurityLine();
            DEFAULT_INSTANCE = establishSecurityLine;
            GeneratedMessageLite.registerDefaultInstance(EstablishSecurityLine.class, establishSecurityLine);
        }

        public static EstablishSecurityLine getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EstablishSecurityLine> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StopUwb extends GeneratedMessageLite<StopUwb, Builder> implements StopUwbOrBuilder {
        public static final StopUwb DEFAULT_INSTANCE;
        private static volatile Parser<StopUwb> PARSER;
        private String uwbAddress_ = "";

        private StopUwb() {
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

        public static StopUwb parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StopUwb parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StopUwb parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StopUwb parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StopUwb parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StopUwb parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StopUwb parseFrom(InputStream inputStream) throws IOException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StopUwb parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StopUwb parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StopUwb) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StopUwb parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopUwb) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StopUwb parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StopUwb parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopUwb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StopUwb stopUwb) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(stopUwb);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StopUwb, Builder> implements StopUwbOrBuilder {
            private Builder() {
                super(StopUwb.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((StopUwb) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((StopUwb) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((StopUwb) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((StopUwb) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((StopUwb) this.instance).setUwbAddressBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new StopUwb();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"uwbAddress_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<StopUwb> parser = PARSER;
                    if (parser == null) {
                        synchronized (StopUwb.class) {
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
            StopUwb stopUwb = new StopUwb();
            DEFAULT_INSTANCE = stopUwb;
            GeneratedMessageLite.registerDefaultInstance(StopUwb.class, stopUwb);
        }

        public static StopUwb getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StopUwb> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SwitchCommunicationType extends GeneratedMessageLite<SwitchCommunicationType, Builder> implements SwitchCommunicationTypeOrBuilder {
        public static final SwitchCommunicationType DEFAULT_INSTANCE;
        private static volatile Parser<SwitchCommunicationType> PARSER;
        private int appId_;
        private String uwbAddress_ = "";

        private SwitchCommunicationType() {
        }

        public final int getAppId() {
            return this.appId_;
        }

        public final void setAppId(int i) {
            this.appId_ = i;
        }

        public final void clearAppId() {
            this.appId_ = 0;
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

        public static SwitchCommunicationType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SwitchCommunicationType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SwitchCommunicationType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SwitchCommunicationType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SwitchCommunicationType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SwitchCommunicationType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SwitchCommunicationType parseFrom(InputStream inputStream) throws IOException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SwitchCommunicationType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SwitchCommunicationType parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SwitchCommunicationType) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SwitchCommunicationType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SwitchCommunicationType) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SwitchCommunicationType parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SwitchCommunicationType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SwitchCommunicationType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SwitchCommunicationType switchCommunicationType) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(switchCommunicationType);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SwitchCommunicationType, Builder> implements SwitchCommunicationTypeOrBuilder {
            private Builder() {
                super(SwitchCommunicationType.DEFAULT_INSTANCE);
            }

            public final int getAppId() {
                return ((SwitchCommunicationType) this.instance).getAppId();
            }

            public final Builder setAppId(int i) {
                copyOnWrite();
                ((SwitchCommunicationType) this.instance).setAppId(i);
                return this;
            }

            public final Builder clearAppId() {
                copyOnWrite();
                ((SwitchCommunicationType) this.instance).clearAppId();
                return this;
            }

            public final String getUwbAddress() {
                return ((SwitchCommunicationType) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((SwitchCommunicationType) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((SwitchCommunicationType) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((SwitchCommunicationType) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((SwitchCommunicationType) this.instance).setUwbAddressBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new SwitchCommunicationType();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"appId_", "uwbAddress_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SwitchCommunicationType> parser = PARSER;
                    if (parser == null) {
                        synchronized (SwitchCommunicationType.class) {
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
            SwitchCommunicationType switchCommunicationType = new SwitchCommunicationType();
            DEFAULT_INSTANCE = switchCommunicationType;
            GeneratedMessageLite.registerDefaultInstance(SwitchCommunicationType.class, switchCommunicationType);
        }

        public static SwitchCommunicationType getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SwitchCommunicationType> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class OnSendPayload extends GeneratedMessageLite<OnSendPayload, Builder> implements OnSendPayloadOrBuilder {
        public static final OnSendPayload DEFAULT_INSTANCE;
        private static volatile Parser<OnSendPayload> PARSER;
        private int taskId_;

        private OnSendPayload() {
        }

        public final int getTaskId() {
            return this.taskId_;
        }

        public final void setTaskId(int i) {
            this.taskId_ = i;
        }

        public final void clearTaskId() {
            this.taskId_ = 0;
        }

        public static OnSendPayload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OnSendPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OnSendPayload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OnSendPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OnSendPayload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OnSendPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OnSendPayload parseFrom(InputStream inputStream) throws IOException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnSendPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnSendPayload parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OnSendPayload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnSendPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnSendPayload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnSendPayload parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OnSendPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnSendPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OnSendPayload onSendPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(onSendPayload);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OnSendPayload, Builder> implements OnSendPayloadOrBuilder {
            private Builder() {
                super(OnSendPayload.DEFAULT_INSTANCE);
            }

            public final int getTaskId() {
                return ((OnSendPayload) this.instance).getTaskId();
            }

            public final Builder setTaskId(int i) {
                copyOnWrite();
                ((OnSendPayload) this.instance).setTaskId(i);
                return this;
            }

            public final Builder clearTaskId() {
                copyOnWrite();
                ((OnSendPayload) this.instance).clearTaskId();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new OnSendPayload();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"taskId_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<OnSendPayload> parser = PARSER;
                    if (parser == null) {
                        synchronized (OnSendPayload.class) {
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
            OnSendPayload onSendPayload = new OnSendPayload();
            DEFAULT_INSTANCE = onSendPayload;
            GeneratedMessageLite.registerDefaultInstance(OnSendPayload.class, onSendPayload);
        }

        public static OnSendPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnSendPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class OnTagOTA extends GeneratedMessageLite<OnTagOTA, Builder> implements OnTagOTAOrBuilder {
        public static final OnTagOTA DEFAULT_INSTANCE;
        private static volatile Parser<OnTagOTA> PARSER;
        private int taskId_;

        private OnTagOTA() {
        }

        public final int getTaskId() {
            return this.taskId_;
        }

        public final void setTaskId(int i) {
            this.taskId_ = i;
        }

        public final void clearTaskId() {
            this.taskId_ = 0;
        }

        public static OnTagOTA parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OnTagOTA parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OnTagOTA parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OnTagOTA parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OnTagOTA parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OnTagOTA parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OnTagOTA parseFrom(InputStream inputStream) throws IOException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnTagOTA parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnTagOTA parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OnTagOTA) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnTagOTA parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnTagOTA) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnTagOTA parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OnTagOTA parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnTagOTA) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OnTagOTA onTagOTA) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(onTagOTA);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OnTagOTA, Builder> implements OnTagOTAOrBuilder {
            private Builder() {
                super(OnTagOTA.DEFAULT_INSTANCE);
            }

            public final int getTaskId() {
                return ((OnTagOTA) this.instance).getTaskId();
            }

            public final Builder setTaskId(int i) {
                copyOnWrite();
                ((OnTagOTA) this.instance).setTaskId(i);
                return this;
            }

            public final Builder clearTaskId() {
                copyOnWrite();
                ((OnTagOTA) this.instance).clearTaskId();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new OnTagOTA();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"taskId_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<OnTagOTA> parser = PARSER;
                    if (parser == null) {
                        synchronized (OnTagOTA.class) {
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
            OnTagOTA onTagOTA = new OnTagOTA();
            DEFAULT_INSTANCE = onTagOTA;
            GeneratedMessageLite.registerDefaultInstance(OnTagOTA.class, onTagOTA);
        }

        public static OnTagOTA getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnTagOTA> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
