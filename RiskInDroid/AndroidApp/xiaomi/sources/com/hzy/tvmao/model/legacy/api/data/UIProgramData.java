package com.hzy.tvmao.model.legacy.api.data;

import com.kookong.app.data.ProgramData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UIProgramData implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<CatItemData> mCatItemDatas = new ArrayList<>();
    private Date mRefreshTime;

    public UIProgramData(Date date) {
        this.mRefreshTime = date;
    }

    public Date getRefreshTime() {
        return this.mRefreshTime;
    }

    public void setRefreshTime(Date date) {
        this.mRefreshTime = date;
    }

    public ArrayList<CatItemData> getCatItemDatas() {
        return this.mCatItemDatas;
    }

    public void setCatItemDatas(ArrayList<CatItemData> arrayList) {
        this.mCatItemDatas = arrayList;
    }

    public static class CatItemData implements Serializable {
        private static final long serialVersionUID = 1;
        private String catTitle;
        private ArrayList<ProgramItem> programItemLists = new ArrayList<>();
        private HashMap<String, ProgramItem> programItemsMap = new HashMap<>();
        private ArrayList<ProgramData.PairProgram> singleDataList = new ArrayList<>();

        public CatItemData(String str) {
            this.catTitle = str;
        }

        public String getCatTitle() {
            return this.catTitle;
        }

        public List<ProgramItem> getProgramItemLists() {
            return this.programItemLists;
        }

        public List<ProgramData.PairProgram> getSingleDataList() {
            return this.singleDataList;
        }

        public void addProgramItem(String str, ProgramData.PairProgram pairProgram) {
            if (!this.programItemsMap.containsKey(str)) {
                ProgramItem programItem = new ProgramItem();
                programItem.getSingleDataList().add(pairProgram);
                this.programItemLists.add(programItem);
                this.programItemsMap.put(str, programItem);
                return;
            }
            this.programItemsMap.get(str).getSingleDataList().add(pairProgram);
        }
    }

    public static class ProgramItem implements Serializable {
        private static final long serialVersionUID = 1;
        private ArrayList<ProgramData.PairProgram> singleDataList = new ArrayList<>();

        public List<ProgramData.PairProgram> getSingleDataList() {
            return this.singleDataList;
        }

        public ProgramData.PairProgram getFirstItem() {
            if (this.singleDataList.size() > 0) {
                return this.singleDataList.get(0);
            }
            return new ProgramData.PairProgram();
        }

        public boolean isMultipleProgram() {
            return this.singleDataList.size() > 1;
        }
    }
}
