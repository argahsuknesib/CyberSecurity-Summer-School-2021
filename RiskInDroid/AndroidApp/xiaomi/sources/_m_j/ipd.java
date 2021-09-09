package _m_j;

import android.content.Context;
import android.media.MediaRecorder;
import java.io.File;

final class ipd implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1534O000000o;

    ipd(Context context) {
        this.f1534O000000o = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:14|15|16|17|18|19|20|23|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:13|27|28|29|30|33|35|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|(1:11)|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        return true ^ r5.f1534O000000o.getPackageManager().hasSystemFeature("android.hardware.microphone");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0029 */
    public final boolean O000000o() throws Throwable {
        MediaRecorder mediaRecorder = new MediaRecorder();
        File file = null;
        file = File.createTempFile("permission", "test");
        mediaRecorder.setAudioSource(1);
        mediaRecorder.setOutputFormat(3);
        mediaRecorder.setAudioEncoder(1);
        mediaRecorder.setOutputFile(file.getAbsolutePath());
        mediaRecorder.prepare();
        mediaRecorder.start();
        mediaRecorder.stop();
        mediaRecorder.release();
        if (file != null && file.exists()) {
            file.delete();
        }
        return true;
    }
}
