package com.mi.global.shop.newmodel.home;

import _m_j.ewr;
import _m_j.jax;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageConfigResult extends BaseResult {
    public DataBean data;

    public static HomePageConfigResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static HomePageConfigResult decode(ProtoReader protoReader) throws IOException {
        HomePageConfigResult homePageConfigResult = new HomePageConfigResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return homePageConfigResult;
            } else if (nextTag == 1) {
                homePageConfigResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                homePageConfigResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                homePageConfigResult.data = DataBean.decode(protoReader);
            }
        }
    }

    public static class DataBean {
        public String ext_page_data_str;
        public String extended;
        public ExtraScreen extraScreen;
        public List<ewr> page_data = new ArrayList();

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
                    dataBean.extended = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    dataBean.page_data.add(ewr.O000000o(protoReader));
                } else if (nextTag == 3) {
                    dataBean.ext_page_data_str = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 4) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    dataBean.extraScreen = ExtraScreen.decode(protoReader);
                }
            }
        }
    }
}
