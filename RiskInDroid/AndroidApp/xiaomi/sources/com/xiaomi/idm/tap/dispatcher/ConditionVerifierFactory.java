package com.xiaomi.idm.tap.dispatcher;

public class ConditionVerifierFactory {
    public ConditionVerifier createConditionVerifier(int i) {
        return null;
    }

    static class Internal {
        public static ConditionVerifierFactory sInstance = new ConditionVerifierFactory();

        private Internal() {
        }
    }

    public static ConditionVerifierFactory getDefault() {
        return Internal.sInstance;
    }

    private ConditionVerifierFactory() {
    }
}
