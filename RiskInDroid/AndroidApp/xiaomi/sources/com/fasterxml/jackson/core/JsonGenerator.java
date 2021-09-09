package com.fasterxml.jackson.core;

import _m_j.aii;
import _m_j.aij;
import _m_j.aim;
import _m_j.ain;
import _m_j.ais;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonGenerator implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected aim f3595O000000o;

    public abstract JsonGenerator O000000o();

    public JsonGenerator O000000o(ais ais) {
        return this;
    }

    public abstract void O000000o(char c) throws IOException, JsonGenerationException;

    public abstract void O000000o(double d) throws IOException, JsonGenerationException;

    public abstract void O000000o(float f) throws IOException, JsonGenerationException;

    public abstract void O000000o(int i) throws IOException, JsonGenerationException;

    public abstract void O000000o(long j) throws IOException, JsonGenerationException;

    public abstract void O000000o(aii aii, byte[] bArr, int i) throws IOException, JsonGenerationException;

    public abstract void O000000o(ain ain) throws IOException, JsonGenerationException;

    public abstract void O000000o(Object obj) throws IOException, JsonProcessingException;

    public abstract void O000000o(String str) throws IOException, JsonGenerationException;

    public abstract void O000000o(BigDecimal bigDecimal) throws IOException, JsonGenerationException;

    public abstract void O000000o(BigInteger bigInteger) throws IOException, JsonGenerationException;

    public abstract void O000000o(boolean z) throws IOException, JsonGenerationException;

    public abstract void O000000o(char[] cArr, int i) throws IOException, JsonGenerationException;

    public abstract void O000000o(char[] cArr, int i, int i2) throws IOException, JsonGenerationException;

    public abstract void O00000Oo() throws IOException, JsonGenerationException;

    public abstract void O00000Oo(ain ain) throws IOException, JsonGenerationException;

    public abstract void O00000Oo(String str) throws IOException, JsonGenerationException;

    public abstract void O00000o() throws IOException, JsonGenerationException;

    public abstract void O00000o(String str) throws IOException, JsonGenerationException;

    public abstract void O00000o0() throws IOException, JsonGenerationException;

    public abstract void O00000o0(String str) throws IOException, JsonGenerationException;

    public abstract void O00000oO() throws IOException, JsonGenerationException;

    public abstract void O00000oO(String str) throws IOException, JsonGenerationException, UnsupportedOperationException;

    public abstract void O00000oo() throws IOException, JsonGenerationException;

    public abstract void O0000O0o() throws IOException;

    public abstract void close() throws IOException;

    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false);
        
        private final boolean _defaultState;
        private final int _mask = (1 << ordinal());

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
            return this._mask;
        }
    }

    protected JsonGenerator() {
    }

    public final JsonGenerator O000000o(aim aim) {
        this.f3595O000000o = aim;
        return this;
    }

    public final void O000000o(byte[] bArr) throws IOException, JsonGenerationException {
        O000000o(aij.O000000o(), bArr, bArr.length);
    }

    public void O000000o(String str, String str2) throws IOException, JsonGenerationException {
        O000000o(str);
        O00000Oo(str2);
    }

    public final void O00000oo(String str) throws IOException, JsonGenerationException {
        O000000o(str);
        O00000o();
    }
}
