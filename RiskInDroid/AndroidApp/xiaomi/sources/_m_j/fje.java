package _m_j;

import android.net.Uri;
import android.os.Parcel;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.server.internal.device.DeviceRecord;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class fje {
    static byte[] O000000o(List<Device> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            Device device = list.get(i);
            if (device != null) {
                obtain.writeParcelable(device, 0);
            }
        }
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    private static List<Device> O000000o(Parcel parcel) {
        if (parcel == null) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerStoreHelper", "parseParcel parcel is null");
            return new ArrayList();
        }
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            Device device = (Device) parcel.readParcelable(Device.class.getClassLoader());
            if (device != null) {
                arrayList.add(device);
            }
        }
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000Oo(logType, "DeviceManagerStoreHelper", "parseParcel " + arrayList.size());
        parcel.recycle();
        return arrayList;
    }

    static List<Device> O000000o(File file) {
        try {
            byte[] O00000o0 = gsc.O00000o0(CommonApplication.getAppContext(), Uri.fromFile(file));
            if (O00000o0 != null) {
                return O000000o(fkw.O000000o(O00000o0));
            }
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerStoreHelper", "getLocalStoredDevicesFromParcelFile data is null");
            return new ArrayList();
        } catch (Exception e) {
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "DeviceManagerStoreHelper", "getLocalStoredDevicesFromParcelFile exception " + e.getMessage());
            e.printStackTrace();
            return new ArrayList();
        }
    }

    static List<Device> O000000o() {
        List<DeviceRecord> queryAllByUserId = DeviceRecord.queryAllByUserId(fcn.O000000o().O00000Oo());
        ArrayList arrayList = new ArrayList(queryAllByUserId.size());
        for (DeviceRecord O000000o2 : queryAllByUserId) {
            Device O000000o3 = fjb.O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000Oo(logType, "DeviceManagerStoreHelper", "getLocalStoredDevicesFromDB " + arrayList.size());
        return arrayList;
    }

    static String O000000o(String str) {
        return CommonApplication.getAppContext().getFilesDir() + File.separator + "device" + File.separator + "cache" + File.separator + "device_list_" + gpp.O000000o(str);
    }
}
