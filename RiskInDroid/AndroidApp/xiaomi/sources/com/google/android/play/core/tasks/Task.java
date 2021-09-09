package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

public abstract class Task<ResultT> {
    public abstract Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener);

    public abstract Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener);

    public abstract Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener);

    public abstract Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener);

    public abstract Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener);

    public abstract Exception getException();

    public abstract ResultT getResult();

    public abstract <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable;

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();
}
