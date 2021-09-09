package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUploader {
    private static AccessTokenTracker accessTokenTracker;
    private static Handler handler;
    private static boolean initialized;
    private static Set<UploadContext> pendingUploads = new HashSet();
    private static WorkQueue uploadQueue = new WorkQueue(8);

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(shareVideoContent, "me", facebookCallback);
        }
    }

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            if (!initialized) {
                registerAccessTokenTracker();
                initialized = true;
            }
            Validate.notNull(shareVideoContent, "videoContent");
            Validate.notNull(str, "graphNode");
            ShareVideo video = shareVideoContent.getVideo();
            Validate.notNull(video, "videoContent.video");
            Validate.notNull(video.getLocalUrl(), "videoContent.video.localUrl");
            UploadContext uploadContext = new UploadContext(shareVideoContent, str, facebookCallback);
            uploadContext.initialize();
            pendingUploads.add(uploadContext);
            enqueueUploadStart(uploadContext, 0);
        }
    }

    public static synchronized void cancelAllRequests() {
        synchronized (VideoUploader.class) {
            for (UploadContext uploadContext : pendingUploads) {
                uploadContext.isCanceled = true;
            }
        }
    }

    private static synchronized void removePendingUpload(UploadContext uploadContext) {
        synchronized (VideoUploader.class) {
            pendingUploads.remove(uploadContext);
        }
    }

    public static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (VideoUploader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    public static void issueResponse(UploadContext uploadContext, FacebookException facebookException, String str) {
        removePendingUpload(uploadContext);
        Utility.closeQuietly(uploadContext.videoStream);
        if (uploadContext.callback == null) {
            return;
        }
        if (facebookException != null) {
            ShareInternalUtility.invokeOnErrorCallback(uploadContext.callback, facebookException);
        } else if (uploadContext.isCanceled) {
            ShareInternalUtility.invokeOnCancelCallback(uploadContext.callback);
        } else {
            ShareInternalUtility.invokeOnSuccessCallback(uploadContext.callback, str);
        }
    }

    public static void enqueueUploadStart(UploadContext uploadContext, int i) {
        enqueueRequest(uploadContext, new StartUploadWorkItem(uploadContext, i));
    }

    public static void enqueueUploadChunk(UploadContext uploadContext, String str, String str2, int i) {
        enqueueRequest(uploadContext, new TransferChunkWorkItem(uploadContext, str, str2, i));
    }

    public static void enqueueUploadFinish(UploadContext uploadContext, int i) {
        enqueueRequest(uploadContext, new FinishUploadWorkItem(uploadContext, i));
    }

    private static synchronized void enqueueRequest(UploadContext uploadContext, Runnable runnable) {
        synchronized (VideoUploader.class) {
            uploadContext.workItem = uploadQueue.addActiveWorkItem(runnable);
        }
    }

    public static byte[] getChunk(UploadContext uploadContext, String str, String str2) throws IOException {
        int read;
        if (!Utility.areObjectsEqual(str, uploadContext.chunkStart)) {
            logError(null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", uploadContext.chunkStart, str);
            return null;
        }
        int parseLong = (int) (Long.parseLong(str2) - Long.parseLong(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Math.min(8192, parseLong)];
        do {
            read = uploadContext.videoStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                parseLong -= read;
                if (parseLong != 0) {
                }
            }
            uploadContext.chunkStart = str2;
            return byteArrayOutputStream.toByteArray();
        } while (parseLong >= 0);
        logError(null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", Integer.valueOf(parseLong + read), Integer.valueOf(read));
        return null;
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new AccessTokenTracker() {
            /* class com.facebook.share.internal.VideoUploader.AnonymousClass1 */

            public final void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken != null) {
                    if (accessToken2 == null || !Utility.areObjectsEqual(accessToken2.getUserId(), accessToken.getUserId())) {
                        VideoUploader.cancelAllRequests();
                    }
                }
            }
        };
    }

    public static void logError(Exception exc, String str, Object... objArr) {
        Log.e("VideoUploader", String.format(Locale.ROOT, str, objArr), exc);
    }

    static class UploadContext {
        public final AccessToken accessToken;
        public final FacebookCallback<Sharer.Result> callback;
        public String chunkStart;
        public final String description;
        public final String graphNode;
        public boolean isCanceled;
        public Bundle params;
        public final String ref;
        public String sessionId;
        public final String title;
        public String videoId;
        public long videoSize;
        public InputStream videoStream;
        public final Uri videoUri;
        public WorkQueue.WorkItem workItem;

        private UploadContext(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) {
            this.chunkStart = "0";
            this.accessToken = AccessToken.getCurrentAccessToken();
            this.videoUri = shareVideoContent.getVideo().getLocalUrl();
            this.title = shareVideoContent.getContentTitle();
            this.description = shareVideoContent.getContentDescription();
            this.ref = shareVideoContent.getRef();
            this.graphNode = str;
            this.callback = facebookCallback;
            this.params = shareVideoContent.getVideo().getParameters();
            if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                this.params.putString("tags", TextUtils.join(", ", shareVideoContent.getPeopleIds()));
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                this.params.putString("place", shareVideoContent.getPlaceId());
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                this.params.putString("ref", shareVideoContent.getRef());
            }
        }

        public void initialize() throws FileNotFoundException {
            try {
                if (Utility.isFileUri(this.videoUri)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(this.videoUri.getPath()), 268435456);
                    this.videoSize = open.getStatSize();
                    this.videoStream = new ParcelFileDescriptor.AutoCloseInputStream(open);
                } else if (Utility.isContentUri(this.videoUri)) {
                    this.videoSize = Utility.getContentSize(this.videoUri);
                    this.videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.videoUri);
                } else {
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
            } catch (FileNotFoundException e) {
                Utility.closeQuietly(this.videoStream);
                throw e;
            }
        }
    }

    static class StartUploadWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
            /* class com.facebook.share.internal.VideoUploader.StartUploadWorkItem.AnonymousClass1 */

            {
                add(6000);
            }
        };

        public StartUploadWorkItem(UploadContext uploadContext, int i) {
            super(uploadContext, i);
        }

        public Bundle getParameters() {
            Bundle bundle = new Bundle();
            bundle.putString("upload_phase", "start");
            bundle.putLong("file_size", this.uploadContext.videoSize);
            return bundle;
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(JSONObject jSONObject) throws JSONException {
            this.uploadContext.sessionId = jSONObject.getString("upload_session_id");
            this.uploadContext.videoId = jSONObject.getString("video_id");
            VideoUploader.enqueueUploadChunk(this.uploadContext, jSONObject.getString("start_offset"), jSONObject.getString("end_offset"), 0);
        }

        /* access modifiers changed from: protected */
        public void handleError(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error starting video upload", new Object[0]);
            endUploadWithFailure(facebookException);
        }

        /* access modifiers changed from: protected */
        public Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* access modifiers changed from: protected */
        public void enqueueRetry(int i) {
            VideoUploader.enqueueUploadStart(this.uploadContext, i);
        }
    }

    static class TransferChunkWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
            /* class com.facebook.share.internal.VideoUploader.TransferChunkWorkItem.AnonymousClass1 */

            {
                add(1363019);
                add(1363021);
                add(1363030);
                add(1363033);
                add(1363041);
            }
        };
        private String chunkEnd;
        private String chunkStart;

        public TransferChunkWorkItem(UploadContext uploadContext, String str, String str2, int i) {
            super(uploadContext, i);
            this.chunkStart = str;
            this.chunkEnd = str2;
        }

        public Bundle getParameters() throws IOException {
            Bundle bundle = new Bundle();
            bundle.putString("upload_phase", "transfer");
            bundle.putString("upload_session_id", this.uploadContext.sessionId);
            bundle.putString("start_offset", this.chunkStart);
            byte[] chunk = VideoUploader.getChunk(this.uploadContext, this.chunkStart, this.chunkEnd);
            if (chunk != null) {
                bundle.putByteArray("video_file_chunk", chunk);
                return bundle;
            }
            throw new FacebookException("Error reading video");
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(JSONObject jSONObject) throws JSONException {
            String string = jSONObject.getString("start_offset");
            String string2 = jSONObject.getString("end_offset");
            if (Utility.areObjectsEqual(string, string2)) {
                VideoUploader.enqueueUploadFinish(this.uploadContext, 0);
            } else {
                VideoUploader.enqueueUploadChunk(this.uploadContext, string, string2, 0);
            }
        }

        /* access modifiers changed from: protected */
        public void handleError(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error uploading video '%s'", this.uploadContext.videoId);
            endUploadWithFailure(facebookException);
        }

        /* access modifiers changed from: protected */
        public Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* access modifiers changed from: protected */
        public void enqueueRetry(int i) {
            VideoUploader.enqueueUploadChunk(this.uploadContext, this.chunkStart, this.chunkEnd, i);
        }
    }

    static class FinishUploadWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
            /* class com.facebook.share.internal.VideoUploader.FinishUploadWorkItem.AnonymousClass1 */

            {
                add(1363011);
            }
        };

        public FinishUploadWorkItem(UploadContext uploadContext, int i) {
            super(uploadContext, i);
        }

        public Bundle getParameters() {
            Bundle bundle = new Bundle();
            if (this.uploadContext.params != null) {
                bundle.putAll(this.uploadContext.params);
            }
            bundle.putString("upload_phase", "finish");
            bundle.putString("upload_session_id", this.uploadContext.sessionId);
            Utility.putNonEmptyString(bundle, "title", this.uploadContext.title);
            Utility.putNonEmptyString(bundle, "description", this.uploadContext.description);
            Utility.putNonEmptyString(bundle, "ref", this.uploadContext.ref);
            return bundle;
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(JSONObject jSONObject) throws JSONException {
            if (jSONObject.getBoolean("success")) {
                issueResponseOnMainThread(null, this.uploadContext.videoId);
            } else {
                handleError(new FacebookException("Unexpected error in server response"));
            }
        }

        /* access modifiers changed from: protected */
        public void handleError(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Video '%s' failed to finish uploading", this.uploadContext.videoId);
            endUploadWithFailure(facebookException);
        }

        /* access modifiers changed from: protected */
        public Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* access modifiers changed from: protected */
        public void enqueueRetry(int i) {
            VideoUploader.enqueueUploadFinish(this.uploadContext, i);
        }
    }

    static abstract class UploadWorkItemBase implements Runnable {
        protected int completedRetries;
        protected UploadContext uploadContext;

        /* access modifiers changed from: protected */
        public abstract void enqueueRetry(int i);

        /* access modifiers changed from: protected */
        public abstract Bundle getParameters() throws Exception;

        /* access modifiers changed from: protected */
        public abstract Set<Integer> getTransientErrorCodes();

        /* access modifiers changed from: protected */
        public abstract void handleError(FacebookException facebookException);

        /* access modifiers changed from: protected */
        public abstract void handleSuccess(JSONObject jSONObject) throws JSONException;

        protected UploadWorkItemBase(UploadContext uploadContext2, int i) {
            this.uploadContext = uploadContext2;
            this.completedRetries = i;
        }

        public void run() {
            if (!this.uploadContext.isCanceled) {
                try {
                    executeGraphRequestSynchronously(getParameters());
                } catch (FacebookException e) {
                    endUploadWithFailure(e);
                } catch (Exception e2) {
                    endUploadWithFailure(new FacebookException("Video upload failed", e2));
                }
            } else {
                endUploadWithFailure(null);
            }
        }

        /* access modifiers changed from: protected */
        public void executeGraphRequestSynchronously(Bundle bundle) {
            Bundle bundle2 = bundle;
            GraphResponse executeAndWait = new GraphRequest(this.uploadContext.accessToken, String.format(Locale.ROOT, "%s/videos", this.uploadContext.graphNode), bundle2, HttpMethod.POST, null).executeAndWait();
            if (executeAndWait != null) {
                FacebookRequestError error = executeAndWait.getError();
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (error != null) {
                    if (!attemptRetry(error.getSubErrorCode())) {
                        handleError(new FacebookGraphResponseException(executeAndWait, "Video upload failed"));
                    }
                } else if (jSONObject != null) {
                    try {
                        handleSuccess(jSONObject);
                    } catch (JSONException e) {
                        endUploadWithFailure(new FacebookException("Unexpected error in server response", e));
                    }
                } else {
                    handleError(new FacebookException("Unexpected error in server response"));
                }
            } else {
                handleError(new FacebookException("Unexpected error in server response"));
            }
        }

        private boolean attemptRetry(int i) {
            if (this.completedRetries >= 2 || !getTransientErrorCodes().contains(Integer.valueOf(i))) {
                return false;
            }
            VideoUploader.getHandler().postDelayed(new Runnable() {
                /* class com.facebook.share.internal.VideoUploader.UploadWorkItemBase.AnonymousClass1 */

                public void run() {
                    UploadWorkItemBase uploadWorkItemBase = UploadWorkItemBase.this;
                    uploadWorkItemBase.enqueueRetry(uploadWorkItemBase.completedRetries + 1);
                }
            }, (long) (((int) Math.pow(3.0d, (double) this.completedRetries)) * 5000));
            return true;
        }

        /* access modifiers changed from: protected */
        public void endUploadWithFailure(FacebookException facebookException) {
            issueResponseOnMainThread(facebookException, null);
        }

        /* access modifiers changed from: protected */
        public void issueResponseOnMainThread(final FacebookException facebookException, final String str) {
            VideoUploader.getHandler().post(new Runnable() {
                /* class com.facebook.share.internal.VideoUploader.UploadWorkItemBase.AnonymousClass2 */

                public void run() {
                    VideoUploader.issueResponse(UploadWorkItemBase.this.uploadContext, facebookException, str);
                }
            });
        }
    }
}
