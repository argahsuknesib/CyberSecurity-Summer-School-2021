package _m_j;

import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

public final class ihu {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f1306O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public long O00000oO;
    public boolean O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public int O0000Oo;
    public String O0000Oo0;
    private LoadingDialog.Speed O0000OoO;

    public ihu() {
        this.f1306O000000o = true;
        this.O0000OoO = LoadingDialog.Speed.SPEED_TWO;
        this.O00000o0 = -1;
        this.O00000o = -1;
        this.O00000oO = -1;
        this.O00000oo = true;
        this.O0000O0o = "加载中...";
        this.O0000OOo = "加载成功";
        this.O0000Oo0 = "加载失败";
        this.O0000Oo = 0;
    }

    public ihu(LoadingDialog.Speed speed, String str, String str2, String str3) {
        this.f1306O000000o = true;
        this.O0000OoO = LoadingDialog.Speed.SPEED_TWO;
        this.O00000o0 = -1;
        this.O00000o = -1;
        this.O00000oO = -1;
        this.O00000oo = true;
        this.O0000O0o = "加载中...";
        this.O0000OOo = "加载成功";
        this.O0000Oo0 = "加载失败";
        this.O0000Oo = 0;
        this.f1306O000000o = true;
        this.O00000Oo = 0;
        this.O0000OoO = speed;
        this.O00000o0 = -1;
        this.O00000o = -1;
        this.O00000oO = 1000;
        this.O00000oo = true;
        this.O0000O0o = str;
        this.O0000OOo = str2;
        this.O0000Oo0 = str3;
    }
}
