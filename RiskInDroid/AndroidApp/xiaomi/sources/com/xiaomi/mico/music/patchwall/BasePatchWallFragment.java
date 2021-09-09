package com.xiaomi.mico.music.patchwall;

import _m_j.jgc;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.smarthome.R;

public class BasePatchWallFragment extends MicoBaseFragment {
    protected RecyclerView mRecyclerView;
    VelocityTracker mVelocityTracker = VelocityTracker.obtain();

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.mico_fragment_base_patchwall;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    @SuppressLint({"ClickableViewAccessibility"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.linear_recycle_view);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.mico.music.patchwall.BasePatchWallFragment.AnonymousClass1 */

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BasePatchWallFragment.this.mVelocityTracker.computeCurrentVelocity(1000);
                float yVelocity = BasePatchWallFragment.this.mVelocityTracker.getYVelocity();
                if (yVelocity > 2000.0f || yVelocity < -2000.0f) {
                    jgc.O000000o().O00000o(new MusicEvent.PlayerControlerDisplay(yVelocity));
                }
            }
        });
        this.mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$BasePatchWallFragment$OhQa2l9JuYkTLu6RehdV1xwr6dg */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BasePatchWallFragment.this.lambda$onCreateView$0$BasePatchWallFragment(view, motionEvent);
            }
        });
        return inflate;
    }

    public /* synthetic */ boolean lambda$onCreateView$0$BasePatchWallFragment(View view, MotionEvent motionEvent) {
        this.mVelocityTracker.addMovement(motionEvent);
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        refreshTitleBar();
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }
}
