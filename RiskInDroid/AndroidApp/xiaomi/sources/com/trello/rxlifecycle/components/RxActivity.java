package com.trello.rxlifecycle.components;

import _m_j.drr;
import _m_j.drs;
import _m_j.drw;
import android.app.Activity;
import android.os.Bundle;
import com.trello.rxlifecycle.android.ActivityEvent;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public abstract class RxActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f5916O000000o = BehaviorSubject.create();

    public final Observable<ActivityEvent> lifecycle() {
        return this.f5916O000000o.asObservable();
    }

    public final <T> drr<T> bindUntilEvent(ActivityEvent activityEvent) {
        return drs.O000000o(this.f5916O000000o, activityEvent);
    }

    public final <T> drr<T> bindToLifecycle() {
        return drw.O000000o(this.f5916O000000o);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5916O000000o.onNext(ActivityEvent.CREATE);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f5916O000000o.onNext(ActivityEvent.START);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f5916O000000o.onNext(ActivityEvent.RESUME);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f5916O000000o.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f5916O000000o.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f5916O000000o.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }
}
