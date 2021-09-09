package bsh;

import _m_j.kv;

public class EvalError extends Exception {
    kv callstack;
    String message;
    SimpleNode node;

    public EvalError(String str, SimpleNode simpleNode, kv kvVar) {
        setMessage(str);
        this.node = simpleNode;
        if (kvVar != null) {
            this.callstack = kvVar.O00000Oo();
        }
    }

    public int getErrorLineNumber() {
        SimpleNode simpleNode = this.node;
        if (simpleNode != null) {
            return simpleNode.O00000oO();
        }
        return -1;
    }

    public String getErrorSourceFile() {
        SimpleNode simpleNode = this.node;
        return simpleNode != null ? simpleNode.O00000o() : "<unknown file>";
    }

    public String getErrorText() {
        SimpleNode simpleNode = this.node;
        return simpleNode != null ? simpleNode.O00000oo() : "<unknown error>";
    }

    public String getMessage() {
        return this.message;
    }

    /* access modifiers changed from: protected */
    public void prependMessage(String str) {
        if (str != null) {
            if (this.message == null) {
                this.message = str;
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" : ");
            stringBuffer.append(this.message);
            this.message = stringBuffer.toString();
        }
    }

    public void reThrow(String str) throws EvalError {
        prependMessage(str);
        throw this;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        String str;
        if (this.node != null) {
            StringBuffer stringBuffer = new StringBuffer(" : at Line: ");
            stringBuffer.append(this.node.O00000oO());
            stringBuffer.append(" : in file: ");
            stringBuffer.append(this.node.O00000o());
            stringBuffer.append(" : ");
            stringBuffer.append(this.node.O00000oo());
            str = stringBuffer.toString();
        } else {
            str = ": <at unknown location>";
        }
        if (this.callstack != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append("\n");
            stringBuffer2.append(getScriptStackTrace());
            str = stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(getMessage());
        stringBuffer3.append(str);
        return stringBuffer3.toString();
    }

    public String getScriptStackTrace() {
        SimpleNode simpleNode;
        kv kvVar = this.callstack;
        if (kvVar == null) {
            return "<Unknown>";
        }
        kv O00000Oo = kvVar.O00000Oo();
        String str = "";
        while (O00000Oo.f2156O000000o.size() > 0) {
            NameSpace O000000o2 = O00000Oo.O000000o();
            NameSpace nameSpace = O000000o2;
            while (true) {
                if (nameSpace.callerInfoNode == null) {
                    if (nameSpace.parent == null) {
                        simpleNode = null;
                        break;
                    }
                    nameSpace = nameSpace.parent;
                } else {
                    simpleNode = nameSpace.callerInfoNode;
                    break;
                }
            }
            if (O000000o2.isMethod) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("\nCalled from method: ");
                stringBuffer.append(O000000o2.nsName);
                str = stringBuffer.toString();
                if (simpleNode != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append(" : at Line: ");
                    stringBuffer2.append(simpleNode.O00000oO());
                    stringBuffer2.append(" : in file: ");
                    stringBuffer2.append(simpleNode.O00000o());
                    stringBuffer2.append(" : ");
                    stringBuffer2.append(simpleNode.O00000oo());
                    str = stringBuffer2.toString();
                }
            }
        }
        return str;
    }
}
