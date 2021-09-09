package _m_j;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ayb extends RecyclerView.O000OOo0 implements axw {
    private int mAfterSwipeReaction = 0;
    private float mHorizontalSwipeAmount;
    private float mMaxDownSwipeAmount = 65537.0f;
    private float mMaxLeftSwipeAmount = -65536.0f;
    private float mMaxRightSwipeAmount = 65536.0f;
    private float mMaxUpSwipeAmount = -65537.0f;
    private int mSwipeResult = 0;
    private int mSwipeStateFlags;
    private float mVerticalSwipeAmount;

    public abstract View getSwipeableContainerView();

    public void onSlideAmountUpdated(float f, float f2, boolean z) {
    }

    public ayb(View view) {
        super(view);
    }

    public void setSwipeStateFlags(int i) {
        this.mSwipeStateFlags = i;
    }

    public int getSwipeStateFlags() {
        return this.mSwipeStateFlags;
    }

    public void setSwipeResult(int i) {
        this.mSwipeResult = i;
    }

    public int getSwipeResult() {
        return this.mSwipeResult;
    }

    public int getAfterSwipeReaction() {
        return this.mAfterSwipeReaction;
    }

    public void setAfterSwipeReaction(int i) {
        this.mAfterSwipeReaction = i;
    }

    public void setSwipeItemVerticalSlideAmount(float f) {
        this.mVerticalSwipeAmount = f;
    }

    public float getSwipeItemVerticalSlideAmount() {
        return this.mVerticalSwipeAmount;
    }

    public void setSwipeItemHorizontalSlideAmount(float f) {
        this.mHorizontalSwipeAmount = f;
    }

    public float getSwipeItemHorizontalSlideAmount() {
        return this.mHorizontalSwipeAmount;
    }

    public void setMaxLeftSwipeAmount(float f) {
        this.mMaxLeftSwipeAmount = f;
    }

    public float getMaxLeftSwipeAmount() {
        return this.mMaxLeftSwipeAmount;
    }

    public void setMaxUpSwipeAmount(float f) {
        this.mMaxUpSwipeAmount = f;
    }

    public float getMaxUpSwipeAmount() {
        return this.mMaxUpSwipeAmount;
    }

    public void setMaxRightSwipeAmount(float f) {
        this.mMaxRightSwipeAmount = f;
    }

    public float getMaxRightSwipeAmount() {
        return this.mMaxRightSwipeAmount;
    }

    public void setMaxDownSwipeAmount(float f) {
        this.mMaxDownSwipeAmount = f;
    }

    public float getMaxDownSwipeAmount() {
        return this.mMaxDownSwipeAmount;
    }
}
