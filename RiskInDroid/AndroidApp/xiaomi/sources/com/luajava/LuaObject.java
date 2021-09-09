package com.luajava;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

public class LuaObject {
    protected LuaState L;
    protected int ref;

    protected LuaObject(LuaState luaState, String str) {
        synchronized (luaState) {
            this.L = luaState;
            luaState.getGlobal(str);
            registerValue(-1);
            luaState.pop(1);
        }
    }

    protected LuaObject(LuaObject luaObject, String str) throws LuaException {
        synchronized (luaObject.getLuaState()) {
            this.L = luaObject.getLuaState();
            if (!luaObject.isTable()) {
                if (!luaObject.isUserdata()) {
                    throw new LuaException("Object parent should be a table or userdata .");
                }
            }
            luaObject.push();
            this.L.pushString(str);
            this.L.getTable(-2);
            this.L.remove(-2);
            registerValue(-1);
            this.L.pop(1);
        }
    }

    protected LuaObject(LuaObject luaObject, Number number) throws LuaException {
        synchronized (luaObject.getLuaState()) {
            this.L = luaObject.getLuaState();
            if (!luaObject.isTable()) {
                if (!luaObject.isUserdata()) {
                    throw new LuaException("Object parent should be a table or userdata .");
                }
            }
            luaObject.push();
            this.L.pushNumber(number.doubleValue());
            this.L.getTable(-2);
            this.L.remove(-2);
            registerValue(-1);
            this.L.pop(1);
        }
    }

    protected LuaObject(LuaObject luaObject, LuaObject luaObject2) throws LuaException {
        if (luaObject.getLuaState() == luaObject2.getLuaState()) {
            synchronized (luaObject.getLuaState()) {
                if (!luaObject.isTable()) {
                    if (!luaObject.isUserdata()) {
                        throw new LuaException("Object parent should be a table or userdata .");
                    }
                }
                this.L = luaObject.getLuaState();
                luaObject.push();
                luaObject2.push();
                this.L.getTable(-2);
                this.L.remove(-2);
                registerValue(-1);
                this.L.pop(1);
            }
            return;
        }
        throw new LuaException("LuaStates must be the same!");
    }

    protected LuaObject(LuaState luaState, int i) {
        synchronized (luaState) {
            this.L = luaState;
            registerValue(i);
        }
    }

    public LuaState getLuaState() {
        return this.L;
    }

    /* access modifiers changed from: protected */
    public void registerValue(int i) {
        synchronized (this.L) {
            this.L.pushValue(i);
            this.ref = this.L.Lref(-1001000);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            synchronized (this.L) {
                if (this.L.getCPtrPeer() != 0) {
                    this.L.LunRef(-1001000, this.ref);
                }
            }
        } catch (Exception unused) {
            PrintStream printStream = System.err;
            printStream.println("Unable to release object " + this.ref);
        }
    }

    public void push() {
        this.L.rawGetI(-1001000, (long) this.ref);
    }

    public boolean isNil() {
        boolean isNil;
        synchronized (this.L) {
            push();
            isNil = this.L.isNil(-1);
            this.L.pop(1);
        }
        return isNil;
    }

    public boolean isBoolean() {
        boolean isBoolean;
        synchronized (this.L) {
            push();
            isBoolean = this.L.isBoolean(-1);
            this.L.pop(1);
        }
        return isBoolean;
    }

    public boolean isNumber() {
        boolean isNumber;
        synchronized (this.L) {
            push();
            isNumber = this.L.isNumber(-1);
            this.L.pop(1);
        }
        return isNumber;
    }

    public boolean isString() {
        boolean isString;
        synchronized (this.L) {
            push();
            isString = this.L.isString(-1);
            this.L.pop(1);
        }
        return isString;
    }

    public boolean isFunction() {
        boolean isFunction;
        synchronized (this.L) {
            push();
            isFunction = this.L.isFunction(-1);
            this.L.pop(1);
        }
        return isFunction;
    }

    public boolean isJavaObject() {
        boolean isObject;
        synchronized (this.L) {
            push();
            isObject = this.L.isObject(-1);
            this.L.pop(1);
        }
        return isObject;
    }

    public boolean isJavaFunction() {
        boolean isJavaFunction;
        synchronized (this.L) {
            push();
            isJavaFunction = this.L.isJavaFunction(-1);
            this.L.pop(1);
        }
        return isJavaFunction;
    }

    public boolean isTable() {
        boolean isTable;
        synchronized (this.L) {
            push();
            isTable = this.L.isTable(-1);
            this.L.pop(1);
        }
        return isTable;
    }

    public boolean isUserdata() {
        boolean isUserdata;
        synchronized (this.L) {
            push();
            isUserdata = this.L.isUserdata(-1);
            this.L.pop(1);
        }
        return isUserdata;
    }

    public int type() {
        int type;
        synchronized (this.L) {
            push();
            type = this.L.type(-1);
            this.L.pop(1);
        }
        return type;
    }

    public boolean getBoolean() {
        boolean z;
        synchronized (this.L) {
            push();
            z = this.L.toBoolean(-1);
            this.L.pop(1);
        }
        return z;
    }

    public double getNumber() {
        double number;
        synchronized (this.L) {
            push();
            number = this.L.toNumber(-1);
            this.L.pop(1);
        }
        return number;
    }

    public String getString() {
        String luaState;
        synchronized (this.L) {
            push();
            luaState = this.L.toString(-1);
            this.L.pop(1);
        }
        return luaState;
    }

    public Object getObject() throws LuaException {
        Object objectFromUserdata;
        synchronized (this.L) {
            push();
            objectFromUserdata = this.L.getObjectFromUserdata(-1);
            this.L.pop(1);
        }
        return objectFromUserdata;
    }

    public LuaObject getField(String str) throws LuaException {
        return this.L.getLuaObject(this, str);
    }

    public void setField(String str, Object obj) {
        push();
        try {
            this.L.pushObjectValue(obj);
        } catch (LuaException unused) {
            this.L.pushNil();
        }
        this.L.setField(-2, str);
        this.L.pop(1);
    }

    public LuaObject getI(long j) throws LuaException {
        return this.L.getLuaObject(this, Long.valueOf(j));
    }

    public void setI(long j, Object obj) {
        push();
        try {
            this.L.pushObjectValue(obj);
        } catch (LuaException unused) {
            this.L.pushNil();
        }
        this.L.setI(-2, j);
        this.L.pop(1);
    }

    public Object[] callx(Object[] objArr, int i) throws LuaException {
        int i2;
        Object[] objArr2;
        String str;
        String str2;
        synchronized (this.L) {
            if (!isFunction() && !isTable()) {
                if (!isUserdata()) {
                    throw new LuaException("Invalid object. Not a function, table or userdata .");
                }
            }
            int top = this.L.getTop();
            push();
            if (objArr != null) {
                for (Object pushObjectValue : objArr) {
                    this.L.pushObjectValue(pushObjectValue);
                }
            } else {
                i2 = 0;
            }
            int pcall = this.L.pcall(i2, i, 0);
            if (pcall != 0) {
                if (this.L.isString(-1)) {
                    str = this.L.toString(-1);
                    this.L.pop(1);
                } else {
                    str = "";
                }
                if (pcall == 2) {
                    str2 = "Runtime error. ".concat(String.valueOf(str));
                } else if (pcall == 4) {
                    str2 = "Memory allocation error. ".concat(String.valueOf(str));
                } else if (pcall == 6) {
                    str2 = "Error while running the error handler function. ".concat(String.valueOf(str));
                } else {
                    str2 = "Lua Error code " + pcall + ". " + str;
                }
                throw new LuaException(str2);
            }
            if (i == -1) {
                i = this.L.getTop() - top;
            }
            if (this.L.getTop() - top >= i) {
                objArr2 = new Object[i];
                while (i > 0) {
                    objArr2[i - 1] = this.L.toJavaObject(-1);
                    this.L.pop(1);
                    i--;
                }
            } else {
                throw new LuaException("Invalid Number of Results .");
            }
        }
        return objArr2;
    }

    public Object call(Object... objArr) throws LuaException {
        return callx(objArr, 1)[0];
    }

    public byte[] dump() throws LuaException {
        byte[] dump;
        synchronized (this.L) {
            if (isFunction()) {
                push();
                dump = this.L.dump(-1);
                this.L.pop(1);
            } else {
                throw new LuaException("Invalid object. Not a function .");
            }
        }
        return dump;
    }

    public Object[] asArray() throws IllegalArgumentException, ArrayIndexOutOfBoundsException, LuaException {
        Object[] objArr;
        synchronized (this.L) {
            if (isTable()) {
                push();
                int objLen = this.L.objLen(-1);
                Object newInstance = Array.newInstance(Object.class, objLen);
                for (int i = 1; i <= objLen; i++) {
                    this.L.pushInteger((long) i);
                    this.L.getTable(-2);
                    Array.set(newInstance, i - 1, this.L.toJavaObject(-1));
                    this.L.pop(1);
                }
                this.L.pop(1);
                objArr = (Object[]) newInstance;
            } else {
                throw new LuaException("Invalid object. Not a table .");
            }
        }
        return objArr;
    }

    public String toString() {
        synchronized (this.L) {
            try {
                if (isNil()) {
                    return "nil";
                }
                if (isBoolean()) {
                    String valueOf = String.valueOf(getBoolean());
                    return valueOf;
                } else if (isNumber()) {
                    String valueOf2 = String.valueOf(getNumber());
                    return valueOf2;
                } else if (isString()) {
                    String string = getString();
                    return string;
                } else if (isFunction()) {
                    return "Lua Function";
                } else {
                    if (isJavaObject()) {
                        String obj = getObject().toString();
                        return obj;
                    } else if (isUserdata()) {
                        return "Userdata";
                    } else {
                        if (isTable()) {
                            return "Lua Table";
                        }
                        if (isJavaFunction()) {
                            return "Java Function";
                        }
                        return null;
                    }
                }
            } catch (LuaException unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object createProxy(String str) throws ClassNotFoundException, LuaException {
        Object newProxyInstance;
        synchronized (this.L) {
            if (isTable()) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                Class[] clsArr = new Class[stringTokenizer.countTokens()];
                int i = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    clsArr[i] = Class.forName(stringTokenizer.nextToken());
                    i++;
                }
                newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new LuaInvocationHandler(this));
            } else {
                throw new LuaException("Invalid Object. Must be Table.");
            }
        }
        return newProxyInstance;
    }

    public Object createProxy(Class cls) throws LuaException {
        Object newProxyInstance;
        synchronized (this.L) {
            if (isTable()) {
                newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new LuaInvocationHandler(this));
            } else {
                throw new LuaException("Invalid Object. Must be Table.");
            }
        }
        return newProxyInstance;
    }
}
