package com.xiaomi.smarthome.camera.view.timeline;

import _m_j.civ;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TimeLineControlViewCloud extends TimeLineControlView2 {
    public static final String TAG = "TimeLineControlViewCloud";
    private String lastEvent = "";

    public TimeLineControlViewCloud(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void handlerNotifyUpdate() {
        if (this.mTimeLineCallback != null) {
            this.mCurrentTime = System.currentTimeMillis() + this.mOffsetCurrentTime;
            if (Math.abs(this.mCurrentTime - getSelectTime()) < 15000) {
                setLivePlay();
                civ.O00000o(TAG, " selectTime near now ");
            } else if (this.treeMapDatas == null || this.treeMapDatas.isEmpty()) {
                updatePlayTime(System.currentTimeMillis());
                if (this.mTimeLineCallback != null) {
                    this.mTimeLineCallback.onCancel();
                }
            } else if (this.mTimeLineCallback != null) {
                this.mTimeLineCallback.onSelectTime(getSelectTime());
            }
            this.mIsPress = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void movePrev() {
        CloudVideoChildListData needItemForCloud;
        if (this.treeMapDatas != null && !this.treeMapDatas.isEmpty() && (needItemForCloud = getNeedItemForCloud(getSelectTime() - ((long) ((int) (30000.0f / this.mWidthScaleFators))), false)) != null) {
            setPlayTime(needItemForCloud.startTime);
        }
    }

    /* access modifiers changed from: package-private */
    public void movePressLast() {
        if (this.treeMapDatas != null && !this.treeMapDatas.isEmpty()) {
            long selectTime = getSelectTime() - ((long) ((int) (30000.0f / this.mWidthScaleFators)));
            for (Map.Entry value : this.treeMapDatas.entrySet()) {
                List list = (List) value.getValue();
                if (list != null && list.size() > 0 && ((CloudVideoChildListData) list.get(list.size() - 1)).startTime <= selectTime) {
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        }
                        CloudVideoChildListData cloudVideoChildListData = (CloudVideoChildListData) list.get(i);
                        if (selectTime <= cloudVideoChildListData.startTime) {
                            i++;
                        } else if (selectTime < cloudVideoChildListData.endTime) {
                            setPlayTime(selectTime);
                        } else {
                            setPlayTime(cloudVideoChildListData.endTime);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean moveNext() {
        if (this.treeMapDatas != null && !this.treeMapDatas.isEmpty()) {
            CloudVideoChildListData needItemForCloud = getNeedItemForCloud(getSelectTime() + ((long) ((int) (30000.0f / this.mWidthScaleFators))), true);
            if (needItemForCloud != null) {
                setPlayTime(needItemForCloud.startTime);
                return true;
            }
            setLivePlay();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void movePressNext() {
        if (isEnabled() && this.treeMapDatas != null && !this.treeMapDatas.isEmpty()) {
            long selectTime = getSelectTime() + ((long) ((int) (30000.0f / this.mWidthScaleFators)));
            Iterator<Long> descendingIterator = CloudTimeLineFragment.descendingIterator(this.treeMapDatas);
            while (descendingIterator.hasNext()) {
                List list = (List) this.treeMapDatas.get(Long.valueOf(descendingIterator.next().longValue()));
                if (list != null && list.size() > 0 && ((CloudVideoChildListData) list.get(0)).endTime >= selectTime) {
                    int size = list.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        CloudVideoChildListData cloudVideoChildListData = (CloudVideoChildListData) list.get(size);
                        if (selectTime >= cloudVideoChildListData.endTime) {
                            size--;
                        } else if (selectTime > cloudVideoChildListData.startTime) {
                            setPlayTime(selectTime);
                        } else {
                            setPlayTime(cloudVideoChildListData.startTime);
                        }
                    }
                }
            }
        }
    }

    public boolean isPlayRealTime() {
        long selectTime = getSelectTime();
        if (this.treeMapDatas == null || this.treeMapDatas.isEmpty()) {
            return false;
        }
        CloudVideoChildListData endItem = TimeLineUtils.getEndItem(this.treeMapDatas);
        return endItem == null || selectTime >= endItem.endTime;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012b, code lost:
        if (r9 < 120000) goto L_0x0127;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0160 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0166  */
    public void drawEventList(Canvas canvas, int i) {
        List list;
        int i2;
        boolean z;
        int i3;
        List list2;
        boolean z2;
        int i4;
        List list3;
        int i5;
        String str;
        char c;
        int i6;
        String[] strArr;
        int i7;
        int i8;
        Iterator it;
        this.lastDrawPos_Event = -20;
        this.lastStartPos_Event = -20;
        this.lastEndTime_Event = 0;
        if (this.treeMapDatas != null) {
            Iterator it2 = this.treeMapDatas.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                long longValue = ((Long) entry.getKey()).longValue();
                List list4 = (List) entry.getValue();
                if (!(list4 == null || list4.size() == 0)) {
                    int pos = i + getPos(((CloudVideoChildListData) list4.get(list4.size() - 1)).startTime);
                    int pos2 = getPos(((CloudVideoChildListData) list4.get(0)).endTime);
                    if (pos <= this.width && pos2 >= 0 && pos2 >= this.lastDrawPos) {
                        int size = list4.size() - 1;
                        while (size >= 0) {
                            CloudVideoChildListData cloudVideoChildListData = (CloudVideoChildListData) list4.get(size);
                            int pos3 = i + getPos(cloudVideoChildListData.startTime);
                            long j = cloudVideoChildListData.endTime;
                            if (this.mCurrentTime <= j) {
                                j = this.mCurrentTime;
                            }
                            long j2 = j;
                            int pos4 = getPos(j2);
                            if (pos3 > this.width || pos4 < 0 || pos4 < this.lastDrawPos) {
                                it = it2;
                            } else {
                                if (cloudVideoChildListData.startTime > this.lastEndTime && cloudVideoChildListData.startTime - this.lastEndTime < ((long) this.mLineLen)) {
                                    pos3 = getPos(this.lastEndTime);
                                }
                                if (pos3 < this.lastDrawPos) {
                                    pos3 = this.lastDrawPos;
                                }
                                it = it2;
                                drawNoEventBg(pos3, this.boundsTop, pos4, this.boundsBottom, canvas);
                                this.lastDrawPos = pos4;
                                this.lastEndTime = j2;
                            }
                            size--;
                            it2 = it;
                        }
                        Iterator it3 = it2;
                        if (this.treeMapEvents != null && !this.treeMapEvents.isEmpty() && (list = (List) this.treeMapEvents.get(Long.valueOf(longValue))) != null && list.size() > 0) {
                            int size2 = list4.size() - 1;
                            int size3 = list.size() - 1;
                            while (size3 >= 0) {
                                AlarmVideo alarmVideo = (AlarmVideo) list.get(size3);
                                long j3 = alarmVideo.createTime;
                                if (j3 >= this.lastStartTime_Event) {
                                    long j4 = j3 - this.lastStartTime_Event;
                                    i2 = size3;
                                    if (j4 < ((long) this.mLineLen)) {
                                        j3 = this.lastStartTime_Event;
                                    }
                                    z = true;
                                    int pos5 = i + getPos(j3);
                                    long j5 = 120000 + j3;
                                    i3 = size2;
                                    while (true) {
                                        if (i3 < 0) {
                                            CloudVideoChildListData cloudVideoChildListData2 = (CloudVideoChildListData) list4.get(i3);
                                            list2 = list;
                                            i8 = size2;
                                            if (j3 < cloudVideoChildListData2.startTime || j3 > cloudVideoChildListData2.endTime) {
                                                i3--;
                                                list = list2;
                                                size2 = i8;
                                            } else {
                                                if (j5 > cloudVideoChildListData2.endTime) {
                                                    j5 = cloudVideoChildListData2.endTime;
                                                }
                                                size2 = i3;
                                                z2 = true;
                                            }
                                        } else {
                                            list2 = list;
                                            z2 = false;
                                        }
                                    }
                                    if (!z2) {
                                        int i9 = size2;
                                        if (this.mCurrentTime <= j5) {
                                            j5 = this.mCurrentTime;
                                        }
                                        int pos6 = getPos(j5);
                                        if (pos5 > this.width || pos6 < 0 || pos6 < this.lastDrawPos_Event) {
                                            i5 = i9;
                                        } else {
                                            List list5 = list2;
                                            if (j3 > this.lastEndTime_Event && j3 - this.lastEndTime_Event < ((long) this.mLineLen)) {
                                                pos5 = this.lastDrawPos_Event;
                                            }
                                            String[] split = alarmVideo.eventType.split(":");
                                            AlarmVideoAdapter.sortByEventTypeForTimeLine(split);
                                            int length = split.length;
                                            String str2 = "";
                                            int i10 = pos5;
                                            int i11 = 0;
                                            boolean z3 = false;
                                            while (true) {
                                                if (i11 < length) {
                                                    list3 = list5;
                                                    String str3 = split[i11];
                                                    i4 = i9;
                                                    String str4 = str2 + str3;
                                                    switch (str3.hashCode()) {
                                                        case -1293551627:
                                                            if (str3.equals("ObjectMotion")) {
                                                                c = 5;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case -740191200:
                                                            if (str3.equals("KnownFace")) {
                                                                c = 3;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case 2088:
                                                            if (str3.equals("AI")) {
                                                                c = 0;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case 80127:
                                                            if (str3.equals("Pet")) {
                                                                c = 6;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case 2181757:
                                                            if (str3.equals("Face")) {
                                                                c = 2;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case 722651973:
                                                            if (str3.equals("PeopleMotion")) {
                                                                c = 4;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case 1316906260:
                                                            if (str3.equals("BabyCry")) {
                                                                c = 1;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        default:
                                                            c = 65535;
                                                            break;
                                                    }
                                                    switch (c) {
                                                        case 0:
                                                            strArr = split;
                                                            i6 = length;
                                                            str = str4;
                                                            Canvas canvas2 = canvas;
                                                            if (this.ai) {
                                                                i7 = rePositionStartPos(str3, z, i10);
                                                                this.mAIBg.setBounds(i7, this.boundsTop, pos6, this.boundsBottom);
                                                                this.mAIBg.draw(canvas2);
                                                                this.lastEvent = str3;
                                                                i10 = i7;
                                                                z3 = true;
                                                                break;
                                                            }
                                                            break;
                                                        case 1:
                                                            strArr = split;
                                                            i6 = length;
                                                            str = str4;
                                                            Canvas canvas3 = canvas;
                                                            if (this.babyCry) {
                                                                i7 = rePositionStartPos(str3, z, i10);
                                                                this.mBabyCryBg.setBounds(i7, this.boundsTop, pos6, this.boundsBottom);
                                                                this.mBabyCryBg.draw(canvas3);
                                                                this.lastEvent = str3;
                                                                i10 = i7;
                                                                z3 = true;
                                                                break;
                                                            }
                                                            break;
                                                        case 2:
                                                        case 3:
                                                            strArr = split;
                                                            i6 = length;
                                                            str = str4;
                                                            Canvas canvas4 = canvas;
                                                            if (this.face) {
                                                                i7 = rePositionStartPos(str3, z, i10);
                                                                this.mFaceBg.setBounds(i7, this.boundsTop, pos6, this.boundsBottom);
                                                                this.mFaceBg.draw(canvas4);
                                                                this.lastEvent = str3;
                                                                i10 = i7;
                                                                z3 = true;
                                                                break;
                                                            }
                                                            break;
                                                        case 4:
                                                            strArr = split;
                                                            i6 = length;
                                                            str = str4;
                                                            Canvas canvas5 = canvas;
                                                            if (this.peopleMove) {
                                                                i7 = rePositionStartPos(str3, z, i10);
                                                                this.mPeopleMoveBg.setBounds(i7, this.boundsTop, pos6, this.boundsBottom);
                                                                this.mPeopleMoveBg.draw(canvas5);
                                                                this.lastEvent = str3;
                                                                i10 = i7;
                                                                z3 = true;
                                                                break;
                                                            }
                                                            break;
                                                        case 5:
                                                            strArr = split;
                                                            i6 = length;
                                                            Canvas canvas6 = canvas;
                                                            if (this.areaMove) {
                                                                i7 = rePositionStartPos(str3, z, i10);
                                                                str = str4;
                                                                this.mAreaMoveBg.setBounds(i7, this.boundsTop, pos6, this.boundsBottom);
                                                                this.mAreaMoveBg.draw(canvas6);
                                                                this.lastEvent = str3;
                                                                i10 = i7;
                                                                z3 = true;
                                                                break;
                                                            }
                                                            str = str4;
                                                            break;
                                                        case 6:
                                                            if (!this.petMove) {
                                                                strArr = split;
                                                                i6 = length;
                                                                str = str4;
                                                                break;
                                                            } else {
                                                                int rePositionStartPos = rePositionStartPos(str3, z, i10);
                                                                strArr = split;
                                                                i6 = length;
                                                                this.mPetMoveBg.setBounds(rePositionStartPos, this.boundsTop, pos6, this.boundsBottom);
                                                                this.mPetMoveBg.draw(canvas);
                                                                this.lastEvent = str3;
                                                                i10 = rePositionStartPos;
                                                                str = str4;
                                                                z3 = true;
                                                                break;
                                                            }
                                                        default:
                                                            strArr = split;
                                                            i6 = length;
                                                            str = str4;
                                                            break;
                                                    }
                                                    if (!z3) {
                                                        i11++;
                                                        list5 = list3;
                                                        i9 = i4;
                                                        split = strArr;
                                                        length = i6;
                                                        str2 = str;
                                                    }
                                                } else {
                                                    list3 = list5;
                                                    i4 = i9;
                                                    str = str2;
                                                }
                                            }
                                            civ.O000000o(TAG, "eventStr=".concat(String.valueOf(str)));
                                            this.lastStartPos_Event = i10;
                                            this.lastDrawPos_Event = pos6;
                                            this.lastStartTime_Event = alarmVideo.createTime;
                                            this.lastEndTime_Event = j5;
                                            size3 = i2 - 1;
                                            list = list3;
                                            size2 = i4;
                                        }
                                    } else {
                                        i5 = size2;
                                    }
                                    list3 = list2;
                                    size3 = i2 - 1;
                                    list = list3;
                                    size2 = i4;
                                } else {
                                    i2 = size3;
                                }
                                z = false;
                                int pos52 = i + getPos(j3);
                                long j52 = 120000 + j3;
                                i3 = size2;
                                while (true) {
                                    if (i3 < 0) {
                                    }
                                    i3--;
                                    list = list2;
                                    size2 = i8;
                                }
                                if (!z2) {
                                }
                                list3 = list2;
                                size3 = i2 - 1;
                                list = list3;
                                size2 = i4;
                            }
                        }
                        it2 = it3;
                    }
                }
            }
        }
    }

    private int rePositionStartPos(String str, boolean z, int i) {
        return (z && AlarmVideoAdapter.getIntByTypeForTimeLine(str) < AlarmVideoAdapter.getIntByTypeForTimeLine(this.lastEvent)) ? this.lastDrawPos_Event : i;
    }

    /* access modifiers changed from: protected */
    public CloudVideoChildListData getNeedItemForCloud(long j, boolean z) {
        List list;
        CloudVideoChildListData cloudVideoChildListData = null;
        if (z) {
            for (Map.Entry value : this.treeMapDatas.entrySet()) {
                List list2 = (List) value.getValue();
                if (list2 != null && list2.size() > 0 && ((CloudVideoChildListData) list2.get(0)).endTime > j) {
                    int size = list2.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        CloudVideoChildListData cloudVideoChildListData2 = (CloudVideoChildListData) list2.get(size);
                        if (cloudVideoChildListData2.startTime > j) {
                            cloudVideoChildListData = cloudVideoChildListData2;
                            break;
                        }
                        size--;
                    }
                    if (cloudVideoChildListData != null) {
                        break;
                    }
                }
            }
            return cloudVideoChildListData;
        }
        Iterator<Long> descendingIterator = CloudTimeLineFragment.descendingIterator(this.treeMapDatas);
        while (descendingIterator.hasNext()) {
            long longValue = descendingIterator.next().longValue();
            if (longValue <= j && (list = (List) this.treeMapDatas.get(Long.valueOf(longValue))) != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    CloudVideoChildListData cloudVideoChildListData3 = (CloudVideoChildListData) list.get(i);
                    if (cloudVideoChildListData3.endTime < j) {
                        cloudVideoChildListData = cloudVideoChildListData3;
                        break;
                    }
                    i++;
                }
                if (cloudVideoChildListData != null) {
                    break;
                }
            }
        }
        return cloudVideoChildListData;
    }
}
