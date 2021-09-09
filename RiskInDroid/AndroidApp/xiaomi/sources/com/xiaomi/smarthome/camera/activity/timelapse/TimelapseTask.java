package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.cid;
import _m_j.civ;
import _m_j.dvp;
import _m_j.me;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TimelapseTask {
    private static final String TAG = AlbumActivity.class.getSimpleName();
    private String cameraMac;
    private int creatStatus;
    private int endTimestampInSeconds;
    private int fileStatus;
    private int intervalToTakePicture;
    public boolean isCreator;
    private cid mCameraDevice;
    private String mDid;
    public File picFolder;
    public File rootFolder;
    private int startTimestampInSeconds;
    public long startTimestampInUTCSeconds;
    public int status;
    private int taskID;
    private String taskName;
    private int timelapseSaveType;
    private int timezoneInMunites;
    public File videoFolder;
    private int videoType;

    public TimelapseTask(cid cid, long j, long j2, long j3, int i, int i2) {
        this.cameraMac = "";
        this.taskName = "";
        this.isCreator = true;
        this.creatStatus = 0;
        this.status = 0;
        this.timelapseSaveType = 1;
        this.fileStatus = 1;
        this.videoType = 3;
        this.mCameraDevice = cid;
        this.mDid = cid.getDid();
        this.cameraMac = shortMac(cid.getMac());
        setTaskID(j);
        setTaskName(String.valueOf(j));
        setStartTimestampInSeconds(j2);
        setEndTimestampInSeconds(j3);
        setIntervalToTakePicture(i);
        setTimezoneInMinutes(i2);
    }

    public TimelapseTask(String str, long j) {
        this.cameraMac = "";
        this.taskName = "";
        this.isCreator = true;
        this.creatStatus = 0;
        this.status = 0;
        this.timelapseSaveType = 1;
        this.fileStatus = 1;
        this.videoType = 3;
        this.timelapseSaveType = 0;
        setTaskID(j);
        setTaskName(str);
    }

    public TimelapseTask(int i, int i2, long j) {
        this.cameraMac = "";
        this.taskName = "";
        this.isCreator = true;
        this.creatStatus = 0;
        this.status = 0;
        this.timelapseSaveType = 1;
        this.fileStatus = 1;
        this.videoType = 3;
        this.videoType = i;
        this.startTimestampInSeconds = i2;
        this.startTimestampInUTCSeconds = j;
    }

    public TimelapseTask(int i, int i2) {
        this.cameraMac = "";
        this.taskName = "";
        this.isCreator = true;
        this.creatStatus = 0;
        this.status = 0;
        this.timelapseSaveType = 1;
        this.fileStatus = 1;
        this.videoType = 3;
        this.videoType = i;
        this.startTimestampInSeconds = i2;
    }

    public int getTimelapseSaveType() {
        return this.timelapseSaveType;
    }

    public void setTimelapseSaveType(int i) {
        this.timelapseSaveType = i;
    }

    public void setStartTimestampInSeconds(long j) {
        if (j < 2147483647L) {
            this.startTimestampInSeconds = (int) j;
        } else {
            this.startTimestampInSeconds = (int) (j / 1000);
        }
        civ.O000000o(TAG, "setStartTimestampInSeconds startTimestampInSeconds=".concat(String.valueOf(j)));
    }

    public int getStartTimestampInSeconds() {
        return this.startTimestampInSeconds;
    }

    public long getRealStartTimeInSec() {
        return getStartTimestampInUTCSeconds() + ((long) (this.timezoneInMunites * 60));
    }

    public void setEndTimestampInSeconds(long j) {
        if (j < 2147483647L) {
            this.endTimestampInSeconds = (int) j;
        } else {
            this.endTimestampInSeconds = (int) (j / 1000);
        }
    }

    public int getEndTimestampInSeconds() {
        return this.endTimestampInSeconds;
    }

    public void setTimezoneInMinutes(int i) {
        this.timezoneInMunites = i;
    }

    public int getTimezoneInMinutes() {
        return this.timezoneInMunites;
    }

    public void setTaskName(String str) {
        if (str == null || str.equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.taskID);
            str = sb.toString();
        } else if (str.length() > 10) {
            str = str.substring(0, 10);
        }
        this.taskName = str;
    }

    public String getTaskName() {
        String str = this.taskName;
        if (str == null || str.equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.taskID);
            this.taskName = sb.toString();
        }
        return this.taskName;
    }

    public void setTaskID(long j) {
        if (j > 9999999999L) {
            this.taskID = (int) (j / 1000);
        } else {
            this.taskID = (int) j;
        }
    }

    public int getTaskID() {
        return this.taskID;
    }

    private String shortMac(String str) {
        String str2 = "";
        if (str != null) {
            str2 = str.replaceAll(":", str2);
        }
        return str2.length() > 3 ? str2.substring(str2.length() - 3) : str2;
    }

    public String getCameraMac() {
        return this.cameraMac;
    }

    public void setIntervalToTakePicture(int i) {
        if (i <= 0 || i > 86400) {
            this.intervalToTakePicture = 1;
        } else {
            this.intervalToTakePicture = i;
        }
    }

    public int getIntervalToTakePicture() {
        return this.intervalToTakePicture;
    }

    public byte[] toProtocolByteArray() {
        byte[] bArr = new byte[20];
        dvp.O000000o(bArr, 0, dvp.O000000o(this.taskID), 3);
        dvp.O000000o(bArr, 4, dvp.O000000o(this.startTimestampInSeconds), 3);
        dvp.O000000o(bArr, 8, dvp.O000000o(this.endTimestampInSeconds), 3);
        dvp.O000000o(bArr, 12, dvp.O000000o(this.intervalToTakePicture), 3);
        dvp.O000000o(bArr, 16, dvp.O000000o(this.timezoneInMunites), 3);
        return bArr;
    }

    public static byte[] getEmpty() {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 20; i++) {
            bArr[i] = 0;
        }
        return bArr;
    }

    public long getStartTimestampInUTCSeconds() {
        return (long) (this.startTimestampInSeconds - (this.timezoneInMunites * 60));
    }

    public long getEndTimestampInUTCSeconds() {
        return (long) (this.endTimestampInSeconds - (this.timezoneInMunites * 60));
    }

    public int readLogFile(cid cid) throws IOException {
        this.mDid = cid.getDid();
        this.mCameraDevice = cid;
        String str = TAG;
        civ.O000000o(str, "==========getCurrentTaskFilePath=========" + me.O000000o(this.mDid, this.taskID, this.taskName));
        File file = new File(me.O000000o(this.mDid, this.taskID, this.taskName) + "log.txt");
        if (!file.exists()) {
            civ.O000000o(TAG, "readLogFile log file dose not exsit");
            return -1;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[fileInputStream.available()];
        fileInputStream.read(bArr);
        String str2 = new String(bArr, "UTF-8");
        civ.O000000o(TAG, "readLogFile log file res= ".concat(str2));
        String[] strArr = null;
        try {
            strArr = str2.split("_");
            String str3 = TAG;
            civ.O000000o(str3, "result ==" + strArr.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (strArr != null && strArr.length == 5) {
            this.startTimestampInSeconds = Integer.valueOf(strArr[0]).intValue();
            this.endTimestampInSeconds = Integer.valueOf(strArr[1]).intValue();
            this.intervalToTakePicture = Integer.valueOf(strArr[2]).intValue();
            this.timezoneInMunites = Integer.valueOf(strArr[3]).intValue();
            this.isCreator = strArr[4].equals("1");
        } else if (strArr != null && strArr.length == 4) {
            this.startTimestampInSeconds = Integer.valueOf(strArr[0]).intValue();
            this.endTimestampInSeconds = Integer.valueOf(strArr[1]).intValue();
            this.intervalToTakePicture = Integer.valueOf(strArr[2]).intValue();
            this.timezoneInMunites = Integer.valueOf(strArr[3]).intValue();
            this.isCreator = true;
        } else if (strArr != null && strArr.length == 6) {
            String str4 = TAG;
            civ.O000000o(str4, "readLogFile log file broken, length= " + strArr.length);
            this.startTimestampInSeconds = Integer.valueOf(strArr[0]).intValue();
            this.endTimestampInSeconds = Integer.valueOf(strArr[1]).intValue();
            this.intervalToTakePicture = Integer.valueOf(strArr[2]).intValue();
            this.timezoneInMunites = Integer.valueOf(strArr[4]).intValue();
            this.isCreator = strArr[5].equals("1");
        }
        fileInputStream.close();
        return 0;
    }

    public void writeLogFile(boolean z) throws IOException {
        File file = new File(me.O000000o(this.mDid, this.taskID, this.taskName) + "log.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        String str = TAG;
        civ.O000000o(str, "writeLogFile file path=" + file.getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        StringBuilder sb = new StringBuilder();
        sb.append(this.startTimestampInSeconds);
        sb.append("_");
        sb.append(this.endTimestampInSeconds);
        sb.append("_");
        sb.append(this.intervalToTakePicture);
        sb.append("_");
        sb.append(this.timezoneInMunites);
        sb.append("_");
        sb.append(z ? "1" : "0");
        String sb2 = sb.toString();
        civ.O000000o(TAG, "writeLogFile ".concat(String.valueOf(sb2)));
        fileOutputStream.write(sb2.getBytes());
        fileOutputStream.close();
    }

    public void reWriteEndtime(long j) throws IOException {
        civ.O000000o(TAG, "reWriteEndtime=" + j + "  getCurrentTaskFilePath()=" + me.O000000o(this.mDid, this.taskID, this.taskName));
        StringBuilder sb = new StringBuilder();
        sb.append(me.O000000o(this.mDid, this.taskID, this.taskName));
        sb.append("log.txt");
        File file = new File(sb.toString());
        long j2 = j + ((long) (this.timezoneInMunites * 60));
        if (!file.exists()) {
            file.createNewFile();
        }
        civ.O000000o(TAG, "writeLogFile file path=" + file.getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String str = String.valueOf(this.startTimestampInSeconds) + "_" + String.valueOf(j2) + "_" + String.valueOf(this.intervalToTakePicture) + "_" + String.valueOf(this.timezoneInMunites) + "_1";
        civ.O000000o(TAG, "writeLogFile ".concat(String.valueOf(str)));
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }

    public void createLocalFolder(boolean z, boolean z2, cid cid) {
        this.mCameraDevice = cid;
        this.mDid = cid.getDid();
        if (TextUtils.isEmpty(this.taskName)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.taskID);
            setTaskName(sb.toString());
        }
        String str = TAG;
        civ.O000000o(str, "createLocalFolder ==taskID =" + this.taskID + ",taskName=" + this.taskName + "mDid,=" + this.mDid);
        String O000000o2 = me.O000000o(this.mDid, this.taskID, this.taskName);
        civ.O000000o(TAG, "createLocalFolder filePath=".concat(String.valueOf(O000000o2)));
        if (!"".equals(O000000o2)) {
            try {
                this.rootFolder = new File(O000000o2);
                if (!this.rootFolder.exists()) {
                    this.rootFolder.mkdirs();
                }
                this.picFolder = new File(this.rootFolder.getPath() + "/pic/");
                if (!this.picFolder.exists()) {
                    this.picFolder.mkdirs();
                }
                this.videoFolder = new File(this.rootFolder.getPath() + "/video/");
                if (!this.videoFolder.exists()) {
                    this.videoFolder.mkdirs();
                }
                if (z) {
                    writeLogFile(z2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String str2 = TAG;
                civ.O000000o(str2, "createLocalData exception: " + e.getMessage());
            }
        }
    }

    public void refreshState() {
        int i = 0;
        if (getStartTimestampInUTCSeconds() > System.currentTimeMillis() / 1000) {
            this.status = 0;
        } else if (getEndTimestampInUTCSeconds() > System.currentTimeMillis() / 1000) {
            this.status = 1;
        } else if (getStartTimestampInUTCSeconds() == 0 || getEndTimestampInUTCSeconds() == 0) {
            this.status = 0;
        } else {
            this.status = 2;
            String str = TAG;
            civ.O000000o(str, "FileUtil.generateTimeLapseFilepath(mDid,taskID,taskName) + \"video/\")=" + me.O000000o(this.mDid, this.taskID, this.taskName) + "video/");
            File[] listFiles = new File(me.O000000o(this.mDid, this.taskID, this.taskName) + "video/").listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File file = listFiles[i];
                    String str2 = TAG;
                    civ.O000000o(str2, "refreshState videoFile ==" + file.getAbsolutePath());
                    String str3 = TAG;
                    civ.O000000o(str3, "refreshState videoFile.getName() ==" + file.getName());
                    if (!file.getName().endsWith("mp4") || (!file.getName().startsWith("A_") && !file.getName().startsWith("Time_"))) {
                        i++;
                    }
                }
                this.status = 3;
                civ.O00000Oo(TAG, "found mp4 file");
            }
        }
        String str4 = TAG;
        civ.O000000o(str4, "refreshState status = " + this.status);
    }

    public String getVideoPath(cid cid) {
        civ.O000000o(TAG, "getVideoPath");
        this.mCameraDevice = cid;
        this.mDid = cid.getDid();
        return me.O000000o(cid.getDid(), this.taskID, this.taskName) + "video/";
    }

    public File getVideoFile(String str) {
        this.rootFolder = new File(me.O000000o(this.mDid, this.taskID, this.taskName));
        civ.O000000o(TAG, "rootFolder=" + this.rootFolder.getPath());
        if (!this.rootFolder.exists()) {
            this.rootFolder.mkdirs();
        }
        File file = this.videoFolder;
        if (file == null || !file.exists()) {
            this.videoFolder = new File(this.rootFolder.getPath() + "/video/");
            if (!this.videoFolder.exists()) {
                this.videoFolder.mkdirs();
            }
        }
        File[] listFiles = this.videoFolder.listFiles();
        File file2 = null;
        if (!(listFiles == null || listFiles.length == 0)) {
            if (listFiles.length != 1) {
                for (File file3 : listFiles) {
                    if (file3.getName().endsWith(str) && (file2 == null || file3.lastModified() > file2.lastModified())) {
                        file2 = file3;
                    }
                }
                civ.O000000o(TAG, "videofile=".concat(String.valueOf(file2)) != null ? file2.getPath() : "null");
            } else if (listFiles[0].getName().endsWith(str)) {
                return listFiles[0];
            } else {
                return null;
            }
        }
        return file2;
    }

    public String getLatestPicPath() {
        this.rootFolder = new File(me.O000000o(this.mDid, this.taskID, this.taskName));
        if (!this.rootFolder.exists()) {
            this.rootFolder.mkdirs();
        }
        File file = this.picFolder;
        if (file == null || !file.exists()) {
            this.picFolder = new File(this.rootFolder.getPath() + "/pic/");
            if (!this.picFolder.exists()) {
                this.picFolder.mkdirs();
            }
        }
        File[] listFiles = this.picFolder.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return "";
        }
        if (listFiles.length == 1) {
            return me.O000000o(this.mDid, this.taskID, this.taskName) + "pic/" + listFiles[0].getName();
        }
        File file2 = listFiles[0];
        for (File file3 : listFiles) {
            if (file3.lastModified() > file2.lastModified()) {
                file2 = file3;
            }
        }
        return file2.getPath();
    }

    public static TimelapseTask getFromProtocol(cid cid, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null || bArr2.length < 20) {
            civ.O000000o(TimeLapsePhotographyActivity.TAG, "走了......1");
            return new TimelapseTask(cid, 0, 0, 0, 0, 0);
        }
        int O00000Oo = dvp.O00000Oo(bArr2, 0);
        if (O00000Oo == 0) {
            civ.O000000o(TimeLapsePhotographyActivity.TAG, "走了......2");
            return new TimelapseTask(cid, 0, 0, 0, 0, 0);
        }
        int O00000Oo2 = dvp.O00000Oo(bArr2, 4);
        int O00000Oo3 = dvp.O00000Oo(bArr2, 8);
        int O00000Oo4 = dvp.O00000Oo(bArr2, 12);
        int O00000Oo5 = dvp.O00000Oo(bArr2, 16);
        civ.O000000o(TimeLapsePhotographyActivity.TAG, "getFromProtocol taskID " + O00000Oo + ",startTime=" + O00000Oo2 + ",endTime=" + O00000Oo3 + ",intervale=" + O00000Oo4 + ".timezoneInMinute=" + O00000Oo5);
        return new TimelapseTask(cid, (long) O00000Oo, (long) O00000Oo2, (long) O00000Oo3, O00000Oo4, O00000Oo5);
    }

    public TimelapseTask(int i, int i2, int i3, int i4) {
        this.cameraMac = "";
        this.taskName = "";
        this.isCreator = true;
        this.creatStatus = 0;
        this.status = 0;
        this.timelapseSaveType = 1;
        this.fileStatus = 1;
        this.videoType = 3;
        this.startTimestampInSeconds = i;
        this.taskID = this.startTimestampInSeconds;
        String str = TAG;
        civ.O000000o(str, "TimelapseTask: taskID=" + this.taskID);
        civ.O000000o(TAG, "TimelapseTask: status=".concat(String.valueOf(i2)));
        this.timezoneInMunites = i4;
        if (i2 == 1) {
            this.status = 0;
            this.endTimestampInSeconds = (int) ((System.currentTimeMillis() / 1000) + ((long) (i4 * 60)) + 86400);
        } else if (i2 == 2) {
            this.status = 1;
            this.endTimestampInSeconds = (int) ((System.currentTimeMillis() / 1000) + ((long) (i4 * 60)) + 86400);
        } else if (i2 != 3) {
            this.status = 0;
        } else {
            this.status = 2;
            this.endTimestampInSeconds = (int) (((System.currentTimeMillis() / 1000) + ((long) (i4 * 60))) - 3600);
        }
        this.fileStatus = i3;
    }

    public void setFileStatus(int i) {
        this.fileStatus = i;
    }

    public int getFileStatus() {
        return this.fileStatus;
    }

    public int getVideoType() {
        return this.videoType;
    }

    public void deleteLocalData(File file) {
        if (file == null) {
            file = this.rootFolder;
        }
        if (file == null || !file.exists()) {
            civ.O000000o(TAG, " deleteLocalData aimed folder not exist");
            return;
        }
        civ.O00000Oo(TAG, " deleteLocalData start folder:" + file.getPath());
        if (file.isDirectory()) {
            civ.O00000Oo(TAG, " deleteLocalData is directory");
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                civ.O00000Oo(TAG, " deleteLocalData delete empty directory: " + file.getPath());
                file.delete();
                return;
            }
            for (File deleteLocalData : listFiles) {
                deleteLocalData(deleteLocalData);
            }
            civ.O00000Oo(TAG, " deleteLocalData delete directory: " + file.getPath());
            file.delete();
            return;
        }
        civ.O00000Oo(TAG, " deleteLocalData is file");
        civ.O00000Oo(TAG, " deleteLocalData delete file: " + file.getPath());
        file.delete();
    }

    public void deleLocalDataNew(File file) {
        if (file == null) {
            file = this.rootFolder;
        }
        if (file == null || !file.exists()) {
            civ.O000000o(TAG, " deleLocalDataNew aimed folder not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    civ.O000000o(TAG, "deleLocalDataNew file= " + file2.getAbsolutePath());
                    if (file2.isDirectory()) {
                        deleLocalDataNew(file2);
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } else {
            file.delete();
        }
    }
}
