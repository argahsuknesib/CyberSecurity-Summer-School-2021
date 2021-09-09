package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class MainReactPackage extends TurboReactPackage {
    private MainPackageConfig mConfig;

    public MainReactPackage() {
    }

    public MainReactPackage(MainPackageConfig mainPackageConfig) {
        this.mConfig = mainPackageConfig;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        char c;
        switch (str.hashCode()) {
            case -2115067288:
                if (str.equals("ToastAndroid")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -2033388651:
                if (str.equals("AsyncSQLiteDBStorage")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1962922905:
                if (str.equals("ImageStoreManager")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -1850625090:
                if (str.equals("SoundManager")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -1654566518:
                if (str.equals("DialogManagerAndroid")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -1505215509:
                if (str.equals("CameraRollManager")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1399423980:
                if (str.equals("TimePickerAndroid")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -1344126773:
                if (str.equals("FileReaderModule")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1062061717:
                if (str.equals("PermissionsAndroid")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -657277650:
                if (str.equals("ImageLoader")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case -570370161:
                if (str.equals("I18nManager")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -457866500:
                if (str.equals("AccessibilityInfo")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -382654004:
                if (str.equals("StatusBarManager")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -254310125:
                if (str.equals("WebSocketModule")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 163245714:
                if (str.equals("FrescoModule")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case 174691539:
                if (str.equals("DatePickerAndroid")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 283572496:
                if (str.equals("ImageEditingManager")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 403570038:
                if (str.equals("Clipboard")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 563961875:
                if (str.equals("IntentAndroid")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1221389072:
                if (str.equals("AppState")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1515242260:
                if (str.equals("Networking")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1547941001:
                if (str.equals("BlobModule")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1555425035:
                if (str.equals("ShareModule")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1721274886:
                if (str.equals("NativeAnimatedModule")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1922110066:
                if (str.equals("Vibration")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        ImagePipelineConfig imagePipelineConfig = null;
        switch (c) {
            case 0:
                return new AccessibilityInfoModule(reactApplicationContext);
            case 1:
                return new AppStateModule(reactApplicationContext);
            case 2:
                return new BlobModule(reactApplicationContext);
            case 3:
                return new FileReaderModule(reactApplicationContext);
            case 4:
                return new AsyncStorageModule(reactApplicationContext);
            case 5:
                return new CameraRollManager(reactApplicationContext);
            case 6:
                return new ClipboardModule(reactApplicationContext);
            case 7:
                return new DatePickerDialogModule(reactApplicationContext);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return new DialogModule(reactApplicationContext);
            case 9:
                MainPackageConfig mainPackageConfig = this.mConfig;
                if (mainPackageConfig != null) {
                    imagePipelineConfig = mainPackageConfig.getFrescoConfig();
                }
                return new FrescoModule(reactApplicationContext, true, imagePipelineConfig);
            case 10:
                return new I18nManagerModule(reactApplicationContext);
            case 11:
                return new ImageEditingManager(reactApplicationContext);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return new ImageLoaderModule(reactApplicationContext);
            case 13:
                return new ImageStoreManager(reactApplicationContext);
            case 14:
                return new IntentModule(reactApplicationContext);
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return new NativeAnimatedModule(reactApplicationContext);
            case 16:
                return new NetworkingModule(reactApplicationContext);
            case 17:
                return new PermissionsModule(reactApplicationContext);
            case 18:
                return new ShareModule(reactApplicationContext);
            case 19:
                return new StatusBarModule(reactApplicationContext);
            case 20:
                return new SoundManagerModule(reactApplicationContext);
            case 21:
                return new TimePickerDialogModule(reactApplicationContext);
            case 22:
                return new ToastModule(reactApplicationContext);
            case 23:
                return new VibrationModule(reactApplicationContext);
            case 24:
                return new WebSocketModule(reactApplicationContext);
            default:
                return null;
        }
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ARTRenderableViewManager.createARTGroupViewManager());
        arrayList.add(ARTRenderableViewManager.createARTShapeViewManager());
        arrayList.add(ARTRenderableViewManager.createARTTextViewManager());
        arrayList.add(new ReactCheckBoxManager());
        arrayList.add(new ReactDialogPickerManager());
        arrayList.add(new ReactDrawerLayoutManager());
        arrayList.add(new ReactDropdownPickerManager());
        arrayList.add(new ReactHorizontalScrollViewManager());
        arrayList.add(new ReactHorizontalScrollContainerViewManager());
        arrayList.add(new ReactProgressBarViewManager());
        arrayList.add(new ReactScrollViewManager());
        arrayList.add(new ReactSliderManager());
        arrayList.add(new ReactSwitchManager());
        arrayList.add(new SwipeRefreshLayoutManager());
        arrayList.add(new ARTSurfaceViewManager());
        arrayList.add(new FrescoBasedReactTextInlineImageViewManager());
        arrayList.add(new ReactImageManager());
        arrayList.add(new ReactModalHostManager());
        arrayList.add(new ReactRawTextManager());
        arrayList.add(new ReactTextInputManager());
        arrayList.add(new ReactTextViewManager());
        arrayList.add(new ReactViewManager());
        arrayList.add(new ReactViewPagerManager());
        arrayList.add(new ReactVirtualTextViewManager());
        return arrayList;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.MainReactPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AccessibilityInfoModule.class, AppStateModule.class, BlobModule.class, FileReaderModule.class, AsyncStorageModule.class, CameraRollManager.class, ClipboardModule.class, DatePickerDialogModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageEditingManager.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, TimePickerDialogModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
            final HashMap hashMap = new HashMap();
            for (int i = 0; i < 25; i++) {
                Class cls = clsArr[i];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), false));
            }
            return new ReactModuleInfoProvider() {
                /* class com.facebook.react.shell.MainReactPackage.AnonymousClass1 */

                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        }
    }
}
