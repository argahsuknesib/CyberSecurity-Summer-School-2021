package com.xiaomi.accountsdk.request;

import com.xiaomi.account.exception.PassportCAException;
import com.xiaomi.accountsdk.account.PassportCAConstants;
import com.xiaomi.accountsdk.account.PassportCATokenManager;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.stat.CustomizedUrlStatUtil;
import com.xiaomi.accountsdk.request.PassportSimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;
import java.util.UUID;

public abstract class PassportLoginRequest extends PassportRequest {
    private final PassportRequest request;

    /* access modifiers changed from: protected */
    public abstract String getLoginType();

    /* access modifiers changed from: protected */
    public abstract PassportCARequest makeCARequest(PassportCATokenManager passportCATokenManager, PassportRequestArguments passportRequestArguments);

    /* access modifiers changed from: protected */
    public abstract PassportSimpleRequest makeHttpsRequest(PassportRequestArguments passportRequestArguments);

    public PassportLoginRequest(PassportRequestArguments passportRequestArguments) {
        PassportSimpleRequest makeHttpsRequest = makeHttpsRequest(passportRequestArguments);
        PassportFallbackableRequest requestTryCA = getRequestTryCA(passportRequestArguments, makeHttpsRequest);
        if (requestTryCA == null) {
            AccountLog.d("PassportLoginRequest", String.format("CA-Request not ready for login %s, fallback to https way", getLoginType()));
            this.request = makeHttpsRequest;
            return;
        }
        this.request = requestTryCA;
    }

    private PassportFallbackableRequest getRequestTryCA(PassportRequestArguments passportRequestArguments, PassportSimpleRequest passportSimpleRequest) {
        String caUrl;
        PassportCATokenManager instance = PassportCATokenManager.getInstance();
        if (instance == null || !instance.isReady() || (caUrl = instance.getCaUrl(passportRequestArguments.url)) == null) {
            return null;
        }
        String str = PassportCAConstants.IMPL_VERSION;
        PassportRequestArguments copy = passportRequestArguments.copy();
        String str2 = copy.params.get("sid");
        copy.setUrl(caUrl);
        copy.putParamOpt("_ver", str);
        copy.params.remove("sid");
        copy.putParamOpt("_sid", str2);
        copy.urlParams.easyPutOpt("_ver", str);
        copy.urlParams.easyPutOpt("_sid", str2);
        copy.putHeaderOpt("x-mistats-header", UUID.randomUUID().toString());
        return new PassportFallbackableRequest(makeCARequest(instance, copy), passportSimpleRequest) {
            /* class com.xiaomi.accountsdk.request.PassportLoginRequest.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public boolean shouldTryRequest2(SimpleRequest.StringContent stringContent) {
                return stringContent == null;
            }

            /* access modifiers changed from: protected */
            public void onRequest1Success() {
                AccountLog.d("PassportLoginRequest", String.format("login %s with CA-Request succeeded to receive data from server", PassportLoginRequest.this.getLoginType()));
            }

            /* access modifiers changed from: protected */
            public void onRequest1Failed() {
                AccountLog.d("PassportLoginRequest", String.format("login %s with CA-Request failed to receive data from server", PassportLoginRequest.this.getLoginType()));
            }

            /* access modifiers changed from: protected */
            public boolean shouldTryRequest2(Exception exc) {
                return (exc instanceof IOException) || (exc.getCause() instanceof AuthenticationFailureException) || (exc.getCause() instanceof PassportCAException) || (exc.getCause() instanceof AccessDeniedException) || invalidResponseDueToHtmlOr302(exc.getCause());
            }

            private boolean invalidResponseDueToHtmlOr302(Throwable th) {
                return (th instanceof InvalidResponseException) && ((InvalidResponseException) th).isHtmlOr302;
            }
        };
    }

    public SimpleRequest.StringContent execute() throws IOException, PassportRequestException {
        Object[] objArr = new Object[2];
        objArr[0] = getLoginType();
        objArr[1] = this.request instanceof PassportFallbackableRequest ? "withCA" : "withoutCA";
        CustomizedUrlStatUtil customizedUrlStatUtil = new CustomizedUrlStatUtil(String.format("login/%s/%s", objArr), PassportCAConstants.IMPL_VERSION);
        customizedUrlStatUtil.startStat();
        try {
            SimpleRequest.StringContent execute = this.request.execute();
            customizedUrlStatUtil.finishStat();
            return execute;
        } catch (PassportRequestException e) {
            if (e.getCause() instanceof PassportCAException) {
                customizedUrlStatUtil.statError((Exception) e.getCause());
            }
            throw e;
        } catch (IOException e2) {
            customizedUrlStatUtil.statError(e2);
            throw e2;
        } catch (Throwable th) {
            customizedUrlStatUtil.finishStat();
            throw th;
        }
    }

    public boolean isResultFromCA() {
        PassportRequest passportRequest = this.request;
        return (passportRequest instanceof PassportFallbackableRequest) && !((PassportFallbackableRequest) passportRequest).isRequest2Used();
    }

    public static class ByPassword extends PassportLoginRequest {
        public final MetaLoginData mmetaLoginData;
        public final String serviceId;
        public final String userId;

        /* access modifiers changed from: protected */
        public String getLoginType() {
            return "byPassword";
        }

        public ByPassword(PassportRequestArguments passportRequestArguments, String str, String str2, MetaLoginData metaLoginData) {
            super(passportRequestArguments);
            this.userId = str;
            this.serviceId = str2;
            this.mmetaLoginData = metaLoginData;
        }

        /* access modifiers changed from: protected */
        public PassportSimpleRequest makeHttpsRequest(PassportRequestArguments passportRequestArguments) {
            return new PassportSimpleRequest.PostAsString(passportRequestArguments) {
                /* class com.xiaomi.accountsdk.request.PassportLoginRequest.ByPassword.AnonymousClass1 */

                public SimpleRequest.StringContent execute() throws IOException, PassportRequestException {
                    MetaLoginData metaLoginData = ByPassword.this.mmetaLoginData;
                    if (metaLoginData == null) {
                        try {
                            metaLoginData = XMPassport.getMetaLoginData(ByPassword.this.userId, ByPassword.this.serviceId);
                            if (metaLoginData == null) {
                                throw new PassportRequestException(new InvalidResponseException("Empty meta login data"));
                            }
                        } catch (IOException e) {
                            throw e;
                        } catch (InvalidResponseException e2) {
                            throw new PassportRequestException(e2);
                        } catch (AccessDeniedException e3) {
                            throw new PassportRequestException(e3);
                        } catch (AuthenticationFailureException e4) {
                            throw new PassportRequestException(e4);
                        } catch (InvalidUserNameException e5) {
                            throw new PassportRequestException(e5);
                        }
                    }
                    this.arguments.params.easyPut("_sign", metaLoginData.sign);
                    this.arguments.params.easyPut("qs", metaLoginData.qs);
                    this.arguments.params.easyPut("callback", metaLoginData.callback);
                    return super.execute();
                }
            };
        }

        /* access modifiers changed from: protected */
        public PassportCARequest makeCARequest(PassportCATokenManager passportCATokenManager, PassportRequestArguments passportRequestArguments) {
            return new PassportCARequest(new PassportSimpleRequest.PostAsString(passportRequestArguments), passportCATokenManager);
        }
    }

    public static class ByPassToken extends PassportLoginRequest {
        /* access modifiers changed from: protected */
        public String getLoginType() {
            return "byPassToken";
        }

        public ByPassToken(PassportRequestArguments passportRequestArguments) {
            super(passportRequestArguments);
        }

        /* access modifiers changed from: protected */
        public PassportSimpleRequest makeHttpsRequest(PassportRequestArguments passportRequestArguments) {
            return new PassportSimpleRequest.GetAsString(passportRequestArguments);
        }

        /* access modifiers changed from: protected */
        public PassportCARequest makeCARequest(PassportCATokenManager passportCATokenManager, PassportRequestArguments passportRequestArguments) {
            return new PassportCARequest(new PassportSimpleRequest.GetAsString(passportRequestArguments), passportCATokenManager);
        }
    }
}
