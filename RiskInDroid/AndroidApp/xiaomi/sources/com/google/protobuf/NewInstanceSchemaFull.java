package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;

public final class NewInstanceSchemaFull implements NewInstanceSchema {
    NewInstanceSchemaFull() {
    }

    public final Object newInstance(Object obj) {
        return ((GeneratedMessageV3) obj).newInstance(GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
    }
}
