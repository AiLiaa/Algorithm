package String.old;

import java.util.Scanner;

/**
 * 括号匹配深度
 *
 * 例如: "()()()"的深度是1,"((()))"的深度是3。
 *
 */

public class BracketMatchingDepth {

    public static int solution(String s){
        int count = 0;
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '('){
                count++;
            }else {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = solution(s);
        sc.close();
        System.out.println(res);
    }

}
