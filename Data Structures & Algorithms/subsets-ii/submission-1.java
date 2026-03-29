class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // list of lists
        List<List<Integer>> output = new ArrayList<>();

        // subset
        List<Integer> subset = new ArrayList<>();

        // we sort our array to make it easier to deal with duplicates
        Arrays.sort(nums);

        helper(nums, output, subset, 0);

        return output;
    }

    private void helper(int[] nums, List<List<Integer>> output, List<Integer> subset, int i){
        // base case

        // when the index reaches the end of the input array, we have visited every element
        // that means we can add the subset
        if(i == nums.length){
            output.add(new ArrayList<>(subset));
            return;
        }

        // recursive case

        // two decisions

        // all subsets that include nums[i]

        // we add the element
        subset.add(nums[i]);
        helper(nums, output, subset, i + 1);

        // all subsets that don't include nums[i]

        // we remove the value we just add to the subset to backtrack
        subset.remove(subset.size() - 1);

        // we ensure that we skip over the duplicates
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        helper(nums, output, subset, i + 1);
    }
}

/*
We are to return a list of list of integers

we are given an array of integers that may or may not contain duplicates 

we want all subset but no duplicate subsets

so if we had for example

nums = [1,2,1]

our subsets can be [], [1], [2], [1, 1], [1, 2], [1, 2, 1]

we note that [2, 1] and [1, 2] are considered the same subset

An approach:

We want to sort the array to group the duplicates

We would backtrack to explore all the combinations

Note the reason we want to group the duplicates so that we skip over them easier to not have duplicate subsets

Another approach:

The same idea that we had

sort to deal with duplicates and keep it on one side
*/