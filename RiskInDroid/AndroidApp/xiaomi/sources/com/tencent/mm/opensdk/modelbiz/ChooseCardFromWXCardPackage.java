package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage {

    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        public boolean checkArgs() {
            String str;
            String str2;
            String str3 = this.appId;
            return str3 != null && str3.length() > 0 && (str = this.signType) != null && str.length() > 0 && (str2 = this.cardSign) != null && str2.length() > 0;
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
        }
    }

    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            String str = this.cardItemList;
            return (str == null || str.length() == 0) ? false : true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                Log.i("MicroMsg.ChooseCardFromWXCardPackage", "cardItemList is empty!");
            } else {
                this.cardItemList = string;
            }
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
        }
    }
}
