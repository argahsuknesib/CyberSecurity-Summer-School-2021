package _m_j;

import android.graphics.RectF;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.device.Device;

public interface eye {
    ImageView getWallPaperView(FragmentActivity fragmentActivity);

    void onClickCommonUseDevice(FragmentActivity fragmentActivity, Device device, RectF rectF, String str);
}
