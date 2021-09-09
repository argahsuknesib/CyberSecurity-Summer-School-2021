package _m_j;

import android.os.AsyncTask;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

public final class fzd extends AsyncTask<Pair<fze, O000000o>, Void, Void> {

    public interface O000000o {
        void onClose(Integer num, String str);

        void onConnection(Integer num, Integer num2, InetSocketAddress inetSocketAddress);

        void onData(Integer num, byte[] bArr);

        void onError(Integer num, String str);
    }

    fzd() {
    }

    /* access modifiers changed from: private */
    @SafeVarargs
    /* renamed from: O000000o */
    public Void doInBackground(Pair<fze, O000000o>... pairArr) {
        if (pairArr.length <= 1) {
            fze fze = (fze) pairArr[0].first;
            O000000o o000000o = (O000000o) pairArr[0].second;
            int O000000o2 = fze.O000000o();
            Socket O00000Oo = fze.O00000Oo();
            byte[] bArr = new byte[8192];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(O00000Oo.getInputStream());
                while (!isCancelled() && !O00000Oo.isClosed()) {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        o000000o.onData(Integer.valueOf(O000000o2), Arrays.copyOfRange(bArr, 0, read));
                    } else if (read == -1) {
                        fze.O00000o();
                    }
                }
                return null;
            } catch (IOException e) {
                if (o000000o != null && !O00000Oo.isClosed()) {
                    o000000o.onError(Integer.valueOf(O000000o2), e.getMessage());
                }
                cancel(false);
                return null;
            }
        } else {
            throw new IllegalArgumentException("This task is only for a single socket/listener pair.");
        }
    }
}
