package com.mi.global.shop.model.app;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.mi.global.shop.model.basestruct.PageMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class SyncData extends Message<SyncData, Builder> {
    public static final ProtoAdapter<SyncData> ADAPTER = new ProtoAdapter_SyncData();
    public static final Boolean DEFAULT_SUBWARHOUSE = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.app.ActivityConf#ADAPTER", tag = 5)
    public final ActivityConf activityConfig;
    @WireField(adapter = "com.mi.global.shop.model.app.CacheConf#ADAPTER", tag = 4)
    public final CacheConf cacheConfig;
    @WireField(adapter = "com.mi.global.shop.model.app.CentralHeader#ADAPTER", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final CentralHeader centralHeader;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 6)
    public final List<String> download;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 9)
    public final List<String> inAppUrls;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 7)
    public final List<String> inBrowserUrls;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final List<String> inHardAccelerUrls;
    @WireField(adapter = "com.mi.global.shop.model.app.PackInfo#ADAPTER", tag = 3)
    public final PackInfo packageInfo;
    @WireField(adapter = "com.mi.global.shop.model.basestruct.PageMessage#ADAPTER", tag = 13)
    public final PageMessage pagemsg;
    @WireField(adapter = "com.mi.global.shop.model.app.PassPortInfo#ADAPTER", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final PassPortInfo passPortInfo;
    @WireField(adapter = "com.mi.global.shop.model.app.PushType#ADAPTER", label = WireField.Label.REPEATED, tag = 14)
    public final List<PushType> pushTypeList;
    @WireField(adapter = "com.mi.global.shop.model.app.Resurfacing#ADAPTER", tag = 10)
    public final Resurfacing resurface;
    @WireField(adapter = "com.mi.global.shop.model.app.StPage#ADAPTER", tag = 2)
    public final StPage startPage;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean subWarhouse;
    @WireField(adapter = "com.mi.global.shop.model.app.SwitchInfo#ADAPTER", tag = 16)
    public final SwitchInfo switchInfo;
    @WireField(adapter = "com.mi.global.shop.model.app.VerInfo#ADAPTER", tag = 1)
    public final VerInfo versionInfo;

    public SyncData(VerInfo verInfo, StPage stPage, PackInfo packInfo, CacheConf cacheConf, ActivityConf activityConf, List<String> list, List<String> list2, List<String> list3, List<String> list4, Resurfacing resurfacing, Boolean bool, CentralHeader centralHeader2, PageMessage pageMessage, List<PushType> list5, PassPortInfo passPortInfo2, SwitchInfo switchInfo2) {
        this(verInfo, stPage, packInfo, cacheConf, activityConf, list, list2, list3, list4, resurfacing, bool, centralHeader2, pageMessage, list5, passPortInfo2, switchInfo2, ByteString.O00000Oo);
    }

    public SyncData(VerInfo verInfo, StPage stPage, PackInfo packInfo, CacheConf cacheConf, ActivityConf activityConf, List<String> list, List<String> list2, List<String> list3, List<String> list4, Resurfacing resurfacing, Boolean bool, CentralHeader centralHeader2, PageMessage pageMessage, List<PushType> list5, PassPortInfo passPortInfo2, SwitchInfo switchInfo2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.versionInfo = verInfo;
        this.startPage = stPage;
        this.packageInfo = packInfo;
        this.cacheConfig = cacheConf;
        this.activityConfig = activityConf;
        this.download = Internal.immutableCopyOf("download", list);
        this.inBrowserUrls = Internal.immutableCopyOf("inBrowserUrls", list2);
        this.inHardAccelerUrls = Internal.immutableCopyOf("inHardAccelerUrls", list3);
        this.inAppUrls = Internal.immutableCopyOf("inAppUrls", list4);
        this.resurface = resurfacing;
        this.subWarhouse = bool;
        this.centralHeader = centralHeader2;
        this.pagemsg = pageMessage;
        this.pushTypeList = Internal.immutableCopyOf("pushTypeList", list5);
        this.passPortInfo = passPortInfo2;
        this.switchInfo = switchInfo2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.versionInfo = this.versionInfo;
        builder.startPage = this.startPage;
        builder.packageInfo = this.packageInfo;
        builder.cacheConfig = this.cacheConfig;
        builder.activityConfig = this.activityConfig;
        builder.download = Internal.copyOf("download", this.download);
        builder.inBrowserUrls = Internal.copyOf("inBrowserUrls", this.inBrowserUrls);
        builder.inHardAccelerUrls = Internal.copyOf("inHardAccelerUrls", this.inHardAccelerUrls);
        builder.inAppUrls = Internal.copyOf("inAppUrls", this.inAppUrls);
        builder.resurface = this.resurface;
        builder.subWarhouse = this.subWarhouse;
        builder.centralHeader = this.centralHeader;
        builder.pagemsg = this.pagemsg;
        builder.pushTypeList = Internal.copyOf("pushTypeList", this.pushTypeList);
        builder.passPortInfo = this.passPortInfo;
        builder.switchInfo = this.switchInfo;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SyncData)) {
            return false;
        }
        SyncData syncData = (SyncData) obj;
        return Internal.equals(unknownFields(), syncData.unknownFields()) && Internal.equals(this.versionInfo, syncData.versionInfo) && Internal.equals(this.startPage, syncData.startPage) && Internal.equals(this.packageInfo, syncData.packageInfo) && Internal.equals(this.cacheConfig, syncData.cacheConfig) && Internal.equals(this.activityConfig, syncData.activityConfig) && Internal.equals(this.download, syncData.download) && Internal.equals(this.inBrowserUrls, syncData.inBrowserUrls) && Internal.equals(this.inHardAccelerUrls, syncData.inHardAccelerUrls) && Internal.equals(this.inAppUrls, syncData.inAppUrls) && Internal.equals(this.resurface, syncData.resurface) && Internal.equals(this.subWarhouse, syncData.subWarhouse) && Internal.equals(this.centralHeader, syncData.centralHeader) && Internal.equals(this.pagemsg, syncData.pagemsg) && Internal.equals(this.pushTypeList, syncData.pushTypeList) && Internal.equals(this.passPortInfo, syncData.passPortInfo) && Internal.equals(this.switchInfo, syncData.switchInfo);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        VerInfo verInfo = this.versionInfo;
        int i2 = 0;
        int hashCode2 = (hashCode + (verInfo != null ? verInfo.hashCode() : 0)) * 37;
        StPage stPage = this.startPage;
        int hashCode3 = (hashCode2 + (stPage != null ? stPage.hashCode() : 0)) * 37;
        PackInfo packInfo = this.packageInfo;
        int hashCode4 = (hashCode3 + (packInfo != null ? packInfo.hashCode() : 0)) * 37;
        CacheConf cacheConf = this.cacheConfig;
        int hashCode5 = (hashCode4 + (cacheConf != null ? cacheConf.hashCode() : 0)) * 37;
        ActivityConf activityConf = this.activityConfig;
        int hashCode6 = (hashCode5 + (activityConf != null ? activityConf.hashCode() : 0)) * 37;
        List<String> list = this.download;
        int i3 = 1;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.inBrowserUrls;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<String> list3 = this.inHardAccelerUrls;
        int hashCode9 = (hashCode8 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<String> list4 = this.inAppUrls;
        int hashCode10 = (hashCode9 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Resurfacing resurfacing = this.resurface;
        int hashCode11 = (hashCode10 + (resurfacing != null ? resurfacing.hashCode() : 0)) * 37;
        Boolean bool = this.subWarhouse;
        int hashCode12 = (hashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
        CentralHeader centralHeader2 = this.centralHeader;
        int hashCode13 = (hashCode12 + (centralHeader2 != null ? centralHeader2.hashCode() : 0)) * 37;
        PageMessage pageMessage = this.pagemsg;
        int hashCode14 = (hashCode13 + (pageMessage != null ? pageMessage.hashCode() : 0)) * 37;
        List<PushType> list5 = this.pushTypeList;
        if (list5 != null) {
            i3 = list5.hashCode();
        }
        int i4 = (hashCode14 + i3) * 37;
        PassPortInfo passPortInfo2 = this.passPortInfo;
        int hashCode15 = (i4 + (passPortInfo2 != null ? passPortInfo2.hashCode() : 0)) * 37;
        SwitchInfo switchInfo2 = this.switchInfo;
        if (switchInfo2 != null) {
            i2 = switchInfo2.hashCode();
        }
        int i5 = hashCode15 + i2;
        this.hashCode = i5;
        return i5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.versionInfo != null) {
            sb.append(", versionInfo=");
            sb.append(this.versionInfo);
        }
        if (this.startPage != null) {
            sb.append(", startPage=");
            sb.append(this.startPage);
        }
        if (this.packageInfo != null) {
            sb.append(", packageInfo=");
            sb.append(this.packageInfo);
        }
        if (this.cacheConfig != null) {
            sb.append(", cacheConfig=");
            sb.append(this.cacheConfig);
        }
        if (this.activityConfig != null) {
            sb.append(", activityConfig=");
            sb.append(this.activityConfig);
        }
        if (this.download != null) {
            sb.append(", download=");
            sb.append(this.download);
        }
        if (this.inBrowserUrls != null) {
            sb.append(", inBrowserUrls=");
            sb.append(this.inBrowserUrls);
        }
        if (this.inHardAccelerUrls != null) {
            sb.append(", inHardAccelerUrls=");
            sb.append(this.inHardAccelerUrls);
        }
        if (this.inAppUrls != null) {
            sb.append(", inAppUrls=");
            sb.append(this.inAppUrls);
        }
        if (this.resurface != null) {
            sb.append(", resurface=");
            sb.append(this.resurface);
        }
        if (this.subWarhouse != null) {
            sb.append(", subWarhouse=");
            sb.append(this.subWarhouse);
        }
        if (this.centralHeader != null) {
            sb.append(", centralHeader=");
            sb.append(this.centralHeader);
        }
        if (this.pagemsg != null) {
            sb.append(", pagemsg=");
            sb.append(this.pagemsg);
        }
        if (this.pushTypeList != null) {
            sb.append(", pushTypeList=");
            sb.append(this.pushTypeList);
        }
        if (this.passPortInfo != null) {
            sb.append(", passPortInfo=");
            sb.append(this.passPortInfo);
        }
        if (this.switchInfo != null) {
            sb.append(", switchInfo=");
            sb.append(this.switchInfo);
        }
        StringBuilder replace = sb.replace(0, 2, "SyncData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SyncData, Builder> {
        public ActivityConf activityConfig;
        public CacheConf cacheConfig;
        public CentralHeader centralHeader;
        public List<String> download = Internal.newMutableList();
        public List<String> inAppUrls = Internal.newMutableList();
        public List<String> inBrowserUrls = Internal.newMutableList();
        public List<String> inHardAccelerUrls = Internal.newMutableList();
        public PackInfo packageInfo;
        public PageMessage pagemsg;
        public PassPortInfo passPortInfo;
        public List<PushType> pushTypeList = Internal.newMutableList();
        public Resurfacing resurface;
        public StPage startPage;
        public Boolean subWarhouse;
        public SwitchInfo switchInfo;
        public VerInfo versionInfo;

        public final Builder versionInfo(VerInfo verInfo) {
            this.versionInfo = verInfo;
            return this;
        }

        public final Builder startPage(StPage stPage) {
            this.startPage = stPage;
            return this;
        }

        public final Builder packageInfo(PackInfo packInfo) {
            this.packageInfo = packInfo;
            return this;
        }

        public final Builder cacheConfig(CacheConf cacheConf) {
            this.cacheConfig = cacheConf;
            return this;
        }

        public final Builder activityConfig(ActivityConf activityConf) {
            this.activityConfig = activityConf;
            return this;
        }

        public final Builder download(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.download = list;
            return this;
        }

        public final Builder inBrowserUrls(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.inBrowserUrls = list;
            return this;
        }

        public final Builder inHardAccelerUrls(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.inHardAccelerUrls = list;
            return this;
        }

        public final Builder inAppUrls(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.inAppUrls = list;
            return this;
        }

        public final Builder resurface(Resurfacing resurfacing) {
            this.resurface = resurfacing;
            return this;
        }

        public final Builder subWarhouse(Boolean bool) {
            this.subWarhouse = bool;
            return this;
        }

        public final Builder centralHeader(CentralHeader centralHeader2) {
            this.centralHeader = centralHeader2;
            return this;
        }

        public final Builder pagemsg(PageMessage pageMessage) {
            this.pagemsg = pageMessage;
            return this;
        }

        public final Builder pushTypeList(List<PushType> list) {
            Internal.checkElementsNotNull(list);
            this.pushTypeList = list;
            return this;
        }

        public final Builder passPortInfo(PassPortInfo passPortInfo2) {
            this.passPortInfo = passPortInfo2;
            return this;
        }

        public final Builder switchInfo(SwitchInfo switchInfo2) {
            this.switchInfo = switchInfo2;
            return this;
        }

        public final SyncData build() {
            return new SyncData(this.versionInfo, this.startPage, this.packageInfo, this.cacheConfig, this.activityConfig, this.download, this.inBrowserUrls, this.inHardAccelerUrls, this.inAppUrls, this.resurface, this.subWarhouse, this.centralHeader, this.pagemsg, this.pushTypeList, this.passPortInfo, this.switchInfo, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SyncData extends ProtoAdapter<SyncData> {
        ProtoAdapter_SyncData() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncData.class);
        }

        public final int encodedSize(SyncData syncData) {
            int i = 0;
            int encodedSizeWithTag = (syncData.versionInfo != null ? VerInfo.ADAPTER.encodedSizeWithTag(1, syncData.versionInfo) : 0) + (syncData.startPage != null ? StPage.ADAPTER.encodedSizeWithTag(2, syncData.startPage) : 0) + (syncData.packageInfo != null ? PackInfo.ADAPTER.encodedSizeWithTag(3, syncData.packageInfo) : 0) + (syncData.cacheConfig != null ? CacheConf.ADAPTER.encodedSizeWithTag(4, syncData.cacheConfig) : 0) + (syncData.activityConfig != null ? ActivityConf.ADAPTER.encodedSizeWithTag(5, syncData.activityConfig) : 0) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(6, syncData.download) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(7, syncData.inBrowserUrls) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, syncData.inHardAccelerUrls) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(9, syncData.inAppUrls) + (syncData.resurface != null ? Resurfacing.ADAPTER.encodedSizeWithTag(10, syncData.resurface) : 0) + (syncData.subWarhouse != null ? ProtoAdapter.BOOL.encodedSizeWithTag(11, syncData.subWarhouse) : 0) + (syncData.centralHeader != null ? CentralHeader.ADAPTER.encodedSizeWithTag(12, syncData.centralHeader) : 0) + (syncData.pagemsg != null ? PageMessage.ADAPTER.encodedSizeWithTag(13, syncData.pagemsg) : 0) + PushType.ADAPTER.asRepeated().encodedSizeWithTag(14, syncData.pushTypeList) + (syncData.passPortInfo != null ? PassPortInfo.ADAPTER.encodedSizeWithTag(15, syncData.passPortInfo) : 0);
            if (syncData.switchInfo != null) {
                i = SwitchInfo.ADAPTER.encodedSizeWithTag(16, syncData.switchInfo);
            }
            return encodedSizeWithTag + i + syncData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SyncData syncData) throws IOException {
            if (syncData.versionInfo != null) {
                VerInfo.ADAPTER.encodeWithTag(protoWriter, 1, syncData.versionInfo);
            }
            if (syncData.startPage != null) {
                StPage.ADAPTER.encodeWithTag(protoWriter, 2, syncData.startPage);
            }
            if (syncData.packageInfo != null) {
                PackInfo.ADAPTER.encodeWithTag(protoWriter, 3, syncData.packageInfo);
            }
            if (syncData.cacheConfig != null) {
                CacheConf.ADAPTER.encodeWithTag(protoWriter, 4, syncData.cacheConfig);
            }
            if (syncData.activityConfig != null) {
                ActivityConf.ADAPTER.encodeWithTag(protoWriter, 5, syncData.activityConfig);
            }
            if (syncData.download != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 6, syncData.download);
            }
            if (syncData.inBrowserUrls != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 7, syncData.inBrowserUrls);
            }
            if (syncData.inHardAccelerUrls != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 8, syncData.inHardAccelerUrls);
            }
            if (syncData.inAppUrls != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 9, syncData.inAppUrls);
            }
            if (syncData.resurface != null) {
                Resurfacing.ADAPTER.encodeWithTag(protoWriter, 10, syncData.resurface);
            }
            if (syncData.subWarhouse != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 11, syncData.subWarhouse);
            }
            if (syncData.centralHeader != null) {
                CentralHeader.ADAPTER.encodeWithTag(protoWriter, 12, syncData.centralHeader);
            }
            if (syncData.pagemsg != null) {
                PageMessage.ADAPTER.encodeWithTag(protoWriter, 13, syncData.pagemsg);
            }
            if (syncData.pushTypeList != null) {
                PushType.ADAPTER.asRepeated().encodeWithTag(protoWriter, 14, syncData.pushTypeList);
            }
            if (syncData.passPortInfo != null) {
                PassPortInfo.ADAPTER.encodeWithTag(protoWriter, 15, syncData.passPortInfo);
            }
            if (syncData.switchInfo != null) {
                SwitchInfo.ADAPTER.encodeWithTag(protoWriter, 16, syncData.switchInfo);
            }
            protoWriter.writeBytes(syncData.unknownFields());
        }

        public final SyncData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.versionInfo(VerInfo.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.startPage(StPage.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.packageInfo(PackInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.cacheConfig(CacheConf.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.activityConfig(ActivityConf.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.download.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.inBrowserUrls.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.inHardAccelerUrls.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.inAppUrls.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.resurface(Resurfacing.ADAPTER.decode(protoReader));
                            break;
                        case 11:
                            builder.subWarhouse(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.centralHeader(CentralHeader.ADAPTER.decode(protoReader));
                            break;
                        case 13:
                            builder.pagemsg(PageMessage.ADAPTER.decode(protoReader));
                            break;
                        case 14:
                            builder.pushTypeList.add(PushType.ADAPTER.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.passPortInfo(PassPortInfo.ADAPTER.decode(protoReader));
                            break;
                        case 16:
                            builder.switchInfo(SwitchInfo.ADAPTER.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final SyncData redact(SyncData syncData) {
            Builder newBuilder = syncData.newBuilder();
            if (newBuilder.versionInfo != null) {
                newBuilder.versionInfo = VerInfo.ADAPTER.redact(newBuilder.versionInfo);
            }
            if (newBuilder.startPage != null) {
                newBuilder.startPage = StPage.ADAPTER.redact(newBuilder.startPage);
            }
            if (newBuilder.packageInfo != null) {
                newBuilder.packageInfo = PackInfo.ADAPTER.redact(newBuilder.packageInfo);
            }
            if (newBuilder.cacheConfig != null) {
                newBuilder.cacheConfig = CacheConf.ADAPTER.redact(newBuilder.cacheConfig);
            }
            if (newBuilder.activityConfig != null) {
                newBuilder.activityConfig = ActivityConf.ADAPTER.redact(newBuilder.activityConfig);
            }
            if (newBuilder.resurface != null) {
                newBuilder.resurface = Resurfacing.ADAPTER.redact(newBuilder.resurface);
            }
            if (newBuilder.centralHeader != null) {
                newBuilder.centralHeader = CentralHeader.ADAPTER.redact(newBuilder.centralHeader);
            }
            if (newBuilder.pagemsg != null) {
                newBuilder.pagemsg = PageMessage.ADAPTER.redact(newBuilder.pagemsg);
            }
            Internal.redactElements(newBuilder.pushTypeList, PushType.ADAPTER);
            if (newBuilder.passPortInfo != null) {
                newBuilder.passPortInfo = PassPortInfo.ADAPTER.redact(newBuilder.passPortInfo);
            }
            if (newBuilder.switchInfo != null) {
                newBuilder.switchInfo = SwitchInfo.ADAPTER.redact(newBuilder.switchInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
