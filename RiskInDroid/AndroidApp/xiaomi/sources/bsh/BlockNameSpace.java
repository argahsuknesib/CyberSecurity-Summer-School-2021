package bsh;

class BlockNameSpace extends NameSpace {
    private boolean O00000oo(String str) {
        try {
            return super.O000000o(str, false) != null;
        } catch (UtilEvalError unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final This O000000o(Interpreter interpreter) {
        return O00000oo().O000000o(interpreter);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean, boolean):void
     arg types: [java.lang.String, java.lang.Object, int, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class, java.lang.Object, bsh.Modifiers):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean, boolean):void */
    public final void O000000o(String str, Object obj) throws UtilEvalError {
        super.O000000o(str, obj, false, false);
    }

    public final This O00000Oo(Interpreter interpreter) {
        return O00000oo().O00000Oo(interpreter);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public BlockNameSpace(NameSpace nameSpace) throws EvalError {
        super(nameSpace, r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nameSpace.nsName);
        stringBuffer.append("/BlockNameSpace");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean, boolean):void
     arg types: [java.lang.String, java.lang.Object, boolean, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class, java.lang.Object, bsh.Modifiers):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean, boolean):void */
    public final void O000000o(String str, Object obj, boolean z, boolean z2) throws UtilEvalError {
        if (O00000oo(str)) {
            super.O000000o(str, obj, z, false);
        } else {
            this.parent.O000000o(str, obj, z, z2);
        }
    }

    private NameSpace O00000oo() {
        BlockNameSpace blockNameSpace = this;
        while (true) {
            NameSpace nameSpace = blockNameSpace.parent;
            if (!(nameSpace instanceof BlockNameSpace)) {
                return nameSpace;
            }
            blockNameSpace = (BlockNameSpace) nameSpace;
        }
    }

    public final void O000000o(String str) {
        this.parent.O000000o(str);
    }

    public final void O00000Oo(String str) {
        this.parent.O00000Oo(str);
    }

    public final void O000000o(String str, BshMethod bshMethod) throws UtilEvalError {
        this.parent.O000000o(str, bshMethod);
    }
}
