import java.util.Arrays;

/**
 * Created by niuyi on 2017/5/15.
 */
public class Transfer {
    public static void intToByte(int i){
        System.out.println((byte)i);
    }

    public static int byteToInt(byte b){
        return b & 0xFF;
    }

    public static int byteArrayToInt(byte[] b){
//        return bs[0]& 0xFF | (bs[1] << 8)&0xff | (bs[2] << 16)&0xff |(bs[3] << 24)&0xff;
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int i){
        return new byte[]{
                (byte)((i >> 24)&0xff),(byte)((i >> 16)&0xff),(byte)((i >> 8)&0xff),(byte)((i)&0xff)
        };
    }

    public static String revert(String s){
        int length = s.length();
        char[] chars = s.toCharArray();
//
//        for(int i = 0 ; i < length ; i++){
//            chars[i] = s.charAt(length - i - 1);
//        }

        int size = length/2;

        for(int i = 0 ; i < size; i++){
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }

        return new String(chars);
    }

    public static boolean checkReverse(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        int size = s1.length();

        for(int i = 0 ; i < size ; i++){
            if(s1.charAt(i) != s2.charAt(size - i - 1))
                return false;
        }

        return true;
    }

    public static void permutation(String s){
        do_permutation(s.toCharArray(), 0, s.length() - 1);
    }

    private static void do_permutation(char[] chars, int start, int end){
        if(start == end){
            System.out.println(Arrays.toString(chars));
        }else{
            for(int i = start ; i <= end; i++){
                swap(chars, start, i);
                do_permutation(chars, start+1, end);
                swap(chars,i, start);
//                System.out.println(Arrays.toString(chars));
            }
        }
    }

    private static void swap(char[] chars, int l, int r){
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

    public static int stringToInt(String s){
        int size = s.length();
        int val = 0;
        for(int i = 0 ; i < size ; i++){
            char c = s.charAt(i);
            double pow = Math.pow(10, size - i - 1);
            Integer integer = Integer.valueOf(new String(new char[]{c}));
            val += integer * pow;
        }

        return val;
    }

    public static void swap(int a , int b){
        a = b -a;
    }
}
