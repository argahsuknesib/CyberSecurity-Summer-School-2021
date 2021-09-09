package _m_j;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.rnscreens.Screen;

public class dfy extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Screen f14592O000000o;

    public dfy() {
        throw new IllegalStateException("Screen fragments should never be restored");
    }

    @SuppressLint({"ValidFragment"})
    public dfy(Screen screen) {
        this.f14592O000000o = screen;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f14592O000000o;
    }

    public final Screen O000000o() {
        return this.f14592O000000o;
    }

    public void onDestroy() {
        super.onDestroy();
        ((UIManagerModule) ((ReactContext) this.f14592O000000o.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new dfx(this.f14592O000000o.getId()));
    }
}
