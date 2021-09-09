package bsh;

import _m_j.kv;
import _m_j.ld;
import android.support.v4.app.NotificationCompat;

class BSHAssignment extends SimpleNode implements ld {
    public int operator;

    BSHAssignment() {
        super(13);
    }

    private static Object O000000o(Object obj, Object obj2, int i) throws UtilEvalError {
        if (!(obj instanceof String) || obj2 == Primitive.O00000o0) {
            boolean z = obj instanceof Primitive;
            if (z || (obj2 instanceof Primitive)) {
                if (obj == Primitive.O00000o0 || obj2 == Primitive.O00000o0) {
                    throw new UtilEvalError("Illegal use of undefined object or 'void' literal");
                } else if (obj == Primitive.O00000Oo || obj2 == Primitive.O00000Oo) {
                    throw new UtilEvalError("Illegal use of null object or 'null' literal");
                }
            }
            if (((obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Number) || z) && ((obj2 instanceof Boolean) || (obj2 instanceof Character) || (obj2 instanceof Number) || (obj2 instanceof Primitive))) {
                return Primitive.O000000o(obj, obj2, i);
            }
            StringBuffer stringBuffer = new StringBuffer("Non primitive value in operator: ");
            stringBuffer.append(obj.getClass());
            stringBuffer.append(" ");
            stringBuffer.append(ld.a_[i]);
            stringBuffer.append(" ");
            stringBuffer.append(obj2.getClass());
            throw new UtilEvalError(stringBuffer.toString());
        } else if (i == 102) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append((String) obj);
            stringBuffer2.append(obj2);
            return stringBuffer2.toString();
        } else {
            throw new UtilEvalError("Use of non + operator with String LHS");
        }
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        BSHPrimaryExpression bSHPrimaryExpression = (BSHPrimaryExpression) O000000o(0);
        if (bSHPrimaryExpression != null) {
            boolean z = interpreter.strictJava;
            LHS O00000Oo = bSHPrimaryExpression.O00000Oo(kvVar, interpreter);
            if (O00000Oo != null) {
                Object obj = null;
                if (this.operator != 81) {
                    try {
                        obj = O00000Oo.O000000o();
                    } catch (UtilEvalError e) {
                        throw e.toEvalError(this, kvVar);
                    }
                }
                Object O000000o2 = ((SimpleNode) O000000o(1)).O000000o(kvVar, interpreter);
                if (O000000o2 != Primitive.O00000o0) {
                    try {
                        int i = this.operator;
                        if (i == 81) {
                            return O00000Oo.O000000o(O000000o2, z);
                        }
                        switch (i) {
                            case 118:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 102), z);
                            case 119:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 103), z);
                            case 120:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 104), z);
                            case 121:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 105), z);
                            case 122:
                            case 123:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 106), z);
                            case 124:
                            case 125:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 108), z);
                            case 126:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 110), z);
                            case 127:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 111), z);
                            case NotificationCompat.FLAG_HIGH_PRIORITY:
                            case 129:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 112), z);
                            case 130:
                            case 131:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 114), z);
                            case 132:
                            case 133:
                                return O00000Oo.O000000o(O000000o(obj, O000000o2, 116), z);
                            default:
                                throw new InterpreterError("unimplemented operator in assignment BSH");
                        }
                    } catch (UtilEvalError e2) {
                        throw e2.toEvalError(this, kvVar);
                    }
                } else {
                    throw new EvalError("Void assignment.", this, kvVar);
                }
            } else {
                throw new InterpreterError("Error, null LHS");
            }
        } else {
            throw new InterpreterError("Error, null LHSnode");
        }
    }
}
