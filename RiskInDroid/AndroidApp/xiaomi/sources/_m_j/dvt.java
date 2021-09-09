package _m_j;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.image.ImageLoaderOptions;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public final class dvt {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile dvt f14978O000000o;
    private int O00000Oo = 1;

    private dvt() {
    }

    public static dvt O000000o() {
        if (f14978O000000o == null) {
            synchronized (uo.class) {
                if (f14978O000000o == null) {
                    f14978O000000o = new dvt();
                }
            }
        }
        return f14978O000000o;
    }

    public final void O000000o(ImageLoaderOptions imageLoaderOptions, int i) {
        this.O00000Oo = i;
        View view = imageLoaderOptions.f5978O000000o;
        view.setTag(imageLoaderOptions.O00000o0);
        Uri O000000o2 = O000000o(imageLoaderOptions);
        SimpleDraweeView O000000o3 = (!(view instanceof ImageView) || O000000o2 == null || O000000o2.toString().startsWith("file") || O000000o2.toString().startsWith("content")) ? null : O000000o(view, ImageView.class);
        if (O000000o3 != null) {
            O000000o(imageLoaderOptions, view, O000000o3, O000000o2);
        } else {
            O000000o(imageLoaderOptions, O000000o2);
        }
    }

    private void O000000o(ImageLoaderOptions imageLoaderOptions, View view, SimpleDraweeView simpleDraweeView, Uri uri) {
        GenericDraweeHierarchyBuilder newInstance = GenericDraweeHierarchyBuilder.newInstance(view.getContext().getResources());
        if (uri != null) {
            if (imageLoaderOptions.O00000oO != 0) {
                newInstance.setPlaceholderImage(imageLoaderOptions.O00000oO);
            } else if (imageLoaderOptions.O00000oo != null) {
                newInstance.setPlaceholderImage(imageLoaderOptions.O00000oo);
            }
            if (imageLoaderOptions.O0000OOo != 0) {
                newInstance.setFailureImage(imageLoaderOptions.O0000OOo);
            } else if (imageLoaderOptions.O0000Oo0 != null) {
                newInstance.setFailureImage(imageLoaderOptions.O0000Oo0);
            }
            if (!imageLoaderOptions.O0000Ooo) {
                newInstance.setFadeDuration(0);
            } else if (imageLoaderOptions.O0000Ooo && imageLoaderOptions.O0000oO0 > 0) {
                newInstance.setFadeDuration(imageLoaderOptions.O0000oO0);
            }
            if (imageLoaderOptions.O0000o0 == 1) {
                newInstance.setRoundingParams(new RoundingParams().setRoundAsCircle(true));
            }
            GenericDraweeHierarchy build = newInstance.build();
            O000000o(build, imageLoaderOptions);
            simpleDraweeView.setHierarchy(build);
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(uri).setAutoPlayAnimations(true);
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
            if (imageLoaderOptions.O0000O0o != null && imageLoaderOptions.O0000O0o.f5979O000000o > 0 && imageLoaderOptions.O0000O0o.O00000Oo > 0) {
                newBuilderWithSource.setResizeOptions(new ResizeOptions(imageLoaderOptions.O0000O0o.f5979O000000o, imageLoaderOptions.O0000O0o.O00000Oo));
            }
            if (imageLoaderOptions.O0000o0O.size() > 0 && imageLoaderOptions.O0000o0o != null) {
                newBuilderWithSource.setPostprocessor(new dvw(view.getContext(), imageLoaderOptions.O0000o0O, imageLoaderOptions.O0000o0o));
            }
            if (imageLoaderOptions.O0000oO != null && imageLoaderOptions.O0000oO.size() > 0) {
                newBuilderWithSource.setPostprocessor(new dvv(view.getContext(), imageLoaderOptions.O0000oO, imageLoaderOptions.O00000o0, view, imageLoaderOptions));
            }
            dvu dvu = new dvu(imageLoaderOptions.O0000o, imageLoaderOptions.O00000Oo, imageLoaderOptions.O00000o0);
            pipelineDraweeControllerBuilder.setControllerListener(dvu);
            if (imageLoaderOptions.O0000OoO) {
                newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).setDecodePreviewFrame(true).build());
            }
            pipelineDraweeControllerBuilder.setImageRequest(newBuilderWithSource.setProgressiveRenderingEnabled(true).build());
            AbstractDraweeController build2 = ((PipelineDraweeControllerBuilder) pipelineDraweeControllerBuilder.setOldController(simpleDraweeView.getController())).build();
            DraweeHolder create = DraweeHolder.create(build, imageLoaderOptions.f5978O000000o.getContext());
            create.setController(build2);
            dvu.f14987O000000o = create.getTopLevelDrawable();
            simpleDraweeView.setController(build2);
            O00000Oo(imageLoaderOptions, uri);
        }
    }

    private static SimpleDraweeView O000000o(View view, Class cls) {
        if (view instanceof SimpleDraweeView) {
            return (SimpleDraweeView) view;
        }
        if (!cls.isInstance(view)) {
            return null;
        }
        new FrameLayout(view.getContext());
        if (view.getParent() instanceof FrameLayout) {
            return O000000o((FrameLayout) view.getParent(), view, (FrameLayout.LayoutParams) view.getLayoutParams());
        }
        if (view.getParent() instanceof RelativeLayout) {
            return O000000o((RelativeLayout) view.getParent(), view, (RelativeLayout.LayoutParams) view.getLayoutParams());
        }
        return null;
    }

    private static SimpleDraweeView O000000o(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        ArrayList<View> arrayList = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= viewGroup.getChildCount()) {
                i2 = -1;
                break;
            } else if (view.equals(viewGroup.getChildAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (i2 - 1 != i3 && (childAt instanceof SimpleDraweeView) && "SimpleDraweeView".equals(childAt.getClass().getSimpleName())) {
                arrayList.add(childAt);
            }
        }
        for (View removeView : arrayList) {
            viewGroup.removeView(removeView);
        }
        arrayList.clear();
        while (true) {
            Drawable drawable = null;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            if (view.equals(viewGroup.getChildAt(i))) {
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    Drawable background = imageView.getBackground();
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    drawable = background;
                }
                int i4 = i - 1;
                if (i4 >= 0) {
                    View childAt2 = viewGroup.getChildAt(i4);
                    if ((childAt2 instanceof SimpleDraweeView) && "SimpleDraweeView".equals(childAt2.getClass().getSimpleName())) {
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) childAt2;
                        if (drawable != null) {
                            simpleDraweeView.setBackground(drawable);
                        }
                        return simpleDraweeView;
                    }
                }
                SimpleDraweeView simpleDraweeView2 = new SimpleDraweeView(view.getContext());
                if (drawable != null) {
                    simpleDraweeView2.setBackground(drawable);
                }
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                if (layoutParams.width == -2 && view.getMinimumWidth() > 0) {
                    layoutParams.width = view.getMinimumWidth();
                }
                if (layoutParams.height == -2 && view.getMinimumHeight() > 0) {
                    layoutParams.height = view.getMinimumHeight();
                }
                if (layoutParams.width == -2 && layoutParams.height == -2) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                simpleDraweeView2.setLayoutParams(layoutParams);
                viewGroup.addView(simpleDraweeView2, i);
                return simpleDraweeView2;
            }
            i++;
        }
    }

    /* renamed from: _m_j.dvt$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14985O000000o = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f14985O000000o[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            f14985O000000o[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            f14985O000000o[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            f14985O000000o[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            f14985O000000o[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            f14985O000000o[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            try {
                f14985O000000o[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public class O000000o implements View.OnAttachStateChangeListener {
        private DraweeHolder O00000Oo;

        public O000000o(DraweeHolder draweeHolder) {
            this.O00000Oo = draweeHolder;
        }

        public final void onViewAttachedToWindow(View view) {
            this.O00000Oo.onAttach();
        }

        public final void onViewDetachedFromWindow(View view) {
            this.O00000Oo.onDetach();
        }
    }

    private void O000000o(ImageLoaderOptions imageLoaderOptions, Uri uri) {
        ImageView imageView = (ImageView) imageLoaderOptions.f5978O000000o;
        if (uri == null) {
            Drawable drawable = imageLoaderOptions.O00000o;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        if (layoutParams.width == -2) {
            layoutParams.width = -1;
        }
        if (layoutParams.height == -2) {
            layoutParams.height = -1;
        }
        imageView.setLayoutParams(layoutParams);
        GenericDraweeHierarchyBuilder newInstance = GenericDraweeHierarchyBuilder.newInstance(imageView.getContext().getResources());
        GenericDraweeHierarchy build = newInstance.build();
        if (imageLoaderOptions.O00000oO != 0) {
            newInstance.setPlaceholderImage(imageLoaderOptions.O00000oO);
        } else if (imageLoaderOptions.O00000oo != null) {
            newInstance.setPlaceholderImage(imageLoaderOptions.O00000oo);
        }
        if (imageLoaderOptions.O0000OOo != 0) {
            newInstance.setFailureImage(imageLoaderOptions.O0000OOo);
        } else if (imageLoaderOptions.O0000Oo0 != null) {
            newInstance.setFailureImage(imageLoaderOptions.O0000Oo0);
        }
        if (!imageLoaderOptions.O0000Ooo) {
            newInstance.setFadeDuration(0);
        } else if (imageLoaderOptions.O0000Ooo && imageLoaderOptions.O0000oO0 > 0) {
            newInstance.setFadeDuration(imageLoaderOptions.O0000oO0);
        }
        if (imageLoaderOptions.O0000o0 == 1) {
            newInstance.setRoundingParams(new RoundingParams().setRoundAsCircle(true));
        }
        O000000o(build, imageLoaderOptions);
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(uri).setAutoPlayAnimations(true);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
        if (imageLoaderOptions.O0000O0o != null && imageLoaderOptions.O0000O0o.f5979O000000o > 0 && imageLoaderOptions.O0000O0o.O00000Oo > 0) {
            newBuilderWithSource.setResizeOptions(new ResizeOptions(imageLoaderOptions.O0000O0o.f5979O000000o, imageLoaderOptions.O0000O0o.f5979O000000o));
        }
        if (imageLoaderOptions.O0000o0O.size() > 0 && imageLoaderOptions.O0000o0o != null) {
            newBuilderWithSource.setPostprocessor(new dvw(imageView.getContext(), imageLoaderOptions.O0000o0O, imageLoaderOptions.O0000o0o));
        }
        if (imageLoaderOptions.O0000oO != null && imageLoaderOptions.O0000oO.size() > 0) {
            newBuilderWithSource.setPostprocessor(new dvv(imageView.getContext(), imageLoaderOptions.O0000oO, imageLoaderOptions.O00000o0, imageView, imageLoaderOptions));
        }
        if (imageLoaderOptions.O0000OoO) {
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).setDecodePreviewFrame(true).build());
        }
        pipelineDraweeControllerBuilder.setImageRequest(newBuilderWithSource.setProgressiveRenderingEnabled(true).build());
        dvu dvu = new dvu(imageLoaderOptions.O0000o, imageLoaderOptions.O00000Oo, imageLoaderOptions.O00000o0);
        pipelineDraweeControllerBuilder.setControllerListener(dvu);
        DraweeHolder create = DraweeHolder.create(build, imageLoaderOptions.f5978O000000o.getContext());
        create.setController(pipelineDraweeControllerBuilder.build());
        dvu.f14987O000000o = create.getTopLevelDrawable();
        imageView.addOnAttachStateChangeListener(new O000000o(create));
        if (cb.O000OO0o(imageView)) {
            create.onAttach();
        }
        imageView.setTag(R.id.fresco_drawee, create);
        imageView.setImageDrawable(create.getTopLevelDrawable());
        O00000Oo(imageLoaderOptions, uri);
    }

    private static void O00000Oo(ImageLoaderOptions imageLoaderOptions, Uri uri) {
        if (imageLoaderOptions.O0000o00 == ImageLoaderOptions.ImageLoaderDiskCacheStrategy.NONE) {
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            imagePipeline.evictFromMemoryCache(uri);
            imagePipeline.evictFromDiskCache(uri);
            imagePipeline.evictFromCache(uri);
        } else if (imageLoaderOptions.O0000o00 == ImageLoaderOptions.ImageLoaderDiskCacheStrategy.MEMORY) {
            Fresco.getImagePipeline().evictFromDiskCache(uri);
        } else if (imageLoaderOptions.O0000o00 == ImageLoaderOptions.ImageLoaderDiskCacheStrategy.DISK) {
            Fresco.getImagePipeline().evictFromMemoryCache(uri);
        }
    }

    public static Uri O000000o(ImageLoaderOptions imageLoaderOptions) {
        if (TextUtils.isEmpty(imageLoaderOptions.O00000o0)) {
            return null;
        }
        if (imageLoaderOptions.O00000o0.startsWith("http") || imageLoaderOptions.O00000o0.startsWith("res:///") || imageLoaderOptions.O00000o0.startsWith("data:") || imageLoaderOptions.O00000o0.startsWith("content://")) {
            return Uri.parse(imageLoaderOptions.O00000o0);
        }
        return Uri.parse("file://" + imageLoaderOptions.O00000o0);
    }

    private void O000000o(GenericDraweeHierarchy genericDraweeHierarchy, ImageLoaderOptions imageLoaderOptions) {
        ImageView imageView = (ImageView) imageLoaderOptions.f5978O000000o;
        int i = this.O00000Oo;
        if (i == 1) {
            switch (AnonymousClass3.f14985O000000o[imageView.getScaleType().ordinal()]) {
                case 1:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                    break;
                case 2:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
                    break;
                case 3:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                    break;
                case 4:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
                    break;
                case 5:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START);
                    break;
                case 6:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END);
                    break;
                case 7:
                    genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER);
                    break;
            }
            int i2 = imageLoaderOptions.O0000o0;
            if (i2 == 2) {
                genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            } else if (i2 == 3) {
                genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            } else if (i2 == 4) {
                genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
            }
        } else if (i == 2) {
            genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
    }
}
