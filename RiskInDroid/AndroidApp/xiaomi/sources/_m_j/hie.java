package _m_j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.Stack;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0004J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0004J\u001d\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H$¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\"H$¢\u0006\u0002\u0010#J\u001d\u0010$\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u001aJ'\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00018\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0012H\u0014¢\u0006\u0002\u0010)J \u0010*\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/SimplePageAdapter;", "T", "Landroid/view/View;", "Landroidx/viewpager/widget/PagerAdapter;", "()V", "<set-?>", "currentPage", "getCurrentPage", "()Landroid/view/View;", "Landroid/view/View;", "mViewStack", "Ljava/util/Stack;", "clearViewCache", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "getItemPosition", "getViewCache", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "isViewFromObject", "", "view", "onBindView", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "onCreateNewInstance", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Landroid/view/View;", "onCreateView", "onPrimaryItemChanged", "old", "current", "pos", "(Landroid/view/View;Landroid/view/View;I)V", "setPrimaryItem", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class hie<T extends View> extends jz {
    public T O0000OOo;
    protected final Stack<T> O0000Oo0 = new Stack<>();

    /* access modifiers changed from: protected */
    public abstract T O000000o(Context context);

    /* access modifiers changed from: protected */
    public void O000000o(T t, T t2, int i) {
        ixe.O00000o(t2, "current");
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(ViewGroup viewGroup, T t, int i);

    public int getItemPosition(Object obj) {
        ixe.O00000o(obj, "obj");
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        ixe.O00000o(view, "view");
        ixe.O00000o(obj, "obj");
        return obj == view;
    }

    public /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
        View view;
        ixe.O00000o(viewGroup, "container");
        if (this.O0000Oo0.size() > 0) {
            T pop = this.O0000Oo0.pop();
            ixe.O00000Oo(pop, "{\n            mViewStack.pop()\n        }");
            view = (View) pop;
        } else {
            Context context = viewGroup.getContext();
            ixe.O00000Oo(context, "container.context");
            view = O000000o(context);
        }
        viewGroup.addView(view, -1);
        O000000o(viewGroup, view, i);
        return view;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ixe.O00000o(viewGroup, "container");
        ixe.O00000o(obj, "obj");
        View view = (View) obj;
        viewGroup.removeView(view);
        if (!this.O0000Oo0.contains(view)) {
            this.O0000Oo0.push(view);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hie.O000000o(android.view.View, android.view.View, int):void
     arg types: [T, T, int]
     candidates:
      _m_j.hie.O000000o(android.view.ViewGroup, android.view.View, int):void
      _m_j.hie.O000000o(android.view.View, android.view.View, int):void */
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        ixe.O00000o(viewGroup, "container");
        ixe.O00000o(obj, "obj");
        T t = (View) obj;
        T t2 = this.O0000OOo;
        if (t != t2) {
            O000000o((View) t2, (View) t, i);
            this.O0000OOo = t;
        }
    }
}
