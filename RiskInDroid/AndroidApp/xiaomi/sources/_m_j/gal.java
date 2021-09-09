package _m_j;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Pair;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public final class gal extends AsyncTask<Pair<DatagramSocket, O000000o>, Void, Void> {

    public interface O000000o {
        void O000000o(RuntimeException runtimeException);

        void O000000o(String str);

        void O000000o(String str, String str2, int i);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public Void doInBackground(Pair<DatagramSocket, O000000o>... pairArr) {
        if (pairArr.length <= 1) {
            DatagramSocket datagramSocket = (DatagramSocket) pairArr[0].first;
            O000000o o000000o = (O000000o) pairArr[0].second;
            DatagramPacket datagramPacket = new DatagramPacket(new byte[65535], 65535);
            while (!isCancelled()) {
                try {
                    datagramSocket.receive(datagramPacket);
                    o000000o.O000000o(Base64.encodeToString(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), 2), datagramPacket.getAddress().getHostAddress(), datagramPacket.getPort());
                } catch (IOException e) {
                    if (o000000o != null) {
                        o000000o.O000000o(e.getMessage());
                    }
                    cancel(false);
                } catch (RuntimeException e2) {
                    if (o000000o != null) {
                        o000000o.O000000o(e2);
                    }
                    cancel(false);
                }
            }
            return null;
        }
        throw new IllegalArgumentException("This task is only for a single socket/listener pair.");
    }
}
