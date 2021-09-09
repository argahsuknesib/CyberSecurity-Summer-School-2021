package _m_j;

import com.airbnb.lottie.LottieAnimationView;
import com.xiaomi.smarthome.R;
import java.util.Random;

public final class gpo {
    public static void O000000o(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null && !lottieAnimationView.isAnimating()) {
            lottieAnimationView.setVisibility(4);
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setAnimation(O000000o());
            lottieAnimationView.setProgress(0.0f);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
            lottieAnimationView.setVisibility(0);
        }
    }

    private static int O000000o() {
        switch (new Random().nextInt(7)) {
            case 0:
                return R.raw.mj_common_refresh_airpurify;
            case 1:
                return R.raw.mj_common_refresh_bulb;
            case 2:
                return R.raw.mj_common_refresh_camera;
            case 3:
                return R.raw.mj_common_refresh_lock;
            case 4:
                return R.raw.mj_common_refresh_speaker;
            case 5:
                return R.raw.mj_common_refresh_tv;
            case 6:
                return R.raw.mj_common_refresh_vacuum;
            default:
                return -1;
        }
    }

    public static void O00000Oo(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
        }
    }
}
