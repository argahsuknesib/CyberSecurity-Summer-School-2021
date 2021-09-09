package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SmartBoxData implements Serializable {
    private static final long serialVersionUID = 3124916604139107833L;
    @SerializedName("defaultid")
    public String defaultid;
    @SerializedName("explain")
    public String explain;
    @SerializedName("hint")
    public String hint;
    @SerializedName("list")
    public ArrayList<SmartDetailItemData> smartDetailListData = new ArrayList<>();
    @SerializedName("title")
    public String title;

    public static SmartBoxData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SmartBoxData decode(ProtoReader protoReader) throws IOException {
        SmartBoxData smartBoxData = new SmartBoxData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return smartBoxData;
            } else if (nextTag == 1) {
                smartBoxData.hint = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                smartBoxData.explain = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                smartBoxData.smartDetailListData.add(SmartDetailItemData.decode(protoReader));
            } else if (nextTag == 4) {
                smartBoxData.defaultid = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                smartBoxData.title = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
