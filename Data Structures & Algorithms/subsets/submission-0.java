class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(nums, 0, subset, output);

        return output;
    }

    private void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> output){
        if(i >= nums.length){
            output.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        helper(nums, i + 1, subset, output);
        subset.remove(subset.size() - 1);
        helper(nums, i + 1, subset, output);
    }
}
