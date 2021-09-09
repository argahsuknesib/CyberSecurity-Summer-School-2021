package com.xiaomi.smarthome.scene;

import _m_j.hja;
import _m_j.hnj;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SceneTabSwitcher {
    INSTANCE;
    
    private static List<Pair<Integer, O000000o>> sTabsUnfiltered = Arrays.asList(Pair.create(Integer.valueOf((int) R.string.smarthome_new_scene_choiceness), $$Lambda$SceneTabSwitcher$YVHG71Om8174PUV0PN9Y17B7IQE.INSTANCE), Pair.create(Integer.valueOf((int) R.string.smarthome_new_scene_recommend), $$Lambda$SceneTabSwitcher$6aKwSjjFopJhNbJs61ey4uvhX60.INSTANCE), Pair.create(Integer.valueOf((int) R.string.smarthome_new_scene_custom), $$Lambda$SceneTabSwitcher$JDtexLAd2sFkMMmVE29rYnEPCH8.INSTANCE));
    private WeakReference<hnj> mHost;

    interface O000000o {
        boolean test();
    }

    public final void init(hnj hnj) {
        this.mHost = new WeakReference<>(hnj);
    }

    public final List<Integer> getPageItems() {
        ArrayList arrayList = new ArrayList();
        for (Pair next : sTabsUnfiltered) {
            if (((O000000o) next.second).test()) {
                arrayList.add(next.first);
            }
        }
        return arrayList;
    }

    private int indexOfTab(int i) {
        return getPageItems().indexOf(Integer.valueOf(i));
    }

    public final boolean toChoicenessTab() {
        return toTab(R.string.smarthome_new_scene_choiceness);
    }

    public final boolean toSceneRecommendTab() {
        return toTab(R.string.smarthome_new_scene_recommend);
    }

    public final boolean toSceneListTab() {
        return toTab(R.string.smarthome_new_scene_my);
    }

    public final boolean toSceneLogTab() {
        return toTab(R.string.smarthome_new_scene_log);
    }

    private boolean toTab(int i) {
        WeakReference<hnj> weakReference;
        int indexOfTab = indexOfTab(i);
        if (!(indexOfTab == -1 || (weakReference = this.mHost) == null || weakReference.get() == null)) {
            hnj hnj = this.mHost.get();
            if (hnj.O0000Oo != null && indexOfTab >= 0 && hnj.O00000o.getChildCount() > indexOfTab) {
                hnj.O0000Oo.setCurrentItem(indexOfTab);
                return true;
            }
        }
        return false;
    }

    public final void showNotifyOpenGuideDialogForSmart() {
        FragmentActivity activity;
        WeakReference<hnj> weakReference = this.mHost;
        if (weakReference != null && weakReference.get() != null && (activity = this.mHost.get().getActivity()) != null) {
            hja.O000000o o000000o = hja.f18973O000000o;
            hja.O000000o.O000000o(activity);
        }
    }
}
