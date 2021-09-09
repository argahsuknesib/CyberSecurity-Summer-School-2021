package bsh;

import _m_j.kv;

class BSHImportDeclaration extends SimpleNode {
    public boolean importPackage;
    public boolean staticImport;
    public boolean superImport;

    BSHImportDeclaration() {
        super(4);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        NameSpace O000000o2 = kvVar.O000000o(0);
        if (this.superImport) {
            try {
                O000000o2.O00000oO();
            } catch (UtilEvalError e) {
                throw e.toEvalError(this, kvVar);
            }
        } else if (!this.staticImport) {
            String str = ((BSHAmbiguousName) O000000o(0)).text;
            if (this.importPackage) {
                O000000o2.O00000Oo(str);
            } else {
                O000000o2.O000000o(str);
            }
        } else if (this.importPackage) {
            O000000o2.O000000o(((BSHAmbiguousName) O000000o(0)).O000000o(kvVar));
        } else {
            throw new EvalError("static field imports not supported yet", this, kvVar);
        }
        return Primitive.O00000o0;
    }
}
