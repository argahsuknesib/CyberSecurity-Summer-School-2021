package com.mi.global.shop.newmodel.domain;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class DomainResult extends BaseResult {
    @SerializedName("data")
    public ArrayList<DomainModel> domainModels = new ArrayList<>();

    public static DomainResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static DomainResult decode(ProtoReader protoReader) throws IOException {
        DomainResult domainResult = new DomainResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return domainResult;
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                domainResult.domainModels.add(DomainModel.decode(protoReader));
            }
        }
    }
}
