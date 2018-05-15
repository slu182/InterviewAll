package priv.interview.module.algorithm.string;

/**
 * 输入ABBB 输出A3B
 */

public class Sample1 {
    public static boolean convert(String stringIn, char ch, int idx) {
        if (idx == 0) return false;
        if (idx < stringIn.length() && ch == stringIn.charAt(idx)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String strIn = "ABBBCCCCC";
        int count = 1;


        StringBuilder stringBuilder = new StringBuilder();
        char ch = strIn.charAt(0);
        for (int i = 0, len = strIn.length(); i < len; i++) {
            if (i == 0) {
                stringBuilder.append(ch);
                continue;
            }
            if (count == 1) {
                if (convert(strIn, ch, i)) {
                    count++;
                } else {
                    stringBuilder.append(strIn.charAt(i));
                    ch = strIn.charAt(i);
                }
            } else {
                if (convert(strIn, ch, i)) {
                    count++;
                    if (i == len - 1) {// 显示最后一个
                        stringBuilder.append(count);
                    }

                } else {
                    stringBuilder.append(count);
                    count = 1;
                }

            }

        }
        System.out.println(stringBuilder.toString());


    }
}
