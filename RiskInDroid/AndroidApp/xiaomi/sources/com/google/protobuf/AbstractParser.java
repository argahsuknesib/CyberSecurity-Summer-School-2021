package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

    private UninitializedMessageException newUninitializedMessageException(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException((MessageLite) messagetype);
    }

    private MessageType checkMessageInitialized(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw newUninitializedMessageException(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public MessageType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (MessageLite) parsePartialFrom(codedInputStream, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized((MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(codedInputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            messagetype = (MessageLite) parsePartialFrom(newCodedInput, extensionRegistryLite);
            newCodedInput.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parsePartialFrom(byteString, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(byteString, extensionRegistryLite));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parseFrom(byteString, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageLite messageLite;
        try {
            CodedInputStream newInstance = CodedInputStream.newInstance(byteBuffer);
            messageLite = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
            newInstance.checkLastTagWas(0);
            return checkMessageInitialized(messageLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messageLite);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return parseFrom(byteBuffer, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
            messagetype = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, i, i2, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(bArr, i, i2, extensionRegistryLite));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return parseFrom(bArr, i, i2, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [byte[], com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parseFrom(bArr, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
        MessageType messagetype = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
        try {
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(inputStream, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(inputStream, extensionRegistryLite));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(java.nio.ByteBuffer, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parseFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.AbstractParser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.Parser.parsePartialFrom(byte[], com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parsePartialDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(inputStream, extensionRegistryLite));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractParser.parseDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
     candidates:
      com.google.protobuf.AbstractParser.parseDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object
      com.google.protobuf.Parser.parseDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType
      com.google.protobuf.AbstractParser.parseDelimitedFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):MessageType */
    public MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }
}
