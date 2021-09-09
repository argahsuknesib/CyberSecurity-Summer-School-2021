package com.xiaomi.smarthome.miio.camera.face.photopicker;

import _m_j.fr;
import _m_j.gqg;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerBaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PhotoPickerActivity extends FaceManagerBaseActivity implements View.OnClickListener {
    public ImagePickerAdapter mImagePickerAdapter;
    private fr.O000000o<Cursor> mLoaderCallback = new fr.O000000o<Cursor>() {
        /* class com.xiaomi.smarthome.miio.camera.face.photopicker.PhotoPickerActivity.AnonymousClass1 */
        private final String[] IMAGE_PROJECTION = {"_data", "_display_name", "_id"};

        public void onLoaderReset(Loader<Cursor> loader) {
        }

        public /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            onLoadFinished((Loader<Cursor>) loader, (Cursor) obj);
        }

        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            if (i == 0) {
                return new CursorLoader(PhotoPickerActivity.this.getContext(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.IMAGE_PROJECTION, null, null, "date_modified DESC");
            }
            if (i != 1) {
                return null;
            }
            Context context = PhotoPickerActivity.this.getContext();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr = this.IMAGE_PROJECTION;
            return new CursorLoader(context, uri, strArr, this.IMAGE_PROJECTION[0] + " not like '%.gif%'", null, "date_added DESC");
        }

        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                ArrayList arrayList = new ArrayList();
                cursor.moveToFirst();
                do {
                    arrayList.add(new Image(cursor.getString(cursor.getColumnIndexOrThrow(this.IMAGE_PROJECTION[0])), cursor.getString(cursor.getColumnIndexOrThrow(this.IMAGE_PROJECTION[1]))));
                } while (cursor.moveToNext());
                PhotoPickerActivity.this.mImagePickerAdapter.setData(arrayList);
            }
        }
    };
    private RecyclerView mRecyclerView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_photo_picker);
        findViewById(R.id.tv_confirm).setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mImagePickerAdapter = new ImagePickerAdapter(this);
        this.mRecyclerView.setAdapter(this.mImagePickerAdapter);
        fr.O000000o(this).O000000o(this.mLoaderCallback);
    }

    private void submit() {
        List<Image> selectImages = this.mImagePickerAdapter.getSelectImages();
        if (selectImages.size() == 0) {
            gqg.O00000Oo((int) R.string.select_img_tips);
            return;
        }
        String str = selectImages.get(0).path;
        gqg.O00000Oo((int) R.string.face_recognitioning);
        mFaceManager.uploadImageFile(this, str, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.photopicker.PhotoPickerActivity.AnonymousClass2 */

            public void onSuccess(Object obj, Object obj2) {
                if (!PhotoPickerActivity.this.isFinishing()) {
                    try {
                        String string = ((JSONObject) ((JSONObject) obj).getJSONObject("data").getJSONArray("faceInfoMetas").get(0)).getString("faceId");
                        Intent intent = new Intent();
                        intent.putExtra("faceId", string);
                        PhotoPickerActivity.this.setResult(-1, intent);
                        PhotoPickerActivity.this.finish();
                    } catch (Exception e) {
                        gqg.O00000Oo((int) R.string.face_recognition_fail_tips);
                        e.printStackTrace();
                    }
                }
            }

            public void onFailure(int i, String str) {
                gqg.O00000Oo((int) R.string.face_recognition_fail_tips);
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_confirm) {
            submit();
        } else if (id == R.id.title_bar_return) {
            finish();
        }
    }
}
