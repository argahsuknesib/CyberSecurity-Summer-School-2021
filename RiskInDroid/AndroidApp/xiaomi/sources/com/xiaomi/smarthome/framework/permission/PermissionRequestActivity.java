package com.xiaomi.smarthome.framework.permission;

import _m_j.gpc;
import _m_j.iuo;
import _m_j.ixe;
import _m_j.ixh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.permission.PermissionRequestActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "backBtn", "Landroid/view/View;", "checkedPermissions", "Ljava/util/HashSet;", "Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "Lkotlin/collections/HashSet;", "permissions", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "selectAllBtn", "selectAllCheckBox", "Landroid/widget/CheckBox;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Adapter", "Companion", "ItemDivider", "MyViewHolder", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PermissionRequestActivity extends BaseActivity {
    public static final O00000Oo Companion = new O00000Oo((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f8044O000000o;
    private View O00000Oo;
    private View O00000o0;
    public HashSet<PermissionBean> checkedPermissions = new HashSet<>();
    public List<PermissionBean> permissions;
    public CheckBox selectAllCheckBox;

    public final void _$_clearFindViewByIdCache() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\u0012\u001a\u00020\n2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity$Companion;", "", "()V", "ANIMATION_DURATION", "", "ARG_KEYS_PERMISSION", "", "REQUEST_CODE", "", "check", "", "activity", "Landroid/app/Activity;", "permissions", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "Lkotlin/collections/ArrayList;", "checkPermissionPass", "shouldShow", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {
        public /* synthetic */ O00000Oo(byte b) {
            this();
        }

        private O00000Oo() {
        }

        public final boolean O000000o(Activity activity) {
            ixe.O00000o(activity, "activity");
            String string = activity.getString(R.string.permission_name_location);
            ixe.O00000Oo(string, "activity.getString(R.string.permission_name_location)");
            String string2 = activity.getString(R.string.permission_location_rational_desc_new);
            ixe.O00000Oo(string2, "activity.getString(R.string.permission_location_rational_desc_new)");
            return O000000o(activity, iuo.O00000o0(new PermissionBean(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, string, string2)));
        }

        private static boolean O000000o(Activity activity, ArrayList<PermissionBean> arrayList) {
            ixe.O00000o(activity, "activity");
            ixe.O00000o(arrayList, "permissions");
            Iterable iterable = arrayList;
            Collection arrayList2 = new ArrayList();
            Iterator it = iterable.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                PermissionBean permissionBean = (PermissionBean) next;
                if (!permissionBean.O000000o() && !permissionBean.O00000Oo()) {
                    z = true;
                }
                if (z) {
                    arrayList2.add(next);
                }
            }
            if (((List) arrayList2).isEmpty()) {
                return false;
            }
            Collection arrayList3 = new ArrayList();
            for (Object next2 : iterable) {
                PermissionBean permissionBean2 = (PermissionBean) next2;
                if ((!permissionBean2.O00000Oo()) || permissionBean2.O000000o()) {
                    arrayList3.add(next2);
                }
            }
            Intent intent = new Intent(activity, PermissionRequestActivity.class);
            intent.putParcelableArrayListExtra("arg_keys_permission", (ArrayList) arrayList3);
            activity.startActivityForResult(intent, 6050);
            return true;
        }

        public static boolean O00000Oo(Activity activity) {
            ixe.O00000o(activity, "activity");
            String string = activity.getString(R.string.permission_name_location);
            ixe.O00000Oo(string, "activity.getString(R.string.permission_name_location)");
            String string2 = activity.getString(R.string.permission_location_rational_desc_new);
            ixe.O00000Oo(string2, "activity.getString(R.string.permission_location_rational_desc_new)");
            PermissionBean[] permissionBeanArr = {new PermissionBean(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, string, string2)};
            Collection arrayList = new ArrayList();
            for (Object next : iuo.O00000o0(permissionBeanArr)) {
                PermissionBean permissionBean = (PermissionBean) next;
                if (!permissionBean.O000000o() && !permissionBean.O00000Oo()) {
                    arrayList.add(next);
                }
            }
            return ((List) arrayList).isEmpty();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.framework.permission.PermissionRequestActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_permission_request);
        if (bundle != null) {
            finish();
            return;
        }
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("arg_keys_permission");
        ixe.O00000Oo(parcelableArrayListExtra, "intent.getParcelableArrayListExtra(ARG_KEYS_PERMISSION)");
        this.permissions = parcelableArrayListExtra;
        List<PermissionBean> list = this.permissions;
        if (list == null) {
            ixe.O000000o("permissions");
            throw null;
        } else if (list.isEmpty()) {
            finish();
        } else {
            View findViewById = findViewById(R.id.recycler);
            ixe.O00000Oo(findViewById, "findViewById(R.id.recycler)");
            this.f8044O000000o = (RecyclerView) findViewById;
            RecyclerView recyclerView = this.f8044O000000o;
            if (recyclerView != null) {
                recyclerView.setHasFixedSize(true);
                RecyclerView recyclerView2 = this.f8044O000000o;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(this));
                    RecyclerView recyclerView3 = this.f8044O000000o;
                    if (recyclerView3 != null) {
                        recyclerView3.setAdapter(new O000000o(this));
                        RecyclerView recyclerView4 = this.f8044O000000o;
                        if (recyclerView4 != null) {
                            recyclerView4.addItemDecoration(new O00000o0(gpc.O000000o((Activity) this, 24.0f)));
                            ((TextView) findViewById(R.id.next_btn)).setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.framework.permission.$$Lambda$PermissionRequestActivity$fXepK06rmxdFtR9dKnfrQCR6Zdk */

                                public final void onClick(View view) {
                                    PermissionRequestActivity.O000000o(PermissionRequestActivity.this, view);
                                }
                            });
                            List<PermissionBean> list2 = this.permissions;
                            if (list2 != null) {
                                Collection arrayList = new ArrayList();
                                for (Object next : list2) {
                                    if (!((PermissionBean) next).O00000o) {
                                        arrayList.add(next);
                                    }
                                }
                                this.checkedPermissions.addAll((List) arrayList);
                                View findViewById2 = findViewById(R.id.select_all_check_box);
                                ixe.O00000Oo(findViewById2, "findViewById<CheckBox>(R.id.select_all_check_box)");
                                this.selectAllCheckBox = (CheckBox) findViewById2;
                                CheckBox checkBox = this.selectAllCheckBox;
                                if (checkBox != null) {
                                    int size = this.checkedPermissions.size();
                                    List<PermissionBean> list3 = this.permissions;
                                    if (list3 != null) {
                                        checkBox.setChecked(size == list3.size());
                                        View findViewById3 = findViewById(R.id.select_all);
                                        ixe.O00000Oo(findViewById3, "findViewById<View>(R.id.select_all)");
                                        this.O00000Oo = findViewById3;
                                        View view = this.O00000Oo;
                                        if (view != null) {
                                            view.setOnClickListener(new View.OnClickListener() {
                                                /* class com.xiaomi.smarthome.framework.permission.$$Lambda$PermissionRequestActivity$MAVXGAtV22HGxgO3Mwx_1Sf8Yk */

                                                public final void onClick(View view) {
                                                    PermissionRequestActivity.O00000Oo(PermissionRequestActivity.this, view);
                                                }
                                            });
                                            try {
                                                ixh ixh = ixh.f1644O000000o;
                                                String string = getString(R.string.we_wanna_require_those_permissions);
                                                ixe.O00000Oo(string, "getString(R.string.we_wanna_require_those_permissions)");
                                                str = String.format(string, Arrays.copyOf(new Object[]{getString(R.string.app_name2)}, 1));
                                                ixe.O00000Oo(str, "java.lang.String.format(format, *args)");
                                            } catch (Exception unused) {
                                                str = getString(R.string.we_wanna_require_those_permissions);
                                                ixe.O00000Oo(str, "{\n            getString(R.string.we_wanna_require_those_permissions)\n        }");
                                            }
                                            ((TextView) findViewById(R.id.request_permission_desc)).setText(str);
                                            View view2 = this.O00000Oo;
                                            if (view2 != null) {
                                                view2.setBackgroundResource(R.drawable.selector_list_item_new);
                                                View findViewById4 = findViewById(R.id.module_a_3_return_btn);
                                                ixe.O00000Oo(findViewById4, "findViewById<TextView>(R.id.module_a_3_return_btn)");
                                                this.O00000o0 = findViewById4;
                                                View view3 = this.O00000o0;
                                                if (view3 != null) {
                                                    view3.setOnClickListener(new View.OnClickListener() {
                                                        /* class com.xiaomi.smarthome.framework.permission.$$Lambda$PermissionRequestActivity$3CWNIrWZlqfF6i6btgRp8ZLPR8 */

                                                        public final void onClick(View view) {
                                                            PermissionRequestActivity.O00000o0(PermissionRequestActivity.this, view);
                                                        }
                                                    });
                                                } else {
                                                    ixe.O000000o("backBtn");
                                                    throw null;
                                                }
                                            } else {
                                                ixe.O000000o("selectAllBtn");
                                                throw null;
                                            }
                                        } else {
                                            ixe.O000000o("selectAllBtn");
                                            throw null;
                                        }
                                    } else {
                                        ixe.O000000o("permissions");
                                        throw null;
                                    }
                                } else {
                                    ixe.O000000o("selectAllCheckBox");
                                    throw null;
                                }
                            } else {
                                ixe.O000000o("permissions");
                                throw null;
                            }
                        } else {
                            ixe.O000000o("recyclerView");
                            throw null;
                        }
                    } else {
                        ixe.O000000o("recyclerView");
                        throw null;
                    }
                } else {
                    ixe.O000000o("recyclerView");
                    throw null;
                }
            } else {
                ixe.O000000o("recyclerView");
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(PermissionRequestActivity permissionRequestActivity, View view) {
        ixe.O00000o(permissionRequestActivity, "this$0");
        Intent intent = new Intent();
        Collection arrayList = new ArrayList();
        for (Object next : permissionRequestActivity.checkedPermissions) {
            if (!((PermissionBean) next).O000000o()) {
                arrayList.add(next);
            }
        }
        intent.putParcelableArrayListExtra("arg_keys_permission", new ArrayList((List) arrayList));
        permissionRequestActivity.setResult(-1, intent);
        permissionRequestActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(PermissionRequestActivity permissionRequestActivity, View view) {
        ixe.O00000o(permissionRequestActivity, "this$0");
        CheckBox checkBox = permissionRequestActivity.selectAllCheckBox;
        if (checkBox != null) {
            checkBox.toggle();
            CheckBox checkBox2 = permissionRequestActivity.selectAllCheckBox;
            if (checkBox2 != null) {
                if (checkBox2.isChecked()) {
                    permissionRequestActivity.checkedPermissions.clear();
                    HashSet<PermissionBean> hashSet = permissionRequestActivity.checkedPermissions;
                    List<PermissionBean> list = permissionRequestActivity.permissions;
                    if (list != null) {
                        hashSet.addAll(list);
                    } else {
                        ixe.O000000o("permissions");
                        throw null;
                    }
                } else {
                    HashSet<PermissionBean> hashSet2 = permissionRequestActivity.checkedPermissions;
                    Collection arrayList = new ArrayList();
                    for (Object next : hashSet2) {
                        if (((PermissionBean) next).O00000o) {
                            arrayList.add(next);
                        }
                    }
                    hashSet2.removeAll((List) arrayList);
                }
                RecyclerView recyclerView = permissionRequestActivity.f8044O000000o;
                if (recyclerView != null) {
                    RecyclerView.O000000o adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        List<PermissionBean> list2 = permissionRequestActivity.permissions;
                        if (list2 != null) {
                            int size = list2.size();
                            CheckBox checkBox3 = permissionRequestActivity.selectAllCheckBox;
                            if (checkBox3 != null) {
                                adapter.notifyItemRangeChanged(0, size, Boolean.valueOf(checkBox3.isChecked()));
                            } else {
                                ixe.O000000o("selectAllCheckBox");
                                throw null;
                            }
                        } else {
                            ixe.O000000o("permissions");
                            throw null;
                        }
                    }
                } else {
                    ixe.O000000o("recyclerView");
                    throw null;
                }
            } else {
                ixe.O000000o("selectAllCheckBox");
                throw null;
            }
        } else {
            ixe.O000000o("selectAllCheckBox");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(PermissionRequestActivity permissionRequestActivity, View view) {
        ixe.O00000o(permissionRequestActivity, "this$0");
        permissionRequestActivity.onBackPressed();
    }

    public final void onResume() {
        super.onResume();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 24 ? isInMultiWindowMode() : false) {
            i = 8;
        }
        findViewById(R.id._icon).setVisibility(i);
        findViewById(R.id._app_name).setVisibility(i);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J*\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity$MyViewHolder;", "Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity;", "(Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends RecyclerView.O000000o<O00000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ PermissionRequestActivity f8045O000000o;

        public O000000o(PermissionRequestActivity permissionRequestActivity) {
            ixe.O00000o(permissionRequestActivity, "this$0");
            this.f8045O000000o = permissionRequestActivity;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000o o00000o = (O00000o) o000OOo0;
            ixe.O00000o(o00000o, "holder");
            List<PermissionBean> list = this.f8045O000000o.permissions;
            if (list != null) {
                o00000o.O000000o(list.get(i));
            } else {
                ixe.O000000o("permissions");
                throw null;
            }
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
            O00000o o00000o = (O00000o) o000OOo0;
            ixe.O00000o(o00000o, "holder");
            ixe.O00000o(list, "payloads");
            if (list.isEmpty()) {
                super.onBindViewHolder(o00000o, i, list);
                return;
            }
            boolean z = false;
            Object obj = list.get(0);
            CheckBox checkBox = o00000o.f8046O000000o;
            if (checkBox != null) {
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                checkBox.setChecked(z);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = this.f8045O000000o.getLayoutInflater().inflate((int) R.layout.permission_item, viewGroup, false);
            inflate.setBackgroundResource(R.drawable.selector_list_item_new);
            PermissionRequestActivity permissionRequestActivity = this.f8045O000000o;
            ixe.O00000Oo(inflate, "item");
            return new O00000o(permissionRequestActivity, inflate);
        }

        public final int getItemCount() {
            List<PermissionBean> list = this.f8045O000000o.permissions;
            if (list != null) {
                return list.size();
            }
            ixe.O000000o("permissions");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "bind", "", "permissionBean", "Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        CheckBox f8046O000000o;
        final /* synthetic */ PermissionRequestActivity O00000Oo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000o(PermissionRequestActivity permissionRequestActivity, View view) {
            super(view);
            ixe.O00000o(permissionRequestActivity, "this$0");
            ixe.O00000o(view, "view");
            this.O00000Oo = permissionRequestActivity;
        }

        /* access modifiers changed from: private */
        public static final void O000000o(PermissionRequestActivity permissionRequestActivity, PermissionBean permissionBean, CompoundButton compoundButton, boolean z) {
            ixe.O00000o(permissionRequestActivity, "this$0");
            ixe.O00000o(permissionBean, "$permissionBean");
            if (z) {
                permissionRequestActivity.checkedPermissions.add(permissionBean);
            } else {
                permissionRequestActivity.checkedPermissions.remove(permissionBean);
            }
            CheckBox checkBox = permissionRequestActivity.selectAllCheckBox;
            if (checkBox != null) {
                List<PermissionBean> list = permissionRequestActivity.permissions;
                if (list != null) {
                    checkBox.setChecked(list.size() == permissionRequestActivity.checkedPermissions.size());
                } else {
                    ixe.O000000o("permissions");
                    throw null;
                }
            } else {
                ixe.O000000o("selectAllCheckBox");
                throw null;
            }
        }

        public final void O000000o(PermissionBean permissionBean) {
            int i;
            Context context;
            ixe.O00000o(permissionBean, "permissionBean");
            if (permissionBean.O00000o) {
                context = this.O00000Oo.getContext();
                i = R.string.optional;
            } else {
                context = this.O00000Oo.getContext();
                i = R.string.require;
            }
            String string = context.getString(i);
            ixe.O00000Oo(string, "if (permissionBean.isOptional) context.getString(R.string.optional) else context.getString(R.string.require)");
            ((TextView) this.itemView.findViewById(R.id.permission_name)).setText(permissionBean.O00000Oo + " (" + string + ')');
            ((TextView) this.itemView.findViewById(R.id.permission_desc)).setText(permissionBean.O00000o0);
            this.f8046O000000o = (CheckBox) this.itemView.findViewById(R.id.check_box);
            CheckBox checkBox = this.f8046O000000o;
            if (checkBox != null) {
                checkBox.setChecked(this.O00000Oo.checkedPermissions.contains(permissionBean));
            }
            if (permissionBean.O00000o) {
                CheckBox checkBox2 = this.f8046O000000o;
                if (checkBox2 != null) {
                    checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(permissionBean) {
                        /* class com.xiaomi.smarthome.framework.permission.$$Lambda$PermissionRequestActivity$O00000o$eN3Phe55PNrAC6vDa01lNzyoBQ */
                        private final /* synthetic */ PermissionBean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            PermissionRequestActivity.O00000o.O000000o(PermissionRequestActivity.this, this.f$1, compoundButton, z);
                        }
                    });
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.permission.$$Lambda$PermissionRequestActivity$O00000o$kwc9aPwpzuNuzIxVt5W3lP4m2vA */

                    public final void onClick(View view) {
                        PermissionRequestActivity.O00000o.O000000o(PermissionRequestActivity.O00000o.this, view);
                    }
                });
            }
            CheckBox checkBox3 = this.f8046O000000o;
            if (checkBox3 != null) {
                checkBox3.setAlpha(permissionBean.O00000o ? 1.0f : 0.3f);
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000o o00000o, View view) {
            ixe.O00000o(o00000o, "this$0");
            CheckBox checkBox = o00000o.f8046O000000o;
            if (checkBox != null) {
                checkBox.toggle();
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionRequestActivity$ItemDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mLeft", "", "mDividerHeight", "(II)V", "mPaint", "Landroid/graphics/Paint;", "mWhitePaint", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000o0 extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final int f8047O000000o;
        private final int O00000Oo = 1;
        private final Paint O00000o = new Paint(1);
        private final Paint O00000o0 = new Paint(1);

        public O00000o0(int i) {
            this.f8047O000000o = i;
            this.O00000o.setColor(-1);
            this.O00000o0.setColor(0);
            this.O00000o0.setAlpha(38);
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            ixe.O00000o(recyclerView, "parent");
            ixe.O00000o(o000OO0o, "state");
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.O00000Oo;
            rect.bottom = i;
            if (childAdapterPosition == 0) {
                rect.top = i;
            }
        }

        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(canvas, "c");
            ixe.O00000o(recyclerView, "parent");
            ixe.O00000o(o000OO0o, "state");
            super.onDrawOver(canvas, recyclerView, o000OO0o);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager != null) {
                int i = 0;
                int childCount = linearLayoutManager.getChildCount();
                if (childCount > 0) {
                    while (true) {
                        int i2 = i + 1;
                        View childAt = linearLayoutManager.getChildAt(i);
                        if (childAt != null) {
                            if (i == 0) {
                                canvas.drawRect((float) this.f8047O000000o, (float) childAt.getTop(), (float) childAt.getWidth(), (float) (childAt.getTop() + this.O00000Oo), this.O00000o0);
                            }
                            if (i == linearLayoutManager.getItemCount() - 1) {
                                canvas.drawRect(0.0f, (float) childAt.getBottom(), (float) childAt.getWidth(), (float) (childAt.getBottom() + this.O00000Oo), this.O00000o0);
                            } else {
                                canvas.drawRect((float) this.f8047O000000o, (float) childAt.getBottom(), (float) childAt.getWidth(), (float) (childAt.getBottom() + this.O00000Oo), this.O00000o0);
                            }
                        }
                        if (i2 < childCount) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
