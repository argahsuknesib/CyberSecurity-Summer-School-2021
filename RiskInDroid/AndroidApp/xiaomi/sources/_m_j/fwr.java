package _m_j;

import _m_j.fwr;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.permission.PermissionBean;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.CompletableSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/SerialPermissionRequest;", "", "()V", "activity", "Landroid/app/Activity;", "cancelListener", "Landroid/content/DialogInterface$OnClickListener;", "getCancelListener", "()Landroid/content/DialogInterface$OnClickListener;", "setCancelListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "permissionBeans", "", "Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "onRequestPermissionsResult", "", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "permissionRequestFinishListener", "Lio/reactivex/Completable;", "requestDNDPermission", "permission", "requestPermission", "", "Ljava/util/ArrayList;", "Companion", "FocusAwareDialog", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class fwr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f17330O000000o = new O000000o((byte) 0);
    public DialogInterface.OnClickListener O00000Oo;
    public List<PermissionBean> O00000o;
    public Activity O00000o0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/SerialPermissionRequest$Companion;", "", "()V", "REQUEST_CODE", "", "TAG", "", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
     arg types: [java.util.Collection, java.util.List]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean */
    public final void O000000o(Activity activity, ArrayList<PermissionBean> arrayList) {
        ixe.O00000o(activity, "activity");
        ixe.O00000o(arrayList, "permissions");
        if (!arrayList.isEmpty()) {
            this.O00000o0 = activity;
            this.O00000o = arrayList;
            Iterable<PermissionBean> iterable = arrayList;
            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
            for (PermissionBean permissionBean : iterable) {
                arrayList2.add(permissionBean.f8043O000000o);
            }
            Collection arrayList3 = new ArrayList();
            for (String[] O000000o2 : (List) arrayList2) {
                iuo.O000000o(arrayList3, (Iterable) iuj.O000000o(O000000o2));
            }
            Object[] array = ((List) arrayList3).toArray(new String[0]);
            if (array != null) {
                oOOO00o0.O000000o(activity, (String[]) array, 6000);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static Completable O000000o() {
        CompletableSubject create = CompletableSubject.create();
        ixe.O00000Oo(create, "create()");
        create.doOnSubscribe(new Consumer() {
            /* class _m_j.$$Lambda$fwr$T6C7qlj2uNSbx63i1xqPAv2TpM */

            public final void accept(Object obj) {
                fwr.O000000o(CompletableSubject.this, (Disposable) obj);
            }
        });
        return create;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(CompletableSubject completableSubject, Disposable disposable) {
        ixe.O00000o(completableSubject, "$subject");
        completableSubject.onComplete();
    }

    public final Completable O000000o(PermissionBean permissionBean, Activity activity) {
        if (permissionBean == null || permissionBean.O00000Oo()) {
            Completable complete = Completable.complete();
            ixe.O00000Oo(complete, "complete()");
            return complete;
        }
        CompletableSubject create = CompletableSubject.create();
        ixe.O00000Oo(create, "create()");
        Completable doOnSubscribe = create.doOnSubscribe(new Consumer(create, activity, this) {
            /* class _m_j.$$Lambda$fwr$kakDKCnFZ4OI0B3qFSZMJJFJjsM */
            private final /* synthetic */ CompletableSubject f$1;
            private final /* synthetic */ Activity f$2;
            private final /* synthetic */ fwr f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void accept(Object obj) {
                fwr.O000000o(PermissionBean.this, this.f$1, this.f$2, this.f$3, (Disposable) obj);
            }
        });
        ixe.O00000Oo(doOnSubscribe, "permissionSubject.doOnSubscribe {\n            if (permission.isGranted()) {\n                //显示前判断是否已经获取了权限,获取了直接显示下一个\n                //因为用户可能在权限页面依次同意多个\n                permissionSubject.onComplete()\n                return@doOnSubscribe\n            }\n\n            val rationalName = try {\n                String.format(activity.getString(R.string.permission_tips_denied_msg), permission.name)\n            } catch (e: Exception) {\n                permission.desc\n            }\n\n            MiJiaLog.onlyLogcat(TAG, \"dialog：${permission.name}\")\n            FocusAwareDialog(permission, activity).apply {\n                setTitle(R.string.tips)\n                setMessage(rationalName)\n                setCancelable(false)\n                setButton(DialogInterface.BUTTON_POSITIVE, activity.getString(R.string.set_now)) { _, _ ->\n                    MiJiaLog.onlyLogcat(TAG, \"dialog positive：${permission.name}\")\n                    val settingService = AndPermission.permissionSetting(activity)\n                    if (CommonUtils.isMIUIInternational()) {\n                        settingService.executeDefault()\n                    } else {\n                        settingService.execute()\n                    }\n                }\n                setButton(DialogInterface.BUTTON_NEGATIVE, activity.getString(R.string.sh_common_cancel)) { v, w -> cancelListener?.onClick(v, w) }\n                setDismissCallBack(object : MLAlertDialog.DismissCallBack {\n                    override fun beforeDismissCallBack() {}\n                    override fun afterDismissCallBack() {\n                        // 弹出下一个dialog的时候延迟一下\n                        Handler().postDelayed({\n                            permissionSubject.onComplete()\n                        }, 100L)\n                    }\n                })\n                show()\n            }\n        }");
        return doOnSubscribe;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(PermissionBean permissionBean, CompletableSubject completableSubject, Activity activity, fwr fwr, Disposable disposable) {
        String str;
        ixe.O00000o(completableSubject, "$permissionSubject");
        ixe.O00000o(activity, "$activity");
        ixe.O00000o(fwr, "this$0");
        if (permissionBean.O00000Oo()) {
            completableSubject.onComplete();
            return;
        }
        try {
            ixh ixh = ixh.f1644O000000o;
            String string = activity.getString(R.string.permission_tips_denied_msg);
            ixe.O00000Oo(string, "activity.getString(R.string.permission_tips_denied_msg)");
            str = String.format(string, Arrays.copyOf(new Object[]{permissionBean.O00000Oo}, 1));
            ixe.O00000Oo(str, "java.lang.String.format(format, *args)");
        } catch (Exception unused) {
            str = permissionBean.O00000o0;
        }
        gsy.O00000Oo("SerialPermissionRequest", ixe.O000000o("dialog：", (Object) permissionBean.O00000Oo));
        O00000Oo o00000Oo = new O00000Oo(permissionBean, activity);
        o00000Oo.setTitle((int) R.string.tips);
        o00000Oo.setMessage(str);
        o00000Oo.setCancelable(false);
        o00000Oo.setButton(-1, activity.getString(R.string.set_now), new DialogInterface.OnClickListener(activity) {
            /* class _m_j.$$Lambda$fwr$iWUbqDyOy6f3a1lgM47pUJkTvU */
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                fwr.O000000o(PermissionBean.this, this.f$1, dialogInterface, i);
            }
        });
        o00000Oo.setButton(-2, activity.getString(R.string.sh_common_cancel), new DialogInterface.OnClickListener() {
            /* class _m_j.$$Lambda$fwr$iVkTx53fQZbMVRntQox4l2fqPs */

            public final void onClick(DialogInterface dialogInterface, int i) {
                fwr.O000000o(fwr.this, dialogInterface, i);
            }
        });
        o00000Oo.setDismissCallBack(new O00000o0(completableSubject));
        o00000Oo.show();
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/xiaomi/smarthome/framework/permission/SerialPermissionRequest$requestDNDPermission$1$1$3", "Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog$DismissCallBack;", "afterDismissCallBack", "", "beforeDismissCallBack", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 implements MLAlertDialog.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ CompletableSubject f17332O000000o;

        public final void beforeDismissCallBack() {
        }

        O00000o0(CompletableSubject completableSubject) {
            this.f17332O000000o = completableSubject;
        }

        public final void afterDismissCallBack() {
            new Handler().postDelayed(new Runnable() {
                /* class _m_j.$$Lambda$fwr$O00000o0$3eOV7OWlN199kFssN_lHY65nMhA */

                public final void run() {
                    fwr.O00000o0.O000000o(CompletableSubject.this);
                }
            }, 100);
        }

        /* access modifiers changed from: private */
        public static final void O000000o(CompletableSubject completableSubject) {
            ixe.O00000o(completableSubject, "$permissionSubject");
            completableSubject.onComplete();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/SerialPermissionRequest$FocusAwareDialog;", "Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog;", "permission", "Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "context", "Landroid/content/Context;", "(Lcom/xiaomi/smarthome/framework/permission/PermissionBean;Landroid/content/Context;)V", "onWindowFocusChanged", "", "hasFocus", "", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends MLAlertDialog {

        /* renamed from: O000000o  reason: collision with root package name */
        private final PermissionBean f17331O000000o;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean):void
         arg types: [android.content.Context, int]
         candidates:
          com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, int):void
          com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean):void */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(PermissionBean permissionBean, Context context) {
            super(context, true);
            ixe.O00000o(permissionBean, "permission");
            ixe.O00000o(context, "context");
            this.f17331O000000o = permissionBean;
        }

        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f17331O000000o.O00000Oo()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class _m_j.$$Lambda$fwr$O00000Oo$ca3r0Q5CfWsCiexxlmPAnQlho */

                    public final void run() {
                        fwr.O00000Oo.O000000o(fwr.O00000Oo.this);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000Oo o00000Oo) {
            ixe.O00000o(o00000Oo, "this$0");
            try {
                if (o00000Oo.isShowing()) {
                    o00000Oo.dismiss();
                }
            } catch (Exception unused) {
                gsy.O00000Oo("SerialPermissionRequest", "error");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(PermissionBean permissionBean, Activity activity, DialogInterface dialogInterface, int i) {
        ixe.O00000o(activity, "$activity");
        gsy.O00000Oo("SerialPermissionRequest", ixe.O000000o("dialog positive：", (Object) permissionBean.O00000Oo));
        inj O000000o2 = ind.O000000o(activity);
        ixe.O00000Oo(O000000o2, "permissionSetting(activity)");
        if (goy.O000000o()) {
            O000000o2.O00000o0();
        } else {
            O000000o2.O000000o();
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(fwr fwr, DialogInterface dialogInterface, int i) {
        ixe.O00000o(fwr, "this$0");
        DialogInterface.OnClickListener onClickListener = fwr.O00000Oo;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
    }
}
