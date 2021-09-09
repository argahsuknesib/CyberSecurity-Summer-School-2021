package com.xiaomi.smarthome.camera.activity.local;

import _m_j.cid;
import _m_j.civ;
import _m_j.clj;
import _m_j.gsy;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.activity.timelapse.TimelapseTask;
import java.io.File;

public class LocalFileData {
    public static int timelapseSaveType = 1;
    public String displayImgPath = "";
    public String durationInStr = "";
    public long endTimeInSec = -1;
    public String imgPath = "";
    protected boolean isCloudMp4File = false;
    public clj.O000000o item;
    public long realStartTimeInSec;
    public int recordStatus = 0;
    public long startTimeInSec = -1;
    public String subTitle;
    private int timezoneInMunites;
    public String title;
    public File videoFile = null;
    public String videoPath = "";
    public int videoType = 0;

    public void copyTimeLapse(TimelapseTask timelapseTask, cid cid) {
        File file;
        if (timelapseTask != null) {
            this.startTimeInSec = timelapseTask.getStartTimestampInUTCSeconds();
            this.endTimeInSec = timelapseTask.getEndTimestampInUTCSeconds();
            this.videoType = 3;
            this.recordStatus = timelapseTask.status;
            this.videoFile = timelapseTask.getVideoFile("mp4");
            this.imgPath = timelapseTask.getLatestPicPath();
            if (this.recordStatus == 3 && (file = this.videoFile) != null) {
                this.durationInStr = getLocalVideoDurationInStr(file.getPath(), "00:01");
            }
            this.displayImgPath = Uri.fromFile(new File(timelapseTask.getLatestPicPath())).toString();
            this.timezoneInMunites = timelapseTask.getTimezoneInMinutes();
            this.realStartTimeInSec = this.startTimeInSec + ((long) (this.timezoneInMunites * 60));
            this.videoPath = timelapseTask.getVideoPath(cid);
            civ.O000000o("AlbumActivity", "copyTimeLapse duration=" + this.durationInStr);
            gsy.O00000Oo("AlbumActivity", "copyTimeLapse: tt.taskID=" + timelapseTask.getTaskID());
            gsy.O00000Oo("AlbumActivity", "copyTimeLapse: imgPath=" + this.imgPath);
            gsy.O00000Oo("AlbumActivity", "copyTimeLapse: recordStatus=" + this.recordStatus);
        }
    }

    public LocalFileData() {
    }

    public LocalFileData(TimelapseTask timelapseTask, cid cid) {
        File file;
        if (timelapseTask != null) {
            this.startTimeInSec = timelapseTask.getStartTimestampInUTCSeconds();
            this.endTimeInSec = timelapseTask.getEndTimestampInUTCSeconds();
            this.videoType = 3;
            this.recordStatus = timelapseTask.status;
            this.videoFile = timelapseTask.getVideoFile("mp4");
            this.imgPath = timelapseTask.getLatestPicPath();
            this.displayImgPath = Uri.fromFile(new File(timelapseTask.getLatestPicPath())).toString();
            if (this.recordStatus == 3 && (file = this.videoFile) != null) {
                this.durationInStr = getLocalVideoDurationInStr(file.getPath(), "00:01");
            }
            this.timezoneInMunites = timelapseTask.getTimezoneInMinutes();
            this.realStartTimeInSec = this.startTimeInSec + ((long) (this.timezoneInMunites * 60));
            this.videoPath = timelapseTask.getVideoPath(cid);
            gsy.O00000Oo("AlbumActivity", "RecordItem TimelapseTask duration=" + this.durationInStr + "=====tt.status====" + timelapseTask.status);
            StringBuilder sb = new StringBuilder("RecordItem: tt-taskID=");
            sb.append(timelapseTask.getTaskID());
            gsy.O00000Oo("AlbumActivity", sb.toString());
            gsy.O00000Oo("AlbumActivity", "RecordItem: displayImgPath=" + this.displayImgPath);
            gsy.O00000Oo("AlbumActivity", "RecordItem: videoFile=" + this.videoFile);
            gsy.O00000Oo("AlbumActivity", "RecordItem: startTimeInSec=" + this.startTimeInSec);
            gsy.O00000Oo("AlbumActivity", "RecordItem: timezoneInMunites=" + this.timezoneInMunites);
            gsy.O00000Oo("AlbumActivity", "RecordItem: realStartTimeInSec=" + this.realStartTimeInSec);
            gsy.O00000Oo("AlbumActivity", "RecordItem: videoPath=" + this.videoPath);
            gsy.O00000Oo("AlbumActivity", "RecordItem: recordStatus=" + this.recordStatus);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    public String getLocalVideoDurationInStr(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "00:00";
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            str3 = mediaMetadataRetriever.extractMetadata(9);
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            str3 = "0";
            e.printStackTrace();
            if (!TextUtils.isEmpty(str3)) {
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            return str2;
        }
        int parseLong = (int) (Long.parseLong(str3) / 1000);
        int i = parseLong / 60;
        int i2 = (parseLong - (i * 60)) % 60;
        String valueOf = i >= 10 ? String.valueOf(i) : "0".concat(String.valueOf(i));
        String valueOf2 = i2 >= 10 ? String.valueOf(i2) : "0".concat(String.valueOf(i2));
        return valueOf + ":" + valueOf2;
    }

    public long getStartTimeInSec() {
        return this.startTimeInSec;
    }

    public int getVideoType() {
        return this.videoType;
    }

    public void setVideoType(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.videoType = i;
    }
}
