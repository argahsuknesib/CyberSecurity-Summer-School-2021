package com.xiaomi.mico.base;

import com.xiaomi.mico.base.EditorBarFragment;
import com.xiaomi.mico.common.editorbar.EditorBar;

public class EditorBarActivity extends MicoBaseActivity implements EditorBarFragment.EditorBarProvider {
    protected EditorBar editorBar;

    public void setContentView(int i) {
        super.setContentView(i);
        initWindowDecorEditorBar();
    }

    private void initWindowDecorEditorBar() {
        this.editorBar = new EditorBar(this);
    }

    public EditorBar getEditorBar() {
        return this.editorBar;
    }

    public void onBackPressed() {
        if (this.editorBar.isInEditorMode()) {
            this.editorBar.finishAction();
        } else {
            super.onBackPressed();
        }
    }
}
