package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi {
    private String graphNode = "me";
    private String message;
    private final ShareContent shareContent;

    public static void share(ShareContent shareContent2, FacebookCallback<Sharer.Result> facebookCallback) {
        new ShareApi(shareContent2).share(facebookCallback);
    }

    public ShareApi(ShareContent shareContent2) {
        this.shareContent = shareContent2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getGraphNode() {
        return this.graphNode;
    }

    public final void setGraphNode(String str) {
        this.graphNode = str;
    }

    public final ShareContent getShareContent() {
        return this.shareContent;
    }

    public final boolean canShare() {
        if (getShareContent() == null) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            return false;
        }
        Set<String> permissions = currentAccessToken.getPermissions();
        if (permissions != null && permissions.contains("publish_actions")) {
            return true;
        }
        Log.w("ShareApi", "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
        return true;
    }

    public final void share(FacebookCallback<Sharer.Result> facebookCallback) {
        if (!canShare()) {
            ShareInternalUtility.invokeCallbackWithError(facebookCallback, "Insufficient permissions for sharing content via Api.");
            return;
        }
        ShareContent shareContent2 = getShareContent();
        try {
            ShareContentValidation.validateForApiShare(shareContent2);
            if (shareContent2 instanceof ShareLinkContent) {
                shareLinkContent((ShareLinkContent) shareContent2, facebookCallback);
            } else if (shareContent2 instanceof SharePhotoContent) {
                sharePhotoContent((SharePhotoContent) shareContent2, facebookCallback);
            } else if (shareContent2 instanceof ShareVideoContent) {
                shareVideoContent((ShareVideoContent) shareContent2, facebookCallback);
            } else if (shareContent2 instanceof ShareOpenGraphContent) {
                shareOpenGraphContent((ShareOpenGraphContent) shareContent2, facebookCallback);
            }
        } catch (FacebookException e) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
        }
    }

    public final String getGraphPath(String str) {
        try {
            return String.format(Locale.ROOT, "%s/%s", URLEncoder.encode(getGraphNode(), "UTF-8"), str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void addCommonParameters(Bundle bundle, ShareContent shareContent2) {
        List<String> peopleIds = shareContent2.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putString("tags", TextUtils.join(", ", peopleIds));
        }
        if (!Utility.isNullOrEmpty(shareContent2.getPlaceId())) {
            bundle.putString("place", shareContent2.getPlaceId());
        }
        if (!Utility.isNullOrEmpty(shareContent2.getPageId())) {
            bundle.putString("page", shareContent2.getPageId());
        }
        if (!Utility.isNullOrEmpty(shareContent2.getRef())) {
            bundle.putString("ref", shareContent2.getRef());
        }
    }

    private void shareOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, final FacebookCallback<Sharer.Result> facebookCallback) {
        final AnonymousClass1 r4 = new GraphRequest.Callback() {
            /* class com.facebook.share.ShareApi.AnonymousClass1 */

            public void onCompleted(GraphResponse graphResponse) {
                String str;
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    str = null;
                } else {
                    str = jSONObject.optString("id");
                }
                ShareInternalUtility.invokeCallbackWithResults(facebookCallback, str, graphResponse);
            }
        };
        final ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        Bundle bundle = action.getBundle();
        addCommonParameters(bundle, shareOpenGraphContent);
        if (!Utility.isNullOrEmpty(getMessage())) {
            bundle.putString("message", getMessage());
        }
        final Bundle bundle2 = bundle;
        final FacebookCallback<Sharer.Result> facebookCallback2 = facebookCallback;
        stageOpenGraphAction(bundle, new CollectionMapper.OnMapperCompleteListener() {
            /* class com.facebook.share.ShareApi.AnonymousClass2 */

            public void onComplete() {
                try {
                    ShareApi.handleImagesOnAction(bundle2);
                    new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.this.getGraphPath(URLEncoder.encode(action.getActionType(), "UTF-8")), bundle2, HttpMethod.POST, r4).executeAsync();
                } catch (UnsupportedEncodingException e) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback2, e);
                }
            }

            public void onError(FacebookException facebookException) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback2, facebookException);
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        putImageInBundleWithArrayFormat(r10, 0, new org.json.JSONObject(r1));
        r10.remove("image");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003e */
    public static void handleImagesOnAction(Bundle bundle) {
        String string = bundle.getString("image");
        if (string != null) {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    putImageInBundleWithArrayFormat(bundle, i, optJSONObject);
                } else {
                    bundle.putString(String.format(Locale.ROOT, "image[%d][url]", Integer.valueOf(i)), jSONArray.getString(i));
                }
            }
            bundle.remove("image");
        }
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", Integer.valueOf(i), next), jSONObject.get(next).toString());
        }
    }

    private void sharePhotoContent(SharePhotoContent sharePhotoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        ArrayList arrayList;
        FacebookCallback<Sharer.Result> facebookCallback2 = facebookCallback;
        Mutable mutable = new Mutable(0);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final Mutable mutable2 = mutable;
        final FacebookCallback<Sharer.Result> facebookCallback3 = facebookCallback;
        AnonymousClass3 r1 = new GraphRequest.Callback() {
            /* class com.facebook.share.ShareApi.AnonymousClass3 */

            public void onCompleted(GraphResponse graphResponse) {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject != null) {
                    arrayList3.add(jSONObject);
                }
                if (graphResponse.getError() != null) {
                    arrayList4.add(graphResponse);
                }
                Mutable mutable = mutable2;
                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() - 1);
                if (((Integer) mutable2.value).intValue() != 0) {
                    return;
                }
                if (!arrayList4.isEmpty()) {
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback3, null, (GraphResponse) arrayList4.get(0));
                } else if (!arrayList3.isEmpty()) {
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback3, ((JSONObject) arrayList3.get(0)).optString("id"), graphResponse);
                }
            }
        };
        try {
            for (SharePhoto next : sharePhotoContent.getPhotos()) {
                try {
                    Bundle sharePhotoCommonParameters = getSharePhotoCommonParameters(next, sharePhotoContent);
                    Bitmap bitmap = next.getBitmap();
                    Uri imageUrl = next.getImageUrl();
                    String caption = next.getCaption();
                    if (caption == null) {
                        caption = getMessage();
                    }
                    String str = caption;
                    if (bitmap != null) {
                        arrayList = arrayList2;
                        arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath("photos"), bitmap, str, sharePhotoCommonParameters, r1));
                    } else {
                        arrayList = arrayList2;
                        if (imageUrl != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath("photos"), imageUrl, str, sharePhotoCommonParameters, r1));
                        }
                    }
                    arrayList2 = arrayList;
                } catch (JSONException e) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback2, e);
                    return;
                }
            }
            ArrayList arrayList5 = arrayList2;
            mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList5.size());
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).executeAsync();
            }
        } catch (FileNotFoundException e2) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback2, e2);
        }
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent, final FacebookCallback<Sharer.Result> facebookCallback) {
        AnonymousClass4 r5 = new GraphRequest.Callback() {
            /* class com.facebook.share.ShareApi.AnonymousClass4 */

            public void onCompleted(GraphResponse graphResponse) {
                String str;
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    str = null;
                } else {
                    str = jSONObject.optString("id");
                }
                ShareInternalUtility.invokeCallbackWithResults(facebookCallback, str, graphResponse);
            }
        };
        Bundle bundle = new Bundle();
        addCommonParameters(bundle, shareLinkContent);
        bundle.putString("message", getMessage());
        bundle.putString("link", Utility.getUriString(shareLinkContent.getContentUrl()));
        bundle.putString("picture", Utility.getUriString(shareLinkContent.getImageUrl()));
        bundle.putString("name", shareLinkContent.getContentTitle());
        bundle.putString("description", shareLinkContent.getContentDescription());
        bundle.putString("ref", shareLinkContent.getRef());
        new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, r5).executeAsync();
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        try {
            VideoUploader.uploadAsync(shareVideoContent, getGraphNode(), facebookCallback);
        } catch (FileNotFoundException e) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
        }
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto sharePhoto, SharePhotoContent sharePhotoContent) throws JSONException {
        Bundle parameters = sharePhoto.getParameters();
        if (!parameters.containsKey("place") && !Utility.isNullOrEmpty(sharePhotoContent.getPlaceId())) {
            parameters.putString("place", sharePhotoContent.getPlaceId());
        }
        if (!parameters.containsKey("tags") && !Utility.isNullOrEmpty(sharePhotoContent.getPeopleIds())) {
            List<String> peopleIds = sharePhotoContent.getPeopleIds();
            if (!Utility.isNullOrEmpty(peopleIds)) {
                JSONArray jSONArray = new JSONArray();
                for (String put : peopleIds) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag_uid", put);
                    jSONArray.put(jSONObject);
                }
                parameters.putString("tags", jSONArray.toString());
            }
        }
        if (!parameters.containsKey("ref") && !Utility.isNullOrEmpty(sharePhotoContent.getRef())) {
            parameters.putString("ref", sharePhotoContent.getRef());
        }
        return parameters;
    }

    public final void stageArrayList(final ArrayList arrayList, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        final JSONArray jSONArray = new JSONArray();
        stageCollectionValues(new CollectionMapper.Collection<Integer>() {
            /* class com.facebook.share.ShareApi.AnonymousClass5 */

            public Iterator<Integer> keyIterator() {
                final int size = arrayList.size();
                final Mutable mutable = new Mutable(0);
                return new Iterator<Integer>() {
                    /* class com.facebook.share.ShareApi.AnonymousClass5.AnonymousClass1 */

                    public void remove() {
                    }

                    public boolean hasNext() {
                        return ((Integer) mutable.value).intValue() < size;
                    }

                    public Integer next() {
                        Integer num = (Integer) mutable.value;
                        Mutable mutable = mutable;
                        mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + 1);
                        return num;
                    }
                };
            }

            public Object get(Integer num) {
                return arrayList.get(num.intValue());
            }

            public void set(Integer num, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                try {
                    jSONArray.put(num.intValue(), obj);
                } catch (JSONException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging object.";
                    }
                    onErrorListener.onError(new FacebookException(localizedMessage));
                }
            }
        }, new CollectionMapper.OnMapperCompleteListener() {
            /* class com.facebook.share.ShareApi.AnonymousClass6 */

            public void onComplete() {
                onMapValueCompleteListener.onComplete(jSONArray);
            }

            public void onError(FacebookException facebookException) {
                onMapValueCompleteListener.onError(facebookException);
            }
        });
    }

    private <T> void stageCollectionValues(CollectionMapper.Collection<T> collection, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        CollectionMapper.iterate(collection, new CollectionMapper.ValueMapper() {
            /* class com.facebook.share.ShareApi.AnonymousClass7 */

            public void mapValue(Object obj, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
                if (obj instanceof ArrayList) {
                    ShareApi.this.stageArrayList((ArrayList) obj, onMapValueCompleteListener);
                } else if (obj instanceof ShareOpenGraphObject) {
                    ShareApi.this.stageOpenGraphObject((ShareOpenGraphObject) obj, onMapValueCompleteListener);
                } else if (obj instanceof SharePhoto) {
                    ShareApi.this.stagePhoto((SharePhoto) obj, onMapValueCompleteListener);
                } else {
                    onMapValueCompleteListener.onComplete(obj);
                }
            }
        }, onMapperCompleteListener);
    }

    private void stageOpenGraphAction(final Bundle bundle, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        stageCollectionValues(new CollectionMapper.Collection<String>() {
            /* class com.facebook.share.ShareApi.AnonymousClass8 */

            public Iterator<String> keyIterator() {
                return bundle.keySet().iterator();
            }

            public Object get(String str) {
                return bundle.get(str);
            }

            public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                if (!Utility.putJSONValueInBundle(bundle, str, obj)) {
                    onErrorListener.onError(new FacebookException("Unexpected value: " + obj.toString()));
                }
            }
        }, onMapperCompleteListener);
    }

    public final void stageOpenGraphObject(final ShareOpenGraphObject shareOpenGraphObject, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        final String str = string;
        if (str == null) {
            onMapValueCompleteListener.onError(new FacebookException("Open Graph objects must contain a type value."));
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        AnonymousClass9 r0 = new CollectionMapper.Collection<String>() {
            /* class com.facebook.share.ShareApi.AnonymousClass9 */

            public Iterator<String> keyIterator() {
                return shareOpenGraphObject.keySet().iterator();
            }

            public Object get(String str) {
                return shareOpenGraphObject.get(str);
            }

            public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging object.";
                    }
                    onErrorListener.onError(new FacebookException(localizedMessage));
                }
            }
        };
        final AnonymousClass10 r5 = new GraphRequest.Callback() {
            /* class com.facebook.share.ShareApi.AnonymousClass10 */

            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = "Error staging Open Graph object.";
                    }
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
                    return;
                }
                String optString = jSONObject.optString("id");
                if (optString == null) {
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
                } else {
                    onMapValueCompleteListener.onComplete(optString);
                }
            }
        };
        final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener2 = onMapValueCompleteListener;
        stageCollectionValues(r0, new CollectionMapper.OnMapperCompleteListener() {
            /* class com.facebook.share.ShareApi.AnonymousClass11 */

            public void onComplete() {
                String jSONObject = jSONObject.toString();
                Bundle bundle = new Bundle();
                bundle.putString("object", jSONObject);
                try {
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    ShareApi shareApi = ShareApi.this;
                    new GraphRequest(currentAccessToken, shareApi.getGraphPath("objects/" + URLEncoder.encode(str, "UTF-8")), bundle, HttpMethod.POST, r5).executeAsync();
                } catch (UnsupportedEncodingException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging Open Graph object.";
                    }
                    onMapValueCompleteListener2.onError(new FacebookException(localizedMessage));
                }
            }

            public void onError(FacebookException facebookException) {
                onMapValueCompleteListener2.onError(facebookException);
            }
        });
    }

    public final void stagePhoto(final SharePhoto sharePhoto, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            onMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
            return;
        }
        AnonymousClass12 r2 = new GraphRequest.Callback() {
            /* class com.facebook.share.ShareApi.AnonymousClass12 */

            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = "Error staging photo.";
                    }
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    onMapValueCompleteListener.onError(new FacebookException("Error staging photo."));
                    return;
                }
                String optString = jSONObject.optString("uri");
                if (optString == null) {
                    onMapValueCompleteListener.onError(new FacebookException("Error staging photo."));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("url", optString);
                    jSONObject2.put("user_generated", sharePhoto.getUserGenerated());
                    onMapValueCompleteListener.onComplete(jSONObject2);
                } catch (JSONException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging photo.";
                    }
                    onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
                }
            }
        };
        if (bitmap != null) {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, r2).executeAsync();
            return;
        }
        try {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, r2).executeAsync();
        } catch (FileNotFoundException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging photo.";
            }
            onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
        }
    }
}
