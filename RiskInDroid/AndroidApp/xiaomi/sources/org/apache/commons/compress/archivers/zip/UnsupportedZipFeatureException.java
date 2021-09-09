package org.apache.commons.compress.archivers.zip;

import _m_j.jck;
import java.io.Serializable;
import java.util.zip.ZipException;

public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161219;
    private final transient jck entry;
    private final Feature reason;

    public UnsupportedZipFeatureException(Feature feature, jck jck) {
        super("unsupported feature " + feature + " used in entry " + jck.getName());
        this.reason = feature;
        this.entry = jck;
    }

    public UnsupportedZipFeatureException(ZipMethod zipMethod, jck jck) {
        super("unsupported feature method '" + zipMethod.name() + "' used in entry " + jck.getName());
        this.reason = Feature.O00000Oo;
        this.entry = jck;
    }

    public UnsupportedZipFeatureException(Feature feature) {
        super("unsupported feature " + feature + " used in archive.");
        this.reason = feature;
        this.entry = null;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public jck getEntry() {
        return this.entry;
    }

    public static class Feature implements Serializable {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final Feature f15423O000000o = new Feature("encryption");
        public static final Feature O00000Oo = new Feature("compression method");
        public static final Feature O00000o = new Feature("splitting");
        public static final Feature O00000o0 = new Feature("data descriptor");
        private final String name;

        private Feature(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }
}
