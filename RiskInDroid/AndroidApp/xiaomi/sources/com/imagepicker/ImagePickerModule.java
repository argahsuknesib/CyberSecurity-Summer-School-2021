package com.imagepicker;

import _m_j.bcw;
import _m_j.bcx;
import _m_j.bcy;
import _m_j.bcz;
import _m_j.bda;
import _m_j.bdb;
import _m_j.bdc;
import _m_j.bdd;
import _m_j.bde;
import _m_j.oOOO00o0;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.webkit.MimeTypeMap;
import androidx.appcompat.app.AlertDialog;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.imagepicker.ImagePickerModule;
import com.imagepicker.utils.SimpleListDialog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

public class ImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    protected Callback callback;
    protected Uri cameraCaptureURI;
    private final int dialogThemeId;
    private bcx imageConfig = new bcx(null, null, 0, 0, 100, 0, false);
    private PermissionListener listener = new PermissionListener() {
        /* class com.imagepicker.ImagePickerModule.AnonymousClass1 */

        public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z = true;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                z = z && (iArr[i2] == 0);
            }
            if (ImagePickerModule.this.callback == null || ImagePickerModule.this.options == null) {
                return false;
            }
            if (!z) {
                ImagePickerModule.this.responseHelper.O000000o(ImagePickerModule.this.callback, "Permissions weren't granted");
                return false;
            }
            if (i == 14001) {
                ImagePickerModule imagePickerModule = ImagePickerModule.this;
                imagePickerModule.launchCamera(imagePickerModule.options, ImagePickerModule.this.callback);
            } else if (i == 14002) {
                ImagePickerModule imagePickerModule2 = ImagePickerModule.this;
                imagePickerModule2.launchImageLibrary(imagePickerModule2.options, ImagePickerModule.this.callback);
            }
            return true;
        }
    };
    private Boolean noData = Boolean.FALSE;
    public ReadableMap options;
    private Boolean pickVideo = Boolean.FALSE;
    private final ReactApplicationContext reactContext;
    public bcw responseHelper = new bcw();
    @Deprecated
    private int videoDurationLimit = 0;
    @Deprecated
    private int videoQuality = 1;

    public String getName() {
        return "ImagePickerManager";
    }

    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext, int i) {
        super(reactApplicationContext);
        this.dialogThemeId = i;
        this.reactContext = reactApplicationContext;
        this.reactContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void showImagePicker(ReadableMap readableMap, Callback callback2) {
        SimpleListDialog simpleListDialog;
        if (getCurrentActivity() == null) {
            this.responseHelper.O000000o(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        this.imageConfig = new bcx(null, null, 0, 0, 100, 0, false);
        AnonymousClass2 r11 = new bde.O000000o() {
            /* class com.imagepicker.ImagePickerModule.AnonymousClass2 */

            public final void O000000o(ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.launchCamera();
                }
            }

            public final void O00000Oo(ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.launchImageLibrary();
                }
            }

            public final void O00000o0(ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.doOnCancel();
                }
            }

            public final void O000000o(ImagePickerModule imagePickerModule, String str) {
                if (imagePickerModule != null) {
                    imagePickerModule.invokeCustomButton(str);
                }
            }
        };
        Activity activity = getActivity();
        if (activity == null) {
            simpleListDialog = null;
        } else {
            WeakReference weakReference = new WeakReference(this);
            bda bda = new bda(bda.O000000o(readableMap, "takePhotoButtonTitle", "photo"), bda.O000000o(readableMap, "chooseFromLibraryButtonTitle", "library"), bda.O000000o(readableMap, "cancelButtonTitle", "cancel"), bda.O000000o(readableMap));
            SimpleListDialog simpleListDialog2 = new SimpleListDialog(activity);
            if (bdc.O000000o(String.class, readableMap, "title")) {
                simpleListDialog2.O00000o0 = readableMap.getString("title");
            }
            simpleListDialog2.setCancelable(true);
            simpleListDialog2.setCanceledOnTouchOutside(true);
            List<String> O000000o2 = bda.O000000o();
            List<String> O00000Oo = bda.O00000Oo();
            if (O000000o2.size() > 0) {
                bde.AnonymousClass1 r3 = new SimpleListDialog.O000000o(O00000Oo, r11, weakReference) {
                    /* class _m_j.bde.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ List f12882O000000o;
                    final /* synthetic */ O000000o O00000Oo;
                    final /* synthetic */ WeakReference O00000o0;

                    {
                        this.f12882O000000o = r1;
                        this.O00000Oo = r2;
                        this.O00000o0 = r3;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
                    public final void O000000o(int i) {
                        char c;
                        String str = (String) this.f12882O000000o.get(i);
                        int hashCode = str.hashCode();
                        if (hashCode != -1367724422) {
                            if (hashCode != 106642994) {
                                if (hashCode == 166208699 && str.equals("library")) {
                                    c = 1;
                                    if (c != 0) {
                                        this.O00000Oo.O000000o((ImagePickerModule) this.O00000o0.get());
                                        return;
                                    } else if (c == 1) {
                                        this.O00000Oo.O00000Oo((ImagePickerModule) this.O00000o0.get());
                                        return;
                                    } else if (c != 2) {
                                        this.O00000Oo.O000000o((ImagePickerModule) this.O00000o0.get(), str);
                                        return;
                                    } else {
                                        this.O00000Oo.O00000o0((ImagePickerModule) this.O00000o0.get());
                                        return;
                                    }
                                }
                            } else if (str.equals("photo")) {
                                c = 0;
                                if (c != 0) {
                                }
                            }
                        } else if (str.equals("cancel")) {
                            c = 2;
                            if (c != 0) {
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                    }
                };
                simpleListDialog2.O00000Oo = (CharSequence[]) O000000o2.toArray(new String[O000000o2.size()]);
                simpleListDialog2.O00000o = r3;
            }
            simpleListDialog2.setOnCancelListener(new DialogInterface.OnCancelListener(r11, weakReference) {
                /* class _m_j.bde.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O000000o f12883O000000o;
                final /* synthetic */ WeakReference O00000Oo;

                {
                    this.f12883O000000o = r1;
                    this.O00000Oo = r2;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.f12883O000000o.O00000o0((ImagePickerModule) this.O00000Oo.get());
                }
            });
            simpleListDialog = simpleListDialog2;
        }
        simpleListDialog.show();
    }

    public void doOnCancel() {
        this.responseHelper.O000000o(this.callback);
    }

    public void launchCamera() {
        launchCamera(this.options, this.callback);
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback2) {
        int i;
        Intent intent;
        if (!isCameraAvailable()) {
            this.responseHelper.O000000o(callback2, "Camera not available");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.O000000o(callback2, "can't find current Activity");
            return;
        }
        this.options = readableMap;
        this.callback = callback2;
        if (permissionsCheck(currentActivity, callback2, 14001)) {
            parseOptions(this.options);
            if (this.pickVideo.booleanValue()) {
                i = 13004;
                intent = new Intent("android.media.action.VIDEO_CAPTURE");
                intent.putExtra("android.intent.extra.videoQuality", this.videoQuality);
                int i2 = this.videoDurationLimit;
                if (i2 > 0) {
                    intent.putExtra("android.intent.extra.durationLimit", i2);
                }
            } else {
                i = 13001;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                this.imageConfig = this.imageConfig.O000000o(bdb.O000000o(this.reactContext, this.options, false));
                if (this.imageConfig.f12875O000000o != null) {
                    this.cameraCaptureURI = bdd.O000000o(this.reactContext, this.imageConfig.f12875O000000o);
                    Uri uri = this.cameraCaptureURI;
                    if (uri == null) {
                        this.responseHelper.O000000o(callback2, "Couldn't get file path for photo");
                        return;
                    }
                    intent.putExtra("output", uri);
                } else {
                    this.responseHelper.O000000o(callback2, "Couldn't get file path for photo");
                    return;
                }
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.O000000o(callback2, "Cannot launch camera");
                return;
            }
            if (Build.VERSION.SDK_INT <= 19) {
                for (ResolveInfo resolveInfo : this.reactContext.getPackageManager().queryIntentActivities(intent, 65536)) {
                    this.reactContext.grantUriPermission(resolveInfo.activityInfo.packageName, this.cameraCaptureURI, 3);
                }
            }
            try {
                currentActivity.startActivityForResult(intent, i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                this.responseHelper.O000000o(callback2, "Cannot launch camera");
            }
        }
    }

    public void launchImageLibrary() {
        launchImageLibrary(this.options, this.callback);
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback2) {
        int i;
        Intent intent;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.O000000o(callback2, "can't find current Activity");
            return;
        }
        this.options = readableMap;
        this.callback = callback2;
        if (permissionsCheck(currentActivity, callback2, 14002)) {
            parseOptions(this.options);
            if (this.pickVideo.booleanValue()) {
                i = 13003;
                intent = new Intent("android.intent.action.PICK");
                intent.setType("video/*");
            } else {
                i = 13002;
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.O000000o(callback2, "Cannot launch photo library");
                return;
            }
            try {
                currentActivity.startActivityForResult(intent, i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                this.responseHelper.O000000o(callback2, "Cannot launch photo library");
            }
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Uri uri;
        if (!passResult(i)) {
            this.responseHelper.f12874O000000o = Arguments.createMap();
            if (i2 != -1) {
                bdb.O000000o(i, this.imageConfig);
                this.responseHelper.O000000o(this.callback);
                this.callback = null;
                return;
            }
            boolean z = false;
            switch (i) {
                case 13001:
                    uri = this.cameraCaptureURI;
                    break;
                case 13002:
                    uri = intent.getData();
                    String realPathFromURI = getRealPathFromURI(uri);
                    boolean z2 = !TextUtils.isEmpty(realPathFromURI) && Patterns.WEB_URL.matcher(realPathFromURI).matches();
                    if (realPathFromURI == null || z2) {
                        try {
                            File createFileFromURI = createFileFromURI(uri);
                            String absolutePath = createFileFromURI.getAbsolutePath();
                            uri = Uri.fromFile(createFileFromURI);
                            realPathFromURI = absolutePath;
                        } catch (Exception unused) {
                            this.responseHelper.O000000o("error", "Could not read photo");
                            this.responseHelper.O000000o("uri", uri.toString());
                            this.responseHelper.O00000Oo(this.callback);
                            this.callback = null;
                            return;
                        }
                    }
                    this.imageConfig = this.imageConfig.O000000o(new File(realPathFromURI));
                    break;
                case 13003:
                    this.responseHelper.O000000o("uri", intent.getData().toString());
                    this.responseHelper.O000000o("path", getRealPathFromURI(intent.getData()));
                    this.responseHelper.O00000Oo(this.callback);
                    this.callback = null;
                    return;
                case 13004:
                    String realPathFromURI2 = getRealPathFromURI(intent.getData());
                    this.responseHelper.O000000o("uri", intent.getData().toString());
                    this.responseHelper.O000000o("path", realPathFromURI2);
                    bdb.O000000o(this.reactContext, realPathFromURI2);
                    this.responseHelper.O00000Oo(this.callback);
                    this.callback = null;
                    return;
                default:
                    uri = null;
                    break;
            }
            bdb.O000000o O000000o2 = bdb.O000000o(this.responseHelper, this.imageConfig);
            if (O000000o2.O00000Oo != null) {
                bdb.O000000o(i, this.imageConfig);
                this.responseHelper.O000000o(this.callback, O000000o2.O00000Oo.getMessage());
                this.callback = null;
                return;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.imageConfig.f12875O000000o.getAbsolutePath(), options2);
            int i3 = options2.outWidth;
            int i4 = options2.outHeight;
            updatedResultResponse(uri, this.imageConfig.f12875O000000o.getAbsolutePath());
            bcx bcx = this.imageConfig;
            int i5 = O000000o2.f12880O000000o;
            if (((i3 < bcx.O00000o0 && bcx.O00000o0 > 0) || bcx.O00000o0 == 0) && (((i4 < bcx.O00000o && bcx.O00000o > 0) || bcx.O00000o == 0) && bcx.O00000oO == 100 && (bcx.O00000oo == 0 || i5 == bcx.O00000oo))) {
                z = true;
            }
            if (z) {
                this.responseHelper.O000000o("width", i3);
                this.responseHelper.O000000o("height", i4);
                bdb.O000000o(this.reactContext, this.imageConfig.f12875O000000o.getAbsolutePath());
            } else {
                this.imageConfig = bdb.O000000o(this.reactContext, this.options, this.imageConfig, i3, i4, i);
                if (this.imageConfig.O00000Oo == null) {
                    bdb.O000000o(i, this.imageConfig);
                    this.responseHelper.O000000o("error", "Can't resize the image");
                } else {
                    Uri fromFile = Uri.fromFile(this.imageConfig.O00000Oo);
                    BitmapFactory.decodeFile(this.imageConfig.O00000Oo.getAbsolutePath(), options2);
                    this.responseHelper.O000000o("width", options2.outWidth);
                    this.responseHelper.O000000o("height", options2.outHeight);
                    updatedResultResponse(fromFile, this.imageConfig.O00000Oo.getAbsolutePath());
                    bdb.O000000o(this.reactContext, this.imageConfig.O00000Oo.getAbsolutePath());
                }
            }
            if (this.imageConfig.O0000O0o && i == 13001) {
                bdb.O00000Oo O000000o3 = bdb.O000000o(this.imageConfig);
                if (O000000o3.O00000Oo == null) {
                    this.imageConfig = O000000o3.f12881O000000o;
                    updatedResultResponse(Uri.fromFile(this.imageConfig.O000000o()), this.imageConfig.O000000o().getAbsolutePath());
                } else {
                    bdb.O000000o(i, this.imageConfig);
                    this.responseHelper.O000000o("error", "Error moving image to camera roll: " + O000000o3.O00000Oo.getMessage());
                    return;
                }
            }
            this.responseHelper.O00000Oo(this.callback);
            this.callback = null;
            this.options = null;
        }
    }

    public void invokeCustomButton(String str) {
        bcw bcw = this.responseHelper;
        Callback callback2 = this.callback;
        bcw.f12874O000000o = Arguments.createMap();
        bcw.f12874O000000o.putString("customButton", str);
        bcw.O00000Oo(callback2);
    }

    public Context getContext() {
        return getReactApplicationContext();
    }

    public int getDialogThemeId() {
        return this.dialogThemeId;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    private boolean passResult(int i) {
        if (this.callback == null) {
            return true;
        }
        if (this.cameraCaptureURI == null && i == 13001) {
            return true;
        }
        return (i == 13001 || i == 13002 || i == 13003 || i == 13004) ? false : true;
    }

    private void updatedResultResponse(Uri uri, String str) {
        this.responseHelper.O000000o("uri", uri.toString());
        this.responseHelper.O000000o("path", str);
        if (!this.noData.booleanValue()) {
            this.responseHelper.O000000o("data", getBase64StringFromFile(str));
        }
        putExtraFileInfo(str, this.responseHelper);
    }

    private boolean permissionsCheck(Activity activity, Callback callback2, int i) {
        boolean z = true;
        if (oOOO00o0.O000000o(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && oOOO00o0.O000000o(activity, "android.permission.CAMERA") == 0) {
            return true;
        }
        if (!oOOO00o0.O000000o(activity, "android.permission.WRITE_EXTERNAL_STORAGE") || !oOOO00o0.O000000o(activity, "android.permission.CAMERA")) {
            z = false;
        }
        if (z) {
            ReadableMap readableMap = this.options;
            AnonymousClass3 r9 = new bcz.O000000o() {
                /* class com.imagepicker.ImagePickerModule.AnonymousClass3 */

                public final void O000000o(WeakReference<ImagePickerModule> weakReference) {
                    ImagePickerModule imagePickerModule = weakReference.get();
                    if (imagePickerModule != null) {
                        imagePickerModule.doOnCancel();
                    }
                }

                public final void O00000Oo(WeakReference<ImagePickerModule> weakReference) {
                    ImagePickerModule imagePickerModule = weakReference.get();
                    if (imagePickerModule != null) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", imagePickerModule.getContext().getPackageName(), null));
                        Activity activity = imagePickerModule.getActivity();
                        if (activity != null) {
                            activity.startActivityForResult(intent, 1);
                        }
                    }
                }
            };
            AlertDialog alertDialog = null;
            if (getContext() != null && readableMap.hasKey("permissionDenied")) {
                ReadableMap map = readableMap.getMap("permissionDenied");
                if (((ReadableNativeMap) map).toHashMap().size() != 0) {
                    String string = map.getString("title");
                    String string2 = map.getString("text");
                    String string3 = map.getString("reTryTitle");
                    String string4 = map.getString("okTitle");
                    WeakReference weakReference = new WeakReference(this);
                    Activity activity2 = getActivity();
                    if (activity2 != null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity2, getDialogThemeId());
                        builder.setTitle(string).setMessage(string2).setCancelable(false).setNegativeButton(string4, new DialogInterface.OnClickListener(r9, weakReference) {
                            /* class _m_j.bcz.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O000000o f12877O000000o;
                            final /* synthetic */ WeakReference O00000Oo;

                            {
                                this.f12877O000000o = r1;
                                this.O00000Oo = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f12877O000000o.O000000o(this.O00000Oo);
                            }
                        }).setPositiveButton(string3, new DialogInterface.OnClickListener(r9, weakReference) {
                            /* class _m_j.bcz.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O000000o f12876O000000o;
                            final /* synthetic */ WeakReference O00000Oo;

                            {
                                this.f12876O000000o = r1;
                                this.O00000Oo = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f12876O000000o.O00000Oo(this.O00000Oo);
                            }
                        });
                        alertDialog = builder.create();
                    }
                }
            }
            if (alertDialog != null) {
                alertDialog.show();
            }
            return false;
        }
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
        if (activity instanceof ReactActivity) {
            ((ReactActivity) activity).requestPermissions(strArr, i, this.listener);
        } else if (activity instanceof PermissionAwareActivity) {
            ((PermissionAwareActivity) activity).requestPermissions(strArr, i, this.listener);
        } else if (activity instanceof bcy) {
            ((bcy) activity).setPermissionListener(this.listener);
            oOOO00o0.O000000o(activity, strArr, i);
        } else {
            throw new UnsupportedOperationException(activity.getClass().getSimpleName() + " must implement " + bcy.class.getSimpleName() + " or " + PermissionAwareActivity.class.getSimpleName());
        }
        return false;
    }

    private boolean isCameraAvailable() {
        return this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera") || this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    private String getRealPathFromURI(Uri uri) {
        ReactApplicationContext reactApplicationContext = this.reactContext;
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(reactApplicationContext, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return uri.getLastPathSegment();
                }
                if (!(reactApplicationContext.getPackageName() + ".provider").equals(uri.getAuthority())) {
                    return bdd.O000000o(reactApplicationContext, uri, null, null);
                }
                File file = new File(reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES), uri.getLastPathSegment());
                if (file.exists()) {
                    return file.toString();
                }
                return null;
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
            return bdd.O000000o(reactApplicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return bdd.O000000o(reactApplicationContext, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    private File createFileFromURI(Uri uri) throws Exception {
        File externalCacheDir = this.reactContext.getExternalCacheDir();
        File file = new File(externalCacheDir, "photo-" + uri.getLastPathSegment());
        InputStream openInputStream = this.reactContext.getContentResolver().openInputStream(uri);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    return file;
                }
            }
        } finally {
            fileOutputStream.close();
            openInputStream.close();
        }
    }

    private String getBase64StringFromFile(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            fileInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return Base64.encodeToString(byteArray, 2);
    }

    private void putExtraFileInfo(String str, bcw bcw) {
        try {
            File file = new File(str);
            bcw.O000000o("fileSize", (double) file.length());
            bcw.O000000o("fileName", file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            bcw.O000000o("type", MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    private void parseOptions(ReadableMap readableMap) {
        boolean z;
        this.noData = Boolean.FALSE;
        if (readableMap.hasKey("noData")) {
            this.noData = Boolean.valueOf(readableMap.getBoolean("noData"));
        }
        bcx bcx = this.imageConfig;
        int i = readableMap.hasKey("maxWidth") ? readableMap.getInt("maxWidth") : 0;
        int i2 = readableMap.hasKey("maxHeight") ? readableMap.getInt("maxHeight") : 0;
        int i3 = readableMap.hasKey("quality") ? (int) (readableMap.getDouble("quality") * 100.0d) : 100;
        int i4 = readableMap.hasKey("rotation") ? readableMap.getInt("rotation") : 0;
        if (readableMap.hasKey("storageOptions")) {
            ReadableMap map = readableMap.getMap("storageOptions");
            if (map.hasKey("cameraRoll")) {
                z = map.getBoolean("cameraRoll");
                this.imageConfig = new bcx(bcx.f12875O000000o, bcx.O00000Oo, i, i2, i3, i4, z);
                this.pickVideo = Boolean.FALSE;
                if (readableMap.hasKey("mediaType") && readableMap.getString("mediaType").equals("video")) {
                    this.pickVideo = Boolean.TRUE;
                }
                this.videoQuality = 1;
                if (readableMap.hasKey("videoQuality") && readableMap.getString("videoQuality").equals("low")) {
                    this.videoQuality = 0;
                }
                this.videoDurationLimit = 0;
                if (!readableMap.hasKey("durationLimit")) {
                    this.videoDurationLimit = readableMap.getInt("durationLimit");
                    return;
                }
                return;
            }
        }
        z = false;
        this.imageConfig = new bcx(bcx.f12875O000000o, bcx.O00000Oo, i, i2, i3, i4, z);
        this.pickVideo = Boolean.FALSE;
        this.pickVideo = Boolean.TRUE;
        this.videoQuality = 1;
        this.videoQuality = 0;
        this.videoDurationLimit = 0;
        if (!readableMap.hasKey("durationLimit")) {
        }
    }
}
