package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@ReactModule(name = "RNCWebView")
public class RNCWebViewModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    final String DEFAULT_MIME_TYPES = "*/*";
    public DownloadManager.Request downloadRequest;
    private ValueCallback<Uri[]> filePathCallback;
    private ValueCallback<Uri> filePathCallbackLegacy;
    private Uri outputFileUri;
    private PermissionListener webviewFileDownloaderPermissionListener = new PermissionListener() {
        /* class com.reactnativecommunity.webview.RNCWebViewModule.AnonymousClass1 */

        public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            if (i != 1) {
                return false;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(RNCWebViewModule.this.getCurrentActivity().getApplicationContext(), "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.", 1).show();
            } else if (RNCWebViewModule.this.downloadRequest != null) {
                RNCWebViewModule.this.downloadFile();
            }
            return true;
        }
    };

    public String getName() {
        return "RNCWebView";
    }

    public void onNewIntent(Intent intent) {
    }

    public RNCWebViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void isFileUploadSupported(Promise promise) {
        Boolean bool = Boolean.FALSE;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            bool = Boolean.TRUE;
        }
        if (i >= 16 && i <= 18) {
            bool = Boolean.TRUE;
        }
        promise.resolve(bool);
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (this.filePathCallback != null || this.filePathCallbackLegacy != null) {
            if (i != 1) {
                if (i == 3) {
                    this.filePathCallbackLegacy.onReceiveValue(i2 != -1 ? null : intent == null ? this.outputFileUri : intent.getData());
                }
            } else if (i2 != -1) {
                ValueCallback<Uri[]> valueCallback = this.filePathCallback;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                Uri[] selectedFiles = getSelectedFiles(intent, i2);
                if (selectedFiles != null) {
                    this.filePathCallback.onReceiveValue(selectedFiles);
                } else {
                    this.filePathCallback.onReceiveValue(new Uri[]{this.outputFileUri});
                }
            }
            this.filePathCallback = null;
            this.filePathCallbackLegacy = null;
            this.outputFileUri = null;
        }
    }

    private Uri[] getSelectedFiles(Intent intent, int i) {
        Uri[] uriArr = null;
        if (intent == null) {
            return null;
        }
        if (intent.getData() == null) {
            if (intent.getClipData() != null) {
                int itemCount = intent.getClipData().getItemCount();
                uriArr = new Uri[itemCount];
                for (int i2 = 0; i2 < itemCount; i2++) {
                    uriArr[i2] = intent.getClipData().getItemAt(i2).getUri();
                }
            }
            return uriArr;
        } else if (i != -1 || Build.VERSION.SDK_INT < 21) {
            return null;
        } else {
            return WebChromeClient.FileChooserParams.parseResult(i, intent);
        }
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        this.filePathCallbackLegacy = valueCallback;
        Intent createChooser = Intent.createChooser(getFileChooserIntent(str), "");
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(str).booleanValue()) {
            arrayList.add(getPhotoIntent());
        }
        if (acceptsVideo(str).booleanValue()) {
            arrayList.add(getVideoIntent());
        }
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (createChooser.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(createChooser, 3);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
    }

    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, Intent intent, String[] strArr, boolean z) {
        this.filePathCallback = valueCallback;
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(strArr).booleanValue()) {
            arrayList.add(getPhotoIntent());
        }
        if (acceptsVideo(strArr).booleanValue()) {
            arrayList.add(getVideoIntent());
        }
        Intent fileChooserIntent = getFileChooserIntent(strArr, z);
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", fileChooserIntent);
        intent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (intent2.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(intent2, 1);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
        return true;
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        this.downloadRequest = request;
    }

    public void downloadFile() {
        ((DownloadManager) getCurrentActivity().getBaseContext().getSystemService("download")).enqueue(this.downloadRequest);
        Toast.makeText(getCurrentActivity().getApplicationContext(), "Downloading", 1).show();
    }

    public boolean grantFileDownloaderPermissions() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean z = ContextCompat.O000000o(getCurrentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!z) {
            getPermissionAwareActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1, this.webviewFileDownloaderPermissionListener);
        }
        return z;
    }

    private Intent getPhotoIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.outputFileUri = getOutputUri("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", this.outputFileUri);
        return intent;
    }

    private Intent getVideoIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        this.outputFileUri = getOutputUri("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", this.outputFileUri);
        return intent;
    }

    private Intent getFileChooserIntent(String str) {
        String str2 = str.isEmpty() ? "*/*" : str;
        if (str.matches("\\.\\w+")) {
            str2 = getMimeTypeFromExtension(str.replace(".", ""));
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str2);
        return intent;
    }

    private Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        return intent;
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains("image"));
    }

    private Boolean acceptsImages(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(isArrayEmpty(acceptedMimeType).booleanValue() || arrayContainsString(acceptedMimeType, "image").booleanValue());
    }

    private Boolean acceptsVideo(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains("video"));
    }

    private Boolean acceptsVideo(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(isArrayEmpty(acceptedMimeType).booleanValue() || arrayContainsString(acceptedMimeType, "video").booleanValue());
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String contains : strArr) {
            if (contains.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (isArrayEmpty(strArr).booleanValue()) {
            return new String[]{"*/*"};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str.matches("\\.\\w+")) {
                strArr2[i] = getMimeTypeFromExtension(str.replace(".", ""));
            } else {
                strArr2[i] = str;
            }
        }
        return strArr2;
    }

    private String getMimeTypeFromExtension(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    private Uri getOutputUri(String str) {
        File file;
        try {
            file = getCapturedFile(str);
        } catch (IOException e) {
            Log.e("CREATE FILE", "Error occurred while creating the File", e);
            e.printStackTrace();
            file = null;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return Uri.fromFile(file);
        }
        String packageName = getReactApplicationContext().getPackageName();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        return FileProvider.getUriForFile(reactApplicationContext, packageName + ".fileprovider", file);
    }

    private File getCapturedFile(String str) throws IOException {
        String str2;
        String str3;
        String str4 = "";
        if (str.equals("android.media.action.IMAGE_CAPTURE")) {
            str4 = Environment.DIRECTORY_PICTURES;
            str2 = "image-";
            str3 = ".jpg";
        } else if (str.equals("android.media.action.VIDEO_CAPTURE")) {
            str4 = Environment.DIRECTORY_MOVIES;
            str2 = "video-";
            str3 = ".mp4";
        } else {
            str2 = str4;
            str3 = str2;
        }
        String str5 = str2 + String.valueOf(System.currentTimeMillis()) + str3;
        if (Build.VERSION.SDK_INT < 23) {
            return new File(Environment.getExternalStoragePublicDirectory(str4), str5);
        }
        return File.createTempFile(str5, str3, getReactApplicationContext().getExternalFilesDir(null));
    }

    private Boolean isArrayEmpty(String[] strArr) {
        boolean z = false;
        if (strArr.length == 0 || (strArr.length == 1 && strArr[0].length() == 0)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }
}
