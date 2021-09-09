package _m_j;

import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.PlaylistException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

abstract class bcf {

    /* renamed from: O000000o  reason: collision with root package name */
    final bcc f12851O000000o;

    /* access modifiers changed from: package-private */
    public abstract void O000000o(bcn bcn) throws IOException, ParseException, PlaylistException;

    bcf(OutputStream outputStream, Encoding encoding) {
        try {
            this.f12851O000000o = new bcc(new OutputStreamWriter(outputStream, encoding.getValue()));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
