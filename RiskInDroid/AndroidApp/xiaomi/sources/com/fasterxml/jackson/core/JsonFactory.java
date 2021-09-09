package com.fasterxml.jackson.core;

import _m_j.ail;
import _m_j.ais;
import _m_j.ait;
import _m_j.aiu;
import _m_j.aiy;
import _m_j.ajd;
import _m_j.aje;
import _m_j.ajf;
import _m_j.ajg;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.BufferRecycler;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class JsonFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final int f3594O000000o = Feature.collectDefaults();
    protected static final int O00000Oo = JsonParser.Feature.collectDefaults();
    protected static final ThreadLocal<SoftReference<BufferRecycler>> O00000o = new ThreadLocal<>();
    protected static final int O00000o0 = JsonGenerator.Feature.collectDefaults();
    protected ajg O00000oO = ajg.O000000o();
    protected ajf O00000oo = new ajf();
    protected ail O0000O0o;
    protected int O0000OOo = f3594O000000o;
    protected int O0000Oo = O00000o0;
    protected int O0000Oo0 = O00000Oo;
    protected ais O0000OoO;
    protected aiu O0000Ooo;
    protected aiy O0000o00;

    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);
        
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

        public final boolean enabledIn(int i) {
            return (i & getMask()) != 0;
        }

        public final int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory(ail ail) {
        this.O0000O0o = ail;
    }

    private boolean O000000o(Feature feature) {
        return (feature.getMask() & this.O0000OOo) != 0;
    }

    public final JsonFactory O000000o(ail ail) {
        this.O0000O0o = ail;
        return this;
    }

    public ail O000000o() {
        return this.O0000O0o;
    }

    public final JsonParser O000000o(String str) throws IOException, JsonParseException {
        Reader stringReader = new StringReader(str);
        ait O000000o2 = O000000o(stringReader, true);
        aiu aiu = this.O0000Ooo;
        if (aiu != null) {
            stringReader = aiu.O000000o();
        }
        return new ajd(O000000o2, this.O0000Oo0, stringReader, this.O0000O0o, this.O00000oO.O000000o(O000000o(Feature.CANONICALIZE_FIELD_NAMES), O000000o(Feature.INTERN_FIELD_NAMES)));
    }

    public final JsonGenerator O000000o(Writer writer) throws IOException {
        ait O000000o2 = O000000o(writer, false);
        aiy aiy = this.O0000o00;
        if (aiy != null) {
            writer = aiy.O000000o();
        }
        aje aje = new aje(O000000o2, this.O0000Oo, this.O0000O0o, writer);
        ais ais = this.O0000OoO;
        if (ais != null) {
            aje.O000000o(ais);
        }
        return aje;
    }

    private static ait O000000o(Object obj, boolean z) {
        return new ait(O00000Oo(), obj, z);
    }

    public static BufferRecycler O00000Oo() {
        BufferRecycler bufferRecycler;
        SoftReference softReference = O00000o.get();
        if (softReference == null) {
            bufferRecycler = null;
        } else {
            bufferRecycler = (BufferRecycler) softReference.get();
        }
        if (bufferRecycler != null) {
            return bufferRecycler;
        }
        BufferRecycler bufferRecycler2 = new BufferRecycler();
        O00000o.set(new SoftReference(bufferRecycler2));
        return bufferRecycler2;
    }
}
