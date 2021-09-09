package _m_j;

import org.mp4parser.boxes.iso14496.part12.DataEntryUrlBox;
import org.mp4parser.boxes.iso14496.part12.DataInformationBox;
import org.mp4parser.boxes.iso14496.part12.DataReferenceBox;
import org.mp4parser.boxes.iso14496.part12.HandlerBox;
import org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MediaBox;
import org.mp4parser.boxes.iso14496.part12.MediaInformationBox;
import org.mp4parser.boxes.iso14496.part12.NullMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SampleSizeBox;
import org.mp4parser.boxes.iso14496.part12.SampleTableBox;
import org.mp4parser.boxes.iso14496.part12.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox;
import org.mp4parser.boxes.iso14496.part12.SubtitleMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;
import org.mp4parser.boxes.iso14496.part12.TrackHeaderBox;
import org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox;

public abstract class jkl {
    /* access modifiers changed from: protected */
    public abstract jgy O000000o(jjk jjk);

    /* access modifiers changed from: protected */
    public final jgy O00000Oo(jjk jjk) {
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setTrackId(((jjs) jjk.getTrackExtension(jjs.class)).f1886O000000o);
        jjq jjq = (jjq) jjk.getTrackExtension(jjq.class);
        if (jjq != null) {
            trackHeaderBox.setHeight((double) jjq.O00000Oo);
            trackHeaderBox.setWidth((double) jjq.f1884O000000o);
        }
        trackBox.addBox(trackHeaderBox);
        MediaBox mediaBox = new MediaBox();
        mediaBox.addBox(O000000o(jjk));
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setHandlerType(jjk.getHandler());
        mediaBox.addBox(handlerBox);
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (jjk.getHandler().equals("vide")) {
            mediaInformationBox.addBox(new VideoMediaHeaderBox());
        } else if (jjk.getHandler().equals("soun")) {
            mediaInformationBox.addBox(new SoundMediaHeaderBox());
        } else if (jjk.getHandler().equals("text")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        } else if (jjk.getHandler().equals("subt")) {
            mediaInformationBox.addBox(new SubtitleMediaHeaderBox());
        } else if (jjk.getHandler().equals("hint")) {
            mediaInformationBox.addBox(new HintMediaHeaderBox());
        } else if (jjk.getHandler().equals("sbtl")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        }
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        SampleTableBox sampleTableBox = new SampleTableBox();
        sampleTableBox.addBox(jjk.getSampleDescriptionBox());
        sampleTableBox.addBox(new TimeToSampleBox());
        sampleTableBox.addBox(new SampleToChunkBox());
        sampleTableBox.addBox(new SampleSizeBox());
        sampleTableBox.addBox(new StaticChunkOffsetBox());
        mediaInformationBox.addBox(sampleTableBox);
        mediaBox.addBox(mediaInformationBox);
        trackBox.addBox(mediaBox);
        return trackBox;
    }
}
