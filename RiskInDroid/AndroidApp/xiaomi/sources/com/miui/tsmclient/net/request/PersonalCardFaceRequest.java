package com.miui.tsmclient.net.request;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PersonalCardFace;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;

public class PersonalCardFaceRequest extends SecureRequest<PersonalCardFaceResponseInfo> {
    private CardInfo mCardInfo;

    public static final class PersonalCardFaceResponseInfo extends CommonResponseInfo {
        @SerializedName("data")
        private PersonalCardFace mPresonalCardFace;

        public final PersonalCardFace getPresonalCardFace() {
            return this.mPresonalCardFace;
        }
    }

    public PersonalCardFaceRequest(CardInfo cardInfo) {
        super(1, "api/%s/spcard/queryPersonalCardFace", PersonalCardFaceResponseInfo.class, (ResponseListener) null);
        this.mCardInfo = cardInfo;
        addParams("cardName", this.mCardInfo.mCardType);
        if (!TextUtils.isEmpty(this.mCardInfo.mAreaCode)) {
            LogUtils.v("mAreaCode " + this.mCardInfo.mAreaCode);
            addParams("areaCode", this.mCardInfo.mAreaCode);
        }
    }

    public void addExtraParams() throws IOException {
        try {
            addParams("cplc", this.mCardInfo.getTerminal().getCPLC());
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("QueryCouponsRequest getExtraParams failed", e);
        }
    }
}
