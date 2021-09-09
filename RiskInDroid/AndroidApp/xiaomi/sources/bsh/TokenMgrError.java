package bsh;

import _m_j.jdn;
import com.google.android.exoplayer2.C;

public class TokenMgrError extends Error {
    int errorCode;

    public TokenMgrError() {
    }

    public TokenMgrError(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public TokenMgrError(boolean z, int i, int i2, int i3, String str, char c, int i4) {
        this(LexicalError(z, i, i2, i3, str, c), i4);
    }

    protected static String LexicalError(boolean z, int i, int i2, int i3, String str, char c) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer("Lexical error at line ");
        stringBuffer.append(i2);
        stringBuffer.append(", column ");
        stringBuffer.append(i3);
        stringBuffer.append(".  Encountered: ");
        if (z) {
            str2 = "<EOF> ";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer(jdn.f1779O000000o);
            stringBuffer2.append(addEscapes(String.valueOf(c)));
            stringBuffer2.append("\" (");
            stringBuffer2.append((int) c);
            stringBuffer2.append("), ");
            str2 = stringBuffer2.toString();
        }
        stringBuffer.append(str2);
        stringBuffer.append("after : \"");
        stringBuffer.append(addEscapes(str));
        stringBuffer.append(jdn.f1779O000000o);
        return stringBuffer.toString();
    }

    protected static final String addEscapes(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != 0) {
                if (charAt == '\"') {
                    str2 = "\\\"";
                } else if (charAt == '\'') {
                    str2 = "\\'";
                } else if (charAt == '\\') {
                    str2 = "\\\\";
                } else if (charAt == 12) {
                    str2 = "\\f";
                } else if (charAt != 13) {
                    switch (charAt) {
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            str2 = "\\b";
                            break;
                        case 9:
                            str2 = "\\t";
                            break;
                        case 10:
                            str2 = "\\n";
                            break;
                        default:
                            char charAt2 = str.charAt(i);
                            if (charAt2 >= ' ' && charAt2 <= '~') {
                                stringBuffer.append(charAt2);
                                break;
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer("0000");
                                stringBuffer2.append(Integer.toString(charAt2, 16));
                                String stringBuffer3 = stringBuffer2.toString();
                                StringBuffer stringBuffer4 = new StringBuffer("\\u");
                                stringBuffer4.append(stringBuffer3.substring(stringBuffer3.length() - 4, stringBuffer3.length()));
                                str2 = stringBuffer4.toString();
                                break;
                            }
                            break;
                    }
                } else {
                    str2 = "\\r";
                }
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    public String getMessage() {
        return super.getMessage();
    }
}
