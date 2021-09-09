package com.miui.tsmclient.sesdk;

import android.os.Looper;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.common.net.Response;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.c;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.net.request.j;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeyCardArt {
    private SeCard mSeCard;

    public static class Art {
        public c.a mArtInfo;

        private Art(c.a aVar) {
            this.mArtInfo = aVar;
        }

        public String getUrl() {
            return this.mArtInfo.b();
        }

        public boolean isValid() {
            return this.mArtInfo.c();
        }
    }

    public static class ArtList {
        private List<Art> mArtInfoList;

        private ArtList(List<Art> list) {
            this.mArtInfoList = list;
        }

        public List<Art> getArtInfoList() {
            return this.mArtInfoList;
        }

        public boolean isEmpty() {
            List<Art> list = this.mArtInfoList;
            if (list == null) {
                return false;
            }
            return list.isEmpty();
        }
    }

    public KeyCardArt(SeCard seCard) {
        this.mSeCard = seCard;
    }

    private void ensureNotOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to anr");
        }
    }

    public BaseResponse getArtList() {
        ensureNotOnMainThread();
        BaseResponse baseResponse = new BaseResponse();
        try {
            com.miui.tsmclient.net.request.c cVar = new com.miui.tsmclient.net.request.c(((MifareCardInfo) this.mSeCard.mCardInfo).getProductId(), null);
            Response execute = HttpClient.getInstance(EnvironmentConfig.getContext()).execute(cVar);
            if (execute.getResult() == null) {
                baseResponse.mResultCode = -1;
                baseResponse.mMsg = "failed to getArtList";
                return baseResponse;
            }
            if (cVar.isSuccess()) {
                ArrayList arrayList = new ArrayList();
                for (c.a art : ((c) execute.getResult()).a()) {
                    arrayList.add(new Art(art));
                }
                ArtList artList = new ArtList(arrayList);
                LogUtils.d("getCardFaceList success");
                baseResponse.mDatas = new Object[]{artList};
                baseResponse.mResultCode = 0;
            }
            return baseResponse;
        } catch (IOException e) {
            LogUtils.e("getCardFaceList AuthApiException: " + e.getMessage());
            baseResponse.mResultCode = -1;
            baseResponse.mMsg = "failed to getArtList";
        }
    }

    public BaseResponse setArt(Art art) {
        String str = "failed to updateArt";
        ensureNotOnMainThread();
        int i = -1;
        try {
            Response execute = HttpClient.getInstance(EnvironmentConfig.getContext()).execute(new j((MifareCardInfo) this.mSeCard.mCardInfo, art.mArtInfo));
            if (execute.getResult() == null) {
                str = "";
            } else {
                String errorDesc = ((CommonResponseInfo) execute.getResult()).getErrorDesc();
                if (execute.isSuccess()) {
                    LogUtils.d("updateArt success");
                    this.mSeCard.setCardFace(art.mArtInfo.b());
                    str = errorDesc;
                    i = 0;
                } else {
                    int errorCode = ((CommonResponseInfo) execute.getResult()).getErrorCode();
                    LogUtils.d("updateArt fail");
                    i = errorCode;
                    str = errorDesc;
                }
            }
        } catch (IOException e) {
            LogUtils.e(str, e);
        }
        return new BaseResponse(i, str, new Object[0]);
    }
}
