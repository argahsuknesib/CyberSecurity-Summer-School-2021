package _m_j;

import android.content.Context;
import android.widget.Toast;
import com.xiaomi.smarthome.R;
import java.io.IOException;

public final class eiy extends eiv {
    public eiy(eiv eiv) {
        super(eiv);
    }

    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof IOException)) {
            return false;
        }
        Toast.makeText(context, (int) R.string.request_error_network, 0).show();
        return true;
    }
}
