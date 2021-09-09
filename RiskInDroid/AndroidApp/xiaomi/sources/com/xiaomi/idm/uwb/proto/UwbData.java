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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class UwbData {

    public interface DeviceStateOrBuilder extends MessageLiteOrBuilder {
        int getAuthorization();

        int getBinding();

        int getIdmSupport();

        int getMiLinkSupport();

        int getOccupied();

        int getReset();

        int getTvPlazaMode();

        int getTvScreenOff();
    }

    public interface FrameDataOrBuilder extends MessageLiteOrBuilder {
        String getAddress();

        ByteString getAddressBytes();

        ByteString getData();

        int getTaskId();
    }

    public interface MeasurementDataOrBuilder extends MessageLiteOrBuilder {
        ByteString getAccountInfo();

        int getAltitudeAoa();

        int getAzimuthAoa();

        String getBleAddress();

        ByteString getBleAddressBytes();

        DeviceState getDeviceState();

        int getDeviceType();

        ByteString getDidInfo();

        long getDistance();

        ByteString getIdmIdHash();

        ByteString getMacAddress();

        long getPid();

        int getRssi();

        TagState getTagState();

        ByteString getTvMacInfo();

        String getUwbAddress();

        ByteString getUwbAddressBytes();

        boolean hasDeviceState();

        boolean hasTagState();
    }

    public interface TagConnectionsOrBuilder extends MessageLiteOrBuilder {
        String getUwbAddress(int i);

        ByteString getUwbAddressBytes(int i);

        int getUwbAddressCount();

        List<String> getUwbAddressList();
    }

    public interface TagInfoOrBuilder extends MessageLiteOrBuilder {
        String getDid();

        ByteString getDidBytes();

        String getMod();

        ByteString getModBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    public interface TagStateOrBuilder extends MessageLiteOrBuilder {
        int getAssociationStatus();

        int getHid();

        int getIdmSupport();

        int getMiLinkSupport();

        int getPower();

        int getShutDown();

        ByteString getTvAccountInfo();

        int getTvAuthorization();

        int getTvMode();

        int getTvScreenOff();

        int getUsb();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private UwbData() {
    }

    public static final class TagInfo extends GeneratedMessageLite<TagInfo, Builder> implements TagInfoOrBuilder {
        public static final TagInfo DEFAULT_INSTANCE;
        private static volatile Parser<TagInfo> PARSER;
        private String did_ = "";
        private String mod_ = "";
        private String version_ = "";

        private TagInfo() {
        }

        public final String getVersion() {
            return this.version_;
        }

        public final ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        public final void setVersion(String str) {
            if (str != null) {
                this.version_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        public final void setVersionBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.version_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final String getDid() {
            return this.did_;
        }

        public final ByteString getDidBytes() {
            return ByteString.copyFromUtf8(this.did_);
        }

        public final void setDid(String str) {
            if (str != null) {
                this.did_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearDid() {
            this.did_ = getDefaultInstance().getDid();
        }

        public final void setDidBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.did_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final String getMod() {
            return this.mod_;
        }

        public final ByteString getModBytes() {
            return ByteString.copyFromUtf8(this.mod_);
        }

        public final void setMod(String str) {
            if (str != null) {
                this.mod_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearMod() {
            this.mod_ = getDefaultInstance().getMod();
        }

        public final void setModBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.mod_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public static TagInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TagInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TagInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TagInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TagInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TagInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TagInfo parseFrom(InputStream inputStream) throws IOException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TagInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TagInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TagInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TagInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TagInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TagInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TagInfo tagInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(tagInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TagInfo, Builder> implements TagInfoOrBuilder {
            private Builder() {
                super(TagInfo.DEFAULT_INSTANCE);
            }

            public final String getVersion() {
                return ((TagInfo) this.instance).getVersion();
            }

            public final ByteString getVersionBytes() {
                return ((TagInfo) this.instance).getVersionBytes();
            }

            public final Builder setVersion(String str) {
                copyOnWrite();
                ((TagInfo) this.instance).setVersion(str);
                return this;
            }

            public final Builder clearVersion() {
                copyOnWrite();
                ((TagInfo) this.instance).clearVersion();
                return this;
            }

            public final Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((TagInfo) this.instance).setVersionBytes(byteString);
                return this;
            }

            public final String getDid() {
                return ((TagInfo) this.instance).getDid();
            }

            public final ByteString getDidBytes() {
                return ((TagInfo) this.instance).getDidBytes();
            }

            public final Builder setDid(String str) {
                copyOnWrite();
                ((TagInfo) this.instance).setDid(str);
                return this;
            }

            public final Builder clearDid() {
                copyOnWrite();
                ((TagInfo) this.instance).clearDid();
                return this;
            }

            public final Builder setDidBytes(ByteString byteString) {
                copyOnWrite();
                ((TagInfo) this.instance).setDidBytes(byteString);
                return this;
            }

            public final String getMod() {
                return ((TagInfo) this.instance).getMod();
            }

            public final ByteString getModBytes() {
                return ((TagInfo) this.instance).getModBytes();
            }

            public final Builder setMod(String str) {
                copyOnWrite();
                ((TagInfo) this.instance).setMod(str);
                return this;
            }

            public final Builder clearMod() {
                copyOnWrite();
                ((TagInfo) this.instance).clearMod();
                return this;
            }

            public final Builder setModBytes(ByteString byteString) {
                copyOnWrite();
                ((TagInfo) this.instance).setModBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new TagInfo();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"version_", "did_", "mod_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<TagInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (TagInfo.class) {
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
            TagInfo tagInfo = new TagInfo();
            DEFAULT_INSTANCE = tagInfo;
            GeneratedMessageLite.registerDefaultInstance(TagInfo.class, tagInfo);
        }

        public static TagInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TagInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class TagConnections extends GeneratedMessageLite<TagConnections, Builder> implements TagConnectionsOrBuilder {
        public static final TagConnections DEFAULT_INSTANCE;
        private static volatile Parser<TagConnections> PARSER;
        private Internal.ProtobufList<String> uwbAddress_ = GeneratedMessageLite.emptyProtobufList();

        private TagConnections() {
        }

        public final List<String> getUwbAddressList() {
            return this.uwbAddress_;
        }

        public final int getUwbAddressCount() {
            return this.uwbAddress_.size();
        }

        public final String getUwbAddress(int i) {
            return this.uwbAddress_.get(i);
        }

        public final ByteString getUwbAddressBytes(int i) {
            return ByteString.copyFromUtf8(this.uwbAddress_.get(i));
        }

        private void ensureUwbAddressIsMutable() {
            if (!this.uwbAddress_.isModifiable()) {
                this.uwbAddress_ = GeneratedMessageLite.mutableCopy(this.uwbAddress_);
            }
        }

        public final void setUwbAddress(int i, String str) {
            if (str != null) {
                ensureUwbAddressIsMutable();
                this.uwbAddress_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        public final void addUwbAddress(String str) {
            if (str != null) {
                ensureUwbAddressIsMutable();
                this.uwbAddress_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.addAll(java.lang.Iterable, java.util.List):void
         arg types: [java.lang.Iterable<java.lang.String>, com.google.protobuf.Internal$ProtobufList<java.lang.String>]
         candidates:
          com.google.protobuf.AbstractMessageLite.addAll(java.lang.Iterable, java.util.Collection):void
          com.google.protobuf.AbstractMessageLite.addAll(java.lang.Iterable, java.util.List):void */
        public final void addAllUwbAddress(Iterable<String> iterable) {
            ensureUwbAddressIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uwbAddress_);
        }

        public final void clearUwbAddress() {
            this.uwbAddress_ = GeneratedMessageLite.emptyProtobufList();
        }

        public final void addUwbAddressBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                ensureUwbAddressIsMutable();
                this.uwbAddress_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public static TagConnections parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TagConnections parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TagConnections parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TagConnections parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TagConnections parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TagConnections parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TagConnections parseFrom(InputStream inputStream) throws IOException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TagConnections parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TagConnections parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TagConnections) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TagConnections parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagConnections) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TagConnections parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TagConnections parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagConnections) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TagConnections tagConnections) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(tagConnections);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TagConnections, Builder> implements TagConnectionsOrBuilder {
            private Builder() {
                super(TagConnections.DEFAULT_INSTANCE);
            }

            public final List<String> getUwbAddressList() {
                return Collections.unmodifiableList(((TagConnections) this.instance).getUwbAddressList());
            }

            public final int getUwbAddressCount() {
                return ((TagConnections) this.instance).getUwbAddressCount();
            }

            public final String getUwbAddress(int i) {
                return ((TagConnections) this.instance).getUwbAddress(i);
            }

            public final ByteString getUwbAddressBytes(int i) {
                return ((TagConnections) this.instance).getUwbAddressBytes(i);
            }

            public final Builder setUwbAddress(int i, String str) {
                copyOnWrite();
                ((TagConnections) this.instance).setUwbAddress(i, str);
                return this;
            }

            public final Builder addUwbAddress(String str) {
                copyOnWrite();
                ((TagConnections) this.instance).addUwbAddress(str);
                return this;
            }

            public final Builder addAllUwbAddress(Iterable<String> iterable) {
                copyOnWrite();
                ((TagConnections) this.instance).addAllUwbAddress(iterable);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((TagConnections) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder addUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((TagConnections) this.instance).addUwbAddressBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new TagConnections();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"uwbAddress_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<TagConnections> parser = PARSER;
                    if (parser == null) {
                        synchronized (TagConnections.class) {
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
            TagConnections tagConnections = new TagConnections();
            DEFAULT_INSTANCE = tagConnections;
            GeneratedMessageLite.registerDefaultInstance(TagConnections.class, tagConnections);
        }

        public static TagConnections getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TagConnections> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MeasurementData extends GeneratedMessageLite<MeasurementData, Builder> implements MeasurementDataOrBuilder {
        public static final MeasurementData DEFAULT_INSTANCE;
        private static volatile Parser<MeasurementData> PARSER;
        private ByteString accountInfo_ = ByteString.EMPTY;
        private int altitudeAoa_;
        private int azimuthAoa_;
        private String bleAddress_ = "";
        private DeviceState deviceState_;
        private int deviceType_;
        private ByteString didInfo_ = ByteString.EMPTY;
        private long distance_;
        private ByteString idmIdHash_ = ByteString.EMPTY;
        private ByteString macAddress_ = ByteString.EMPTY;
        private long pid_;
        private int rssi_;
        private TagState tagState_;
        private ByteString tvMacInfo_ = ByteString.EMPTY;
        private String uwbAddress_ = "";

        private MeasurementData() {
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

        public final long getDistance() {
            return this.distance_;
        }

        public final void setDistance(long j) {
            this.distance_ = j;
        }

        public final void clearDistance() {
            this.distance_ = 0;
        }

        public final int getAltitudeAoa() {
            return this.altitudeAoa_;
        }

        public final void setAltitudeAoa(int i) {
            this.altitudeAoa_ = i;
        }

        public final void clearAltitudeAoa() {
            this.altitudeAoa_ = 0;
        }

        public final int getAzimuthAoa() {
            return this.azimuthAoa_;
        }

        public final void setAzimuthAoa(int i) {
            this.azimuthAoa_ = i;
        }

        public final void clearAzimuthAoa() {
            this.azimuthAoa_ = 0;
        }

        public final int getRssi() {
            return this.rssi_;
        }

        public final void setRssi(int i) {
            this.rssi_ = i;
        }

        public final void clearRssi() {
            this.rssi_ = 0;
        }

        public final int getDeviceType() {
            return this.deviceType_;
        }

        public final void setDeviceType(int i) {
            this.deviceType_ = i;
        }

        public final void clearDeviceType() {
            this.deviceType_ = 0;
        }

        public final long getPid() {
            return this.pid_;
        }

        public final void setPid(long j) {
            this.pid_ = j;
        }

        public final void clearPid() {
            this.pid_ = 0;
        }

        public final boolean hasTagState() {
            return this.tagState_ != null;
        }

        public final TagState getTagState() {
            TagState tagState = this.tagState_;
            return tagState == null ? TagState.getDefaultInstance() : tagState;
        }

        public final void setTagState(TagState tagState) {
            if (tagState != null) {
                this.tagState_ = tagState;
                return;
            }
            throw new NullPointerException();
        }

        public final void setTagState(TagState.Builder builder) {
            this.tagState_ = (TagState) builder.build();
        }

        public final void mergeTagState(TagState tagState) {
            if (tagState != null) {
                TagState tagState2 = this.tagState_;
                if (tagState2 == null || tagState2 == TagState.getDefaultInstance()) {
                    this.tagState_ = tagState;
                } else {
                    this.tagState_ = (TagState) ((TagState.Builder) TagState.newBuilder(this.tagState_).mergeFrom((GeneratedMessageLite) tagState)).buildPartial();
                }
            } else {
                throw new NullPointerException();
            }
        }

        public final void clearTagState() {
            this.tagState_ = null;
        }

        public final ByteString getIdmIdHash() {
            return this.idmIdHash_;
        }

        public final void setIdmIdHash(ByteString byteString) {
            if (byteString != null) {
                this.idmIdHash_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearIdmIdHash() {
            this.idmIdHash_ = getDefaultInstance().getIdmIdHash();
        }

        public final ByteString getDidInfo() {
            return this.didInfo_;
        }

        public final void setDidInfo(ByteString byteString) {
            if (byteString != null) {
                this.didInfo_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearDidInfo() {
            this.didInfo_ = getDefaultInstance().getDidInfo();
        }

        public final ByteString getAccountInfo() {
            return this.accountInfo_;
        }

        public final void setAccountInfo(ByteString byteString) {
            if (byteString != null) {
                this.accountInfo_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearAccountInfo() {
            this.accountInfo_ = getDefaultInstance().getAccountInfo();
        }

        public final ByteString getMacAddress() {
            return this.macAddress_;
        }

        public final void setMacAddress(ByteString byteString) {
            if (byteString != null) {
                this.macAddress_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearMacAddress() {
            this.macAddress_ = getDefaultInstance().getMacAddress();
        }

        public final boolean hasDeviceState() {
            return this.deviceState_ != null;
        }

        public final DeviceState getDeviceState() {
            DeviceState deviceState = this.deviceState_;
            return deviceState == null ? DeviceState.getDefaultInstance() : deviceState;
        }

        public final void setDeviceState(DeviceState deviceState) {
            if (deviceState != null) {
                this.deviceState_ = deviceState;
                return;
            }
            throw new NullPointerException();
        }

        public final void setDeviceState(DeviceState.Builder builder) {
            this.deviceState_ = (DeviceState) builder.build();
        }

        public final void mergeDeviceState(DeviceState deviceState) {
            if (deviceState != null) {
                DeviceState deviceState2 = this.deviceState_;
                if (deviceState2 == null || deviceState2 == DeviceState.getDefaultInstance()) {
                    this.deviceState_ = deviceState;
                } else {
                    this.deviceState_ = (DeviceState) ((DeviceState.Builder) DeviceState.newBuilder(this.deviceState_).mergeFrom((GeneratedMessageLite) deviceState)).buildPartial();
                }
            } else {
                throw new NullPointerException();
            }
        }

        public final void clearDeviceState() {
            this.deviceState_ = null;
        }

        public final String getBleAddress() {
            return this.bleAddress_;
        }

        public final ByteString getBleAddressBytes() {
            return ByteString.copyFromUtf8(this.bleAddress_);
        }

        public final void setBleAddress(String str) {
            if (str != null) {
                this.bleAddress_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearBleAddress() {
            this.bleAddress_ = getDefaultInstance().getBleAddress();
        }

        public final void setBleAddressBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.bleAddress_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public final ByteString getTvMacInfo() {
            return this.tvMacInfo_;
        }

        public final void setTvMacInfo(ByteString byteString) {
            if (byteString != null) {
                this.tvMacInfo_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearTvMacInfo() {
            this.tvMacInfo_ = getDefaultInstance().getTvMacInfo();
        }

        public static MeasurementData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MeasurementData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MeasurementData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MeasurementData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MeasurementData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MeasurementData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MeasurementData parseFrom(InputStream inputStream) throws IOException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MeasurementData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MeasurementData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MeasurementData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MeasurementData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MeasurementData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MeasurementData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MeasurementData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MeasurementData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MeasurementData measurementData) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(measurementData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MeasurementData, Builder> implements MeasurementDataOrBuilder {
            private Builder() {
                super(MeasurementData.DEFAULT_INSTANCE);
            }

            public final String getUwbAddress() {
                return ((MeasurementData) this.instance).getUwbAddress();
            }

            public final ByteString getUwbAddressBytes() {
                return ((MeasurementData) this.instance).getUwbAddressBytes();
            }

            public final Builder setUwbAddress(String str) {
                copyOnWrite();
                ((MeasurementData) this.instance).setUwbAddress(str);
                return this;
            }

            public final Builder clearUwbAddress() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearUwbAddress();
                return this;
            }

            public final Builder setUwbAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setUwbAddressBytes(byteString);
                return this;
            }

            public final long getDistance() {
                return ((MeasurementData) this.instance).getDistance();
            }

            public final Builder setDistance(long j) {
                copyOnWrite();
                ((MeasurementData) this.instance).setDistance(j);
                return this;
            }

            public final Builder clearDistance() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearDistance();
                return this;
            }

            public final int getAltitudeAoa() {
                return ((MeasurementData) this.instance).getAltitudeAoa();
            }

            public final Builder setAltitudeAoa(int i) {
                copyOnWrite();
                ((MeasurementData) this.instance).setAltitudeAoa(i);
                return this;
            }

            public final Builder clearAltitudeAoa() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearAltitudeAoa();
                return this;
            }

            public final int getAzimuthAoa() {
                return ((MeasurementData) this.instance).getAzimuthAoa();
            }

            public final Builder setAzimuthAoa(int i) {
                copyOnWrite();
                ((MeasurementData) this.instance).setAzimuthAoa(i);
                return this;
            }

            public final Builder clearAzimuthAoa() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearAzimuthAoa();
                return this;
            }

            public final int getRssi() {
                return ((MeasurementData) this.instance).getRssi();
            }

            public final Builder setRssi(int i) {
                copyOnWrite();
                ((MeasurementData) this.instance).setRssi(i);
                return this;
            }

            public final Builder clearRssi() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearRssi();
                return this;
            }

            public final int getDeviceType() {
                return ((MeasurementData) this.instance).getDeviceType();
            }

            public final Builder setDeviceType(int i) {
                copyOnWrite();
                ((MeasurementData) this.instance).setDeviceType(i);
                return this;
            }

            public final Builder clearDeviceType() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearDeviceType();
                return this;
            }

            public final long getPid() {
                return ((MeasurementData) this.instance).getPid();
            }

            public final Builder setPid(long j) {
                copyOnWrite();
                ((MeasurementData) this.instance).setPid(j);
                return this;
            }

            public final Builder clearPid() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearPid();
                return this;
            }

            public final boolean hasTagState() {
                return ((MeasurementData) this.instance).hasTagState();
            }

            public final TagState getTagState() {
                return ((MeasurementData) this.instance).getTagState();
            }

            public final Builder setTagState(TagState tagState) {
                copyOnWrite();
                ((MeasurementData) this.instance).setTagState(tagState);
                return this;
            }

            public final Builder setTagState(TagState.Builder builder) {
                copyOnWrite();
                ((MeasurementData) this.instance).setTagState(builder);
                return this;
            }

            public final Builder mergeTagState(TagState tagState) {
                copyOnWrite();
                ((MeasurementData) this.instance).mergeTagState(tagState);
                return this;
            }

            public final Builder clearTagState() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearTagState();
                return this;
            }

            public final ByteString getIdmIdHash() {
                return ((MeasurementData) this.instance).getIdmIdHash();
            }

            public final Builder setIdmIdHash(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setIdmIdHash(byteString);
                return this;
            }

            public final Builder clearIdmIdHash() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearIdmIdHash();
                return this;
            }

            public final ByteString getDidInfo() {
                return ((MeasurementData) this.instance).getDidInfo();
            }

            public final Builder setDidInfo(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setDidInfo(byteString);
                return this;
            }

            public final Builder clearDidInfo() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearDidInfo();
                return this;
            }

            public final ByteString getAccountInfo() {
                return ((MeasurementData) this.instance).getAccountInfo();
            }

            public final Builder setAccountInfo(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setAccountInfo(byteString);
                return this;
            }

            public final Builder clearAccountInfo() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearAccountInfo();
                return this;
            }

            public final ByteString getMacAddress() {
                return ((MeasurementData) this.instance).getMacAddress();
            }

            public final Builder setMacAddress(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setMacAddress(byteString);
                return this;
            }

            public final Builder clearMacAddress() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearMacAddress();
                return this;
            }

            public final boolean hasDeviceState() {
                return ((MeasurementData) this.instance).hasDeviceState();
            }

            public final DeviceState getDeviceState() {
                return ((MeasurementData) this.instance).getDeviceState();
            }

            public final Builder setDeviceState(DeviceState deviceState) {
                copyOnWrite();
                ((MeasurementData) this.instance).setDeviceState(deviceState);
                return this;
            }

            public final Builder setDeviceState(DeviceState.Builder builder) {
                copyOnWrite();
                ((MeasurementData) this.instance).setDeviceState(builder);
                return this;
            }

            public final Builder mergeDeviceState(DeviceState deviceState) {
                copyOnWrite();
                ((MeasurementData) this.instance).mergeDeviceState(deviceState);
                return this;
            }

            public final Builder clearDeviceState() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearDeviceState();
                return this;
            }

            public final String getBleAddress() {
                return ((MeasurementData) this.instance).getBleAddress();
            }

            public final ByteString getBleAddressBytes() {
                return ((MeasurementData) this.instance).getBleAddressBytes();
            }

            public final Builder setBleAddress(String str) {
                copyOnWrite();
                ((MeasurementData) this.instance).setBleAddress(str);
                return this;
            }

            public final Builder clearBleAddress() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearBleAddress();
                return this;
            }

            public final Builder setBleAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setBleAddressBytes(byteString);
                return this;
            }

            public final ByteString getTvMacInfo() {
                return ((MeasurementData) this.instance).getTvMacInfo();
            }

            public final Builder setTvMacInfo(ByteString byteString) {
                copyOnWrite();
                ((MeasurementData) this.instance).setTvMacInfo(byteString);
                return this;
            }

            public final Builder clearTvMacInfo() {
                copyOnWrite();
                ((MeasurementData) this.instance).clearTvMacInfo();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new MeasurementData();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0002\b\t\t\n\n\n\u000b\n\f\n\r\t\u000eȈ\u000f\n", new Object[]{"uwbAddress_", "distance_", "altitudeAoa_", "azimuthAoa_", "rssi_", "deviceType_", "pid_", "tagState_", "idmIdHash_", "didInfo_", "accountInfo_", "macAddress_", "deviceState_", "bleAddress_", "tvMacInfo_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<MeasurementData> parser = PARSER;
                    if (parser == null) {
                        synchronized (MeasurementData.class) {
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
            MeasurementData measurementData = new MeasurementData();
            DEFAULT_INSTANCE = measurementData;
            GeneratedMessageLite.registerDefaultInstance(MeasurementData.class, measurementData);
        }

        public static MeasurementData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MeasurementData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class TagState extends GeneratedMessageLite<TagState, Builder> implements TagStateOrBuilder {
        public static final TagState DEFAULT_INSTANCE;
        private static volatile Parser<TagState> PARSER;
        private int associationStatus_;
        private int hid_;
        private int idmSupport_;
        private int miLinkSupport_;
        private int power_;
        private int shutDown_;
        private ByteString tvAccountInfo_ = ByteString.EMPTY;
        private int tvAuthorization_;
        private int tvMode_;
        private int tvScreenOff_;
        private int usb_;

        private TagState() {
        }

        public final int getPower() {
            return this.power_;
        }

        public final void setPower(int i) {
            this.power_ = i;
        }

        public final void clearPower() {
            this.power_ = 0;
        }

        public final int getUsb() {
            return this.usb_;
        }

        public final void setUsb(int i) {
            this.usb_ = i;
        }

        public final void clearUsb() {
            this.usb_ = 0;
        }

        public final int getHid() {
            return this.hid_;
        }

        public final void setHid(int i) {
            this.hid_ = i;
        }

        public final void clearHid() {
            this.hid_ = 0;
        }

        public final int getIdmSupport() {
            return this.idmSupport_;
        }

        public final void setIdmSupport(int i) {
            this.idmSupport_ = i;
        }

        public final void clearIdmSupport() {
            this.idmSupport_ = 0;
        }

        public final int getTvMode() {
            return this.tvMode_;
        }

        public final void setTvMode(int i) {
            this.tvMode_ = i;
        }

        public final void clearTvMode() {
            this.tvMode_ = 0;
        }

        public final int getMiLinkSupport() {
            return this.miLinkSupport_;
        }

        public final void setMiLinkSupport(int i) {
            this.miLinkSupport_ = i;
        }

        public final void clearMiLinkSupport() {
            this.miLinkSupport_ = 0;
        }

        public final int getShutDown() {
            return this.shutDown_;
        }

        public final void setShutDown(int i) {
            this.shutDown_ = i;
        }

        public final void clearShutDown() {
            this.shutDown_ = 0;
        }

        public final int getTvAuthorization() {
            return this.tvAuthorization_;
        }

        public final void setTvAuthorization(int i) {
            this.tvAuthorization_ = i;
        }

        public final void clearTvAuthorization() {
            this.tvAuthorization_ = 0;
        }

        public final int getAssociationStatus() {
            return this.associationStatus_;
        }

        public final void setAssociationStatus(int i) {
            this.associationStatus_ = i;
        }

        public final void clearAssociationStatus() {
            this.associationStatus_ = 0;
        }

        public final int getTvScreenOff() {
            return this.tvScreenOff_;
        }

        public final void setTvScreenOff(int i) {
            this.tvScreenOff_ = i;
        }

        public final void clearTvScreenOff() {
            this.tvScreenOff_ = 0;
        }

        public final ByteString getTvAccountInfo() {
            return this.tvAccountInfo_;
        }

        public final void setTvAccountInfo(ByteString byteString) {
            if (byteString != null) {
                this.tvAccountInfo_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearTvAccountInfo() {
            this.tvAccountInfo_ = getDefaultInstance().getTvAccountInfo();
        }

        public static TagState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TagState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TagState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TagState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TagState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TagState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TagState parseFrom(InputStream inputStream) throws IOException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TagState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TagState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TagState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TagState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TagState parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TagState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TagState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TagState tagState) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(tagState);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TagState, Builder> implements TagStateOrBuilder {
            private Builder() {
                super(TagState.DEFAULT_INSTANCE);
            }

            public final int getPower() {
                return ((TagState) this.instance).getPower();
            }

            public final Builder setPower(int i) {
                copyOnWrite();
                ((TagState) this.instance).setPower(i);
                return this;
            }

            public final Builder clearPower() {
                copyOnWrite();
                ((TagState) this.instance).clearPower();
                return this;
            }

            public final int getUsb() {
                return ((TagState) this.instance).getUsb();
            }

            public final Builder setUsb(int i) {
                copyOnWrite();
                ((TagState) this.instance).setUsb(i);
                return this;
            }

            public final Builder clearUsb() {
                copyOnWrite();
                ((TagState) this.instance).clearUsb();
                return this;
            }

            public final int getHid() {
                return ((TagState) this.instance).getHid();
            }

            public final Builder setHid(int i) {
                copyOnWrite();
                ((TagState) this.instance).setHid(i);
                return this;
            }

            public final Builder clearHid() {
                copyOnWrite();
                ((TagState) this.instance).clearHid();
                return this;
            }

            public final int getIdmSupport() {
                return ((TagState) this.instance).getIdmSupport();
            }

            public final Builder setIdmSupport(int i) {
                copyOnWrite();
                ((TagState) this.instance).setIdmSupport(i);
                return this;
            }

            public final Builder clearIdmSupport() {
                copyOnWrite();
                ((TagState) this.instance).clearIdmSupport();
                return this;
            }

            public final int getTvMode() {
                return ((TagState) this.instance).getTvMode();
            }

            public final Builder setTvMode(int i) {
                copyOnWrite();
                ((TagState) this.instance).setTvMode(i);
                return this;
            }

            public final Builder clearTvMode() {
                copyOnWrite();
                ((TagState) this.instance).clearTvMode();
                return this;
            }

            public final int getMiLinkSupport() {
                return ((TagState) this.instance).getMiLinkSupport();
            }

            public final Builder setMiLinkSupport(int i) {
                copyOnWrite();
                ((TagState) this.instance).setMiLinkSupport(i);
                return this;
            }

            public final Builder clearMiLinkSupport() {
                copyOnWrite();
                ((TagState) this.instance).clearMiLinkSupport();
                return this;
            }

            public final int getShutDown() {
                return ((TagState) this.instance).getShutDown();
            }

            public final Builder setShutDown(int i) {
                copyOnWrite();
                ((TagState) this.instance).setShutDown(i);
                return this;
            }

            public final Builder clearShutDown() {
                copyOnWrite();
                ((TagState) this.instance).clearShutDown();
                return this;
            }

            public final int getTvAuthorization() {
                return ((TagState) this.instance).getTvAuthorization();
            }

            public final Builder setTvAuthorization(int i) {
                copyOnWrite();
                ((TagState) this.instance).setTvAuthorization(i);
                return this;
            }

            public final Builder clearTvAuthorization() {
                copyOnWrite();
                ((TagState) this.instance).clearTvAuthorization();
                return this;
            }

            public final int getAssociationStatus() {
                return ((TagState) this.instance).getAssociationStatus();
            }

            public final Builder setAssociationStatus(int i) {
                copyOnWrite();
                ((TagState) this.instance).setAssociationStatus(i);
                return this;
            }

            public final Builder clearAssociationStatus() {
                copyOnWrite();
                ((TagState) this.instance).clearAssociationStatus();
                return this;
            }

            public final int getTvScreenOff() {
                return ((TagState) this.instance).getTvScreenOff();
            }

            public final Builder setTvScreenOff(int i) {
                copyOnWrite();
                ((TagState) this.instance).setTvScreenOff(i);
                return this;
            }

            public final Builder clearTvScreenOff() {
                copyOnWrite();
                ((TagState) this.instance).clearTvScreenOff();
                return this;
            }

            public final ByteString getTvAccountInfo() {
                return ((TagState) this.instance).getTvAccountInfo();
            }

            public final Builder setTvAccountInfo(ByteString byteString) {
                copyOnWrite();
                ((TagState) this.instance).setTvAccountInfo(byteString);
                return this;
            }

            public final Builder clearTvAccountInfo() {
                copyOnWrite();
                ((TagState) this.instance).clearTvAccountInfo();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new TagState();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004\b\u0004\t\u0004\n\u0004\u000b\n", new Object[]{"power_", "usb_", "hid_", "idmSupport_", "tvMode_", "miLinkSupport_", "shutDown_", "tvAuthorization_", "associationStatus_", "tvScreenOff_", "tvAccountInfo_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<TagState> parser = PARSER;
                    if (parser == null) {
                        synchronized (TagState.class) {
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
            TagState tagState = new TagState();
            DEFAULT_INSTANCE = tagState;
            GeneratedMessageLite.registerDefaultInstance(TagState.class, tagState);
        }

        public static TagState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TagState> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DeviceState extends GeneratedMessageLite<DeviceState, Builder> implements DeviceStateOrBuilder {
        public static final DeviceState DEFAULT_INSTANCE;
        private static volatile Parser<DeviceState> PARSER;
        private int authorization_;
        private int binding_;
        private int idmSupport_;
        private int miLinkSupport_;
        private int occupied_;
        private int reset_;
        private int tvPlazaMode_;
        private int tvScreenOff_;

        private DeviceState() {
        }

        public final int getBinding() {
            return this.binding_;
        }

        public final void setBinding(int i) {
            this.binding_ = i;
        }

        public final void clearBinding() {
            this.binding_ = 0;
        }

        public final int getAuthorization() {
            return this.authorization_;
        }

        public final void setAuthorization(int i) {
            this.authorization_ = i;
        }

        public final void clearAuthorization() {
            this.authorization_ = 0;
        }

        public final int getIdmSupport() {
            return this.idmSupport_;
        }

        public final void setIdmSupport(int i) {
            this.idmSupport_ = i;
        }

        public final void clearIdmSupport() {
            this.idmSupport_ = 0;
        }

        public final int getTvPlazaMode() {
            return this.tvPlazaMode_;
        }

        public final void setTvPlazaMode(int i) {
            this.tvPlazaMode_ = i;
        }

        public final void clearTvPlazaMode() {
            this.tvPlazaMode_ = 0;
        }

        public final int getMiLinkSupport() {
            return this.miLinkSupport_;
        }

        public final void setMiLinkSupport(int i) {
            this.miLinkSupport_ = i;
        }

        public final void clearMiLinkSupport() {
            this.miLinkSupport_ = 0;
        }

        public final int getReset() {
            return this.reset_;
        }

        public final void setReset(int i) {
            this.reset_ = i;
        }

        public final void clearReset() {
            this.reset_ = 0;
        }

        public final int getOccupied() {
            return this.occupied_;
        }

        public final void setOccupied(int i) {
            this.occupied_ = i;
        }

        public final void clearOccupied() {
            this.occupied_ = 0;
        }

        public final int getTvScreenOff() {
            return this.tvScreenOff_;
        }

        public final void setTvScreenOff(int i) {
            this.tvScreenOff_ = i;
        }

        public final void clearTvScreenOff() {
            this.tvScreenOff_ = 0;
        }

        public static DeviceState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeviceState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeviceState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeviceState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeviceState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeviceState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeviceState parseFrom(InputStream inputStream) throws IOException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeviceState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeviceState parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeviceState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeviceState deviceState) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(deviceState);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeviceState, Builder> implements DeviceStateOrBuilder {
            private Builder() {
                super(DeviceState.DEFAULT_INSTANCE);
            }

            public final int getBinding() {
                return ((DeviceState) this.instance).getBinding();
            }

            public final Builder setBinding(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setBinding(i);
                return this;
            }

            public final Builder clearBinding() {
                copyOnWrite();
                ((DeviceState) this.instance).clearBinding();
                return this;
            }

            public final int getAuthorization() {
                return ((DeviceState) this.instance).getAuthorization();
            }

            public final Builder setAuthorization(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setAuthorization(i);
                return this;
            }

            public final Builder clearAuthorization() {
                copyOnWrite();
                ((DeviceState) this.instance).clearAuthorization();
                return this;
            }

            public final int getIdmSupport() {
                return ((DeviceState) this.instance).getIdmSupport();
            }

            public final Builder setIdmSupport(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setIdmSupport(i);
                return this;
            }

            public final Builder clearIdmSupport() {
                copyOnWrite();
                ((DeviceState) this.instance).clearIdmSupport();
                return this;
            }

            public final int getTvPlazaMode() {
                return ((DeviceState) this.instance).getTvPlazaMode();
            }

            public final Builder setTvPlazaMode(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setTvPlazaMode(i);
                return this;
            }

            public final Builder clearTvPlazaMode() {
                copyOnWrite();
                ((DeviceState) this.instance).clearTvPlazaMode();
                return this;
            }

            public final int getMiLinkSupport() {
                return ((DeviceState) this.instance).getMiLinkSupport();
            }

            public final Builder setMiLinkSupport(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setMiLinkSupport(i);
                return this;
            }

            public final Builder clearMiLinkSupport() {
                copyOnWrite();
                ((DeviceState) this.instance).clearMiLinkSupport();
                return this;
            }

            public final int getReset() {
                return ((DeviceState) this.instance).getReset();
            }

            public final Builder setReset(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setReset(i);
                return this;
            }

            public final Builder clearReset() {
                copyOnWrite();
                ((DeviceState) this.instance).clearReset();
                return this;
            }

            public final int getOccupied() {
                return ((DeviceState) this.instance).getOccupied();
            }

            public final Builder setOccupied(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setOccupied(i);
                return this;
            }

            public final Builder clearOccupied() {
                copyOnWrite();
                ((DeviceState) this.instance).clearOccupied();
                return this;
            }

            public final int getTvScreenOff() {
                return ((DeviceState) this.instance).getTvScreenOff();
            }

            public final Builder setTvScreenOff(int i) {
                copyOnWrite();
                ((DeviceState) this.instance).setTvScreenOff(i);
                return this;
            }

            public final Builder clearTvScreenOff() {
                copyOnWrite();
                ((DeviceState) this.instance).clearTvScreenOff();
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new DeviceState();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004\b\u0004", new Object[]{"binding_", "authorization_", "idmSupport_", "tvPlazaMode_", "miLinkSupport_", "reset_", "occupied_", "tvScreenOff_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DeviceState> parser = PARSER;
                    if (parser == null) {
                        synchronized (DeviceState.class) {
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
            DeviceState deviceState = new DeviceState();
            DEFAULT_INSTANCE = deviceState;
            GeneratedMessageLite.registerDefaultInstance(DeviceState.class, deviceState);
        }

        public static DeviceState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeviceState> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FrameData extends GeneratedMessageLite<FrameData, Builder> implements FrameDataOrBuilder {
        public static final FrameData DEFAULT_INSTANCE;
        private static volatile Parser<FrameData> PARSER;
        private String address_ = "";
        private ByteString data_ = ByteString.EMPTY;
        private int taskId_;

        private FrameData() {
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

        public final int getTaskId() {
            return this.taskId_;
        }

        public final void setTaskId(int i) {
            this.taskId_ = i;
        }

        public final void clearTaskId() {
            this.taskId_ = 0;
        }

        public final String getAddress() {
            return this.address_;
        }

        public final ByteString getAddressBytes() {
            return ByteString.copyFromUtf8(this.address_);
        }

        public final void setAddress(String str) {
            if (str != null) {
                this.address_ = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void clearAddress() {
            this.address_ = getDefaultInstance().getAddress();
        }

        public final void setAddressBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.address_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public static FrameData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FrameData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FrameData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FrameData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FrameData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FrameData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FrameData parseFrom(InputStream inputStream) throws IOException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FrameData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FrameData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FrameData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FrameData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FrameData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FrameData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FrameData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FrameData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FrameData frameData) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(frameData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FrameData, Builder> implements FrameDataOrBuilder {
            private Builder() {
                super(FrameData.DEFAULT_INSTANCE);
            }

            public final ByteString getData() {
                return ((FrameData) this.instance).getData();
            }

            public final Builder setData(ByteString byteString) {
                copyOnWrite();
                ((FrameData) this.instance).setData(byteString);
                return this;
            }

            public final Builder clearData() {
                copyOnWrite();
                ((FrameData) this.instance).clearData();
                return this;
            }

            public final int getTaskId() {
                return ((FrameData) this.instance).getTaskId();
            }

            public final Builder setTaskId(int i) {
                copyOnWrite();
                ((FrameData) this.instance).setTaskId(i);
                return this;
            }

            public final Builder clearTaskId() {
                copyOnWrite();
                ((FrameData) this.instance).clearTaskId();
                return this;
            }

            public final String getAddress() {
                return ((FrameData) this.instance).getAddress();
            }

            public final ByteString getAddressBytes() {
                return ((FrameData) this.instance).getAddressBytes();
            }

            public final Builder setAddress(String str) {
                copyOnWrite();
                ((FrameData) this.instance).setAddress(str);
                return this;
            }

            public final Builder clearAddress() {
                copyOnWrite();
                ((FrameData) this.instance).clearAddress();
                return this;
            }

            public final Builder setAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((FrameData) this.instance).setAddressBytes(byteString);
                return this;
            }
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new FrameData();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0002\u0004\u0003Ȉ", new Object[]{"data_", "taskId_", "address_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<FrameData> parser = PARSER;
                    if (parser == null) {
                        synchronized (FrameData.class) {
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
            FrameData frameData = new FrameData();
            DEFAULT_INSTANCE = frameData;
            GeneratedMessageLite.registerDefaultInstance(FrameData.class, frameData);
        }

        public static FrameData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FrameData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
