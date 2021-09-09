package com.google.protobuf;

import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {
    private final boolean proto3;

    /* access modifiers changed from: package-private */
    public void makeImmutable(Object obj) {
    }

    public UnknownFieldSetSchema(boolean z) {
        this.proto3 = z;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDiscardUnknownFields(Reader reader) {
        return reader.shouldDiscardUnknownFields();
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSet.Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    /* access modifiers changed from: package-private */
    public void addVarint(UnknownFieldSet.Builder builder, int i, long j) {
        builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addVarint(j).build());
    }

    /* access modifiers changed from: package-private */
    public void addFixed32(UnknownFieldSet.Builder builder, int i, int i2) {
        builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addFixed32(i2).build());
    }

    /* access modifiers changed from: package-private */
    public void addFixed64(UnknownFieldSet.Builder builder, int i, long j) {
        builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addFixed64(j).build());
    }

    /* access modifiers changed from: package-private */
    public void addLengthDelimited(UnknownFieldSet.Builder builder, int i, ByteString byteString) {
        builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
    }

    /* access modifiers changed from: package-private */
    public void addGroup(UnknownFieldSet.Builder builder, int i, UnknownFieldSet unknownFieldSet) {
        builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addGroup(unknownFieldSet).build());
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSet toImmutable(UnknownFieldSet.Builder builder) {
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public void writeTo(UnknownFieldSet unknownFieldSet, Writer writer) throws IOException {
        unknownFieldSet.writeTo(writer);
    }

    /* access modifiers changed from: package-private */
    public void writeAsMessageSetTo(UnknownFieldSet unknownFieldSet, Writer writer) throws IOException {
        unknownFieldSet.writeAsMessageSetTo(writer);
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSet getFromMessage(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields;
    }

    /* access modifiers changed from: package-private */
    public void setToMessage(Object obj, UnknownFieldSet unknownFieldSet) {
        ((GeneratedMessageV3) obj).unknownFields = unknownFieldSet;
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSet.Builder getBuilderFromMessage(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields.toBuilder();
    }

    /* access modifiers changed from: package-private */
    public void setBuilderToMessage(Object obj, UnknownFieldSet.Builder builder) {
        ((GeneratedMessageV3) obj).unknownFields = builder.build();
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSet merge(UnknownFieldSet unknownFieldSet, UnknownFieldSet unknownFieldSet2) {
        return unknownFieldSet.toBuilder().mergeFrom(unknownFieldSet2).build();
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSize();
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSizeAsMessageSet(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSizeAsMessageSet();
    }
}
