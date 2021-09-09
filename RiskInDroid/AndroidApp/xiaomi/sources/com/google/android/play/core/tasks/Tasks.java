package com.google.android.play.core.tasks;

import com.google.android.play.core.splitcompat.q;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    public static <ResultT> Task<ResultT> a(Exception exc) {
        m mVar = new m();
        mVar.a(exc);
        return mVar;
    }

    public static <ResultT> Task<ResultT> a(Object obj) {
        m mVar = new m();
        mVar.a(obj);
        return mVar;
    }

    private static <ResultT> ResultT a(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    private static void a(Task<?> task, n nVar) {
        task.addOnSuccessListener(TaskExecutors.f3843a, nVar);
        task.addOnFailureListener(TaskExecutors.f3843a, nVar);
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        q.a(task, "Task must not be null");
        if (task.isComplete()) {
            return a((Task) task);
        }
        n nVar = new n(null);
        a(task, nVar);
        nVar.a();
        return a((Task) task);
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        q.a(task, "Task must not be null");
        q.a(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return a((Task) task);
        }
        n nVar = new n(null);
        a(task, nVar);
        if (nVar.a(j, timeUnit)) {
            return a((Task) task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
