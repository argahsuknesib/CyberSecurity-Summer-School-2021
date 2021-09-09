package com.trello.rxlifecycle.components.support;

import _m_j.drr;
import _m_j.drs;
import _m_j.drw;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.trello.rxlifecycle.android.ActivityEvent;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public abstract class RxAppCompatActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f5917O000000o = BehaviorSubject.create();

    public final Observable<ActivityEvent> lifecycle() {
        return this.f5917O000000o.asObservable();
    }

    public final <T> drr<T> bindUntilEvent(ActivityEvent activityEvent) {
        return drs.O000000o(this.f5917O000000o, activityEvent);
    }

    public final <T> drr<T> bindToLifecycle() {
        return drw.O000000o(this.f5917O000000o);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5917O000000o.onNext(ActivityEvent.CREATE);
    }

    public void onStart() {
        super.onStart();
        this.f5917O000000o.onNext(ActivityEvent.START);
    }

    public void onResume() {
        super.onResume();
        this.f5917O000000o.onNext(ActivityEvent.RESUME);
    }

    public void onPause() {
        this.f5917O000000o.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    public void onStop() {
        this.f5917O000000o.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    public void onDestroy() {
        this.f5917O000000o.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }
}
