package com.tiqiaa.tv.entity;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bdk;
import _m_j.bdl;
import _m_j.boy;
import _m_j.bpa;
import com.imi.fastjson.parser.Feature;
import com.tiqiaa.common.IJsonable;
import com.tiqiaa.database.DataBaseManager;
import java.util.Date;
import java.util.List;

@bpa(O000000o = "tb_tvshow")
@bdl(O00000Oo = {"pp", "previews_json", "type", "cacheTime", "img"})
public class TvShow implements IJsonable {
    @bdk(O000000o = "brief_content")
    String brief_content;
    @bdk(O000000o = "cacheTime")
    Date cacheTime;
    @bdk(O000000o = "content")
    String content;
    @bdk(O000000o = "director")
    String director;
    @boy
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "img")
    TvShowImg img;
    @bdk(O000000o = "js")
    int js;
    @bdk(O000000o = "keywords")
    String keywords;
    @bdk(O000000o = "pp")
    String pp;
    @bdk(O000000o = "presenter")
    String presenter;
    @bdk(O000000o = "previews")
    List<TvShowPreview> previews;
    @bdk(O000000o = "previews_json")
    String previews_json;
    @bdk(O000000o = "title")
    String title;
    @bdk(O000000o = "type")
    int type;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getTitle() {
        if (this.title == null) {
            this.title = "";
        }
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getKeywords() {
        if (this.keywords == null) {
            this.keywords = "";
        }
        return this.keywords;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }

    public String getBrief_content() {
        if (this.brief_content == null) {
            this.brief_content = "";
        }
        return this.brief_content;
    }

    public void setBrief_content(String str) {
        this.brief_content = str;
    }

    public String getContent() {
        if (this.content == null) {
            this.content = "";
        }
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getDirector() {
        if (this.director == null) {
            this.director = "";
        }
        return this.director;
    }

    public void setDirector(String str) {
        this.director = str;
    }

    public String getPresenter() {
        if (this.presenter == null) {
            this.presenter = "";
        }
        return this.presenter;
    }

    public void setPresenter(String str) {
        this.presenter = str;
    }

    public int getJs() {
        return this.js;
    }

    public void setJs(int i) {
        this.js = i;
    }

    public List<TvShowPreview> getPreviews() {
        String str;
        if (this.previews == null && (str = this.previews_json) != null) {
            try {
                this.previews = (List) bdf.O000000o(str, new bdi<List<TvShowPreview>>() {
                    /* class com.tiqiaa.tv.entity.TvShow.AnonymousClass1 */
                }, new Feature[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.previews;
    }

    public void setPreviews(List<TvShowPreview> list) {
        this.previews = list;
    }

    public String getPreviews_json() {
        return this.previews_json;
    }

    public void setPreviews_json(String str) {
        this.previews_json = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public Date getCacheTime() {
        return this.cacheTime;
    }

    public void setCacheTime(Date date) {
        this.cacheTime = date;
    }

    public String getPp() {
        return this.pp;
    }

    public void setPp(String str) {
        this.pp = str;
    }

    public TvShowImg getImg() {
        if (this.img == null) {
            this.img = DataBaseManager.getInstance().getTvShowImgByshowId(getId());
        }
        return this.img;
    }

    public void setImg(TvShowImg tvShowImg) {
        this.img = tvShowImg;
    }
}
