package com.xiaomi.smarthome.miio.camera.face.util;

import _m_j.cil;
import _m_j.civ;
import _m_j.g;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hxi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.JsonObject;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceEmptyActivity;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity;
import com.xiaomi.smarthome.miio.camera.face.model.CommonResult;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import com.xiaomi.smarthome.miio.camera.face.photopicker.PhotoPickerActivity;
import com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceUtils {
    private static String[] permitArray = {"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private static boolean isEmojiCharacter(char c) {
        if (c == 0 || c == 9 || c == 10 || c == 13) {
            return true;
        }
        if (c >= ' ' && c <= 55295) {
            return true;
        }
        if (c < 57344 || c > 65533) {
            return c >= 0 && c <= 65535;
        }
        return true;
    }

    public static void showPickAlbumGuideDialog(Activity activity, final String str, final View.OnClickListener onClickListener) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        View inflate = LayoutInflater.from(activity).inflate((int) R.layout.face_pick_album_guide_dialog, (ViewGroup) null);
        builder.O000000o(inflate);
        final MLAlertDialog O00000oO = builder.O00000oO();
        inflate.findViewById(R.id.btn_know).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass1 */

            public final void onClick(View view) {
                O00000oO.dismiss();
                FaceUtils.setNeedPickAlbumGuide(str, false);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        O00000oO.show();
    }

    public static void showSelectDialog(final Activity activity, final String str) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        String[] strArr = {activity.getString(R.string.select_dialog_camera), activity.getString(R.string.select_dialog_album), activity.getString(R.string.sh_common_cancel)};
        builder.O000000o(activity.getString(R.string.select_dialog_title));
        builder.O000000o(strArr, 0, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    hxi.O00000o.f952O000000o.O000000o("Face_CameraInput_ClickNum", new Object[0]);
                    FaceUtils.tryJumpFaceCamera(activity);
                } else if (i == 1) {
                    hxi.O00000o.f952O000000o.O000000o("Face_GalleryInput_ClickNum", new Object[0]);
                    String str = XmPluginHostApi.instance().getDeviceByDid(str).userId;
                    Activity activity = activity;
                    FaceUtils.tryChoosePicture(activity, str + str);
                }
                dialogInterface.dismiss();
            }
        });
        builder.O00000oo();
    }

    public static void tryJumpFaceCamera(final Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            activity.startActivityForResult(new Intent(activity, FaceCameraActivity.class), 102);
        } else if (XmPluginHostApi.instance().getApiLevel() >= 75) {
            XmPluginHostApi.instance().checkAndRequestPermisson(activity, true, new Callback<List<String>>() {
                /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<String>) ((List) obj));
                }

                public final void onSuccess(List<String> list) {
                    Activity activity = activity;
                    activity.startActivityForResult(new Intent(activity, FaceCameraActivity.class), 102);
                }

                public final void onFailure(int i, String str) {
                    gqg.O00000Oo("permission error");
                }
            }, permitArray);
        } else if (g.O000000o(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            gqg.O00000Oo(activity.getString(R.string.no_write_permission));
        } else if (g.O000000o(activity, "android.permission.CAMERA") != 0) {
            gqg.O00000Oo(activity.getString(R.string.camera_no_permission));
        } else {
            activity.startActivityForResult(new Intent(activity, FaceCameraActivity.class), 102);
        }
    }

    public static void tryChoosePicture(final Activity activity, String str) {
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(activity, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
        } else if (getNeedPickAlbumGuide(str)) {
            showPickAlbumGuideDialog(activity, str, new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass4 */

                public final void onClick(View view) {
                    activity.startActivityForResult(new Intent(activity, PhotoPickerActivity.class), 101);
                }
            });
        } else {
            activity.startActivityForResult(new Intent(activity, PhotoPickerActivity.class), 101);
        }
    }

    public static void processAddFaceToFigure(Context context, String str, final String str2, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        faceManager.uploadImageFile(context, str, new FaceManager.IFaceCallback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass5 */

            public final void onSuccess(JSONObject jSONObject, Object obj) {
                try {
                    faceManager.addFaceToFigure(((JSONObject) jSONObject.getJSONObject("data").getJSONArray("faceInfoMetas").get(0)).getString("faceId"), str2, "", new FaceManager.IFaceCallback() {
                        /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass5.AnonymousClass1 */

                        public void onSuccess(Object obj, Object obj2) {
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(obj, obj2);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (iFaceCallback != null) {
                                iFaceCallback.onFailure(i, str);
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                    FaceManager.IFaceCallback iFaceCallback = iFaceCallback;
                    if (iFaceCallback != null) {
                        iFaceCallback.onFailure(-1, "Json parse expection");
                    }
                }
            }

            public final void onFailure(int i, String str) {
                FaceManager.IFaceCallback iFaceCallback = iFaceCallback;
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(i, str);
                }
            }
        });
    }

    public static void processMarkFace(final Context context, final String str, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        faceManager.getFigures(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass6 */

            public final void onSuccess(Object obj, Object obj2) {
                FaceUtils.showFaceMarkDialog(context, str, ((FigureInfos) obj2).figureInfos, faceManager, iFaceCallback);
            }

            public final void onFailure(int i, String str) {
                FaceUtils.showFaceMarkDialog(context, str, null, faceManager, iFaceCallback);
            }
        });
    }

    public static void processMarkFaces(final Context context, final String str, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        faceManager.getFigures(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass7 */

            public final void onSuccess(Object obj, Object obj2) {
                FaceUtils.showFacesMarkDialog(context, str, ((FigureInfos) obj2).figureInfos, faceManager, iFaceCallback);
            }

            public final void onFailure(int i, String str) {
                FaceUtils.showFacesMarkDialog(context, str, null, faceManager, iFaceCallback);
            }
        });
    }

    public static void processReplaceFace(Context context, String str, String str2, String str3, FaceManager faceManager, FaceManager.IFaceCallback iFaceCallback) {
        final Context context2 = context;
        final String str4 = str;
        final FaceManager faceManager2 = faceManager;
        final FaceManager.IFaceCallback iFaceCallback2 = iFaceCallback;
        final String str5 = str2;
        final String str6 = str3;
        faceManager.getFigures(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass8 */

            public final void onSuccess(Object obj, Object obj2) {
                FaceUtils.showFaceReplaceDialog(context2, str4, ((FigureInfos) obj2).figureInfos, faceManager2, iFaceCallback2, str5, str6);
            }

            public final void onFailure(int i, String str) {
                FaceUtils.showFaceReplaceDialog(context2, str4, null, faceManager2, iFaceCallback2, str5, str6);
            }
        });
    }

    public static void showFaceReplaceDialog(Context context, String str, ArrayList<FigureInfo> arrayList, FaceManager faceManager, FaceManager.IFaceCallback iFaceCallback, String str2, String str3) {
        FaceMarkDialog faceMarkDialog = new FaceMarkDialog(context, str, arrayList, faceManager, str3);
        final String str4 = str3;
        final FaceManager faceManager2 = faceManager;
        final String str5 = str;
        final String str6 = str2;
        final FaceManager.IFaceCallback iFaceCallback2 = iFaceCallback;
        final Context context2 = context;
        faceMarkDialog.setOnNameSelectListener(new FaceMarkDialog.OnNameSelectListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass9 */

            public final void onNameSelected(final String str, boolean z) {
                if (!str4.equals(str)) {
                    faceManager2.deleteFaceFromFigure(str5, str6, new FaceManager.IFaceCallback() {
                        /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass9.AnonymousClass1 */

                        public void onSuccess(Object obj, Object obj2) {
                            faceManager2.getFigureByName(str, new FaceManager.IFaceCallback<JSONObject>() {
                                /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                public void onSuccess(JSONObject jSONObject, Object obj) {
                                    try {
                                        final JSONObject jSONObject2 = ((JSONObject) obj).getJSONObject("data");
                                        faceManager2.addFaceToFigure(str5, jSONObject2.getString("figureId"), str, new FaceManager.IFaceCallback() {
                                            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass9.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public void onSuccess(Object obj, Object obj2) {
                                                if (iFaceCallback2 != null) {
                                                    iFaceCallback2.onSuccess(jSONObject2.toString(), obj2);
                                                }
                                            }

                                            public void onFailure(int i, String str) {
                                                if (i == 400302) {
                                                    gqg.O00000Oo((int) R.string.figure_max_tips);
                                                } else if (i == 400305) {
                                                    gqg.O00000Oo((int) R.string.face_max_tips);
                                                } else if (iFaceCallback2 != null) {
                                                    iFaceCallback2.onFailure(i, str);
                                                }
                                            }
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        if (iFaceCallback2 != null) {
                                            FaceManager.IFaceCallback iFaceCallback = iFaceCallback2;
                                            iFaceCallback.onFailure(-1, e.getLocalizedMessage());
                                        }
                                    }
                                }

                                public void onFailure(int i, String str) {
                                    FaceUtils.processAddFace(context2, str, str5, faceManager2, iFaceCallback2);
                                }
                            });
                        }

                        public void onFailure(int i, String str) {
                            iFaceCallback2.onFailure(i, str);
                        }
                    });
                }
            }
        });
        faceMarkDialog.show();
    }

    public static void showFaceMarkDialog(final Context context, final String str, List<FigureInfo> list, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        FaceMarkDialog faceMarkDialog = new FaceMarkDialog(context, str, list, faceManager);
        faceMarkDialog.setOnNameSelectListener(new FaceMarkDialog.OnNameSelectListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass10 */

            public final void onNameSelected(final String str, boolean z) {
                faceManager.getFigureByName(str, new FaceManager.IFaceCallback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass10.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject, Object obj) {
                        try {
                            final JSONObject jSONObject2 = ((JSONObject) obj).getJSONObject("data");
                            faceManager.addFaceToFigure(str, jSONObject2.getString("figureId"), str, new FaceManager.IFaceCallback() {
                                /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                public void onSuccess(Object obj, Object obj2) {
                                    if (iFaceCallback != null) {
                                        iFaceCallback.onSuccess(jSONObject2.toString(), obj2);
                                    }
                                }

                                public void onFailure(int i, String str) {
                                    if (i == 400302) {
                                        gqg.O00000Oo((int) R.string.figure_max_tips);
                                    } else if (i == 400305) {
                                        gqg.O00000Oo((int) R.string.face_max_tips);
                                    } else if (iFaceCallback != null) {
                                        iFaceCallback.onFailure(i, str);
                                    }
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                            if (iFaceCallback != null) {
                                FaceManager.IFaceCallback iFaceCallback = iFaceCallback;
                                iFaceCallback.onFailure(-1, e.getLocalizedMessage());
                            }
                        }
                    }

                    public void onFailure(int i, String str) {
                        FaceUtils.processAddFace(context, str, str, faceManager, iFaceCallback);
                    }
                });
            }
        });
        faceMarkDialog.show();
    }

    public static void showFacesMarkDialog(final Context context, final String str, List<FigureInfo> list, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        FaceMarkDialog faceMarkDialog = new FaceMarkDialog(context, str, list, faceManager);
        faceMarkDialog.setOnNameSelectListener(new FaceMarkDialog.OnNameSelectListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass11 */

            public final void onNameSelected(final String str, boolean z) {
                faceManager.getFigureByName(str, new FaceManager.IFaceCallback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass11.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject, Object obj) {
                        try {
                            final JSONObject jSONObject2 = ((JSONObject) obj).getJSONObject("data");
                            faceManager.addFacesToFigure(str, jSONObject2.getString("figureId"), new FaceManager.IFaceCallback() {
                                /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass11.AnonymousClass1.AnonymousClass1 */

                                public void onSuccess(Object obj, Object obj2) {
                                    if (iFaceCallback != null) {
                                        iFaceCallback.onSuccess(jSONObject2.toString(), obj2);
                                    }
                                }

                                public void onFailure(int i, String str) {
                                    if (i == 400302) {
                                        gqg.O00000Oo((int) R.string.figure_max_tips);
                                    } else if (i == 400305) {
                                        gqg.O00000Oo((int) R.string.face_max_tips);
                                    } else if (iFaceCallback != null) {
                                        iFaceCallback.onFailure(i, str);
                                    }
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                            if (iFaceCallback != null) {
                                FaceManager.IFaceCallback iFaceCallback = iFaceCallback;
                                iFaceCallback.onFailure(-1, e.getLocalizedMessage());
                            }
                        }
                    }

                    public void onFailure(int i, String str) {
                        FaceUtils.processAddFaces(context, str, str, faceManager, iFaceCallback);
                    }
                });
            }
        });
        faceMarkDialog.show();
    }

    public static void processAddFace(Context context, final String str, final String str2, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        faceManager.addFigure(str, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass12 */

            public final void onSuccess(Object obj, Object obj2) {
                final JsonObject asJsonObject = ((CommonResult) obj2).data.getAsJsonObject();
                faceManager.addFaceToFigure(str2, asJsonObject.get("figureId").getAsString(), str, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass12.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (iFaceCallback != null) {
                            asJsonObject.addProperty("figureInfo", str);
                            asJsonObject.addProperty("figureName", str);
                            iFaceCallback.onSuccess(asJsonObject.toString(), obj2);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                });
            }

            public final void onFailure(int i, String str) {
                if (i == 400302) {
                    gqg.O00000Oo((int) R.string.figure_max_tips);
                    return;
                }
                FaceManager.IFaceCallback iFaceCallback = iFaceCallback;
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(i, str);
                }
            }
        });
    }

    public static void processAddFaces(Context context, final String str, final String str2, final FaceManager faceManager, final FaceManager.IFaceCallback iFaceCallback) {
        faceManager.addFigure(str, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass13 */

            public final void onSuccess(Object obj, Object obj2) {
                final JsonObject asJsonObject = ((CommonResult) obj2).data.getAsJsonObject();
                faceManager.addFacesToFigure(str2, asJsonObject.get("figureId").getAsString(), new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass13.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (iFaceCallback != null) {
                            asJsonObject.addProperty("figureInfo", str);
                            asJsonObject.addProperty("figureName", str);
                            iFaceCallback.onSuccess(asJsonObject.toString(), obj2);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                });
            }

            public final void onFailure(int i, String str) {
                if (i == 400302) {
                    gqg.O00000Oo((int) R.string.figure_max_tips);
                    return;
                }
                FaceManager.IFaceCallback iFaceCallback = iFaceCallback;
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(i, str);
                }
            }
        });
    }

    public static boolean getNeedFaceGuide(String str) {
        return cil.O00000Oo(XmPluginHostApi.instance().context(), "camera_need_face_guide_".concat(String.valueOf(str))) != 0;
    }

    public static void setNeedFaceGuide(String str, boolean z) {
        cil.O000000o("camera_need_face_guide_".concat(String.valueOf(str)), z ? 1 : 0);
    }

    public static boolean getNeedFaceGuideForUsingFreeFaceService(String str) {
        return cil.O00000Oo(XmPluginHostApi.instance().context(), "camera_need_face_guide_".concat(String.valueOf(str))) != 0;
    }

    public static void setNeedFaceGuideForUsingFreeFaceService(String str, boolean z) {
        cil.O000000o("camera_need_face_guide_".concat(String.valueOf(str)), z ? 1 : 0);
    }

    public static boolean getNeedPickAlbumGuide(String str) {
        return XmPluginHostApi.instance().context().getSharedPreferences("mijia_camera_".concat(String.valueOf(str)), 0).getBoolean("need_pick_album_guide", true);
    }

    public static void setNeedPickAlbumGuide(String str, boolean z) {
        XmPluginHostApi.instance().context().getSharedPreferences("mijia_camera_".concat(String.valueOf(str)), 0).edit().putBoolean("need_pick_album_guide", z).apply();
    }

    public static boolean containsEmoji(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean getNeedGotoManage(String str) {
        return cil.O00000Oo(XmPluginHostApi.instance().context(), "camera_need_to_face_manage_".concat(String.valueOf(str))) == 0;
    }

    public static void setNeedGotoManage(String str) {
        cil.O000000o("camera_need_to_face_manage_".concat(String.valueOf(str)), 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (getNeedFaceGuide(r8 + r3) == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        if (getNeedFaceGuideForUsingFreeFaceService(r8 + r3) != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        _m_j.hxi.O00000o.f952O000000o.O000000o("Face_NewOpen_ClickNum", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        if ("chuangmi.camera.ipc022".equals(r2.model) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        openFaceActivity(r7, r8, true, r6, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        openGuildImpl(r6, r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        return;
     */
    public static void openFaceManagerActivity(int i, Activity activity, String str, String str2) {
        boolean z;
        try {
            z = new JSONObject(str2).optBoolean("is_using_service");
        } catch (Exception unused) {
            z = false;
        }
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        String str3 = deviceByDid.userId;
        if (!getNeedFaceGuide(str)) {
            openFaceActivity(activity, str, true, i);
            return;
        }
        if (!z) {
        }
        if (z) {
        }
        openFaceActivity(activity, str, true, i);
    }

    public static void openGuildImpl(int i, Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, FaceManagerGuideActivity.class);
        intent.putExtra("extra_device_did", str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            intent.putExtra("KEY_EXTRA_face_tips_info", jSONObject.optString("face_tips"));
            intent.putExtra("KEY_EXTRA_face_from_lowpower", jSONObject.optBoolean("from_lowpower"));
            intent.putExtra("KEY_EXTRA_face_is_vip_user", jSONObject.optBoolean("is_vip_user"));
            intent.putExtra("KEY_EXTRA_face_buy_cloud_url", jSONObject.optString("buy_cloud_url"));
            intent.putExtra("KEY_EXTRA_face_buy_cloud_title", jSONObject.optString("buy_cloud_title"));
            intent.putExtra("KEY_EXTRA_face_from_camera", jSONObject.optBoolean("is_from_camera"));
            intent.putExtra("key_extra_try_face", jSONObject.optBoolean("try_use_face"));
            intent.putExtra("key_extra_is_using_free_service", jSONObject.optBoolean("is_using_service"));
            intent.putExtra("key_extra_cloud_url", jSONObject.optString("cloudUrl"));
        } catch (JSONException e) {
            gsy.O000000o(6, "openFaceManagerActivity", e.toString());
        }
        activity.startActivityForResult(intent, i);
    }

    public static void openFaceActivity(Activity activity, String str, boolean z, int i) {
        openFaceActivity(activity, str, z, i, null);
    }

    public static void openFaceActivity(Activity activity, String str, boolean z, int i, String str2) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        final String str3 = deviceByDid.userId;
        String str4 = deviceByDid.model;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("model", str4);
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        civ.O00000Oo("Face, ", "params=".concat(String.valueOf(jSONObject2)));
        final String str5 = str;
        final Activity activity2 = activity;
        final int i2 = i;
        final String str6 = str2;
        final boolean z2 = z;
        XmPluginHostApi.instance().callSmartHomeApi(str4, "business.smartcamera.", "/miot/camera/app/v1/get/figures", "GET", jSONObject2, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.FaceUtils.AnonymousClass14 */

            public final void onSuccess(JSONObject jSONObject) {
                CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                if (commonResult.code == 0) {
                    FigureInfos figureInfos = (FigureInfos) FaceManager.gGson.fromJson(commonResult.data, FigureInfos.class);
                    if (XmPluginHostApi.instance().getDeviceByDid(str5) != null) {
                        if (FaceUtils.getNeedGotoManage(str5 + str3)) {
                            FaceUtils.jumpFaceManagerActivity(activity2, str5, i2);
                            return;
                        }
                    }
                    if (figureInfos == null || figureInfos.figureInfos == null || figureInfos.figureInfos.size() <= 0) {
                        String str = str6;
                        if (str != null) {
                            FaceUtils.openGuildImpl(i2, activity2, str5, str);
                        } else {
                            FaceUtils.jumpEmptyFaceActivity(activity2, str5, z2, i2);
                        }
                    } else {
                        FaceUtils.jumpFaceManagerActivity(activity2, str5, i2);
                    }
                } else {
                    String str2 = str6;
                    if (str2 != null) {
                        FaceUtils.openGuildImpl(i2, activity2, str5, str2);
                    } else {
                        FaceUtils.jumpEmptyFaceActivity(activity2, str5, z2, i2);
                    }
                }
            }

            public final void onFailure(int i, String str) {
                String str2 = str6;
                if (str2 != null) {
                    FaceUtils.openGuildImpl(i2, activity2, str5, str2);
                } else {
                    FaceUtils.jumpEmptyFaceActivity(activity2, str5, z2, i2);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public static void jumpFaceManagerActivity(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, FaceManagerActivity.class);
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null && deviceByDid.model.equals("chuangmi.camera.ipc022")) {
            intent.setClass(activity, FaceManager2Activity.class);
        }
        intent.putExtra("extra_device_did", str);
        activity.startActivityForResult(intent, i);
    }

    public static void jumpEmptyFaceActivity(Activity activity, String str, boolean z, int i) {
        if (!z) {
            String str2 = XmPluginHostApi.instance().getDeviceByDid(str).userId;
            setNeedFaceGuideForUsingFreeFaceService(str + str2, false);
        }
        Intent intent = new Intent(activity, FaceEmptyActivity.class);
        intent.putExtra("extra_device_did", str);
        activity.startActivityForResult(intent, i);
    }
}
