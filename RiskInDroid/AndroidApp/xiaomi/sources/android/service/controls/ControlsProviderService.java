package android.service.controls;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.service.controls.Control;
import android.service.controls.IControlsProvider;
import android.service.controls.IControlsSubscription;
import android.service.controls.actions.ControlAction;
import android.service.controls.actions.ControlActionWrapper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.R;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import miui.systemui.controls.SignatureUtil;

public abstract class ControlsProviderService extends Service {
    public RequestHandler mHandler;
    public IBinder mToken;

    public abstract Flow.Publisher<Control> createPublisherFor(List<String> list);

    public abstract Flow.Publisher<Control> createPublisherForAllAvailable();

    public Flow.Publisher<Control> createPublisherForSuggested() {
        return null;
    }

    public abstract void performControlAction(String str, ControlAction controlAction, Consumer<Integer> consumer);

    public final IBinder onBind(Intent intent) {
        this.mHandler = new RequestHandler(Looper.getMainLooper());
        this.mToken = intent.getBundleExtra("CALLBACK_BUNDLE").getBinder("CALLBACK_TOKEN");
        final boolean securityCheck = securityCheck();
        return new IControlsProvider.Stub() {
            /* class android.service.controls.ControlsProviderService.AnonymousClass1 */

            public void load(IControlsSubscriber iControlsSubscriber) {
                if (securityCheck) {
                    ControlsProviderService.this.mHandler.obtainMessage(1, iControlsSubscriber).sendToTarget();
                }
            }

            public void loadSuggested(IControlsSubscriber iControlsSubscriber) {
                if (securityCheck) {
                    ControlsProviderService.this.mHandler.obtainMessage(4, iControlsSubscriber).sendToTarget();
                }
            }

            public void subscribe(List<String> list, IControlsSubscriber iControlsSubscriber) {
                if (securityCheck) {
                    ControlsProviderService.this.mHandler.obtainMessage(2, new SubscribeMessage(list, iControlsSubscriber)).sendToTarget();
                }
            }

            public void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) {
                if (securityCheck) {
                    ControlsProviderService.this.mHandler.obtainMessage(3, new ActionMessage(str, controlActionWrapper.getWrappedAction(), iControlsActionCallback)).sendToTarget();
                }
            }
        };
    }

    private boolean securityCheck() {
        if (Build.VERSION.SDK_INT < 30) {
            PackageManager packageManager = getPackageManager();
            try {
                PermissionInfo permissionInfo = packageManager.getPermissionInfo("android.permission.BIND_CONTROLS", NotificationCompat.FLAG_HIGH_PRIORITY);
                if (permissionInfo != null) {
                    if (permissionInfo.packageName != null) {
                        if (!SignatureUtil.compareSignatures(permissionInfo.packageName, "android", packageManager)) {
                            return false;
                        }
                    }
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        this.mHandler = null;
        return true;
    }

    class RequestHandler extends Handler {
        RequestHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ControlsProviderService.this.createPublisherForAllAvailable().subscribe(new SubscriberProxy(true, ControlsProviderService.this.mToken, (IControlsSubscriber) message.obj));
            } else if (i == 2) {
                SubscribeMessage subscribeMessage = (SubscribeMessage) message.obj;
                ControlsProviderService.this.createPublisherFor(subscribeMessage.mControlIds).subscribe(new SubscriberProxy(false, ControlsProviderService.this.mToken, subscribeMessage.mSubscriber));
            } else if (i == 3) {
                ActionMessage actionMessage = (ActionMessage) message.obj;
                ControlsProviderService.this.performControlAction(actionMessage.mControlId, actionMessage.mAction, consumerFor(actionMessage.mControlId, actionMessage.mCb));
            } else if (i == 4) {
                SubscriberProxy subscriberProxy = new SubscriberProxy(true, ControlsProviderService.this.mToken, (IControlsSubscriber) message.obj);
                Flow.Publisher<Control> createPublisherForSuggested = ControlsProviderService.this.createPublisherForSuggested();
                if (createPublisherForSuggested == null) {
                    Log.i("ControlsProviderService", "No publisher provided for suggested controls");
                    subscriberProxy.onComplete();
                    return;
                }
                createPublisherForSuggested.subscribe(subscriberProxy);
            }
        }

        private Consumer<Integer> consumerFor(final String str, final IControlsActionCallback iControlsActionCallback) {
            return new Consumer<Integer>() {
                /* class android.service.controls.ControlsProviderService.RequestHandler.AnonymousClass1 */

                public void accept(Integer num) {
                    Objects.requireNonNull(num);
                    if (!ControlAction.isValidResponse(num.intValue())) {
                        Log.e("ControlsProviderService", "Not valid response result: ".concat(String.valueOf(num)));
                        num = 0;
                    }
                    try {
                        iControlsActionCallback.accept(ControlsProviderService.this.mToken, str, num.intValue());
                    } catch (RemoteException unused) {
                    }
                }
            };
        }
    }

    public static boolean isStatelessControl(Control control) {
        return control.getStatus() == 0 && control.getControlTemplate().getTemplateType() == 0 && TextUtils.isEmpty(control.getStatusText());
    }

    static class SubscriberProxy implements Flow.Subscriber<Control> {
        private IControlsSubscriber mCs;
        private boolean mEnforceStateless;
        private IBinder mToken;

        SubscriberProxy(boolean z, IBinder iBinder, IControlsSubscriber iControlsSubscriber) {
            this.mEnforceStateless = z;
            this.mToken = iBinder;
            this.mCs = iControlsSubscriber;
        }

        public void onSubscribe(Flow.Subscription subscription) {
            try {
                this.mCs.onSubscribe(this.mToken, new SubscriptionAdapter(subscription));
            } catch (RemoteException unused) {
            }
        }

        public void onNext(Control control) {
            Objects.requireNonNull(control);
            try {
                if (this.mEnforceStateless && !ControlsProviderService.isStatelessControl(control)) {
                    Log.w("ControlsProviderService", "onNext(): control is not stateless. Use the Control.StatelessBuilder() to build the control.");
                    control = new Control.StatelessBuilder(control).build();
                }
                this.mCs.onNext(this.mToken, control);
            } catch (RemoteException unused) {
            }
        }

        public void onError(Throwable th) {
            try {
                this.mCs.onError(this.mToken, th.toString());
            } catch (RemoteException unused) {
            }
        }

        public void onComplete() {
            try {
                this.mCs.onComplete(this.mToken);
            } catch (RemoteException unused) {
            }
        }
    }

    public static void requestAddControl(Context context, ComponentName componentName, Control control) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(componentName);
        Objects.requireNonNull(control);
        String string = context.getString(R.string.config_controlsPackage);
        Intent intent = new Intent("android.service.controls.action.ADD_CONTROL");
        intent.putExtra("android.intent.extra.COMPONENT_NAME", componentName);
        intent.setPackage(string);
        if (isStatelessControl(control)) {
            intent.putExtra("android.service.controls.extra.CONTROL", control);
        } else {
            intent.putExtra("android.service.controls.extra.CONTROL", new Control.StatelessBuilder(control).build());
        }
        context.sendBroadcast(intent, "android.permission.BIND_CONTROLS");
    }

    static class SubscriptionAdapter extends IControlsSubscription.Stub {
        final Flow.Subscription mSubscription;

        SubscriptionAdapter(Flow.Subscription subscription) {
            this.mSubscription = subscription;
        }

        public void request(long j) {
            this.mSubscription.request(j);
        }

        public void cancel() {
            this.mSubscription.cancel();
        }
    }

    static class ActionMessage {
        final ControlAction mAction;
        final IControlsActionCallback mCb;
        final String mControlId;

        ActionMessage(String str, ControlAction controlAction, IControlsActionCallback iControlsActionCallback) {
            this.mControlId = str;
            this.mAction = controlAction;
            this.mCb = iControlsActionCallback;
        }
    }

    static class SubscribeMessage {
        final List<String> mControlIds;
        final IControlsSubscriber mSubscriber;

        SubscribeMessage(List<String> list, IControlsSubscriber iControlsSubscriber) {
            this.mControlIds = list;
            this.mSubscriber = iControlsSubscriber;
        }
    }
}
