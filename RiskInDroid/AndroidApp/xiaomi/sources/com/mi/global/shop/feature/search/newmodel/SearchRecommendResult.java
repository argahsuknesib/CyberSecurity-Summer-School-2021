package com.mi.global.shop.feature.search.newmodel;

import _m_j.byn;
import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchRecommendResult extends byn {
    @SerializedName("data")
    public Data data = new Data();

    public static SearchRecommendResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SearchRecommendResult decode(ProtoReader protoReader) throws IOException {
        SearchRecommendResult searchRecommendResult = new SearchRecommendResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return searchRecommendResult;
            } else if (nextTag == 1) {
                searchRecommendResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                searchRecommendResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                searchRecommendResult.data = Data.decode(protoReader);
            }
        }
    }

    public static class Recommend {
        @SerializedName("link")
        public String link;
        @SerializedName("name")
        public String name;

        public static Recommend decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static Recommend decode(ProtoReader protoReader) throws IOException {
            Recommend recommend = new Recommend();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return recommend;
                } else if (nextTag == 1) {
                    recommend.name = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 2) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    recommend.link = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }

    public static class Data {
        @SerializedName("recommend")
        public ArrayList<Recommend> recommend = new ArrayList<>();

        public static Data decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static Data decode(ProtoReader protoReader) throws IOException {
            Data data = new Data();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return data;
                } else if (nextTag != 1) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    data.recommend.add(Recommend.decode(protoReader));
                }
            }
        }
    }
}
