package String;

/**
 *
 * 验证回文串
 *
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */


public class VerifyPalindromeString {

    /**
     * 第一种方法：用API翻转字符串，判断是否相等
     *
     * Character.isLetterOrDigit():如果 isLetter(codePoint) 或 isDigit(codePoint) 对字符返回 true，则认为该字符是字母或数字。
     * reverse()：翻转字符
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     */
    public static boolean isPalindrome01(String s){

        StringBuilder res = new StringBuilder();
        int lenth = s.length();
        char ch = ' ';

        // 转换为小写
        for (int i = 0; i < lenth; i++) {
            ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                res.append(Character.toLowerCase(ch));
            }
        }

        StringBuilder res_rev = new StringBuilder(res).reverse();

        System.out.println(res);
        System.out.println(res_rev);

        return res.toString().equals(res_rev.toString());
    }

    /**
     * 方法二：双指针
     *
     * 使用双指针左右指针分别指向字符串的两侧
     * 不断地将这两个指针相向移动，每次移动一步，并判断这两个指针指向的字符是否相同。
     * 当这两个指针相遇时，说明是回文串
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     */

    public static boolean isPalindrome02(String s){
        StringBuilder res = new StringBuilder();
        int lenth = s.length();
        char ch = ' ';

        // 转换为小写
        for (int i = 0; i < lenth; i++) {
            ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                res.append(Character.toLowerCase(ch));
            }
        }
        
        int n = res.length();
        int left = 0;
        int right = n - 1;
        while (right > left){
            if (res.charAt(left) != res.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 方法三：双指针，在原串中操作
     *
     * 在移动任意一个指针时，需要不断地向另一指针的方向移动
     * 每次判断两字符是否相等
     *
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     */
    public static boolean isPalindrome03(String s){
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right){
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "a bc 1 21c b a";
        boolean palindrome = isPalindrome02(s);
        System.out.println(palindrome);
    }

}
