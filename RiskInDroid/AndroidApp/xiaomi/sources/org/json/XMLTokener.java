package org.json;

import java.util.HashMap;

public class XMLTokener extends JSONTokener {
    public static final HashMap<String, Character> entity;

    static {
        HashMap<String, Character> hashMap = new HashMap<>(8);
        entity = hashMap;
        hashMap.put("amp", XML.AMP);
        entity.put("apos", XML.APOS);
        entity.put("gt", XML.GT);
        entity.put("lt", XML.LT);
        entity.put("quot", XML.QUOT);
    }

    public XMLTokener(String str) {
        super(str);
    }

    public String nextCDATA() throws JSONException {
        StringBuilder sb = new StringBuilder();
        while (more()) {
            sb.append(next());
            int length = sb.length() - 3;
            if (length >= 0 && sb.charAt(length) == ']' && sb.charAt(length + 1) == ']' && sb.charAt(length + 2) == '>') {
                sb.setLength(length);
                return sb.toString();
            }
        }
        throw syntaxError("Unclosed CDATA");
    }

    public Object nextContent() throws JSONException {
        char next;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        if (next == 0) {
            return null;
        }
        if (next == '<') {
            return XML.LT;
        }
        StringBuilder sb = new StringBuilder();
        while (next != 0) {
            if (next == '<') {
                back();
                return sb.toString().trim();
            }
            if (next == '&') {
                sb.append(nextEntity(next));
            } else {
                sb.append(next);
            }
            next = next();
        }
        return sb.toString().trim();
    }

    public Object nextEntity(char c) throws JSONException {
        char next;
        StringBuilder sb = new StringBuilder();
        while (true) {
            next = next();
            if (!Character.isLetterOrDigit(next) && next != '#') {
                break;
            }
            sb.append(Character.toLowerCase(next));
        }
        if (next == ';') {
            return unescapeEntity(sb.toString());
        }
        throw syntaxError("Missing ';' in XML entity: &".concat(String.valueOf(sb)));
    }

    static String unescapeEntity(String str) {
        int i;
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.charAt(0) == '#') {
            if (str.charAt(1) == 'x') {
                i = Integer.parseInt(str.substring(2), 16);
            } else {
                i = Integer.parseInt(str.substring(1));
            }
            return new String(new int[]{i}, 0, 1);
        }
        Character ch = entity.get(str);
        if (ch != null) {
            return ch.toString();
        }
        return "&" + str + ';';
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[LOOP_START] */
    public Object nextMeta() throws JSONException {
        char next;
        char next2;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        if (next != 0) {
            if (next != '\'') {
                if (next == '/') {
                    return XML.SLASH;
                }
                if (next == '!') {
                    return XML.BANG;
                }
                if (next != '\"') {
                    switch (next) {
                        case '<':
                            return XML.LT;
                        case '=':
                            return XML.EQ;
                        case '>':
                            return XML.GT;
                        case '?':
                            return XML.QUEST;
                    }
                    while (true) {
                        char next3 = next();
                        if (Character.isWhitespace(next3)) {
                            return Boolean.TRUE;
                        }
                        if (next3 == 0 || next3 == '\'' || next3 == '/' || next3 == '!' || next3 == '\"') {
                            back();
                        } else {
                            switch (next3) {
                            }
                        }
                    }
                    back();
                    return Boolean.TRUE;
                }
            }
            do {
                next2 = next();
                if (next2 == 0) {
                    throw syntaxError("Unterminated string");
                }
            } while (next2 != next);
            return Boolean.TRUE;
        }
        throw syntaxError("Misshaped meta tag");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
        throw syntaxError("Bad character in a name");
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[LOOP_START, PHI: r0 10  PHI: (r0v13 char) = (r0v0 char), (r0v14 char) binds: [B:12:0x001f, B:26:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    public Object nextToken() throws JSONException {
        char next;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        if (next != 0) {
            if (next != '\'') {
                if (next == '/') {
                    return XML.SLASH;
                }
                if (next == '!') {
                    return XML.BANG;
                }
                if (next != '\"') {
                    switch (next) {
                        case '<':
                            throw syntaxError("Misplaced '<'");
                        case '=':
                            return XML.EQ;
                        case '>':
                            return XML.GT;
                        case '?':
                            return XML.QUEST;
                        default:
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                sb.append(next);
                                next = next();
                                if (Character.isWhitespace(next)) {
                                    return sb.toString();
                                }
                                if (next != 0) {
                                    if (next != '\'') {
                                        if (next != '/' && next != '[' && next != ']' && next != '!') {
                                            if (next == '\"') {
                                                break;
                                            } else {
                                                switch (next) {
                                                }
                                            }
                                        } else {
                                            back();
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    return sb.toString();
                                }
                            }
                            back();
                            return sb.toString();
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                char next2 = next();
                if (next2 == 0) {
                    throw syntaxError("Unterminated string");
                } else if (next2 == next) {
                    return sb2.toString();
                } else {
                    if (next2 == '&') {
                        sb2.append(nextEntity(next2));
                    } else {
                        sb2.append(next2);
                    }
                }
            }
        } else {
            throw syntaxError("Misshaped element");
        }
    }

    public void skipPast(String str) {
        boolean z;
        char next;
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        while (i < length) {
            char next2 = next();
            if (next2 != 0) {
                cArr[i] = next2;
                i++;
            } else {
                return;
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z = true;
                    break;
                } else if (cArr[i3] != str.charAt(i4)) {
                    z = false;
                    break;
                } else {
                    i3++;
                    if (i3 >= length) {
                        i3 -= length;
                    }
                    i4++;
                }
            }
            if (!z && (next = next()) != 0) {
                cArr[i2] = next;
                i2++;
                if (i2 >= length) {
                    i2 -= length;
                }
            } else {
                return;
            }
        }
    }
}
