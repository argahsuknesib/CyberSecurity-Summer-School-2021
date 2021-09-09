package org.json;

public class HTTPTokener extends JSONTokener {
    public HTTPTokener(String str) {
        super(str);
    }

    public String nextToken() throws JSONException {
        char next;
        StringBuilder sb = new StringBuilder();
        do {
            next = next();
        } while (Character.isWhitespace(next));
        if (next == '\"' || next == '\'') {
            while (true) {
                char next2 = next();
                if (next2 < ' ') {
                    throw syntaxError("Unterminated string.");
                } else if (next2 == next) {
                    return sb.toString();
                } else {
                    sb.append(next2);
                }
            }
        } else {
            while (next != 0 && !Character.isWhitespace(next)) {
                sb.append(next);
                next = next();
            }
            return sb.toString();
        }
    }
}
