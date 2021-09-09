package com.miui.tsmclient.sesdk;

import com.miui.tsmclient.entity.UncompletedBusiness;
import java.util.List;

public class UncompletedOrderList {
    private List<UncompletedOrder> mList;

    public static class UncompletedOrder {
        private UncompletedBusiness mUncompletedBusiness;

        UncompletedOrder(UncompletedBusiness uncompletedBusiness, SeCard seCard) {
            this.mUncompletedBusiness = uncompletedBusiness;
            if (uncompletedBusiness.getOrderInfo() != null) {
                seCard.setCityId(uncompletedBusiness.getOrderInfo().mCityId);
            }
        }

        public String getAid() {
            return this.mUncompletedBusiness.getAid();
        }

        public String getRechargeToken() {
            return this.mUncompletedBusiness.getRechargeToken();
        }

        public String getToken() {
            return this.mUncompletedBusiness.getToken();
        }

        public int getType() {
            return this.mUncompletedBusiness.getType();
        }

        public String getUserIdMismatchDesc() {
            return this.mUncompletedBusiness.getUserIdMismatchDesc();
        }

        public boolean isOutSource() {
            return !this.mUncompletedBusiness.isInWalletBusiness();
        }
    }

    UncompletedOrderList(List<UncompletedOrder> list) {
        this.mList = list;
    }

    public List<UncompletedOrder> getList() {
        return this.mList;
    }

    public boolean isEmpty() {
        List<UncompletedOrder> list = this.mList;
        return list != null && list.isEmpty();
    }
}
