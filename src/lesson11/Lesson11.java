package lesson11;

/**
 * Java Pro. lesson #11
 * @author Igor Cijov
 * @version 14 Jul 2022
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lesson11 {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.equals(s2));
        //Set<String> strSet = new HashSet<>();
        Set<String> strSet = new TreeSet<>();
        strSet.addAll(Arrays.asList("B","DD","A","F"));
        System.out.println(strSet);

    }


}
