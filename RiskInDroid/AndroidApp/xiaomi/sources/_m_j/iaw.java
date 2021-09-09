package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public final class iaw {
    public static Bundle O000000o(String str) {
        Bundle bundle = new Bundle();
        try {
            for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    bundle.putString(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        } catch (URISyntaxException e) {
            Log.e("openauth", e.getMessage());
        }
        return bundle;
    }
}
