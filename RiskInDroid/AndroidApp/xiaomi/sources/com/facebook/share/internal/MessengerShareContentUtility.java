package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessengerShareContentUtility {
    public static final Pattern FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");

    public static void addGenericTemplateContent(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        addGenericTemplateElementForPreview(bundle, shareMessengerGenericTemplateContent.getGenericTemplateElement());
        Utility.putJSONValueInBundle(bundle, "MESSENGER_PLATFORM_CONTENT", serializeGenericTemplateContent(shareMessengerGenericTemplateContent));
    }

    public static void addOpenGraphMusicTemplateContent(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        addOpenGraphMusicTemplateContentForPreview(bundle, shareMessengerOpenGraphMusicTemplateContent);
        Utility.putJSONValueInBundle(bundle, "MESSENGER_PLATFORM_CONTENT", serializeOpenGraphMusicTemplateContent(shareMessengerOpenGraphMusicTemplateContent));
    }

    public static void addMediaTemplateContent(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        addMediaTemplateContentForPreview(bundle, shareMessengerMediaTemplateContent);
        Utility.putJSONValueInBundle(bundle, "MESSENGER_PLATFORM_CONTENT", serializeMediaTemplateContent(shareMessengerMediaTemplateContent));
    }

    private static void addGenericTemplateElementForPreview(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getButton(), false);
        } else if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getDefaultAction(), true);
        }
        Utility.putUri(bundle, "IMAGE", shareMessengerGenericTemplateElement.getImageUrl());
        Utility.putNonEmptyString(bundle, "PREVIEW_TYPE", "DEFAULT");
        Utility.putNonEmptyString(bundle, "TITLE", shareMessengerGenericTemplateElement.getTitle());
        Utility.putNonEmptyString(bundle, "SUBTITLE", shareMessengerGenericTemplateElement.getSubtitle());
    }

    private static void addOpenGraphMusicTemplateContentForPreview(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        addActionButton(bundle, shareMessengerOpenGraphMusicTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, "PREVIEW_TYPE", "OPEN_GRAPH");
        Utility.putUri(bundle, "OPEN_GRAPH_URL", shareMessengerOpenGraphMusicTemplateContent.getUrl());
    }

    private static void addMediaTemplateContentForPreview(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        addActionButton(bundle, shareMessengerMediaTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, "PREVIEW_TYPE", "DEFAULT");
        Utility.putNonEmptyString(bundle, "ATTACHMENT_ID", shareMessengerMediaTemplateContent.getAttachmentId());
        if (shareMessengerMediaTemplateContent.getMediaUrl() != null) {
            Utility.putUri(bundle, getMediaUrlKey(shareMessengerMediaTemplateContent.getMediaUrl()), shareMessengerMediaTemplateContent.getMediaUrl());
        }
        Utility.putNonEmptyString(bundle, "type", getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
    }

    private static void addActionButton(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (shareMessengerActionButton != null && (shareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
            addURLActionButton(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
    }

    private static void addURLActionButton(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        String str;
        if (z) {
            str = Utility.getUriString(shareMessengerURLActionButton.getUrl());
        } else {
            str = shareMessengerURLActionButton.getTitle() + " - " + Utility.getUriString(shareMessengerURLActionButton.getUrl());
        }
        Utility.putNonEmptyString(bundle, "TARGET_DISPLAY", str);
        Utility.putUri(bundle, "ITEM_URL", shareMessengerURLActionButton.getUrl());
    }

    private static JSONObject serializeGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "generic").put("sharable", shareMessengerGenericTemplateContent.getIsSharable()).put("image_aspect_ratio", getImageRatioString(shareMessengerGenericTemplateContent.getImageAspectRatio())).put("elements", new JSONArray().put(serializeGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement())))));
    }

    private static JSONObject serializeOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "open_graph").put("elements", new JSONArray().put(serializeOpenGraphMusicTemplateElement(shareMessengerOpenGraphMusicTemplateContent)))));
    }

    private static JSONObject serializeMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "media").put("elements", new JSONArray().put(serializeMediaTemplateElement(shareMessengerMediaTemplateContent)))));
    }

    private static JSONObject serializeGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.getTitle()).put("subtitle", shareMessengerGenericTemplateElement.getSubtitle()).put("image_url", Utility.getUriString(shareMessengerGenericTemplateElement.getImageUrl()));
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerGenericTemplateElement.getButton()));
            put.put("buttons", jSONArray);
        }
        if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            put.put("default_action", serializeActionButton(shareMessengerGenericTemplateElement.getDefaultAction(), true));
        }
        return put;
    }

    private static JSONObject serializeOpenGraphMusicTemplateElement(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        JSONObject put = new JSONObject().put("url", Utility.getUriString(shareMessengerOpenGraphMusicTemplateContent.getUrl()));
        if (shareMessengerOpenGraphMusicTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton()));
            put.put("buttons", jSONArray);
        }
        return put;
    }

    private static JSONObject serializeMediaTemplateElement(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        JSONObject put = new JSONObject().put("attachment_id", shareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(shareMessengerMediaTemplateContent.getMediaUrl())).put("media_type", getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        if (shareMessengerMediaTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerMediaTemplateContent.getButton()));
            put.put("buttons", jSONArray);
        }
        return put;
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton) throws JSONException {
        return serializeActionButton(shareMessengerActionButton, false);
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            return serializeURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
        return null;
    }

    private static JSONObject serializeURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        String str;
        JSONObject put = new JSONObject().put("type", "web_url");
        if (z) {
            str = null;
        } else {
            str = shareMessengerURLActionButton.getTitle();
        }
        return put.put("title", str).put("url", Utility.getUriString(shareMessengerURLActionButton.getUrl())).put("webview_height_ratio", getWebviewHeightRatioString(shareMessengerURLActionButton.getWebviewHeightRatio())).put("messenger_extensions", shareMessengerURLActionButton.getIsMessengerExtensionURL()).put("fallback_url", Utility.getUriString(shareMessengerURLActionButton.getFallbackUrl())).put("webview_share_button", getShouldHideShareButton(shareMessengerURLActionButton));
    }

    private static String getMediaUrlKey(Uri uri) {
        String host = uri.getHost();
        return (Utility.isNullOrEmpty(host) || !FACEBOOK_DOMAIN.matcher(host).matches()) ? "IMAGE" : "uri";
    }

    private static String getWebviewHeightRatioString(ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio) {
        if (webviewHeightRatio == null) {
            return "full";
        }
        int i = AnonymousClass1.$SwitchMap$com$facebook$share$model$ShareMessengerURLActionButton$WebviewHeightRatio[webviewHeightRatio.ordinal()];
        if (i != 1) {
            return i != 2 ? "full" : "tall";
        }
        return "compact";
    }

    private static String getImageRatioString(ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio) {
        return (imageAspectRatio != null && AnonymousClass1.$SwitchMap$com$facebook$share$model$ShareMessengerGenericTemplateContent$ImageAspectRatio[imageAspectRatio.ordinal()] == 1) ? "square" : "horizontal";
    }

    /* renamed from: com.facebook.share.internal.MessengerShareContentUtility$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$model$ShareMessengerGenericTemplateContent$ImageAspectRatio = new int[ShareMessengerGenericTemplateContent.ImageAspectRatio.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$model$ShareMessengerMediaTemplateContent$MediaType = new int[ShareMessengerMediaTemplateContent.MediaType.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$model$ShareMessengerURLActionButton$WebviewHeightRatio = new int[ShareMessengerURLActionButton.WebviewHeightRatio.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003a */
        static {
            try {
                $SwitchMap$com$facebook$share$model$ShareMessengerMediaTemplateContent$MediaType[ShareMessengerMediaTemplateContent.MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$share$model$ShareMessengerGenericTemplateContent$ImageAspectRatio[ShareMessengerGenericTemplateContent.ImageAspectRatio.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            $SwitchMap$com$facebook$share$model$ShareMessengerURLActionButton$WebviewHeightRatio[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioCompact.ordinal()] = 1;
            try {
                $SwitchMap$com$facebook$share$model$ShareMessengerURLActionButton$WebviewHeightRatio[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioTall.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String getMediaType(ShareMessengerMediaTemplateContent.MediaType mediaType) {
        return (mediaType != null && AnonymousClass1.$SwitchMap$com$facebook$share$model$ShareMessengerMediaTemplateContent$MediaType[mediaType.ordinal()] == 1) ? "video" : "image";
    }

    private static String getShouldHideShareButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getShouldHideWebviewShareButton()) {
            return "hide";
        }
        return null;
    }
}
