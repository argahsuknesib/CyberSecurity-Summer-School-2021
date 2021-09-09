package _m_j;

import _m_j.fbm;
import _m_j.fbr;
import _m_j.hcc;
import _m_j.hcc.O000000o;
import _m_j.hlz;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;

public final class hcr<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    private hhk O0000Oo0;
    private TextView O0000OoO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o() {
        final View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_notsupport, this.O00000o0, false);
        this.O00000o0.addView(inflate);
        this.O0000OoO = (TextView) inflate.findViewById(R.id.unsupport_text);
        O000000o(this.O00000o0, this.O00000oO);
        if (!this.O00000oO.isOnline) {
            this.O0000OoO.setTextColor(this.O00000o0.getResources().getColor(R.color.mj_color_gray_lighter));
        }
        this.O0000Oo0 = (hhk) inflate.findViewById(R.id.dpb_enter_device);
        this.O0000Oo = inflate.findViewById(R.id.progress_enter_device);
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0(new fbm.O000000o() {
            /* class _m_j.hcr.AnonymousClass1 */

            public final void O000000o() {
                hlz.O000000o(hcr.this.O00000oO.model, new fsm<hlz.O000000o, fso>(new fbr.O000000o() {
                    /* class _m_j.hcr.AnonymousClass1.AnonymousClass1 */

                    public final void O000000o(String str) {
                        String str2;
                        if (TextUtils.isEmpty(str)) {
                            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(hcr.this.O00000oO.model);
                            if (O00000oO != null) {
                                str2 = O00000oO.O0000o0();
                            } else {
                                str2 = null;
                            }
                            if (str2 != null) {
                                hcr.this.O000000o(inflate, Uri.parse(str2));
                                return;
                            }
                            return;
                        }
                        hcr.this.O000000o(inflate, Uri.parse(str));
                    }
                }) {
                    /* class _m_j.fbr.AnonymousClass2 */

                    /* renamed from: O000000o */
                    final /* synthetic */ O000000o f16048O000000o;

                    public final void onFailure(fso fso) {
                    }

                    {
                        this.f16048O000000o = r1;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        hlz.O000000o o000000o = (hlz.O000000o) obj;
                        String str = o000000o != null ? o000000o.f19057O000000o : null;
                        O000000o o000000o2 = this.f16048O000000o;
                        if (o000000o2 != null) {
                            o000000o2.O000000o(str);
                        }
                    }
                });
            }
        }) {
            /* class _m_j.fbm.AnonymousClass1 */

            /* renamed from: O000000o */
            final /* synthetic */ O000000o f16042O000000o;

            {
                this.f16042O000000o = r1;
            }

            public final void onCoreReady() {
                O000000o o000000o = this.f16042O000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }

    public final void O000000o(final View view, Uri uri) {
        ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), null).subscribe(new BaseBitmapDataSubscriber() {
            /* class _m_j.hcr.AnonymousClass2 */

            public final void onFailureImpl(DataSource dataSource) {
            }

            public final void onNewResultImpl(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap);
                    hcr hcr = hcr.this;
                    View view = view;
                    view.post(new Runnable(view, createBitmap) {
                        /* class _m_j.hcr.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ View f18782O000000o;
                        final /* synthetic */ Bitmap O00000Oo;

                        {
                            this.f18782O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void run() {
                            ImageView imageView;
                            if (!((Activity) hcr.this.O00000o).isFinishing() && (imageView = (ImageView) this.f18782O000000o.findViewById(R.id.icon)) != null) {
                                imageView.setImageBitmap(this.O00000Oo);
                                ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) this.f18782O000000o.findViewById(R.id.unsupport_text), "translationY", 0.0f, (float) gpc.O000000o(this.f18782O000000o.getContext(), 70.0f));
                                ofFloat.setDuration(400L);
                                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
                                ofFloat2.setDuration(400L);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ofFloat, ofFloat2);
                                animatorSet.start();
                            }
                        }
                    });
                }
            }

            public final void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                super.onCancellation(dataSource);
            }
        }, CallerThreadExecutor.getInstance());
    }

    public final hhk O00000Oo() {
        return this.O0000Oo0;
    }

    public final View O00000o0() {
        return this.O0000Oo;
    }

    public hcr(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        super(c, arrayList, viewGroup, context, device);
    }
}
