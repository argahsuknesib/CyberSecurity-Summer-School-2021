package com.mobikwik.sdk.lib.utils;

import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import java.util.ArrayList;

public class PaymentOptionsDecoder {
    public static String getBankCodeForPaymentOption(String[] strArr, int i) {
        return strArr[i - 1].split("\\|")[0];
    }

    public static int getBankPositionForBankId(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i].split("\\|")[0])) {
                return i;
            }
        }
        return 0;
    }

    public static String getCCAVMerchantIdForAmount(String str, boolean z, PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping) {
        String[] memberIdList = paymentsMapping.getMemberIdList();
        int i = 0;
        if (z) {
            double parseDouble = Double.parseDouble(str);
            int length = memberIdList.length;
            while (i < length) {
                String str2 = memberIdList[i];
                if (str2.startsWith("CCAVE")) {
                    String[] split = str2.split(":");
                    int i2 = 5;
                    int i3 = 100000;
                    if (!split[1].equals("-")) {
                        i2 = Integer.parseInt(split[1]);
                    }
                    if (!split[2].equals("-")) {
                        i3 = Integer.parseInt(split[2]);
                    }
                    if (((double) i2) <= parseDouble && parseDouble <= ((double) i3)) {
                        return split[3];
                    }
                }
                i++;
            }
            return null;
        }
        String[] split2 = memberIdList[0].split("\\|");
        while (i < split2.length) {
            String[] split3 = split2[i].split(":");
            if (split2[i].toUpperCase().indexOf("CCAVE") != -1) {
                return split3[split3.length - 1];
            }
            i++;
        }
        return null;
    }

    public static int getIndexForBank(String[] strArr, String str) {
        int i = 0;
        while (i < strArr.length) {
            try {
                if (str.equalsIgnoreCase(strArr[i].split("\\|")[0].split(":")[1])) {
                    return i;
                }
                i++;
            } catch (Exception e) {
                Utils.print(" Exception ".concat(String.valueOf(e)));
                return -1;
            }
        }
        return -1;
    }

    public static String[] getNames(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String split : strArr) {
            arrayList.add(split.split("\\|")[1]);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String getPGUrlForId(PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping, int i) {
        for (PaymentsMappingAPIResponse.PaymentsMapping.GatewayUrl gatewayUrl : paymentsMapping.getGatewayUrls()) {
            if (i == gatewayUrl.getId()) {
                return gatewayUrl.getUrl();
            }
        }
        return null;
    }

    public static String getPGUrlForPaymentOption(PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping, String[] strArr, int i) {
        return getPGUrlForId(paymentsMapping, getPGUrlIdForPaymentOption(strArr, i));
    }

    private static int getPGUrlIdForPaymentOption(String[] strArr, int i) {
        return Integer.parseInt(strArr[i - 1].split("\\|")[2]);
    }

    public static PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey getZaakpayKeyForMerchantId(String str, PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping) {
        PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey[] publicKeyList = paymentsMapping.getPublicKeyList();
        for (PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey zaakPayPublicKey : publicKeyList) {
            if (str.equals(zaakPayPublicKey.merchantId)) {
                return zaakPayPublicKey;
            }
        }
        return null;
    }

    public static String getZaakpayMerchantIdForAmount(String str, boolean z, PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping) {
        String[] memberIdList = paymentsMapping.getMemberIdList();
        int i = 0;
        if (z) {
            double parseDouble = Double.parseDouble(str);
            int length = memberIdList.length;
            while (i < length) {
                String str2 = memberIdList[i];
                if (str2.startsWith("ZAAKPAY")) {
                    String[] split = str2.split(":");
                    int i2 = 5;
                    int i3 = 100000;
                    if (!split[1].equals("-")) {
                        i2 = Integer.parseInt(split[1]);
                    }
                    if (!split[2].equals("-")) {
                        i3 = Integer.parseInt(split[2]);
                    }
                    if (((double) i2) <= parseDouble && parseDouble <= ((double) i3)) {
                        return split[3];
                    }
                }
                i++;
            }
            return null;
        }
        String[] split2 = memberIdList[0].split("\\|");
        while (i < split2.length) {
            String[] split3 = split2[i].split(":");
            if (split2[i].toUpperCase().indexOf("ZAAKPAY") != -1) {
                return split3[split3.length - 1];
            }
            i++;
        }
        return null;
    }

    public static boolean isAllCardNonCCAvenue(String[] strArr) {
        for (String upperCase : strArr) {
            if (upperCase.toUpperCase().startsWith("CCAV")) {
                return false;
            }
        }
        return true;
    }
}
