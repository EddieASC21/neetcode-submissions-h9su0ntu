class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // we have a list of lists as our answer
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> combination = new ArrayList<>();

        // we must sort our array
        Arrays.sort(candidates);

        helper(candidates, target, 0, ans, combination, 0);

        return ans;
    }

    // we have a helper function to help carryout the backtracking
    private void helper(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> combination, int total){
        // base case

        // we reach the target amount
        if(total == target){
            // if so we have a valid combination to add
            ans.add(new ArrayList<>(combination));
            return;
        }

        // total is greater than target or no more candidates left
        // this will not give a valid combination
        if(total > target || index >= candidates.length) return;

        // recursive case

        // we include the element candidates[index]
        combination.add(candidates[index]);
        // we must update our index as we can only use each element at most once
        // we update total with adding candidates[index]
        helper(candidates, target, index + 1, ans, combination, total + candidates[index]);

        // we don't include candidates[index]
        // we remove the element we added
        combination.remove(combination.size() - 1);
        // we have to ensure that when we skip, we don't skip to a candidate with the same value as the candidate we just skipped
        // so we ensure we update our index until we are on a new value of a candidate and ensuring we are also in bounds as we are saying i + 1
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;
        // then we run our recursive case skipping this candidate and the candidates with the same value and now updating our index
        helper(candidates, target, index + 1, ans, combination, total);
    }
}

/*
Here we go with another question

We have an array of integers, we call these integers candidates

note that we may have duplicate candidates i our array

we also have a target we want to sum up to called target

we nota that we are returning a list of list of integers

where the list is all unique combination of candidates being added up to target

each candidate may be chosen at most once and we cannot have duplicate combinations

we can return the candidates in any order and the combinations in any order

lets walk through an example

candidates = [9,2,2,4,6,1,5], target = 8

we can either take or not

so we would take 9, greater than 8 so no

we don't take 9 and take 2

we have 2 and we decide take 2 and now have 4 and [2, 2]

note duplicate values are allowed but not candidates which we track by index

we take take 4 and we have 8, a valid combination

okay what if we don't take 4 and take 6, 10 > 8 so no

we backtrack and don't take 6, take 1, we have 5

we take 5 and that is greater than 8 as we have 10 so no

we bactrack to now [2,2] don't take 1 and take 5 which is still too big

we then backtrack to [2], we skip 2 and take 4 we are 6

we take 6 and are over so instead we take 1 and are at 7 

we take 5 and note its too big as 12 > 8, so backtrack to [2]

we skip 4 and take 6 to find another valid combination

as we have found a combination, we add it and back track to [2]

we skip 6 and take 1 and then take 5 which makes another valid combination

we backtrack [] and instead take 4 and so on

we note at the end we find all valid combinations

[1,2,5], [2,2,4], [2,6]

we used recursive backtracking 

An approach:

So we could sort the array to help keep track of duplicate element's values

we use backtracking with passing in the index to not use duplicate elements

Another approach as the last one was mid

note that with target 8 for example and array [1, 7, 1]

[1, 7] and [7, 1] are the same solution and is a duplicate

even if the ones we used are different candidates in terms of index

The problem lies in the duplicate combinations and we can avoid this 

We decide to sort the array

This will help with having all duplicate elements together

This makes it easier to now have a decision tree

With having duplicates grouped, if we decide not to include it, it makes it easier to shift to another

such as [1, 1, 2, 3]

We can choose 1 or skip 1

but in the past if we skip the 1, we still end up on 1

so now what we have is if its the same value, we skip till we get to 2

so the decision tree is either [1] or [] then from [] to [2] and []

for [1] we then include [1, 1] or [1]

for [1, 1] we can have [1, 1, 2] or [1,1] and so on

we just note that on the right side that 1 is not included even if we have multiple 1's in the array
*/
