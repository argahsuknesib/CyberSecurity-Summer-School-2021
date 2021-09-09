package com.mi.global.shop.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.model.buy.OrderInfoData;
import com.mi.global.shop.model.buy.OrderItemsData;
import com.mi.global.shop.model.buy.PayInfoData;
import com.mi.global.shop.model.buy.SupportData;
import com.mi.global.shop.model.buy.onlinepayCouponInfoData;
import com.mi.global.shop.model.common.Emi;
import com.mi.global.shop.model.common.Netbank;
import com.mi.global.shop.model.common.PayList;
import com.mi.global.shop.model.common.PayParam;
import com.mi.global.shop.model.common.UserCardsType;
import com.mi.global.shop.model.common.Wallet;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyPayInfoMirror {
    String bankList;
    String mention;
    String mention_ext;
    Map<String, String> onlinepayCouponInfo;
    OrderInfoMirror orderInfo;
    PayListMirror payList;
    PayParamMirror payParam;
    String payParamString;
    SupportMirror support;

    public BuyPayInfoMirror(PayInfoData payInfoData) {
        this.mention = (String) Wire.get(payInfoData.mention, "");
        OrderInfoData orderInfoData = payInfoData.orderInfo;
        if (orderInfoData != null) {
            this.orderInfo = new OrderInfoMirror(orderInfoData);
        }
        PayList payList2 = payInfoData.payList;
        if (payList2 != null) {
            this.payList = new PayListMirror(payList2);
        }
        PayParam payParam2 = payInfoData.payParam;
        if (payParam2 != null) {
            this.payParam = new PayParamMirror(payParam2);
        }
        SupportData supportData = payInfoData.support;
        if (supportData != null) {
            this.support = new SupportMirror(supportData);
        }
        onlinepayCouponInfoData onlinepaycouponinfodata = payInfoData.onlinepayCouponInfo;
        if (onlinepaycouponinfodata != null) {
            this.onlinepayCouponInfo = new HashMap();
            this.onlinepayCouponInfo.put("0", Wire.get(onlinepaycouponinfodata.mention, ""));
        }
        this.payParamString = (String) Wire.get(payInfoData.payParamString, "");
        this.mention_ext = (String) Wire.get(payInfoData.mention_ext, "");
        this.bankList = (String) Wire.get(payInfoData.bank_list, "");
    }

    public String toString() {
        return new Gson().toJsonTree(this).getAsJsonObject().toString();
    }

    public static class OrderInfoMirror {
        String address;
        String consignee;
        String goods_amount;
        ArrayList<OrderItemMirror> orderItems;
        String order_id;
        String original_price;
        String reduce_price;
        String remaining_time;
        String shipment_expense;
        String tel;
        String zipcode;

        public OrderInfoMirror(OrderInfoData orderInfoData) {
            this.order_id = (String) Wire.get(orderInfoData.order_id, "");
            this.consignee = (String) Wire.get(orderInfoData.consignee, "");
            this.address = (String) Wire.get(orderInfoData.address, "");
            this.zipcode = (String) Wire.get(orderInfoData.zipcode, "");
            this.tel = (String) Wire.get(orderInfoData.tel, "");
            this.goods_amount = (String) Wire.get(orderInfoData.goods_amount, "");
            this.original_price = (String) Wire.get(orderInfoData.original_price, "");
            this.shipment_expense = (String) Wire.get(orderInfoData.shipment_expense, "");
            this.reduce_price = (String) Wire.get(orderInfoData.reduce_price, "");
            this.remaining_time = (String) Wire.get(orderInfoData.remaining_time, "");
            List<OrderItemsData> list = orderInfoData.orderItems;
            if (list != null) {
                this.orderItems = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    this.orderItems.add(new OrderItemMirror(list.get(i)));
                }
            }
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }

    public static class OrderItemMirror {
        String cart_price;
        String goods_id;
        String image_url;
        String price;
        String product_count;
        String product_id;
        String product_name;
        String subtotal;

        public OrderItemMirror(OrderItemsData orderItemsData) {
            this.product_id = (String) Wire.get(orderItemsData.product_id, "");
            this.goods_id = (String) Wire.get(orderItemsData.goods_id, "");
            this.product_name = (String) Wire.get(orderItemsData.product_name, "");
            this.image_url = (String) Wire.get(orderItemsData.image_url, "");
            this.product_count = (String) Wire.get(orderItemsData.product_count, "");
            this.cart_price = (String) Wire.get(orderItemsData.cart_price, "");
            this.price = (String) Wire.get(orderItemsData.price, "");
            this.subtotal = (String) Wire.get(orderItemsData.subtotal, "");
        }
    }

    public static class SupportMirror {
        int can_cod;
        int can_onlinepay;
        String cod_message;
        String codstatus;

        public SupportMirror(SupportData supportData) {
            this.can_cod = ((Integer) Wire.get(supportData.can_cod, SupportData.DEFAULT_CAN_COD)).intValue();
            this.can_onlinepay = ((Integer) Wire.get(supportData.can_onlinepay, SupportData.DEFAULT_CAN_ONLINEPAY)).intValue();
            this.codstatus = (String) Wire.get(supportData.codstatus, "");
            this.cod_message = (String) Wire.get(supportData.cod_message, "");
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }

    public static class PayParamMirror {
        String amount;
        String email;
        String enforce_paymethod;
        String firstname;
        String furl;
        String hash;
        String key;
        String pay_url;
        String phone;
        String productinfo;
        String sign;
        boolean supportStoreCards;
        String surl;
        String txnid;
        List<UserCardsTypeMirror> user_cards;
        String user_credentials;

        public PayParamMirror(PayParam payParam) {
            this.key = (String) Wire.get(payParam.key, "");
            this.txnid = (String) Wire.get(payParam.txnid, "");
            this.amount = (String) Wire.get(payParam.amount, "");
            this.productinfo = (String) Wire.get(payParam.productinfo, "");
            this.firstname = (String) Wire.get(payParam.firstname, "");
            this.email = (String) Wire.get(payParam.email, "");
            this.phone = (String) Wire.get(payParam.phone, "");
            this.surl = (String) Wire.get(payParam.surl, "");
            this.furl = (String) Wire.get(payParam.furl, "");
            this.enforce_paymethod = (String) Wire.get(payParam.enforce_paymethod, "");
            this.user_credentials = (String) Wire.get(payParam.user_credentials, "");
            this.pay_url = (String) Wire.get(payParam.pay_url, "");
            this.hash = (String) Wire.get(payParam.hash, "");
            if (payParam.user_cards != null) {
                this.user_cards = new ArrayList();
                List<UserCardsType> list = payParam.user_cards;
                for (int i = 0; i < list.size(); i++) {
                    this.user_cards.add(new UserCardsTypeMirror(list.get(i)));
                }
            }
            this.sign = (String) Wire.get(payParam.sign, "");
            this.supportStoreCards = ((Boolean) Wire.get(payParam.supportStoreCards, PayParam.DEFAULT_SUPPORTSTORECARDS)).booleanValue();
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }

    public static class UserCardsTypeMirror {
        String card_brand;
        String card_mode;
        String card_name;
        String card_no;
        String card_token;
        String card_type;
        String expiry_month;
        String expiry_year;
        String name_on_card;

        public UserCardsTypeMirror(UserCardsType userCardsType) {
            this.card_name = (String) Wire.get(userCardsType.card_name, "");
            this.card_type = (String) Wire.get(userCardsType.card_type, "");
            this.card_token = (String) Wire.get(userCardsType.card_token, "");
            this.expiry_year = (String) Wire.get(userCardsType.expiry_year, "");
            this.expiry_month = (String) Wire.get(userCardsType.expiry_month, "");
            this.name_on_card = (String) Wire.get(userCardsType.name_on_card, "");
            this.card_no = (String) Wire.get(userCardsType.card_no, "");
            this.card_mode = (String) Wire.get(userCardsType.card_mode, "");
            this.card_brand = (String) Wire.get(userCardsType.card_brand, "");
        }
    }

    public static class PayListMirror {
        List<String> cards;
        List<EmiMirror> emi;
        NetbankMirror netbank;
        WalletMirror wallet;

        public PayListMirror(PayList payList) {
            List<Emi> list = payList.emi;
            if (list != null) {
                this.emi = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    this.emi.add(new EmiMirror(list.get(i)));
                }
            }
            List<String> list2 = payList.cards;
            if (list2 != null) {
                this.cards = new ArrayList();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    this.cards.add(list2.get(i2));
                }
            }
            Netbank netbank2 = payList.netbank;
            if (netbank2 != null) {
                this.netbank = new NetbankMirror(netbank2);
            }
            Wallet wallet2 = payList.wallet;
            if (wallet2 != null) {
                this.wallet = new WalletMirror(wallet2);
            }
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }

    public static class EmiMirror {
        boolean enable;
        String img;
        String key;
        int min;
        String name;
        List<EmiRateMirror> rate;
        String tips;

        public EmiMirror(Emi emi) {
            this.min = ((Integer) Wire.get(emi.min, Emi.DEFAULT_MIN)).intValue();
            this.key = (String) Wire.get(emi.key, "");
            this.name = (String) Wire.get(emi.name, "");
            this.enable = ((Boolean) Wire.get(emi.enable, Emi.DEFAULT_ENABLE)).booleanValue();
            this.img = (String) Wire.get(emi.img, "");
            List<Emi.EmiRate> list = emi.rate;
            if (list != null) {
                this.rate = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    this.rate.add(new EmiRateMirror(list.get(i)));
                }
            }
            this.tips = (String) Wire.get(emi.tips, "");
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }

    public static class EmiRateMirror {
        String code;
        String desc;
        float interest;
        String interest_desc;
        String monthPay;
        int months;
        String tips;
        String totalInterest;

        public EmiRateMirror(Emi.EmiRate emiRate) {
            this.desc = (String) Wire.get(emiRate.desc, "");
            this.interest = ((Float) Wire.get(emiRate.interest, Emi.EmiRate.DEFAULT_INTEREST)).floatValue();
            this.code = (String) Wire.get(emiRate.code, "");
            this.months = ((Integer) Wire.get(emiRate.months, Emi.EmiRate.DEFAULT_MONTHS)).intValue();
            this.totalInterest = (String) Wire.get(emiRate.totalInterest, "");
            this.monthPay = (String) Wire.get(emiRate.monthPay, "");
            this.tips = (String) Wire.get(emiRate.tips, "");
            this.interest_desc = (String) Wire.get(emiRate.interest_desc, "");
        }
    }

    public static class NetbankMirror {
        Map<String, NetbankAllMirror> all;
        List<String> recommend;

        public NetbankMirror(Netbank netbank) {
            List<String> list = netbank.recommend;
            if (list != null) {
                this.recommend = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    this.recommend.add(list.get(i));
                }
            }
            this.all = (Map) new Gson().fromJson(netbank.all_json, new TypeToken<Map<String, NetbankAllMirror>>() {
                /* class com.mi.global.shop.model.BuyPayInfoMirror.NetbankMirror.AnonymousClass1 */
            }.getType());
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }

    class NetbankAllMirror {
        boolean enable;
        String img;
        String name;

        NetbankAllMirror() {
        }
    }

    public static class WalletMirror {
        String bank;
        String desc;
        boolean mbkValide;
        String mobikwik_desc;
        String mobikwik_img;
        String payu_img;

        public WalletMirror(Wallet wallet) {
            this.desc = (String) Wire.get(wallet.desc, "");
            this.bank = (String) Wire.get(wallet.bank, "");
            this.payu_img = (String) Wire.get(wallet.payu_img, "");
            this.mobikwik_img = (String) Wire.get(wallet.mobikwik_img, "");
            this.mobikwik_desc = (String) Wire.get(wallet.mobikwik_desc, "");
            this.mbkValide = ((Boolean) Wire.get(wallet.mbkValide, Wallet.DEFAULT_MBKVALIDE)).booleanValue();
        }

        public String toString() {
            return new Gson().toJsonTree(this).getAsJsonObject().toString();
        }
    }
}
