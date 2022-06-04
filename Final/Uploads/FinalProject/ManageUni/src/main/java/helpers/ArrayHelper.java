package helpers;

public class ArrayHelper {

    private ArrayHelper() {

    }

    public static <T> boolean addItem(final T[] ar, final T item, final int lastUsedIndex) {
        if (item == null)
            return false;

        boolean res = true;
        for (int i = 0; i < lastUsedIndex; i++) {
            if (item.equals(ar[i])) {
                res = false;
                break;
            }
        }
        if (res) {
            ar[lastUsedIndex] = item;
        }
        return res;
    }

    public static <T> boolean deleteItem(final T[] ar, final T item, final int lastUsedIndex) {
        if (item == null) {
            return false;
        }
        boolean res = false;

        for (int i = 0; i < lastUsedIndex; i++) {
            if (item.equals(ar[i])) {
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
