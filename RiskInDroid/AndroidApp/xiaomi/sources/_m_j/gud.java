package _m_j;

import android.content.Context;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Home;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;

public interface gud {
    guc createDeviceMainFragment();

    void destoryBottomTabImgsApi();

    void finishCurrentSmartConfig(Context context, Device device);

    void getCommonDeviceModel();

    String getDeviceMainPageName();

    String getDeviceMainPageSimpleName();

    String getWallpaper();

    void initBottomTabImgsApi();

    Observable<Boolean> markAsFreq(Home home, List<String> list);

    Observable<Boolean> markAsUnFreq(Home home, List<String> list);

    void notifyDoubleClick();

    void notifySingleClick();

    void onPageSelected(FragmentActivity fragmentActivity, int i);

    void reportOfflineStatAndClean();

    void sendBroadcastByShareMsg();

    void setBottomTabIconByTag(String str, ImageView imageView);

    void setWallpaper(String str);

    void subscribeMainDeviceTabAnimManager(Consumer<Boolean> consumer);
}
