package com.xiaomi.mico.api.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.PaymentWebActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Payment {

    public static class Order {
        public List<OrderInfo> list;
        public long nextIndex;
    }

    public static class OrderInfo {
        public String action;
        public long createTime;
        public long finishTime;
        public String orderId;
        public String origin;
        public long payTime;
        public String pictureUrl;
        public String productId;
        public String productName;
        public String status;
        public String type;
        public String userId;
    }

    public static class PriceItem {
        public String contractDesc;
        public String origin;
        private long originalSalePrice;
        public String paymentUrl;
        public String pictureUrl;
        public String productId;
        public String productName;
        private long salePrice;
        public boolean selected;
        public String shortName = "";
        public String subtitle;
        public boolean supportContract;
        public boolean timeLimitSale;
        public int validPeriod;

        public long getSalePrice() {
            return this.salePrice / 100;
        }

        public boolean showOriginSalePrice() {
            return this.originalSalePrice >= 0;
        }

        public long getOriginalSalePrice() {
            return this.originalSalePrice / 100;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
        public void startPaymentWebActivity(Context context) {
            Intent intent = new Intent(CommonApplication.getAppContext(), PaymentWebActivity.class);
            intent.putExtra("common_web_title", "");
            intent.putExtra("common_web_url", getPaymentUrl());
            intent.putExtra("fullscreen", false);
            intent.putExtra("type", 0);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }

        private String getPaymentUrl() {
            if (ContainerUtil.hasData(this.paymentUrl)) {
                return this.paymentUrl;
            }
            Uri.Builder appendQueryParameter = Uri.parse(ApiConstants.isPrevEnv() ? "https://preview-payment.mina.mi.com/payment/v2/index" : "https://payment.api.mina.mi.com/payment/index").buildUpon().appendQueryParameter("productName", this.productName).appendQueryParameter("pictureUrl", this.pictureUrl);
            StringBuilder sb = new StringBuilder();
            sb.append(this.salePrice);
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("totalFee", sb.toString()).appendQueryParameter("origin", this.origin).appendQueryParameter("productId", this.productId).appendQueryParameter("productCount", "1").appendQueryParameter("action", "").appendQueryParameter("operateMode", "0");
            if (ApiConstants.isPrevEnv()) {
                appendQueryParameter2.appendQueryParameter("environment", "1");
            }
            return appendQueryParameter2.build().toString();
        }
    }

    public static class MemberStatus {
        public String eightEndTime;
        public int eightFlag;
        public String eightStartTime;
        public String greenVipEndTime;
        public int greenVipFlag;
        public String greenVipStartTime;
        private String superGreenVipEndTime;
        public int superGreenVipFlag;
        public String superGreenVipStartTime;
        public String twelveEndTime;
        public int twelveFlag;
        public String twelveStartTime;

        public String getVipEndTime() {
            String str;
            if (this.eightFlag == 1 && !ContainerUtil.isEmpty(this.eightEndTime)) {
                str = this.eightEndTime;
            } else if (this.twelveFlag == 1 && !ContainerUtil.isEmpty(this.twelveEndTime)) {
                str = this.twelveEndTime;
            } else if (this.greenVipFlag != 1 || ContainerUtil.isEmpty(this.greenVipEndTime)) {
                str = (this.superGreenVipFlag != 1 || ContainerUtil.isEmpty(this.superGreenVipEndTime)) ? "" : this.superGreenVipEndTime;
            } else {
                str = this.greenVipEndTime;
            }
            return Payment.formatTime(str);
        }

        public boolean isVipOpened() {
            return this.eightFlag == 1 || this.twelveFlag == 1 || this.greenVipFlag == 1 || this.superGreenVipFlag == 1;
        }
    }

    public static String formatTime(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static class TransactionRecord {
        public ArrayList<TransactionRecordItem> billInfoList = new ArrayList<>();
        public long nextIndex;

        public boolean hasMoreData() {
            return this.nextIndex > 0;
        }
    }

    public static class TransactionRecordItem {
        public String action;
        public long aiCoin;
        public String feeType;
        public String orderId;
        public String pictureUrl;
        public String platform;
        public String productName;
        public long timeStamp;
        public long totalFee;
        public String type;

        public boolean isRecharge() {
            return ContainerUtil.hasData(this.type) && this.type.equals("recharge");
        }

        public boolean isBalanceIncrease() {
            if (ContainerUtil.hasData(this.type)) {
                return this.type.equals("recharge") || this.type.equals("refund");
            }
            return false;
        }

        public float getTotalFee() {
            return ((float) this.totalFee) / 100.0f;
        }
    }
}
