package reflection.javassist;

/**
 * Created by harlenzhang on 2017/1/24.
 */
public class TimeCounter {
    private String buildString(int length) {
        return buildString$impl(length);
    }

    private String buildString$impl(int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += (char)(i%26 + 'a');
        }
        return result;
    }

    public static void main(String[] args) {
        TimeCounter inst = new TimeCounter();
        for (int i = 0; i < args.length; i++) {
            String result = inst.buildString(Integer.parseInt(args[i]));
            System.out.println("Constructed string of length " +
                    result.length());
        }
    }
}
