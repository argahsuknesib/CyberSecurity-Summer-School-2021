package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.hid;
import _m_j.ixe;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "", "()V", "DeviceRoomState", "ErrorState", "LoadingState", "LogoutState", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$LoadingState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$LogoutState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$ErrorState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$DeviceRoomState;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DeviceRoomRenderState {
    public /* synthetic */ DeviceRoomRenderState(byte b) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$LoadingState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LoadingState extends DeviceRoomRenderState {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final LoadingState f10364O000000o = new LoadingState();

        private LoadingState() {
            super((byte) 0);
        }
    }

    private DeviceRoomRenderState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$LogoutState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LogoutState extends DeviceRoomRenderState {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final LogoutState f10365O000000o = new LogoutState();

        private LogoutState() {
            super((byte) 0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$ErrorState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ErrorState extends DeviceRoomRenderState {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final ErrorState f10363O000000o = new ErrorState();

        private ErrorState() {
            super((byte) 0);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState$DeviceRoomState;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "home", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "rooms", "", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/RoomRenderData;", "scenes", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "freqCameras", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "(Lcom/xiaomi/smarthome/homeroom/model/Home;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getFreqCameras", "()Ljava/util/List;", "getHome", "()Lcom/xiaomi/smarthome/homeroom/model/Home;", "getRooms", "getScenes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DeviceRoomState extends DeviceRoomRenderState {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Home f10362O000000o;
        public final List<hid> O00000Oo;
        public final List<MainCameraCardModel> O00000o;
        public final List<CommonUsedScene> O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeviceRoomState)) {
                return false;
            }
            DeviceRoomState deviceRoomState = (DeviceRoomState) obj;
            return ixe.O000000o(this.f10362O000000o, deviceRoomState.f10362O000000o) && ixe.O000000o(this.O00000Oo, deviceRoomState.O00000Oo) && ixe.O000000o(this.O00000o0, deviceRoomState.O00000o0) && ixe.O000000o(this.O00000o, deviceRoomState.O00000o);
        }

        public final int hashCode() {
            Home home = this.f10362O000000o;
            return ((((((home == null ? 0 : home.hashCode()) * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + this.O00000o.hashCode();
        }

        public final String toString() {
            return "DeviceRoomState(home=" + this.f10362O000000o + ", rooms=" + this.O00000Oo + ", scenes=" + this.O00000o0 + ", freqCameras=" + this.O00000o + ')';
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.List<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.List<? extends com.xiaomi.smarthome.scene.bean.CommonUsedScene>] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        public DeviceRoomState(Home home, List<hid> list, List<? extends CommonUsedScene> r4, List<MainCameraCardModel> list2) {
            super((byte) 0);
            ixe.O00000o(list, "rooms");
            ixe.O00000o(r4, "scenes");
            ixe.O00000o(list2, "freqCameras");
            this.f10362O000000o = home;
            this.O00000Oo = list;
            this.O00000o0 = r4;
            this.O00000o = list2;
        }
    }
}
