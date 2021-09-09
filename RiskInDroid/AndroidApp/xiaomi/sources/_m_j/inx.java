package _m_j;

import android.media.MediaRecorder;
import java.io.File;

final class inx implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private File f1509O000000o;
    private MediaRecorder O00000Oo;

    inx() {
        this.f1509O000000o = null;
        this.O00000Oo = null;
        this.O00000Oo = new MediaRecorder();
    }

    public final boolean O000000o() throws Throwable {
        try {
            this.f1509O000000o = File.createTempFile("permission", "test");
            this.O00000Oo.setAudioSource(1);
            this.O00000Oo.setOutputFormat(3);
            this.O00000Oo.setAudioEncoder(1);
            this.O00000Oo.setOutputFile(this.f1509O000000o.getAbsolutePath());
            this.O00000Oo.prepare();
            this.O00000Oo.start();
            return true;
        } finally {
            O00000Oo();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:2|3|4|5) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    private void O00000Oo() {
        MediaRecorder mediaRecorder = this.O00000Oo;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.O00000Oo.release();
        }
        File file = this.f1509O000000o;
        if (file != null && file.exists()) {
            this.f1509O000000o.delete();
        }
    }
}
