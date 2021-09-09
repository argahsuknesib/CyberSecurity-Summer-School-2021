package com.xiaomi.mico.setting.alarm.ring;

import _m_j.ahh;
import _m_j.jgc;
import _m_j.jgi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.api.service.AiFileService;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.util.IOUtils;
import com.xiaomi.mico.common.util.PermissionHelper;
import com.xiaomi.mico.common.util.PhotoUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.AlarmVideoView;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.mico.setting.alarm.ring.AlarmRingActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import org.greenrobot.eventbus.ThreadMode;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class VidoRingFragment extends MicoBaseFragment implements AlarmRingActivity.OnTakeVideoResultListener {
    public ThirdPartyResponse.AiFileToken aiFileToken;
    public ThirdPartyResponse.AiFileUploadResult aiFileUploadResult;
    Remote.Response.AlarmRing currentAlarmRing;
    Remote.Response.AlarmRing customVideoRing;
    AlarmVideoView customVideoView;
    Remote.Response.AlarmRing defaultVideoRing;
    AlarmVideoView defualtVideoView;
    private PermissionHelper mPermissionHelper;
    Remote.Response.AlarmRing selectedRing;

    public VidoRingFragment setCurrentAlarmRing(Remote.Response.AlarmRing alarmRing) {
        if (alarmRing != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("SELECTED_ALARM_RING", alarmRing);
            setArguments(bundle);
        }
        return this;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.view_alarm_video_ring_header_item, (ViewGroup) null);
        ButterKnife.bind(this, inflate);
        this.defualtVideoView = (AlarmVideoView) inflate.findViewById(R.id.alarm_video_view);
        this.customVideoView = (AlarmVideoView) inflate.findViewById(R.id.custom_video_view);
        inflate.findViewById(R.id.add_video).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$vEMx_aZgN9QXk3fs1HzeQ34xrpQ */

            public final void onClick(View view) {
                VidoRingFragment.this.lambda$onCreateView$0$VidoRingFragment(view);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.currentAlarmRing = (Remote.Response.AlarmRing) arguments.getSerializable("SELECTED_ALARM_RING");
        }
        initView();
        jgc.O000000o().O000000o(this);
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$VidoRingFragment(View view) {
        onClick();
    }

    private void initView() {
        this.defaultVideoRing = AlarmHelper.getVideoAlarmDefaultRing();
        this.customVideoView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$b96YD5acFQcwV5fxNl6ZgxjsBwY */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VidoRingFragment.this.lambda$initView$1$VidoRingFragment(compoundButton, z);
            }
        });
        this.defualtVideoView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$aduc3FI3vll9avs3fxaRwPHOOc */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VidoRingFragment.this.lambda$initView$2$VidoRingFragment(compoundButton, z);
            }
        });
        this.customVideoView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$Jn78XQYbgfYY78scj3SG8_yik */

            public final boolean onLongClick(View view) {
                return VidoRingFragment.this.lambda$initView$3$VidoRingFragment(view);
            }
        });
        this.defualtVideoView.setVideoPath(this.defaultVideoRing.video);
        this.defualtVideoView.setVideoPreview(this.defaultVideoRing.videoImage);
        this.aiFileUploadResult = AlarmHelper.loadLastUploadVideo();
        ThirdPartyResponse.AiFileUploadResult aiFileUploadResult2 = this.aiFileUploadResult;
        if (aiFileUploadResult2 != null) {
            this.customVideoRing = AlarmHelper.getVideoAlarmRing(aiFileUploadResult2, null);
        }
        bindView(this.customVideoRing, this.currentAlarmRing);
    }

    public /* synthetic */ void lambda$initView$1$VidoRingFragment(CompoundButton compoundButton, boolean z) {
        jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(this.customVideoRing));
    }

    public /* synthetic */ void lambda$initView$2$VidoRingFragment(CompoundButton compoundButton, boolean z) {
        jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(this.defaultVideoRing));
    }

    public /* synthetic */ boolean lambda$initView$3$VidoRingFragment(View view) {
        deleteVidoDialog();
        return true;
    }

    public void replaceCustomRing(Remote.Response.AlarmRing alarmRing) {
        if (alarmRing != null) {
            this.selectedRing = alarmRing;
        } else if (this.selectedRing == this.currentAlarmRing) {
            this.selectedRing = this.defaultVideoRing;
        }
        onAlarmRingChange(this.selectedRing);
        this.customVideoRing = alarmRing;
        bindView(this.customVideoRing, this.selectedRing);
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.defualtVideoView.pauseVideo();
        this.customVideoView.pauseVideo();
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onAlarmRingChange(MicoEvent.AlarmRingChange alarmRingChange) {
        this.selectedRing = alarmRingChange.ring;
        onAlarmRingChange(this.selectedRing);
        bindView(this.customVideoRing, this.selectedRing);
    }

    private void onAlarmRingChange(Remote.Response.AlarmRing alarmRing) {
        ((AlarmRingActivity) getActivity()).onAlarmRingChange(alarmRing);
    }

    public void bindView(Remote.Response.AlarmRing alarmRing, Remote.Response.AlarmRing alarmRing2) {
        if (alarmRing2 != null) {
            this.defualtVideoView.setVideoSelected(this.defaultVideoRing.video.equals(alarmRing2.video));
        } else {
            this.defualtVideoView.setVideoSelected(false);
        }
        if (alarmRing != null) {
            if (this.customVideoView.getVisibility() != 0) {
                this.customVideoView.setVisibility(0);
            }
            if (alarmRing.videoLocalPath != null) {
                this.customVideoView.setVideoPath(alarmRing.videoLocalPath);
            } else {
                this.customVideoView.setVideoPath(alarmRing.video);
            }
            this.customVideoView.setVideoPreview(alarmRing.videoImage);
            if (alarmRing2 != null) {
                this.customVideoView.setVideoSelected(alarmRing.video.equals(alarmRing2.video));
            } else {
                this.customVideoView.setVideoSelected(false);
            }
        } else {
            this.customVideoView.setVisibility(8);
        }
    }

    public void onClick() {
        if (this.customVideoRing != null) {
            reuploadVidoDialog();
        } else {
            showTakeMediaFileDialog();
        }
    }

    public void openCameraWithPermissionCheck(Activity activity) {
        this.mPermissionHelper = new PermissionHelper(activity).withPermission("android.permission.CAMERA", R.string.permission_record_image, R.string.permission_record_image).withPermission("android.permission.WRITE_EXTERNAL_STORAGE", R.string.permission_write_storage, R.string.permission_write_storage).listener(new PermissionHelper.Listener() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass1 */

            public void onPermissionDenied(String str) {
            }

            public void onAllPermissionGranted() {
                VidoRingFragment.this.recordVideo();
            }

            public void onGoToSetting() {
                PermissionHelper.gotoPermissionSetting(VidoRingFragment.this.getContext());
            }
        });
        this.mPermissionHelper.check();
    }

    public void openAlbumWithPermissionCheck(Activity activity) {
        this.mPermissionHelper = new PermissionHelper(activity).withPermission("android.permission.WRITE_EXTERNAL_STORAGE", R.string.permission_write_storage, R.string.permission_write_storage).listener(new PermissionHelper.Listener() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass2 */

            public void onPermissionDenied(String str) {
            }

            public void onAllPermissionGranted() {
                VidoRingFragment.this.openAlbum();
            }

            public void onGoToSetting() {
                PermissionHelper.gotoPermissionSetting(VidoRingFragment.this.getContext());
            }
        });
        this.mPermissionHelper.check();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        new Object[1][0] = "onActivityResult=".concat(String.valueOf(i));
        if (i2 == -1) {
            if (i == 11) {
                Uri data = intent.getData();
                if (data != null && PhotoUtils.getDurationFromURI(getContext(), data) > 0) {
                    String dataColumn = PhotoUtils.getDataColumn(getContext(), data, null, null);
                    new Object[1][0] = "TAKE_VIDEO uri path=".concat(String.valueOf(dataColumn));
                    uploadFile(dataColumn, data);
                }
            } else if (i == 12) {
                Uri data2 = intent.getData();
                if (PhotoUtils.getDurationFromURI(getContext(), data2) > 0) {
                    String dataColumn2 = PhotoUtils.getDataColumn(getContext(), data2, null, null);
                    new Object[1][0] = "VIDEO_ALBUM path =".concat(String.valueOf(dataColumn2));
                    if (new File(dataColumn2).length() > 10485760) {
                        ToastUtil.showToast((int) R.string.alarm_video_ring_max_size);
                    } else {
                        uploadFile(dataColumn2, data2);
                    }
                }
            }
        }
    }

    private void reuploadVidoDialog() {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.alarm_video_upload_hint).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$tRPvVNvZZ1fHhJPGBOkKBLh2Uo */

            public final void onClick(DialogInterface dialogInterface, int i) {
                VidoRingFragment.this.lambda$reuploadVidoDialog$4$VidoRingFragment(dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$reuploadVidoDialog$4$VidoRingFragment(DialogInterface dialogInterface, int i) {
        showTakeMediaFileDialog();
    }

    private void deleteVidoDialog() {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.alarm_video_ring_remove_hint).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$uxdJvsEibS0HoPgkCp1KUzeSTWc */

            public final void onClick(DialogInterface dialogInterface, int i) {
                VidoRingFragment.this.lambda$deleteVidoDialog$5$VidoRingFragment(dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$deleteVidoDialog$5$VidoRingFragment(DialogInterface dialogInterface, int i) {
        deleteLastUploadVideo();
    }

    private void showTakeMediaFileDialog() {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.array.take_media_file, -1, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    VidoRingFragment vidoRingFragment = VidoRingFragment.this;
                    vidoRingFragment.openAlbumWithPermissionCheck(vidoRingFragment.getActivity());
                } else if (i == 1) {
                    VidoRingFragment vidoRingFragment2 = VidoRingFragment.this;
                    vidoRingFragment2.openCameraWithPermissionCheck(vidoRingFragment2.getActivity());
                }
                dialogInterface.dismiss();
            }
        }).O00000o().show();
    }

    public void recordVideo() {
        PhotoUtils.takeVideo(getActivity(), 11, 0, 60);
    }

    public void openAlbum() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setData(MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 12);
    }

    private void uploadFile(final String str, Uri uri) {
        showProgressDialog(null);
        final String lowerCase = IOUtils.getFileSHA1Digest(str).toLowerCase();
        AiFileService.Helper.prepare().flatMap(new Func1<AiFileService, Observable<?>>() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass7 */

            public Observable<Response<ThirdPartyResponse.AiFileToken>> call(AiFileService aiFileService) {
                return aiFileService.requestFieUpload(lowerCase);
            }
        }).flatMap(new Func1<Object, Observable<AiFileService>>() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass6 */

            public Observable<AiFileService> call(Object obj) {
                VidoRingFragment.this.aiFileToken = (ThirdPartyResponse.AiFileToken) ((Response) obj).body();
                return AiFileService.Helper.prepare();
            }
        }).flatMap(new Func1<AiFileService, Observable<Response<ThirdPartyResponse.AiFileUploadResult>>>() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass5 */

            public Observable<Response<ThirdPartyResponse.AiFileUploadResult>> call(AiFileService aiFileService) {
                File file = new File(str);
                return aiFileService.uploadVideo(MultipartBody.create(MediaType.parse("text/plain"), VidoRingFragment.this.aiFileToken.token), MultipartBody.Part.createFormData("file", file.getName(), MultipartBody.create(MediaType.parse("video/*"), file)));
            }
        }).flatMap(new Func1<Response<ThirdPartyResponse.AiFileUploadResult>, Observable<?>>() {
            /* class com.xiaomi.mico.setting.alarm.ring.VidoRingFragment.AnonymousClass4 */

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Response<ThirdPartyResponse.AiFileUploadResult>) ((Response) obj));
            }

            public Observable<?> call(Response<ThirdPartyResponse.AiFileUploadResult> response) {
                VidoRingFragment.this.aiFileUploadResult = response.body();
                return ObservableApiHelper.bindUploadedVideo(VidoRingFragment.this.aiFileUploadResult.commitToken, lowerCase);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(uri) {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$ewBvua325NQts_tVOXA9eapjfIE */
            private final /* synthetic */ Uri f$1;

            {
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                VidoRingFragment.this.lambda$uploadFile$6$VidoRingFragment(this.f$1, obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$VidoRingFragment$02zhFN_P1CTE4jQIv90knpKetMQ */

            public final void call(Object obj) {
                VidoRingFragment.this.lambda$uploadFile$7$VidoRingFragment((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$uploadFile$6$VidoRingFragment(Uri uri, Object obj) {
        new Object[1][0] = "upload response JsonElement=" + obj.toString();
        dismissProgressDialog();
        AlarmHelper.saveLastUploadVideo(this.aiFileUploadResult);
        replaceCustomRing(AlarmHelper.getVideoAlarmRing(this.aiFileUploadResult, uri));
    }

    public /* synthetic */ void lambda$uploadFile$7$VidoRingFragment(Throwable th) {
        dismissProgressDialog();
        ToastUtil.showToast((int) R.string.alarm_video_upload_fail);
        ahh.O000000o(th);
    }

    private void deleteLastUploadVideo() {
        AlarmHelper.saveLastUploadVideo(null);
        replaceCustomRing(null);
    }
}
