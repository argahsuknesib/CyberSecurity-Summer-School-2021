package bsh;

import _m_j.kv;

class BSHLiteral extends SimpleNode {
    public Object value;

    BSHLiteral() {
        super(21);
    }

    private static char O000000o(char c) {
        if (c == 'b') {
            return 8;
        }
        if (c == 'f') {
            return 12;
        }
        if (c == 'n') {
            return 10;
        }
        if (c == 'r') {
            return 13;
        }
        if (c != 't') {
            return c;
        }
        return 9;
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        Object obj = this.value;
        if (obj != null) {
            return obj;
        }
        StringBuffer stringBuffer = new StringBuffer("Null in bsh literal: ");
        stringBuffer.append(this.value);
        throw new InterpreterError(stringBuffer.toString());
    }

    public final void O000000o(String str) {
        char charAt = str.charAt(0);
        if (charAt == '\\') {
            char charAt2 = str.charAt(1);
            charAt = Character.isDigit(charAt2) ? (char) Integer.parseInt(str.substring(1), 8) : O000000o(charAt2);
        }
        this.value = new Primitive(charAt);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i++;
                char charAt2 = str.charAt(i);
                if (Character.isDigit(charAt2)) {
                    int i2 = i;
                    while (i2 < i + 2) {
                        int i3 = i2 + 1;
                        if (!Character.isDigit(str.charAt(i3))) {
                            break;
                        }
                        i2 = i3;
                    }
                    int i4 = i2;
                    charAt = (char) Integer.parseInt(str.substring(i, i2 + 1), 8);
                    i = i4;
                } else {
                    charAt = O000000o(charAt2);
                }
            }
            stringBuffer.append(charAt);
            i++;
        }
        this.value = stringBuffer.toString().intern();
    }
}
