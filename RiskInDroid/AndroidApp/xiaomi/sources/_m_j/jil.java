package _m_j;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import org.mp4parser.boxes.iso14496.part12.SchemeTypeBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;

public final class jil {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.TrackBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public static jib O000000o(ReadableByteChannel readableByteChannel, jid jid, String str) throws IOException {
        jhc jhc = new jhc(readableByteChannel);
        jib jib = new jib();
        for (TrackBox trackBox : jhc.O000000o().getBoxes(TrackBox.class)) {
            SchemeTypeBox schemeTypeBox = (SchemeTypeBox) jlf.O000000o((jko) trackBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schm[0]");
            if (schemeTypeBox == null || (!schemeTypeBox.getSchemeType().equals("cenc") && !schemeTypeBox.getSchemeType().equals("cbc1"))) {
                long trackId = trackBox.getTrackHeaderBox().getTrackId();
                jib.O000000o(new jic(trackId, jhc, jid, str + "[" + trackBox.getTrackHeaderBox().getTrackId() + "]"));
            } else {
                long trackId2 = trackBox.getTrackHeaderBox().getTrackId();
                jib.O000000o(new jhw(trackId2, jhc, jid, str + "[" + trackBox.getTrackHeaderBox().getTrackId() + "]"));
            }
        }
        jib.f1848O000000o = jhc.O000000o().getMovieHeaderBox().getMatrix();
        return jib;
    }
}
