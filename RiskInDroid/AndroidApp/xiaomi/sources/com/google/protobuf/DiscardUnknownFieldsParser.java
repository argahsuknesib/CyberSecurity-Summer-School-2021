package com.google.protobuf;

public final class DiscardUnknownFieldsParser {
    public static final <T extends Message> Parser<T> wrap(final Parser<T> parser) {
        return new AbstractParser<T>() {
            /* class com.google.protobuf.DiscardUnknownFieldsParser.AnonymousClass1 */

            public final T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                try {
                    codedInputStream.discardUnknownFields();
                    return (Message) parser.parsePartialFrom(codedInputStream, extensionRegistryLite);
                } finally {
                    codedInputStream.unsetDiscardUnknownFields();
                }
            }
        };
    }

    private DiscardUnknownFieldsParser() {
    }
}
