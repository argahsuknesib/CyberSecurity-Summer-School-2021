package _m_j;

import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
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

public final class ect extends GeneratedMessage.Builder implements ecw {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15173O000000o;
    private int O00000Oo;
    private Object O00000o;
    private Object O00000o0;
    private Object O00000oO;
    private Object O00000oo;
    private Object O0000O0o;
    private Object O0000OOo;
    private Object O0000Oo;
    private int O0000Oo0;
    private Object O0000OoO;
    private Object O0000Ooo;
    private Object O0000o;
    private Object O0000o0;
    private Object O0000o00;
    private Object O0000o0O;
    private Object O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private boolean O0000oOO;
    private Object O0000oOo;
    private Object O0000oo;
    private Object O0000oo0;
    private boolean O0000ooO;
    private Object O0000ooo;
    private long O000O00o;
    private List O000O0OO;
    private RepeatedFieldBuilder O000O0Oo;
    private Object O000O0o;
    private Object O000O0o0;
    private Object O000O0oO;
    private Object O000O0oo;
    private Object O000OO;
    private Object O000OO00;
    private Object O000OO0o;
    private Object O000OOOo;
    private ProtoMsg$StatsMsg.NetworkType O00oOoOo;
    private Object O00oOooO;
    private Object O00oOooo;

    private ect() {
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.O0000Oo = "";
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        this.O0000o0o = "";
        this.O0000o = "";
        this.O0000oOo = "";
        this.O0000oo0 = "";
        this.O0000oo = "";
        this.O0000ooo = "";
        this.O00oOooO = "";
        this.O00oOooo = "";
        this.O000O0OO = Collections.emptyList();
        this.O00oOoOo = ProtoMsg$StatsMsg.NetworkType.NETWORK_UNKNOWN;
        this.O000O0o0 = "";
        this.O000O0o = "";
        this.O000O0oO = "";
        this.O000O0oo = "";
        this.O000OO00 = "";
        this.O000OO0o = "";
        this.O000OO = "";
        this.O000OOOo = "";
        O00000Oo();
    }

    private ect(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.O0000Oo = "";
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        this.O0000o0o = "";
        this.O0000o = "";
        this.O0000oOo = "";
        this.O0000oo0 = "";
        this.O0000oo = "";
        this.O0000ooo = "";
        this.O00oOooO = "";
        this.O00oOooo = "";
        this.O000O0OO = Collections.emptyList();
        this.O00oOoOo = ProtoMsg$StatsMsg.NetworkType.NETWORK_UNKNOWN;
        this.O000O0o0 = "";
        this.O000O0o = "";
        this.O000O0oO = "";
        this.O000O0oo = "";
        this.O000OO00 = "";
        this.O000OO0o = "";
        this.O000OO = "";
        this.O000OOOo = "";
        O00000Oo();
    }

    public /* synthetic */ ect(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    private ect O000000o(int i) {
        this.f15173O000000o |= 64;
        this.O0000Oo0 = i;
        onChanged();
        return this;
    }

    private ect O000000o(long j) {
        this.f15173O000000o |= 33554432;
        this.O000O00o = j;
        onChanged();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ect mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.Client client;
        ProtoMsg$StatsMsg.Client client2 = null;
        try {
            ProtoMsg$StatsMsg.Client client3 = (ProtoMsg$StatsMsg.Client) ProtoMsg$StatsMsg.Client.f6059O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (client3 != null) {
                O000000o(client3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            client = (ProtoMsg$StatsMsg.Client) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            client2 = client;
        }
        if (client2 != null) {
            O000000o(client2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ect mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.Client) {
            return O000000o((ProtoMsg$StatsMsg.Client) message);
        }
        super.mergeFrom(message);
        return this;
    }

    private ect O000000o(ProtoMsg$StatsMsg.NetworkType networkType) {
        if (networkType != null) {
            this.f15173O000000o |= 134217728;
            this.O00oOoOo = networkType;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    private ect O000000o(boolean z) {
        this.f15173O000000o |= 32768;
        this.O0000oO0 = z;
        onChanged();
        return this;
    }

    private ect O00000Oo(boolean z) {
        this.f15173O000000o |= 65536;
        this.O0000oO = z;
        onChanged();
        return this;
    }

    private void O00000Oo() {
        if (ProtoMsg$StatsMsg.Client.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    private ect O00000o(boolean z) {
        this.f15173O000000o |= 2097152;
        this.O0000ooO = z;
        onChanged();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public ect clear() {
        super.clear();
        this.O00000o0 = "";
        this.f15173O000000o &= -2;
        this.O00000o = "";
        this.f15173O000000o &= -3;
        this.O00000oO = "";
        this.f15173O000000o &= -5;
        this.O00000oo = "";
        this.f15173O000000o &= -9;
        this.O0000O0o = "";
        this.f15173O000000o &= -17;
        this.O0000OOo = "";
        this.f15173O000000o &= -33;
        this.O0000Oo0 = 0;
        this.f15173O000000o &= -65;
        this.O0000Oo = "";
        this.f15173O000000o &= -129;
        this.O0000OoO = "";
        this.f15173O000000o &= -257;
        this.O0000Ooo = "";
        this.f15173O000000o &= -513;
        this.O0000o00 = "";
        this.f15173O000000o &= -1025;
        this.O0000o0 = "";
        this.f15173O000000o &= -2049;
        this.O0000o0O = "";
        this.f15173O000000o &= -4097;
        this.O0000o0o = "";
        this.f15173O000000o &= -8193;
        this.O0000o = "";
        this.f15173O000000o &= -16385;
        this.O0000oO0 = false;
        this.f15173O000000o &= -32769;
        this.O0000oO = false;
        this.f15173O000000o &= -65537;
        this.O0000oOO = false;
        this.f15173O000000o &= -131073;
        this.O0000oOo = "";
        this.f15173O000000o &= -262145;
        this.O0000oo0 = "";
        this.f15173O000000o &= -524289;
        this.O0000oo = "";
        this.f15173O000000o &= -1048577;
        this.O0000ooO = false;
        this.f15173O000000o &= -2097153;
        this.O0000ooo = "";
        this.f15173O000000o &= -4194305;
        this.O00oOooO = "";
        this.f15173O000000o &= -8388609;
        this.O00oOooo = "";
        this.f15173O000000o &= -16777217;
        this.O000O00o = 0;
        this.f15173O000000o &= -33554433;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O000O0Oo;
        if (repeatedFieldBuilder == null) {
            this.O000O0OO = Collections.emptyList();
            this.f15173O000000o &= -67108865;
        } else {
            repeatedFieldBuilder.clear();
        }
        this.O00oOoOo = ProtoMsg$StatsMsg.NetworkType.NETWORK_UNKNOWN;
        this.f15173O000000o &= -134217729;
        this.O000O0o0 = "";
        this.f15173O000000o &= -268435457;
        this.O000O0o = "";
        this.f15173O000000o &= -536870913;
        this.O000O0oO = "";
        this.f15173O000000o &= -1073741825;
        this.O000O0oo = "";
        this.f15173O000000o &= Integer.MAX_VALUE;
        this.O000OO00 = "";
        this.O00000Oo &= -2;
        this.O000OO0o = "";
        this.O00000Oo &= -3;
        this.O000OO = "";
        this.O00000Oo &= -5;
        this.O000OOOo = "";
        this.O00000Oo &= -9;
        return this;
    }

    private ect O00000o0(boolean z) {
        this.f15173O000000o |= 131072;
        this.O0000oOO = z;
        onChanged();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ProtoMsg$StatsMsg.Client build() {
        ProtoMsg$StatsMsg.Client O00000oo2 = buildPartial();
        if (O00000oo2.isInitialized()) {
            return O00000oo2;
        }
        throw newUninitializedMessageException((Message) O00000oo2);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.Client buildPartial() {
        List list;
        int i = 0;
        ProtoMsg$StatsMsg.Client client = new ProtoMsg$StatsMsg.Client(this, (byte) 0);
        int i2 = this.f15173O000000o;
        int i3 = this.O00000Oo;
        int i4 = (i2 & 1) == 1 ? 1 : 0;
        Object unused = client.aC = this.O00000o0;
        if ((i2 & 2) == 2) {
            i4 |= 2;
        }
        Object unused2 = client.aD = this.O00000o;
        if ((i2 & 4) == 4) {
            i4 |= 4;
        }
        Object unused3 = client.aE = this.O00000oO;
        if ((i2 & 8) == 8) {
            i4 |= 8;
        }
        Object unused4 = client.aF = this.O00000oo;
        if ((i2 & 16) == 16) {
            i4 |= 16;
        }
        Object unused5 = client.aG = this.O0000O0o;
        if ((i2 & 32) == 32) {
            i4 |= 32;
        }
        Object unused6 = client.aH = this.O0000OOo;
        if ((i2 & 64) == 64) {
            i4 |= 64;
        }
        int unused7 = client.aI = this.O0000Oo0;
        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i4 |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        Object unused8 = client.aJ = this.O0000Oo;
        if ((i2 & 256) == 256) {
            i4 |= 256;
        }
        Object unused9 = client.aK = this.O0000OoO;
        if ((i2 & 512) == 512) {
            i4 |= 512;
        }
        Object unused10 = client.aL = this.O0000Ooo;
        if ((i2 & 1024) == 1024) {
            i4 |= 1024;
        }
        Object unused11 = client.aM = this.O0000o00;
        if ((i2 & 2048) == 2048) {
            i4 |= 2048;
        }
        Object unused12 = client.aN = this.O0000o0;
        if ((i2 & 4096) == 4096) {
            i4 |= 4096;
        }
        Object unused13 = client.aO = this.O0000o0O;
        if ((i2 & 8192) == 8192) {
            i4 |= 8192;
        }
        Object unused14 = client.aP = this.O0000o0o;
        if ((i2 & 16384) == 16384) {
            i4 |= 16384;
        }
        Object unused15 = client.aQ = this.O0000o;
        if ((32768 & i2) == 32768) {
            i4 |= 32768;
        }
        boolean unused16 = client.aR = this.O0000oO0;
        if ((65536 & i2) == 65536) {
            i4 |= 65536;
        }
        boolean unused17 = client.aS = this.O0000oO;
        if ((131072 & i2) == 131072) {
            i4 |= 131072;
        }
        boolean unused18 = client.aT = this.O0000oOO;
        if ((262144 & i2) == 262144) {
            i4 |= 262144;
        }
        Object unused19 = client.aU = this.O0000oOo;
        if ((524288 & i2) == 524288) {
            i4 |= 524288;
        }
        Object unused20 = client.aV = this.O0000oo0;
        if ((1048576 & i2) == 1048576) {
            i4 |= ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
        }
        Object unused21 = client.aW = this.O0000oo;
        if ((2097152 & i2) == 2097152) {
            i4 |= 2097152;
        }
        boolean unused22 = client.aX = this.O0000ooO;
        if ((4194304 & i2) == 4194304) {
            i4 |= 4194304;
        }
        Object unused23 = client.aY = this.O0000ooo;
        if ((8388608 & i2) == 8388608) {
            i4 |= 8388608;
        }
        Object unused24 = client.aZ = this.O00oOooO;
        if ((16777216 & i2) == 16777216) {
            i4 |= 16777216;
        }
        Object unused25 = client.ba = this.O00oOooo;
        if ((33554432 & i2) == 33554432) {
            i4 |= 33554432;
        }
        long unused26 = client.bb = this.O000O00o;
        RepeatedFieldBuilder repeatedFieldBuilder = this.O000O0Oo;
        if (repeatedFieldBuilder == null) {
            if ((this.f15173O000000o & 67108864) == 67108864) {
                this.O000O0OO = Collections.unmodifiableList(this.O000O0OO);
                this.f15173O000000o &= -67108865;
            }
            list = this.O000O0OO;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused27 = client.bc = list;
        if ((134217728 & i2) == 134217728) {
            i4 |= 67108864;
        }
        ProtoMsg$StatsMsg.NetworkType unused28 = client.bd = this.O00oOoOo;
        if ((268435456 & i2) == 268435456) {
            i4 |= 134217728;
        }
        Object unused29 = client.be = this.O000O0o0;
        if ((536870912 & i2) == 536870912) {
            i4 |= 268435456;
        }
        Object unused30 = client.bf = this.O000O0o;
        if ((1073741824 & i2) == 1073741824) {
            i4 |= 536870912;
        }
        Object unused31 = client.bg = this.O000O0oO;
        if ((i2 & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            i4 |= 1073741824;
        }
        Object unused32 = client.bh = this.O000O0oo;
        if ((i3 & 1) == 1) {
            i4 |= Integer.MIN_VALUE;
        }
        Object unused33 = client.bi = this.O000OO00;
        if ((i3 & 2) == 2) {
            i = 1;
        }
        Object unused34 = client.bj = this.O000OO0o;
        if ((i3 & 4) == 4) {
            i |= 2;
        }
        Object unused35 = client.bk = this.O000OO;
        if ((i3 & 8) == 8) {
            i |= 4;
        }
        Object unused36 = client.bl = this.O000OOOo;
        int unused37 = client.aA = i4;
        int unused38 = client.aB = i;
        onBuilt();
        return client;
    }

    private void O0000O0o() {
        if ((this.f15173O000000o & 67108864) != 67108864) {
            this.O000O0OO = new ArrayList(this.O000O0OO);
            this.f15173O000000o |= 67108864;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O000O0Oo == null) {
            this.O000O0Oo = new RepeatedFieldBuilder(this.O000O0OO, (this.f15173O000000o & 67108864) == 67108864, getParentForChildren(), isClean());
            this.O000O0OO = null;
        }
        return this.O000O0Oo;
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000o00;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000o0.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.Client.class, ect.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ect clone() {
        return new ect().O000000o(buildPartial());
    }

    public final ect O000000o(ProtoMsg$StatsMsg.Client client) {
        if (client == ProtoMsg$StatsMsg.Client.O000000o()) {
            return this;
        }
        if (client.O00000Oo()) {
            this.f15173O000000o |= 1;
            this.O00000o0 = client.aC;
            onChanged();
        }
        if (client.O00000o0()) {
            this.f15173O000000o |= 2;
            this.O00000o = client.aD;
            onChanged();
        }
        if (client.O00000o()) {
            this.f15173O000000o |= 4;
            this.O00000oO = client.aE;
            onChanged();
        }
        if (client.O00000oO()) {
            this.f15173O000000o |= 8;
            this.O00000oo = client.aF;
            onChanged();
        }
        if (client.O00000oo()) {
            this.f15173O000000o |= 16;
            this.O0000O0o = client.aG;
            onChanged();
        }
        if (client.O0000O0o()) {
            this.f15173O000000o |= 32;
            this.O0000OOo = client.aH;
            onChanged();
        }
        if (client.O0000OOo()) {
            O000000o(client.aI);
        }
        if (client.O0000Oo0()) {
            this.f15173O000000o |= NotificationCompat.FLAG_HIGH_PRIORITY;
            this.O0000Oo = client.aJ;
            onChanged();
        }
        if (client.O0000Oo()) {
            this.f15173O000000o |= 256;
            this.O0000OoO = client.aK;
            onChanged();
        }
        if (client.O0000OoO()) {
            this.f15173O000000o |= 512;
            this.O0000Ooo = client.aL;
            onChanged();
        }
        if (client.O0000Ooo()) {
            this.f15173O000000o |= 1024;
            this.O0000o00 = client.aM;
            onChanged();
        }
        if (client.O0000o00()) {
            this.f15173O000000o |= 2048;
            this.O0000o0 = client.aN;
            onChanged();
        }
        if (client.O0000o0()) {
            this.f15173O000000o |= 4096;
            this.O0000o0O = client.aO;
            onChanged();
        }
        if (client.O0000o0O()) {
            this.f15173O000000o |= 8192;
            this.O0000o0o = client.aP;
            onChanged();
        }
        if (client.O0000o0o()) {
            this.f15173O000000o |= 16384;
            this.O0000o = client.aQ;
            onChanged();
        }
        if (client.O0000o()) {
            O000000o(client.aR);
        }
        if (client.O0000oO0()) {
            O00000Oo(client.aS);
        }
        if (client.O0000oO()) {
            O00000o0(client.aT);
        }
        if (client.O0000oOO()) {
            this.f15173O000000o |= 262144;
            this.O0000oOo = client.aU;
            onChanged();
        }
        if (client.O0000oOo()) {
            this.f15173O000000o |= 524288;
            this.O0000oo0 = client.aV;
            onChanged();
        }
        if (client.O0000oo0()) {
            this.f15173O000000o |= ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
            this.O0000oo = client.aW;
            onChanged();
        }
        if (client.O0000oo()) {
            O00000o(client.aX);
        }
        if (client.O0000ooO()) {
            this.f15173O000000o |= 4194304;
            this.O0000ooo = client.aY;
            onChanged();
        }
        if (client.O0000ooo()) {
            this.f15173O000000o |= 8388608;
            this.O00oOooO = client.aZ;
            onChanged();
        }
        if (client.O00oOooO()) {
            this.f15173O000000o |= 16777216;
            this.O00oOooo = client.ba;
            onChanged();
        }
        if (client.O00oOooo()) {
            O000000o(client.bb);
        }
        if (this.O000O0Oo == null) {
            if (!client.bc.isEmpty()) {
                if (this.O000O0OO.isEmpty()) {
                    this.O000O0OO = client.bc;
                    this.f15173O000000o &= -67108865;
                } else {
                    O0000O0o();
                    this.O000O0OO.addAll(client.bc);
                }
                onChanged();
            }
        } else if (!client.bc.isEmpty()) {
            if (this.O000O0Oo.isEmpty()) {
                this.O000O0Oo.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O000O0Oo = null;
                this.O000O0OO = client.bc;
                this.f15173O000000o = -67108865 & this.f15173O000000o;
                if (ProtoMsg$StatsMsg.Client.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O000O0Oo = repeatedFieldBuilder;
            } else {
                this.O000O0Oo.addAllMessages(client.bc);
            }
        }
        if (client.O000O00o()) {
            O000000o(client.bd);
        }
        if (client.O000O0OO()) {
            this.f15173O000000o |= 268435456;
            this.O000O0o0 = client.be;
            onChanged();
        }
        if (client.O000O0Oo()) {
            this.f15173O000000o |= 536870912;
            this.O000O0o = client.bf;
            onChanged();
        }
        if (client.O00oOoOo()) {
            this.f15173O000000o |= 1073741824;
            this.O000O0oO = client.bg;
            onChanged();
        }
        if (client.O000O0o0()) {
            this.f15173O000000o |= Integer.MIN_VALUE;
            this.O000O0oo = client.bh;
            onChanged();
        }
        if (client.O000O0o()) {
            this.O00000Oo |= 1;
            this.O000OO00 = client.bi;
            onChanged();
        }
        if (client.O000O0oO()) {
            this.O00000Oo |= 2;
            this.O000OO0o = client.bj;
            onChanged();
        }
        if (client.O000O0oo()) {
            this.O00000Oo |= 4;
            this.O000OO = client.bk;
            onChanged();
        }
        if (client.O000OO00()) {
            this.O00000Oo |= 8;
            this.O000OOOo = client.bl;
            onChanged();
        }
        mergeUnknownFields(client.getUnknownFields());
        return this;
    }

    public final boolean isInitialized() {
        if (!((this.f15173O000000o & 1) == 1)) {
            return false;
        }
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O000O0Oo;
            if (i >= (repeatedFieldBuilder == null ? this.O000O0OO.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O000O0Oo;
            if (!((ProtoMsg$StatsMsg.ProtoMap) (repeatedFieldBuilder2 == null ? this.O000O0OO.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ ect O000000o() {
        return new ect();
    }
}
