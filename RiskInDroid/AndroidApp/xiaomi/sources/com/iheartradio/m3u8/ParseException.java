package com.iheartradio.m3u8;

public class ParseException extends Exception {
    private static final long serialVersionUID = -2217152001086567983L;
    public String mInput;
    private final String mMessageSuffix;
    public final ParseExceptionType type;

    public static ParseException O000000o(ParseExceptionType parseExceptionType, String str) {
        return O000000o(parseExceptionType, str, null);
    }

    public static ParseException O000000o(ParseExceptionType parseExceptionType, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (str2 != null) {
            if (sb.length() > 0) {
                sb.append(" - ");
            }
            sb.append(str2);
        }
        if (sb.length() > 0) {
            return new ParseException(parseExceptionType, sb.toString());
        }
        return new ParseException(parseExceptionType);
    }

    public ParseException(ParseExceptionType parseExceptionType) {
        this(parseExceptionType, null);
    }

    public ParseException(ParseExceptionType parseExceptionType, String str) {
        this.type = parseExceptionType;
        this.mMessageSuffix = str;
    }

    public String getInput() {
        return this.mInput;
    }

    public String getMessage() {
        if (this.mMessageSuffix == null) {
            return this.type.message;
        }
        return this.type.message + ": " + this.mMessageSuffix;
    }
}
