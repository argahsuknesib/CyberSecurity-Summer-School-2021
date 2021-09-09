package com.xiaomi.smarthome.camera.view.recycle;

import _m_j.gsy;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;

public class RecyclerViewRefreshLayoutEx extends RecyclerViewRefreshLayout {
    private Context context;
    public ImageView imageView;
    public boolean mPullEnable = false;
    public RecyclerViewRefreshLayout.OnPullRefreshListener mSubListener;
    public View prog;
    public TextView textView;

    public RecyclerViewRefreshLayoutEx(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        setTopRefreshView(createHeaderView());
        setTargetScrollWithLayout(true);
        super.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayoutEx.AnonymousClass1 */

            public void onRefresh() {
                try {
                    RecyclerViewRefreshLayoutEx.this.textView.setText((int) R.string.pull_refresh);
                    RecyclerViewRefreshLayoutEx.this.imageView.clearAnimation();
                    RecyclerViewRefreshLayoutEx.this.prog.setVisibility(0);
                    RecyclerViewRefreshLayoutEx.this.imageView.setVisibility(8);
                    if (RecyclerViewRefreshLayoutEx.this.mSubListener != null) {
                        RecyclerViewRefreshLayoutEx.this.mSubListener.onRefresh();
                    }
                } catch (Exception e) {
                    gsy.O000000o(6, "RecyclerViewRefreshLayoutEx", "exception:" + e.getLocalizedMessage());
                }
            }

            public void onPullDistance(int i) {
                try {
                    if (RecyclerViewRefreshLayoutEx.this.mSubListener != null) {
                        RecyclerViewRefreshLayoutEx.this.mSubListener.onPullDistance(i);
                    }
                } catch (Exception e) {
                    gsy.O000000o(6, "RecyclerViewRefreshLayoutEx", "exception:" + e.getLocalizedMessage());
                }
            }

            public void onPullEnable(boolean z) {
                if (RecyclerViewRefreshLayoutEx.this.mPullEnable != z) {
                    try {
                        RecyclerViewRefreshLayoutEx.this.mPullEnable = z;
                        RecyclerViewRefreshLayoutEx.this.textView.setText(z ? R.string.pull_refresh_up : R.string.pull_refresh_down);
                        RecyclerViewRefreshLayoutEx.this.prog.setVisibility(8);
                        RecyclerViewRefreshLayoutEx.this.imageView.setVisibility(0);
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecyclerViewRefreshLayoutEx.this.imageView, "rotation", 0.0f, 180.0f);
                            ofFloat.setDuration(300L);
                            ofFloat.start();
                        } else {
                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(RecyclerViewRefreshLayoutEx.this.imageView, "rotation", 180.0f, 0.0f);
                            ofFloat2.setDuration(300L);
                            ofFloat2.start();
                        }
                        if (RecyclerViewRefreshLayoutEx.this.mSubListener != null) {
                            RecyclerViewRefreshLayoutEx.this.mSubListener.onPullEnable(z);
                        }
                    } catch (Exception e) {
                        gsy.O000000o(6, "RecyclerViewRefreshLayoutEx", "exception:" + e.getLocalizedMessage());
                    }
                }
            }
        });
    }

    private View createHeaderView() {
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.camera_list_pull_head, (ViewGroup) null);
        this.textView = (TextView) inflate.findViewById(R.id.text_view);
        this.imageView = (ImageView) inflate.findViewById(R.id.image_view);
        this.imageView.setVisibility(0);
        this.prog = inflate.findViewById(R.id.pull_header);
        this.prog.setVisibility(8);
        this.mPullEnable = false;
        return inflate;
    }

    public void setOnPullRefreshListener(RecyclerViewRefreshLayout.OnPullRefreshListener onPullRefreshListener) {
        this.mSubListener = onPullRefreshListener;
    }
}
