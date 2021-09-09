package com.mi.blockcanary.ui;

import _m_j.bxv;
import _m_j.bxw;
import _m_j.bya;
import _m_j.byi;
import _m_j.byj;
import _m_j.byk;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DisplayActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f4569O000000o;
    private TextView O00000Oo;
    private Button O00000o0;
    public List<byj> mBlockInfoEntries = new ArrayList();
    public String mBlockStartTime;
    public int mMaxStoredBlockCount;

    public static PendingIntent createPendingIntent(Context context, String str) {
        Intent intent = new Intent(context, DisplayActivity.class);
        intent.putExtra("show_latest", str);
        intent.setFlags(335544320);
        return PendingIntent.getActivity(context, 1, intent, 134217728);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mBlockStartTime = bundle.getString("BlockStartTime");
        } else {
            Intent intent = getIntent();
            if (intent.hasExtra("show_latest")) {
                this.mBlockStartTime = intent.getStringExtra("show_latest");
            }
        }
        setContentView((int) R.layout.block_canary_display_leak);
        this.f4569O000000o = (ListView) findViewById(R.id.__leak_canary_display_leak_list);
        this.O00000Oo = (TextView) findViewById(R.id.__leak_canary_display_leak_failure);
        this.O00000o0 = (Button) findViewById(R.id.__leak_canary_action);
        this.mMaxStoredBlockCount = getResources().getInteger(R.integer.block_canary_max_stored_count);
        updateUi();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.mBlockInfoEntries;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("BlockStartTime", this.mBlockStartTime);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        O00000Oo.O000000o(this);
    }

    public void setTheme(int i) {
        if (i == 2132739217) {
            super.setTheme(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        O00000Oo.O000000o();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        final byj O000000o2 = O000000o(this.mBlockStartTime);
        if (O000000o2 == null) {
            return false;
        }
        menu.add((int) R.string.block_canary_share_leak).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                DisplayActivity.this.shareBlock(O000000o2);
                return true;
            }
        });
        menu.add((int) R.string.block_canary_share_stack_dump).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                DisplayActivity.this.shareHeapDump(O000000o2);
                return true;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        this.mBlockStartTime = null;
        updateUi();
        return true;
    }

    public void onBackPressed() {
        if (this.mBlockStartTime != null) {
            this.mBlockStartTime = null;
            updateUi();
            return;
        }
        super.onBackPressed();
    }

    public void shareBlock(byj byj) {
        String byj2 = byj.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", byj2);
        startActivity(Intent.createChooser(intent, getString(R.string.block_canary_share_with)));
    }

    public void shareHeapDump(byj byj) {
        File file = byj.O0000oOO;
        if (Build.VERSION.SDK_INT >= 9) {
            file.setReadable(true, false);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/octet-stream");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        startActivity(Intent.createChooser(intent, getString(R.string.block_canary_share_with)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void updateUi() {
        final byk byk;
        final byj O000000o2 = O000000o(this.mBlockStartTime);
        if (O000000o2 == null) {
            this.mBlockStartTime = null;
        }
        int i = 0;
        this.f4569O000000o.setVisibility(0);
        this.O00000Oo.setVisibility(8);
        if (O000000o2 != null) {
            ListAdapter adapter = this.f4569O000000o.getAdapter();
            if (adapter instanceof byk) {
                byk = (byk) adapter;
            } else {
                byk = new byk();
                this.f4569O000000o.setAdapter((ListAdapter) byk);
                this.f4569O000000o.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass5 */

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        byk byk = byk;
                        byk.f13409O000000o[i] = !byk.f13409O000000o[i];
                        byk.notifyDataSetChanged();
                    }
                });
                if (Build.VERSION.SDK_INT >= 11) {
                    invalidateOptionsMenu();
                    ActionBar actionBar = getActionBar();
                    if (actionBar != null) {
                        actionBar.setDisplayHomeAsUpEnabled(true);
                    }
                }
                this.O00000o0.setVisibility(0);
                this.O00000o0.setText((int) R.string.block_canary_delete);
            }
            this.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass6 */

                public final void onClick(View view) {
                    byj byj = O000000o2;
                    if (byj != null) {
                        byj.O0000oOO.delete();
                        DisplayActivity displayActivity = DisplayActivity.this;
                        displayActivity.mBlockStartTime = null;
                        displayActivity.mBlockInfoEntries.remove(O000000o2);
                        DisplayActivity.this.updateUi();
                    }
                }
            });
            if (byk.O00000Oo == null || !O000000o2.O0000OoO.equals(byk.O00000Oo.O0000OoO)) {
                byk.O00000Oo = O000000o2;
                byk.f13409O000000o = new boolean[(byk.O00000Oo.O0000o0O.size() + 4)];
                Arrays.fill(byk.f13409O000000o, true);
                byk.notifyDataSetChanged();
            }
            setTitle(getString(R.string.block_canary_class_has_blocked, new Object[]{Long.valueOf(O000000o2.O0000Oo0)}));
            return;
        }
        ListAdapter adapter2 = this.f4569O000000o.getAdapter();
        if (adapter2 instanceof O000000o) {
            ((O000000o) adapter2).notifyDataSetChanged();
        } else {
            this.f4569O000000o.setAdapter((ListAdapter) new O000000o());
            this.f4569O000000o.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass3 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    DisplayActivity displayActivity = DisplayActivity.this;
                    displayActivity.mBlockStartTime = displayActivity.mBlockInfoEntries.get(i).O0000OoO;
                    DisplayActivity.this.updateUi();
                }
            });
            if (Build.VERSION.SDK_INT >= 11) {
                invalidateOptionsMenu();
                ActionBar actionBar2 = getActionBar();
                if (actionBar2 != null) {
                    actionBar2.setDisplayHomeAsUpEnabled(false);
                }
            }
            setTitle(getString(R.string.block_canary_block_list_title, new Object[]{getPackageName()}));
            this.O00000o0.setText((int) R.string.block_canary_delete_all);
            this.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    new AlertDialog.Builder(DisplayActivity.this).setTitle(DisplayActivity.this.getString(R.string.block_canary_delete)).setMessage(DisplayActivity.this.getString(R.string.block_canary_delete_all_dialog_content)).setPositiveButton(DisplayActivity.this.getString(R.string.block_canary_yes), new DialogInterface.OnClickListener() {
                        /* class com.mi.blockcanary.ui.DisplayActivity.AnonymousClass4.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            bya.O00000Oo();
                            DisplayActivity.this.mBlockInfoEntries = Collections.emptyList();
                            DisplayActivity.this.updateUi();
                        }
                    }).setNegativeButton(DisplayActivity.this.getString(R.string.block_canary_no), (DialogInterface.OnClickListener) null).show();
                }
            });
        }
        Button button = this.O00000o0;
        if (this.mBlockInfoEntries.isEmpty()) {
            i = 8;
        }
        button.setVisibility(i);
    }

    private byj O000000o(String str) {
        if (this.mBlockInfoEntries != null && !TextUtils.isEmpty(str)) {
            for (byj next : this.mBlockInfoEntries) {
                if (next.O0000OoO != null && str.equals(next.O0000OoO)) {
                    return next;
                }
            }
        }
        return null;
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o() {
        }

        public final int getCount() {
            return DisplayActivity.this.mBlockInfoEntries.size();
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public byj getItem(int i) {
            return DisplayActivity.this.mBlockInfoEntries.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            String str;
            if (view == null) {
                view = LayoutInflater.from(DisplayActivity.this).inflate((int) R.layout.block_canary_block_row, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.__leak_canary_row_text);
            TextView textView2 = (TextView) view.findViewById(R.id.__leak_canary_row_time);
            byj O000000o2 = getItem(i);
            if (i == 0 && DisplayActivity.this.mBlockInfoEntries.size() == DisplayActivity.this.mMaxStoredBlockCount) {
                str = "MAX. ";
            } else {
                str = (DisplayActivity.this.mBlockInfoEntries.size() - i) + ". ";
            }
            textView.setText(str + byi.O000000o(O000000o2) + " " + DisplayActivity.this.getString(R.string.block_canary_class_has_blocked, new Object[]{Long.valueOf(O000000o2.O0000Oo0)}));
            textView2.setText(DateUtils.formatDateTime(DisplayActivity.this, O000000o2.O0000oOO.lastModified(), 17));
            return view;
        }
    }

    static class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        static final List<O00000Oo> f4578O000000o = new ArrayList();
        static final Executor O00000Oo = Executors.newSingleThreadExecutor();
        private final Handler O00000o = new Handler(Looper.getMainLooper());
        public DisplayActivity O00000o0;

        private O00000Oo(DisplayActivity displayActivity) {
            this.O00000o0 = displayActivity;
        }

        static void O000000o(DisplayActivity displayActivity) {
            O00000Oo o00000Oo = new O00000Oo(displayActivity);
            f4578O000000o.add(o00000Oo);
            O00000Oo.execute(o00000Oo);
        }

        static void O000000o() {
            for (O00000Oo o00000Oo : f4578O000000o) {
                o00000Oo.O00000o0 = null;
            }
            f4578O000000o.clear();
        }

        public final void run() {
            boolean z;
            final ArrayList arrayList = new ArrayList();
            File[] O00000o02 = bxw.O00000o0();
            if (O00000o02 != null) {
                int length = O00000o02.length;
                int i = 0;
                while (i < length) {
                    File file = O00000o02[i];
                    try {
                        byj O000000o2 = byj.O000000o(file);
                        if (byi.O00000Oo(O000000o2)) {
                            if (byi.O00000o0(O000000o2)) {
                                bxv.O00000oO();
                                file.delete();
                                file = null;
                                z = false;
                            } else {
                                z = true;
                            }
                            O000000o2.O0000oOo = byi.O000000o(O000000o2);
                            bxv.O00000oO();
                            if (z && file != null) {
                                arrayList.add(O000000o2);
                            }
                            i++;
                        } else {
                            throw new BlockInfoCorruptException(O000000o2);
                        }
                    } catch (Exception e) {
                        file.delete();
                        Log.e("DisplayActivity", "Could not read block log file, deleted :".concat(String.valueOf(file)), e);
                    }
                }
                Collections.sort(arrayList, new Comparator<byj>() {
                    /* class com.mi.blockcanary.ui.DisplayActivity.O00000Oo.AnonymousClass1 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        return Long.valueOf(((byj) obj2).O0000oOO.lastModified()).compareTo(Long.valueOf(((byj) obj).O0000oOO.lastModified()));
                    }
                });
            }
            this.O00000o.post(new Runnable() {
                /* class com.mi.blockcanary.ui.DisplayActivity.O00000Oo.AnonymousClass2 */

                public final void run() {
                    O00000Oo.f4578O000000o.remove(O00000Oo.this);
                    if (O00000Oo.this.O00000o0 != null) {
                        O00000Oo.this.O00000o0.mBlockInfoEntries = arrayList;
                        Log.d("DisplayActivity", "load block entries: " + arrayList.size());
                        O00000Oo.this.O00000o0.updateUi();
                    }
                }
            });
        }
    }
}
