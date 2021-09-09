package com.google.zxing.client.result;

public final class EmailAddressParsedResult extends ParsedResult {
    private final String[] bccs;
    private final String body;
    private final String[] ccs;
    private final String subject;
    private final String[] tos;

    @Deprecated
    public final String getMailtoURI() {
        return "mailto:";
    }

    EmailAddressParsedResult(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    EmailAddressParsedResult(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.tos = strArr;
        this.ccs = strArr2;
        this.bccs = strArr3;
        this.subject = str;
        this.body = str2;
    }

    @Deprecated
    public final String getEmailAddress() {
        String[] strArr = this.tos;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    public final String[] getTos() {
        return this.tos;
    }

    public final String[] getCCs() {
        return this.ccs;
    }

    public final String[] getBCCs() {
        return this.bccs;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getDisplayResult() {
        StringBuilder sb = new StringBuilder(30);
        maybeAppend(this.tos, sb);
        maybeAppend(this.ccs, sb);
        maybeAppend(this.bccs, sb);
        maybeAppend(this.subject, sb);
        maybeAppend(this.body, sb);
        return sb.toString();
    }
}
