class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // we will have our lists of lists where we add the subsets to
        List<List<Integer>> ans = new ArrayList<>(); 
        
        // we build the subset using a List
        List<Integer> subset = new ArrayList<>();

        // call our helper function
        helper(nums, ans, subset, 0);

        return ans;
    }

    // helper method
    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> subset, int i){
        // base case
        // if i is greater than the length of our array, we are out of bounds and have traversed over each element
        if(i >= nums.length){
            // we add a copy of the subset to our answer as the subset is going to be modified hence the copy being added
            ans.add(new ArrayList<>(subset));
            return;
        }

        // our decision

        // decision to include nums[i]
        subset.add(nums[i]);
        // we then call dfs recursively on the next element
        // this can be seen as the left branch of our decision tree
        // for this recursive call will have a different subset given to it
        helper(nums, ans, subset, i + 1);

        // this is our decision to not include nums[i]
        // we backtrack
        // so what we do is remove the element we just appended
        subset.remove(subset.size() - 1);
        // then we recursively run dfs on the next element
        // this can be seen as the right branch
        // this recursive call will be have an empty subset given to it
        helper(nums, ans, subset, i + 1);
    }
}

/*
We have the question subsets

Just by knowing we must return a list of lists of integers and we are given an array nums

also we note that nums is populated with unique integers

we then want to return all possible substes of nums

we note that the lists of integers in our lust can be returned in any order

also note that duplicate lists can't be in our list

we will now walk through an example

nums = [1,2,3]

we have our list []

we can take no elements: [[]]

we can take only the first element as a subset: [[], [1]]

We can also only take the second element as a subset: [[], [1], [2]]

We can also take only the third element as a subset as well: [[], [1], [2], [3]]

we can take only the first two elements as a subset: [[], [1], [2], [3], [1,2]]

we can take the second and last element as a subset: [[], [1], [2], [3], [1,2], [2,3]]

we can take the first and last element as a subset: [[], [1], [2], [3], [1,2], [2,3], [1,3]]

we can also have the array itself as a subset: [[], [1], [2], [3], [1,2], [2,3], [1, 3], [1,2,3]]

What i know is that we probably have to deal with a decision tree as we are dealing a lot with include in the subset or not

a decision tree means that we have to deal with dfs and recursion

An Approach:

what we note is that for an array of length n, there are 2^n possible subsets

no need to worry about duplucate subsets as all integers are unique

we note that for each element we have the choice to add it to our current subset or exclude it and move on

Another Manner:

note that [2, 1] and [1, 2] are the same subsets, we are not dealing with permutation

We have a choice for every element

we either include or not 

We have now 2 decisions for n elements so then we have 2^n subsets

We note each subset can be up to the length n

So that means the time complexity is O(n * 2^n)

so we will deal with backtracking which is brute force and efficient solution

so starting from 1 in [1, 2, 3]

our decisions are [] or [1]

then moving to 2

the decisions are [], [2], [1, 2], [1]

then we move on to 3 and we have

[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []

the final level is the complete answer
*/
