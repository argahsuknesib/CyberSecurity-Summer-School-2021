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

public final class edl extends GeneratedMessage.Builder implements edm {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15183O000000o;
    private Object O00000Oo;
    private Object O00000o;
    private Object O00000o0;
    private Object O00000oO;
    private Object O00000oo;
    private long O0000O0o;
    private Object O0000OOo;
    private Object O0000Oo;
    private Object O0000Oo0;
    private Object O0000OoO;
    private Object O0000Ooo;
    private Object O0000o;
    private List O0000o0;
    private Object O0000o00;
    private RepeatedFieldBuilder O0000o0O;
    private int O0000o0o;
    private Object O0000oO;
    private Object O0000oO0;
    private Object O0000oOO;
    private Object O0000oOo;
    private Object O0000oo0;

    private edl() {
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000OOo = "";
        this.O0000Oo0 = "";
        this.O0000Oo = "";
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = Collections.emptyList();
        this.O0000o = "";
        this.O0000oO0 = "";
        this.O0000oO = "";
        this.O0000oOO = "";
        this.O0000oOo = "";
        this.O0000oo0 = "";
        O00000Oo();
    }

    private edl(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000OOo = "";
        this.O0000Oo0 = "";
        this.O0000Oo = "";
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = Collections.emptyList();
        this.O0000o = "";
        this.O0000oO0 = "";
        this.O0000oO = "";
        this.O0000oOO = "";
        this.O0000oOo = "";
        this.O0000oo0 = "";
        O00000Oo();
    }

    public /* synthetic */ edl(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    private edl O000000o(int i) {
        this.f15183O000000o |= 8192;
        this.O0000o0o = i;
        onChanged();
        return this;
    }

    private edl O000000o(long j) {
        this.f15183O000000o |= 32;
        this.O0000O0o = j;
        onChanged();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edl mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.ProtoError protoError;
        ProtoMsg$StatsMsg.ProtoError protoError2 = null;
        try {
            ProtoMsg$StatsMsg.ProtoError protoError3 = (ProtoMsg$StatsMsg.ProtoError) ProtoMsg$StatsMsg.ProtoError.f6068O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (protoError3 != null) {
                O000000o(protoError3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            protoError = (ProtoMsg$StatsMsg.ProtoError) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            protoError2 = protoError;
        }
        if (protoError2 != null) {
            O000000o(protoError2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edl mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.ProtoError) {
            return O000000o((ProtoMsg$StatsMsg.ProtoError) message);
        }
        super.mergeFrom(message);
        return this;
    }

    private void O00000Oo() {
        if (ProtoMsg$StatsMsg.ProtoError.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public edl clear() {
        super.clear();
        this.O00000Oo = "";
        this.f15183O000000o &= -2;
        this.O00000o0 = "";
        this.f15183O000000o &= -3;
        this.O00000o = "";
        this.f15183O000000o &= -5;
        this.O00000oO = "";
        this.f15183O000000o &= -9;
        this.O00000oo = "";
        this.f15183O000000o &= -17;
        this.O0000O0o = 0;
        this.f15183O000000o &= -33;
        this.O0000OOo = "";
        this.f15183O000000o &= -65;
        this.O0000Oo0 = "";
        this.f15183O000000o &= -129;
        this.O0000Oo = "";
        this.f15183O000000o &= -257;
        this.O0000OoO = "";
        this.f15183O000000o &= -513;
        this.O0000Ooo = "";
        this.f15183O000000o &= -1025;
        this.O0000o00 = "";
        this.f15183O000000o &= -2049;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000o0O;
        if (repeatedFieldBuilder == null) {
            this.O0000o0 = Collections.emptyList();
            this.f15183O000000o &= -4097;
        } else {
            repeatedFieldBuilder.clear();
        }
        this.O0000o0o = 0;
        this.f15183O000000o &= -8193;
        this.O0000o = "";
        this.f15183O000000o &= -16385;
        this.O0000oO0 = "";
        this.f15183O000000o &= -32769;
        this.O0000oO = "";
        this.f15183O000000o &= -65537;
        this.O0000oOO = "";
        this.f15183O000000o &= -131073;
        this.O0000oOo = "";
        this.f15183O000000o &= -262145;
        this.O0000oo0 = "";
        this.f15183O000000o &= -524289;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ProtoMsg$StatsMsg.ProtoError build() {
        ProtoMsg$StatsMsg.ProtoError O00000oo2 = buildPartial();
        if (O00000oo2.isInitialized()) {
            return O00000oo2;
        }
        throw newUninitializedMessageException((Message) O00000oo2);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.ProtoError buildPartial() {
        List list;
        ProtoMsg$StatsMsg.ProtoError protoError = new ProtoMsg$StatsMsg.ProtoError(this, (byte) 0);
        int i = this.f15183O000000o;
        int i2 = 1;
        if ((i & 1) != 1) {
            i2 = 0;
        }
        Object unused = protoError.aC = this.O00000Oo;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        Object unused2 = protoError.aD = this.O00000o0;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        Object unused3 = protoError.aE = this.O00000o;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        Object unused4 = protoError.aF = this.O00000oO;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        Object unused5 = protoError.ce = this.O00000oo;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        long unused6 = protoError.bb = this.O0000O0o;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        Object unused7 = protoError.aG = this.O0000OOo;
        if ((i & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i2 |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        Object unused8 = protoError.cf = this.O0000Oo0;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        Object unused9 = protoError.cg = this.O0000Oo;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        Object unused10 = protoError.ch = this.O0000OoO;
        if ((i & 1024) == 1024) {
            i2 |= 1024;
        }
        Object unused11 = protoError.ci = this.O0000Ooo;
        if ((i & 2048) == 2048) {
            i2 |= 2048;
        }
        Object unused12 = protoError.cj = this.O0000o00;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O0000o0O;
        if (repeatedFieldBuilder == null) {
            if ((this.f15183O000000o & 4096) == 4096) {
                this.O0000o0 = Collections.unmodifiableList(this.O0000o0);
                this.f15183O000000o &= -4097;
            }
            list = this.O0000o0;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused13 = protoError.ck = list;
        if ((i & 8192) == 8192) {
            i2 |= 4096;
        }
        int unused14 = protoError.aI = this.O0000o0o;
        if ((i & 16384) == 16384) {
            i2 |= 8192;
        }
        Object unused15 = protoError.aJ = this.O0000o;
        if ((32768 & i) == 32768) {
            i2 |= 16384;
        }
        Object unused16 = protoError.aH = this.O0000oO0;
        if ((65536 & i) == 65536) {
            i2 |= 32768;
        }
        Object unused17 = protoError.aP = this.O0000oO;
        if ((131072 & i) == 131072) {
            i2 |= 65536;
        }
        Object unused18 = protoError.aM = this.O0000oOO;
        if ((262144 & i) == 262144) {
            i2 |= 131072;
        }
        Object unused19 = protoError.bh = this.O0000oOo;
        if ((i & 524288) == 524288) {
            i2 |= 262144;
        }
        Object unused20 = protoError.bj = this.O0000oo0;
        int unused21 = protoError.aA = i2;
        onBuilt();
        return protoError;
    }

    private void O0000O0o() {
        if ((this.f15183O000000o & 4096) != 4096) {
            this.O0000o0 = new ArrayList(this.O0000o0);
            this.f15183O000000o |= 4096;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O0000o0O == null) {
            this.O0000o0O = new RepeatedFieldBuilder(this.O0000o0, (this.f15183O000000o & 4096) == 4096, getParentForChildren(), isClean());
            this.O0000o0 = null;
        }
        return this.O0000o0O;
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000oO;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000oOO.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.ProtoError.class, edl.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public edl clone() {
        return new edl().O000000o(buildPartial());
    }

    public final edl O000000o(ProtoMsg$StatsMsg.ProtoError protoError) {
        if (protoError == ProtoMsg$StatsMsg.ProtoError.O000000o()) {
            return this;
        }
        if (protoError.O00000Oo()) {
            this.f15183O000000o |= 1;
            this.O00000Oo = protoError.aC;
            onChanged();
        }
        if (protoError.O00000o0()) {
            this.f15183O000000o |= 2;
            this.O00000o0 = protoError.aD;
            onChanged();
        }
        if (protoError.O00000o()) {
            this.f15183O000000o |= 4;
            this.O00000o = protoError.aE;
            onChanged();
        }
        if (protoError.O00000oO()) {
            this.f15183O000000o |= 8;
            this.O00000oO = protoError.aF;
            onChanged();
        }
        if (protoError.O00000oo()) {
            this.f15183O000000o |= 16;
            this.O00000oo = protoError.ce;
            onChanged();
        }
        if (protoError.O0000O0o()) {
            O000000o(protoError.bb);
        }
        if (protoError.O0000OOo()) {
            this.f15183O000000o |= 64;
            this.O0000OOo = protoError.aG;
            onChanged();
        }
        if (protoError.O0000Oo0()) {
            this.f15183O000000o |= NotificationCompat.FLAG_HIGH_PRIORITY;
            this.O0000Oo0 = protoError.cf;
            onChanged();
        }
        if (protoError.O0000Oo()) {
            this.f15183O000000o |= 256;
            this.O0000Oo = protoError.cg;
            onChanged();
        }
        if (protoError.O0000OoO()) {
            this.f15183O000000o |= 512;
            this.O0000OoO = protoError.ch;
            onChanged();
        }
        if (protoError.O0000Ooo()) {
            this.f15183O000000o |= 1024;
            this.O0000Ooo = protoError.ci;
            onChanged();
        }
        if (protoError.O0000o00()) {
            this.f15183O000000o |= 2048;
            this.O0000o00 = protoError.cj;
            onChanged();
        }
        if (this.O0000o0O == null) {
            if (!protoError.ck.isEmpty()) {
                if (this.O0000o0.isEmpty()) {
                    this.O0000o0 = protoError.ck;
                    this.f15183O000000o &= -4097;
                } else {
                    O0000O0o();
                    this.O0000o0.addAll(protoError.ck);
                }
                onChanged();
            }
        } else if (!protoError.ck.isEmpty()) {
            if (this.O0000o0O.isEmpty()) {
                this.O0000o0O.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O0000o0O = null;
                this.O0000o0 = protoError.ck;
                this.f15183O000000o &= -4097;
                if (ProtoMsg$StatsMsg.ProtoError.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O0000o0O = repeatedFieldBuilder;
            } else {
                this.O0000o0O.addAllMessages(protoError.ck);
            }
        }
        if (protoError.O0000o0()) {
            O000000o(protoError.aI);
        }
        if (protoError.O0000o0O()) {
            this.f15183O000000o |= 16384;
            this.O0000o = protoError.aJ;
            onChanged();
        }
        if (protoError.O0000o0o()) {
            this.f15183O000000o |= 32768;
            this.O0000oO0 = protoError.aH;
            onChanged();
        }
        if (protoError.O0000o()) {
            this.f15183O000000o |= 65536;
            this.O0000oO = protoError.aP;
            onChanged();
        }
        if (protoError.O0000oO0()) {
            this.f15183O000000o |= 131072;
            this.O0000oOO = protoError.aM;
            onChanged();
        }
        if (protoError.O0000oO()) {
            this.f15183O000000o |= 262144;
            this.O0000oOo = protoError.bh;
            onChanged();
        }
        if (protoError.O0000oOO()) {
            this.f15183O000000o |= 524288;
            this.O0000oo0 = protoError.bj;
            onChanged();
        }
        mergeUnknownFields(protoError.getUnknownFields());
        return this;
    }

    public final boolean isInitialized() {
        if (!((this.f15183O000000o & 1) == 1)) {
            return false;
        }
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O0000o0O;
            if (i >= (repeatedFieldBuilder == null ? this.O0000o0.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O0000o0O;
            if (!((ProtoMsg$StatsMsg.ProtoMap) (repeatedFieldBuilder2 == null ? this.O0000o0.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ edl O000000o() {
        return new edl();
    }
}
