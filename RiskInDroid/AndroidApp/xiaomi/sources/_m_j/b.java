package _m_j;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

public final class b {

    /* renamed from: O000000o  reason: collision with root package name */
    final String f12739O000000o;
    final CharSequence O00000Oo;
    final boolean O00000o;
    final CharSequence[] O00000o0;
    final Bundle O00000oO;
    final Set<String> O00000oo;
    private final int O0000O0o;

    static RemoteInput[] O000000o(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            b bVar = bVarArr[i];
            RemoteInput.Builder addExtras = new RemoteInput.Builder(bVar.f12739O000000o).setLabel(bVar.O00000Oo).setChoices(bVar.O00000o0).setAllowFreeFormInput(bVar.O00000o).addExtras(bVar.O00000oO);
            if (Build.VERSION.SDK_INT >= 29) {
                addExtras.setEditChoicesBeforeSending(bVar.O0000O0o);
            }
            remoteInputArr[i] = addExtras.build();
        }
        return remoteInputArr;
    }
}
