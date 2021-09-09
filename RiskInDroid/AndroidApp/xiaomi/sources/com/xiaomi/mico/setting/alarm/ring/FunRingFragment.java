package com.xiaomi.mico.setting.alarm.ring;

import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.setting.alarm.ring.BaseRingFragment;

public class FunRingFragment extends BaseRingFragment {
    BaseRingFragment.RingAdapter adapter;

    /* access modifiers changed from: package-private */
    public String ringType() {
        return "趣味";
    }

    /* access modifiers changed from: package-private */
    public void initRingsData() {
        this.adapter = new BaseRingFragment.RingAdapter();
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setRings(loadRingList(ringType()), this.currentAlarmRing);
    }

    /* access modifiers changed from: protected */
    public void onRingConfigUpdated() {
        super.onRingConfigUpdated();
        this.adapter.setRings(loadRingList(ringType()), this.currentAlarmRing);
    }

    public void notifySelectRingChange(Remote.Response.AlarmRing alarmRing) {
        super.notifySelectRingChange(alarmRing);
        BaseRingFragment.RingAdapter ringAdapter = this.adapter;
        if (ringAdapter != null) {
            ringAdapter.notifySelectRingChange(alarmRing);
        }
    }
}
