package String;

/**
 * 字符串空格替换
 *
 * 剑指offer：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */

public class StringReplaceSpace {
    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
     * )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     */
    public String replaceSpace(String str){

        int lenth = str.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lenth; i++){
            char c = str.charAt(i);
            if(String.valueOf(c).equals(" ")){

                res.append("%20");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     * 第二种方法，用java API
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {

        // str.toString().replace(" ","%20");
        return str.toString().replaceAll("\\s", "%20");
    }

    public static void main(String[] args) {
        StringReplaceSpace stringReplaceSpace = new StringReplaceSpace();
        String s = "12 3 456 7897/";
        String s1 = stringReplaceSpace.replaceSpace(s);
        System.out.println(s1);
    }
}
