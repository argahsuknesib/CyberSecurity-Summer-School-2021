package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoData;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewSyncData {
    public NewActivityConfig activityConfig;
    public NewCacheConfig cacheConfig;
    public NewCentralHeader centralHeader;
    public ArrayList<String> download = new ArrayList<>();
    public ArrayList<HttpDnsModel> httpDnsIps = new ArrayList<>();
    public HttpsModel httpsModel;
    public ArrayList<String> inAppUrls = new ArrayList<>();
    public ArrayList<String> inBrowserUrls = new ArrayList<>();
    public ArrayList<String> inHardAccelerUrls = new ArrayList<>();
    public ArrayList<String> inSoftWareUrls = new ArrayList<>();
    public NewNoticeData notice;
    public NewPackageInfo packageInfo;
    public NewPageMessage pagemsg;
    public NewPassPortInfo passPortInfo;
    public ArrayList<NewPushType> pushTypeList = new ArrayList<>();
    public NewResurface resurface;
    public SearchConf searchConf;
    public boolean showPushTypeMenu;
    public NewStartPage startPage;
    public boolean subWarhouse;
    public SwitchInfo switchInfo;
    public NewUserInfoData userInfo;
    public NewVersionInfo versionInfo;

    public static NewSyncData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSyncData decode(ProtoReader protoReader) throws IOException {
        NewSyncData newSyncData = new NewSyncData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newSyncData.versionInfo = NewVersionInfo.decode(protoReader);
                        break;
                    case 2:
                        newSyncData.startPage = NewStartPage.decode(protoReader);
                        break;
                    case 3:
                        newSyncData.packageInfo = NewPackageInfo.decode(protoReader);
                        break;
                    case 4:
                        newSyncData.cacheConfig = NewCacheConfig.decode(protoReader);
                        break;
                    case 5:
                        newSyncData.activityConfig = NewActivityConfig.decode(protoReader);
                        break;
                    case 6:
                        newSyncData.download.add(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 7:
                        newSyncData.inBrowserUrls.add(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newSyncData.inHardAccelerUrls.add(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 9:
                        newSyncData.inAppUrls.add(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 10:
                        newSyncData.resurface = NewResurface.decode(protoReader);
                        break;
                    case 11:
                        newSyncData.subWarhouse = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newSyncData.centralHeader = NewCentralHeader.decode(protoReader);
                        break;
                    case 13:
                        newSyncData.pagemsg = NewPageMessage.decode(protoReader);
                        break;
                    case 14:
                        newSyncData.pushTypeList.add(NewPushType.decode(protoReader));
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newSyncData.passPortInfo = NewPassPortInfo.decode(protoReader);
                        break;
                    case 16:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                    case 17:
                        newSyncData.userInfo = NewUserInfoData.decode(protoReader);
                        break;
                    case 18:
                        newSyncData.notice = NewNoticeData.decode(protoReader);
                        break;
                    case 19:
                        newSyncData.showPushTypeMenu = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 20:
                        newSyncData.switchInfo = SwitchInfo.decode(protoReader);
                        break;
                    case 21:
                        newSyncData.httpDnsIps.add(HttpDnsModel.decode(protoReader));
                        break;
                    case 22:
                        newSyncData.inSoftWareUrls.add(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 25:
                        newSyncData.httpsModel = HttpsModel.decode(protoReader);
                        break;
                    case 29:
                        newSyncData.searchConf = SearchConf.decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newSyncData;
            }
        }
    }
}
