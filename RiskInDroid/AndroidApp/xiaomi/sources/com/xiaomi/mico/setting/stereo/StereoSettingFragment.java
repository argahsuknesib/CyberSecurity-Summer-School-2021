package com.xiaomi.mico.setting.stereo;

import _m_j.go;
import _m_j.jdb;
import _m_j.we;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
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
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.EmptyView;
import com.xiaomi.mico.module.update.UpdateAssistantActivity;
import com.xiaomi.mico.setting.stereo.StereoSettingFragment;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StereoSettingFragment extends MicoBaseFragment implements GroupedRecyclerViewAdapter.O00000Oo {
    @BindView(6179)
    EmptyView emptyView;
    public LanGroupAdapter lanGroupAdapter;
    @BindView(6702)
    Button nextBtn;
    @BindView(7134)
    RecyclerView recyclerView;
    private ArrayList<DeviceState> selectDeviceList;
    private int selectGroupIndex = -1;
    public List<StereoData.StereoGroup> stereoGroupList;
    @BindView(7136)
    TextView titleDescView;
    @BindView(7135)
    TextView titleView;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.activity_setting_stereo, viewGroup, false);
        ButterKnife.bind(this, inflate);
        this.nextBtn.setEnabled(false);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((go) this.recyclerView.getItemAnimator()).O0000o00 = false;
        this.selectDeviceList = new ArrayList<>(2);
        this.lanGroupAdapter = new LanGroupAdapter(getContext());
        this.lanGroupAdapter.setOnChildClickListener(this);
        this.recyclerView.setAdapter(this.lanGroupAdapter);
        return inflate;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            loadStereoGroup(true);
            return;
        }
        if (ContainerUtil.hasData(this.selectDeviceList)) {
            this.selectDeviceList.clear();
        }
        if (ContainerUtil.hasData(this.stereoGroupList)) {
            this.stereoGroupList.clear();
        }
        this.lanGroupAdapter.setGroups(null);
        this.nextBtn.setEnabled(false);
    }

    private void loadStereoGroup(boolean z) {
        if (z) {
            showProgressDialog(null);
        }
        ApiHelper.getMicoLanGroup("", "", "", new ApiRequest.Listener<MicoLanGroup>() {
            /* class com.xiaomi.mico.setting.stereo.StereoSettingFragment.AnonymousClass1 */

            public void onSuccess(MicoLanGroup micoLanGroup) {
                StereoSettingFragment.this.recyclerView.post(new Runnable(micoLanGroup) {
                    /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoSettingFragment$1$t_yd0kLHEv0yuCuHJhCIWm6gKs */
                    private final /* synthetic */ MicoLanGroup f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        StereoSettingFragment.AnonymousClass1.this.lambda$onSuccess$0$StereoSettingFragment$1(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$StereoSettingFragment$1(MicoLanGroup micoLanGroup) {
                StereoSettingFragment.this.dismissProgressDialog();
                MicoManager.getInstance().clearStereoData(false);
                PairedGroupInfo pairedGroupInfo = micoLanGroup.pairedGroupInfo;
                List<LanGroupInfo.LanGroup> groups = StereoSettingFragment.this.getGroups(micoLanGroup.lanGroupInfo.stereoLanList, pairedGroupInfo);
                if (groups.isEmpty()) {
                    StereoSettingFragment.this.recyclerView.setVisibility(8);
                    StereoSettingFragment.this.emptyView.setVisibility(0);
                    StereoSettingFragment.this.emptyView.setBackgroundRes(R.color.transparent);
                    StereoSettingFragment.this.emptyView.setEmptyMessage((int) R.string.setting_stereo_empty_desc);
                    StereoSettingFragment.this.emptyView.setIconResource(R.drawable.radio_empty);
                    return;
                }
                StereoSettingFragment.this.emptyView.setVisibility(8);
                StereoSettingFragment.this.recyclerView.setVisibility(0);
                StereoSettingFragment.this.lanGroupAdapter.setGroups(groups);
                if (pairedGroupInfo != null) {
                    StereoSettingFragment.this.stereoGroupList = pairedGroupInfo.stereoList;
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoSettingActivity loadStereoGroup: ".concat(String.valueOf(apiError));
                StereoSettingFragment.this.dismissProgressDialog();
                Toast.makeText(StereoSettingFragment.this.getContext(), (int) R.string.bind_device_error_write_wifi_resp_timeout, 1).show();
            }
        }).bindToLifecycle(this);
    }

    public List<LanGroupInfo.LanGroup> getGroups(List<LanGroupInfo.LanGroup> list, PairedGroupInfo pairedGroupInfo) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!(pairedGroupInfo == null || pairedGroupInfo.stereoList == null || pairedGroupInfo.stereoList.isEmpty())) {
            for (StereoData.StereoGroup next : pairedGroupInfo.stereoList) {
                if (next != null) {
                    arrayList2.add(next.leftDeviceId);
                    arrayList2.add(next.rightDeviceId);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            LanGroupInfo.LanGroup lanGroup = list.get(i);
            if (ContainerUtil.hasData(lanGroup.devices)) {
                for (String str : arrayList2) {
                    Iterator<DeviceState> it = lanGroup.devices.iterator();
                    while (it.hasNext()) {
                        DeviceState next2 = it.next();
                        if (str.equals(next2.deviceId)) {
                            it.remove();
                        }
                        if (next2.deviceName == null || next2.hardware == null) {
                            it.remove();
                        }
                    }
                }
                if (lanGroup.devices.size() > 0) {
                    arrayList.add(lanGroup);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d1 A[EDGE_INSN: B:26:0x00d1->B:20:0x00d1 ?: BREAK  , SYNTHETIC] */
    @OnClick({6702})
    public void onClickView(View view) {
        StereoData.StereoGroup stereoGroup = new StereoData.StereoGroup();
        boolean z = false;
        DeviceState deviceState = this.selectDeviceList.get(0);
        DeviceState deviceState2 = this.selectDeviceList.get(1);
        stereoGroup.groupName = getGroupName();
        stereoGroup.leftDeviceId = deviceState.deviceId;
        stereoGroup.leftDeviceHardware = deviceState.hardware;
        stereoGroup.leftDeviceResource = deviceState.resource;
        stereoGroup.leftDeviceName = deviceState.deviceName;
        Admin.Mico micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(deviceState.deviceId);
        stereoGroup.rightDeviceId = deviceState2.deviceId;
        stereoGroup.rightDeviceHardware = deviceState2.hardware;
        stereoGroup.rightDeviceResource = deviceState2.resource;
        stereoGroup.rightDeviceName = deviceState2.deviceName;
        Admin.Mico micoByDeviceId2 = MicoManager.getInstance().getMicoByDeviceId(deviceState2.deviceId);
        if ((!micoByDeviceId.hasCapability(MicoCapability.STEREO_MODE_V2) || micoByDeviceId2.hasCapability(MicoCapability.STEREO_MODE_V2)) && (micoByDeviceId.hasCapability(MicoCapability.STEREO_MODE_V2) || !micoByDeviceId2.hasCapability(MicoCapability.STEREO_MODE_V2))) {
            MultiRoomData.MultiRoomGroup multiRoomGroup = MicoManager.getInstance().getMultiRoomGroup();
            if (multiRoomGroup != null) {
                Iterator<MultiRoomData.MultiRoomMember> it = multiRoomGroup.members.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        MultiRoomData.MultiRoomMember next = it.next();
                        if (next.deviceId.equalsIgnoreCase(stereoGroup.leftDeviceId) || next.deviceId.equalsIgnoreCase(stereoGroup.rightDeviceId)) {
                            z = true;
                        }
                        if (!it.hasNext()) {
                            break;
                        }
                    }
                }
                z = true;
            }
            if (z) {
                ToastUtil.showToast((int) R.string.setting_stereo_cannot_create_stereo);
                return;
            }
            Intent intent = new Intent(getContext(), StereoChannelSettingActivity.class);
            intent.putExtra("stereo_channel_group", stereoGroup);
            startActivity(intent);
            return;
        }
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.common_hint).O00000Oo((int) R.string.setting_stereo_version_update_dialog_msg).O000000o((int) R.string.update, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoSettingFragment$uioXJyfLqb1xNmEo61VOiIvJcE */

            public final void onClick(DialogInterface dialogInterface, int i) {
                StereoSettingFragment.this.lambda$onClickView$0$StereoSettingFragment(dialogInterface, i);
            }
        }).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
    }

    public /* synthetic */ void lambda$onClickView$0$StereoSettingFragment(DialogInterface dialogInterface, int i) {
        getContext().startActivity(new Intent(getContext(), UpdateAssistantActivity.class));
    }

    public void onChildClick(GroupedRecyclerViewAdapter groupedRecyclerViewAdapter, we weVar, int i, int i2) {
        LanGroupInfo.LanGroup lanGroup = this.lanGroupAdapter.getGroups().get(i);
        int i3 = this.selectGroupIndex;
        boolean z = true;
        if (i3 == -1) {
            this.selectGroupIndex = i;
        } else if (i3 != i) {
            Toast.makeText(getContext(), (int) R.string.setting_stereo_select_toast_same_lan, 1).show();
            return;
        }
        DeviceState deviceState = lanGroup.devices.get(i2);
        String str = deviceState.hardware;
        DeviceState selectedDeviceState = this.lanGroupAdapter.getSelectedDeviceState();
        if (selectedDeviceState != null) {
            if (!Hardware.canSetupStereo(Hardware.safeValueOf(selectedDeviceState.hardware), Hardware.safeValueOf(str))) {
                return;
            }
        }
        if (deviceState.select) {
            deviceState.select = false;
            this.selectDeviceList.remove(deviceState);
            if (this.selectDeviceList.isEmpty()) {
                this.selectGroupIndex = -1;
                lanGroup.select = false;
                for (LanGroupInfo.LanGroup lanGroup2 : this.lanGroupAdapter.getGroups()) {
                    lanGroup2.selectState = 0;
                }
                this.lanGroupAdapter.setSelectedDeviceState(null);
            }
            groupedRecyclerViewAdapter.notifyDataChanged();
        } else if (this.selectDeviceList.size() < 2) {
            lanGroup.select = true;
            deviceState.select = true;
            for (LanGroupInfo.LanGroup lanGroup3 : this.lanGroupAdapter.getGroups()) {
                lanGroup3.selectState = 2;
            }
            lanGroup.selectState = 1;
            this.lanGroupAdapter.setSelectedDeviceState(deviceState);
            groupedRecyclerViewAdapter.notifyDataChanged();
            this.selectDeviceList.add(deviceState);
        } else {
            ToastUtil.showToast((int) R.string.setting_stereo_select_toast_too_many_devices);
        }
        Button button = this.nextBtn;
        if (this.selectDeviceList.size() < 2) {
            z = false;
        }
        button.setEnabled(z);
    }

    private String getGroupName() {
        String string = getString(R.string.setting_stereo_group);
        if (!ContainerUtil.hasData(this.stereoGroupList)) {
            return string;
        }
        if (this.stereoGroupList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < this.stereoGroupList.size(); i2++) {
                StereoData.StereoGroup stereoGroup = this.stereoGroupList.get(i2);
                if (stereoGroup.groupName.equals(getString(R.string.setting_stereo_group))) {
                    z = true;
                } else if (stereoGroup.groupName.length() > getString(R.string.setting_stereo_group).length() && stereoGroup.groupName.substring(0, getString(R.string.setting_stereo_group).length()).equals(getString(R.string.setting_stereo_group))) {
                    String substring = stereoGroup.groupName.substring(getString(R.string.setting_stereo_group).length());
                    if (jdb.O000000o(substring)) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(substring)));
                    }
                }
            }
            if (ContainerUtil.hasData(arrayList)) {
                Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
                Arrays.sort(numArr);
                int intValue = numArr[numArr.length - 1].intValue();
                while (true) {
                    if (i >= numArr.length - 1) {
                        i = intValue;
                        break;
                    }
                    int i3 = i + 1;
                    if (numArr[i].intValue() + 1 < numArr[i3].intValue()) {
                        i = numArr[i].intValue();
                        break;
                    }
                    i = i3;
                }
            }
            if (z) {
                return getString(R.string.setting_stereo_group).concat(String.valueOf(i + 1));
            }
        }
        return getString(R.string.setting_stereo_group);
    }
}
