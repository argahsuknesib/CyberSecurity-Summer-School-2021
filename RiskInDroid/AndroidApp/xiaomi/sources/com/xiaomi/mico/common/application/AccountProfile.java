package com.xiaomi.mico.common.application;

import _m_j.ahg;
import _m_j.jgc;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.common.util.Cache;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.mico.music.QQMusicVipAdHelper;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.manager.MusicSourceManager;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.HashMap;
import rx.Observable;
import rx.Subscriber;

public class AccountProfile {
    private static HashMap<String, AccountProfile> sProfiles = new HashMap<>();
    private String avatar;
    public MiBrain.CPAccountInfo mKkboxAccountInfo;
    private MiBrain.CPBindStatus mKkboxBindStatus;
    public MiBrain.CPAccountInfo mQQAccountInfo;
    private MiBrain.CPBindStatus mQQBindStatus;
    private final String mUserId;
    public MusicSuorce musicSource;
    private String name;
    public boolean qqMusicVipOpened;

    public static AccountProfile current() {
        String userId = LoginManager.getInstance().getPassportInfo().getUserId();
        if (!sProfiles.containsKey(userId)) {
            sProfiles.put(userId, new AccountProfile(userId));
        }
        return sProfiles.get(userId);
    }

    public AccountProfile(String str) {
        this.mUserId = str;
        this.musicSource = getCacheMusicSource(str);
        getCacheCPBindStatus(str);
    }

    public boolean needSyncXMProfile() {
        return TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.avatar);
    }

    public void setQQBindStatus(MiBrain.CPBindStatus cPBindStatus) {
        this.mQQBindStatus = cPBindStatus;
        cacheCPBindStatus();
    }

    public void setQQAccountInfo(MiBrain.CPAccountInfo cPAccountInfo) {
        this.mQQAccountInfo = cPAccountInfo;
    }

    public void setKkboxBindStatus(MiBrain.CPBindStatus cPBindStatus) {
        this.mKkboxBindStatus = cPBindStatus;
        cacheCPBindStatus();
    }

    public void setKkboxAccountInfo(MiBrain.CPAccountInfo cPAccountInfo) {
        this.mKkboxAccountInfo = cPAccountInfo;
    }

    public MusicSuorce getMusicSource() {
        return this.musicSource;
    }

    public void setMusicSource(String str) {
        MusicSuorce value = MusicSuorce.value(str);
        MusicSuorce musicSuorce = this.musicSource;
        boolean z = musicSuorce == null || musicSuorce != value;
        this.musicSource = value;
        if (z) {
            jgc.O000000o().O00000o(new MusicEvent.MusicSourceChanged());
        }
        cacheMusicSource();
    }

    public MusicSuorce getCacheMusicSource(String str) {
        String settingString = PreferenceUtils.getSettingString(CommonApplication.getAppContext(), "music_source_".concat(String.valueOf(str)), null);
        if (!TextUtils.isEmpty(settingString)) {
            return MusicSuorce.value(settingString);
        }
        return null;
    }

    public void cacheMusicSource() {
        Context appContext = CommonApplication.getAppContext();
        PreferenceUtils.setSettingString(appContext, "music_source_" + this.mUserId, this.musicSource.source);
    }

    public void cacheCPBindStatus() {
        Cache.put("qq_bind_status" + this.mUserId, this.mQQBindStatus);
        Cache.put("kkbox_bind_status" + this.mUserId, this.mKkboxBindStatus);
    }

    public MiBrain.CPBindStatus getQQBindStatus() {
        return this.mQQBindStatus;
    }

    public MiBrain.CPBindStatus getKkboxBindStatus() {
        return this.mKkboxBindStatus;
    }

    public void getCacheCPBindStatus(String str) {
        this.mQQBindStatus = (MiBrain.CPBindStatus) Cache.get("qq_bind_status".concat(String.valueOf(str)), MiBrain.CPBindStatus.class);
        this.mKkboxBindStatus = (MiBrain.CPBindStatus) Cache.get("kkbox_bind_status".concat(String.valueOf(str)), MiBrain.CPBindStatus.class);
    }

    public boolean isQQAccountAuthValid() {
        MiBrain.CPBindStatus cPBindStatus = this.mQQBindStatus;
        if (cPBindStatus != null) {
            return ("normal".equalsIgnoreCase(cPBindStatus.expireStatus) || "expireSoon".equalsIgnoreCase(this.mQQBindStatus.expireStatus)) && this.mQQBindStatus.isQQMusicCP();
        }
        return false;
    }

    public boolean isQqMusicVipOpened() {
        return this.qqMusicVipOpened;
    }

    public boolean isKKBoxAuthValid() {
        MiBrain.CPBindStatus cPBindStatus = this.mKkboxBindStatus;
        return cPBindStatus != null && "binded".equalsIgnoreCase(cPBindStatus.expireStatus) && this.mKkboxBindStatus.isKKBoxMusicCP();
    }

    public boolean isQQAccountNotBinded() {
        MiBrain.CPBindStatus cPBindStatus = this.mQQBindStatus;
        return cPBindStatus != null && "notBind".equalsIgnoreCase(cPBindStatus.expireStatus);
    }

    public String getName() {
        return this.name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public Observable<MiBrain.CPAccountInfo> getKkboxAccountInfo() {
        MiBrain.CPAccountInfo cPAccountInfo = this.mKkboxAccountInfo;
        if (cPAccountInfo != null) {
            return Observable.just(cPAccountInfo);
        }
        return Observable.unsafeCreate(new Observable.OnSubscribe() {
            /* class com.xiaomi.mico.common.application.$$Lambda$AccountProfile$oyTyd_rSVfK11UKnXdYGBQdEFGk */

            public final void call(Object obj) {
                AccountProfile.this.lambda$getKkboxAccountInfo$0$AccountProfile((Subscriber) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getKkboxAccountInfo$0$AccountProfile(final Subscriber subscriber) {
        Long valueOf = Long.valueOf(this.mUserId);
        MiBrain.CPBindStatus cPBindStatus = this.mKkboxBindStatus;
        ApiHelper.getQQAccountInfo(valueOf, cPBindStatus == null ? "" : cPBindStatus.providerName, new ApiRequest.Listener<MiBrain.CPAccountInfo>() {
            /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass1 */

            public void onSuccess(MiBrain.CPAccountInfo cPAccountInfo) {
                AccountProfile accountProfile = AccountProfile.this;
                accountProfile.mKkboxAccountInfo = cPAccountInfo;
                subscriber.onNext(accountProfile.mKkboxAccountInfo);
                subscriber.onCompleted();
            }

            public void onFailure(ApiError apiError) {
                subscriber.onError(apiError.toThrowable());
            }
        });
    }

    public Observable<MiBrain.CPAccountInfo> getQQAccountInfo() {
        MiBrain.CPAccountInfo cPAccountInfo = this.mQQAccountInfo;
        if (cPAccountInfo != null) {
            return Observable.just(cPAccountInfo);
        }
        return Observable.unsafeCreate(new Observable.OnSubscribe() {
            /* class com.xiaomi.mico.common.application.$$Lambda$AccountProfile$nnYlQxY2M_x10TE9fmW4rX3cIww */

            public final void call(Object obj) {
                AccountProfile.this.lambda$getQQAccountInfo$1$AccountProfile((Subscriber) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getQQAccountInfo$1$AccountProfile(final Subscriber subscriber) {
        Long valueOf = Long.valueOf(this.mUserId);
        MiBrain.CPBindStatus cPBindStatus = this.mQQBindStatus;
        ApiHelper.getQQAccountInfo(valueOf, cPBindStatus == null ? "" : cPBindStatus.providerName, new ApiRequest.Listener<MiBrain.CPAccountInfo>() {
            /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass2 */

            public void onSuccess(MiBrain.CPAccountInfo cPAccountInfo) {
                AccountProfile accountProfile = AccountProfile.this;
                accountProfile.mQQAccountInfo = cPAccountInfo;
                subscriber.onNext(accountProfile.mQQAccountInfo);
                subscriber.onCompleted();
            }

            public void onFailure(ApiError apiError) {
                subscriber.onError(apiError.toThrowable());
            }
        });
    }

    public void syncQQBindStatus() {
        syncQQBindStatus(null);
    }

    public void syncQQBindStatus(final ApiRequest.Listener<MiBrain.CPBindStatus> listener) {
        final boolean isQQAccountAuthValid = isQQAccountAuthValid();
        AreaCode areaCode = ApiConstants.getAreaCode();
        if (AreaCode.CN == areaCode) {
            ApiHelper.getQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
                /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass3 */

                static /* synthetic */ void lambda$onSuccess$0(MiBrain.CPAccountInfo cPAccountInfo) {
                }

                public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                    AccountProfile.this.setQQBindStatus(cPBindStatus);
                    boolean isQQAccountAuthValid = AccountProfile.this.isQQAccountAuthValid();
                    if (isQQAccountAuthValid != isQQAccountAuthValid) {
                        jgc.O000000o().O00000oO(new MusicEvent.CPAccountBindStatusChanged());
                        MusicSourceManager.sendCpAccountBindStatusChanged(isQQAccountAuthValid);
                    }
                    boolean isQQAccountAuthValid2 = AccountProfile.this.isQQAccountAuthValid();
                    ahg ahg = QQMusicVipAdHelper.LOGGER_NEW;
                    ahg.O000000o("AccountProfile#syncQQBindStatus isQQAccountAuthValid = %b", Boolean.valueOf(isQQAccountAuthValid2));
                    if (isQQAccountAuthValid2) {
                        AccountProfile.this.getQQMusicMemberStatus();
                        AccountProfile.this.getQQAccountInfo().subscribe($$Lambda$AccountProfile$3$0WdjfGZvceQvXVtuAdE_mq4xf8.INSTANCE, $$Lambda$AccountProfile$3$pvtHvXWiXRQzRfcIO72OFCibCE0.INSTANCE);
                    } else {
                        QQMusicVipAdHelper.postRemoveHeaderEvent();
                    }
                    ApiRequest.Listener listener = listener;
                    if (listener != null) {
                        listener.onSuccess(cPBindStatus);
                    }
                }

                public void onFailure(ApiError apiError) {
                    ApiRequest.Listener listener = listener;
                    if (listener != null) {
                        listener.onFailure(apiError);
                    }
                    ahg ahg = QQMusicVipAdHelper.LOGGER_NEW;
                    ahg.O000000o("AccountProfile#syncQQBindStatus#getQQBindStatus onFailure");
                    QQMusicVipAdHelper.postRemoveHeaderEvent();
                }
            });
            return;
        }
        if (AreaCode.TW == areaCode) {
            ApiHelper.getOAuthInfo("347442676548767744", new ApiRequest.Listener<MiBrain.OAuthInfo>() {
                /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass4 */

                public void onSuccess(MiBrain.OAuthInfo oAuthInfo) {
                    MiBrain.CPBindStatus cPBindStatus = new MiBrain.CPBindStatus();
                    cPBindStatus.expireStatus = oAuthInfo.state;
                    cPBindStatus.providerName = oAuthInfo.providerName;
                    long currentTimeMillis = (oAuthInfo.expireAt - System.currentTimeMillis()) / 1000;
                    if (currentTimeMillis > 0) {
                        cPBindStatus.expiresIn = (int) currentTimeMillis;
                    }
                    AccountProfile.this.setKkboxBindStatus(cPBindStatus);
                    ApiRequest.Listener listener = listener;
                    if (listener != null) {
                        listener.onSuccess(cPBindStatus);
                    }
                }

                public void onFailure(ApiError apiError) {
                    ApiRequest.Listener listener = listener;
                    if (listener != null) {
                        listener.onFailure(apiError);
                    }
                }
            });
        }
        ahg ahg = QQMusicVipAdHelper.LOGGER_NEW;
        ahg.O00000Oo("AccountProfile#syncQQBindStatus AreaCode.CN != areaCode");
        QQMusicVipAdHelper.postRemoveHeaderEvent();
    }

    public void getQQMusicMemberStatus() {
        ApiHelper.getQQMusicMemberStatus(new ApiRequest.Listener<Payment.MemberStatus>() {
            /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass5 */

            public void onSuccess(Payment.MemberStatus memberStatus) {
                AccountProfile.this.qqMusicVipOpened = memberStatus.isVipOpened();
                QQMusicVipAdHelper.getInstance().refreshAdConfigure(CommonApplication.getAppContext());
            }

            public void onFailure(ApiError apiError) {
                ahg ahg = QQMusicVipAdHelper.LOGGER_NEW;
                ahg.O00000o("AccountProfile#getQQMusicMemberStatus#onFailure");
                QQMusicVipAdHelper.postRemoveHeaderEvent();
            }
        });
    }

    public Observable<Boolean> isQQAccountExpired() {
        MiBrain.CPBindStatus cPBindStatus = this.mQQBindStatus;
        if (cPBindStatus != null) {
            return Observable.just(Boolean.valueOf("expired".equalsIgnoreCase(cPBindStatus.expireStatus)));
        }
        return Observable.unsafeCreate(new Observable.OnSubscribe<Boolean>() {
            /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass6 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super Boolean>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super Boolean> subscriber) {
                ApiHelper.getQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
                    /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass6.AnonymousClass1 */

                    public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                        if (cPBindStatus != null) {
                            subscriber.onNext(Boolean.valueOf("expired".equalsIgnoreCase(cPBindStatus.expireStatus)));
                        }
                        subscriber.onCompleted();
                    }

                    public void onFailure(ApiError apiError) {
                        subscriber.onError(apiError.toThrowable());
                    }
                });
            }
        });
    }

    public Observable<MusicSuorce> getMusicSourceInfo(boolean z) {
        MusicSuorce musicSuorce = this.musicSource;
        if (musicSuorce == null || z) {
            return Observable.unsafeCreate(new Observable.OnSubscribe() {
                /* class com.xiaomi.mico.common.application.$$Lambda$AccountProfile$RIBBwMMuOXrSXJX0esr5r_p0HG4 */

                public final void call(Object obj) {
                    AccountProfile.this.lambda$getMusicSourceInfo$2$AccountProfile((Subscriber) obj);
                }
            });
        }
        return Observable.just(musicSuorce);
    }

    public /* synthetic */ void lambda$getMusicSourceInfo$2$AccountProfile(final Subscriber subscriber) {
        ApiHelper.getMusicSource(new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.application.AccountProfile.AnonymousClass7 */

            public void onSuccess(String str) {
                AccountProfile.this.setMusicSource(str);
                subscriber.onNext(AccountProfile.this.musicSource);
                subscriber.onCompleted();
            }

            public void onFailure(ApiError apiError) {
                subscriber.onError(apiError.toThrowable());
            }
        });
    }

    public boolean isQQMusicSource() {
        return MusicSuorce.QQ == this.musicSource;
    }

    public boolean isMiMusicSource() {
        return MusicSuorce.MI == this.musicSource;
    }

    public void logout() {
        cacheCPBindStatus();
    }

    public enum MusicSuorce {
        MI("MI"),
        QQ("QQ"),
        KKBOX("KKBOX"),
        NONE("NONE");
        
        public String source;

        private MusicSuorce(String str) {
            this.source = str;
        }

        public final String getSource() {
            return this.source;
        }

        public static MusicSuorce value(String str) {
            for (MusicSuorce musicSuorce : values()) {
                if (musicSuorce.source.equalsIgnoreCase(str)) {
                    return musicSuorce;
                }
            }
            return NONE;
        }
    }
}
