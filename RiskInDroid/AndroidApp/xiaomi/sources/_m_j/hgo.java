package _m_j;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/ConfigurationObserverFragment2;", "Landroidx/fragment/app/Fragment;", "()V", "listener", "Lcom/xiaomi/smarthome/newui/page/ConfigurationObserverFragment2$OnConfigurationChangeListener;", "getListener", "()Lcom/xiaomi/smarthome/newui/page/ConfigurationObserverFragment2$OnConfigurationChangeListener;", "setListener", "(Lcom/xiaomi/smarthome/newui/page/ConfigurationObserverFragment2$OnConfigurationChangeListener;)V", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "OnConfigurationChangeListener", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hgo extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f18900O000000o;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/ConfigurationObserverFragment2$OnConfigurationChangeListener;", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void O000000o(Configuration configuration);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        O000000o o000000o = this.f18900O000000o;
        if (o000000o != null) {
            o000000o.O000000o(configuration);
        }
    }
}
