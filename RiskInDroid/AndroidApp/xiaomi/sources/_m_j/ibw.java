package _m_j;

import _m_j.icb;
import com.xiaomi.youpin.login.entity.Error;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class ibw<T extends icb> implements Callback {
    public abstract T O000000o(String str);

    public abstract void O000000o(T t);

    public abstract void O000000o(Error error);

    public void onFailure(Call call, IOException iOException) {
        O000000o(new Error(-1, iOException.getMessage()));
    }

    public void onResponse(Call call, Response response) throws IOException {
        if (response == null) {
            O000000o(new Error(-1, "net response is null"));
        } else if (!response.isSuccessful()) {
            O000000o(new Error(response.code(), ""));
        } else {
            try {
                icb O000000o2 = O000000o(response.body().string());
                if (O000000o2 == null) {
                    O000000o(new Error(-1, "on Parse is null"));
                } else if (O000000o2.f1171O000000o != 0) {
                    O000000o(new Error(-1, "code not success " + O000000o2.f1171O000000o));
                } else {
                    O000000o(O000000o2);
                }
            } catch (Exception e) {
                O000000o(new Error(-1, e.getMessage()));
            }
        }
    }
}
