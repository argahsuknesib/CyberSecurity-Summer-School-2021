package _m_j;

import bsh.Capabilities;
import bsh.EvalError;
import bsh.ReflectError;
import bsh.UtilEvalError;
import java.lang.reflect.InvocationTargetException;

public abstract class kw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static kw f2157O000000o;

    public static kw O000000o() throws UtilEvalError {
        if (f2157O000000o == null) {
            try {
                f2157O000000o = (kw) Class.forName("bsh.ClassGeneratorImpl").newInstance();
            } catch (Exception e) {
                throw new Capabilities.Unavailable("ClassGenerator unavailable: ".concat(String.valueOf(e)));
            }
        }
        return f2157O000000o;
    }

    public abstract Class O00000Oo() throws EvalError;

    public abstract Object O00000o0() throws UtilEvalError, ReflectError, InvocationTargetException;
}
