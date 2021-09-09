package bsh;

import _m_j.kv;

class BSHTypedVariableDeclaration extends SimpleNode {
    public Modifiers modifiers;

    BSHTypedVariableDeclaration() {
        super(33);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        try {
            NameSpace O000000o2 = kvVar.O000000o(0);
            BSHType bSHType = (BSHType) O000000o(0);
            Class O00000Oo = bSHType.O00000Oo(kvVar, interpreter);
            int O00000o0 = O00000o0();
            BSHVariableDeclarator[] bSHVariableDeclaratorArr = new BSHVariableDeclarator[(O00000o0 - 1)];
            for (int i = 1; i < O00000o0; i++) {
                bSHVariableDeclaratorArr[i - 1] = (BSHVariableDeclarator) O000000o(i);
            }
            int i2 = 0;
            while (i2 < bSHVariableDeclaratorArr.length) {
                BSHVariableDeclarator bSHVariableDeclarator = bSHVariableDeclaratorArr[i2];
                Object obj = null;
                if (bSHVariableDeclarator.O00000o0() > 0) {
                    SimpleNode simpleNode = (SimpleNode) bSHVariableDeclarator.O000000o(0);
                    obj = (bSHType == null || !(simpleNode instanceof BSHArrayInitializer)) ? simpleNode.O000000o(kvVar, interpreter) : ((BSHArrayInitializer) simpleNode).O000000o(bSHType.baseType, bSHType.arrayDims, kvVar, interpreter);
                }
                if (obj != Primitive.O00000o0) {
                    O000000o2.O000000o(bSHVariableDeclarator.name, O00000Oo, obj, this.modifiers);
                    i2++;
                } else {
                    throw new EvalError("Void initializer.", bSHVariableDeclarator, kvVar);
                }
            }
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        } catch (EvalError e2) {
            e2.reThrow("Typed variable declaration");
        }
        return Primitive.O00000o0;
    }
}
