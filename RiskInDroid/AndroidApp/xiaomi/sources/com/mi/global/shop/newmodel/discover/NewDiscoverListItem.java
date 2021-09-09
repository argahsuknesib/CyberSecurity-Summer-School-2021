package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewDiscoverListItem {
    @SerializedName("addtime")
    public String addtime;
    @SerializedName("desc")
    public String content;
    @SerializedName("id")
    public String id;
    @SerializedName("img")
    public String imageUrl;
    @SerializedName("supportnum")
    public String likeCount;
    @SerializedName("share")
    public NewShareItem share;
    @SerializedName("status")
    public String status;
    @SerializedName("title")
    public String title;
    @SerializedName("classify")
    public String type;
    @SerializedName("url")
    public String url;
    @SerializedName("icon")
    public String userHeadImg;
    @SerializedName("uname")
    public String username;

    public static NewDiscoverListItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDiscoverListItem decode(ProtoReader protoReader) throws IOException {
        NewDiscoverListItem newDiscoverListItem = new NewDiscoverListItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newDiscoverListItem.id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newDiscoverListItem.type = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newDiscoverListItem.imageUrl = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newDiscoverListItem.title = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newDiscoverListItem.content = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newDiscoverListItem.url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newDiscoverListItem.addtime = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newDiscoverListItem.share = NewShareItem.decode(protoReader);
                        break;
                    case 9:
                        newDiscoverListItem.likeCount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newDiscoverListItem.userHeadImg = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newDiscoverListItem.username = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newDiscoverListItem.status = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newDiscoverListItem;
            }
        }
    }
}
