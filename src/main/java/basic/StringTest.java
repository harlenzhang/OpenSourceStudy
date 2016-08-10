package basic;

/**
 * Created by harlenzhang on 16/7/25.
 */
public class StringTest {
    public static void main(String[] args) {
        String modelIds = "2,3,4,5,6,7,8,9,10,11,12,13,14,15,";
        String[] ids = modelIds.split(",");
        for (String s : ids)
            System.out.println(Integer.parseInt(s));
    }
}
