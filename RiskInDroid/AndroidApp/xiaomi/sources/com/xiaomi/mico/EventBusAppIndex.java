package com.xiaomi.mico;

import _m_j.iah;
import _m_j.jgo;
import _m_j.jgp;
import _m_j.jgq;
import _m_j.jgr;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.common.event.DeDaoAuthEvent;
import com.xiaomi.mico.common.event.KKBoxAuthEvent;
import com.xiaomi.mico.common.event.QQMusicAuthEvent;
import com.xiaomi.mico.common.widget.KKBoxAuthPopupView;
import com.xiaomi.mico.common.widget.QQMusicAuthDelegate;
import com.xiaomi.mico.module.update.UpdateAssistantActivity;
import com.xiaomi.mico.module.update.UpgradeEvent;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.patchwall.CollectionFragment;
import com.xiaomi.mico.music.patchwall.CollectionFragmentV2;
import com.xiaomi.mico.music.patchwall.DeDaoPatchWallFragment;
import com.xiaomi.mico.music.patchwall.KKBoxPatchWallFragment;
import com.xiaomi.mico.music.patchwall.MySongsFragment;
import com.xiaomi.mico.music.patchwall.QQPatchWallFragment;
import com.xiaomi.mico.music.patchwall.RadioPatchWallFragment;
import com.xiaomi.mico.music.patchwall.adapter.KidsPatchWallAdapter;
import com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment;
import com.xiaomi.mico.music.player.PlayerControler;
import com.xiaomi.mico.music.player.PlayerListManager;
import com.xiaomi.mico.music.player.PlayerLrcFragment;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.mico.music.search.SchBaseFragment;
import com.xiaomi.mico.setting.MicoMyActivity;
import com.xiaomi.mico.setting.alarm.ring.BaseRingFragment;
import com.xiaomi.mico.setting.alarm.ring.MusicRingFragment;
import com.xiaomi.mico.setting.alarm.ring.VidoRingFragment;
import com.xiaomi.mico.setting.mijia.event.MijiaEvent;
import com.xiaomi.mico.setting.stereo.StereoConfigActivity;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusAppIndex implements jgq {
    private static final Map<Class<?>, jgp> SUBSCRIBER_INDEX = new HashMap();

    static {
        putIndex(new jgo(SchBaseFragment.class, new jgr[]{new jgr("onSearchKeyChanged", MusicEvent.SearchKeyChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(QQMusicAuthDelegate.class, new jgr[]{new jgr("onMiniProgramAuthEvent", iah.class, ThreadMode.MAIN), new jgr("onQQMusicAuthEvent", QQMusicAuthEvent.class, ThreadMode.MAIN), new jgr("onQQMusicLogin", QQMusicAuthEvent.QQMusicLogin.class, ThreadMode.MAIN), new jgr("onQQMusicCancelLogin", QQMusicAuthEvent.QQMusicCancelLogin.class, ThreadMode.MAIN)}));
        putIndex(new jgo(DeDaoPatchWallFragment.class, new jgr[]{new jgr("onDedaoAuthStatusChanged", DeDaoAuthEvent.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(KKBoxAuthPopupView.class, new jgr[]{new jgr("onKKBoxAuthEvent", KKBoxAuthEvent.class, ThreadMode.MAIN)}));
        putIndex(new jgo(MicoSelectPatchWallFragment.class, new jgr[]{new jgr("onCPAccountBindStatusChanged", MusicEvent.CPAccountBindStatusChanged.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(KKBoxPatchWallFragment.class, new jgr[]{new jgr("onKKBoxAccountBindStatusChanged", MusicEvent.CPAccountBindStatusChanged.class, ThreadMode.MAIN, 0, true), new jgr("onKKBoxAuthEvent", KKBoxAuthEvent.class, ThreadMode.MAIN)}));
        putIndex(new jgo(BaseRingFragment.class, new jgr[]{new jgr("onAlarmRingChange", MicoEvent.AlarmRingChange.class, ThreadMode.MAIN), new jgr("onRingCofnigUpdated", MicoEvent.RingConfigUpdated.class, ThreadMode.MAIN)}));
        putIndex(new jgo(StereoConfigActivity.class, new jgr[]{new jgr("onPlayerStatusUpdate", MusicEvent.PlayerStatusUpdate.class, ThreadMode.MAIN)}));
        putIndex(new jgo(KidsPatchWallAdapter.class, new jgr[]{new jgr("onCurrentMicoChanged", MicoEvent.CurrentMicoChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(MySongsFragment.class, new jgr[]{new jgr("onChannelListChanged", MusicEvent.ChannelListChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(PlayerStatusTrack.class, new jgr[]{new jgr("onPlayerStatusUpdate", MusicEvent.PlayerStatusUpdate.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(PlayerLrcFragment.class, new jgr[]{new jgr("onPlayerPositionChanged", MusicEvent.PlayerPositionEvent.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(UpdateAssistantActivity.class, new jgr[]{new jgr("onMessageEvent", UpgradeEvent.class, ThreadMode.MAIN)}));
        putIndex(new jgo(CollectionFragment.class, new jgr[]{new jgr("onChannelListChanged", MusicEvent.ChannelListChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(MusicRingFragment.class, new jgr[]{new jgr("onCPAccountBindStatusChanged", MusicEvent.CPAccountBindStatusChanged.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(QQPatchWallFragment.class, new jgr[]{new jgr("onCPAccountBindStatusChanged", MusicEvent.CPAccountBindStatusChanged.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(MicoMyActivity.class, new jgr[]{new jgr("onChannelListChanged", MusicEvent.ChannelListChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(CollectionFragmentV2.class, new jgr[]{new jgr("onChannelListChanged", MusicEvent.ChannelListChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(VidoRingFragment.class, new jgr[]{new jgr("onAlarmRingChange", MicoEvent.AlarmRingChange.class, ThreadMode.MAIN)}));
        putIndex(new jgo(RadioPatchWallFragment.class, new jgr[]{new jgr("onKKBoxAccountBindStatusChanged", MusicEvent.CPAccountBindStatusChanged.class, ThreadMode.MAIN, 0, true)}));
        putIndex(new jgo(MicoMainFragment.class, new jgr[]{new jgr("onCurrentMicoChanged", MicoEvent.CurrentMicoChanged.class, ThreadMode.MAIN), new jgr("onCurrentMicoInfoUpdate", MicoEvent.CurrentMicoInfoUpdate.class, ThreadMode.MAIN), new jgr("onNeedChangePlayerControler", MusicEvent.PlayerControlerDisplay.class, ThreadMode.MAIN), new jgr("onMusicSourceChanged", MusicEvent.MusicSourceChanged.class, ThreadMode.MAIN), new jgr("onHomeChanged", MijiaEvent.MijiaCurrHomeChanged.class, ThreadMode.MAIN)}));
        putIndex(new jgo(PlayerManager.class, new jgr[]{new jgr("onCurrentMicoChanged", MicoEvent.CurrentMicoChanged.class, ThreadMode.MAIN, 100, false)}));
        putIndex(new jgo(PlayerControler.class, new jgr[]{new jgr("onMusicPlayedByUser", MusicEvent.MusicUserPlay.class, ThreadMode.MAIN), new jgr("onForceFreshPlayingDataEvent", PlayerListManager.ForceFreshPlayingDataEvent.class, ThreadMode.MAIN)}));
    }

    private static void putIndex(jgp jgp) {
        SUBSCRIBER_INDEX.put(jgp.O000000o(), jgp);
    }

    public jgp getSubscriberInfo(Class<?> cls) {
        jgp jgp = SUBSCRIBER_INDEX.get(cls);
        if (jgp != null) {
            return jgp;
        }
        return null;
    }
}
