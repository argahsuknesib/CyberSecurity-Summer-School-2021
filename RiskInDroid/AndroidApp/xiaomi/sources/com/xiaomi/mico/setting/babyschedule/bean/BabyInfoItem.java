package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.common.util.ContainerUtil;
import java.util.List;

public class BabyInfoItem implements BabyScheduleItem {
    public ThirdPartyResponse.ChildProfile childProfile;

    public interface ChildrenProfileLoadListener {
        void onChildrenProfileLoad();
    }

    public int getItemType() {
        return 1;
    }

    public void handleItemClick(Context context, int i) {
    }

    public BabyInfoItem(ChildrenProfileLoadListener childrenProfileLoadListener) {
        loadData(childrenProfileLoadListener);
    }

    private void loadData(final ChildrenProfileLoadListener childrenProfileLoadListener) {
        ApiHelper.getChildrenProfile(new ApiRequest.Listener<List<ThirdPartyResponse.ChildProfile>>() {
            /* class com.xiaomi.mico.setting.babyschedule.bean.BabyInfoItem.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<ThirdPartyResponse.ChildProfile>) ((List) obj));
            }

            public void onSuccess(List<ThirdPartyResponse.ChildProfile> list) {
                if (!ContainerUtil.isEmpty(list)) {
                    BabyInfoItem.this.childProfile = list.get(0);
                    childrenProfileLoadListener.onChildrenProfileLoad();
                }
            }
        });
    }

    public void setChildProfile(ThirdPartyResponse.ChildProfile childProfile2) {
        this.childProfile = childProfile2;
    }

    public ThirdPartyResponse.ChildProfile getChildProfile() {
        return this.childProfile;
    }
}
