package _m_j;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public interface djy {
    void O000000o(HttpUtils.HttpStatusException httpStatusException);

    void O000000o(HttpUtils.NetworkUnavailableException networkUnavailableException);

    void O000000o(IOException iOException);

    void O000000o(Exception exc);

    void O000000o(MalformedURLException malformedURLException);

    void O000000o(SocketTimeoutException socketTimeoutException);

    void O000000o(ConnectTimeoutException connectTimeoutException);

    void O000000o(JSONException jSONException);

    void O000000o(JSONObject jSONObject);
}
