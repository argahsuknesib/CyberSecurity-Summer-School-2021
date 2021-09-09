package bsh;

import _m_j.kv;
import _m_j.ld;
import _m_j.li;

class BSHForStatement extends SimpleNode implements ld {
    private SimpleNode expression;
    private SimpleNode forInit;
    private SimpleNode forUpdate;
    public boolean hasExpression;
    public boolean hasForInit;
    public boolean hasForUpdate;
    private boolean parsed;
    private SimpleNode statement;

    BSHForStatement() {
        super(31);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: bsh.Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: _m_j.li} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: bsh.Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: bsh.Primitive} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091 A[SYNTHETIC] */
    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        int i;
        Primitive primitive;
        boolean z;
        if (this.hasForInit) {
            this.forInit = (SimpleNode) O000000o(0);
            i = 1;
        } else {
            i = 0;
        }
        if (this.hasExpression) {
            this.expression = (SimpleNode) O000000o(i);
            i++;
        }
        if (this.hasForUpdate) {
            this.forUpdate = (SimpleNode) O000000o(i);
            i++;
        }
        if (i < O00000o0()) {
            this.statement = (SimpleNode) O000000o(i);
        }
        NameSpace O000000o2 = kvVar.O000000o(0);
        kvVar.O00000Oo(new BlockNameSpace(O000000o2));
        if (this.hasForInit) {
            this.forInit.O000000o(kvVar, interpreter);
        }
        Primitive primitive2 = Primitive.O00000o0;
        while (true) {
            if (this.hasExpression && !BSHIfStatement.O000000o(this.expression, kvVar, interpreter)) {
                break;
            }
            SimpleNode simpleNode = this.statement;
            if (simpleNode != null) {
                Object O000000o3 = simpleNode.O000000o(kvVar, interpreter);
                if (O000000o3 instanceof li) {
                    int i2 = O000000o3.f2166O000000o;
                    if (i2 != 12) {
                        if (i2 != 19 && i2 == 46) {
                            primitive2 = O000000o3;
                        }
                    }
                    primitive = primitive2;
                    z = true;
                    if (!z) {
                        primitive2 = primitive;
                        break;
                    }
                    if (this.hasForUpdate) {
                        this.forUpdate.O000000o(kvVar, interpreter);
                    }
                    primitive2 = primitive;
                }
            }
            primitive = primitive2;
            z = false;
            if (!z) {
            }
        }
        kvVar.O00000Oo(O000000o2);
        return primitive2;
    }
}
