package _m_j;

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

final class bvg implements XmlSerializer {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f13307O000000o = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    private final char[] O00000Oo = new char[8192];
    private Writer O00000o;
    private int O00000o0;
    private OutputStream O00000oO;
    private CharsetEncoder O00000oo;
    private ByteBuffer O0000O0o = ByteBuffer.allocate(8192);
    private boolean O0000OOo;

    bvg() {
    }

    private void O000000o() throws IOException {
        int position = this.O0000O0o.position();
        if (position > 0) {
            this.O0000O0o.flip();
            this.O00000oO.write(this.O0000O0o.array(), 0, position);
            this.O0000O0o.clear();
        }
    }

    private void O000000o(char c) throws IOException {
        int i = this.O00000o0;
        if (i >= 8191) {
            flush();
            i = this.O00000o0;
        }
        this.O00000Oo[i] = c;
        this.O00000o0 = i + 1;
    }

    private void O000000o(String str) throws IOException {
        O000000o(str, 0, str.length());
    }

    private void O000000o(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                O000000o(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.O00000o0;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.O00000o0;
        }
        str.getChars(i, i + i2, this.O00000Oo, i5);
        this.O00000o0 = i5 + i2;
    }

    private void O000000o(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                O000000o(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.O00000o0;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.O00000o0;
        }
        System.arraycopy(cArr, i, this.O00000Oo, i5, i2);
        this.O00000o0 = i5 + i2;
    }

    private void O00000Oo(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f13307O000000o;
        char length2 = (char) strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i2 < i) {
                    O000000o(str, i2, i - i2);
                }
                i2 = i + 1;
                O000000o(str2);
            }
            i++;
        }
        if (i2 < i) {
            O000000o(str, i2, i - i2);
        }
    }

    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        O000000o(' ');
        if (str != null) {
            O000000o(str);
            O000000o(':');
        }
        O000000o(str2);
        O000000o("=\"");
        O00000Oo(str3);
        O000000o('\"');
        return this;
    }

    public final void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public final XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        String str3;
        if (this.O0000OOo) {
            str3 = " />\n";
        } else {
            O000000o("</");
            if (str != null) {
                O000000o(str);
                O000000o(':');
            }
            O000000o(str2);
            str3 = ">\n";
        }
        O000000o(str3);
        this.O0000OOo = false;
        return this;
    }

    public final void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void flush() throws IOException {
        int i = this.O00000o0;
        if (i > 0) {
            if (this.O00000oO != null) {
                CharBuffer wrap = CharBuffer.wrap(this.O00000Oo, 0, i);
                CharsetEncoder charsetEncoder = this.O00000oo;
                ByteBuffer byteBuffer = this.O0000O0o;
                while (true) {
                    CoderResult encode = charsetEncoder.encode(wrap, byteBuffer, true);
                    if (!encode.isError()) {
                        if (!encode.isOverflow()) {
                            O000000o();
                            this.O00000oO.flush();
                            break;
                        }
                        O000000o();
                        charsetEncoder = this.O00000oo;
                        byteBuffer = this.O0000O0o;
                    } else {
                        throw new IOException(encode.toString());
                    }
                }
            } else {
                this.O00000o.write(this.O00000Oo, 0, i);
                this.O00000o.flush();
            }
            this.O00000o0 = 0;
        }
    }

    public final int getDepth() {
        throw new UnsupportedOperationException();
    }

    public final boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public final String getName() {
        throw new UnsupportedOperationException();
    }

    public final String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public final String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public final Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public final void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    public final void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.O00000oo = Charset.forName(str).newEncoder();
                this.O00000oO = outputStream;
            } catch (IllegalCharsetNameException e) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
            } catch (UnsupportedCharsetException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.O00000o = writer;
    }

    public final void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        O000000o(sb.toString());
    }

    public final XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.O0000OOo) {
            O000000o(">\n");
        }
        O000000o('<');
        if (str != null) {
            O000000o(str);
            O000000o(':');
        }
        O000000o(str2);
        this.O0000OOo = true;
        return this;
    }

    public final XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.O0000OOo) {
            O000000o(">");
            this.O0000OOo = false;
        }
        O00000Oo(str);
        return this;
    }

    public final XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        String str;
        if (this.O0000OOo) {
            O000000o(">");
            this.O0000OOo = false;
        }
        String[] strArr = f13307O000000o;
        char length = (char) strArr.length;
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length && (str = strArr[c]) != null) {
                if (i4 < i) {
                    O000000o(cArr, i4, i - i4);
                }
                i4 = i + 1;
                O000000o(str);
            }
            i++;
        }
        if (i4 < i) {
            O000000o(cArr, i4, i - i4);
        }
        return this;
    }
}
