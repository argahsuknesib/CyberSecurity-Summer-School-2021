package _m_j;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

public final class ilh {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final BigInteger f1438O000000o = new BigInteger("f460d489678f7ec903293517e9193fd156c821b3e2b027c644eb96aedc85a54c971468cea07df15e9ecda0e2ca062161add38b9aa8aefcbd7ac18cd05a6bfb1147aaa516a6df694ee2cb5164607c618df7c65e75e274ff49632c34ce18da534ee32cfc42279e0f4c29101e89033130058d7f77744dddaca541094f19c394d485", 16);
    protected static final BigInteger O00000Oo = new BigInteger("9ce2e29b2be0ebfd7b3c58cfb0ee4e9004e65367c069f358effaf2a8e334891d20ff158111f54b50244d682b720f964c4d6234079d480fcc2ce66e0fa3edeb642b0700cd62c4c02a483c92d2361e41a23706332bd3a8aaed07fe53bba376cefbce12fa46265ad5ea5210a3d96f5260f7b6f29588f61a4798e40bdc75bbb2b457", 16);
    private static DhKeyPair O00000o0;

    public static String O000000o(String str, DhKeyPair dhKeyPair) {
        return new BigInteger(str).modPow(dhKeyPair.privateKey, f1438O000000o).toString().toUpperCase();
    }

    public static void O000000o(Context context) {
        try {
            new File(context.getFilesDir(), "client.txt").deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DhKeyPair O000000o() {
        Context context;
        DhKeyPair dhKeyPair;
        if (XmPlayerService.getPlayerSrvice() != null) {
            context = XmPlayerService.getPlayerSrvice();
        } else {
            context = iit.O000000o().f1325O000000o;
        }
        DhKeyPair dhKeyPair2 = O00000o0;
        if (dhKeyPair2 != null) {
            return dhKeyPair2;
        }
        try {
            File file = new File(context.getFilesDir(), "client.txt");
            System.out.println("DHUtil.initPartyAKey   ".concat(String.valueOf(file)));
            if (file.exists() && (dhKeyPair = (DhKeyPair) new ObjectInputStream(new FileInputStream(file)).readObject()) != null) {
                O00000o0 = dhKeyPair;
                return dhKeyPair;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        DhKeyPair dhKeyPair3 = new DhKeyPair();
        BigInteger bigInteger = new BigInteger((int) NotificationCompat.FLAG_HIGH_PRIORITY, new SecureRandom());
        dhKeyPair3.publicKey = O00000Oo.modPow(bigInteger, f1438O000000o);
        dhKeyPair3.privateKey = bigInteger;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(), "client.txt")));
            objectOutputStream.writeObject(dhKeyPair3);
            objectOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        O00000o0 = dhKeyPair3;
        return dhKeyPair3;
    }
}
