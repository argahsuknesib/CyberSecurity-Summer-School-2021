package com.xiaomi.smarthome.scene.activity;

import _m_j.fnn;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.hnk;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.jdn;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class SceneSettingVoiceAliasActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f10854O000000o;
    private SceneApi.O000OOOo O00000Oo = null;
    private hny O00000o0 = new hny() {
        /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.AnonymousClass1 */

        public final void onRefreshScenceSuccess(int i) {
            if (SceneSettingVoiceAliasActivity.this.isValid() && i == 5) {
                List<SceneApi.O000OOOo> list = hpr.O00000o0().O0000O0o;
                HashSet hashSet = new HashSet();
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if ((TextUtils.isEmpty(SceneSettingVoiceAliasActivity.this.mSceneID) || !TextUtils.equals(SceneSettingVoiceAliasActivity.this.mSceneID, list.get(i2).f11131O000000o)) && list.get(i2).O0000o0 != null && list.get(i2).O0000o0.size() > 0) {
                            SceneSettingVoiceAliasActivity.this.aliasInAccount.addAll(list.get(i2).O0000o0);
                        }
                    }
                }
                SceneSettingVoiceAliasActivity.this.aliasInAccount.addAll(hashSet);
                InputMethodManager inputMethodManager = (InputMethodManager) SceneSettingVoiceAliasActivity.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null && !inputMethodManager.isActive()) {
                    SceneSettingVoiceAliasActivity.this.mItemAdapter.notifyDataSetChanged();
                }
            }
        }

        public final void onRefreshScenceFailed(int i) {
            gsy.O00000Oo(LogType.SCENE, "scenevoicealiassetting", "litescene is not inited");
        }
    };
    public Set<String> aliasInAccount = new HashSet();
    public ArrayList<String> denyVCList = null;
    public boolean isSuccesGetDeny;
    @BindView(5089)
    RecyclerView mAliasList;
    public O00000o0 mItemAdapter;
    public gzl mMergedAdapter;
    @BindView(5822)
    View mModuleA4ReturnBtn;
    public XQProgressDialog mPD;
    public String mSceneID;
    public String mSceneName;
    public int mUseSceneName;
    public final ArrayList<O00000o> mVoiceInstructions = new ArrayList<>();
    @BindView(6504)
    View tvCancel;
    @BindView(6521)
    View tvSave;
    public ArrayList<String> voiceContrlDidList = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        Set set;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scene_voicealias);
        ButterKnife.bind(this);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("alias_list");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                this.mVoiceInstructions.add(new O00000o(it.next()));
            }
        }
        this.mSceneID = getIntent().getStringExtra("scene_id");
        this.mSceneName = getIntent().getStringExtra("scene_name");
        this.mUseSceneName = getIntent().getIntExtra("use_title", -1);
        Map<String, Set<String>> O000000o2 = fnn.O000000o().O00000Oo().O000000o(8);
        DeviceTagInterface.Category O0000Oo0 = fnn.O000000o().O00000Oo().O0000Oo0("46");
        if (O0000Oo0 == null) {
            set = null;
        } else {
            set = O000000o2.get(O0000Oo0.name);
        }
        if (set != null) {
            this.voiceContrlDidList.addAll(set);
        }
        this.mAliasList.setLayoutManager(new GridLayoutManager(this) {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.AnonymousClass3 */

            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.mAliasList.setNestedScrollingEnabled(true);
        this.mMergedAdapter = new gzl() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.AnonymousClass4 */

            public final void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
                super.onViewDetachedFromWindow(o000OOo0);
                if (o000OOo0 instanceof O00000o0.O000000o) {
                    O00000o0.O000000o o000000o = (O00000o0.O000000o) o000OOo0;
                    o000000o.f10865O000000o.removeTextWatcher();
                    o000000o.f10865O000000o.clearFocus();
                    O000000o(SceneSettingVoiceAliasActivity.this.mItemAdapter, SceneSettingVoiceAliasActivity.this.mItemAdapter.f10864O000000o);
                    o000000o.getAdapterPosition();
                }
            }

            public final void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
                int i;
                super.onViewAttachedToWindow(o000OOo0);
                if (o000OOo0 instanceof O00000o0.O000000o) {
                    O00000o0.O000000o o000000o = (O00000o0.O000000o) o000OOo0;
                    EditTextViewWithSingleWatcher editTextViewWithSingleWatcher = o000000o.f10865O000000o;
                    editTextViewWithSingleWatcher.addTextWatcher();
                    int adapterPosition = o000000o.getAdapterPosition();
                    if (adapterPosition != -1 && O000000o(SceneSettingVoiceAliasActivity.this.mItemAdapter, SceneSettingVoiceAliasActivity.this.mItemAdapter.f10864O000000o) == adapterPosition) {
                        editTextViewWithSingleWatcher.requestFocus();
                        Editable text = editTextViewWithSingleWatcher.getText();
                        if (text == null) {
                            i = 0;
                        } else {
                            i = text.length();
                        }
                        editTextViewWithSingleWatcher.setSelection(i);
                    }
                }
            }
        };
        this.mItemAdapter = new O00000o0(this, (byte) 0);
        this.f10854O000000o = new O000000o(this, (byte) 0);
        this.mMergedAdapter.O000000o(new O00000Oo(this, (byte) 0));
        this.mMergedAdapter.O000000o(this.mItemAdapter);
        this.mMergedAdapter.O000000o(this.f10854O000000o);
        this.mMergedAdapter.O000000o(new O0000O0o(this, (byte) 0));
        this.mAliasList.setAdapter(this.mMergedAdapter);
        hpr.O00000o0().O00000Oo(this.O00000o0);
        hpr.O00000o0().O00000Oo();
        new hnk(this).O00000o0 = new hnk.O000000o() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.AnonymousClass2 */

            public final void O000000o() {
                SceneSettingVoiceAliasActivity.this.mAliasList.setPadding(0, SceneSettingVoiceAliasActivity.this.mAliasList.getPaddingTop(), 0, gpc.O000000o(200.0f));
            }

            public final void O00000Oo() {
                SceneSettingVoiceAliasActivity.this.mAliasList.setPadding(0, SceneSettingVoiceAliasActivity.this.mAliasList.getPaddingTop(), 0, 0);
            }
        };
        if (!TextUtils.isEmpty(this.mSceneID)) {
            getAuthDenyData(false);
        }
        this.O00000Oo = hpq.O000000o().O00000Oo;
    }

    public void onBackPressed() {
        O000000o();
    }

    private void O000000o() {
        if (this.O00000Oo != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<O00000o> it = this.mVoiceInstructions.iterator();
            while (it.hasNext()) {
                O00000o next = it.next();
                if (!TextUtils.isEmpty(next.f10863O000000o)) {
                    arrayList.add(next.f10863O000000o);
                }
            }
            if (this.O00000Oo.O0000o00 != this.mUseSceneName || !this.O00000Oo.O0000o0.equals(arrayList)) {
                gqg.O00000Oo((int) R.string.scene_save_edit);
                return;
            }
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        hpr.O00000o0().O00000o0(this.O00000o0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i == 4 && i2 == -1 && (stringArrayListExtra = intent.getStringArrayListExtra("voice_control_deny_list")) != null) {
            this.denyVCList = new ArrayList<>();
            this.denyVCList.addAll(stringArrayListExtra);
            this.mMergedAdapter.notifyDataSetChanged();
        }
    }

    @OnClick({5822})
    public void onBackClick() {
        O000000o();
    }

    @OnClick({6504})
    public void onCancelClick() {
        setResult(0);
        finish();
    }

    public void goSceneAuthPage() {
        Intent intent = new Intent(this, SceneSpeakerSettingActivity.class);
        if (!TextUtils.isEmpty(this.mSceneID)) {
            intent.putExtra("scene_id", this.mSceneID);
        }
        intent.putStringArrayListExtra("voice_control_list", this.voiceContrlDidList);
        ArrayList<String> arrayList = this.denyVCList;
        if (arrayList != null) {
            intent.putStringArrayListExtra("voice_control_deny_list", arrayList);
        }
        startActivityForResult(intent, 4);
    }

    public void getAuthDenyData(final boolean z) {
        this.mPD = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.get_data_from_server));
        DeviceApi.getInstance().getAllSceneAuthDataByUsId(this, this.mSceneID, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray optJSONArray;
                JSONObject jSONObject = (JSONObject) obj;
                SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity = SceneSettingVoiceAliasActivity.this;
                sceneSettingVoiceAliasActivity.isSuccesGetDeny = true;
                if (sceneSettingVoiceAliasActivity.mPD != null && SceneSettingVoiceAliasActivity.this.isValid()) {
                    SceneSettingVoiceAliasActivity.this.mPD.dismiss();
                }
                if (SceneSettingVoiceAliasActivity.this.denyVCList != null) {
                    SceneSettingVoiceAliasActivity.this.denyVCList.clear();
                }
                if (!TextUtils.isEmpty(SceneSettingVoiceAliasActivity.this.mSceneID)) {
                    int optInt = jSONObject.optInt("code");
                    if (optInt != 0) {
                        gsy.O00000Oo("SCENE", "error code ".concat(String.valueOf(optInt)));
                        gqg.O00000Oo((int) R.string.load_failed);
                        return;
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("result");
                    if (optJSONArray2 != null) {
                        SceneSettingVoiceAliasActivity.this.denyVCList = new ArrayList<>();
                        for (int i = 0; i < optJSONArray2.length(); i++) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                            if (optJSONObject != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(optJSONObject.optLong("scene_id"));
                                if (TextUtils.equals(SceneSettingVoiceAliasActivity.this.mSceneID, sb.toString()) && (optJSONArray = optJSONObject.optJSONArray("ctrl_devs")) != null && optJSONArray.length() > 0) {
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                        if (optJSONObject2 != null && optJSONObject2.optInt("ctrlable") == 0) {
                                            String optString = optJSONObject2.optString("voicedevid");
                                            if (!TextUtils.isEmpty(optString)) {
                                                SceneSettingVoiceAliasActivity.this.denyVCList.add(optString);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    SceneSettingVoiceAliasActivity.this.goSceneAuthPage();
                } else {
                    SceneSettingVoiceAliasActivity.this.mMergedAdapter.notifyDataSetChanged();
                }
            }

            public final void onFailure(fso fso) {
                if (SceneSettingVoiceAliasActivity.this.mPD != null && SceneSettingVoiceAliasActivity.this.isValid()) {
                    SceneSettingVoiceAliasActivity.this.mPD.dismiss();
                }
                gsy.O00000Oo("SCENE", "error detail " + fso.O00000Oo);
                gqg.O00000Oo((int) R.string.load_failed);
            }
        });
    }

    class O00000Oo extends gzm {
        public final int O000000o() {
            return 1;
        }

        public final int getItemCount() {
            return 1;
        }

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity, byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(SceneSettingVoiceAliasActivity.this.getContext()).inflate((int) R.layout.item_set_scene_alias_above, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((O000000o) o000OOo0).O000000o();
        }

        class O000000o extends RecyclerView.O000OOo0 {
            private TextView O00000Oo;
            private TextView O00000o;
            private SwitchButton O00000o0;

            public O000000o(View view) {
                super(view);
                this.O00000Oo = (TextView) view.findViewById(R.id.eg_scene_name);
                this.O00000o0 = (SwitchButton) view.findViewById(R.id.use_title);
                this.O00000o = (TextView) view.findViewById(R.id.error_tip);
            }

            public final void O000000o() {
                O00000Oo();
                if (!TextUtils.isEmpty(SceneSettingVoiceAliasActivity.this.mSceneName)) {
                    TextView textView = this.O00000Oo;
                    textView.setText(jdn.f1779O000000o + SceneSettingVoiceAliasActivity.this.mSceneName + jdn.f1779O000000o);
                } else {
                    this.O00000Oo.setText("\"\"");
                }
                this.O00000o0.setChecked(SceneSettingVoiceAliasActivity.this.mUseSceneName != 0);
                this.O00000o0.setOnCheckedChangeListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: INVOKE  
                      (wrap: com.xiaomi.smarthome.library.common.widget.SwitchButton : 0x0043: IGET  (r0v5 com.xiaomi.smarthome.library.common.widget.SwitchButton) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo$O000000o A[THIS]) com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.O000000o.O00000o0 com.xiaomi.smarthome.library.common.widget.SwitchButton)
                      (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4 : 0x0047: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo$O000000o):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.xiaomi.smarthome.library.common.widget.SwitchButton.setOnCheckedChangeListener(android.widget.CompoundButton$OnCheckedChangeListener):void in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.O000000o.O000000o():void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.O000000o.O000000o():void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    r4.O00000Oo()
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.this
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                    java.lang.String r0 = r0.mSceneName
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L_0x002c
                    android.widget.TextView r0 = r4.O00000Oo
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "\""
                    r1.<init>(r2)
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo r3 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.this
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r3 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                    java.lang.String r3 = r3.mSceneName
                    r1.append(r3)
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    r0.setText(r1)
                    goto L_0x0033
                L_0x002c:
                    android.widget.TextView r0 = r4.O00000Oo
                    java.lang.String r1 = "\"\""
                    r0.setText(r1)
                L_0x0033:
                    com.xiaomi.smarthome.library.common.widget.SwitchButton r0 = r4.O00000o0
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000Oo r1 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.this
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r1 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                    int r1 = r1.mUseSceneName
                    if (r1 == 0) goto L_0x003f
                    r1 = 1
                    goto L_0x0040
                L_0x003f:
                    r1 = 0
                L_0x0040:
                    r0.setChecked(r1)
                    com.xiaomi.smarthome.library.common.widget.SwitchButton r0 = r4.O00000o0
                    com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4 r1 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000Oo$O000000o$dr4pyJ_IVxHyfnvpw5ty73u_wp4
                    r1.<init>(r4)
                    r0.setOnCheckedChangeListener(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000Oo.O000000o.O000000o():void");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
                SceneSettingVoiceAliasActivity.this.mUseSceneName = z ? 1 : 0;
                O00000Oo();
            }

            private void O00000Oo() {
                if (SceneSettingVoiceAliasActivity.this.mUseSceneName == 0) {
                    this.O00000o.setVisibility(8);
                } else if (!hnw.O00000Oo(SceneSettingVoiceAliasActivity.this.mSceneName)) {
                    this.O00000o.setVisibility(0);
                    this.O00000o.setText((int) R.string.scene_name_illegal);
                } else if (!hnw.O00000o0(SceneSettingVoiceAliasActivity.this.mSceneName)) {
                    this.O00000o.setVisibility(0);
                    this.O00000o.setText((int) R.string.scene_name_length_illegal);
                } else {
                    this.O00000o.setVisibility(8);
                }
            }
        }
    }

    class O00000o0 extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f10864O000000o;

        public final int O000000o() {
            return 1;
        }

        private O00000o0() {
            this.f10864O000000o = -1;
        }

        /* synthetic */ O00000o0(SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity, byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(SceneSettingVoiceAliasActivity.this.getContext()).inflate((int) R.layout.item_set_scene_alias_item, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((O000000o) o000OOo0).O000000o(i);
        }

        public final int getItemCount() {
            return SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size();
        }

        class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public EditTextViewWithSingleWatcher f10865O000000o;
            private View O00000o;
            private TextView O00000o0;

            public O000000o(View view) {
                super(view);
                this.f10865O000000o = (EditTextViewWithSingleWatcher) view.findViewById(R.id.alias_desc);
                this.O00000o0 = (TextView) view.findViewById(R.id.error_desc);
                this.O00000o = view.findViewById(R.id.img_clear);
            }

            public final void O000000o(int i) {
                final O00000o o00000o = SceneSettingVoiceAliasActivity.this.mVoiceInstructions.get(i);
                gsy.O000000o(3, "SceneSettingVoiceAliasA", "bind: " + i + " ;name: " + o00000o.f10863O000000o);
                this.f10865O000000o.setText(o00000o.f10863O000000o);
                O000000o(o00000o.f10863O000000o, i);
                this.O00000o.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: INVOKE  
                      (wrap: android.view.View : 0x0036: IGET  (r1v4 android.view.View) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o A[THIS]) com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O00000o android.view.View)
                      (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc : 0x003a: CONSTRUCTOR  (r2v5 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc) = 
                      (r4v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o A[THIS])
                      (r0v4 'o00000o' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o)
                     call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o, com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O000000o(int):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: CONSTRUCTOR  (r2v5 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc) = 
                      (r4v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o A[THIS])
                      (r0v4 'o00000o' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o)
                     call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o, com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O000000o(int):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                    java.util.ArrayList<com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o> r0 = r0.mVoiceInstructions
                    java.lang.Object r0 = r0.get(r5)
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o r0 = (com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o) r0
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "bind: "
                    r1.<init>(r2)
                    r1.append(r5)
                    java.lang.String r2 = " ;name: "
                    r1.append(r2)
                    java.lang.String r2 = r0.f10863O000000o
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SceneSettingVoiceAliasA"
                    r3 = 3
                    _m_j.gsy.O000000o(r3, r2, r1)
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r1 = r4.f10865O000000o
                    java.lang.String r2 = r0.f10863O000000o
                    r1.setText(r2)
                    java.lang.String r1 = r0.f10863O000000o
                    r4.O000000o(r1, r5)
                    android.view.View r1 = r4.O00000o
                    com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc r2 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$kviTJrwIj2xi2rp41IPT0wR4Agc
                    r2.<init>(r4, r0)
                    r1.setOnClickListener(r2)
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r1 = r4.f10865O000000o
                    com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$UyMX-sEJu6079rx7aAF7WyTBpDk r2 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$UyMX-sEJu6079rx7aAF7WyTBpDk
                    r2.<init>(r4, r0)
                    r1.setOnFocusChangeListener(r2)
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r1 = r4.f10865O000000o
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o$1 r2 = new com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o$1
                    r2.<init>(r0)
                    r1.setEditListener(r2)
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r1 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                    com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r1 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                    java.util.ArrayList<com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o> r1 = r1.mVoiceInstructions
                    int r1 = r1.size()
                    int r1 = r1 + -1
                    if (r5 != r1) goto L_0x0085
                    boolean r5 = r0.O00000Oo
                    if (r5 == 0) goto L_0x0085
                    r5 = 0
                    r0.O00000Oo = r5
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r0 = r4.f10865O000000o
                    r0.requestFocus()
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r0 = r4.f10865O000000o
                    android.text.Editable r0 = r0.getText()
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r1 = r4.f10865O000000o
                    if (r0 != 0) goto L_0x0079
                    goto L_0x007d
                L_0x0079:
                    int r5 = r1.length()
                L_0x007d:
                    r1.setSelection(r5)
                    com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r5 = r4.f10865O000000o
                    r5.showSoftInput()
                L_0x0085:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O000000o(int):void");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(O00000o o00000o, View view) {
                this.f10865O000000o.setEditListener(null);
                int indexOf = SceneSettingVoiceAliasActivity.this.mVoiceInstructions.indexOf(o00000o);
                if (SceneSettingVoiceAliasActivity.this.mVoiceInstructions.remove(o00000o)) {
                    O00000o0.this.notifyItemRemoved(indexOf);
                    SceneSettingVoiceAliasActivity.this.mAliasList.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: INVOKE  
                          (wrap: androidx.recyclerview.widget.RecyclerView : 0x0025: IGET  (r2v10 androidx.recyclerview.widget.RecyclerView) = 
                          (wrap: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity : 0x0023: IGET  (r2v9 com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity) = 
                          (wrap: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 : 0x0021: IGET  (r2v8 com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0) = (r1v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o A[THIS]) com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O00000Oo com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0)
                         com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O00000Oo com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity)
                         com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.mAliasList androidx.recyclerview.widget.RecyclerView)
                          (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM : 0x0029: CONSTRUCTOR  (r3v6 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM) = (r1v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o):void type: CONSTRUCTOR)
                         type: VIRTUAL call: androidx.recyclerview.widget.RecyclerView.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o, android.view.View):void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: CONSTRUCTOR  (r3v6 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM) = (r1v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o, android.view.View):void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 68 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 74 more
                        */
                    /*
                        this = this;
                        com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r3 = r1.f10865O000000o
                        r0 = 0
                        r3.setEditListener(r0)
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r3 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r3 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o> r3 = r3.mVoiceInstructions
                        int r3 = r3.indexOf(r2)
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o> r0 = r0.mVoiceInstructions
                        boolean r2 = r0.remove(r2)
                        if (r2 == 0) goto L_0x002f
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                        r2.notifyItemRemoved(r3)
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        androidx.recyclerview.widget.RecyclerView r2 = r2.mAliasList
                        com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM r3 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O00000o0$O000000o$9nwII9_7WwoGlaRl62A73yW6viM
                        r3.<init>(r1)
                        r2.post(r3)
                    L_0x002f:
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o0 r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o> r2 = r2.mVoiceInstructions
                        int r2 = r2.size()
                        if (r2 != 0) goto L_0x0041
                        com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher r2 = r1.f10865O000000o
                        r2.hideSoftInput()
                        return
                    L_0x0041:
                        r1.O000000o()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O00000o, android.view.View):void");
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    if (SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size() > 0) {
                        int size = SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size() - 1;
                        SceneSettingVoiceAliasActivity.this.mVoiceInstructions.get(size).O00000Oo = true;
                        O00000o0.this.notifyItemChanged(size);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(O00000o o00000o, View view, boolean z) {
                    if (z) {
                        O00000o0 o00000o0 = O00000o0.this;
                        o00000o0.f10864O000000o = SceneSettingVoiceAliasActivity.this.mVoiceInstructions.indexOf(o00000o);
                    }
                }

                public final void O000000o(String str, int i) {
                    String errorMessageForIndex = SceneSettingVoiceAliasActivity.this.getErrorMessageForIndex(str, i);
                    if (!TextUtils.isEmpty(errorMessageForIndex)) {
                        this.O00000o0.setText(errorMessageForIndex);
                        this.O00000o0.setVisibility(0);
                        return;
                    }
                    this.O00000o0.setText("");
                    this.O00000o0.setVisibility(8);
                }

                public final void O000000o() {
                    if (((GridLayoutManager) SceneSettingVoiceAliasActivity.this.mAliasList.getLayoutManager()) != null) {
                        gzl gzl = SceneSettingVoiceAliasActivity.this.mMergedAdapter;
                        int indexOf = gzl.f18620O000000o.indexOf(SceneSettingVoiceAliasActivity.this.mItemAdapter);
                        int i = -1;
                        if (indexOf != -1) {
                            int i2 = 0;
                            for (int i3 = 0; i3 < indexOf; i3++) {
                                i2 += gzl.f18620O000000o.get(i3).getItemCount();
                            }
                            i = i2;
                        }
                        for (int i4 = 0; i4 < SceneSettingVoiceAliasActivity.this.mMergedAdapter.getItemCount(); i4++) {
                            RecyclerView.O000OOo0 findViewHolderForAdapterPosition = SceneSettingVoiceAliasActivity.this.mAliasList.findViewHolderForAdapterPosition(i4);
                            if (findViewHolderForAdapterPosition instanceof O000000o) {
                                int i5 = i4 - i;
                                ((O000000o) findViewHolderForAdapterPosition).O000000o(SceneSettingVoiceAliasActivity.this.mVoiceInstructions.get(i5).f10863O000000o, i5);
                            }
                        }
                    }
                }
            }
        }

        class O000000o extends gzm {
            private O000000o() {
            }

            /* synthetic */ O000000o(SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity, byte b) {
                this();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new C0089O000000o(LayoutInflater.from(SceneSettingVoiceAliasActivity.this.getContext()).inflate((int) R.layout.item_set_scene_alias_item_add, viewGroup, false));
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ((C0089O000000o) o000OOo0).O000000o();
            }

            public final int getItemCount() {
                return SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size() >= 20 ? 0 : 1;
            }

            /* renamed from: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o  reason: collision with other inner class name */
            class C0089O000000o extends RecyclerView.O000OOo0 {
                private View O00000Oo;

                public C0089O000000o(View view) {
                    super(view);
                    this.O00000Oo = view.findViewById(R.id.txt_add_alias);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(View view) {
                    SceneSettingVoiceAliasActivity.this.mAliasList.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                          (wrap: androidx.recyclerview.widget.RecyclerView : 0x0004: IGET  (r2v3 androidx.recyclerview.widget.RecyclerView) = 
                          (wrap: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity : 0x0002: IGET  (r2v2 com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity) = 
                          (wrap: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o : 0x0000: IGET  (r2v1 com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o) = (r1v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o.O000000o com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o)
                         com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity)
                         com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.mAliasList androidx.recyclerview.widget.RecyclerView)
                          (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk : 0x0008: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk) = (r1v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o):void type: CONSTRUCTOR)
                         type: VIRTUAL call: androidx.recyclerview.widget.RecyclerView.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o.O000000o(android.view.View):void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk) = (r1v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o.O000000o(android.view.View):void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 63 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 69 more
                        */
                    /*
                        this = this;
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r2 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        androidx.recyclerview.widget.RecyclerView r2 = r2.mAliasList
                        com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk r0 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$XOGHXmHxYja_san-R9NPTC10hvk
                        r0.<init>(r1)
                        r2.post(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.C0089O000000o.O000000o(android.view.View):void");
                }

                public final void O000000o() {
                    this.O00000Oo.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  
                          (wrap: android.view.View : 0x0000: IGET  (r0v0 android.view.View) = (r2v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o.O00000Oo android.view.View)
                          (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY : 0x0004: CONSTRUCTOR  (r1v0 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY) = (r2v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o.O000000o():void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r1v0 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY) = (r2v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O000000o$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.O000000o.O000000o():void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 63 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 69 more
                        */
                    /*
                        this = this;
                        android.view.View r0 = r2.O00000Oo
                        com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY r1 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O000000o$O000000o$HuGW7h2QMV0lzDFf_j0DMqV0jBY
                        r1.<init>(r2)
                        r0.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O000000o.C0089O000000o.O000000o():void");
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    if (SceneSettingVoiceAliasActivity.this.mVoiceInstructions.isEmpty()) {
                        SceneSettingVoiceAliasActivity.this.mVoiceInstructions.add(new O00000o(null, true));
                        SceneSettingVoiceAliasActivity.this.mItemAdapter.notifyItemInserted(0);
                        return;
                    }
                    O00000o o00000o = SceneSettingVoiceAliasActivity.this.mVoiceInstructions.get(SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size() - 1);
                    if (TextUtils.isEmpty(o00000o.f10863O000000o)) {
                        o00000o.O00000Oo = true;
                        SceneSettingVoiceAliasActivity.this.mItemAdapter.notifyItemChanged(SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size() - 1);
                        gqg.O00000Oo(SceneSettingVoiceAliasActivity.this.getString(R.string.scene_alias_null));
                        return;
                    }
                    SceneSettingVoiceAliasActivity.this.mVoiceInstructions.add(new O00000o(null, true));
                    SceneSettingVoiceAliasActivity.this.mItemAdapter.notifyItemInserted(SceneSettingVoiceAliasActivity.this.mVoiceInstructions.size() - 1);
                }
            }
        }

        class O0000O0o extends gzm {
            public final int O000000o() {
                return 1;
            }

            public final int getItemCount() {
                return 1;
            }

            private O0000O0o() {
            }

            /* synthetic */ O0000O0o(SceneSettingVoiceAliasActivity sceneSettingVoiceAliasActivity, byte b) {
                this();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new O000000o(LayoutInflater.from(SceneSettingVoiceAliasActivity.this.getContext()).inflate((int) R.layout.item_set_scene_alias_below, viewGroup, false));
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ((O000000o) o000OOo0).O000000o();
            }

            class O000000o extends RecyclerView.O000OOo0 {
                private TextView O00000Oo;
                private View O00000o0;

                public O000000o(View view) {
                    super(view);
                    this.O00000Oo = (TextView) view.findViewById(R.id.speaker_count);
                    this.O00000o0 = view.findViewById(R.id.view_select_speaker);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(View view) {
                    if (SceneSettingVoiceAliasActivity.this.voiceContrlDidList.size() <= 0) {
                        SceneSettingVoiceAliasActivity.this.goSceneAuthPage();
                    } else if (TextUtils.isEmpty(SceneSettingVoiceAliasActivity.this.mSceneID) || SceneSettingVoiceAliasActivity.this.isSuccesGetDeny) {
                        SceneSettingVoiceAliasActivity.this.goSceneAuthPage();
                    } else {
                        SceneSettingVoiceAliasActivity.this.getAuthDenyData(true);
                    }
                }

                public final void O000000o() {
                    int i;
                    int size = SceneSettingVoiceAliasActivity.this.voiceContrlDidList.size();
                    if (SceneSettingVoiceAliasActivity.this.denyVCList != null) {
                        i = 0;
                        for (int i2 = 0; i2 < size; i2++) {
                            if (SceneSettingVoiceAliasActivity.this.denyVCList.contains(SceneSettingVoiceAliasActivity.this.voiceContrlDidList.get(i2))) {
                                i++;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    int i3 = size - i;
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    this.O00000Oo.setText(SceneSettingVoiceAliasActivity.this.getResources().getQuantityString(R.plurals.scene_voice_control_count, i3, Integer.valueOf(i3)));
                    this.O00000o0.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005b: INVOKE  
                          (wrap: android.view.View : 0x0054: IGET  (r0v7 android.view.View) = (r7v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o$O000000o A[THIS]) com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.O000000o.O00000o0 android.view.View)
                          (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw : 0x0058: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw) = (r7v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o$O000000o):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.O000000o.O000000o():void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0058: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw) = (r7v0 'this' com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o$O000000o A[THIS]) call: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw.<init>(com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.O000000o.O000000o():void, dex: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 63 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 69 more
                        */
                    /*
                        this = this;
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r0 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<java.lang.String> r0 = r0.voiceContrlDidList
                        int r0 = r0.size()
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o r1 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r1 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<java.lang.String> r1 = r1.denyVCList
                        r2 = 0
                        if (r1 == 0) goto L_0x0032
                        r1 = 0
                        r3 = 0
                    L_0x0015:
                        if (r1 >= r0) goto L_0x0033
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o r4 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r4 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<java.lang.String> r4 = r4.denyVCList
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o r5 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r5 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        java.util.ArrayList<java.lang.String> r5 = r5.voiceContrlDidList
                        java.lang.Object r5 = r5.get(r1)
                        boolean r4 = r4.contains(r5)
                        if (r4 == 0) goto L_0x002f
                        int r3 = r3 + 1
                    L_0x002f:
                        int r1 = r1 + 1
                        goto L_0x0015
                    L_0x0032:
                        r3 = 0
                    L_0x0033:
                        int r0 = r0 - r3
                        if (r0 >= 0) goto L_0x0037
                        r0 = 0
                    L_0x0037:
                        android.widget.TextView r1 = r7.O00000Oo
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity$O0000O0o r3 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.this
                        com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity r3 = com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.this
                        android.content.res.Resources r3 = r3.getResources()
                        r4 = 2132541503(0x7f1c003f, float:2.0736085E38)
                        r5 = 1
                        java.lang.Object[] r5 = new java.lang.Object[r5]
                        java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
                        r5[r2] = r6
                        java.lang.String r0 = r3.getQuantityString(r4, r0, r5)
                        r1.setText(r0)
                        android.view.View r0 = r7.O00000o0
                        com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw r1 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$SceneSettingVoiceAliasActivity$O0000O0o$O000000o$y0ZC2l-Z6vQW-MvppK8LqCpu5uw
                        r1.<init>(r7)
                        r0.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.SceneSettingVoiceAliasActivity.O0000O0o.O000000o.O000000o():void");
                }
            }
        }

        static class O00000o {

            /* renamed from: O000000o  reason: collision with root package name */
            String f10863O000000o;
            boolean O00000Oo;

            public O00000o(String str) {
                this(str, false);
            }

            public O00000o(String str, boolean z) {
                this.O00000Oo = false;
                this.f10863O000000o = str;
                this.O00000Oo = z;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
        @OnClick({6521})
        public void onSaveClick() {
            String str;
            String str2;
            if (this.mUseSceneName != 0) {
                if (!hnw.O00000Oo(this.mSceneName)) {
                    str = getString(R.string.scene_name_illegal);
                } else if (!hnw.O00000o0(this.mSceneName)) {
                    str = getString(R.string.scene_name_length_illegal);
                }
                if (TextUtils.isEmpty(str)) {
                    gqg.O00000Oo(str);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= this.mVoiceInstructions.size()) {
                        str2 = "";
                        break;
                    }
                    str2 = getErrorMessageForIndex(this.mVoiceInstructions.get(i).f10863O000000o, i);
                    if (!TextUtils.isEmpty(str2)) {
                        break;
                    }
                    i++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    gqg.O00000Oo(str2);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<O00000o> it = this.mVoiceInstructions.iterator();
                while (it.hasNext()) {
                    O00000o next = it.next();
                    if (!TextUtils.isEmpty(next.f10863O000000o)) {
                        arrayList.add(next.f10863O000000o);
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("use_title", this.mUseSceneName);
                intent.putStringArrayListExtra("alias_list", arrayList);
                ArrayList<String> arrayList2 = this.denyVCList;
                if (arrayList2 != null) {
                    intent.putStringArrayListExtra("voice_control_deny_list", arrayList2);
                }
                setResult(-1, intent);
                finish();
                return;
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
        public String getErrorMessageForIndex(String str, int i) {
            String str2;
            if (!TextUtils.isEmpty(str) && str.trim().length() != 0) {
                if (!hnw.O000000o(str)) {
                    str2 = getString(R.string.scene_voice_alias_limit1);
                } else if (str.length() > 20) {
                    str2 = getString(R.string.scene_voice_alias_limit2);
                }
                if (TextUtils.isEmpty(str2)) {
                    return str2;
                }
                if (i != -1) {
                    if (this.aliasInAccount.contains(str)) {
                        return getString(R.string.scene_voice_alias_limit3);
                    }
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= i) {
                            break;
                        } else if (TextUtils.equals(this.mVoiceInstructions.get(i2).f10863O000000o, str)) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        return getString(R.string.scene_voice_alias_limit4);
                    }
                }
                return "";
            }
            str2 = "";
            if (TextUtils.isEmpty(str2)) {
            }
        }
    }
