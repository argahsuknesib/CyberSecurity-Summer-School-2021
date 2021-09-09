package com.google.android.play.core.tasks;

public interface OnCompleteListener<ResultT> {
    void onComplete(Task<ResultT> task);
}
