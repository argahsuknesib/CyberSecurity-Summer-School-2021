package com.facebook.soloader;

class MergedSoMapping {
    static String mapLibName(String str) {
        return null;
    }

    MergedSoMapping() {
    }

    static void invokeJniOnload(String str) {
        throw new IllegalArgumentException("Unknown library: ".concat(String.valueOf(str)));
    }
}
