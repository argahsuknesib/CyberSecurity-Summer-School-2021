package com.mi.global.shop.model.discover;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class ItemsInfo extends Message<ItemsInfo, Builder> {
    public static final ProtoAdapter<ItemsInfo> ADAPTER = new ProtoAdapter_ItemsInfo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String addtime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String classify;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String desc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String icon;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String img;
    @WireField(adapter = "com.mi.global.shop.model.app.Share#ADAPTER", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final Share share;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String status;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String supportnum;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String title;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String uname;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String url;

    public ItemsInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Share share2, String str8, String str9, String str10, String str11) {
        this(str, str2, str3, str4, str5, str6, str7, share2, str8, str9, str10, str11, ByteString.O00000Oo);
    }

    public ItemsInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Share share2, String str8, String str9, String str10, String str11, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = str;
        this.classify = str2;
        this.img = str3;
        this.title = str4;
        this.desc = str5;
        this.url = str6;
        this.addtime = str7;
        this.share = share2;
        this.supportnum = str8;
        this.icon = str9;
        this.uname = str10;
        this.status = str11;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.classify = this.classify;
        builder.img = this.img;
        builder.title = this.title;
        builder.desc = this.desc;
        builder.url = this.url;
        builder.addtime = this.addtime;
        builder.share = this.share;
        builder.supportnum = this.supportnum;
        builder.icon = this.icon;
        builder.uname = this.uname;
        builder.status = this.status;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemsInfo)) {
            return false;
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        return Internal.equals(unknownFields(), itemsInfo.unknownFields()) && Internal.equals(this.id, itemsInfo.id) && Internal.equals(this.classify, itemsInfo.classify) && Internal.equals(this.img, itemsInfo.img) && Internal.equals(this.title, itemsInfo.title) && Internal.equals(this.desc, itemsInfo.desc) && Internal.equals(this.url, itemsInfo.url) && Internal.equals(this.addtime, itemsInfo.addtime) && Internal.equals(this.share, itemsInfo.share) && Internal.equals(this.supportnum, itemsInfo.supportnum) && Internal.equals(this.icon, itemsInfo.icon) && Internal.equals(this.uname, itemsInfo.uname) && Internal.equals(this.status, itemsInfo.status);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.classify;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.img;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.title;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.desc;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.url;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.addtime;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Share share2 = this.share;
        int hashCode9 = (hashCode8 + (share2 != null ? share2.hashCode() : 0)) * 37;
        String str8 = this.supportnum;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.icon;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.uname;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.status;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.classify != null) {
            sb.append(", classify=");
            sb.append(this.classify);
        }
        if (this.img != null) {
            sb.append(", img=");
            sb.append(this.img);
        }
        if (this.title != null) {
            sb.append(", title=");
            sb.append(this.title);
        }
        if (this.desc != null) {
            sb.append(", desc=");
            sb.append(this.desc);
        }
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        if (this.addtime != null) {
            sb.append(", addtime=");
            sb.append(this.addtime);
        }
        if (this.share != null) {
            sb.append(", share=");
            sb.append(this.share);
        }
        if (this.supportnum != null) {
            sb.append(", supportnum=");
            sb.append(this.supportnum);
        }
        if (this.icon != null) {
            sb.append(", icon=");
            sb.append(this.icon);
        }
        if (this.uname != null) {
            sb.append(", uname=");
            sb.append(this.uname);
        }
        if (this.status != null) {
            sb.append(", status=");
            sb.append(this.status);
        }
        StringBuilder replace = sb.replace(0, 2, "ItemsInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ItemsInfo, Builder> {
        public String addtime;
        public String classify;
        public String desc;
        public String icon;
        public String id;
        public String img;
        public Share share;
        public String status;
        public String supportnum;
        public String title;
        public String uname;
        public String url;

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder classify(String str) {
            this.classify = str;
            return this;
        }

        public final Builder img(String str) {
            this.img = str;
            return this;
        }

        public final Builder title(String str) {
            this.title = str;
            return this;
        }

        public final Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder addtime(String str) {
            this.addtime = str;
            return this;
        }

        public final Builder share(Share share2) {
            this.share = share2;
            return this;
        }

        public final Builder supportnum(String str) {
            this.supportnum = str;
            return this;
        }

        public final Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public final Builder uname(String str) {
            this.uname = str;
            return this;
        }

        public final Builder status(String str) {
            this.status = str;
            return this;
        }

        public final ItemsInfo build() {
            return new ItemsInfo(this.id, this.classify, this.img, this.title, this.desc, this.url, this.addtime, this.share, this.supportnum, this.icon, this.uname, this.status, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ItemsInfo extends ProtoAdapter<ItemsInfo> {
        ProtoAdapter_ItemsInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ItemsInfo.class);
        }

        public final int encodedSize(ItemsInfo itemsInfo) {
            int i = 0;
            int encodedSizeWithTag = (itemsInfo.id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, itemsInfo.id) : 0) + (itemsInfo.classify != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, itemsInfo.classify) : 0) + (itemsInfo.img != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, itemsInfo.img) : 0) + (itemsInfo.title != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, itemsInfo.title) : 0) + (itemsInfo.desc != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, itemsInfo.desc) : 0) + (itemsInfo.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, itemsInfo.url) : 0) + (itemsInfo.addtime != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, itemsInfo.addtime) : 0) + (itemsInfo.share != null ? Share.ADAPTER.encodedSizeWithTag(8, itemsInfo.share) : 0) + (itemsInfo.supportnum != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, itemsInfo.supportnum) : 0) + (itemsInfo.icon != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, itemsInfo.icon) : 0) + (itemsInfo.uname != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, itemsInfo.uname) : 0);
            if (itemsInfo.status != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(12, itemsInfo.status);
            }
            return encodedSizeWithTag + i + itemsInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ItemsInfo itemsInfo) throws IOException {
            if (itemsInfo.id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, itemsInfo.id);
            }
            if (itemsInfo.classify != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, itemsInfo.classify);
            }
            if (itemsInfo.img != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, itemsInfo.img);
            }
            if (itemsInfo.title != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, itemsInfo.title);
            }
            if (itemsInfo.desc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, itemsInfo.desc);
            }
            if (itemsInfo.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, itemsInfo.url);
            }
            if (itemsInfo.addtime != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, itemsInfo.addtime);
            }
            if (itemsInfo.share != null) {
                Share.ADAPTER.encodeWithTag(protoWriter, 8, itemsInfo.share);
            }
            if (itemsInfo.supportnum != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, itemsInfo.supportnum);
            }
            if (itemsInfo.icon != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, itemsInfo.icon);
            }
            if (itemsInfo.uname != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, itemsInfo.uname);
            }
            if (itemsInfo.status != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, itemsInfo.status);
            }
            protoWriter.writeBytes(itemsInfo.unknownFields());
        }

        public final ItemsInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.classify(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.img(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.title(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.desc(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.addtime(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.share(Share.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            builder.supportnum(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.icon(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.uname(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.status(ProtoAdapter.STRING.decode(protoReader));
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

        public final ItemsInfo redact(ItemsInfo itemsInfo) {
            Builder newBuilder = itemsInfo.newBuilder();
            if (newBuilder.share != null) {
                newBuilder.share = Share.ADAPTER.redact(newBuilder.share);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
