package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;

final /* synthetic */ class h implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final t f3816a;
    private final i b;

    h(t tVar, i iVar) {
        this.f3816a = tVar;
        this.b = iVar;
    }

    public final void onComplete(Task task) {
        t tVar = this.f3816a;
        i iVar = this.b;
        if (task.isSuccessful()) {
            tVar.a((SplitInstallManager) task.getResult()).addOnCompleteListener(new j(iVar));
        } else {
            iVar.a(task.getException());
        }
    }
}
