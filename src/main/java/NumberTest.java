import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by harlenzhang on 2016/12/16.
 */
public class NumberTest {
    public static void main(String[] args) {

        List<BigDecimal> numberList = new ArrayList<BigDecimal>();
        numberList.add(new BigDecimal(1));
        numberList.add(new BigDecimal(2));
        for (BigDecimal number : numberList)
        number.multiply(new BigDecimal(2));
        System.out.println(numberList);


    }
}
