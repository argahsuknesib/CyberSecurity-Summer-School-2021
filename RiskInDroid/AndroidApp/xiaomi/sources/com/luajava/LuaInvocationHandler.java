package com.luajava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LuaInvocationHandler implements InvocationHandler {
    private LuaState L;
    private LuaObject obj;
    private LuaObject print = this.L.getLuaObject("print");

    public LuaInvocationHandler(LuaObject luaObject) {
        this.obj = luaObject;
        this.L = luaObject.L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r3;
     */
    public Object invoke(Object obj2, Method method, Object[] objArr) throws LuaException {
        synchronized (this.obj.L) {
            String name = method.getName();
            LuaObject field = this.obj.getField(name);
            Object obj3 = null;
            if (field.isNil()) {
                return null;
            }
            Class<?> returnType = method.getReturnType();
            try {
                if (!returnType.equals(Void.class)) {
                    if (!returnType.equals(Void.TYPE)) {
                        obj3 = field.call(objArr);
                        if (obj3 != null && (obj3 instanceof Double)) {
                            obj3 = LuaState.convertLuaNumber((Double) obj3, returnType);
                        }
                        if (obj3 != null && (returnType.equals(Boolean.TYPE) || returnType.equals(Boolean.class))) {
                            Boolean bool = Boolean.FALSE;
                            return bool;
                        }
                    }
                }
                field.call(objArr);
            } catch (LuaException e) {
                LuaObject luaObject = this.print;
                luaObject.call(name + " " + e.getMessage());
            }
            if (obj3 != null) {
            }
        }
    }
}
