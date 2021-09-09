package _m_j;

import android.support.v4.app.NotificationCompat;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class edd extends GeneratedMessage.Builder implements edg {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15179O000000o;
    private Object O00000Oo;
    private Object O00000o;
    private Object O00000o0;
    private Object O00000oO;
    private long O00000oo;
    private Object O0000O0o;
    private Object O0000OOo;
    private RepeatedFieldBuilder O0000Oo;
    private List O0000Oo0;
    private Object O0000OoO;
    private Object O0000Ooo;
    private Object O0000o0;
    private Object O0000o00;
    private Object O0000o0O;

    private edd() {
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.O0000Oo0 = Collections.emptyList();
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        O00000Oo();
    }

    private edd(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.O0000Oo0 = Collections.emptyList();
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        O00000Oo();
    }

    public /* synthetic */ edd(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    private edd O000000o(long j) {
        this.f15179O000000o |= 16;
        this.O00000oo = j;
        onChanged();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edd mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.Event event;
        ProtoMsg$StatsMsg.Event event2 = null;
        try {
            ProtoMsg$StatsMsg.Event event3 = (ProtoMsg$StatsMsg.Event) ProtoMsg$StatsMsg.Event.f6064O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (event3 != null) {
                O000000o(event3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            event = (ProtoMsg$StatsMsg.Event) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            event2 = event;
        }
        if (event2 != null) {
            O000000o(event2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edd mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.Event) {
            return O000000o((ProtoMsg$StatsMsg.Event) message);
        }
        super.mergeFrom(message);
        return this;
    }

    private void O00000Oo() {
        if (ProtoMsg$StatsMsg.Event.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public edd clear() {
        super.clear();
        this.O00000Oo = "";
        this.f15179O000000o &= -2;
        this.O00000o0 = "";
        this.f15179O000000o &= -3;
        this.O00000o = "";
        this.f15179O000000o &= -5;
        this.O00000oO = "";
        this.f15179O000000o &= -9;
        this.O00000oo = 0;
        this.f15179O000000o &= -17;
        this.O0000O0o = "";
        this.f15179O000000o &= -33;
        this.O0000OOo = "";
        this.f15179O000000o &= -65;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
        if (repeatedFieldBuilder == null) {
            this.O0000Oo0 = Collections.emptyList();
            this.f15179O000000o &= -129;
        } else {
            repeatedFieldBuilder.clear();
        }
        this.O0000OoO = "";
        this.f15179O000000o &= -257;
        this.O0000Ooo = "";
        this.f15179O000000o &= -513;
        this.O0000o00 = "";
        this.f15179O000000o &= -1025;
        this.O0000o0 = "";
        this.f15179O000000o &= -2049;
        this.O0000o0O = "";
        this.f15179O000000o &= -4097;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ProtoMsg$StatsMsg.Event build() {
        ProtoMsg$StatsMsg.Event O00000oo2 = buildPartial();
        if (O00000oo2.isInitialized()) {
            return O00000oo2;
        }
        throw newUninitializedMessageException((Message) O00000oo2);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.Event buildPartial() {
        List list;
        int i = 0;
        ProtoMsg$StatsMsg.Event event = new ProtoMsg$StatsMsg.Event(this, (byte) 0);
        int i2 = this.f15179O000000o;
        if ((i2 & 1) == 1) {
            i = 1;
        }
        Object unused = event.aC = this.O00000Oo;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        Object unused2 = event.aF = this.O00000o0;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        Object unused3 = event.aH = this.O00000o;
        if ((i2 & 8) == 8) {
            i |= 8;
        }
        Object unused4 = event.aG = this.O00000oO;
        if ((i2 & 16) == 16) {
            i |= 16;
        }
        long unused5 = event.bb = this.O00000oo;
        if ((i2 & 32) == 32) {
            i |= 32;
        }
        Object unused6 = event.bJ = this.O0000O0o;
        if ((i2 & 64) == 64) {
            i |= 64;
        }
        Object unused7 = event.bK = this.O0000OOo;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
        if (repeatedFieldBuilder == null) {
            if ((this.f15179O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                this.O0000Oo0 = Collections.unmodifiableList(this.O0000Oo0);
                this.f15179O000000o &= -129;
            }
            list = this.O0000Oo0;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused8 = event.bL = list;
        if ((i2 & 256) == 256) {
            i |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        Object unused9 = event.aM = this.O0000OoO;
        if ((i2 & 512) == 512) {
            i |= 256;
        }
        Object unused10 = event.aD = this.O0000Ooo;
        if ((i2 & 1024) == 1024) {
            i |= 512;
        }
        Object unused11 = event.aE = this.O0000o00;
        if ((i2 & 2048) == 2048) {
            i |= 1024;
        }
        Object unused12 = event.bh = this.O0000o0;
        if ((i2 & 4096) == 4096) {
            i |= 2048;
        }
        Object unused13 = event.bj = this.O0000o0O;
        int unused14 = event.aA = i;
        onBuilt();
        return event;
    }

    private void O0000O0o() {
        if ((this.f15179O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) != 128) {
            this.O0000Oo0 = new ArrayList(this.O0000Oo0);
            this.f15179O000000o |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new RepeatedFieldBuilder(this.O0000Oo0, (this.f15179O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) == 128, getParentForChildren(), isClean());
            this.O0000Oo0 = null;
        }
        return this.O0000Oo;
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000Oo0;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000Oo.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.Event.class, edd.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public edd clone() {
        return new edd().O000000o(buildPartial());
    }

    public final edd O000000o(ProtoMsg$StatsMsg.Event event) {
        if (event == ProtoMsg$StatsMsg.Event.O000000o()) {
            return this;
        }
        if (event.O00000Oo()) {
            this.f15179O000000o |= 1;
            this.O00000Oo = event.aC;
            onChanged();
        }
        if (event.O00000o0()) {
            this.f15179O000000o |= 2;
            this.O00000o0 = event.aF;
            onChanged();
        }
        if (event.O00000o()) {
            this.f15179O000000o |= 4;
            this.O00000o = event.aH;
            onChanged();
        }
        if (event.O00000oO()) {
            this.f15179O000000o |= 8;
            this.O00000oO = event.aG;
            onChanged();
        }
        if (event.O00000oo()) {
            O000000o(event.bb);
        }
        if (event.O0000O0o()) {
            this.f15179O000000o |= 32;
            this.O0000O0o = event.bJ;
            onChanged();
        }
        if (event.O0000OOo()) {
            this.f15179O000000o |= 64;
            this.O0000OOo = event.bK;
            onChanged();
        }
        if (this.O0000Oo == null) {
            if (!event.bL.isEmpty()) {
                if (this.O0000Oo0.isEmpty()) {
                    this.O0000Oo0 = event.bL;
                    this.f15179O000000o &= -129;
                } else {
                    O0000O0o();
                    this.O0000Oo0.addAll(event.bL);
                }
                onChanged();
            }
        } else if (!event.bL.isEmpty()) {
            if (this.O0000Oo.isEmpty()) {
                this.O0000Oo.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O0000Oo = null;
                this.O0000Oo0 = event.bL;
                this.f15179O000000o &= -129;
                if (ProtoMsg$StatsMsg.Event.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O0000Oo = repeatedFieldBuilder;
            } else {
                this.O0000Oo.addAllMessages(event.bL);
            }
        }
        if (event.O0000Oo0()) {
            this.f15179O000000o |= 256;
            this.O0000OoO = event.aM;
            onChanged();
        }
        if (event.O0000Oo()) {
            this.f15179O000000o |= 512;
            this.O0000Ooo = event.aD;
            onChanged();
        }
        if (event.O0000OoO()) {
            this.f15179O000000o |= 1024;
            this.O0000o00 = event.aE;
            onChanged();
        }
        if (event.O0000Ooo()) {
            this.f15179O000000o |= 2048;
            this.O0000o0 = event.bh;
            onChanged();
        }
        if (event.O0000o00()) {
            this.f15179O000000o |= 4096;
            this.O0000o0O = event.bj;
            onChanged();
        }
        mergeUnknownFields(event.getUnknownFields());
        return this;
    }

    public final boolean isInitialized() {
        if (!((this.f15179O000000o & 1) == 1)) {
            return false;
        }
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
            if (i >= (repeatedFieldBuilder == null ? this.O0000Oo0.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O0000Oo;
            if (!((ProtoMsg$StatsMsg.ProtoMap) (repeatedFieldBuilder2 == null ? this.O0000Oo0.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ edd O000000o() {
        return new edd();
    }
}
