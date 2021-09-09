package com.xiaomi.mico.setting.alarm.ring;

import _m_j.jgc;
import _m_j.jgi;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.mico.setting.alarm.ring.BaseRingFragment;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseRingFragment extends MicoBaseFragment {
    Remote.Response.AlarmRing currentAlarmRing;
    RecyclerView recyclerView;

    /* access modifiers changed from: package-private */
    public void initRingsData() {
    }

    /* access modifiers changed from: protected */
    public void onRingConfigUpdated() {
    }

    /* access modifiers changed from: package-private */
    public abstract String ringType();

    public BaseRingFragment setCurrentAlarmRing(Remote.Response.AlarmRing alarmRing) {
        if (alarmRing != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("SELECTED_ALARM_RING", alarmRing);
            setArguments(bundle);
        }
        return this;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.view_linear_recycler_view, (ViewGroup) null);
        ButterKnife.bind(this, inflate);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.linear_recycle_view);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.currentAlarmRing = (Remote.Response.AlarmRing) arguments.getSerializable("SELECTED_ALARM_RING");
        }
        initRingsData();
        jgc.O000000o().O000000o(this);
        return inflate;
    }

    public List<Remote.Response.AlarmRing> loadRingList(String str) {
        ArrayList arrayList = new ArrayList();
        List<Remote.Response.AlarmRing> loadTabRings = AlarmHelper.loadTabRings(str);
        if (loadTabRings != null) {
            if (this.currentAlarmRing != null && ringType().equalsIgnoreCase(this.currentAlarmRing.tab) && !hasCurrentRingOfRingList(loadTabRings)) {
                arrayList.add(this.currentAlarmRing);
            }
            arrayList.addAll(loadTabRings);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean hasCurrentRingOfRingList(List<Remote.Response.AlarmRing> list) {
        for (Remote.Response.AlarmRing next : list) {
            if (next.id.equals(this.currentAlarmRing.id) && next.name.equals(this.currentAlarmRing.name)) {
                return true;
            }
        }
        return false;
    }

    public void notifySelectRingChange(Remote.Response.AlarmRing alarmRing) {
        ((AlarmRingActivity) getActivity()).onAlarmRingChange(alarmRing);
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onAlarmRingChange(MicoEvent.AlarmRingChange alarmRingChange) {
        notifySelectRingChange(alarmRingChange.ring);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onRingCofnigUpdated(MicoEvent.RingConfigUpdated ringConfigUpdated) {
        onRingConfigUpdated();
    }

    public class RingAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<Remote.Response.AlarmRing> rings;
        Remote.Response.AlarmRing selectedRing;

        public RingAdapter() {
        }

        public void notifySelectRingChange(Remote.Response.AlarmRing alarmRing) {
            this.selectedRing = alarmRing;
            notifyDataSetChanged();
        }

        public void setRings(List<Remote.Response.AlarmRing> list, Remote.Response.AlarmRing alarmRing) {
            this.rings = list;
            this.selectedRing = alarmRing;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RingItemsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_alarm_ring_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((RingItemsViewHolder) o000OOo0).bindView(this.rings.get(i), this.selectedRing);
        }

        public int getItemCount() {
            List<Remote.Response.AlarmRing> list = this.rings;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    static class RingItemsViewHolder extends RecyclerView.O000OOo0 {
        TextView nameView;
        Remote.Response.AlarmRing ring;
        ImageView selectedView;

        public RingItemsViewHolder(View view) {
            super(view);
            this.nameView = (TextView) view.findViewById(R.id.alarm_ring_name);
            this.selectedView = (ImageView) view.findViewById(R.id.alarm_ring_selected);
            view.findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$BaseRingFragment$RingItemsViewHolder$Ra9xfMLFa8s6hkWi7hI5vVgqdTU */

                public final void onClick(View view) {
                    BaseRingFragment.RingItemsViewHolder.this.lambda$new$0$BaseRingFragment$RingItemsViewHolder(view);
                }
            });
        }

        public void bindView(Remote.Response.AlarmRing alarmRing, Remote.Response.AlarmRing alarmRing2) {
            if (!TextUtils.isEmpty(alarmRing.display_name)) {
                this.nameView.setText(alarmRing.display_name);
            } else {
                this.nameView.setText(alarmRing.name);
            }
            this.ring = alarmRing;
            if (alarmRing2 == null || !alarmRing.name.equals(alarmRing2.name)) {
                this.selectedView.setVisibility(4);
                this.nameView.setSelected(false);
                return;
            }
            this.selectedView.setVisibility(0);
            this.nameView.setSelected(true);
        }

        /* renamed from: onClick */
        public void lambda$new$0$BaseRingFragment$RingItemsViewHolder(View view) {
            jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(this.ring));
        }
    }
}
