package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;

public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();

    public static boolean canShow() {
        return true;
    }

    public static final class Result {
        String requestId;
        List<String> to;

        private Result(Bundle bundle) {
            this.requestId = bundle.getString("request");
            this.to = new ArrayList();
            while (true) {
                if (bundle.containsKey(String.format("to[%d]", Integer.valueOf(this.to.size())))) {
                    List<String> list = this.to;
                    list.add(bundle.getString(String.format("to[%d]", Integer.valueOf(list.size()))));
                } else {
                    return;
                }
            }
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final List<String> getRequestRecipients() {
            return this.to;
        }
    }

    public static void show(Activity activity, GameRequestContent gameRequestContent) {
        new GameRequestDialog(activity).show(gameRequestContent);
    }

    public static void show(Fragment fragment, GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    public static void show(android.app.Fragment fragment, GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, GameRequestContent gameRequestContent) {
        new GameRequestDialog(fragmentWrapper).show(gameRequestContent);
    }

    public GameRequestDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public GameRequestDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public GameRequestDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private GameRequestDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        final AnonymousClass1 r4;
        if (facebookCallback == null) {
            r4 = null;
        } else {
            r4 = new ResultProcessor(facebookCallback) {
                /* class com.facebook.share.widget.GameRequestDialog.AnonymousClass1 */

                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if (bundle != null) {
                        facebookCallback.onSuccess(new Result(bundle));
                    } else {
                        onCancel(appCall);
                    }
                }
            };
        }
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            /* class com.facebook.share.widget.GameRequestDialog.AnonymousClass2 */

            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), i, intent, r4);
            }
        });
    }

    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    public List<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WebHandler());
        return arrayList;
    }

    class WebHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        public boolean canShow(GameRequestContent gameRequestContent, boolean z) {
            return true;
        }

        private WebHandler() {
            super();
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "apprequests", WebDialogParameters.create(gameRequestContent));
            return createBaseAppCall;
        }
    }
}
