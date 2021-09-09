package com.mi.global.shop.feature.search.newmodel;

import _m_j.byn;
import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchWordResult extends byn {
    @SerializedName("data")
    public SearchData data;

    public static SearchWordResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SearchWordResult decode(ProtoReader protoReader) throws IOException {
        SearchWordResult searchWordResult = new SearchWordResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return searchWordResult;
            } else if (nextTag == 1) {
                searchWordResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                searchWordResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                searchWordResult.data = SearchData.decode(protoReader);
            }
        }
    }

    public static class SearchData {
        public ArrayList<DataBean> item;
        public ArrayList<String> list;

        public static SearchData decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static SearchData decode(ProtoReader protoReader) throws IOException {
            SearchData searchData = new SearchData();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return searchData;
                } else if (nextTag == 2) {
                    searchData.item = new ArrayList<>();
                    searchData.item.add(DataBean.decode(protoReader));
                } else if (nextTag != 3) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    searchData.list = new ArrayList<>();
                    searchData.list.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }
    }

    public static class DataBean {
        public String image;
        public String name;
        public String price;
        public String price_before;
        public String tag;

        public static DataBean decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static DataBean decode(ProtoReader protoReader) throws IOException {
            DataBean dataBean = new DataBean();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return dataBean;
                } else if (nextTag == 1) {
                    dataBean.name = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    dataBean.tag = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    dataBean.image = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 4) {
                    dataBean.price = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 5) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    dataBean.price_before = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
