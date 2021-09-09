package org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener {
    private long character;
    private long characterPreviousLine;
    private boolean eof;
    private long index;
    private long line;
    private char previous;
    private final Reader reader;
    private boolean usePrevious;

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    public JSONTokener(Reader reader2) {
        this.reader = !reader2.markSupported() ? new BufferedReader(reader2) : reader2;
        this.eof = false;
        this.usePrevious = false;
        this.previous = 0;
        this.index = 0;
        this.character = 1;
        this.characterPreviousLine = 0;
        this.line = 1;
    }

    public JSONTokener(InputStream inputStream) {
        this(new InputStreamReader(inputStream));
    }

    public JSONTokener(String str) {
        this(new StringReader(str));
    }

    public void back() throws JSONException {
        if (this.usePrevious || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        decrementIndexes();
        this.usePrevious = true;
        this.eof = false;
    }

    private void decrementIndexes() {
        this.index--;
        char c = this.previous;
        if (c == 13 || c == 10) {
            this.line--;
            this.character = this.characterPreviousLine;
            return;
        }
        long j = this.character;
        if (j > 0) {
            this.character = j - 1;
        }
    }

    public boolean end() {
        return this.eof && !this.usePrevious;
    }

    public boolean more() throws JSONException {
        if (this.usePrevious) {
            return true;
        }
        try {
            this.reader.mark(1);
            try {
                if (this.reader.read() <= 0) {
                    this.eof = true;
                    return false;
                }
                this.reader.reset();
                return true;
            } catch (IOException e) {
                throw new JSONException("Unable to read the next character from the stream", e);
            }
        } catch (IOException e2) {
            throw new JSONException("Unable to preserve stream position", e2);
        }
    }

    public char next() throws JSONException {
        int i;
        if (this.usePrevious) {
            this.usePrevious = false;
            i = this.previous;
        } else {
            try {
                i = this.reader.read();
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        if (i <= 0) {
            this.eof = true;
            return 0;
        }
        incrementIndexes(i);
        this.previous = (char) i;
        return this.previous;
    }

    private void incrementIndexes(int i) {
        if (i > 0) {
            this.index++;
            if (i == 13) {
                this.line++;
                this.characterPreviousLine = this.character;
                this.character = 0;
            } else if (i == 10) {
                if (this.previous != 13) {
                    this.line++;
                    this.characterPreviousLine = this.character;
                }
                this.character = 0;
            } else {
                this.character++;
            }
        }
    }

    public char next(char c) throws JSONException {
        char next = next();
        if (next == c) {
            return next;
        }
        if (next > 0) {
            throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
        }
        throw syntaxError("Expected '" + c + "' and instead saw ''");
    }

    public String next(int i) throws JSONException {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        while (i2 < i) {
            cArr[i2] = next();
            if (!end()) {
                i2++;
            } else {
                throw syntaxError("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    public char nextClean() throws JSONException {
        char next;
        do {
            next = next();
            if (next == 0) {
                break;
            }
        } while (next <= ' ');
        return next;
    }

    public String nextString(char c) throws JSONException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char next = next();
            if (next != 0 && next != 10 && next != 13) {
                if (next == '\\') {
                    char next2 = next();
                    if (next2 == '\"' || next2 == '\'' || next2 == '/' || next2 == '\\') {
                        sb.append(next2);
                    } else if (next2 == 'b') {
                        sb.append(8);
                    } else if (next2 == 'f') {
                        sb.append(12);
                    } else if (next2 == 'n') {
                        sb.append(10);
                    } else if (next2 == 'r') {
                        sb.append(13);
                    } else if (next2 == 't') {
                        sb.append(9);
                    } else if (next2 == 'u') {
                        try {
                            sb.append((char) Integer.parseInt(next(4), 16));
                        } catch (NumberFormatException e) {
                            throw syntaxError("Illegal escape.", e);
                        }
                    } else {
                        throw syntaxError("Illegal escape.");
                    }
                } else if (next == c) {
                    return sb.toString();
                } else {
                    sb.append(next);
                }
            }
        }
        throw syntaxError("Unterminated string");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    public String nextTo(char c) throws JSONException {
        char next;
        StringBuilder sb = new StringBuilder();
        while (true) {
            next = next();
            if (next != c && next != 0 && next != 10 && next != 13) {
                sb.append(next);
            } else if (next != 0) {
                back();
            }
        }
        if (next != 0) {
        }
        return sb.toString().trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    public String nextTo(String str) throws JSONException {
        char next;
        StringBuilder sb = new StringBuilder();
        while (true) {
            next = next();
            if (str.indexOf(next) < 0 && next != 0 && next != 10 && next != 13) {
                sb.append(next);
            } else if (next != 0) {
                back();
            }
        }
        if (next != 0) {
        }
        return sb.toString().trim();
    }

    public Object nextValue() throws JSONException {
        char nextClean = nextClean();
        if (nextClean == '\"' || nextClean == '\'') {
            return nextString(nextClean);
        }
        if (nextClean == '[') {
            back();
            return new JSONArray(this);
        } else if (nextClean != '{') {
            StringBuilder sb = new StringBuilder();
            while (nextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(nextClean) < 0) {
                sb.append(nextClean);
                nextClean = next();
            }
            back();
            String trim = sb.toString().trim();
            if (!"".equals(trim)) {
                return JSONObject.stringToValue(trim);
            }
            throw syntaxError("Missing value");
        } else {
            back();
            return new JSONObject(this);
        }
    }

    public char skipTo(char c) throws JSONException {
        char next;
        try {
            long j = this.index;
            long j2 = this.character;
            long j3 = this.line;
            this.reader.mark(1000000);
            do {
                next = next();
                if (next == 0) {
                    this.reader.reset();
                    this.index = j;
                    this.character = j2;
                    this.line = j3;
                    return 0;
                }
            } while (next != c);
            this.reader.mark(1);
            back();
            return next;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public JSONException syntaxError(String str, Throwable th) {
        return new JSONException(str + toString(), th);
    }

    public String toString() {
        return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
    }
}
