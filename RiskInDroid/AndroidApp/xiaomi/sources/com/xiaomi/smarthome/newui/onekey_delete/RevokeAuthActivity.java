package com.xiaomi.smarthome.newui.onekey_delete;

import _m_j.gsy;
import _m_j.hji;
import _m_j.hte;
import _m_j.hxi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.newui.onekey_delete.RevokeAuthActivity;
import com.xiaomi.smarthome.operation.js_sdk.share.LoadingDialogHelper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.CompletableSubject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RevokeAuthActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private final CompositeDisposable f10254O000000o = new CompositeDisposable();
    private LoadingDialogHelper O00000Oo = new LoadingDialogHelper(this);
    private CompletableSubject O00000o;
    private String O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new FrameLayout(this));
        CompletableSubject create = CompletableSubject.create();
        Completable doOnSubscribe = create.doOnSubscribe(new Consumer(create) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$d6uHuBHyuLmyg4q_5DQNesyVceQ */
            private final /* synthetic */ CompletableSubject f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O00000o(this.f$1, (Disposable) obj);
            }
        });
        CompletableSubject create2 = CompletableSubject.create();
        Completable andThen = doOnSubscribe.andThen(create2.doOnSubscribe(new Consumer(create2) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$y72bVcMqobJffQg7Pkjkz72cLS4 */
            private final /* synthetic */ CompletableSubject f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O00000o0(this.f$1, (Disposable) obj);
            }
        }));
        CompletableSubject create3 = CompletableSubject.create();
        Completable andThen2 = andThen.andThen(create3.doOnSubscribe(new Consumer(create3) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$f5SMx4sML4B_VgkkAsF5bu11C8 */
            private final /* synthetic */ CompletableSubject f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O00000Oo(this.f$1, (Disposable) obj);
            }
        }));
        CompletableSubject create4 = CompletableSubject.create();
        this.f10254O000000o.add(andThen2.andThen(create4.doOnSubscribe(new Consumer(create4) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$bFtEgDAu80uQ0wHHWMCSElc5xB0 */
            private final /* synthetic */ CompletableSubject f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O000000o(this.f$1, (Disposable) obj);
            }
        })).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$05JUlmQjqergfHrDlC_Fot7pgHg */

            public final void run() {
                RevokeAuthActivity.this.O00000o0();
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$zXoS0QWSplYZ8nqvJ9ICIcgIJio */

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O000000o((Throwable) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() throws Exception {
        gsy.O00000Oo("RevokeAuthActivity", "revoke finished: success: ");
        setResult(-1, new Intent());
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Throwable th) throws Exception {
        if (!(th instanceof CancelByUserException)) {
            hte.O000000o(getContext(), (int) R.string.failed);
        }
        gsy.O00000Oo("RevokeAuthActivity", "revoke failed >> " + th.getLocalizedMessage());
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(final CompletableSubject completableSubject, Disposable disposable) throws Exception {
        hxi.O00000o0.f957O000000o.O000000o("del_user_auth", new Object[0]);
        gsy.O00000Oo("RevokeAuthActivity", "showFirstAlertDialog: ");
        View inflate = View.inflate(getContext(), R.layout.revoke_auth_dialog_content, null);
        TextView textView = (TextView) inflate.findViewById(R.id.msg);
        ((TextView) inflate.findViewById(R.id.title)).setText((int) R.string.revoke_auth_title);
        textView.setText((int) R.string.revoke_auth_msg);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MLAlertDialog O00000o2 = new MLAlertDialog.Builder(getContext()).O000000o(inflate).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$1KXQuSfDWK7drUZILw24w_PHKYs */

            public final void onClick(DialogInterface dialogInterface, int i) {
                RevokeAuthActivity.O00000o0(CompletableSubject.this, dialogInterface, i);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(atomicBoolean) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$Haxg2NLKUQc39dAPUzsXSOMF2ro */
            private final /* synthetic */ AtomicBoolean f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.set(true);
            }
        }).O000000o(new MLAlertDialog.O000000o() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.RevokeAuthActivity.AnonymousClass1 */

            public final void beforeDismissCallBack() {
            }

            public final void afterDismissCallBack() {
                if (atomicBoolean.get()) {
                    completableSubject.onError(new CancelByUserException("canceled on dismissed at showFirstAlertDialog."));
                }
            }
        }).O000000o(true).O00000o();
        O00000o2.show();
        Button button = O00000o2.getButton(-1);
        button.setEnabled(false);
        button.setTextColor(getResources().getColor(R.color.mj_color_black_50_transparent));
        Observable<R> observeOn = Observable.interval(0, 1, TimeUnit.SECONDS).take(10).map(new Function(10) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$rNyxuLRupqkf9QivqS8p80eUiA */
            private final /* synthetic */ int f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return Long.valueOf(((long) this.f$0) - ((Long) obj).longValue());
            }
        }).takeWhile(new Predicate() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$SsmV9ANk_rxy4G2owgnqMrNFEs */

            public final boolean test(Object obj) {
                return RevokeAuthActivity.O000000o(Disposable.this, (Long) obj);
            }
        }).map(new Function() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$Mums2Y8xNIm1ne52cxBwtoSzFIU */

            public final Object apply(Object obj) {
                return RevokeAuthActivity.this.O000000o((Long) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        button.getClass();
        $$Lambda$21RFyOA5k8VeZFT2I2pHWl4hpI r1 = new Consumer(button) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$21RFyOA5k8VeZFT2I2pHWl4hpI */
            private final /* synthetic */ Button f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                this.f$0.setText((String) obj);
            }
        };
        completableSubject.getClass();
        this.f10254O000000o.add(observeOn.subscribe(r1, new Consumer() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$choprRsDTSvpwrZVpXc94jmfwE */

            public final void accept(Object obj) {
                CompletableSubject.this.onError((Throwable) obj);
            }
        }, new Action(button) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$sVQ_EOVs5M0WKo9f242t7MT0Mng */
            private final /* synthetic */ Button f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.postDelayed(new Runnable(this.f$0) {
                    /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$QxSe9Qs5DC4APWv6CzBrOuzJe0U */
                    private final /* synthetic */ Button f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        RevokeAuthActivity.O00000Oo(this.f$0);
                    }
                }, 1000);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(CompletableSubject completableSubject, DialogInterface dialogInterface, int i) {
        completableSubject.onComplete();
        hxi.O00000o.f952O000000o.O000000o("del_user_auth", new Object[0]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(Disposable disposable, Long l) throws Exception {
        return !disposable.isDisposed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String O000000o(Long l) throws Exception {
        return getString(R.string.next) + "(" + l + ")";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(Button button) {
        button.setEnabled(true);
        button.setText((int) R.string.next);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(final CompletableSubject completableSubject, Disposable disposable) throws Exception {
        gsy.O00000Oo("RevokeAuthActivity", "showRequestTokenWebView: ");
        this.f10254O000000o.add(hji.O000000o().O000000o("").observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$KHbVOAmrvFLSXFnPcx1BLUwqTNA */

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O00000Oo((Disposable) obj);
            }
        }).subscribe(new Consumer<hji.O000000o>() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.RevokeAuthActivity.AnonymousClass2 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                hji.O000000o o000000o = (hji.O000000o) obj;
                if (o000000o.f18989O000000o == -4005001) {
                    String str = o000000o.O00000Oo;
                    if (!TextUtils.isEmpty(str)) {
                        RevokeAuthActivity.this.startRequestAuthTokenActivity(completableSubject, str);
                        return;
                    }
                    return;
                }
                CompletableSubject completableSubject = completableSubject;
                completableSubject.onError(new IllegalStateException("showRequestTokenWebView error: code = " + o000000o.f18989O000000o + " ; message: " + o000000o.O00000Oo));
            }
        }, new Consumer(completableSubject) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$t1WREpYS3n8c8_q_4XfE9ire0w */
            private final /* synthetic */ CompletableSubject f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O00000Oo(this.f$1, (Throwable) obj);
            }
        }, new Action() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$3ZMoqfaFC8N1DvWBURRM_MbBsYg */

            public final void run() {
                RevokeAuthActivity.this.O00000Oo();
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Disposable disposable) throws Exception {
        this.O00000Oo.O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(CompletableSubject completableSubject, Throwable th) throws Exception {
        completableSubject.onError(th);
        this.O00000Oo.O00000Oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo() throws Exception {
        this.O00000Oo.O00000Oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(CompletableSubject completableSubject, Disposable disposable) throws Exception {
        hxi.O00000o0.f957O000000o.O000000o("del_user_authcon", new Object[0]);
        gsy.O00000Oo("RevokeAuthActivity", "showConfirmAlertDialogAgain: ");
        View inflate = View.inflate(getContext(), R.layout.revoke_auth_dialog_content, null);
        ((TextView) inflate.findViewById(R.id.title)).setText((int) R.string.reassure_dialog_title);
        ((TextView) inflate.findViewById(R.id.msg)).setText((int) R.string.revoke_auth_confirm_msg);
        MLAlertDialog O00000o2 = new MLAlertDialog.Builder(getContext()).O000000o(inflate).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$RS3ZuGIE3IKOI6l6iQrQUfKLO4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                RevokeAuthActivity.O00000Oo(CompletableSubject.this, dialogInterface, i);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$fiGRo1h1l3lHpEtbJTf_r6UUKKM */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CompletableSubject.this.onError(new RevokeAuthActivity.CancelByUserException("canceled cat showConfirmAlertDialogAgain."));
            }
        }).O000000o(false).O00000o();
        O00000o2.show();
        O00000o2.getButton(-1).setTextColor(getResources().getColor(R.color.mj_color_black_50_transparent));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(CompletableSubject completableSubject, DialogInterface dialogInterface, int i) {
        completableSubject.onComplete();
        hxi.O00000o.f952O000000o.O000000o("del_user_authcon", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompletableSubject completableSubject, Disposable disposable) throws Exception {
        gsy.O00000Oo("RevokeAuthActivity", "requestDeleteServerData: ");
        this.f10254O000000o.add(hji.O000000o().O000000o(this.O00000o0).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$eG61OIBpWcvoVfFrqF0p4Yca__s */

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O000000o((Disposable) obj);
            }
        }).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$oDo_wRrj1MeHA1EWDggxiQp5hM */

            public final void accept(Object obj) {
                RevokeAuthActivity.O000000o(CompletableSubject.this, (hji.O000000o) obj);
            }
        }, new Consumer(completableSubject) {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$STY9Cl9Bbj7IvyMR5DjnjeBwoU */
            private final /* synthetic */ CompletableSubject f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RevokeAuthActivity.this.O000000o(this.f$1, (Throwable) obj);
            }
        }, new Action() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.$$Lambda$RevokeAuthActivity$4M2Cd6eqo75Qkx_D92z0KzzTVDo */

            public final void run() {
                RevokeAuthActivity.this.O000000o();
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Disposable disposable) throws Exception {
        this.O00000Oo.O000000o();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(CompletableSubject completableSubject, hji.O000000o o000000o) throws Exception {
        if (o000000o.f18989O000000o == 0) {
            completableSubject.onComplete();
            return;
        }
        completableSubject.onError(new IllegalStateException("requestDeleteServerData failed: code = " + o000000o.f18989O000000o + " ; message: " + o000000o.O00000Oo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompletableSubject completableSubject, Throwable th) throws Exception {
        completableSubject.onError(th);
        this.O00000Oo.O00000Oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() throws Exception {
        this.O00000Oo.O00000Oo();
    }

    public void startRequestAuthTokenActivity(CompletableSubject completableSubject, String str) {
        this.O00000o = completableSubject;
        Intent intent = new Intent(getContext(), AuthTokenActivity.class);
        intent.putExtra("url", str);
        startActivityForResult(intent, 136);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 136) {
            return;
        }
        if (i2 != -1 || intent == null) {
            this.O00000o.onError(new CancelByUserException("get token cancel."));
            return;
        }
        this.O00000o0 = intent.getStringExtra("arg_auth_token");
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o.onError(new AuthenticationFailureException("empty auth token!"));
        } else {
            this.O00000o.onComplete();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f10254O000000o.clear();
    }

    static class CancelByUserException extends Exception {
        CancelByUserException(String str) {
            super(str);
        }
    }
}
