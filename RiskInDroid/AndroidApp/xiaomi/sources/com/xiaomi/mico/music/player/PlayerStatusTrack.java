package com.xiaomi.mico.music.player;

import _m_j.jgc;
import _m_j.jgi;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.AssertionUtil;
import com.xiaomi.mico.music.event.MusicEvent;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class PlayerStatusTrack {
    private static PlayerStatusTrack sInstance = new PlayerStatusTrack();
    private List<onTrackListener> mOnTrackListeners = new ArrayList();

    public interface onTrackListener {
        void onTrack(Remote.Response.PlayerStatus playerStatus);
    }

    public static PlayerStatusTrack getInstance() {
        return sInstance;
    }

    public void register(onTrackListener ontracklistener) {
        AssertionUtil.checkUiThread();
        if (ontracklistener != null) {
            this.mOnTrackListeners.add(ontracklistener);
            if (this.mOnTrackListeners.size() == 1) {
                jgc.O000000o().O000000o(this);
                return;
            }
            MusicEvent.PlayerStatusUpdate playerStatusUpdate = (MusicEvent.PlayerStatusUpdate) jgc.O000000o().O000000o(MusicEvent.PlayerStatusUpdate.class);
            if (playerStatusUpdate != null) {
                ontracklistener.onTrack(playerStatusUpdate.playerStatus);
            }
        }
    }

    public void unregister(onTrackListener ontracklistener) {
        AssertionUtil.checkUiThread();
        if (ontracklistener != null) {
            this.mOnTrackListeners.remove(ontracklistener);
            if (this.mOnTrackListeners.size() == 0) {
                jgc.O000000o().O00000o0(this);
            }
        }
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onPlayerStatusUpdate(MusicEvent.PlayerStatusUpdate playerStatusUpdate) {
        Remote.Response.PlayerStatus playerStatus = playerStatusUpdate.playerStatus;
        for (onTrackListener onTrack : this.mOnTrackListeners) {
            onTrack.onTrack(playerStatus);
        }
    }
}
