package _m_j;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import com.xiaomi.mi_connect_service.proto.AttributeProto;

public final class dwu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f15008O000000o = {0};
    private static final byte[] O00000Oo = {0};

    public static byte[] O000000o(dwr dwr) {
        AttributeProto.AttrAdvData.Builder versionMinor = AttributeProto.AttrAdvData.newBuilder().addAppsData(ByteString.copyFrom(dwr.O000000o())).setDeviceType(15).setFlags(ByteString.copyFrom(f15008O000000o)).setIdHash(ByteString.copyFrom(O00000Oo)).setName("MI-NFCTAG").setSecurityMode(0).setWifiMac("").setVersionMajor(1).setVersionMinor(2);
        versionMinor.addAppIds(16378);
        AttributeProto.AttrOps.Builder newBuilder = AttributeProto.AttrOps.newBuilder();
        newBuilder.setAdvData(versionMinor.build());
        return newBuilder.build().toByteArray();
    }

    public static dwv O000000o(byte[] bArr) throws NfcTagDataCorruptException {
        try {
            AttributeProto.AttrOps parseFrom = AttributeProto.AttrOps.parseFrom(bArr);
            if (parseFrom.hasAdvData()) {
                return dwv.O000000o(parseFrom.getAdvData().getAppsData(0).toByteArray());
            }
            throw new NfcTagDataCorruptException("no adv data");
        } catch (InvalidProtocolBufferException e) {
            throw new NfcTagDataCorruptException(e.getMessage());
        } catch (RuntimeException e2) {
            throw new NfcTagDataCorruptException(e2.getMessage());
        }
    }
}
