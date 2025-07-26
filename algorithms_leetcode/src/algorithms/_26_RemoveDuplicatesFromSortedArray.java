package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class _26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesThere(arr));
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set.stream().collect(Collectors.toList()));
        return set.size();
    }

    public static int removeDuplicatesTwo(int[] nums) {
        int leng = nums.length;
        int lengArr = leng;
        int index = 0;
        int[] arr = new int[lengArr];
        for (int i = 0; i < leng; i++) {
            if (i + 1 < leng) {
                if (nums[i] != nums[i + 1]) {
                    arr[index] = nums[i];
                    lengArr--;
                    index++;
                }
            } else if (i + 1 == leng) {
                arr[index] = nums[leng - 1];
                lengArr--;
            }
        }
        int[] newArr = new int[lengArr];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        return arr.length;
    }

    public static int removeDuplicatesThere(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
