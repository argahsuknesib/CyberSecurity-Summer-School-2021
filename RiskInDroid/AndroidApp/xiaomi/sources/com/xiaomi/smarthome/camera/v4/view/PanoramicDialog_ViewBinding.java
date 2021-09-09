package com.xiaomi.smarthome.camera.v4.view;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PanoramicDialog_ViewBinding implements Unbinder {
    private PanoramicDialog target;
    private View view1948;
    private View view19a2;
    private View view19a3;
    private View view19a4;
    private View view19fb;

    public PanoramicDialog_ViewBinding(final PanoramicDialog panoramicDialog, View view) {
        this.target = panoramicDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'mBtn1' and method 'onClick'");
        panoramicDialog.mBtn1 = (ImageView) Utils.castView(findRequiredView, R.id.btn1, "field 'mBtn1'", ImageView.class);
        this.view19a2 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.view.PanoramicDialog_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                panoramicDialog.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'mBtn2' and method 'onClick'");
        panoramicDialog.mBtn2 = (ImageView) Utils.castView(findRequiredView2, R.id.btn2, "field 'mBtn2'", ImageView.class);
        this.view19a3 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.view.PanoramicDialog_ViewBinding.AnonymousClass2 */

            public void doClick(View view) {
                panoramicDialog.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'mBtn3' and method 'onClick'");
        panoramicDialog.mBtn3 = (ImageView) Utils.castView(findRequiredView3, R.id.btn3, "field 'mBtn3'", ImageView.class);
        this.view19a4 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.view.PanoramicDialog_ViewBinding.AnonymousClass3 */

            public void doClick(View view) {
                panoramicDialog.onClick(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.cancel, "method 'onClick'");
        this.view19fb = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.view.PanoramicDialog_ViewBinding.AnonymousClass4 */

            public void doClick(View view) {
                panoramicDialog.onClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.agree, "method 'onClick'");
        this.view1948 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.view.PanoramicDialog_ViewBinding.AnonymousClass5 */

            public void doClick(View view) {
                panoramicDialog.onClick(view);
            }
        });
    }

    public void unbind() {
        PanoramicDialog panoramicDialog = this.target;
        if (panoramicDialog != null) {
            this.target = null;
            panoramicDialog.mBtn1 = null;
            panoramicDialog.mBtn2 = null;
            panoramicDialog.mBtn3 = null;
            this.view19a2.setOnClickListener(null);
            this.view19a2 = null;
            this.view19a3.setOnClickListener(null);
            this.view19a3 = null;
            this.view19a4.setOnClickListener(null);
            this.view19a4 = null;
            this.view19fb.setOnClickListener(null);
            this.view19fb = null;
            this.view1948.setOnClickListener(null);
            this.view1948 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
