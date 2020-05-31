package utils;

import org.junit.Test;

public class ArrayUtil {

    @Test
    public void dealStr() {
        String s = "[[1,3,1],[1,5,1],[4,2,1]]";
        s = s.replace("[", "{");
        s = s.replace("]", "}");
//        s = s.replace("\"", "'");
        System.out.println(s);
    }
}
