class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        helper(nums, target, 0, 0, combination, output);

        return output;
    }

    private void helper(int[] nums, int target, int currentSum, int index, List<Integer> combination, List<List<Integer>> output){
        if(target == currentSum){
            output.add(new ArrayList<>(combination));
            return;
        }

        if(index >= nums.length || currentSum >= target) return;

        combination.add(nums[index]);
        helper(nums, target, currentSum + nums[index], index, combination, output);
        combination.remove(combination.size() - 1);
        helper(nums, target, currentSum, index + 1, combination, output);
    }
}
