package _m_j;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

public abstract class gso extends gsl<String, gsf> {
    public abstract void O000000o(String str);

    public /* synthetic */ void onSuccess(Object obj, Response response) {
        O000000o((String) obj);
    }

    public final void processResponse(Response response) {
        if (response.isSuccessful()) {
            try {
                sendSuccessMessage(response.body().string(), response);
            } catch (Exception e) {
                sendFailureMessage(new gsf(response.code(), ""), e, response);
            }
        } else {
            sendFailureMessage(new gsf(response.code(), ""), null, response);
        }
    }

    public final void processFailure(Call call, IOException iOException) {
        sendFailureMessage(new gsf(-1, ""), iOException, null);
    }
}
