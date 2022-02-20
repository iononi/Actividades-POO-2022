public class Utils {
    public static <T extends Number> T[] ordena(T[] array, int fromIndex, int toIndex) {
        int i, j, middle;
        T pivot;

        middle = (fromIndex + toIndex) / 2;
        pivot = array[middle];
        i = fromIndex; j = toIndex;

        do {
            while (array[i].doubleValue() < pivot.doubleValue()) {
                i++;
            }
            while (array[j].doubleValue() > pivot.doubleValue()) {
                j--;
            }
            if (i <= j) {
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                /* swap a[i] to a[j] */
                i++;
                j--;
            }
        } while (i <= j);

        if (fromIndex < j) {
            ordena(array, fromIndex, j); /* same process with left subarray */
        }
        if (i < toIndex) {
            ordena(array, i, toIndex); /* same process with right subarray */
        }
        return array;
    }
}
