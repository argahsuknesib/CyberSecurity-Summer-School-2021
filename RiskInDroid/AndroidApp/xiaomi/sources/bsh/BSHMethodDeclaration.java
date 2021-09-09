package bsh;

import _m_j.kv;

class BSHMethodDeclaration extends SimpleNode {
    BSHBlock blockNode;
    int firstThrowsClause;
    public Modifiers modifiers;
    public String name;
    int numThrows = 0;
    BSHFormalParameters paramsNode;
    Class returnType;
    BSHReturnType returnTypeNode;

    BSHMethodDeclaration() {
        super(2);
    }

    private synchronized void O000000o() {
        if (this.paramsNode == null) {
            Node O000000o2 = O000000o(0);
            this.firstThrowsClause = 1;
            if (O000000o2 instanceof BSHReturnType) {
                this.returnTypeNode = (BSHReturnType) O000000o2;
                this.paramsNode = (BSHFormalParameters) O000000o(1);
                if (O00000o0() > this.numThrows + 2) {
                    this.blockNode = (BSHBlock) O000000o(this.numThrows + 2);
                }
                this.firstThrowsClause++;
                return;
            }
            this.paramsNode = (BSHFormalParameters) O000000o(0);
            this.blockNode = (BSHBlock) O000000o(this.numThrows + 1);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MethodDeclaration: ");
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        Class cls;
        O000000o();
        BSHReturnType bSHReturnType = this.returnTypeNode;
        if (bSHReturnType == null) {
            cls = null;
        } else if (bSHReturnType.isVoid) {
            cls = Void.TYPE;
        } else {
            cls = ((BSHType) bSHReturnType.O000000o(0)).O00000Oo(kvVar, interpreter);
        }
        this.returnType = cls;
        O000000o();
        for (int i = this.firstThrowsClause; i < this.numThrows + this.firstThrowsClause; i++) {
            ((BSHAmbiguousName) O000000o(i)).O000000o(kvVar);
        }
        this.paramsNode.O000000o(kvVar, interpreter);
        if (interpreter.strictJava) {
            int i2 = 0;
            while (i2 < this.paramsNode.paramTypes.length) {
                if (this.paramsNode.paramTypes[i2] != null) {
                    i2++;
                } else {
                    StringBuffer stringBuffer = new StringBuffer("(Strict Java Mode) Undeclared argument type, parameter: ");
                    stringBuffer.append(this.paramsNode.O000000o()[i2]);
                    stringBuffer.append(" in method: ");
                    stringBuffer.append(this.name);
                    throw new EvalError(stringBuffer.toString(), this, null);
                }
            }
            if (this.returnType == null) {
                StringBuffer stringBuffer2 = new StringBuffer("(Strict Java Mode) Undeclared return type for method: ");
                stringBuffer2.append(this.name);
                throw new EvalError(stringBuffer2.toString(), this, null);
            }
        }
        NameSpace O000000o2 = kvVar.O000000o(0);
        try {
            O000000o2.O000000o(this.name, new BshMethod(this, O000000o2, this.modifiers));
            return Primitive.O00000o0;
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }
}
