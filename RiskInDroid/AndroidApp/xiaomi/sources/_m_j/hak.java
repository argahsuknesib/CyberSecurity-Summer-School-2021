package _m_j;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0005"}, d2 = {"scaleRollbackAnim", "", "Landroid/view/View;", "block", "Lkotlin/Function0;", "smarthome-widget_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class hak {
    public static final void O000000o(View view, iwb<iuh> iwb) {
        ixe.O00000o(view, "<this>");
        ixe.O00000o(iwb, "block");
        hag hag = new hag(0.9f);
        hag.setDuration(360);
        hag.setInterpolator(new LinearInterpolator());
        hag.setAnimationListener(new O000000o(iwb));
        view.startAnimation(hag);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/xiaomi/smarthome/newui/ScaleRollBackAnimKt$scaleRollbackAnim$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Animation.AnimationListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ iwb<iuh> f18706O000000o;

        public final void onAnimationRepeat(Animation animation) {
            ixe.O00000o(animation, "animation");
        }

        public final void onAnimationStart(Animation animation) {
            ixe.O00000o(animation, "animation");
        }

        O000000o(iwb<iuh> iwb) {
            this.f18706O000000o = iwb;
        }

        public final void onAnimationEnd(Animation animation) {
            ixe.O00000o(animation, "animation");
            this.f18706O000000o.invoke();
        }
    }
}
