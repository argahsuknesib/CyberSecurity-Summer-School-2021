package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.ToastUtil;
import java.util.Arrays;
import java.util.List;

public class SettingSchemaHandler extends TabSchemaHandler {
    private static final List<String> SUPPORT_PATHS = Arrays.asList("/ota", "/qq_music_account", "/alarm", "/alarm_build", "/children_profile", "/location", "/mesh");

    /* access modifiers changed from: protected */
    public String authority() {
        return "settings";
    }

    /* access modifiers changed from: protected */
    public String tabKey() {
        return "settings";
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    /* access modifiers changed from: protected */
    public List<String> supportPaths() {
        return SUPPORT_PATHS;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void doProcess(Context context, String str, Uri uri) {
        char c;
        switch (str.hashCode()) {
            case -2127282319:
                if (str.equals("/alarm_build")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1620405149:
                if (str.equals("/qq_music_account")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1444937500:
                if (str.equals("/location")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1363811944:
                if (str.equals("/children_profile")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1510541:
                if (str.equals("/ota")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 46753436:
                if (str.equals("/mesh")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1438465922:
                if (str.equals("/alarm")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2128184064:
                if (str.equals("/music_auth_status")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                ToastUtil.showToast("TODO SettingSchemaHandler ota");
                return;
            case 1:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_QQ_MUSIC_ACCOUNT");
                return;
            case 2:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_ALARM");
                return;
            case 3:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_ALARM_BUILD");
                return;
            case 4:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_CHILDREN_PROFILE");
                return;
            case 5:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_MUSIC_AUTH_INFO");
                return;
            case 6:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_LOCATION");
                return;
            case 7:
                ToastUtil.showToast("TODO SettingSchemaHandler PATH_MESH");
                uri.getQueryParameter("uid");
                String queryParameter = uri.getQueryParameter("did");
                if (queryParameter != null) {
                    MicoManager.getInstance().selectMicoByMiotDID(queryParameter);
                }
                LoginManager.getInstance().getPassportInfo().getUserId();
                return;
            default:
                return;
        }
    }
}
