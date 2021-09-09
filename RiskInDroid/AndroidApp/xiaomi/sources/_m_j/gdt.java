package _m_j;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import io.reactivex.Observable;
import org.json.JSONObject;

public interface gdt {
    fsn O000000o(Context context, String str, String str2, fsm<JSONObject, fso> fsm);

    Observable<String> O000000o(ServerBean serverBean);

    String O000000o(ReadableMap readableMap);

    String O000000o(String str) throws RemoteException;

    String O000000o(String str, String str2, String str3, boolean z, String str4);

    void O000000o();

    void O000000o(Activity activity, String str) throws RemoteException;

    void O000000o(String str, int i, gdw<String> gdw);

    void O000000o(String str, gdw<String> gdw);

    void O000000o(String str, DeviceStat deviceStat, int i, String str2, MessageCallback messageCallback);

    void O000000o(String str, MiServiceTokenInfo miServiceTokenInfo, MessageCallback messageCallback);

    WritableMap O00000Oo(ReadableMap readableMap);

    String O00000Oo(String str) throws RemoteException;

    void O00000Oo() throws RemoteException;

    Home O00000o(String str) throws RemoteException;

    void O00000o();

    String O00000o0(String str);

    boolean O00000o0();

    Room O00000oO(String str) throws RemoteException;

    void O00000oO();

    boolean O00000oo();
}
