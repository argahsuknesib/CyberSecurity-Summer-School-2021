package org.mp4parser.boxes.samplegrouping;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part15.StepwiseTemporalLayerEntry;
import org.mp4parser.boxes.iso14496.part15.SyncSampleEntry;
import org.mp4parser.boxes.iso14496.part15.TemporalLayerSampleGroup;
import org.mp4parser.boxes.iso14496.part15.TemporalSubLayerSampleGroup;

public class SampleGroupDescriptionBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private int defaultLength;
    private List<GroupEntry> groupEntries = new LinkedList();
    private String groupingType;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getGroupingType", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 56);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setGroupingType", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 60);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultLength", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 152);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultLength", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 156);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getGroupEntries", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 160);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setGroupEntries", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 164);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "equals", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 169);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "hashCode", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 190);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 198);
    }

    public SampleGroupDescriptionBox() {
        super("sgpd");
        setVersion(1);
    }

    public String getGroupingType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.groupingType;
    }

    public void setGroupingType(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.groupingType = str;
    }

    public long getContentSize() {
        long j = (getVersion() == 1 ? 12 : 8) + 4;
        for (GroupEntry next : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                j += 4;
            }
            j += (long) next.size();
        }
        return j;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(jhc.O000000o(this.groupingType));
        if (getVersion() == 1) {
            jla.O00000Oo(byteBuffer, (long) this.defaultLength);
        }
        jla.O00000Oo(byteBuffer, (long) this.groupEntries.size());
        for (GroupEntry next : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                jla.O00000Oo(byteBuffer, (long) next.get().limit());
            }
            byteBuffer.put(next.get());
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.groupingType = jky.O0000OoO(byteBuffer);
            if (getVersion() == 1) {
                this.defaultLength = jkv.O000000o(jky.O000000o(byteBuffer));
            }
            long O000000o2 = jky.O000000o(byteBuffer);
            while (true) {
                long j = O000000o2 - 1;
                if (O000000o2 > 0) {
                    int i = this.defaultLength;
                    if (getVersion() == 1) {
                        if (this.defaultLength == 0) {
                            i = jkv.O000000o(jky.O000000o(byteBuffer));
                        }
                        int position = byteBuffer.position() + i;
                        ByteBuffer slice = byteBuffer.slice();
                        slice.limit(i);
                        this.groupEntries.add(parseGroupEntry(slice, this.groupingType));
                        byteBuffer.position(position);
                        O000000o2 = j;
                    } else {
                        throw new RuntimeException("This should be implemented");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        GroupEntry groupEntry;
        if ("roll".equals(str)) {
            groupEntry = new RollRecoveryEntry();
        } else if ("rash".equals(str)) {
            groupEntry = new RateShareEntry();
        } else if ("seig".equals(str)) {
            groupEntry = new CencSampleEncryptionInformationGroupEntry();
        } else if ("rap ".equals(str)) {
            groupEntry = new VisualRandomAccessEntry();
        } else if ("tele".equals(str)) {
            groupEntry = new TemporalLevelEntry();
        } else if ("sync".equals(str)) {
            groupEntry = new SyncSampleEntry();
        } else if ("tscl".equals(str)) {
            groupEntry = new TemporalLayerSampleGroup();
        } else if ("tsas".equals(str)) {
            groupEntry = new TemporalSubLayerSampleGroup();
        } else if ("stsa".equals(str)) {
            groupEntry = new StepwiseTemporalLayerEntry();
        } else {
            groupEntry = new UnknownEntry(str);
        }
        groupEntry.parse(byteBuffer);
        return groupEntry;
    }

    public int getDefaultLength() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultLength;
    }

    public List<GroupEntry> getGroupEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.groupEntries;
    }

    public void setGroupEntries(List<GroupEntry> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.groupEntries = list;
    }

    public boolean equals(Object obj) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, obj);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
        if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
            return false;
        }
        List<GroupEntry> list = this.groupEntries;
        return list == null ? sampleGroupDescriptionBox.groupEntries == null : list.equals(sampleGroupDescriptionBox.groupEntries);
    }

    public int hashCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        int i = 0;
        int i2 = (this.defaultLength + 0) * 31;
        List<GroupEntry> list = this.groupEntries;
        if (list != null) {
            i = list.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        StringBuilder sb = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        sb.append(this.groupEntries.size() > 0 ? this.groupEntries.get(0).getType() : "????");
        sb.append('\'');
        sb.append(", defaultLength=");
        sb.append(this.defaultLength);
        sb.append(", groupEntries=");
        sb.append(this.groupEntries);
        sb.append('}');
        return sb.toString();
    }

    public void setDefaultLength(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultLength = i;
    }
}
