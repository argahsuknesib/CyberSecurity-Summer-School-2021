package com.xiaomi.smarthome.library.common.widget;

import _m_j.gpo;
import _m_j.gri;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.util.XMBaseListView;
import java.lang.ref.WeakReference;

public class CustomPullDownRefreshListView extends XMBaseListView {

    /* renamed from: O000000o  reason: collision with root package name */
    float f9166O000000o;
    int O00000Oo;
    public boolean O00000o = false;
    int O00000o0 = 0;
    O000000o O00000oO = new O000000o(this);
    View O00000oo = null;
    View O0000O0o = null;
    int O0000OOo = 0;
    private final int O0000Oo = 16;
    int O0000Oo0 = 0;
    private final float O0000OoO = 1.5f;
    private boolean O0000Ooo = false;
    private O00000Oo O0000o;
    private float O0000o0 = 0.0f;
    private boolean O0000o00 = false;
    private boolean O0000o0O = false;
    private O00000o0 O0000o0o;
    private ImageView O0000oO = null;
    private View O0000oO0 = null;
    private int O0000oOO = Integer.MAX_VALUE;
    private boolean O0000oOo = true;
    private boolean O0000oo = true;
    private boolean O0000oo0 = true;
    private CharSequence O0000ooO;
    private CharSequence O0000ooo;
    private boolean O000O00o = false;
    private LottieAnimationView O000O0OO;
    private View O00oOooO;
    private float O00oOooo = -1.0f;

    public interface O00000Oo {
        boolean O000000o();
    }

    public interface O00000o0 {
        void startRefresh();
    }

    public CustomPullDownRefreshListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o();
    }

    public CustomPullDownRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o();
    }

    public CustomPullDownRefreshListView(Context context) {
        super(context);
        O00000o();
    }

    public void setRefreshListener(O00000o0 o00000o0) {
        this.O0000o0o = o00000o0;
    }

    public void setInterceptListener(O00000Oo o00000Oo) {
        this.O0000o = o00000Oo;
    }

    public void setShowRefreshProgress(boolean z) {
        this.O0000oo = z;
    }

    public final void O000000o() {
        if (this.O00000o || this.O0000o0o == null) {
            gpo.O00000Oo(this.O000O0OO);
            return;
        }
        O00000o0();
        this.O0000o0o.startRefresh();
    }

    private void O00000o0() {
        this.O00000o = true;
        ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
        if (this.O00000o0 == 0) {
            this.O00000o0 = getContext().getResources().getDimensionPixelSize(R.dimen.pull_down_header_height);
        }
        layoutParams.height = this.O00000o0 + this.O0000OOo;
        this.O00000oo.setLayoutParams(layoutParams);
        gpo.O000000o(this.O000O0OO);
    }

    public void setProgressDrawable(Drawable drawable) {
        ((ProgressBar) findViewById(R.id.pull_header_prog)).setIndeterminateDrawable(drawable);
    }

    public final void O00000Oo() {
        this.O00000o = false;
        ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
        layoutParams.height = this.O0000OOo + this.O00000o0;
        this.O00000oo.setLayoutParams(layoutParams);
        this.O00000oO.sendEmptyMessageDelayed(0, 16);
        gpo.O00000Oo(this.O000O0OO);
    }

    public void setOriHeight(int i) {
        this.O0000OOo = i;
        findViewById(R.id.pull_header).getLayoutParams().height = this.O0000OOo;
        this.O0000oO0.findViewById(R.id.empty_view).getLayoutParams().height = this.O0000OOo;
    }

    public void setPullDownEnabled(boolean z) {
        this.O0000oOo = z;
    }

    public void setPullDownHeaderVisibility(int i) {
        findViewById(R.id.pull_header_container).setVisibility(i);
    }

    public void setPullDownTextColor(int i) {
        ((TextView) findViewById(R.id.pull_header_txt)).setTextColor(i);
    }

    public void setPullDownTextSize(int i) {
        ((TextView) findViewById(R.id.pull_header_txt)).setTextSize((float) i);
    }

    public void setPullDownTextColorLine2(int i) {
        ((TextView) findViewById(R.id.pull_header_txt_line2)).setTextColor(i);
    }

    public void setPullDownLine2Text(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.pull_header_txt_line2);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(0);
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
    }

    public void setIndicatorDrawable(Drawable drawable) {
        ((ImageView) findViewById(R.id.pull_header_indc)).setImageDrawable(drawable);
    }

    public void setMaxPullDownFromRes(int i) {
        this.O0000oOO = getResources().getDimensionPixelSize(i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int heightWithoutFooter = getHeightWithoutFooter();
        if (getHeight() - heightWithoutFooter > gri.O000000o(13.3f)) {
            this.O0000Oo0 = getHeight() - heightWithoutFooter;
        } else {
            this.O0000Oo0 = gri.O000000o(13.3f);
        }
        ViewGroup.LayoutParams layoutParams = this.O0000O0o.getLayoutParams();
        layoutParams.height = this.O0000Oo0;
        this.O0000O0o.setLayoutParams(layoutParams);
    }

    @SuppressLint({"NewApi"})
    private void O00000o() {
        if (Build.VERSION.SDK_INT >= 14) {
            setOverScrollMode(2);
        }
        if (!isInEditMode()) {
            this.f9166O000000o = (getResources().getDisplayMetrics().density * 1.5f) + 0.5f;
            this.O0000ooO = getContext().getString(R.string.pull_down_refresh);
            this.O0000ooo = getContext().getString(R.string.release_to_refresh);
            this.O00000Oo = getResources().getDimensionPixelSize(R.dimen.pull_down_refresh_threshold);
            this.O0000oO0 = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_header, (ViewGroup) null);
            this.O00000oo = this.O0000oO0.findViewById(R.id.pull_header);
            addHeaderView(this.O0000oO0);
            this.O000O0OO = (LottieAnimationView) this.O0000oO0.findViewById(R.id.pull_animation);
            this.O00oOooO = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_footer, (ViewGroup) null);
            super.addFooterView(this.O00oOooO);
            this.O0000O0o = this.O00oOooO.findViewById(R.id.pull_footer);
            this.O0000Oo0 = gri.O000000o(13.3f);
        }
    }

    public void addFooterView(View view) {
        removeFooterView(this.O00oOooO);
        super.addFooterView(this.O00oOooO);
        super.addFooterView(view);
    }

    public void setCanPullDown(boolean z) {
        this.O0000oo0 = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000oo0) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.O0000Ooo) {
                    O00000Oo o00000Oo = this.O0000o;
                    if (o00000Oo == null || !o00000Oo.O000000o()) {
                        this.O00000oO.sendEmptyMessage(0);
                        if (this.O0000o0O) {
                            O000000o();
                        }
                        this.O0000Ooo = false;
                    } else if (!this.O0000o0O) {
                        this.O00000oO.sendEmptyMessage(0);
                        this.O0000Ooo = false;
                    }
                } else if (this.O0000o00) {
                    this.O00000oO.sendEmptyMessage(1);
                    this.O0000o00 = false;
                }
                this.O00oOooo = -1.0f;
            } else if (action == 2) {
                if (this.O00oOooo == -1.0f) {
                    int heightWithoutFooter = getHeightWithoutFooter();
                    if (getHeight() - heightWithoutFooter > gri.O000000o(13.3f)) {
                        this.O0000Oo0 = getHeight() - heightWithoutFooter;
                    } else {
                        this.O0000Oo0 = gri.O000000o(13.3f);
                    }
                    this.O00oOooo = motionEvent.getY();
                    gpo.O000000o(this.O000O0OO);
                }
                boolean z = this.O0000Ooo;
                if (z) {
                    float y = motionEvent.getY();
                    if (y - this.O0000o0 > 10.0f) {
                        ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
                        this.O00000o0 = (int) ((y - this.O0000o0) / 2.0f);
                        int i = this.O00000o0;
                        int i2 = this.O0000OOo;
                        int i3 = i + i2;
                        int i4 = this.O0000oOO;
                        if (i3 < i4) {
                            layoutParams.height = i + i2;
                            this.O00000oo.setLayoutParams(layoutParams);
                            if (this.O00000o0 >= this.O00000Oo) {
                                if (!this.O0000o0O) {
                                    this.O0000o0O = true;
                                }
                            } else if (this.O0000o0O) {
                                this.O0000o0O = false;
                            }
                        } else {
                            this.O00000o0 = Math.max(0, i4 - i2);
                        }
                        motionEvent.setAction(3);
                        super.onTouchEvent(motionEvent);
                        return true;
                    }
                } else if (this.O0000o00) {
                    float y2 = motionEvent.getY();
                    float f = this.O0000o0;
                    if (y2 - f < -10.0f) {
                        this.O00000o0 = (int) ((f - y2) / 3.0f);
                        ViewGroup.LayoutParams layoutParams2 = this.O0000O0o.getLayoutParams();
                        layoutParams2.height = this.O00000o0 + this.O0000Oo0;
                        this.O0000O0o.setLayoutParams(layoutParams2);
                        setSelection(getBottom());
                        motionEvent.setAction(3);
                        super.onTouchEvent(motionEvent);
                    }
                } else if (this.O0000oOo && !z && !this.O00000o && getFirstVisiblePosition() <= 0 && motionEvent.getY() - this.O00oOooo > 0.0f && this.O0000oO0.getTop() >= 0) {
                    this.O0000Ooo = true;
                    this.O0000o0 = motionEvent.getY();
                    this.O0000o0O = false;
                    gpo.O000000o(this.O000O0OO);
                } else if (!this.O0000o00 && !this.O00000o && getLastVisiblePosition() >= getCount() - 1 && motionEvent.getY() - this.O00oOooo < 0.0f) {
                    this.O0000o00 = true;
                    this.O0000o0 = motionEvent.getY();
                    this.O0000o0O = false;
                }
            } else if (action == 3) {
                this.O00oOooo = -1.0f;
                if (this.O0000Ooo) {
                    this.O00000oO.sendEmptyMessage(0);
                }
                this.O0000Ooo = false;
            }
        } else if (this.O00oOooo == -1.0f) {
            int heightWithoutFooter2 = getHeightWithoutFooter();
            if (getHeight() - heightWithoutFooter2 > gri.O000000o(13.3f)) {
                this.O0000Oo0 = getHeight() - heightWithoutFooter2;
            } else {
                this.O0000Oo0 = gri.O000000o(13.3f);
            }
            this.O00oOooo = motionEvent.getY();
            gpo.O000000o(this.O000O0OO);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean getIsDown() {
        if ((this.O00000o || getFirstVisiblePosition() > 0 || this.O0000oO0.getTop() < 0) && !this.O00000o) {
            return false;
        }
        return true;
    }

    static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<CustomPullDownRefreshListView> f9167O000000o;

        public O000000o(CustomPullDownRefreshListView customPullDownRefreshListView) {
            this.f9167O000000o = new WeakReference<>(customPullDownRefreshListView);
        }

        public final void handleMessage(Message message) {
            CustomPullDownRefreshListView customPullDownRefreshListView = this.f9167O000000o.get();
            if (customPullDownRefreshListView != null) {
                if (message.what == 0) {
                    ViewGroup.LayoutParams layoutParams = customPullDownRefreshListView.O00000oo.getLayoutParams();
                    if (customPullDownRefreshListView.O00000o0 >= 0) {
                        customPullDownRefreshListView.O00000o0 = (int) (((float) customPullDownRefreshListView.O00000o0) - ((customPullDownRefreshListView.O00000o ? customPullDownRefreshListView.f9166O000000o : customPullDownRefreshListView.f9166O000000o / 2.0f) * 16.0f));
                        if (customPullDownRefreshListView.O00000o && customPullDownRefreshListView.O00000o0 <= customPullDownRefreshListView.O00000Oo) {
                            customPullDownRefreshListView.O00000o0 = customPullDownRefreshListView.O00000Oo;
                            layoutParams.height = customPullDownRefreshListView.O00000o0 + customPullDownRefreshListView.O0000OOo;
                            customPullDownRefreshListView.O00000oo.setLayoutParams(layoutParams);
                            customPullDownRefreshListView.O00000oO.removeMessages(0);
                        } else if (customPullDownRefreshListView.O00000o0 <= 0) {
                            customPullDownRefreshListView.O00000o0 = 0;
                            layoutParams.height = customPullDownRefreshListView.O00000o0 + customPullDownRefreshListView.O0000OOo;
                            customPullDownRefreshListView.O00000oo.setLayoutParams(layoutParams);
                            customPullDownRefreshListView.O00000oO.removeMessages(0);
                        } else {
                            layoutParams.height = customPullDownRefreshListView.O00000o0 + customPullDownRefreshListView.O0000OOo;
                            customPullDownRefreshListView.O00000oo.setLayoutParams(layoutParams);
                        }
                    }
                    customPullDownRefreshListView.O00000oO.sendEmptyMessageDelayed(0, 16);
                } else if (message.what == 1) {
                    ViewGroup.LayoutParams layoutParams2 = customPullDownRefreshListView.O0000O0o.getLayoutParams();
                    if (customPullDownRefreshListView.O00000o0 >= 0) {
                        customPullDownRefreshListView.O00000o0 = (int) (((float) customPullDownRefreshListView.O00000o0) - ((customPullDownRefreshListView.O00000o ? customPullDownRefreshListView.f9166O000000o : customPullDownRefreshListView.f9166O000000o / 2.0f) * 16.0f));
                        if (customPullDownRefreshListView.O00000o0 <= 0) {
                            customPullDownRefreshListView.O00000o0 = 0;
                            layoutParams2.height = customPullDownRefreshListView.O00000o0 + customPullDownRefreshListView.O0000Oo0;
                            customPullDownRefreshListView.O0000O0o.setLayoutParams(layoutParams2);
                            customPullDownRefreshListView.O00000oO.removeMessages(1);
                            customPullDownRefreshListView.setSelection(customPullDownRefreshListView.getBottom());
                        } else {
                            layoutParams2.height = customPullDownRefreshListView.O00000o0 + customPullDownRefreshListView.O0000Oo0;
                            customPullDownRefreshListView.O0000O0o.setLayoutParams(layoutParams2);
                            customPullDownRefreshListView.setSelection(customPullDownRefreshListView.getBottom());
                        }
                    }
                    customPullDownRefreshListView.O00000oO.sendEmptyMessageDelayed(1, 16);
                }
                super.handleMessage(message);
            }
        }
    }

    public int getHeightWithoutFooter() {
        if (getAdapter() == null) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.O00oOooO)) {
                i += childAt.getHeight();
            }
        }
        return i;
    }
}
