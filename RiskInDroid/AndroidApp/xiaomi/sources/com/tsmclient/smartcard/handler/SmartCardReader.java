package com.tsmclient.smartcard.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.handler.config.ConfigCardHandler;
import com.tsmclient.smartcard.model.ConfigRules;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;

public class SmartCardReader extends TagReader {
    public SmartCardReader(Activity activity) {
        this(activity, null, null);
    }

    public SmartCardReader(Activity activity, Handler handler, Handler handler2) {
        super(activity, handler, handler2);
    }

    public static Bundle readCard(IScTerminal iScTerminal, String str, Context context) {
        return readCard(iScTerminal, str, context, new Bundle());
    }

    public static Bundle readCard(IScTerminal iScTerminal, String str, Context context, Bundle bundle) {
        try {
            Bundle doReadCard = doReadCard(iScTerminal, str, context, bundle);
            Log.d("SmartCardReader", "readCard:" + str + " success.");
            return doReadCard;
        } catch (IOException e) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("success", false);
            bundle2.putInt("error", 1);
            Log.e("SmartCardReader", "readCard:" + str + " occurred IOException.", e);
            return bundle2;
        } catch (UnProcessableCardException e2) {
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("success", false);
            bundle3.putInt("error", 2);
            Log.e("SmartCardReader", "readCard:" + str + " occurred UnProcessableCardException.", e2);
            return bundle3;
        } catch (Exception e3) {
            Bundle bundle4 = new Bundle();
            bundle4.putBoolean("success", false);
            bundle4.putInt("error", 3);
            Log.e("SmartCardReader", "readCard:" + str + " occurred Exception.", e3);
            return bundle4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw new java.io.IOException("read card is interrupted");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    private static Bundle doReadCard(IScTerminal iScTerminal, String str, Context context, Bundle bundle) throws IOException, UnProcessableCardException {
        if (iScTerminal != null) {
            ISmartCardHandler handler = getHandler(context, str, bundle);
            if (handler != null) {
                iScTerminal.open();
                Bundle onHandleCard = handler.onHandleCard(iScTerminal, bundle);
                iScTerminal.close();
                return onHandleCard;
            }
            throw new UnProcessableCardException("No matched handler");
        }
        throw new UnProcessableCardException("IScTerminal is null");
    }

    private static ISmartCardHandler getHandler(Context context, String str, Bundle bundle) {
        if (bundle != null && bundle.containsKey("KEY_READ_CARD_OPTION_RULES")) {
            return new ConfigCardHandler(str, (ConfigRules) bundle.getParcelable("KEY_READ_CARD_OPTION_RULES"));
        }
        if (TextUtils.equals(str, "SZT")) {
            return new SZTCardHandler();
        }
        if (TextUtils.equals(str, "SPTC") || TextUtils.equals(str, "SPTC_NEW")) {
            return new CityUCardHandler(str);
        }
        if (TextUtils.equals(str, "BMAC")) {
            return new BMACCardHandler();
        }
        if (TextUtils.equals(str, "LNT")) {
            return new LingNanCardHandler();
        }
        if (TextUtils.equals(str, "CARD_TYPE_BANKCARD")) {
            return new BankCardHandler();
        }
        if (TextUtils.equals(str, "SUZHOUTONG")) {
            return new SuZhouTongCardHandler();
        }
        if (TextUtils.equals(str, "WHT")) {
            return new WHTCardHandler();
        }
        if (TextUtils.equals(str, "HZT")) {
            return new HZTCardHandler();
        }
        if (TextUtils.equals(str, "CHANGSHA")) {
            return new CSTCardHandler();
        }
        return null;
    }
}
