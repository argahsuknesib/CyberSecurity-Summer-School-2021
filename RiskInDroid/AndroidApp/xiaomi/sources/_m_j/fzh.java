package _m_j;

import com.tiqiaa.client.IRemoteClient;
import com.tiqiaa.client.impl.RemoteClient;
import com.tiqiaa.icontrol.util.TiqiaaService;
import com.tiqiaa.ircode.impl.InfraredFetcher;
import com.tiqiaa.remote.entity.AirRemoteState;
import com.tiqiaa.remote.entity.Brand;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.tv.entity.City;
import com.tiqiaa.tv.entity.CityProvider;
import com.tiqiaa.tv.entity.CityProviderRemote;
import com.tiqiaa.tv.entity.Province;
import com.tiqiaa.tv.entity.TvProvider;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.List;

public final class fzh {

    /* renamed from: O000000o  reason: collision with root package name */
    public IRemoteClient f17433O000000o = new RemoteClient(XmPluginHostApi.instance().context());
    public InfraredFetcher O00000Oo = new InfraredFetcher(XmPluginHostApi.instance().context());

    public interface O000000o {
        void O000000o(AirRemoteState airRemoteState);

        void O000000o(String str);
    }

    public interface O00000Oo {
        void O000000o(String str);

        void O000000o(List<Infrared> list);
    }

    public interface O00000o {
        void O000000o(int i, String str);

        void O000000o(int i, List<City> list);
    }

    public interface O00000o0 {
        void O000000o(int i, String str);

        void O000000o(int i, List<CityProvider> list);
    }

    public interface O0000O0o {
        void O000000o(int i, String str);

        void O000000o(int i, List<CityProviderRemote> list);
    }

    public interface O0000OOo {
        void O000000o(int i, String str);

        void O000000o(int i, List<CityProvider> list);
    }

    public interface O0000Oo {
        void O000000o(List<TvProvider> list);
    }

    public interface O0000Oo0 {
        void O000000o(int i, String str);

        void O000000o(int i, List<Province> list);
    }

    public interface O0000o {
        void O000000o(String str);

        void O000000o(String str, String str2);
    }

    public interface O0000o0 {
        void O000000o(int i, String str);

        void O000000o(int i, List<Remote> list);
    }

    public interface O0000o00 {
        void O000000o(String str);

        void O00000Oo(String str);
    }

    public interface O000O00o {
        void O000000o(int i, String str);

        void O000000o(int i, List<Remote> list);
    }

    public interface O000O0OO {
        void O000000o(int i, String str);

        void O000000o(int i, List<Brand> list);
    }

    public interface O000O0o0 {
        void O000000o(int i, String str);

        void O000000o(int i, List<Remote> list);
    }

    public interface O00oOooO {
        void O000000o(int i, Remote remote);

        void O000000o(int i, String str);
    }

    public fzh() {
        TiqiaaService.setLocalServer(false);
        TiqiaaService.init(XmPluginHostApi.instance().context(), "Hq6UXid7b7i1LMO4lT7FMiOZ");
        TiqiaaService.enableTestMode();
    }

    public final void O000000o() {
        if (this.f17433O000000o == null) {
            this.f17433O000000o = new RemoteClient(XmPluginHostApi.instance().context());
        }
    }

    public final void O00000Oo() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new InfraredFetcher(XmPluginHostApi.instance().context());
        }
    }
}
