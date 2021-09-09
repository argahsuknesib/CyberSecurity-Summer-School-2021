package com.luajava;

public class LuaState {
    private CPtr luaState;
    private int stateId;

    private native synchronized int _LargError(CPtr cPtr, int i, String str);

    private native synchronized int _LcallMeta(CPtr cPtr, int i, String str);

    private native synchronized void _LcheckAny(CPtr cPtr, int i);

    private native synchronized int _LcheckInteger(CPtr cPtr, int i);

    private native synchronized double _LcheckNumber(CPtr cPtr, int i);

    private native synchronized void _LcheckStack(CPtr cPtr, int i, String str);

    private native synchronized String _LcheckString(CPtr cPtr, int i);

    private native synchronized void _LcheckType(CPtr cPtr, int i, int i2);

    private native synchronized int _LdoFile(CPtr cPtr, String str);

    private native synchronized int _LdoString(CPtr cPtr, String str);

    private native synchronized int _LgetMetaField(CPtr cPtr, int i, String str);

    private native synchronized void _LgetMetatable(CPtr cPtr, String str);

    private native synchronized String _Lgsub(CPtr cPtr, String str, String str2, String str3);

    private native synchronized int _LloadBuffer(CPtr cPtr, byte[] bArr, long j, String str);

    private native synchronized int _LloadFile(CPtr cPtr, String str);

    private native synchronized int _LloadString(CPtr cPtr, String str);

    private native synchronized int _LnewMetatable(CPtr cPtr, String str);

    private native synchronized int _LoptInteger(CPtr cPtr, int i, int i2);

    private native synchronized double _LoptNumber(CPtr cPtr, int i, double d);

    private native synchronized String _LoptString(CPtr cPtr, int i, String str);

    private native synchronized int _Lref(CPtr cPtr, int i);

    private native synchronized void _LunRef(CPtr cPtr, int i, int i2);

    private native synchronized void _Lwhere(CPtr cPtr, int i);

    private native synchronized void _call(CPtr cPtr, int i, int i2);

    private native synchronized int _checkStack(CPtr cPtr, int i);

    private native synchronized void _close(CPtr cPtr);

    private native synchronized int _compare(CPtr cPtr, int i, int i2, int i3);

    private native synchronized void _concat(CPtr cPtr, int i);

    private native synchronized void _copy(CPtr cPtr, int i, int i2);

    private native synchronized void _createTable(CPtr cPtr, int i, int i2);

    private native synchronized byte[] _dump(CPtr cPtr, int i);

    private native synchronized int _equal(CPtr cPtr, int i, int i2);

    private native synchronized int _error(CPtr cPtr);

    private native synchronized int _gc(CPtr cPtr, int i, int i2);

    private native synchronized int _getField(CPtr cPtr, int i, String str);

    private native synchronized int _getGlobal(CPtr cPtr, String str);

    private native synchronized int _getI(CPtr cPtr, int i, long j);

    private native synchronized int _getMetaTable(CPtr cPtr, int i);

    private native synchronized Object _getObjectFromUserdata(CPtr cPtr, int i) throws LuaException;

    private native synchronized int _getTable(CPtr cPtr, int i);

    private native synchronized int _getTop(CPtr cPtr);

    private native synchronized String _getUpValue(CPtr cPtr, int i, int i2);

    private native synchronized int _getUserValue(CPtr cPtr, int i);

    private native synchronized void _insert(CPtr cPtr, int i);

    private native synchronized int _isBoolean(CPtr cPtr, int i);

    private native synchronized int _isCFunction(CPtr cPtr, int i);

    private native synchronized int _isFunction(CPtr cPtr, int i);

    private native synchronized int _isInteger(CPtr cPtr, int i);

    private native synchronized boolean _isJavaFunction(CPtr cPtr, int i);

    private native synchronized int _isNil(CPtr cPtr, int i);

    private native synchronized int _isNone(CPtr cPtr, int i);

    private native synchronized int _isNoneOrNil(CPtr cPtr, int i);

    private native synchronized int _isNumber(CPtr cPtr, int i);

    private native synchronized boolean _isObject(CPtr cPtr, int i);

    private native synchronized int _isString(CPtr cPtr, int i);

    private native synchronized int _isTable(CPtr cPtr, int i);

    private native synchronized int _isThread(CPtr cPtr, int i);

    private native synchronized int _isUserdata(CPtr cPtr, int i);

    private native synchronized int _isYieldable(CPtr cPtr);

    private native synchronized int _lessThan(CPtr cPtr, int i, int i2);

    private native synchronized void _newTable(CPtr cPtr);

    private native synchronized CPtr _newstate();

    private native synchronized CPtr _newthread(CPtr cPtr);

    private native synchronized int _next(CPtr cPtr, int i);

    private native synchronized int _objlen(CPtr cPtr, int i);

    private native synchronized void _openBase(CPtr cPtr);

    private native synchronized void _openDebug(CPtr cPtr);

    private native synchronized void _openIo(CPtr cPtr);

    private native synchronized void _openLibs(CPtr cPtr);

    private native synchronized void _openLuajava(CPtr cPtr, int i);

    private native synchronized void _openMath(CPtr cPtr);

    private native synchronized void _openOs(CPtr cPtr);

    private native synchronized void _openPackage(CPtr cPtr);

    private native synchronized void _openString(CPtr cPtr);

    private native synchronized void _openTable(CPtr cPtr);

    private native synchronized int _pcall(CPtr cPtr, int i, int i2, int i3);

    private native synchronized void _pop(CPtr cPtr, int i);

    private native synchronized void _pushBoolean(CPtr cPtr, int i);

    private native synchronized void _pushInteger(CPtr cPtr, long j);

    private native synchronized void _pushJavaFunction(CPtr cPtr, JavaFunction javaFunction) throws LuaException;

    private native synchronized void _pushJavaObject(CPtr cPtr, Object obj);

    private native synchronized void _pushNil(CPtr cPtr);

    private native synchronized void _pushNumber(CPtr cPtr, double d);

    private native synchronized void _pushString(CPtr cPtr, String str);

    private native synchronized void _pushString(CPtr cPtr, byte[] bArr, int i);

    private native synchronized void _pushValue(CPtr cPtr, int i);

    private native synchronized int _rawGet(CPtr cPtr, int i);

    private native synchronized int _rawGetI(CPtr cPtr, int i, long j);

    private native synchronized void _rawSet(CPtr cPtr, int i);

    private native synchronized void _rawSetI(CPtr cPtr, int i, long j);

    private native synchronized int _rawequal(CPtr cPtr, int i, int i2);

    private native synchronized int _rawlen(CPtr cPtr, int i);

    private native synchronized void _remove(CPtr cPtr, int i);

    private native synchronized void _replace(CPtr cPtr, int i);

    private native synchronized int _resume(CPtr cPtr, CPtr cPtr2, int i);

    private native synchronized void _rotate(CPtr cPtr, int i, int i2);

    private native synchronized void _setField(CPtr cPtr, int i, String str);

    private native synchronized void _setGlobal(CPtr cPtr, String str);

    private native synchronized void _setI(CPtr cPtr, int i, long j);

    private native synchronized int _setMetaTable(CPtr cPtr, int i);

    private native synchronized void _setTable(CPtr cPtr, int i);

    private native synchronized void _setTop(CPtr cPtr, int i);

    private native synchronized String _setUpValue(CPtr cPtr, int i, int i2);

    private native synchronized void _setUserValue(CPtr cPtr, int i);

    private native synchronized int _status(CPtr cPtr);

    private native synchronized int _strlen(CPtr cPtr, int i);

    private native synchronized int _toBoolean(CPtr cPtr, int i);

    private native synchronized long _toInteger(CPtr cPtr, int i);

    private native synchronized double _toNumber(CPtr cPtr, int i);

    private native synchronized String _toString(CPtr cPtr, int i);

    private native synchronized CPtr _toThread(CPtr cPtr, int i);

    private native synchronized int _type(CPtr cPtr, int i);

    private native synchronized String _typeName(CPtr cPtr, int i);

    private native synchronized void _xmove(CPtr cPtr, CPtr cPtr2, int i);

    private native synchronized int _yield(CPtr cPtr, int i);

    static {
        try {
            System.loadLibrary("luajava");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected LuaState(int i) {
        this.luaState = _newstate();
        this.stateId = i;
    }

    protected LuaState(CPtr cPtr) {
        this.luaState = cPtr;
        this.stateId = LuaStateFactory.insertLuaState(this);
    }

    public CPtr getCPtr() {
        return this.luaState;
    }

    public synchronized void close() {
        LuaStateFactory.removeLuaState(this.stateId);
        _close(this.luaState);
        this.luaState = null;
    }

    public synchronized boolean isClosed() {
        return this.luaState == null;
    }

    public long getCPtrPeer() {
        CPtr cPtr = this.luaState;
        if (cPtr != null) {
            return cPtr.getPeer();
        }
        return 0;
    }

    public LuaState newThread() {
        LuaState luaState2 = new LuaState(_newthread(this.luaState));
        LuaStateFactory.insertLuaState(luaState2);
        return luaState2;
    }

    public int getTop() {
        return _getTop(this.luaState);
    }

    public void setTop(int i) {
        _setTop(this.luaState, i);
    }

    public void pushValue(int i) {
        _pushValue(this.luaState, i);
    }

    public void rotate(int i, int i2) {
        _rotate(this.luaState, i, i2);
    }

    public void copy(int i, int i2) {
        _copy(this.luaState, i, i2);
    }

    public void remove(int i) {
        _remove(this.luaState, i);
    }

    public void insert(int i) {
        _insert(this.luaState, i);
    }

    public void replace(int i) {
        _replace(this.luaState, i);
    }

    public int checkStack(int i) {
        return _checkStack(this.luaState, i);
    }

    public void xmove(LuaState luaState2, int i) {
        _xmove(this.luaState, luaState2.luaState, i);
    }

    public boolean isNumber(int i) {
        return _isNumber(this.luaState, i) != 0;
    }

    public boolean isInteger(int i) {
        return _isInteger(this.luaState, i) != 0;
    }

    public boolean isString(int i) {
        return _isString(this.luaState, i) != 0;
    }

    public boolean isFunction(int i) {
        return _isFunction(this.luaState, i) != 0;
    }

    public boolean isCFunction(int i) {
        return _isCFunction(this.luaState, i) != 0;
    }

    public boolean isUserdata(int i) {
        return _isUserdata(this.luaState, i) != 0;
    }

    public boolean isTable(int i) {
        return _isTable(this.luaState, i) != 0;
    }

    public boolean isBoolean(int i) {
        return _isBoolean(this.luaState, i) != 0;
    }

    public boolean isNil(int i) {
        return _isNil(this.luaState, i) != 0;
    }

    public boolean isThread(int i) {
        return _isThread(this.luaState, i) != 0;
    }

    public boolean isNone(int i) {
        return _isNone(this.luaState, i) != 0;
    }

    public boolean isNoneOrNil(int i) {
        return _isNoneOrNil(this.luaState, i) != 0;
    }

    public int type(int i) {
        return _type(this.luaState, i);
    }

    public String typeName(int i) {
        return _typeName(this.luaState, i);
    }

    public int equal(int i, int i2) {
        return _equal(this.luaState, i, i2);
    }

    public int compare(int i, int i2, int i3) {
        return _compare(this.luaState, i, i2, i3);
    }

    public int rawequal(int i, int i2) {
        return _rawequal(this.luaState, i, i2);
    }

    public int lessThan(int i, int i2) {
        return _lessThan(this.luaState, i, i2);
    }

    public double toNumber(int i) {
        return _toNumber(this.luaState, i);
    }

    public long toInteger(int i) {
        return _toInteger(this.luaState, i);
    }

    public boolean toBoolean(int i) {
        return _toBoolean(this.luaState, i) != 0;
    }

    public String toString(int i) {
        return _toString(this.luaState, i);
    }

    public int strLen(int i) {
        return _strlen(this.luaState, i);
    }

    public int objLen(int i) {
        return _objlen(this.luaState, i);
    }

    public int rawLen(int i) {
        return _rawlen(this.luaState, i);
    }

    public LuaState toThread(int i) {
        return new LuaState(_toThread(this.luaState, i));
    }

    public void pushNil() {
        _pushNil(this.luaState);
    }

    public void pushNumber(double d) {
        _pushNumber(this.luaState, d);
    }

    public void pushInteger(long j) {
        _pushInteger(this.luaState, j);
    }

    public void pushString(String str) {
        if (str == null) {
            _pushNil(this.luaState);
        } else {
            _pushString(this.luaState, str);
        }
    }

    public void pushString(byte[] bArr) {
        if (bArr == null) {
            _pushNil(this.luaState);
        } else {
            _pushString(this.luaState, bArr, bArr.length);
        }
    }

    public void pushBoolean(boolean z) {
        _pushBoolean(this.luaState, z ? 1 : 0);
    }

    public void getTable(int i) {
        _getTable(this.luaState, i);
    }

    public int getField(int i, String str) {
        return _getField(this.luaState, i, str);
    }

    public int getI(int i, long j) {
        return _getI(this.luaState, i, j);
    }

    public int rawGet(int i) {
        return _rawGet(this.luaState, i);
    }

    public int rawGetI(int i, long j) {
        return _rawGetI(this.luaState, i, j);
    }

    public void createTable(int i, int i2) {
        _createTable(this.luaState, i, i2);
    }

    public void newTable() {
        _newTable(this.luaState);
    }

    public int getMetaTable(int i) {
        return _getMetaTable(this.luaState, i);
    }

    public int getUserValue(int i) {
        return _getUserValue(this.luaState, i);
    }

    public void setTable(int i) {
        _setTable(this.luaState, i);
    }

    public void setField(int i, String str) {
        _setField(this.luaState, i, str);
    }

    public void setI(int i, long j) {
        _setI(this.luaState, i, j);
    }

    public void rawSet(int i) {
        _rawSet(this.luaState, i);
    }

    public void rawSetI(int i, long j) {
        _rawSetI(this.luaState, i, j);
    }

    public int setMetaTable(int i) {
        return _setMetaTable(this.luaState, i);
    }

    public void setUserValue(int i) {
        _setUserValue(this.luaState, i);
    }

    public void call(int i, int i2) {
        _call(this.luaState, i, i2);
    }

    public int pcall(int i, int i2, int i3) {
        return _pcall(this.luaState, i, i2, i3);
    }

    public int yield(int i) {
        return _yield(this.luaState, i);
    }

    public int resume(LuaState luaState2, int i) {
        return _resume(this.luaState, luaState2.getCPtr(), i);
    }

    public int status() {
        return _status(this.luaState);
    }

    public int isYieldable() {
        return _isYieldable(this.luaState);
    }

    public int gc(int i, int i2) {
        return _gc(this.luaState, i, i2);
    }

    public int next(int i) {
        return _next(this.luaState, i);
    }

    public int error() {
        return _error(this.luaState);
    }

    public void concat(int i) {
        _concat(this.luaState, i);
    }

    public int LdoFile(String str) {
        return _LdoFile(this.luaState, str);
    }

    public int LdoString(String str) {
        return _LdoString(this.luaState, str);
    }

    public int LgetMetaField(int i, String str) {
        return _LgetMetaField(this.luaState, i, str);
    }

    public int LcallMeta(int i, String str) {
        return _LcallMeta(this.luaState, i, str);
    }

    public int LargError(int i, String str) {
        return _LargError(this.luaState, i, str);
    }

    public String LcheckString(int i) {
        return _LcheckString(this.luaState, i);
    }

    public String LoptString(int i, String str) {
        return _LoptString(this.luaState, i, str);
    }

    public double LcheckNumber(int i) {
        return _LcheckNumber(this.luaState, i);
    }

    public double LoptNumber(int i, double d) {
        return _LoptNumber(this.luaState, i, d);
    }

    public int LcheckInteger(int i) {
        return _LcheckInteger(this.luaState, i);
    }

    public int LoptInteger(int i, int i2) {
        return _LoptInteger(this.luaState, i, i2);
    }

    public void LcheckStack(int i, String str) {
        _LcheckStack(this.luaState, i, str);
    }

    public void LcheckType(int i, int i2) {
        _LcheckType(this.luaState, i, i2);
    }

    public void LcheckAny(int i) {
        _LcheckAny(this.luaState, i);
    }

    public int LnewMetatable(String str) {
        return _LnewMetatable(this.luaState, str);
    }

    public void LgetMetatable(String str) {
        _LgetMetatable(this.luaState, str);
    }

    public void Lwhere(int i) {
        _Lwhere(this.luaState, i);
    }

    public int Lref(int i) {
        return _Lref(this.luaState, i);
    }

    public void LunRef(int i, int i2) {
        _LunRef(this.luaState, i, i2);
    }

    public int LloadFile(String str) {
        return _LloadFile(this.luaState, str);
    }

    public int LloadString(String str) {
        return _LloadString(this.luaState, str);
    }

    public int LloadBuffer(byte[] bArr, String str) {
        return _LloadBuffer(this.luaState, bArr, (long) bArr.length, str);
    }

    public String Lgsub(String str, String str2, String str3) {
        return _Lgsub(this.luaState, str, str2, str3);
    }

    public String getUpValue(int i, int i2) {
        return _getUpValue(this.luaState, i, i2);
    }

    public String setUpValue(int i, int i2) {
        return _setUpValue(this.luaState, i, i2);
    }

    public byte[] dump(int i) {
        return _dump(this.luaState, i);
    }

    public void pop(int i) {
        _pop(this.luaState, i);
    }

    public synchronized int getGlobal(String str) {
        return _getGlobal(this.luaState, str);
    }

    public synchronized void setGlobal(String str) {
        _setGlobal(this.luaState, str);
    }

    public void openBase() {
        _openBase(this.luaState);
    }

    public void openTable() {
        _openTable(this.luaState);
    }

    public void openIo() {
        _openIo(this.luaState);
    }

    public void openOs() {
        _openOs(this.luaState);
    }

    public void openString() {
        _openString(this.luaState);
    }

    public void openMath() {
        _openMath(this.luaState);
    }

    public void openDebug() {
        _openDebug(this.luaState);
    }

    public void openPackage() {
        _openPackage(this.luaState);
    }

    public void openLibs() {
        _openLibs(this.luaState);
        _openLuajava(this.luaState, this.stateId);
        pushPrimitive();
    }

    public void openLuajava() {
        _openLuajava(this.luaState, this.stateId);
        pushPrimitive();
    }

    public Object getObjectFromUserdata(int i) throws LuaException {
        return _getObjectFromUserdata(this.luaState, i);
    }

    public boolean isObject(int i) {
        return _isObject(this.luaState, i);
    }

    public void pushJavaObject(Object obj) {
        _pushJavaObject(this.luaState, obj);
    }

    public void pushJavaFunction(JavaFunction javaFunction) throws LuaException {
        _pushJavaFunction(this.luaState, javaFunction);
    }

    public boolean isJavaFunction(int i) {
        return _isJavaFunction(this.luaState, i);
    }

    public void pushObjectValue(Object obj) throws LuaException {
        if (obj == null) {
            pushNil();
        } else if (obj instanceof Boolean) {
            pushBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            pushInteger(((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            pushInteger((long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            pushInteger((long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            pushInteger((long) ((Byte) obj).byteValue());
        } else if (obj instanceof Number) {
            pushNumber(((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            pushString((String) obj);
        } else if (obj instanceof JavaFunction) {
            pushJavaFunction((JavaFunction) obj);
        } else if (obj instanceof LuaObject) {
            ((LuaObject) obj).push();
        } else {
            pushJavaObject(obj);
        }
    }

    public synchronized Object toJavaObject(int i) throws LuaException {
        Object obj;
        obj = null;
        if (isBoolean(i)) {
            obj = Boolean.valueOf(toBoolean(i));
        } else if (type(i) == 4) {
            obj = toString(i);
        } else if (isFunction(i)) {
            obj = getLuaObject(i);
        } else if (isTable(i)) {
            obj = getLuaObject(i);
        } else if (type(i) == 3) {
            if (isInteger(i)) {
                obj = Long.valueOf(toInteger(i));
            } else {
                obj = Double.valueOf(toNumber(i));
            }
        } else if (!isUserdata(i)) {
            boolean isNil = isNil(i);
        } else if (isObject(i)) {
            obj = getObjectFromUserdata(i);
        } else {
            obj = getLuaObject(i);
        }
        return obj;
    }

    public LuaObject getLuaObject(String str) {
        return new LuaObject(this, str);
    }

    public LuaObject getLuaObject(LuaObject luaObject, String str) throws LuaException {
        if (luaObject.L.getCPtrPeer() == this.luaState.getPeer()) {
            return new LuaObject(luaObject, str);
        }
        throw new LuaException("Object must have the same LuaState as the parent!");
    }

    public LuaObject getLuaObject(LuaObject luaObject, Number number) throws LuaException {
        if (luaObject.L.getCPtrPeer() == this.luaState.getPeer()) {
            return new LuaObject(luaObject, number);
        }
        throw new LuaException("Object must have the same LuaState as the parent!");
    }

    public LuaObject getLuaObject(LuaObject luaObject, LuaObject luaObject2) throws LuaException {
        if (luaObject.getLuaState().getCPtrPeer() == this.luaState.getPeer() && luaObject.getLuaState().getCPtrPeer() == luaObject2.getLuaState().getCPtrPeer()) {
            return new LuaObject(luaObject, luaObject2);
        }
        throw new LuaException("Object must have the same LuaState as the parent!");
    }

    public LuaObject getLuaObject(int i) {
        return new LuaObject(this, i);
    }

    public static Number convertLuaNumber(Double d, Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(d.intValue());
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(d.longValue());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(d.floatValue());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(d.doubleValue());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(d.byteValue());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(d.shortValue());
            }
            return null;
        } else if (!cls.isAssignableFrom(Number.class)) {
            return null;
        } else {
            if (cls.isAssignableFrom(Integer.class)) {
                return new Integer(d.intValue());
            }
            if (cls.isAssignableFrom(Long.class)) {
                return new Long(d.longValue());
            }
            if (cls.isAssignableFrom(Float.class)) {
                return new Float(d.floatValue());
            }
            if (cls.isAssignableFrom(Double.class)) {
                return d;
            }
            if (cls.isAssignableFrom(Byte.class)) {
                return new Byte(d.byteValue());
            }
            if (cls.isAssignableFrom(Short.class)) {
                return new Short(d.shortValue());
            }
            return null;
        }
    }

    public static Number convertLuaNumber(Long l, Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(l.intValue());
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(l.longValue());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(l.floatValue());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(l.doubleValue());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(l.byteValue());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(l.shortValue());
            }
            return null;
        } else if (!cls.isAssignableFrom(Number.class)) {
            return null;
        } else {
            if (cls.isAssignableFrom(Integer.class)) {
                return new Integer(l.intValue());
            }
            if (cls.isAssignableFrom(Long.class)) {
                return new Long(l.longValue());
            }
            if (cls.isAssignableFrom(Float.class)) {
                return new Float(l.floatValue());
            }
            if (cls.isAssignableFrom(Double.class)) {
                return l;
            }
            if (cls.isAssignableFrom(Byte.class)) {
                return new Byte(l.byteValue());
            }
            if (cls.isAssignableFrom(Short.class)) {
                return new Short(l.shortValue());
            }
            return null;
        }
    }

    public void pushPrimitive() {
        pushJavaObject(Boolean.TYPE);
        setGlobal("boolean");
        pushJavaObject(Byte.TYPE);
        setGlobal("byte");
        pushJavaObject(Character.TYPE);
        setGlobal("char");
        pushJavaObject(Short.TYPE);
        setGlobal("short");
        pushJavaObject(Integer.TYPE);
        setGlobal("int");
        pushJavaObject(Long.TYPE);
        setGlobal("long");
        pushJavaObject(Float.TYPE);
        setGlobal("float");
        pushJavaObject(Double.TYPE);
        setGlobal("double");
    }
}
