package bsh;

import java.io.Serializable;
import java.util.Hashtable;

public class Modifiers implements Serializable {
    Hashtable modifiers;

    private void O000000o() {
        O000000o("volatile", "Method");
        O000000o("transient", "Method");
    }

    private void O000000o(String str, String str2) {
        if (O000000o(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(" cannot be declared '");
            stringBuffer.append(str);
            stringBuffer.append("'");
            throw new IllegalStateException(stringBuffer.toString());
        }
    }

    private void O00000Oo() {
        O000000o("synchronized", "Variable");
        O000000o("native", "Variable");
        O000000o("abstract", "Variable");
    }

    private void O00000o0() {
        O000000o();
        O000000o("native", "Class");
        O000000o("synchronized", "Class");
    }

    public final void O000000o(int i, String str) {
        if (this.modifiers == null) {
            this.modifiers = new Hashtable();
        }
        if (this.modifiers.put(str, Void.TYPE) == null) {
            int i2 = 0;
            if (O000000o("private")) {
                i2 = 1;
            }
            if (O000000o("protected")) {
                i2++;
            }
            if (O000000o("public")) {
                i2++;
            }
            if (i2 > 1) {
                throw new IllegalStateException("public/private/protected cannot be used in combination.");
            } else if (i == 0) {
                O00000o0();
            } else if (i == 1) {
                O000000o();
            } else if (i == 2) {
                O00000Oo();
            }
        } else {
            throw new IllegalStateException("Duplicate modifier: ".concat(String.valueOf(str)));
        }
    }

    public final boolean O000000o(String str) {
        if (this.modifiers == null) {
            this.modifiers = new Hashtable();
        }
        return this.modifiers.get(str) != null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Modifiers: ");
        stringBuffer.append(this.modifiers);
        return stringBuffer.toString();
    }
}
