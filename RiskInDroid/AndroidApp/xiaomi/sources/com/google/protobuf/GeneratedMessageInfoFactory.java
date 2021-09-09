package com.google.protobuf;

class GeneratedMessageInfoFactory implements MessageInfoFactory {
    private static final GeneratedMessageInfoFactory instance = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory getInstance() {
        return instance;
    }

    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    public MessageInfo messageInfoFor(Class<?> cls) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            try {
                return (MessageInfo) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
    }
}
