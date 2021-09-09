package bsh;

import _m_j.lb;
import _m_j.lc;
import _m_j.ld;
import _m_j.le;
import _m_j.lf;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.Reader;

public final class Parser implements ld, lf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected lb f3065O000000o = new lb();
    boolean O00000Oo = false;
    lc O00000o;
    public le O00000o0;
    public Token O00000oO;
    public Token O00000oo;
    public boolean O0000O0o = false;
    private Token O0000Oo;
    private int O0000Oo0;
    private Token O0000OoO;
    private int O0000Ooo;
    private final LookaheadSuccess O0000o0 = new LookaheadSuccess((byte) 0);
    private boolean O0000o00;

    static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }

        LookaheadSuccess(byte b) {
            this();
        }
    }

    public Parser(Reader reader) {
        this.O00000o = new lc(reader);
        this.O00000o0 = new le(this.O00000o);
        this.O00000oO = new Token();
        this.O0000Oo0 = -1;
    }

    private Modifiers O000000o(int i) throws ParseException {
        int i2;
        Modifiers modifiers = null;
        while (true) {
            int i3 = this.O0000Oo0;
            if (i3 == -1) {
                i3 = O00oO0OO();
            }
            if (!(i3 == 10 || i3 == 27 || i3 == 39 || i3 == 58 || i3 == 48 || i3 == 49 || i3 == 51 || i3 == 52)) {
                switch (i3) {
                    case 43:
                    case 44:
                    case 45:
                        break;
                    default:
                        return modifiers;
                }
            }
            int i4 = this.O0000Oo0;
            if (i4 == -1) {
                i4 = O00oO0OO();
            }
            if (i4 == 10) {
                O00000Oo(10);
            } else if (i4 == 27) {
                O00000Oo(27);
            } else if (i4 == 39) {
                O00000Oo(39);
            } else if (i4 == 58) {
                O00000Oo(58);
            } else if (i4 == 48) {
                O00000Oo(48);
            } else if (i4 == 49) {
                O00000Oo(49);
            } else if (i4 == 51) {
                O00000Oo(51);
            } else if (i4 != 52) {
                switch (i4) {
                    case 43:
                        i2 = 43;
                        break;
                    case 44:
                        i2 = 44;
                        break;
                    case 45:
                        i2 = 45;
                        break;
                    default:
                        O00000Oo(-1);
                        throw new ParseException();
                }
                O00000Oo(i2);
            } else {
                O00000Oo(52);
            }
            if (modifiers == null) {
                try {
                    modifiers = new Modifiers();
                } catch (IllegalStateException e) {
                    throw O000000o(e.getMessage());
                }
            }
            modifiers.O000000o(i, O00000o(0).image);
        }
    }

    private ParseException O000000o(String str) {
        Token token = this.O00000oO;
        int i = token.beginLine;
        int i2 = token.beginColumn;
        StringBuffer stringBuffer = new StringBuffer("Parse error at line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(" : ");
        stringBuffer.append(str);
        return new ParseException(stringBuffer.toString());
    }

    private void O000000o(Node node) {
        ((SimpleNode) node).firstToken = O00000o(1);
    }

    private final Token O00000Oo(int i) throws ParseException {
        Token token = this.O00000oO;
        if (token.next != null) {
            this.O00000oO = this.O00000oO.next;
        } else {
            Token token2 = this.O00000oO;
            Token O000000o2 = this.O00000o0.O000000o();
            token2.next = O000000o2;
            this.O00000oO = O000000o2;
        }
        this.O0000Oo0 = -1;
        if (this.O00000oO.kind == i) {
            return this.O00000oO;
        }
        this.O00000oO = token;
        throw O00oO00o();
    }

    private void O00000Oo(Node node) {
        ((SimpleNode) node).lastToken = O00000o(0);
    }

    private boolean O00000Oo() {
        if (O00000o(1).kind != 30) {
            return false;
        }
        int i = 3;
        if (O00000o(2).kind != 72) {
            return false;
        }
        while (true) {
            int i2 = i + 1;
            int i3 = O00000o(i).kind;
            if (i3 == 0) {
                return false;
            }
            if (i3 == 78) {
                return true;
            }
            if (i3 == 89) {
                return false;
            }
            i = i2;
        }
    }

    private Token O00000o(int i) {
        Token token;
        Token token2 = this.O0000O0o ? this.O0000Oo : this.O00000oO;
        for (int i2 = 0; i2 < i; i2++) {
            if (token2.next != null) {
                token = token2.next;
            } else {
                Token O000000o2 = this.O00000o0.O000000o();
                token2.next = O000000o2;
                token = O000000o2;
            }
        }
        return token2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHClassDeclaration, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090 A[SYNTHETIC, Splitter:B:43:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096 A[Catch:{ all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a0 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b4  */
    private void O00000o0() throws ParseException {
        boolean z;
        Throwable th;
        BSHClassDeclaration bSHClassDeclaration = new BSHClassDeclaration();
        this.f3065O000000o.O00000oo();
        O000000o(bSHClassDeclaration);
        boolean z2 = false;
        try {
            Modifiers O000000o2 = O000000o(0);
            int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
            if (O00oO0OO == 13) {
                O00000Oo(13);
            } else if (O00oO0OO == 37) {
                O00000Oo(37);
                bSHClassDeclaration.isInterface = true;
            } else {
                O00000Oo(-1);
                throw new ParseException();
            }
            Token O00000Oo2 = O00000Oo(69);
            if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 25) {
                O00000Oo(25);
                O0000o00();
                bSHClassDeclaration.extend = true;
            }
            if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 33) {
                O00000Oo(33);
                bSHClassDeclaration.numInterfaces = O0000o0();
            }
            O000Oo0o();
            this.f3065O000000o.O000000o((Node) bSHClassDeclaration, true);
            try {
                O00000Oo(bSHClassDeclaration);
                bSHClassDeclaration.modifiers = O000000o2;
                bSHClassDeclaration.name = O00000Oo2.image;
            } catch (Throwable th2) {
                th = th2;
                z = false;
                if (z) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z = true;
            if (z) {
                this.f3065O000000o.O000000o((Node) bSHClassDeclaration, true);
                O00000Oo(bSHClassDeclaration);
            }
            throw th;
        }
    }

    private final boolean O00000o0(int i) {
        Token token = this.O0000Oo;
        if (token == this.O0000OoO) {
            this.O0000Ooo--;
            if (token.next == null) {
                Token token2 = this.O0000Oo;
                Token O000000o2 = this.O00000o0.O000000o();
                token2.next = O000000o2;
                this.O0000Oo = O000000o2;
                this.O0000OoO = O000000o2;
            } else {
                Token token3 = this.O0000Oo.next;
                this.O0000Oo = token3;
                this.O0000OoO = token3;
            }
        } else {
            this.O0000Oo = token.next;
        }
        if (this.O0000Oo.kind != i) {
            return true;
        }
        if (this.O0000Ooo != 0 || this.O0000Oo != this.O0000OoO) {
            return false;
        }
        throw this.O0000o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHPackageDeclaration, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    private void O00000oO() throws ParseException {
        boolean z;
        BSHPackageDeclaration bSHPackageDeclaration = new BSHPackageDeclaration();
        this.f3065O000000o.O00000oo();
        O000000o(bSHPackageDeclaration);
        try {
            O00000Oo(42);
            O0000o00();
            this.f3065O000000o.O000000o((Node) bSHPackageDeclaration, true);
            O00000Oo(bSHPackageDeclaration);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHImportDeclaration, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    private void O00000oo() throws ParseException {
        boolean z;
        Throwable th;
        BSHImportDeclaration bSHImportDeclaration = new BSHImportDeclaration();
        this.f3065O000000o.O00000oo();
        O000000o(bSHImportDeclaration);
        boolean z2 = false;
        try {
            if (O000Ooo()) {
                Token token = null;
                Token O00000Oo2 = (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) != 48 ? null : O00000Oo(48);
                O00000Oo(34);
                O0000o00();
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 80) {
                    token = O00000Oo(80);
                    O00000Oo(104);
                }
                O00000Oo(78);
                this.f3065O000000o.O000000o((Node) bSHImportDeclaration, true);
                try {
                    O00000Oo(bSHImportDeclaration);
                    if (O00000Oo2 != null) {
                        bSHImportDeclaration.staticImport = true;
                    }
                    if (token != null) {
                        bSHImportDeclaration.importPackage = true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                    if (z) {
                    }
                    throw th;
                }
            } else {
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 34) {
                    O00000Oo(34);
                    O00000Oo(104);
                    O00000Oo(78);
                    this.f3065O000000o.O000000o((Node) bSHImportDeclaration, true);
                    O00000Oo(bSHImportDeclaration);
                    bSHImportDeclaration.superImport = true;
                    return;
                }
                O00000Oo(-1);
                throw new ParseException();
            }
        } catch (Throwable th3) {
            th = th3;
            z = true;
            if (z) {
                this.f3065O000000o.O000000o((Node) bSHImportDeclaration, true);
                O00000Oo(bSHImportDeclaration);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHVariableDeclarator, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[SYNTHETIC, Splitter:B:21:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053 A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0066  */
    private void O0000O0o() throws ParseException {
        boolean z;
        BSHVariableDeclarator bSHVariableDeclarator = new BSHVariableDeclarator();
        this.f3065O000000o.O00000oo();
        O000000o(bSHVariableDeclarator);
        boolean z2 = false;
        try {
            Token O00000Oo2 = O00000Oo(69);
            if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 81) {
                O00000Oo(81);
                O0000OOo();
            }
            this.f3065O000000o.O000000o((Node) bSHVariableDeclarator, true);
            try {
                O00000Oo(bSHVariableDeclarator);
                bSHVariableDeclarator.name = O00000Oo2.image;
            } catch (Throwable th) {
                th = th;
                z = false;
                if (!z) {
                }
                try {
                    if (!(th instanceof RuntimeException)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z2) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = true;
            if (z2) {
                this.f3065O000000o.O000000o((Node) bSHVariableDeclarator, true);
                O00000Oo(bSHVariableDeclarator);
            }
            throw th;
        }
    }

    private void O0000OOo() throws ParseException {
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        switch (i) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case 38:
            case 40:
            case 41:
            case 47:
            case 55:
            case 57:
            case 60:
            case 64:
            case 66:
            case 67:
            case 69:
            case 72:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                O0000o0O();
                return;
            case 74:
                O0000Oo0();
                return;
            default:
                O00000Oo(-1);
                throw new ParseException();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHFormalParameter, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007f  */
    private void O0000Oo() throws ParseException {
        boolean z;
        String str;
        BSHFormalParameter bSHFormalParameter = new BSHFormalParameter();
        this.f3065O000000o.O00000oo();
        O000000o(bSHFormalParameter);
        boolean z2 = false;
        try {
            if (O000Oooo()) {
                O0000OoO();
                Token O00000Oo2 = O00000Oo(69);
                this.f3065O000000o.O000000o((Node) bSHFormalParameter, true);
                try {
                    O00000Oo(bSHFormalParameter);
                    str = O00000Oo2.image;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                }
            } else {
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 69) {
                    Token O00000Oo3 = O00000Oo(69);
                    this.f3065O000000o.O000000o((Node) bSHFormalParameter, true);
                    O00000Oo(bSHFormalParameter);
                    str = O00000Oo3.image;
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
            }
            bSHFormalParameter.name = str;
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            if (z2) {
                this.f3065O000000o.O000000o((Node) bSHFormalParameter, true);
                O00000Oo(bSHFormalParameter);
            }
            throw th;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHArrayInitializer, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006f  */
    private void O0000Oo0() throws ParseException {
        boolean z;
        BSHArrayInitializer bSHArrayInitializer = new BSHArrayInitializer();
        this.f3065O000000o.O00000oo();
        O000000o(bSHArrayInitializer);
        try {
            O00000Oo(74);
            switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                case 11:
                case 14:
                case 17:
                case 22:
                case 26:
                case 29:
                case 36:
                case 38:
                case 40:
                case 41:
                case 47:
                case 55:
                case 57:
                case 60:
                case 64:
                case 66:
                case 67:
                case 69:
                case 72:
                case 74:
                case 86:
                case 87:
                case 100:
                case 101:
                case 102:
                case 103:
                    while (true) {
                        O0000OOo();
                        if (!O000OooO()) {
                            break;
                        } else {
                            O00000Oo(79);
                        }
                    }
            }
            if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 79) {
                O00000Oo(79);
            }
            O00000Oo(75);
            this.f3065O000000o.O000000o((Node) bSHArrayInitializer, true);
            O00000Oo(bSHArrayInitializer);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHType, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0089  */
    private void O0000OoO() throws ParseException {
        boolean z;
        BSHType bSHType = new BSHType();
        this.f3065O000000o.O00000oo();
        O000000o(bSHType);
        try {
            int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
            if (O00oO0OO == 11 || O00oO0OO == 14 || O00oO0OO == 17 || O00oO0OO == 22 || O00oO0OO == 29 || O00oO0OO == 36 || O00oO0OO == 38 || O00oO0OO == 47) {
                O0000Ooo();
            } else if (O00oO0OO == 69) {
                O0000o00();
            } else {
                O00000Oo(-1);
                throw new ParseException();
            }
            while (O000o000()) {
                O00000Oo(76);
                O00000Oo(77);
                bSHType.O000000o();
            }
            this.f3065O000000o.O000000o((Node) bSHType, true);
            O00000Oo(bSHType);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHPrimitiveType, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    private void O0000Ooo() throws ParseException {
        boolean z;
        Class cls;
        BSHPrimitiveType bSHPrimitiveType = new BSHPrimitiveType();
        this.f3065O000000o.O00000oo();
        O000000o(bSHPrimitiveType);
        try {
            int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
            if (O00oO0OO == 11) {
                O00000Oo(11);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Boolean.TYPE;
            } else if (O00oO0OO == 14) {
                O00000Oo(14);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Byte.TYPE;
            } else if (O00oO0OO == 17) {
                O00000Oo(17);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Character.TYPE;
            } else if (O00oO0OO == 22) {
                O00000Oo(22);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Double.TYPE;
            } else if (O00oO0OO == 29) {
                O00000Oo(29);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Float.TYPE;
            } else if (O00oO0OO == 36) {
                O00000Oo(36);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Integer.TYPE;
            } else if (O00oO0OO == 38) {
                O00000Oo(38);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
                cls = Long.TYPE;
            } else if (O00oO0OO == 47) {
                O00000Oo(47);
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                try {
                    O00000Oo(bSHPrimitiveType);
                    cls = Short.TYPE;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                }
            } else {
                O00000Oo(-1);
                throw new ParseException();
            }
            bSHPrimitiveType.type = cls;
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
                this.f3065O000000o.O000000o((Node) bSHPrimitiveType, true);
                O00000Oo(bSHPrimitiveType);
            }
            throw th;
        }
    }

    private int O0000o() throws ParseException {
        int i;
        int i2 = this.O0000Oo0;
        if (i2 == -1) {
            i2 = O00oO0OO();
        }
        int i3 = 81;
        if (i2 != 81) {
            i3 = 124;
            if (i2 != 124) {
                switch (i2) {
                    case 118:
                        i = 118;
                        break;
                    case 119:
                        i = 119;
                        break;
                    case 120:
                        i = 120;
                        break;
                    case 121:
                        i = 121;
                        break;
                    case 122:
                        i = 122;
                        break;
                    default:
                        switch (i2) {
                            case 126:
                                i = 126;
                                break;
                            case 127:
                                i = 127;
                                break;
                            case NotificationCompat.FLAG_HIGH_PRIORITY:
                                i = NotificationCompat.FLAG_HIGH_PRIORITY;
                                break;
                            case 129:
                                i = 129;
                                break;
                            case 130:
                                i = 130;
                                break;
                            case 131:
                                i = 131;
                                break;
                            case 132:
                                i = 132;
                                break;
                            case 133:
                                i = 133;
                                break;
                            default:
                                O00000Oo(-1);
                                throw new ParseException();
                        }
                }
                O00000Oo(i);
                return O00000o(0).kind;
            }
        }
        O00000Oo(i3);
        return O00000o(0).kind;
    }

    private int O0000o0() throws ParseException {
        O0000o00();
        int i = 1;
        while (true) {
            int i2 = this.O0000Oo0;
            if (i2 == -1) {
                i2 = O00oO0OO();
            }
            if (i2 != 79) {
                return i;
            }
            O00000Oo(79);
            O0000o00();
            i++;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHAmbiguousName, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    private void O0000o00() throws ParseException {
        boolean z;
        BSHAmbiguousName bSHAmbiguousName = new BSHAmbiguousName();
        this.f3065O000000o.O00000oo();
        O000000o(bSHAmbiguousName);
        try {
            StringBuffer stringBuffer = new StringBuffer(O00000Oo(69).image);
            while (O000o00()) {
                O00000Oo(80);
                Token O00000Oo2 = O00000Oo(69);
                StringBuffer stringBuffer2 = new StringBuffer(".");
                stringBuffer2.append(O00000Oo2.image);
                stringBuffer.append(stringBuffer2.toString());
            }
            this.f3065O000000o.O000000o((Node) bSHAmbiguousName, true);
            try {
                O00000Oo(bSHAmbiguousName);
                bSHAmbiguousName.text = stringBuffer.toString();
            } catch (Throwable th) {
                th = th;
                z = false;
                if (z) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
                this.f3065O000000o.O000000o((Node) bSHAmbiguousName, true);
                O00000Oo(bSHAmbiguousName);
            }
            throw th;
        }
    }

    private void O0000o0O() throws ParseException {
        if (O000o00O()) {
            O0000o0o();
            return;
        }
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        switch (i) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case 38:
            case 40:
            case 41:
            case 47:
            case 55:
            case 57:
            case 60:
            case 64:
            case 66:
            case 67:
            case 69:
            case 72:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                O0000oO0();
                return;
            default:
                O00000Oo(-1);
                throw new ParseException();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHAssignment, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
    private void O0000o0o() throws ParseException {
        boolean z;
        BSHAssignment bSHAssignment = new BSHAssignment();
        this.f3065O000000o.O00000oo();
        O000000o(bSHAssignment);
        try {
            O000OO00();
            bSHAssignment.operator = O0000o();
            O0000o0O();
            this.f3065O000000o.O000000o((Node) bSHAssignment, true);
            O00000Oo(bSHAssignment);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    private void O0000oO() throws ParseException {
        Token token;
        O0000oOO();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 96 || i == 97) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 96) {
                    token = O00000Oo(96);
                } else if (i2 == 97) {
                    token = O00000Oo(97);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O0000oOO();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O0000oO0() throws ParseException {
        O0000oO();
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        if (i == 88) {
            O00000Oo(88);
            O0000o0O();
            O00000Oo(89);
            BSHTernaryExpression bSHTernaryExpression = new BSHTernaryExpression();
            this.f3065O000000o.O00000oo();
            O000000o(bSHTernaryExpression);
            try {
                O0000oO0();
                this.f3065O000000o.O000000o(bSHTernaryExpression, 3);
                O00000Oo(bSHTernaryExpression);
            } catch (Throwable th) {
                if (1 != 0) {
                    this.f3065O000000o.O000000o(bSHTernaryExpression, 3);
                    O00000Oo(bSHTernaryExpression);
                }
                throw th;
            }
        }
    }

    private void O0000oOO() throws ParseException {
        Token token;
        O0000oOo();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 98 || i == 99) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 98) {
                    token = O00000Oo(98);
                } else if (i2 == 99) {
                    token = O00000Oo(99);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O0000oOo();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O0000oOo() throws ParseException {
        Token token;
        O0000oo0();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 108 || i == 109) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 108) {
                    token = O00000Oo(108);
                } else if (i2 == 109) {
                    token = O00000Oo(109);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O0000oo0();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O0000oo() throws ParseException {
        Token token;
        O0000ooO();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 106 || i == 107) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 106) {
                    token = O00000Oo(106);
                } else if (i2 == 107) {
                    token = O00000Oo(107);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O0000ooO();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O0000oo0() throws ParseException {
        O0000oo();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 110) {
                Token O00000Oo2 = O00000Oo(110);
                O0000oo();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = O00000Oo2.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O0000ooO() throws ParseException {
        Token token;
        O0000ooo();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 90 || i == 95) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 90) {
                    token = O00000Oo(90);
                } else if (i2 == 95) {
                    token = O00000Oo(95);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O0000ooo();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O0000ooo() throws ParseException {
        O00oOooO();
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        if (i == 35) {
            Token O00000Oo2 = O00000Oo(35);
            O0000OoO();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
            boolean z = true;
            this.f3065O000000o.O00000oo();
            O000000o(bSHBinaryExpression);
            try {
                this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                z = false;
                O00000Oo(bSHBinaryExpression);
                bSHBinaryExpression.kind = O00000Oo2.kind;
            } catch (Throwable th) {
                if (z) {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    O00000Oo(bSHBinaryExpression);
                }
                throw th;
            }
        }
    }

    private void O000O00o() throws ParseException {
        Token token;
        O000O0OO();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 102 || i == 103) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 102) {
                    token = O00000Oo(102);
                } else if (i2 == 103) {
                    token = O00000Oo(103);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O000O0OO();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    private void O000O0OO() throws ParseException {
        Token token;
        O000O0Oo();
        while (true) {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 104 || i == 105 || i == 111) {
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                if (i2 == 104) {
                    token = O00000Oo(104);
                } else if (i2 == 105) {
                    token = O00000Oo(105);
                } else if (i2 == 111) {
                    token = O00000Oo(111);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                O000O0Oo();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
                boolean z = true;
                this.f3065O000000o.O00000oo();
                O000000o(bSHBinaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    z = false;
                    O00000Oo(bSHBinaryExpression);
                    bSHBinaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                        O00000Oo(bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058  */
    private void O000O0Oo() throws ParseException {
        boolean z;
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        switch (i) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case 38:
            case 40:
            case 41:
            case 47:
            case 55:
            case 57:
            case 60:
            case 64:
            case 66:
            case 67:
            case 69:
            case 72:
            case 86:
            case 87:
                O000O0o();
                return;
            case 100:
                O00oOoOo();
                return;
            case 101:
                O000O0o0();
                return;
            case 102:
            case 103:
                int i2 = this.O0000Oo0;
                if (i2 == -1) {
                    i2 = O00oO0OO();
                }
                int i3 = 102;
                if (i2 != 102) {
                    i3 = 103;
                    if (i2 != 103) {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                }
                Token O00000Oo2 = O00000Oo(i3);
                O000O0Oo();
                BSHUnaryExpression bSHUnaryExpression = new BSHUnaryExpression();
                this.f3065O000000o.O00000oo();
                O000000o(bSHUnaryExpression);
                try {
                    this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                    z = false;
                    try {
                        O00000Oo(bSHUnaryExpression);
                        bSHUnaryExpression.kind = O00000Oo2.kind;
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (z) {
                            this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                            O00000Oo(bSHUnaryExpression);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                    if (z) {
                    }
                    throw th;
                }
            default:
                O00000Oo(-1);
                throw new ParseException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    private void O000O0o() throws ParseException {
        Token token;
        boolean z;
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        if (i == 86 || i == 87) {
            int i2 = this.O0000Oo0;
            if (i2 == -1) {
                i2 = O00oO0OO();
            }
            if (i2 == 86) {
                token = O00000Oo(86);
            } else if (i2 == 87) {
                token = O00000Oo(87);
            } else {
                O00000Oo(-1);
                throw new ParseException();
            }
            O000O0Oo();
            BSHUnaryExpression bSHUnaryExpression = new BSHUnaryExpression();
            this.f3065O000000o.O00000oo();
            O000000o(bSHUnaryExpression);
            try {
                this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                z = false;
                try {
                    O00000Oo(bSHUnaryExpression);
                    bSHUnaryExpression.kind = token.kind;
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                        O00000Oo(bSHUnaryExpression);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                }
                throw th;
            }
        } else if (O000o00o()) {
            O000O0oo();
        } else {
            int i3 = this.O0000Oo0;
            if (i3 == -1) {
                i3 = O00oO0OO();
            }
            switch (i3) {
                case 11:
                case 14:
                case 17:
                case 22:
                case 26:
                case 29:
                case 36:
                case 38:
                case 40:
                case 41:
                case 47:
                case 55:
                case 57:
                case 60:
                case 64:
                case 66:
                case 67:
                case 69:
                case 72:
                    O000O0oO();
                    return;
                default:
                    O00000Oo(-1);
                    throw new ParseException();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    private void O000O0o0() throws ParseException {
        boolean z;
        Token O00000Oo2 = O00000Oo(101);
        O000OO00();
        BSHUnaryExpression bSHUnaryExpression = new BSHUnaryExpression();
        this.f3065O000000o.O00000oo();
        O000000o(bSHUnaryExpression);
        try {
            this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
            z = false;
            try {
                O00000Oo(bSHUnaryExpression);
                bSHUnaryExpression.kind = O00000Oo2.kind;
            } catch (Throwable th) {
                th = th;
                if (z) {
                    this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                    O00000Oo(bSHUnaryExpression);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    private void O000O0oO() throws ParseException {
        boolean z;
        if (O000o0()) {
            O000OO00();
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            int i2 = 100;
            if (i != 100) {
                i2 = 101;
                if (i != 101) {
                    O00000Oo(-1);
                    throw new ParseException();
                }
            }
            Token O00000Oo2 = O00000Oo(i2);
            BSHUnaryExpression bSHUnaryExpression = new BSHUnaryExpression();
            this.f3065O000000o.O00000oo();
            O000000o(bSHUnaryExpression);
            try {
                this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                z = false;
                try {
                    O00000Oo(bSHUnaryExpression);
                    bSHUnaryExpression.kind = O00000Oo2.kind;
                    bSHUnaryExpression.postfix = true;
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                        O00000Oo(bSHUnaryExpression);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                }
                throw th;
            }
        } else {
            int i3 = this.O0000Oo0;
            if (i3 == -1) {
                i3 = O00oO0OO();
            }
            switch (i3) {
                case 11:
                case 14:
                case 17:
                case 22:
                case 26:
                case 29:
                case 36:
                case 38:
                case 40:
                case 41:
                case 47:
                case 55:
                case 57:
                case 60:
                case 64:
                case 66:
                case 67:
                case 69:
                case 72:
                    O000OO00();
                    return;
                default:
                    O00000Oo(-1);
                    throw new ParseException();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHCastExpression, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    private void O000O0oo() throws ParseException {
        boolean z;
        BSHCastExpression bSHCastExpression = new BSHCastExpression();
        this.f3065O000000o.O00000oo();
        O000000o(bSHCastExpression);
        try {
            if (O000o0O0()) {
                O00000Oo(72);
                O0000OoO();
                O00000Oo(73);
                O000O0Oo();
            } else {
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 72) {
                    O00000Oo(72);
                    O0000OoO();
                    O00000Oo(73);
                    O000O0o();
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
            }
            this.f3065O000000o.O000000o((Node) bSHCastExpression, true);
            O00000Oo(bSHCastExpression);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    private void O000OO() throws ParseException {
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        if (!(i == 26 || i == 55 || i == 57 || i == 60 || i == 64)) {
            if (i == 72) {
                O00000Oo(72);
                O0000o0O();
                O00000Oo(73);
                return;
            } else if (i == 40) {
                O000Oo00();
                return;
            } else if (!(i == 41 || i == 66 || i == 67)) {
                if (O000o0O()) {
                    O000OO0o();
                    return;
                } else if (O000o0OO()) {
                    O0000OoO();
                    return;
                } else {
                    int i2 = this.O0000Oo0;
                    if (i2 == -1) {
                        i2 = O00oO0OO();
                    }
                    if (i2 == 69) {
                        O0000o00();
                        return;
                    } else {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                }
            }
        }
        O000OOo0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHPrimaryExpression, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0054  */
    private void O000OO00() throws ParseException {
        boolean z;
        BSHPrimaryExpression bSHPrimaryExpression = new BSHPrimaryExpression();
        this.f3065O000000o.O00000oo();
        O000000o(bSHPrimaryExpression);
        try {
            O000OO();
            while (true) {
                int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                if (O00oO0OO == 74 || O00oO0OO == 76 || O00oO0OO == 80) {
                    O000OOOo();
                } else {
                    this.f3065O000000o.O000000o((Node) bSHPrimaryExpression, true);
                    O00000Oo(bSHPrimaryExpression);
                    return;
                }
            }
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHMethodInvocation, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b  */
    private void O000OO0o() throws ParseException {
        boolean z;
        BSHMethodInvocation bSHMethodInvocation = new BSHMethodInvocation();
        this.f3065O000000o.O00000oo();
        O000000o(bSHMethodInvocation);
        try {
            O0000o00();
            O000OOoO();
            this.f3065O000000o.O000000o((Node) bSHMethodInvocation, true);
            O00000Oo(bSHMethodInvocation);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHPrimarySuffix, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d1  */
    private void O000OOOo() throws ParseException {
        boolean z;
        BSHPrimarySuffix bSHPrimarySuffix = new BSHPrimarySuffix();
        this.f3065O000000o.O00000oo();
        O000000o(bSHPrimarySuffix);
        boolean z2 = false;
        try {
            if (O000o0Oo()) {
                O00000Oo(80);
                O00000Oo(13);
                this.f3065O000000o.O000000o((Node) bSHPrimarySuffix, true);
                try {
                    O00000Oo(bSHPrimarySuffix);
                    bSHPrimarySuffix.operation = 0;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                }
            } else {
                int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                if (O00oO0OO == 74) {
                    O00000Oo(74);
                    O0000o0O();
                    O00000Oo(75);
                    this.f3065O000000o.O000000o((Node) bSHPrimarySuffix, true);
                    O00000Oo(bSHPrimarySuffix);
                    bSHPrimarySuffix.operation = 3;
                } else if (O00oO0OO == 76) {
                    O00000Oo(76);
                    O0000o0O();
                    O00000Oo(77);
                    this.f3065O000000o.O000000o((Node) bSHPrimarySuffix, true);
                    O00000Oo(bSHPrimarySuffix);
                    bSHPrimarySuffix.operation = 1;
                } else if (O00oO0OO == 80) {
                    O00000Oo(80);
                    Token O00000Oo2 = O00000Oo(69);
                    if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 72) {
                        O000OOoO();
                    }
                    this.f3065O000000o.O000000o((Node) bSHPrimarySuffix, true);
                    O00000Oo(bSHPrimarySuffix);
                    bSHPrimarySuffix.operation = 2;
                    bSHPrimarySuffix.field = O00000Oo2.image;
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            if (z2) {
                this.f3065O000000o.O000000o((Node) bSHPrimarySuffix, true);
                O00000Oo(bSHPrimarySuffix);
            }
            throw th;
        }
    }

    private boolean O000OOo() throws ParseException {
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        if (i == 26) {
            O00000Oo(26);
            return false;
        } else if (i == 55) {
            O00000Oo(55);
            return true;
        } else {
            O00000Oo(-1);
            throw new ParseException();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHArguments, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052  */
    private void O000OOoO() throws ParseException {
        boolean z;
        BSHArguments bSHArguments = new BSHArguments();
        this.f3065O000000o.O00000oo();
        O000000o(bSHArguments);
        try {
            O00000Oo(72);
            switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                case 11:
                case 14:
                case 17:
                case 22:
                case 26:
                case 29:
                case 36:
                case 38:
                case 40:
                case 41:
                case 47:
                case 55:
                case 57:
                case 60:
                case 64:
                case 66:
                case 67:
                case 69:
                case 72:
                case 86:
                case 87:
                case 100:
                case 101:
                case 102:
                case 103:
                    O000OOoo();
                    break;
            }
            O00000Oo(73);
            this.f3065O000000o.O000000o((Node) bSHArguments, true);
            O00000Oo(bSHArguments);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    private void O000OOoo() throws ParseException {
        while (true) {
            O0000o0O();
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i == 79) {
                O00000Oo(79);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHArrayDimensions, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0091  */
    private void O000Oo0() throws ParseException {
        boolean z;
        int i;
        BSHArrayDimensions bSHArrayDimensions = new BSHArrayDimensions();
        this.f3065O000000o.O00000oo();
        O000000o(bSHArrayDimensions);
        try {
            if (O000oO00()) {
                do {
                    O00000Oo(76);
                    O0000o0O();
                    O00000Oo(77);
                    bSHArrayDimensions.O000000o();
                } while (O000o0oo());
                while (O000o()) {
                    O00000Oo(76);
                    O00000Oo(77);
                    bSHArrayDimensions.O00000Oo();
                }
            } else {
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 76) {
                    do {
                        O00000Oo(76);
                        O00000Oo(77);
                        bSHArrayDimensions.O00000Oo();
                        if (this.O0000Oo0 == -1) {
                            i = O00oO0OO();
                            continue;
                        } else {
                            i = this.O0000Oo0;
                            continue;
                        }
                    } while (i == 76);
                    O0000Oo0();
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
            }
            this.f3065O000000o.O000000o((Node) bSHArrayDimensions, true);
            O00000Oo(bSHArrayDimensions);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHAllocationExpression, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    private void O000Oo00() throws ParseException {
        boolean z;
        BSHAllocationExpression bSHAllocationExpression = new BSHAllocationExpression();
        this.f3065O000000o.O00000oo();
        O000000o(bSHAllocationExpression);
        try {
            if (O000o0o()) {
                O00000Oo(40);
                O0000Ooo();
            } else {
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 40) {
                    O00000Oo(40);
                    O0000o00();
                    int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                    if (O00oO0OO == 72) {
                        O000OOoO();
                        if (O000o0o0()) {
                            O000Oo0o();
                        }
                        this.f3065O000000o.O000000o((Node) bSHAllocationExpression, true);
                        O00000Oo(bSHAllocationExpression);
                    } else if (O00oO0OO != 76) {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
            }
            O000Oo0();
            this.f3065O000000o.O000000o((Node) bSHAllocationExpression, true);
            O00000Oo(bSHAllocationExpression);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHBlock, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049  */
    private void O000Oo0o() throws ParseException {
        boolean z;
        BSHBlock bSHBlock = new BSHBlock();
        this.f3065O000000o.O00000oo();
        O000000o(bSHBlock);
        try {
            O00000Oo(74);
            while (O000oO0O()) {
                O000OoO0();
            }
            O00000Oo(75);
            this.f3065O000000o.O000000o((Node) bSHBlock, true);
            O00000Oo(bSHBlock);
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHTypedVariableDeclaration, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0066  */
    private void O000OoO() throws ParseException {
        boolean z;
        BSHTypedVariableDeclaration bSHTypedVariableDeclaration = new BSHTypedVariableDeclaration();
        this.f3065O000000o.O00000oo();
        O000000o(bSHTypedVariableDeclaration);
        boolean z2 = false;
        try {
            Modifiers O000000o2 = O000000o(2);
            O0000OoO();
            while (true) {
                O0000O0o();
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) != 79) {
                    this.f3065O000000o.O000000o((Node) bSHTypedVariableDeclaration, true);
                    try {
                        O00000Oo(bSHTypedVariableDeclaration);
                        bSHTypedVariableDeclaration.modifiers = O000000o2;
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            try {
                                this.f3065O000000o.O00000oO();
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = z;
                                if (z2) {
                                }
                                throw th;
                            }
                        } else {
                            this.f3065O000000o.O00000o0();
                            z2 = z;
                        }
                        try {
                            if (th instanceof RuntimeException) {
                                throw ((RuntimeException) th);
                            } else if (th instanceof ParseException) {
                                throw ((ParseException) th);
                            } else {
                                throw ((Error) th);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (z2) {
                            }
                            throw th;
                        }
                    }
                } else {
                    O00000Oo(79);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z2 = true;
            if (z2) {
                this.f3065O000000o.O000000o((Node) bSHTypedVariableDeclaration, true);
                O00000Oo(bSHTypedVariableDeclaration);
            }
            throw th;
        }
    }

    private void O000OoO0() throws ParseException {
        if (O000oO0o()) {
            O00000o0();
        } else if (O000oO()) {
            O00000o();
        } else if (O000oOO0()) {
            O00000o();
        } else if (O000oOO()) {
            O000OoO();
            O00000Oo(78);
        } else if (O000oOOO()) {
            O000Oo0O();
        } else {
            int i = this.O0000Oo0;
            if (i == -1) {
                i = O00oO0OO();
            }
            if (i != 34) {
                if (i == 42) {
                    O00000oO();
                    return;
                } else if (i != 48) {
                    if (i == 68) {
                        O00O0Oo();
                        return;
                    } else {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                }
            }
            O00000oo();
        }
    }

    private final boolean O000Ooo() {
        this.O0000Ooo = 3;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00o00O();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000OooO() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00OoOo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000Oooo() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00OoOoo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00O0o();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o00() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00OOOo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o000() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00OoO0O();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o0Oo() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00o00o();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o0o() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00OO0O();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o0o0() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00O0Oo0();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o0oo() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00O0oO0();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oO0() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00O0o00();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oO00() {
        this.O0000Ooo = 2;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00O0oOo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oO0O() {
        this.O0000Ooo = 1;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O000oo0();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oOOO() {
        this.O0000Ooo = 1;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00o0ooo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oOOo() {
        this.O0000Ooo = 1;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00o0O0o();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oOo0() {
        this.O0000Ooo = 4;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00o0O00();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oOoo() {
        Token token = this.O0000Oo;
        if (!O000oOoO()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00oO00O()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00oO000()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00oO0O0()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00o0ooo()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00o0oo()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00o0oOo()) {
            return false;
        }
        this.O0000Oo = token;
        return O00o0oOO();
    }

    private final boolean O000oo0() {
        return O000oOoo();
    }

    private final boolean O000oo0o() {
        Token token;
        if (O00000o0(74)) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O000oo0());
        this.O0000Oo = token;
        return O00000o0(75);
    }

    private final boolean O000ooO() {
        return O00000o0(88) || O00O0ooO() || O00000o0(89) || O00O0O0o();
    }

    private final boolean O000ooO0() {
        return O00000o0(69) || O00000o0(89) || O00O0Ooo();
    }

    private final boolean O00O0O0o() {
        if (O00O00o0()) {
            return true;
        }
        Token token = this.O0000Oo;
        if (!O000ooO()) {
            return false;
        }
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00O0OOo() {
        return O00o0o0() || O00000o0(78);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHFormalComment, boolean]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    private void O00O0Oo() throws ParseException {
        BSHFormalComment bSHFormalComment = new BSHFormalComment();
        this.f3065O000000o.O00000oo();
        O000000o(bSHFormalComment);
        boolean z = true;
        try {
            Token O00000Oo2 = O00000Oo(68);
            this.f3065O000000o.O000000o((Node) bSHFormalComment, this.O00000Oo);
            z = false;
            O00000Oo(bSHFormalComment);
            bSHFormalComment.text = O00000Oo2.image;
        } catch (Throwable th) {
            if (z) {
                this.f3065O000000o.O000000o((Node) bSHFormalComment, this.O00000Oo);
                O00000Oo(bSHFormalComment);
            }
            throw th;
        }
    }

    private final boolean O00O0Oo0() {
        return O000oo0o();
    }

    private final boolean O00O0OoO() {
        return O000oo0o();
    }

    private final boolean O00O0Ooo() {
        Token token = this.O0000Oo;
        if (O00O0o00()) {
            this.O0000Oo = token;
            if (O00O0OoO()) {
                this.O0000Oo = token;
                if (O00000o0(78)) {
                    this.O0000Oo = token;
                    if (O00O0OOo()) {
                        this.O0000Oo = token;
                        if (O00O0OO()) {
                            this.O0000Oo = token;
                            if (O00O00oo()) {
                                this.O0000Oo = token;
                                if (O00O00oO()) {
                                    this.O0000Oo = token;
                                    if (O00O00o()) {
                                        this.O0000Oo = token;
                                        this.O0000O0o = true;
                                        this.O0000o00 = O00000Oo();
                                        this.O0000O0o = false;
                                        if (!this.O0000o00 || O00O00Oo()) {
                                            this.O0000Oo = token;
                                            if (O00O000o()) {
                                                this.O0000Oo = token;
                                                if (O00oOOoo()) {
                                                    this.O0000Oo = token;
                                                    if (oooOoO()) {
                                                        this.O0000Oo = token;
                                                        if (O000oooO()) {
                                                            this.O0000Oo = token;
                                                            if (O000ooo()) {
                                                                this.O0000Oo = token;
                                                                if (O000ooo0()) {
                                                                    this.O0000Oo = token;
                                                                    if (O000ooOo()) {
                                                                        return true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean O00O0o() {
        return O00000o0(76) || O00000o0(77);
    }

    private final boolean O00O0o0() {
        Token token = this.O0000Oo;
        if (!O00000o0(81)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(120)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(121)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(127)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(118)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(119)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(122)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(126)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(124)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(NotificationCompat.FLAG_HIGH_PRIORITY)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(129)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(130)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(131)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(132)) {
            return false;
        }
        this.O0000Oo = token;
        return O00000o0(133);
    }

    private final boolean O00O0o00() {
        return O000ooO0();
    }

    private final boolean O00O0o0O() {
        return O00000o0(79) || O00OOo();
    }

    private final boolean O00O0o0o() {
        return O00000o0(76) || O00000o0(77);
    }

    private final boolean O00O0oO0() {
        return O00000o0(76) || O00O0ooO() || O00000o0(77);
    }

    private final boolean O00O0oOO() {
        return O00oo000() || O00O0o0() || O00O0ooO();
    }

    private final boolean O00O0oOo() {
        Token token;
        Token token2;
        if (O00O0oO0()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00O0oO0());
        this.O0000Oo = token;
        do {
            token2 = this.O0000Oo;
        } while (!O00O0o());
        this.O0000Oo = token2;
        return false;
    }

    private final boolean O00O0oo() {
        return O00O0O0o();
    }

    private final boolean O00O0ooO() {
        Token token = this.O0000Oo;
        if (!O00O0ooo()) {
            return false;
        }
        this.O0000Oo = token;
        return O00O0oo();
    }

    private final boolean O00O0ooo() {
        return O00O0oOO();
    }

    private final boolean O00OO0O() {
        return O00000o0(40) || O00Oo0oO() || O00O0oo0();
    }

    private final boolean O00OO0o() {
        Token token;
        if (O00OOo()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00O0o0O());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00OOOo() {
        return O00000o0(80) || O00000o0(69);
    }

    private final boolean O00OOo() {
        Token token;
        if (O00000o0(69)) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00OOOo());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00OOoO() {
        return O00000o0(22);
    }

    private final boolean O00OOoo() {
        return O00000o0(29);
    }

    private final boolean O00Oo() {
        Token token = this.O0000Oo;
        if (!O00OoO0()) {
            return false;
        }
        this.O0000Oo = token;
        return O00Oo0oo();
    }

    private final boolean O00Oo0() {
        return O00000o0(47);
    }

    private final boolean O00Oo00() {
        return O00000o0(38);
    }

    private final boolean O00Oo00o() {
        return O00000o0(36);
    }

    private final boolean O00Oo0OO() {
        return O00OOo();
    }

    private final boolean O00Oo0Oo() {
        return O00000o0(14);
    }

    private final boolean O00Oo0o() {
        return O00000o0(11);
    }

    private final boolean O00Oo0o0() {
        return O00000o0(17);
    }

    private final boolean O00Oo0oO() {
        Token token = this.O0000Oo;
        if (!O00Oo0o()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00Oo0o0()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00Oo0Oo()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00Oo0()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00Oo00o()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00Oo00()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00OOoo()) {
            return false;
        }
        this.O0000Oo = token;
        return O00OOoO();
    }

    private final boolean O00Oo0oo() {
        return O00OoOO();
    }

    private final boolean O00OoO() {
        return O00Oo0oO();
    }

    private final boolean O00OoO0() {
        return O00000o0(57);
    }

    private final boolean O00OoO0O() {
        return O00000o0(76) || O00000o0(77);
    }

    private final boolean O00OoO0o() {
        return O00000o0(41);
    }

    private final boolean O00OoOO() {
        Token token;
        Token token2 = this.O0000Oo;
        if (O00OoO()) {
            this.O0000Oo = token2;
            if (O00Oo0OO()) {
                return true;
            }
        }
        do {
            token = this.O0000Oo;
        } while (!O00OoO0O());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00OoOO0() {
        return O00000o0(67);
    }

    private final boolean O00OoOo() {
        return O00000o0(79) || O00OoooO();
    }

    private final boolean O00OoOo0() {
        return O00000o0(66);
    }

    private final boolean O00OoOoO() {
        return O00000o0(69);
    }

    private final boolean O00OoOoo() {
        return O00OoOO() || O00000o0(69);
    }

    private final boolean O00Ooo0() {
        Token token = this.O0000Oo;
        if (!O00OoOoo()) {
            return false;
        }
        this.O0000Oo = token;
        return O00OoOoO();
    }

    private final boolean O00Ooo0O() {
        if (O00000o0(72)) {
            return true;
        }
        Token token = this.O0000Oo;
        if (O00Ooo00()) {
            this.O0000Oo = token;
        }
        return O00000o0(73);
    }

    private final boolean O00Ooo0o() {
        Token token;
        if (O00OoooO()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00OoOo());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00OooO() {
        if (O00000o0(74)) {
            return true;
        }
        Token token = this.O0000Oo;
        if (O00Ooo0o()) {
            this.O0000Oo = token;
        }
        Token token2 = this.O0000Oo;
        if (O00000o0(79)) {
            this.O0000Oo = token2;
        }
        return O00000o0(75);
    }

    private final boolean O00OooO0() {
        return O00000o0(64);
    }

    private final boolean O00OooOO() {
        return O00000o0(57);
    }

    private final boolean O00OooOo() {
        return O00000o0(80) || O00000o0(104);
    }

    private final boolean O00Oooo() {
        return O00O0ooO();
    }

    private final boolean O00Oooo0() {
        return O00000o0(81) || O00OoooO();
    }

    private final boolean O00OoooO() {
        Token token = this.O0000Oo;
        if (!O00Ooooo()) {
            return false;
        }
        this.O0000Oo = token;
        return O00Oooo();
    }

    private final boolean O00Ooooo() {
        return O00OooO();
    }

    private final boolean O00o() {
        if (O00o0oo0()) {
            return true;
        }
        Token token = this.O0000Oo;
        if (!O00o0ooO()) {
            return false;
        }
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00o00() {
        if (O00000o0(69)) {
            return true;
        }
        Token token = this.O0000Oo;
        if (!O00Oooo0()) {
            return false;
        }
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00o000() {
        return O00000o0(79) || O00o0o0();
    }

    private final boolean O00o0000() {
        return O00000o0(79) || O00o00();
    }

    private final boolean O00o000O() {
        Token token = this.O0000Oo;
        if (!O00o000o()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00OooO0()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00OoOo0()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00OoOO0()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00Ooo()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00OoO0o()) {
            return false;
        }
        this.O0000Oo = token;
        return O00OooOO();
    }

    private final boolean O00o000o() {
        return O00000o0(60);
    }

    private final boolean O00o00O() {
        Token token = this.O0000Oo;
        if (O00000o0(48)) {
            this.O0000Oo = token;
        }
        if (O00000o0(34) || O00OOo()) {
            return true;
        }
        Token token2 = this.O0000Oo;
        if (O00OooOo()) {
            this.O0000Oo = token2;
        }
        return O00000o0(78);
    }

    private final boolean O00o00O0() {
        Token token;
        if (O00o0o0()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00o000());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00o00Oo() {
        Token token;
        O00o0O();
        if (O00OoOO() || O00o00()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00o0000());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00o00o() {
        return O00000o0(80) || O00000o0(13);
    }

    private final boolean O00o00o0() {
        return O00000o0(42) || O00OOo();
    }

    private final boolean O00o0O() {
        Token token;
        do {
            token = this.O0000Oo;
        } while (!O00o0O0O());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00o0O0() {
        return O00OOo() || O00OOo0();
    }

    private final boolean O00o0O00() {
        return O00000o0(30) || O00000o0(72) || O00000o0(69) || O00000o0(89) || O00O0ooO() || O00000o0(73) || O00O0Ooo();
    }

    private final boolean O00o0O0O() {
        Token token = this.O0000Oo;
        if (!O00000o0(43)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(44)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(45)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(51)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(27)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(39)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(52)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(58)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(10)) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00000o0(48)) {
            return false;
        }
        this.O0000Oo = token;
        return O00000o0(49);
    }

    private final boolean O00o0O0o() {
        return O000oOoo();
    }

    private final boolean O00o0OOO() {
        Token token = this.O0000Oo;
        if (O00000o0(87)) {
            this.O0000Oo = token;
            if (O00000o0(86)) {
                return true;
            }
        }
        return O00o0o00();
    }

    private final boolean O00o0OOo() {
        Token token = this.O0000Oo;
        if (!O00o0OOO()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00o0OO()) {
            return false;
        }
        this.O0000Oo = token;
        return O00o0OO0();
    }

    private final boolean O00o0Oo0() {
        return O00o0OOo();
    }

    private final boolean O00o0Ooo() {
        Token token = this.O0000Oo;
        if (O00000o0(102)) {
            this.O0000Oo = token;
            if (O00000o0(103)) {
                return true;
            }
        }
        return O00o0o00();
    }

    private final boolean O00o0o() {
        return O00000o0(68);
    }

    private final boolean O00o0o0() {
        return O00O0ooO();
    }

    private final boolean O00o0o00() {
        Token token = this.O0000Oo;
        if (!O00o0Ooo()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00o0OoO()) {
            return false;
        }
        this.O0000Oo = token;
        if (!O00o0Oo()) {
            return false;
        }
        this.O0000Oo = token;
        return O00o0Oo0();
    }

    private final boolean O00o0oO0() {
        Token token = this.O0000Oo;
        if (O00000o0(90)) {
            this.O0000Oo = token;
            if (O00000o0(95)) {
                return true;
            }
        }
        return O00o();
    }

    private final boolean O00o0oOO() {
        return O00o0o();
    }

    private final boolean O00o0oOo() {
        return O00o00o0();
    }

    private final boolean O00o0oo() {
        return O00o00OO();
    }

    private final boolean O00o0ooO() {
        return O00000o0(35) || O00OoOO();
    }

    private final boolean O00o0ooo() {
        return O00O0Ooo();
    }

    private final boolean O00oO00() {
        Token token;
        if (O00o()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00o0oO0());
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00oO000() {
        return O00o00oO();
    }

    private final boolean O00oO00O() {
        return O00o00oO();
    }

    private ParseException O00oO00o() {
        Token token = this.O00000oO.next;
        int i = token.beginLine;
        int i2 = token.beginColumn;
        String str = token.kind == 0 ? ld.a_[0] : token.image;
        StringBuffer stringBuffer = new StringBuffer("Parse error at line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(".  Encountered: ");
        stringBuffer.append(str);
        return new ParseException(stringBuffer.toString());
    }

    private final boolean O00oO0O0() {
        return O00o00Oo() || O00000o0(78);
    }

    private final int O00oO0OO() {
        int i;
        Token token = this.O00000oO.next;
        this.O00000oo = token;
        if (token == null) {
            Token token2 = this.O00000oO;
            Token O000000o2 = this.O00000o0.O000000o();
            token2.next = O000000o2;
            i = O000000o2.kind;
        } else {
            i = this.O00000oo.kind;
        }
        this.O0000Oo0 = i;
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    private void O00oOoOo() throws ParseException {
        boolean z;
        Token O00000Oo2 = O00000Oo(100);
        O000OO00();
        BSHUnaryExpression bSHUnaryExpression = new BSHUnaryExpression();
        this.f3065O000000o.O00000oo();
        O000000o(bSHUnaryExpression);
        try {
            this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
            z = false;
            try {
                O00000Oo(bSHUnaryExpression);
                bSHUnaryExpression.kind = O00000Oo2.kind;
            } catch (Throwable th) {
                th = th;
                if (z) {
                    this.f3065O000000o.O000000o(bSHUnaryExpression, 1);
                    O00000Oo(bSHUnaryExpression);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
            }
            throw th;
        }
    }

    private void O00oOooO() throws ParseException {
        int i;
        O00oOooo();
        while (true) {
            int i2 = this.O0000Oo0;
            if (i2 == -1) {
                i2 = O00oO0OO();
            }
            switch (i2) {
                case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                case 83:
                case 84:
                case 85:
                    break;
                default:
                    switch (i2) {
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                            break;
                        default:
                            return;
                    }
            }
            int i3 = this.O0000Oo0;
            if (i3 == -1) {
                i3 = O00oO0OO();
            }
            switch (i3) {
                case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                    i = 82;
                    break;
                case 83:
                    i = 83;
                    break;
                case 84:
                    i = 84;
                    break;
                case 85:
                    i = 85;
                    break;
                default:
                    switch (i3) {
                        case 91:
                            i = 91;
                            break;
                        case 92:
                            i = 92;
                            break;
                        case 93:
                            i = 93;
                            break;
                        case 94:
                            i = 94;
                            break;
                        default:
                            O00000Oo(-1);
                            throw new ParseException();
                    }
            }
            Token O00000Oo2 = O00000Oo(i);
            O00oOooo();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression();
            boolean z = true;
            this.f3065O000000o.O00000oo();
            O000000o(bSHBinaryExpression);
            try {
                this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                z = false;
                O00000Oo(bSHBinaryExpression);
                bSHBinaryExpression.kind = O00000Oo2.kind;
            } catch (Throwable th) {
                if (z) {
                    this.f3065O000000o.O000000o(bSHBinaryExpression, 2);
                    O00000Oo(bSHBinaryExpression);
                }
                throw th;
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x000f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0008  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0010 A[FALL_THROUGH] */
    private void O00oOooo() throws bsh.ParseException {
        /*
            r5 = this;
            r5.O000O00o()
        L_0x0003:
            int r0 = r5.O0000Oo0
            r1 = -1
            if (r0 != r1) goto L_0x000c
            int r0 = r5.O00oO0OO()
        L_0x000c:
            switch(r0) {
                case 112: goto L_0x0010;
                case 113: goto L_0x0010;
                case 114: goto L_0x0010;
                case 115: goto L_0x0010;
                case 116: goto L_0x0010;
                case 117: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            return
        L_0x0010:
            int r0 = r5.O0000Oo0
            if (r0 != r1) goto L_0x0018
            int r0 = r5.O00oO0OO()
        L_0x0018:
            switch(r0) {
                case 112: goto L_0x0033;
                case 113: goto L_0x0030;
                case 114: goto L_0x002d;
                case 115: goto L_0x002a;
                case 116: goto L_0x0027;
                case 117: goto L_0x0024;
                default: goto L_0x001b;
            }
        L_0x001b:
            r5.O00000Oo(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x0024:
            r0 = 117(0x75, float:1.64E-43)
            goto L_0x0035
        L_0x0027:
            r0 = 116(0x74, float:1.63E-43)
            goto L_0x0035
        L_0x002a:
            r0 = 115(0x73, float:1.61E-43)
            goto L_0x0035
        L_0x002d:
            r0 = 114(0x72, float:1.6E-43)
            goto L_0x0035
        L_0x0030:
            r0 = 113(0x71, float:1.58E-43)
            goto L_0x0035
        L_0x0033:
            r0 = 112(0x70, float:1.57E-43)
        L_0x0035:
            bsh.Token r0 = r5.O00000Oo(r0)
            r5.O000O00o()
            bsh.BSHBinaryExpression r1 = new bsh.BSHBinaryExpression
            r1.<init>()
            r2 = 1
            _m_j.lb r3 = r5.f3065O000000o
            r3.O00000oo()
            r5.O000000o(r1)
            r3 = 2
            _m_j.lb r4 = r5.f3065O000000o     // Catch:{ all -> 0x0059 }
            r4.O000000o(r1, r3)     // Catch:{ all -> 0x0059 }
            r2 = 0
            r5.O00000Oo(r1)     // Catch:{ all -> 0x0059 }
            int r0 = r0.kind     // Catch:{ all -> 0x0059 }
            r1.kind = r0     // Catch:{ all -> 0x0059 }
            goto L_0x0003
        L_0x0059:
            r0 = move-exception
            if (r2 == 0) goto L_0x0064
            _m_j.lb r2 = r5.f3065O000000o
            r2.O000000o(r1, r3)
            r5.O00000Oo(r1)
        L_0x0064:
            goto L_0x0066
        L_0x0065:
            throw r0
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.O00oOooo():void");
    }

    private final boolean O00oo000() {
        Token token;
        if (O00o0()) {
            return true;
        }
        do {
            token = this.O0000Oo;
        } while (!O00o00oo());
        this.O0000Oo = token;
        return false;
    }

    public final void O000000o(Reader reader) {
        this.O00000o.O000000o(reader, 1, 1);
        this.O00000o0.O000000o(this.O00000o);
        this.O00000oO = new Token();
        this.O0000Oo0 = -1;
        this.f3065O000000o.O000000o();
    }

    public final boolean O000000o() throws ParseException {
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        if (i == 0) {
            O00000Oo(0);
            Interpreter.O00000Oo("End of File!");
            return true;
        } else if (O000OoOo()) {
            O000OoO0();
            return false;
        } else {
            O00000Oo(-1);
            throw new ParseException();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHReturnType, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHFormalParameters, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHMethodDeclaration, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017f A[SYNTHETIC, Splitter:B:125:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018f A[SYNTHETIC, Splitter:B:133:0x018f] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0196 A[Catch:{ all -> 0x01ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019f A[Catch:{ all -> 0x01ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a9 A[Catch:{ all -> 0x01ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01af A[SYNTHETIC, Splitter:B:148:0x01af] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b7 A[SYNTHETIC, Splitter:B:54:0x00b7] */
    private void O00000o() throws ParseException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        BSHMethodDeclaration bSHMethodDeclaration = new BSHMethodDeclaration();
        this.f3065O000000o.O00000oo();
        O000000o(bSHMethodDeclaration);
        try {
            bSHMethodDeclaration.modifiers = O000000o(1);
            if (O000Ooo0()) {
                bSHMethodDeclaration.name = O00000Oo(69).image;
            } else {
                int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                if (!(O00oO0OO == 11 || O00oO0OO == 14 || O00oO0OO == 17 || O00oO0OO == 22 || O00oO0OO == 29 || O00oO0OO == 36 || O00oO0OO == 38 || O00oO0OO == 47 || O00oO0OO == 57)) {
                    if (O00oO0OO != 69) {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                }
                BSHReturnType bSHReturnType = new BSHReturnType();
                this.f3065O000000o.O00000oo();
                O000000o(bSHReturnType);
                try {
                    int O00oO0OO2 = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                    if (!(O00oO0OO2 == 11 || O00oO0OO2 == 14 || O00oO0OO2 == 17 || O00oO0OO2 == 22 || O00oO0OO2 == 29 || O00oO0OO2 == 36 || O00oO0OO2 == 38 || O00oO0OO2 == 47)) {
                        if (O00oO0OO2 == 57) {
                            O00000Oo(57);
                            this.f3065O000000o.O000000o((Node) bSHReturnType, true);
                            try {
                                O00000Oo(bSHReturnType);
                                bSHReturnType.isVoid = true;
                                z4 = false;
                                if (z4) {
                                    this.f3065O000000o.O000000o((Node) bSHReturnType, true);
                                    O00000Oo(bSHReturnType);
                                }
                                bSHMethodDeclaration.name = O00000Oo(69).image;
                            } catch (Throwable th) {
                                th = th;
                                z3 = false;
                                if (z3) {
                                }
                                throw th;
                            }
                        } else if (O00oO0OO2 != 69) {
                            O00000Oo(-1);
                            throw new ParseException();
                        }
                    }
                    O0000OoO();
                    z4 = true;
                    if (z4) {
                    }
                    bSHMethodDeclaration.name = O00000Oo(69).image;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = true;
                    if (z3) {
                        this.f3065O000000o.O000000o((Node) bSHReturnType, true);
                        O00000Oo(bSHReturnType);
                    }
                    throw th;
                }
            }
            BSHFormalParameters bSHFormalParameters = new BSHFormalParameters();
            this.f3065O000000o.O00000oo();
            O000000o(bSHFormalParameters);
            try {
                O00000Oo(72);
                int O00oO0OO3 = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                if (O00oO0OO3 == 11 || O00oO0OO3 == 14 || O00oO0OO3 == 17 || O00oO0OO3 == 22 || O00oO0OO3 == 29 || O00oO0OO3 == 36 || O00oO0OO3 == 38 || O00oO0OO3 == 47 || O00oO0OO3 == 69) {
                    while (true) {
                        O0000Oo();
                        if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) != 79) {
                            break;
                        }
                        O00000Oo(79);
                    }
                }
                O00000Oo(73);
                this.f3065O000000o.O000000o((Node) bSHFormalParameters, true);
                O00000Oo(bSHFormalParameters);
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 54) {
                    O00000Oo(54);
                    bSHMethodDeclaration.numThrows = O0000o0();
                }
                int O00oO0OO4 = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                if (O00oO0OO4 == 74) {
                    O000Oo0o();
                } else if (O00oO0OO4 == 78) {
                    O00000Oo(78);
                } else {
                    O00000Oo(-1);
                    throw new ParseException();
                }
                this.f3065O000000o.O000000o((Node) bSHMethodDeclaration, true);
                O00000Oo(bSHMethodDeclaration);
            } catch (Throwable th3) {
                th = th3;
                z2 = false;
                if (z2) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            z = false;
            if (z) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHLiteral, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|23|24|25|26|27|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:33|34|35|36|37|38|39|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0143, code lost:
        throw O000000o("Error or number too big for integer type: ".concat(java.lang.String.valueOf(r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0190, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0191, code lost:
        r4 = false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0044, B:65:0x0125] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0095 */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01bf  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0095=Splitter:B:38:0x0095, B:27:0x0059=Splitter:B:27:0x0059} */
    private void O000OOo0() throws ParseException {
        Primitive primitive;
        BSHLiteral bSHLiteral = new BSHLiteral();
        this.f3065O000000o.O00000oo();
        O000000o(bSHLiteral);
        boolean z = false;
        try {
            int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
            if (O00oO0OO != 26) {
                if (O00oO0OO == 41) {
                    O00000Oo(41);
                    this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                    O00000Oo(bSHLiteral);
                    bSHLiteral.value = Primitive.O00000Oo;
                    return;
                } else if (O00oO0OO != 55) {
                    if (O00oO0OO == 57) {
                        O00000Oo(57);
                        this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                        O00000Oo(bSHLiteral);
                        bSHLiteral.value = Primitive.O00000o0;
                        return;
                    } else if (O00oO0OO == 60) {
                        Token O00000Oo2 = O00000Oo(60);
                        this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                        O00000Oo(bSHLiteral);
                        String str = O00000Oo2.image;
                        char charAt = str.charAt(str.length() - 1);
                        if (charAt == 'l' || charAt == 'L') {
                            primitive = new Primitive(new Long(str.substring(0, str.length() - 1)).longValue());
                            bSHLiteral.value = primitive;
                        }
                        bSHLiteral.value = new Primitive(Integer.decode(str).intValue());
                        return;
                    } else if (O00oO0OO == 64) {
                        Token O00000Oo3 = O00000Oo(64);
                        this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                        O00000Oo(bSHLiteral);
                        String str2 = O00000Oo3.image;
                        char charAt2 = str2.charAt(str2.length() - 1);
                        if (charAt2 != 'f') {
                            if (charAt2 != 'F') {
                                if (charAt2 == 'd' || charAt2 == 'D') {
                                    str2 = str2.substring(0, str2.length() - 1);
                                }
                                primitive = new Primitive(new Double(str2).doubleValue());
                                bSHLiteral.value = primitive;
                            }
                        }
                        primitive = new Primitive(new Float(str2.substring(0, str2.length() - 1)).floatValue());
                        bSHLiteral.value = primitive;
                    } else if (O00oO0OO == 66) {
                        Token O00000Oo4 = O00000Oo(66);
                        this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                        O00000Oo(bSHLiteral);
                        bSHLiteral.O000000o(O00000Oo4.image.substring(1, O00000Oo4.image.length() - 1));
                        StringBuffer stringBuffer = new StringBuffer("Error parsing character: ");
                        stringBuffer.append(O00000Oo4.image);
                        throw O000000o(stringBuffer.toString());
                    } else if (O00oO0OO == 67) {
                        Token O00000Oo5 = O00000Oo(67);
                        this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                        O00000Oo(bSHLiteral);
                        bSHLiteral.O00000Oo(O00000Oo5.image.substring(1, O00000Oo5.image.length() - 1));
                        StringBuffer stringBuffer2 = new StringBuffer("Error parsing string: ");
                        stringBuffer2.append(O00000Oo5.image);
                        throw O000000o(stringBuffer2.toString());
                    } else {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                }
            }
            boolean O000OOo = O000OOo();
            this.f3065O000000o.O000000o((Node) bSHLiteral, true);
            O00000Oo(bSHLiteral);
            primitive = new Primitive(O000OOo);
            bSHLiteral.value = primitive;
        } catch (Throwable th) {
            th = th;
            z = true;
            if (z) {
                this.f3065O000000o.O000000o((Node) bSHLiteral, true);
                O00000Oo(bSHLiteral);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHWhileStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHSwitchStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHSwitchLabel, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHIfStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHForStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHTryStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHThrowStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHBlock, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHReturnStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHEnhancedForStatement, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0154 A[SYNTHETIC, Splitter:B:101:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0221 A[SYNTHETIC, Splitter:B:169:0x0221] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0227 A[Catch:{ all -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0231 A[Catch:{ all -> 0x023e }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x023b A[Catch:{ all -> 0x023e }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0381 A[SYNTHETIC, Splitter:B:300:0x0381] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0387 A[Catch:{ all -> 0x03a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0391 A[Catch:{ all -> 0x039e }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x039b A[Catch:{ all -> 0x039e }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0430 A[SYNTHETIC, Splitter:B:361:0x0430] */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0436 A[Catch:{ all -> 0x044f }] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0440 A[Catch:{ all -> 0x044d }] */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x044a A[Catch:{ all -> 0x044d }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0496 A[SYNTHETIC, Splitter:B:402:0x0496] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x049c A[Catch:{ all -> 0x04b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x04a6 A[Catch:{ all -> 0x04b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x04b0 A[Catch:{ all -> 0x04b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:489:0x059e  */
    /* JADX WARNING: Removed duplicated region for block: B:508:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0134 A[SYNTHETIC, Splitter:B:86:0x0134] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013b A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0144 A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x014e A[Catch:{ all -> 0x0151 }] */
    private void O000Oo0O() throws ParseException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        boolean z5;
        boolean z6;
        boolean z7;
        while (O000oO0()) {
            O00000Oo(69);
            O00000Oo(89);
        }
        int i = this.O0000Oo0;
        if (i == -1) {
            i = O00oO0OO();
        }
        boolean z8 = false;
        switch (i) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case 38:
            case 40:
            case 41:
            case 47:
            case 55:
            case 57:
            case 60:
            case 64:
            case 66:
            case 67:
            case 69:
            case 72:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                O0000o0O();
                O00000Oo(78);
                return;
            case 21:
                BSHWhileStatement bSHWhileStatement = new BSHWhileStatement();
                this.f3065O000000o.O00000oo();
                O000000o(bSHWhileStatement);
                try {
                    O00000Oo(21);
                    O000Oo0O();
                    O00000Oo(59);
                    O00000Oo(72);
                    O0000o0O();
                    O00000Oo(73);
                    O00000Oo(78);
                    this.f3065O000000o.O000000o((Node) bSHWhileStatement, true);
                    try {
                        O00000Oo(bSHWhileStatement);
                        bSHWhileStatement.isDoStatement = true;
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                        }
                        try {
                            if (!(th instanceof RuntimeException)) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (z8) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z8 = true;
                    if (z8) {
                        this.f3065O000000o.O000000o((Node) bSHWhileStatement, true);
                        O00000Oo(bSHWhileStatement);
                    }
                    throw th;
                }
            case 32:
                BSHIfStatement bSHIfStatement = new BSHIfStatement();
                this.f3065O000000o.O00000oo();
                O000000o(bSHIfStatement);
                try {
                    O00000Oo(32);
                    O00000Oo(72);
                    O0000o0O();
                    O00000Oo(73);
                    O000Oo0O();
                    if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 23) {
                        O00000Oo(23);
                        O000Oo0O();
                    }
                    this.f3065O000000o.O000000o((Node) bSHIfStatement, true);
                    O00000Oo(bSHIfStatement);
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    if (z8) {
                    }
                    throw th;
                }
            case 50:
                BSHSwitchStatement bSHSwitchStatement = new BSHSwitchStatement();
                this.f3065O000000o.O00000oo();
                O000000o(bSHSwitchStatement);
                try {
                    O00000Oo(50);
                    O00000Oo(72);
                    O0000o0O();
                    O00000Oo(73);
                    O00000Oo(74);
                    while (true) {
                        int O00oO0OO = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                        if (O00oO0OO == 15 || O00oO0OO == 20) {
                            BSHSwitchLabel bSHSwitchLabel = new BSHSwitchLabel();
                            this.f3065O000000o.O00000oo();
                            O000000o(bSHSwitchLabel);
                            try {
                                int O00oO0OO2 = this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0;
                                if (O00oO0OO2 == 15) {
                                    O00000Oo(15);
                                    O0000o0O();
                                    O00000Oo(89);
                                    z3 = true;
                                } else if (O00oO0OO2 == 20) {
                                    O00000Oo(20);
                                    O00000Oo(89);
                                    this.f3065O000000o.O000000o((Node) bSHSwitchLabel, true);
                                    try {
                                        O00000Oo(bSHSwitchLabel);
                                        bSHSwitchLabel.isDefault = true;
                                        z3 = false;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        z2 = false;
                                        if (z2) {
                                            this.f3065O000000o.O000000o((Node) bSHSwitchLabel, true);
                                            O00000Oo(bSHSwitchLabel);
                                        }
                                        throw th;
                                    }
                                } else {
                                    O00000Oo(-1);
                                    throw new ParseException();
                                }
                                if (z3) {
                                    this.f3065O000000o.O000000o((Node) bSHSwitchLabel, true);
                                    O00000Oo(bSHSwitchLabel);
                                }
                                while (O000oOOo()) {
                                    O000OoO0();
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                z2 = true;
                                if (z2) {
                                }
                                throw th;
                            }
                        } else {
                            O00000Oo(75);
                            this.f3065O000000o.O000000o((Node) bSHSwitchStatement, true);
                            O00000Oo(bSHSwitchStatement);
                            return;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (z8) {
                    }
                    throw th;
                }
            case 59:
                BSHWhileStatement bSHWhileStatement2 = new BSHWhileStatement();
                this.f3065O000000o.O00000oo();
                O000000o(bSHWhileStatement2);
                try {
                    O00000Oo(59);
                    O00000Oo(72);
                    O0000o0O();
                    O00000Oo(73);
                    O000Oo0O();
                    this.f3065O000000o.O000000o((Node) bSHWhileStatement2, true);
                    O00000Oo(bSHWhileStatement2);
                    return;
                } catch (Throwable th8) {
                    th = th8;
                    if (z8) {
                    }
                    throw th;
                }
            case 74:
                O000Oo0o();
                return;
            case 78:
                O00000Oo(78);
                return;
            default:
                if (O00000Oo()) {
                    BSHForStatement bSHForStatement = new BSHForStatement();
                    this.f3065O000000o.O00000oo();
                    O000000o(bSHForStatement);
                    try {
                        O00000Oo(30);
                        O00000Oo(72);
                        switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                            case 10:
                            case 11:
                            case 14:
                            case 17:
                            case 22:
                            case 26:
                            case 27:
                            case 29:
                            case 36:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 43:
                            case 44:
                            case 45:
                            case 47:
                            case 48:
                            case 49:
                            case 51:
                            case 52:
                            case 55:
                            case 57:
                            case 58:
                            case 60:
                            case 64:
                            case 66:
                            case 67:
                            case 69:
                            case 72:
                            case 86:
                            case 87:
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                                if (!O000oOo()) {
                                    switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                                        default:
                                            O00000Oo(-1);
                                            throw new ParseException();
                                        case 11:
                                        case 14:
                                        case 17:
                                        case 22:
                                        case 26:
                                        case 29:
                                        case 36:
                                        case 38:
                                        case 40:
                                        case 41:
                                        case 47:
                                        case 55:
                                        case 57:
                                        case 60:
                                        case 64:
                                        case 66:
                                        case 67:
                                        case 69:
                                        case 72:
                                        case 86:
                                        case 87:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                            O000OoOO();
                                            break;
                                    }
                                } else {
                                    O000OoO();
                                }
                                bSHForStatement.hasForInit = true;
                                break;
                        }
                        O00000Oo(78);
                        switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                            case 11:
                            case 14:
                            case 17:
                            case 22:
                            case 26:
                            case 29:
                            case 36:
                            case 38:
                            case 40:
                            case 41:
                            case 47:
                            case 55:
                            case 57:
                            case 60:
                            case 64:
                            case 66:
                            case 67:
                            case 69:
                            case 72:
                            case 86:
                            case 87:
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                                O0000o0O();
                                bSHForStatement.hasExpression = true;
                                break;
                        }
                        O00000Oo(78);
                        switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                            case 11:
                            case 14:
                            case 17:
                            case 22:
                            case 26:
                            case 29:
                            case 36:
                            case 38:
                            case 40:
                            case 41:
                            case 47:
                            case 55:
                            case 57:
                            case 60:
                            case 64:
                            case 66:
                            case 67:
                            case 69:
                            case 72:
                            case 86:
                            case 87:
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                                O000OoOO();
                                bSHForStatement.hasForUpdate = true;
                                break;
                        }
                        O00000Oo(73);
                        O000Oo0O();
                        this.f3065O000000o.O000000o((Node) bSHForStatement, true);
                        O00000Oo(bSHForStatement);
                        return;
                    } catch (Throwable th9) {
                        th = th9;
                        if (z8) {
                        }
                        throw th;
                    }
                } else {
                    int i2 = this.O0000Oo0;
                    if (i2 == -1) {
                        i2 = O00oO0OO();
                    }
                    if (i2 == 12) {
                        BSHReturnStatement bSHReturnStatement = new BSHReturnStatement();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHReturnStatement);
                        try {
                            O00000Oo(12);
                            if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 69) {
                                O00000Oo(69);
                            }
                            O00000Oo(78);
                            this.f3065O000000o.O000000o((Node) bSHReturnStatement, true);
                            try {
                                O00000Oo(bSHReturnStatement);
                                bSHReturnStatement.kind = 12;
                                return;
                            } catch (Throwable th10) {
                                th = th10;
                                if (z8) {
                                    this.f3065O000000o.O000000o((Node) bSHReturnStatement, true);
                                    O00000Oo(bSHReturnStatement);
                                }
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            z8 = true;
                            if (z8) {
                            }
                            throw th;
                        }
                    } else if (i2 == 19) {
                        BSHReturnStatement bSHReturnStatement2 = new BSHReturnStatement();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHReturnStatement2);
                        try {
                            O00000Oo(19);
                            if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 69) {
                                O00000Oo(69);
                            }
                            O00000Oo(78);
                            this.f3065O000000o.O000000o((Node) bSHReturnStatement2, true);
                            try {
                                O00000Oo(bSHReturnStatement2);
                                bSHReturnStatement2.kind = 19;
                                return;
                            } catch (Throwable th12) {
                                th = th12;
                                if (z8) {
                                    this.f3065O000000o.O000000o((Node) bSHReturnStatement2, true);
                                    O00000Oo(bSHReturnStatement2);
                                }
                                throw th;
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            z8 = true;
                            if (z8) {
                            }
                            throw th;
                        }
                    } else if (i2 == 30) {
                        BSHEnhancedForStatement bSHEnhancedForStatement = new BSHEnhancedForStatement();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHEnhancedForStatement);
                        try {
                            if (O000oOo0()) {
                                O00000Oo(30);
                                O00000Oo(72);
                                Token O00000Oo2 = O00000Oo(69);
                                O00000Oo(89);
                                O0000o0O();
                                O00000Oo(73);
                                O000Oo0O();
                                this.f3065O000000o.O000000o((Node) bSHEnhancedForStatement, true);
                                try {
                                    O00000Oo(bSHEnhancedForStatement);
                                    str = O00000Oo2.image;
                                } catch (Throwable th14) {
                                    th = th14;
                                    z4 = false;
                                }
                            } else {
                                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 30) {
                                    O00000Oo(30);
                                    O00000Oo(72);
                                    O0000OoO();
                                    Token O00000Oo3 = O00000Oo(69);
                                    O00000Oo(89);
                                    O0000o0O();
                                    O00000Oo(73);
                                    O000Oo0O();
                                    this.f3065O000000o.O000000o((Node) bSHEnhancedForStatement, true);
                                    O00000Oo(bSHEnhancedForStatement);
                                    str = O00000Oo3.image;
                                } else {
                                    O00000Oo(-1);
                                    throw new ParseException();
                                }
                            }
                            bSHEnhancedForStatement.varName = str;
                            return;
                        } catch (Throwable th15) {
                            th = th15;
                            z8 = true;
                            if (z8) {
                                this.f3065O000000o.O000000o((Node) bSHEnhancedForStatement, true);
                                O00000Oo(bSHEnhancedForStatement);
                            }
                            throw th;
                        }
                    } else if (i2 == 46) {
                        BSHReturnStatement bSHReturnStatement3 = new BSHReturnStatement();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHReturnStatement3);
                        try {
                            O00000Oo(46);
                            switch (this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) {
                                case 11:
                                case 14:
                                case 17:
                                case 22:
                                case 26:
                                case 29:
                                case 36:
                                case 38:
                                case 40:
                                case 41:
                                case 47:
                                case 55:
                                case 57:
                                case 60:
                                case 64:
                                case 66:
                                case 67:
                                case 69:
                                case 72:
                                case 86:
                                case 87:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                    O0000o0O();
                                    break;
                            }
                            O00000Oo(78);
                            this.f3065O000000o.O000000o((Node) bSHReturnStatement3, true);
                            try {
                                O00000Oo(bSHReturnStatement3);
                                bSHReturnStatement3.kind = 46;
                                return;
                            } catch (Throwable th16) {
                                th = th16;
                                z5 = false;
                                if (!z5) {
                                }
                                try {
                                    if (!(th instanceof RuntimeException)) {
                                    }
                                } catch (Throwable th17) {
                                    th = th17;
                                    if (z8) {
                                        this.f3065O000000o.O000000o((Node) bSHReturnStatement3, true);
                                        O00000Oo(bSHReturnStatement3);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th18) {
                            th = th18;
                            z8 = true;
                            if (z8) {
                            }
                            throw th;
                        }
                    } else if (i2 == 51) {
                        BSHBlock bSHBlock = new BSHBlock();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHBlock);
                        try {
                            O00000Oo(51);
                            O00000Oo(72);
                            O0000o0O();
                            O00000Oo(73);
                            O000Oo0o();
                            this.f3065O000000o.O000000o((Node) bSHBlock, true);
                            try {
                                O00000Oo(bSHBlock);
                                bSHBlock.isSynchronized = true;
                                return;
                            } catch (Throwable th19) {
                                th = th19;
                                z6 = false;
                                if (!z6) {
                                    try {
                                        this.f3065O000000o.O00000oO();
                                    } catch (Throwable th20) {
                                        th = th20;
                                        z8 = z6;
                                        if (z8) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    this.f3065O000000o.O00000o0();
                                    z8 = z6;
                                }
                                try {
                                    if (!(th instanceof RuntimeException)) {
                                        throw ((RuntimeException) th);
                                    } else if (th instanceof ParseException) {
                                        throw ((ParseException) th);
                                    } else {
                                        throw ((Error) th);
                                    }
                                } catch (Throwable th21) {
                                    th = th21;
                                    if (z8) {
                                        this.f3065O000000o.O000000o((Node) bSHBlock, true);
                                        O00000Oo(bSHBlock);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            z8 = true;
                            if (z8) {
                            }
                            throw th;
                        }
                    } else if (i2 == 53) {
                        BSHThrowStatement bSHThrowStatement = new BSHThrowStatement();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHThrowStatement);
                        try {
                            O00000Oo(53);
                            O0000o0O();
                            O00000Oo(78);
                            this.f3065O000000o.O000000o((Node) bSHThrowStatement, true);
                            O00000Oo(bSHThrowStatement);
                            return;
                        } catch (Throwable th23) {
                            th = th23;
                            if (z8) {
                            }
                            throw th;
                        }
                    } else if (i2 == 56) {
                        BSHTryStatement bSHTryStatement = new BSHTryStatement();
                        this.f3065O000000o.O00000oo();
                        O000000o(bSHTryStatement);
                        try {
                            O00000Oo(56);
                            O000Oo0o();
                            boolean z9 = false;
                            while (true) {
                                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) != 16) {
                                    if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) == 28) {
                                        O00000Oo(28);
                                        O000Oo0o();
                                        z9 = true;
                                    }
                                    this.f3065O000000o.O000000o((Node) bSHTryStatement, true);
                                    try {
                                        O00000Oo(bSHTryStatement);
                                        if (!z9) {
                                            throw O00oO00o();
                                        }
                                        return;
                                    } catch (Throwable th24) {
                                        th = th24;
                                        z7 = false;
                                        if (!z7) {
                                        }
                                        try {
                                            if (!(th instanceof RuntimeException)) {
                                            }
                                        } catch (Throwable th25) {
                                            th = th25;
                                            if (z8) {
                                            }
                                            throw th;
                                        }
                                    }
                                } else {
                                    O00000Oo(16);
                                    O00000Oo(72);
                                    O0000Oo();
                                    O00000Oo(73);
                                    O000Oo0o();
                                    z9 = true;
                                }
                            }
                        } catch (Throwable th26) {
                            th = th26;
                            z8 = true;
                            if (z8) {
                            }
                            throw th;
                        }
                    } else {
                        O00000Oo(-1);
                        throw new ParseException();
                    }
                }
                break;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lb.O000000o(bsh.Node, boolean):void
     arg types: [bsh.BSHStatementExpressionList, int]
     candidates:
      _m_j.lb.O000000o(bsh.Node, int):void
      _m_j.lb.O000000o(bsh.Node, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004f  */
    private void O000OoOO() throws ParseException {
        boolean z;
        BSHStatementExpressionList bSHStatementExpressionList = new BSHStatementExpressionList();
        this.f3065O000000o.O00000oo();
        O000000o(bSHStatementExpressionList);
        try {
            O0000o0O();
            while (true) {
                if ((this.O0000Oo0 == -1 ? O00oO0OO() : this.O0000Oo0) != 79) {
                    this.f3065O000000o.O000000o((Node) bSHStatementExpressionList, true);
                    O00000Oo(bSHStatementExpressionList);
                    return;
                }
                O00000Oo(79);
                O0000o0O();
            }
        } catch (Throwable th) {
            th = th;
            if (z) {
            }
            throw th;
        }
    }

    private final boolean O000OoOo() {
        this.O0000Ooo = 1;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O000oOoo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000Ooo0() {
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !(O00000o0(69) || O00000o0(72));
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o00O() {
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !(O00oo000() || O00O0o0());
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (O00o000O() != false) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023 A[Catch:{ LookaheadSuccess -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[Catch:{ LookaheadSuccess -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a5 A[RETURN] */
    private final boolean O000o00o() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            Token token2 = this.O0000Oo;
            if (!O00000o0(72)) {
                if (!O00Oo0oO()) {
                    z = false;
                    if (z) {
                        this.O0000Oo = token2;
                        if (!O00000o0(72)) {
                            if (!O00OOo()) {
                                if (!O00000o0(76)) {
                                    if (!O00000o0(77)) {
                                        z3 = false;
                                        if (z3) {
                                            this.O0000Oo = token2;
                                            if (!O00000o0(72)) {
                                                if (!O00OOo()) {
                                                    if (!O00000o0(73)) {
                                                        Token token3 = this.O0000Oo;
                                                        if (O00000o0(87)) {
                                                            this.O0000Oo = token3;
                                                            if (O00000o0(86)) {
                                                                this.O0000Oo = token3;
                                                                if (O00000o0(72)) {
                                                                    this.O0000Oo = token3;
                                                                    if (O00000o0(69)) {
                                                                        this.O0000Oo = token3;
                                                                        if (O00000o0(40)) {
                                                                            this.O0000Oo = token3;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z4 = false;
                                                        if (z4) {
                                                            z2 = true;
                                                            return !z2;
                                                        }
                                                    }
                                                }
                                            }
                                            z4 = true;
                                            if (z4) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
            z = true;
            if (z) {
            }
            z2 = false;
            if (!z2) {
            }
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (O00000o0(101) != false) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e A[RETURN] */
    private final boolean O000o0() {
        boolean z;
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            if (!O00oo000()) {
                Token token2 = this.O0000Oo;
                if (O00000o0(100)) {
                    this.O0000Oo = token2;
                }
                z = false;
                return z;
            }
            z = true;
            if (z) {
            }
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o0O0() {
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !(O00000o0(72) || O00Oo0oO());
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000o0O() {
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            return !O00o0O0();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[RETURN] */
    private final boolean O000o0OO() {
        boolean z;
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            if (!O00OoOO()) {
                if (!O00000o0(80)) {
                    if (!O00000o0(13)) {
                        z = false;
                        return z;
                    }
                }
            }
            z = true;
            if (z) {
            }
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029 A[RETURN] */
    private final boolean O000oO0o() {
        boolean z;
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            O00o0O();
            Token token2 = this.O0000Oo;
            if (O00000o0(13)) {
                this.O0000Oo = token2;
                if (O00000o0(37)) {
                    z = true;
                    return z;
                }
            }
            z = false;
            if (z) {
            }
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[RETURN] */
    private final boolean O000oO() {
        boolean z;
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            O00o0O();
            if (!O00Oo()) {
                if (!O00000o0(69)) {
                    if (!O00000o0(72)) {
                        z = false;
                        return z;
                    }
                }
            }
            z = true;
            if (z) {
            }
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037 A[Catch:{ LookaheadSuccess -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[RETURN] */
    private final boolean O000oOO0() {
        boolean z;
        boolean z2;
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            O00o0O();
            if (!O00000o0(69)) {
                if (!O00Ooo0O()) {
                    Token token2 = this.O0000Oo;
                    if (!O00000o0(54)) {
                        if (!O00OO0o()) {
                            z2 = false;
                            if (z2) {
                                this.O0000Oo = token2;
                            }
                            if (!O00000o0(74)) {
                                z = false;
                                if (z) {
                                    return true;
                                }
                                return false;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                    if (!O00000o0(74)) {
                    }
                }
            }
            z = true;
            if (z) {
            }
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oOO() {
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            O00o0O();
            return !(O00OoOO() || O00000o0(69));
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    private final boolean O000oOo() {
        this.O0000Ooo = Integer.MAX_VALUE;
        Token token = this.O00000oO;
        this.O0000Oo = token;
        this.O0000OoO = token;
        try {
            O00o0O();
            return !(O00OoOO() || O00000o0(69));
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (O00000o0(37) != false) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[RETURN] */
    private final boolean O000oOoO() {
        boolean z;
        O00o0O();
        Token token = this.O0000Oo;
        if (O00000o0(13)) {
            this.O0000Oo = token;
        }
        if (!O00000o0(69)) {
            Token token2 = this.O0000Oo;
            if (O00000o0(25) || O00OOo()) {
                this.O0000Oo = token2;
            }
            Token token3 = this.O0000Oo;
            if (O00000o0(33) || O00OO0o()) {
                this.O0000Oo = token3;
            }
            if (!O000oo0o()) {
                z = false;
                return !z;
            }
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (O00000o0(107) != false) goto L_0x0024;
     */
    private final boolean O000oo0O() {
        Token token;
        boolean z;
        if (O00oO00()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(106)) {
                this.O0000Oo = token;
            }
            if (!O00oO00()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    private final boolean O000oo() {
        Token token;
        boolean z;
        if (O000oo0O()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (!O00000o0(110) && !O000oo0O()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (O00000o0(109) != false) goto L_0x0024;
     */
    private final boolean O000ooOO() {
        Token token;
        boolean z;
        if (O000oo()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(108)) {
                this.O0000Oo = token;
            }
            if (!O000oo()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    private final boolean O000ooOo() {
        boolean z;
        Token token;
        boolean z2;
        if (!O00000o0(56) && !O000oo0o()) {
            do {
                token = this.O0000Oo;
                if (!O00000o0(16) && !O00000o0(72) && !O00Ooo0() && !O00000o0(73) && !O000oo0o()) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
            } while (!z2);
            this.O0000Oo = token;
            Token token2 = this.O0000Oo;
            if (O00000o0(28) || O000oo0o()) {
                this.O0000Oo = token2;
            }
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private final boolean O000ooo0() {
        return O00000o0(53) || O00O0ooO() || O00000o0(78);
    }

    private final boolean O000ooo() {
        return O00000o0(51) || O00000o0(72) || O00O0ooO() || O00000o0(73) || O000oo0o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[RETURN] */
    private final boolean O000oooO() {
        boolean z;
        if (!O00000o0(46)) {
            Token token = this.O0000Oo;
            if (O00O0ooO()) {
                this.O0000Oo = token;
            }
            if (!O00000o0(78)) {
                z = false;
                return !z;
            }
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (O00000o0(99) != false) goto L_0x0024;
     */
    private final boolean O000oooo() {
        Token token;
        boolean z;
        if (O000ooOO()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(98)) {
                this.O0000Oo = token;
            }
            if (!O000ooOO()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[RETURN] */
    private final boolean oooOoO() {
        boolean z;
        if (!O00000o0(19)) {
            Token token = this.O0000Oo;
            if (O00000o0(69)) {
                this.O0000Oo = token;
            }
            if (!O00000o0(78)) {
                z = false;
                return !z;
            }
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[RETURN] */
    private final boolean O00oOOoo() {
        boolean z;
        if (!O00000o0(12)) {
            Token token = this.O0000Oo;
            if (O00000o0(69)) {
                this.O0000Oo = token;
            }
            if (!O00000o0(78)) {
                z = false;
                return !z;
            }
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A[RETURN] */
    private final boolean O00O000o() {
        boolean z;
        Token token = this.O0000Oo;
        if (O00o0O00()) {
            this.O0000Oo = token;
            if (O00000o0(30) || O00000o0(72) || O00OoOO() || O00000o0(69) || O00000o0(89) || O00O0ooO() || O00000o0(73) || O00O0Ooo()) {
                z = true;
                return !z;
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[RETURN] */
    private final boolean O00O00Oo() {
        boolean z;
        boolean z2;
        if (!O00000o0(30) && !O00000o0(72)) {
            Token token = this.O0000Oo;
            if (O00o00Oo()) {
                this.O0000Oo = token;
                if (O00o00O0()) {
                    z2 = true;
                    if (z2) {
                        this.O0000Oo = token;
                    }
                    if (!O00000o0(78)) {
                        Token token2 = this.O0000Oo;
                        if (O00O0ooO()) {
                            this.O0000Oo = token2;
                        }
                        if (!O00000o0(78)) {
                            Token token3 = this.O0000Oo;
                            if (O00o00O0()) {
                                this.O0000Oo = token3;
                            }
                            if (!O00000o0(73) && !O00O0Ooo()) {
                                z = false;
                                return !z;
                            }
                        }
                    }
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!O00000o0(78)) {
            }
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (O00000o0(97) != false) goto L_0x0024;
     */
    private final boolean O00O00o0() {
        Token token;
        boolean z;
        if (O000oooo()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(96)) {
                this.O0000Oo = token;
            }
            if (!O000oooo()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00O00o() {
        return O00000o0(21) || O00O0Ooo() || O00000o0(59) || O00000o0(72) || O00O0ooO() || O00000o0(73) || O00000o0(78);
    }

    private final boolean O00O00oO() {
        return O00000o0(59) || O00000o0(72) || O00O0ooO() || O00000o0(73) || O00O0Ooo();
    }

    private final boolean O00O00oo() {
        boolean z;
        if (!O00000o0(32) && !O00000o0(72) && !O00O0ooO() && !O00000o0(73) && !O00O0Ooo()) {
            Token token = this.O0000Oo;
            if (O00000o0(23) || O00O0Ooo()) {
                this.O0000Oo = token;
            }
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[LOOP:1: B:31:0x006b->B:32:0x0071, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087 A[RETURN] */
    private final boolean O00O0OO() {
        boolean z;
        Token token;
        boolean z2;
        boolean z3;
        Token token2;
        if (!O00000o0(50) && !O00000o0(72) && !O00O0ooO() && !O00000o0(73) && !O00000o0(74)) {
            do {
                token = this.O0000Oo;
                if (O00000o0(15) || O00O0ooO() || O00000o0(89)) {
                    this.O0000Oo = token;
                    if (O00000o0(20) || O00000o0(89)) {
                        z2 = true;
                        if (!z2) {
                            z3 = true;
                            continue;
                        } else {
                            do {
                                token2 = this.O0000Oo;
                            } while (!O00o0O0o());
                            this.O0000Oo = token2;
                            z3 = false;
                            continue;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                }
            } while (!z3);
            this.O0000Oo = token;
            if (!O00000o0(75)) {
                z = false;
                return !z;
            }
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028 A[RETURN] */
    private final boolean O00O0oo0() {
        boolean z;
        Token token;
        Token token2 = this.O0000Oo;
        if (O00O0oOo()) {
            this.O0000Oo = token2;
            if (!O00O0o0o()) {
                do {
                    token = this.O0000Oo;
                } while (!O00O0o0o());
                this.O0000Oo = token;
                if (!O00OooO()) {
                    z = false;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return false;
    }

    private final boolean O00OOo0() {
        boolean z;
        Token token;
        boolean z2;
        if (O00000o0(72)) {
            return true;
        }
        Token token2 = this.O0000Oo;
        if (O00O0ooO()) {
            z = true;
        } else {
            do {
                token = this.O0000Oo;
                if (!O00000o0(79) && !O00O0ooO()) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
            } while (!z2);
            this.O0000Oo = token;
            z = false;
        }
        if (z) {
            this.O0000Oo = token2;
        }
        return O00000o0(73);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c A[RETURN] */
    private final boolean O00Ooo() {
        boolean z;
        Token token = this.O0000Oo;
        if (O00000o0(55)) {
            this.O0000Oo = token;
            if (O00000o0(26)) {
                z = true;
                return !z;
            }
        }
        z = false;
        if (!z) {
        }
    }

    private final boolean O00Ooo00() {
        Token token;
        boolean z;
        if (O00Ooo0()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (!O00000o0(79) && !O00Ooo0()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    private final boolean O00o00OO() {
        Token token = this.O0000Oo;
        if (O00o00O()) {
            this.O0000Oo = token;
            if (O00000o0(34) || O00000o0(104) || O00000o0(78)) {
                return true;
            }
        }
        return false;
    }

    private final boolean O00o00oO() {
        O00o0O();
        Token token = this.O0000Oo;
        if (O00000o0(69)) {
            this.O0000Oo = token;
            if (O00Oo() || O00000o0(69)) {
                return true;
            }
        }
        if (O00Ooo0O()) {
            return true;
        }
        Token token2 = this.O0000Oo;
        if (O00000o0(54) || O00OO0o()) {
            this.O0000Oo = token2;
        }
        Token token3 = this.O0000Oo;
        if (O000oo0o()) {
            this.O0000Oo = token3;
            if (O00000o0(78)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070 A[RETURN] */
    private final boolean O00o00oo() {
        boolean z;
        boolean z2;
        Token token = this.O0000Oo;
        if (O00o00o()) {
            this.O0000Oo = token;
            if (O00000o0(76) || O00O0ooO() || O00000o0(77)) {
                this.O0000Oo = token;
                if (!O00000o0(80) && !O00000o0(69)) {
                    Token token2 = this.O0000Oo;
                    if (O00OOo0()) {
                        this.O0000Oo = token2;
                    }
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    this.O0000Oo = token;
                    if (O00000o0(74) || O00O0ooO() || O00000o0(75)) {
                        z = true;
                        return !z;
                    }
                }
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r1 != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e  */
    private final boolean O00o0() {
        boolean z;
        boolean z2;
        boolean z3;
        Token token = this.O0000Oo;
        if (O00o000O()) {
            this.O0000Oo = token;
            if (O00000o0(72) || O00O0ooO() || O00000o0(73)) {
                this.O0000Oo = token;
                Token token2 = this.O0000Oo;
                if (O00OO0O()) {
                    this.O0000Oo = token2;
                    if (!O00000o0(40) && !O00OOo()) {
                        Token token3 = this.O0000Oo;
                        if (O00O0oo0()) {
                            this.O0000Oo = token3;
                            if (O00OOo0()) {
                                z3 = true;
                            } else {
                                Token token4 = this.O0000Oo;
                                if (O00O0Oo0()) {
                                    this.O0000Oo = token4;
                                }
                                z3 = false;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            z = true;
                            if (z) {
                                this.O0000Oo = token;
                                if (O00o0O0()) {
                                    this.O0000Oo = token;
                                    if (O00OoOO()) {
                                        this.O0000Oo = token;
                                        if (O00OOo()) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                z = false;
                if (z) {
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (O00000o0(101) != false) goto L_0x000a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    private final boolean O00o0OO0() {
        boolean z;
        boolean z2;
        Token token = this.O0000Oo;
        if (!O00oo000()) {
            Token token2 = this.O0000Oo;
            if (O00000o0(100)) {
                this.O0000Oo = token2;
            }
            z = false;
            if (z) {
                this.O0000Oo = token;
                if (O00oo000()) {
                    z2 = true;
                    return z2;
                }
            }
            z2 = false;
            if (z2) {
            }
        }
        z = true;
        if (z) {
        }
        z2 = false;
        if (z2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[RETURN] */
    private final boolean O00o0OO() {
        boolean z;
        Token token = this.O0000Oo;
        if (O00000o0(72) || O00OoOO() || O00000o0(73) || O00o0o00()) {
            this.O0000Oo = token;
            if (O00000o0(72) || O00OoOO() || O00000o0(73) || O00o0OOo()) {
                z = true;
                return !z;
            }
        }
        z = false;
        if (!z) {
        }
    }

    private final boolean O00o0Oo() {
        return O00000o0(101) || O00oo000();
    }

    private final boolean O00o0OoO() {
        return O00000o0(100) || O00oo000();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (O00000o0(111) != false) goto L_0x002e;
     */
    private final boolean O00o0o0O() {
        Token token;
        boolean z;
        if (O00o0o00()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(104)) {
                this.O0000Oo = token;
                if (O00000o0(105)) {
                    this.O0000Oo = token;
                }
            }
            if (!O00o0o00()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (O00000o0(103) != false) goto L_0x0024;
     */
    private final boolean O00o0o0o() {
        Token token;
        boolean z;
        if (O00o0o0O()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(102)) {
                this.O0000Oo = token;
            }
            if (!O00o0o0O()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (O00000o0(117) != false) goto L_0x004c;
     */
    private final boolean O00o0oO() {
        Token token;
        boolean z;
        if (O00o0o0o()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(112)) {
                this.O0000Oo = token;
                if (O00000o0(113)) {
                    this.O0000Oo = token;
                    if (O00000o0(114)) {
                        this.O0000Oo = token;
                        if (O00000o0(115)) {
                            this.O0000Oo = token;
                            if (O00000o0(116)) {
                                this.O0000Oo = token;
                            }
                        }
                    }
                }
            }
            if (!O00o0o0o()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (O00000o0(94) != false) goto L_0x0060;
     */
    private final boolean O00o0oo0() {
        Token token;
        boolean z;
        if (O00o0oO()) {
            return true;
        }
        do {
            token = this.O0000Oo;
            if (O00000o0(84)) {
                this.O0000Oo = token;
                if (O00000o0(85)) {
                    this.O0000Oo = token;
                    if (O00000o0(82)) {
                        this.O0000Oo = token;
                        if (O00000o0(83)) {
                            this.O0000Oo = token;
                            if (O00000o0(91)) {
                                this.O0000Oo = token;
                                if (O00000o0(92)) {
                                    this.O0000Oo = token;
                                    if (O00000o0(93)) {
                                        this.O0000Oo = token;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!O00o0oO()) {
                z = false;
                continue;
            }
            z = true;
            continue;
        } while (!z);
        this.O0000Oo = token;
        return false;
    }
}
