//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//
//    public static double solution(int n,int k,int[] ints){
//        Arrays.sort(ints);
//        int count = n / k;
//        int kk = 0;
//        double res = 0;
//        double sum;
//        // 规则分组的
//        for (int i = 0; i < n; i++) {
//            kk++;
//            if (kk == k){
//                break;
//            }
//            sum = 0;
//            for (int j = 0; j < count; j++) {
//                sum += ints[i];
//            }
//            res += sum/count;
//        }
//        // 剩下的一组
//        sum = 0;
//        for (int i = (k-1)*count; i < n; i++) {
//            sum += ints[i];
//        }
//        res += sum/(n-(k-1)*count);
//        return res;
//    }
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n =in.nextInt();
//        int temp = n;
//        int k = in.nextInt();
//        int[] ints = new int[n];
//        int num = 0;
//        while (n-- > 0){
//            ints[num++] = in.nextInt();
//        }
//        double r = solution(temp, k, ints);
//        System.out.println(r);
//    }
//}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        int x;
//        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        x = in.nextInt();
//
//        int n =(int) Math.sqrt(2*x);
//        while ((n+1)*n/2 < x){
//            n++;
//        }
//        n--;
//        String s = "";
//        for (int i = 0; i < n; i++) {
//            s += "d";
//        }
//        char[] chars = {'r','e','d'};
//        int a = (n+1)*n/2;
//        for (int i = 0; i < x - a; i++) {
//            s+= chars[i%3];
//        }
//        System.out.println(s);
//
//    }
//}

