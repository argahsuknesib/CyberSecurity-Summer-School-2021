package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.LexerPhase;

import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Token;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YylexImpl {
    private static int READERBUFFERSIZE = 16684;
    private Set<String> calcSets = new HashSet();
    private String initInputString = null;
    private char[] readBuffer = new char[READERBUFFERSIZE];
    private int readEnd = 0;
    private Reader reader;
    ListIterator<String> tokenIter = null;
    private List<String> tokens = null;
    private Map<String, Short> tokensMap = new HashMap();

    public YylexImpl() {
        init_tokenMapandCalcSet();
    }

    public YylexImpl(String str) {
        init_tokenMapandCalcSet();
        this.initInputString = str;
        this.tokens = preProcessToken(this.initInputString);
        List<String> list = this.tokens;
        if (list != null) {
            this.tokenIter = list.listIterator();
        } else {
            System.out.println("tokenIter init failed ! ");
        }
    }

    public YylexImpl(Reader reader2) {
        init_tokenMapandCalcSet();
        this.reader = reader2;
        this.initInputString = readCharsToString();
        this.tokens = preProcessToken(this.initInputString);
        List<String> list = this.tokens;
        if (list != null) {
            this.tokenIter = list.listIterator();
        } else {
            System.out.println("tokenIter init failed ! ");
        }
    }

    private void init_tokenMapandCalcSet() {
        this.tokensMap.put("if", (short) 258);
        this.tokensMap.put("else", (short) 259);
        this.tokensMap.put("&&", (short) 264);
        this.tokensMap.put("==", (short) 260);
        this.tokensMap.put("false", (short) 267);
        this.tokensMap.put("true", (short) 266);
        this.tokensMap.put(">=", (short) 262);
        this.tokensMap.put("<=", (short) 263);
        this.tokensMap.put("||", (short) 265);
        this.tokensMap.put("!=", (short) 261);
        this.calcSets.add("{");
        this.calcSets.add("}");
        this.calcSets.add("[");
        this.calcSets.add("]");
        this.calcSets.add("(");
        this.calcSets.add(")");
        this.calcSets.add("+");
        this.calcSets.add("-");
        this.calcSets.add("*");
        this.calcSets.add("/");
        this.calcSets.add("%");
        this.calcSets.add(",");
        this.calcSets.add(">");
        this.calcSets.add("<");
        this.calcSets.add(":");
        this.calcSets.add("UNARY");
    }

    private String readCharsToString() {
        int i;
        try {
            this.readEnd = this.reader.read(this.readBuffer);
        } catch (Exception unused) {
            System.out.println("Read the inputs filed !");
        }
        char[] cArr = this.readBuffer;
        if (cArr[0] == 10 || (i = this.readEnd) <= 0) {
            return null;
        }
        return new String(cArr, 0, i - 1);
    }

    private List<String> preProcessToken(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("The inputs is empty ! ");
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Pattern compile = Pattern.compile("[<>=!]=?|=" + "|&&|\\|\\|" + "|\\:|\\[|\\]|\\{|\\}|\\(|\\)|\\+|\\,|\\%|\\-|\\*|\\/");
        Matcher matcher = compile.matcher(str);
        String[] split = compile.split(str, -1);
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                if (matcher.find()) {
                    if (split[i].trim().equals("else if")) {
                        String[] split2 = split[i].trim().split(" ");
                        linkedList.add(split2[0].trim());
                        linkedList.add(split2[1].trim());
                    } else {
                        linkedList.add(split[i].trim());
                    }
                    linkedList.add(matcher.group());
                } else {
                    linkedList.add(split[i].trim());
                }
            }
        }
        int i2 = 0;
        while (i2 < linkedList.size()) {
            if (((String) linkedList.get(i2)).length() == 0) {
                linkedList.remove(i2);
            } else {
                if (((String) linkedList.get(i2)).equals("") || (((String) linkedList.get(i2)).length() != 0 && ((String) linkedList.get(i2)).charAt(0) == ' ')) {
                    linkedList.remove(i2);
                }
                i2++;
            }
            i2--;
            i2++;
        }
        return linkedList;
    }

    public Token yylex() {
        if (!this.tokenIter.hasNext()) {
            return new Token();
        }
        String next = this.tokenIter.next();
        Token token = new Token();
        if (isNumber(next)) {
            token.setType(270);
            token.setStr(next);
        } else if (this.tokensMap.containsKey(next)) {
            token.setStr(next);
            token.setType(this.tokensMap.get(next).shortValue());
        } else if (this.calcSets.contains(next)) {
            token.setStr(next);
            token.setType(next.charAt(0));
        } else if (next.charAt(0) != '\"') {
            token.setStr(next);
            token.setType(268);
        } else {
            token.setStr(next.substring(1, next.length() - 1));
            token.setType(269);
        }
        return token;
    }

    private boolean isNumber(String str) {
        return str.matches("^[0-9]+(.[0-9]+)?$");
    }
}
