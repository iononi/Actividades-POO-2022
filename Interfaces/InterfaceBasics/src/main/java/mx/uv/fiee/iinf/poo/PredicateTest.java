package mx.uv.fiee.iinf.poo;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        // Creating a reference to a predicate
        Predicate<Integer> greaterThan = i -> (i > 10);
        System.out.println(greaterThan.test(15));
    }

}
