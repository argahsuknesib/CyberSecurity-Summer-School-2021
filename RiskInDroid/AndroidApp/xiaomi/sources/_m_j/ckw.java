package _m_j;

import android.view.MotionEvent;
import android.view.View;

public final class ckw implements View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f13973O000000o;
    private int O00000Oo;

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f13973O000000o = (int) motionEvent.getRawX();
            this.O00000Oo = (int) motionEvent.getRawY();
            view.getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            int rawX = ((int) motionEvent.getRawX()) - this.f13973O000000o;
            int rawY = ((int) motionEvent.getRawY()) - this.O00000Oo;
            if (Math.abs(rawX) > 3 || Math.abs(rawY) > 3) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }
}
