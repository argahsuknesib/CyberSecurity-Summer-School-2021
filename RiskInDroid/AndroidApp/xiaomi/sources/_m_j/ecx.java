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

public final class ecx extends GeneratedMessage.Builder implements eda {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15175O000000o;
    private Object O00000Oo;
    private Object O00000o;
    private Object O00000o0;
    private Object O00000oO;
    private long O00000oo;
    private Object O0000O0o;
    private Object O0000OOo;
    private RepeatedFieldBuilder O0000Oo;
    private List O0000Oo0;
    private int O0000OoO;
    private Object O0000Ooo;
    private Object O0000o;
    private Object O0000o0;
    private Object O0000o00;
    private Object O0000o0O;
    private Object O0000o0o;
    private Object O0000oO;
    private int O0000oO0;
    private Object O0000oOO;
    private Object O0000oOo;

    private ecx() {
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.O0000Oo0 = Collections.emptyList();
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        this.O0000o0o = "";
        this.O0000o = "";
        this.O0000oO = "";
        this.O0000oOO = "";
        this.O0000oOo = "";
        O00000o0();
    }

    private ecx(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.O0000Oo0 = Collections.emptyList();
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        this.O0000o0o = "";
        this.O0000o = "";
        this.O0000oO = "";
        this.O0000oOO = "";
        this.O0000oOo = "";
        O00000o0();
    }

    public /* synthetic */ ecx(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecx mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.Crash crash;
        ProtoMsg$StatsMsg.Crash crash2 = null;
        try {
            ProtoMsg$StatsMsg.Crash crash3 = (ProtoMsg$StatsMsg.Crash) ProtoMsg$StatsMsg.Crash.f6061O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (crash3 != null) {
                O000000o(crash3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            crash = (ProtoMsg$StatsMsg.Crash) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            crash2 = crash;
        }
        if (crash2 != null) {
            O000000o(crash2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecx mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.Crash) {
            return O000000o((ProtoMsg$StatsMsg.Crash) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ecx clear() {
        super.clear();
        this.O00000Oo = "";
        this.f15175O000000o &= -2;
        this.O00000o0 = "";
        this.f15175O000000o &= -3;
        this.O00000o = "";
        this.f15175O000000o &= -5;
        this.O00000oO = "";
        this.f15175O000000o &= -9;
        this.O00000oo = 0;
        this.f15175O000000o &= -17;
        this.O0000O0o = "";
        this.f15175O000000o &= -33;
        this.O0000OOo = "";
        this.f15175O000000o &= -65;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
        if (repeatedFieldBuilder == null) {
            this.O0000Oo0 = Collections.emptyList();
            this.f15175O000000o &= -129;
        } else {
            repeatedFieldBuilder.clear();
        }
        this.O0000OoO = 0;
        this.f15175O000000o &= -257;
        this.O0000Ooo = "";
        this.f15175O000000o &= -513;
        this.O0000o00 = "";
        this.f15175O000000o &= -1025;
        this.O0000o0 = "";
        this.f15175O000000o &= -2049;
        this.O0000o0O = "";
        this.f15175O000000o &= -4097;
        this.O0000o0o = "";
        this.f15175O000000o &= -8193;
        this.O0000o = "";
        this.f15175O000000o &= -16385;
        this.O0000oO0 = 0;
        this.f15175O000000o &= -32769;
        this.O0000oO = "";
        this.f15175O000000o &= -65537;
        this.O0000oOO = "";
        this.f15175O000000o &= -131073;
        this.O0000oOo = "";
        this.f15175O000000o &= -262145;
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.Crash.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.Crash buildPartial() {
        List list;
        ProtoMsg$StatsMsg.Crash crash = new ProtoMsg$StatsMsg.Crash(this, (byte) 0);
        int i = this.f15175O000000o;
        int i2 = 1;
        if ((i & 1) != 1) {
            i2 = 0;
        }
        Object unused = crash.aC = this.O00000Oo;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        Object unused2 = crash.aD = this.O00000o0;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        Object unused3 = crash.aE = this.O00000o;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        Object unused4 = crash.aF = this.O00000oO;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        long unused5 = crash.bb = this.O00000oo;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        Object unused6 = crash.aG = this.O0000O0o;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        Object unused7 = crash.bv = this.O0000OOo;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
        if (repeatedFieldBuilder == null) {
            if ((this.f15175O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                this.O0000Oo0 = Collections.unmodifiableList(this.O0000Oo0);
                this.f15175O000000o &= -129;
            }
            list = this.O0000Oo0;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused8 = crash.bw = list;
        if ((i & 256) == 256) {
            i2 |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        int unused9 = crash.aI = this.O0000OoO;
        if ((i & 512) == 512) {
            i2 |= 256;
        }
        Object unused10 = crash.aJ = this.O0000Ooo;
        if ((i & 1024) == 1024) {
            i2 |= 512;
        }
        Object unused11 = crash.aH = this.O0000o00;
        if ((i & 2048) == 2048) {
            i2 |= 1024;
        }
        Object unused12 = crash.aP = this.O0000o0;
        if ((i & 4096) == 4096) {
            i2 |= 2048;
        }
        Object unused13 = crash.aM = this.O0000o0O;
        if ((i & 8192) == 8192) {
            i2 |= 4096;
        }
        Object unused14 = crash.bx = this.O0000o0o;
        if ((i & 16384) == 16384) {
            i2 |= 8192;
        }
        Object unused15 = crash.by = this.O0000o;
        if ((32768 & i) == 32768) {
            i2 |= 16384;
        }
        int unused16 = crash.bz = this.O0000oO0;
        if ((65536 & i) == 65536) {
            i2 |= 32768;
        }
        Object unused17 = crash.bA = this.O0000oO;
        if ((131072 & i) == 131072) {
            i2 |= 65536;
        }
        Object unused18 = crash.bh = this.O0000oOO;
        if ((i & 262144) == 262144) {
            i2 |= 131072;
        }
        Object unused19 = crash.bj = this.O0000oOo;
        int unused20 = crash.aA = i2;
        onBuilt();
        return crash;
    }

    private void O0000O0o() {
        if ((this.f15175O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) != 128) {
            this.O0000Oo0 = new ArrayList(this.O0000Oo0);
            this.f15175O000000o |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new RepeatedFieldBuilder(this.O0000Oo0, (this.f15175O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) == 128, getParentForChildren(), isClean());
            this.O0000Oo0 = null;
        }
        return this.O0000Oo;
    }

    public final ecx O000000o(int i) {
        this.f15175O000000o |= 256;
        this.O0000OoO = i;
        onChanged();
        return this;
    }

    public final ecx O000000o(long j) {
        this.f15175O000000o |= 16;
        this.O00000oo = j;
        onChanged();
        return this;
    }

    public final ecx O000000o(edn edn) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
        if (repeatedFieldBuilder == null) {
            O0000O0o();
            this.O0000Oo0.add(edn.build());
            onChanged();
        } else {
            repeatedFieldBuilder.addMessage(edn.build());
        }
        return this;
    }

    public final ecx O000000o(ProtoMsg$StatsMsg.ProtoMap protoMap) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000Oo;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(protoMap);
        } else if (protoMap != null) {
            O0000O0o();
            this.O0000Oo0.add(protoMap);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    public final ecx O000000o(String str) {
        this.f15175O000000o |= 1;
        this.O00000Oo = str;
        onChanged();
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.Crash build() {
        ProtoMsg$StatsMsg.Crash O00000oo2 = buildPartial();
        if (O00000oo2.isInitialized()) {
            return O00000oo2;
        }
        throw newUninitializedMessageException((Message) O00000oo2);
    }

    public final ecx O00000Oo(int i) {
        this.f15175O000000o |= 32768;
        this.O0000oO0 = i;
        onChanged();
        return this;
    }

    public final ecx O00000Oo(String str) {
        if (str != null) {
            this.f15175O000000o |= 2;
            this.O00000o0 = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O00000o(String str) {
        if (str != null) {
            this.f15175O000000o |= 8;
            this.O00000oO = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O00000o0(String str) {
        if (str != null) {
            this.f15175O000000o |= 4;
            this.O00000o = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O00000oO(String str) {
        if (str != null) {
            this.f15175O000000o |= 32;
            this.O0000O0o = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O00000oo(String str) {
        if (str != null) {
            this.f15175O000000o |= 64;
            this.O0000OOo = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000O0o(String str) {
        if (str != null) {
            this.f15175O000000o |= 512;
            this.O0000Ooo = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000OOo(String str) {
        if (str != null) {
            this.f15175O000000o |= 1024;
            this.O0000o00 = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000Oo(String str) {
        this.f15175O000000o |= 4096;
        this.O0000o0O = str;
        onChanged();
        return this;
    }

    public final ecx O0000Oo0(String str) {
        if (str != null) {
            this.f15175O000000o |= 2048;
            this.O0000o0 = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000OoO(String str) {
        if (str != null) {
            this.f15175O000000o |= 8192;
            this.O0000o0o = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000Ooo(String str) {
        if (str != null) {
            this.f15175O000000o |= 16384;
            this.O0000o = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000o0(String str) {
        if (str != null) {
            this.f15175O000000o |= 131072;
            this.O0000oOO = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000o00(String str) {
        if (str != null) {
            this.f15175O000000o |= 65536;
            this.O0000oO = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final ecx O0000o0O(String str) {
        this.f15175O000000o |= 262144;
        this.O0000oOo = str;
        onChanged();
        return this;
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000oo;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000ooO.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.Crash.class, ecx.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ecx clone() {
        return new ecx().O000000o(buildPartial());
    }

    public final ecx O000000o(ProtoMsg$StatsMsg.Crash crash) {
        if (crash == ProtoMsg$StatsMsg.Crash.O000000o()) {
            return this;
        }
        if (crash.O00000Oo()) {
            this.f15175O000000o |= 1;
            this.O00000Oo = crash.aC;
            onChanged();
        }
        if (crash.O00000o0()) {
            this.f15175O000000o |= 2;
            this.O00000o0 = crash.aD;
            onChanged();
        }
        if (crash.O00000o()) {
            this.f15175O000000o |= 4;
            this.O00000o = crash.aE;
            onChanged();
        }
        if (crash.O00000oO()) {
            this.f15175O000000o |= 8;
            this.O00000oO = crash.aF;
            onChanged();
        }
        if (crash.O00000oo()) {
            O000000o(crash.bb);
        }
        if (crash.O0000O0o()) {
            this.f15175O000000o |= 32;
            this.O0000O0o = crash.aG;
            onChanged();
        }
        if (crash.O0000OOo()) {
            this.f15175O000000o |= 64;
            this.O0000OOo = crash.bv;
            onChanged();
        }
        if (this.O0000Oo == null) {
            if (!crash.bw.isEmpty()) {
                if (this.O0000Oo0.isEmpty()) {
                    this.O0000Oo0 = crash.bw;
                    this.f15175O000000o &= -129;
                } else {
                    O0000O0o();
                    this.O0000Oo0.addAll(crash.bw);
                }
                onChanged();
            }
        } else if (!crash.bw.isEmpty()) {
            if (this.O0000Oo.isEmpty()) {
                this.O0000Oo.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O0000Oo = null;
                this.O0000Oo0 = crash.bw;
                this.f15175O000000o &= -129;
                if (ProtoMsg$StatsMsg.Crash.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O0000Oo = repeatedFieldBuilder;
            } else {
                this.O0000Oo.addAllMessages(crash.bw);
            }
        }
        if (crash.O0000Oo0()) {
            O000000o(crash.aI);
        }
        if (crash.O0000Oo()) {
            this.f15175O000000o |= 512;
            this.O0000Ooo = crash.aJ;
            onChanged();
        }
        if (crash.O0000OoO()) {
            this.f15175O000000o |= 1024;
            this.O0000o00 = crash.aH;
            onChanged();
        }
        if (crash.O0000Ooo()) {
            this.f15175O000000o |= 2048;
            this.O0000o0 = crash.aP;
            onChanged();
        }
        if (crash.O0000o00()) {
            this.f15175O000000o |= 4096;
            this.O0000o0O = crash.aM;
            onChanged();
        }
        if (crash.O0000o0()) {
            this.f15175O000000o |= 8192;
            this.O0000o0o = crash.bx;
            onChanged();
        }
        if (crash.O0000o0O()) {
            this.f15175O000000o |= 16384;
            this.O0000o = crash.by;
            onChanged();
        }
        if (crash.O0000o0o()) {
            O00000Oo(crash.bz);
        }
        if (crash.O0000o()) {
            this.f15175O000000o |= 65536;
            this.O0000oO = crash.bA;
            onChanged();
        }
        if (crash.O0000oO()) {
            this.f15175O000000o |= 131072;
            this.O0000oOO = crash.bh;
            onChanged();
        }
        if (crash.O0000oOO()) {
            this.f15175O000000o |= 262144;
            this.O0000oOo = crash.bj;
            onChanged();
        }
        mergeUnknownFields(crash.getUnknownFields());
        return this;
    }

    public final boolean isInitialized() {
        if (!((this.f15175O000000o & 1) == 1)) {
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

    public static /* synthetic */ ecx O00000Oo() {
        return new ecx();
    }
}
