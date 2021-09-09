package bsh;

import _m_j.kv;
import _m_j.lf;
import java.io.PrintStream;

public class SimpleNode implements Node {
    public static SimpleNode O00000Oo = new SimpleNode() {
        /* class bsh.SimpleNode.AnonymousClass1 */

        public final String O00000o() {
            return "<Called from Java Code>";
        }

        public final int O00000oO() {
            return -1;
        }

        public final String O00000oo() {
            return "<Compiled Java Code>";
        }
    };
    protected Node[] children;
    Token firstToken;
    protected int id;
    Token lastToken;
    protected Node parent;
    String sourceFile;

    public SimpleNode(int i) {
        this.id = i;
    }

    public final Node O000000o(int i) {
        return this.children[i];
    }

    public Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        StringBuffer stringBuffer = new StringBuffer("Unimplemented or inappropriate for ");
        stringBuffer.append(getClass().getName());
        throw new InterpreterError(stringBuffer.toString());
    }

    public final void O000000o(Node node) {
        this.parent = node;
    }

    public final void O000000o(Node node, int i) {
        Node[] nodeArr = this.children;
        if (nodeArr == null) {
            this.children = new Node[(i + 1)];
        } else if (i >= nodeArr.length) {
            Node[] nodeArr2 = new Node[(i + 1)];
            System.arraycopy(nodeArr, 0, nodeArr2, 0, nodeArr.length);
            this.children = nodeArr2;
        }
        this.children[i] = node;
    }

    public String O00000o() {
        String str = this.sourceFile;
        if (str != null) {
            return str;
        }
        Node node = this.parent;
        return node != null ? ((SimpleNode) node).O00000o() : "<unknown file>";
    }

    public final int O00000o0() {
        Node[] nodeArr = this.children;
        if (nodeArr == null) {
            return 0;
        }
        return nodeArr.length;
    }

    public int O00000oO() {
        return this.firstToken.beginLine;
    }

    public String O00000oo() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Token token = this.firstToken; token != null; token = token.next) {
            stringBuffer.append(token.image);
            if (!token.image.equals(".")) {
                stringBuffer.append(" ");
            }
            if (token == this.lastToken || token.image.equals("{") || token.image.equals(";")) {
                break;
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return lf.O0000OOo[this.id];
    }

    public final void O00000o0(String str) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(toString());
        printStream.println(stringBuffer.toString());
        if (this.children != null) {
            int i = 0;
            while (true) {
                Node[] nodeArr = this.children;
                if (i < nodeArr.length) {
                    SimpleNode simpleNode = (SimpleNode) nodeArr[i];
                    if (simpleNode != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(str);
                        stringBuffer2.append(" ");
                        simpleNode.O00000o0(stringBuffer2.toString());
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
