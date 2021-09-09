package bsh;

import java.io.Serializable;

public class Token implements Serializable {
    public int beginColumn;
    public int beginLine;
    public int endColumn;
    public int endLine;
    public String image;
    public int kind;
    public Token next;
    public Token specialToken;

    public static final Token O000000o() {
        return new Token();
    }

    public String toString() {
        return this.image;
    }
}
