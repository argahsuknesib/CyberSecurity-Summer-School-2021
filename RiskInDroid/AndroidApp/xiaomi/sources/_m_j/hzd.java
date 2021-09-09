package _m_j;

import java.math.BigDecimal;
import java.util.Stack;

public final class hzd {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    public static Object O000000o(String str, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return Double.valueOf(O000000o(str, BigDecimal.valueOf(((Double) obj).doubleValue())).doubleValue());
        }
        if (obj instanceof Float) {
            return Float.valueOf(O000000o(str, BigDecimal.valueOf((double) ((Float) obj).floatValue())).floatValue());
        }
        if (obj instanceof Long) {
            return Long.valueOf(O000000o(str, BigDecimal.valueOf(((Long) obj).longValue())).longValue());
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(O000000o(str, BigDecimal.valueOf((long) ((Integer) obj).intValue())).intValue());
        }
        ((String) obj).contains(".");
        return O000000o(str, BigDecimal.valueOf(hhc.O000000o(obj, 0.0d))).toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    private static BigDecimal O000000o(String str, BigDecimal bigDecimal) {
        char[] charArray = str.toCharArray();
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        int i = 0;
        while (i < str.length()) {
            if (charArray[i] == 'x') {
                stack.push(bigDecimal);
            } else if (charArray[i] >= '0' && charArray[i] <= '9') {
                int i2 = i + 1;
                while (i2 < str.length() && ((charArray[i2] >= '0' && charArray[i2] <= '9') || charArray[i2] == '.')) {
                    i2++;
                }
                String substring = str.substring(i, i2);
                substring.contains(".");
                stack.push(BigDecimal.valueOf(hhc.O000000o((Object) substring, 0.0d)));
                i = i2 - 1;
            } else if (stack2.empty()) {
                stack2.push(Character.valueOf(charArray[i]));
            } else {
                char charValue = ((Character) stack2.pop()).charValue();
                int O000000o2 = O000000o(charValue, charArray[i]);
                if (O000000o2 == 1) {
                    stack.push(O000000o((BigDecimal) stack.pop(), (BigDecimal) stack.pop(), charValue));
                    stack2.push(Character.valueOf(charArray[i]));
                }
                if (O000000o2 == 0) {
                    stack2.push(Character.valueOf(charValue));
                    stack2.push(Character.valueOf(charArray[i]));
                }
                if (O000000o2 == 2) {
                    System.out.println("'('刚好遇到')'");
                }
                if (O000000o2 == 3) {
                    while (charValue != '(') {
                        stack.push(O000000o((BigDecimal) stack.pop(), (BigDecimal) stack.pop(), charValue));
                        charValue = ((Character) stack2.pop()).charValue();
                    }
                }
                if (O000000o2 == -1) {
                    System.out.println("出现栈顶有')'错误！！！");
                }
            }
            i++;
        }
        while (!stack2.empty() && !stack.empty()) {
            stack.push(O000000o((BigDecimal) stack.pop(), (BigDecimal) stack.pop(), ((Character) stack2.pop()).charValue()));
        }
        return (BigDecimal) stack.pop();
    }

    private static BigDecimal O000000o(BigDecimal bigDecimal, BigDecimal bigDecimal2, char c) {
        if (c == '*') {
            return bigDecimal.multiply(bigDecimal2);
        }
        if (c == '+') {
            return bigDecimal.add(bigDecimal2);
        }
        if (c == '-') {
            return bigDecimal.subtract(bigDecimal2);
        }
        if (c != '/') {
            return BigDecimal.valueOf(0L);
        }
        return bigDecimal.divide(bigDecimal2, 4);
    }

    private static int O000000o(char c, char c2) {
        char c3 = 0;
        char c4 = 5;
        int[][] iArr = {new int[]{1, 1, 0, 0, 0, 3}, new int[]{1, 1, 0, 0, 0, 3}, new int[]{1, 1, 1, 1, 0, 3}, new int[]{1, 1, 1, 1, 0, 3}, new int[]{0, 0, 0, 0, 0, 2}, new int[]{-1, -1, -1, -1, -1, -1}};
        char c5 = c == '-' ? (char) 1 : 0;
        if (c == '*') {
            c5 = 2;
        }
        if (c == '/') {
            c5 = 3;
        }
        if (c == '(') {
            c5 = 4;
        }
        if (c == ')') {
            c5 = 5;
        }
        if (c2 == '-') {
            c3 = 1;
        }
        if (c2 == '*') {
            c3 = 2;
        }
        if (c2 == '/') {
            c3 = 3;
        }
        if (c2 == '(') {
            c3 = 4;
        }
        if (c2 != ')') {
            c4 = c3;
        }
        return iArr[c5][c4];
    }
}
