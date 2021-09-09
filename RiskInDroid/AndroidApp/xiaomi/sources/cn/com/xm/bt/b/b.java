package cn.com.xm.bt.b;

import java.io.Serializable;

public enum b implements Serializable {
    VDEVICE(c.VDevice, -1),
    MILI(c.MILI, 0),
    MILI_1A(c.MILI, 5),
    MILI_1S(c.MILI, 4),
    WEIGHT(c.WEIGHT, 1),
    WEIGHT_BODYFAT(c.WEIGHT, 101),
    SENSORHUB(c.SENSORHUB, 2),
    SHOES(c.SHOES, 3),
    SHOES_CHILD(c.SHOES, 304),
    SHOES_LIGHT(c.SHOES, 305),
    SHOES_SPRANDI(c.SHOES, 306),
    MILI_PRO_OLD(c.MILI, 7),
    MILI_PRO(c.MILI, 8),
    MILI_NFC(c.MILI, 9);
    
    private c o = c.MILI;
    private int p = 0;

    private b(c cVar, int i) {
        this.o = cVar;
        this.p = i;
    }
}
