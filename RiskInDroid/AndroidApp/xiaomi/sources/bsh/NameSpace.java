package bsh;

import _m_j.kt;
import _m_j.lg;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class NameSpace implements Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final NameSpace f3064O000000o;
    private transient kt O00000Oo;
    private transient Hashtable O00000o0;
    SimpleNode callerInfoNode;
    Object classInstance;
    Class classStatic;
    protected Hashtable importedClasses;
    private Vector importedCommands;
    private Vector importedObjects;
    private Vector importedPackages;
    private Vector importedStatic;
    boolean isClass;
    boolean isMethod;
    private Hashtable methods;
    Vector nameSourceListeners;
    private Hashtable names;
    String nsName;
    String packageName;
    NameSpace parent;
    private This thisReference;
    private Hashtable variables;

    static {
        NameSpace nameSpace = new NameSpace((kt) null, "Called from compiled Java code.");
        f3064O000000o = nameSpace;
        nameSpace.isMethod = true;
    }

    public NameSpace(kt ktVar, String str) {
        this(null, ktVar, str);
    }

    public NameSpace(NameSpace nameSpace, String str) {
        this(nameSpace, null, str);
    }

    private BshMethod O000000o(InputStream inputStream, String str, Class[] clsArr, String str2, Interpreter interpreter) throws UtilEvalError {
        try {
            interpreter.O000000o(new InputStreamReader(inputStream), this, str2);
            return O000000o(str, clsArr);
        } catch (EvalError e) {
            Interpreter.O00000Oo(e.toString());
            StringBuffer stringBuffer = new StringBuffer("Error loading script: ");
            stringBuffer.append(e.getMessage());
            throw new UtilEvalError(stringBuffer.toString());
        }
    }

    private static Object O000000o(Variable variable) throws UtilEvalError {
        return variable == null ? Primitive.O00000o0 : variable.O000000o();
    }

    private void O000000o(String str, Class cls) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new Hashtable();
        }
        this.O00000o0.put(str, cls);
    }

    private static String[] O000000o(Enumeration enumeration) {
        Vector vector = new Vector();
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.String, java.lang.Class[], boolean):java.lang.reflect.Method
     arg types: [_m_j.kt, java.lang.Class<?>, java.lang.String, java.lang.Class[], int]
     candidates:
      _m_j.lg.O000000o(java.lang.Class, java.lang.String, int, boolean, java.util.Vector):java.util.Vector
      _m_j.lg.O000000o(java.lang.reflect.Method[], java.lang.String, int, boolean, java.util.Vector):java.util.Vector
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.String, java.lang.Class[], boolean):java.lang.reflect.Method */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.String, java.lang.Class[], boolean):java.lang.reflect.Method
     arg types: [_m_j.kt, java.lang.Class, java.lang.String, java.lang.Class[], int]
     candidates:
      _m_j.lg.O000000o(java.lang.Class, java.lang.String, int, boolean, java.util.Vector):java.util.Vector
      _m_j.lg.O000000o(java.lang.reflect.Method[], java.lang.String, int, boolean, java.util.Vector):java.util.Vector
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.String, java.lang.Class[], boolean):java.lang.reflect.Method */
    private BshMethod O00000Oo(String str, Class[] clsArr) throws UtilEvalError {
        if (this.importedObjects != null) {
            for (int i = 0; i < this.importedObjects.size(); i++) {
                Object elementAt = this.importedObjects.elementAt(i);
                Method O000000o2 = lg.O000000o(O00000o(), (Class) elementAt.getClass(), str, clsArr, false);
                if (O000000o2 != null) {
                    return new BshMethod(O000000o2, elementAt);
                }
            }
        }
        if (this.importedStatic != null) {
            for (int i2 = 0; i2 < this.importedStatic.size(); i2++) {
                Method O000000o3 = lg.O000000o(O00000o(), (Class) this.importedStatic.elementAt(i2), str, clsArr, true);
                if (O000000o3 != null) {
                    return new BshMethod(O000000o3, null);
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, boolean):bsh.Variable
     arg types: [java.lang.String, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[]):bsh.BshMethod
      bsh.NameSpace.O000000o(java.lang.String, bsh.BshMethod):void
      bsh.NameSpace.O000000o(java.lang.String, boolean):bsh.Variable */
    private Object O00000oo(String str) throws UtilEvalError {
        return O000000o(O000000o(str, true));
    }

    private void O00000oo() {
        this.O00000o0 = null;
        this.names = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(java.lang.Class, java.lang.String, boolean):java.lang.reflect.Field
     arg types: [java.lang.Class<?>, java.lang.String, int]
     candidates:
      _m_j.lg.O000000o(java.lang.reflect.Method, java.lang.Object, java.lang.Object[]):java.lang.Object
      _m_j.lg.O000000o(java.lang.String, java.lang.reflect.Method, java.lang.Object[]):void
      _m_j.lg.O000000o(java.lang.Class, java.lang.String, boolean):java.lang.reflect.Field */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(java.lang.Class, java.lang.String, boolean):java.lang.reflect.Field
     arg types: [java.lang.Class, java.lang.String, int]
     candidates:
      _m_j.lg.O000000o(java.lang.reflect.Method, java.lang.Object, java.lang.Object[]):java.lang.Object
      _m_j.lg.O000000o(java.lang.String, java.lang.reflect.Method, java.lang.Object[]):void
      _m_j.lg.O000000o(java.lang.Class, java.lang.String, boolean):java.lang.reflect.Field */
    private Variable O0000O0o(String str) throws UtilEvalError {
        if (this.importedObjects != null) {
            for (int i = 0; i < this.importedObjects.size(); i++) {
                Object elementAt = this.importedObjects.elementAt(i);
                Field O000000o2 = lg.O000000o((Class) elementAt.getClass(), str, false);
                if (O000000o2 != null) {
                    return new Variable(str, O000000o2.getType(), new LHS(elementAt, O000000o2));
                }
            }
        }
        if (this.importedStatic == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.importedStatic.size(); i2++) {
            Field O000000o3 = lg.O000000o((Class) this.importedStatic.elementAt(i2), str, true);
            if (O000000o3 != null) {
                return new Variable(str, O000000o3.getType(), new LHS(O000000o3));
            }
        }
        return null;
    }

    private Class O0000OOo(String str) throws UtilEvalError {
        Class cls;
        Hashtable hashtable = this.O00000o0;
        if (hashtable != null) {
            cls = (Class) hashtable.get(str);
            if (cls != null) {
                return cls;
            }
        } else {
            cls = null;
        }
        boolean z = !Name.O000000o(str);
        if (z) {
            if (cls == null) {
                cls = O0000Oo0(str);
            }
            if (cls != null) {
                O000000o(str, cls);
                return cls;
            }
        }
        Class O0000Oo = O0000Oo(str);
        if (O0000Oo != null) {
            if (z) {
                O000000o(str, O0000Oo);
            }
            return O0000Oo;
        }
        if (Interpreter.f3062O000000o) {
            StringBuffer stringBuffer = new StringBuffer("getClass(): ");
            stringBuffer.append(str);
            stringBuffer.append(" not\tfound in ");
            stringBuffer.append(this);
            Interpreter.O00000Oo(stringBuffer.toString());
        }
        return null;
    }

    private Class O0000Oo(String str) {
        return O00000o().O000000o(str);
    }

    private Class O0000Oo0(String str) throws UtilEvalError {
        Hashtable hashtable = this.importedClasses;
        String str2 = hashtable != null ? (String) hashtable.get(str) : null;
        if (str2 != null) {
            Class O0000Oo = O0000Oo(str2);
            if (O0000Oo != null) {
                return O0000Oo;
            }
            if (Name.O000000o(str2)) {
                try {
                    O0000Oo = O00000oO(str2).O000000o();
                } catch (ClassNotFoundException unused) {
                }
            } else if (Interpreter.f3062O000000o) {
                Interpreter.O00000Oo("imported unpackaged name not found:".concat(String.valueOf(str2)));
            }
            if (O0000Oo == null) {
                return null;
            }
            O00000o().O000000o(str2, O0000Oo);
            return O0000Oo;
        }
        Vector vector = this.importedPackages;
        if (vector != null) {
            for (int size = vector.size() - 1; size >= 0; size--) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append((String) this.importedPackages.elementAt(size));
                stringBuffer.append(".");
                stringBuffer.append(str);
                Class O0000Oo2 = O0000Oo(stringBuffer.toString());
                if (O0000Oo2 != null) {
                    return O0000Oo2;
                }
            }
        }
        O00000o();
        return null;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        this.names = null;
        objectOutputStream.defaultWriteObject();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod
     arg types: [java.lang.String, java.lang.Class[], int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], bsh.Interpreter):java.lang.Object
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod */
    public final BshMethod O000000o(String str, Class[] clsArr) throws UtilEvalError {
        return O000000o(str, clsArr, false);
    }

    /* access modifiers changed from: package-private */
    public This O000000o(Interpreter interpreter) {
        if (this.thisReference == null) {
            this.thisReference = This.O000000o(this, interpreter);
        }
        return this.thisReference;
    }

    /* access modifiers changed from: protected */
    public final Variable O000000o(String str, boolean z) throws UtilEvalError {
        NameSpace nameSpace;
        Hashtable hashtable;
        Variable O0000O0o = this.isClass ? O0000O0o(str) : null;
        if (O0000O0o == null && (hashtable = this.variables) != null) {
            O0000O0o = (Variable) hashtable.get(str);
        }
        if (O0000O0o == null && !this.isClass) {
            O0000O0o = O0000O0o(str);
        }
        return (!z || O0000O0o != null || (nameSpace = this.parent) == null) ? O0000O0o : nameSpace.O000000o(str, z);
    }

    /* access modifiers changed from: package-private */
    public final Object O000000o() throws UtilEvalError {
        Object obj = this.classInstance;
        if (obj != null) {
            return obj;
        }
        if (this.classStatic != null) {
            throw new UtilEvalError("Can't refer to class instance from static context.");
        }
        throw new InterpreterError("Can't resolve class instance 'this' in: ".concat(String.valueOf(this)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public final Object O000000o(String str, Class[] clsArr, Interpreter interpreter) throws UtilEvalError {
        StringBuffer stringBuffer;
        String str2;
        NameSpace nameSpace = this;
        do {
            if (Interpreter.f3062O000000o) {
                Interpreter.O00000Oo("getCommand: ".concat(String.valueOf(str)));
            }
            kt O00000o02 = interpreter.O00000o0();
            Vector vector = nameSpace.importedCommands;
            if (vector != null) {
                for (int size = vector.size() - 1; size >= 0; size--) {
                    String str3 = (String) nameSpace.importedCommands.elementAt(size);
                    if (str3.equals("/")) {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(str3);
                    } else {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(str3);
                        stringBuffer.append("/");
                    }
                    stringBuffer.append(str);
                    stringBuffer.append(".bsh");
                    String stringBuffer2 = stringBuffer.toString();
                    Interpreter.O00000Oo("searching for script: ".concat(String.valueOf(stringBuffer2)));
                    InputStream O00000Oo2 = O00000o02.O00000Oo(stringBuffer2);
                    if (O00000Oo2 != null) {
                        return nameSpace.O000000o(O00000Oo2, str, clsArr, stringBuffer2, interpreter);
                    }
                    if (str3.equals("/")) {
                        str2 = str;
                    } else {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append(str3.substring(1).replace('/', '.'));
                        stringBuffer3.append(".");
                        stringBuffer3.append(str);
                        str2 = stringBuffer3.toString();
                    }
                    Interpreter.O00000Oo("searching for class: ".concat(String.valueOf(str2)));
                    Class O000000o2 = O00000o02.O000000o(str2);
                    if (O000000o2 != null) {
                        return O000000o2;
                    }
                }
            }
            nameSpace = nameSpace.parent;
        } while (nameSpace != null);
        return null;
    }

    public final void O000000o(Class cls) {
        if (this.importedStatic == null) {
            this.importedStatic = new Vector();
        }
        if (this.importedStatic.contains(cls)) {
            this.importedStatic.remove(cls);
        }
        this.importedStatic.addElement(cls);
        O00000oo();
    }

    public void O000000o(String str) {
        if (this.importedClasses == null) {
            this.importedClasses = new Hashtable();
        }
        this.importedClasses.put(Name.O000000o(str, 1), str);
        O00000oo();
    }

    public void O000000o(String str, BshMethod bshMethod) throws UtilEvalError {
        if (this.methods == null) {
            this.methods = new Hashtable();
        }
        Object obj = this.methods.get(str);
        if (obj == null) {
            this.methods.put(str, bshMethod);
        } else if (obj instanceof BshMethod) {
            Vector vector = new Vector();
            vector.addElement(obj);
            vector.addElement(bshMethod);
            this.methods.put(str, vector);
        } else {
            ((Vector) obj).addElement(bshMethod);
        }
    }

    public final void O000000o(String str, Object obj, boolean z) throws UtilEvalError {
        O000000o(str, obj, z, Interpreter.O00000o0 ? z : true);
    }

    /* access modifiers changed from: package-private */
    public void O000000o(String str, Object obj, boolean z, boolean z2) throws UtilEvalError {
        if (this.variables == null) {
            this.variables = new Hashtable();
        }
        if (obj != null) {
            Variable O000000o2 = O000000o(str, z2);
            if (O000000o2 != null) {
                try {
                    O000000o2.O000000o(obj, 1);
                } catch (UtilEvalError e) {
                    StringBuffer stringBuffer = new StringBuffer("Variable assignment: ");
                    stringBuffer.append(str);
                    stringBuffer.append(": ");
                    stringBuffer.append(e.getMessage());
                    throw new UtilEvalError(stringBuffer.toString());
                }
            } else if (!z) {
                this.variables.put(str, new Variable(str, obj));
                O00000oo();
            } else {
                throw new UtilEvalError("(Strict Java mode) Assignment to undeclared variable: ".concat(String.valueOf(str)));
            }
        } else {
            throw new InterpreterError("null variable value");
        }
    }

    public This O00000Oo(Interpreter interpreter) {
        NameSpace nameSpace = this.parent;
        return nameSpace != null ? nameSpace.O000000o(interpreter) : O000000o(interpreter);
    }

    public void O00000Oo(String str) {
        if (this.importedPackages == null) {
            this.importedPackages = new Vector();
        }
        if (this.importedPackages.contains(str)) {
            this.importedPackages.remove(str);
        }
        this.importedPackages.addElement(str);
        O00000oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean, boolean):void
     arg types: [java.lang.String, java.lang.Object, boolean, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class, java.lang.Object, bsh.Modifiers):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O00000Oo(String str, Object obj, boolean z) throws UtilEvalError {
        O000000o(str, obj, z, false);
    }

    public final String[] O00000Oo() {
        Hashtable hashtable = this.variables;
        return hashtable == null ? new String[0] : O000000o(hashtable.keys());
    }

    public final kt O00000o() {
        NameSpace nameSpace = this;
        while (true) {
            kt ktVar = nameSpace.O00000Oo;
            if (ktVar != null) {
                return ktVar;
            }
            NameSpace nameSpace2 = nameSpace.parent;
            if (nameSpace2 == null || nameSpace2 == f3064O000000o) {
                System.out.println("experiment: creating class manager");
                nameSpace.O00000Oo = kt.O000000o((Interpreter) null);
            } else {
                nameSpace = nameSpace2;
            }
        }
        System.out.println("experiment: creating class manager");
        nameSpace.O00000Oo = kt.O000000o((Interpreter) null);
        return nameSpace.O00000Oo;
    }

    public final Class O00000o(String str) throws UtilEvalError {
        NameSpace nameSpace = this;
        do {
            Class O0000OOo = nameSpace.O0000OOo(str);
            if (O0000OOo != null) {
                return O0000OOo;
            }
            nameSpace = nameSpace.parent;
        } while (nameSpace != null);
        return null;
    }

    public final This O00000o0(Interpreter interpreter) {
        NameSpace nameSpace = this;
        while (true) {
            NameSpace nameSpace2 = nameSpace.parent;
            if (nameSpace2 == null) {
                return nameSpace.O000000o(interpreter);
            }
            nameSpace = nameSpace2;
        }
    }

    public final Object O00000o0(String str) throws UtilEvalError {
        return O00000oo(str);
    }

    public final String[] O00000o0() {
        Hashtable hashtable = this.methods;
        return hashtable == null ? new String[0] : O000000o(hashtable.keys());
    }

    /* access modifiers changed from: package-private */
    public final Name O00000oO(String str) {
        if (this.names == null) {
            this.names = new Hashtable();
        }
        Name name = (Name) this.names.get(str);
        if (name != null) {
            return name;
        }
        Name name2 = new Name(this, str);
        this.names.put(str, name2);
        return name2;
    }

    public final void O00000oO() throws UtilEvalError {
        O00000o();
        kt.O000000o();
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer("NameSpace: ");
        if (this.nsName == null) {
            str = super.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.nsName);
            stringBuffer2.append(" (");
            stringBuffer2.append(super.toString());
            stringBuffer2.append(")");
            str = stringBuffer2.toString();
        }
        stringBuffer.append(str);
        String str2 = "";
        stringBuffer.append(this.isClass ? " (isClass) " : str2);
        stringBuffer.append(this.isMethod ? " (method) " : str2);
        stringBuffer.append(this.classStatic != null ? " (class static) " : str2);
        if (this.classInstance != null) {
            str2 = " (class instance) ";
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    private NameSpace(NameSpace nameSpace, kt ktVar, String str) {
        this.nsName = str;
        this.parent = nameSpace;
        if (nameSpace == null) {
            O000000o("bsh.EvalError");
            O000000o("bsh.Interpreter");
            O00000Oo("javax.swing.event");
            O00000Oo("javax.swing");
            O00000Oo("java.awt.event");
            O00000Oo("java.awt");
            O00000Oo("java.net");
            O00000Oo("java.util");
            O00000Oo("java.io");
            O00000Oo("java.lang");
            if (this.importedCommands == null) {
                this.importedCommands = new Vector();
            }
            String replace = "/bsh/commands".replace('.', '/');
            replace = !replace.startsWith("/") ? "/".concat(String.valueOf(replace)) : replace;
            if (replace.length() > 1 && replace.endsWith("/")) {
                replace = replace.substring(0, replace.length() - 1);
            }
            if (this.importedCommands.contains(replace)) {
                this.importedCommands.remove(replace);
            }
            this.importedCommands.addElement(replace);
            O00000oo();
        }
        this.O00000Oo = ktVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, boolean):bsh.Variable
     arg types: [java.lang.String, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[]):bsh.BshMethod
      bsh.NameSpace.O000000o(java.lang.String, bsh.BshMethod):void
      bsh.NameSpace.O000000o(java.lang.String, boolean):bsh.Variable */
    public final void O000000o(String str, Class cls, Object obj, Modifiers modifiers) throws UtilEvalError {
        if (this.variables == null) {
            this.variables = new Hashtable();
        }
        Variable O000000o2 = O000000o(str, false);
        if (O000000o2 == null || O000000o2.type == null) {
            this.variables.put(str, new Variable(str, cls, obj, modifiers));
        } else if (O000000o2.type == cls) {
            O000000o2.O000000o(obj, 0);
        } else {
            StringBuffer stringBuffer = new StringBuffer("Typed variable: ");
            stringBuffer.append(str);
            stringBuffer.append(" was previously declared with type: ");
            stringBuffer.append(O000000o2.type);
            throw new UtilEvalError(stringBuffer.toString());
        }
    }

    public final BshMethod O000000o(String str, Class[] clsArr, boolean z) throws UtilEvalError {
        BshMethod bshMethod;
        Hashtable hashtable;
        Object obj;
        BshMethod[] bshMethodArr;
        NameSpace nameSpace = this;
        do {
            bshMethod = null;
            if (nameSpace.isClass) {
                bshMethod = nameSpace.O00000Oo(str, clsArr);
            }
            if (!(bshMethod != null || (hashtable = nameSpace.methods) == null || (obj = hashtable.get(str)) == null)) {
                if (obj instanceof Vector) {
                    Vector vector = (Vector) obj;
                    bshMethodArr = new BshMethod[vector.size()];
                    vector.copyInto(bshMethodArr);
                } else {
                    bshMethodArr = new BshMethod[]{(BshMethod) obj};
                }
                Class[][] clsArr2 = new Class[bshMethodArr.length][];
                for (int i = 0; i < bshMethodArr.length; i++) {
                    clsArr2[i] = bshMethodArr[i].cparamTypes;
                }
                int O000000o2 = lg.O000000o(clsArr, clsArr2);
                if (O000000o2 != -1) {
                    bshMethod = bshMethodArr[O000000o2];
                }
            }
            if (bshMethod == null && !nameSpace.isClass) {
                bshMethod = nameSpace.O00000Oo(str, clsArr);
            }
            if (bshMethod != null) {
                break;
            }
            nameSpace = nameSpace.parent;
        } while (nameSpace != null);
        return bshMethod;
    }
}
