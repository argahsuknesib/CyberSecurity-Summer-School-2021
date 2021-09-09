package com.xiaomi.smarthome.uwb.mico;

import _m_j.ixe;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/ContentInfo;", "", "playerStatus", "Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;", "song", "Lcom/xiaomi/mico/api/model/Music$Song;", "(Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;Lcom/xiaomi/mico/api/model/Music$Song;)V", "getPlayerStatus", "()Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;", "setPlayerStatus", "(Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;)V", "getSong", "()Lcom/xiaomi/mico/api/model/Music$Song;", "setSong", "(Lcom/xiaomi/mico/api/model/Music$Song;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContentInfo {
    private Remote.Response.PlayerStatus playerStatus;
    private Music.Song song;

    public static /* synthetic */ ContentInfo copy$default(ContentInfo contentInfo, Remote.Response.PlayerStatus playerStatus2, Music.Song song2, int i, Object obj) {
        if ((i & 1) != 0) {
            playerStatus2 = contentInfo.playerStatus;
        }
        if ((i & 2) != 0) {
            song2 = contentInfo.song;
        }
        return contentInfo.copy(playerStatus2, song2);
    }

    public final Remote.Response.PlayerStatus component1() {
        return this.playerStatus;
    }

    public final Music.Song component2() {
        return this.song;
    }

    public final ContentInfo copy(Remote.Response.PlayerStatus playerStatus2, Music.Song song2) {
        ixe.O00000o(playerStatus2, "playerStatus");
        return new ContentInfo(playerStatus2, song2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentInfo)) {
            return false;
        }
        ContentInfo contentInfo = (ContentInfo) obj;
        return ixe.O000000o(this.playerStatus, contentInfo.playerStatus) && ixe.O000000o(this.song, contentInfo.song);
    }

    public final int hashCode() {
        int hashCode = this.playerStatus.hashCode() * 31;
        Music.Song song2 = this.song;
        return hashCode + (song2 == null ? 0 : song2.hashCode());
    }

    public final String toString() {
        return "ContentInfo(playerStatus=" + this.playerStatus + ", song=" + this.song + ')';
    }

    public ContentInfo(Remote.Response.PlayerStatus playerStatus2, Music.Song song2) {
        ixe.O00000o(playerStatus2, "playerStatus");
        this.playerStatus = playerStatus2;
        this.song = song2;
    }

    public final Remote.Response.PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }

    public final Music.Song getSong() {
        return this.song;
    }

    public final void setPlayerStatus(Remote.Response.PlayerStatus playerStatus2) {
        ixe.O00000o(playerStatus2, "<set-?>");
        this.playerStatus = playerStatus2;
    }

    public final void setSong(Music.Song song2) {
        this.song = song2;
    }
}
