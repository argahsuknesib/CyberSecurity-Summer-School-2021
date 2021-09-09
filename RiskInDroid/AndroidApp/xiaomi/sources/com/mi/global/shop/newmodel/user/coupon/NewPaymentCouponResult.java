package com.mi.global.shop.newmodel.user.coupon;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPaymentCouponResult extends BaseResult {
    @SerializedName("data")
    public PaymentsData data;

    public static NewPaymentCouponResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPaymentCouponResult decode(ProtoReader protoReader) throws IOException {
        NewPaymentCouponResult newPaymentCouponResult = new NewPaymentCouponResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPaymentCouponResult;
            } else if (nextTag == 1) {
                newPaymentCouponResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newPaymentCouponResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPaymentCouponResult.data = PaymentsData.decode(protoReader);
            }
        }
    }

    public static class PaymentsData {
        @SerializedName("checkout")
        public Checkout checkout;
        @SerializedName("coupon")
        public Coupon coupon;
        @SerializedName("exchange_coupon")
        public ExchangeCoupon exchange_coupon;

        public static PaymentsData decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static PaymentsData decode(ProtoReader protoReader) throws IOException {
            PaymentsData paymentsData = new PaymentsData();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return paymentsData;
                } else if (nextTag == 3) {
                    paymentsData.checkout = Checkout.decode(protoReader);
                } else if (nextTag == 4) {
                    paymentsData.coupon = Coupon.decode(protoReader);
                } else if (nextTag != 5) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    paymentsData.exchange_coupon = ExchangeCoupon.decode(protoReader);
                }
            }
        }
    }

    public static class Checkout {
        @SerializedName("activityDiscountMoney")
        public String activityDiscountMoney;
        @SerializedName("amount")
        public String amount;
        @SerializedName("couponDiscountMoney")
        public String couponDiscountMoney;
        @SerializedName("exchange_coupon_amount")
        public String exchange_coupon_amount;
        @SerializedName("need_pay_amount")
        public String need_pay_amount;
        @SerializedName("productMoney")
        public String productMoney;
        @SerializedName("shipment")
        public String shipment;

        public static Checkout decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static Checkout decode(ProtoReader protoReader) throws IOException {
            Checkout checkout = new Checkout();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            checkout.productMoney = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 2:
                            checkout.activityDiscountMoney = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 3:
                            checkout.couponDiscountMoney = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 4:
                            checkout.shipment = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 5:
                            checkout.amount = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 6:
                            checkout.need_pay_amount = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 7:
                            checkout.exchange_coupon_amount = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        default:
                            protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return checkout;
                }
            }
        }
    }

    public static class Coupon {
        @SerializedName("postFree")
        public String postFree;
        @SerializedName("reason")
        public String reason;
        @SerializedName("replaceMoney")
        public String replaceMoney;
        @SerializedName("result")
        public String result;

        public static Coupon decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static Coupon decode(ProtoReader protoReader) throws IOException {
            Coupon coupon = new Coupon();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return coupon;
                } else if (nextTag == 1) {
                    coupon.result = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    coupon.reason = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    coupon.postFree = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 4) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    coupon.replaceMoney = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }

    public static class ExchangeCoupon {
        @SerializedName("allow")
        public int allow;
        @SerializedName("deny_reason")
        public String deny_reason;
        @SerializedName("ex_couponID")
        public String ex_couponID;

        public static ExchangeCoupon decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static ExchangeCoupon decode(ProtoReader protoReader) throws IOException {
            ExchangeCoupon exchangeCoupon = new ExchangeCoupon();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return exchangeCoupon;
                } else if (nextTag == 1) {
                    exchangeCoupon.allow = ProtoAdapter.INT32.decode(protoReader).intValue();
                } else if (nextTag == 2) {
                    exchangeCoupon.ex_couponID = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 3) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    exchangeCoupon.deny_reason = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
