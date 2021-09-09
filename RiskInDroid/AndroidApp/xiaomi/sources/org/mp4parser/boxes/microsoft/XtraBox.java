package org.mp4parser.boxes.microsoft;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class XtraBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    ByteBuffer data;
    private boolean successfulParse = false;
    Vector<XtraTag> tags = new Vector<>();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("XtraBox.java", XtraBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.microsoft.XtraBox", "", "", "", "java.lang.String"), 131);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getAllTagNames", "org.mp4parser.boxes.microsoft.XtraBox", "", "", "", "[Ljava.lang.String;"), 193);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "setTagValue", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:long", "name:value", "", "void"), 326);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getFirstStringValue", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.String"), 208);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getFirstDateValue", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.util.Date"), 224);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getFirstLongValue", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.Long"), 240);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getValues", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "[Ljava.lang.Object;"), 256);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "removeTag", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "void"), 275);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setTagValues", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:[Ljava.lang.String;", "name:values", "", "void"), 288);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setTagValue", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.lang.String", "name:value", "", "void"), 303);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setTagValue", "org.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.util.Date", "name:date", "", "void"), 313);
    }

    public static long millisToFiletime(long j) {
        return (j + 11644473600000L) * 10000;
    }

    public XtraBox() {
        super("Xtra");
    }

    public XtraBox(String str) {
        super(str);
    }

    public static long filetimeToMillis(long j) {
        return (j / 10000) - 11644473600000L;
    }

    public static void writeAsciiString(ByteBuffer byteBuffer, String str) {
        try {
            byteBuffer.put(str.getBytes("US-ASCII"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Shouldn't happen", e);
        }
    }

    public static String readAsciiString(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Shouldn't happen", e);
        }
    }

    public static String readUtf16String(ByteBuffer byteBuffer, int i) {
        int i2 = (i / 2) - 1;
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = byteBuffer.getChar();
        }
        byteBuffer.getChar();
        return new String(cArr);
    }

    public static void writeUtf16String(ByteBuffer byteBuffer, String str) {
        char[] charArray = str.toCharArray();
        for (char putChar : charArray) {
            byteBuffer.putChar(putChar);
        }
        byteBuffer.putChar(0);
    }

    public long getContentSize() {
        int limit;
        if (this.successfulParse) {
            limit = detailSize();
        } else {
            limit = this.data.limit();
        }
        return (long) limit;
    }

    private int detailSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.tags.size(); i2++) {
            i += this.tags.elementAt(i2).getContentSize();
        }
        return i;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (!isParsed()) {
            parseDetails();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XtraBox[");
        Iterator<XtraTag> it = this.tags.iterator();
        while (it.hasNext()) {
            XtraTag next = it.next();
            Iterator<XtraValue> it2 = next.values.iterator();
            while (it2.hasNext()) {
                stringBuffer.append(next.tagName);
                stringBuffer.append("=");
                stringBuffer.append(it2.next().toString());
                stringBuffer.append(";");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.data = byteBuffer.slice();
        this.successfulParse = false;
        try {
            this.tags.clear();
            while (byteBuffer.remaining() > 0) {
                XtraTag xtraTag = new XtraTag((XtraTag) null);
                xtraTag.parse(byteBuffer);
                this.tags.addElement(xtraTag);
            }
            int detailSize = detailSize();
            if (remaining == detailSize) {
                this.successfulParse = true;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                return;
            }
            throw new RuntimeException("Improperly handled Xtra tag: Calculated sizes don't match ( " + remaining + "/" + detailSize + ")");
        } catch (Exception e) {
            this.successfulParse = false;
            PrintStream printStream = System.err;
            printStream.println("Malformed Xtra Tag detected: " + e.toString());
            e.printStackTrace();
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } catch (Throwable th) {
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            throw th;
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        if (this.successfulParse) {
            for (int i = 0; i < this.tags.size(); i++) {
                this.tags.elementAt(i).getContent(byteBuffer);
            }
            return;
        }
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    public String[] getAllTagNames() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        String[] strArr = new String[this.tags.size()];
        for (int i = 0; i < this.tags.size(); i++) {
            strArr[i] = this.tags.elementAt(i).tagName;
        }
        return strArr;
    }

    public String getFirstStringValue(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        for (Object obj : getValues(str)) {
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public Date getFirstDateValue(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        for (Object obj : getValues(str)) {
            if (obj instanceof Date) {
                return (Date) obj;
            }
        }
        return null;
    }

    public Long getFirstLongValue(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        for (Object obj : getValues(str)) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
        }
        return null;
    }

    public Object[] getValues(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        XtraTag tagByName = getTagByName(str);
        if (tagByName == null) {
            return new Object[0];
        }
        Object[] objArr = new Object[tagByName.values.size()];
        for (int i = 0; i < tagByName.values.size(); i++) {
            objArr[i] = tagByName.values.elementAt(i).getValueAsObject();
        }
        return objArr;
    }

    public void removeTag(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        XtraTag tagByName = getTagByName(str);
        if (tagByName != null) {
            this.tags.remove(tagByName);
        }
    }

    public void setTagValues(String str, String[] strArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, str, strArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str, null);
        for (String xtraValue : strArr) {
            xtraTag.values.addElement(new XtraValue(xtraValue, (XtraValue) null));
        }
        this.tags.addElement(xtraTag);
    }

    public void setTagValue(String str, String str2) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, str, str2);
        jku.O000000o();
        jku.O000000o(O000000o2);
        setTagValues(str, new String[]{str2});
    }

    public void setTagValue(String str, Date date) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, str, date);
        jku.O000000o();
        jku.O000000o(O000000o2);
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str, null);
        xtraTag.values.addElement(new XtraValue(date, (XtraValue) null));
        this.tags.addElement(xtraTag);
    }

    public void setTagValue(String str, long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this, str, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str, null);
        xtraTag.values.addElement(new XtraValue(j, (XtraValue) null));
        this.tags.addElement(xtraTag);
    }

    private XtraTag getTagByName(String str) {
        Iterator<XtraTag> it = this.tags.iterator();
        while (it.hasNext()) {
            XtraTag next = it.next();
            if (next.tagName.equals(str)) {
                return next;
            }
        }
        return null;
    }

    static class XtraTag {
        private int inputSize;
        public String tagName;
        public Vector<XtraValue> values;

        private XtraTag() {
            this.values = new Vector<>();
        }

        /* synthetic */ XtraTag(XtraTag xtraTag) {
            this();
        }

        /* synthetic */ XtraTag(String str, XtraTag xtraTag) {
            this(str);
        }

        private XtraTag(String str) {
            this();
            this.tagName = str;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.inputSize = byteBuffer.getInt();
            this.tagName = XtraBox.readAsciiString(byteBuffer, byteBuffer.getInt());
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                XtraValue xtraValue = new XtraValue((XtraValue) null);
                xtraValue.parse(byteBuffer);
                this.values.addElement(xtraValue);
            }
            if (this.inputSize != getContentSize()) {
                throw new RuntimeException("Improperly handled Xtra tag: Sizes don't match ( " + this.inputSize + "/" + getContentSize() + ") on " + this.tagName);
            }
        }

        public void getContent(ByteBuffer byteBuffer) {
            byteBuffer.putInt(getContentSize());
            byteBuffer.putInt(this.tagName.length());
            XtraBox.writeAsciiString(byteBuffer, this.tagName);
            byteBuffer.putInt(this.values.size());
            for (int i = 0; i < this.values.size(); i++) {
                this.values.elementAt(i).getContent(byteBuffer);
            }
        }

        public int getContentSize() {
            int length = this.tagName.length() + 12;
            for (int i = 0; i < this.values.size(); i++) {
                length += this.values.elementAt(i).getContentSize();
            }
            return length;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.tagName);
            stringBuffer.append(" [");
            stringBuffer.append(this.inputSize);
            stringBuffer.append("/");
            stringBuffer.append(this.values.size());
            stringBuffer.append("]:\n");
            for (int i = 0; i < this.values.size(); i++) {
                stringBuffer.append("  ");
                stringBuffer.append(this.values.elementAt(i).toString());
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        }
    }

    static class XtraValue {
        public Date fileTimeValue;
        public long longValue;
        public byte[] nonParsedValue;
        public String stringValue;
        public int type;

        private XtraValue() {
        }

        /* synthetic */ XtraValue(XtraValue xtraValue) {
            this();
        }

        private XtraValue(String str) {
            this.type = 8;
            this.stringValue = str;
        }

        /* synthetic */ XtraValue(String str, XtraValue xtraValue) {
            this(str);
        }

        private XtraValue(long j) {
            this.type = 19;
            this.longValue = j;
        }

        /* synthetic */ XtraValue(long j, XtraValue xtraValue) {
            this(j);
        }

        private XtraValue(Date date) {
            this.type = 21;
            this.fileTimeValue = date;
        }

        /* synthetic */ XtraValue(Date date, XtraValue xtraValue) {
            this(date);
        }

        public Object getValueAsObject() {
            int i = this.type;
            if (i == 8) {
                return this.stringValue;
            }
            if (i == 19) {
                return Long.valueOf(this.longValue);
            }
            if (i != 21) {
                return this.nonParsedValue;
            }
            return this.fileTimeValue;
        }

        public void parse(ByteBuffer byteBuffer) {
            int i = byteBuffer.getInt() - 6;
            this.type = byteBuffer.getShort();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = this.type;
            if (i2 == 8) {
                this.stringValue = XtraBox.readUtf16String(byteBuffer, i);
            } else if (i2 == 19) {
                this.longValue = byteBuffer.getLong();
            } else if (i2 != 21) {
                this.nonParsedValue = new byte[i];
                byteBuffer.get(this.nonParsedValue);
            } else {
                this.fileTimeValue = new Date(XtraBox.filetimeToMillis(byteBuffer.getLong()));
            }
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public void getContent(ByteBuffer byteBuffer) {
            try {
                byteBuffer.putInt(getContentSize());
                byteBuffer.putShort((short) this.type);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int i = this.type;
                if (i == 8) {
                    XtraBox.writeUtf16String(byteBuffer, this.stringValue);
                } else if (i == 19) {
                    byteBuffer.putLong(this.longValue);
                } else if (i != 21) {
                    byteBuffer.put(this.nonParsedValue);
                } else {
                    byteBuffer.putLong(XtraBox.millisToFiletime(this.fileTimeValue.getTime()));
                }
            } finally {
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            }
        }

        public int getContentSize() {
            int length;
            int i = this.type;
            if (i == 8) {
                length = (this.stringValue.length() * 2) + 2;
            } else if (i == 19 || i == 21) {
                return 14;
            } else {
                length = this.nonParsedValue.length;
            }
            return length + 6;
        }

        public String toString() {
            int i = this.type;
            if (i == 8) {
                return "[string]" + this.stringValue;
            } else if (i == 19) {
                return "[long]" + String.valueOf(this.longValue);
            } else if (i != 21) {
                return "[GUID](nonParsed)";
            } else {
                return "[filetime]" + this.fileTimeValue.toString();
            }
        }
    }
}
