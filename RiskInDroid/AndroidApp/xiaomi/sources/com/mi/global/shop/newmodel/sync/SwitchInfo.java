package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class SwitchInfo {
    public boolean assembleTEZ = true;
    public boolean authorizedStoreSwitch;
    public boolean hardwareAccelerateModel = true;
    public boolean loyaltySwitch;
    public boolean usingGoMifileHostSwitch;

    public static SwitchInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SwitchInfo decode(ProtoReader protoReader) throws IOException {
        SwitchInfo switchInfo = new SwitchInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return switchInfo;
            } else if (nextTag == 1) {
                switchInfo.loyaltySwitch = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 2) {
                switchInfo.authorizedStoreSwitch = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 3) {
                switchInfo.usingGoMifileHostSwitch = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 4) {
                switchInfo.hardwareAccelerateModel = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                switchInfo.assembleTEZ = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
