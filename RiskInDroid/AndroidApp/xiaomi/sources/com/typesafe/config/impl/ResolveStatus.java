package com.typesafe.config.impl;

import java.util.Collection;

public enum ResolveStatus {
    UNRESOLVED,
    RESOLVED;

    static final ResolveStatus fromValues(Collection<? extends AbstractConfigValue> collection) {
        for (AbstractConfigValue O0000O0o : collection) {
            ResolveStatus O0000O0o2 = O0000O0o.O0000O0o();
            ResolveStatus resolveStatus = UNRESOLVED;
            if (O0000O0o2 == resolveStatus) {
                return resolveStatus;
            }
        }
        return RESOLVED;
    }

    static final ResolveStatus fromBoolean(boolean z) {
        return z ? RESOLVED : UNRESOLVED;
    }
}
