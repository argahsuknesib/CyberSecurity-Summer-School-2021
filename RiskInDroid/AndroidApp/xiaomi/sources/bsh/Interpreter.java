package bsh;

import _m_j.kt;
import _m_j.kv;
import _m_j.la;
import _m_j.li;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;

public class Interpreter implements la, Serializable, Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f3062O000000o = false;
    public static boolean O00000Oo = false;
    static transient PrintStream O00000o = null;
    public static boolean O00000o0 = false;
    static String O00000oO = "\n";
    static This O00000oo;
    transient Parser O0000O0o;
    transient Reader O0000OOo;
    transient PrintStream O0000Oo;
    transient PrintStream O0000Oo0;
    la console;
    protected boolean evalOnly;
    private boolean exitOnEOF;
    public NameSpace globalNameSpace;
    protected boolean interactive;
    Interpreter parent;
    private boolean showResults;
    String sourceFileInfo;
    boolean strictJava;

    public Interpreter() {
        this(new StringReader(""), System.out, System.err);
        this.evalOnly = true;
        O00000Oo("bsh.evalOnly", new Primitive(true));
    }

    private Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2) {
        this(reader, printStream, printStream2, false, null, null, null);
    }

    private Object O000000o(String str, NameSpace nameSpace) throws EvalError {
        if (!str.endsWith(";")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(";");
            str = stringBuffer.toString();
        }
        StringReader stringReader = new StringReader(str);
        StringBuffer stringBuffer2 = new StringBuffer("inline evaluation of: ``");
        stringBuffer2.append(O00000o0(str));
        stringBuffer2.append("''");
        return O000000o(stringReader, nameSpace, stringBuffer2.toString());
    }

    public static final void O00000Oo(String str) {
        if (f3062O000000o) {
            O00000o.println("// Debug: ".concat(String.valueOf(str)));
        }
    }

    private void O00000Oo(String str, Object obj) {
        try {
            O000000o(str, obj);
        } catch (EvalError e) {
            throw new InterpreterError("set: ".concat(String.valueOf(e)));
        }
    }

    private String O00000o() {
        try {
            return (String) O000000o("getBshPrompt()");
        } catch (Exception unused) {
            return "bsh % ";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    private static String O00000o0(String str) {
        String replace = str.replace(10, ' ').replace(13, ' ');
        if (replace.length() <= 80) {
            return replace;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(replace.substring(0, 80));
        stringBuffer.append(" . . . ");
        return stringBuffer.toString();
    }

    private void O00000o0(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(obj));
        stringBuffer.append(O00000oO);
        O000000o((Object) stringBuffer.toString());
    }

    private Object O00000oO(String str) {
        try {
            return O00000o(str);
        } catch (EvalError e) {
            throw new InterpreterError("set: ".concat(String.valueOf(e)));
        }
    }

    public final PrintStream O000000o() {
        return this.O0000Oo0;
    }

    public final Object O000000o(String str) throws EvalError {
        if (f3062O000000o) {
            O00000Oo("eval(String): ".concat(String.valueOf(str)));
        }
        return O000000o(str, this.globalNameSpace);
    }

    public final void O000000o(Object obj) {
        la laVar = this.console;
        if (laVar != null) {
            laVar.O000000o(obj);
            return;
        }
        this.O0000Oo0.print(obj);
        this.O0000Oo0.flush();
    }

    public final void O000000o(String str, int i) throws EvalError {
        O000000o(str, new Primitive(i));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.Object, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], bsh.Interpreter):java.lang.Object
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void */
    public final void O000000o(String str, Object obj) throws EvalError {
        if (obj == null) {
            obj = Primitive.O00000Oo;
        }
        kv kvVar = new kv();
        try {
            if (Name.O000000o(str)) {
                this.globalNameSpace.O00000oO(str).O000000o(kvVar, this).O000000o(obj, false);
            } else {
                this.globalNameSpace.O000000o(str, obj, false);
            }
        } catch (UtilEvalError e) {
            throw e.toEvalError(SimpleNode.O00000Oo, kvVar);
        }
    }

    public final PrintStream O00000Oo() {
        return this.O0000Oo;
    }

    public final void O00000Oo(Object obj) {
        la laVar = this.console;
        if (laVar != null) {
            StringBuffer stringBuffer = new StringBuffer("// Error: ");
            stringBuffer.append(obj);
            stringBuffer.append("\n");
            laVar.O00000Oo(stringBuffer.toString());
            return;
        }
        this.O0000Oo.println("// Error: ".concat(String.valueOf(obj)));
        this.O0000Oo.flush();
    }

    private Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z, NameSpace nameSpace, Interpreter interpreter, String str) {
        this.strictJava = false;
        this.exitOnEOF = true;
        this.O0000O0o = new Parser(reader);
        long currentTimeMillis = System.currentTimeMillis();
        this.O0000OOo = reader;
        this.O0000Oo0 = printStream;
        this.O0000Oo = printStream2;
        this.interactive = false;
        O00000o = printStream2;
        this.parent = interpreter;
        if (interpreter != null) {
            this.strictJava = interpreter.strictJava;
        }
        this.sourceFileInfo = str;
        kt O000000o2 = kt.O000000o(this);
        if (nameSpace == null) {
            this.globalNameSpace = new NameSpace(O000000o2, "global");
        } else {
            this.globalNameSpace = nameSpace;
        }
        if (!(O00000oO("bsh") instanceof This)) {
            kt O00000o2 = this.globalNameSpace.O00000o();
            O00000Oo("bsh", new NameSpace(O00000o2, "Bsh Object").O000000o(this));
            if (O00000oo == null) {
                O00000oo = new NameSpace(O00000o2, "Bsh Shared System Object").O000000o(this);
            }
            O00000Oo("bsh.system", O00000oo);
            O00000Oo("bsh.shared", O00000oo);
            O00000Oo("bsh.help", new NameSpace(O00000o2, "Bsh Command Help Text").O000000o(this));
            try {
                O00000Oo("bsh.cwd", System.getProperty("user.dir"));
            } catch (SecurityException unused) {
                O00000Oo("bsh.cwd", ".");
            }
            O00000Oo("bsh.interactive", new Primitive(this.interactive));
            O00000Oo("bsh.evalOnly", new Primitive(this.evalOnly));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (f3062O000000o) {
            StringBuffer stringBuffer = new StringBuffer("Time to initialize interpreter: ");
            stringBuffer.append(currentTimeMillis2 - currentTimeMillis);
            O00000Oo(stringBuffer.toString());
        }
    }

    public void run() {
        String stringBuffer;
        if (!this.evalOnly) {
            if (this.interactive) {
                try {
                    O000000o("printBanner();");
                } catch (EvalError unused) {
                    O00000o0((Object) "BeanShell 2.0b4 - by Pat Niemeyer (pat@pat.net)");
                }
            }
            kv kvVar = new kv(this.globalNameSpace);
            boolean z = false;
            while (!z) {
                try {
                    System.out.flush();
                    System.err.flush();
                    Thread.yield();
                    if (this.interactive) {
                        O000000o((Object) O00000o());
                    }
                    z = this.O0000O0o.O000000o();
                    if (this.O0000O0o.f3065O000000o.O00000o() > 0) {
                        SimpleNode simpleNode = (SimpleNode) this.O0000O0o.f3065O000000o.O00000Oo();
                        if (f3062O000000o) {
                            simpleNode.O00000o0(">");
                        }
                        Object O000000o2 = simpleNode.O000000o(kvVar, this);
                        if (kvVar.f2156O000000o.size() <= 1) {
                            if (O000000o2 instanceof li) {
                                O000000o2 = ((li) O000000o2).O00000Oo;
                            }
                            if (O000000o2 != Primitive.O00000o0) {
                                O00000Oo("$_", O000000o2);
                                if (this.showResults) {
                                    StringBuffer stringBuffer2 = new StringBuffer("<");
                                    stringBuffer2.append(O000000o2);
                                    stringBuffer2.append(">");
                                    O00000o0((Object) stringBuffer2.toString());
                                }
                            }
                        } else {
                            throw new InterpreterError("Callstack growing: ".concat(String.valueOf(kvVar)));
                        }
                    }
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (ParseException e) {
                    StringBuffer stringBuffer3 = new StringBuffer("Parser Error: ");
                    stringBuffer3.append(e.getMessage(f3062O000000o));
                    O00000Oo((Object) stringBuffer3.toString());
                    if (f3062O000000o) {
                        e.printStackTrace();
                    }
                    if (!this.interactive) {
                        z = true;
                    }
                    this.O0000O0o.O000000o(this.O0000OOo);
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (InterpreterError e2) {
                    StringBuffer stringBuffer4 = new StringBuffer("Internal Error: ");
                    stringBuffer4.append(e2.getMessage());
                    O00000Oo((Object) stringBuffer4.toString());
                    e2.printStackTrace();
                    if (!this.interactive) {
                        z = true;
                    }
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (TargetError e3) {
                    O00000Oo((Object) "// Uncaught Exception: ".concat(String.valueOf(e3)));
                    if (e3.inNativeCode()) {
                        e3.printStackTrace(f3062O000000o, this.O0000Oo);
                    }
                    if (!this.interactive) {
                        z = true;
                    }
                    O00000Oo("$_e", e3.getTarget());
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (EvalError e4) {
                    if (this.interactive) {
                        StringBuffer stringBuffer5 = new StringBuffer("EvalError: ");
                        stringBuffer5.append(e4.toString());
                        stringBuffer = stringBuffer5.toString();
                    } else {
                        StringBuffer stringBuffer6 = new StringBuffer("EvalError: ");
                        stringBuffer6.append(e4.getMessage());
                        stringBuffer = stringBuffer6.toString();
                    }
                    O00000Oo((Object) stringBuffer);
                    if (f3062O000000o) {
                        e4.printStackTrace();
                    }
                    if (!this.interactive) {
                        z = true;
                    }
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (Exception e5) {
                    O00000Oo((Object) "Unknown error: ".concat(String.valueOf(e5)));
                    if (f3062O000000o) {
                        e5.printStackTrace();
                    }
                    if (!this.interactive) {
                        z = true;
                    }
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (TokenMgrError e6) {
                    O00000Oo((Object) "Error parsing input: ".concat(String.valueOf(e6)));
                    Parser parser = this.O0000O0o;
                    parser.O00000o.O000000o(this.O0000OOo, parser.O00000o.O00000o(), parser.O00000o.O00000o0());
                    if (!this.interactive) {
                        z = true;
                    }
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                } catch (Throwable th) {
                    this.O0000O0o.f3065O000000o.O000000o();
                    if (kvVar.f2156O000000o.size() > 1) {
                        kvVar.f2156O000000o.removeAllElements();
                        kvVar.O000000o(this.globalNameSpace);
                    }
                    throw th;
                }
            }
            if (this.interactive && this.exitOnEOF) {
                System.exit(0);
                return;
            }
            return;
        }
        throw new RuntimeException("bsh Interpreter: No stream");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b7, code lost:
        if (bsh.Interpreter.f3062O000000o != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b9, code lost:
        O00000Oo((java.lang.Object) r0.getMessage(bsh.Interpreter.f3062O000000o));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c2, code lost:
        r0.setErrorSourceFile(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c5, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111 A[Catch:{ ParseException -> 0x01b4, InterpreterError -> 0x00cc, TargetError -> 0x00c9, EvalError -> 0x00c7, Exception -> 0x00c5, TokenMgrError -> 0x00c3, ParseException -> 0x01b4, InterpreterError -> 0x0191, TargetError -> 0x0165, EvalError -> 0x0132, Exception -> 0x010b, TokenMgrError -> 0x00eb, all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0138 A[Catch:{ ParseException -> 0x01b4, InterpreterError -> 0x00cc, TargetError -> 0x00c9, EvalError -> 0x00c7, Exception -> 0x00c5, TokenMgrError -> 0x00c3, ParseException -> 0x01b4, InterpreterError -> 0x0191, TargetError -> 0x0165, EvalError -> 0x0132, Exception -> 0x010b, TokenMgrError -> 0x00eb, all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013f A[Catch:{ ParseException -> 0x01b4, InterpreterError -> 0x00cc, TargetError -> 0x00c9, EvalError -> 0x00c7, Exception -> 0x00c5, TokenMgrError -> 0x00c3, ParseException -> 0x01b4, InterpreterError -> 0x0191, TargetError -> 0x0165, EvalError -> 0x0132, Exception -> 0x010b, TokenMgrError -> 0x00eb, all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x016b A[Catch:{ ParseException -> 0x01b4, InterpreterError -> 0x00cc, TargetError -> 0x00c9, EvalError -> 0x00c7, Exception -> 0x00c5, TokenMgrError -> 0x00c3, ParseException -> 0x01b4, InterpreterError -> 0x0191, TargetError -> 0x0165, EvalError -> 0x0132, Exception -> 0x010b, TokenMgrError -> 0x00eb, all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b4 A[Catch:{ ParseException -> 0x01b4, InterpreterError -> 0x00cc, TargetError -> 0x00c9, EvalError -> 0x00c7, Exception -> 0x00c5, TokenMgrError -> 0x00c3, ParseException -> 0x01b4, InterpreterError -> 0x0191, TargetError -> 0x0165, EvalError -> 0x0132, Exception -> 0x010b, TokenMgrError -> 0x00eb, all -> 0x00e8 }, ExcHandler: ParseException (r0v1 'e' bsh.ParseException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:6:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x002a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x002a A[SYNTHETIC] */
    public final Object O000000o(Reader reader, NameSpace nameSpace, String str) throws EvalError {
        SimpleNode simpleNode;
        if (f3062O000000o) {
            O00000Oo("eval: nameSpace = ".concat(String.valueOf(nameSpace)));
        }
        Interpreter interpreter = new Interpreter(reader, this.O0000Oo0, this.O0000Oo, false, nameSpace, this, str);
        kv kvVar = new kv(nameSpace);
        boolean z = false;
        Object obj = null;
        while (true) {
            if (z) {
                break;
            }
            try {
                z = interpreter.O0000O0o.O000000o();
                if (interpreter.O0000O0o.f3065O000000o.O00000o() > 0) {
                    simpleNode = (SimpleNode) interpreter.O0000O0o.f3065O000000o.O00000Oo();
                    simpleNode.sourceFile = str;
                    if (O00000Oo) {
                        StringBuffer stringBuffer = new StringBuffer("// ");
                        stringBuffer.append(simpleNode.O00000oo());
                        O00000o0((Object) stringBuffer.toString());
                    }
                    obj = simpleNode.O000000o(kvVar, interpreter);
                    if (kvVar.f2156O000000o.size() > 1) {
                        throw new InterpreterError("Callstack growing: ".concat(String.valueOf(kvVar)));
                    } else if (obj instanceof li) {
                        obj = ((li) obj).O00000Oo;
                        interpreter.O0000O0o.f3065O000000o.O000000o();
                        if (kvVar.f2156O000000o.size() > 1) {
                            kvVar.f2156O000000o.removeAllElements();
                            kvVar.O000000o(nameSpace);
                        }
                    } else if (interpreter.showResults && obj != Primitive.O00000o0) {
                        StringBuffer stringBuffer2 = new StringBuffer("<");
                        stringBuffer2.append(obj);
                        stringBuffer2.append(">");
                        O00000o0((Object) stringBuffer2.toString());
                    }
                }
                interpreter.O0000O0o.f3065O000000o.O000000o();
                if (kvVar.f2156O000000o.size() > 1) {
                    kvVar.f2156O000000o.removeAllElements();
                    kvVar.O000000o(nameSpace);
                }
            } catch (ParseException e) {
            } catch (InterpreterError e2) {
                e = e2;
                e.printStackTrace();
                StringBuffer stringBuffer3 = new StringBuffer("Sourced file: ");
                stringBuffer3.append(str);
                stringBuffer3.append(" internal Error: ");
                stringBuffer3.append(e.getMessage());
                throw new EvalError(stringBuffer3.toString(), simpleNode, kvVar);
            } catch (TargetError e3) {
                e = e3;
                if (e.node == null) {
                    e.node = simpleNode;
                }
                e.reThrow("Sourced file: ".concat(String.valueOf(str)));
                interpreter.O0000O0o.f3065O000000o.O000000o();
                if (kvVar.f2156O000000o.size() <= 1) {
                    kvVar.f2156O000000o.removeAllElements();
                    kvVar.O000000o(nameSpace);
                }
            } catch (EvalError e4) {
                e = e4;
                if (f3062O000000o) {
                    e.printStackTrace();
                }
                if (e.node == null) {
                    e.node = simpleNode;
                }
                e.reThrow("Sourced file: ".concat(String.valueOf(str)));
                interpreter.O0000O0o.f3065O000000o.O000000o();
                if (kvVar.f2156O000000o.size() <= 1) {
                    kvVar.f2156O000000o.removeAllElements();
                    kvVar.O000000o(nameSpace);
                }
            } catch (Exception e5) {
                e = e5;
                if (f3062O000000o) {
                    e.printStackTrace();
                }
                StringBuffer stringBuffer4 = new StringBuffer("Sourced file: ");
                stringBuffer4.append(str);
                stringBuffer4.append(" unknown error: ");
                stringBuffer4.append(e.getMessage());
                throw new EvalError(stringBuffer4.toString(), simpleNode, kvVar);
            } catch (TokenMgrError e6) {
                e = e6;
                StringBuffer stringBuffer5 = new StringBuffer("Sourced file: ");
                stringBuffer5.append(str);
                stringBuffer5.append(" Token Parsing Error: ");
                stringBuffer5.append(e.getMessage());
                throw new EvalError(stringBuffer5.toString(), simpleNode, kvVar);
            } catch (InterpreterError e7) {
                e = e7;
                simpleNode = null;
                e.printStackTrace();
                StringBuffer stringBuffer32 = new StringBuffer("Sourced file: ");
                stringBuffer32.append(str);
                stringBuffer32.append(" internal Error: ");
                stringBuffer32.append(e.getMessage());
                throw new EvalError(stringBuffer32.toString(), simpleNode, kvVar);
            } catch (TargetError e8) {
                e = e8;
                simpleNode = null;
                if (e.node == null) {
                }
                e.reThrow("Sourced file: ".concat(String.valueOf(str)));
                interpreter.O0000O0o.f3065O000000o.O000000o();
                if (kvVar.f2156O000000o.size() <= 1) {
                }
            } catch (EvalError e9) {
                e = e9;
                simpleNode = null;
                if (f3062O000000o) {
                }
                if (e.node == null) {
                }
                e.reThrow("Sourced file: ".concat(String.valueOf(str)));
                interpreter.O0000O0o.f3065O000000o.O000000o();
                if (kvVar.f2156O000000o.size() <= 1) {
                }
            } catch (Exception e10) {
                e = e10;
                simpleNode = null;
                if (f3062O000000o) {
                }
                StringBuffer stringBuffer42 = new StringBuffer("Sourced file: ");
                stringBuffer42.append(str);
                stringBuffer42.append(" unknown error: ");
                stringBuffer42.append(e.getMessage());
                throw new EvalError(stringBuffer42.toString(), simpleNode, kvVar);
            } catch (TokenMgrError e11) {
                e = e11;
                simpleNode = null;
                StringBuffer stringBuffer52 = new StringBuffer("Sourced file: ");
                stringBuffer52.append(str);
                stringBuffer52.append(" Token Parsing Error: ");
                stringBuffer52.append(e.getMessage());
                throw new EvalError(stringBuffer52.toString(), simpleNode, kvVar);
            } catch (Throwable th) {
                interpreter.O0000O0o.f3065O000000o.O000000o();
                if (kvVar.f2156O000000o.size() > 1) {
                    kvVar.f2156O000000o.removeAllElements();
                    kvVar.O000000o(nameSpace);
                }
                throw th;
            }
        }
        return Primitive.O00000Oo(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean):java.lang.Object
     arg types: [_m_j.kv, bsh.Interpreter, int]
     candidates:
      bsh.Name.O000000o(java.lang.String, java.lang.String, java.lang.Object):java.lang.Object
      bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean):java.lang.Object */
    private Object O00000o(String str) throws EvalError {
        try {
            NameSpace nameSpace = this.globalNameSpace;
            return Primitive.O00000Oo(nameSpace.O00000oO(str).O000000o(new kv(nameSpace), this, false));
        } catch (UtilEvalError e) {
            throw e.toEvalError(SimpleNode.O00000Oo, new kv());
        }
    }

    public final kt O00000o0() {
        return this.globalNameSpace.O00000o();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        la laVar = this.console;
        if (laVar != null) {
            this.O0000Oo0 = laVar.O000000o();
            this.O0000Oo = this.console.O00000Oo();
            return;
        }
        this.O0000Oo0 = System.out;
        this.O0000Oo = System.err;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        java.lang.System.err.println("Can't redirect output to file: ".concat(java.lang.String.valueOf(r0)));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003d */
    static {
        PrintStream printStream;
        String valueOf;
        String str;
        try {
            O00000oO = System.getProperty("line.separator");
            O00000o = System.err;
            f3062O000000o = Boolean.getBoolean("debug");
            O00000Oo = Boolean.getBoolean("trace");
            O00000o0 = Boolean.getBoolean("localscoping");
            String property = System.getProperty("outfile");
            if (property != null) {
                PrintStream printStream2 = new PrintStream(new FileOutputStream(property));
                System.setOut(printStream2);
                System.setErr(printStream2);
                return;
            }
            return;
        } catch (SecurityException e) {
            printStream = System.err;
            valueOf = String.valueOf(e);
            str = "Could not init static:";
        } catch (Exception e2) {
            printStream = System.err;
            valueOf = String.valueOf(e2);
            str = "Could not init static(2):";
        } catch (Throwable th) {
            printStream = System.err;
            valueOf = String.valueOf(th);
            str = "Could not init static(3):";
        }
        printStream.println(str.concat(valueOf));
    }
}
