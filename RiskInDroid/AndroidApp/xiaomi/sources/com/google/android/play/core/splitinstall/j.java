package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;

final /* synthetic */ class j implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final i f3818a;

    j(i iVar) {
        this.f3818a = iVar;
    }

    public final void onComplete(Task task) {
        i iVar = this.f3818a;
        if (task.isSuccessful()) {
            iVar.a(task.getResult());
        } else {
            iVar.a(task.getException());
        }
    }
}
