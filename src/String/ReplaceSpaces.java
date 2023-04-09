package String;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpaces {
    public static String solution(String s){
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String res = solution("ab cd ef ");
        System.out.println(res);
    }
}
