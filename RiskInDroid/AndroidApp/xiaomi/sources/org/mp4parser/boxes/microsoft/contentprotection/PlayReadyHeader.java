package org.mp4parser.boxes.microsoft.contentprotection;

import _m_j.jky;
import _m_j.jla;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.mp4parser.boxes.microsoft.ProtectionSpecificHeader;

public class PlayReadyHeader extends ProtectionSpecificHeader {
    public static UUID PROTECTION_SYSTEM_ID = UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95");
    private long length;
    private List<PlayReadyRecord> records;

    static {
        ProtectionSpecificHeader.uuidRegistry.put(PROTECTION_SYSTEM_ID, PlayReadyHeader.class);
    }

    public UUID getSystemId() {
        return PROTECTION_SYSTEM_ID;
    }

    public ByteBuffer getData() {
        int i = 6;
        for (PlayReadyRecord value : this.records) {
            i = i + 4 + value.getValue().rewind().limit();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        jla.O00000o0(allocate, (long) i);
        jla.O00000o0(allocate, this.records.size());
        for (PlayReadyRecord next : this.records) {
            jla.O00000o0(allocate, next.type);
            jla.O00000o0(allocate, next.getValue().limit());
            allocate.put(next.getValue());
        }
        return allocate;
    }

    public List<PlayReadyRecord> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    public void setRecords(List<PlayReadyRecord> list) {
        this.records = list;
    }

    public String toString() {
        return "PlayReadyHeader" + "{length=" + this.length + ", recordCount=" + this.records.size() + ", records=" + this.records + '}';
    }

    public static abstract class PlayReadyRecord {
        int type;

        public abstract ByteBuffer getValue();

        public abstract void parse(ByteBuffer byteBuffer);

        public PlayReadyRecord(int i) {
            this.type = i;
        }

        public static List<PlayReadyRecord> createFor(ByteBuffer byteBuffer, int i) {
            PlayReadyRecord playReadyRecord;
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                int O00000o = jky.O00000o(byteBuffer);
                int O00000o2 = jky.O00000o(byteBuffer);
                if (O00000o == 1) {
                    playReadyRecord = new RMHeader();
                } else if (O00000o == 2) {
                    playReadyRecord = new DefaulPlayReadyRecord(2);
                } else if (O00000o != 3) {
                    playReadyRecord = new DefaulPlayReadyRecord(O00000o);
                } else {
                    playReadyRecord = new EmeddedLicenseStore();
                }
                playReadyRecord.parse((ByteBuffer) byteBuffer.slice().limit(O00000o2));
                byteBuffer.position(byteBuffer.position() + O00000o2);
                arrayList.add(playReadyRecord);
            }
            return arrayList;
        }

        public String toString() {
            return "PlayReadyRecord" + "{type=" + this.type + ", length=" + getValue().limit() + '}';
        }

        public static class RMHeader extends PlayReadyRecord {
            String header;

            public RMHeader() {
                super(1);
            }

            public void parse(ByteBuffer byteBuffer) {
                try {
                    byte[] bArr = new byte[byteBuffer.slice().limit()];
                    byteBuffer.get(bArr);
                    this.header = new String(bArr, "UTF-16LE");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }

            public ByteBuffer getValue() {
                try {
                    return ByteBuffer.wrap(this.header.getBytes("UTF-16LE"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }

            public String getHeader() {
                return this.header;
            }

            public void setHeader(String str) {
                this.header = str;
            }

            public String toString() {
                return "RMHeader" + "{length=" + getValue().limit() + ", header='" + this.header + '\'' + '}';
            }
        }

        public static class EmeddedLicenseStore extends PlayReadyRecord {
            ByteBuffer value;

            public EmeddedLicenseStore() {
                super(3);
            }

            public void parse(ByteBuffer byteBuffer) {
                this.value = byteBuffer.duplicate();
            }

            public ByteBuffer getValue() {
                return this.value;
            }

            public String toString() {
                return "EmeddedLicenseStore" + "{length=" + getValue().limit() + '}';
            }
        }

        public static class DefaulPlayReadyRecord extends PlayReadyRecord {
            ByteBuffer value;

            public DefaulPlayReadyRecord(int i) {
                super(i);
            }

            public void parse(ByteBuffer byteBuffer) {
                this.value = byteBuffer.duplicate();
            }

            public ByteBuffer getValue() {
                return this.value;
            }
        }
    }

    public void parse(ByteBuffer byteBuffer) {
        this.length = (((long) jky.O000000o(byteBuffer.get())) << 24) + (((long) jky.O000000o(byteBuffer.get())) << 16) + (((long) jky.O000000o(byteBuffer.get())) << 8) + (((long) jky.O000000o(byteBuffer.get())) << 0);
        this.records = PlayReadyRecord.createFor(byteBuffer, jky.O00000o(byteBuffer));
    }
}
