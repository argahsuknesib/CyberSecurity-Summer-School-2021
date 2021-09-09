package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class jr {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.content.res.XmlResourceParser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.content.res.XmlResourceParser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.content.res.XmlResourceParser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.content.res.XmlResourceParser} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x014e  */
    public static Interpolator O000000o(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser;
        Interpolator juVar;
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        Interpolator interpolator = null;
        if (i == 17563663) {
            try {
                return new en();
            } catch (XmlPullParserException e) {
                e = e;
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (IOException e2) {
                e = e2;
                try {
                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException2.initCause(e);
                    throw notFoundException2;
                } catch (Throwable th) {
                    th = th;
                    xmlResourceParser = interpolator;
                    if (xmlResourceParser != 0) {
                    }
                    throw th;
                }
            }
        } else if (i == 17563661) {
            return new eo();
        } else {
            if (i == 17563662) {
                return new ep();
            }
            XmlResourceParser animation = context.getResources().getAnimation(i);
            try {
                context.getResources();
                context.getTheme();
                int depth = animation.getDepth();
                while (true) {
                    int next = animation.next();
                    if ((next != 3 || animation.getDepth() > depth) && next != 1) {
                        if (next == 2) {
                            AttributeSet asAttributeSet = Xml.asAttributeSet(animation);
                            String name = animation.getName();
                            if (name.equals("linearInterpolator")) {
                                interpolator = new LinearInterpolator();
                            } else {
                                if (name.equals("accelerateInterpolator")) {
                                    juVar = new AccelerateInterpolator(context, asAttributeSet);
                                } else if (name.equals("decelerateInterpolator")) {
                                    juVar = new DecelerateInterpolator(context, asAttributeSet);
                                } else if (name.equals("accelerateDecelerateInterpolator")) {
                                    interpolator = new AccelerateDecelerateInterpolator();
                                } else if (name.equals("cycleInterpolator")) {
                                    juVar = new CycleInterpolator(context, asAttributeSet);
                                } else if (name.equals("anticipateInterpolator")) {
                                    juVar = new AnticipateInterpolator(context, asAttributeSet);
                                } else if (name.equals("overshootInterpolator")) {
                                    juVar = new OvershootInterpolator(context, asAttributeSet);
                                } else if (name.equals("anticipateOvershootInterpolator")) {
                                    juVar = new AnticipateOvershootInterpolator(context, asAttributeSet);
                                } else if (name.equals("bounceInterpolator")) {
                                    interpolator = new BounceInterpolator();
                                } else if (name.equals("pathInterpolator")) {
                                    juVar = new ju(context, asAttributeSet, animation);
                                } else {
                                    throw new RuntimeException("Unknown interpolator name: " + animation.getName());
                                }
                                interpolator = juVar;
                            }
                        }
                    }
                }
                if (animation != 0) {
                    animation.close();
                }
                return interpolator;
            } catch (XmlPullParserException e3) {
                e = e3;
                Resources.NotFoundException notFoundException3 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException3.initCause(e);
                throw notFoundException3;
            } catch (IOException e4) {
                e = e4;
                interpolator = animation;
                Resources.NotFoundException notFoundException22 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException22.initCause(e);
                throw notFoundException22;
            } catch (Throwable th2) {
                th = th2;
                xmlResourceParser = animation;
                if (xmlResourceParser != 0) {
                    xmlResourceParser.close();
                }
                throw th;
            }
        }
    }
}
