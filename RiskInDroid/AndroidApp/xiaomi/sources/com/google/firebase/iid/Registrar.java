package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
public final class Registrar implements ComponentRegistrar {

    static class zza implements FirebaseInstanceIdInternal {
        private final FirebaseInstanceId zzbz;

        public zza(FirebaseInstanceId firebaseInstanceId) {
            this.zzbz = firebaseInstanceId;
        }

        public final String getId() {
            return this.zzbz.getId();
        }

        public final String getToken() {
            return this.zzbz.getToken();
        }
    }

    @Keep
    public final List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).factory(zzaf.zzby).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzag.zzby).build());
    }
}
