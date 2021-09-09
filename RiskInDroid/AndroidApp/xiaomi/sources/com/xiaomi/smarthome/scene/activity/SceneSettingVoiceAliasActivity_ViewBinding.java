package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SceneSettingVoiceAliasActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SceneSettingVoiceAliasActivity f10869O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;

    public SceneSettingVoiceAliasActivity_ViewBinding(final SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity, View view) {
        this.f10869O000000o = sceneSettingVoiceAliasActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mModuleA4ReturnBtn' and method 'onBackClick'");
        sceneSettingVoiceAliasActivity.mModuleA4ReturnBtn = findRequiredView;
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                sceneSettingVoiceAliasActivity.onBackClick();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.txt_cancel, "field 'tvCancel' and method 'onCancelClick'");
        sceneSettingVoiceAliasActivity.tvCancel = findRequiredView2;
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                sceneSettingVoiceAliasActivity.onCancelClick();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.txt_save, "field 'tvSave' and method 'onSaveClick'");
        sceneSettingVoiceAliasActivity.tvSave = findRequiredView3;
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                sceneSettingVoiceAliasActivity.onSaveClick();
            }
        });
        sceneSettingVoiceAliasActivity.mAliasList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.alias_list, "field 'mAliasList'", RecyclerView.class);
    }

    public void unbind() {
        SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity = this.f10869O000000o;
        if (sceneSettingVoiceAliasActivity != null) {
            this.f10869O000000o = null;
            sceneSettingVoiceAliasActivity.mModuleA4ReturnBtn = null;
            sceneSettingVoiceAliasActivity.tvCancel = null;
            sceneSettingVoiceAliasActivity.tvSave = null;
            sceneSettingVoiceAliasActivity.mAliasList = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
