package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class hz extends Enum<hz> {
    public static final hz A = new hz("SyncMIID", 26, "sync_miid");
    public static final hz B = new hz("UploadTinyData", 27, "upload");
    public static final hz C = new hz("CancelPushMessage", 28, "clear_push_message");
    public static final hz D = new hz("CancelPushMessageACK", 29, "clear_push_message_ack");
    public static final hz E = new hz("DisablePushMessage", 30, "disable_push");
    public static final hz F = new hz("EnablePushMessage", 31, "enable_push");
    public static final hz G = new hz("ClientABTest", 32, "client_ab_test");
    public static final hz H = new hz("AwakeSystemApp", 33, "awake_system_app");
    public static final hz I = new hz("AwakeAppResponse", 34, "awake_app_response");
    public static final hz J = new hz("HybridRegister", 35, "hb_register");
    public static final hz K = new hz("HybridRegisterResult", 36, "hb_register_res");
    public static final hz L = new hz("HybridUnregister", 37, "hb_unregister");
    public static final hz M = new hz("HybridUnregisterResult", 38, "hb_unregister_res");
    public static final hz N = new hz("ThirdPartyRegUpdate", 39, "3rd_party_reg_update");
    public static final hz O = new hz("VRUpload", 40, "vr_upload");
    public static final hz P = new hz("PushLogUpload", 41, "log_upload");
    public static final hz Q = new hz("APP_WAKEUP", 42, "app_wakeup");
    public static final hz R = new hz("APP_SLEEP", 43, "app_sleep");
    public static final hz S = new hz("NOTIFICATION_SWITCH", 44, "notification_switch");
    public static final hz T = new hz("ACTIVITY_RESUMED", 45, "activity_resumed");
    public static final hz U = new hz("HeadsUpReporter", 46, "headsup_reporter");
    public static final hz V = new hz("ScenePushRuleUpdate", 47, "scene_push_rule_update");
    public static final hz W = new hz("ScenePushRuleDelete", 48, "scene_push_rule_delete");
    public static final hz X = new hz("ScenePushRuleTrigger", 49, "scene_push_rule_trigger");
    public static final hz Y = new hz("NotificationRemoved", 50, "notification_removed");
    public static final hz Z = new hz("NotificationArrived", 51, "notification_arrived");

    /* renamed from: a  reason: collision with root package name */
    public static final hz f6403a = new hz("Invalid", 0, "INVALID");

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ hz[] f69a = a();
    public static final hz aa = new hz("NotificationClicked", 52, "notification_clicked");
    public static final hz ab = new hz("PullDownPop", 53, "pull_down_pop");
    public static final hz ac = new hz("AppDataCleared", 54, "app_data_cleared");
    public static final hz ad = new hz("TtsReporter", 55, "tts_data_reporter");
    public static final hz ae = new hz("SDK_START_ACTIVITY", 56, "sdk_start_activity");
    public static final hz af = new hz("DetectAppAlive", 57, "detect_app_alive");
    public static final hz ag = new hz("DetectAppAliveResult", 58, "detect_app_alive_result");
    public static final hz b = new hz("BarClick", 1, "bar:click");
    public static final hz c = new hz("BarCancel", 2, "bar:cancel");
    public static final hz d = new hz("AppOpen", 3, "app:open");
    public static final hz e = new hz("PackageUninstall", 4, "package uninstalled");
    public static final hz f = new hz("AppUninstall", 5, "app_uninstalled");
    public static final hz g = new hz("ClientInfoUpdate", 6, "client_info_update");
    public static final hz h = new hz("ClientInfoUpdateOk", 7, "client_info_update_ok");
    public static final hz i = new hz("ClientMIIDUpdate", 8, "client_miid_update");
    public static final hz j = new hz("PullOfflineMessage", 9, "pull");
    public static final hz k = new hz("IosSleep", 10, "ios_sleep");
    public static final hz l = new hz("IosWakeUp", 11, "ios_wakeup");
    public static final hz m = new hz("AwakeApp", 12, "awake_app");
    public static final hz n = new hz("NormalClientConfigUpdate", 13, "normal_client_config_update");
    public static final hz o = new hz("CustomClientConfigUpdate", 14, "custom_client_config_update");
    public static final hz p = new hz("DailyCheckClientConfig", 15, "daily_check_client_config");
    public static final hz q = new hz("DataCollection", 16, "data_collection");
    public static final hz r = new hz("RegIdExpired", 17, "registration id expired");
    public static final hz s = new hz("ConnectionDisabled", 18, "!!!MILINK CONNECTION DISABLED!!!");
    public static final hz t = new hz("PackageUnregistered", 19, "package_unregistered");
    public static final hz u = new hz("DecryptMessageFail", 20, "decrypt_msg_fail");
    public static final hz v = new hz("SyncInfo", 21, "sync_info");
    public static final hz w = new hz("SyncInfoResult", 22, "sync_info_result");
    public static final hz x = new hz("ForceSync", 23, "force_sync");
    public static final hz y = new hz("UploadClientLog", 24, "upload_client_log");
    public static final hz z = new hz("NotificationBarInfo", 25, "notification_bar_info");

    /* renamed from: a  reason: collision with other field name */
    public final String f70a;

    private hz(String str, int i2, String str2) {
        this.f70a = str2;
    }

    private static /* synthetic */ hz[] a() {
        return new hz[]{f6403a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag};
    }

    public static hz valueOf(String str) {
        return (hz) Enum.valueOf(hz.class, str);
    }

    public static hz[] values() {
        return (hz[]) f69a.clone();
    }

    public final String toString() {
        return this.f70a;
    }
}
