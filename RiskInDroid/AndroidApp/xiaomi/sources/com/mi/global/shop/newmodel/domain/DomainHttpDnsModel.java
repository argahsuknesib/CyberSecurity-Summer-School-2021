package com.mi.global.shop.newmodel.domain;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class DomainHttpDnsModel {
    public boolean enable;
    public String hostname;
    public ArrayList<String> ips = new ArrayList<>();
    public String oldHostname;
    public long ttl;

    public static DomainHttpDnsModel decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static DomainHttpDnsModel decode(ProtoReader protoReader) throws IOException {
        DomainHttpDnsModel domainHttpDnsModel = new DomainHttpDnsModel();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return domainHttpDnsModel;
            } else if (nextTag == 1) {
                domainHttpDnsModel.hostname = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                domainHttpDnsModel.oldHostname = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                domainHttpDnsModel.ips.add(ProtoAdapter.STRING.decode(protoReader));
            } else if (nextTag == 4) {
                domainHttpDnsModel.ttl = ProtoAdapter.INT64.decode(protoReader).longValue();
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                domainHttpDnsModel.enable = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
