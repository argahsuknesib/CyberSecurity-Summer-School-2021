package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ControlBarV2_ViewBinding implements Unbinder {
    private ControlBarV2 target;
    private View view1a9d;
    private View view1a9e;
    private View view1aa0;
    private View view1aa1;
    private View view1aa2;
    private View view1aa5;
    private View view1aa6;

    public ControlBarV2_ViewBinding(ControlBarV2 controlBarV2) {
        this(controlBarV2, controlBarV2);
    }

    public ControlBarV2_ViewBinding(final ControlBarV2 controlBarV2, View view) {
        this.target = controlBarV2;
        View findRequiredView = Utils.findRequiredView(view, R.id.player_control_bar_loop, "field 'mLoop' and method 'onClick'");
        controlBarV2.mLoop = (ImageView) Utils.castView(findRequiredView, R.id.player_control_bar_loop, "field 'mLoop'", ImageView.class);
        this.view1a9e = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.player_control_bar_prev, "field 'mPrev' and method 'onClick'");
        controlBarV2.mPrev = (ImageView) Utils.castView(findRequiredView2, R.id.player_control_bar_prev, "field 'mPrev'", ImageView.class);
        this.view1aa2 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass2 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.player_control_bar_play, "field 'mPlay' and method 'onClick'");
        controlBarV2.mPlay = (ImageView) Utils.castView(findRequiredView3, R.id.player_control_bar_play, "field 'mPlay'", ImageView.class);
        this.view1aa1 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass3 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.player_control_bar_next, "field 'mNext' and method 'onClick'");
        controlBarV2.mNext = (ImageView) Utils.castView(findRequiredView4, R.id.player_control_bar_next, "field 'mNext'", ImageView.class);
        this.view1aa0 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass4 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.player_control_bar_time, "field 'mTime' and method 'onClick'");
        controlBarV2.mTime = (ImageView) Utils.castView(findRequiredView5, R.id.player_control_bar_time, "field 'mTime'", ImageView.class);
        this.view1aa5 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass5 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.player_control_bar_volume, "field 'mVolume' and method 'onClick'");
        controlBarV2.mVolume = (ImageView) Utils.castView(findRequiredView6, R.id.player_control_bar_volume, "field 'mVolume'", ImageView.class);
        this.view1aa6 = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass6 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
        controlBarV2.playerProgressBar = (PlayerProgressBar) Utils.findRequiredViewAsType(view, R.id.player_progress_bar, "field 'playerProgressBar'", PlayerProgressBar.class);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.player_control_bar_list, "method 'onClick'");
        this.view1a9d = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2_ViewBinding.AnonymousClass7 */

            public void doClick(View view) {
                controlBarV2.onClick(view);
            }
        });
    }

    public void unbind() {
        ControlBarV2 controlBarV2 = this.target;
        if (controlBarV2 != null) {
            this.target = null;
            controlBarV2.mLoop = null;
            controlBarV2.mPrev = null;
            controlBarV2.mPlay = null;
            controlBarV2.mNext = null;
            controlBarV2.mTime = null;
            controlBarV2.mVolume = null;
            controlBarV2.playerProgressBar = null;
            this.view1a9e.setOnClickListener(null);
            this.view1a9e = null;
            this.view1aa2.setOnClickListener(null);
            this.view1aa2 = null;
            this.view1aa1.setOnClickListener(null);
            this.view1aa1 = null;
            this.view1aa0.setOnClickListener(null);
            this.view1aa0 = null;
            this.view1aa5.setOnClickListener(null);
            this.view1aa5 = null;
            this.view1aa6.setOnClickListener(null);
            this.view1aa6 = null;
            this.view1a9d.setOnClickListener(null);
            this.view1a9d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
