package _m_j;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Iterator;
import java.util.List;

public final class dvu extends BaseControllerListener<ImageInfo> {

    /* renamed from: O000000o  reason: collision with root package name */
    Drawable f14987O000000o = null;
    private List<vg> O00000Oo;
    private String O00000o;
    private vl O00000o0;

    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String str, Object obj) {
    }

    public final /* synthetic */ void onFinalImageSet(String str, Object obj, Animatable animatable) {
        if (((ImageInfo) obj) != null) {
            vl vlVar = this.O00000o0;
            if (vlVar != null) {
                vlVar.O000000o(this.f14987O000000o);
            }
            List<vg> list = this.O00000Oo;
            if (list != null && list.size() > 0) {
                Iterator<vg> it = this.O00000Oo.iterator();
                while (it.hasNext()) {
                    it.next();
                    DataSource dataSource = DataSource.DATA_DISK_CACHE;
                }
            }
        }
    }

    public dvu(List<vg> list, vl vlVar, String str) {
        this.O00000Oo = list;
        this.O00000o0 = vlVar;
        this.O00000o = str;
    }

    public final void onFailure(String str, Throwable th) {
        new GlideException(th.getMessage());
        List<vg> list = this.O00000Oo;
        if (list != null && list.size() > 0) {
            for (vg O000000o2 : this.O00000Oo) {
                O000000o2.O000000o();
            }
        }
    }
}
