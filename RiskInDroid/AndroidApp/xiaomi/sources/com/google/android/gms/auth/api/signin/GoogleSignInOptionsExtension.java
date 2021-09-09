package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface GoogleSignInOptionsExtension {

    public @interface TypeId {
    }

    @TypeId
    int getExtensionType();

    List<Scope> getImpliedScopes();

    Bundle toBundle();
}
