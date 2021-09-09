package com.xiaomi.mico.setting.alarm.ring;

import _m_j.jgc;
import _m_j.jgi;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.QQMusicAuthPopupView;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.mico.setting.alarm.ring.BaseRingFragment;
import com.xiaomi.mico.setting.alarm.ring.MusicRingFragment;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class MusicRingFragment extends BaseRingFragment {
    MusicRingAdapter adapter;

    /* access modifiers changed from: package-private */
    public String ringType() {
        return "音乐";
    }

    /* access modifiers changed from: package-private */
    public void initRingsData() {
        this.adapter = new MusicRingAdapter();
        this.recyclerView.setAdapter(this.adapter);
        ArrayList arrayList = new ArrayList();
        List<Remote.Response.AlarmRing> loadTabRings = AlarmHelper.loadTabRings(ringType());
        if (loadTabRings != null) {
            arrayList.addAll(loadTabRings);
        }
        this.adapter.setRings(arrayList, this.currentAlarmRing);
    }

    /* access modifiers changed from: protected */
    public void onRingConfigUpdated() {
        super.onRingConfigUpdated();
        ArrayList arrayList = new ArrayList();
        List<Remote.Response.AlarmRing> loadTabRings = AlarmHelper.loadTabRings(ringType());
        if (loadTabRings != null) {
            arrayList.addAll(loadTabRings);
        }
        this.adapter.setRings(arrayList, this.currentAlarmRing);
    }

    public void notifySelectRingChange(Remote.Response.AlarmRing alarmRing) {
        super.notifySelectRingChange(alarmRing);
        MusicRingAdapter musicRingAdapter = this.adapter;
        if (musicRingAdapter != null) {
            musicRingAdapter.notifySelectRingChange(alarmRing);
        }
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onCPAccountBindStatusChanged(MusicEvent.CPAccountBindStatusChanged cPAccountBindStatusChanged) {
        MusicRingAdapter musicRingAdapter = this.adapter;
        if (musicRingAdapter != null) {
            musicRingAdapter.notifyDataSetChanged();
        }
    }

    public class MusicRingAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<Remote.Response.AlarmRing> rings;
        Remote.Response.AlarmRing selectedRing;
        Remote.Response.AlarmRing songRing;

        public MusicRingAdapter() {
        }

        /* access modifiers changed from: package-private */
        public void notifySelectRingChange(Remote.Response.AlarmRing alarmRing) {
            this.selectedRing = alarmRing;
            notifyDataSetChanged();
        }

        /* access modifiers changed from: package-private */
        public void setRings(List<Remote.Response.AlarmRing> list, Remote.Response.AlarmRing alarmRing) {
            this.rings = list;
            this.selectedRing = alarmRing;
            if (alarmRing == null || !MusicRingFragment.this.ringType().equalsIgnoreCase(alarmRing.tab) || AlarmHelper.isSystemAlarmRing(alarmRing) || AlarmHelper.isMusicAlarmDefaultRing(alarmRing) || "music.song".equals(alarmRing.id) || MusicRingFragment.this.hasCurrentRingOfRingList(list)) {
                if (MusicRingFragment.this.hasCurrentRingOfRingList(list)) {
                    this.songRing = null;
                }
            } else if (!TextUtils.isEmpty(alarmRing.id)) {
                this.songRing = alarmRing;
            } else {
                this.selectedRing = AlarmHelper.getSystemAlarmRing();
            }
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new AuthInvalidViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.layout_qqmusic_not_auth_hint, viewGroup, false));
            }
            if (i == 1) {
                return new MusicRingItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_alarm_music_ring_top, viewGroup, false));
            }
            return new BaseRingFragment.RingItemsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_alarm_ring_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (o000OOo0 instanceof BaseRingFragment.RingItemsViewHolder) {
                ((BaseRingFragment.RingItemsViewHolder) o000OOo0).bindView(this.rings.get(i - 1), this.selectedRing);
            } else if (o000OOo0 instanceof MusicRingItemViewHolder) {
                ((MusicRingItemViewHolder) o000OOo0).bindView(this.selectedRing, this.songRing);
            }
        }

        public int getItemViewType(int i) {
            if (!AccountProfile.current().isQQMusicSource() || AccountProfile.current().isQQAccountAuthValid()) {
                return i == 0 ? 1 : 2;
            }
            return 0;
        }

        public int getItemCount() {
            if ((!AccountProfile.current().isQQMusicSource() || AccountProfile.current().isQQAccountAuthValid()) && ContainerUtil.hasData(this.rings)) {
                return this.rings.size() + 1;
            }
            return 1;
        }
    }

    static class AuthInvalidViewHolder extends RecyclerView.O000OOo0 {
        AuthInvalidViewHolder(View view) {
            super(view);
            view.findViewById(R.id.qq_bind).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$MusicRingFragment$AuthInvalidViewHolder$SHtdB3sD97slNY8x9ffui2DBvI */

                public final void onClick(View view) {
                    MusicRingFragment.AuthInvalidViewHolder.this.lambda$new$0$MusicRingFragment$AuthInvalidViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$MusicRingFragment$AuthInvalidViewHolder(View view) {
            onClick();
        }

        public void onClick() {
            QQMusicAuthPopupView.showAuthAlert(this.itemView.getContext(), AccountProfile.current().getQQBindStatus());
        }
    }

    static class MusicRingItemViewHolder extends RecyclerView.O000OOo0 {
        Remote.Response.AlarmRing songRing;
        View songRingLayout;
        TextView songRingNameView;
        ImageView songRingSelectedView;
        Remote.Response.AlarmRing systemRing = AlarmHelper.getSystemAlarmRing();
        TextView systemRingNameView;
        ImageView systemRingSelectedView;

        MusicRingItemViewHolder(View view) {
            super(view);
            this.songRingNameView = (TextView) view.findViewById(R.id.song_ring_name);
            this.songRingSelectedView = (ImageView) view.findViewById(R.id.song_ring_selected);
            this.songRingLayout = view.findViewById(R.id.song_ring_layout);
            this.systemRingSelectedView = (ImageView) view.findViewById(R.id.system_ring_selected);
            this.systemRingNameView = (TextView) view.findViewById(R.id.system_ring_name);
            view.findViewById(R.id.select_music_layout).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$MusicRingFragment$MusicRingItemViewHolder$fwTPuWDq4yhT9lexXbXuXIss20 */

                public final void onClick(View view) {
                    MusicRingFragment.MusicRingItemViewHolder.this.lambda$new$0$MusicRingFragment$MusicRingItemViewHolder(view);
                }
            });
            view.findViewById(R.id.system_ring_layout).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$MusicRingFragment$MusicRingItemViewHolder$AZBPS37fPgD9gU38q6jelcmyliQ */

                public final void onClick(View view) {
                    MusicRingFragment.MusicRingItemViewHolder.this.lambda$new$1$MusicRingFragment$MusicRingItemViewHolder(view);
                }
            });
            view.findViewById(R.id.song_ring_layout).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$MusicRingFragment$MusicRingItemViewHolder$94g40hBb7vqHVxLDLg90ZSZOAMk */

                public final void onClick(View view) {
                    MusicRingFragment.MusicRingItemViewHolder.this.lambda$new$2$MusicRingFragment$MusicRingItemViewHolder(view);
                }
            });
        }

        public void bindView(Remote.Response.AlarmRing alarmRing, Remote.Response.AlarmRing alarmRing2) {
            this.songRing = null;
            if (alarmRing != null && "music.song".equals(alarmRing.id)) {
                this.songRing = alarmRing;
            }
            if (this.songRing == null && alarmRing2 != null) {
                this.songRing = alarmRing2;
            }
            if (this.songRing != null) {
                this.songRingLayout.setVisibility(0);
                if (this.songRing.name != null) {
                    if (!TextUtils.isEmpty(this.songRing.name)) {
                        this.songRingNameView.setText(this.songRing.name);
                    } else {
                        this.songRingNameView.setText(this.songRing.query);
                    }
                    if (alarmRing == null || !this.songRing.name.equals(alarmRing.name)) {
                        this.songRingSelectedView.setVisibility(4);
                        this.songRingNameView.setSelected(false);
                    } else {
                        this.songRingSelectedView.setVisibility(0);
                        this.songRingNameView.setSelected(true);
                    }
                }
            } else {
                this.songRingLayout.setVisibility(8);
            }
            if (alarmRing == null || !this.systemRing.name.equals(alarmRing.name)) {
                this.systemRingSelectedView.setVisibility(4);
                this.systemRingNameView.setSelected(false);
                return;
            }
            this.systemRingSelectedView.setVisibility(0);
            this.systemRingNameView.setSelected(true);
        }

        /* renamed from: onClick */
        public void lambda$new$2$MusicRingFragment$MusicRingItemViewHolder(View view) {
            int id = view.getId();
            if (id == R.id.select_music_layout) {
                view.getContext().startActivity(new Intent(view.getContext(), SongSearchActivity.class));
            } else if (id == R.id.system_ring_layout) {
                jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(this.systemRing));
            } else if (id == R.id.song_ring_layout && this.songRing != null) {
                jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(this.songRing));
            }
        }
    }
}
