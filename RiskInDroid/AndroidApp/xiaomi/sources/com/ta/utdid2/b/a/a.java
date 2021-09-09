package com.ta.utdid2.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

class a implements XmlSerializer {

    /* renamed from: a  reason: collision with root package name */
    private static String f5801a = "xmlpull.org/v1/doc/features.html#indent-output";

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f5a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f6a;

    /* renamed from: a  reason: collision with other field name */
    private Writer f7a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f8a = ByteBuffer.allocate(8192);

    /* renamed from: a  reason: collision with other field name */
    private CharsetEncoder f9a;

    /* renamed from: a  reason: collision with other field name */
    private final char[] f10a = new char[8192];
    private boolean e;
    private int mPos;

    a() {
    }

    private void append(char c) throws IOException {
        int i = this.mPos;
        if (i >= 8191) {
            flush();
            i = this.mPos;
        }
        this.f10a[i] = c;
        this.mPos = i + 1;
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.mPos;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.mPos;
        }
        str.getChars(i, i + i2, this.f10a, i5);
        this.mPos = i5 + i2;
    }

    private void append(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                append(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.mPos;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.mPos;
        }
        System.arraycopy(cArr, i, this.f10a, i5, i2);
        this.mPos = i5 + i2;
    }

    private void append(String str) throws IOException {
        a(str, 0, str.length());
    }

    private void a(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f5a;
        char length2 = (char) strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i2 < i) {
                    a(str, i2, i - i2);
                }
                i2 = i + 1;
                append(str2);
            }
            i++;
        }
        if (i2 < i) {
            a(str, i2, i - i2);
        }
    }

    private void a(char[] cArr, int i, int i2) throws IOException {
        String str;
        String[] strArr = f5a;
        char length = (char) strArr.length;
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length && (str = strArr[c]) != null) {
                if (i4 < i) {
                    append(cArr, i4, i - i4);
                }
                i4 = i + 1;
                append(str);
            }
            i++;
        }
        if (i4 < i) {
            append(cArr, i4, i - i4);
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        append(' ');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        append("=\"");
        a(str3);
        append('\"');
        return this;
    }

    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.e) {
            append(" />\n");
        } else {
            append("</");
            if (str != null) {
                append(str);
                append(':');
            }
            append(str2);
            append(">\n");
        }
        this.e = false;
        return this;
    }

    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    private void a() throws IOException {
        int position = this.f8a.position();
        if (position > 0) {
            this.f8a.flip();
            this.f6a.write(this.f8a.array(), 0, position);
            this.f8a.clear();
        }
    }

    public void flush() throws IOException {
        int i = this.mPos;
        if (i > 0) {
            if (this.f6a != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f10a, 0, i);
                CoderResult encode = this.f9a.encode(wrap, this.f8a, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        a();
                        encode = this.f9a.encode(wrap, this.f8a, true);
                    } else {
                        a();
                        this.f6a.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f7a.write(this.f10a, 0, i);
            this.f7a.flush();
            this.mPos = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    static String d() {
        return "http://" + f5801a;
    }

    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals(d())) {
            throw new UnsupportedOperationException();
        }
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f9a = Charset.forName(str).newEncoder();
                this.f6a = outputStream;
            } catch (IllegalCharsetNameException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            } catch (UnsupportedCharsetException e3) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e3));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f7a = writer;
    }

    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        append(sb.toString());
    }

    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.e) {
            append(">\n");
        }
        append('<');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        this.e = true;
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.e) {
            append(">");
            this.e = false;
        }
        a(cArr, i, i2);
        return this;
    }

    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.e) {
            append(">");
            this.e = false;
        }
        a(str);
        return this;
    }
}
