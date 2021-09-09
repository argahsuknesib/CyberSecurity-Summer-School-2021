package com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class MiotBleAdvPacket implements Parcelable {
    public static final Parcelable.Creator<MiotBleAdvPacket> CREATOR = new Parcelable.Creator<MiotBleAdvPacket>() {
        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiotBleAdvPacket[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MiotBleAdvPacket(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public FrameControl f6871O000000o;
    public int O00000Oo;
    public String O00000o;
    public int O00000o0;
    public Capability O00000oO;
    public String O00000oo;
    public IoCapability O0000O0o;
    public Event O0000OOo;
    public int[] O0000Oo;
    public int[] O0000Oo0;
    public Mesh O0000OoO;

    public int describeContents() {
        return 0;
    }

    public MiotBleAdvPacket() {
    }

    protected MiotBleAdvPacket(Parcel parcel) {
        try {
            this.f6871O000000o = (FrameControl) parcel.readParcelable(FrameControl.class.getClassLoader());
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
            if (this.f6871O000000o != null) {
                if (this.f6871O000000o.O00000Oo) {
                    this.O00000o = parcel.readString();
                }
                if (this.f6871O000000o.O00000o0) {
                    this.O00000oO = (Capability) parcel.readParcelable(Capability.class.getClassLoader());
                }
                if (O000000o()) {
                    this.O00000oo = parcel.readString();
                }
                if (this.f6871O000000o.O00000o0 && this.O00000oO != null && this.O00000oO.O00000oO) {
                    this.O0000O0o = (IoCapability) parcel.readParcelable(IoCapability.class.getClassLoader());
                }
                if (this.f6871O000000o.O00000o) {
                    this.O0000OOo = (Event) parcel.readParcelable(Event.class.getClassLoader());
                }
                if (this.f6871O000000o.f6874O000000o) {
                    this.O0000Oo0 = new int[3];
                    parcel.readIntArray(this.O0000Oo0);
                    if (this.f6871O000000o.O0000Oo0 >= 4) {
                        this.O0000Oo = new int[4];
                    } else {
                        this.O0000Oo = new int[1];
                    }
                    parcel.readIntArray(this.O0000Oo);
                }
                if (this.f6871O000000o.O00000oO) {
                    this.O0000OoO = (Mesh) parcel.readParcelable(Mesh.class.getClassLoader());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeParcelable(this.f6871O000000o, 0);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
            if (this.f6871O000000o != null) {
                if (this.f6871O000000o.O00000Oo) {
                    parcel.writeString(this.O00000o);
                }
                if (this.f6871O000000o.O00000o0) {
                    parcel.writeParcelable(this.O00000oO, 0);
                }
                if (O000000o()) {
                    parcel.writeString(this.O00000oo);
                }
                if (this.f6871O000000o.O00000o0 && this.O00000oO != null && this.O00000oO.O00000oO) {
                    parcel.writeParcelable(this.O0000O0o, 0);
                }
                if (this.f6871O000000o.O00000o) {
                    parcel.writeParcelable(this.O0000OOo, 0);
                }
                if (this.f6871O000000o.f6874O000000o) {
                    parcel.writeIntArray(this.O0000Oo0);
                    parcel.writeIntArray(this.O0000Oo);
                }
                if (this.f6871O000000o.O00000oO) {
                    parcel.writeParcelable(this.O0000OoO, 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class FrameControl implements Parcelable {
        public static final Parcelable.Creator<FrameControl> CREATOR = new Parcelable.Creator<FrameControl>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket.FrameControl.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new FrameControl[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new FrameControl(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f6874O000000o;
        public boolean O00000Oo;
        public boolean O00000o;
        public boolean O00000o0;
        public boolean O00000oO;
        public boolean O00000oo;
        public boolean O0000O0o;
        public int O0000OOo;
        public int O0000Oo0;

        public int describeContents() {
            return 0;
        }

        public FrameControl() {
        }

        protected FrameControl(Parcel parcel) {
            boolean z = true;
            this.f6874O000000o = parcel.readByte() != 0;
            this.O00000Oo = parcel.readByte() != 0;
            this.O00000o0 = parcel.readByte() != 0;
            this.O00000o = parcel.readByte() != 0;
            this.O00000oO = parcel.readByte() != 0;
            this.O00000oo = parcel.readByte() != 0;
            this.O0000O0o = parcel.readByte() == 0 ? false : z;
            this.O0000OOo = parcel.readInt();
            this.O0000Oo0 = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6874O000000o ? 1 : 0);
            parcel.writeInt(this.O00000Oo ? 1 : 0);
            parcel.writeInt(this.O00000o0 ? 1 : 0);
            parcel.writeInt(this.O00000o ? 1 : 0);
            parcel.writeInt(this.O00000oO ? 1 : 0);
            parcel.writeInt(this.O00000oo ? 1 : 0);
            parcel.writeInt(this.O0000O0o ? 1 : 0);
            parcel.writeInt(this.O0000OOo);
            parcel.writeInt(this.O0000Oo0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("");
            sb.append("encrypted = " + this.f6874O000000o);
            sb.append("\n");
            sb.append("withMac = " + this.O00000Oo);
            sb.append("\n");
            sb.append("withCapability = " + this.O00000o0);
            sb.append("\n");
            sb.append("withEvent = " + this.O00000o);
            sb.append("\n");
            sb.append("withMesh = " + this.O00000oO);
            sb.append("\n");
            sb.append("registered = " + this.O00000oo);
            sb.append("\n");
            sb.append("bindingCfm = " + this.O0000O0o);
            sb.append("\n");
            sb.append("authMode = " + this.O0000OOo);
            sb.append("\n");
            sb.append("version = " + this.O0000Oo0);
            return sb.toString();
        }
    }

    public static class Capability implements Parcelable {
        public static final Parcelable.Creator<Capability> CREATOR = new Parcelable.Creator<Capability>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket.Capability.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Capability[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Capability(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f6872O000000o;
        public boolean O00000Oo;
        public int O00000o;
        public boolean O00000o0;
        public boolean O00000oO;

        public int describeContents() {
            return 0;
        }

        public Capability() {
        }

        protected Capability(Parcel parcel) {
            boolean z = true;
            this.f6872O000000o = parcel.readByte() != 0;
            this.O00000Oo = parcel.readByte() != 0;
            this.O00000o0 = parcel.readByte() != 0;
            this.O00000o = parcel.readInt();
            this.O00000oO = parcel.readByte() == 0 ? false : z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("connectable = " + this.f6872O000000o);
            sb.append("\n");
            sb.append("centralable = " + this.O00000Oo);
            sb.append("\n");
            sb.append("encryptable = " + this.O00000o0);
            sb.append("\n");
            sb.append("bindable = " + this.O00000o);
            sb.append("\n");
            sb.append("ioCapabilityable = " + this.O00000oO);
            sb.append("\n");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6872O000000o ? 1 : 0);
            parcel.writeInt(this.O00000Oo ? 1 : 0);
            parcel.writeInt(this.O00000o0 ? 1 : 0);
            parcel.writeInt(this.O00000o);
            parcel.writeInt(this.O00000oO ? 1 : 0);
        }
    }

    public static class IoCapability implements Parcelable {
        public static final Parcelable.Creator<IoCapability> CREATOR = new Parcelable.Creator<IoCapability>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket.IoCapability.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IoCapability[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IoCapability(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f6875O000000o;
        public int O00000Oo;

        public int describeContents() {
            return 0;
        }

        public IoCapability() {
        }

        protected IoCapability(Parcel parcel) {
            this.f6875O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("inputCapability = " + this.f6875O000000o);
            sb.append("\n");
            sb.append("outputCapability = " + this.O00000Oo);
            sb.append("\n");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6875O000000o);
            parcel.writeInt(this.O00000Oo);
        }
    }

    public static class Event implements Parcelable {
        public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket.Event.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Event[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Event(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f6873O000000o;
        public int O00000Oo;

        public int describeContents() {
            return 0;
        }

        public Event() {
        }

        protected Event(Parcel parcel) {
            this.f6873O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("");
            sb.append(String.format("eventId = 0x%x", Integer.valueOf(this.f6873O000000o)));
            sb.append("\n");
            sb.append("eventLength = " + this.O00000Oo);
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6873O000000o);
            parcel.writeInt(this.O00000Oo);
        }
    }

    public static class Mesh implements Parcelable {
        public static final Parcelable.Creator<Mesh> CREATOR = new Parcelable.Creator<Mesh>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket.Mesh.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Mesh[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Mesh(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f6876O000000o;
        public int O00000Oo;
        public int O00000o0;

        public int describeContents() {
            return 0;
        }

        public Mesh() {
        }

        protected Mesh(Parcel parcel) {
            this.f6876O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("pbType = " + this.f6876O000000o);
            sb.append("\n");
            sb.append("state = " + this.O00000Oo);
            sb.append("\n");
            sb.append("version = " + this.O00000o0);
            sb.append("\n");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6876O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("productId = 0x%2x", Integer.valueOf(this.O00000Oo)));
        sb.append("\n");
        sb.append(String.format("frameCounter = %d", Integer.valueOf(this.O00000o0)));
        sb.append("\n");
        sb.append(String.format("mac = %s", this.O00000o));
        sb.append("\n");
        if (this.f6871O000000o != null) {
            sb.append("\nFrameControl: \n");
            sb.append(this.f6871O000000o.toString());
            sb.append("\n");
        }
        if (this.O00000oO != null) {
            sb.append("\nCapability: \n");
            sb.append(this.O00000oO.toString());
            sb.append("\n");
        }
        if (this.O0000OOo != null) {
            sb.append("\nEvent: \n");
            sb.append(this.O0000OOo.toString());
            sb.append("\n");
        }
        if (this.O0000O0o != null) {
            sb.append("\nIoCapability: \n");
            sb.append(this.O0000O0o.toString());
            sb.append("\n");
        }
        if (this.O0000OoO != null) {
            sb.append("\nMesh: \n");
            sb.append(this.O0000OoO.toString());
            sb.append("\n");
        }
        if (!TextUtils.isEmpty(this.O00000oo)) {
            sb.append("\n");
            sb.append(String.format("comboKey: %s", this.O00000oo));
            sb.append("\n");
        }
        return sb.toString();
    }

    public final boolean O000000o() {
        FrameControl frameControl;
        Capability capability = this.O00000oO;
        return capability != null && capability.O00000o == 3 && (frameControl = this.f6871O000000o) != null && frameControl.O0000Oo0 >= 3;
    }

    public final boolean O00000Oo() {
        FrameControl frameControl = this.f6871O000000o;
        return frameControl != null && frameControl.O0000O0o;
    }
}
