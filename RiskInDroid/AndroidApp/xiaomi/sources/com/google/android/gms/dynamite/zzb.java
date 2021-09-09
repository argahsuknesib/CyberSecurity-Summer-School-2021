package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzb implements DynamiteModule.VersionPolicy {
    zzb() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.remoteVersion = iVersions.getRemoteVersion(context, str, true);
        if (selectionResult.remoteVersion != 0) {
            selectionResult.selection = 1;
        } else {
            selectionResult.localVersion = iVersions.getLocalVersion(context, str);
            if (selectionResult.localVersion != 0) {
                selectionResult.selection = -1;
            }
        }
        return selectionResult;
    }
}
