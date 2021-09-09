package com.google.android.play.core.tasks;

public class NativeOnCompleteListener implements OnCompleteListener<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final long f3842a;
    private final int b;

    public NativeOnCompleteListener(long j, int i) {
        this.f3842a = j;
        this.b = i;
    }

    public native void nativeOnComplete(long j, int i, Object obj, int i2);

    public void onComplete(Task<Object> task) {
        if (!task.isComplete()) {
            int i = this.b;
            StringBuilder sb = new StringBuilder(50);
            sb.append("onComplete called for incomplete task: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        } else if (task.isSuccessful()) {
            nativeOnComplete(this.f3842a, this.b, task.getResult(), 0);
        } else {
            Exception exception = task.getException();
            if (!(exception instanceof j)) {
                nativeOnComplete(this.f3842a, this.b, null, -100);
                return;
            }
            int errorCode = ((j) exception).getErrorCode();
            if (errorCode != 0) {
                nativeOnComplete(this.f3842a, this.b, null, errorCode);
                return;
            }
            int i2 = this.b;
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("TaskException has error code 0 on task: ");
            sb2.append(i2);
            throw new IllegalStateException(sb2.toString());
        }
    }
}
