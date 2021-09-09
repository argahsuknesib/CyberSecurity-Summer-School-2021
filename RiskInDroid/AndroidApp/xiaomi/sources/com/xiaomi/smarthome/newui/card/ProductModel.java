package com.xiaomi.smarthome.newui.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f10224O000000o;
    protected boolean O00000Oo;
    protected int O00000o;
    protected int O00000o0;
    public List<Capability> O00000oO;

    public enum CapabilityType {
        BTN_POWER,
        BTN_COLOR,
        BTN_CT,
        BTN_FLOW,
        BTN_SCENE,
        BTN_NL,
        BTN_CAMERA,
        CONTROL_COLOR_V,
        CONTROL_COLOR_H,
        CONTROL_CT_V,
        CONTROL_CT_H,
        CONTROL_FLOW_V,
        CONTROL_FLOW_H,
        SCENE_BRIGHT,
        SCENE_COLOR,
        SCENE_CT,
        SCENE_FLOW,
        SCENE_NL,
        BTN_GUARD_READ,
        BTN_GUARD_WORK,
        CONTROL_CT_GUARD_READ,
        CONTROL_CT_GUARD_WORK,
        BTN_DELAY
    }

    public ProductModel() {
        this.f10224O000000o = "";
        this.O00000Oo = false;
        this.O00000o0 = 1700;
        this.O00000o = 6500;
        this.O00000oO = new ArrayList();
        this.f10224O000000o = "";
    }

    public final String O000000o() {
        return this.f10224O000000o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Capability capability : this.O00000oO) {
            sb.append(capability.mType.toString());
            sb.append(";");
        }
        return sb.toString();
    }

    public final boolean O000000o(CapabilityType capabilityType) {
        for (Capability next : this.O00000oO) {
            if (next.mType == capabilityType && next.mEnabled) {
                return true;
            }
        }
        return false;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo;
    }

    public static class Capability implements Serializable, Comparable<Capability> {
        private static final long serialVersionUID = 650754658372631811L;
        public boolean mEnabled = true;
        public CapabilityType mType;

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.mType.compareTo((Enum) ((Capability) obj).mType);
        }

        public Capability(CapabilityType capabilityType) {
            this.mType = capabilityType;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return (obj instanceof Capability) && ((Capability) obj).mType == this.mType;
        }

        public String toString() {
            return this.mType.name();
        }
    }

    public static class O000000o extends ProductModel {
        public O000000o(String str) {
            this.O00000oO.add(new Capability(CapabilityType.BTN_POWER));
            this.O00000oO.add(new Capability(CapabilityType.BTN_COLOR));
            this.O00000oO.add(new Capability(CapabilityType.BTN_CT));
            this.O00000oO.add(new Capability(CapabilityType.BTN_FLOW));
            this.O00000oO.add(new Capability(CapabilityType.BTN_SCENE));
            this.O00000oO.add(new Capability(CapabilityType.BTN_CAMERA));
            this.O00000oO.add(new Capability(CapabilityType.CONTROL_COLOR_V));
            this.O00000oO.add(new Capability(CapabilityType.CONTROL_COLOR_H));
            this.O00000oO.add(new Capability(CapabilityType.CONTROL_CT_V));
            this.O00000oO.add(new Capability(CapabilityType.CONTROL_CT_H));
            this.O00000oO.add(new Capability(CapabilityType.CONTROL_FLOW_V));
            this.O00000oO.add(new Capability(CapabilityType.CONTROL_FLOW_H));
            this.O00000oO.add(new Capability(CapabilityType.SCENE_BRIGHT));
            this.O00000oO.add(new Capability(CapabilityType.SCENE_COLOR));
            this.O00000oO.add(new Capability(CapabilityType.SCENE_CT));
            this.O00000oO.add(new Capability(CapabilityType.SCENE_FLOW));
            this.f10224O000000o = str;
        }
    }

    public final int O00000o0() {
        return this.O00000o0;
    }

    public final int O00000o() {
        return this.O00000o;
    }
}
