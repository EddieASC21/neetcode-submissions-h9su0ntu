class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            int currentSum = numbers[left] + numbers[right];

            if(currentSum > target) right--;
            else if(currentSum < target) left++;
            else return new int[] { left + 1, right + 1 };
        }

        return new int[0];
    }
}
