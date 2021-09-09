package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.AppInviteDialogFeature;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class AppInviteDialog extends FacebookDialogBase<AppInviteContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppInvite.toRequestCode();

    @Deprecated
    public static boolean canShow() {
        return false;
    }

    private static boolean canShowNativeDialog() {
        return false;
    }

    private static boolean canShowWebFallback() {
        return false;
    }

    @Deprecated
    public void show(AppInviteContent appInviteContent) {
    }

    @Deprecated
    public static final class Result {
        private final Bundle bundle;

        public Result(Bundle bundle2) {
            this.bundle = bundle2;
        }

        public final Bundle getData() {
            return this.bundle;
        }
    }

    @Deprecated
    public static void show(Activity activity, AppInviteContent appInviteContent) {
        new AppInviteDialog(activity).show(appInviteContent);
    }

    @Deprecated
    public static void show(Fragment fragment, AppInviteContent appInviteContent) {
        show(new FragmentWrapper(fragment), appInviteContent);
    }

    @Deprecated
    public static void show(android.app.Fragment fragment, AppInviteContent appInviteContent) {
        show(new FragmentWrapper(fragment), appInviteContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, AppInviteContent appInviteContent) {
        new AppInviteDialog(fragmentWrapper).show(appInviteContent);
    }

    @Deprecated
    public AppInviteDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    @Deprecated
    public AppInviteDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Deprecated
    public AppInviteDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private AppInviteDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        final AnonymousClass1 r3;
        if (facebookCallback == null) {
            r3 = null;
        } else {
            r3 = new ResultProcessor(facebookCallback) {
                /* class com.facebook.share.widget.AppInviteDialog.AnonymousClass1 */

                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(bundle))) {
                        facebookCallback.onCancel();
                    } else {
                        facebookCallback.onSuccess(new Result(bundle));
                    }
                }
            };
        }
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            /* class com.facebook.share.widget.AppInviteDialog.AnonymousClass2 */

            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(AppInviteDialog.this.getRequestCode(), i, intent, r3);
            }
        });
    }

    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    public List<FacebookDialogBase<AppInviteContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new WebFallbackHandler());
        return arrayList;
    }

    class NativeHandler extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        public boolean canShow(AppInviteContent appInviteContent, boolean z) {
            return false;
        }

        private NativeHandler() {
            super();
        }

        public AppCall createAppCall(final AppInviteContent appInviteContent) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() {
                /* class com.facebook.share.widget.AppInviteDialog.NativeHandler.AnonymousClass1 */

                public Bundle getParameters() {
                    return AppInviteDialog.createParameters(appInviteContent);
                }

                public Bundle getLegacyParameters() {
                    Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
                    return new Bundle();
                }
            }, AppInviteDialog.getFeature());
            return createBaseAppCall;
        }
    }

    class WebFallbackHandler extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        public boolean canShow(AppInviteContent appInviteContent, boolean z) {
            return false;
        }

        private WebFallbackHandler() {
            super();
        }

        public AppCall createAppCall(AppInviteContent appInviteContent) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, AppInviteDialog.createParameters(appInviteContent), AppInviteDialog.getFeature());
            return createBaseAppCall;
        }
    }

    public static DialogFeature getFeature() {
        return AppInviteDialogFeature.APP_INVITES_DIALOG;
    }

    public static Bundle createParameters(AppInviteContent appInviteContent) {
        Bundle bundle = new Bundle();
        bundle.putString("app_link_url", appInviteContent.getApplinkUrl());
        bundle.putString("preview_image_url", appInviteContent.getPreviewImageUrl());
        bundle.putString("destination", appInviteContent.getDestination().toString());
        String promotionCode = appInviteContent.getPromotionCode();
        if (promotionCode == null) {
            promotionCode = "";
        }
        String promotionText = appInviteContent.getPromotionText();
        if (!TextUtils.isEmpty(promotionText)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("promo_code", promotionCode);
                jSONObject.put("promo_text", promotionText);
                bundle.putString("deeplink_context", jSONObject.toString());
                bundle.putString("promo_code", promotionCode);
                bundle.putString("promo_text", promotionText);
            } catch (JSONException unused) {
                Log.e("AppInviteDialog", "Json Exception in creating deeplink context");
            }
        }
        return bundle;
    }
}
