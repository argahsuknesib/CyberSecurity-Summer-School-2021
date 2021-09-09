package com.xiaomi.mobilestats.data;

import _m_j.ecr;
import _m_j.ecs;
import _m_j.ect;
import _m_j.ecu;
import _m_j.ecv;
import _m_j.ecw;
import _m_j.ecx;
import _m_j.ecy;
import _m_j.ecz;
import _m_j.eda;
import _m_j.edb;
import _m_j.edc;
import _m_j.edd;
import _m_j.ede;
import _m_j.edf;
import _m_j.edg;
import _m_j.edh;
import _m_j.edi;
import _m_j.edj;
import _m_j.edk;
import _m_j.edl;
import _m_j.edm;
import _m_j.edn;
import _m_j.edo;
import _m_j.edp;
import _m_j.edq;
import _m_j.edr;
import _m_j.eds;
import _m_j.edt;
import _m_j.edx;
import _m_j.edy;
import _m_j.edz;
import _m_j.eea;
import _m_j.eeb;
import _m_j.eec;
import _m_j.eed;
import _m_j.eee;
import _m_j.eef;
import _m_j.eeg;
import _m_j.eeh;
import _m_j.eei;
import _m_j.eej;
import _m_j.eek;
import _m_j.eel;
import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ProtoMsg$StatsMsg extends GeneratedMessage implements edt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Parser f6058O000000o = new edx();
    private static final ProtoMsg$StatsMsg O00000Oo = new ProtoMsg$StatsMsg();
    private final UnknownFieldSet aw;
    private byte ax;
    private int ay;

    public enum NetworkType implements ProtocolMessageEnum {
        NETWORK_UNKNOWN(0, 0),
        NETWORK_WIFI(1, 1),
        NETWORK_2G(2, 2),
        NETWORK_3G(3, 3),
        NETWORK_4G(4, 4),
        NETWORK_BLUETOOTH(5, 5),
        NETWORK_OTHERS(6, 6);
        
        private static Internal.EnumLiteMap bQ = new eef();
        private static final NetworkType[] bR = values();
        private final int index;
        private final int value;

        private NetworkType(int i, int i2) {
            this.index = i;
            this.value = i2;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ProtoMsg$StatsMsg.O00000Oo().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap internalGetValueMap() {
            return bQ;
        }

        public static NetworkType valueOf(int i) {
            switch (i) {
                case 0:
                    return NETWORK_UNKNOWN;
                case 1:
                    return NETWORK_WIFI;
                case 2:
                    return NETWORK_2G;
                case 3:
                    return NETWORK_3G;
                case 4:
                    return NETWORK_4G;
                case 5:
                    return NETWORK_BLUETOOTH;
                case 6:
                    return NETWORK_OTHERS;
                default:
                    return null;
            }
        }

        public static NetworkType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return bR[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            return this.value;
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(this.index);
        }
    }

    private ProtoMsg$StatsMsg() {
        this.ax = -1;
        this.ay = -1;
        this.aw = UnknownFieldSet.getDefaultInstance();
    }

    private ProtoMsg$StatsMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.ax = -1;
        this.ay = -1;
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag == 0 || !parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                    z = true;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th) {
                this.aw = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        this.aw = newBuilder.build();
        makeExtensionsImmutable();
    }

    public /* synthetic */ ProtoMsg$StatsMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
        this(codedInputStream, extensionRegistryLite);
    }

    private ProtoMsg$StatsMsg(GeneratedMessage.Builder builder) {
        super(builder);
        this.ax = -1;
        this.ay = -1;
        this.aw = builder.getUnknownFields();
    }

    public /* synthetic */ ProtoMsg$StatsMsg(GeneratedMessage.Builder builder, byte b) {
        this(builder);
    }

    public static ProtoMsg$StatsMsg O000000o() {
        return O00000Oo;
    }

    public static final Descriptors.Descriptor O00000Oo() {
        return ecr.f15172O000000o;
    }

    public final Parser getParserForType() {
        return f6058O000000o;
    }

    public final int getSerializedSize() {
        int i = this.ay;
        if (i != -1) {
            return i;
        }
        int serializedSize = getUnknownFields().getSerializedSize() + 0;
        this.ay = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.aw;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O00000Oo.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.class, ecs.class);
    }

    public final boolean isInitialized() {
        byte b = this.ax;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.ax = 1;
        return true;
    }

    public final Object writeReplace() {
        return super.writeReplace();
    }

    public final void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        getUnknownFields().writeTo(codedOutputStream);
    }

    public final class Client extends GeneratedMessage implements ecw {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6059O000000o = new edy();
        private static final Client O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        /* access modifiers changed from: private */
        public int aB;
        /* access modifiers changed from: private */
        public Object aC;
        /* access modifiers changed from: private */
        public Object aD;
        /* access modifiers changed from: private */
        public Object aE;
        /* access modifiers changed from: private */
        public Object aF;
        /* access modifiers changed from: private */
        public Object aG;
        /* access modifiers changed from: private */
        public Object aH;
        public int aI;
        /* access modifiers changed from: private */
        public Object aJ;
        /* access modifiers changed from: private */
        public Object aK;
        /* access modifiers changed from: private */
        public Object aL;
        /* access modifiers changed from: private */
        public Object aM;
        /* access modifiers changed from: private */
        public Object aN;
        /* access modifiers changed from: private */
        public Object aO;
        /* access modifiers changed from: private */
        public Object aP;
        /* access modifiers changed from: private */
        public Object aQ;
        public boolean aR;
        public boolean aS;
        public boolean aT;
        /* access modifiers changed from: private */
        public Object aU;
        /* access modifiers changed from: private */
        public Object aV;
        /* access modifiers changed from: private */
        public Object aW;
        public boolean aX;
        /* access modifiers changed from: private */
        public Object aY;
        /* access modifiers changed from: private */
        public Object aZ;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public Object ba;
        public long bb;
        /* access modifiers changed from: private */
        public List bc;
        public NetworkType bd;
        /* access modifiers changed from: private */
        public Object be;
        /* access modifiers changed from: private */
        public Object bf;
        /* access modifiers changed from: private */
        public Object bg;
        /* access modifiers changed from: private */
        public Object bh;
        /* access modifiers changed from: private */
        public Object bi;
        /* access modifiers changed from: private */
        public Object bj;
        /* access modifiers changed from: private */
        public Object bk;
        /* access modifiers changed from: private */
        public Object bl;

        static {
            Client client = new Client();
            O00000Oo = client;
            client.O000o0o();
        }

        private Client() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private Client(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O000o0o();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.aC = readBytes;
                            continue;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.aD = readBytes2;
                            continue;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.aA |= 4;
                            this.aE = readBytes3;
                            continue;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.aA |= 8;
                            this.aF = readBytes4;
                            continue;
                        case 42:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.aA |= 16;
                            this.aG = readBytes5;
                            continue;
                        case 50:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.aA |= 32;
                            this.aH = readBytes6;
                            continue;
                        case 56:
                            this.aA |= 64;
                            this.aI = codedInputStream.readInt32();
                            continue;
                        case 66:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.aA |= NotificationCompat.FLAG_HIGH_PRIORITY;
                            this.aJ = readBytes7;
                            continue;
                        case 74:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.aA |= 256;
                            this.aK = readBytes8;
                            continue;
                        case XiaomiOAuthConstants.VERSION_MINOR:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.aA |= 512;
                            this.aL = readBytes9;
                            continue;
                        case 90:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.aA |= 1024;
                            this.aM = readBytes10;
                            continue;
                        case 98:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.aA |= 2048;
                            this.aN = readBytes11;
                            continue;
                        case 106:
                            ByteString readBytes12 = codedInputStream.readBytes();
                            this.aA |= 4096;
                            this.aO = readBytes12;
                            continue;
                        case 114:
                            ByteString readBytes13 = codedInputStream.readBytes();
                            this.aA |= 8192;
                            this.aP = readBytes13;
                            continue;
                        case 122:
                            ByteString readBytes14 = codedInputStream.readBytes();
                            this.aA |= 16384;
                            this.aQ = readBytes14;
                            continue;
                        case NotificationCompat.FLAG_HIGH_PRIORITY:
                            this.aA |= 32768;
                            this.aR = codedInputStream.readBool();
                            continue;
                        case 136:
                            this.aA |= 65536;
                            this.aS = codedInputStream.readBool();
                            continue;
                        case 144:
                            this.aA |= 131072;
                            this.aT = codedInputStream.readBool();
                            continue;
                        case 154:
                            ByteString readBytes15 = codedInputStream.readBytes();
                            this.aA |= 262144;
                            this.aU = readBytes15;
                            continue;
                        case 162:
                            ByteString readBytes16 = codedInputStream.readBytes();
                            this.aA |= 524288;
                            this.aV = readBytes16;
                            continue;
                        case 170:
                            ByteString readBytes17 = codedInputStream.readBytes();
                            this.aA |= ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
                            this.aW = readBytes17;
                            continue;
                        case 176:
                            this.aA |= 2097152;
                            this.aX = codedInputStream.readBool();
                            continue;
                        case 186:
                            ByteString readBytes18 = codedInputStream.readBytes();
                            this.aA |= 4194304;
                            this.aY = readBytes18;
                            continue;
                        case 194:
                            ByteString readBytes19 = codedInputStream.readBytes();
                            this.aA |= 8388608;
                            this.aZ = readBytes19;
                            continue;
                        case 202:
                            ByteString readBytes20 = codedInputStream.readBytes();
                            this.aA |= 16777216;
                            this.ba = readBytes20;
                            continue;
                        case 208:
                            this.aA |= 33554432;
                            this.bb = codedInputStream.readInt64();
                            continue;
                        case 218:
                            if (!(z2 & true)) {
                                this.bc = new ArrayList();
                                z2 |= true;
                            }
                            this.bc.add(codedInputStream.readMessage(ProtoMap.f6069O000000o, extensionRegistryLite));
                            continue;
                        case 224:
                            int readEnum = codedInputStream.readEnum();
                            NetworkType valueOf = NetworkType.valueOf(readEnum);
                            if (valueOf == null) {
                                newBuilder.mergeVarintField(28, readEnum);
                                continue;
                            } else {
                                this.aA |= 67108864;
                                this.bd = valueOf;
                            }
                        case 234:
                            ByteString readBytes21 = codedInputStream.readBytes();
                            this.aA |= 134217728;
                            this.be = readBytes21;
                            continue;
                        case 242:
                            ByteString readBytes22 = codedInputStream.readBytes();
                            this.aA |= 268435456;
                            this.bf = readBytes22;
                            continue;
                        case 250:
                            ByteString readBytes23 = codedInputStream.readBytes();
                            this.aA |= 536870912;
                            this.bg = readBytes23;
                            continue;
                        case 258:
                            ByteString readBytes24 = codedInputStream.readBytes();
                            this.aA |= 1073741824;
                            this.bh = readBytes24;
                            continue;
                        case 266:
                            ByteString readBytes25 = codedInputStream.readBytes();
                            this.aA |= Integer.MIN_VALUE;
                            this.bi = readBytes25;
                            continue;
                        case 274:
                            ByteString readBytes26 = codedInputStream.readBytes();
                            this.aB |= 1;
                            this.bj = readBytes26;
                            continue;
                        case 282:
                            ByteString readBytes27 = codedInputStream.readBytes();
                            this.aB |= 2;
                            this.bk = readBytes27;
                            continue;
                        case 290:
                            ByteString readBytes28 = codedInputStream.readBytes();
                            this.aB |= 4;
                            this.bl = readBytes28;
                            continue;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                continue;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.bc = Collections.unmodifiableList(this.bc);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.bc = Collections.unmodifiableList(this.bc);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ Client(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private Client(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ Client(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static Client O000000o() {
            return O00000Oo;
        }

        private ByteString O000OOOo() {
            Object obj = this.aC;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aC = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OOo() {
            Object obj = this.aE;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aE = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OOo0() {
            Object obj = this.aD;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aD = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OOoO() {
            Object obj = this.aF;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aF = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OOoo() {
            Object obj = this.aG;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aG = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Oo0() {
            Object obj = this.aJ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aJ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Oo00() {
            Object obj = this.aH;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aH = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Oo0O() {
            Object obj = this.aK;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aK = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Oo0o() {
            Object obj = this.aL;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aL = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OoO() {
            Object obj = this.aO;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aO = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OoO0() {
            Object obj = this.aM;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aM = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OoOO() {
            Object obj = this.aP;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aP = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OoOo() {
            Object obj = this.aQ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aQ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Ooo() {
            Object obj = this.aV;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aV = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Ooo0() {
            Object obj = this.aU;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aU = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OooO() {
            Object obj = this.aW;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aW = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000Oooo() {
            Object obj = this.aY;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aY = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o0() {
            Object obj = this.bg;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bg = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o00() {
            Object obj = this.ba;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ba = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o000() {
            Object obj = this.aZ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aZ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o00O() {
            Object obj = this.be;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.be = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o00o() {
            Object obj = this.bf;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bf = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o0O() {
            Object obj = this.bi;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bi = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o0O0() {
            Object obj = this.bh;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bh = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o0OO() {
            Object obj = this.bj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bj = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000o0Oo() {
            Object obj = this.bk;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bk = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O000o0o() {
            this.aC = "";
            this.aD = "";
            this.aE = "";
            this.aF = "";
            this.aG = "";
            this.aH = "";
            this.aI = 0;
            this.aJ = "";
            this.aK = "";
            this.aL = "";
            this.aM = "";
            this.aN = "";
            this.aO = "";
            this.aP = "";
            this.aQ = "";
            this.aR = false;
            this.aS = false;
            this.aT = false;
            this.aU = "";
            this.aV = "";
            this.aW = "";
            this.aX = false;
            this.aY = "";
            this.aZ = "";
            this.ba = "";
            this.bb = 0;
            this.bc = Collections.emptyList();
            this.bd = NetworkType.NETWORK_UNKNOWN;
            this.be = "";
            this.bf = "";
            this.bg = "";
            this.bh = "";
            this.bi = "";
            this.bj = "";
            this.bk = "";
            this.bl = "";
        }

        private ByteString O000o0o0() {
            Object obj = this.bl;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bl = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00O0Oo() {
            Object obj = this.aN;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aN = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o() {
            return (this.aA & 4) == 4;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final boolean O00000oO() {
            return (this.aA & 8) == 8;
        }

        public final boolean O00000oo() {
            return (this.aA & 16) == 16;
        }

        public final boolean O0000O0o() {
            return (this.aA & 32) == 32;
        }

        public final boolean O0000OOo() {
            return (this.aA & 64) == 64;
        }

        public final boolean O0000Oo() {
            return (this.aA & 256) == 256;
        }

        public final boolean O0000Oo0() {
            return (this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
        }

        public final boolean O0000OoO() {
            return (this.aA & 512) == 512;
        }

        public final boolean O0000Ooo() {
            return (this.aA & 1024) == 1024;
        }

        public final boolean O0000o() {
            return (this.aA & 32768) == 32768;
        }

        public final boolean O0000o0() {
            return (this.aA & 4096) == 4096;
        }

        public final boolean O0000o00() {
            return (this.aA & 2048) == 2048;
        }

        public final boolean O0000o0O() {
            return (this.aA & 8192) == 8192;
        }

        public final boolean O0000o0o() {
            return (this.aA & 16384) == 16384;
        }

        public final boolean O0000oO() {
            return (this.aA & 131072) == 131072;
        }

        public final boolean O0000oO0() {
            return (this.aA & 65536) == 65536;
        }

        public final boolean O0000oOO() {
            return (this.aA & 262144) == 262144;
        }

        public final boolean O0000oOo() {
            return (this.aA & 524288) == 524288;
        }

        public final boolean O0000oo() {
            return (this.aA & 2097152) == 2097152;
        }

        public final boolean O0000oo0() {
            return (this.aA & ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) == 1048576;
        }

        public final boolean O0000ooO() {
            return (this.aA & 4194304) == 4194304;
        }

        public final boolean O0000ooo() {
            return (this.aA & 8388608) == 8388608;
        }

        public final boolean O000O00o() {
            return (this.aA & 67108864) == 67108864;
        }

        public final boolean O000O0OO() {
            return (this.aA & 134217728) == 134217728;
        }

        public final boolean O000O0Oo() {
            return (this.aA & 268435456) == 268435456;
        }

        public final boolean O000O0o() {
            return (this.aA & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        }

        public final boolean O000O0o0() {
            return (this.aA & 1073741824) == 1073741824;
        }

        public final boolean O000O0oO() {
            return (this.aB & 1) == 1;
        }

        public final boolean O000O0oo() {
            return (this.aB & 2) == 2;
        }

        public final boolean O000OO00() {
            return (this.aB & 4) == 4;
        }

        public final boolean O00oOoOo() {
            return (this.aA & 536870912) == 536870912;
        }

        public final boolean O00oOooO() {
            return (this.aA & 16777216) == 16777216;
        }

        public final boolean O00oOooo() {
            return (this.aA & 33554432) == 33554432;
        }

        public final Parser getParserForType() {
            return f6059O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.aA & 1) == 1 ? CodedOutputStream.computeBytesSize(1, O000OOOo()) + 0 : 0;
            if ((this.aA & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, O000OOo0());
            }
            if ((this.aA & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, O000OOo());
            }
            if ((this.aA & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, O000OOoO());
            }
            if ((this.aA & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeBytesSize(5, O000OOoo());
            }
            if ((this.aA & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, O000Oo00());
            }
            if ((this.aA & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt32Size(7, this.aI);
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, O000Oo0());
            }
            if ((this.aA & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(9, O000Oo0O());
            }
            if ((this.aA & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeBytesSize(10, O000Oo0o());
            }
            if ((this.aA & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeBytesSize(11, O000OoO0());
            }
            if ((this.aA & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeBytesSize(12, O00O0Oo());
            }
            if ((this.aA & 4096) == 4096) {
                computeBytesSize += CodedOutputStream.computeBytesSize(13, O000OoO());
            }
            if ((this.aA & 8192) == 8192) {
                computeBytesSize += CodedOutputStream.computeBytesSize(14, O000OoOO());
            }
            if ((this.aA & 16384) == 16384) {
                computeBytesSize += CodedOutputStream.computeBytesSize(15, O000OoOo());
            }
            if ((this.aA & 32768) == 32768) {
                computeBytesSize += CodedOutputStream.computeBoolSize(16, this.aR);
            }
            if ((this.aA & 65536) == 65536) {
                computeBytesSize += CodedOutputStream.computeBoolSize(17, this.aS);
            }
            if ((this.aA & 131072) == 131072) {
                computeBytesSize += CodedOutputStream.computeBoolSize(18, this.aT);
            }
            if ((this.aA & 262144) == 262144) {
                computeBytesSize += CodedOutputStream.computeBytesSize(19, O000Ooo0());
            }
            if ((this.aA & 524288) == 524288) {
                computeBytesSize += CodedOutputStream.computeBytesSize(20, O000Ooo());
            }
            if ((this.aA & ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) == 1048576) {
                computeBytesSize += CodedOutputStream.computeBytesSize(21, O000OooO());
            }
            if ((this.aA & 2097152) == 2097152) {
                computeBytesSize += CodedOutputStream.computeBoolSize(22, this.aX);
            }
            if ((this.aA & 4194304) == 4194304) {
                computeBytesSize += CodedOutputStream.computeBytesSize(23, O000Oooo());
            }
            if ((this.aA & 8388608) == 8388608) {
                computeBytesSize += CodedOutputStream.computeBytesSize(24, O000o000());
            }
            if ((this.aA & 16777216) == 16777216) {
                computeBytesSize += CodedOutputStream.computeBytesSize(25, O000o00());
            }
            if ((this.aA & 33554432) == 33554432) {
                computeBytesSize += CodedOutputStream.computeInt64Size(26, this.bb);
            }
            for (int i2 = 0; i2 < this.bc.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(27, (MessageLite) this.bc.get(i2));
            }
            if ((this.aA & 67108864) == 67108864) {
                computeBytesSize += CodedOutputStream.computeEnumSize(28, this.bd.getNumber());
            }
            if ((this.aA & 134217728) == 134217728) {
                computeBytesSize += CodedOutputStream.computeBytesSize(29, O000o00O());
            }
            if ((this.aA & 268435456) == 268435456) {
                computeBytesSize += CodedOutputStream.computeBytesSize(30, O000o00o());
            }
            if ((this.aA & 536870912) == 536870912) {
                computeBytesSize += CodedOutputStream.computeBytesSize(31, O000o0());
            }
            if ((this.aA & 1073741824) == 1073741824) {
                computeBytesSize += CodedOutputStream.computeBytesSize(32, O000o0O0());
            }
            if ((this.aA & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                computeBytesSize += CodedOutputStream.computeBytesSize(33, O000o0O());
            }
            if ((this.aB & 1) == 1) {
                computeBytesSize += CodedOutputStream.computeBytesSize(34, O000o0OO());
            }
            if ((this.aB & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(35, O000o0Oo());
            }
            if ((this.aB & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(36, O000o0o0());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000o0.ensureFieldAccessorsInitialized(Client.class, ect.class);
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O000OOOo());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O000OOo0());
            }
            if ((this.aA & 4) == 4) {
                codedOutputStream.writeBytes(3, O000OOo());
            }
            if ((this.aA & 8) == 8) {
                codedOutputStream.writeBytes(4, O000OOoO());
            }
            if ((this.aA & 16) == 16) {
                codedOutputStream.writeBytes(5, O000OOoo());
            }
            if ((this.aA & 32) == 32) {
                codedOutputStream.writeBytes(6, O000Oo00());
            }
            if ((this.aA & 64) == 64) {
                codedOutputStream.writeInt32(7, this.aI);
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                codedOutputStream.writeBytes(8, O000Oo0());
            }
            if ((this.aA & 256) == 256) {
                codedOutputStream.writeBytes(9, O000Oo0O());
            }
            if ((this.aA & 512) == 512) {
                codedOutputStream.writeBytes(10, O000Oo0o());
            }
            if ((this.aA & 1024) == 1024) {
                codedOutputStream.writeBytes(11, O000OoO0());
            }
            if ((this.aA & 2048) == 2048) {
                codedOutputStream.writeBytes(12, O00O0Oo());
            }
            if ((this.aA & 4096) == 4096) {
                codedOutputStream.writeBytes(13, O000OoO());
            }
            if ((this.aA & 8192) == 8192) {
                codedOutputStream.writeBytes(14, O000OoOO());
            }
            if ((this.aA & 16384) == 16384) {
                codedOutputStream.writeBytes(15, O000OoOo());
            }
            if ((this.aA & 32768) == 32768) {
                codedOutputStream.writeBool(16, this.aR);
            }
            if ((this.aA & 65536) == 65536) {
                codedOutputStream.writeBool(17, this.aS);
            }
            if ((this.aA & 131072) == 131072) {
                codedOutputStream.writeBool(18, this.aT);
            }
            if ((this.aA & 262144) == 262144) {
                codedOutputStream.writeBytes(19, O000Ooo0());
            }
            if ((this.aA & 524288) == 524288) {
                codedOutputStream.writeBytes(20, O000Ooo());
            }
            if ((this.aA & ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) == 1048576) {
                codedOutputStream.writeBytes(21, O000OooO());
            }
            if ((this.aA & 2097152) == 2097152) {
                codedOutputStream.writeBool(22, this.aX);
            }
            if ((this.aA & 4194304) == 4194304) {
                codedOutputStream.writeBytes(23, O000Oooo());
            }
            if ((this.aA & 8388608) == 8388608) {
                codedOutputStream.writeBytes(24, O000o000());
            }
            if ((this.aA & 16777216) == 16777216) {
                codedOutputStream.writeBytes(25, O000o00());
            }
            if ((this.aA & 33554432) == 33554432) {
                codedOutputStream.writeInt64(26, this.bb);
            }
            for (int i = 0; i < this.bc.size(); i++) {
                codedOutputStream.writeMessage(27, (MessageLite) this.bc.get(i));
            }
            if ((this.aA & 67108864) == 67108864) {
                codedOutputStream.writeEnum(28, this.bd.getNumber());
            }
            if ((this.aA & 134217728) == 134217728) {
                codedOutputStream.writeBytes(29, O000o00O());
            }
            if ((this.aA & 268435456) == 268435456) {
                codedOutputStream.writeBytes(30, O000o00o());
            }
            if ((this.aA & 536870912) == 536870912) {
                codedOutputStream.writeBytes(31, O000o0());
            }
            if ((this.aA & 1073741824) == 1073741824) {
                codedOutputStream.writeBytes(32, O000o0O0());
            }
            if ((this.aA & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                codedOutputStream.writeBytes(33, O000o0O());
            }
            if ((this.aB & 1) == 1) {
                codedOutputStream.writeBytes(34, O000o0OO());
            }
            if ((this.aB & 2) == 2) {
                codedOutputStream.writeBytes(35, O000o0Oo());
            }
            if ((this.aB & 4) == 4) {
                codedOutputStream.writeBytes(36, O000o0o0());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            }
            for (int i = 0; i < this.bc.size(); i++) {
                if (!((ProtoMap) this.bc.get(i)).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000o0oo */
        public ect toBuilder() {
            return ect.O000000o().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new ect(builderParent, (byte) 0);
        }
    }

    public final class ClientMsg extends GeneratedMessage implements ecv {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6060O000000o = new edz();
        private static final ClientMsg O00000Oo;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public List bo;

        private ClientMsg() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        public /* synthetic */ ClientMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private ClientMsg(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ ClientMsg(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static ClientMsg O000000o() {
            return O00000Oo;
        }

        public static ClientMsg O000000o(byte[] bArr) {
            return (ClientMsg) f6060O000000o.parseFrom(bArr);
        }

        public static ecu O00000o0() {
            return ecu.O00000Oo();
        }

        public final Client O000000o(int i) {
            return (Client) this.bo.get(i);
        }

        public final int O00000Oo() {
            return this.bo.size();
        }

        public final Parser getParserForType() {
            return f6060O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.bo.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.bo.get(i3));
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000o0o.ensureFieldAccessorsInitialized(ClientMsg.class, ecu.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < O00000Oo(); i++) {
                if (!O000000o(i).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.bo.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.bo.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private ClientMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            this.bo = Collections.emptyList();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.bo = new ArrayList();
                                z2 |= true;
                            }
                            this.bo.add(codedInputStream.readMessage(Client.f6059O000000o, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.bo = Collections.unmodifiableList(this.bo);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.bo = Collections.unmodifiableList(this.bo);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public ecu toBuilder() {
            return ecu.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new ecu(builderParent, (byte) 0);
        }

        static {
            ClientMsg clientMsg = new ClientMsg();
            O00000Oo = clientMsg;
            clientMsg.bo = Collections.emptyList();
        }
    }

    public final class Crash extends GeneratedMessage implements eda {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6061O000000o = new eea();
        private static final Crash O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        /* access modifiers changed from: private */
        public Object aC;
        public Object aD;
        public Object aE;
        public Object aF;
        public Object aG;
        public Object aH;
        public int aI;
        public Object aJ;
        /* access modifiers changed from: private */
        public Object aM;
        public Object aP;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public Object bA;
        public long bb;
        public Object bh;
        /* access modifiers changed from: private */
        public Object bj;
        public Object bv;
        public List bw;
        public Object bx;
        public Object by;
        public int bz;

        static {
            Crash crash = new Crash();
            O00000Oo = crash;
            crash.O000OOOo();
        }

        private Crash() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O000OOOo();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.aC = readBytes;
                            continue;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.aD = readBytes2;
                            continue;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.aA |= 4;
                            this.aE = readBytes3;
                            continue;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.aA |= 8;
                            this.aF = readBytes4;
                            continue;
                        case 40:
                            this.aA |= 16;
                            this.bb = codedInputStream.readInt64();
                            continue;
                        case 50:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.aA |= 32;
                            this.aG = readBytes5;
                            continue;
                        case 58:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.aA |= 64;
                            this.bv = readBytes6;
                            continue;
                        case 66:
                            if (!(z2 & true)) {
                                this.bw = new ArrayList();
                                z2 |= true;
                            }
                            this.bw.add(codedInputStream.readMessage(ProtoMap.f6069O000000o, extensionRegistryLite));
                            continue;
                        case 72:
                            this.aA |= NotificationCompat.FLAG_HIGH_PRIORITY;
                            this.aI = codedInputStream.readInt32();
                            continue;
                        case XiaomiOAuthConstants.VERSION_MINOR:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.aA |= 256;
                            this.aJ = readBytes7;
                            continue;
                        case 90:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.aA |= 512;
                            this.aH = readBytes8;
                            continue;
                        case 98:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.aA |= 1024;
                            this.aP = readBytes9;
                            continue;
                        case 106:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.aA |= 2048;
                            this.aM = readBytes10;
                            continue;
                        case 114:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.aA |= 4096;
                            this.bx = readBytes11;
                            continue;
                        case 122:
                            ByteString readBytes12 = codedInputStream.readBytes();
                            this.aA |= 8192;
                            this.by = readBytes12;
                            continue;
                        case NotificationCompat.FLAG_HIGH_PRIORITY:
                            this.aA |= 16384;
                            this.bz = codedInputStream.readInt32();
                            continue;
                        case 138:
                            ByteString readBytes13 = codedInputStream.readBytes();
                            this.aA |= 32768;
                            this.bA = readBytes13;
                            continue;
                        case 146:
                            ByteString readBytes14 = codedInputStream.readBytes();
                            this.aA |= 65536;
                            this.bh = readBytes14;
                            continue;
                        case 154:
                            ByteString readBytes15 = codedInputStream.readBytes();
                            this.aA |= 131072;
                            this.bj = readBytes15;
                            continue;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                continue;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.bw = Collections.unmodifiableList(this.bw);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.bw = Collections.unmodifiableList(this.bw);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private Crash(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ Crash(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static Crash O000000o() {
            return O00000Oo;
        }

        public static ecx O0000oOo() {
            return ecx.O00000Oo();
        }

        private ByteString O0000ooO() {
            Object obj = this.aC;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aC = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooo() {
            Object obj = this.aD;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aD = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O00o() {
            Object obj = this.aG;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aG = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0OO() {
            Object obj = this.bv;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bv = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0Oo() {
            Object obj = this.aJ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aJ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0o() {
            Object obj = this.aM;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aM = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0o0() {
            Object obj = this.aP;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aP = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0oO() {
            Object obj = this.bx;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bx = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0oo() {
            Object obj = this.by;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.by = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO() {
            Object obj = this.bj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bj = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO00() {
            Object obj = this.bA;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bA = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO0o() {
            Object obj = this.bh;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bh = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O000OOOo() {
            this.aC = "";
            this.aD = "";
            this.aE = "";
            this.aF = "";
            this.bb = 0;
            this.aG = "";
            this.bv = "";
            this.bw = Collections.emptyList();
            this.aI = 0;
            this.aJ = "";
            this.aH = "";
            this.aP = "";
            this.aM = "";
            this.bx = "";
            this.by = "";
            this.bz = 0;
            this.bA = "";
            this.bh = "";
            this.bj = "";
        }

        private ByteString O00oOoOo() {
            Object obj = this.aH;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aH = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooO() {
            Object obj = this.aE;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aE = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooo() {
            Object obj = this.aF;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aF = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o() {
            return (this.aA & 4) == 4;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final boolean O00000oO() {
            return (this.aA & 8) == 8;
        }

        public final boolean O00000oo() {
            return (this.aA & 16) == 16;
        }

        public final boolean O0000O0o() {
            return (this.aA & 32) == 32;
        }

        public final boolean O0000OOo() {
            return (this.aA & 64) == 64;
        }

        public final boolean O0000Oo() {
            return (this.aA & 256) == 256;
        }

        public final boolean O0000Oo0() {
            return (this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
        }

        public final boolean O0000OoO() {
            return (this.aA & 512) == 512;
        }

        public final boolean O0000Ooo() {
            return (this.aA & 1024) == 1024;
        }

        public final boolean O0000o() {
            return (this.aA & 32768) == 32768;
        }

        public final boolean O0000o0() {
            return (this.aA & 4096) == 4096;
        }

        public final boolean O0000o00() {
            return (this.aA & 2048) == 2048;
        }

        public final boolean O0000o0O() {
            return (this.aA & 8192) == 8192;
        }

        public final boolean O0000o0o() {
            return (this.aA & 16384) == 16384;
        }

        public final boolean O0000oO() {
            return (this.aA & 65536) == 65536;
        }

        public final String O0000oO0() {
            Object obj = this.bA;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bA = stringUtf8;
            }
            return stringUtf8;
        }

        public final boolean O0000oOO() {
            return (this.aA & 131072) == 131072;
        }

        public final Parser getParserForType() {
            return f6061O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.aA & 1) == 1 ? CodedOutputStream.computeBytesSize(1, O0000ooO()) + 0 : 0;
            if ((this.aA & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, O0000ooo());
            }
            if ((this.aA & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, O00oOooO());
            }
            if ((this.aA & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, O00oOooo());
            }
            if ((this.aA & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.bb);
            }
            if ((this.aA & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, O000O00o());
            }
            if ((this.aA & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeBytesSize(7, O000O0OO());
            }
            for (int i2 = 0; i2 < this.bw.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(8, (MessageLite) this.bw.get(i2));
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                computeBytesSize += CodedOutputStream.computeInt32Size(9, this.aI);
            }
            if ((this.aA & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(10, O000O0Oo());
            }
            if ((this.aA & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeBytesSize(11, O00oOoOo());
            }
            if ((this.aA & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeBytesSize(12, O000O0o0());
            }
            if ((this.aA & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeBytesSize(13, O000O0o());
            }
            if ((this.aA & 4096) == 4096) {
                computeBytesSize += CodedOutputStream.computeBytesSize(14, O000O0oO());
            }
            if ((this.aA & 8192) == 8192) {
                computeBytesSize += CodedOutputStream.computeBytesSize(15, O000O0oo());
            }
            if ((this.aA & 16384) == 16384) {
                computeBytesSize += CodedOutputStream.computeInt32Size(16, this.bz);
            }
            if ((this.aA & 32768) == 32768) {
                computeBytesSize += CodedOutputStream.computeBytesSize(17, O000OO00());
            }
            if ((this.aA & 65536) == 65536) {
                computeBytesSize += CodedOutputStream.computeBytesSize(18, O000OO0o());
            }
            if ((this.aA & 131072) == 131072) {
                computeBytesSize += CodedOutputStream.computeBytesSize(19, O000OO());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000ooO.ensureFieldAccessorsInitialized(Crash.class, ecx.class);
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O0000ooO());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O0000ooo());
            }
            if ((this.aA & 4) == 4) {
                codedOutputStream.writeBytes(3, O00oOooO());
            }
            if ((this.aA & 8) == 8) {
                codedOutputStream.writeBytes(4, O00oOooo());
            }
            if ((this.aA & 16) == 16) {
                codedOutputStream.writeInt64(5, this.bb);
            }
            if ((this.aA & 32) == 32) {
                codedOutputStream.writeBytes(6, O000O00o());
            }
            if ((this.aA & 64) == 64) {
                codedOutputStream.writeBytes(7, O000O0OO());
            }
            for (int i = 0; i < this.bw.size(); i++) {
                codedOutputStream.writeMessage(8, (MessageLite) this.bw.get(i));
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                codedOutputStream.writeInt32(9, this.aI);
            }
            if ((this.aA & 256) == 256) {
                codedOutputStream.writeBytes(10, O000O0Oo());
            }
            if ((this.aA & 512) == 512) {
                codedOutputStream.writeBytes(11, O00oOoOo());
            }
            if ((this.aA & 1024) == 1024) {
                codedOutputStream.writeBytes(12, O000O0o0());
            }
            if ((this.aA & 2048) == 2048) {
                codedOutputStream.writeBytes(13, O000O0o());
            }
            if ((this.aA & 4096) == 4096) {
                codedOutputStream.writeBytes(14, O000O0oO());
            }
            if ((this.aA & 8192) == 8192) {
                codedOutputStream.writeBytes(15, O000O0oo());
            }
            if ((this.aA & 16384) == 16384) {
                codedOutputStream.writeInt32(16, this.bz);
            }
            if ((this.aA & 32768) == 32768) {
                codedOutputStream.writeBytes(17, O000OO00());
            }
            if ((this.aA & 65536) == 65536) {
                codedOutputStream.writeBytes(18, O000OO0o());
            }
            if ((this.aA & 131072) == 131072) {
                codedOutputStream.writeBytes(19, O000OO());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            }
            for (int i = 0; i < this.bw.size(); i++) {
                if (!((ProtoMap) this.bw.get(i)).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000OOo0 */
        public ecx toBuilder() {
            return ecx.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new ecx(builderParent, (byte) 0);
        }
    }

    public final class CrashMsg extends GeneratedMessage implements ecz {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6062O000000o = new eeb();
        private static final CrashMsg O00000Oo;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public List bD;

        private CrashMsg() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        public /* synthetic */ CrashMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private CrashMsg(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ CrashMsg(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static CrashMsg O000000o() {
            return O00000Oo;
        }

        public static CrashMsg O000000o(byte[] bArr) {
            return (CrashMsg) f6062O000000o.parseFrom(bArr);
        }

        public static ecy O00000o0() {
            return ecy.O00000Oo();
        }

        public final Crash O000000o(int i) {
            return (Crash) this.bD.get(i);
        }

        public final int O00000Oo() {
            return this.bD.size();
        }

        public final Parser getParserForType() {
            return f6062O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.bD.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.bD.get(i3));
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O00oOooO.ensureFieldAccessorsInitialized(CrashMsg.class, ecy.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < O00000Oo(); i++) {
                if (!O000000o(i).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.bD.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.bD.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private CrashMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            this.bD = Collections.emptyList();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.bD = new ArrayList();
                                z2 |= true;
                            }
                            this.bD.add(codedInputStream.readMessage(Crash.f6061O000000o, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.bD = Collections.unmodifiableList(this.bD);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.bD = Collections.unmodifiableList(this.bD);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public ecy toBuilder() {
            return ecy.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new ecy(builderParent, (byte) 0);
        }

        static {
            CrashMsg crashMsg = new CrashMsg();
            O00000Oo = crashMsg;
            crashMsg.bD = Collections.emptyList();
        }
    }

    public final class ErrorMsg extends GeneratedMessage implements edc {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6063O000000o = new eec();
        private static final ErrorMsg O00000Oo;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public List bG;

        private ErrorMsg() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        public /* synthetic */ ErrorMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private ErrorMsg(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ ErrorMsg(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static ErrorMsg O000000o() {
            return O00000Oo;
        }

        public static ErrorMsg O000000o(byte[] bArr) {
            return (ErrorMsg) f6063O000000o.parseFrom(bArr);
        }

        public static edb O00000o0() {
            return edb.O00000Oo();
        }

        public final ProtoError O000000o(int i) {
            return (ProtoError) this.bG.get(i);
        }

        public final int O00000Oo() {
            return this.bG.size();
        }

        public final Parser getParserForType() {
            return f6063O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.bG.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.bG.get(i3));
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000oo0.ensureFieldAccessorsInitialized(ErrorMsg.class, edb.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < O00000Oo(); i++) {
                if (!O000000o(i).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.bG.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.bG.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private ErrorMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            this.bG = Collections.emptyList();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.bG = new ArrayList();
                                z2 |= true;
                            }
                            this.bG.add(codedInputStream.readMessage(ProtoError.f6068O000000o, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.bG = Collections.unmodifiableList(this.bG);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.bG = Collections.unmodifiableList(this.bG);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public edb toBuilder() {
            return edb.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edb(builderParent, (byte) 0);
        }

        static {
            ErrorMsg errorMsg = new ErrorMsg();
            O00000Oo = errorMsg;
            errorMsg.bG = Collections.emptyList();
        }
    }

    public final class Event extends GeneratedMessage implements edg {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6064O000000o = new eed();
        private static final Event O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        /* access modifiers changed from: private */
        public Object aC;
        /* access modifiers changed from: private */
        public Object aD;
        /* access modifiers changed from: private */
        public Object aE;
        /* access modifiers changed from: private */
        public Object aF;
        /* access modifiers changed from: private */
        public Object aG;
        /* access modifiers changed from: private */
        public Object aH;
        /* access modifiers changed from: private */
        public Object aM;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public Object bJ;
        /* access modifiers changed from: private */
        public Object bK;
        /* access modifiers changed from: private */
        public List bL;
        public long bb;
        /* access modifiers changed from: private */
        public Object bh;
        /* access modifiers changed from: private */
        public Object bj;

        static {
            Event event = new Event();
            O00000Oo = event;
            event.O00oOooo();
        }

        private Event() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private Event(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O00oOooo();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.aC = readBytes;
                            continue;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.aF = readBytes2;
                            continue;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.aA |= 4;
                            this.aH = readBytes3;
                            continue;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.aA |= 8;
                            this.aG = readBytes4;
                            continue;
                        case 40:
                            this.aA |= 16;
                            this.bb = codedInputStream.readInt64();
                            continue;
                        case 50:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.aA |= 32;
                            this.bJ = readBytes5;
                            continue;
                        case 58:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.aA |= 64;
                            this.bK = readBytes6;
                            continue;
                        case 66:
                            if (!(z2 & true)) {
                                this.bL = new ArrayList();
                                z2 |= true;
                            }
                            this.bL.add(codedInputStream.readMessage(ProtoMap.f6069O000000o, extensionRegistryLite));
                            continue;
                        case 74:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.aA |= NotificationCompat.FLAG_HIGH_PRIORITY;
                            this.aM = readBytes7;
                            continue;
                        case XiaomiOAuthConstants.VERSION_MINOR:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.aA |= 256;
                            this.aD = readBytes8;
                            continue;
                        case 90:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.aA |= 512;
                            this.aE = readBytes9;
                            continue;
                        case 98:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.aA |= 1024;
                            this.bh = readBytes10;
                            continue;
                        case 106:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.aA |= 2048;
                            this.bj = readBytes11;
                            continue;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                continue;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.bL = Collections.unmodifiableList(this.bL);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.bL = Collections.unmodifiableList(this.bL);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ Event(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private Event(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ Event(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static Event O000000o() {
            return O00000Oo;
        }

        private ByteString O0000o() {
            Object obj = this.aF;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aF = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000o0o() {
            Object obj = this.aC;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aC = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oO() {
            Object obj = this.aG;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aG = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oO0() {
            Object obj = this.aH;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aH = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oOO() {
            Object obj = this.bJ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bJ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oOo() {
            Object obj = this.bK;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bK = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oo() {
            Object obj = this.aD;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aD = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oo0() {
            Object obj = this.aM;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aM = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooO() {
            Object obj = this.aE;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aE = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooo() {
            Object obj = this.bh;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bh = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooO() {
            Object obj = this.bj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bj = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O00oOooo() {
            this.aC = "";
            this.aF = "";
            this.aH = "";
            this.aG = "";
            this.bb = 0;
            this.bJ = "";
            this.bK = "";
            this.bL = Collections.emptyList();
            this.aM = "";
            this.aD = "";
            this.aE = "";
            this.bh = "";
            this.bj = "";
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o() {
            return (this.aA & 4) == 4;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final boolean O00000oO() {
            return (this.aA & 8) == 8;
        }

        public final boolean O00000oo() {
            return (this.aA & 16) == 16;
        }

        public final boolean O0000O0o() {
            return (this.aA & 32) == 32;
        }

        public final boolean O0000OOo() {
            return (this.aA & 64) == 64;
        }

        public final boolean O0000Oo() {
            return (this.aA & 256) == 256;
        }

        public final boolean O0000Oo0() {
            return (this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
        }

        public final boolean O0000OoO() {
            return (this.aA & 512) == 512;
        }

        public final boolean O0000Ooo() {
            return (this.aA & 1024) == 1024;
        }

        public final boolean O0000o00() {
            return (this.aA & 2048) == 2048;
        }

        public final Parser getParserForType() {
            return f6064O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.aA & 1) == 1 ? CodedOutputStream.computeBytesSize(1, O0000o0o()) + 0 : 0;
            if ((this.aA & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, O0000o());
            }
            if ((this.aA & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, O0000oO0());
            }
            if ((this.aA & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, O0000oO());
            }
            if ((this.aA & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.bb);
            }
            if ((this.aA & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, O0000oOO());
            }
            if ((this.aA & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeBytesSize(7, O0000oOo());
            }
            for (int i2 = 0; i2 < this.bL.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(8, (MessageLite) this.bL.get(i2));
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(9, O0000oo0());
            }
            if ((this.aA & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(10, O0000oo());
            }
            if ((this.aA & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeBytesSize(11, O0000ooO());
            }
            if ((this.aA & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeBytesSize(12, O0000ooo());
            }
            if ((this.aA & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeBytesSize(13, O00oOooO());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000Oo.ensureFieldAccessorsInitialized(Event.class, edd.class);
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O0000o0o());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O0000o());
            }
            if ((this.aA & 4) == 4) {
                codedOutputStream.writeBytes(3, O0000oO0());
            }
            if ((this.aA & 8) == 8) {
                codedOutputStream.writeBytes(4, O0000oO());
            }
            if ((this.aA & 16) == 16) {
                codedOutputStream.writeInt64(5, this.bb);
            }
            if ((this.aA & 32) == 32) {
                codedOutputStream.writeBytes(6, O0000oOO());
            }
            if ((this.aA & 64) == 64) {
                codedOutputStream.writeBytes(7, O0000oOo());
            }
            for (int i = 0; i < this.bL.size(); i++) {
                codedOutputStream.writeMessage(8, (MessageLite) this.bL.get(i));
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                codedOutputStream.writeBytes(9, O0000oo0());
            }
            if ((this.aA & 256) == 256) {
                codedOutputStream.writeBytes(10, O0000oo());
            }
            if ((this.aA & 512) == 512) {
                codedOutputStream.writeBytes(11, O0000ooO());
            }
            if ((this.aA & 1024) == 1024) {
                codedOutputStream.writeBytes(12, O0000ooo());
            }
            if ((this.aA & 2048) == 2048) {
                codedOutputStream.writeBytes(13, O00oOooO());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            }
            for (int i = 0; i < this.bL.size(); i++) {
                if (!((ProtoMap) this.bL.get(i)).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000O00o */
        public edd toBuilder() {
            return edd.O000000o().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edd(builderParent, (byte) 0);
        }
    }

    public final class EventMsg extends GeneratedMessage implements edf {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6065O000000o = new eee();
        private static final EventMsg O00000Oo;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public List bO;

        private EventMsg() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        public /* synthetic */ EventMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private EventMsg(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ EventMsg(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static EventMsg O000000o() {
            return O00000Oo;
        }

        public static EventMsg O000000o(byte[] bArr) {
            return (EventMsg) f6065O000000o.parseFrom(bArr);
        }

        public static ede O00000o0() {
            return ede.O00000Oo();
        }

        public final Event O000000o(int i) {
            return (Event) this.bO.get(i);
        }

        public final int O00000Oo() {
            return this.bO.size();
        }

        public final Parser getParserForType() {
            return f6065O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.bO.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.bO.get(i3));
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000Ooo.ensureFieldAccessorsInitialized(EventMsg.class, ede.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < O00000Oo(); i++) {
                if (!O000000o(i).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.bO.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.bO.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private EventMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            this.bO = Collections.emptyList();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.bO = new ArrayList();
                                z2 |= true;
                            }
                            this.bO.add(codedInputStream.readMessage(Event.f6064O000000o, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.bO = Collections.unmodifiableList(this.bO);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.bO = Collections.unmodifiableList(this.bO);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public ede toBuilder() {
            return ede.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new ede(builderParent, (byte) 0);
        }

        static {
            EventMsg eventMsg = new EventMsg();
            O00000Oo = eventMsg;
            eventMsg.bO = Collections.emptyList();
        }
    }

    public final class Page extends GeneratedMessage implements edk {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6066O000000o = new eeg();
        private static final Page O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        /* access modifiers changed from: private */
        public Object aC;
        /* access modifiers changed from: private */
        public Object aD;
        /* access modifiers changed from: private */
        public Object aE;
        /* access modifiers changed from: private */
        public Object aF;
        /* access modifiers changed from: private */
        public Object aG;
        /* access modifiers changed from: private */
        public Object aH;
        public int aI;
        /* access modifiers changed from: private */
        public Object aJ;
        /* access modifiers changed from: private */
        public Object aK;
        /* access modifiers changed from: private */
        public Object aL;
        /* access modifiers changed from: private */
        public Object aM;
        /* access modifiers changed from: private */
        public Object aP;
        /* access modifiers changed from: private */
        public Object aU;
        /* access modifiers changed from: private */
        public Object aV;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        public long bU;
        public long bV;
        public long bW;
        /* access modifiers changed from: private */
        public Object bX;
        /* access modifiers changed from: private */
        public List bY;
        /* access modifiers changed from: private */
        public Object bh;
        /* access modifiers changed from: private */
        public Object bj;

        static {
            Page page = new Page();
            O00000Oo = page;
            page.O000OOo();
        }

        private Page() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private Page(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O000OOo();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.aC = readBytes;
                            continue;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.aF = readBytes2;
                            continue;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.aA |= 4;
                            this.aH = readBytes3;
                            continue;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.aA |= 8;
                            this.aG = readBytes4;
                            continue;
                        case 40:
                            this.aA |= 16;
                            this.bU = codedInputStream.readInt64();
                            continue;
                        case 48:
                            this.aA |= 32;
                            this.bV = codedInputStream.readInt64();
                            continue;
                        case 56:
                            this.aA |= 64;
                            this.bW = codedInputStream.readInt64();
                            continue;
                        case 66:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.aA |= NotificationCompat.FLAG_HIGH_PRIORITY;
                            this.bX = readBytes5;
                            continue;
                        case 74:
                            if (!(z2 & true)) {
                                this.bY = new ArrayList();
                                z2 |= true;
                            }
                            this.bY.add(codedInputStream.readMessage(ProtoMap.f6069O000000o, extensionRegistryLite));
                            continue;
                        case XiaomiOAuthConstants.VERSION_MINOR:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.aA |= 256;
                            this.aM = readBytes6;
                            continue;
                        case 90:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.aA |= 512;
                            this.aD = readBytes7;
                            continue;
                        case 98:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.aA |= 1024;
                            this.aE = readBytes8;
                            continue;
                        case 106:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.aA |= 2048;
                            this.bh = readBytes9;
                            continue;
                        case 114:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.aA |= 4096;
                            this.bj = readBytes10;
                            continue;
                        case 120:
                            this.aA |= 8192;
                            this.aI = codedInputStream.readInt32();
                            continue;
                        case 130:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.aA |= 16384;
                            this.aJ = readBytes11;
                            continue;
                        case 138:
                            ByteString readBytes12 = codedInputStream.readBytes();
                            this.aA |= 32768;
                            this.aK = readBytes12;
                            continue;
                        case 146:
                            ByteString readBytes13 = codedInputStream.readBytes();
                            this.aA |= 65536;
                            this.aL = readBytes13;
                            continue;
                        case 154:
                            ByteString readBytes14 = codedInputStream.readBytes();
                            this.aA |= 131072;
                            this.aP = readBytes14;
                            continue;
                        case 162:
                            ByteString readBytes15 = codedInputStream.readBytes();
                            this.aA |= 262144;
                            this.aU = readBytes15;
                            continue;
                        case 170:
                            ByteString readBytes16 = codedInputStream.readBytes();
                            this.aA |= 524288;
                            this.aV = readBytes16;
                            continue;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                continue;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.bY = Collections.unmodifiableList(this.bY);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.bY = Collections.unmodifiableList(this.bY);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ Page(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private Page(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ Page(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static Page O000000o() {
            return O00000Oo;
        }

        public static edh O0000oo0() {
            return edh.O00000Oo();
        }

        private ByteString O0000ooo() {
            Object obj = this.aC;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aC = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O00o() {
            Object obj = this.aG;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aG = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0OO() {
            Object obj = this.bX;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bX = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0Oo() {
            Object obj = this.aM;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aM = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0o() {
            Object obj = this.bh;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bh = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0o0() {
            Object obj = this.aE;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aE = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0oO() {
            Object obj = this.bj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bj = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0oo() {
            Object obj = this.aJ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aJ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO() {
            Object obj = this.aP;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aP = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO00() {
            Object obj = this.aK;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aK = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO0o() {
            Object obj = this.aL;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aL = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OOOo() {
            Object obj = this.aU;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aU = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O000OOo() {
            this.aC = "";
            this.aF = "";
            this.aH = "";
            this.aG = "";
            this.bU = 0;
            this.bV = 0;
            this.bW = 0;
            this.bX = "";
            this.bY = Collections.emptyList();
            this.aM = "";
            this.aD = "";
            this.aE = "";
            this.bh = "";
            this.bj = "";
            this.aI = 0;
            this.aJ = "";
            this.aK = "";
            this.aL = "";
            this.aP = "";
            this.aU = "";
            this.aV = "";
        }

        private ByteString O000OOo0() {
            Object obj = this.aV;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aV = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOoOo() {
            Object obj = this.aD;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aD = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooO() {
            Object obj = this.aF;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aF = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooo() {
            Object obj = this.aH;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aH = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o() {
            return (this.aA & 4) == 4;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final boolean O00000oO() {
            return (this.aA & 8) == 8;
        }

        public final boolean O00000oo() {
            return (this.aA & 16) == 16;
        }

        public final boolean O0000O0o() {
            return (this.aA & 32) == 32;
        }

        public final boolean O0000OOo() {
            return (this.aA & 64) == 64;
        }

        public final boolean O0000Oo() {
            return (this.aA & 256) == 256;
        }

        public final boolean O0000Oo0() {
            return (this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
        }

        public final boolean O0000OoO() {
            return (this.aA & 512) == 512;
        }

        public final boolean O0000Ooo() {
            return (this.aA & 1024) == 1024;
        }

        public final boolean O0000o() {
            return (this.aA & 32768) == 32768;
        }

        public final boolean O0000o0() {
            return (this.aA & 4096) == 4096;
        }

        public final boolean O0000o00() {
            return (this.aA & 2048) == 2048;
        }

        public final boolean O0000o0O() {
            return (this.aA & 8192) == 8192;
        }

        public final boolean O0000o0o() {
            return (this.aA & 16384) == 16384;
        }

        public final boolean O0000oO() {
            return (this.aA & 131072) == 131072;
        }

        public final boolean O0000oO0() {
            return (this.aA & 65536) == 65536;
        }

        public final boolean O0000oOO() {
            return (this.aA & 262144) == 262144;
        }

        public final boolean O0000oOo() {
            return (this.aA & 524288) == 524288;
        }

        public final Parser getParserForType() {
            return f6066O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.aA & 1) == 1 ? CodedOutputStream.computeBytesSize(1, O0000ooo()) + 0 : 0;
            if ((this.aA & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, O00oOooO());
            }
            if ((this.aA & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, O00oOooo());
            }
            if ((this.aA & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, O000O00o());
            }
            if ((this.aA & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.bU);
            }
            if ((this.aA & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.bV);
            }
            if ((this.aA & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.bW);
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, O000O0OO());
            }
            for (int i2 = 0; i2 < this.bY.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(9, (MessageLite) this.bY.get(i2));
            }
            if ((this.aA & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(10, O000O0Oo());
            }
            if ((this.aA & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeBytesSize(11, O00oOoOo());
            }
            if ((this.aA & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeBytesSize(12, O000O0o0());
            }
            if ((this.aA & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeBytesSize(13, O000O0o());
            }
            if ((this.aA & 4096) == 4096) {
                computeBytesSize += CodedOutputStream.computeBytesSize(14, O000O0oO());
            }
            if ((this.aA & 8192) == 8192) {
                computeBytesSize += CodedOutputStream.computeInt32Size(15, this.aI);
            }
            if ((this.aA & 16384) == 16384) {
                computeBytesSize += CodedOutputStream.computeBytesSize(16, O000O0oo());
            }
            if ((this.aA & 32768) == 32768) {
                computeBytesSize += CodedOutputStream.computeBytesSize(17, O000OO00());
            }
            if ((this.aA & 65536) == 65536) {
                computeBytesSize += CodedOutputStream.computeBytesSize(18, O000OO0o());
            }
            if ((this.aA & 131072) == 131072) {
                computeBytesSize += CodedOutputStream.computeBytesSize(19, O000OO());
            }
            if ((this.aA & 262144) == 262144) {
                computeBytesSize += CodedOutputStream.computeBytesSize(20, O000OOOo());
            }
            if ((this.aA & 524288) == 524288) {
                computeBytesSize += CodedOutputStream.computeBytesSize(21, O000OOo0());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O00000oo.ensureFieldAccessorsInitialized(Page.class, edh.class);
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O0000ooo());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O00oOooO());
            }
            if ((this.aA & 4) == 4) {
                codedOutputStream.writeBytes(3, O00oOooo());
            }
            if ((this.aA & 8) == 8) {
                codedOutputStream.writeBytes(4, O000O00o());
            }
            if ((this.aA & 16) == 16) {
                codedOutputStream.writeInt64(5, this.bU);
            }
            if ((this.aA & 32) == 32) {
                codedOutputStream.writeInt64(6, this.bV);
            }
            if ((this.aA & 64) == 64) {
                codedOutputStream.writeInt64(7, this.bW);
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                codedOutputStream.writeBytes(8, O000O0OO());
            }
            for (int i = 0; i < this.bY.size(); i++) {
                codedOutputStream.writeMessage(9, (MessageLite) this.bY.get(i));
            }
            if ((this.aA & 256) == 256) {
                codedOutputStream.writeBytes(10, O000O0Oo());
            }
            if ((this.aA & 512) == 512) {
                codedOutputStream.writeBytes(11, O00oOoOo());
            }
            if ((this.aA & 1024) == 1024) {
                codedOutputStream.writeBytes(12, O000O0o0());
            }
            if ((this.aA & 2048) == 2048) {
                codedOutputStream.writeBytes(13, O000O0o());
            }
            if ((this.aA & 4096) == 4096) {
                codedOutputStream.writeBytes(14, O000O0oO());
            }
            if ((this.aA & 8192) == 8192) {
                codedOutputStream.writeInt32(15, this.aI);
            }
            if ((this.aA & 16384) == 16384) {
                codedOutputStream.writeBytes(16, O000O0oo());
            }
            if ((this.aA & 32768) == 32768) {
                codedOutputStream.writeBytes(17, O000OO00());
            }
            if ((this.aA & 65536) == 65536) {
                codedOutputStream.writeBytes(18, O000OO0o());
            }
            if ((this.aA & 131072) == 131072) {
                codedOutputStream.writeBytes(19, O000OO());
            }
            if ((this.aA & 262144) == 262144) {
                codedOutputStream.writeBytes(20, O000OOOo());
            }
            if ((this.aA & 524288) == 524288) {
                codedOutputStream.writeBytes(21, O000OOo0());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            }
            for (int i = 0; i < this.bY.size(); i++) {
                if (!((ProtoMap) this.bY.get(i)).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000OOoO */
        public edh toBuilder() {
            return edh.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edh(builderParent, (byte) 0);
        }
    }

    public final class PageMsg extends GeneratedMessage implements edj {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6067O000000o = new eeh();
        private static final PageMsg O00000Oo;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public List cb;

        private PageMsg() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        public /* synthetic */ PageMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private PageMsg(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ PageMsg(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static PageMsg O000000o() {
            return O00000Oo;
        }

        public static PageMsg O000000o(byte[] bArr) {
            return (PageMsg) f6067O000000o.parseFrom(bArr);
        }

        public static edi O00000o0() {
            return edi.O00000Oo();
        }

        public final Page O000000o(int i) {
            return (Page) this.cb.get(i);
        }

        public final int O00000Oo() {
            return this.cb.size();
        }

        public final Parser getParserForType() {
            return f6067O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.cb.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.cb.get(i3));
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000OOo.ensureFieldAccessorsInitialized(PageMsg.class, edi.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < O00000Oo(); i++) {
                if (!O000000o(i).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.cb.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.cb.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private PageMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            this.cb = Collections.emptyList();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.cb = new ArrayList();
                                z2 |= true;
                            }
                            this.cb.add(codedInputStream.readMessage(Page.f6066O000000o, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.cb = Collections.unmodifiableList(this.cb);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.cb = Collections.unmodifiableList(this.cb);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public edi toBuilder() {
            return edi.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edi(builderParent, (byte) 0);
        }

        static {
            PageMsg pageMsg = new PageMsg();
            O00000Oo = pageMsg;
            pageMsg.cb = Collections.emptyList();
        }
    }

    public final class ProtoError extends GeneratedMessage implements edm {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6068O000000o = new eei();
        private static final ProtoError O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        /* access modifiers changed from: private */
        public Object aC;
        /* access modifiers changed from: private */
        public Object aD;
        /* access modifiers changed from: private */
        public Object aE;
        /* access modifiers changed from: private */
        public Object aF;
        /* access modifiers changed from: private */
        public Object aG;
        /* access modifiers changed from: private */
        public Object aH;
        public int aI;
        /* access modifiers changed from: private */
        public Object aJ;
        /* access modifiers changed from: private */
        public Object aM;
        /* access modifiers changed from: private */
        public Object aP;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        public long bb;
        /* access modifiers changed from: private */
        public Object bh;
        /* access modifiers changed from: private */
        public Object bj;
        /* access modifiers changed from: private */
        public Object ce;
        /* access modifiers changed from: private */
        public Object cf;
        /* access modifiers changed from: private */
        public Object cg;
        /* access modifiers changed from: private */
        public Object ch;
        /* access modifiers changed from: private */
        public Object ci;
        /* access modifiers changed from: private */
        public Object cj;
        /* access modifiers changed from: private */
        public List ck;

        static {
            ProtoError protoError = new ProtoError();
            O00000Oo = protoError;
            protoError.O000OOo0();
        }

        private ProtoError() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private ProtoError(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O000OOo0();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.aC = readBytes;
                            continue;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.aD = readBytes2;
                            continue;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.aA |= 4;
                            this.aE = readBytes3;
                            continue;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.aA |= 8;
                            this.aF = readBytes4;
                            continue;
                        case 42:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.aA |= 16;
                            this.ce = readBytes5;
                            continue;
                        case 48:
                            this.aA |= 32;
                            this.bb = codedInputStream.readInt64();
                            continue;
                        case 58:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.aA |= 64;
                            this.aG = readBytes6;
                            continue;
                        case 66:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.aA |= NotificationCompat.FLAG_HIGH_PRIORITY;
                            this.cf = readBytes7;
                            continue;
                        case 74:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.aA |= 256;
                            this.cg = readBytes8;
                            continue;
                        case XiaomiOAuthConstants.VERSION_MINOR:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.aA |= 512;
                            this.ch = readBytes9;
                            continue;
                        case 90:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.aA |= 1024;
                            this.ci = readBytes10;
                            continue;
                        case 98:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.aA |= 2048;
                            this.cj = readBytes11;
                            continue;
                        case 106:
                            if (!(z2 & true)) {
                                this.ck = new ArrayList();
                                z2 |= true;
                            }
                            this.ck.add(codedInputStream.readMessage(ProtoMap.f6069O000000o, extensionRegistryLite));
                            continue;
                        case 112:
                            this.aA |= 4096;
                            this.aI = codedInputStream.readInt32();
                            continue;
                        case 122:
                            ByteString readBytes12 = codedInputStream.readBytes();
                            this.aA |= 8192;
                            this.aJ = readBytes12;
                            continue;
                        case 130:
                            ByteString readBytes13 = codedInputStream.readBytes();
                            this.aA |= 16384;
                            this.aH = readBytes13;
                            continue;
                        case 138:
                            ByteString readBytes14 = codedInputStream.readBytes();
                            this.aA |= 32768;
                            this.aP = readBytes14;
                            continue;
                        case 146:
                            ByteString readBytes15 = codedInputStream.readBytes();
                            this.aA |= 65536;
                            this.aM = readBytes15;
                            continue;
                        case 154:
                            ByteString readBytes16 = codedInputStream.readBytes();
                            this.aA |= 131072;
                            this.bh = readBytes16;
                            continue;
                        case 162:
                            ByteString readBytes17 = codedInputStream.readBytes();
                            this.aA |= 262144;
                            this.bj = readBytes17;
                            continue;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                continue;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.ck = Collections.unmodifiableList(this.ck);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.ck = Collections.unmodifiableList(this.ck);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ ProtoError(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private ProtoError(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ ProtoError(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static ProtoError O000000o() {
            return O00000Oo;
        }

        private ByteString O0000oo() {
            Object obj = this.aC;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aC = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooO() {
            Object obj = this.aD;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aD = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooo() {
            Object obj = this.aE;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aE = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O00o() {
            Object obj = this.aG;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aG = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0OO() {
            Object obj = this.cf;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cf = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0Oo() {
            Object obj = this.cg;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cg = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0o() {
            Object obj = this.cj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cj = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0o0() {
            Object obj = this.ci;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ci = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0oO() {
            Object obj = this.aJ;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aJ = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000O0oo() {
            Object obj = this.aH;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aH = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO() {
            Object obj = this.bh;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bh = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO00() {
            Object obj = this.aP;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aP = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OO0o() {
            Object obj = this.aM;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aM = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O000OOOo() {
            Object obj = this.bj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bj = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O000OOo0() {
            this.aC = "";
            this.aD = "";
            this.aE = "";
            this.aF = "";
            this.ce = "";
            this.bb = 0;
            this.aG = "";
            this.cf = "";
            this.cg = "";
            this.ch = "";
            this.ci = "";
            this.cj = "";
            this.ck = Collections.emptyList();
            this.aI = 0;
            this.aJ = "";
            this.aH = "";
            this.aP = "";
            this.aM = "";
            this.bh = "";
            this.bj = "";
        }

        private ByteString O00oOoOo() {
            Object obj = this.ch;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ch = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooO() {
            Object obj = this.aF;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aF = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooo() {
            Object obj = this.ce;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ce = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o() {
            return (this.aA & 4) == 4;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final boolean O00000oO() {
            return (this.aA & 8) == 8;
        }

        public final boolean O00000oo() {
            return (this.aA & 16) == 16;
        }

        public final boolean O0000O0o() {
            return (this.aA & 32) == 32;
        }

        public final boolean O0000OOo() {
            return (this.aA & 64) == 64;
        }

        public final boolean O0000Oo() {
            return (this.aA & 256) == 256;
        }

        public final boolean O0000Oo0() {
            return (this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
        }

        public final boolean O0000OoO() {
            return (this.aA & 512) == 512;
        }

        public final boolean O0000Ooo() {
            return (this.aA & 1024) == 1024;
        }

        public final boolean O0000o() {
            return (this.aA & 32768) == 32768;
        }

        public final boolean O0000o0() {
            return (this.aA & 4096) == 4096;
        }

        public final boolean O0000o00() {
            return (this.aA & 2048) == 2048;
        }

        public final boolean O0000o0O() {
            return (this.aA & 8192) == 8192;
        }

        public final boolean O0000o0o() {
            return (this.aA & 16384) == 16384;
        }

        public final boolean O0000oO() {
            return (this.aA & 131072) == 131072;
        }

        public final boolean O0000oO0() {
            return (this.aA & 65536) == 65536;
        }

        public final boolean O0000oOO() {
            return (this.aA & 262144) == 262144;
        }

        public final Parser getParserForType() {
            return f6068O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.aA & 1) == 1 ? CodedOutputStream.computeBytesSize(1, O0000oo()) + 0 : 0;
            if ((this.aA & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, O0000ooO());
            }
            if ((this.aA & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, O0000ooo());
            }
            if ((this.aA & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, O00oOooO());
            }
            if ((this.aA & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeBytesSize(5, O00oOooo());
            }
            if ((this.aA & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.bb);
            }
            if ((this.aA & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeBytesSize(7, O000O00o());
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, O000O0OO());
            }
            if ((this.aA & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(9, O000O0Oo());
            }
            if ((this.aA & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeBytesSize(10, O00oOoOo());
            }
            if ((this.aA & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeBytesSize(11, O000O0o0());
            }
            if ((this.aA & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeBytesSize(12, O000O0o());
            }
            for (int i2 = 0; i2 < this.ck.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(13, (MessageLite) this.ck.get(i2));
            }
            if ((this.aA & 4096) == 4096) {
                computeBytesSize += CodedOutputStream.computeInt32Size(14, this.aI);
            }
            if ((this.aA & 8192) == 8192) {
                computeBytesSize += CodedOutputStream.computeBytesSize(15, O000O0oO());
            }
            if ((this.aA & 16384) == 16384) {
                computeBytesSize += CodedOutputStream.computeBytesSize(16, O000O0oo());
            }
            if ((this.aA & 32768) == 32768) {
                computeBytesSize += CodedOutputStream.computeBytesSize(17, O000OO00());
            }
            if ((this.aA & 65536) == 65536) {
                computeBytesSize += CodedOutputStream.computeBytesSize(18, O000OO0o());
            }
            if ((this.aA & 131072) == 131072) {
                computeBytesSize += CodedOutputStream.computeBytesSize(19, O000OO());
            }
            if ((this.aA & 262144) == 262144) {
                computeBytesSize += CodedOutputStream.computeBytesSize(20, O000OOOo());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O0000oOO.ensureFieldAccessorsInitialized(ProtoError.class, edl.class);
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O0000oo());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O0000ooO());
            }
            if ((this.aA & 4) == 4) {
                codedOutputStream.writeBytes(3, O0000ooo());
            }
            if ((this.aA & 8) == 8) {
                codedOutputStream.writeBytes(4, O00oOooO());
            }
            if ((this.aA & 16) == 16) {
                codedOutputStream.writeBytes(5, O00oOooo());
            }
            if ((this.aA & 32) == 32) {
                codedOutputStream.writeInt64(6, this.bb);
            }
            if ((this.aA & 64) == 64) {
                codedOutputStream.writeBytes(7, O000O00o());
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                codedOutputStream.writeBytes(8, O000O0OO());
            }
            if ((this.aA & 256) == 256) {
                codedOutputStream.writeBytes(9, O000O0Oo());
            }
            if ((this.aA & 512) == 512) {
                codedOutputStream.writeBytes(10, O00oOoOo());
            }
            if ((this.aA & 1024) == 1024) {
                codedOutputStream.writeBytes(11, O000O0o0());
            }
            if ((this.aA & 2048) == 2048) {
                codedOutputStream.writeBytes(12, O000O0o());
            }
            for (int i = 0; i < this.ck.size(); i++) {
                codedOutputStream.writeMessage(13, (MessageLite) this.ck.get(i));
            }
            if ((this.aA & 4096) == 4096) {
                codedOutputStream.writeInt32(14, this.aI);
            }
            if ((this.aA & 8192) == 8192) {
                codedOutputStream.writeBytes(15, O000O0oO());
            }
            if ((this.aA & 16384) == 16384) {
                codedOutputStream.writeBytes(16, O000O0oo());
            }
            if ((this.aA & 32768) == 32768) {
                codedOutputStream.writeBytes(17, O000OO00());
            }
            if ((this.aA & 65536) == 65536) {
                codedOutputStream.writeBytes(18, O000OO0o());
            }
            if ((this.aA & 131072) == 131072) {
                codedOutputStream.writeBytes(19, O000OO());
            }
            if ((this.aA & 262144) == 262144) {
                codedOutputStream.writeBytes(20, O000OOOo());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            }
            for (int i = 0; i < this.ck.size(); i++) {
                if (!((ProtoMap) this.ck.get(i)).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000OOo */
        public edl toBuilder() {
            return edl.O000000o().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edl(builderParent, (byte) 0);
        }
    }

    public final class View extends GeneratedMessage implements eds {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6071O000000o = new eek();
        private static final View O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        /* access modifiers changed from: private */
        public Object aC;
        /* access modifiers changed from: private */
        public Object aD;
        /* access modifiers changed from: private */
        public Object aE;
        /* access modifiers changed from: private */
        public Object aF;
        /* access modifiers changed from: private */
        public Object aG;
        /* access modifiers changed from: private */
        public Object aH;
        /* access modifiers changed from: private */
        public Object aM;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public Object bK;
        public long bb;
        /* access modifiers changed from: private */
        public Object bh;
        /* access modifiers changed from: private */
        public Object bj;
        /* access modifiers changed from: private */
        public Object cw;
        /* access modifiers changed from: private */
        public List cx;

        static {
            View view = new View();
            O00000Oo = view;
            view.O00oOooo();
        }

        private View() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private View(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O00oOooo();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.aC = readBytes;
                            continue;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.aF = readBytes2;
                            continue;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.aA |= 4;
                            this.aH = readBytes3;
                            continue;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.aA |= 8;
                            this.aG = readBytes4;
                            continue;
                        case 40:
                            this.aA |= 16;
                            this.bb = codedInputStream.readInt64();
                            continue;
                        case 50:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.aA |= 32;
                            this.cw = readBytes5;
                            continue;
                        case 58:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.aA |= 64;
                            this.bK = readBytes6;
                            continue;
                        case 66:
                            if (!(z2 & true)) {
                                this.cx = new ArrayList();
                                z2 |= true;
                            }
                            this.cx.add(codedInputStream.readMessage(ProtoMap.f6069O000000o, extensionRegistryLite));
                            continue;
                        case 74:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.aA |= NotificationCompat.FLAG_HIGH_PRIORITY;
                            this.aM = readBytes7;
                            continue;
                        case XiaomiOAuthConstants.VERSION_MINOR:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.aA |= 256;
                            this.aD = readBytes8;
                            continue;
                        case 90:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.aA |= 512;
                            this.aE = readBytes9;
                            continue;
                        case 98:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.aA |= 1024;
                            this.bh = readBytes10;
                            continue;
                        case 106:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.aA |= 2048;
                            this.bj = readBytes11;
                            continue;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                continue;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.cx = Collections.unmodifiableList(this.cx);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.cx = Collections.unmodifiableList(this.cx);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ View(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private View(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ View(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static View O000000o() {
            return O00000Oo;
        }

        private ByteString O0000o() {
            Object obj = this.aF;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aF = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000o0o() {
            Object obj = this.aC;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aC = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oO() {
            Object obj = this.aG;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aG = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oO0() {
            Object obj = this.aH;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aH = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oOO() {
            Object obj = this.cw;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cw = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oOo() {
            Object obj = this.bK;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bK = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oo() {
            Object obj = this.aD;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aD = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000oo0() {
            Object obj = this.aM;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aM = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooO() {
            Object obj = this.aE;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aE = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000ooo() {
            Object obj = this.bh;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bh = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O00oOooO() {
            Object obj = this.bj;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bj = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O00oOooo() {
            this.aC = "";
            this.aF = "";
            this.aH = "";
            this.aG = "";
            this.bb = 0;
            this.cw = "";
            this.bK = "";
            this.cx = Collections.emptyList();
            this.aM = "";
            this.aD = "";
            this.aE = "";
            this.bh = "";
            this.bj = "";
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o() {
            return (this.aA & 4) == 4;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final boolean O00000oO() {
            return (this.aA & 8) == 8;
        }

        public final boolean O00000oo() {
            return (this.aA & 16) == 16;
        }

        public final boolean O0000O0o() {
            return (this.aA & 32) == 32;
        }

        public final boolean O0000OOo() {
            return (this.aA & 64) == 64;
        }

        public final boolean O0000Oo() {
            return (this.aA & 256) == 256;
        }

        public final boolean O0000Oo0() {
            return (this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
        }

        public final boolean O0000OoO() {
            return (this.aA & 512) == 512;
        }

        public final boolean O0000Ooo() {
            return (this.aA & 1024) == 1024;
        }

        public final boolean O0000o00() {
            return (this.aA & 2048) == 2048;
        }

        public final Parser getParserForType() {
            return f6071O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.aA & 1) == 1 ? CodedOutputStream.computeBytesSize(1, O0000o0o()) + 0 : 0;
            if ((this.aA & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, O0000o());
            }
            if ((this.aA & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, O0000oO0());
            }
            if ((this.aA & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, O0000oO());
            }
            if ((this.aA & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.bb);
            }
            if ((this.aA & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, O0000oOO());
            }
            if ((this.aA & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeBytesSize(7, O0000oOo());
            }
            for (int i2 = 0; i2 < this.cx.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(8, (MessageLite) this.cx.get(i2));
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(9, O0000oo0());
            }
            if ((this.aA & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(10, O0000oo());
            }
            if ((this.aA & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeBytesSize(11, O0000ooO());
            }
            if ((this.aA & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeBytesSize(12, O0000ooo());
            }
            if ((this.aA & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeBytesSize(13, O00oOooO());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O000O00o.ensureFieldAccessorsInitialized(View.class, edp.class);
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O0000o0o());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O0000o());
            }
            if ((this.aA & 4) == 4) {
                codedOutputStream.writeBytes(3, O0000oO0());
            }
            if ((this.aA & 8) == 8) {
                codedOutputStream.writeBytes(4, O0000oO());
            }
            if ((this.aA & 16) == 16) {
                codedOutputStream.writeInt64(5, this.bb);
            }
            if ((this.aA & 32) == 32) {
                codedOutputStream.writeBytes(6, O0000oOO());
            }
            if ((this.aA & 64) == 64) {
                codedOutputStream.writeBytes(7, O0000oOo());
            }
            for (int i = 0; i < this.cx.size(); i++) {
                codedOutputStream.writeMessage(8, (MessageLite) this.cx.get(i));
            }
            if ((this.aA & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                codedOutputStream.writeBytes(9, O0000oo0());
            }
            if ((this.aA & 256) == 256) {
                codedOutputStream.writeBytes(10, O0000oo());
            }
            if ((this.aA & 512) == 512) {
                codedOutputStream.writeBytes(11, O0000ooO());
            }
            if ((this.aA & 1024) == 1024) {
                codedOutputStream.writeBytes(12, O0000ooo());
            }
            if ((this.aA & 2048) == 2048) {
                codedOutputStream.writeBytes(13, O00oOooO());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            }
            for (int i = 0; i < this.cx.size(); i++) {
                if (!((ProtoMap) this.cx.get(i)).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000O00o */
        public edp toBuilder() {
            return edp.O000000o().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edp(builderParent, (byte) 0);
        }
    }

    public final class ViewMsg extends GeneratedMessage implements edr {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6072O000000o = new eel();
        private static final ViewMsg O00000Oo;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public List cA;

        private ViewMsg() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        public /* synthetic */ ViewMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private ViewMsg(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ ViewMsg(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static ViewMsg O000000o() {
            return O00000Oo;
        }

        public static ViewMsg O000000o(byte[] bArr) {
            return (ViewMsg) f6072O000000o.parseFrom(bArr);
        }

        public static edq O00000o0() {
            return edq.O00000Oo();
        }

        public final View O000000o(int i) {
            return (View) this.cA.get(i);
        }

        public final int O00000Oo() {
            return this.cA.size();
        }

        public final Parser getParserForType() {
            return f6072O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.cA.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.cA.get(i3));
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O000O0Oo.ensureFieldAccessorsInitialized(ViewMsg.class, edq.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < O00000Oo(); i++) {
                if (!O000000o(i).isInitialized()) {
                    this.ax = 0;
                    return false;
                }
            }
            this.ax = 1;
            return true;
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.cA.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.cA.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private ViewMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            this.cA = Collections.emptyList();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.cA = new ArrayList();
                                z2 |= true;
                            }
                            this.cA.add(codedInputStream.readMessage(View.f6071O000000o, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.cA = Collections.unmodifiableList(this.cA);
                    }
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.cA = Collections.unmodifiableList(this.cA);
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public edq toBuilder() {
            return edq.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edq(builderParent, (byte) 0);
        }

        static {
            ViewMsg viewMsg = new ViewMsg();
            O00000Oo = viewMsg;
            viewMsg.cA = Collections.emptyList();
        }
    }

    public final class ProtoMap extends GeneratedMessage implements edo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Parser f6069O000000o = new eej();
        private static final ProtoMap O00000Oo;
        /* access modifiers changed from: private */
        public int aA;
        private final UnknownFieldSet aw;
        private byte ax;
        private int ay;
        /* access modifiers changed from: private */
        public Object bg;
        /* access modifiers changed from: private */

        /* renamed from: cn  reason: collision with root package name */
        public Object f6070cn;

        static {
            ProtoMap protoMap = new ProtoMap();
            O00000Oo = protoMap;
            protoMap.O0000OOo();
        }

        private ProtoMap() {
            this.ax = -1;
            this.ay = -1;
            this.aw = UnknownFieldSet.getDefaultInstance();
        }

        private ProtoMap(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.ax = -1;
            this.ay = -1;
            O0000OOo();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            ByteString readBytes = codedInputStream.readBytes();
                            this.aA |= 1;
                            this.bg = readBytes;
                        } else if (readTag == 18) {
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.aA |= 2;
                            this.f6070cn = readBytes2;
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.aw = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.aw = newBuilder.build();
            makeExtensionsImmutable();
        }

        public /* synthetic */ ProtoMap(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) {
            this(codedInputStream, extensionRegistryLite);
        }

        private ProtoMap(GeneratedMessage.Builder builder) {
            super(builder);
            this.ax = -1;
            this.ay = -1;
            this.aw = builder.getUnknownFields();
        }

        public /* synthetic */ ProtoMap(GeneratedMessage.Builder builder, byte b) {
            this(builder);
        }

        public static ProtoMap O000000o() {
            return O00000Oo;
        }

        public static edn O00000o() {
            return edn.O00000Oo();
        }

        private ByteString O00000oo() {
            Object obj = this.bg;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bg = copyFromUtf8;
            return copyFromUtf8;
        }

        private ByteString O0000O0o() {
            Object obj = this.f6070cn;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.f6070cn = copyFromUtf8;
            return copyFromUtf8;
        }

        private void O0000OOo() {
            this.bg = "";
            this.f6070cn = "";
        }

        public final boolean O00000Oo() {
            return (this.aA & 1) == 1;
        }

        public final boolean O00000o0() {
            return (this.aA & 2) == 2;
        }

        public final Parser getParserForType() {
            return f6069O000000o;
        }

        public final int getSerializedSize() {
            int i = this.ay;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.aA & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeBytesSize(1, O00000oo());
            }
            if ((this.aA & 2) == 2) {
                i2 += CodedOutputStream.computeBytesSize(2, O0000O0o());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.ay = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.aw;
        }

        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ecr.O00000o.ensureFieldAccessorsInitialized(ProtoMap.class, edn.class);
        }

        public final boolean isInitialized() {
            byte b = this.ax;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!O00000Oo()) {
                this.ax = 0;
                return false;
            } else if (!O00000o0()) {
                this.ax = 0;
                return false;
            } else {
                this.ax = 1;
                return true;
            }
        }

        public final Object writeReplace() {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.aA & 1) == 1) {
                codedOutputStream.writeBytes(1, O00000oo());
            }
            if ((this.aA & 2) == 2) {
                codedOutputStream.writeBytes(2, O0000O0o());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        /* access modifiers changed from: private */
        /* renamed from: O0000Oo0 */
        public edn toBuilder() {
            return edn.O00000Oo().O000000o(this);
        }

        public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new edn(builderParent, (byte) 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ecs toBuilder() {
        return ecs.O000000o().O000000o(this);
    }

    public final /* synthetic */ Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
        return new ecs(builderParent, (byte) 0);
    }
}
