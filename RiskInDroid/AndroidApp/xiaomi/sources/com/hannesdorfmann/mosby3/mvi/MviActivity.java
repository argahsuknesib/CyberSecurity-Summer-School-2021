package com.hannesdorfmann.mosby3.mvi;

import _m_j.ayf;
import _m_j.ayg;
import _m_j.ayi;
import _m_j.ayq;
import _m_j.ays;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MviActivity<V extends ays, P extends ayq<V, ?>> extends AppCompatActivity implements ayi<V, P>, ays {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ayf<V, P> f4333O000000o;
    private boolean O00000Oo = false;

    public abstract P createPresenter();

    public V getMvpView() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o().O000000o(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        O000000o().O000000o();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        O000000o().O00000Oo(bundle);
    }

    public void onPause() {
        super.onPause();
        O000000o();
    }

    public void onResume() {
        super.onResume();
        O000000o();
    }

    public void onStart() {
        super.onStart();
        O000000o().O00000Oo();
    }

    public void onStop() {
        super.onStop();
        O000000o().O00000o0();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        O000000o();
    }

    public void onContentChanged() {
        super.onContentChanged();
        O000000o();
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        O000000o();
    }

    private ayf<V, P> O000000o() {
        if (this.f4333O000000o == null) {
            this.f4333O000000o = new ayg(this, this);
        }
        return this.f4333O000000o;
    }

    public final Object onRetainCustomNonConfigurationInstance() {
        O000000o();
        return null;
    }

    public void setRestoringViewState(boolean z) {
        this.O00000Oo = z;
    }
}
