package com.mobikwik.sdk.lib.model;

import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import java.io.Serializable;
import java.util.ArrayList;

public class PaymentsMappingAPIResponse {
    private SDKPaymentMappingBody data;
    public String description;
    public boolean failure;

    public static class PaymentsMapping implements Serializable {
        private String[] creditCardMappings;
        private String[] debitCardMappings;
        private GatewayUrl[] gatewayUrls;
        private ZaakPayPublicKey[] keyList;
        private MbkPublicKey mbkKey;
        private String[] memberIdList;
        private String[] netBankingMappings;

        public class GatewayUrl implements Serializable {
            private int id;
            private String url;

            public GatewayUrl(int i, String str) {
                this.id = i;
                this.url = str;
            }

            public int getId() {
                return this.id;
            }

            public String getUrl() {
                return this.url;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public static class MbkPublicKey implements Serializable {
            public String key;
            public String keyId;
        }

        public static class ZaakPayPublicKey implements Serializable {
            public String key;
            public String keyId;
            public String merchantId;
        }

        public PaymentsMapping(String[] strArr, String[] strArr2, String[] strArr3, GatewayUrl[] gatewayUrlArr, String[] strArr4) {
            this.netBankingMappings = strArr;
            this.creditCardMappings = strArr2;
            this.debitCardMappings = strArr3;
            this.gatewayUrls = gatewayUrlArr;
            this.memberIdList = strArr4;
        }

        public String[] getCreditCardMappings() {
            return this.creditCardMappings;
        }

        public String[] getDebitCardMappings() {
            return this.debitCardMappings;
        }

        public GatewayUrl[] getGatewayUrls() {
            return this.gatewayUrls;
        }

        public MbkPublicKey getMbkKey() {
            return this.mbkKey;
        }

        public String[] getMemberIdList() {
            return this.memberIdList;
        }

        public String[] getNetBankingMappings() {
            return this.netBankingMappings;
        }

        public ZaakPayPublicKey[] getPublicKeyList() {
            return this.keyList;
        }

        public void setCreditCardMappings(String[] strArr) {
            this.creditCardMappings = strArr;
        }

        public void setDebitCardMappings(String[] strArr) {
            this.debitCardMappings = strArr;
        }

        public void setGatewayUrls(GatewayUrl[] gatewayUrlArr) {
            this.gatewayUrls = gatewayUrlArr;
        }

        public void setMemberIdList(String[] strArr) {
            this.memberIdList = strArr;
        }

        public void setNetBankingMappings(String[] strArr) {
            this.netBankingMappings = strArr;
        }

        public void setPublicKeyList(ZaakPayPublicKey[] zaakPayPublicKeyArr) {
            this.keyList = zaakPayPublicKeyArr;
        }
    }

    public class SDKPaymentMappingBody implements Serializable {
        PaymentsMapping bankMappingMerchant;
        PaymentsMapping bankMappingMobikwik;
        String enabledOptions;

        public SDKPaymentMappingBody() {
        }

        public PaymentsMapping getBankMappingMerchant() {
            return this.bankMappingMerchant;
        }

        public PaymentsMapping getBankMappingMobikwik() {
            return this.bankMappingMobikwik;
        }

        public ArrayList getEnabledOptions() {
            if (this.enabledOptions == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.enabledOptions.contains("cc")) {
                arrayList.add(PaymentInstrumentType.CREDIT_CARD);
            }
            if (this.enabledOptions.contains("dc")) {
                arrayList.add(PaymentInstrumentType.DEBIT_CARD);
            }
            if (this.enabledOptions.contains("sc")) {
                arrayList.add(PaymentInstrumentType.SAVED_CARD);
            }
            if (this.enabledOptions.contains("nb")) {
                arrayList.add(PaymentInstrumentType.NETBANKING);
            }
            if (this.enabledOptions.contains("mw")) {
                arrayList.add(PaymentInstrumentType.MK_WALLET);
            }
            return arrayList;
        }
    }

    public SDKPaymentMappingBody getData() {
        return this.data;
    }
}
