package com.mobikwik.sdk.lib;

public class Constants {
    public static String AMOUNTTOADD = "amountToAdd";
    public static int CALL_TO_OTPLOGIN = 1;
    public static String INSUFF_BALANCE_TITLE = "Insufficient balance";
    public static String JSON_RESPONSE_NET_FAILURE = "{\"body\":{\"amount\":\"0\",\"walletBalance\":\"0\",\"token\":\"\",\"email\":\"\",\"cell\":\"\",\"isNewUser\":\"\"},\"statuscode\":\"98\",\"statusmessage\":\"User Internet Not Working\"}";
    public static String MODE_LIVE = "1";
    public static String MODE_TEST = "0";
    public static String NETBANKING_CODE = "bankId";
    public static String PG_DATA_KEY = "postdata";
    public static String PG_RETURN_URL_KEY = "returnUrl";
    public static String PG_URL_KEY = "url";
    public static String SENDER_TO_WALLET = "senderToWallet";
    public static int SENDER_TO_WALLET_BILLER_ELECTRICITY = 3;
    public static int SENDER_TO_WALLET_BILLER_GAS = 4;
    public static int SENDER_TO_WALLET_BILLER_INSURANCE = 5;
    public static int SENDER_TO_WALLET_BILLER_LANDLINE = 2;
    public static int SENDER_TO_WALLET_BROWSE_PLANS = 6;
    public static int SENDER_TO_WALLET_HOME = 0;
    public static int SENDER_TO_WALLET_OFFERS = 11;
    public static int SENDER_TO_WALLET_RECHARGE = 1;

    public static String getServerUrl(String str) {
        return MODE_TEST.equals(str) ? "https://test.mobikwik.com/" : "https://walletapi.mobikwik.com/";
    }
}
