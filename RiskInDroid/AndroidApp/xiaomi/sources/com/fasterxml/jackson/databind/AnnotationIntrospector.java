package com.fasterxml.jackson.databind;

import _m_j.ajv;
import _m_j.aki;
import _m_j.akr;
import _m_j.ani;
import _m_j.anj;
import _m_j.anl;
import _m_j.anm;
import _m_j.ann;
import _m_j.anp;
import _m_j.anz;
import _m_j.aoc;
import _m_j.aod;
import _m_j.aoh;
import _m_j.atb;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.annotation.Annotation;
import java.util.List;

public abstract class AnnotationIntrospector {
    public anz O000000o(ani ani) {
        return null;
    }

    public aoc<?> O000000o(anj anj, aoc<?> aoc) {
        return aoc;
    }

    public aoh<?> O000000o(akr<?> akr, anj anj, ajv ajv) {
        return null;
    }

    public aoh<?> O000000o(akr<?> akr, anm anm, ajv ajv) {
        return null;
    }

    public JsonInclude.Include O000000o(ani ani, JsonInclude.Include include) {
        return include;
    }

    public ReferenceProperty O000000o(anm anm) {
        return null;
    }

    public String O000000o(anj anj) {
        return null;
    }

    public String O000000o(anl anl) {
        return null;
    }

    public String O000000o(ann ann) {
        return null;
    }

    public String O000000o(anp anp) {
        return null;
    }

    public String O000000o(Enum<?> enumR) {
        return null;
    }

    public boolean O000000o(Annotation annotation) {
        return false;
    }

    public aoh<?> O00000Oo(akr<?> akr, anm anm, ajv ajv) {
        return null;
    }

    public atb O00000Oo(anm anm) {
        return null;
    }

    public Boolean O00000Oo(anj anj) {
        return null;
    }

    public String O00000Oo(anl anl) {
        return null;
    }

    public boolean O00000Oo(ann ann) {
        return false;
    }

    public String[] O00000Oo(ani ani) {
        return null;
    }

    public Object O00000o(anj anj) {
        return null;
    }

    public Object O00000o(anm anm) {
        return null;
    }

    public boolean O00000o(ann ann) {
        return false;
    }

    public Class<?>[] O00000o(ani ani) {
        return null;
    }

    public Boolean O00000o0(anj anj) {
        return null;
    }

    public String O00000o0(ann ann) {
        return null;
    }

    public List<aod> O00000o0(ani ani) {
        return null;
    }

    public boolean O00000o0(anm anm) {
        return false;
    }

    public JsonFormat.O000000o O00000oO(anm anm) {
        return null;
    }

    public Object O00000oO(ani ani) {
        return null;
    }

    public String O00000oO(anj anj) {
        return null;
    }

    public boolean O00000oO(ann ann) {
        return false;
    }

    public Boolean O00000oo(anm anm) {
        return null;
    }

    public Object O00000oo(ani ani) {
        return null;
    }

    public String[] O00000oo(anj anj) {
        return null;
    }

    public Boolean O0000O0o(anj anj) {
        return null;
    }

    public Object O0000O0o(ani ani) {
        return null;
    }

    public Class<?> O0000OOo(ani ani) {
        return null;
    }

    public Object O0000OOo(anj anj) {
        return null;
    }

    public aki.O000000o O0000Oo(anj anj) {
        return null;
    }

    public Class<?> O0000Oo(ani ani) {
        return null;
    }

    public Class<?> O0000Oo0(ani ani) {
        return null;
    }

    public Class<?> O0000Oo0(anj anj) {
        return null;
    }

    public JsonSerialize.Typing O0000OoO(ani ani) {
        return null;
    }

    public Object O0000Ooo(ani ani) {
        return null;
    }

    public Class<?> O0000o(ani ani) {
        return null;
    }

    public Object O0000o0(ani ani) {
        return null;
    }

    public Object O0000o00(ani ani) {
        return null;
    }

    public Class<?> O0000o0O(ani ani) {
        return null;
    }

    public Class<?> O0000o0o(ani ani) {
        return null;
    }

    public boolean O0000oO0(ani ani) {
        return false;
    }

    public static class ReferenceProperty {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f3600O000000o;
        private final Type O00000Oo;

        public enum Type {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public ReferenceProperty(Type type, String str) {
            this.O00000Oo = type;
            this.f3600O000000o = str;
        }

        public final boolean O000000o() {
            return this.O00000Oo == Type.MANAGED_REFERENCE;
        }

        public final boolean O00000Oo() {
            return this.O00000Oo == Type.BACK_REFERENCE;
        }
    }
}
