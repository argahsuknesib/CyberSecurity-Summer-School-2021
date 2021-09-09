package org.mp4parser.boxes.iso23001.part7;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat;

public abstract class AbstractSampleEncryptionBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    protected int algorithmId = -1;
    List<CencSampleAuxiliaryDataFormat> entries = Collections.emptyList();
    protected int ivSize = -1;
    protected byte[] kid = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getOffsetToFirstIV", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "int"), 28);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 89);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 93);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "equals", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 173);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "hashCode", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "int"), 200);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getEntrySizes", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 208);
    }

    protected AbstractSampleEncryptionBox(String str) {
        super(str);
    }

    public int getOffsetToFirstIV() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getSize() > 4294967296L ? 16 : 8) + (isOverrideTrackEncryptionBoxParameters() ? this.kid.length + 4 : 0) + 4;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) > 0) {
            this.algorithmId = jky.O00000Oo(byteBuffer);
            this.ivSize = jky.O000000o(byteBuffer.get());
            this.kid = new byte[16];
            byteBuffer.get(this.kid);
        }
        long O000000o2 = jky.O000000o(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        this.entries = parseEntries(duplicate, O000000o2, 8);
        if (this.entries == null) {
            this.entries = parseEntries(duplicate2, O000000o2, 16);
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining());
        } else {
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining());
        }
        if (this.entries == null) {
            throw new RuntimeException("Cannot parse SampleEncryptionBox");
        }
    }

    private List<CencSampleAuxiliaryDataFormat> parseEntries(ByteBuffer byteBuffer, long j, int i) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            long j2 = j - 1;
            if (j <= 0) {
                return arrayList;
            }
            try {
                CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
                cencSampleAuxiliaryDataFormat.iv = new byte[i];
                byteBuffer.get(cencSampleAuxiliaryDataFormat.iv);
                if ((getFlags() & 2) > 0) {
                    cencSampleAuxiliaryDataFormat.pairs = new CencSampleAuxiliaryDataFormat.Pair[jky.O00000o0(byteBuffer)];
                    for (int i2 = 0; i2 < cencSampleAuxiliaryDataFormat.pairs.length; i2++) {
                        cencSampleAuxiliaryDataFormat.pairs[i2] = cencSampleAuxiliaryDataFormat.createPair(jky.O00000o0(byteBuffer), jky.O000000o(byteBuffer));
                    }
                }
                arrayList.add(cencSampleAuxiliaryDataFormat);
                j = j2;
            } catch (BufferUnderflowException unused) {
                return null;
            }
        }
    }

    public List<CencSampleAuxiliaryDataFormat> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public void setEntries(List<CencSampleAuxiliaryDataFormat> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public boolean isSubSampleEncryption() {
        return (getFlags() & 2) > 0;
    }

    public void setSubSampleEncryption(boolean z) {
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & 16777213);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isOverrideTrackEncryptionBoxParameters() {
        return (getFlags() & 1) > 0;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            jla.O000000o(byteBuffer, this.algorithmId);
            jla.O00000o(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        jla.O00000Oo(byteBuffer, (long) getNonEmptyEntriesNum());
        for (CencSampleAuxiliaryDataFormat next : this.entries) {
            if (next.getSize() > 0) {
                if (next.iv.length == 8 || next.iv.length == 16) {
                    byteBuffer.put(next.iv);
                    if (isSubSampleEncryption()) {
                        jla.O00000Oo(byteBuffer, next.pairs.length);
                        for (CencSampleAuxiliaryDataFormat.Pair pair : next.pairs) {
                            jla.O00000Oo(byteBuffer, pair.clear());
                            jla.O00000Oo(byteBuffer, pair.encrypted());
                        }
                    }
                } else {
                    throw new RuntimeException("IV must be either 8 or 16 bytes");
                }
            }
        }
    }

    private int getNonEmptyEntriesNum() {
        int i = 0;
        for (CencSampleAuxiliaryDataFormat size : this.entries) {
            if (size.getSize() > 0) {
                i++;
            }
        }
        return i;
    }

    public long getContentSize() {
        long length = (isOverrideTrackEncryptionBoxParameters() ? 8 + ((long) this.kid.length) : 4) + 4;
        for (CencSampleAuxiliaryDataFormat size : this.entries) {
            length += (long) size.getSize();
        }
        return length;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        super.getBox(writableByteChannel);
    }

    public boolean equals(Object obj) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, obj);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractSampleEncryptionBox abstractSampleEncryptionBox = (AbstractSampleEncryptionBox) obj;
        if (this.algorithmId != abstractSampleEncryptionBox.algorithmId || this.ivSize != abstractSampleEncryptionBox.ivSize) {
            return false;
        }
        List<CencSampleAuxiliaryDataFormat> list = this.entries;
        if (list == null ? abstractSampleEncryptionBox.entries == null : list.equals(abstractSampleEncryptionBox.entries)) {
            return Arrays.equals(this.kid, abstractSampleEncryptionBox.kid);
        }
        return false;
    }

    public int hashCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        int i = ((this.algorithmId * 31) + this.ivSize) * 31;
        byte[] bArr = this.kid;
        int i2 = 0;
        int hashCode = (i + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        List<CencSampleAuxiliaryDataFormat> list = this.entries;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public List<Short> getEntrySizes() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        ArrayList arrayList = new ArrayList(this.entries.size());
        for (CencSampleAuxiliaryDataFormat next : this.entries) {
            short length = (short) next.iv.length;
            if (isSubSampleEncryption()) {
                length = (short) (((short) (length + 2)) + (next.pairs.length * 6));
            }
            arrayList.add(Short.valueOf(length));
        }
        return arrayList;
    }
}
