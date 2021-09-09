package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.chq;
import _m_j.cid;
import _m_j.civ;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Timelapse {
    public static ArrayList<TimelapseTask> timeLapseList = new ArrayList<>();
    private cid mCameraDevice;

    private static void addToList(TimelapseTask timelapseTask) {
        civ.O000000o("AlbumActivity", "addToList  tlt =" + timelapseTask.getStartTimestampInSeconds());
        civ.O000000o("AlbumActivity", "addToList  tlt =" + timelapseTask.getEndTimestampInSeconds());
        civ.O000000o("AlbumActivity", "addToList  tlt =" + timelapseTask.status);
        civ.O000000o("AlbumActivity", "");
        if (timelapseTask == null) {
            civ.O000000o("AlbumActivity", "tlt==null");
            return;
        }
        if (timeLapseList == null) {
            civ.O000000o("AlbumActivity", "timeLapseList==null");
            timeLapseList = new ArrayList<>();
        }
        boolean z = false;
        Iterator<TimelapseTask> it = timeLapseList.iterator();
        while (it.hasNext()) {
            TimelapseTask next = it.next();
            if (next.getTaskID() == timelapseTask.getTaskID()) {
                z = true;
                next.setEndTimestampInSeconds((long) timelapseTask.getEndTimestampInSeconds());
                next.refreshState();
            }
        }
        civ.O000000o("AlbumActivity", "addToList ==".concat(String.valueOf(z)));
        if (!z) {
            civ.O000000o("AlbumActivity", "add:" + timelapseTask.getTaskName());
            timeLapseList.add(timelapseTask);
        }
    }

    public static void getSavedTimeLapseData(cid cid) throws IOException {
        String str = chq.O0000OOo + File.separator;
        if (TextUtils.isEmpty(str)) {
            str = null;
        } else {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File[] listFiles = file2.listFiles();
        civ.O000000o("AlbumActivity", "getLocalTimeLapseData");
        if (listFiles != null) {
            for (File file3 : listFiles) {
                civ.O000000o("AlbumActivity", "cameraFolder getPath =" + file3.getPath());
                civ.O000000o("AlbumActivity", "cameraFolder getName =" + file3.getName());
                if (cid.getDid().equals(file3.getName())) {
                    civ.O000000o("AlbumActivity", "cameraFolder current Camera did =");
                    getTimelapseFromLocolFolder(file3, cid);
                    return;
                }
            }
        }
    }

    private static void getTimelapseFromLocolFolder(File file, cid cid) {
        for (File file2 : file.listFiles()) {
            civ.O000000o("AlbumActivity", "file getTimelapseFromLocolFolder=" + file2.getAbsolutePath());
            String name = file2.getName();
            civ.O000000o("AlbumActivity", "fileName= ".concat(String.valueOf(name)));
            if (!file2.isFile()) {
                try {
                    civ.O000000o("AlbumActivity", "fileName.split(\"_\")[1]=" + name.split("_")[1] + ",Long.valueOf(fileName.split(\"_\")[0])=" + Long.valueOf(name.split("_")[0]));
                    TimelapseTask timelapseTask = new TimelapseTask(name.split("_")[1], Long.valueOf(name.split("_")[0]).longValue());
                    if (timelapseTask.readLogFile(cid) == -1) {
                        civ.O000000o("AlbumActivity", "log文件不存在或读写错误, ".concat(String.valueOf(name)));
                    } else {
                        timelapseTask.refreshState();
                        civ.O000000o("AlbumActivity", "status = " + timelapseTask.status);
                        if (timelapseTask.status == 3) {
                            addToList(timelapseTask);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    civ.O000000o("AlbumActivity", "getTimelapseFromCameraFolder exception: " + e.getMessage());
                }
            }
        }
    }

    public static TimelapseTask getTimeLapseFromList(long j) {
        Iterator<TimelapseTask> it = timeLapseList.iterator();
        while (it.hasNext()) {
            TimelapseTask next = it.next();
            if (((long) (next.getStartTimestampInSeconds() - (next.getTimezoneInMinutes() * 60))) == j) {
                return next;
            }
        }
        return null;
    }
}
