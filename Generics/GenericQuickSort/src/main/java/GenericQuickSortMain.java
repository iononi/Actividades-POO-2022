import java.util.Arrays;

public class GenericQuickSortMain {

    public static void main(String[] args) {
        Integer[] intArray = {101, 99, 12, 19, 21, 111, 345, 25, 77, 81};
        Float[] floatArray = { 19.1f, 456.6f, 23.45f, 12.34f, 11.11f, 354.55f, 78.45f, 28.33f, 45.99f, 108.88f };
        String[] strArray = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"};

        System.out.println("Integer Array before sorting: " + Arrays.toString(intArray));
        Integer[] result = Utils.ordena(intArray, 0, intArray.length - 1);
        System.out.println("Integer Array after sorting: " + Arrays.toString(result));

        System.out.println();

        System.out.println("Float Array before sorting: " + Arrays.toString(floatArray));
        Float[] fResult = Utils.ordena(floatArray, 0, floatArray.length - 1);
        System.out.println("Float Array after sorting: " + Arrays.toString(fResult));

        System.out.println();

        //System.out.println("String array before sorting: " + Arrays.toString(strArray));
        //String[] strResult = Utils.ordena(strArray, 0, strArray.length).length - 1;
    }

}
