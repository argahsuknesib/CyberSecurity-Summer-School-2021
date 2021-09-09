package com.miui.tsmclient.model.e;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.entity.CardConfigManager;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.i;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.handler.SmartCardReader;

public class e<T extends d, C extends CardInfo> implements i<C> {
    protected T b = c();

    public BaseResponse a(Context context, CardInfo cardInfo) {
        return a(context, cardInfo, null);
    }

    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        String str = cardInfo.mCardType;
        Bundle bundle2 = new Bundle();
        CardConfigManager.getInstance().parseCardRulesToBundle(str, bundle2);
        Bundle readCard = SmartCardReader.readCard(cardInfo.getTerminal(), str, context, bundle2);
        int i = -2;
        if (readCard == null) {
            return new BaseResponse(-2, cardInfo);
        }
        LogUtils.i("queryCardInfo:" + str + ", " + readCard);
        if (!readCard.getBoolean("success")) {
            if (readCard.getInt("error") == 2) {
                i = 2003;
            }
            return new BaseResponse(i, cardInfo);
        }
        cardInfo.mCardNo = readCard.getString("account_num");
        cardInfo.mRealCardNo = readCard.getString("account_real_num");
        cardInfo.mIsReadSECorrectly = true;
        cardInfo.mCardBalance = readCard.getInt("e_balance");
        cardInfo.mTradeLogs = readCard.getParcelableArrayList("trade_log");
        cardInfo.mStartDate = readCard.getString("valid_start");
        cardInfo.mEndDate = readCard.getString("valid_end");
        cardInfo.mAreaCode = readCard.getString("area_code");
        cardInfo.mStatus = CardInfo.Status.ACTIVE;
        if (readCard.getInt("status_negative") != 0) {
            cardInfo.mStatus = CardInfo.Status.NEGATIVE;
        }
        if (readCard.getInt("card_exception") != 0) {
            cardInfo.mStatus = CardInfo.Status.INVALID;
        }
        if (readCard.getInt("in_black_list") == 1) {
            cardInfo.mStatus = CardInfo.Status.IN_BLACKLIST;
        }
        int i2 = readCard.getInt("overdrawn");
        CardConfigManager.CardConfig cardConfigByType = CardConfigManager.getInstance().getCardConfigByType(str);
        if (i2 < 0 || (cardConfigByType != null && cardConfigByType.isJudgeOverdrawIllegal() && i2 > 0 && cardInfo.mCardBalance + i2 > 0)) {
            cardInfo.mStatus = CardInfo.Status.DATA_ILLEGAL;
        }
        boolean z = readCard.getBoolean("is_valid_start_date", true);
        boolean z2 = readCard.getBoolean("is_valid_end_date", true);
        if (!z) {
            cardInfo.mStatus = CardInfo.Status.START_DATE_INVALID;
        }
        if (!z2) {
            cardInfo.mStatus = CardInfo.Status.END_DATE_INVALID;
        }
        if (readCard.getInt("card_locked") == 1) {
            cardInfo.mStatus = CardInfo.Status.LOCKED;
        }
        cardInfo.updateExtraInfo(context);
        return new BaseResponse(0, cardInfo);
    }

    public void a() {
        this.b.a();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.miui.tsmclient.model.BaseResponse b(android.content.Context r2, C r3, android.os.Bundle r4) {
        /*
            r1 = this;
            T r0 = r1.b
            com.miui.tsmclient.model.BaseResponse r2 = r0.a(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.e.e.b(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.miui.tsmclient.model.BaseResponse c(android.content.Context r2, C r3, android.os.Bundle r4) {
        /*
            r1 = this;
            T r0 = r1.b
            com.miui.tsmclient.model.BaseResponse r2 = r0.e(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.e.e.c(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse");
    }

    /* access modifiers changed from: protected */
    public T c() {
        return new d();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.miui.tsmclient.model.BaseResponse d(android.content.Context r2, C r3, android.os.Bundle r4) {
        /*
            r1 = this;
            T r0 = r1.b
            com.miui.tsmclient.model.BaseResponse r2 = r0.f(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.e.e.d(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.miui.tsmclient.model.BaseResponse e(android.content.Context r3, C r4, android.os.Bundle r5) {
        /*
            r2 = this;
            T r0 = r2.b
            com.miui.tsmclient.model.BaseResponse r0 = r0.c(r3, r4, r5)
            boolean r1 = r0.isSuccess()
            if (r1 == 0) goto L_0x0016
            com.miui.tsmclient.util.a.a(r3, r4)
            T r0 = r2.b
            com.miui.tsmclient.model.BaseResponse r3 = r0.g(r3, r4, r5)
            return r3
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.e.e.e(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.miui.tsmclient.model.BaseResponse f(android.content.Context r2, C r3, android.os.Bundle r4) {
        /*
            r1 = this;
            T r0 = r1.b
            com.miui.tsmclient.model.BaseResponse r2 = r0.d(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.e.e.f(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.miui.tsmclient.model.BaseResponse g(android.content.Context r2, C r3, android.os.Bundle r4) {
        /*
            r1 = this;
            T r0 = r1.b
            com.miui.tsmclient.model.BaseResponse r2 = r0.b(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.e.e.g(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse");
    }

    public BaseResponse h(Context context, C c, Bundle bundle) {
        return new BaseResponse();
    }
}
