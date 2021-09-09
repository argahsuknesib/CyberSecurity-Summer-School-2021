package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jkz;
import _m_j.jla;
import _m_j.jlb;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class ItemLocationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    public int baseOffsetSize = 8;
    public int indexSize = 0;
    public List<Item> items = new LinkedList();
    public int lengthSize = 8;
    public int offsetSize = 8;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 118);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "offsetSize", "", "void"), 122);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "createItem", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox$Item"), 159);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "createExtent", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox$Extent"), 167);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 126);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setLengthSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "lengthSize", "", "void"), 130);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getBaseOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 134);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setBaseOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 138);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getIndexSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 142);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setIndexSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "indexSize", "", "void"), 146);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getItems", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "java.util.List"), 150);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setItems", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "java.util.List", "items", "", "void"), 154);
    }

    public ItemLocationBox() {
        super("iloc");
    }

    public long getContentSize() {
        long j = 8;
        for (Item size : this.items) {
            j += (long) size.getSize();
        }
        return j;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000o(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
        if (getVersion() == 1) {
            jla.O00000o(byteBuffer, (this.baseOffsetSize << 4) | this.indexSize);
        } else {
            jla.O00000o(byteBuffer, this.baseOffsetSize << 4);
        }
        jla.O00000Oo(byteBuffer, this.items.size());
        for (Item content : this.items) {
            content.getContent(byteBuffer);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.offsetSize = O000000o2 >>> 4;
        this.lengthSize = O000000o2 & 15;
        int O000000o3 = jky.O000000o(byteBuffer.get());
        this.baseOffsetSize = O000000o3 >>> 4;
        if (getVersion() == 1) {
            this.indexSize = O000000o3 & 15;
        }
        int O00000o0 = jky.O00000o0(byteBuffer);
        for (int i = 0; i < O00000o0; i++) {
            this.items.add(new Item(byteBuffer));
        }
    }

    public int getOffsetSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.offsetSize;
    }

    public int getLengthSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.lengthSize;
    }

    public int getBaseOffsetSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.baseOffsetSize;
    }

    public int getIndexSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.indexSize;
    }

    public List<Item> getItems() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.items;
    }

    public void setItems(List<Item> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.items = list;
    }

    /* access modifiers changed from: package-private */
    public Item createItem(ByteBuffer byteBuffer) {
        return new Item(byteBuffer);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object[]):_m_j.jhf
     arg types: [_m_j.jhf$O000000o, org.mp4parser.boxes.iso14496.part12.ItemLocationBox, org.mp4parser.boxes.iso14496.part12.ItemLocationBox, java.lang.Object[]]
     candidates:
      _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object):_m_j.jhf
      _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object[]):_m_j.jhf */
    public Extent createExtent(long j, long j2, long j3) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, (Object) this, (Object) this, new Object[]{jhm.O000000o(j), jhm.O000000o(j2), jhm.O000000o(j3)});
        jku.O000000o();
        jku.O000000o(O000000o2);
        return new Extent(j, j2, j3);
    }

    /* access modifiers changed from: package-private */
    public Extent createExtent(ByteBuffer byteBuffer) {
        return new Extent(byteBuffer);
    }

    public class Item {
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents = new LinkedList();
        public int itemId;

        public Item(ByteBuffer byteBuffer) {
            this.itemId = jky.O00000o0(byteBuffer);
            if (ItemLocationBox.this.getVersion() == 1) {
                this.constructionMethod = jky.O00000o0(byteBuffer) & 15;
            }
            this.dataReferenceIndex = jky.O00000o0(byteBuffer);
            if (ItemLocationBox.this.baseOffsetSize > 0) {
                this.baseOffset = jkz.O000000o(byteBuffer, ItemLocationBox.this.baseOffsetSize);
            } else {
                this.baseOffset = 0;
            }
            int O00000o0 = jky.O00000o0(byteBuffer);
            for (int i = 0; i < O00000o0; i++) {
                this.extents.add(new Extent(byteBuffer));
            }
        }

        public Item(int i, int i2, int i3, long j, List<Extent> list) {
            this.itemId = i;
            this.constructionMethod = i2;
            this.dataReferenceIndex = i3;
            this.baseOffset = j;
            this.extents = list;
        }

        public int getSize() {
            int i = (ItemLocationBox.this.getVersion() == 1 ? 4 : 2) + 2 + ItemLocationBox.this.baseOffsetSize + 2;
            for (Extent size : this.extents) {
                i += size.getSize();
            }
            return i;
        }

        public void setBaseOffset(long j) {
            this.baseOffset = j;
        }

        public void getContent(ByteBuffer byteBuffer) {
            jla.O00000Oo(byteBuffer, this.itemId);
            if (ItemLocationBox.this.getVersion() == 1) {
                jla.O00000Oo(byteBuffer, this.constructionMethod);
            }
            jla.O00000Oo(byteBuffer, this.dataReferenceIndex);
            if (ItemLocationBox.this.baseOffsetSize > 0) {
                jlb.O000000o(this.baseOffset, byteBuffer, ItemLocationBox.this.baseOffsetSize);
            }
            jla.O00000Oo(byteBuffer, this.extents.size());
            for (Extent content : this.extents) {
                content.getContent(byteBuffer);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            if (this.baseOffset != item.baseOffset || this.constructionMethod != item.constructionMethod || this.dataReferenceIndex != item.dataReferenceIndex || this.itemId != item.itemId) {
                return false;
            }
            List<Extent> list = this.extents;
            return list == null ? item.extents == null : list.equals(item.extents);
        }

        public int hashCode() {
            long j = this.baseOffset;
            int i = ((((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            List<Extent> list = this.extents;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Item{baseOffset=" + this.baseOffset + ", itemId=" + this.itemId + ", constructionMethod=" + this.constructionMethod + ", dataReferenceIndex=" + this.dataReferenceIndex + ", extents=" + this.extents + '}';
        }
    }

    public class Extent {
        public long extentIndex;
        public long extentLength;
        public long extentOffset;

        public Extent(long j, long j2, long j3) {
            this.extentOffset = j;
            this.extentLength = j2;
            this.extentIndex = j3;
        }

        public Extent(ByteBuffer byteBuffer) {
            if (ItemLocationBox.this.getVersion() == 1 && ItemLocationBox.this.indexSize > 0) {
                this.extentIndex = jkz.O000000o(byteBuffer, ItemLocationBox.this.indexSize);
            }
            this.extentOffset = jkz.O000000o(byteBuffer, ItemLocationBox.this.offsetSize);
            this.extentLength = jkz.O000000o(byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (ItemLocationBox.this.getVersion() == 1 && ItemLocationBox.this.indexSize > 0) {
                jlb.O000000o(this.extentIndex, byteBuffer, ItemLocationBox.this.indexSize);
            }
            jlb.O000000o(this.extentOffset, byteBuffer, ItemLocationBox.this.offsetSize);
            jlb.O000000o(this.extentLength, byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public int getSize() {
            return (ItemLocationBox.this.indexSize > 0 ? ItemLocationBox.this.indexSize : 0) + ItemLocationBox.this.offsetSize + ItemLocationBox.this.lengthSize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Extent extent = (Extent) obj;
            return this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset;
        }

        public int hashCode() {
            long j = this.extentOffset;
            long j2 = this.extentLength;
            long j3 = this.extentIndex;
            return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "Extent" + "{extentOffset=" + this.extentOffset + ", extentLength=" + this.extentLength + ", extentIndex=" + this.extentIndex + '}';
        }
    }

    public void setOffsetSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.offsetSize = i;
    }

    public void setLengthSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.lengthSize = i;
    }

    public void setBaseOffsetSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.baseOffsetSize = i;
    }

    public void setIndexSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.indexSize = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object[]):_m_j.jhf
     arg types: [_m_j.jhf$O000000o, org.mp4parser.boxes.iso14496.part12.ItemLocationBox, org.mp4parser.boxes.iso14496.part12.ItemLocationBox, java.lang.Object[]]
     candidates:
      _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object):_m_j.jhf
      _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object[]):_m_j.jhf */
    public Item createItem(int i, int i2, int i3, long j, List<Extent> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, (Object) this, (Object) this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jhm.O000000o(j), list});
        jku.O000000o();
        jku.O000000o(O000000o2);
        return new Item(i, i2, i3, j, list);
    }
}
