package _m_j;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public final class awm extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    awd f12666O000000o;

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        awd awd = this.f12666O000000o;
        if (awd != null) {
            awd.O00000Oo(getResources().getConfiguration());
        }
    }

    public final void onResume() {
        super.onResume();
        awd awd = this.f12666O000000o;
        if (awd != null) {
            awd.O000000o();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        awd awd = this.f12666O000000o;
        if (awd != null) {
            awd.O00000Oo();
            this.f12666O000000o = null;
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        awd awd = this.f12666O000000o;
        if (awd != null) {
            awd.O000000o(configuration);
        }
    }
}
