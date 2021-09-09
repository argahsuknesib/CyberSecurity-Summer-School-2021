package _m_j;

import _m_j.gzq;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0014J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\b8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "isCameraEditMode", "", "isCardEditMode", "isSceneEditMode", "onAnyEditModeChanged", "", "current", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCameraEditModeChanged", "onCardEditModeChanged", "onDetachedFromRecyclerView", "onSceneEditModeChanged", "registerEditChangeObserver", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class haz extends gzm {
    public boolean O00000o;
    public final CompositeDisposable O00000o0 = new CompositeDisposable();
    public boolean O00000oO;
    public boolean O00000oo;

    /* access modifiers changed from: protected */
    public void O000000o(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void O00000o(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void O00000o0(boolean z) {
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        CompositeDisposable compositeDisposable = this.O00000o0;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzq.O000000o o000000o2 = gzq.f18638O000000o;
        gzq.O000000o o000000o3 = gzq.f18638O000000o;
        compositeDisposable.addAll(gzq.O00000o.map($$Lambda$haz$qVQkUHci9liCazPlK7JBKFITfk0.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$haz$1gbKDmMNhhyX_0xckRQQQEaotY0 */

            public final void accept(Object obj) {
                haz.O000000o(haz.this, (Boolean) obj);
            }
        }), gzq.O00000oO.map($$Lambda$haz$5RJvSbFsudjUoYHIwFxmfTebyFg.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$haz$D2NXzamxKMArCePwxZUveYn174Q */

            public final void accept(Object obj) {
                haz.O00000Oo(haz.this, (Boolean) obj);
            }
        }), gzq.O00000oo.map($$Lambda$haz$ZaPgZqnyc_BGUSeX2qT7xyoj8.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$haz$83LZ0eiu8kWwDoyxbHcNpJ38b0M */

            public final void accept(Object obj) {
                haz.O00000o0(haz.this, (Boolean) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_card_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(haz haz, Boolean bool) {
        ixe.O00000o(haz, "this$0");
        ixe.O00000Oo(bool, "it");
        haz.O00000oO = bool.booleanValue();
        haz.O000000o(bool.booleanValue());
        haz.O00000Oo(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(haz haz, Boolean bool) {
        ixe.O00000o(haz, "this$0");
        ixe.O00000Oo(bool, "it");
        haz.O00000o = bool.booleanValue();
        haz.O00000o(bool.booleanValue());
        haz.O00000Oo(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000o0(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_camera_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(haz haz, Boolean bool) {
        ixe.O00000o(haz, "this$0");
        ixe.O00000Oo(bool, "it");
        haz.O00000oo = bool.booleanValue();
        haz.O00000o0(bool.booleanValue());
        haz.O00000Oo(bool.booleanValue());
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.O00000o0.clear();
    }
}
