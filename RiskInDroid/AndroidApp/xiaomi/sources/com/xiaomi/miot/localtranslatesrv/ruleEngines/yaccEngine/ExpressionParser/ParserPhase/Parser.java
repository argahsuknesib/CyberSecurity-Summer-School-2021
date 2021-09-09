package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserPhase;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.LexerPhase.YylexImpl;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.ArithmeticOpExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.ArrayConstructExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.AttrGetExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Expr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.FalseExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.FuncCallExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.IdentExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.IfExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.LogicalExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.MapConstructExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.MapItemExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.NumberExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.StringExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.TrueExpr;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class Parser {
    static short[] yycheck;
    static final short[] yydefred = {0, 0, 10, 11, 0, 8, 9, 0, 0, 0, 0, 0, 0, 0, 34, 33, 0, 0, 36, 0, 0, 41, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 0, 35, 0, 0, 30, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 24, 25, 0, 0, 38, 0, 42, 40, 0, 0, 31, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, 0, 32};
    static final short[] yydgoto = {11, 12, 13, 14, 15, 21, 71, 22, 18, 0, 0};
    static final short[] yygindex = {-5, 548, 0, 0, 0, -16, 0, 0, 0, 0, 0};
    static final short[] yylen = {2, 0, 2, 1, 1, 2, 1, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 1, 8, 12, 3, 3, 0, 9, 1, 1, 3, 2, 2, 3, 1, 4, 1, 3, 3};
    static final short[] yylhs = {-1, 9, 9, 10, 10, 10, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 6, 2, 2, 2, 3, 8, 8, 4, 4, 7, 7, 5};
    static final String[] yyname = {"end-of-file", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "'%'", 0, 0, "'('", "')'", "'*'", "'+'", "','", "'-'", 0, "'/'", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "':'", 0, "'<'", 0, "'>'", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "'['", 0, "']'", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "'{'", 0, "'}'", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "NL", "TIf", "TElse", "TEqeq", "TNeq", "TGteq", "TLteq", "TAnd", "TOr", "TTrue", "TFalse", "TIdent", "TString", "TNumber", "UNARY"};
    static final short[] yyrindex = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 105, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 139, 25, 93, 101, 113, 124, 144, 143, 167, 65, 71, 0, 0, 0, 0, 0, 0, -37, 0, 0, 0, 0, 0, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final String[] yyrule = {"$accept : exprlist", "input :", "input : input line", "line : NL", "line : exprlist", "line : expr NL", "exprlist : expr", "exprlist : exprlist ',' expr", "expr : TString", "expr : TNumber", "expr : TTrue", "expr : TFalse", "expr : expr TOr expr", "expr : expr TAnd expr", "expr : expr '>' expr", "expr : expr '<' expr", "expr : expr TGteq expr", "expr : expr TLteq expr", "expr : expr TEqeq expr", "expr : expr TNeq expr", "expr : expr '+' expr", "expr : expr '-' expr", "expr : '-' expr", "expr : expr '*' expr", "expr : expr '/' expr", "expr : expr '%' expr", "expr : prefixexp", "expr : TIf '(' expr ')' '{' expr '}' elseifs", "expr : TIf '(' expr ')' '{' expr '}' elseifs TElse '{' expr '}'", "expr : '[' exprlist ']'", "expr : '{' mapitemlist '}'", "elseifs :", "elseifs : elseifs TElse TIf '(' expr ')' '{' expr '}'", "prefixexp : var", "prefixexp : functioncall", "prefixexp : '(' expr ')'", "functioncall : TIdent args", "args : '(' ')'", "args : '(' exprlist ')'", "var : TIdent", "var : prefixexp '[' expr ']'", "mapitemlist : mapitem", "mapitemlist : mapitemlist ',' mapitem", "mapitem : expr ':' expr"};
    static final short[] yysindex = {129, -38, 0, 0, -32, 0, 0, 129, 129, 129, 129, -29, 456, -71, 0, 0, 129, -27, 0, 277, 375, 0, -39, -44, 0, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 397, 0, -35, 0, 129, 129, 0, 0, 456, -26, -26, -26, -26, 484, 468, -26, -26, -15, -15, 0, 0, 0, 404, -100, 0, 456, 0, 0, 129, 411, 0, -235, -120, -14, 129, 129, 418, 440, 0, -95, 129, 447, 0};
    static short[] yytable;
    private YylexImpl lexer;
    int statemax;
    int stateptr;
    int stateptrmax;
    int[] statestk;
    private String stringCode;
    int valptr;
    ParserVal[] valstk;
    int yychar;
    boolean yydebug;
    int yyerrflag;
    ParserVal yylval;
    int yym;
    int yyn;
    int yynerrs;
    String yys;
    int yystate;
    String yytext;
    ParserVal yyval;

    /* access modifiers changed from: package-private */
    public void debug(String str) {
        if (this.yydebug) {
            System.out.println(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void state_push(int i) {
        try {
            this.stateptr++;
            this.statestk[this.stateptr] = i;
        } catch (ArrayIndexOutOfBoundsException unused) {
            int[] iArr = this.statestk;
            int length = iArr.length;
            int[] iArr2 = new int[(length * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            this.statestk = iArr2;
            this.statestk[this.stateptr] = i;
        }
    }

    /* access modifiers changed from: package-private */
    public final int state_pop() {
        int[] iArr = this.statestk;
        int i = this.stateptr;
        this.stateptr = i - 1;
        return iArr[i];
    }

    /* access modifiers changed from: package-private */
    public final void state_drop(int i) {
        this.stateptr -= i;
    }

    /* access modifiers changed from: package-private */
    public final int state_peek(int i) {
        return this.statestk[this.stateptr - i];
    }

    /* access modifiers changed from: package-private */
    public final boolean init_stacks() {
        this.stateptr = -1;
        val_init();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void dump_stacks(int i) {
        PrintStream printStream = System.out;
        printStream.println("=index==state====value=     s:" + this.stateptr + "  v:" + this.valptr);
        for (int i2 = 0; i2 < i; i2++) {
            PrintStream printStream2 = System.out;
            printStream2.println(" " + i2 + "    " + this.statestk[i2] + "      " + this.valstk[i2]);
        }
        System.out.println("======================");
    }

    /* access modifiers changed from: package-private */
    public void val_init() {
        this.valstk = new ParserVal[500];
        this.yyval = new ParserVal();
        this.yylval = new ParserVal();
        this.valptr = -1;
    }

    /* access modifiers changed from: package-private */
    public void val_push(ParserVal parserVal) {
        int i = this.valptr;
        if (i < 500) {
            ParserVal[] parserValArr = this.valstk;
            int i2 = i + 1;
            this.valptr = i2;
            parserValArr[i2] = parserVal;
        }
    }

    /* access modifiers changed from: package-private */
    public ParserVal val_pop() {
        int i = this.valptr;
        if (i < 0) {
            return new ParserVal();
        }
        ParserVal[] parserValArr = this.valstk;
        this.valptr = i - 1;
        return parserValArr[i];
    }

    /* access modifiers changed from: package-private */
    public void val_drop(int i) {
        int i2 = this.valptr - i;
        if (i2 >= 0) {
            this.valptr = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public ParserVal val_peek(int i) {
        int i2 = this.valptr - i;
        if (i2 < 0) {
            return new ParserVal();
        }
        return this.valstk[i2];
    }

    /* access modifiers changed from: package-private */
    public final ParserVal dup_yyval(ParserVal parserVal) {
        ParserVal parserVal2 = new ParserVal();
        parserVal2.ival = parserVal.ival;
        parserVal2.dval = parserVal.dval;
        parserVal2.sval = parserVal.sval;
        parserVal2.obj = parserVal.obj;
        parserVal2.setToken(parserVal.getToken());
        parserVal2.setExpr(parserVal.getExpr());
        parserVal2.setExprs(parserVal.getExprs());
        return parserVal2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        yytable();
        yycheck();
    }

    static void yytable() {
        yytable = new short[]{25, 39, 16, 74, 23, 45, 64, 43, 17, 25, 26, 38, 42, 7, 41, 25, 36, 34, 10, 35, 39, 37, 38, 68, 72, 18, 75, 36, 80, 66, 0, 0, 37, 0, 0, 0, 0, 27, 39, 0, 0, 0, 39, 39, 39, 39, 39, 26, 39, 47, 0, 26, 26, 26, 26, 26, 0, 26, 0, 39, 0, 39, 0, 39, 9, 20, 18, 0, 26, 18, 26, 21, 26, 0, 27, 0, 0, 0, 27, 27, 27, 27, 27, 18, 27, 18, 46, 18, 43, 0, 0, 0, 39, 19, 39, 27, 8, 27, 0, 27, 0, 16, 0, 26, 0, 6, 20, 0, 20, 20, 20, 0, 21, 17, 21, 21, 21, 0, 18, 0, 0, 0, 0, 20, 13, 20, 39, 20, 0, 21, 27, 21, 0, 21, 19, 26, 0, 19, 73, 7, 0, 0, 16, 14, 12, 16, 6, 0, 0, 6, 18, 19, 0, 19, 17, 19, 0, 17, 20, 16, 0, 16, 27, 16, 21, 13, 0, 15, 13, 7, 0, 17, 0, 17, 10, 17, 0, 0, 0, 0, 7, 0, 13, 7, 14, 12, 19, 14, 12, 0, 20, 0, 0, 0, 16, 0, 21, 0, 6, 0, 0, 14, 12, 14, 0, 14, 17, 0, 15, 0, 0, 15, 0, 0, 0, 0, 0, 13, 19, 0, 9, 0, 0, 0, 0, 15, 16, 15, 0, 15, 0, 1, 7, 0, 0, 0, 14, 12, 17, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 13, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 15, 39, 39, 39, 39, 39, 39, 0, 14, 12, 26, 26, 26, 26, 26, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 18, 18, 18, 18, 18, 0, 15, 0, 0, 0, 0, 27, 27, 27, 27, 27, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 43, 36, 34, 0, 35, 0, 37, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 33, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 19, 19, 19, 19, 0, 0, 16, 16, 16, 16, 16, 16, 0, 0, 0, 0, 0, 0, 17, 17, 17, 17, 17, 17, 0, 0, 0, 0, 0, 0, 0, 0, 1, 13, 13, 0, 0, 0, 0, 0, 2, 3, 4, 5, 6, 0, 0, 0, 14, 14, 14, 14, 14, 14, 12, 0, 0, 38, 0, 0, 0, 0, 36, 34, 0, 35, 0, 37, 0, 0, 0, 0, 15, 15, 15, 15, 15, 15, 44, 38, 33, 0, 32, 63, 36, 34, 38, 35, 0, 37, 0, 36, 34, 38, 35, 0, 37, 0, 36, 34, 38, 35, 33, 37, 32, 36, 34, 0, 35, 33, 37, 32, 0, 0, 0, 0, 33, 0, 32, 0, 0, 0, 38, 33, 0, 32, 79, 36, 34, 38, 35, 0, 37, 0, 36, 34, 0, 35, 38, 37, 0, 0, 67, 36, 34, 33, 35, 32, 37, 0, 38, 0, 33, 0, 32, 36, 34, 0, 35, 0, 37, 33, 0, 32, 0, 0, 38, 0, 0, 0, 0, 36, 34, 33, 35, 32, 37, 0, 0, 0, 0, 70, 26, 27, 28, 29, 30, 31, 78, 33, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 19, 20, 0, 24, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 82, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 0, 0, 0, 0, 65, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 69, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 81, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 0, 26, 27, 28, 29, 30, 31, 0, 26, 27, 28, 29, 30, 31, 0, 26, 27, 28, 29, 30, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 0, 26, 27, 28, 29, 30, 31, 0, 0, 0, 26, 27, 28, 29, 30, 31, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29};
    }

    static void yycheck() {
        yycheck = new short[]{44, 0, 40, 123, 9, 44, 41, 44, 40, 44, 0, 37, 17, 40, 41, 44, 42, 43, 45, 45, 91, 47, 37, 123, 259, 0, 40, 42, 123, 45, -1, -1, 47, -1, -1, -1, -1, 0, 37, -1, -1, -1, 41, 42, 43, 44, 45, 37, 47, 93, -1, 41, 42, 43, 44, 45, -1, 47, -1, 58, -1, 60, -1, 62, 91, 0, 41, -1, 58, 44, 60, 0, 62, -1, 37, -1, -1, -1, 41, 42, 43, 44, 45, 58, 47, 60, 125, 62, 125, -1, -1, -1, 91, 0, 93, 58, 123, 60, -1, 62, -1, 0, -1, 93, -1, 0, 41, -1, 43, 44, 45, -1, 41, 0, 43, 44, 45, -1, 93, -1, -1, -1, -1, 58, 0, 60, 125, 62, -1, 58, 93, 60, -1, 62, 41, 125, -1, 44, 258, 0, -1, -1, 41, 0, 0, 44, 41, -1, -1, 44, 125, 58, -1, 60, 41, 62, -1, 44, 93, 58, -1, 60, 125, 62, 93, 41, -1, 0, 44, 40, -1, 58, -1, 60, 45, 62, -1, -1, -1, -1, 41, -1, 58, 44, 41, 41, 93, 44, 44, -1, 125, -1, -1, -1, 93, -1, 125, -1, 93, -1, -1, 58, 58, 60, -1, 62, 93, -1, 41, -1, -1, 44, -1, -1, -1, -1, -1, 93, 125, -1, 91, -1, -1, -1, -1, 58, 125, 60, -1, 62, -1, 258, 93, -1, -1, -1, 93, 93, 125, 266, 267, 268, 269, 270, -1, -1, -1, -1, -1, 125, -1, -1, 123, -1, -1, -1, -1, -1, -1, -1, 93, 260, 261, 262, 263, 264, 265, -1, 125, 125, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, 125, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, 41, 42, 43, -1, 45, -1, 47, 260, 261, 262, 263, 264, 265, 260, 261, 262, 263, 264, 265, 60, -1, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, -1, -1, 258, 264, 265, -1, -1, -1, -1, -1, 266, 267, 268, 269, 270, -1, -1, -1, 260, 261, 262, 263, 264, 265, 265, -1, -1, 37, -1, -1, -1, -1, 42, 43, -1, 45, -1, 47, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, 58, 37, 60, -1, 62, 41, 42, 43, 37, 45, -1, 47, -1, 42, 43, 37, 45, -1, 47, -1, 42, 43, 37, 45, 60, 47, 62, 42, 43, -1, 45, 60, 47, 62, -1, -1, -1, -1, 60, -1, 62, -1, -1, -1, 37, 60, -1, 62, 41, 42, 43, 37, 45, -1, 47, -1, 42, 43, -1, 45, 37, 47, -1, -1, 93, 42, 43, 60, 45, 62, 47, -1, 37, -1, 60, -1, 62, 42, 43, -1, 45, -1, 47, 60, -1, 62, -1, -1, 37, -1, -1, -1, -1, 42, 43, 60, 45, 62, 47, -1, -1, -1, -1, 125, 260, 261, 262, 263, 264, 265, 125, 60, -1, 62, -1, -1, -1, -1, -1, -1, -1, -1, 7, 8, -1, 10, -1, -1, -1, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, 125, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, -1, -1, -1, -1, 44, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 68, -1, -1, -1, -1, -1, 74, 75, -1, -1, -1, -1, 80, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, 260, 261, 262, 263, 264, 265, -1, 260, 261, 262, 263, 264, 265, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, 260, 261, 262, 263, 264, 265, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263, 264, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 260, 261, 262, 263};
    }

    public String TokenName(int i) {
        if (i >= 264) {
            int i2 = i - 264;
            String[] strArr = yyname;
            if (i2 < strArr.length && strArr[i2] != null) {
                return new String(strArr[i2]);
            }
        }
        return new String(String.valueOf(i));
    }

    private int yylex() {
        this.yylval = new ParserVal();
        this.yylval.setToken(this.lexer.yylex());
        return this.yylval.getToken().getType();
    }

    public void setCodeString(String str) {
        this.stringCode = str;
    }

    public ParserVal executeParser() {
        this.lexer = new YylexImpl(this.stringCode);
        yyparse();
        return this.yyval;
    }

    public void yyerror(String str) {
        System.err.println("Error: ".concat(String.valueOf(str)));
    }

    public Parser(Reader reader, boolean z) {
        this(z);
        this.lexer = new YylexImpl(reader);
    }

    /* access modifiers changed from: package-private */
    public void yylexdebug(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        String str = i2 <= 271 ? yyname[i2] : null;
        if (str == null) {
            str = "illegal-symbol";
        }
        debug("state " + i + ", reading " + i2 + " (" + str + ")");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:226:0x0474 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0785  */
    public int yyparse() {
        IfExpr ifExpr;
        int i;
        int i2;
        int i3;
        int i4;
        init_stacks();
        this.yynerrs = 0;
        this.yyerrflag = 0;
        this.yychar = -1;
        this.yystate = 0;
        state_push(this.yystate);
        val_push(this.yylval);
        while (true) {
            if (this.yydebug) {
                debug("loop");
            }
            this.yyn = yydefred[this.yystate];
            boolean z = true;
            while (true) {
                ifExpr = null;
                if (this.yyn == 0) {
                    if (this.yydebug) {
                        debug("yyn:" + this.yyn + "  state:" + this.yystate + "  yychar:" + this.yychar);
                    }
                    if (this.yychar < 0) {
                        this.yychar = yylex();
                        if (this.yydebug) {
                            debug(" next yychar:" + this.yychar);
                        }
                        if (this.yychar < 0) {
                            this.yychar = 0;
                            if (this.yydebug) {
                                yylexdebug(this.yystate, this.yychar);
                            }
                        }
                    }
                    this.yyn = yysindex[this.yystate];
                    int i5 = this.yyn;
                    if (i5 != 0) {
                        int i6 = this.yychar;
                        int i7 = i5 + i6;
                        this.yyn = i7;
                        if (i7 >= 0 && (i4 = this.yyn) <= 747 && yycheck[i4] == i6) {
                            if (this.yydebug) {
                                debug("state " + this.yystate + ", shifting to state " + ((int) yytable[this.yyn]));
                            }
                            this.yystate = yytable[this.yyn];
                            state_push(this.yystate);
                            val_push(this.yylval);
                            this.yychar = -1;
                            int i8 = this.yyerrflag;
                            if (i8 > 0) {
                                this.yyerrflag = i8 - 1;
                            }
                            z = false;
                        }
                    }
                    this.yyn = yyrindex[this.yystate];
                    int i9 = this.yyn;
                    if (i9 != 0) {
                        int i10 = this.yychar;
                        int i11 = i9 + i10;
                        this.yyn = i11;
                        if (i11 >= 0 && (i3 = this.yyn) <= 747 && yycheck[i3] == i10) {
                            if (this.yydebug) {
                                debug("reduce");
                            }
                            this.yyn = yytable[this.yyn];
                            z = true;
                        }
                    }
                    if (this.yyerrflag == 0) {
                        yyerror("syntax error");
                        this.yynerrs++;
                    }
                    if (this.yyerrflag < 3) {
                        this.yyerrflag = 3;
                        while (this.stateptr >= 0) {
                            this.yyn = yysindex[state_peek(0)];
                            int i12 = this.yyn;
                            if (i12 != 0) {
                                int i13 = i12 + 256;
                                this.yyn = i13;
                                if (i13 >= 0 && (i2 = this.yyn) <= 747 && yycheck[i2] == 256) {
                                    if (this.yydebug) {
                                        debug("state " + state_peek(0) + ", error recovery shifting to state " + ((int) yytable[this.yyn]) + " ");
                                    }
                                    this.yystate = yytable[this.yyn];
                                    state_push(this.yystate);
                                    val_push(this.yylval);
                                    z = false;
                                }
                            }
                            if (this.yydebug) {
                                debug("error recovery discarding state " + state_peek(0) + " ");
                            }
                            if (this.stateptr < 0) {
                                yyerror("Stack underflow. aborting...");
                                return 1;
                            }
                            state_pop();
                            val_pop();
                        }
                        yyerror("stack underflow. aborting...");
                        return 1;
                    }
                    int i14 = this.yychar;
                    if (i14 == 0) {
                        return 1;
                    }
                    if (this.yydebug) {
                        this.yys = null;
                        if (i14 <= 271) {
                            this.yys = yyname[i14];
                        }
                        if (this.yys == null) {
                            this.yys = "illegal-symbol";
                        }
                        debug("state " + this.yystate + ", error recovery discards token " + this.yychar + " (" + this.yys + ")");
                    }
                    this.yychar = -1;
                    this.yyn = yydefred[this.yystate];
                }
            }
            if (z) {
                this.yym = yylen[this.yyn];
                if (this.yydebug) {
                    debug("state " + this.yystate + ", reducing " + this.yym + " by rule " + this.yyn + " (" + yyrule[this.yyn] + ")");
                }
                int i15 = this.yym;
                if (i15 > 0) {
                    this.yyval = val_peek(i15 - 1);
                }
                this.yyval = dup_yyval(this.yyval);
                switch (this.yyn) {
                    case 3:
                        System.out.print("Expression should not come here ！ ");
                        break;
                    case 5:
                        System.out.print("Expression should not come here ！ ");
                        break;
                    case 6:
                        this.yyval.setExprs(new Expr[]{val_peek(0).getExpr()});
                        break;
                    case 7:
                        Expr[] exprArr = (Expr[]) Arrays.copyOf(val_peek(2).getExprs(), val_peek(2).getExprs().length + 1);
                        exprArr[exprArr.length - 1] = val_peek(0).getExpr();
                        this.yyval.setExprs(exprArr);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        this.yyval.setExpr(new StringExpr(val_peek(0).getToken().getStr()));
                        break;
                    case 9:
                        this.yyval.setExpr(new NumberExpr(Float.parseFloat(val_peek(0).getToken().getStr())));
                        break;
                    case 10:
                        this.yyval.setExpr(new TrueExpr());
                        break;
                    case 11:
                        this.yyval.setExpr(new FalseExpr());
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), "||", val_peek(0).getExpr()));
                        break;
                    case 13:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), "&&", val_peek(0).getExpr()));
                        break;
                    case 14:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), ">", val_peek(0).getExpr()));
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), "<", val_peek(0).getExpr()));
                        break;
                    case 16:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), ">=", val_peek(0).getExpr()));
                        break;
                    case 17:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), "<=", val_peek(0).getExpr()));
                        break;
                    case 18:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), "==", val_peek(0).getExpr()));
                        break;
                    case 19:
                        this.yyval.setExpr(new LogicalExpr(val_peek(2).getExpr(), "!=", val_peek(0).getExpr()));
                        break;
                    case 20:
                        this.yyval.setExpr(new ArithmeticOpExpr(val_peek(2).getExpr(), "+", val_peek(0).getExpr()));
                        break;
                    case 21:
                        this.yyval.setExpr(new ArithmeticOpExpr(val_peek(2).getExpr(), "-", val_peek(0).getExpr()));
                        break;
                    case 22:
                        this.yyval.setExpr(new ArithmeticOpExpr(new NumberExpr(0.0f), "-", val_peek(0).getExpr()));
                        break;
                    case 23:
                        this.yyval.setExpr(new ArithmeticOpExpr(val_peek(2).getExpr(), "*", val_peek(0).getExpr()));
                        break;
                    case 24:
                        this.yyval.setExpr(new ArithmeticOpExpr(val_peek(2).getExpr(), "/", val_peek(0).getExpr()));
                        break;
                    case 25:
                        this.yyval.setExpr(new ArithmeticOpExpr(val_peek(2).getExpr(), "%", val_peek(0).getExpr()));
                        break;
                    case 26:
                        this.yyval.setExpr(val_peek(0).getExpr());
                        break;
                    case 27:
                        this.yyval.setExpr(new IfExpr(val_peek(5).getExpr(), val_peek(2).getExpr(), val_peek(0).getExpr()));
                        break;
                    case 28:
                        this.yyval.setExpr(new IfExpr(val_peek(9).getExpr(), val_peek(6).getExpr(), val_peek(4).getExpr()));
                        IfExpr ifExpr2 = this.yyval.getExpr() instanceof IfExpr ? (IfExpr) this.yyval.getExpr() : null;
                        if (ifExpr2 != null && ifExpr2.getElse() == null) {
                            ifExpr2.setElse(val_peek(1).getExpr());
                        }
                        Expr expr = ifExpr2.getElse();
                        if (expr instanceof IfExpr) {
                            ifExpr = (IfExpr) expr;
                        }
                        boolean z2 = ifExpr instanceof IfExpr;
                        Expr expr2 = expr;
                        while (z2) {
                            if (ifExpr.getElse() == null) {
                                ifExpr.setElse(val_peek(1).getExpr());
                                expr2 = expr2;
                            } else {
                                expr2 = ifExpr.getElse();
                            }
                            if (expr2 instanceof IfExpr) {
                                ifExpr = (IfExpr) expr2;
                            } else {
                                z2 = false;
                            }
                        }
                        break;
                    case 29:
                        this.yyval.setExpr(new ArrayConstructExpr(val_peek(1).getExprs()));
                        break;
                    case 30:
                        this.yyval.setExpr(new MapConstructExpr(val_peek(1).getExprs()));
                        break;
                    case 31:
                        this.yyval.setExpr(null);
                        break;
                    case 32:
                        if (val_peek(8).getExpr() != null) {
                            IfExpr ifExpr3 = val_peek(8).getExpr() instanceof IfExpr ? (IfExpr) val_peek(8).getExpr() : null;
                            while (ifExpr3.getElse() != null) {
                                if (ifExpr3.getElse() instanceof IfExpr) {
                                    ifExpr3 = (IfExpr) ifExpr3.getElse();
                                }
                            }
                            ifExpr3.setElse(new IfExpr(val_peek(4).getExpr(), val_peek(1).getExpr(), null));
                            break;
                        } else {
                            this.yyval.setExpr(new IfExpr(val_peek(4).getExpr(), val_peek(1).getExpr(), null));
                            break;
                        }
                    case 33:
                        this.yyval.setExpr(val_peek(0).getExpr());
                        break;
                    case 34:
                        this.yyval.setExpr(val_peek(0).getExpr());
                        break;
                    case 35:
                        this.yyval.setExpr(val_peek(1).getExpr());
                        break;
                    case 36:
                        this.yyval.setExpr(new FuncCallExpr(new IdentExpr(val_peek(1).getToken().getStr()), val_peek(0).getExprs()));
                        break;
                    case 37:
                        this.yyval.setExprs(new Expr[C.MSG_CUSTOM_BASE]);
                        break;
                    case 38:
                        this.yyval.setExprs(val_peek(1).getExprs());
                        break;
                    case 39:
                        this.yyval.setExpr(new IdentExpr(val_peek(0).getToken().getStr()));
                        break;
                    case 40:
                        this.yyval.setExpr(new AttrGetExpr(val_peek(3).getExpr(), val_peek(1).getExpr()));
                        break;
                    case 41:
                        this.yyval.setExprs(new Expr[]{val_peek(0).getExpr()});
                        break;
                    case 42:
                        Expr[] exprArr2 = (Expr[]) Arrays.copyOf(val_peek(2).getExprs(), val_peek(2).getExprs().length + 1);
                        exprArr2[exprArr2.length - 1] = val_peek(0).getExpr();
                        this.yyval.setExprs(exprArr2);
                        break;
                    case 43:
                        this.yyval.setExpr(new MapItemExpr(val_peek(2).getExpr(), val_peek(0).getExpr()));
                        break;
                }
                if (this.yydebug) {
                    debug("reduce");
                }
                state_drop(this.yym);
                this.yystate = state_peek(0);
                val_drop(this.yym);
                this.yym = yylhs[this.yyn];
                if (this.yystate == 0 && this.yym == 0) {
                    if (this.yydebug) {
                        debug("After reduction, shifting from state 0 to state 11");
                    }
                    this.yystate = 11;
                    state_push(11);
                    val_push(this.yyval);
                    if (this.yychar < 0) {
                        this.yychar = yylex();
                        if (this.yychar < 0) {
                            this.yychar = 0;
                        }
                        if (this.yydebug) {
                            yylexdebug(this.yystate, this.yychar);
                        }
                    }
                    if (this.yychar == 0) {
                        return 0;
                    }
                } else {
                    this.yyn = yygindex[this.yym];
                    int i16 = this.yyn;
                    if (i16 != 0) {
                        int i17 = this.yystate;
                        int i18 = i16 + i17;
                        this.yyn = i18;
                        if (i18 >= 0 && (i = this.yyn) <= 747 && yycheck[i] == i17) {
                            this.yystate = yytable[i];
                            if (this.yydebug) {
                                debug("after reduction, shifting from state " + state_peek(0) + " to state " + this.yystate);
                            }
                            state_push(this.yystate);
                            val_push(this.yyval);
                        }
                    }
                    this.yystate = yydgoto[this.yym];
                    if (this.yydebug) {
                    }
                    state_push(this.yystate);
                    val_push(this.yyval);
                }
            }
        }
    }

    public void run() {
        yyparse();
    }

    public Parser() {
        this.statestk = new int[500];
    }

    public Parser(boolean z) {
        this.statestk = new int[500];
        this.yydebug = z;
    }
}
