package com.fasterxml.jackson.core;

import _m_j.aii;
import _m_j.ail;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonParser implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f3597O000000o;

    public enum NumberType {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    public abstract ail O000000o();

    public abstract byte[] O000000o(aii aii) throws IOException, JsonParseException;

    public abstract JsonToken O00000Oo() throws IOException, JsonParseException;

    public abstract JsonParser O00000o() throws IOException, JsonParseException;

    public abstract JsonToken O00000o0() throws IOException, JsonParseException;

    public abstract JsonToken O00000oO();

    public abstract String O00000oo() throws IOException, JsonParseException;

    public abstract JsonLocation O0000O0o();

    public abstract JsonLocation O0000OOo();

    public abstract void O0000Oo();

    public abstract String O0000OoO() throws IOException, JsonParseException;

    public abstract char[] O0000Ooo() throws IOException, JsonParseException;

    public abstract NumberType O0000o() throws IOException, JsonParseException;

    public abstract int O0000o0() throws IOException, JsonParseException;

    public abstract int O0000o00() throws IOException, JsonParseException;

    public abstract boolean O0000o0O();

    public abstract Number O0000o0o() throws IOException, JsonParseException;

    public abstract int O0000oOO() throws IOException, JsonParseException;

    public abstract long O0000oOo() throws IOException, JsonParseException;

    public abstract float O0000oo() throws IOException, JsonParseException;

    public abstract BigInteger O0000oo0() throws IOException, JsonParseException;

    public abstract double O0000ooO() throws IOException, JsonParseException;

    public abstract BigDecimal O0000ooo() throws IOException, JsonParseException;

    public long O000O00o() throws IOException, JsonParseException {
        return 0;
    }

    public abstract Object O00oOooO() throws IOException, JsonParseException;

    public int O00oOooo() throws IOException, JsonParseException {
        return 0;
    }

    public abstract void close() throws IOException;

    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false);
        
        private final boolean _defaultState;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._defaultState = z;
        }

        public final boolean enabledByDefault() {
            return this._defaultState;
        }

        public final int getMask() {
            return 1 << ordinal();
        }
    }

    protected JsonParser() {
    }

    protected JsonParser(int i) {
        this.f3597O000000o = 0;
    }

    public boolean O000000o(Feature feature) {
        return (feature.getMask() & this.f3597O000000o) != 0;
    }

    public final boolean O0000Oo0() {
        return O00000oO() == JsonToken.START_ARRAY;
    }

    public byte O0000oO0() throws IOException, JsonParseException {
        int O0000oOO = O0000oOO();
        if (O0000oOO >= -128 && O0000oOO <= 255) {
            return (byte) O0000oOO;
        }
        throw O000000o("Numeric value (" + O0000OoO() + ") out of range of Java byte");
    }

    public short O0000oO() throws IOException, JsonParseException {
        int O0000oOO = O0000oOO();
        if (O0000oOO >= -32768 && O0000oOO <= 32767) {
            return (short) O0000oOO;
        }
        throw O000000o("Numeric value (" + O0000OoO() + ") out of range of Java short");
    }

    /* access modifiers changed from: protected */
    public final JsonParseException O000000o(String str) {
        return new JsonParseException(str, O0000OOo());
    }
}
