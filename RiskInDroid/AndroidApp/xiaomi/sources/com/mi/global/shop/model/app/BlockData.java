package com.mi.global.shop.model.app;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class BlockData extends Message<BlockData, Builder> {
    public static final ProtoAdapter<BlockData> ADAPTER = new ProtoAdapter_BlockData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<BlockInfo> accessorieslist;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<BlockInfo> gallery;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<BlockInfo> gamerecommend;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    public final List<BlockInfo> hdrecommend;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<BlockInfo> hotbuy;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<BlockInfo> index_ad;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<BlockInfo> phonelist;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final List<BlockInfo> productrecommend;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<BlockInfo> products;

    public BlockData(List<BlockInfo> list, List<BlockInfo> list2, List<BlockInfo> list3, List<BlockInfo> list4, List<BlockInfo> list5, List<BlockInfo> list6, List<BlockInfo> list7, List<BlockInfo> list8, List<BlockInfo> list9) {
        this(list, list2, list3, list4, list5, list6, list7, list8, list9, ByteString.O00000Oo);
    }

    public BlockData(List<BlockInfo> list, List<BlockInfo> list2, List<BlockInfo> list3, List<BlockInfo> list4, List<BlockInfo> list5, List<BlockInfo> list6, List<BlockInfo> list7, List<BlockInfo> list8, List<BlockInfo> list9, ByteString byteString) {
        super(ADAPTER, byteString);
        this.gallery = Internal.immutableCopyOf("gallery", list);
        this.products = Internal.immutableCopyOf("products", list2);
        this.index_ad = Internal.immutableCopyOf("index_ad", list3);
        this.hotbuy = Internal.immutableCopyOf("hotbuy", list4);
        this.gamerecommend = Internal.immutableCopyOf("gamerecommend", list5);
        this.phonelist = Internal.immutableCopyOf("phonelist", list6);
        this.accessorieslist = Internal.immutableCopyOf("accessorieslist", list7);
        this.productrecommend = Internal.immutableCopyOf("productrecommend", list8);
        this.hdrecommend = Internal.immutableCopyOf("hdrecommend", list9);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.gallery = Internal.copyOf("gallery", this.gallery);
        builder.products = Internal.copyOf("products", this.products);
        builder.index_ad = Internal.copyOf("index_ad", this.index_ad);
        builder.hotbuy = Internal.copyOf("hotbuy", this.hotbuy);
        builder.gamerecommend = Internal.copyOf("gamerecommend", this.gamerecommend);
        builder.phonelist = Internal.copyOf("phonelist", this.phonelist);
        builder.accessorieslist = Internal.copyOf("accessorieslist", this.accessorieslist);
        builder.productrecommend = Internal.copyOf("productrecommend", this.productrecommend);
        builder.hdrecommend = Internal.copyOf("hdrecommend", this.hdrecommend);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockData)) {
            return false;
        }
        BlockData blockData = (BlockData) obj;
        return Internal.equals(unknownFields(), blockData.unknownFields()) && Internal.equals(this.gallery, blockData.gallery) && Internal.equals(this.products, blockData.products) && Internal.equals(this.index_ad, blockData.index_ad) && Internal.equals(this.hotbuy, blockData.hotbuy) && Internal.equals(this.gamerecommend, blockData.gamerecommend) && Internal.equals(this.phonelist, blockData.phonelist) && Internal.equals(this.accessorieslist, blockData.accessorieslist) && Internal.equals(this.productrecommend, blockData.productrecommend) && Internal.equals(this.hdrecommend, blockData.hdrecommend);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<BlockInfo> list = this.gallery;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<BlockInfo> list2 = this.products;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<BlockInfo> list3 = this.index_ad;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<BlockInfo> list4 = this.hotbuy;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<BlockInfo> list5 = this.gamerecommend;
        int hashCode6 = (hashCode5 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<BlockInfo> list6 = this.phonelist;
        int hashCode7 = (hashCode6 + (list6 != null ? list6.hashCode() : 1)) * 37;
        List<BlockInfo> list7 = this.accessorieslist;
        int hashCode8 = (hashCode7 + (list7 != null ? list7.hashCode() : 1)) * 37;
        List<BlockInfo> list8 = this.productrecommend;
        int hashCode9 = (hashCode8 + (list8 != null ? list8.hashCode() : 1)) * 37;
        List<BlockInfo> list9 = this.hdrecommend;
        if (list9 != null) {
            i2 = list9.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.gallery != null) {
            sb.append(", gallery=");
            sb.append(this.gallery);
        }
        if (this.products != null) {
            sb.append(", products=");
            sb.append(this.products);
        }
        if (this.index_ad != null) {
            sb.append(", index_ad=");
            sb.append(this.index_ad);
        }
        if (this.hotbuy != null) {
            sb.append(", hotbuy=");
            sb.append(this.hotbuy);
        }
        if (this.gamerecommend != null) {
            sb.append(", gamerecommend=");
            sb.append(this.gamerecommend);
        }
        if (this.phonelist != null) {
            sb.append(", phonelist=");
            sb.append(this.phonelist);
        }
        if (this.accessorieslist != null) {
            sb.append(", accessorieslist=");
            sb.append(this.accessorieslist);
        }
        if (this.productrecommend != null) {
            sb.append(", productrecommend=");
            sb.append(this.productrecommend);
        }
        if (this.hdrecommend != null) {
            sb.append(", hdrecommend=");
            sb.append(this.hdrecommend);
        }
        StringBuilder replace = sb.replace(0, 2, "BlockData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BlockData, Builder> {
        public List<BlockInfo> accessorieslist = Internal.newMutableList();
        public List<BlockInfo> gallery = Internal.newMutableList();
        public List<BlockInfo> gamerecommend = Internal.newMutableList();
        public List<BlockInfo> hdrecommend = Internal.newMutableList();
        public List<BlockInfo> hotbuy = Internal.newMutableList();
        public List<BlockInfo> index_ad = Internal.newMutableList();
        public List<BlockInfo> phonelist = Internal.newMutableList();
        public List<BlockInfo> productrecommend = Internal.newMutableList();
        public List<BlockInfo> products = Internal.newMutableList();

        public final Builder gallery(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.gallery = list;
            return this;
        }

        public final Builder products(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.products = list;
            return this;
        }

        public final Builder index_ad(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.index_ad = list;
            return this;
        }

        public final Builder hotbuy(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.hotbuy = list;
            return this;
        }

        public final Builder gamerecommend(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.gamerecommend = list;
            return this;
        }

        public final Builder phonelist(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.phonelist = list;
            return this;
        }

        public final Builder accessorieslist(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.accessorieslist = list;
            return this;
        }

        public final Builder productrecommend(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.productrecommend = list;
            return this;
        }

        public final Builder hdrecommend(List<BlockInfo> list) {
            Internal.checkElementsNotNull(list);
            this.hdrecommend = list;
            return this;
        }

        public final BlockData build() {
            return new BlockData(this.gallery, this.products, this.index_ad, this.hotbuy, this.gamerecommend, this.phonelist, this.accessorieslist, this.productrecommend, this.hdrecommend, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_BlockData extends ProtoAdapter<BlockData> {
        ProtoAdapter_BlockData() {
            super(FieldEncoding.LENGTH_DELIMITED, BlockData.class);
        }

        public final int encodedSize(BlockData blockData) {
            return BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, blockData.gallery) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, blockData.products) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, blockData.index_ad) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, blockData.hotbuy) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, blockData.gamerecommend) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(6, blockData.phonelist) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(7, blockData.accessorieslist) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(8, blockData.productrecommend) + BlockInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, blockData.hdrecommend) + blockData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, BlockData blockData) throws IOException {
            if (blockData.gallery != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, blockData.gallery);
            }
            if (blockData.products != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, blockData.products);
            }
            if (blockData.index_ad != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, blockData.index_ad);
            }
            if (blockData.hotbuy != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, blockData.hotbuy);
            }
            if (blockData.gamerecommend != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, blockData.gamerecommend);
            }
            if (blockData.phonelist != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, blockData.phonelist);
            }
            if (blockData.accessorieslist != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, blockData.accessorieslist);
            }
            if (blockData.productrecommend != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, blockData.productrecommend);
            }
            if (blockData.hdrecommend != null) {
                BlockInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 9, blockData.hdrecommend);
            }
            protoWriter.writeBytes(blockData.unknownFields());
        }

        public final BlockData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.gallery.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.products.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.index_ad.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.hotbuy.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.gamerecommend.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.phonelist.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.accessorieslist.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.productrecommend.add(BlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            builder.hdrecommend.add(BlockInfo.ADAPTER.decode(protoReader));
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

        public final BlockData redact(BlockData blockData) {
            Builder newBuilder = blockData.newBuilder();
            Internal.redactElements(newBuilder.gallery, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.products, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.index_ad, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.hotbuy, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.gamerecommend, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.phonelist, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.accessorieslist, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.productrecommend, BlockInfo.ADAPTER);
            Internal.redactElements(newBuilder.hdrecommend, BlockInfo.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
