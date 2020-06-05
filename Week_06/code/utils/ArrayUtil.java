package utils;

import org.junit.Test;

public class ArrayUtil {

    @Test
    public void dealStr() {
        String s = "[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]";
        s = s.replace("[", "{");
        s = s.replace("]", "}");
        s = s.replace("\"", "'");
        System.out.println(s);
    }
}
