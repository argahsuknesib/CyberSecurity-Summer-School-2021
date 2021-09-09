package com.mi.global.shop.feature.search.newmodel;

import _m_j.byn;
import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class SearchResult extends byn {
    @SerializedName("data")
    public Data data = new Data();

    public static SearchResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SearchResult decode(ProtoReader protoReader) throws IOException {
        SearchResult searchResult = new SearchResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return searchResult;
            } else if (nextTag == 1) {
                searchResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                searchResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                searchResult.data = Data.decode(protoReader);
            }
        }
    }

    public static class Data {
        public List<AllCategoriesBean> allCategories = new ArrayList();
        public DataProviderBean dataProvider;
        public String keyword;

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
                } else if (nextTag == 1) {
                    data.keyword = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    data.dataProvider = DataProviderBean.decode(protoReader);
                } else if (nextTag != 3) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    data.allCategories.add(AllCategoriesBean.decode(protoReader));
                }
            }
        }
    }

    public static class DataProviderBean {
        public List<AllAdapt> all_adapt = new ArrayList();
        public int all_is_cos;
        public String current_page;
        public List<DataBean> data = new ArrayList();
        public int total_count;
        public int total_pages;

        public static DataProviderBean decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static DataProviderBean decode(ProtoReader protoReader) throws IOException {
            DataProviderBean dataProviderBean = new DataProviderBean();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            dataProviderBean.total_count = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 2:
                            try {
                                dataProviderBean.current_page = ProtoAdapter.STRING.decode(protoReader);
                                break;
                            } catch (Exception unused) {
                                dataProviderBean.current_page = String.valueOf(ProtoAdapter.INT32.decode(protoReader));
                                break;
                            }
                        case 3:
                            dataProviderBean.total_pages = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 4:
                            dataProviderBean.all_is_cos = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 5:
                            dataProviderBean.data.add(DataBean.decode(protoReader));
                            break;
                        case 6:
                            dataProviderBean.all_adapt.add(AllAdapt.decode(protoReader));
                            break;
                        default:
                            protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return dataProviderBean;
                }
            }
        }
    }

    public static class AllAdapt {
        public String adapt_id;
        public String adapt_name;
        public boolean isChecked;

        public AllAdapt(String str, String str2) {
            this.adapt_id = str;
            this.adapt_name = str2;
        }

        public static AllAdapt decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static AllAdapt decode(ProtoReader protoReader) throws IOException {
            AllAdapt allAdapt = new AllAdapt("", "");
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return allAdapt;
                } else if (nextTag == 1) {
                    allAdapt.adapt_id = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 2) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    allAdapt.adapt_name = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }

    public static class DataBean {
        public List<CommodityDetailBean> commodity = new ArrayList();
        public ProductBean product;

        public static class ProductBean {
            public String id;
            public String is_sale;
            public String name;
        }

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
                } else if (nextTag != 3) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    dataBean.commodity.add(CommodityDetailBean.decode(protoReader));
                }
            }
        }
    }

    public static class CommodityDetailBean {
        public List<String> good_ids = new ArrayList();
        public int has_store;
        public String id;
        public String image;
        public String is_batched;
        public int is_sale;
        public String item_link;
        public String market_price_max;
        public String market_price_min;
        public String name;
        public String price_max;
        public String price_min;
        public String short_name;

        public static CommodityDetailBean decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static CommodityDetailBean decode(ProtoReader protoReader) throws IOException {
            CommodityDetailBean commodityDetailBean = new CommodityDetailBean();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            commodityDetailBean.id = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 2:
                            commodityDetailBean.name = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 3:
                            commodityDetailBean.short_name = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 4:
                            commodityDetailBean.is_batched = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 5:
                            commodityDetailBean.is_sale = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 6:
                            commodityDetailBean.has_store = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 7:
                            commodityDetailBean.image = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            commodityDetailBean.market_price_max = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 9:
                            commodityDetailBean.market_price_min = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 10:
                            commodityDetailBean.price_max = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 11:
                            commodityDetailBean.price_min = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            commodityDetailBean.good_ids.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            commodityDetailBean.item_link = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        default:
                            protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return commodityDetailBean;
                }
            }
        }
    }

    public static class AllCategoriesBean {
        public String cat_id;
        public String cat_name;
        public String is_highlight;
        public String parent_id;

        public AllCategoriesBean(String str, String str2) {
            this.cat_id = str;
            this.cat_name = str2;
        }

        public static AllCategoriesBean decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static AllCategoriesBean decode(ProtoReader protoReader) throws IOException {
            AllCategoriesBean allCategoriesBean = new AllCategoriesBean("", "");
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return allCategoriesBean;
                } else if (nextTag == 1) {
                    allCategoriesBean.cat_id = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    allCategoriesBean.cat_name = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    allCategoriesBean.parent_id = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 4) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    allCategoriesBean.is_highlight = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
