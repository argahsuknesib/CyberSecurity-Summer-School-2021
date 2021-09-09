package bsh;

import _m_j.kt;
import _m_j.ky;
import _m_j.ld;
import _m_j.lg;
import _m_j.lh;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

public class LHS implements ld, Serializable {
    Field field;
    int index;
    boolean localVar;
    NameSpace nameSpace;
    Object object;
    String propName;
    int type;
    String varName;

    public LHS(NameSpace nameSpace2, String str, boolean z) {
        this.type = 0;
        this.localVar = z;
        this.varName = str;
        this.nameSpace = nameSpace2;
    }

    LHS(Object obj, int i) {
        if (obj != null) {
            this.type = 3;
            this.object = obj;
            this.index = i;
            return;
        }
        throw new NullPointerException("constructed empty LHS");
    }

    public LHS(Object obj, String str) {
        if (obj != null) {
            this.type = 2;
            this.object = obj;
            this.propName = str;
            return;
        }
        throw new NullPointerException("constructed empty LHS");
    }

    public LHS(Object obj, Field field2) {
        if (obj != null) {
            this.type = 1;
            this.object = obj;
            this.field = field2;
            return;
        }
        throw new NullPointerException("constructed empty LHS");
    }

    LHS(Field field2) {
        this.type = 1;
        this.object = null;
        this.field = field2;
    }

    public final Object O000000o() throws UtilEvalError {
        int i = this.type;
        if (i == 0) {
            return this.nameSpace.O00000o0(this.varName);
        }
        if (i == 1) {
            try {
                return Primitive.O000000o(this.field.get(this.object), this.field.getType());
            } catch (IllegalAccessException unused) {
                StringBuffer stringBuffer = new StringBuffer("Can't read field: ");
                stringBuffer.append(this.field);
                throw new UtilEvalError(stringBuffer.toString());
            }
        } else if (i == 2) {
            try {
                return lg.O00000o0(this.object, this.propName);
            } catch (ReflectError e) {
                Interpreter.O00000Oo(e.getMessage());
                StringBuffer stringBuffer2 = new StringBuffer("No such property: ");
                stringBuffer2.append(this.propName);
                throw new UtilEvalError(stringBuffer2.toString());
            }
        } else if (i == 3) {
            try {
                return lg.O000000o(this.object, this.index);
            } catch (Exception e2) {
                throw new UtilEvalError("Array access: ".concat(String.valueOf(e2)));
            }
        } else {
            throw new InterpreterError("LHS type");
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer("LHS: ");
        String str3 = "";
        if (this.field != null) {
            StringBuffer stringBuffer2 = new StringBuffer("field = ");
            stringBuffer2.append(this.field.toString());
            str = stringBuffer2.toString();
        } else {
            str = str3;
        }
        stringBuffer.append(str);
        if (this.varName != null) {
            StringBuffer stringBuffer3 = new StringBuffer(" varName = ");
            stringBuffer3.append(this.varName);
            str2 = stringBuffer3.toString();
        } else {
            str2 = str3;
        }
        stringBuffer.append(str2);
        if (this.nameSpace != null) {
            StringBuffer stringBuffer4 = new StringBuffer(" nameSpace = ");
            stringBuffer4.append(this.nameSpace.toString());
            str3 = stringBuffer4.toString();
        }
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method
     arg types: [?[OBJECT, ARRAY], java.lang.Class<?>, java.lang.Object, java.lang.String, java.lang.Object[], int]
     candidates:
      _m_j.lg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[], bsh.Interpreter, _m_j.kv, bsh.SimpleNode):java.lang.Object
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0179, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017a, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0179 A[ExcHandler: UtilTargetError (r10v2 'e' bsh.UtilTargetError A[CUSTOM_DECLARE]), Splitter:B:50:0x012e] */
    public final Object O000000o(Object obj, boolean z) throws UtilEvalError {
        int i = this.type;
        if (i == 0) {
            if (this.localVar) {
                this.nameSpace.O00000Oo(this.varName, obj, z);
            } else {
                this.nameSpace.O000000o(this.varName, obj, z);
            }
        } else if (i == 1) {
            try {
                Object O000000o2 = obj instanceof Primitive ? ((Primitive) obj).O000000o() : obj;
                lh.O000000o();
                this.field.set(this.object, O000000o2);
                return obj;
            } catch (NullPointerException unused) {
                StringBuffer stringBuffer = new StringBuffer("LHS (");
                stringBuffer.append(this.field.getName());
                stringBuffer.append(") not a static field.");
                throw new UtilEvalError(stringBuffer.toString());
            } catch (IllegalAccessException e) {
                StringBuffer stringBuffer2 = new StringBuffer("LHS (");
                stringBuffer2.append(this.field.getName());
                stringBuffer2.append(") can't access field: ");
                stringBuffer2.append(e);
                throw new UtilEvalError(stringBuffer2.toString());
            } catch (IllegalArgumentException unused2) {
                String name = (obj instanceof Primitive ? ((Primitive) obj).O00000Oo() : obj.getClass()).getName();
                StringBuffer stringBuffer3 = new StringBuffer("Argument type mismatch. ");
                if (obj == null) {
                    name = "null";
                }
                stringBuffer3.append(name);
                stringBuffer3.append(" not assignable to field ");
                stringBuffer3.append(this.field.getName());
                throw new UtilEvalError(stringBuffer3.toString());
            }
        } else if (i == 2) {
            ky.O000000o();
            Object obj2 = this.object;
            if (obj2 instanceof Hashtable) {
                ((Hashtable) obj2).put(this.propName, obj);
            } else {
                try {
                    String O000000o3 = lg.O000000o("set", this.propName);
                    Object[] objArr = {obj};
                    Interpreter.O00000Oo("property access: ");
                    lg.O000000o(lg.O000000o((kt) null, (Class) obj2.getClass(), obj2, O000000o3, objArr, false), obj2, objArr);
                } catch (InvocationTargetException e2) {
                    StringBuffer stringBuffer4 = new StringBuffer("Property accessor threw exception: ");
                    stringBuffer4.append(e2.getTargetException());
                    throw new UtilEvalError(stringBuffer4.toString());
                } catch (ReflectError e3) {
                    StringBuffer stringBuffer5 = new StringBuffer("Assignment: ");
                    stringBuffer5.append(e3.getMessage());
                    Interpreter.O00000Oo(stringBuffer5.toString());
                    StringBuffer stringBuffer6 = new StringBuffer("No such property: ");
                    stringBuffer6.append(this.propName);
                    throw new UtilEvalError(stringBuffer6.toString());
                }
            }
        } else if (i == 3) {
            try {
                Array.set(this.object, this.index, Primitive.O00000Oo(obj));
            } catch (ArrayStoreException e4) {
                throw new UtilTargetError(e4);
            } catch (IllegalArgumentException e5) {
                throw new UtilTargetError(new ArrayStoreException(e5.toString()));
            } catch (Exception e6) {
                throw new ReflectError("Array access:".concat(String.valueOf(e6)));
            } catch (UtilTargetError e7) {
            } catch (Exception e8) {
                StringBuffer stringBuffer7 = new StringBuffer("Assignment: ");
                stringBuffer7.append(e8.getMessage());
                throw new UtilEvalError(stringBuffer7.toString());
            }
        } else {
            throw new InterpreterError("unknown lhs");
        }
        return obj;
    }
}
