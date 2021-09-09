package org.mp4parser.boxes.samplegrouping;

import _m_j.jky;
import _m_j.jla;
import _m_j.jlh;
import java.nio.ByteBuffer;
import java.util.UUID;

public class CencSampleEncryptionInformationGroupEntry extends GroupEntry {
    private boolean isEncrypted;
    private byte ivSize;
    private UUID kid;

    public String getType() {
        return "seig";
    }

    public void parse(ByteBuffer byteBuffer) {
        boolean z = true;
        if (jky.O00000Oo(byteBuffer) != 1) {
            z = false;
        }
        this.isEncrypted = z;
        this.ivSize = (byte) jky.O000000o(byteBuffer.get());
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.kid = jlh.O000000o(bArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000o(java.nio.ByteBuffer, int):void
     arg types: [java.nio.ByteBuffer, byte]
     candidates:
      _m_j.jla.O00000o(java.nio.ByteBuffer, long):void
      _m_j.jla.O00000o(java.nio.ByteBuffer, int):void */
    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        jla.O000000o(allocate, this.isEncrypted ? 1 : 0);
        if (this.isEncrypted) {
            jla.O00000o(allocate, (int) this.ivSize);
            allocate.put(jlh.O000000o(this.kid));
        } else {
            allocate.put(new byte[17]);
        }
        allocate.rewind();
        return allocate;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public byte getIvSize() {
        return this.ivSize;
    }

    public void setIvSize(int i) {
        this.ivSize = (byte) i;
    }

    public UUID getKid() {
        return this.kid;
    }

    public void setKid(UUID uuid) {
        this.kid = uuid;
    }

    public String toString() {
        return "CencSampleEncryptionInformationGroupEntry{isEncrypted=" + this.isEncrypted + ", ivSize=" + ((int) this.ivSize) + ", kid=" + this.kid + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CencSampleEncryptionInformationGroupEntry cencSampleEncryptionInformationGroupEntry = (CencSampleEncryptionInformationGroupEntry) obj;
        if (this.isEncrypted != cencSampleEncryptionInformationGroupEntry.isEncrypted || this.ivSize != cencSampleEncryptionInformationGroupEntry.ivSize) {
            return false;
        }
        UUID uuid = this.kid;
        return uuid == null ? cencSampleEncryptionInformationGroupEntry.kid == null : uuid.equals(cencSampleEncryptionInformationGroupEntry.kid);
    }

    public int hashCode() {
        int i = (((this.isEncrypted ? 7 : 19) * 31) + this.ivSize) * 31;
        UUID uuid = this.kid;
        return i + (uuid != null ? uuid.hashCode() : 0);
    }
}
