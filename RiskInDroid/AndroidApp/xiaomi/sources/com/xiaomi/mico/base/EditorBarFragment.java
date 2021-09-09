package com.xiaomi.mico.base;

import android.content.Context;
import com.xiaomi.mico.common.editorbar.EditorBar;

public class EditorBarFragment extends MicoBaseFragment {
    private EditorBarProvider mEditorBarProvider;

    interface EditorBarProvider {
        EditorBar getEditorBar();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EditorBarProvider) {
            this.mEditorBarProvider = (EditorBarProvider) context;
            return;
        }
        throw new IllegalStateException("EditorBarFragment's host activity must provide EditorBar.");
    }

    /* access modifiers changed from: protected */
    public EditorBar getEditorBar() {
        return this.mEditorBarProvider.getEditorBar();
    }
}
