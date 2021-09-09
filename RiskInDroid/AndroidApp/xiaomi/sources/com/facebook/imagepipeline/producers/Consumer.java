package com.facebook.imagepipeline.producers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Consumer<T> {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    void onCancellation();

    void onFailure(Throwable th);

    void onNewResult(T t, int i);

    void onProgressUpdate(float f);
}
