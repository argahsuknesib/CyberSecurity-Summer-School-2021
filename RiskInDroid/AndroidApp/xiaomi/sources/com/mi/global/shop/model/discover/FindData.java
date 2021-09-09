package com.mi.global.shop.model.discover;

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

public final class FindData extends Message<FindData, Builder> {
    public static final ProtoAdapter<FindData> ADAPTER = new ProtoAdapter_FindData();
    public static final Long DEFAULT_CURRENTPAGE = 0L;
    public static final Long DEFAULT_TOTALPAGES = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long currentpage;
    @WireField(adapter = "com.mi.global.shop.model.app.ItemsInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<ItemsInfo> items;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long totalpages;

    public FindData(Long l, Long l2, List<ItemsInfo> list) {
        this(l, l2, list, ByteString.O00000Oo);
    }

    public FindData(Long l, Long l2, List<ItemsInfo> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.totalpages = l;
        this.currentpage = l2;
        this.items = Internal.immutableCopyOf("items", list);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.totalpages = this.totalpages;
        builder.currentpage = this.currentpage;
        builder.items = Internal.copyOf("items", this.items);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FindData)) {
            return false;
        }
        FindData findData = (FindData) obj;
        return Internal.equals(unknownFields(), findData.unknownFields()) && Internal.equals(this.totalpages, findData.totalpages) && Internal.equals(this.currentpage, findData.currentpage) && Internal.equals(this.items, findData.items);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.totalpages;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.currentpage;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<ItemsInfo> list = this.items;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.totalpages != null) {
            sb.append(", totalpages=");
            sb.append(this.totalpages);
        }
        if (this.currentpage != null) {
            sb.append(", currentpage=");
            sb.append(this.currentpage);
        }
        if (this.items != null) {
            sb.append(", items=");
            sb.append(this.items);
        }
        StringBuilder replace = sb.replace(0, 2, "FindData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<FindData, Builder> {
        public Long currentpage;
        public List<ItemsInfo> items = Internal.newMutableList();
        public Long totalpages;

        public final Builder totalpages(Long l) {
            this.totalpages = l;
            return this;
        }

        public final Builder currentpage(Long l) {
            this.currentpage = l;
            return this;
        }

        public final Builder items(List<ItemsInfo> list) {
            Internal.checkElementsNotNull(list);
            this.items = list;
            return this;
        }

        public final FindData build() {
            return new FindData(this.totalpages, this.currentpage, this.items, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_FindData extends ProtoAdapter<FindData> {
        ProtoAdapter_FindData() {
            super(FieldEncoding.LENGTH_DELIMITED, FindData.class);
        }

        public final int encodedSize(FindData findData) {
            int i = 0;
            int encodedSizeWithTag = findData.totalpages != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, findData.totalpages) : 0;
            if (findData.currentpage != null) {
                i = ProtoAdapter.INT64.encodedSizeWithTag(2, findData.currentpage);
            }
            return encodedSizeWithTag + i + ItemsInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, findData.items) + findData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, FindData findData) throws IOException {
            if (findData.totalpages != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, findData.totalpages);
            }
            if (findData.currentpage != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, findData.currentpage);
            }
            if (findData.items != null) {
                ItemsInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, findData.items);
            }
            protoWriter.writeBytes(findData.unknownFields());
        }

        public final FindData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.totalpages(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.currentpage(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.items.add(ItemsInfo.ADAPTER.decode(protoReader));
                }
            }
        }

        public final FindData redact(FindData findData) {
            Builder newBuilder = findData.newBuilder();
            Internal.redactElements(newBuilder.items, ItemsInfo.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
