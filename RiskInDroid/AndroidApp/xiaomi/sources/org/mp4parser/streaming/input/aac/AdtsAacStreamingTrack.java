package org.mp4parser.streaming.input.aac;

import _m_j.jjp;
import _m_j.jjs;
import _m_j.jjt;
import _m_j.jju;
import _m_j.jjv;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.AudioSpecificConfig;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.DecoderConfigDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.SLConfigDescriptor;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part14.ESDescriptorBox;
import org.mp4parser.boxes.sampleentry.AudioSampleEntry;

public class AdtsAacStreamingTrack extends jjt implements Callable<Void> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Logger LOG = Logger.getLogger(AdtsAacStreamingTrack.class.getName());
    private static Map<Integer, Integer> samplingFrequencyIndexMap = new HashMap();
    private long avgBitrate;
    private boolean closed;
    private jjv firstHeader;
    CountDownLatch gotFirstSample = new CountDownLatch(1);
    private InputStream is;
    private String lang = "und";
    private long maxBitrate;
    SampleDescriptionBox stsd = null;

    public String getHandler() {
        return "soun";
    }

    static {
        samplingFrequencyIndexMap.put(96000, 0);
        samplingFrequencyIndexMap.put(88200, 1);
        samplingFrequencyIndexMap.put(64000, 2);
        samplingFrequencyIndexMap.put(48000, 3);
        samplingFrequencyIndexMap.put(44100, 4);
        samplingFrequencyIndexMap.put(32000, 5);
        samplingFrequencyIndexMap.put(24000, 6);
        samplingFrequencyIndexMap.put(22050, 7);
        samplingFrequencyIndexMap.put(16000, 8);
        samplingFrequencyIndexMap.put(12000, 9);
        samplingFrequencyIndexMap.put(11025, 10);
        samplingFrequencyIndexMap.put(8000, 11);
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, 8000);
    }

    public AdtsAacStreamingTrack(InputStream inputStream, long j, long j2) {
        this.avgBitrate = j;
        this.maxBitrate = j2;
        this.is = inputStream;
        jjp jjp = new jjp();
        jjp.O00000Oo = 2;
        jjp.O00000o0 = 2;
        jjp.O00000o = 2;
        jjp.O00000oO = 2;
        jjp.O0000O0o = false;
        addTrackExtension(jjp);
    }

    public boolean isClosed() {
        return this.closed;
    }

    public synchronized SampleDescriptionBox getSampleDescriptionBox() {
        waitForFirstSample();
        if (this.stsd == null) {
            this.stsd = new SampleDescriptionBox();
            AudioSampleEntry audioSampleEntry = new AudioSampleEntry("mp4a");
            if (this.firstHeader.O0000O0o == 7) {
                audioSampleEntry.setChannelCount(8);
            } else {
                audioSampleEntry.setChannelCount(this.firstHeader.O0000O0o);
            }
            audioSampleEntry.setSampleRate((long) this.firstHeader.O00000oo);
            audioSampleEntry.setDataReferenceIndex(1);
            audioSampleEntry.setSampleSize(16);
            ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
            ESDescriptor eSDescriptor = new ESDescriptor();
            eSDescriptor.setEsId(0);
            SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
            sLConfigDescriptor.setPredefined(2);
            eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
            DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
            decoderConfigDescriptor.setObjectTypeIndication(64);
            decoderConfigDescriptor.setStreamType(5);
            decoderConfigDescriptor.setBufferSizeDB(1536);
            decoderConfigDescriptor.setMaxBitRate(this.maxBitrate);
            decoderConfigDescriptor.setAvgBitRate(this.avgBitrate);
            AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
            audioSpecificConfig.setOriginalAudioObjectType(2);
            audioSpecificConfig.setSamplingFrequencyIndex(this.firstHeader.f1888O000000o);
            audioSpecificConfig.setChannelConfiguration(this.firstHeader.O0000O0o);
            decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
            eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
            eSDescriptorBox.setEsDescriptor(eSDescriptor);
            audioSampleEntry.addBox(eSDescriptorBox);
            this.stsd.addBox(audioSampleEntry);
        }
        return this.stsd;
    }

    /* access modifiers changed from: package-private */
    public void waitForFirstSample() {
        try {
            this.gotFirstSample.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public long getTimescale() {
        waitForFirstSample();
        return (long) this.firstHeader.O00000oo;
    }

    public String getLanguage() {
        return this.lang;
    }

    public void setLanguage(String str) {
        this.lang = str;
    }

    public void close() throws IOException {
        this.closed = true;
        this.is.close();
    }

    private jjv readADTSHeader(InputStream inputStream) throws IOException {
        jjv jjv = new jjv();
        int read = inputStream.read() << 4;
        int read2 = inputStream.read();
        if (read2 == -1) {
            return null;
        }
        if (read + (read2 >> 4) == 4095) {
            jjv.O00000Oo = (read2 & 8) >> 3;
            jjv.O00000o0 = (read2 & 6) >> 1;
            jjv.O00000o = read2 & 1;
            int read3 = inputStream.read();
            jjv.O00000oO = ((read3 & 192) >> 6) + 1;
            jjv.f1888O000000o = (read3 & 60) >> 2;
            jjv.O00000oo = samplingFrequencyIndexMap.get(Integer.valueOf(jjv.f1888O000000o)).intValue();
            jjv.O0000O0o = (read3 & 1) << 2;
            int read4 = inputStream.read();
            jjv.O0000O0o += (read4 & 192) >> 6;
            jjv.O0000OOo = (read4 & 32) >> 5;
            jjv.O0000Oo0 = (read4 & 16) >> 4;
            jjv.O0000Oo = (read4 & 8) >> 3;
            jjv.O0000OoO = (read4 & 4) >> 2;
            jjv.O0000Ooo = (read4 & 3) << 9;
            jjv.O0000Ooo += inputStream.read() << 3;
            int read5 = inputStream.read();
            jjv.O0000Ooo += (read5 & 224) >> 5;
            jjv.O0000o00 = (read5 & 31) << 6;
            int read6 = inputStream.read();
            jjv.O0000o00 += (read6 & 252) >> 2;
            jjv.O0000o0 = (read6 & 3) + 1;
            if (jjv.O0000o0 == 1) {
                if (jjv.O00000o == 0) {
                    inputStream.read();
                    inputStream.read();
                }
                return jjv;
            }
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        }
        throw new IOException("Expected Start Word 0xfff");
    }

    public Void call() throws Exception {
        while (true) {
            try {
                jjv readADTSHeader = readADTSHeader(this.is);
                if (readADTSHeader == null) {
                    return null;
                }
                if (this.firstHeader == null) {
                    this.firstHeader = readADTSHeader;
                    this.gotFirstSample.countDown();
                }
                int i = 0;
                byte[] bArr = new byte[(readADTSHeader.O0000Ooo - (7 + (readADTSHeader.O00000o == 0 ? 2 : 0)))];
                while (i < bArr.length) {
                    int read = this.is.read(bArr, i, bArr.length - i);
                    if (read >= 0) {
                        i += read;
                    } else {
                        throw new EOFException();
                    }
                }
                this.sampleSink.O000000o(new jju(ByteBuffer.wrap(bArr)), this);
            } catch (EOFException unused) {
                LOG.info("Done reading ADTS AAC file.");
                return null;
            }
        }
    }

    public String toString() {
        jjs jjs = (jjs) getTrackExtension(jjs.class);
        if (jjs == null) {
            return "AdtsAacStreamingTrack{}";
        }
        return "AdtsAacStreamingTrack{trackId=" + jjs.f1886O000000o + "}";
    }
}
