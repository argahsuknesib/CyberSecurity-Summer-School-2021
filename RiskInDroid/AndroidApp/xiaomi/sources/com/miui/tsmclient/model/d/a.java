package com.miui.tsmclient.model.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.MifareTag;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ResUtils;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a extends d {
    public static List<MifareCardInfo> a(Context context, List<TsmRpcModels.DoorCardInfo> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (TsmRpcModels.DoorCardInfo next : list) {
            MifareCardInfo mifareCardInfo = new MifareCardInfo();
            mifareCardInfo.mAid = next.getAid();
            mifareCardInfo.mMifareCardType = next.getCardType().getNumber();
            mifareCardInfo.mVCStatus = next.getVcStatus();
            mifareCardInfo.mCardName = TextUtils.isEmpty(next.getName()) ? ResUtils.getString(context, "entrance_card_name_home") : next.getName();
            mifareCardInfo.mCardArt = next.getCardArt();
            mifareCardInfo.mCardFace = i % 2 == 0 ? 1 : 2;
            mifareCardInfo.mFingerAuthFlag = next.getFingerFlag();
            mifareCardInfo.mProductName = next.getProductName();
            mifareCardInfo.setProductId(next.getProductId());
            mifareCardInfo.setBusinessId(next.getBusinessId());
            mifareCardInfo.setCommunityCode(next.getCommunityCode());
            mifareCardInfo.setApplyStatus(next.getStatus());
            arrayList.add(mifareCardInfo);
            i++;
        }
        return arrayList;
    }

    private void a(Context context, CardInfo cardInfo, String str, int i, String str2, boolean z) throws IOException, com.miui.tsmclient.seitsm.a.a {
        TsmRpcModels.DoorCardInfo a2 = this.c.a(context, str, i, str2);
        if ("MIFARE_ENTRANCE".equals(cardInfo.mCardType)) {
            a(context, (MifareCardInfo) cardInfo, a2);
            if (z) {
                a(context, cardInfo);
            }
        }
    }

    public static void a(Context context, MifareCardInfo mifareCardInfo, TsmRpcModels.DoorCardInfo doorCardInfo) {
        if (doorCardInfo != null) {
            mifareCardInfo.mAid = doorCardInfo.getAid();
            if (mifareCardInfo.mCardArt == null) {
                mifareCardInfo.mCardArt = doorCardInfo.getCardArt();
            }
            mifareCardInfo.mVCStatus = doorCardInfo.getVcStatus();
            mifareCardInfo.mCardName = TextUtils.isEmpty(doorCardInfo.getName()) ? ResUtils.getString(context, "entrance_card_name_home") : doorCardInfo.getName();
            mifareCardInfo.mFingerAuthFlag = doorCardInfo.getFingerFlag();
            mifareCardInfo.setProductId(doorCardInfo.getProductId());
        }
    }

    public BaseResponse a(Context context) {
        String str;
        int i;
        try {
            TsmRpcModels.QueryDoorCardInfoResponse b = this.c.b(context);
            if (b == null) {
                str = "";
                i = -1;
            } else {
                i = f.a(b.getResult());
                String errorDesc = b.getErrorDesc();
                LogUtils.d("queryMifareCardInfo result: ".concat(String.valueOf(i)));
                if (i == 0) {
                    return new BaseResponse(0, b);
                }
                str = errorDesc;
            }
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            LogUtils.e("failed to query mifare card info", e);
            i = e.a();
            str = e.getMessage();
        }
        return new BaseResponse(i, str, new Object[0]);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.d.a.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, java.lang.String, int, java.lang.String, boolean):void
     arg types: [android.content.Context, com.miui.tsmclient.entity.CardInfo, java.lang.String, int, java.lang.String, int]
     candidates:
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand, com.miui.tsmclient.seitsm.TsmRpcModels$SeOperationType, boolean):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.d.a.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, java.lang.String, int, java.lang.String, boolean):void */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01fa, code lost:
        if (r15.getBoolean(r11) != false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019d, code lost:
        if (r15.getBoolean(r11) != false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b8, code lost:
        if (r15.getBoolean(r11) != false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01cc, code lost:
        if (r15.getBoolean(r11) != false) goto L_0x01d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01c8  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x0126=Splitter:B:52:0x0126, B:43:0x010e=Splitter:B:43:0x010e} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:87:0x01a5=Splitter:B:87:0x01a5, B:104:0x01dd=Splitter:B:104:0x01dd} */
    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        String str;
        String str2;
        MifareTag mifareTag;
        String str3;
        Bundle bundle2;
        h.a aVar;
        CardInfo cardInfo2;
        String str4;
        int i;
        Context context2 = context;
        CardInfo cardInfo3 = cardInfo;
        Bundle bundle3 = bundle;
        h.a aVar2 = h.a.INSTALL;
        MifareCardInfo mifareCardInfo = (MifareCardInfo) cardInfo3;
        int mifareCardType = mifareCardInfo.getMifareCardType();
        BaseResponse baseResponse = null;
        String str5 = "";
        if (bundle3 != null) {
            str3 = bundle3.getString("extra_door_card_product_id");
            String string = bundle3.getString("extra_mifare_door_card_issuer_token");
            mifareTag = (MifareTag) bundle3.getParcelable("extra_mifare_tag");
            str2 = string;
            str = bundle3.getString("extra_mifare_cpu_card_apply_channel");
        } else {
            mifareTag = null;
            str3 = str5;
            str2 = str3;
            str = str2;
        }
        String productId = TextUtils.isEmpty(str3) ? mifareCardInfo.getProductId() : str3;
        try {
            TsmRpcModels.TsmSessionInfo a2 = a(context2, cardInfo3, aVar2);
            if (d.get()) {
                baseResponse = a(context2, cardInfo3, a2, bundle3);
            }
            if (!d.get()) {
                MifareCardInfo mifareCardInfo2 = (MifareCardInfo) cardInfo3;
                String communityCode = mifareCardInfo2.getCommunityCode();
                String businessId = mifareCardInfo2.getBusinessId();
                String ticket = mifareCardInfo2.getTicket();
                boolean isOverWrite = mifareCardInfo2.isOverWrite();
                Bundle bundle4 = new Bundle();
                bundle4.putString("communityCode", communityCode);
                bundle4.putString("businessId", businessId);
                bundle4.putString("ticket", ticket);
                bundle4.putBoolean("overWrite", isOverWrite);
                TsmRpcModels.TsmAPDUCommand a3 = this.c.a(context, a2, productId, mifareTag, mifareCardType, str2, str, bundle4);
                if (a3 == null) {
                    d.set(true);
                    BaseResponse baseResponse2 = new BaseResponse(16, new Object[0]);
                    if (bundle3 == null || !bundle3.getBoolean("extras_key_session_not_finish")) {
                        h.a().a(cardInfo3, aVar2);
                    }
                    return baseResponse2;
                }
                int a4 = f.a(a3.getResult());
                if (a4 == 0) {
                    if (a3.getApdusList() != null) {
                        if (!a3.getApdusList().isEmpty()) {
                            IScTerminal terminal = cardInfo.getTerminal();
                            try {
                                terminal.open();
                                BaseResponse a5 = a(context2, terminal, a2, a3);
                                if (a5 == null || a5.mResultCode != 0) {
                                    aVar = aVar2;
                                    str4 = "extras_key_session_not_finish";
                                    bundle2 = bundle3;
                                    cardInfo2 = cardInfo3;
                                } else {
                                    aVar = aVar2;
                                    str4 = "extras_key_session_not_finish";
                                    bundle2 = bundle3;
                                    cardInfo2 = cardInfo3;
                                    try {
                                        a(context, cardInfo, a3.getAid(), mifareCardType, productId, true);
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                }
                                try {
                                    terminal.close();
                                    if (bundle2 == null || !bundle2.getBoolean(str4)) {
                                        h.a().a(cardInfo2, aVar);
                                    }
                                    return a5;
                                } catch (NfcEeIOException e) {
                                    e = e;
                                    LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                    i = 10;
                                    if (bundle2 != null) {
                                    }
                                    h.a().a(cardInfo2, aVar);
                                    return new BaseResponse(i, str5, new Object[0]);
                                } catch (IOException e2) {
                                    e = e2;
                                    i = 2;
                                    LogUtils.e("issue failed with an io exception.", e);
                                    if (bundle2 != null) {
                                    }
                                    h.a().a(cardInfo2, aVar);
                                    return new BaseResponse(i, str5, new Object[0]);
                                } catch (com.miui.tsmclient.seitsm.a.a e3) {
                                    e = e3;
                                    i = e.a();
                                    str5 = e.getMessage();
                                    LogUtils.e("issue failed with an tsmapi exception.", e);
                                    if (bundle2 != null) {
                                    }
                                    h.a().a(cardInfo2, aVar);
                                    return new BaseResponse(i, str5, new Object[0]);
                                } catch (InterruptedException e4) {
                                    e = e4;
                                    i = 11;
                                    try {
                                        LogUtils.e("issue is interrupted.", e);
                                        if (bundle2 != null) {
                                        }
                                        h.a().a(cardInfo2, aVar);
                                        return new BaseResponse(i, str5, new Object[0]);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        h.a().a(cardInfo2, aVar);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                aVar = aVar2;
                                str4 = "extras_key_session_not_finish";
                                bundle2 = bundle3;
                                cardInfo2 = cardInfo3;
                                terminal.close();
                                throw th;
                            }
                        }
                    }
                    h.a aVar3 = aVar2;
                    String str6 = "extras_key_session_not_finish";
                    Bundle bundle5 = bundle3;
                    CardInfo cardInfo4 = cardInfo3;
                    a(context, cardInfo, a3.getAid(), mifareCardType, productId, true);
                    BaseResponse baseResponse3 = new BaseResponse(0, new Object[0]);
                    if (bundle5 == null || !bundle5.getBoolean(str6)) {
                        h.a().a(cardInfo4, aVar3);
                    }
                    return baseResponse3;
                }
                aVar = aVar2;
                str4 = "extras_key_session_not_finish";
                bundle2 = bundle3;
                cardInfo2 = cardInfo3;
                throw new com.miui.tsmclient.seitsm.a.a(a4, a3.getErrorDesc());
            }
            h.a aVar4 = aVar2;
            String str7 = "extras_key_session_not_finish";
            Bundle bundle6 = bundle3;
            CardInfo cardInfo5 = cardInfo3;
            if (bundle6 == null || !bundle6.getBoolean(str7)) {
                h.a().a(cardInfo5, aVar4);
            }
            return baseResponse;
        } catch (NfcEeIOException e5) {
            e = e5;
            aVar = aVar2;
            str4 = "extras_key_session_not_finish";
            bundle2 = bundle3;
            cardInfo2 = cardInfo3;
            LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
            i = 10;
            if (bundle2 != null) {
            }
            h.a().a(cardInfo2, aVar);
            return new BaseResponse(i, str5, new Object[0]);
        } catch (IOException e6) {
            e = e6;
            aVar = aVar2;
            str4 = "extras_key_session_not_finish";
            bundle2 = bundle3;
            cardInfo2 = cardInfo3;
            i = 2;
            LogUtils.e("issue failed with an io exception.", e);
            if (bundle2 != null) {
            }
            h.a().a(cardInfo2, aVar);
            return new BaseResponse(i, str5, new Object[0]);
        } catch (com.miui.tsmclient.seitsm.a.a e7) {
            e = e7;
            aVar = aVar2;
            str4 = "extras_key_session_not_finish";
            bundle2 = bundle3;
            cardInfo2 = cardInfo3;
            i = e.a();
            str5 = e.getMessage();
            LogUtils.e("issue failed with an tsmapi exception.", e);
            if (bundle2 != null) {
            }
            h.a().a(cardInfo2, aVar);
            return new BaseResponse(i, str5, new Object[0]);
        } catch (InterruptedException e8) {
            e = e8;
            aVar = aVar2;
            str4 = "extras_key_session_not_finish";
            bundle2 = bundle3;
            cardInfo2 = cardInfo3;
            i = 11;
            LogUtils.e("issue is interrupted.", e);
            if (bundle2 != null) {
            }
            h.a().a(cardInfo2, aVar);
            return new BaseResponse(i, str5, new Object[0]);
        } catch (Throwable th4) {
            th = th4;
            aVar = aVar2;
            str4 = "extras_key_session_not_finish";
            bundle2 = bundle3;
            cardInfo2 = cardInfo3;
            if (bundle2 == null || !bundle2.getBoolean(str4)) {
                h.a().a(cardInfo2, aVar);
            }
            throw th;
        }
    }

    public BaseResponse a(Context context, MifareCardInfo mifareCardInfo) {
        try {
            this.f3875a.updateCommunityCardFlowStatus(context, mifareCardInfo);
            return new BaseResponse(0, new Object[0]);
        } catch (AuthApiException e) {
            LogUtils.d("updateCommunityCardFlowStatus failed ".concat(String.valueOf(e)));
            return new BaseResponse(e.mErrorCode, e.mErrorMsg, new Object[0]);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.d.a.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, java.lang.String, int, java.lang.String, boolean):void
     arg types: [android.content.Context, com.miui.tsmclient.entity.MifareCardInfo, java.lang.String, int, java.lang.String, int]
     candidates:
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand, com.miui.tsmclient.seitsm.TsmRpcModels$SeOperationType, boolean):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.d.a.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, java.lang.String, int, java.lang.String, boolean):void */
    public BaseResponse a(Context context, MifareCardInfo... mifareCardInfoArr) {
        int i;
        String str = "";
        try {
            TsmRpcModels.CommonResponse a2 = this.c.a(context, mifareCardInfoArr);
            if (a2 == null) {
                i = -1;
            } else {
                int a3 = f.a(a2.getResult());
                str = a2.getErrorDesc();
                LogUtils.d("updateMifareCardInfo result: ".concat(String.valueOf(a3)));
                i = a3;
            }
            if (mifareCardInfoArr != null && mifareCardInfoArr.length == 1) {
                a(context, (CardInfo) mifareCardInfoArr[0], mifareCardInfoArr[0].mAid, mifareCardInfoArr[0].getMifareCardType(), mifareCardInfoArr[0].getProductId(), false);
            }
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            LogUtils.e("failed to update mifare card info", e);
            i = e.a();
            str = e.getMessage();
        } catch (IOException e2) {
            i = 2;
            LogUtils.e("update failed with an io exception.", e2);
        }
        return new BaseResponse(i, str, new Object[0]);
    }
}
