package com.xiaomi.mico.common.widget;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class LifeListenerFragment extends Fragment {
    private AttachedPageLifeCycleListener attachedPageLifeCycleListener;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void addLifeListener(AttachedPageLifeCycleListener attachedPageLifeCycleListener2) {
        this.attachedPageLifeCycleListener = attachedPageLifeCycleListener2;
    }

    public void removeLifeListener() {
        this.attachedPageLifeCycleListener = null;
    }

    public void onResume() {
        super.onResume();
        AttachedPageLifeCycleListener attachedPageLifeCycleListener2 = this.attachedPageLifeCycleListener;
        if (attachedPageLifeCycleListener2 != null) {
            attachedPageLifeCycleListener2.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        removeLifeListener();
    }
}
