package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PlayerShutdownTimer_ViewBinding implements Unbinder {
    private PlayerShutdownTimer target;
    private View view1747;
    private View view1c2f;
    private View view1c30;
    private View view1c31;
    private View view1c32;
    private View view1c33;

    public PlayerShutdownTimer_ViewBinding(PlayerShutdownTimer playerShutdownTimer) {
        this(playerShutdownTimer, playerShutdownTimer);
    }

    public PlayerShutdownTimer_ViewBinding(final PlayerShutdownTimer playerShutdownTimer, View view) {
        this.target = playerShutdownTimer;
        View findRequiredView = Utils.findRequiredView(view, R.id.time10, "field 'time10' and method 'onViewClicked'");
        playerShutdownTimer.time10 = (TextView) Utils.castView(findRequiredView, R.id.time10, "field 'time10'", TextView.class);
        this.view1c2f = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                playerShutdownTimer.onViewClicked(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.time20, "field 'time20' and method 'onViewClicked'");
        playerShutdownTimer.time20 = (TextView) Utils.castView(findRequiredView2, R.id.time20, "field 'time20'", TextView.class);
        this.view1c30 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer_ViewBinding.AnonymousClass2 */

            public void doClick(View view) {
                playerShutdownTimer.onViewClicked(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.time30, "field 'time30' and method 'onViewClicked'");
        playerShutdownTimer.time30 = (TextView) Utils.castView(findRequiredView3, R.id.time30, "field 'time30'", TextView.class);
        this.view1c31 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer_ViewBinding.AnonymousClass3 */

            public void doClick(View view) {
                playerShutdownTimer.onViewClicked(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.time45, "field 'time45' and method 'onViewClicked'");
        playerShutdownTimer.time45 = (TextView) Utils.castView(findRequiredView4, R.id.time45, "field 'time45'", TextView.class);
        this.view1c32 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer_ViewBinding.AnonymousClass4 */

            public void doClick(View view) {
                playerShutdownTimer.onViewClicked(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.time60, "field 'time60' and method 'onViewClicked'");
        playerShutdownTimer.time60 = (TextView) Utils.castView(findRequiredView5, R.id.time60, "field 'time60'", TextView.class);
        this.view1c33 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer_ViewBinding.AnonymousClass5 */

            public void doClick(View view) {
                playerShutdownTimer.onViewClicked(view);
            }
        });
        playerShutdownTimer.leftTime = (TextView) Utils.findRequiredViewAsType(view, R.id.left_time, "field 'leftTime'", TextView.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.cancel_btn, "field 'cancelBtn' and method 'onViewClicked'");
        playerShutdownTimer.cancelBtn = (TextView) Utils.castView(findRequiredView6, R.id.cancel_btn, "field 'cancelBtn'", TextView.class);
        this.view1747 = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer_ViewBinding.AnonymousClass6 */

            public void doClick(View view) {
                playerShutdownTimer.onViewClicked();
            }
        });
        playerShutdownTimer.hint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_player_shutdown_timer_hint, "field 'hint'", TextView.class);
        playerShutdownTimer.leftTimeContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.left_time_container, "field 'leftTimeContainer'", LinearLayout.class);
        playerShutdownTimer.btnClose = (TextView) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'btnClose'", TextView.class);
    }

    public void unbind() {
        PlayerShutdownTimer playerShutdownTimer = this.target;
        if (playerShutdownTimer != null) {
            this.target = null;
            playerShutdownTimer.time10 = null;
            playerShutdownTimer.time20 = null;
            playerShutdownTimer.time30 = null;
            playerShutdownTimer.time45 = null;
            playerShutdownTimer.time60 = null;
            playerShutdownTimer.leftTime = null;
            playerShutdownTimer.cancelBtn = null;
            playerShutdownTimer.hint = null;
            playerShutdownTimer.leftTimeContainer = null;
            playerShutdownTimer.btnClose = null;
            this.view1c2f.setOnClickListener(null);
            this.view1c2f = null;
            this.view1c30.setOnClickListener(null);
            this.view1c30 = null;
            this.view1c31.setOnClickListener(null);
            this.view1c31 = null;
            this.view1c32.setOnClickListener(null);
            this.view1c32 = null;
            this.view1c33.setOnClickListener(null);
            this.view1c33 = null;
            this.view1747.setOnClickListener(null);
            this.view1747 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
