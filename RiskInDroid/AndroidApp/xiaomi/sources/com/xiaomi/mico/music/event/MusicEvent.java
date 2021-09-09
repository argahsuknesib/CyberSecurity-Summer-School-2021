package com.xiaomi.mico.music.event;

import com.xiaomi.mico.api.model.Remote;

public class MusicEvent {

    public static class ChannelListChanged {
    }

    public static class MusicSourceChanged {
    }

    public static class MusicUserPlay {
    }

    public static class PlayerStatusUpdate {
        public Remote.Response.PlayerStatus playerStatus;

        public PlayerStatusUpdate(Remote.Response.PlayerStatus playerStatus2) {
            this.playerStatus = playerStatus2;
        }
    }

    public static class SearchKeyChanged {
        public String key;

        public SearchKeyChanged(String str) {
            this.key = str;
        }
    }

    public static class CPAccountBindStatusChanged {
        public boolean unbind;

        public CPAccountBindStatusChanged() {
        }

        public CPAccountBindStatusChanged(boolean z) {
            this.unbind = z;
        }
    }

    public static class PlayerPositionEvent {
        public boolean fromUser;
        public int position;

        public PlayerPositionEvent(int i, boolean z) {
            this.position = i;
            this.fromUser = z;
        }
    }

    public static class PlayerControlerDisplay {
        public float yVelocity;

        public PlayerControlerDisplay(float f) {
            this.yVelocity = f;
        }

        public boolean display() {
            return this.yVelocity > 2000.0f;
        }

        public boolean hide() {
            return this.yVelocity < -2000.0f;
        }
    }
}
