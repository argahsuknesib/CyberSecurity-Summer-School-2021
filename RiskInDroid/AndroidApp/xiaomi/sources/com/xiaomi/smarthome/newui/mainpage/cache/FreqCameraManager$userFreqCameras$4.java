package com.xiaomi.smarthome.newui.mainpage.cache;

import _m_j.fno;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class FreqCameraManager$userFreqCameras$4 extends Lambda implements iwc<MainCameraCardModel, String> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final FreqCameraManager$userFreqCameras$4 f10248O000000o = new FreqCameraManager$userFreqCameras$4();

    FreqCameraManager$userFreqCameras$4() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        MainCameraCardModel mainCameraCardModel = (MainCameraCardModel) obj;
        ixe.O00000o(mainCameraCardModel, "it");
        Device O000000o2 = fno.O000000o().O000000o(mainCameraCardModel.f10175O000000o);
        String str = O000000o2 == null ? null : O000000o2.orderTimeJString;
        return str == null ? mainCameraCardModel.f10175O000000o : str;
    }
}
