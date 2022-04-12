package helpers;

public class ArrayHelper {
    public static <T> boolean addItem(final T[] ar, final T item, final int lastUsedIndex) {
        boolean res = true;
        for (int i = 0; i < lastUsedIndex; i++) {
            if (item == ar[i]) {
                res = false;
                break;
            }
        }
        if (res) {
            ar[lastUsedIndex + 1] = item;
        }
        return res;
    }

    public static <T> boolean deleteItem(final T[] ar, final T item, final int lastUsedIndex) {
        boolean res = false;
        for (int i = 0; i < lastUsedIndex; i++) {
            if (item == ar[i]) {
                res = true;

                for (int j = i; j < lastUsedIndex - 1; j++) {
                    ar[j] = ar[j + 1];
                }
                ar[lastUsedIndex - 1] = null;
                break;
            }
        }
        return res;
    }
}
