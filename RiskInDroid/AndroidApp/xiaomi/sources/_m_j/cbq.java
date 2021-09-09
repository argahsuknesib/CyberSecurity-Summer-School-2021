package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import java.io.File;
import okhttp3.OkHttpClient;

public final class cbq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13601O000000o = "imageCache";

    public static void O000000o(final Context context, String str) {
        DiskCacheConfig build = DiskCacheConfig.newBuilder(context).setMaxCacheSize(104857600).setBaseDirectoryName(f13601O000000o).setBaseDirectoryPathSupplier(new Supplier<File>() {
            /* class _m_j.cbq.AnonymousClass1 */

            public final /* synthetic */ Object get() {
                return context.getCacheDir();
            }
        }).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        ImagePipelineConfig.Builder downsampleEnabled = OkHttpImagePipelineConfigFactory.newBuilder(context, builder.cookieJar(new cbp()).build()).setMainDiskCacheConfig(build).setDownsampleEnabled(true);
        if (!TextUtils.isEmpty(str) && !str.equals("mihome_sdk")) {
            downsampleEnabled.setBitmapMemoryCacheParamsSupplier(new cbo((ActivityManager) context.getSystemService("activity")));
        }
        Fresco.initialize(context, downsampleEnabled.build());
    }

    public static void O000000o(String str, SimpleDraweeView simpleDraweeView) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(Uri.parse(str), simpleDraweeView, null, 0, 0, null);
        }
    }

    public static void O000000o(Uri uri, SimpleDraweeView simpleDraweeView) {
        O000000o(uri, simpleDraweeView, null, 0, 0, null);
    }

    public static void O000000o(String str, SimpleDraweeView simpleDraweeView, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(Uri.fromFile(new File(str)), simpleDraweeView, null, i, i2, null);
        }
    }

    public static void O000000o(SimpleDraweeView simpleDraweeView, int i, int i2) {
        O000000o(O000000o(R.drawable.shop_add_image_icon), simpleDraweeView, null, i, i2, null);
    }

    public static void O000000o(int i, SimpleDraweeView simpleDraweeView) {
        O000000o(O000000o(i), simpleDraweeView, null, 0, 0, null);
    }

    private static void O000000o(Uri uri, SimpleDraweeView simpleDraweeView, BasePostprocessor basePostprocessor, int i, int i2, BaseControllerListener baseControllerListener) {
        if (uri != null) {
            simpleDraweeView.setController((PipelineDraweeController) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(cbl.O00000o0(uri.toString()))).setPostprocessor(null).setResizeOptions((i <= 0 || i2 <= 0) ? null : new ResizeOptions(i, i2)).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true).build())).setControllerListener(null)).setOldController(simpleDraweeView.getController())).setAutoPlayAnimations(true)).build());
        }
    }

    public static void O000000o() {
        Fresco.getImagePipeline().pause();
    }

    public static void O00000Oo() {
        Fresco.getImagePipeline().resume();
    }

    private static Uri O000000o(int i) {
        return Uri.parse("res://xxyy/".concat(String.valueOf(i)));
    }
}
