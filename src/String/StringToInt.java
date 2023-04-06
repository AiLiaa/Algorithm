package String;

/**
 * 剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 有以下四种字符需要考虑:
 *
 * 首部空格： 删除之即可；
 * 符号位:三种情况，即"+", "-","无符号"﹔新建一个变量保存符号位，返回前判断正负即可。
 * 非数字字符： 遇到首个非数字的字符时，应立即返回。
 *
 * 数字字符:
 *    字符转数字： “此数字的 ASCII 码” 与 “0" 的 ASCII 码” 相减即可
 *    数字拼接:若从左向右遍历数字，设当前位字符为c，当前位数字为α，数字结果为res，则数字拼接公式为:
 *        res = 10 x res＋a
 *        a = ascii(c) - ascii('O')
 */

public class StringToInt {
    public static int solution(String s){

        char[] chars = s.trim().toCharArray();
        int length = chars.length;
        if (length == 0){
            return 0;
        }
        int res = 0, sign = 1, j = 0;
        // 2147483647/10=2147483640
        int bndry = Integer.MAX_VALUE / 10;
        if (chars[0] == '-'){
            sign = -1;
        }
        if (chars[0] == '-' || chars[0] == '+'){
            j = 1;
        }

        for (int i = j; i < length; i++) {
            if (chars[i] < '0' || chars[i] > '9')
                break;
            // 边界检测 res > 214748364 ==> res*10 > 2147483647
            // res = 214748364 chars[i] > '7' ==> res + 7 > 2147483647
            if(res > bndry || res == bndry && chars[i] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            res = res*10 + (chars[i]-'0');

        }
        return sign * res;
    }

    public static void main(String[] args) {

        String s = "   -489132794324dsv578374dsfjn vsdv";
        int r = solution(s);

        System.out.println(r);

    }

}
