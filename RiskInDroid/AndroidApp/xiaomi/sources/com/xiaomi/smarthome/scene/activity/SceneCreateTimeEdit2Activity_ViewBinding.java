package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.common.widget.TimePicker;

public class SceneCreateTimeEdit2Activity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SceneCreateTimeEdit2Activity f10823O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;

    public SceneCreateTimeEdit2Activity_ViewBinding(final SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity, View view) {
        this.f10823O000000o = sceneCreateTimeEdit2Activity;
        sceneCreateTimeEdit2Activity.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleView'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_right_btn, "field 'mConfirmView' and method 'onClick'");
        sceneCreateTimeEdit2Activity.mConfirmView = (ImageView) Utils.castView(findRequiredView, R.id.module_a_3_right_btn, "field 'mConfirmView'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
        sceneCreateTimeEdit2Activity.mRepeatDayHint = (TextView) Utils.findRequiredViewAsType(view, R.id.smarthome_scene_timer_day_hint, "field 'mRepeatDayHint'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.all_day_switch, "field 'mIsAlldaySwitch' and method 'onClick'");
        sceneCreateTimeEdit2Activity.mIsAlldaySwitch = (SwitchButton) Utils.castView(findRequiredView2, R.id.all_day_switch, "field 'mIsAlldaySwitch'", SwitchButton.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.all_day_setting, "field 'mIsAlldaySwitchLayout' and method 'onClick'");
        sceneCreateTimeEdit2Activity.mIsAlldaySwitchLayout = findRequiredView3;
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
        sceneCreateTimeEdit2Activity.mExecuteFromTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_from_title, "field 'mExecuteFromTitle'", TextView.class);
        sceneCreateTimeEdit2Activity.mExecuteFrom = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_from_hint, "field 'mExecuteFrom'", TextView.class);
        sceneCreateTimeEdit2Activity.mExecuteTo = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_to_hint, "field 'mExecuteTo'", TextView.class);
        sceneCreateTimeEdit2Activity.mExecuteToTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_to_title, "field 'mExecuteToTitle'", TextView.class);
        sceneCreateTimeEdit2Activity.mExecuteFromPicker = (TimePicker) Utils.findRequiredViewAsType(view, R.id.execute_from_picker, "field 'mExecuteFromPicker'", TimePicker.class);
        sceneCreateTimeEdit2Activity.mExecuteToPicker = (TimePicker) Utils.findRequiredViewAsType(view, R.id.execute_to_picker, "field 'mExecuteToPicker'", TimePicker.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClick'");
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.repeat_setting, "method 'onClick'");
        this.O00000oo = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass5 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.execute_from_layout, "method 'onClick'");
        this.O0000O0o = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass6 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.execute_to_layout, "method 'onClick'");
        this.O0000OOo = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity_ViewBinding.AnonymousClass7 */

            public final void doClick(View view) {
                sceneCreateTimeEdit2Activity.onClick(view);
            }
        });
    }

    public void unbind() {
        SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity = this.f10823O000000o;
        if (sceneCreateTimeEdit2Activity != null) {
            this.f10823O000000o = null;
            sceneCreateTimeEdit2Activity.mTitleView = null;
            sceneCreateTimeEdit2Activity.mConfirmView = null;
            sceneCreateTimeEdit2Activity.mRepeatDayHint = null;
            sceneCreateTimeEdit2Activity.mIsAlldaySwitch = null;
            sceneCreateTimeEdit2Activity.mIsAlldaySwitchLayout = null;
            sceneCreateTimeEdit2Activity.mExecuteFromTitle = null;
            sceneCreateTimeEdit2Activity.mExecuteFrom = null;
            sceneCreateTimeEdit2Activity.mExecuteTo = null;
            sceneCreateTimeEdit2Activity.mExecuteToTitle = null;
            sceneCreateTimeEdit2Activity.mExecuteFromPicker = null;
            sceneCreateTimeEdit2Activity.mExecuteToPicker = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            this.O00000oO.setOnClickListener(null);
            this.O00000oO = null;
            this.O00000oo.setOnClickListener(null);
            this.O00000oo = null;
            this.O0000O0o.setOnClickListener(null);
            this.O0000O0o = null;
            this.O0000OOo.setOnClickListener(null);
            this.O0000OOo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
