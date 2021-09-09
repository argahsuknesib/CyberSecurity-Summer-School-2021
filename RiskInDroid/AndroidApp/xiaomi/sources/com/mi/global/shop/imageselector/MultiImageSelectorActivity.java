package com.mi.global.shop.imageselector;

import _m_j.caa;
import _m_j.cab;
import _m_j.cac;
import _m_j.cbb;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cee;
import _m_j.cpf;
import _m_j.fr;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.FileProvider;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.imageselector.adapter.FolderAdapter;
import com.mi.global.shop.imageselector.bean.Image;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.multimonitor.CrashReport;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiImageSelectorActivity extends BaseActivity {
    public static final String TAG = "MultiImageSelectorActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f4875O000000o;
    private CustomButtonView O00000Oo;
    private View O00000o;
    private CustomTextView O00000o0;
    private File O00000oO;
    private fr.O000000o<Cursor> O00000oo = new fr.O000000o<Cursor>() {
        /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass9 */
        private final String[] O00000Oo = {"_data", "_display_name", "date_added", "mime_type", "_size", "_id"};

        public final void onLoaderReset(Loader<Cursor> loader) {
        }

        public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            Cursor cursor = (Cursor) obj;
            String str = MultiImageSelectorActivity.this.mFolderAdapter.getCount() > MultiImageSelectorActivity.this.mFolderAdapter.O00000o0 ? MultiImageSelectorActivity.this.mFolderAdapter.getItem(MultiImageSelectorActivity.this.mFolderAdapter.O00000o0).O00000Oo : "/sdcard";
            MultiImageSelectorActivity.this.mResultFolder.clear();
            cab cab = new cab();
            cab.f13512O000000o = MultiImageSelectorActivity.this.getResources().getString(R.string.shop_mis_folder_all);
            cab.O00000Oo = "/sdcard";
            cab.O00000o = new ArrayList<>();
            MultiImageSelectorActivity.this.mResultFolder.add(cab);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    boolean z = false;
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(this.O00000Oo[0]));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.O00000Oo[1]));
                    long j = cursor.getLong(cursor.getColumnIndexOrThrow(this.O00000Oo[2]));
                    if (!TextUtils.isEmpty(string)) {
                        z = new File(string).exists();
                    }
                    if (z) {
                        Image image = null;
                        if (!TextUtils.isEmpty(string2)) {
                            image = new Image(string, string2, j);
                            cab.O00000o.add(image);
                            if (cab.O00000o0 == null) {
                                cab.O00000o0 = image;
                            }
                        }
                        File parentFile = new File(string).getParentFile();
                        if (parentFile != null && parentFile.exists()) {
                            String absolutePath = parentFile.getAbsolutePath();
                            cab folderByPath = MultiImageSelectorActivity.this.getFolderByPath(absolutePath);
                            if (folderByPath == null) {
                                cab cab2 = new cab();
                                cab2.f13512O000000o = parentFile.getName();
                                cab2.O00000Oo = absolutePath;
                                cab2.O00000o0 = image;
                                ArrayList<Image> arrayList = new ArrayList<>();
                                arrayList.add(image);
                                cab2.O00000o = arrayList;
                                MultiImageSelectorActivity.this.mResultFolder.add(cab2);
                            } else {
                                folderByPath.O00000o.add(image);
                            }
                        }
                    }
                } while (cursor.moveToNext());
                FolderAdapter folderAdapter = MultiImageSelectorActivity.this.mFolderAdapter;
                ArrayList<cab> arrayList2 = MultiImageSelectorActivity.this.mResultFolder;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    folderAdapter.f4885O000000o.clear();
                } else {
                    folderAdapter.f4885O000000o = arrayList2;
                }
                folderAdapter.notifyDataSetChanged();
                int folderIndexByPath = MultiImageSelectorActivity.this.getFolderIndexByPath(str);
                MultiImageSelectorActivity.this.mFolderAdapter.O00000Oo(folderIndexByPath);
                MultiImageSelectorActivity.this.updateFolder(folderIndexByPath);
                if (MultiImageSelectorActivity.this.resultList != null && MultiImageSelectorActivity.this.resultList.size() > 0) {
                    MultiImageSelectorActivity.this.mImageAdapter.O0000O0o = MultiImageSelectorActivity.this.resultList;
                }
            }
        }

        public final Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            if (i == 0) {
                return new CursorLoader(MultiImageSelectorActivity.this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.O00000Oo, this.O00000Oo[4] + ">0 AND " + this.O00000Oo[3] + "=? OR " + this.O00000Oo[3] + "=? ", new String[]{"image/jpeg", "image/png"}, this.O00000Oo[2] + " DESC");
            } else if (i != 1) {
                return null;
            } else {
                return new CursorLoader(MultiImageSelectorActivity.this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.O00000Oo, this.O00000Oo[4] + ">0 AND " + this.O00000Oo[0] + " like '%" + bundle.getString("path") + "%'", null, this.O00000Oo[2] + " DESC");
            }
        }
    };
    public int mDefaultCount = 9;
    public FolderAdapter mFolderAdapter;
    public ListPopupWindow mFolderPopupWindow;
    public View mGridMarkView;
    public GridView mGridView;
    public caa mImageAdapter;
    public ArrayList<cab> mResultFolder = new ArrayList<>();
    public int mode;
    public ArrayList<String> resultList = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.O00000oO = (File) bundle.getSerializable("KEY_CAMERA_TEMP_FILE");
        }
        O000000o((int) R.layout.shop_activity_multi_image);
        this.mCartView.setVisibility(8);
        boolean z = false;
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass1 */

            public final void onClick(View view) {
                MultiImageSelectorActivity.this.setResult(0);
                MultiImageSelectorActivity.this.finish();
            }
        });
        setTitle("Images");
        Intent intent = getIntent();
        this.mDefaultCount = intent.getIntExtra("max_select_count", 9);
        this.mode = intent.getIntExtra("select_count_mode", 1);
        this.f4875O000000o = intent.getBooleanExtra("show_camera", true);
        if (this.mode == 1 && intent.hasExtra("default_list")) {
            this.resultList = intent.getStringArrayListExtra("default_list");
        }
        this.O00000Oo = (CustomButtonView) findViewById(R.id.commit);
        if (this.mode == 1) {
            updateDoneText();
            this.O00000Oo.setVisibility(0);
            this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    if (MultiImageSelectorActivity.this.resultList == null || MultiImageSelectorActivity.this.resultList.size() <= 0) {
                        MultiImageSelectorActivity.this.setResult(0);
                    } else {
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("select_result", MultiImageSelectorActivity.this.resultList);
                        MultiImageSelectorActivity.this.setResult(-1, intent);
                    }
                    MultiImageSelectorActivity.this.finish();
                }
            });
        } else {
            this.O00000Oo.setVisibility(8);
        }
        this.mImageAdapter = new caa(this, this.f4875O000000o);
        caa caa = this.mImageAdapter;
        if (this.mode == 1) {
            z = true;
        }
        caa.O00000o = z;
        caa caa2 = this.mImageAdapter;
        caa2.O0000O0o = this.resultList;
        caa2.O00000oO = this.mDefaultCount;
        this.O00000o = findViewById(R.id.footer);
        this.O00000o0 = (CustomTextView) findViewById(R.id.category_btn);
        this.O00000o0.setText((int) R.string.shop_mis_folder_all);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass3 */

            public final void onClick(View view) {
                if (MultiImageSelectorActivity.this.mFolderPopupWindow == null) {
                    MultiImageSelectorActivity.this.createPopupFolderList();
                }
                if (MultiImageSelectorActivity.this.mFolderPopupWindow.O0000o.isShowing()) {
                    MultiImageSelectorActivity.this.mFolderPopupWindow.O00000Oo();
                    return;
                }
                MultiImageSelectorActivity.this.mFolderPopupWindow.a_();
                MultiImageSelectorActivity.this.mGridMarkView.setVisibility(0);
                int i = MultiImageSelectorActivity.this.mFolderAdapter.O00000o0;
                if (i != 0) {
                    i--;
                }
                MultiImageSelectorActivity.this.mFolderPopupWindow.O00000oO.setSelection(i);
            }
        });
        this.mGridView = (GridView) findViewById(R.id.grid);
        this.mGridView.setAdapter((ListAdapter) this.mImageAdapter);
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass4 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MultiImageSelectorActivity.this.mImageAdapter.O00000o0) {
                    Intent intent = new Intent(MultiImageSelectorActivity.this, ImageViewActivity.class);
                    intent.putParcelableArrayListExtra("data", MultiImageSelectorActivity.this.mImageAdapter.O00000oo);
                    intent.putStringArrayListExtra("results", MultiImageSelectorActivity.this.resultList);
                    intent.putExtra("pager", i);
                    intent.putExtra("count", MultiImageSelectorActivity.this.mDefaultCount);
                    intent.putExtra("mode", MultiImageSelectorActivity.this.mode);
                    MultiImageSelectorActivity.this.startActivityForResult(intent, 123);
                } else if (i == 0) {
                    MultiImageSelectorActivity.this.showCameraAction();
                } else {
                    try {
                        Intent intent2 = new Intent(MultiImageSelectorActivity.this, ImageViewActivity.class);
                        intent2.putParcelableArrayListExtra("data", MultiImageSelectorActivity.this.mImageAdapter.O00000oo);
                        intent2.putStringArrayListExtra("results", MultiImageSelectorActivity.this.resultList);
                        intent2.putExtra("pager", i - 1);
                        intent2.putExtra("count", MultiImageSelectorActivity.this.mDefaultCount);
                        intent2.putExtra("mode", MultiImageSelectorActivity.this.mode);
                        MultiImageSelectorActivity.this.startActivityForResult(intent2, 123);
                    } catch (Exception e) {
                        ArrayList<Image> arrayList = MultiImageSelectorActivity.this.mImageAdapter.O00000oo;
                        StringBuilder sb = new StringBuilder();
                        sb.append(arrayList.toString() + "\n");
                        sb.append(MultiImageSelectorActivity.this.resultList.toString() + "\n");
                        CrashReport.postCrash(Thread.currentThread(), new Exception(sb.toString(), e));
                    }
                }
            }
        });
        this.mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass5 */

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2) {
                    cbq.O000000o();
                } else {
                    cbq.O00000Oo();
                }
            }
        });
        this.mGridMarkView = findViewById(R.id.grid_mark);
        this.mFolderAdapter = new FolderAdapter(this);
        getSupportLoaderManager().O000000o(this.O00000oo);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        File file = this.O00000oO;
        if (file != null) {
            bundle.putSerializable("KEY_CAMERA_TEMP_FILE", file);
        }
    }

    public void createPopupFolderList() {
        int i = Device.f5099O000000o;
        int i2 = (int) (((float) Device.O00000Oo) * 0.5625f);
        this.mFolderPopupWindow = new ListPopupWindow(this);
        this.mFolderPopupWindow.O000000o(new ColorDrawable(-1));
        this.mFolderPopupWindow.O000000o(this.mFolderAdapter);
        this.mFolderPopupWindow.O00000o(i);
        ListPopupWindow listPopupWindow = this.mFolderPopupWindow;
        listPopupWindow.O0000O0o = i;
        if (i2 >= 0 || -2 == i2 || -1 == i2) {
            listPopupWindow.O00000oo = i2;
            ListPopupWindow listPopupWindow2 = this.mFolderPopupWindow;
            listPopupWindow2.O0000Ooo = this.O00000o;
            listPopupWindow2.O0000OOo();
            this.mFolderPopupWindow.O0000o00 = new AdapterView.OnItemClickListener() {
                /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass6 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != MultiImageSelectorActivity.this.mFolderAdapter.O00000o0) {
                        MultiImageSelectorActivity.this.mFolderAdapter.O00000Oo(i);
                        MultiImageSelectorActivity.this.mFolderPopupWindow.O00000Oo();
                        MultiImageSelectorActivity.this.updateFolder(i);
                        MultiImageSelectorActivity.this.mGridView.smoothScrollToPosition(0);
                    }
                }
            };
            this.mFolderPopupWindow.O000000o(new PopupWindow.OnDismissListener() {
                /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass7 */

                public final void onDismiss() {
                    MultiImageSelectorActivity.this.mGridMarkView.setVisibility(8);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void updateFolder(int i) {
        cab O000000o2 = this.mFolderAdapter.getItem(i);
        if (O000000o2 != null) {
            caa caa = this.mImageAdapter;
            ArrayList<Image> arrayList = O000000o2.O00000o;
            if (arrayList == null || arrayList.size() <= 0) {
                caa.O00000oo.clear();
            } else {
                caa.O00000oo = arrayList;
            }
            caa.notifyDataSetChanged();
            this.O00000o0.setText(O000000o2.f13512O000000o);
        }
        if (i == 0) {
            this.mImageAdapter.O000000o(true);
        } else {
            this.mImageAdapter.O000000o(false);
        }
    }

    public void updateDoneText() {
        int i;
        ArrayList<String> arrayList = this.resultList;
        if (arrayList == null || arrayList.size() <= 0) {
            this.O00000Oo.setText((int) R.string.shop_mis_action_done);
            this.O00000Oo.setEnabled(false);
            i = 0;
        } else {
            i = this.resultList.size();
            this.O00000Oo.setEnabled(true);
        }
        this.O00000Oo.setText(getString(R.string.mis_action_button_string, new Object[]{getString(R.string.shop_mis_action_done), Integer.valueOf(i), Integer.valueOf(this.mDefaultCount)}));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            try {
                onCameraShot(this.O00000oO);
            } catch (Exception e) {
                ccr.O000000o(e.getMessage());
            }
        }
        if (intent != null && i == 123) {
            this.resultList = intent.getStringArrayListExtra("result");
            ccr.O00000Oo(TAG, this.resultList.toString());
            if (i2 == -1) {
                runOnUiThread(new Runnable() {
                    /* class com.mi.global.shop.imageselector.MultiImageSelectorActivity.AnonymousClass8 */

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("select_result", MultiImageSelectorActivity.this.resultList);
                        MultiImageSelectorActivity.this.setResult(-1, intent);
                        MultiImageSelectorActivity.this.finish();
                    }
                });
                return;
            }
            caa caa = this.mImageAdapter;
            caa.O0000O0o = this.resultList;
            caa.notifyDataSetChanged();
            updateDoneText();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        ListPopupWindow listPopupWindow = this.mFolderPopupWindow;
        if (listPopupWindow != null && listPopupWindow.O0000o.isShowing()) {
            this.mFolderPopupWindow.O00000Oo();
        }
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
        if (r1.exists() == false) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092 A[Catch:{ Exception -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0096 A[Catch:{ Exception -> 0x00de }] */
    public void showCameraAction() {
        File file;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, (int) R.string.mis_msg_no_camera, 0).show();
            return;
        }
        try {
            if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
                file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                if (!file.exists()) {
                    file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Camera");
                }
                this.O00000oO = File.createTempFile("IMG_", ".jpg", file);
                Uri uriForFile = FileProvider.getUriForFile(this, cee.O000000o("file_provider_authorities"), this.O00000oO);
                cpf.O000000o((Object) ("picker file:" + this.O00000oO.getAbsolutePath() + ",mCameraTempUri:" + uriForFile));
                if (Build.VERSION.SDK_INT < 21) {
                    intent.addFlags(2);
                } else if (Build.VERSION.SDK_INT >= 16) {
                    intent.setClipData(ClipData.newUri(getContentResolver(), this.O00000oO.getName(), uriForFile));
                    intent.addFlags(2);
                } else {
                    for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 65536)) {
                        grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 2);
                    }
                }
                intent.putExtra("output", uriForFile);
                startActivityForResult(intent, 100);
            }
            file = cac.O000000o(this);
            this.O00000oO = File.createTempFile("IMG_", ".jpg", file);
            Uri uriForFile2 = FileProvider.getUriForFile(this, cee.O000000o("file_provider_authorities"), this.O00000oO);
            cpf.O000000o((Object) ("picker file:" + this.O00000oO.getAbsolutePath() + ",mCameraTempUri:" + uriForFile2));
            if (Build.VERSION.SDK_INT < 21) {
            }
            intent.putExtra("output", uriForFile2);
            startActivityForResult(intent, 100);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, (int) R.string.shop_mis_error_image_not_exist, 0).show();
        }
    }

    public cab getFolderByPath(String str) {
        ArrayList<cab> arrayList = this.mResultFolder;
        if (arrayList == null) {
            return null;
        }
        Iterator<cab> it = arrayList.iterator();
        while (it.hasNext()) {
            cab next = it.next();
            if (TextUtils.equals(next.O00000Oo, str)) {
                return next;
            }
        }
        return null;
    }

    public int getFolderIndexByPath(String str) {
        for (int i = 0; i < this.mResultFolder.size(); i++) {
            if (TextUtils.equals(this.mResultFolder.get(i).O00000Oo, str)) {
                return i;
            }
        }
        return 0;
    }

    public void onCameraShot(File file) {
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            int lastIndexOf = absolutePath.lastIndexOf(46);
            String str = absolutePath.substring(0, lastIndexOf) + "_compress" + absolutePath.substring(lastIndexOf);
            cbb.O000000o(BitmapFactory.decodeFile(absolutePath), str, Bitmap.CompressFormat.JPEG, 80);
            File file2 = new File(str);
            if (file2.exists()) {
                file.delete();
                file = file2;
            }
            Uri fromFile = Uri.fromFile(file);
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
            Intent intent = new Intent();
            this.resultList.add(fromFile.toString());
            intent.putStringArrayListExtra("select_result", this.resultList);
            setResult(-1, intent);
            cpf.O000000o((Object) "setResult picker:".concat(String.valueOf(fromFile)));
            finish();
        }
    }
}
