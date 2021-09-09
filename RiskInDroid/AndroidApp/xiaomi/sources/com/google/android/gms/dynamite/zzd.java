package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzd implements DynamiteModule.VersionPolicy {
    zzd() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int i;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.getLocalVersion(context, str);
        selectionResult.remoteVersion = iVersions.getRemoteVersion(context, str, true);
        if (selectionResult.localVersion == 0 && selectionResult.remoteVersion == 0) {
            i = 0;
        } else if (selectionResult.localVersion >= selectionResult.remoteVersion) {
            i = -1;
        } else {
            selectionResult.selection = 1;
            return selectionResult;
        }
        selectionResult.selection = i;
        return selectionResult;
    }
}
