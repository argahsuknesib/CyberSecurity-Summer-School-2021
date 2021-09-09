package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyNativeDialogParameters {
    private static Bundle create(ShareVideoContent shareVideoContent, boolean z) {
        return null;
    }

    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return create((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            return create((ShareVideoContent) shareContent, z);
        } else {
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            }
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return create(shareOpenGraphContent, ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), z);
            } catch (JSONException e) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        }
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z);
        Utility.putNonEmptyString(createBaseParameters, "com.facebook.platform.extra.TITLE", shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.getContentDescription());
        Utility.putUri(createBaseParameters, "com.facebook.platform.extra.IMAGE", shareLinkContent.getImageUrl());
        return createBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z);
        createBaseParameters.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(list));
        return createBaseParameters;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z);
        Utility.putNonEmptyString(createBaseParameters, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.getPreviewPropertyName());
        Utility.putNonEmptyString(createBaseParameters, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(createBaseParameters, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return createBaseParameters;
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, "com.facebook.platform.extra.LINK", shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, "com.facebook.platform.extra.PLACE", shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, "com.facebook.platform.extra.REF", shareContent.getRef());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(peopleIds));
        }
        return bundle;
    }
}
