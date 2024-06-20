package DSA.HashTable;


public class CommonItemInTwoArray {


    public static void main(String[] args) {
        CommonItemInTwoArray test = new CommonItemInTwoArray();
        int[] arr1 = {2, 5, 8, 9, 4};
        int[] arr2 = {6, 7, 8, 10, 14};
        int common = test.testMethod(arr1, arr2);
        System.out.println(common);
    }

    private int testMethod(int[] arr1, int[] arr2) {
        HashTable<Integer, Boolean> hs = new HashTable<>();
        for (int j : arr1) {
            hs.put(j, true);
        }
        for (int i : arr2) {
            if (hs.get(i) != null) {
                return i;
            }
        }
        return -1;
    }
}
