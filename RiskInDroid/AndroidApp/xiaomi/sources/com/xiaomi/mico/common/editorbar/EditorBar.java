package com.xiaomi.mico.common.editorbar;

import _m_j.gwg;
import _m_j.hzf;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.List;

public class EditorBar implements Finishing {
    private boolean canEdit = true;
    public ActionBar mActionBar;
    private List<ActionCallback> mActionCallbacks = new ArrayList(2);
    public ActionMenu mActionMenu;
    private boolean mInEditorMode;
    private Selector mSelector;

    public EditorBar(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        setupActionBar(activity, viewGroup);
        setupActionMenu(activity, viewGroup);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void setupActionBar(Activity activity, ViewGroup viewGroup) {
        this.mActionBar = (ActionBar) LayoutInflater.from(activity).inflate((int) R.layout.widget_action_bar, viewGroup, false);
        viewGroup.addView(this.mActionBar);
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.mActionBar);
        this.mActionBar.setFinishing(this);
        this.mActionBar.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void setupActionMenu(Activity activity, ViewGroup viewGroup) {
        this.mActionMenu = (ActionMenu) LayoutInflater.from(activity).inflate((int) R.layout.widget_action_menu, viewGroup, false);
        viewGroup.addView(this.mActionMenu);
        this.mActionMenu.setFinishing(this);
        this.mActionMenu.setVisibility(8);
    }

    public void addActionCallback(ActionCallback actionCallback) {
        if (actionCallback != null) {
            this.mActionCallbacks.add(actionCallback);
        }
    }

    public void removeActionCallback(ActionCallback actionCallback) {
        if (actionCallback != null) {
            this.mActionCallbacks.remove(actionCallback);
        }
    }

    public void setSelector(Selector selector) {
        Selector selector2 = this.mSelector;
        if (selector2 != selector) {
            if (selector2 != null) {
                removeActionCallback(selector2);
            }
            this.mSelector = selector;
            addActionCallback(selector);
            this.mActionBar.setSelector(selector);
            this.mActionMenu.setSelector(selector);
        }
    }

    public void onCountChange(int i, int i2) {
        this.mActionBar.onCountChange(i, i2);
        this.mActionMenu.onCountChange(i, i2);
    }

    public boolean isInEditorMode() {
        return this.mInEditorMode;
    }

    public void startAction(ActionMenu.MenuCallback menuCallback) {
        if (!this.mInEditorMode) {
            this.mInEditorMode = true;
            this.mActionBar.startAction();
            this.mActionMenu.startAction(menuCallback);
            this.mActionBar.setVisibility(0);
            this.mActionMenu.setVisibility(0);
            for (ActionCallback onActionStarted : this.mActionCallbacks) {
                onActionStarted.onActionStarted();
            }
        }
    }

    public void finishAction() {
        if (this.mInEditorMode) {
            this.mInEditorMode = false;
            this.mActionBar.finishAction();
            this.mActionMenu.finishAction();
            for (ActionCallback onActionFinished : this.mActionCallbacks) {
                onActionFinished.onActionFinished();
            }
            this.mActionBar.postDelayed(new Runnable() {
                /* class com.xiaomi.mico.common.editorbar.EditorBar.AnonymousClass1 */

                public void run() {
                    EditorBar.this.mActionBar.setVisibility(8);
                    EditorBar.this.mActionMenu.setVisibility(8);
                    EditorBar.this.mActionMenu.removeMenus();
                }
            }, 160);
        }
    }

    public boolean isCanEdit() {
        return this.canEdit;
    }

    public void setCanEdit(boolean z) {
        this.canEdit = z;
    }
}
