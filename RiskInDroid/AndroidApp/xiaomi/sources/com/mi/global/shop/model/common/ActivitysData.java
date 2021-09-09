package com.mi.global.shop.model.common;

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

public final class ActivitysData extends Message<ActivitysData, Builder> {
    public static final ProtoAdapter<ActivitysData> ADAPTER = new ProtoAdapter_ActivitysData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.CouponsData#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<CouponsData> coupons;
    @WireField(adapter = "com.mi.global.shop.model.common.GiftData#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<GiftData> gift;
    @WireField(adapter = "com.mi.global.shop.model.common.PostFreeData#ADAPTER", tag = 4)
    public final PostFreeData postFree;
    @WireField(adapter = "com.mi.global.shop.model.common.ReductionData#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<ReductionData> reduction;

    public ActivitysData(List<GiftData> list, List<ReductionData> list2, List<CouponsData> list3, PostFreeData postFreeData) {
        this(list, list2, list3, postFreeData, ByteString.O00000Oo);
    }

    public ActivitysData(List<GiftData> list, List<ReductionData> list2, List<CouponsData> list3, PostFreeData postFreeData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.gift = Internal.immutableCopyOf("gift", list);
        this.reduction = Internal.immutableCopyOf("reduction", list2);
        this.coupons = Internal.immutableCopyOf("coupons", list3);
        this.postFree = postFreeData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.gift = Internal.copyOf("gift", this.gift);
        builder.reduction = Internal.copyOf("reduction", this.reduction);
        builder.coupons = Internal.copyOf("coupons", this.coupons);
        builder.postFree = this.postFree;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivitysData)) {
            return false;
        }
        ActivitysData activitysData = (ActivitysData) obj;
        return Internal.equals(unknownFields(), activitysData.unknownFields()) && Internal.equals(this.gift, activitysData.gift) && Internal.equals(this.reduction, activitysData.reduction) && Internal.equals(this.coupons, activitysData.coupons) && Internal.equals(this.postFree, activitysData.postFree);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<GiftData> list = this.gift;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<ReductionData> list2 = this.reduction;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<CouponsData> list3 = this.coupons;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        PostFreeData postFreeData = this.postFree;
        int hashCode4 = i3 + (postFreeData != null ? postFreeData.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.gift != null) {
            sb.append(", gift=");
            sb.append(this.gift);
        }
        if (this.reduction != null) {
            sb.append(", reduction=");
            sb.append(this.reduction);
        }
        if (this.coupons != null) {
            sb.append(", coupons=");
            sb.append(this.coupons);
        }
        if (this.postFree != null) {
            sb.append(", postFree=");
            sb.append(this.postFree);
        }
        StringBuilder replace = sb.replace(0, 2, "ActivitysData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ActivitysData, Builder> {
        public List<CouponsData> coupons = Internal.newMutableList();
        public List<GiftData> gift = Internal.newMutableList();
        public PostFreeData postFree;
        public List<ReductionData> reduction = Internal.newMutableList();

        public final Builder gift(List<GiftData> list) {
            Internal.checkElementsNotNull(list);
            this.gift = list;
            return this;
        }

        public final Builder reduction(List<ReductionData> list) {
            Internal.checkElementsNotNull(list);
            this.reduction = list;
            return this;
        }

        public final Builder coupons(List<CouponsData> list) {
            Internal.checkElementsNotNull(list);
            this.coupons = list;
            return this;
        }

        public final Builder postFree(PostFreeData postFreeData) {
            this.postFree = postFreeData;
            return this;
        }

        public final ActivitysData build() {
            return new ActivitysData(this.gift, this.reduction, this.coupons, this.postFree, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ActivitysData extends ProtoAdapter<ActivitysData> {
        ProtoAdapter_ActivitysData() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivitysData.class);
        }

        public final int encodedSize(ActivitysData activitysData) {
            return GiftData.ADAPTER.asRepeated().encodedSizeWithTag(1, activitysData.gift) + ReductionData.ADAPTER.asRepeated().encodedSizeWithTag(2, activitysData.reduction) + CouponsData.ADAPTER.asRepeated().encodedSizeWithTag(3, activitysData.coupons) + (activitysData.postFree != null ? PostFreeData.ADAPTER.encodedSizeWithTag(4, activitysData.postFree) : 0) + activitysData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ActivitysData activitysData) throws IOException {
            if (activitysData.gift != null) {
                GiftData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, activitysData.gift);
            }
            if (activitysData.reduction != null) {
                ReductionData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, activitysData.reduction);
            }
            if (activitysData.coupons != null) {
                CouponsData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, activitysData.coupons);
            }
            if (activitysData.postFree != null) {
                PostFreeData.ADAPTER.encodeWithTag(protoWriter, 4, activitysData.postFree);
            }
            protoWriter.writeBytes(activitysData.unknownFields());
        }

        public final ActivitysData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.gift.add(GiftData.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.reduction.add(ReductionData.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.coupons.add(CouponsData.ADAPTER.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.postFree(PostFreeData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ActivitysData redact(ActivitysData activitysData) {
            Builder newBuilder = activitysData.newBuilder();
            Internal.redactElements(newBuilder.gift, GiftData.ADAPTER);
            Internal.redactElements(newBuilder.reduction, ReductionData.ADAPTER);
            Internal.redactElements(newBuilder.coupons, CouponsData.ADAPTER);
            if (newBuilder.postFree != null) {
                newBuilder.postFree = PostFreeData.ADAPTER.redact(newBuilder.postFree);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
