package com.xiaomi.smarthome.framework.plugin;

import _m_j.fkl;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class PluginInfoActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    ListView f8048O000000o;
    O000000o O00000Oo;
    O00000Oo O00000o;
    O00000o0 O00000o0;
    int O00000oO;
    List<PluginPackageInfo> O00000oo = new ArrayList();
    List<PluginPackageInfo> O0000O0o = new ArrayList();
    List<PluginPackageInfo> O0000OOo = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000oO = getIntent().getIntExtra("type", 1);
        setContentView((int) R.layout.plugin_info_activity);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        textView.setText((int) R.string.developer_plugin_device_info);
        this.O00000oo.addAll(fkl.O000000o().O0000OOo.values());
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.PluginInfoActivity.AnonymousClass1 */

            public final void onClick(View view) {
                PluginInfoActivity.this.finish();
            }
        });
        this.O0000O0o = new ArrayList(fkl.O000000o().O0000OOo.values());
        this.O0000OOo = new ArrayList(fkl.O000000o().O0000Oo0.values());
        this.O00000Oo = new O000000o();
        this.O00000o0 = new O00000o0();
        this.O00000o = new O00000Oo();
        this.f8048O000000o = (ListView) findViewById(R.id.plugin_info_list);
        int i = this.O00000oO;
        if (i == 1) {
            textView.setText((int) R.string.developer_plugin_device_info);
            this.f8048O000000o.setAdapter((ListAdapter) this.O00000Oo);
        } else if (i == 2) {
            textView.setText((int) R.string.developer_plugin_package_info_installed);
            this.f8048O000000o.setAdapter((ListAdapter) this.O00000o0);
        } else if (i == 3) {
            textView.setText((int) R.string.developer_plugin_package_info_downloaded);
            this.f8048O000000o.setAdapter((ListAdapter) this.O00000o);
        }
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f8052O000000o;

        O00000o() {
        }
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o() {
        }

        public final int getCount() {
            return PluginInfoActivity.this.O00000oo.size();
        }

        public final Object getItem(int i) {
            return PluginInfoActivity.this.O00000oo.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            PluginPackageInfo pluginPackageInfo = PluginInfoActivity.this.O00000oo.get(i);
            if (view == null) {
                view = PluginInfoActivity.this.getLayoutInflater().inflate((int) R.layout.plugin_info_item, (ViewGroup) null);
                o00000o = new O00000o();
                o00000o.f8052O000000o = (TextView) view.findViewById(R.id.text);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
                o00000o.f8052O000000o.setText("");
            }
            if (i % 2 == 0) {
                o00000o.f8052O000000o.setBackgroundColor(Color.parseColor("#EFEFEF"));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("---------- Installed ----------");
            sb.append("\n");
            sb.append("VersionCode: " + pluginPackageInfo.O00000oO());
            sb.append("\n");
            sb.append("PluginId: " + pluginPackageInfo.O000000o());
            sb.append("\n");
            sb.append("PackageId: " + pluginPackageInfo.O00000Oo());
            sb.append("\n");
            sb.append("PackageName: " + pluginPackageInfo.O00000oo());
            sb.append("\n");
            sb.append("PackageType: " + pluginPackageInfo.O0000O0o());
            sb.append("\n");
            sb.append("MinApiLevel: " + pluginPackageInfo.O0000OOo());
            sb.append("\n");
            sb.append("Platform: " + pluginPackageInfo.O0000Oo());
            sb.append("\n");
            sb.append("ModelList: " + pluginPackageInfo.O0000OoO().toString());
            o00000o.f8052O000000o.setText(sb.toString());
            return view;
        }
    }

    class O00000o0 extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        O00000o0() {
        }

        public final int getCount() {
            return PluginInfoActivity.this.O0000O0o.size();
        }

        public final Object getItem(int i) {
            return PluginInfoActivity.this.O0000O0o.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            PluginPackageInfo pluginPackageInfo = PluginInfoActivity.this.O0000O0o.get(i);
            if (view == null) {
                view = PluginInfoActivity.this.getLayoutInflater().inflate((int) R.layout.plugin_info_item, (ViewGroup) null);
                o00000o = new O00000o();
                o00000o.f8052O000000o = (TextView) view.findViewById(R.id.text);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
                o00000o.f8052O000000o.setText("");
            }
            if (i % 2 == 0) {
                o00000o.f8052O000000o.setBackgroundColor(Color.parseColor("#EFEFEF"));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("VersionCode: " + pluginPackageInfo.O00000oO());
            sb.append("\n");
            sb.append("PluginId: " + pluginPackageInfo.O000000o());
            sb.append("\n");
            sb.append("PackageId: " + pluginPackageInfo.O00000Oo());
            sb.append("\n");
            sb.append("PackageName: " + pluginPackageInfo.O00000oo());
            sb.append("\n");
            sb.append("PackageType: " + pluginPackageInfo.O0000O0o());
            sb.append("\n");
            sb.append("MinApiLevel: " + pluginPackageInfo.O0000OOo());
            sb.append("\n");
            sb.append("Platform: " + pluginPackageInfo.O0000Oo());
            sb.append("\n");
            sb.append("ModelList: " + pluginPackageInfo.O0000OoO().toString());
            o00000o.f8052O000000o.setText(sb.toString());
            return view;
        }
    }

    class O00000Oo extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        O00000Oo() {
        }

        public final int getCount() {
            return PluginInfoActivity.this.O0000OOo.size();
        }

        public final Object getItem(int i) {
            return PluginInfoActivity.this.O0000OOo.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            PluginPackageInfo pluginPackageInfo = PluginInfoActivity.this.O0000OOo.get(i);
            if (view == null) {
                view = PluginInfoActivity.this.getLayoutInflater().inflate((int) R.layout.plugin_info_item, (ViewGroup) null);
                o00000o = new O00000o();
                o00000o.f8052O000000o = (TextView) view.findViewById(R.id.text);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
                o00000o.f8052O000000o.setText("");
            }
            if (i % 2 == 0) {
                o00000o.f8052O000000o.setBackgroundColor(Color.parseColor("#EFEFEF"));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("VersionCode: " + pluginPackageInfo.O00000oO());
            sb.append("\n");
            sb.append("PluginId: " + pluginPackageInfo.O000000o());
            sb.append("\n");
            sb.append("PackageId: " + pluginPackageInfo.O00000Oo());
            sb.append("\n");
            sb.append("PackageName: " + pluginPackageInfo.O00000oo());
            sb.append("\n");
            sb.append("PackageType: " + pluginPackageInfo.O0000O0o());
            sb.append("\n");
            sb.append("MinApiLevel: " + pluginPackageInfo.O0000OOo());
            sb.append("\n");
            sb.append("Platform: " + pluginPackageInfo.O0000Oo());
            sb.append("\n");
            sb.append("ModelList: " + pluginPackageInfo.O0000OoO().toString());
            o00000o.f8052O000000o.setText(sb.toString());
            return view;
        }
    }
}
