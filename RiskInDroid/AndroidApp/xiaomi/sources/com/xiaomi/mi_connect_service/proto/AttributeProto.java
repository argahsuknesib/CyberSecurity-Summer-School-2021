package com.xiaomi.mi_connect_service.proto;

import com.google.android.exoplayer2.C;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class AttributeProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fAttrProto.proto\u0012#com.xiaomi.mi_connect_service.proto\"\u0002\n\u000bAttrAdvData\u0012\u0014\n\fversionMajor\u0018\u0001 \u0001(\u0005\u0012\u0014\n\fversionMinor\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004apps\u0018\u0003 \u0001(\f\u0012\r\n\u0005flags\u0018\u0004 \u0001(\f\u0012\f\n\u0004name\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006idHash\u0018\u0006 \u0001(\f\u0012\u0012\n\ndeviceType\u0018\u0007 \u0001(\u0005\u0012\u0014\n\fsecurityMode\u0018\b \u0001(\u0005\u0012\u0010\n\bappsData\u0018\t \u0003(\f\u0012\u0016\n\u000esupportSetting\u0018\n \u0003(\f\u0012\u0016\n\u000ecurrentSetting\u0018\u000b \u0003(\f\u0012\u000f\n\u0007wifiMac\u0018\f \u0001(\t\u0012\u000e\n\u0006appIds\u0018\r \u0003(\u0005\">\n\u0010AttrWriteRequest\u0012\f\n\u0004uuid\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\f\u0012\r\n\u0005index\u0018\u0003 \u0001(\u0005\"`\n\u0011AttrWriteResponse\u0012<\n\u0003res\u0018\u0001 \u0001(\u000e2/.com.xiaomi.mi_connect_service.proto.ResultEnum\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\".\n\u000fAttrReadRequest\u0012\f\n\u0004uuid\u0018\u0001 \u0001(\t\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\"n\n\u0010AttrReadResponse\u0012<\n\u0003res\u0018\u0001 \u0001(\u000e2/.com.xiaomi.mi_connect_service.proto.ResultEnum\u0012\r\n\u0005value\u0018\u0002 \u0001(\f\u0012\r\n\u0005index\u0018\u0003 \u0001(\u0005\"3\n\u0014AttrSetNotifyRequest\u0012\f\n\u0004uuid\u0018\u0001 \u0001(\t\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\"d\n\u0015AttrSetNotifyResponse\u0012<\n\u0003res\u0018\u0001 \u0001(\u000e2/.com.xiaomi.mi_connect_service.proto.ResultEnum\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\"5\n\u0016AttrUnsetNotifyRequest\u0012\f\n\u0004uuid\u0018\u0001 \u0001(\t\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\"f\n\u0017AttrUnsetNotifyResponse\u0012<\n\u0003res\u0018\u0001 \u0001(\u000e2/.com.xiaomi.mi_connect_service.proto.ResultEnum\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\"?\n\u0011AttrNotifyRequest\u0012\f\n\u0004uuid\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\f\u0012\r\n\u0005index\u0018\u0003 \u0001(\u0005\"a\n\u0012AttrNotifyResponse\u0012<\n\u0003res\u0018\u0001 \u0001(\u000e2/.com.xiaomi.mi_connect_service.proto.ResultEnum\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\"\u001f\n\u000eAttrNotifyPull\u0012\r\n\u0005index\u0018\u0001 \u0001(\u0005\"<\n\u000eAttrNotifyPush\u0012\r\n\u0005index\u0018\u0001 \u0001(\u0005\u0012\f\n\u0004uuid\u0018\u0002 \u0001(\t\u0012\r\n\u0005value\u0018\u0003 \u0001(\f\"\b\n\u0007AttrOps\u0012C\n\u0007advData\u0018\u0001 \u0001(\u000b20.com.xiaomi.mi_connect_service.proto.AttrAdvDataH\u0000\u0012I\n\bwriteReq\u0018\u0002 \u0001(\u000b25.com.xiaomi.mi_connect_service.proto.AttrWriteRequestH\u0000\u0012J\n\bwriteRsp\u0018\u0003 \u0001(\u000b26.com.xiaomi.mi_connect_service.proto.AttrWriteResponseH\u0000\u0012G\n\u0007readReq\u0018\u0004 \u0001(\u000b24.com.xiaomi.mi_connect_service.proto.AttrReadRequestH\u0000\u0012H\n\u0007readRsp\u0018\u0005 \u0001(\u000b25.com.xiaomi.mi_connect_service.proto.AttrReadResponseH\u0000\u0012Q\n\fsetNotifyReq\u0018\u0006 \u0001(\u000b29.com.xiaomi.mi_connect_service.proto.AttrSetNotifyRequestH\u0000\u0012R\n\fsetNotifyRsp\u0018\u0007 \u0001(\u000b2:.com.xiaomi.mi_connect_service.proto.AttrSetNotifyResponseH\u0000\u0012U\n\u000eunsetNotifyReq\u0018\b \u0001(\u000b2;.com.xiaomi.mi_connect_service.proto.AttrUnsetNotifyRequestH\u0000\u0012V\n\u000eunsetNotifyRsp\u0018\t \u0001(\u000b2<.com.xiaomi.mi_connect_service.proto.AttrUnsetNotifyResponseH\u0000\u0012K\n\tnotifyReq\u0018\n \u0001(\u000b26.com.xiaomi.mi_connect_service.proto.AttrNotifyRequestH\u0000\u0012L\n\tnotifyRsp\u0018\u000b \u0001(\u000b27.com.xiaomi.mi_connect_service.proto.AttrNotifyResponseH\u0000\u0012I\n\nnotifyPull\u0018\f \u0001(\u000b23.com.xiaomi.mi_connect_service.proto.AttrNotifyPullH\u0000\u0012I\n\nnotifyPush\u0018\r \u0001(\u000b23.com.xiaomi.mi_connect_service.proto.AttrNotifyPushH\u0000B\b\n\u0006action*#\n\nResultEnum\u0012\u000b\n\u0007SUCCESS\u0010\u0000\u0012\b\n\u0004FAIL\u0010\u0001B5\n#com.xiaomi.mi_connect_service.protoB\u000eAttributeProtob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_descriptor = getDescriptor().getMessageTypes().get(0);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_descriptor, new String[]{"VersionMajor", "VersionMinor", "Apps", "Flags", "Name", "IdHash", "DeviceType", "SecurityMode", "AppsData", "SupportSetting", "CurrentSetting", "WifiMac", "AppIds"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_descriptor = getDescriptor().getMessageTypes().get(11);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_descriptor, new String[]{"Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_descriptor = getDescriptor().getMessageTypes().get(12);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_descriptor, new String[]{"Index", "Uuid", "Value"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_descriptor, new String[]{"Uuid", "Value", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_descriptor, new String[]{"Res", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_descriptor = getDescriptor().getMessageTypes().get(13);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_descriptor, new String[]{"AdvData", "WriteReq", "WriteRsp", "ReadReq", "ReadRsp", "SetNotifyReq", "SetNotifyRsp", "UnsetNotifyReq", "UnsetNotifyRsp", "NotifyReq", "NotifyRsp", "NotifyPull", "NotifyPush", "Action"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_descriptor, new String[]{"Uuid", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_descriptor, new String[]{"Res", "Value", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_descriptor, new String[]{"Uuid", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_descriptor, new String[]{"Res", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_descriptor, new String[]{"Uuid", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_descriptor, new String[]{"Res", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_descriptor, new String[]{"Uuid", "Value", "Index"});
    public static final Descriptors.Descriptor internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_descriptor, new String[]{"Res", "Index"});

    public interface AttrAdvDataOrBuilder extends MessageOrBuilder {
        int getAppIds(int i);

        int getAppIdsCount();

        List<Integer> getAppIdsList();

        ByteString getApps();

        ByteString getAppsData(int i);

        int getAppsDataCount();

        List<ByteString> getAppsDataList();

        ByteString getCurrentSetting(int i);

        int getCurrentSettingCount();

        List<ByteString> getCurrentSettingList();

        int getDeviceType();

        ByteString getFlags();

        ByteString getIdHash();

        String getName();

        ByteString getNameBytes();

        int getSecurityMode();

        ByteString getSupportSetting(int i);

        int getSupportSettingCount();

        List<ByteString> getSupportSettingList();

        int getVersionMajor();

        int getVersionMinor();

        String getWifiMac();

        ByteString getWifiMacBytes();
    }

    public interface AttrNotifyPullOrBuilder extends MessageOrBuilder {
        int getIndex();
    }

    public interface AttrNotifyPushOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getUuid();

        ByteString getUuidBytes();

        ByteString getValue();
    }

    public interface AttrNotifyRequestOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getUuid();

        ByteString getUuidBytes();

        ByteString getValue();
    }

    public interface AttrNotifyResponseOrBuilder extends MessageOrBuilder {
        int getIndex();

        ResultEnum getRes();

        int getResValue();
    }

    public interface AttrOpsOrBuilder extends MessageOrBuilder {
        AttrOps.ActionCase getActionCase();

        AttrAdvData getAdvData();

        AttrAdvDataOrBuilder getAdvDataOrBuilder();

        AttrNotifyPull getNotifyPull();

        AttrNotifyPullOrBuilder getNotifyPullOrBuilder();

        AttrNotifyPush getNotifyPush();

        AttrNotifyPushOrBuilder getNotifyPushOrBuilder();

        AttrNotifyRequest getNotifyReq();

        AttrNotifyRequestOrBuilder getNotifyReqOrBuilder();

        AttrNotifyResponse getNotifyRsp();

        AttrNotifyResponseOrBuilder getNotifyRspOrBuilder();

        AttrReadRequest getReadReq();

        AttrReadRequestOrBuilder getReadReqOrBuilder();

        AttrReadResponse getReadRsp();

        AttrReadResponseOrBuilder getReadRspOrBuilder();

        AttrSetNotifyRequest getSetNotifyReq();

        AttrSetNotifyRequestOrBuilder getSetNotifyReqOrBuilder();

        AttrSetNotifyResponse getSetNotifyRsp();

        AttrSetNotifyResponseOrBuilder getSetNotifyRspOrBuilder();

        AttrUnsetNotifyRequest getUnsetNotifyReq();

        AttrUnsetNotifyRequestOrBuilder getUnsetNotifyReqOrBuilder();

        AttrUnsetNotifyResponse getUnsetNotifyRsp();

        AttrUnsetNotifyResponseOrBuilder getUnsetNotifyRspOrBuilder();

        AttrWriteRequest getWriteReq();

        AttrWriteRequestOrBuilder getWriteReqOrBuilder();

        AttrWriteResponse getWriteRsp();

        AttrWriteResponseOrBuilder getWriteRspOrBuilder();

        boolean hasAdvData();

        boolean hasNotifyPull();

        boolean hasNotifyPush();

        boolean hasNotifyReq();

        boolean hasNotifyRsp();

        boolean hasReadReq();

        boolean hasReadRsp();

        boolean hasSetNotifyReq();

        boolean hasSetNotifyRsp();

        boolean hasUnsetNotifyReq();

        boolean hasUnsetNotifyRsp();

        boolean hasWriteReq();

        boolean hasWriteRsp();
    }

    public interface AttrReadRequestOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getUuid();

        ByteString getUuidBytes();
    }

    public interface AttrReadResponseOrBuilder extends MessageOrBuilder {
        int getIndex();

        ResultEnum getRes();

        int getResValue();

        ByteString getValue();
    }

    public interface AttrSetNotifyRequestOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getUuid();

        ByteString getUuidBytes();
    }

    public interface AttrSetNotifyResponseOrBuilder extends MessageOrBuilder {
        int getIndex();

        ResultEnum getRes();

        int getResValue();
    }

    public interface AttrUnsetNotifyRequestOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getUuid();

        ByteString getUuidBytes();
    }

    public interface AttrUnsetNotifyResponseOrBuilder extends MessageOrBuilder {
        int getIndex();

        ResultEnum getRes();

        int getResValue();
    }

    public interface AttrWriteRequestOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getUuid();

        ByteString getUuidBytes();

        ByteString getValue();
    }

    public interface AttrWriteResponseOrBuilder extends MessageOrBuilder {
        int getIndex();

        ResultEnum getRes();

        int getResValue();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private AttributeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public enum ResultEnum implements ProtocolMessageEnum {
        SUCCESS(0),
        FAIL(1),
        UNRECOGNIZED(-1);
        
        private static final ResultEnum[] VALUES = values();
        private static final Internal.EnumLiteMap<ResultEnum> internalValueMap = new Internal.EnumLiteMap<ResultEnum>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.ResultEnum.AnonymousClass1 */

            public final ResultEnum findValueByNumber(int i) {
                return ResultEnum.forNumber(i);
            }
        };
        private final int value;

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ResultEnum valueOf(int i) {
            return forNumber(i);
        }

        public static ResultEnum forNumber(int i) {
            if (i == 0) {
                return SUCCESS;
            }
            if (i != 1) {
                return null;
            }
            return FAIL;
        }

        public static Internal.EnumLiteMap<ResultEnum> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return AttributeProto.getDescriptor().getEnumTypes().get(0);
        }

        public static ResultEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[enumValueDescriptor.getIndex()];
            }
        }

        private ResultEnum(int i) {
            this.value = i;
        }
    }

    public static final class AttrAdvData extends GeneratedMessageV3 implements AttrAdvDataOrBuilder {
        private static final AttrAdvData DEFAULT_INSTANCE = new AttrAdvData();
        public static final Parser<AttrAdvData> PARSER = new AbstractParser<AttrAdvData>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.AnonymousClass1 */

            public final AttrAdvData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrAdvData(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        private int appIdsMemoizedSerializedSize;
        public Internal.IntList appIds_;
        public List<ByteString> appsData_;
        public ByteString apps_;
        public List<ByteString> currentSetting_;
        public int deviceType_;
        public ByteString flags_;
        public ByteString idHash_;
        private byte memoizedIsInitialized;
        public volatile Object name_;
        public int securityMode_;
        public List<ByteString> supportSetting_;
        public int versionMajor_;
        public int versionMinor_;
        public volatile Object wifiMac_;

        /* synthetic */ AttrAdvData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrAdvData(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrAdvData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.appIdsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AttrAdvData() {
            this.appIdsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.apps_ = ByteString.EMPTY;
            this.flags_ = ByteString.EMPTY;
            this.name_ = "";
            this.idHash_ = ByteString.EMPTY;
            this.appsData_ = Collections.emptyList();
            this.supportSetting_ = Collections.emptyList();
            this.currentSetting_ = Collections.emptyList();
            this.wifiMac_ = "";
            this.appIds_ = emptyIntList();
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrAdvData();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrAdvData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                this.versionMajor_ = codedInputStream.readInt32();
                                continue;
                            case 16:
                                this.versionMinor_ = codedInputStream.readInt32();
                                continue;
                            case 26:
                                this.apps_ = codedInputStream.readBytes();
                                continue;
                            case 34:
                                this.flags_ = codedInputStream.readBytes();
                                continue;
                            case 42:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 50:
                                this.idHash_ = codedInputStream.readBytes();
                                continue;
                            case 56:
                                this.deviceType_ = codedInputStream.readInt32();
                                continue;
                            case 64:
                                this.securityMode_ = codedInputStream.readInt32();
                                continue;
                            case 74:
                                if (!z2 || !true) {
                                    this.appsData_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.appsData_.add(codedInputStream.readBytes());
                                continue;
                            case XiaomiOAuthConstants.VERSION_MINOR:
                                if (!z2 || !true) {
                                    this.supportSetting_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.supportSetting_.add(codedInputStream.readBytes());
                                continue;
                            case 90:
                                if (!z2 || !true) {
                                    this.currentSetting_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.currentSetting_.add(codedInputStream.readBytes());
                                continue;
                            case 98:
                                this.wifiMac_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 104:
                                if (!z2 || !true) {
                                    this.appIds_ = newIntList();
                                    z2 |= true;
                                }
                                this.appIds_.addInt(codedInputStream.readInt32());
                                continue;
                            case 106:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((!z2 || !true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.appIds_ = newIntList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.appIds_.addInt(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(pushLimit);
                                continue;
                            default:
                                if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    continue;
                                }
                                break;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        if (z2 && true) {
                            this.appsData_ = Collections.unmodifiableList(this.appsData_);
                        }
                        if (z2 && true) {
                            this.supportSetting_ = Collections.unmodifiableList(this.supportSetting_);
                        }
                        if (z2 && true) {
                            this.currentSetting_ = Collections.unmodifiableList(this.currentSetting_);
                        }
                        if (z2 && true) {
                            this.appIds_.makeImmutable();
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if (z2 && true) {
                    this.appsData_ = Collections.unmodifiableList(this.appsData_);
                }
                if (z2 && true) {
                    this.supportSetting_ = Collections.unmodifiableList(this.supportSetting_);
                }
                if (z2 && true) {
                    this.currentSetting_ = Collections.unmodifiableList(this.currentSetting_);
                }
                if (z2 && true) {
                    this.appIds_.makeImmutable();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrAdvData.class, Builder.class);
        }

        public final int getVersionMajor() {
            return this.versionMajor_;
        }

        public final int getVersionMinor() {
            return this.versionMinor_;
        }

        public final ByteString getApps() {
            return this.apps_;
        }

        public final ByteString getFlags() {
            return this.flags_;
        }

        public final String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getNameBytes() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final ByteString getIdHash() {
            return this.idHash_;
        }

        public final int getDeviceType() {
            return this.deviceType_;
        }

        public final int getSecurityMode() {
            return this.securityMode_;
        }

        public final List<ByteString> getAppsDataList() {
            return this.appsData_;
        }

        public final int getAppsDataCount() {
            return this.appsData_.size();
        }

        public final ByteString getAppsData(int i) {
            return this.appsData_.get(i);
        }

        public final List<ByteString> getSupportSettingList() {
            return this.supportSetting_;
        }

        public final int getSupportSettingCount() {
            return this.supportSetting_.size();
        }

        public final ByteString getSupportSetting(int i) {
            return this.supportSetting_.get(i);
        }

        public final List<ByteString> getCurrentSettingList() {
            return this.currentSetting_;
        }

        public final int getCurrentSettingCount() {
            return this.currentSetting_.size();
        }

        public final ByteString getCurrentSetting(int i) {
            return this.currentSetting_.get(i);
        }

        public final String getWifiMac() {
            Object obj = this.wifiMac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wifiMac_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getWifiMacBytes() {
            Object obj = this.wifiMac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.wifiMac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final List<Integer> getAppIdsList() {
            return this.appIds_;
        }

        public final int getAppIdsCount() {
            return this.appIds_.size();
        }

        public final int getAppIds(int i) {
            return this.appIds_.getInt(i);
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i = this.versionMajor_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.versionMinor_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            if (!this.apps_.isEmpty()) {
                codedOutputStream.writeBytes(3, this.apps_);
            }
            if (!this.flags_.isEmpty()) {
                codedOutputStream.writeBytes(4, this.flags_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.name_);
            }
            if (!this.idHash_.isEmpty()) {
                codedOutputStream.writeBytes(6, this.idHash_);
            }
            int i3 = this.deviceType_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(7, i3);
            }
            int i4 = this.securityMode_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(8, i4);
            }
            for (int i5 = 0; i5 < this.appsData_.size(); i5++) {
                codedOutputStream.writeBytes(9, this.appsData_.get(i5));
            }
            for (int i6 = 0; i6 < this.supportSetting_.size(); i6++) {
                codedOutputStream.writeBytes(10, this.supportSetting_.get(i6));
            }
            for (int i7 = 0; i7 < this.currentSetting_.size(); i7++) {
                codedOutputStream.writeBytes(11, this.currentSetting_.get(i7));
            }
            if (!getWifiMacBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.wifiMac_);
            }
            if (getAppIdsList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(106);
                codedOutputStream.writeUInt32NoTag(this.appIdsMemoizedSerializedSize);
            }
            for (int i8 = 0; i8 < this.appIds_.size(); i8++) {
                codedOutputStream.writeInt32NoTag(this.appIds_.getInt(i8));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.versionMajor_;
            int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
            int i3 = this.versionMinor_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            if (!this.apps_.isEmpty()) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, this.apps_);
            }
            if (!this.flags_.isEmpty()) {
                computeInt32Size += CodedOutputStream.computeBytesSize(4, this.flags_);
            }
            if (!getNameBytes().isEmpty()) {
                computeInt32Size += GeneratedMessageV3.computeStringSize(5, this.name_);
            }
            if (!this.idHash_.isEmpty()) {
                computeInt32Size += CodedOutputStream.computeBytesSize(6, this.idHash_);
            }
            int i4 = this.deviceType_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, i4);
            }
            int i5 = this.securityMode_;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, i5);
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.appsData_.size(); i7++) {
                i6 += CodedOutputStream.computeBytesSizeNoTag(this.appsData_.get(i7));
            }
            int size = computeInt32Size + i6 + (getAppsDataList().size() * 1);
            int i8 = 0;
            for (int i9 = 0; i9 < this.supportSetting_.size(); i9++) {
                i8 += CodedOutputStream.computeBytesSizeNoTag(this.supportSetting_.get(i9));
            }
            int size2 = size + i8 + (getSupportSettingList().size() * 1);
            int i10 = 0;
            for (int i11 = 0; i11 < this.currentSetting_.size(); i11++) {
                i10 += CodedOutputStream.computeBytesSizeNoTag(this.currentSetting_.get(i11));
            }
            int size3 = size2 + i10 + (getCurrentSettingList().size() * 1);
            if (!getWifiMacBytes().isEmpty()) {
                size3 += GeneratedMessageV3.computeStringSize(12, this.wifiMac_);
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.appIds_.size(); i13++) {
                i12 += CodedOutputStream.computeInt32SizeNoTag(this.appIds_.getInt(i13));
            }
            int i14 = size3 + i12;
            if (!getAppIdsList().isEmpty()) {
                i14 = i14 + 1 + CodedOutputStream.computeInt32SizeNoTag(i12);
            }
            this.appIdsMemoizedSerializedSize = i12;
            int serializedSize = i14 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrAdvData)) {
                return super.equals(obj);
            }
            AttrAdvData attrAdvData = (AttrAdvData) obj;
            if (getVersionMajor() == attrAdvData.getVersionMajor() && getVersionMinor() == attrAdvData.getVersionMinor() && getApps().equals(attrAdvData.getApps()) && getFlags().equals(attrAdvData.getFlags()) && getName().equals(attrAdvData.getName()) && getIdHash().equals(attrAdvData.getIdHash()) && getDeviceType() == attrAdvData.getDeviceType() && getSecurityMode() == attrAdvData.getSecurityMode() && getAppsDataList().equals(attrAdvData.getAppsDataList()) && getSupportSettingList().equals(attrAdvData.getSupportSettingList()) && getCurrentSettingList().equals(attrAdvData.getCurrentSettingList()) && getWifiMac().equals(attrAdvData.getWifiMac()) && getAppIdsList().equals(attrAdvData.getAppIdsList()) && this.unknownFields.equals(attrAdvData.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getVersionMajor()) * 37) + 2) * 53) + getVersionMinor()) * 37) + 3) * 53) + getApps().hashCode()) * 37) + 4) * 53) + getFlags().hashCode()) * 37) + 5) * 53) + getName().hashCode()) * 37) + 6) * 53) + getIdHash().hashCode()) * 37) + 7) * 53) + getDeviceType()) * 37) + 8) * 53) + getSecurityMode();
            if (getAppsDataCount() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + getAppsDataList().hashCode();
            }
            if (getSupportSettingCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + getSupportSettingList().hashCode();
            }
            if (getCurrentSettingCount() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + getCurrentSettingList().hashCode();
            }
            int hashCode2 = (((hashCode * 37) + 12) * 53) + getWifiMac().hashCode();
            if (getAppIdsCount() > 0) {
                hashCode2 = (((hashCode2 * 37) + 13) * 53) + getAppIdsList().hashCode();
            }
            int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }

        public static AttrAdvData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrAdvData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrAdvData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrAdvData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrAdvData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrAdvData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrAdvData parseFrom(InputStream inputStream) throws IOException {
            return (AttrAdvData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrAdvData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrAdvData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrAdvData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrAdvData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrAdvData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrAdvData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrAdvData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrAdvData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrAdvData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrAdvData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrAdvData attrAdvData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrAdvData);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrAdvDataOrBuilder {
            private Internal.IntList appIds_;
            private List<ByteString> appsData_;
            private ByteString apps_;
            private int bitField0_;
            private List<ByteString> currentSetting_;
            private int deviceType_;
            private ByteString flags_;
            private ByteString idHash_;
            private Object name_;
            private int securityMode_;
            private List<ByteString> supportSetting_;
            private int versionMajor_;
            private int versionMinor_;
            private Object wifiMac_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrAdvData.class, Builder.class);
            }

            private Builder() {
                this.apps_ = ByteString.EMPTY;
                this.flags_ = ByteString.EMPTY;
                this.name_ = "";
                this.idHash_ = ByteString.EMPTY;
                this.appsData_ = Collections.emptyList();
                this.supportSetting_ = Collections.emptyList();
                this.currentSetting_ = Collections.emptyList();
                this.wifiMac_ = "";
                this.appIds_ = AttrAdvData.emptyIntList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.apps_ = ByteString.EMPTY;
                this.flags_ = ByteString.EMPTY;
                this.name_ = "";
                this.idHash_ = ByteString.EMPTY;
                this.appsData_ = Collections.emptyList();
                this.supportSetting_ = Collections.emptyList();
                this.currentSetting_ = Collections.emptyList();
                this.wifiMac_ = "";
                this.appIds_ = AttrAdvData.emptyIntList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrAdvData.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.versionMajor_ = 0;
                this.versionMinor_ = 0;
                this.apps_ = ByteString.EMPTY;
                this.flags_ = ByteString.EMPTY;
                this.name_ = "";
                this.idHash_ = ByteString.EMPTY;
                this.deviceType_ = 0;
                this.securityMode_ = 0;
                this.appsData_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.supportSetting_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.currentSetting_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.wifiMac_ = "";
                this.appIds_ = AttrAdvData.emptyIntList();
                this.bitField0_ &= -9;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrAdvData_descriptor;
            }

            public final AttrAdvData getDefaultInstanceForType() {
                return AttrAdvData.getDefaultInstance();
            }

            public final AttrAdvData build() {
                AttrAdvData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrAdvData buildPartial() {
                AttrAdvData attrAdvData = new AttrAdvData(this, (AnonymousClass1) null);
                attrAdvData.versionMajor_ = this.versionMajor_;
                attrAdvData.versionMinor_ = this.versionMinor_;
                attrAdvData.apps_ = this.apps_;
                attrAdvData.flags_ = this.flags_;
                attrAdvData.name_ = this.name_;
                attrAdvData.idHash_ = this.idHash_;
                attrAdvData.deviceType_ = this.deviceType_;
                attrAdvData.securityMode_ = this.securityMode_;
                if ((this.bitField0_ & 1) != 0) {
                    this.appsData_ = Collections.unmodifiableList(this.appsData_);
                    this.bitField0_ &= -2;
                }
                attrAdvData.appsData_ = this.appsData_;
                if ((this.bitField0_ & 2) != 0) {
                    this.supportSetting_ = Collections.unmodifiableList(this.supportSetting_);
                    this.bitField0_ &= -3;
                }
                attrAdvData.supportSetting_ = this.supportSetting_;
                if ((this.bitField0_ & 4) != 0) {
                    this.currentSetting_ = Collections.unmodifiableList(this.currentSetting_);
                    this.bitField0_ &= -5;
                }
                attrAdvData.currentSetting_ = this.currentSetting_;
                attrAdvData.wifiMac_ = this.wifiMac_;
                if ((this.bitField0_ & 8) != 0) {
                    this.appIds_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                attrAdvData.appIds_ = this.appIds_;
                onBuilt();
                return attrAdvData;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrAdvData$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrAdvData$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrAdvData.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrAdvData$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrAdvData) {
                    return mergeFrom((AttrAdvData) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrAdvData attrAdvData) {
                if (attrAdvData == AttrAdvData.getDefaultInstance()) {
                    return this;
                }
                if (attrAdvData.getVersionMajor() != 0) {
                    setVersionMajor(attrAdvData.getVersionMajor());
                }
                if (attrAdvData.getVersionMinor() != 0) {
                    setVersionMinor(attrAdvData.getVersionMinor());
                }
                if (attrAdvData.getApps() != ByteString.EMPTY) {
                    setApps(attrAdvData.getApps());
                }
                if (attrAdvData.getFlags() != ByteString.EMPTY) {
                    setFlags(attrAdvData.getFlags());
                }
                if (!attrAdvData.getName().isEmpty()) {
                    this.name_ = attrAdvData.name_;
                    onChanged();
                }
                if (attrAdvData.getIdHash() != ByteString.EMPTY) {
                    setIdHash(attrAdvData.getIdHash());
                }
                if (attrAdvData.getDeviceType() != 0) {
                    setDeviceType(attrAdvData.getDeviceType());
                }
                if (attrAdvData.getSecurityMode() != 0) {
                    setSecurityMode(attrAdvData.getSecurityMode());
                }
                if (!attrAdvData.appsData_.isEmpty()) {
                    if (this.appsData_.isEmpty()) {
                        this.appsData_ = attrAdvData.appsData_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAppsDataIsMutable();
                        this.appsData_.addAll(attrAdvData.appsData_);
                    }
                    onChanged();
                }
                if (!attrAdvData.supportSetting_.isEmpty()) {
                    if (this.supportSetting_.isEmpty()) {
                        this.supportSetting_ = attrAdvData.supportSetting_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSupportSettingIsMutable();
                        this.supportSetting_.addAll(attrAdvData.supportSetting_);
                    }
                    onChanged();
                }
                if (!attrAdvData.currentSetting_.isEmpty()) {
                    if (this.currentSetting_.isEmpty()) {
                        this.currentSetting_ = attrAdvData.currentSetting_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureCurrentSettingIsMutable();
                        this.currentSetting_.addAll(attrAdvData.currentSetting_);
                    }
                    onChanged();
                }
                if (!attrAdvData.getWifiMac().isEmpty()) {
                    this.wifiMac_ = attrAdvData.wifiMac_;
                    onChanged();
                }
                if (!attrAdvData.appIds_.isEmpty()) {
                    if (this.appIds_.isEmpty()) {
                        this.appIds_ = attrAdvData.appIds_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureAppIdsIsMutable();
                        this.appIds_.addAll(attrAdvData.appIds_);
                    }
                    onChanged();
                }
                mergeUnknownFields(attrAdvData.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrAdvData attrAdvData;
                AttrAdvData attrAdvData2 = null;
                try {
                    AttrAdvData parsePartialFrom = AttrAdvData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrAdvData = (AttrAdvData) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrAdvData2 = attrAdvData;
                    if (attrAdvData2 != null) {
                    }
                    throw th;
                }
            }

            public final int getVersionMajor() {
                return this.versionMajor_;
            }

            public final Builder setVersionMajor(int i) {
                this.versionMajor_ = i;
                onChanged();
                return this;
            }

            public final Builder clearVersionMajor() {
                this.versionMajor_ = 0;
                onChanged();
                return this;
            }

            public final int getVersionMinor() {
                return this.versionMinor_;
            }

            public final Builder setVersionMinor(int i) {
                this.versionMinor_ = i;
                onChanged();
                return this;
            }

            public final Builder clearVersionMinor() {
                this.versionMinor_ = 0;
                onChanged();
                return this;
            }

            public final ByteString getApps() {
                return this.apps_;
            }

            public final Builder setApps(ByteString byteString) {
                if (byteString != null) {
                    this.apps_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearApps() {
                this.apps_ = AttrAdvData.getDefaultInstance().getApps();
                onChanged();
                return this;
            }

            public final ByteString getFlags() {
                return this.flags_;
            }

            public final Builder setFlags(ByteString byteString) {
                if (byteString != null) {
                    this.flags_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearFlags() {
                this.flags_ = AttrAdvData.getDefaultInstance().getFlags();
                onChanged();
                return this;
            }

            public final String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getNameBytes() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setName(String str) {
                if (str != null) {
                    this.name_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearName() {
                this.name_ = AttrAdvData.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public final Builder setNameBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrAdvData.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final ByteString getIdHash() {
                return this.idHash_;
            }

            public final Builder setIdHash(ByteString byteString) {
                if (byteString != null) {
                    this.idHash_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearIdHash() {
                this.idHash_ = AttrAdvData.getDefaultInstance().getIdHash();
                onChanged();
                return this;
            }

            public final int getDeviceType() {
                return this.deviceType_;
            }

            public final Builder setDeviceType(int i) {
                this.deviceType_ = i;
                onChanged();
                return this;
            }

            public final Builder clearDeviceType() {
                this.deviceType_ = 0;
                onChanged();
                return this;
            }

            public final int getSecurityMode() {
                return this.securityMode_;
            }

            public final Builder setSecurityMode(int i) {
                this.securityMode_ = i;
                onChanged();
                return this;
            }

            public final Builder clearSecurityMode() {
                this.securityMode_ = 0;
                onChanged();
                return this;
            }

            private void ensureAppsDataIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.appsData_ = new ArrayList(this.appsData_);
                    this.bitField0_ |= 1;
                }
            }

            public final List<ByteString> getAppsDataList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.appsData_) : this.appsData_;
            }

            public final int getAppsDataCount() {
                return this.appsData_.size();
            }

            public final ByteString getAppsData(int i) {
                return this.appsData_.get(i);
            }

            public final Builder setAppsData(int i, ByteString byteString) {
                if (byteString != null) {
                    ensureAppsDataIsMutable();
                    this.appsData_.set(i, byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder addAppsData(ByteString byteString) {
                if (byteString != null) {
                    ensureAppsDataIsMutable();
                    this.appsData_.add(byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
             arg types: [java.lang.Iterable<? extends com.google.protobuf.ByteString>, java.util.List<com.google.protobuf.ByteString>]
             candidates:
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
            public final Builder addAllAppsData(Iterable<? extends ByteString> iterable) {
                ensureAppsDataIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.appsData_);
                onChanged();
                return this;
            }

            public final Builder clearAppsData() {
                this.appsData_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureSupportSettingIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.supportSetting_ = new ArrayList(this.supportSetting_);
                    this.bitField0_ |= 2;
                }
            }

            public final List<ByteString> getSupportSettingList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.supportSetting_) : this.supportSetting_;
            }

            public final int getSupportSettingCount() {
                return this.supportSetting_.size();
            }

            public final ByteString getSupportSetting(int i) {
                return this.supportSetting_.get(i);
            }

            public final Builder setSupportSetting(int i, ByteString byteString) {
                if (byteString != null) {
                    ensureSupportSettingIsMutable();
                    this.supportSetting_.set(i, byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder addSupportSetting(ByteString byteString) {
                if (byteString != null) {
                    ensureSupportSettingIsMutable();
                    this.supportSetting_.add(byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
             arg types: [java.lang.Iterable<? extends com.google.protobuf.ByteString>, java.util.List<com.google.protobuf.ByteString>]
             candidates:
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
            public final Builder addAllSupportSetting(Iterable<? extends ByteString> iterable) {
                ensureSupportSettingIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.supportSetting_);
                onChanged();
                return this;
            }

            public final Builder clearSupportSetting() {
                this.supportSetting_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureCurrentSettingIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.currentSetting_ = new ArrayList(this.currentSetting_);
                    this.bitField0_ |= 4;
                }
            }

            public final List<ByteString> getCurrentSettingList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.currentSetting_) : this.currentSetting_;
            }

            public final int getCurrentSettingCount() {
                return this.currentSetting_.size();
            }

            public final ByteString getCurrentSetting(int i) {
                return this.currentSetting_.get(i);
            }

            public final Builder setCurrentSetting(int i, ByteString byteString) {
                if (byteString != null) {
                    ensureCurrentSettingIsMutable();
                    this.currentSetting_.set(i, byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder addCurrentSetting(ByteString byteString) {
                if (byteString != null) {
                    ensureCurrentSettingIsMutable();
                    this.currentSetting_.add(byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
             arg types: [java.lang.Iterable<? extends com.google.protobuf.ByteString>, java.util.List<com.google.protobuf.ByteString>]
             candidates:
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
            public final Builder addAllCurrentSetting(Iterable<? extends ByteString> iterable) {
                ensureCurrentSettingIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.currentSetting_);
                onChanged();
                return this;
            }

            public final Builder clearCurrentSetting() {
                this.currentSetting_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public final String getWifiMac() {
                Object obj = this.wifiMac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wifiMac_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getWifiMacBytes() {
                Object obj = this.wifiMac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.wifiMac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setWifiMac(String str) {
                if (str != null) {
                    this.wifiMac_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearWifiMac() {
                this.wifiMac_ = AttrAdvData.getDefaultInstance().getWifiMac();
                onChanged();
                return this;
            }

            public final Builder setWifiMacBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrAdvData.checkByteStringIsUtf8(byteString);
                    this.wifiMac_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            private void ensureAppIdsIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.appIds_ = AttrAdvData.mutableCopy(this.appIds_);
                    this.bitField0_ |= 8;
                }
            }

            public final List<Integer> getAppIdsList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.appIds_) : this.appIds_;
            }

            public final int getAppIdsCount() {
                return this.appIds_.size();
            }

            public final int getAppIds(int i) {
                return this.appIds_.getInt(i);
            }

            public final Builder setAppIds(int i, int i2) {
                ensureAppIdsIsMutable();
                this.appIds_.setInt(i, i2);
                onChanged();
                return this;
            }

            public final Builder addAppIds(int i) {
                ensureAppIdsIsMutable();
                this.appIds_.addInt(i);
                onChanged();
                return this;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
             arg types: [java.lang.Iterable<? extends java.lang.Integer>, com.google.protobuf.Internal$IntList]
             candidates:
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
            public final Builder addAllAppIds(Iterable<? extends Integer> iterable) {
                ensureAppIdsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.appIds_);
                onChanged();
                return this;
            }

            public final Builder clearAppIds() {
                this.appIds_ = AttrAdvData.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrAdvData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrAdvData> parser() {
            return PARSER;
        }

        public final Parser<AttrAdvData> getParserForType() {
            return PARSER;
        }

        public final AttrAdvData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrWriteRequest extends GeneratedMessageV3 implements AttrWriteRequestOrBuilder {
        private static final AttrWriteRequest DEFAULT_INSTANCE = new AttrWriteRequest();
        public static final Parser<AttrWriteRequest> PARSER = new AbstractParser<AttrWriteRequest>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.AnonymousClass1 */

            public final AttrWriteRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrWriteRequest(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public volatile Object uuid_;
        public ByteString value_;

        /* synthetic */ AttrWriteRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrWriteRequest(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrWriteRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrWriteRequest() {
            this.memoizedIsInitialized = -1;
            this.uuid_ = "";
            this.value_ = ByteString.EMPTY;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrWriteRequest();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrWriteRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.uuid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.value_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrWriteRequest.class, Builder.class);
        }

        public final String getUuid() {
            Object obj = this.uuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uuid_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getUuidBytes() {
            Object obj = this.uuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final ByteString getValue() {
            return this.value_;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUuidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.uuid_);
            }
            if (!this.value_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.value_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUuidBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.uuid_);
            }
            if (!this.value_.isEmpty()) {
                i2 += CodedOutputStream.computeBytesSize(2, this.value_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(3, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrWriteRequest)) {
                return super.equals(obj);
            }
            AttrWriteRequest attrWriteRequest = (AttrWriteRequest) obj;
            if (getUuid().equals(attrWriteRequest.getUuid()) && getValue().equals(attrWriteRequest.getValue()) && getIndex() == attrWriteRequest.getIndex() && this.unknownFields.equals(attrWriteRequest.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getUuid().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 37) + 3) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrWriteRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrWriteRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrWriteRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrWriteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrWriteRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrWriteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrWriteRequest parseFrom(InputStream inputStream) throws IOException {
            return (AttrWriteRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrWriteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrWriteRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrWriteRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrWriteRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrWriteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrWriteRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrWriteRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrWriteRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrWriteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrWriteRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrWriteRequest attrWriteRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrWriteRequest);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrWriteRequestOrBuilder {
            private int index_;
            private Object uuid_;
            private ByteString value_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrWriteRequest.class, Builder.class);
            }

            private Builder() {
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrWriteRequest.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteRequest_descriptor;
            }

            public final AttrWriteRequest getDefaultInstanceForType() {
                return AttrWriteRequest.getDefaultInstance();
            }

            public final AttrWriteRequest build() {
                AttrWriteRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrWriteRequest buildPartial() {
                AttrWriteRequest attrWriteRequest = new AttrWriteRequest(this, (AnonymousClass1) null);
                attrWriteRequest.uuid_ = this.uuid_;
                attrWriteRequest.value_ = this.value_;
                attrWriteRequest.index_ = this.index_;
                onBuilt();
                return attrWriteRequest;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrWriteRequest) {
                    return mergeFrom((AttrWriteRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrWriteRequest attrWriteRequest) {
                if (attrWriteRequest == AttrWriteRequest.getDefaultInstance()) {
                    return this;
                }
                if (!attrWriteRequest.getUuid().isEmpty()) {
                    this.uuid_ = attrWriteRequest.uuid_;
                    onChanged();
                }
                if (attrWriteRequest.getValue() != ByteString.EMPTY) {
                    setValue(attrWriteRequest.getValue());
                }
                if (attrWriteRequest.getIndex() != 0) {
                    setIndex(attrWriteRequest.getIndex());
                }
                mergeUnknownFields(attrWriteRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrWriteRequest attrWriteRequest;
                AttrWriteRequest attrWriteRequest2 = null;
                try {
                    AttrWriteRequest parsePartialFrom = AttrWriteRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrWriteRequest = (AttrWriteRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrWriteRequest2 = attrWriteRequest;
                    if (attrWriteRequest2 != null) {
                    }
                    throw th;
                }
            }

            public final String getUuid() {
                Object obj = this.uuid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uuid_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getUuidBytes() {
                Object obj = this.uuid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uuid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setUuid(String str) {
                if (str != null) {
                    this.uuid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearUuid() {
                this.uuid_ = AttrWriteRequest.getDefaultInstance().getUuid();
                onChanged();
                return this;
            }

            public final Builder setUuidBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrWriteRequest.checkByteStringIsUtf8(byteString);
                    this.uuid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final ByteString getValue() {
                return this.value_;
            }

            public final Builder setValue(ByteString byteString) {
                if (byteString != null) {
                    this.value_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearValue() {
                this.value_ = AttrWriteRequest.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrWriteRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrWriteRequest> parser() {
            return PARSER;
        }

        public final Parser<AttrWriteRequest> getParserForType() {
            return PARSER;
        }

        public final AttrWriteRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrWriteResponse extends GeneratedMessageV3 implements AttrWriteResponseOrBuilder {
        private static final AttrWriteResponse DEFAULT_INSTANCE = new AttrWriteResponse();
        public static final Parser<AttrWriteResponse> PARSER = new AbstractParser<AttrWriteResponse>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.AnonymousClass1 */

            public final AttrWriteResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrWriteResponse(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public int res_;

        /* synthetic */ AttrWriteResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrWriteResponse(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrWriteResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrWriteResponse() {
            this.memoizedIsInitialized = -1;
            this.res_ = 0;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrWriteResponse();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrWriteResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.res_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrWriteResponse.class, Builder.class);
        }

        public final int getResValue() {
            return this.res_;
        }

        public final ResultEnum getRes() {
            ResultEnum valueOf = ResultEnum.valueOf(this.res_);
            return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.res_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.res_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrWriteResponse)) {
                return super.equals(obj);
            }
            AttrWriteResponse attrWriteResponse = (AttrWriteResponse) obj;
            if (this.res_ == attrWriteResponse.res_ && getIndex() == attrWriteResponse.getIndex() && this.unknownFields.equals(attrWriteResponse.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.res_) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrWriteResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrWriteResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrWriteResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrWriteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrWriteResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrWriteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrWriteResponse parseFrom(InputStream inputStream) throws IOException {
            return (AttrWriteResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrWriteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrWriteResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrWriteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrWriteResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrWriteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrWriteResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrWriteResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrWriteResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrWriteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrWriteResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrWriteResponse attrWriteResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrWriteResponse);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrWriteResponseOrBuilder {
            private int index_;
            private int res_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrWriteResponse.class, Builder.class);
            }

            private Builder() {
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrWriteResponse.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.res_ = 0;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrWriteResponse_descriptor;
            }

            public final AttrWriteResponse getDefaultInstanceForType() {
                return AttrWriteResponse.getDefaultInstance();
            }

            public final AttrWriteResponse build() {
                AttrWriteResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrWriteResponse buildPartial() {
                AttrWriteResponse attrWriteResponse = new AttrWriteResponse(this, (AnonymousClass1) null);
                attrWriteResponse.res_ = this.res_;
                attrWriteResponse.index_ = this.index_;
                onBuilt();
                return attrWriteResponse;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrWriteResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrWriteResponse) {
                    return mergeFrom((AttrWriteResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrWriteResponse attrWriteResponse) {
                if (attrWriteResponse == AttrWriteResponse.getDefaultInstance()) {
                    return this;
                }
                if (attrWriteResponse.res_ != 0) {
                    setResValue(attrWriteResponse.getResValue());
                }
                if (attrWriteResponse.getIndex() != 0) {
                    setIndex(attrWriteResponse.getIndex());
                }
                mergeUnknownFields(attrWriteResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrWriteResponse attrWriteResponse;
                AttrWriteResponse attrWriteResponse2 = null;
                try {
                    AttrWriteResponse parsePartialFrom = AttrWriteResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrWriteResponse = (AttrWriteResponse) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrWriteResponse2 = attrWriteResponse;
                    if (attrWriteResponse2 != null) {
                    }
                    throw th;
                }
            }

            public final int getResValue() {
                return this.res_;
            }

            public final Builder setResValue(int i) {
                this.res_ = i;
                onChanged();
                return this;
            }

            public final ResultEnum getRes() {
                ResultEnum valueOf = ResultEnum.valueOf(this.res_);
                return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
            }

            public final Builder setRes(ResultEnum resultEnum) {
                if (resultEnum != null) {
                    this.res_ = resultEnum.getNumber();
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearRes() {
                this.res_ = 0;
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrWriteResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrWriteResponse> parser() {
            return PARSER;
        }

        public final Parser<AttrWriteResponse> getParserForType() {
            return PARSER;
        }

        public final AttrWriteResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrReadRequest extends GeneratedMessageV3 implements AttrReadRequestOrBuilder {
        private static final AttrReadRequest DEFAULT_INSTANCE = new AttrReadRequest();
        public static final Parser<AttrReadRequest> PARSER = new AbstractParser<AttrReadRequest>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.AnonymousClass1 */

            public final AttrReadRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrReadRequest(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public volatile Object uuid_;

        /* synthetic */ AttrReadRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrReadRequest(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrReadRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrReadRequest() {
            this.memoizedIsInitialized = -1;
            this.uuid_ = "";
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrReadRequest();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrReadRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.uuid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrReadRequest.class, Builder.class);
        }

        public final String getUuid() {
            Object obj = this.uuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uuid_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getUuidBytes() {
            Object obj = this.uuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUuidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.uuid_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUuidBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.uuid_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrReadRequest)) {
                return super.equals(obj);
            }
            AttrReadRequest attrReadRequest = (AttrReadRequest) obj;
            if (getUuid().equals(attrReadRequest.getUuid()) && getIndex() == attrReadRequest.getIndex() && this.unknownFields.equals(attrReadRequest.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getUuid().hashCode()) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrReadRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrReadRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrReadRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrReadRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrReadRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrReadRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrReadRequest parseFrom(InputStream inputStream) throws IOException {
            return (AttrReadRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrReadRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrReadRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrReadRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrReadRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrReadRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrReadRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrReadRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrReadRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrReadRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrReadRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrReadRequest attrReadRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrReadRequest);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrReadRequestOrBuilder {
            private int index_;
            private Object uuid_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrReadRequest.class, Builder.class);
            }

            private Builder() {
                this.uuid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uuid_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrReadRequest.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.uuid_ = "";
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadRequest_descriptor;
            }

            public final AttrReadRequest getDefaultInstanceForType() {
                return AttrReadRequest.getDefaultInstance();
            }

            public final AttrReadRequest build() {
                AttrReadRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrReadRequest buildPartial() {
                AttrReadRequest attrReadRequest = new AttrReadRequest(this, (AnonymousClass1) null);
                attrReadRequest.uuid_ = this.uuid_;
                attrReadRequest.index_ = this.index_;
                onBuilt();
                return attrReadRequest;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrReadRequest) {
                    return mergeFrom((AttrReadRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrReadRequest attrReadRequest) {
                if (attrReadRequest == AttrReadRequest.getDefaultInstance()) {
                    return this;
                }
                if (!attrReadRequest.getUuid().isEmpty()) {
                    this.uuid_ = attrReadRequest.uuid_;
                    onChanged();
                }
                if (attrReadRequest.getIndex() != 0) {
                    setIndex(attrReadRequest.getIndex());
                }
                mergeUnknownFields(attrReadRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrReadRequest attrReadRequest;
                AttrReadRequest attrReadRequest2 = null;
                try {
                    AttrReadRequest parsePartialFrom = AttrReadRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrReadRequest = (AttrReadRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrReadRequest2 = attrReadRequest;
                    if (attrReadRequest2 != null) {
                    }
                    throw th;
                }
            }

            public final String getUuid() {
                Object obj = this.uuid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uuid_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getUuidBytes() {
                Object obj = this.uuid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uuid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setUuid(String str) {
                if (str != null) {
                    this.uuid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearUuid() {
                this.uuid_ = AttrReadRequest.getDefaultInstance().getUuid();
                onChanged();
                return this;
            }

            public final Builder setUuidBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrReadRequest.checkByteStringIsUtf8(byteString);
                    this.uuid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrReadRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrReadRequest> parser() {
            return PARSER;
        }

        public final Parser<AttrReadRequest> getParserForType() {
            return PARSER;
        }

        public final AttrReadRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrReadResponse extends GeneratedMessageV3 implements AttrReadResponseOrBuilder {
        private static final AttrReadResponse DEFAULT_INSTANCE = new AttrReadResponse();
        public static final Parser<AttrReadResponse> PARSER = new AbstractParser<AttrReadResponse>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.AnonymousClass1 */

            public final AttrReadResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrReadResponse(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public int res_;
        public ByteString value_;

        /* synthetic */ AttrReadResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrReadResponse(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrReadResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrReadResponse() {
            this.memoizedIsInitialized = -1;
            this.res_ = 0;
            this.value_ = ByteString.EMPTY;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrReadResponse();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrReadResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.res_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                this.value_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrReadResponse.class, Builder.class);
        }

        public final int getResValue() {
            return this.res_;
        }

        public final ResultEnum getRes() {
            ResultEnum valueOf = ResultEnum.valueOf(this.res_);
            return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
        }

        public final ByteString getValue() {
            return this.value_;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.res_);
            }
            if (!this.value_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.value_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.res_);
            }
            if (!this.value_.isEmpty()) {
                i2 += CodedOutputStream.computeBytesSize(2, this.value_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(3, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrReadResponse)) {
                return super.equals(obj);
            }
            AttrReadResponse attrReadResponse = (AttrReadResponse) obj;
            if (this.res_ == attrReadResponse.res_ && getValue().equals(attrReadResponse.getValue()) && getIndex() == attrReadResponse.getIndex() && this.unknownFields.equals(attrReadResponse.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.res_) * 37) + 2) * 53) + getValue().hashCode()) * 37) + 3) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrReadResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrReadResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrReadResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrReadResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrReadResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrReadResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrReadResponse parseFrom(InputStream inputStream) throws IOException {
            return (AttrReadResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrReadResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrReadResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrReadResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrReadResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrReadResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrReadResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrReadResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrReadResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrReadResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrReadResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrReadResponse attrReadResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrReadResponse);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrReadResponseOrBuilder {
            private int index_;
            private int res_;
            private ByteString value_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrReadResponse.class, Builder.class);
            }

            private Builder() {
                this.res_ = 0;
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.res_ = 0;
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrReadResponse.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.res_ = 0;
                this.value_ = ByteString.EMPTY;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrReadResponse_descriptor;
            }

            public final AttrReadResponse getDefaultInstanceForType() {
                return AttrReadResponse.getDefaultInstance();
            }

            public final AttrReadResponse build() {
                AttrReadResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrReadResponse buildPartial() {
                AttrReadResponse attrReadResponse = new AttrReadResponse(this, (AnonymousClass1) null);
                attrReadResponse.res_ = this.res_;
                attrReadResponse.value_ = this.value_;
                attrReadResponse.index_ = this.index_;
                onBuilt();
                return attrReadResponse;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrReadResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrReadResponse) {
                    return mergeFrom((AttrReadResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrReadResponse attrReadResponse) {
                if (attrReadResponse == AttrReadResponse.getDefaultInstance()) {
                    return this;
                }
                if (attrReadResponse.res_ != 0) {
                    setResValue(attrReadResponse.getResValue());
                }
                if (attrReadResponse.getValue() != ByteString.EMPTY) {
                    setValue(attrReadResponse.getValue());
                }
                if (attrReadResponse.getIndex() != 0) {
                    setIndex(attrReadResponse.getIndex());
                }
                mergeUnknownFields(attrReadResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrReadResponse attrReadResponse;
                AttrReadResponse attrReadResponse2 = null;
                try {
                    AttrReadResponse parsePartialFrom = AttrReadResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrReadResponse = (AttrReadResponse) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrReadResponse2 = attrReadResponse;
                    if (attrReadResponse2 != null) {
                    }
                    throw th;
                }
            }

            public final int getResValue() {
                return this.res_;
            }

            public final Builder setResValue(int i) {
                this.res_ = i;
                onChanged();
                return this;
            }

            public final ResultEnum getRes() {
                ResultEnum valueOf = ResultEnum.valueOf(this.res_);
                return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
            }

            public final Builder setRes(ResultEnum resultEnum) {
                if (resultEnum != null) {
                    this.res_ = resultEnum.getNumber();
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearRes() {
                this.res_ = 0;
                onChanged();
                return this;
            }

            public final ByteString getValue() {
                return this.value_;
            }

            public final Builder setValue(ByteString byteString) {
                if (byteString != null) {
                    this.value_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearValue() {
                this.value_ = AttrReadResponse.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrReadResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrReadResponse> parser() {
            return PARSER;
        }

        public final Parser<AttrReadResponse> getParserForType() {
            return PARSER;
        }

        public final AttrReadResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrSetNotifyRequest extends GeneratedMessageV3 implements AttrSetNotifyRequestOrBuilder {
        private static final AttrSetNotifyRequest DEFAULT_INSTANCE = new AttrSetNotifyRequest();
        public static final Parser<AttrSetNotifyRequest> PARSER = new AbstractParser<AttrSetNotifyRequest>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.AnonymousClass1 */

            public final AttrSetNotifyRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrSetNotifyRequest(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public volatile Object uuid_;

        /* synthetic */ AttrSetNotifyRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrSetNotifyRequest(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrSetNotifyRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrSetNotifyRequest() {
            this.memoizedIsInitialized = -1;
            this.uuid_ = "";
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrSetNotifyRequest();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrSetNotifyRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.uuid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrSetNotifyRequest.class, Builder.class);
        }

        public final String getUuid() {
            Object obj = this.uuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uuid_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getUuidBytes() {
            Object obj = this.uuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUuidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.uuid_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUuidBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.uuid_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrSetNotifyRequest)) {
                return super.equals(obj);
            }
            AttrSetNotifyRequest attrSetNotifyRequest = (AttrSetNotifyRequest) obj;
            if (getUuid().equals(attrSetNotifyRequest.getUuid()) && getIndex() == attrSetNotifyRequest.getIndex() && this.unknownFields.equals(attrSetNotifyRequest.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getUuid().hashCode()) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrSetNotifyRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrSetNotifyRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrSetNotifyRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrSetNotifyRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrSetNotifyRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrSetNotifyRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrSetNotifyRequest parseFrom(InputStream inputStream) throws IOException {
            return (AttrSetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrSetNotifyRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrSetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrSetNotifyRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrSetNotifyRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrSetNotifyRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrSetNotifyRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrSetNotifyRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrSetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrSetNotifyRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrSetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrSetNotifyRequest attrSetNotifyRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrSetNotifyRequest);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrSetNotifyRequestOrBuilder {
            private int index_;
            private Object uuid_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrSetNotifyRequest.class, Builder.class);
            }

            private Builder() {
                this.uuid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uuid_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrSetNotifyRequest.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.uuid_ = "";
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyRequest_descriptor;
            }

            public final AttrSetNotifyRequest getDefaultInstanceForType() {
                return AttrSetNotifyRequest.getDefaultInstance();
            }

            public final AttrSetNotifyRequest build() {
                AttrSetNotifyRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrSetNotifyRequest buildPartial() {
                AttrSetNotifyRequest attrSetNotifyRequest = new AttrSetNotifyRequest(this, (AnonymousClass1) null);
                attrSetNotifyRequest.uuid_ = this.uuid_;
                attrSetNotifyRequest.index_ = this.index_;
                onBuilt();
                return attrSetNotifyRequest;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrSetNotifyRequest) {
                    return mergeFrom((AttrSetNotifyRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrSetNotifyRequest attrSetNotifyRequest) {
                if (attrSetNotifyRequest == AttrSetNotifyRequest.getDefaultInstance()) {
                    return this;
                }
                if (!attrSetNotifyRequest.getUuid().isEmpty()) {
                    this.uuid_ = attrSetNotifyRequest.uuid_;
                    onChanged();
                }
                if (attrSetNotifyRequest.getIndex() != 0) {
                    setIndex(attrSetNotifyRequest.getIndex());
                }
                mergeUnknownFields(attrSetNotifyRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrSetNotifyRequest attrSetNotifyRequest;
                AttrSetNotifyRequest attrSetNotifyRequest2 = null;
                try {
                    AttrSetNotifyRequest parsePartialFrom = AttrSetNotifyRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrSetNotifyRequest = (AttrSetNotifyRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrSetNotifyRequest2 = attrSetNotifyRequest;
                    if (attrSetNotifyRequest2 != null) {
                    }
                    throw th;
                }
            }

            public final String getUuid() {
                Object obj = this.uuid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uuid_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getUuidBytes() {
                Object obj = this.uuid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uuid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setUuid(String str) {
                if (str != null) {
                    this.uuid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearUuid() {
                this.uuid_ = AttrSetNotifyRequest.getDefaultInstance().getUuid();
                onChanged();
                return this;
            }

            public final Builder setUuidBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrSetNotifyRequest.checkByteStringIsUtf8(byteString);
                    this.uuid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrSetNotifyRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrSetNotifyRequest> parser() {
            return PARSER;
        }

        public final Parser<AttrSetNotifyRequest> getParserForType() {
            return PARSER;
        }

        public final AttrSetNotifyRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrSetNotifyResponse extends GeneratedMessageV3 implements AttrSetNotifyResponseOrBuilder {
        private static final AttrSetNotifyResponse DEFAULT_INSTANCE = new AttrSetNotifyResponse();
        public static final Parser<AttrSetNotifyResponse> PARSER = new AbstractParser<AttrSetNotifyResponse>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.AnonymousClass1 */

            public final AttrSetNotifyResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrSetNotifyResponse(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public int res_;

        /* synthetic */ AttrSetNotifyResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrSetNotifyResponse(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrSetNotifyResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrSetNotifyResponse() {
            this.memoizedIsInitialized = -1;
            this.res_ = 0;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrSetNotifyResponse();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrSetNotifyResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.res_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrSetNotifyResponse.class, Builder.class);
        }

        public final int getResValue() {
            return this.res_;
        }

        public final ResultEnum getRes() {
            ResultEnum valueOf = ResultEnum.valueOf(this.res_);
            return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.res_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.res_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrSetNotifyResponse)) {
                return super.equals(obj);
            }
            AttrSetNotifyResponse attrSetNotifyResponse = (AttrSetNotifyResponse) obj;
            if (this.res_ == attrSetNotifyResponse.res_ && getIndex() == attrSetNotifyResponse.getIndex() && this.unknownFields.equals(attrSetNotifyResponse.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.res_) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrSetNotifyResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrSetNotifyResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrSetNotifyResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrSetNotifyResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrSetNotifyResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrSetNotifyResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrSetNotifyResponse parseFrom(InputStream inputStream) throws IOException {
            return (AttrSetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrSetNotifyResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrSetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrSetNotifyResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrSetNotifyResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrSetNotifyResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrSetNotifyResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrSetNotifyResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrSetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrSetNotifyResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrSetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrSetNotifyResponse attrSetNotifyResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrSetNotifyResponse);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrSetNotifyResponseOrBuilder {
            private int index_;
            private int res_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrSetNotifyResponse.class, Builder.class);
            }

            private Builder() {
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrSetNotifyResponse.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.res_ = 0;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrSetNotifyResponse_descriptor;
            }

            public final AttrSetNotifyResponse getDefaultInstanceForType() {
                return AttrSetNotifyResponse.getDefaultInstance();
            }

            public final AttrSetNotifyResponse build() {
                AttrSetNotifyResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrSetNotifyResponse buildPartial() {
                AttrSetNotifyResponse attrSetNotifyResponse = new AttrSetNotifyResponse(this, (AnonymousClass1) null);
                attrSetNotifyResponse.res_ = this.res_;
                attrSetNotifyResponse.index_ = this.index_;
                onBuilt();
                return attrSetNotifyResponse;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrSetNotifyResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrSetNotifyResponse) {
                    return mergeFrom((AttrSetNotifyResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrSetNotifyResponse attrSetNotifyResponse) {
                if (attrSetNotifyResponse == AttrSetNotifyResponse.getDefaultInstance()) {
                    return this;
                }
                if (attrSetNotifyResponse.res_ != 0) {
                    setResValue(attrSetNotifyResponse.getResValue());
                }
                if (attrSetNotifyResponse.getIndex() != 0) {
                    setIndex(attrSetNotifyResponse.getIndex());
                }
                mergeUnknownFields(attrSetNotifyResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrSetNotifyResponse attrSetNotifyResponse;
                AttrSetNotifyResponse attrSetNotifyResponse2 = null;
                try {
                    AttrSetNotifyResponse parsePartialFrom = AttrSetNotifyResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrSetNotifyResponse = (AttrSetNotifyResponse) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrSetNotifyResponse2 = attrSetNotifyResponse;
                    if (attrSetNotifyResponse2 != null) {
                    }
                    throw th;
                }
            }

            public final int getResValue() {
                return this.res_;
            }

            public final Builder setResValue(int i) {
                this.res_ = i;
                onChanged();
                return this;
            }

            public final ResultEnum getRes() {
                ResultEnum valueOf = ResultEnum.valueOf(this.res_);
                return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
            }

            public final Builder setRes(ResultEnum resultEnum) {
                if (resultEnum != null) {
                    this.res_ = resultEnum.getNumber();
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearRes() {
                this.res_ = 0;
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrSetNotifyResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrSetNotifyResponse> parser() {
            return PARSER;
        }

        public final Parser<AttrSetNotifyResponse> getParserForType() {
            return PARSER;
        }

        public final AttrSetNotifyResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrUnsetNotifyRequest extends GeneratedMessageV3 implements AttrUnsetNotifyRequestOrBuilder {
        private static final AttrUnsetNotifyRequest DEFAULT_INSTANCE = new AttrUnsetNotifyRequest();
        public static final Parser<AttrUnsetNotifyRequest> PARSER = new AbstractParser<AttrUnsetNotifyRequest>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.AnonymousClass1 */

            public final AttrUnsetNotifyRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrUnsetNotifyRequest(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public volatile Object uuid_;

        /* synthetic */ AttrUnsetNotifyRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrUnsetNotifyRequest(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrUnsetNotifyRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrUnsetNotifyRequest() {
            this.memoizedIsInitialized = -1;
            this.uuid_ = "";
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrUnsetNotifyRequest();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrUnsetNotifyRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.uuid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrUnsetNotifyRequest.class, Builder.class);
        }

        public final String getUuid() {
            Object obj = this.uuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uuid_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getUuidBytes() {
            Object obj = this.uuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUuidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.uuid_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUuidBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.uuid_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrUnsetNotifyRequest)) {
                return super.equals(obj);
            }
            AttrUnsetNotifyRequest attrUnsetNotifyRequest = (AttrUnsetNotifyRequest) obj;
            if (getUuid().equals(attrUnsetNotifyRequest.getUuid()) && getIndex() == attrUnsetNotifyRequest.getIndex() && this.unknownFields.equals(attrUnsetNotifyRequest.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getUuid().hashCode()) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrUnsetNotifyRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrUnsetNotifyRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrUnsetNotifyRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrUnsetNotifyRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrUnsetNotifyRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrUnsetNotifyRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrUnsetNotifyRequest parseFrom(InputStream inputStream) throws IOException {
            return (AttrUnsetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrUnsetNotifyRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrUnsetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrUnsetNotifyRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrUnsetNotifyRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrUnsetNotifyRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrUnsetNotifyRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrUnsetNotifyRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrUnsetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrUnsetNotifyRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrUnsetNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrUnsetNotifyRequest attrUnsetNotifyRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrUnsetNotifyRequest);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrUnsetNotifyRequestOrBuilder {
            private int index_;
            private Object uuid_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrUnsetNotifyRequest.class, Builder.class);
            }

            private Builder() {
                this.uuid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uuid_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrUnsetNotifyRequest.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.uuid_ = "";
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyRequest_descriptor;
            }

            public final AttrUnsetNotifyRequest getDefaultInstanceForType() {
                return AttrUnsetNotifyRequest.getDefaultInstance();
            }

            public final AttrUnsetNotifyRequest build() {
                AttrUnsetNotifyRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrUnsetNotifyRequest buildPartial() {
                AttrUnsetNotifyRequest attrUnsetNotifyRequest = new AttrUnsetNotifyRequest(this, (AnonymousClass1) null);
                attrUnsetNotifyRequest.uuid_ = this.uuid_;
                attrUnsetNotifyRequest.index_ = this.index_;
                onBuilt();
                return attrUnsetNotifyRequest;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrUnsetNotifyRequest) {
                    return mergeFrom((AttrUnsetNotifyRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrUnsetNotifyRequest attrUnsetNotifyRequest) {
                if (attrUnsetNotifyRequest == AttrUnsetNotifyRequest.getDefaultInstance()) {
                    return this;
                }
                if (!attrUnsetNotifyRequest.getUuid().isEmpty()) {
                    this.uuid_ = attrUnsetNotifyRequest.uuid_;
                    onChanged();
                }
                if (attrUnsetNotifyRequest.getIndex() != 0) {
                    setIndex(attrUnsetNotifyRequest.getIndex());
                }
                mergeUnknownFields(attrUnsetNotifyRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrUnsetNotifyRequest attrUnsetNotifyRequest;
                AttrUnsetNotifyRequest attrUnsetNotifyRequest2 = null;
                try {
                    AttrUnsetNotifyRequest parsePartialFrom = AttrUnsetNotifyRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrUnsetNotifyRequest = (AttrUnsetNotifyRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrUnsetNotifyRequest2 = attrUnsetNotifyRequest;
                    if (attrUnsetNotifyRequest2 != null) {
                    }
                    throw th;
                }
            }

            public final String getUuid() {
                Object obj = this.uuid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uuid_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getUuidBytes() {
                Object obj = this.uuid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uuid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setUuid(String str) {
                if (str != null) {
                    this.uuid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearUuid() {
                this.uuid_ = AttrUnsetNotifyRequest.getDefaultInstance().getUuid();
                onChanged();
                return this;
            }

            public final Builder setUuidBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrUnsetNotifyRequest.checkByteStringIsUtf8(byteString);
                    this.uuid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrUnsetNotifyRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrUnsetNotifyRequest> parser() {
            return PARSER;
        }

        public final Parser<AttrUnsetNotifyRequest> getParserForType() {
            return PARSER;
        }

        public final AttrUnsetNotifyRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrUnsetNotifyResponse extends GeneratedMessageV3 implements AttrUnsetNotifyResponseOrBuilder {
        private static final AttrUnsetNotifyResponse DEFAULT_INSTANCE = new AttrUnsetNotifyResponse();
        public static final Parser<AttrUnsetNotifyResponse> PARSER = new AbstractParser<AttrUnsetNotifyResponse>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.AnonymousClass1 */

            public final AttrUnsetNotifyResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrUnsetNotifyResponse(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public int res_;

        /* synthetic */ AttrUnsetNotifyResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrUnsetNotifyResponse(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrUnsetNotifyResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrUnsetNotifyResponse() {
            this.memoizedIsInitialized = -1;
            this.res_ = 0;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrUnsetNotifyResponse();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrUnsetNotifyResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.res_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrUnsetNotifyResponse.class, Builder.class);
        }

        public final int getResValue() {
            return this.res_;
        }

        public final ResultEnum getRes() {
            ResultEnum valueOf = ResultEnum.valueOf(this.res_);
            return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.res_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.res_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrUnsetNotifyResponse)) {
                return super.equals(obj);
            }
            AttrUnsetNotifyResponse attrUnsetNotifyResponse = (AttrUnsetNotifyResponse) obj;
            if (this.res_ == attrUnsetNotifyResponse.res_ && getIndex() == attrUnsetNotifyResponse.getIndex() && this.unknownFields.equals(attrUnsetNotifyResponse.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.res_) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrUnsetNotifyResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrUnsetNotifyResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrUnsetNotifyResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrUnsetNotifyResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrUnsetNotifyResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrUnsetNotifyResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrUnsetNotifyResponse parseFrom(InputStream inputStream) throws IOException {
            return (AttrUnsetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrUnsetNotifyResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrUnsetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrUnsetNotifyResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrUnsetNotifyResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrUnsetNotifyResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrUnsetNotifyResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrUnsetNotifyResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrUnsetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrUnsetNotifyResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrUnsetNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrUnsetNotifyResponse attrUnsetNotifyResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrUnsetNotifyResponse);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrUnsetNotifyResponseOrBuilder {
            private int index_;
            private int res_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrUnsetNotifyResponse.class, Builder.class);
            }

            private Builder() {
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrUnsetNotifyResponse.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.res_ = 0;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrUnsetNotifyResponse_descriptor;
            }

            public final AttrUnsetNotifyResponse getDefaultInstanceForType() {
                return AttrUnsetNotifyResponse.getDefaultInstance();
            }

            public final AttrUnsetNotifyResponse build() {
                AttrUnsetNotifyResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrUnsetNotifyResponse buildPartial() {
                AttrUnsetNotifyResponse attrUnsetNotifyResponse = new AttrUnsetNotifyResponse(this, (AnonymousClass1) null);
                attrUnsetNotifyResponse.res_ = this.res_;
                attrUnsetNotifyResponse.index_ = this.index_;
                onBuilt();
                return attrUnsetNotifyResponse;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrUnsetNotifyResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrUnsetNotifyResponse) {
                    return mergeFrom((AttrUnsetNotifyResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrUnsetNotifyResponse attrUnsetNotifyResponse) {
                if (attrUnsetNotifyResponse == AttrUnsetNotifyResponse.getDefaultInstance()) {
                    return this;
                }
                if (attrUnsetNotifyResponse.res_ != 0) {
                    setResValue(attrUnsetNotifyResponse.getResValue());
                }
                if (attrUnsetNotifyResponse.getIndex() != 0) {
                    setIndex(attrUnsetNotifyResponse.getIndex());
                }
                mergeUnknownFields(attrUnsetNotifyResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrUnsetNotifyResponse attrUnsetNotifyResponse;
                AttrUnsetNotifyResponse attrUnsetNotifyResponse2 = null;
                try {
                    AttrUnsetNotifyResponse parsePartialFrom = AttrUnsetNotifyResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrUnsetNotifyResponse = (AttrUnsetNotifyResponse) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrUnsetNotifyResponse2 = attrUnsetNotifyResponse;
                    if (attrUnsetNotifyResponse2 != null) {
                    }
                    throw th;
                }
            }

            public final int getResValue() {
                return this.res_;
            }

            public final Builder setResValue(int i) {
                this.res_ = i;
                onChanged();
                return this;
            }

            public final ResultEnum getRes() {
                ResultEnum valueOf = ResultEnum.valueOf(this.res_);
                return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
            }

            public final Builder setRes(ResultEnum resultEnum) {
                if (resultEnum != null) {
                    this.res_ = resultEnum.getNumber();
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearRes() {
                this.res_ = 0;
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrUnsetNotifyResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrUnsetNotifyResponse> parser() {
            return PARSER;
        }

        public final Parser<AttrUnsetNotifyResponse> getParserForType() {
            return PARSER;
        }

        public final AttrUnsetNotifyResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrNotifyRequest extends GeneratedMessageV3 implements AttrNotifyRequestOrBuilder {
        private static final AttrNotifyRequest DEFAULT_INSTANCE = new AttrNotifyRequest();
        public static final Parser<AttrNotifyRequest> PARSER = new AbstractParser<AttrNotifyRequest>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.AnonymousClass1 */

            public final AttrNotifyRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrNotifyRequest(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public volatile Object uuid_;
        public ByteString value_;

        /* synthetic */ AttrNotifyRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrNotifyRequest(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrNotifyRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrNotifyRequest() {
            this.memoizedIsInitialized = -1;
            this.uuid_ = "";
            this.value_ = ByteString.EMPTY;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrNotifyRequest();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrNotifyRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.uuid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.value_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyRequest.class, Builder.class);
        }

        public final String getUuid() {
            Object obj = this.uuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uuid_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getUuidBytes() {
            Object obj = this.uuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final ByteString getValue() {
            return this.value_;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUuidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.uuid_);
            }
            if (!this.value_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.value_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUuidBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.uuid_);
            }
            if (!this.value_.isEmpty()) {
                i2 += CodedOutputStream.computeBytesSize(2, this.value_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(3, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrNotifyRequest)) {
                return super.equals(obj);
            }
            AttrNotifyRequest attrNotifyRequest = (AttrNotifyRequest) obj;
            if (getUuid().equals(attrNotifyRequest.getUuid()) && getValue().equals(attrNotifyRequest.getValue()) && getIndex() == attrNotifyRequest.getIndex() && this.unknownFields.equals(attrNotifyRequest.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getUuid().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 37) + 3) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrNotifyRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrNotifyRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrNotifyRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrNotifyRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrNotifyRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrNotifyRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrNotifyRequest parseFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrNotifyRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrNotifyRequest attrNotifyRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrNotifyRequest);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrNotifyRequestOrBuilder {
            private int index_;
            private Object uuid_;
            private ByteString value_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyRequest.class, Builder.class);
            }

            private Builder() {
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrNotifyRequest.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyRequest_descriptor;
            }

            public final AttrNotifyRequest getDefaultInstanceForType() {
                return AttrNotifyRequest.getDefaultInstance();
            }

            public final AttrNotifyRequest build() {
                AttrNotifyRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrNotifyRequest buildPartial() {
                AttrNotifyRequest attrNotifyRequest = new AttrNotifyRequest(this, (AnonymousClass1) null);
                attrNotifyRequest.uuid_ = this.uuid_;
                attrNotifyRequest.value_ = this.value_;
                attrNotifyRequest.index_ = this.index_;
                onBuilt();
                return attrNotifyRequest;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrNotifyRequest) {
                    return mergeFrom((AttrNotifyRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrNotifyRequest attrNotifyRequest) {
                if (attrNotifyRequest == AttrNotifyRequest.getDefaultInstance()) {
                    return this;
                }
                if (!attrNotifyRequest.getUuid().isEmpty()) {
                    this.uuid_ = attrNotifyRequest.uuid_;
                    onChanged();
                }
                if (attrNotifyRequest.getValue() != ByteString.EMPTY) {
                    setValue(attrNotifyRequest.getValue());
                }
                if (attrNotifyRequest.getIndex() != 0) {
                    setIndex(attrNotifyRequest.getIndex());
                }
                mergeUnknownFields(attrNotifyRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrNotifyRequest attrNotifyRequest;
                AttrNotifyRequest attrNotifyRequest2 = null;
                try {
                    AttrNotifyRequest parsePartialFrom = AttrNotifyRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrNotifyRequest = (AttrNotifyRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrNotifyRequest2 = attrNotifyRequest;
                    if (attrNotifyRequest2 != null) {
                    }
                    throw th;
                }
            }

            public final String getUuid() {
                Object obj = this.uuid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uuid_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getUuidBytes() {
                Object obj = this.uuid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uuid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setUuid(String str) {
                if (str != null) {
                    this.uuid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearUuid() {
                this.uuid_ = AttrNotifyRequest.getDefaultInstance().getUuid();
                onChanged();
                return this;
            }

            public final Builder setUuidBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrNotifyRequest.checkByteStringIsUtf8(byteString);
                    this.uuid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final ByteString getValue() {
                return this.value_;
            }

            public final Builder setValue(ByteString byteString) {
                if (byteString != null) {
                    this.value_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearValue() {
                this.value_ = AttrNotifyRequest.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrNotifyRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrNotifyRequest> parser() {
            return PARSER;
        }

        public final Parser<AttrNotifyRequest> getParserForType() {
            return PARSER;
        }

        public final AttrNotifyRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrNotifyResponse extends GeneratedMessageV3 implements AttrNotifyResponseOrBuilder {
        private static final AttrNotifyResponse DEFAULT_INSTANCE = new AttrNotifyResponse();
        public static final Parser<AttrNotifyResponse> PARSER = new AbstractParser<AttrNotifyResponse>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.AnonymousClass1 */

            public final AttrNotifyResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrNotifyResponse(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public int res_;

        /* synthetic */ AttrNotifyResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrNotifyResponse(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrNotifyResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrNotifyResponse() {
            this.memoizedIsInitialized = -1;
            this.res_ = 0;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrNotifyResponse();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrNotifyResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.res_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyResponse.class, Builder.class);
        }

        public final int getResValue() {
            return this.res_;
        }

        public final ResultEnum getRes() {
            ResultEnum valueOf = ResultEnum.valueOf(this.res_);
            return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.res_);
            }
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.res_ != ResultEnum.SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.res_);
            }
            int i3 = this.index_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrNotifyResponse)) {
                return super.equals(obj);
            }
            AttrNotifyResponse attrNotifyResponse = (AttrNotifyResponse) obj;
            if (this.res_ == attrNotifyResponse.res_ && getIndex() == attrNotifyResponse.getIndex() && this.unknownFields.equals(attrNotifyResponse.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.res_) * 37) + 2) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrNotifyResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrNotifyResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrNotifyResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrNotifyResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrNotifyResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrNotifyResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrNotifyResponse parseFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrNotifyResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrNotifyResponse attrNotifyResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrNotifyResponse);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrNotifyResponseOrBuilder {
            private int index_;
            private int res_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyResponse.class, Builder.class);
            }

            private Builder() {
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.res_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrNotifyResponse.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.res_ = 0;
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyResponse_descriptor;
            }

            public final AttrNotifyResponse getDefaultInstanceForType() {
                return AttrNotifyResponse.getDefaultInstance();
            }

            public final AttrNotifyResponse build() {
                AttrNotifyResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrNotifyResponse buildPartial() {
                AttrNotifyResponse attrNotifyResponse = new AttrNotifyResponse(this, (AnonymousClass1) null);
                attrNotifyResponse.res_ = this.res_;
                attrNotifyResponse.index_ = this.index_;
                onBuilt();
                return attrNotifyResponse;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrNotifyResponse) {
                    return mergeFrom((AttrNotifyResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrNotifyResponse attrNotifyResponse) {
                if (attrNotifyResponse == AttrNotifyResponse.getDefaultInstance()) {
                    return this;
                }
                if (attrNotifyResponse.res_ != 0) {
                    setResValue(attrNotifyResponse.getResValue());
                }
                if (attrNotifyResponse.getIndex() != 0) {
                    setIndex(attrNotifyResponse.getIndex());
                }
                mergeUnknownFields(attrNotifyResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrNotifyResponse attrNotifyResponse;
                AttrNotifyResponse attrNotifyResponse2 = null;
                try {
                    AttrNotifyResponse parsePartialFrom = AttrNotifyResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrNotifyResponse = (AttrNotifyResponse) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrNotifyResponse2 = attrNotifyResponse;
                    if (attrNotifyResponse2 != null) {
                    }
                    throw th;
                }
            }

            public final int getResValue() {
                return this.res_;
            }

            public final Builder setResValue(int i) {
                this.res_ = i;
                onChanged();
                return this;
            }

            public final ResultEnum getRes() {
                ResultEnum valueOf = ResultEnum.valueOf(this.res_);
                return valueOf == null ? ResultEnum.UNRECOGNIZED : valueOf;
            }

            public final Builder setRes(ResultEnum resultEnum) {
                if (resultEnum != null) {
                    this.res_ = resultEnum.getNumber();
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearRes() {
                this.res_ = 0;
                onChanged();
                return this;
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrNotifyResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrNotifyResponse> parser() {
            return PARSER;
        }

        public final Parser<AttrNotifyResponse> getParserForType() {
            return PARSER;
        }

        public final AttrNotifyResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrNotifyPull extends GeneratedMessageV3 implements AttrNotifyPullOrBuilder {
        private static final AttrNotifyPull DEFAULT_INSTANCE = new AttrNotifyPull();
        public static final Parser<AttrNotifyPull> PARSER = new AbstractParser<AttrNotifyPull>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.AnonymousClass1 */

            public final AttrNotifyPull parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrNotifyPull(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;

        /* synthetic */ AttrNotifyPull(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrNotifyPull(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrNotifyPull(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrNotifyPull() {
            this.memoizedIsInitialized = -1;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrNotifyPull();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrNotifyPull(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyPull.class, Builder.class);
        }

        public final int getIndex() {
            return this.index_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.index_;
            int i3 = 0;
            if (i2 != 0) {
                i3 = 0 + CodedOutputStream.computeInt32Size(1, i2);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrNotifyPull)) {
                return super.equals(obj);
            }
            AttrNotifyPull attrNotifyPull = (AttrNotifyPull) obj;
            if (getIndex() == attrNotifyPull.getIndex() && this.unknownFields.equals(attrNotifyPull.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getIndex()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrNotifyPull parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrNotifyPull parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrNotifyPull parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrNotifyPull parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrNotifyPull parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrNotifyPull parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrNotifyPull parseFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyPull) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyPull parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyPull) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyPull parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyPull) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyPull parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyPull) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyPull parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrNotifyPull) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrNotifyPull parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyPull) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrNotifyPull attrNotifyPull) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrNotifyPull);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrNotifyPullOrBuilder {
            private int index_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyPull.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrNotifyPull.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.index_ = 0;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPull_descriptor;
            }

            public final AttrNotifyPull getDefaultInstanceForType() {
                return AttrNotifyPull.getDefaultInstance();
            }

            public final AttrNotifyPull build() {
                AttrNotifyPull buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrNotifyPull buildPartial() {
                AttrNotifyPull attrNotifyPull = new AttrNotifyPull(this, (AnonymousClass1) null);
                attrNotifyPull.index_ = this.index_;
                onBuilt();
                return attrNotifyPull;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPull$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPull$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPull.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPull$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrNotifyPull) {
                    return mergeFrom((AttrNotifyPull) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrNotifyPull attrNotifyPull) {
                if (attrNotifyPull == AttrNotifyPull.getDefaultInstance()) {
                    return this;
                }
                if (attrNotifyPull.getIndex() != 0) {
                    setIndex(attrNotifyPull.getIndex());
                }
                mergeUnknownFields(attrNotifyPull.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrNotifyPull attrNotifyPull;
                AttrNotifyPull attrNotifyPull2 = null;
                try {
                    AttrNotifyPull parsePartialFrom = AttrNotifyPull.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrNotifyPull = (AttrNotifyPull) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrNotifyPull2 = attrNotifyPull;
                    if (attrNotifyPull2 != null) {
                    }
                    throw th;
                }
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrNotifyPull getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrNotifyPull> parser() {
            return PARSER;
        }

        public final Parser<AttrNotifyPull> getParserForType() {
            return PARSER;
        }

        public final AttrNotifyPull getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrNotifyPush extends GeneratedMessageV3 implements AttrNotifyPushOrBuilder {
        private static final AttrNotifyPush DEFAULT_INSTANCE = new AttrNotifyPush();
        public static final Parser<AttrNotifyPush> PARSER = new AbstractParser<AttrNotifyPush>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.AnonymousClass1 */

            public final AttrNotifyPush parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrNotifyPush(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int index_;
        private byte memoizedIsInitialized;
        public volatile Object uuid_;
        public ByteString value_;

        /* synthetic */ AttrNotifyPush(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrNotifyPush(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrNotifyPush(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttrNotifyPush() {
            this.memoizedIsInitialized = -1;
            this.uuid_ = "";
            this.value_ = ByteString.EMPTY;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrNotifyPush();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttrNotifyPush(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.uuid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.value_ = codedInputStream.readBytes();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyPush.class, Builder.class);
        }

        public final int getIndex() {
            return this.index_;
        }

        public final String getUuid() {
            Object obj = this.uuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uuid_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getUuidBytes() {
            Object obj = this.uuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final ByteString getValue() {
            return this.value_;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            if (!getUuidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.uuid_);
            }
            if (!this.value_.isEmpty()) {
                codedOutputStream.writeBytes(3, this.value_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.index_;
            int i3 = 0;
            if (i2 != 0) {
                i3 = 0 + CodedOutputStream.computeInt32Size(1, i2);
            }
            if (!getUuidBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(2, this.uuid_);
            }
            if (!this.value_.isEmpty()) {
                i3 += CodedOutputStream.computeBytesSize(3, this.value_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrNotifyPush)) {
                return super.equals(obj);
            }
            AttrNotifyPush attrNotifyPush = (AttrNotifyPush) obj;
            if (getIndex() == attrNotifyPush.getIndex() && getUuid().equals(attrNotifyPush.getUuid()) && getValue().equals(attrNotifyPush.getValue()) && this.unknownFields.equals(attrNotifyPush.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getIndex()) * 37) + 2) * 53) + getUuid().hashCode()) * 37) + 3) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AttrNotifyPush parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrNotifyPush parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrNotifyPush parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrNotifyPush parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrNotifyPush parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrNotifyPush parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrNotifyPush parseFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyPush) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyPush parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyPush) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyPush parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrNotifyPush) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrNotifyPush parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyPush) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrNotifyPush parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrNotifyPush) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrNotifyPush parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrNotifyPush) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrNotifyPush attrNotifyPush) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrNotifyPush);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrNotifyPushOrBuilder {
            private int index_;
            private Object uuid_;
            private ByteString value_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrNotifyPush.class, Builder.class);
            }

            private Builder() {
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrNotifyPush.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.index_ = 0;
                this.uuid_ = "";
                this.value_ = ByteString.EMPTY;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrNotifyPush_descriptor;
            }

            public final AttrNotifyPush getDefaultInstanceForType() {
                return AttrNotifyPush.getDefaultInstance();
            }

            public final AttrNotifyPush build() {
                AttrNotifyPush buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrNotifyPush buildPartial() {
                AttrNotifyPush attrNotifyPush = new AttrNotifyPush(this, (AnonymousClass1) null);
                attrNotifyPush.index_ = this.index_;
                attrNotifyPush.uuid_ = this.uuid_;
                attrNotifyPush.value_ = this.value_;
                onBuilt();
                return attrNotifyPush;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPush$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPush$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrNotifyPush.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPush$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrNotifyPush) {
                    return mergeFrom((AttrNotifyPush) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrNotifyPush attrNotifyPush) {
                if (attrNotifyPush == AttrNotifyPush.getDefaultInstance()) {
                    return this;
                }
                if (attrNotifyPush.getIndex() != 0) {
                    setIndex(attrNotifyPush.getIndex());
                }
                if (!attrNotifyPush.getUuid().isEmpty()) {
                    this.uuid_ = attrNotifyPush.uuid_;
                    onChanged();
                }
                if (attrNotifyPush.getValue() != ByteString.EMPTY) {
                    setValue(attrNotifyPush.getValue());
                }
                mergeUnknownFields(attrNotifyPush.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrNotifyPush attrNotifyPush;
                AttrNotifyPush attrNotifyPush2 = null;
                try {
                    AttrNotifyPush parsePartialFrom = AttrNotifyPush.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrNotifyPush = (AttrNotifyPush) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrNotifyPush2 = attrNotifyPush;
                    if (attrNotifyPush2 != null) {
                    }
                    throw th;
                }
            }

            public final int getIndex() {
                return this.index_;
            }

            public final Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public final Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public final String getUuid() {
                Object obj = this.uuid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uuid_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getUuidBytes() {
                Object obj = this.uuid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uuid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setUuid(String str) {
                if (str != null) {
                    this.uuid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearUuid() {
                this.uuid_ = AttrNotifyPush.getDefaultInstance().getUuid();
                onChanged();
                return this;
            }

            public final Builder setUuidBytes(ByteString byteString) {
                if (byteString != null) {
                    AttrNotifyPush.checkByteStringIsUtf8(byteString);
                    this.uuid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final ByteString getValue() {
                return this.value_;
            }

            public final Builder setValue(ByteString byteString) {
                if (byteString != null) {
                    this.value_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearValue() {
                this.value_ = AttrNotifyPush.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrNotifyPush getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrNotifyPush> parser() {
            return PARSER;
        }

        public final Parser<AttrNotifyPush> getParserForType() {
            return PARSER;
        }

        public final AttrNotifyPush getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AttrOps extends GeneratedMessageV3 implements AttrOpsOrBuilder {
        private static final AttrOps DEFAULT_INSTANCE = new AttrOps();
        public static final Parser<AttrOps> PARSER = new AbstractParser<AttrOps>() {
            /* class com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.AnonymousClass1 */

            public final AttrOps parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AttrOps(codedInputStream, extensionRegistryLite, null);
            }
        };
        private static final long serialVersionUID = 0;
        public int actionCase_;
        public Object action_;
        private byte memoizedIsInitialized;

        /* synthetic */ AttrOps(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ AttrOps(GeneratedMessageV3.Builder builder, AnonymousClass1 r2) {
            this(builder);
        }

        private AttrOps(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.actionCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private AttrOps() {
            this.actionCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AttrOps();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrAdvData$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteRequest$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrWriteResponse$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadRequest$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrReadResponse$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyRequest$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrSetNotifyResponse$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyRequest$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrUnsetNotifyResponse$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyRequest$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyResponse$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPull$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: com.xiaomi.mi_connect_service.proto.AttributeProto$AttrNotifyPush$Builder} */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v27 */
        /* JADX WARN: Type inference failed for: r4v28 */
        /* JADX WARN: Type inference failed for: r4v29 */
        /* JADX WARN: Type inference failed for: r4v30 */
        /* JADX WARN: Type inference failed for: r4v31 */
        /* JADX WARN: Type inference failed for: r4v32 */
        /* JADX WARN: Type inference failed for: r4v33 */
        /* JADX WARN: Type inference failed for: r4v34 */
        /* JADX WARN: Type inference failed for: r4v35 */
        /* JADX WARN: Type inference failed for: r4v36 */
        /* JADX WARN: Type inference failed for: r4v37 */
        /* JADX WARN: Type inference failed for: r4v38 */
        /* JADX WARN: Type inference failed for: r4v39 */
        /* JADX WARNING: Multi-variable type inference failed */
        private AttrOps(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        ? r4 = 0;
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                r4 = this.actionCase_ == 1 ? ((AttrAdvData) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrAdvData.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrAdvData) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 1;
                                continue;
                            case 18:
                                r4 = this.actionCase_ == 2 ? ((AttrWriteRequest) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrWriteRequest.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrWriteRequest) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 2;
                                continue;
                            case 26:
                                r4 = this.actionCase_ == 3 ? ((AttrWriteResponse) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrWriteResponse.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrWriteResponse) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 3;
                                continue;
                            case 34:
                                r4 = this.actionCase_ == 4 ? ((AttrReadRequest) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrReadRequest.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrReadRequest) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 4;
                                continue;
                            case 42:
                                r4 = this.actionCase_ == 5 ? ((AttrReadResponse) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrReadResponse.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrReadResponse) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 5;
                                continue;
                            case 50:
                                r4 = this.actionCase_ == 6 ? ((AttrSetNotifyRequest) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrSetNotifyRequest.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrSetNotifyRequest) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 6;
                                continue;
                            case 58:
                                r4 = this.actionCase_ == 7 ? ((AttrSetNotifyResponse) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrSetNotifyResponse.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrSetNotifyResponse) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 7;
                                continue;
                            case 66:
                                r4 = this.actionCase_ == 8 ? ((AttrUnsetNotifyRequest) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrUnsetNotifyRequest.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrUnsetNotifyRequest) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 8;
                                continue;
                            case 74:
                                r4 = this.actionCase_ == 9 ? ((AttrUnsetNotifyResponse) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrUnsetNotifyResponse.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrUnsetNotifyResponse) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 9;
                                continue;
                            case XiaomiOAuthConstants.VERSION_MINOR:
                                r4 = this.actionCase_ == 10 ? ((AttrNotifyRequest) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrNotifyRequest.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrNotifyRequest) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 10;
                                continue;
                            case 90:
                                r4 = this.actionCase_ == 11 ? ((AttrNotifyResponse) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrNotifyResponse.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrNotifyResponse) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 11;
                                continue;
                            case 98:
                                r4 = this.actionCase_ == 12 ? ((AttrNotifyPull) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrNotifyPull.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrNotifyPull) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 12;
                                continue;
                            case 106:
                                r4 = this.actionCase_ == 13 ? ((AttrNotifyPush) this.action_).toBuilder() : r4;
                                this.action_ = codedInputStream.readMessage(AttrNotifyPush.parser(), extensionRegistryLite);
                                if (r4 != 0) {
                                    r4.mergeFrom((AttrNotifyPush) this.action_);
                                    this.action_ = r4.buildPartial();
                                }
                                this.actionCase_ = 13;
                                continue;
                            default:
                                if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    continue;
                                }
                                break;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrOps.class, Builder.class);
        }

        public enum ActionCase implements AbstractMessageLite.InternalOneOfEnum, Internal.EnumLite {
            ADVDATA(1),
            WRITEREQ(2),
            WRITERSP(3),
            READREQ(4),
            READRSP(5),
            SETNOTIFYREQ(6),
            SETNOTIFYRSP(7),
            UNSETNOTIFYREQ(8),
            UNSETNOTIFYRSP(9),
            NOTIFYREQ(10),
            NOTIFYRSP(11),
            NOTIFYPULL(12),
            NOTIFYPUSH(13),
            ACTION_NOT_SET(0);
            
            private final int value;

            private ActionCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static ActionCase valueOf(int i) {
                return forNumber(i);
            }

            public static ActionCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return ACTION_NOT_SET;
                    case 1:
                        return ADVDATA;
                    case 2:
                        return WRITEREQ;
                    case 3:
                        return WRITERSP;
                    case 4:
                        return READREQ;
                    case 5:
                        return READRSP;
                    case 6:
                        return SETNOTIFYREQ;
                    case 7:
                        return SETNOTIFYRSP;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return UNSETNOTIFYREQ;
                    case 9:
                        return UNSETNOTIFYRSP;
                    case 10:
                        return NOTIFYREQ;
                    case 11:
                        return NOTIFYRSP;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        return NOTIFYPULL;
                    case 13:
                        return NOTIFYPUSH;
                    default:
                        return null;
                }
            }

            public final int getNumber() {
                return this.value;
            }
        }

        public final ActionCase getActionCase() {
            return ActionCase.forNumber(this.actionCase_);
        }

        public final boolean hasAdvData() {
            return this.actionCase_ == 1;
        }

        public final AttrAdvData getAdvData() {
            if (this.actionCase_ == 1) {
                return (AttrAdvData) this.action_;
            }
            return AttrAdvData.getDefaultInstance();
        }

        public final AttrAdvDataOrBuilder getAdvDataOrBuilder() {
            if (this.actionCase_ == 1) {
                return (AttrAdvData) this.action_;
            }
            return AttrAdvData.getDefaultInstance();
        }

        public final boolean hasWriteReq() {
            return this.actionCase_ == 2;
        }

        public final AttrWriteRequest getWriteReq() {
            if (this.actionCase_ == 2) {
                return (AttrWriteRequest) this.action_;
            }
            return AttrWriteRequest.getDefaultInstance();
        }

        public final AttrWriteRequestOrBuilder getWriteReqOrBuilder() {
            if (this.actionCase_ == 2) {
                return (AttrWriteRequest) this.action_;
            }
            return AttrWriteRequest.getDefaultInstance();
        }

        public final boolean hasWriteRsp() {
            return this.actionCase_ == 3;
        }

        public final AttrWriteResponse getWriteRsp() {
            if (this.actionCase_ == 3) {
                return (AttrWriteResponse) this.action_;
            }
            return AttrWriteResponse.getDefaultInstance();
        }

        public final AttrWriteResponseOrBuilder getWriteRspOrBuilder() {
            if (this.actionCase_ == 3) {
                return (AttrWriteResponse) this.action_;
            }
            return AttrWriteResponse.getDefaultInstance();
        }

        public final boolean hasReadReq() {
            return this.actionCase_ == 4;
        }

        public final AttrReadRequest getReadReq() {
            if (this.actionCase_ == 4) {
                return (AttrReadRequest) this.action_;
            }
            return AttrReadRequest.getDefaultInstance();
        }

        public final AttrReadRequestOrBuilder getReadReqOrBuilder() {
            if (this.actionCase_ == 4) {
                return (AttrReadRequest) this.action_;
            }
            return AttrReadRequest.getDefaultInstance();
        }

        public final boolean hasReadRsp() {
            return this.actionCase_ == 5;
        }

        public final AttrReadResponse getReadRsp() {
            if (this.actionCase_ == 5) {
                return (AttrReadResponse) this.action_;
            }
            return AttrReadResponse.getDefaultInstance();
        }

        public final AttrReadResponseOrBuilder getReadRspOrBuilder() {
            if (this.actionCase_ == 5) {
                return (AttrReadResponse) this.action_;
            }
            return AttrReadResponse.getDefaultInstance();
        }

        public final boolean hasSetNotifyReq() {
            return this.actionCase_ == 6;
        }

        public final AttrSetNotifyRequest getSetNotifyReq() {
            if (this.actionCase_ == 6) {
                return (AttrSetNotifyRequest) this.action_;
            }
            return AttrSetNotifyRequest.getDefaultInstance();
        }

        public final AttrSetNotifyRequestOrBuilder getSetNotifyReqOrBuilder() {
            if (this.actionCase_ == 6) {
                return (AttrSetNotifyRequest) this.action_;
            }
            return AttrSetNotifyRequest.getDefaultInstance();
        }

        public final boolean hasSetNotifyRsp() {
            return this.actionCase_ == 7;
        }

        public final AttrSetNotifyResponse getSetNotifyRsp() {
            if (this.actionCase_ == 7) {
                return (AttrSetNotifyResponse) this.action_;
            }
            return AttrSetNotifyResponse.getDefaultInstance();
        }

        public final AttrSetNotifyResponseOrBuilder getSetNotifyRspOrBuilder() {
            if (this.actionCase_ == 7) {
                return (AttrSetNotifyResponse) this.action_;
            }
            return AttrSetNotifyResponse.getDefaultInstance();
        }

        public final boolean hasUnsetNotifyReq() {
            return this.actionCase_ == 8;
        }

        public final AttrUnsetNotifyRequest getUnsetNotifyReq() {
            if (this.actionCase_ == 8) {
                return (AttrUnsetNotifyRequest) this.action_;
            }
            return AttrUnsetNotifyRequest.getDefaultInstance();
        }

        public final AttrUnsetNotifyRequestOrBuilder getUnsetNotifyReqOrBuilder() {
            if (this.actionCase_ == 8) {
                return (AttrUnsetNotifyRequest) this.action_;
            }
            return AttrUnsetNotifyRequest.getDefaultInstance();
        }

        public final boolean hasUnsetNotifyRsp() {
            return this.actionCase_ == 9;
        }

        public final AttrUnsetNotifyResponse getUnsetNotifyRsp() {
            if (this.actionCase_ == 9) {
                return (AttrUnsetNotifyResponse) this.action_;
            }
            return AttrUnsetNotifyResponse.getDefaultInstance();
        }

        public final AttrUnsetNotifyResponseOrBuilder getUnsetNotifyRspOrBuilder() {
            if (this.actionCase_ == 9) {
                return (AttrUnsetNotifyResponse) this.action_;
            }
            return AttrUnsetNotifyResponse.getDefaultInstance();
        }

        public final boolean hasNotifyReq() {
            return this.actionCase_ == 10;
        }

        public final AttrNotifyRequest getNotifyReq() {
            if (this.actionCase_ == 10) {
                return (AttrNotifyRequest) this.action_;
            }
            return AttrNotifyRequest.getDefaultInstance();
        }

        public final AttrNotifyRequestOrBuilder getNotifyReqOrBuilder() {
            if (this.actionCase_ == 10) {
                return (AttrNotifyRequest) this.action_;
            }
            return AttrNotifyRequest.getDefaultInstance();
        }

        public final boolean hasNotifyRsp() {
            return this.actionCase_ == 11;
        }

        public final AttrNotifyResponse getNotifyRsp() {
            if (this.actionCase_ == 11) {
                return (AttrNotifyResponse) this.action_;
            }
            return AttrNotifyResponse.getDefaultInstance();
        }

        public final AttrNotifyResponseOrBuilder getNotifyRspOrBuilder() {
            if (this.actionCase_ == 11) {
                return (AttrNotifyResponse) this.action_;
            }
            return AttrNotifyResponse.getDefaultInstance();
        }

        public final boolean hasNotifyPull() {
            return this.actionCase_ == 12;
        }

        public final AttrNotifyPull getNotifyPull() {
            if (this.actionCase_ == 12) {
                return (AttrNotifyPull) this.action_;
            }
            return AttrNotifyPull.getDefaultInstance();
        }

        public final AttrNotifyPullOrBuilder getNotifyPullOrBuilder() {
            if (this.actionCase_ == 12) {
                return (AttrNotifyPull) this.action_;
            }
            return AttrNotifyPull.getDefaultInstance();
        }

        public final boolean hasNotifyPush() {
            return this.actionCase_ == 13;
        }

        public final AttrNotifyPush getNotifyPush() {
            if (this.actionCase_ == 13) {
                return (AttrNotifyPush) this.action_;
            }
            return AttrNotifyPush.getDefaultInstance();
        }

        public final AttrNotifyPushOrBuilder getNotifyPushOrBuilder() {
            if (this.actionCase_ == 13) {
                return (AttrNotifyPush) this.action_;
            }
            return AttrNotifyPush.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.actionCase_ == 1) {
                codedOutputStream.writeMessage(1, (AttrAdvData) this.action_);
            }
            if (this.actionCase_ == 2) {
                codedOutputStream.writeMessage(2, (AttrWriteRequest) this.action_);
            }
            if (this.actionCase_ == 3) {
                codedOutputStream.writeMessage(3, (AttrWriteResponse) this.action_);
            }
            if (this.actionCase_ == 4) {
                codedOutputStream.writeMessage(4, (AttrReadRequest) this.action_);
            }
            if (this.actionCase_ == 5) {
                codedOutputStream.writeMessage(5, (AttrReadResponse) this.action_);
            }
            if (this.actionCase_ == 6) {
                codedOutputStream.writeMessage(6, (AttrSetNotifyRequest) this.action_);
            }
            if (this.actionCase_ == 7) {
                codedOutputStream.writeMessage(7, (AttrSetNotifyResponse) this.action_);
            }
            if (this.actionCase_ == 8) {
                codedOutputStream.writeMessage(8, (AttrUnsetNotifyRequest) this.action_);
            }
            if (this.actionCase_ == 9) {
                codedOutputStream.writeMessage(9, (AttrUnsetNotifyResponse) this.action_);
            }
            if (this.actionCase_ == 10) {
                codedOutputStream.writeMessage(10, (AttrNotifyRequest) this.action_);
            }
            if (this.actionCase_ == 11) {
                codedOutputStream.writeMessage(11, (AttrNotifyResponse) this.action_);
            }
            if (this.actionCase_ == 12) {
                codedOutputStream.writeMessage(12, (AttrNotifyPull) this.action_);
            }
            if (this.actionCase_ == 13) {
                codedOutputStream.writeMessage(13, (AttrNotifyPush) this.action_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.actionCase_ == 1) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, (AttrAdvData) this.action_);
            }
            if (this.actionCase_ == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, (AttrWriteRequest) this.action_);
            }
            if (this.actionCase_ == 3) {
                i2 += CodedOutputStream.computeMessageSize(3, (AttrWriteResponse) this.action_);
            }
            if (this.actionCase_ == 4) {
                i2 += CodedOutputStream.computeMessageSize(4, (AttrReadRequest) this.action_);
            }
            if (this.actionCase_ == 5) {
                i2 += CodedOutputStream.computeMessageSize(5, (AttrReadResponse) this.action_);
            }
            if (this.actionCase_ == 6) {
                i2 += CodedOutputStream.computeMessageSize(6, (AttrSetNotifyRequest) this.action_);
            }
            if (this.actionCase_ == 7) {
                i2 += CodedOutputStream.computeMessageSize(7, (AttrSetNotifyResponse) this.action_);
            }
            if (this.actionCase_ == 8) {
                i2 += CodedOutputStream.computeMessageSize(8, (AttrUnsetNotifyRequest) this.action_);
            }
            if (this.actionCase_ == 9) {
                i2 += CodedOutputStream.computeMessageSize(9, (AttrUnsetNotifyResponse) this.action_);
            }
            if (this.actionCase_ == 10) {
                i2 += CodedOutputStream.computeMessageSize(10, (AttrNotifyRequest) this.action_);
            }
            if (this.actionCase_ == 11) {
                i2 += CodedOutputStream.computeMessageSize(11, (AttrNotifyResponse) this.action_);
            }
            if (this.actionCase_ == 12) {
                i2 += CodedOutputStream.computeMessageSize(12, (AttrNotifyPull) this.action_);
            }
            if (this.actionCase_ == 13) {
                i2 += CodedOutputStream.computeMessageSize(13, (AttrNotifyPush) this.action_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttrOps)) {
                return super.equals(obj);
            }
            AttrOps attrOps = (AttrOps) obj;
            if (!getActionCase().equals(attrOps.getActionCase())) {
                return false;
            }
            switch (this.actionCase_) {
                case 1:
                    if (!getAdvData().equals(attrOps.getAdvData())) {
                        return false;
                    }
                    break;
                case 2:
                    if (!getWriteReq().equals(attrOps.getWriteReq())) {
                        return false;
                    }
                    break;
                case 3:
                    if (!getWriteRsp().equals(attrOps.getWriteRsp())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!getReadReq().equals(attrOps.getReadReq())) {
                        return false;
                    }
                    break;
                case 5:
                    if (!getReadRsp().equals(attrOps.getReadRsp())) {
                        return false;
                    }
                    break;
                case 6:
                    if (!getSetNotifyReq().equals(attrOps.getSetNotifyReq())) {
                        return false;
                    }
                    break;
                case 7:
                    if (!getSetNotifyRsp().equals(attrOps.getSetNotifyRsp())) {
                        return false;
                    }
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (!getUnsetNotifyReq().equals(attrOps.getUnsetNotifyReq())) {
                        return false;
                    }
                    break;
                case 9:
                    if (!getUnsetNotifyRsp().equals(attrOps.getUnsetNotifyRsp())) {
                        return false;
                    }
                    break;
                case 10:
                    if (!getNotifyReq().equals(attrOps.getNotifyReq())) {
                        return false;
                    }
                    break;
                case 11:
                    if (!getNotifyRsp().equals(attrOps.getNotifyRsp())) {
                        return false;
                    }
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (!getNotifyPull().equals(attrOps.getNotifyPull())) {
                        return false;
                    }
                    break;
                case 13:
                    if (!getNotifyPush().equals(attrOps.getNotifyPush())) {
                        return false;
                    }
                    break;
            }
            if (!this.unknownFields.equals(attrOps.unknownFields)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i;
            int i2;
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = getDescriptor().hashCode() + 779;
            switch (this.actionCase_) {
                case 1:
                    i2 = ((hashCode * 37) + 1) * 53;
                    i = getAdvData().hashCode();
                    break;
                case 2:
                    i2 = ((hashCode * 37) + 2) * 53;
                    i = getWriteReq().hashCode();
                    break;
                case 3:
                    i2 = ((hashCode * 37) + 3) * 53;
                    i = getWriteRsp().hashCode();
                    break;
                case 4:
                    i2 = ((hashCode * 37) + 4) * 53;
                    i = getReadReq().hashCode();
                    break;
                case 5:
                    i2 = ((hashCode * 37) + 5) * 53;
                    i = getReadRsp().hashCode();
                    break;
                case 6:
                    i2 = ((hashCode * 37) + 6) * 53;
                    i = getSetNotifyReq().hashCode();
                    break;
                case 7:
                    i2 = ((hashCode * 37) + 7) * 53;
                    i = getSetNotifyRsp().hashCode();
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    i2 = ((hashCode * 37) + 8) * 53;
                    i = getUnsetNotifyReq().hashCode();
                    break;
                case 9:
                    i2 = ((hashCode * 37) + 9) * 53;
                    i = getUnsetNotifyRsp().hashCode();
                    break;
                case 10:
                    i2 = ((hashCode * 37) + 10) * 53;
                    i = getNotifyReq().hashCode();
                    break;
                case 11:
                    i2 = ((hashCode * 37) + 11) * 53;
                    i = getNotifyRsp().hashCode();
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    i2 = ((hashCode * 37) + 12) * 53;
                    i = getNotifyPull().hashCode();
                    break;
                case 13:
                    i2 = ((hashCode * 37) + 13) * 53;
                    i = getNotifyPush().hashCode();
                    break;
                default:
                    int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
            }
            hashCode = i2 + i;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        public static AttrOps parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AttrOps parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AttrOps parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AttrOps parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AttrOps parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AttrOps parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AttrOps parseFrom(InputStream inputStream) throws IOException {
            return (AttrOps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AttrOps parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrOps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrOps parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AttrOps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AttrOps parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrOps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AttrOps parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AttrOps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AttrOps parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AttrOps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttrOps attrOps) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(attrOps);
        }

        public final Builder toBuilder() {
            if (this == DEFAULT_INSTANCE) {
                return new Builder((AnonymousClass1) null);
            }
            return new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttrOpsOrBuilder {
            private int actionCase_;
            private Object action_;
            private SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> advDataBuilder_;
            private SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> notifyPullBuilder_;
            private SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> notifyPushBuilder_;
            private SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> notifyReqBuilder_;
            private SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> notifyRspBuilder_;
            private SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> readReqBuilder_;
            private SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> readRspBuilder_;
            private SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> setNotifyReqBuilder_;
            private SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> setNotifyRspBuilder_;
            private SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> unsetNotifyReqBuilder_;
            private SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> unsetNotifyRspBuilder_;
            private SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> writeReqBuilder_;
            private SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> writeRspBuilder_;

            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, AnonymousClass1 r2) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_fieldAccessorTable.ensureFieldAccessorsInitialized(AttrOps.class, Builder.class);
            }

            private Builder() {
                this.actionCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.actionCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = AttrOps.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.actionCase_ = 0;
                this.action_ = null;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return AttributeProto.internal_static_com_xiaomi_mi_connect_service_proto_AttrOps_descriptor;
            }

            public final AttrOps getDefaultInstanceForType() {
                return AttrOps.getDefaultInstance();
            }

            public final AttrOps build() {
                AttrOps buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final AttrOps buildPartial() {
                AttrOps attrOps = new AttrOps(this, (AnonymousClass1) null);
                if (this.actionCase_ == 1) {
                    SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> singleFieldBuilderV3 = this.advDataBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV3.build();
                    }
                }
                if (this.actionCase_ == 2) {
                    SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> singleFieldBuilderV32 = this.writeReqBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV32.build();
                    }
                }
                if (this.actionCase_ == 3) {
                    SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> singleFieldBuilderV33 = this.writeRspBuilder_;
                    if (singleFieldBuilderV33 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV33.build();
                    }
                }
                if (this.actionCase_ == 4) {
                    SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> singleFieldBuilderV34 = this.readReqBuilder_;
                    if (singleFieldBuilderV34 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV34.build();
                    }
                }
                if (this.actionCase_ == 5) {
                    SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> singleFieldBuilderV35 = this.readRspBuilder_;
                    if (singleFieldBuilderV35 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV35.build();
                    }
                }
                if (this.actionCase_ == 6) {
                    SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> singleFieldBuilderV36 = this.setNotifyReqBuilder_;
                    if (singleFieldBuilderV36 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV36.build();
                    }
                }
                if (this.actionCase_ == 7) {
                    SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> singleFieldBuilderV37 = this.setNotifyRspBuilder_;
                    if (singleFieldBuilderV37 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV37.build();
                    }
                }
                if (this.actionCase_ == 8) {
                    SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> singleFieldBuilderV38 = this.unsetNotifyReqBuilder_;
                    if (singleFieldBuilderV38 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV38.build();
                    }
                }
                if (this.actionCase_ == 9) {
                    SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> singleFieldBuilderV39 = this.unsetNotifyRspBuilder_;
                    if (singleFieldBuilderV39 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV39.build();
                    }
                }
                if (this.actionCase_ == 10) {
                    SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> singleFieldBuilderV310 = this.notifyReqBuilder_;
                    if (singleFieldBuilderV310 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV310.build();
                    }
                }
                if (this.actionCase_ == 11) {
                    SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> singleFieldBuilderV311 = this.notifyRspBuilder_;
                    if (singleFieldBuilderV311 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV311.build();
                    }
                }
                if (this.actionCase_ == 12) {
                    SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> singleFieldBuilderV312 = this.notifyPullBuilder_;
                    if (singleFieldBuilderV312 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV312.build();
                    }
                }
                if (this.actionCase_ == 13) {
                    SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> singleFieldBuilderV313 = this.notifyPushBuilder_;
                    if (singleFieldBuilderV313 == null) {
                        attrOps.action_ = this.action_;
                    } else {
                        attrOps.action_ = singleFieldBuilderV313.build();
                    }
                }
                attrOps.actionCase_ = this.actionCase_;
                onBuilt();
                return attrOps;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrOps$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrOps$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
            public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.xiaomi.mi_connect_service.proto.AttributeProto.AttrOps.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.xiaomi.mi_connect_service.proto.AttributeProto$AttrOps$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof AttrOps) {
                    return mergeFrom((AttrOps) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(AttrOps attrOps) {
                if (attrOps == AttrOps.getDefaultInstance()) {
                    return this;
                }
                switch (AnonymousClass1.$SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[attrOps.getActionCase().ordinal()]) {
                    case 1:
                        mergeAdvData(attrOps.getAdvData());
                        break;
                    case 2:
                        mergeWriteReq(attrOps.getWriteReq());
                        break;
                    case 3:
                        mergeWriteRsp(attrOps.getWriteRsp());
                        break;
                    case 4:
                        mergeReadReq(attrOps.getReadReq());
                        break;
                    case 5:
                        mergeReadRsp(attrOps.getReadRsp());
                        break;
                    case 6:
                        mergeSetNotifyReq(attrOps.getSetNotifyReq());
                        break;
                    case 7:
                        mergeSetNotifyRsp(attrOps.getSetNotifyRsp());
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        mergeUnsetNotifyReq(attrOps.getUnsetNotifyReq());
                        break;
                    case 9:
                        mergeUnsetNotifyRsp(attrOps.getUnsetNotifyRsp());
                        break;
                    case 10:
                        mergeNotifyReq(attrOps.getNotifyReq());
                        break;
                    case 11:
                        mergeNotifyRsp(attrOps.getNotifyRsp());
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        mergeNotifyPull(attrOps.getNotifyPull());
                        break;
                    case 13:
                        mergeNotifyPush(attrOps.getNotifyPush());
                        break;
                }
                mergeUnknownFields(attrOps.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AttrOps attrOps;
                AttrOps attrOps2 = null;
                try {
                    AttrOps parsePartialFrom = AttrOps.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    attrOps = (AttrOps) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    attrOps2 = attrOps;
                    if (attrOps2 != null) {
                    }
                    throw th;
                }
            }

            public final ActionCase getActionCase() {
                return ActionCase.forNumber(this.actionCase_);
            }

            public final Builder clearAction() {
                this.actionCase_ = 0;
                this.action_ = null;
                onChanged();
                return this;
            }

            public final boolean hasAdvData() {
                return this.actionCase_ == 1;
            }

            public final AttrAdvData getAdvData() {
                SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> singleFieldBuilderV3 = this.advDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 1) {
                        return (AttrAdvData) this.action_;
                    }
                    return AttrAdvData.getDefaultInstance();
                } else if (this.actionCase_ == 1) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrAdvData.getDefaultInstance();
                }
            }

            public final Builder setAdvData(AttrAdvData attrAdvData) {
                SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> singleFieldBuilderV3 = this.advDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrAdvData);
                } else if (attrAdvData != null) {
                    this.action_ = attrAdvData;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 1;
                return this;
            }

            public final Builder setAdvData(AttrAdvData.Builder builder) {
                SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> singleFieldBuilderV3 = this.advDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 1;
                return this;
            }

            public final Builder mergeAdvData(AttrAdvData attrAdvData) {
                SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> singleFieldBuilderV3 = this.advDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 1 || this.action_ == AttrAdvData.getDefaultInstance()) {
                        this.action_ = attrAdvData;
                    } else {
                        this.action_ = AttrAdvData.newBuilder((AttrAdvData) this.action_).mergeFrom(attrAdvData).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 1) {
                        singleFieldBuilderV3.mergeFrom(attrAdvData);
                    }
                    this.advDataBuilder_.setMessage(attrAdvData);
                }
                this.actionCase_ = 1;
                return this;
            }

            public final Builder clearAdvData() {
                if (this.advDataBuilder_ != null) {
                    if (this.actionCase_ == 1) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.advDataBuilder_.clear();
                } else if (this.actionCase_ == 1) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrAdvData.Builder getAdvDataBuilder() {
                return getAdvDataFieldBuilder().getBuilder();
            }

            public final AttrAdvDataOrBuilder getAdvDataOrBuilder() {
                SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 1 && (singleFieldBuilderV3 = this.advDataBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 1) {
                    return (AttrAdvData) this.action_;
                }
                return AttrAdvData.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrAdvData, AttrAdvData.Builder, AttrAdvDataOrBuilder> getAdvDataFieldBuilder() {
                if (this.advDataBuilder_ == null) {
                    if (this.actionCase_ != 1) {
                        this.action_ = AttrAdvData.getDefaultInstance();
                    }
                    this.advDataBuilder_ = new SingleFieldBuilderV3<>((AttrAdvData) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 1;
                onChanged();
                return this.advDataBuilder_;
            }

            public final boolean hasWriteReq() {
                return this.actionCase_ == 2;
            }

            public final AttrWriteRequest getWriteReq() {
                SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> singleFieldBuilderV3 = this.writeReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 2) {
                        return (AttrWriteRequest) this.action_;
                    }
                    return AttrWriteRequest.getDefaultInstance();
                } else if (this.actionCase_ == 2) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrWriteRequest.getDefaultInstance();
                }
            }

            public final Builder setWriteReq(AttrWriteRequest attrWriteRequest) {
                SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> singleFieldBuilderV3 = this.writeReqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrWriteRequest);
                } else if (attrWriteRequest != null) {
                    this.action_ = attrWriteRequest;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 2;
                return this;
            }

            public final Builder setWriteReq(AttrWriteRequest.Builder builder) {
                SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> singleFieldBuilderV3 = this.writeReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 2;
                return this;
            }

            public final Builder mergeWriteReq(AttrWriteRequest attrWriteRequest) {
                SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> singleFieldBuilderV3 = this.writeReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 2 || this.action_ == AttrWriteRequest.getDefaultInstance()) {
                        this.action_ = attrWriteRequest;
                    } else {
                        this.action_ = AttrWriteRequest.newBuilder((AttrWriteRequest) this.action_).mergeFrom(attrWriteRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 2) {
                        singleFieldBuilderV3.mergeFrom(attrWriteRequest);
                    }
                    this.writeReqBuilder_.setMessage(attrWriteRequest);
                }
                this.actionCase_ = 2;
                return this;
            }

            public final Builder clearWriteReq() {
                if (this.writeReqBuilder_ != null) {
                    if (this.actionCase_ == 2) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.writeReqBuilder_.clear();
                } else if (this.actionCase_ == 2) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrWriteRequest.Builder getWriteReqBuilder() {
                return getWriteReqFieldBuilder().getBuilder();
            }

            public final AttrWriteRequestOrBuilder getWriteReqOrBuilder() {
                SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 2 && (singleFieldBuilderV3 = this.writeReqBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 2) {
                    return (AttrWriteRequest) this.action_;
                }
                return AttrWriteRequest.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrWriteRequest, AttrWriteRequest.Builder, AttrWriteRequestOrBuilder> getWriteReqFieldBuilder() {
                if (this.writeReqBuilder_ == null) {
                    if (this.actionCase_ != 2) {
                        this.action_ = AttrWriteRequest.getDefaultInstance();
                    }
                    this.writeReqBuilder_ = new SingleFieldBuilderV3<>((AttrWriteRequest) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 2;
                onChanged();
                return this.writeReqBuilder_;
            }

            public final boolean hasWriteRsp() {
                return this.actionCase_ == 3;
            }

            public final AttrWriteResponse getWriteRsp() {
                SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> singleFieldBuilderV3 = this.writeRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 3) {
                        return (AttrWriteResponse) this.action_;
                    }
                    return AttrWriteResponse.getDefaultInstance();
                } else if (this.actionCase_ == 3) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrWriteResponse.getDefaultInstance();
                }
            }

            public final Builder setWriteRsp(AttrWriteResponse attrWriteResponse) {
                SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> singleFieldBuilderV3 = this.writeRspBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrWriteResponse);
                } else if (attrWriteResponse != null) {
                    this.action_ = attrWriteResponse;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 3;
                return this;
            }

            public final Builder setWriteRsp(AttrWriteResponse.Builder builder) {
                SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> singleFieldBuilderV3 = this.writeRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 3;
                return this;
            }

            public final Builder mergeWriteRsp(AttrWriteResponse attrWriteResponse) {
                SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> singleFieldBuilderV3 = this.writeRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 3 || this.action_ == AttrWriteResponse.getDefaultInstance()) {
                        this.action_ = attrWriteResponse;
                    } else {
                        this.action_ = AttrWriteResponse.newBuilder((AttrWriteResponse) this.action_).mergeFrom(attrWriteResponse).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 3) {
                        singleFieldBuilderV3.mergeFrom(attrWriteResponse);
                    }
                    this.writeRspBuilder_.setMessage(attrWriteResponse);
                }
                this.actionCase_ = 3;
                return this;
            }

            public final Builder clearWriteRsp() {
                if (this.writeRspBuilder_ != null) {
                    if (this.actionCase_ == 3) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.writeRspBuilder_.clear();
                } else if (this.actionCase_ == 3) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrWriteResponse.Builder getWriteRspBuilder() {
                return getWriteRspFieldBuilder().getBuilder();
            }

            public final AttrWriteResponseOrBuilder getWriteRspOrBuilder() {
                SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 3 && (singleFieldBuilderV3 = this.writeRspBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 3) {
                    return (AttrWriteResponse) this.action_;
                }
                return AttrWriteResponse.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrWriteResponse, AttrWriteResponse.Builder, AttrWriteResponseOrBuilder> getWriteRspFieldBuilder() {
                if (this.writeRspBuilder_ == null) {
                    if (this.actionCase_ != 3) {
                        this.action_ = AttrWriteResponse.getDefaultInstance();
                    }
                    this.writeRspBuilder_ = new SingleFieldBuilderV3<>((AttrWriteResponse) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 3;
                onChanged();
                return this.writeRspBuilder_;
            }

            public final boolean hasReadReq() {
                return this.actionCase_ == 4;
            }

            public final AttrReadRequest getReadReq() {
                SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> singleFieldBuilderV3 = this.readReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 4) {
                        return (AttrReadRequest) this.action_;
                    }
                    return AttrReadRequest.getDefaultInstance();
                } else if (this.actionCase_ == 4) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrReadRequest.getDefaultInstance();
                }
            }

            public final Builder setReadReq(AttrReadRequest attrReadRequest) {
                SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> singleFieldBuilderV3 = this.readReqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrReadRequest);
                } else if (attrReadRequest != null) {
                    this.action_ = attrReadRequest;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 4;
                return this;
            }

            public final Builder setReadReq(AttrReadRequest.Builder builder) {
                SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> singleFieldBuilderV3 = this.readReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 4;
                return this;
            }

            public final Builder mergeReadReq(AttrReadRequest attrReadRequest) {
                SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> singleFieldBuilderV3 = this.readReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 4 || this.action_ == AttrReadRequest.getDefaultInstance()) {
                        this.action_ = attrReadRequest;
                    } else {
                        this.action_ = AttrReadRequest.newBuilder((AttrReadRequest) this.action_).mergeFrom(attrReadRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 4) {
                        singleFieldBuilderV3.mergeFrom(attrReadRequest);
                    }
                    this.readReqBuilder_.setMessage(attrReadRequest);
                }
                this.actionCase_ = 4;
                return this;
            }

            public final Builder clearReadReq() {
                if (this.readReqBuilder_ != null) {
                    if (this.actionCase_ == 4) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.readReqBuilder_.clear();
                } else if (this.actionCase_ == 4) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrReadRequest.Builder getReadReqBuilder() {
                return getReadReqFieldBuilder().getBuilder();
            }

            public final AttrReadRequestOrBuilder getReadReqOrBuilder() {
                SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 4 && (singleFieldBuilderV3 = this.readReqBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 4) {
                    return (AttrReadRequest) this.action_;
                }
                return AttrReadRequest.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrReadRequest, AttrReadRequest.Builder, AttrReadRequestOrBuilder> getReadReqFieldBuilder() {
                if (this.readReqBuilder_ == null) {
                    if (this.actionCase_ != 4) {
                        this.action_ = AttrReadRequest.getDefaultInstance();
                    }
                    this.readReqBuilder_ = new SingleFieldBuilderV3<>((AttrReadRequest) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 4;
                onChanged();
                return this.readReqBuilder_;
            }

            public final boolean hasReadRsp() {
                return this.actionCase_ == 5;
            }

            public final AttrReadResponse getReadRsp() {
                SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> singleFieldBuilderV3 = this.readRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 5) {
                        return (AttrReadResponse) this.action_;
                    }
                    return AttrReadResponse.getDefaultInstance();
                } else if (this.actionCase_ == 5) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrReadResponse.getDefaultInstance();
                }
            }

            public final Builder setReadRsp(AttrReadResponse attrReadResponse) {
                SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> singleFieldBuilderV3 = this.readRspBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrReadResponse);
                } else if (attrReadResponse != null) {
                    this.action_ = attrReadResponse;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 5;
                return this;
            }

            public final Builder setReadRsp(AttrReadResponse.Builder builder) {
                SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> singleFieldBuilderV3 = this.readRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 5;
                return this;
            }

            public final Builder mergeReadRsp(AttrReadResponse attrReadResponse) {
                SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> singleFieldBuilderV3 = this.readRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 5 || this.action_ == AttrReadResponse.getDefaultInstance()) {
                        this.action_ = attrReadResponse;
                    } else {
                        this.action_ = AttrReadResponse.newBuilder((AttrReadResponse) this.action_).mergeFrom(attrReadResponse).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 5) {
                        singleFieldBuilderV3.mergeFrom(attrReadResponse);
                    }
                    this.readRspBuilder_.setMessage(attrReadResponse);
                }
                this.actionCase_ = 5;
                return this;
            }

            public final Builder clearReadRsp() {
                if (this.readRspBuilder_ != null) {
                    if (this.actionCase_ == 5) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.readRspBuilder_.clear();
                } else if (this.actionCase_ == 5) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrReadResponse.Builder getReadRspBuilder() {
                return getReadRspFieldBuilder().getBuilder();
            }

            public final AttrReadResponseOrBuilder getReadRspOrBuilder() {
                SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 5 && (singleFieldBuilderV3 = this.readRspBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 5) {
                    return (AttrReadResponse) this.action_;
                }
                return AttrReadResponse.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrReadResponse, AttrReadResponse.Builder, AttrReadResponseOrBuilder> getReadRspFieldBuilder() {
                if (this.readRspBuilder_ == null) {
                    if (this.actionCase_ != 5) {
                        this.action_ = AttrReadResponse.getDefaultInstance();
                    }
                    this.readRspBuilder_ = new SingleFieldBuilderV3<>((AttrReadResponse) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 5;
                onChanged();
                return this.readRspBuilder_;
            }

            public final boolean hasSetNotifyReq() {
                return this.actionCase_ == 6;
            }

            public final AttrSetNotifyRequest getSetNotifyReq() {
                SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.setNotifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 6) {
                        return (AttrSetNotifyRequest) this.action_;
                    }
                    return AttrSetNotifyRequest.getDefaultInstance();
                } else if (this.actionCase_ == 6) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrSetNotifyRequest.getDefaultInstance();
                }
            }

            public final Builder setSetNotifyReq(AttrSetNotifyRequest attrSetNotifyRequest) {
                SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.setNotifyReqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrSetNotifyRequest);
                } else if (attrSetNotifyRequest != null) {
                    this.action_ = attrSetNotifyRequest;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 6;
                return this;
            }

            public final Builder setSetNotifyReq(AttrSetNotifyRequest.Builder builder) {
                SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.setNotifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 6;
                return this;
            }

            public final Builder mergeSetNotifyReq(AttrSetNotifyRequest attrSetNotifyRequest) {
                SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.setNotifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 6 || this.action_ == AttrSetNotifyRequest.getDefaultInstance()) {
                        this.action_ = attrSetNotifyRequest;
                    } else {
                        this.action_ = AttrSetNotifyRequest.newBuilder((AttrSetNotifyRequest) this.action_).mergeFrom(attrSetNotifyRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 6) {
                        singleFieldBuilderV3.mergeFrom(attrSetNotifyRequest);
                    }
                    this.setNotifyReqBuilder_.setMessage(attrSetNotifyRequest);
                }
                this.actionCase_ = 6;
                return this;
            }

            public final Builder clearSetNotifyReq() {
                if (this.setNotifyReqBuilder_ != null) {
                    if (this.actionCase_ == 6) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.setNotifyReqBuilder_.clear();
                } else if (this.actionCase_ == 6) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrSetNotifyRequest.Builder getSetNotifyReqBuilder() {
                return getSetNotifyReqFieldBuilder().getBuilder();
            }

            public final AttrSetNotifyRequestOrBuilder getSetNotifyReqOrBuilder() {
                SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 6 && (singleFieldBuilderV3 = this.setNotifyReqBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 6) {
                    return (AttrSetNotifyRequest) this.action_;
                }
                return AttrSetNotifyRequest.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrSetNotifyRequest, AttrSetNotifyRequest.Builder, AttrSetNotifyRequestOrBuilder> getSetNotifyReqFieldBuilder() {
                if (this.setNotifyReqBuilder_ == null) {
                    if (this.actionCase_ != 6) {
                        this.action_ = AttrSetNotifyRequest.getDefaultInstance();
                    }
                    this.setNotifyReqBuilder_ = new SingleFieldBuilderV3<>((AttrSetNotifyRequest) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 6;
                onChanged();
                return this.setNotifyReqBuilder_;
            }

            public final boolean hasSetNotifyRsp() {
                return this.actionCase_ == 7;
            }

            public final AttrSetNotifyResponse getSetNotifyRsp() {
                SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.setNotifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 7) {
                        return (AttrSetNotifyResponse) this.action_;
                    }
                    return AttrSetNotifyResponse.getDefaultInstance();
                } else if (this.actionCase_ == 7) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrSetNotifyResponse.getDefaultInstance();
                }
            }

            public final Builder setSetNotifyRsp(AttrSetNotifyResponse attrSetNotifyResponse) {
                SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.setNotifyRspBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrSetNotifyResponse);
                } else if (attrSetNotifyResponse != null) {
                    this.action_ = attrSetNotifyResponse;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 7;
                return this;
            }

            public final Builder setSetNotifyRsp(AttrSetNotifyResponse.Builder builder) {
                SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.setNotifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 7;
                return this;
            }

            public final Builder mergeSetNotifyRsp(AttrSetNotifyResponse attrSetNotifyResponse) {
                SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.setNotifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 7 || this.action_ == AttrSetNotifyResponse.getDefaultInstance()) {
                        this.action_ = attrSetNotifyResponse;
                    } else {
                        this.action_ = AttrSetNotifyResponse.newBuilder((AttrSetNotifyResponse) this.action_).mergeFrom(attrSetNotifyResponse).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 7) {
                        singleFieldBuilderV3.mergeFrom(attrSetNotifyResponse);
                    }
                    this.setNotifyRspBuilder_.setMessage(attrSetNotifyResponse);
                }
                this.actionCase_ = 7;
                return this;
            }

            public final Builder clearSetNotifyRsp() {
                if (this.setNotifyRspBuilder_ != null) {
                    if (this.actionCase_ == 7) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.setNotifyRspBuilder_.clear();
                } else if (this.actionCase_ == 7) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrSetNotifyResponse.Builder getSetNotifyRspBuilder() {
                return getSetNotifyRspFieldBuilder().getBuilder();
            }

            public final AttrSetNotifyResponseOrBuilder getSetNotifyRspOrBuilder() {
                SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 7 && (singleFieldBuilderV3 = this.setNotifyRspBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 7) {
                    return (AttrSetNotifyResponse) this.action_;
                }
                return AttrSetNotifyResponse.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrSetNotifyResponse, AttrSetNotifyResponse.Builder, AttrSetNotifyResponseOrBuilder> getSetNotifyRspFieldBuilder() {
                if (this.setNotifyRspBuilder_ == null) {
                    if (this.actionCase_ != 7) {
                        this.action_ = AttrSetNotifyResponse.getDefaultInstance();
                    }
                    this.setNotifyRspBuilder_ = new SingleFieldBuilderV3<>((AttrSetNotifyResponse) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 7;
                onChanged();
                return this.setNotifyRspBuilder_;
            }

            public final boolean hasUnsetNotifyReq() {
                return this.actionCase_ == 8;
            }

            public final AttrUnsetNotifyRequest getUnsetNotifyReq() {
                SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.unsetNotifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 8) {
                        return (AttrUnsetNotifyRequest) this.action_;
                    }
                    return AttrUnsetNotifyRequest.getDefaultInstance();
                } else if (this.actionCase_ == 8) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrUnsetNotifyRequest.getDefaultInstance();
                }
            }

            public final Builder setUnsetNotifyReq(AttrUnsetNotifyRequest attrUnsetNotifyRequest) {
                SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.unsetNotifyReqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrUnsetNotifyRequest);
                } else if (attrUnsetNotifyRequest != null) {
                    this.action_ = attrUnsetNotifyRequest;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 8;
                return this;
            }

            public final Builder setUnsetNotifyReq(AttrUnsetNotifyRequest.Builder builder) {
                SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.unsetNotifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 8;
                return this;
            }

            public final Builder mergeUnsetNotifyReq(AttrUnsetNotifyRequest attrUnsetNotifyRequest) {
                SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> singleFieldBuilderV3 = this.unsetNotifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 8 || this.action_ == AttrUnsetNotifyRequest.getDefaultInstance()) {
                        this.action_ = attrUnsetNotifyRequest;
                    } else {
                        this.action_ = AttrUnsetNotifyRequest.newBuilder((AttrUnsetNotifyRequest) this.action_).mergeFrom(attrUnsetNotifyRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 8) {
                        singleFieldBuilderV3.mergeFrom(attrUnsetNotifyRequest);
                    }
                    this.unsetNotifyReqBuilder_.setMessage(attrUnsetNotifyRequest);
                }
                this.actionCase_ = 8;
                return this;
            }

            public final Builder clearUnsetNotifyReq() {
                if (this.unsetNotifyReqBuilder_ != null) {
                    if (this.actionCase_ == 8) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.unsetNotifyReqBuilder_.clear();
                } else if (this.actionCase_ == 8) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrUnsetNotifyRequest.Builder getUnsetNotifyReqBuilder() {
                return getUnsetNotifyReqFieldBuilder().getBuilder();
            }

            public final AttrUnsetNotifyRequestOrBuilder getUnsetNotifyReqOrBuilder() {
                SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 8 && (singleFieldBuilderV3 = this.unsetNotifyReqBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 8) {
                    return (AttrUnsetNotifyRequest) this.action_;
                }
                return AttrUnsetNotifyRequest.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrUnsetNotifyRequest, AttrUnsetNotifyRequest.Builder, AttrUnsetNotifyRequestOrBuilder> getUnsetNotifyReqFieldBuilder() {
                if (this.unsetNotifyReqBuilder_ == null) {
                    if (this.actionCase_ != 8) {
                        this.action_ = AttrUnsetNotifyRequest.getDefaultInstance();
                    }
                    this.unsetNotifyReqBuilder_ = new SingleFieldBuilderV3<>((AttrUnsetNotifyRequest) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 8;
                onChanged();
                return this.unsetNotifyReqBuilder_;
            }

            public final boolean hasUnsetNotifyRsp() {
                return this.actionCase_ == 9;
            }

            public final AttrUnsetNotifyResponse getUnsetNotifyRsp() {
                SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.unsetNotifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 9) {
                        return (AttrUnsetNotifyResponse) this.action_;
                    }
                    return AttrUnsetNotifyResponse.getDefaultInstance();
                } else if (this.actionCase_ == 9) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrUnsetNotifyResponse.getDefaultInstance();
                }
            }

            public final Builder setUnsetNotifyRsp(AttrUnsetNotifyResponse attrUnsetNotifyResponse) {
                SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.unsetNotifyRspBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrUnsetNotifyResponse);
                } else if (attrUnsetNotifyResponse != null) {
                    this.action_ = attrUnsetNotifyResponse;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 9;
                return this;
            }

            public final Builder setUnsetNotifyRsp(AttrUnsetNotifyResponse.Builder builder) {
                SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.unsetNotifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 9;
                return this;
            }

            public final Builder mergeUnsetNotifyRsp(AttrUnsetNotifyResponse attrUnsetNotifyResponse) {
                SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> singleFieldBuilderV3 = this.unsetNotifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 9 || this.action_ == AttrUnsetNotifyResponse.getDefaultInstance()) {
                        this.action_ = attrUnsetNotifyResponse;
                    } else {
                        this.action_ = AttrUnsetNotifyResponse.newBuilder((AttrUnsetNotifyResponse) this.action_).mergeFrom(attrUnsetNotifyResponse).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 9) {
                        singleFieldBuilderV3.mergeFrom(attrUnsetNotifyResponse);
                    }
                    this.unsetNotifyRspBuilder_.setMessage(attrUnsetNotifyResponse);
                }
                this.actionCase_ = 9;
                return this;
            }

            public final Builder clearUnsetNotifyRsp() {
                if (this.unsetNotifyRspBuilder_ != null) {
                    if (this.actionCase_ == 9) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.unsetNotifyRspBuilder_.clear();
                } else if (this.actionCase_ == 9) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrUnsetNotifyResponse.Builder getUnsetNotifyRspBuilder() {
                return getUnsetNotifyRspFieldBuilder().getBuilder();
            }

            public final AttrUnsetNotifyResponseOrBuilder getUnsetNotifyRspOrBuilder() {
                SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 9 && (singleFieldBuilderV3 = this.unsetNotifyRspBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 9) {
                    return (AttrUnsetNotifyResponse) this.action_;
                }
                return AttrUnsetNotifyResponse.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrUnsetNotifyResponse, AttrUnsetNotifyResponse.Builder, AttrUnsetNotifyResponseOrBuilder> getUnsetNotifyRspFieldBuilder() {
                if (this.unsetNotifyRspBuilder_ == null) {
                    if (this.actionCase_ != 9) {
                        this.action_ = AttrUnsetNotifyResponse.getDefaultInstance();
                    }
                    this.unsetNotifyRspBuilder_ = new SingleFieldBuilderV3<>((AttrUnsetNotifyResponse) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 9;
                onChanged();
                return this.unsetNotifyRspBuilder_;
            }

            public final boolean hasNotifyReq() {
                return this.actionCase_ == 10;
            }

            public final AttrNotifyRequest getNotifyReq() {
                SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> singleFieldBuilderV3 = this.notifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 10) {
                        return (AttrNotifyRequest) this.action_;
                    }
                    return AttrNotifyRequest.getDefaultInstance();
                } else if (this.actionCase_ == 10) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrNotifyRequest.getDefaultInstance();
                }
            }

            public final Builder setNotifyReq(AttrNotifyRequest attrNotifyRequest) {
                SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> singleFieldBuilderV3 = this.notifyReqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrNotifyRequest);
                } else if (attrNotifyRequest != null) {
                    this.action_ = attrNotifyRequest;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 10;
                return this;
            }

            public final Builder setNotifyReq(AttrNotifyRequest.Builder builder) {
                SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> singleFieldBuilderV3 = this.notifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 10;
                return this;
            }

            public final Builder mergeNotifyReq(AttrNotifyRequest attrNotifyRequest) {
                SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> singleFieldBuilderV3 = this.notifyReqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 10 || this.action_ == AttrNotifyRequest.getDefaultInstance()) {
                        this.action_ = attrNotifyRequest;
                    } else {
                        this.action_ = AttrNotifyRequest.newBuilder((AttrNotifyRequest) this.action_).mergeFrom(attrNotifyRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 10) {
                        singleFieldBuilderV3.mergeFrom(attrNotifyRequest);
                    }
                    this.notifyReqBuilder_.setMessage(attrNotifyRequest);
                }
                this.actionCase_ = 10;
                return this;
            }

            public final Builder clearNotifyReq() {
                if (this.notifyReqBuilder_ != null) {
                    if (this.actionCase_ == 10) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.notifyReqBuilder_.clear();
                } else if (this.actionCase_ == 10) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrNotifyRequest.Builder getNotifyReqBuilder() {
                return getNotifyReqFieldBuilder().getBuilder();
            }

            public final AttrNotifyRequestOrBuilder getNotifyReqOrBuilder() {
                SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 10 && (singleFieldBuilderV3 = this.notifyReqBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 10) {
                    return (AttrNotifyRequest) this.action_;
                }
                return AttrNotifyRequest.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrNotifyRequest, AttrNotifyRequest.Builder, AttrNotifyRequestOrBuilder> getNotifyReqFieldBuilder() {
                if (this.notifyReqBuilder_ == null) {
                    if (this.actionCase_ != 10) {
                        this.action_ = AttrNotifyRequest.getDefaultInstance();
                    }
                    this.notifyReqBuilder_ = new SingleFieldBuilderV3<>((AttrNotifyRequest) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 10;
                onChanged();
                return this.notifyReqBuilder_;
            }

            public final boolean hasNotifyRsp() {
                return this.actionCase_ == 11;
            }

            public final AttrNotifyResponse getNotifyRsp() {
                SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> singleFieldBuilderV3 = this.notifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 11) {
                        return (AttrNotifyResponse) this.action_;
                    }
                    return AttrNotifyResponse.getDefaultInstance();
                } else if (this.actionCase_ == 11) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrNotifyResponse.getDefaultInstance();
                }
            }

            public final Builder setNotifyRsp(AttrNotifyResponse attrNotifyResponse) {
                SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> singleFieldBuilderV3 = this.notifyRspBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrNotifyResponse);
                } else if (attrNotifyResponse != null) {
                    this.action_ = attrNotifyResponse;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 11;
                return this;
            }

            public final Builder setNotifyRsp(AttrNotifyResponse.Builder builder) {
                SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> singleFieldBuilderV3 = this.notifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 11;
                return this;
            }

            public final Builder mergeNotifyRsp(AttrNotifyResponse attrNotifyResponse) {
                SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> singleFieldBuilderV3 = this.notifyRspBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 11 || this.action_ == AttrNotifyResponse.getDefaultInstance()) {
                        this.action_ = attrNotifyResponse;
                    } else {
                        this.action_ = AttrNotifyResponse.newBuilder((AttrNotifyResponse) this.action_).mergeFrom(attrNotifyResponse).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 11) {
                        singleFieldBuilderV3.mergeFrom(attrNotifyResponse);
                    }
                    this.notifyRspBuilder_.setMessage(attrNotifyResponse);
                }
                this.actionCase_ = 11;
                return this;
            }

            public final Builder clearNotifyRsp() {
                if (this.notifyRspBuilder_ != null) {
                    if (this.actionCase_ == 11) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.notifyRspBuilder_.clear();
                } else if (this.actionCase_ == 11) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrNotifyResponse.Builder getNotifyRspBuilder() {
                return getNotifyRspFieldBuilder().getBuilder();
            }

            public final AttrNotifyResponseOrBuilder getNotifyRspOrBuilder() {
                SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 11 && (singleFieldBuilderV3 = this.notifyRspBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 11) {
                    return (AttrNotifyResponse) this.action_;
                }
                return AttrNotifyResponse.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrNotifyResponse, AttrNotifyResponse.Builder, AttrNotifyResponseOrBuilder> getNotifyRspFieldBuilder() {
                if (this.notifyRspBuilder_ == null) {
                    if (this.actionCase_ != 11) {
                        this.action_ = AttrNotifyResponse.getDefaultInstance();
                    }
                    this.notifyRspBuilder_ = new SingleFieldBuilderV3<>((AttrNotifyResponse) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 11;
                onChanged();
                return this.notifyRspBuilder_;
            }

            public final boolean hasNotifyPull() {
                return this.actionCase_ == 12;
            }

            public final AttrNotifyPull getNotifyPull() {
                SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> singleFieldBuilderV3 = this.notifyPullBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 12) {
                        return (AttrNotifyPull) this.action_;
                    }
                    return AttrNotifyPull.getDefaultInstance();
                } else if (this.actionCase_ == 12) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrNotifyPull.getDefaultInstance();
                }
            }

            public final Builder setNotifyPull(AttrNotifyPull attrNotifyPull) {
                SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> singleFieldBuilderV3 = this.notifyPullBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrNotifyPull);
                } else if (attrNotifyPull != null) {
                    this.action_ = attrNotifyPull;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 12;
                return this;
            }

            public final Builder setNotifyPull(AttrNotifyPull.Builder builder) {
                SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> singleFieldBuilderV3 = this.notifyPullBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 12;
                return this;
            }

            public final Builder mergeNotifyPull(AttrNotifyPull attrNotifyPull) {
                SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> singleFieldBuilderV3 = this.notifyPullBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 12 || this.action_ == AttrNotifyPull.getDefaultInstance()) {
                        this.action_ = attrNotifyPull;
                    } else {
                        this.action_ = AttrNotifyPull.newBuilder((AttrNotifyPull) this.action_).mergeFrom(attrNotifyPull).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 12) {
                        singleFieldBuilderV3.mergeFrom(attrNotifyPull);
                    }
                    this.notifyPullBuilder_.setMessage(attrNotifyPull);
                }
                this.actionCase_ = 12;
                return this;
            }

            public final Builder clearNotifyPull() {
                if (this.notifyPullBuilder_ != null) {
                    if (this.actionCase_ == 12) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.notifyPullBuilder_.clear();
                } else if (this.actionCase_ == 12) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrNotifyPull.Builder getNotifyPullBuilder() {
                return getNotifyPullFieldBuilder().getBuilder();
            }

            public final AttrNotifyPullOrBuilder getNotifyPullOrBuilder() {
                SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 12 && (singleFieldBuilderV3 = this.notifyPullBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 12) {
                    return (AttrNotifyPull) this.action_;
                }
                return AttrNotifyPull.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrNotifyPull, AttrNotifyPull.Builder, AttrNotifyPullOrBuilder> getNotifyPullFieldBuilder() {
                if (this.notifyPullBuilder_ == null) {
                    if (this.actionCase_ != 12) {
                        this.action_ = AttrNotifyPull.getDefaultInstance();
                    }
                    this.notifyPullBuilder_ = new SingleFieldBuilderV3<>((AttrNotifyPull) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 12;
                onChanged();
                return this.notifyPullBuilder_;
            }

            public final boolean hasNotifyPush() {
                return this.actionCase_ == 13;
            }

            public final AttrNotifyPush getNotifyPush() {
                SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> singleFieldBuilderV3 = this.notifyPushBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ == 13) {
                        return (AttrNotifyPush) this.action_;
                    }
                    return AttrNotifyPush.getDefaultInstance();
                } else if (this.actionCase_ == 13) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return AttrNotifyPush.getDefaultInstance();
                }
            }

            public final Builder setNotifyPush(AttrNotifyPush attrNotifyPush) {
                SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> singleFieldBuilderV3 = this.notifyPushBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(attrNotifyPush);
                } else if (attrNotifyPush != null) {
                    this.action_ = attrNotifyPush;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.actionCase_ = 13;
                return this;
            }

            public final Builder setNotifyPush(AttrNotifyPush.Builder builder) {
                SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> singleFieldBuilderV3 = this.notifyPushBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.action_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.actionCase_ = 13;
                return this;
            }

            public final Builder mergeNotifyPush(AttrNotifyPush attrNotifyPush) {
                SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> singleFieldBuilderV3 = this.notifyPushBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.actionCase_ != 13 || this.action_ == AttrNotifyPush.getDefaultInstance()) {
                        this.action_ = attrNotifyPush;
                    } else {
                        this.action_ = AttrNotifyPush.newBuilder((AttrNotifyPush) this.action_).mergeFrom(attrNotifyPush).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.actionCase_ == 13) {
                        singleFieldBuilderV3.mergeFrom(attrNotifyPush);
                    }
                    this.notifyPushBuilder_.setMessage(attrNotifyPush);
                }
                this.actionCase_ = 13;
                return this;
            }

            public final Builder clearNotifyPush() {
                if (this.notifyPushBuilder_ != null) {
                    if (this.actionCase_ == 13) {
                        this.actionCase_ = 0;
                        this.action_ = null;
                    }
                    this.notifyPushBuilder_.clear();
                } else if (this.actionCase_ == 13) {
                    this.actionCase_ = 0;
                    this.action_ = null;
                    onChanged();
                }
                return this;
            }

            public final AttrNotifyPush.Builder getNotifyPushBuilder() {
                return getNotifyPushFieldBuilder().getBuilder();
            }

            public final AttrNotifyPushOrBuilder getNotifyPushOrBuilder() {
                SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> singleFieldBuilderV3;
                if (this.actionCase_ == 13 && (singleFieldBuilderV3 = this.notifyPushBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.actionCase_ == 13) {
                    return (AttrNotifyPush) this.action_;
                }
                return AttrNotifyPush.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AttrNotifyPush, AttrNotifyPush.Builder, AttrNotifyPushOrBuilder> getNotifyPushFieldBuilder() {
                if (this.notifyPushBuilder_ == null) {
                    if (this.actionCase_ != 13) {
                        this.action_ = AttrNotifyPush.getDefaultInstance();
                    }
                    this.notifyPushBuilder_ = new SingleFieldBuilderV3<>((AttrNotifyPush) this.action_, getParentForChildren(), isClean());
                    this.action_ = null;
                }
                this.actionCase_ = 13;
                onChanged();
                return this.notifyPushBuilder_;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AttrOps getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttrOps> parser() {
            return PARSER;
        }

        public final Parser<AttrOps> getParserForType() {
            return PARSER;
        }

        public final AttrOps getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* renamed from: com.xiaomi.mi_connect_service.proto.AttributeProto$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase = new int[AttrOps.ActionCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.ADVDATA.ordinal()] = 1;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.WRITEREQ.ordinal()] = 2;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.WRITERSP.ordinal()] = 3;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.READREQ.ordinal()] = 4;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.READRSP.ordinal()] = 5;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.SETNOTIFYREQ.ordinal()] = 6;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.SETNOTIFYRSP.ordinal()] = 7;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.UNSETNOTIFYREQ.ordinal()] = 8;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.UNSETNOTIFYRSP.ordinal()] = 9;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.NOTIFYREQ.ordinal()] = 10;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.NOTIFYRSP.ordinal()] = 11;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.NOTIFYPULL.ordinal()] = 12;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.NOTIFYPUSH.ordinal()] = 13;
            $SwitchMap$com$xiaomi$mi_connect_service$proto$AttributeProto$AttrOps$ActionCase[AttrOps.ActionCase.ACTION_NOT_SET.ordinal()] = 14;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
