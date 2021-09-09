package com.mi.global.shop.newmodel.domain;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DomainModel extends BaseResult {
    @SerializedName("cookieDomain")
    public String cookieDomain;
    @SerializedName("dns")
    public ArrayList<DomainHttpDnsModel> domainDnsModels = new ArrayList<>();
    @SerializedName("launchTime")
    public long launchTime;
    @SerializedName("local")
    public String local;
    @SerializedName("sid")
    public String sid;

    public static DomainModel decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static DomainModel decode(ProtoReader protoReader) throws IOException {
        DomainModel domainModel = new DomainModel();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return domainModel;
            } else if (nextTag == 1) {
                domainModel.local = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                domainModel.sid = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                domainModel.domainDnsModels.add(DomainHttpDnsModel.decode(protoReader));
            } else if (nextTag == 4) {
                domainModel.cookieDomain = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                domainModel.launchTime = ProtoAdapter.INT64.decode(protoReader).longValue();
            }
        }
    }

    public String replaceMatchedDomain(String str) {
        Iterator<DomainHttpDnsModel> it = this.domainDnsModels.iterator();
        while (it.hasNext()) {
            DomainHttpDnsModel next = it.next();
            if (str.contains(next.oldHostname)) {
                return str.replaceFirst(next.oldHostname, next.hostname);
            }
        }
        return "";
    }
}
