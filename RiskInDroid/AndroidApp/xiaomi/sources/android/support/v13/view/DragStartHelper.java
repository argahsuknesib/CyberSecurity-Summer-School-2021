package android.support.v13.view;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

@TargetApi(13)
@RequiresApi(13)
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() {
        /* class android.support.v13.view.DragStartHelper.AnonymousClass1 */

        public boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    };
    private final View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        /* class android.support.v13.view.DragStartHelper.AnonymousClass2 */

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    };
    private final View mView;

    public interface OnDragStartListener {
        boolean onDragStart(View view, DragStartHelper dragStartHelper);
    }

    public DragStartHelper(View view, OnDragStartListener onDragStartListener) {
        this.mView = view;
        this.mListener = onDragStartListener;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r2 != 3) goto L_0x004c;
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (MotionEventCompat.isFromSource(motionEvent, 8194) && (MotionEventCompat.getButtonState(motionEvent) & 1) != 0 && !this.mDragging && !(this.mLastTouchX == x && this.mLastTouchY == y)) {
                        this.mLastTouchX = x;
                        this.mLastTouchY = y;
                        this.mDragging = this.mListener.onDragStart(view, this);
                        return this.mDragging;
                    }
                }
            }
            this.mDragging = false;
        } else {
            this.mLastTouchX = x;
            this.mLastTouchY = y;
        }
        return false;
    }

    public boolean onLongClick(View view) {
        return this.mListener.onDragStart(view, this);
    }

    public void getTouchPosition(Point point) {
        point.set(this.mLastTouchX, this.mLastTouchY);
    }
}
