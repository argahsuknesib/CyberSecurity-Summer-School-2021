package com.xiaomi.passport.ui.internal;

import _m_j.egl;
import _m_j.egs;
import _m_j.iwb;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$signInIdAndPswWithCountryCode$1 extends Lambda implements iwb<AccountInfo> {
    final /* synthetic */ egl $credential;
    final /* synthetic */ egs this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$signInIdAndPswWithCountryCode$1(egs egs, egl egl) {
        super(0);
        this.this$0 = egs;
        this.$credential = egl;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: _m_j.ekq.O000000o(com.xiaomi.accountsdk.account.data.PasswordLoginParams):com.xiaomi.accountsdk.account.data.AccountInfo in method: com.xiaomi.passport.ui.internal.PassportRepoImpl$signInIdAndPswWithCountryCode$1.O000000o():com.xiaomi.accountsdk.account.data.AccountInfo, dex: classes4.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: _m_j.ekq.O000000o(com.xiaomi.accountsdk.account.data.PasswordLoginParams):com.xiaomi.accountsdk.account.data.AccountInfo
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:528)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    /* renamed from: O000000o */
    public com.xiaomi.accountsdk.account.data.AccountInfo invoke() {
        /*
            r6 = this;
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = new com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder
            r0.<init>()
            _m_j.egl r1 = r6.$credential
            java.lang.String r1 = r1.O00000oo
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = r0.setUserId(r1)
            _m_j.egl r1 = r6.$credential
            java.lang.String r1 = r1.O0000O0o
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = r0.setPassword(r1)
            _m_j.egl r1 = r6.$credential
            java.lang.String r1 = r1.f15233O000000o
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = r0.setCaptCode(r1)
            _m_j.egl r1 = r6.$credential
            java.lang.String r1 = r1.O00000Oo
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = r0.setCaptIck(r1)
            _m_j.egl r1 = r6.$credential
            java.lang.String r1 = r1.O00000o
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = r0.setServiceId(r1)
            _m_j.egl r1 = r6.$credential
            java.lang.String r1 = r1.O00000oO
            com.xiaomi.accountsdk.account.data.PasswordLoginParams$Builder r0 = r0.setCountryCode(r1)
            com.xiaomi.accountsdk.account.data.PasswordLoginParams r0 = r0.build()
            com.xiaomi.accountsdk.account.data.AccountInfo r0 = _m_j.ekq.O000000o(r0)     // Catch:{ NeedCaptchaException -> 0x003e }
            return r0
        L_0x003e:
            r0 = move-exception
            java.lang.String r0 = r0.getCaptchaUrl()
            java.lang.String r1 = "url"
            _m_j.ixe.O000000o(r0, r1)
            android.util.Pair r1 = _m_j.egs.O00000o(r0)
            com.xiaomi.passport.ui.internal.CaptchaException r2 = new com.xiaomi.passport.ui.internal.CaptchaException
            _m_j.efz r3 = new _m_j.efz
            java.lang.Object r4 = r1.first
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            java.lang.Object r1 = r1.second
            java.lang.String r5 = "captcha.second"
            _m_j.ixe.O000000o(r1, r5)
            java.lang.String r1 = (java.lang.String) r1
            r3.<init>(r4, r1, r0)
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.internal.PassportRepoImpl$signInIdAndPswWithCountryCode$1.invoke():com.xiaomi.accountsdk.account.data.AccountInfo");
    }
}
