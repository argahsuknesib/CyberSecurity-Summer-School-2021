package _m_j;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.youpin.login.entity.account.MiAccountInfo;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.Calendar;
import okhttp3.OkHttpClient;

public final class gyl {
    private static gyl O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public ShareUserRecord f18543O000000o;
    private OkHttpClient O00000o0 = new OkHttpClient();

    private gyl() {
    }

    public static synchronized gyl O000000o() {
        gyl gyl;
        synchronized (gyl.class) {
            if (O00000Oo == null) {
                O00000Oo = new gyl();
            }
            gyl = O00000Oo;
        }
        return gyl;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gyl.O000000o(java.lang.String, _m_j.ftt<com.xiaomi.smarthome.miio.db.record.ShareUserRecord>, boolean):void
     arg types: [java.lang.String, _m_j.gyl$1, int]
     candidates:
      _m_j.gyl.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView, com.facebook.imagepipeline.request.BasePostprocessor):void
      _m_j.gyl.O000000o(java.lang.String, _m_j.ftt<com.xiaomi.smarthome.miio.db.record.ShareUserRecord>, boolean):void */
    public void O000000o(String str, final SimpleDraweeView simpleDraweeView, BasePostprocessor basePostprocessor) {
        ShareUserRecord shareUserRecord = ShareUserRecord.get(str);
        if (shareUserRecord == null) {
            gsy.O000000o(3, "UserMamanger", "cannot get ShareUserRecord for ".concat(String.valueOf(str)));
        } else if (!TextUtils.isEmpty(shareUserRecord.url)) {
            O00000Oo(shareUserRecord.url, simpleDraweeView, null);
        } else if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            O000000o(str, (ftt<ShareUserRecord>) new ftt<ShareUserRecord>(null) {
                /* class _m_j.gyl.AnonymousClass1 */

                public final void O000000o(int i) {
                }

                public final void O000000o(int i, Object obj) {
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    ShareUserRecord shareUserRecord = (ShareUserRecord) obj;
                    if (shareUserRecord != null && shareUserRecord.url != null) {
                        gyl.O00000Oo(shareUserRecord.url, simpleDraweeView, null);
                    }
                }
            }, false);
        } else {
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageResource(R.drawable.user_not_log_in_v2);
            }
            if (ServiceApplication.shouldEnableBugly()) {
                CrashReport.O000000o(new RuntimeException("old userInfo server interface offline,please user new interface"));
            }
            gsy.O00000o0(LogType.GENERAL, "userInfo", "old userInfo server interface offline,please user new interface");
        }
    }

    public final void O000000o(final ftt<ShareUserRecord> ftt) {
        gty.O000000o().getMiUserInfoAndProfile(CoreApi.O000000o().O0000oOo(), new ibn<MiAccountInfo>() {
            /* class _m_j.gyl.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                MiAccountInfo miAccountInfo = (MiAccountInfo) obj;
                final ShareUserRecord shareUserRecord = new ShareUserRecord();
                shareUserRecord.nickName = miAccountInfo.O00000Oo;
                if (TextUtils.isEmpty(shareUserRecord.nickName)) {
                    shareUserRecord.nickName = miAccountInfo.O0000O0o;
                }
                shareUserRecord.userId = miAccountInfo.f12085O000000o;
                shareUserRecord.url = miAccountInfo.O00000o0;
                shareUserRecord.phone = miAccountInfo.O00000o;
                shareUserRecord.email = miAccountInfo.O00000oo;
                MiAccountInfo.Gender gender = miAccountInfo.O0000Oo0;
                if (gender != null && gender.name().equals("MALE")) {
                    shareUserRecord.sex = gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.sex_male);
                } else if (gender == null || !gender.name().equals("FEMALE")) {
                    shareUserRecord.sex = gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.not_set);
                } else {
                    shareUserRecord.sex = gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.sex_female);
                }
                Calendar calendar = miAccountInfo.O0000Oo;
                if (calendar != null) {
                    shareUserRecord.birth = String.format("%s/%s/%s", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
                }
                ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                    /* class _m_j.gyl.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        ShareUserRecord.update(shareUserRecord);
                    }
                });
                gyl.O000000o(shareUserRecord);
                ftt.O000000o(shareUserRecord);
            }

            public final void O000000o(int i, String str) {
                ftt.O000000o(-1);
            }

            public final void O000000o(MiServiceTokenInfo miServiceTokenInfo) {
                CoreApi.O000000o().O000000o(miServiceTokenInfo, new fsm<Void, fso>() {
                    /* class _m_j.gyl.AnonymousClass2.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }
                });
            }
        });
    }

    public final void O000000o(final String str, final ftt<ShareUserRecord> ftt, final boolean z) {
        ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.gyl.AnonymousClass3 */

            public final void run() {
                final ShareUserRecord shareUserRecord = ShareUserRecord.get(str);
                if ((shareUserRecord != null && TextUtils.isEmpty(shareUserRecord.url)) || z) {
                    if (!(shareUserRecord == null || TextUtils.isEmpty(shareUserRecord.url) || ftt == null)) {
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gyl.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                gyl.O000000o(shareUserRecord);
                                ftt.O000000o(shareUserRecord);
                            }
                        });
                    }
                    hys.O000000o().O000000o(ServiceApplication.getAppContext(), str, new fsm<UserInfo, fso>() {
                        /* class _m_j.gyl.AnonymousClass3.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            UserInfo userInfo = (UserInfo) obj;
                            if (shareUserRecord == null) {
                                gsy.O000000o(6, "UserManager", "ShareUserRecord is null");
                                return;
                            }
                            if (!TextUtils.isEmpty(userInfo.O00000o0)) {
                                shareUserRecord.url = userInfo.O00000o0;
                            }
                            shareUserRecord.nickName = userInfo.O00000oO;
                            ShareUserRecord.insert(shareUserRecord);
                            if (ftt != null) {
                                ServiceApplication.getGlobalHandler().post(new Runnable() {
                                    /* class _m_j.gyl.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        gyl.O000000o(shareUserRecord);
                                        ftt.O000000o(shareUserRecord);
                                    }
                                });
                            }
                        }

                        public final void onFailure(fso fso) {
                            if (ftt != null) {
                                ServiceApplication.getGlobalHandler().post(new Runnable() {
                                    /* class _m_j.gyl.AnonymousClass3.AnonymousClass2.AnonymousClass2 */

                                    public final void run() {
                                        ftt.O000000o(ErrorCode.ERROR_INVALID_REQUEST.getCode());
                                    }
                                });
                            }
                        }
                    });
                } else if (ftt != null) {
                    ServiceApplication.getGlobalHandler().post(new Runnable() {
                        /* class _m_j.gyl.AnonymousClass3.AnonymousClass3 */

                        public final void run() {
                            gyl.O000000o(shareUserRecord);
                            ftt.O000000o(shareUserRecord);
                        }
                    });
                }
            }
        });
    }

    public static void O000000o(ShareUserRecord shareUserRecord) {
        if (shareUserRecord != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.O00000o0 = shareUserRecord.url;
            userInfo.O00000oO = shareUserRecord.nickName;
            userInfo.f7549O000000o = shareUserRecord.userId;
            userInfo.O00000Oo = shareUserRecord.nickName;
            ggg.O000000o().f17738O000000o.put(Long.parseLong(userInfo.f7549O000000o), userInfo);
        }
    }

    public static boolean O000000o(String str, SimpleDraweeView simpleDraweeView) {
        String O000000o2 = grv.O000000o(str);
        Context appContext = ServiceApplication.getAppContext();
        String O00000o02 = gpy.O00000o0(appContext, "userinfo", O000000o2 + "key_user_avatar_cache", "");
        if (TextUtils.isEmpty(O00000o02)) {
            return false;
        }
        if (!ImagePipelineFactory.getInstance().getMainBufferedDiskCache().diskCheckSync(DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(O00000o02), null))) {
            return false;
        }
        try {
            simpleDraweeView.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController())).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(O00000o02)).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.DISK_CACHE).build())).build());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void O000000o(String str, String str2) {
        String O000000o2 = grv.O000000o(str);
        Context appContext = ServiceApplication.getAppContext();
        gpy.O000000o(appContext, "userinfo", O000000o2 + "key_user_avatar_cache", str2);
    }

    public static void O00000Oo(String str, SimpleDraweeView simpleDraweeView, BasePostprocessor basePostprocessor) {
        O000000o(CoreApi.O000000o().O0000o0(), str);
        if (Fresco.getDraweeControllerBuilderSupplier() != null && simpleDraweeView != null) {
            if (simpleDraweeView.getHierarchy() == null) {
                simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.default_icon_user240_nor)).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
            }
            if (TextUtils.isEmpty(str) || str.equals("null")) {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.user_default));
                return;
            }
            int lastIndexOf = str.lastIndexOf(".");
            String substring = str.substring(lastIndexOf - 4, lastIndexOf);
            if (!substring.contains("_320") && !substring.contains("_150")) {
                str = str.substring(0, lastIndexOf) + "_320" + str.substring(lastIndexOf);
            }
            if (basePostprocessor == null) {
                simpleDraweeView.setImageURI(Uri.parse(str));
                return;
            }
            simpleDraweeView.setController((PipelineDraweeController) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setPostprocessor(basePostprocessor).build())).setOldController(simpleDraweeView.getController())).build());
        }
    }
}
