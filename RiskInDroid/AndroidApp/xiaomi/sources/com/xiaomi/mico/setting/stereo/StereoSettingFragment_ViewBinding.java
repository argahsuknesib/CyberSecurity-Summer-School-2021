package com.xiaomi.mico.setting.stereo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.mico.common.widget.EmptyView;
import com.xiaomi.smarthome.R;

public class StereoSettingFragment_ViewBinding implements Unbinder {
    private StereoSettingFragment target;
    private View view1a2e;

    public StereoSettingFragment_ViewBinding(final StereoSettingFragment stereoSettingFragment, View view) {
        this.target = stereoSettingFragment;
        stereoSettingFragment.titleView = (TextView) Utils.findRequiredViewAsType(view, R.id.stereo_lan_title, "field 'titleView'", TextView.class);
        stereoSettingFragment.titleDescView = (TextView) Utils.findRequiredViewAsType(view, R.id.stereo_lan_title_desc, "field 'titleDescView'", TextView.class);
        stereoSettingFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.stereo_lan_list_view, "field 'recyclerView'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.next_step_btn, "field 'nextBtn' and method 'onClickView'");
        stereoSettingFragment.nextBtn = (Button) Utils.castView(findRequiredView, R.id.next_step_btn, "field 'nextBtn'", Button.class);
        this.view1a2e = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.StereoSettingFragment_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                stereoSettingFragment.onClickView(view);
            }
        });
        stereoSettingFragment.emptyView = (EmptyView) Utils.findRequiredViewAsType(view, R.id.empty_view, "field 'emptyView'", EmptyView.class);
    }

    public void unbind() {
        StereoSettingFragment stereoSettingFragment = this.target;
        if (stereoSettingFragment != null) {
            this.target = null;
            stereoSettingFragment.titleView = null;
            stereoSettingFragment.titleDescView = null;
            stereoSettingFragment.recyclerView = null;
            stereoSettingFragment.nextBtn = null;
            stereoSettingFragment.emptyView = null;
            this.view1a2e.setOnClickListener(null);
            this.view1a2e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
