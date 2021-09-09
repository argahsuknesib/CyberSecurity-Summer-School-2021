package _m_j;

import android.os.RemoteException;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Map;

public final class fjy extends hvm {
    public final String O000000o() {
        return CoreApi.O000000o().O0000o0();
    }

    public final PluginDeviceInfo O000000o(String str) {
        return CoreApi.O000000o().O00000oO(str);
    }

    public final void O000000o(String str, int i) {
        try {
            CoreApi.O000000o().O00000Oo().beginProcess(str, i);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final String O000000o(int i) {
        return CoreApi.O000000o().O00000o0(i);
    }

    public final void O000000o(String str, String str2) {
        try {
            CoreApi.O000000o().O00000Oo().addProcessContext(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final int O00000Oo(int i) {
        return CoreApi.O000000o().O00000o(i);
    }

    public final void O00000Oo(String str, String str2) {
        try {
            CoreApi.O000000o().O00000Oo().addContextToCurrentAction(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O00000o0(String str, String str2) {
        try {
            CoreApi.O000000o().O00000Oo().appendContextToCurrentAction(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O000000o(int i, String str, String str2) {
        try {
            CoreApi.O000000o().O00000Oo().addContextToActionById(i, str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O00000Oo(int i, String str, String str2) {
        try {
            CoreApi.O000000o().O00000Oo().addContextByActionCode(i, str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O00000o0(int i) {
        try {
            CoreApi.O000000o().O00000Oo().finishCurrentAction(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O000000o(int i, Map<String, String> map) {
        try {
            CoreApi.O000000o().O00000Oo().finishCurrentActionWithContext(i, map);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O000000o(int i, int i2) {
        try {
            CoreApi.O000000o().O00000Oo().updateActionResultById(i, i2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void O00000Oo(int i, int i2) {
        try {
            CoreApi.O000000o().O00000Oo().updateActionResultByCode(i, i2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }
}
