package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/OperationImageCacheHelper;", "", "()V", "isImageCacheExist", "", "url", "", "loadCacheImgIntoView", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "prefetchImageToCache", "", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hkb {
    public static boolean O000000o(String str, SimpleDraweeView simpleDraweeView) {
        ixe.O00000o(str, "url");
        ixe.O00000o(simpleDraweeView, "imageView");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            AbstractDraweeController build = ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController())).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build())).build();
            ixe.O00000Oo(build, "newDraweeControllerBuilder()\n                    .setOldController(imageView.controller)\n                    .setImageRequest(request)\n                    .build()");
            simpleDraweeView.setController(build);
            simpleDraweeView.setImageURI(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
