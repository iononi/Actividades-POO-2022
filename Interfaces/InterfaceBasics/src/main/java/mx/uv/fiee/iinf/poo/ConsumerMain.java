package mx.uv.fiee.iinf.poo;

import java.util.function.Consumer;
import java.util.ArrayList;

public class ConsumerMain {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        Consumer<ArrayList<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, list.get(i) * 2);
            System.out.println(list);
        };

        modify.accept(myList);

    }
}
