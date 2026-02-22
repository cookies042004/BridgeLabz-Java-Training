package annotation;

import java.util.*;

public class Suppress {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();  // Raw type
        list.add("Hello");

        ArrayList<String> strList = list;  // unchecked warning suppressed

        System.out.println(strList.get(0));
    }
}
