//import java.util.Scanner;
//
///**
// * 时间限制： 3000MS
// * 内存限制： 589824KB
// * 题目描述：
// *        小明学会了一种加密方式。他定义suc(x)为x在字母表中的后继，例如a的后继为b，b的后继为c… （即按字母表的顺序后一个）。特别的，z的后继为a。对于一个原字符串S，将其中每个字母x都替换成其三重后继，即suc(suc(suc(x)))的字母，即完成了加密。
// *
// *        例如，abc加密后变成def （suc(suc(suc(a)))=d suc(suc(suc(b)))=e suc(suc(suc(c)))=f）
// *
// *        现在小明知道一个加密后的字符串S'，想请你找出他的原串S
// */
//
//
//public class Main {
//
//    public String sucSolution(String str, int count){
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String abc = "abcdefghijklmnopqrstuvwxyz";
//
//        for (char c : str.toCharArray()){
//            int index = abc.indexOf(Character.toLowerCase(c));
//            char res = abc.charAt((index+23)% 26);
//            stringBuilder.append(res);
//        }
//
//        return stringBuilder.toString();
//    }
//
//    public static void main(String[] args) {
//        Main demo01 = new Main();
//
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//
//
//        String s = scanner.next();
//
//        String res = demo01.sucSolution(s, i);
//        System.out.println(res);
//    }
//
//}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        for (int i = 0 ; i<t;i++){
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            int[] a = new int[n];
//            for (int j = 0; j<n;j++){
//                a[j] = scanner.nextInt();
//            }
//            int res = kSort(a,m);
//            System.out.println(res);
//        }
//    }
//
//    private static int kSort(int[] a, int m) {
//        int n = a.length;
//        int res = 0;
//        while (true){
//            int i = 0;
//            while (i<n){
//                int j = Math.min(i+m, n);
//                Arrays.sort(a,i,j);
//                i =j;
//
//            }
//            res++;
//            if (isSorted(a)){
//                break;
//            }
//
//        }
//        return res-1;
//    }
//
//    private static boolean isSorted(int[] a) {
//        for (int i = 0;i<a.length-1;i++){
//            if (a[i]>a[i+1]){
//                return false;
//            }
//        }
//        return true;
//    }
//
//}


//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    public static int solution(){
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//
//        int[] b = new int[n+1];
//        List<Integer>[] m = new List[n + 1];
//
//        for (int i = 0; i <= n ; i++) {
//            String type = scanner.next();
//            if (type.equals("b")){
//                b[i] = scanner.nextInt();
//
//            }else if (type.equals("m")){
//                int k1 = scanner.nextInt();
//                m[i] = new ArrayList<>();
//                for (int j = 0; j < k1; j++) {
//                    m[i].add(scanner.nextInt());
//                }
//                Collections.sort(m[i]);
//
//            }
//        }
//        int a = 0;
//        for (int i = 1; i <= n; i++) {
//            if (b[i] >= k){
//                a+=k;
//            }else if (m[i]!=null&& b[i]+m[i].size()>=k){
//                int count = k - b[i];
//                a+=b[i]+count;
//                for (int j = 0; j < m[i].size(); j++) {
//                    if (m[i].get(j)<= count){
//                        a += m[i].get(j);
//                        count+=m[i].get(j);
//                    }else {
//                        a+=count;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return a;
//    }
//
//    public static void main(String[] args) {
//        int solution = solution();
//        System.out.println(solution);
//
//    }
//
//}

public class Main {

    public static int solution(int[] ints){
        int maxLen = 1;
        int begin = 0;

        int length = ints.length;

        // 初始化dp[][],表示s[i,j]是否是回文串
        boolean[][] dp = new  boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        // 在判断串时，i是左边界，j是右边界
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {

                if (ints[i] != ints[j]){
                    dp[i][j] = false;
                }else if (j - i < 3){
                    // 此时dp[i+1][j-1]还未赋值
                    dp[i][j] = true;
                }else {
                    // dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j]
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return 0;
    }

}




















