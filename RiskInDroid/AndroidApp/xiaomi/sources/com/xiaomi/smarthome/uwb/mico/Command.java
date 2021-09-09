package com.xiaomi.smarthome.uwb.mico;

import _m_j.ixc;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/Command;", "", "()V", "ModifyVolumeByValue", "Next", "PlayOrPause", "Prev", "Seek", "Lcom/xiaomi/smarthome/uwb/mico/Command$PlayOrPause;", "Lcom/xiaomi/smarthome/uwb/mico/Command$Prev;", "Lcom/xiaomi/smarthome/uwb/mico/Command$Next;", "Lcom/xiaomi/smarthome/uwb/mico/Command$ModifyVolumeByValue;", "Lcom/xiaomi/smarthome/uwb/mico/Command$Seek;", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Command {
    public /* synthetic */ Command(ixc ixc) {
        this();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/Command$PlayOrPause;", "Lcom/xiaomi/smarthome/uwb/mico/Command;", "play", "", "(Z)V", "getPlay", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PlayOrPause extends Command {
        private final boolean play;

        public static /* synthetic */ PlayOrPause copy$default(PlayOrPause playOrPause, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = playOrPause.play;
            }
            return playOrPause.copy(z);
        }

        public final boolean component1() {
            return this.play;
        }

        public final PlayOrPause copy(boolean z) {
            return new PlayOrPause(z);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PlayOrPause) && this.play == ((PlayOrPause) obj).play;
        }

        public final int hashCode() {
            boolean z = this.play;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "PlayOrPause(play=" + this.play + ')';
        }

        public PlayOrPause(boolean z) {
            super(null);
            this.play = z;
        }

        public final boolean getPlay() {
            return this.play;
        }
    }

    private Command() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/Command$Prev;", "Lcom/xiaomi/smarthome/uwb/mico/Command;", "()V", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Prev extends Command {
        public static final Prev INSTANCE = new Prev();

        private Prev() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/Command$Next;", "Lcom/xiaomi/smarthome/uwb/mico/Command;", "()V", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Next extends Command {
        public static final Next INSTANCE = new Next();

        private Next() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/Command$ModifyVolumeByValue;", "Lcom/xiaomi/smarthome/uwb/mico/Command;", "volume", "", "(I)V", "getVolume", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModifyVolumeByValue extends Command {
        private final int volume;

        public static /* synthetic */ ModifyVolumeByValue copy$default(ModifyVolumeByValue modifyVolumeByValue, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = modifyVolumeByValue.volume;
            }
            return modifyVolumeByValue.copy(i);
        }

        public final int component1() {
            return this.volume;
        }

        public final ModifyVolumeByValue copy(int i) {
            return new ModifyVolumeByValue(i);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ModifyVolumeByValue) && this.volume == ((ModifyVolumeByValue) obj).volume;
        }

        public final int hashCode() {
            return Integer.valueOf(this.volume).hashCode();
        }

        public final String toString() {
            return "ModifyVolumeByValue(volume=" + this.volume + ')';
        }

        public ModifyVolumeByValue(int i) {
            super(null);
            this.volume = i;
        }

        public final int getVolume() {
            return this.volume;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/Command$Seek;", "Lcom/xiaomi/smarthome/uwb/mico/Command;", "position", "", "(J)V", "getPosition", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Seek extends Command {
        private final long position;

        public static /* synthetic */ Seek copy$default(Seek seek, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = seek.position;
            }
            return seek.copy(j);
        }

        public final long component1() {
            return this.position;
        }

        public final Seek copy(long j) {
            return new Seek(j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Seek) && this.position == ((Seek) obj).position;
        }

        public final int hashCode() {
            return Long.valueOf(this.position).hashCode();
        }

        public final String toString() {
            return "Seek(position=" + this.position + ')';
        }

        public Seek(long j) {
            super(null);
            this.position = j;
        }

        public final long getPosition() {
            return this.position;
        }
    }
}
