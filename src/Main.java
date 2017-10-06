public class Main {

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        Integer arr[] = {12, 11, 13, 5, 6};
        ArrayPrinter array = new ArrayPrinter(arr);
        is.sort(array);
        array.end();
    }


}
