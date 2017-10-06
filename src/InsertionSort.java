class InsertionSort {
    void sort(ArrayPrinter array)
    {
        int n = array.length();
        for (int i=1; i<n; ++i)
        {
            int key = array.get(i);
            int j = i-1;

            while (j>=0 && array.get(j) > key)
            {
                array.set(j+1, array.get(j));
                j = j-1;
            }
            array.set(j+1, key);
        }
    }
}
