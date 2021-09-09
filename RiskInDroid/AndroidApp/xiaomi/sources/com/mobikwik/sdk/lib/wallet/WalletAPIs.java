package com.mobikwik.sdk.lib.wallet;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.google.gson.Gson;
import com.mobikwik.sdk.lib.Constants;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.ApiResponseContainer;
import com.mobikwik.sdk.lib.model.ApplyCouponResponse;
import com.mobikwik.sdk.lib.model.CancelTxnResponse;
import com.mobikwik.sdk.lib.model.CreateWalletResponse;
import com.mobikwik.sdk.lib.model.DebitWalletResponse;
import com.mobikwik.sdk.lib.model.DeleteSavedCardResponse;
import com.mobikwik.sdk.lib.model.FetchSavedCardResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.model.QueryWalletResponse;
import com.mobikwik.sdk.lib.model.TxnHashResponse;
import com.mobikwik.sdk.lib.model.UserBalanceResponse;
import com.mobikwik.sdk.lib.model.WalletApiRequest;
import com.mobikwik.sdk.lib.tasks.APICallTask;
import com.mobikwik.sdk.lib.utils.Checksum;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.Utils;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public abstract class WalletAPIs {
    private static WalletAPIsImpl implLive;
    private static WalletAPIsImpl implTest;

    static class WalletAPIsImpl extends WalletAPIs {
        private final String URL;
        private String deviceId;
        private String deviceName;
        boolean islive;

        public WalletAPIsImpl(boolean z, Context context) {
            this.islive = z;
            this.URL = Constants.getServerUrl(z ? "1" : "0");
            this.deviceId = context.getSharedPreferences("WalletAPIsPref", 0).getString("DeviceID", null);
            if (this.deviceId == null) {
                new StringBuilder("Wallet").append(new Random().nextLong());
                this.deviceId = UUID.randomUUID().toString();
                context.getSharedPreferences("WalletAPIsPref", 0).edit().putString("DeviceID", this.deviceId).apply();
            }
            this.deviceName = Build.MANUFACTURER + " " + Build.MODEL;
            if (this.deviceName.length() > 50) {
                this.deviceName = this.deviceName.substring(0, 50);
            }
        }

        private void fillCommonData(WalletApiRequest walletApiRequest) {
            walletApiRequest.deviceId = this.deviceId;
            walletApiRequest.deviceName = this.deviceName;
            walletApiRequest.plateform = "ANDROID";
        }

        public void applyCBCoupon(String str, String str2, String str3, String str4, String str5, final WalletResponseCallback walletResponseCallback) {
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str4;
            walletApiRequest.txnHash = str5;
            walletApiRequest.amount = str3;
            walletApiRequest.orderId = str2;
            walletApiRequest.couponCode = str;
            new APICallTask(this.URL + "walletapis/sdk/v1/applyCBCoupon", walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass10 */

                public void onCompleted(String str) {
                    if (walletResponseCallback != null) {
                        if (!Network.validateNetworkResponse(str)) {
                            walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                            return;
                        }
                        try {
                            ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                            ApplyCouponResponse applyCouponResponse = new ApplyCouponResponse();
                            applyCouponResponse.initiateFrom(apiResponseContainer.getApiResponse());
                            walletResponseCallback.onTaskCompleted(applyCouponResponse, apiResponseContainer.getOtpResponse());
                        } catch (Exception e) {
                            e.printStackTrace();
                            walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                        }
                    }
                }
            }).execute(new Void[0]);
        }

        public void cancelTxn(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, final WalletResponseCallback walletResponseCallback) {
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.orderId = str3;
            walletApiRequest.responseURL = str7;
            walletApiRequest.merchantName = str8;
            new APICallTask(this.URL + "walletapis/sdk/v1/cancel", walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass9 */

                public void onCompleted(String str) {
                    if (walletResponseCallback != null) {
                        if (!Network.validateNetworkResponse(str)) {
                            walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                            return;
                        }
                        try {
                            ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                            CancelTxnResponse cancelTxnResponse = new CancelTxnResponse();
                            cancelTxnResponse.initiateFrom(apiResponseContainer.getApiResponse());
                            walletResponseCallback.onTaskCompleted(cancelTxnResponse, apiResponseContainer.getOtpResponse());
                        } catch (Exception e) {
                            e.printStackTrace();
                            walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                        }
                    }
                }
            }).execute(new Void[0]);
        }

        public void createWallet(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, final WalletResponseCallback walletResponseCallback) {
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.responseURL = str8;
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.orderId = str3;
            walletApiRequest.otp = str7;
            walletApiRequest.merchantName = str9;
            new APICallTask(this.URL + "walletapis/sdk/v1/createUser", walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass5 */

                public void onCompleted(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        CreateWalletResponse createWalletResponse = new CreateWalletResponse();
                        createWalletResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(createWalletResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }

        public void debitWallet(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2, String str8, String str9, final WalletResponseCallback walletResponseCallback) {
            String str10 = this.URL + "walletapis/sdk/v1/debitWallet";
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.orderId = str3;
            walletApiRequest.responseURL = str8;
            walletApiRequest.merchantName = str9;
            if (z) {
                walletApiRequest.token = str7;
                if (z2) {
                    walletApiRequest.autoSendOTP = true;
                }
            } else {
                walletApiRequest.otp = str7;
            }
            new APICallTask(str10, walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass6 */

                public void onCompleted(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        DebitWalletResponse debitWalletResponse = new DebitWalletResponse();
                        debitWalletResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(debitWalletResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }

        public void deleteSavedCard(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, final WalletResponseCallback walletResponseCallback) {
            String str11 = this.URL + "walletapis/sdk/v1/deleteCard";
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.orderId = str3;
            walletApiRequest.responseURL = str9;
            walletApiRequest.cardId = str8;
            if (z) {
                walletApiRequest.token = str7;
            } else {
                walletApiRequest.otp = str7;
            }
            walletApiRequest.merchantName = str10;
            new APICallTask(str11, walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass8 */

                public void onCompleted(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        DeleteSavedCardResponse deleteSavedCardResponse = new DeleteSavedCardResponse();
                        deleteSavedCardResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(deleteSavedCardResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }

        public void fetchSavedCard(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, final WalletResponseCallback walletResponseCallback) {
            String str10 = this.URL + "walletapis/sdk/v1/fetchCards";
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            fillCommonData(walletApiRequest);
            walletApiRequest.responseURL = str8;
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.orderId = str3;
            if (z) {
                walletApiRequest.token = str7;
            } else {
                walletApiRequest.otp = str7;
            }
            walletApiRequest.merchantName = str9;
            new APICallTask(str10, walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass7 */

                public void onCompleted(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        FetchSavedCardResponse fetchSavedCardResponse = new FetchSavedCardResponse();
                        fetchSavedCardResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(fetchSavedCardResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }

        public void generateOtp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, final WalletResponseCallback walletResponseCallback) {
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.merchantName = str8;
            walletApiRequest.orderId = str3;
            walletApiRequest.responseURL = str7;
            new APICallTask(this.URL + "walletapis/sdk/v1/generateOTP", walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass3 */

                public void onCompleted(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        GenerateOTPResponse generateOTPResponse = new GenerateOTPResponse();
                        generateOTPResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(generateOTPResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }

        public void getTransactionHash(final String str, String str2, String str3, String str4, final WalletResponseCallback walletResponseCallback) {
            final HashMap hashMap = new HashMap();
            hashMap.put("orderid", str2);
            hashMap.put("amount", str3);
            hashMap.put("mid", str4);
            hashMap.put("pgName", "wallet");
            new AsyncTask() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public String doInBackground(Void... voidArr) {
                    return Network.getResponseOfPostRequest(str, hashMap);
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        Checksum parseChecksumResponse = Checksum.parseChecksumResponse(str);
                        walletResponseCallback.onTaskCompleted(new TxnHashResponse("SUCCESS".equals(parseChecksumResponse.getStatus()) ? "0" : "1", parseChecksumResponse.getStatus(), parseChecksumResponse.getStatus(), parseChecksumResponse.getChecksum()), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }.execute(new Void[0]);
        }

        public void getUserBalance(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2, boolean z3, String str8, String str9, final WalletResponseCallback walletResponseCallback) {
            String str10 = this.URL + "walletapis/sdk/v1/walletBalance";
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.cell = str2;
            walletApiRequest.email = str;
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str5;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.orderId = str3;
            walletApiRequest.responseURL = str8;
            walletApiRequest.merchantName = str9;
            if (z) {
                walletApiRequest.token = str7;
                if (z2) {
                    walletApiRequest.autoSendOTP = true;
                }
            } else {
                walletApiRequest.otp = str7;
            }
            walletApiRequest.forceFetchCards = z3;
            new APICallTask(str10, walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass4 */

                public void onCompleted(String str) {
                    Utils.print("getUserBalance  response ." + str + ".");
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        UserBalanceResponse userBalanceResponse = new UserBalanceResponse();
                        userBalanceResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(userBalanceResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }

        public void resolveUser(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, final WalletResponseCallback walletResponseCallback) {
            String str9 = this.URL + "walletapis/sdk/v1/resolveUser";
            WalletApiRequest walletApiRequest = new WalletApiRequest();
            fillCommonData(walletApiRequest);
            walletApiRequest.mid = str5;
            walletApiRequest.email = str;
            walletApiRequest.cell = str2;
            walletApiRequest.txnHash = str6;
            walletApiRequest.amount = str4;
            walletApiRequest.responseURL = str7;
            walletApiRequest.merchantName = str8;
            walletApiRequest.orderId = str3;
            if (z) {
                walletApiRequest.autoSendOTP = true;
            }
            new APICallTask(str9, walletApiRequest.toString(), new APICallTask.OnCompleteListener() {
                /* class com.mobikwik.sdk.lib.wallet.WalletAPIs.WalletAPIsImpl.AnonymousClass2 */

                public void onCompleted(String str) {
                    if (!Network.validateNetworkResponse(str)) {
                        walletResponseCallback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), str);
                        return;
                    }
                    try {
                        ApiResponseContainer apiResponseContainer = (ApiResponseContainer) new Gson().fromJson(str.trim(), ApiResponseContainer.class);
                        QueryWalletResponse queryWalletResponse = new QueryWalletResponse();
                        queryWalletResponse.initiateFrom(apiResponseContainer.getApiResponse());
                        walletResponseCallback.onTaskCompleted(queryWalletResponse, apiResponseContainer.getOtpResponse());
                    } catch (Exception e) {
                        e.printStackTrace();
                        walletResponseCallback.onError(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }).execute(new Void[0]);
        }
    }

    public static WalletAPIs getInstance(boolean z, Context context) {
        if (z) {
            if (implLive == null) {
                implLive = new WalletAPIsImpl(z, context);
            }
            return implLive;
        }
        if (implTest == null) {
            implTest = new WalletAPIsImpl(z, context);
        }
        return implTest;
    }

    public abstract void applyCBCoupon(String str, String str2, String str3, String str4, String str5, WalletResponseCallback walletResponseCallback);

    public abstract void cancelTxn(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, WalletResponseCallback walletResponseCallback);

    public abstract void createWallet(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, WalletResponseCallback walletResponseCallback);

    public abstract void debitWallet(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2, String str8, String str9, WalletResponseCallback walletResponseCallback);

    public abstract void deleteSavedCard(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, WalletResponseCallback walletResponseCallback);

    public abstract void fetchSavedCard(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, WalletResponseCallback walletResponseCallback);

    public abstract void generateOtp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, WalletResponseCallback walletResponseCallback);

    public abstract void getTransactionHash(String str, String str2, String str3, String str4, WalletResponseCallback walletResponseCallback);

    public abstract void getUserBalance(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2, boolean z3, String str8, String str9, WalletResponseCallback walletResponseCallback);

    public abstract void resolveUser(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, WalletResponseCallback walletResponseCallback);
}
