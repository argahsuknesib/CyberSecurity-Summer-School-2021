package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/newui/CommonMainPageReceivers;", "", "()V", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class gzq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18638O000000o = new O000000o((byte) 0);
    public static final hne O00000Oo;
    public static final hne O00000o;
    public static final hne O00000o0;
    public static final hne O00000oO;
    public static final hne O00000oo;
    public static final hne O0000O0o;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/newui/CommonMainPageReceivers$Companion;", "", "()V", "dropMenuSelectedChanged", "Lcom/xiaomi/smarthome/rx_receiver/BroadcastReceiverObservable;", "getDropMenuSelectedChanged$annotations", "getDropMenuSelectedChanged", "()Lcom/xiaomi/smarthome/rx_receiver/BroadcastReceiverObservable;", "homeChangeObservable", "getHomeChangeObservable$annotations", "getHomeChangeObservable", "localeChanged", "getLocaleChanged$annotations", "getLocaleChanged", "mainCameraEditModeChanged", "getMainCameraEditModeChanged$annotations", "getMainCameraEditModeChanged", "mainCardEditModeChanged", "getMainCardEditModeChanged$annotations", "getMainCardEditModeChanged", "mainSceneEditModeChanged", "getMainSceneEditModeChanged$annotations", "getMainSceneEditModeChanged", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    static {
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        O00000Oo = new hne("home_room_home_changed", application);
        CommonApplication application2 = CommonApplication.getApplication();
        ixe.O00000Oo(application2, "getApplication()");
        O00000o0 = new hne("main_action_room_selected", application2);
        CommonApplication application3 = CommonApplication.getApplication();
        ixe.O00000Oo(application3, "getApplication()");
        O00000o = new hne("main_action_card_edit_mode_changed", application3);
        CommonApplication application4 = CommonApplication.getApplication();
        ixe.O00000Oo(application4, "getApplication()");
        O00000oO = new hne("main_action_scene_edit_mode_changed", application4);
        CommonApplication application5 = CommonApplication.getApplication();
        ixe.O00000Oo(application5, "getApplication()");
        O00000oo = new hne("main_action_camera_edit_mode_changed", application5);
        CommonApplication application6 = CommonApplication.getApplication();
        ixe.O00000Oo(application6, "getApplication()");
        O0000O0o = new hne("action_locale_changed", application6);
    }

    public static final hne O000000o() {
        return O00000o;
    }

    public static final hne O00000Oo() {
        return O00000oO;
    }

    public static final hne O00000o0() {
        return O00000oo;
    }
}
