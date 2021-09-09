package _m_j;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/LifeCycleObserverFragment;", "Landroidx/fragment/app/Fragment;", "()V", "lifeCycleObserver", "Lcom/xiaomi/smarthome/newui/adapter/LifeCycleObserverFragment$OnLifeChangeChangeListener;", "getLifeCycleObserver", "()Lcom/xiaomi/smarthome/newui/adapter/LifeCycleObserverFragment$OnLifeChangeChangeListener;", "setLifeCycleObserver", "(Lcom/xiaomi/smarthome/newui/adapter/LifeCycleObserverFragment$OnLifeChangeChangeListener;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPause", "onResume", "OnLifeChangeChangeListener", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbk extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f18743O000000o;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/LifeCycleObserverFragment$OnLifeChangeChangeListener;", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAppPause", "onAppResume", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void O000000o(int i, int i2, Intent intent);

        void O00000oO();

        void O0000Oo();
    }

    public final void onResume() {
        super.onResume();
        O000000o o000000o = this.f18743O000000o;
        if (o000000o != null) {
            o000000o.O00000oO();
        }
    }

    public final void onPause() {
        super.onPause();
        O000000o o000000o = this.f18743O000000o;
        if (o000000o != null) {
            o000000o.O0000Oo();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        O000000o o000000o = this.f18743O000000o;
        if (o000000o != null) {
            o000000o.O000000o(i, i2, intent);
        }
    }
}
