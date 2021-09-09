package com.xiaomi.smarthome.camera.lowpower.timerange;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class CreateTimeEdit2Activity_ViewBinding implements Unbinder {
    private CreateTimeEdit2Activity target;
    private View view1b0a;
    private View view1b0e;
    private View view1d50;
    private View view1d57;
    private View view1e72;

    public CreateTimeEdit2Activity_ViewBinding(CreateTimeEdit2Activity createTimeEdit2Activity) {
        this(createTimeEdit2Activity, createTimeEdit2Activity.getWindow().getDecorView());
    }

    public CreateTimeEdit2Activity_ViewBinding(final CreateTimeEdit2Activity createTimeEdit2Activity, View view) {
        this.target = createTimeEdit2Activity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClick'");
        this.view1d50 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                createTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.module_a_3_right_btn, "method 'onClick'");
        this.view1d57 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity_ViewBinding.AnonymousClass2 */

            public void doClick(View view) {
                createTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.repeat_setting, "method 'onClick'");
        this.view1e72 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity_ViewBinding.AnonymousClass3 */

            public void doClick(View view) {
                createTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.execute_from_layout, "method 'onClick'");
        this.view1b0a = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity_ViewBinding.AnonymousClass4 */

            public void doClick(View view) {
                createTimeEdit2Activity.onClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.execute_to_layout, "method 'onClick'");
        this.view1b0e = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity_ViewBinding.AnonymousClass5 */

            public void doClick(View view) {
                createTimeEdit2Activity.onClick(view);
            }
        });
    }

    public void unbind() {
        if (this.target != null) {
            this.target = null;
            this.view1d50.setOnClickListener(null);
            this.view1d50 = null;
            this.view1d57.setOnClickListener(null);
            this.view1d57 = null;
            this.view1e72.setOnClickListener(null);
            this.view1e72 = null;
            this.view1b0a.setOnClickListener(null);
            this.view1b0a = null;
            this.view1b0e.setOnClickListener(null);
            this.view1b0e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
