package com.tsmclient.smartcard.terminal;

import android.support.v4.app.NotificationCompat;
import com.tsmclient.smartcard.ByteArray;

public class APDUConstants {
    public static final ByteArray AID_BMAC = ByteArray.wrap(new byte[]{-111, 86, 0, 0, 20, 1, 0, 1});
    public static final ByteArray AID_CST = ByteArray.wrap(new byte[]{-96, 0, 0, 0, 3, -122, -104, 7, 1, 65, 0});
    public static final ByteArray AID_FAKE_SPDB = ByteArray.wrap(new byte[]{-96, 0, 0, 3, 51, 1, 1, 1, -1, 32, 0, -1, -1, -1, -1, 0});
    public static final ByteArray AID_HZT = ByteArray.wrap(new byte[]{-96, 0, 0, 0, 3, -122, -104, 7, 1, 49, 0});
    public static final ByteArray AID_LNT = ByteArray.wrap(new byte[]{89, 67, 84, 46, 85, 83, 69, 82});
    public static final ByteArray AID_SPTC = ByteArray.wrap(new byte[]{-96, 0, 0, 0, 3, -122, -104, 7, 1});
    public static final ByteArray AID_SPTC_NEW = ByteArray.wrap(new byte[]{-96, 0, 0, 0, 3, -122, -104, 7, 1});
    public static final ByteArray AID_ST_ONE_DAY_PASS = ByteArray.wrap(new byte[]{65, 80, 80, 77, 69, 67, 48, 50, 65});
    public static final ByteArray AID_ST_THREE_DAY_PASS = ByteArray.wrap(new byte[]{65, 80, 80, 77, 69, 67, 48, 50, 66});
    public static final ByteArray AID_SUZHOUTONG = ByteArray.wrap(new byte[]{83, 85, 88, 73, 78, 46, 77, 70});
    public static final ByteArray AID_SZT = ByteArray.wrap(new byte[]{83, 90, 84, 46, 87, 65, 76, 76, 69, 84, 46, 69, 78, 86});
    public static final ByteArray AID_WHT = ByteArray.wrap(new byte[]{-96, 0, 0, 83, 66, 87, 72, 84, 75});
    public static final CommandApdu COMM_PREFIX_ACTIVATE_CARD = new CommandApdu(NotificationCompat.FLAG_HIGH_PRIORITY, 240, 1, 1);
    public static final CommandApdu COMM_PREFIX_DEACTIVATE_CARD = new CommandApdu(NotificationCompat.FLAG_HIGH_PRIORITY, 240, 1, 0);
    public static final CommandApdu COMM_PREFIX_GET_STATUS = new CommandApdu(NotificationCompat.FLAG_HIGH_PRIORITY, 242, 64, 0);
    public static final CommandApdu COMM_PREFIX_INIT_UPDATE = new CommandApdu(NotificationCompat.FLAG_HIGH_PRIORITY, 80, 33, 0);
    public static final CommandApdu COMM_PREFIX_READ_RECORD = new CommandApdu(0, 178, 1, 12);
    public static final CommandApdu COMM_TAG_GET_STATUS = new CommandApdu(92, 3, 79, 159, 112);
    public static final byte[] GET_SEID = {Byte.MIN_VALUE, -54, -97, Byte.MAX_VALUE, 0};
    public static final byte[] ISD = {-96, 0, 0, 1, 81, 0, 0, 0};
    public static final byte[] MC_OPEN = {0, 112, 0, 0, 1};
    public static byte[] MIFARE_CARD_AID_PREFFIX = {-96, 0, 0, 3, -106, 77, 52, 77, 16};
    public static final ByteArray NOT_EXISTS = ByteArray.wrap(new byte[]{106, -126});
    public static byte[] PBOC_CARD_AID_PREFFIX = {-96, 0, 0, 3, 51, 1, 1};
    public static final byte[] SELECT_CRS = {0, -92, 4, 0, 9, -96, 0, 0, 1, 81, 67, 82, 83, 0};
    public static final byte[] SELECT_ISD = {0, -92, 4, 0, 8, -96, 0, 0, 1, 81, 0, 0, 0};
    public static final byte[] SELECT_PPSE = {0, -92, 4, 0, 14, 50, 80, 65, 89, 46, 83, 89, 83, 46, 68, 68, 70, 48, 49};
    public static final ByteArray TAG_AEF_ENTRANCE = ByteArray.wrap(new byte[]{97});
    public static final ByteArray TAG_AID = ByteArray.wrap(new byte[]{79});
    public static final ByteArray TAG_APP = ByteArray.wrap(new byte[]{80});
    public static final ByteArray TAG_BANK_CUSTOM_DATA = ByteArray.wrap(new byte[]{-65, 12});
    public static final ByteArray TAG_CARD_NUM = ByteArray.wrap(new byte[]{87});
    public static final ByteArray TAG_FCI_2PAY = ByteArray.wrap(new byte[]{-124});
    public static final ByteArray TAG_FCI_DATA_TEMPLATE = ByteArray.wrap(new byte[]{-91});
    public static final ByteArray TAG_FCI_TEMPLATE = ByteArray.wrap(new byte[]{111});
    public static final ByteArray TAG_LIFESTYLE_STATE = ByteArray.wrap(new byte[]{-97, 112});
    public static final ByteArray TAG_PDOL = ByteArray.wrap(new byte[]{-97, 56});
}
