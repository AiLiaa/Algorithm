package Array.DoublePointer;

/**
 * 比较字符串（含退出字符#）
 *
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 双指针删除 # 和 #之前的字符
 *
 */

public class BackSpaceCompare {
    public static boolean solution(String s1, String s2){
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int skipS1 = 0;
        int skipS2 = 0;

        // 找到 s1 中第一个需要比较的字符（即去除 # 影响后的第一个待比较字符）
        while (i >= 0 || j >= 0){
            while (i >= 0){
                if (s1.charAt(i) == '#'){
                    i--;
                    skipS1++;
                }else if (skipS1 > 0){
                    skipS1--;
                    i--;
                }else {
                    break;
                }
            }
            // 找到 s2 中第一个需要比较的字符（即去除 # 影响后的第一个待比较字符）
            while (j >= 0){
                if (s2.charAt(j) == '#'){
                    j--;
                    skipS2++;
                }else if (skipS2 > 0){
                    skipS2--;
                    j--;
                }else {
                    break;
                }
            }

            if (i >= 0 && j >= 0){
                if (s1.charAt(i) != s2.charAt(j)){
                    return false;
                }
            }
            // (i >= 0 && j >= 0) 为 false 情况为
            // 1. i < 0 && j >= 0
            // 2. j < 0 && i >= 0
            // 3. i < 0 && j < 0
            // 其中，第 3 种情况为符合题意情况，因为这种情况下 s 和 t 都是 index = 0 的位置为 '#' 而这种情况下
            // 退格空字符即为空字符，也符合题意，应当返回 True。
            // 但是，情况 1 和 2 不符合题意，因为 s 和 t 其中一个是在 index >= 0 处找到了待比较字符，另一个没有找到
            // 这种情况显然不符合题意，应当返回 False，下式便处理这种情况。
            else {
                if (i >= 0 || j >= 0){
                    return false;
                }
            }
            i--;
            j--;
        }

        return true;
    }


    /**
     *
     * 方法二重构字符串
     *
     */
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s1 = "ab##ab#bc";
        String s2 = "abc#c";
        boolean res = solution(s1, s2);
        System.out.println(res);
    }
}
