package com.xiaomi.mico.music.player.multiroom;

import _m_j.go;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.DeviceState;
import com.xiaomi.mico.api.model.LanGroupInfo;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.MultiRoomData;
import com.xiaomi.mico.api.model.PairedGroupInfo;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.recyclerview.itemdecoration.ItemDecorationHelper;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.music.player.multiroom.MultiRoomDeviceAdapter;
import com.xiaomi.mico.music.player.multiroom.MultiRoomView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiasuhuei321.loadingdialog.view.LoadCircleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiRoomView extends LinearLayout {
    public int action = 0;
    @BindView(5959)
    Button cancelBtn;
    public boolean clickToast = false;
    MultiRoomDeviceAdapter mAdapter;
    public MLAlertDialog mDialog;
    private Gson mGson;
    private OnMultiRoomBottomBtnClick mListener;
    @BindView(6669)
    LoadCircleView mLoading;
    @BindView(6668)
    RecyclerView mRecyclerView;
    private ApiRequest mRequest;
    MultiRoomData.MultiRoomGroup mRoomGroup;
    @BindView(6729)
    Button okBtn;
    private List<StereoData.StereoGroup> stereoGroupList;

    public interface OnMultiRoomBottomBtnClick {
        void onCancelClick();

        void onOkClick();
    }

    public void setListener(OnMultiRoomBottomBtnClick onMultiRoomBottomBtnClick) {
        this.mListener = onMultiRoomBottomBtnClick;
    }

    public MultiRoomView(Context context) {
        super(context);
    }

    public MultiRoomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MultiRoomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        initDevicesList();
    }

    @OnClick({6729, 5959})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ok_btn) {
            if (this.clickToast) {
                ToastUtil.showToast((int) R.string.multi_room_disable_toast);
                return;
            }
            OnMultiRoomBottomBtnClick onMultiRoomBottomBtnClick = this.mListener;
            if (onMultiRoomBottomBtnClick != null) {
                onMultiRoomBottomBtnClick.onOkClick();
            }
            List<DeviceState> list = this.mAdapter.getList();
            ArrayList arrayList = new ArrayList();
            int i = this.action;
            if (i == 0) {
                MultiRoomData.MultiRoomGroup multiRoomGroup = this.mRoomGroup;
                if (multiRoomGroup == null || multiRoomGroup.members.isEmpty()) {
                    MultiRoomData.MultiRoomGroup multiRoomGroup2 = new MultiRoomData.MultiRoomGroup();
                    multiRoomGroup2.groupSwitch = 1;
                    buildMultiGroupMemberInfo(list, arrayList, null);
                    multiRoomGroup2.members = arrayList;
                    if (arrayList.isEmpty()) {
                        MLAlertDialog mLAlertDialog = this.mDialog;
                        if (mLAlertDialog != null) {
                            mLAlertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                    createMultiRoom(true, multiRoomGroup2);
                    return;
                }
                MLAlertDialog mLAlertDialog2 = this.mDialog;
                if (mLAlertDialog2 != null) {
                    mLAlertDialog2.dismiss();
                }
            } else if (i == 1) {
                ArrayList arrayList2 = new ArrayList();
                buildMultiGroupMemberInfo(list, arrayList, arrayList2);
                MultiRoomData.MultiRoomGroup multiRoomGroup3 = this.mRoomGroup;
                multiRoomGroup3.members = arrayList;
                updateMultiRoom(true, multiRoomGroup3, arrayList2);
            } else if (i == 2) {
                ArrayList arrayList3 = new ArrayList();
                List<StereoData.StereoGroup> list2 = this.stereoGroupList;
                if (list2 != null) {
                    for (StereoData.StereoGroup next : list2) {
                        initGson();
                        MultiRoomData.MultiRoomMember multiRoomMember = new MultiRoomData.MultiRoomMember();
                        multiRoomMember.deviceId = next.leftDeviceId;
                        multiRoomMember.name = next.leftDeviceName;
                        multiRoomMember.hardWare = next.leftDeviceHardware;
                        multiRoomMember.resource = next.leftDeviceResource;
                        arrayList3.add(this.mGson.toJson(multiRoomMember));
                        MultiRoomData.MultiRoomMember multiRoomMember2 = new MultiRoomData.MultiRoomMember();
                        multiRoomMember2.deviceId = next.rightDeviceId;
                        multiRoomMember2.name = next.rightDeviceName;
                        multiRoomMember2.hardWare = next.rightDeviceHardware;
                        multiRoomMember2.resource = next.rightDeviceResource;
                        arrayList3.add(this.mGson.toJson(multiRoomMember2));
                    }
                }
                deleteMultiRoom(true, this.mRoomGroup, arrayList3);
            }
        } else if (id == R.id.cancel_btn) {
            OnMultiRoomBottomBtnClick onMultiRoomBottomBtnClick2 = this.mListener;
            if (onMultiRoomBottomBtnClick2 != null) {
                onMultiRoomBottomBtnClick2.onCancelClick();
            }
            this.mRequest.cancel();
            hideLoading();
            MLAlertDialog mLAlertDialog3 = this.mDialog;
            if (mLAlertDialog3 != null) {
                mLAlertDialog3.dismiss();
            }
        }
    }

    private void buildMultiGroupMemberInfo(List<DeviceState> list, List<MultiRoomData.MultiRoomMember> list2, List<String> list3) {
        List<StereoData.StereoGroup> list4;
        for (DeviceState next : list) {
            if (next.select) {
                if (TextUtils.isEmpty(next.stereoJson)) {
                    MultiRoomData.MultiRoomMember multiRoomMember = new MultiRoomData.MultiRoomMember();
                    multiRoomMember.deviceId = next.deviceId;
                    multiRoomMember.name = next.deviceName;
                    multiRoomMember.hardWare = next.hardware;
                    multiRoomMember.resource = next.resource;
                    list2.add(multiRoomMember);
                } else {
                    List<StereoData.StereoGroup> list5 = this.stereoGroupList;
                    if (list5 != null) {
                        for (StereoData.StereoGroup next2 : list5) {
                            if (next.stereoJson.equals(next2.groupId)) {
                                MultiRoomData.MultiRoomMember multiRoomMember2 = new MultiRoomData.MultiRoomMember();
                                multiRoomMember2.deviceId = next2.leftDeviceId;
                                multiRoomMember2.name = next2.leftDeviceName;
                                multiRoomMember2.hardWare = next2.leftDeviceHardware;
                                multiRoomMember2.resource = next2.leftDeviceResource;
                                list2.add(multiRoomMember2);
                                MultiRoomData.MultiRoomMember multiRoomMember3 = new MultiRoomData.MultiRoomMember();
                                multiRoomMember3.deviceId = next2.rightDeviceId;
                                multiRoomMember3.name = next2.rightDeviceName;
                                multiRoomMember3.hardWare = next2.rightDeviceHardware;
                                multiRoomMember3.resource = next2.rightDeviceResource;
                                list2.add(multiRoomMember3);
                            }
                        }
                    }
                }
            } else if (!(TextUtils.isEmpty(next.stereoJson) || (list4 = this.stereoGroupList) == null || list3 == null)) {
                for (StereoData.StereoGroup next3 : list4) {
                    if (next.stereoJson.equals(next3.groupId)) {
                        initGson();
                        MultiRoomData.MultiRoomMember multiRoomMember4 = new MultiRoomData.MultiRoomMember();
                        multiRoomMember4.deviceId = next3.leftDeviceId;
                        multiRoomMember4.name = next3.leftDeviceName;
                        multiRoomMember4.hardWare = next3.leftDeviceHardware;
                        multiRoomMember4.resource = next3.leftDeviceResource;
                        list3.add(this.mGson.toJson(multiRoomMember4));
                        MultiRoomData.MultiRoomMember multiRoomMember5 = new MultiRoomData.MultiRoomMember();
                        multiRoomMember5.deviceId = next3.rightDeviceId;
                        multiRoomMember5.name = next3.rightDeviceName;
                        multiRoomMember5.hardWare = next3.rightDeviceHardware;
                        multiRoomMember5.resource = next3.rightDeviceResource;
                        list3.add(this.mGson.toJson(multiRoomMember5));
                    }
                }
            }
        }
    }

    private void initDevicesList() {
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((go) this.mRecyclerView.getItemAnimator()).O0000o00 = false;
        this.mRecyclerView.addItemDecoration(ItemDecorationHelper.listDivider(getContext(), 0, 0, null));
        this.mAdapter = new MultiRoomDeviceAdapter(getContext());
        this.mAdapter.setOnItemClickListener(new MultiRoomDeviceAdapter.OnItemClickListener() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView.AnonymousClass1 */

            public void onItemClicked(DeviceState deviceState, int i, List<DeviceState> list) {
                List<DeviceState> list2 = MultiRoomView.this.mAdapter.getList();
                boolean z = true;
                if (MultiRoomView.this.mRoomGroup == null) {
                    int i2 = 0;
                    for (DeviceState deviceState2 : list2) {
                        if (deviceState2.select) {
                            i2++;
                        }
                    }
                    MultiRoomView multiRoomView = MultiRoomView.this;
                    if (i2 >= 2) {
                        z = false;
                    }
                    multiRoomView.clickToast = z;
                    MultiRoomView.this.action = 0;
                } else if (list.size() < 2) {
                    MultiRoomView multiRoomView2 = MultiRoomView.this;
                    multiRoomView2.action = 2;
                    multiRoomView2.clickToast = false;
                } else {
                    MultiRoomView multiRoomView3 = MultiRoomView.this;
                    multiRoomView3.action = 1;
                    multiRoomView3.clickToast = false;
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    @Deprecated
    private void initOkBtnStatus() {
        boolean z;
        MultiRoomData.MultiRoomGroup multiRoomGroup = this.mRoomGroup;
        boolean z2 = false;
        if (multiRoomGroup != null) {
            Iterator<MultiRoomData.MultiRoomMember> it = multiRoomGroup.members.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().unKnownError) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.action = 2;
                this.okBtn.setEnabled(true);
                this.mAdapter.setItemClickEnable(false);
                ToastUtil.showToast("出现了硬件恢复出厂造成的脏数据，点击确定删除旧组合");
                return;
            }
            Button button = this.okBtn;
            if (this.mAdapter.getItemCount() > 1) {
                z2 = true;
            }
            button.setEnabled(z2);
            return;
        }
        z = false;
        if (!z) {
        }
    }

    public void show(MLAlertDialog mLAlertDialog) {
        this.mDialog = mLAlertDialog;
        MLAlertDialog mLAlertDialog2 = this.mDialog;
        if (mLAlertDialog2 != null) {
            mLAlertDialog2.show();
        }
        getMultiRoom(true, "", false);
    }

    public boolean isShowing() {
        MLAlertDialog mLAlertDialog = this.mDialog;
        if (mLAlertDialog != null) {
            return mLAlertDialog.isShowing();
        }
        return false;
    }

    private void showLoading() {
        this.mLoading.setVisibility(0);
    }

    public void hideLoading() {
        this.mLoading.setVisibility(8);
    }

    public void getMultiRoom(boolean z, String str, final boolean z2) {
        if (z) {
            showLoading();
        }
        this.mRequest = ApiHelper.getMicoLanGroup("", "", str, new ApiRequest.Listener<MicoLanGroup>() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView.AnonymousClass2 */

            public void onSuccess(MicoLanGroup micoLanGroup) {
                if (!z2) {
                    MultiRoomView.this.setMultiRoomData(micoLanGroup);
                } else {
                    MultiRoomView.this.mRecyclerView.post(new Runnable() {
                        /* class com.xiaomi.mico.music.player.multiroom.$$Lambda$MultiRoomView$2$HArXoGgiKcqu_hOl9cvsSXU8Y5U */

                        public final void run() {
                            MultiRoomView.AnonymousClass2.this.lambda$onSuccess$0$MultiRoomView$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$MultiRoomView$2() {
                MultiRoomView.this.hideLoading();
                if (MultiRoomView.this.mDialog != null) {
                    MultiRoomView.this.mDialog.dismiss();
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "MultiRoomView getMultiRoom onFailure ".concat(String.valueOf(apiError));
                if (!z2) {
                    MultiRoomView.this.setMultiRoomData(null);
                    ToastUtil.showToast("加载失败 ".concat(String.valueOf(apiError)));
                    return;
                }
                MultiRoomView.this.mRecyclerView.post(new Runnable() {
                    /* class com.xiaomi.mico.music.player.multiroom.$$Lambda$MultiRoomView$2$v9eGsGDyVwDEOVeAO5oiVWj25HY */

                    public final void run() {
                        MultiRoomView.AnonymousClass2.this.lambda$onFailure$1$MultiRoomView$2();
                    }
                });
            }

            public /* synthetic */ void lambda$onFailure$1$MultiRoomView$2() {
                MultiRoomView.this.hideLoading();
                if (MultiRoomView.this.mDialog != null) {
                    MultiRoomView.this.mDialog.dismiss();
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x01eb  */
    public void setMultiRoomData(MicoLanGroup micoLanGroup) {
        StereoData.StereoGroup next;
        MultiRoomData multiRoomData;
        ArrayList<DeviceState> arrayList = new ArrayList<>();
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        boolean z = true;
        if (micoLanGroup != null) {
            PairedGroupInfo pairedGroupInfo = micoLanGroup.pairedGroupInfo;
            if (!(pairedGroupInfo == null || (multiRoomData = pairedGroupInfo.multiRoom) == null || multiRoomData.groups == null || multiRoomData.groups.isEmpty())) {
                this.mRoomGroup = multiRoomData.groups.get(0);
            }
            LanGroupInfo lanGroupInfo = micoLanGroup.lanGroupInfo;
            if (lanGroupInfo != null) {
                LanGroupInfo.LanGroup lanGroup = null;
                Iterator<LanGroupInfo.LanGroup> it = lanGroupInfo.multiRoomLanList.iterator();
                loop0:
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LanGroupInfo.LanGroup next2 = it.next();
                    int size = next2.devices.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (next2.devices.get(i).deviceId.equalsIgnoreCase(currentMico.deviceID)) {
                                lanGroup = next2;
                                break loop0;
                            }
                            i++;
                        }
                    }
                }
                if (lanGroup != null) {
                    this.stereoGroupList = (List) GsonUtil.getGsonInstance().fromJson(MicoManager.getInstance().getStereoGroupJson(), new TypeToken<List<StereoData.StereoGroup>>() {
                        /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView.AnonymousClass3 */
                    }.getType());
                    List<DeviceState> list = lanGroup.devices;
                    ArrayList arrayList2 = new ArrayList();
                    for (DeviceState next3 : list) {
                        List<StereoData.StereoGroup> list2 = this.stereoGroupList;
                        if (list2 != null) {
                            Iterator<StereoData.StereoGroup> it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                next = it2.next();
                                if (next == null || (!next3.deviceId.equalsIgnoreCase(next.leftDeviceId) && !next3.deviceId.equalsIgnoreCase(next.rightDeviceId))) {
                                }
                            }
                            if (next3.deviceId.equalsIgnoreCase(next.leftDeviceId)) {
                                arrayList2.add(next3.deviceId);
                            }
                        }
                        if (next3.deviceId.equalsIgnoreCase(currentMico.deviceID)) {
                            arrayList.add(0, next3);
                        } else {
                            arrayList.add(next3);
                        }
                    }
                    MultiRoomData.MultiRoomGroup multiRoomGroup = this.mRoomGroup;
                    if (multiRoomGroup != null) {
                        List<MultiRoomData.MultiRoomMember> list3 = multiRoomGroup.members;
                        List<StereoData.StereoGroup> list4 = this.stereoGroupList;
                        if (list4 != null) {
                            for (StereoData.StereoGroup next4 : list4) {
                                Iterator<MultiRoomData.MultiRoomMember> it3 = list3.iterator();
                                while (it3.hasNext()) {
                                    MultiRoomData.MultiRoomMember next5 = it3.next();
                                    if (next5.deviceId.equalsIgnoreCase(next4.leftDeviceId) || next5.deviceId.equalsIgnoreCase(next4.rightDeviceId)) {
                                        next4.select = true;
                                        it3.remove();
                                    }
                                }
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList<MultiRoomData.MultiRoomMember> arrayList4 = new ArrayList<>();
                        arrayList4.addAll(list3);
                        Iterator it4 = arrayList4.iterator();
                        while (it4.hasNext()) {
                            MultiRoomData.MultiRoomMember multiRoomMember = (MultiRoomData.MultiRoomMember) it4.next();
                            for (DeviceState deviceState : arrayList) {
                                if (multiRoomMember.deviceId.equalsIgnoreCase(deviceState.deviceId)) {
                                    it4.remove();
                                }
                            }
                        }
                        for (MultiRoomData.MultiRoomMember convert : arrayList4) {
                            arrayList3.add(DeviceState.convert(convert));
                        }
                        arrayList.addAll(arrayList3);
                        for (MultiRoomData.MultiRoomMember next6 : list3) {
                            Iterator it5 = arrayList.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                DeviceState deviceState2 = (DeviceState) it5.next();
                                if (next6.deviceId.equalsIgnoreCase(deviceState2.deviceId)) {
                                    deviceState2.select = true;
                                    deviceState2.unKnownError = next6.unKnownError;
                                    break;
                                }
                            }
                        }
                    }
                    List<StereoData.StereoGroup> list5 = this.stereoGroupList;
                    if (list5 != null) {
                        for (StereoData.StereoGroup next7 : list5) {
                            if (arrayList2.contains(next7.leftDeviceId)) {
                                DeviceState deviceState3 = new DeviceState();
                                deviceState3.hardware = next7.leftDeviceHardware;
                                deviceState3.deviceName = next7.groupName;
                                deviceState3.stereoJson = next7.groupId;
                                deviceState3.select = next7.select;
                                arrayList.add(deviceState3);
                            }
                        }
                    }
                    if (!z) {
                        DeviceState deviceState4 = new DeviceState();
                        deviceState4.hardware = currentMico.hardware;
                        deviceState4.deviceName = currentMico.name;
                        deviceState4.select = false;
                        arrayList.add(deviceState4);
                    }
                    this.mRecyclerView.post(new Runnable(arrayList) {
                        /* class com.xiaomi.mico.music.player.multiroom.$$Lambda$MultiRoomView$IL2UcJ8hT2eDqho8uKXKbh47b4 */
                        private final /* synthetic */ List f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            MultiRoomView.this.lambda$setMultiRoomData$0$MultiRoomView(this.f$1);
                        }
                    });
                }
            }
        }
        z = false;
        if (!z) {
        }
        this.mRecyclerView.post(new Runnable(arrayList) {
            /* class com.xiaomi.mico.music.player.multiroom.$$Lambda$MultiRoomView$IL2UcJ8hT2eDqho8uKXKbh47b4 */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MultiRoomView.this.lambda$setMultiRoomData$0$MultiRoomView(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$setMultiRoomData$0$MultiRoomView(List list) {
        hideLoading();
        this.okBtn.setEnabled(true);
        this.mAdapter.setList(list);
        ViewGroup.LayoutParams layoutParams = this.mRecyclerView.getLayoutParams();
        if (this.mAdapter.getList().size() > 2) {
            layoutParams.height = DisplayUtils.dip2px(getContext(), 200.0f);
        } else if (this.mAdapter.getList().size() < 2) {
            layoutParams.height = DisplayUtils.dip2px(getContext(), 70.0f);
        } else {
            layoutParams.height = DisplayUtils.dip2px(getContext(), 145.0f);
        }
        this.mRecyclerView.setLayoutParams(layoutParams);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    private void createMultiRoom(boolean z, MultiRoomData.MultiRoomGroup multiRoomGroup) {
        if (z) {
            showLoading();
        }
        initGson();
        this.mRequest = ApiHelper.createMultiRoomGroup(this.mGson.toJson(multiRoomGroup), new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView.AnonymousClass4 */

            public void onSuccess(String str) {
                MultiRoomView.this.getMultiRoom(false, "", true);
            }

            public void onFailure(ApiError apiError) {
                MultiRoomView.this.hideLoading();
            }
        });
    }

    private void updateMultiRoom(boolean z, final MultiRoomData.MultiRoomGroup multiRoomGroup, List<String> list) {
        if (z) {
            showLoading();
        }
        initGson();
        multiRoomGroup.server = "";
        this.mRequest = ApiHelper.updateMultiRoomGroup(multiRoomGroup.groupId, this.mGson.toJson(multiRoomGroup), list, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView.AnonymousClass5 */

            public void onSuccess(Boolean bool) {
                MultiRoomView.this.hideLoading();
                MicoManager.getInstance().saveMultiRoomJson(GsonUtil.getGsonInstance().toJson(multiRoomGroup));
                if (MultiRoomView.this.mDialog != null) {
                    MultiRoomView.this.mDialog.dismiss();
                }
            }

            public void onFailure(ApiError apiError) {
                MultiRoomView.this.hideLoading();
            }
        });
    }

    private void initGson() {
        if (this.mGson == null) {
            this.mGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        }
    }

    private void deleteMultiRoom(boolean z, MultiRoomData.MultiRoomGroup multiRoomGroup, List<String> list) {
        if (z) {
            showLoading();
        }
        this.mRequest = ApiHelper.deleteMultiRoomGroup(multiRoomGroup.groupId, list, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView.AnonymousClass6 */

            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    MicoManager.getInstance().clearMultiRoomJson();
                    MicoManager.getInstance().setMultiRoomGroup(null);
                    PlayerManager.getInstance().setQueryDeviceId(MicoManager.getInstance().getCurrentMicoID());
                }
                MultiRoomView.this.hideLoading();
                if (MultiRoomView.this.mDialog != null) {
                    MultiRoomView.this.mDialog.dismiss();
                }
            }

            public void onFailure(ApiError apiError) {
                MultiRoomView.this.hideLoading();
            }
        });
    }
}
