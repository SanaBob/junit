package q7;

public class Question7 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3 };
        int[] arrCounts = countThisPlease(arr);
        for (int j = 0; j < arrCounts.length; j++)
            System.out.println(arrCounts[j]);
    }

    public static int[] countThisPlease(int[] nums) {
        int[] counts = new int[10];
        for (int i = 0; i < nums.length; i++)
            counts[nums[i]]++;
        return counts;
    }
}
