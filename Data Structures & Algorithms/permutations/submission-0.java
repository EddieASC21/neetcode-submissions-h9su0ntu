class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // what we will do is the backtracking

        // our output
        List<List<Integer>> output = new ArrayList<>();

        // our permutations
        List<Integer> permutations = new ArrayList<>();

        helper(nums, output, permutations);

        return output;
    }

    // helper function to carry out backtracking
    private void helper(int[] nums, List<List<Integer>> output, List<Integer> permutations){
        // base case

        // if permutation same length as original array, valid permutation found
        if(permutations.size() == nums.length){
            output.add(new ArrayList<>(permutations));
            return;
        }

        // we now iterate over each number in the nums to see if we can add to our permutation
        for(int i = 0; i < nums.length; i++){
            // if we are already used this element in the permutation, we skip it
            if(permutations.contains(nums[i])) continue;
            // we now add the element to the permutation
            permutations.add(nums[i]);
            // call our helper function now including the element
            helper(nums, output, permutations);
            // we now remove the element we just added to backtrack
            permutations.remove(permutations.size() - 1);
        }
    }
}

/*
We must return a list of list of integers

we are given an array called numbers with UNIQUE integers

We have to return all possible permutations in order

walk through an example:

nums = [1,2,3]

We note that each permutation is the same length as the original array

The original array is also considered a permutation

we also note that each element can only be in the same position twice so

we will have [1, , ] and [1, , ] then [ , 1, ] and [ , 1, ] to [ , , 1] and [ , , 1]

same can be said for other elements so we would have [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

an approach would be:

is that with each list that is our permutation, we try every unsused number

we would then mark it as used and then move to next position and recurse

Backtracking comes into play when we remove and unmark the number

but from this, we would mark if used using a boolean array

another approach

We will work in another manner where we work with subproblems

to find all permutations of [1, 2, 3]

we find the permution of [2, 3]

to find this, we must find permutations of [3]

where we find permutation of [] which is a basic as the permutation is []

then the permutation is then adding 3 to [] which is 3

we go back up and add 2 which can be [2, 3] or [3, 2]

we go up again and add 1 to [2, 3] which is [1, 2, 3], [2, 1, 3], and [2, 3, 1]

we try now with [3, 2] and 1 to get [1, 3, 2], [3, 1, 2], and [3, 2, 1]

note all permutations are the length of the original array which is a base case

this gives us all permutations
*/
