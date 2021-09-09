package com.xiaomi.smarthome.device.api;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.bluetooth.BleUpgrader;
import com.xiaomi.smarthome.bluetooth.IBleUpgradeController;
import com.xiaomi.smarthome.bluetooth.ISlideBtnController;
import java.util.ArrayList;
import java.util.List;

public interface IXmPluginHostActivity {

    public static abstract class AsyncCallback<T> {
        public abstract void onFailure(int i, Object obj);

        public abstract void onSuccess(T t);
    }

    public enum BarcodeFormat {
        AZTEC,
        CODABAR,
        CODE_39,
        CODE_93,
        CODE_128,
        DATA_MATRIX,
        EAN_8,
        EAN_13,
        ITF,
        MAXICODE,
        PDF_417,
        QR_CODE,
        RSS_14,
        RSS_EXPANDED,
        UPC_A,
        UPC_E,
        UPC_EAN_EXTENSION
    }

    public interface DeviceFindCallback {
        void onDeviceFind(List<DeviceStat> list);
    }

    public static abstract class MenuItemBase implements Parcelable {
    }

    FragmentActivity activity();

    void addToLauncher();

    void clickHotSpotAd(String str);

    void enableAd();

    void enableBlackTranslucentStatus();

    void enableVerifyPincode();

    void enableWhiteTranslucentStatus();

    Intent getActivityIntent(String str, String str2);

    void getDeviceRecommendScenes(String str, AsyncCallback<List<RecommendSceneItem>> asyncCallback);

    List<SceneInfo> getSceneByDid(String str);

    void goBleUpdateActivity(Intent intent, BleUpgrader bleUpgrader);

    void goUpdateActivity();

    void goUpdateActivity(String str);

    boolean isTranslucentStatusbarEnable();

    void loadWebView(String str, String str2);

    void modifySceneName(SceneInfo sceneInfo, AsyncCallback<Void> asyncCallback);

    void onDeviceReady(String str, String str2);

    void openAddIRController(DeviceStat deviceStat);

    void openAddIRController(DeviceStat deviceStat, int i, String str);

    void openAddIRController(DeviceStat deviceStat, int i, String[] strArr, Bundle bundle);

    void openBtGatewayActivity(String str);

    void openCloudVideoExoPlayerActivity(String str, String str2, String str3);

    void openCloudVideoListActivity(String str, String str2);

    void openCloudVideoPlayerActivity(String str, String str2, String str3);

    void openCloudVideoWebActivity(String str, String str2, String str3);

    void openDevice(String str, Intent intent);

    void openFaceEmptyActivity(String str);

    void openFaceManagerActivity(int i, String str, String str2);

    void openFaceManagerActivity(String str);

    void openFeedbackActivity();

    void openGatewaySubDeviceList(String str);

    void openHelpActivity();

    void openMarkFaceDialog(String str, String str2, FaceManagerCallback faceManagerCallback);

    @Deprecated
    void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<MenuItemBase> arrayList, boolean z, String str, int i, Intent intent);

    void openMoreMenu(String str, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i);

    void openMoreMenu(ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i);

    void openMoreMenu(ArrayList<MenuItemBase> arrayList, boolean z, int i);

    void openMoreMenu(ArrayList<MenuItemBase> arrayList, boolean z, int i, Intent intent);

    void openMoreMenu2(ArrayList<MenuItemBase> arrayList, boolean z, int i, Intent intent);

    void openMoreMenu2(ArrayList<MenuItemBase> arrayList, boolean z, int i, Intent intent, Intent intent2);

    void openNetworkInfoActivity(String str);

    void openOneTimePasswordActivity(String str, int i, int i2);

    void openOpHistoryActivity();

    void openPowerSwitchNameActivity(String str, String str2);

    void openRechargePage(int i, double d, double d2);

    void openReplaceFaceDialog(String str, String str2, String str3, String str4, FaceManagerCallback faceManagerCallback);

    void openScanBarcodePage(Bundle bundle, int i);

    void openSceneActivity(String str);

    void openScreenDeviceLinkageSettingActivity(String str, boolean z);

    void openScreenDeviceLinkageSettingActivity(String str, boolean z, int i, String str2);

    void openShareActivity();

    void openShareDeviceActivity();

    void openShareMediaActivity(String str, String str2, String str3);

    void openShareMediaActivity(String str, String str2, String str3, Bitmap bitmap);

    void openShareMediaActivity(String str, String str2, String str3, Bitmap bitmap, String str4, Bitmap bitmap2);

    void openSharePictureActivity(String str, String str2, String str3);

    void openShareVideoActivity(String str, String str2, String str3);

    void openShopActivity(String str);

    void openVirtualGroupInitActivity(String str, int i);

    void openWxBindActivity(int i);

    void overridePendingTransition(String str, String str2);

    void reportHotSpotAdShow(String str);

    void setSceneEnabled(SceneInfo sceneInfo, boolean z, AsyncCallback<Void> asyncCallback);

    void setTitleBarPadding(View view);

    void share(String str, String str2, String str3, String str4, String str5, Bitmap bitmap);

    void showBannerAd(ViewGroup viewGroup, String str);

    void showNoticeAd(ViewGroup viewGroup, String str);

    void showUseDefaultLicenseDialog(String str, View.OnClickListener onClickListener);

    @Deprecated
    void showUserLicenseDialog(String str, String str2, Spanned spanned, String str3, Spanned spanned2, View.OnClickListener onClickListener);

    void showUserLicenseDialog(String str, String str2, Spanned spanned, String str3, Spanned spanned2, View.OnClickListener onClickListener, Intent intent);

    @Deprecated
    void showUserLicenseDialog(String str, String str2, String str3, View.OnClickListener onClickListener);

    void showUserLicenseHtmlDialog(String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener);

    void showUserLicenseUriDialog(String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener);

    void showUserLicenseUriDialog(String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, Intent intent);

    void startActivityForResult(Intent intent, String str, String str2, int i);

    void startAddRoom();

    void startCreateSceneByDid(String str);

    void startEditCustomScene();

    void startEditRecommendScenes(RecommendSceneItem recommendSceneItem, String str, String str2);

    @Deprecated
    void startEditScene(int i);

    void startEditScene(String str);

    void startLoadScene();

    void startLoadScene(AsyncCallback asyncCallback);

    void startRecommendSceneDetailActivityBy(String str, int i);

    void startSearchNewDevice(String str, String str2, DeviceFindCallback deviceFindCallback);

    void startSetTimerCountDown(String str, String str2, String str3, String str4, String str5, boolean z);

    @Deprecated
    void startSetTimerList(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void startSetTimerList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void startSetTimerListV2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11);

    void startSetTimerListV3(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void startSetTimerListV3(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11);

    public static class StringMenuItem extends MenuItemBase {
        public static final Parcelable.Creator<StringMenuItem> CREATOR = new Parcelable.Creator<StringMenuItem>() {
            /* class com.xiaomi.smarthome.device.api.IXmPluginHostActivity.StringMenuItem.AnonymousClass1 */

            public final StringMenuItem createFromParcel(Parcel parcel) {
                return new StringMenuItem(parcel);
            }

            public final StringMenuItem[] newArray(int i) {
                return new StringMenuItem[i];
            }
        };
        public String name;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
        }

        public StringMenuItem(Parcel parcel) {
            this.name = parcel.readString();
        }

        public StringMenuItem() {
        }
    }

    public static class InfoMenuItem extends MenuItemBase {
        public static final Parcelable.Creator<InfoMenuItem> CREATOR = new Parcelable.Creator<InfoMenuItem>() {
            /* class com.xiaomi.smarthome.device.api.IXmPluginHostActivity.InfoMenuItem.AnonymousClass1 */

            public final InfoMenuItem createFromParcel(Parcel parcel) {
                return new InfoMenuItem(parcel);
            }

            public final InfoMenuItem[] newArray(int i) {
                return new InfoMenuItem[i];
            }
        };
        public String name;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
        }

        public InfoMenuItem(Parcel parcel) {
            this.name = parcel.readString();
        }

        public InfoMenuItem() {
        }
    }

    public static class IntentMenuItem extends MenuItemBase {
        public static final Parcelable.Creator<IntentMenuItem> CREATOR = new Parcelable.Creator<IntentMenuItem>() {
            /* class com.xiaomi.smarthome.device.api.IXmPluginHostActivity.IntentMenuItem.AnonymousClass1 */

            public final IntentMenuItem createFromParcel(Parcel parcel) {
                return new IntentMenuItem(parcel);
            }

            public final IntentMenuItem[] newArray(int i) {
                return new IntentMenuItem[i];
            }
        };
        public boolean goBuyVip;
        public Intent intent;
        public String name;

        public int describeContents() {
            return 0;
        }

        public IntentMenuItem() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeParcelable(this.intent, i);
            parcel.writeByte(this.goBuyVip ? (byte) 1 : 0);
        }

        protected IntentMenuItem(Parcel parcel) {
            this.name = parcel.readString();
            this.intent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.goBuyVip = parcel.readByte() != 0;
        }
    }

    public static class SlideBtnMenuItem extends MenuItemBase {
        public static final Parcelable.Creator<SlideBtnMenuItem> CREATOR = new Parcelable.Creator<SlideBtnMenuItem>() {
            /* class com.xiaomi.smarthome.device.api.IXmPluginHostActivity.SlideBtnMenuItem.AnonymousClass1 */

            public final SlideBtnMenuItem createFromParcel(Parcel parcel) {
                return new SlideBtnMenuItem(parcel);
            }

            public final SlideBtnMenuItem[] newArray(int i) {
                return new SlideBtnMenuItem[i];
            }
        };
        public ISlideBtnController controller;
        public boolean isClicked = false;
        public boolean isOn;
        public String name;
        public String offMethod;
        public String offParams;
        public String onMethod;
        public String onParams;
        public String subName;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.onMethod);
            parcel.writeString(this.onParams);
            parcel.writeString(this.offMethod);
            parcel.writeString(this.offParams);
            parcel.writeInt(this.isOn ? 1 : 0);
            parcel.writeString(this.subName);
            if (this.controller != null) {
                parcel.writeInt(1);
                parcel.writeStrongBinder(this.controller.asBinder());
                return;
            }
            parcel.writeInt(0);
        }

        public SlideBtnMenuItem(Parcel parcel) {
            boolean z = false;
            this.name = parcel.readString();
            this.onMethod = parcel.readString();
            this.onParams = parcel.readString();
            this.offMethod = parcel.readString();
            this.offParams = parcel.readString();
            this.isOn = parcel.readInt() == 1 ? true : z;
            this.subName = parcel.readString();
            if (parcel.readInt() != 0) {
                this.controller = ISlideBtnController.Stub.asInterface(parcel.readStrongBinder());
            }
        }

        public SlideBtnMenuItem() {
        }
    }

    public static class BleMenuItem extends MenuItemBase {
        public static final Parcelable.Creator<BleMenuItem> CREATOR = new Parcelable.Creator<BleMenuItem>() {
            /* class com.xiaomi.smarthome.device.api.IXmPluginHostActivity.BleMenuItem.AnonymousClass1 */

            public final BleMenuItem createFromParcel(Parcel parcel) {
                return new BleMenuItem(parcel);
            }

            public final BleMenuItem[] newArray(int i) {
                return new BleMenuItem[i];
            }
        };
        public Intent intent;
        public String key;

        public int describeContents() {
            return 0;
        }

        @Deprecated
        public void setHasNewerVersion(boolean z) {
        }

        public BleMenuItem() {
            this.intent = new Intent();
        }

        public static BleMenuItem newUpgraderItem(BleUpgrader bleUpgrader) {
            BleMenuItem bleMenuItem = new BleMenuItem();
            bleMenuItem.key = "key_firmware_click";
            bleMenuItem.setUpgrader(bleUpgrader);
            return bleMenuItem;
        }

        private void setUpgrader(BleUpgrader bleUpgrader) {
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 18) {
                bundle.putBinder("extra_upgrade_controller", bleUpgrader);
            }
            this.intent.putExtras(bundle);
        }

        public IBleUpgradeController getBleUpgrader() {
            Bundle extras = this.intent.getExtras();
            IBinder binder = (extras == null || Build.VERSION.SDK_INT < 18) ? null : extras.getBinder("extra_upgrade_controller");
            if (binder != null) {
                return IBleUpgradeController.Stub.asInterface(binder);
            }
            return null;
        }

        public BleMenuItem(Parcel parcel) {
            this.key = parcel.readString();
            this.intent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.key);
            parcel.writeParcelable(this.intent, i);
        }
    }
}
