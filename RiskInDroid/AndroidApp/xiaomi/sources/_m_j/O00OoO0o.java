package _m_j;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public final class O00OoO0o implements O0000Oo {
    public final void O000000o(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(0);
        ((ImageView) view.findViewById(R.id.dialog_icon)).setAnimation(rotateAnimation);
    }
}
