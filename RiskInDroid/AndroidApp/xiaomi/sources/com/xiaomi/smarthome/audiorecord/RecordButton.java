package com.xiaomi.smarthome.audiorecord;

import _m_j.gqg;
import _m_j.gsy;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordButton extends Button {
    public String AUDOI_DIR;
    int delta = 50;
    private String mAudioFile;
    public O00000Oo mAudioUtil = new O00000Oo();
    Dialog mRecordDialog;
    O00000o0 mRecordListerer;
    long mStartTime;
    O000000o mThread;
    public Handler mVolumeHandler = new O00000o(this);
    private final DialogInterface.OnDismissListener onDismiss = new DialogInterface.OnDismissListener() {
        /* class com.xiaomi.smarthome.audiorecord.RecordButton.AnonymousClass1 */

        public final void onDismiss(DialogInterface dialogInterface) {
            RecordButton.this.stopRecording();
        }
    };

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f4232O000000o;
        boolean O00000Oo;
        MediaRecorder O00000o0;
    }

    public interface O00000o0 {
        void O000000o();

        void O000000o(String str);

        void O000000o(boolean z);

        void O00000Oo();
    }

    public RecordButton(Context context) {
        super(context);
    }

    public RecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private String getReadableDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            initlization();
        } else if (action != 1) {
            if (action == 2) {
                if (isTouchOutOfBound(motionEvent)) {
                    O00000o0 o00000o0 = this.mRecordListerer;
                    if (o00000o0 != null) {
                        o00000o0.O000000o(false);
                    }
                } else {
                    O00000o0 o00000o02 = this.mRecordListerer;
                    if (o00000o02 != null) {
                        o00000o02.O000000o(true);
                    }
                }
            }
        } else if (isTouchOutOfBound(motionEvent)) {
            cancelRecord();
        } else {
            finishRecord();
        }
        return true;
    }

    private boolean isTouchOutOfBound(MotionEvent motionEvent) {
        int width = getWidth();
        int height = getHeight();
        int y = (int) motionEvent.getY();
        int x = (int) motionEvent.getX();
        int i = this.delta;
        return y < (-i) || y > height + i || x < (-i) || x > width + i;
    }

    private void initlization() {
        if (TextUtils.isEmpty(this.AUDOI_DIR)) {
            this.AUDOI_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + ServiceApplication.getAppContext().getPackageName() + "/audio";
        }
        this.mAudioFile = this.AUDOI_DIR + "/" + getReadableDate() + "-" + System.currentTimeMillis();
        File file = new File(this.AUDOI_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            new File(this.mAudioFile).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.mRecordDialog == null) {
            this.mRecordDialog = new Dialog(getContext());
            this.mRecordDialog.setOnDismissListener(this.onDismiss);
        }
        startRecording();
    }

    public void finishRecord() {
        stopRecording();
        this.mRecordDialog.dismiss();
        if (System.currentTimeMillis() - this.mStartTime < 700) {
            gqg.O00000Oo("too short");
            new File(this.mAudioFile).delete();
            return;
        }
        O00000o0 o00000o0 = this.mRecordListerer;
        if (o00000o0 != null) {
            String str = this.mAudioFile;
            System.currentTimeMillis();
            o00000o0.O000000o(str);
        }
    }

    public void setRecordListener(O00000o0 o00000o0) {
        this.mRecordListerer = o00000o0;
    }

    private void cancelRecord() {
        stopRecording();
        this.mRecordDialog.dismiss();
        new File(this.mAudioFile).delete();
        O00000o0 o00000o0 = this.mRecordListerer;
        if (o00000o0 != null) {
            o00000o0.O000000o();
        }
    }

    private void startRecording() {
        O00000Oo o00000Oo = this.mAudioUtil;
        o00000Oo.f4232O000000o = this.mAudioFile;
        o00000Oo.O00000o0 = new MediaRecorder();
        try {
            o00000Oo.O00000o0.setAudioSource(1);
            o00000Oo.O00000o0.setOutputFormat(3);
            o00000Oo.O00000o0.setAudioEncoder(1);
            o00000Oo.O00000o0.setOutputFile(o00000Oo.f4232O000000o);
            o00000Oo.O00000Oo = true;
        } catch (Exception e) {
            gsy.O000000o(3, RecordButton.class.getSimpleName(), "safe log");
            e.printStackTrace();
            o00000Oo.O00000Oo = false;
        }
        try {
            o00000Oo.O00000o0.prepare();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        o00000Oo.O00000o0.start();
        this.mThread = new O000000o(this, (byte) 0);
        this.mThread.start();
        O00000o0 o00000o0 = this.mRecordListerer;
        if (o00000o0 != null) {
            o00000o0.O00000Oo();
        }
    }

    public void stopRecording() {
        O000000o o000000o = this.mThread;
        if (o000000o != null) {
            o000000o.f4231O000000o = false;
            this.mThread = null;
        }
        O00000Oo o00000Oo = this.mAudioUtil;
        if (o00000Oo != null && o00000Oo.O00000o0 != null) {
            o00000Oo.O00000o0.stop();
            o00000Oo.O00000o0.release();
            o00000Oo.O00000o0 = null;
            o00000Oo.O00000Oo = false;
        }
    }

    class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        volatile boolean f4231O000000o;

        private O000000o() {
            this.f4231O000000o = true;
        }

        /* synthetic */ O000000o(RecordButton recordButton, byte b) {
            this();
        }

        public final void run() {
            while (this.f4231O000000o) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (System.currentTimeMillis() - RecordButton.this.mStartTime >= 60000) {
                    RecordButton.this.mVolumeHandler.sendEmptyMessage(-1);
                }
                int i = 0;
                if (RecordButton.this.mAudioUtil == null || !this.f4231O000000o) {
                    this.f4231O000000o = false;
                } else {
                    O00000Oo o00000Oo = RecordButton.this.mAudioUtil;
                    if (!(o00000Oo.O00000o0 == null || !o00000Oo.O00000Oo || (i = o00000Oo.O00000o0.getMaxAmplitude()) == 0)) {
                        i = ((int) ((Math.log((double) i) * 10.0d) / Math.log(10.0d))) / 7;
                    }
                    if (i != 0) {
                        RecordButton.this.mVolumeHandler.sendEmptyMessage(i);
                    }
                }
            }
        }
    }

    static class O00000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<RecordButton> f4233O000000o;

        public O00000o(RecordButton recordButton) {
            this.f4233O000000o = new WeakReference<>(recordButton);
        }

        public final void handleMessage(Message message) {
            RecordButton recordButton = this.f4233O000000o.get();
            if (message.what == -1) {
                recordButton.finishRecord();
            }
        }
    }
}
