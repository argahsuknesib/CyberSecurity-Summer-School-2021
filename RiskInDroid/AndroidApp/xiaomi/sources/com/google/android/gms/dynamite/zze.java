package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zze implements DynamiteModule.VersionPolicy {
    zze() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.getLocalVersion(context, str);
        selectionResult.remoteVersion = selectionResult.localVersion != 0 ? iVersions.getRemoteVersion(context, str, false) : iVersions.getRemoteVersion(context, str, true);
        if (selectionResult.localVersion == 0 && selectionResult.remoteVersion == 0) {
            selectionResult.selection = 0;
        } else if (selectionResult.localVersion >= selectionResult.remoteVersion) {
            selectionResult.selection = -1;
        } else {
            selectionResult.selection = 1;
        }
        return selectionResult;
    }
}
