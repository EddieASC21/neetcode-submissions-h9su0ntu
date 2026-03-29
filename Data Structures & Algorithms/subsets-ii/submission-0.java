class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, output, subset, 0);
        return output;
    }

    private void helper(int[] nums, List<List<Integer>> output, List<Integer> subset, int i){
        if(i == nums.length){
            output.add(new ArrayList<>(subset));
            return; 
        }

        subset.add(nums[i]);
        helper(nums, output, subset, i + 1);
        subset.remove(subset.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        helper(nums, output, subset, i + 1);
    }
}

/*
We are to return a list if
*/