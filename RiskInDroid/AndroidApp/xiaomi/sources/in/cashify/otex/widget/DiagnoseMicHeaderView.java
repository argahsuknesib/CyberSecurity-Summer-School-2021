package in.cashify.otex.widget;

import a.a.a.b;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Process;
import com.xiaomi.smarthome.R;

public class DiagnoseMicHeaderView extends DiagnoseHeaderView {

    /* renamed from: O000000o  reason: collision with root package name */
    public VisualizerView f12281O000000o;
    public O000000o O00000Oo;
    public int O00000o = -1;
    public b O00000o0;

    public DiagnoseMicHeaderView(Context context) {
        super(context);
    }

    public DiagnoseMicHeaderView(Context context, byte b) {
        super(context, R.layout.layout_diagnose_header_mic);
    }

    public final void O000000o() {
        this.O00000Oo = new O000000o(this, (byte) 0);
        this.O00000Oo.execute(new Void[0]);
    }

    public final void O000000o(Context context, int i) {
        super.O000000o(context, i);
        this.f12281O000000o = (VisualizerView) this.O0000Ooo.findViewById(R.id.visualizer_view);
        this.f12281O000000o.getHolder().setFormat(-3);
    }

    public class O000000o extends AsyncTask<Void, Void, Void> {
        private O000000o() {
        }

        public /* synthetic */ O000000o(DiagnoseMicHeaderView diagnoseMicHeaderView, byte b) {
            this();
        }

        private static int O000000o(int i, short[] sArr) {
            double d = 0.0d;
            for (int i2 = 0; i2 < i; i2++) {
                double d2 = (double) (sArr[i2] * sArr[i2]);
                Double.isNaN(d2);
                d += d2;
            }
            double d3 = (double) i;
            Double.isNaN(d3);
            return (int) (Math.log10(Math.abs(d / d3) / 32768.0d) * 20.0d);
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        public final void onPreExecute() {
            super.onPreExecute();
            DiagnoseMicHeaderView.this.O00000o = -1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0096, code lost:
            if (r0.getState() == 1) goto L_0x0098;
         */
        private Void O000000o() {
            Process.setThreadPriority(-16);
            int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
            int i = minBufferSize >> 1;
            short[] sArr = new short[i];
            try {
                AudioRecord build = Build.VERSION.SDK_INT >= 23 ? new AudioRecord.Builder().setAudioSource(1).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(44100).setChannelMask(16).build()).setBufferSizeInBytes(minBufferSize).build() : new AudioRecord(1, 44100, 16, 2, minBufferSize);
                if (build == null || build.getState() == 0) {
                    throw new UnsupportedOperationException("Cannot create AudioRecord");
                }
                try {
                    build.startRecording();
                    long j = 0;
                    while (!isCancelled()) {
                        int O000000o2 = O000000o(build.read(sArr, 0, i), sArr);
                        if (O000000o2 > DiagnoseMicHeaderView.this.O00000o) {
                            DiagnoseMicHeaderView.this.O00000o = O000000o2;
                        }
                        if (System.currentTimeMillis() - j > 100) {
                            j = System.currentTimeMillis();
                            VisualizerView visualizerView = DiagnoseMicHeaderView.this.f12281O000000o;
                            if (visualizerView != null) {
                                visualizerView.O000000o(O000000o2);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                return null;
            } catch (Throwable unused2) {
                b unused3 = DiagnoseMicHeaderView.this.O00000o0 = new b("me", 4004, false);
                return null;
            }
        }
    }
}
