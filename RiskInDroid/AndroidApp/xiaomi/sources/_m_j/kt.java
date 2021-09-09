package _m_j;

import bsh.Capabilities;
import bsh.EvalError;
import bsh.Interpreter;
import bsh.InterpreterError;
import bsh.UtilEvalError;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Hashtable;

public final class kt {
    static Class O0000OOo;
    private static Object O0000Oo0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    protected ClassLoader f2154O000000o;
    protected transient Hashtable O00000Oo = new Hashtable();
    protected transient Hashtable O00000o = new Hashtable();
    protected transient Hashtable O00000o0 = new Hashtable();
    protected transient Hashtable O00000oO = new Hashtable();
    protected transient Hashtable O00000oo = new Hashtable();
    protected transient Hashtable O0000O0o = new Hashtable();
    private Interpreter O0000Oo;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Class f2155O000000o;
        Class[] O00000Oo;
        int O00000o = 0;
        String O00000o0;

        O000000o(Class cls, String str, Class[] clsArr) {
            this.f2155O000000o = cls;
            this.O00000o0 = str;
            this.O00000Oo = clsArr;
        }

        public final boolean equals(Object obj) {
            O000000o o000000o = (O000000o) obj;
            if (this.O00000Oo == null) {
                return o000000o.O00000Oo == null;
            }
            if (this.f2155O000000o != o000000o.f2155O000000o || !this.O00000o0.equals(o000000o.O00000o0) || this.O00000Oo.length != o000000o.O00000Oo.length) {
                return false;
            }
            int i = 0;
            while (true) {
                Class[] clsArr = this.O00000Oo;
                if (i >= clsArr.length) {
                    return true;
                }
                if (clsArr[i] == null) {
                    if (o000000o.O00000Oo[i] != null) {
                        return false;
                    }
                } else if (!clsArr[i].equals(o000000o.O00000Oo[i])) {
                    return false;
                }
                i++;
            }
        }

        public final int hashCode() {
            if (this.O00000o == 0) {
                this.O00000o = this.f2155O000000o.hashCode() * this.O00000o0.hashCode();
                if (this.O00000Oo == null) {
                    return this.O00000o;
                }
                int i = 0;
                while (true) {
                    Class[] clsArr = this.O00000Oo;
                    if (i >= clsArr.length) {
                        break;
                    }
                    int hashCode = clsArr[i] == null ? 21 : clsArr[i].hashCode();
                    i++;
                    this.O00000o = (this.O00000o * i) + hashCode;
                }
            }
            return this.O00000o;
        }
    }

    public static kt O000000o(Interpreter interpreter) {
        kt ktVar;
        if (!Capabilities.O000000o("java.lang.ref.WeakReference") || !Capabilities.O000000o("java.util.HashMap") || !Capabilities.O000000o("bsh.classpath.ClassManagerImpl")) {
            ktVar = new kt();
        } else {
            try {
                ktVar = (kt) Class.forName("bsh.classpath.ClassManagerImpl").newInstance();
            } catch (Exception e) {
                throw new InterpreterError("Error loading classmanager: ".concat(String.valueOf(e)));
            }
        }
        if (interpreter == null) {
            interpreter = new Interpreter();
        }
        ktVar.O0000Oo = interpreter;
        return ktVar;
    }

    private static Class O00000oO(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final Method O000000o(Class cls, String str, Class[] clsArr, boolean z) {
        String str2;
        O000000o o000000o = new O000000o(cls, str, clsArr);
        Method method = (Method) this.O00000oO.get(o000000o);
        if (method == null && !z) {
            method = (Method) this.O00000o.get(o000000o);
        }
        if (Interpreter.f3062O000000o) {
            if (method == null) {
                StringBuffer stringBuffer = new StringBuffer("getResolvedMethod cache MISS: ");
                stringBuffer.append(cls);
                stringBuffer.append(" - ");
                stringBuffer.append(str);
                str2 = stringBuffer.toString();
            } else {
                StringBuffer stringBuffer2 = new StringBuffer("getResolvedMethod cache HIT: ");
                stringBuffer2.append(cls);
                stringBuffer2.append(" - ");
                stringBuffer2.append(method);
                str2 = stringBuffer2.toString();
            }
            Interpreter.O00000Oo(str2);
        }
        return method;
    }

    public final void O000000o(Class cls, Class[] clsArr, Method method) {
        if (Interpreter.f3062O000000o) {
            StringBuffer stringBuffer = new StringBuffer("cacheResolvedMethod putting: ");
            stringBuffer.append(cls);
            stringBuffer.append(" ");
            stringBuffer.append(method);
            Interpreter.O00000Oo(stringBuffer.toString());
        }
        (Modifier.isStatic(method.getModifiers()) ? this.O00000oO : this.O00000o).put(new O000000o(cls, method.getName(), clsArr), method);
    }

    public final void O000000o(String str, Class cls) {
        if (cls != null) {
            this.O00000Oo.put(str, cls);
        } else {
            this.O00000o0.put(str, O0000Oo0);
        }
    }

    public final InputStream O00000Oo(String str) {
        ClassLoader classLoader = this.f2154O000000o;
        InputStream resourceAsStream = classLoader != null ? classLoader.getResourceAsStream(str.substring(1)) : null;
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        Class cls = O0000OOo;
        if (cls == null) {
            cls = O00000oO("bsh.Interpreter");
            O0000OOo = cls;
        }
        return cls.getResourceAsStream(str);
    }

    public final Class O000000o(String str) {
        if (!(this.O00000oo.get(str) != null)) {
            Class cls = null;
            try {
                cls = O00000o(str);
            } catch (ClassNotFoundException unused) {
            }
            return cls == null ? O00000o0(str) : cls;
        }
        throw new InterpreterError("Attempting to load class in the process of being defined: ".concat(String.valueOf(str)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    private Class O00000o0(String str) {
        StringBuffer stringBuffer = new StringBuffer("/");
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append(".java");
        String stringBuffer2 = stringBuffer.toString();
        InputStream O00000Oo2 = O00000Oo(stringBuffer2);
        if (O00000Oo2 == null) {
            return null;
        }
        try {
            System.out.println("Loading class from source file: ".concat(String.valueOf(stringBuffer2)));
            Interpreter interpreter = this.O0000Oo;
            interpreter.O000000o(new InputStreamReader(O00000Oo2), interpreter.globalNameSpace, "eval stream");
        } catch (EvalError e) {
            System.err.println(e);
        }
        try {
            return O00000o(str);
        } catch (ClassNotFoundException unused) {
            System.err.println("Class not found in source file: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private Class O00000o(String str) throws ClassNotFoundException {
        try {
            Class<?> loadClass = this.f2154O000000o != null ? this.f2154O000000o.loadClass(str) : Class.forName(str);
            O000000o(str, loadClass);
            return loadClass;
        } catch (NoClassDefFoundError e) {
            StringBuffer stringBuffer = new StringBuffer("A class required by class: ");
            stringBuffer.append(str);
            stringBuffer.append(" could not be loaded:\n");
            stringBuffer.append(e.toString());
            throw new NoClassDefFoundError(stringBuffer.toString());
        }
    }

    public static void O000000o() throws UtilEvalError {
        throw new Capabilities.Unavailable("ClassLoading features unavailable.");
    }
}
