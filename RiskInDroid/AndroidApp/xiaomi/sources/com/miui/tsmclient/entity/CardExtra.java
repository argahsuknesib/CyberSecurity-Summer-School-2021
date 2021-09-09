package com.miui.tsmclient.entity;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.miui.tsmclient.b.a.b;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.entity.CardConfigManager;
import com.miui.tsmclient.net.request.a;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.PrefUtils;
import com.tsmclient.smartcard.terminal.IScTerminal;
import com.tsmclient.smartcard.terminal.TerminalType;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CardExtra {
    private static Set<String> INTERNAL_TERMINAL;

    static {
        HashSet hashSet = new HashSet();
        INTERNAL_TERMINAL = hashSet;
        hashSet.add("com.miui.tsmclient");
    }

    public IScTerminal getTerminal(CardInfo cardInfo) {
        LogUtils.i("cardInfo.mCardDevice:" + cardInfo.mCardDevice);
        return b.a().a(cardInfo.mCardDevice, (TextUtils.isEmpty(cardInfo.mCardDevice) || INTERNAL_TERMINAL.contains(cardInfo.mCardDevice)) ? cardInfo.isSecure() ? TerminalType.SPI : TerminalType.I2C : TerminalType.PERIPHERAL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.miui.tsmclient.entity.CardExtraInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void updateExtraInfo(Context context, CardInfo cardInfo) {
        CardConfigManager.CardConfig cardConfigByType;
        if (cardInfo != null && context != null && cardInfo.mHasIssue && Looper.myLooper() != Looper.getMainLooper() && (cardConfigByType = CardConfigManager.getInstance().getCardConfigByType(cardInfo.mCardType)) != null && cardConfigByType.isNeedExtraInfo()) {
            Context applicationContext = context.getApplicationContext();
            String format = String.format("key_card_extra_%1$s", cardInfo.mCardType);
            CardExtraInfo cardExtraInfo = null;
            String string = PrefUtils.getString(applicationContext, format, null);
            cardInfo.updateBackground(applicationContext);
            if (TextUtils.isEmpty(string)) {
                try {
                    a aVar = new a(cardInfo, getTerminal(cardInfo).getCPLC());
                    CardExtraInfo cardExtraInfo2 = (CardExtraInfo) HttpClient.getInstance(applicationContext).execute(aVar).getResult();
                    if (aVar.isSuccess()) {
                        string = cardExtraInfo2.toString();
                        PrefUtils.putString(applicationContext, format, string);
                    }
                } catch (IOException e) {
                    LogUtils.e("updateExtraInfo failed", e);
                } catch (InterruptedException e2) {
                    LogUtils.e("updateExtraInfo failed", e2);
                    Thread.currentThread().interrupt();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                cardExtraInfo = new Gson().fromJson(string, CardExtraInfo.class);
            }
            if (cardExtraInfo != null) {
                if (!TextUtils.isEmpty(cardExtraInfo.getCardNumber())) {
                    cardInfo.mCardNo = cardExtraInfo.getCardNumber();
                }
                if (!TextUtils.isEmpty(cardExtraInfo.getRealCardNumber())) {
                    cardInfo.mRealCardNo = cardExtraInfo.getRealCardNumber();
                }
            }
        }
    }
}
