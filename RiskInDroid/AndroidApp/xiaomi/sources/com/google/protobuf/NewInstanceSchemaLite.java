package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;

final class NewInstanceSchemaLite implements NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    public final Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
