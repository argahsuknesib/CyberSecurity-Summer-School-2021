package _m_j;

import _m_j.vr;
import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class vp<T, K extends vr> extends RecyclerView.O000000o<K> {
    protected static final String O0000OOo = "vp";

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f2551O000000o;
    public vv O00000Oo;
    public boolean O00000o;
    public O00000o O00000o0;
    public O00000Oo O00000oO;
    O00000o0 O00000oo;
    public O000000o O0000O0o;
    protected int O0000Oo;
    protected Context O0000Oo0;
    protected LayoutInflater O0000OoO;
    protected List<T> O0000Ooo;
    private boolean O0000o;
    boolean O0000o0;
    boolean O0000o00;
    public O0000O0o O0000o0O;
    vy<T> O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private boolean O0000oOO;
    private Interpolator O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private vu O0000ooO;
    private vu O0000ooo;
    private FrameLayout O000O00o;
    private boolean O000O0OO;
    private boolean O000O0Oo;
    private int O000O0o;
    private RecyclerView O000O0o0;
    private int O000O0oO;
    private boolean O00oOoOo;
    private LinearLayout O00oOooO;
    private LinearLayout O00oOooo;

    public interface O000000o {
        void O000000o(View view, int i);
    }

    public interface O00000Oo {
        void O000000o(int i);
    }

    public interface O00000o {
    }

    public interface O00000o0 {
        boolean O000000o();
    }

    public interface O0000O0o {
        int O000000o();
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(K k, T t);

    /* access modifiers changed from: protected */
    public boolean O00000o0(int i) {
        return i == 1365 || i == 273 || i == 819 || i == 546;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        vr vrVar = (vr) o000OOo0;
        super.onViewAttachedToWindow(vrVar);
        int itemViewType = vrVar.getItemViewType();
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            O000000o(vrVar);
        } else if (!this.O0000oOO) {
        } else {
            if (!this.O0000oO || vrVar.getLayoutPosition() > this.O0000oo) {
                vu vuVar = this.O0000ooO;
                if (vuVar == null) {
                    vuVar = this.O0000ooo;
                }
                Animator[] O000000o2 = vuVar.O000000o(vrVar.itemView);
                for (int i = 0; i <= 0; i++) {
                    Animator animator = O000000o2[0];
                    vrVar.getLayoutPosition();
                    animator.setDuration((long) this.O0000oo0).start();
                    animator.setInterpolator(this.O0000oOo);
                }
                this.O0000oo = vrVar.getLayoutPosition();
            }
        }
    }

    private int O00000o() {
        if (this.O00000o0 == null || !this.O0000o) {
            return 0;
        }
        if ((this.f2551O000000o || !this.O00000Oo.O00000Oo) && this.O0000Ooo.size() != 0) {
            return 1;
        }
        return 0;
    }

    public vp(int i, List<T> list) {
        this.f2551O000000o = false;
        this.O0000o = false;
        this.O0000oO0 = false;
        this.O00000Oo = new vw();
        this.O00000o = false;
        this.O0000oO = true;
        this.O0000oOO = false;
        this.O0000oOo = new LinearInterpolator();
        this.O0000oo0 = 300;
        this.O0000oo = -1;
        this.O0000ooo = new vt();
        this.O000O0OO = true;
        this.O000O0o = 1;
        this.O000O0oO = 1;
        this.O0000Ooo = list == null ? new ArrayList<>() : list;
        if (i != 0) {
            this.O0000Oo = i;
        }
    }

    public vp(List<T> list) {
        this(0, list);
    }

    public final List<T> O000000o() {
        return this.O0000Ooo;
    }

    public final T O000000o(int i) {
        if (i < 0 || i >= this.O0000Ooo.size()) {
            return null;
        }
        return this.O0000Ooo.get(i);
    }

    public final int O00000Oo() {
        LinearLayout linearLayout = this.O00oOooO;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    private int O00000oO() {
        LinearLayout linearLayout = this.O00oOooo;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    private int O00000oo() {
        FrameLayout frameLayout = this.O000O00o;
        if (frameLayout == null || frameLayout.getChildCount() == 0 || !this.O000O0OO || this.O0000Ooo.size() != 0) {
            return 0;
        }
        return 1;
    }

    public int getItemCount() {
        int i = 1;
        if (O00000oo() == 1) {
            if (this.O000O0Oo && O00000Oo() != 0) {
                i = 2;
            }
            if (!this.O00oOoOo || O00000oO() == 0) {
                return i;
            }
            return i + 1;
        }
        return O00000o() + O00000Oo() + this.O0000Ooo.size() + O00000oO();
    }

    public int getItemViewType(int i) {
        if (O00000oo() == 1) {
            boolean z = this.O000O0Oo && O00000Oo() != 0;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return 1365;
                    }
                    return 819;
                } else if (z) {
                    return 1365;
                } else {
                    return 819;
                }
            } else if (z) {
                return 273;
            } else {
                return 1365;
            }
        } else {
            int O00000Oo2 = O00000Oo();
            if (i < O00000Oo2) {
                return 273;
            }
            int i2 = i - O00000Oo2;
            int size = this.O0000Ooo.size();
            if (i2 < size) {
                return O00000Oo(i2);
            }
            if (i2 - size < O00000oO()) {
                return 819;
            }
            return 546;
        }
    }

    /* access modifiers changed from: protected */
    public int O00000Oo(int i) {
        vy<T> vyVar = this.O0000o0o;
        if (vyVar != null) {
            return vyVar.O000000o(this.O0000Ooo, i);
        }
        return super.getItemViewType(i);
    }

    public final void O00000o0() {
        if (this.O00000Oo.f2564O000000o != 2) {
            this.O00000Oo.f2564O000000o = 1;
            notifyItemChanged(O00000Oo() + this.O0000Ooo.size() + O00000oO());
        }
    }

    protected static void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) o000OOo0.itemView.getLayoutParams()).O00000Oo = true;
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.O00000Oo() {
                /* class _m_j.vp.AnonymousClass2 */

                public final int getSpanSize(int i) {
                    int itemViewType = vp.this.getItemViewType(i);
                    if (itemViewType == 273 && vp.this.O0000o00) {
                        return 1;
                    }
                    if (itemViewType == 819 && vp.this.O0000o0) {
                        return 1;
                    }
                    if (vp.this.O0000o0O == null) {
                        if (vp.this.O00000o0(itemViewType)) {
                            return gridLayoutManager.getSpanCount();
                        }
                        return 1;
                    } else if (vp.this.O00000o0(itemViewType)) {
                        return gridLayoutManager.getSpanCount();
                    } else {
                        O0000O0o o0000O0o = vp.this.O0000o0O;
                        vp.this.O00000Oo();
                        return o0000O0o.O000000o();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public K O000000o(ViewGroup viewGroup, int i) {
        int i2 = this.O0000Oo;
        vy<T> vyVar = this.O0000o0o;
        if (vyVar != null) {
            i2 = vyVar.O00000Oo.get(i, -404);
        }
        return O000000o(O000000o(i2, viewGroup));
    }

    /* access modifiers changed from: protected */
    public final K O000000o(View view) {
        K k;
        Class<?> cls = getClass();
        Class cls2 = null;
        while (cls2 == null && cls != null) {
            cls2 = O000000o(cls);
            cls = cls.getSuperclass();
        }
        if (cls2 == null) {
            k = new vr(view);
        } else {
            k = O000000o(cls2, view);
        }
        if (k != null) {
            return k;
        }
        return new vr(view);
    }

    private K O000000o(Class cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor declaredConstructor = cls.getDeclaredConstructor(View.class);
                declaredConstructor.setAccessible(true);
                return (vr) declaredConstructor.newInstance(view);
            }
            Constructor declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            declaredConstructor2.setAccessible(true);
            return (vr) declaredConstructor2.newInstance(this, view);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static Class O000000o(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (vr.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            } else if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    Class cls3 = (Class) rawType;
                    if (vr.class.isAssignableFrom(cls3)) {
                        return cls3;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final View O000000o(int i, ViewGroup viewGroup) {
        return this.O0000OoO.inflate(i, viewGroup, false);
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(K k, int i) {
        if (O00000o() != 0 && i >= getItemCount() - this.O000O0oO && this.O00000Oo.f2564O000000o == 1) {
            this.O00000Oo.f2564O000000o = 2;
            if (!this.O0000oO0) {
                this.O0000oO0 = true;
                RecyclerView recyclerView = this.O000O0o0;
                if (recyclerView != null) {
                    recyclerView.post(new Runnable() {
                        /* class _m_j.vp.AnonymousClass5 */

                        public final void run() {
                        }
                    });
                }
            }
        }
        int itemViewType = k.getItemViewType();
        if (itemViewType == 0) {
            O000000o(k, O000000o(i - O00000Oo()));
        } else if (itemViewType == 273) {
        } else {
            if (itemViewType == 546) {
                int i2 = this.O00000Oo.f2564O000000o;
                if (i2 == 1) {
                    vv.O000000o(k, false);
                    vv.O00000Oo(k, false);
                    vv.O00000o0(k, false);
                } else if (i2 == 2) {
                    vv.O000000o(k, true);
                    vv.O00000Oo(k, false);
                    vv.O00000o0(k, false);
                } else if (i2 == 3) {
                    vv.O000000o(k, false);
                    vv.O00000Oo(k, true);
                    vv.O00000o0(k, false);
                } else if (i2 == 4) {
                    vv.O000000o(k, false);
                    vv.O00000Oo(k, false);
                    vv.O00000o0(k, true);
                }
            } else if (itemViewType != 819 && itemViewType != 1365) {
                O000000o(k, O000000o(i - O00000Oo()));
            }
        }
    }

    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        final vr vrVar;
        View view;
        this.O0000Oo0 = viewGroup.getContext();
        this.O0000OoO = LayoutInflater.from(this.O0000Oo0);
        if (i == 273) {
            vrVar = O000000o(this.O00oOooO);
        } else if (i == 546) {
            vrVar = O000000o(O000000o(this.O00000Oo.O000000o(), viewGroup));
            vrVar.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.vp.AnonymousClass1 */

                public final void onClick(View view) {
                    if (vp.this.O00000Oo.f2564O000000o == 3) {
                        vp.this.O00000o0();
                    }
                    if (vp.this.O00000o && vp.this.O00000Oo.f2564O000000o == 4) {
                        vp.this.O00000o0();
                    }
                }
            });
        } else if (i == 819) {
            vrVar = O000000o(this.O00oOooo);
        } else if (i != 1365) {
            vrVar = O000000o(viewGroup, i);
            if (!(vrVar == null || (view = vrVar.itemView) == null)) {
                if (this.O00000oO != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.vp.AnonymousClass3 */

                        public final void onClick(View view) {
                            vp.this.O00000oO.O000000o(vrVar.getLayoutPosition() - vp.this.O00000Oo());
                        }
                    });
                }
                if (this.O00000oo != null) {
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class _m_j.vp.AnonymousClass4 */

                        public final boolean onLongClick(View view) {
                            vp vpVar = vp.this;
                            vrVar.getLayoutPosition();
                            vp.this.O00000Oo();
                            return vpVar.O00000oo.O000000o();
                        }
                    });
                }
            }
        } else {
            vrVar = O000000o(this.O000O00o);
        }
        vrVar.f2557O000000o = this;
        return vrVar;
    }
}
