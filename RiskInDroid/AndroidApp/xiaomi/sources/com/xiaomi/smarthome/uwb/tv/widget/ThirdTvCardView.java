package com.xiaomi.smarthome.uwb.tv.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.api.UwbThirdApi;
import com.xiaomi.smarthome.uwb.lib.mitv.widget.LPImageView;
import com.xiaomi.smarthome.uwb.lib.mitv.widget.TvPadView;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;

public class ThirdTvCardView extends RelativeLayout {
    private static final String TAG = "com.xiaomi.smarthome.uwb.tv.widget.ThirdTvCardView";
    Runnable mExitRunning = new Runnable() {
        /* class com.xiaomi.smarthome.uwb.tv.widget.ThirdTvCardView.AnonymousClass1 */

        public void run() {
            if (ThirdTvCardView.this.getContext() instanceof Activity) {
                Activity activity = (Activity) ThirdTvCardView.this.getContext();
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    ((Activity) ThirdTvCardView.this.getContext()).finish();
                }
            }
        }
    };
    Handler mHandler;
    View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
        /* class com.xiaomi.smarthome.uwb.tv.widget.ThirdTvCardView.AnonymousClass2 */

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (R.id.power_iv == view.getId()) {
                    UwbThirdApi.doKeyEventDown(26);
                    view.setSelected(!view.isSelected());
                    if (ThirdTvCardView.this.mHandler == null) {
                        ThirdTvCardView.this.mHandler = new Handler();
                    }
                    ThirdTvCardView.this.mHandler.postDelayed(ThirdTvCardView.this.mExitRunning, 2000);
                } else if (R.id.volume_reduce == view.getId()) {
                    UwbThirdApi.doKeyEventDown(25);
                } else if (R.id.volume_add == view.getId()) {
                    UwbThirdApi.doKeyEventDown(24);
                } else if (R.id.home_iv == view.getId()) {
                    UwbThirdApi.doKeyEventDown(3);
                } else if (R.id.back_iv == view.getId()) {
                    UwbThirdApi.doKeyEventDown(4);
                } else if (R.id.menu_iv == view.getId()) {
                    UwbThirdApi.doKeyEventDown(82);
                }
                return true;
            } else if (1 != motionEvent.getAction() && 3 != motionEvent.getAction()) {
                return false;
            } else {
                if (R.id.menu_iv == view.getId()) {
                    UwbThirdApi.doKeyEventUp(Type.Keyboard);
                } else {
                    UwbThirdApi.doKeyEventUp(Type.Multimedia);
                }
                return true;
            }
        }
    };
    LPImageView.PadLayoutListener mPadLayoutListener;
    TvPadView mTvPadView;

    public ThirdTvCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTvPadView = (TvPadView) findViewById(R.id.pad_l);
        this.mPadLayoutListener = new LPImageView.PadLayoutListener() {
            /* class com.xiaomi.smarthome.uwb.tv.widget.ThirdTvCardView.AnonymousClass3 */

            public void onActionExecute(View view, boolean z) {
            }

            public void onActionDown(View view) {
                if (R.id.ok_btn == view.getId()) {
                    UwbThirdApi.doKeyEventDown(66);
                    ThirdTvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_ok_press);
                } else if (R.id.left_btn == view.getId()) {
                    UwbThirdApi.doKeyEventDown(21);
                    ThirdTvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_left_press);
                } else if (R.id.right_btn == view.getId()) {
                    UwbThirdApi.doKeyEventDown(22);
                    ThirdTvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_right_press);
                } else if (R.id.up_btn == view.getId()) {
                    UwbThirdApi.doKeyEventDown(19);
                    ThirdTvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_up_press);
                } else if (R.id.down_btn == view.getId()) {
                    UwbThirdApi.doKeyEventDown(20);
                    ThirdTvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_down_press);
                }
            }

            public void onActionUp(View view) {
                ThirdTvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_normal);
                UwbThirdApi.doKeyEventUp(Type.Keyboard);
            }
        };
        this.mTvPadView.setPadViewClickListener(this.mPadLayoutListener);
        findViewById(R.id.power_iv).setOnTouchListener(this.mOnTouchListener);
        findViewById(R.id.volume_reduce).setOnTouchListener(this.mOnTouchListener);
        findViewById(R.id.volume_add).setOnTouchListener(this.mOnTouchListener);
        findViewById(R.id.home_iv).setOnTouchListener(this.mOnTouchListener);
        findViewById(R.id.back_iv).setOnTouchListener(this.mOnTouchListener);
        findViewById(R.id.menu_iv).setOnTouchListener(this.mOnTouchListener);
    }
}
