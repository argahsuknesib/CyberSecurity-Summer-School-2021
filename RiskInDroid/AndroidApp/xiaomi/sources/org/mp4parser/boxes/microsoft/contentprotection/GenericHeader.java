package org.mp4parser.boxes.microsoft.contentprotection;

import java.nio.ByteBuffer;
import java.util.UUID;
import org.mp4parser.boxes.microsoft.ProtectionSpecificHeader;

public class GenericHeader extends ProtectionSpecificHeader {
    public static UUID PROTECTION_SYSTEM_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    ByteBuffer data;

    static {
        ProtectionSpecificHeader.uuidRegistry.put(PROTECTION_SYSTEM_ID, GenericHeader.class);
    }

    public UUID getSystemId() {
        return PROTECTION_SYSTEM_ID;
    }

    public void parse(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public ByteBuffer getData() {
        return this.data;
    }
}
