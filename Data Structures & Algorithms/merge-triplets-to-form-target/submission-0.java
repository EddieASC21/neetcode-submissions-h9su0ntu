class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // we have a set to keep track of the indeces in target have been found
        Set<Integer> set = new HashSet<>();

        // we iterate through all triplets
        for(int[] t : triplets){
            // if at any index, the element in this triplet is greater than that in the target, we must ignore it
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;

            // we now iterate through this triplet
            // we check if the element in this triplet is equal to that of the target
            for (int i = 0; i < t.length; i++) {
                // if so, we can add this index to the set
                if (t[i] == target[i]) set.add(i);
            }
        }

        // if the size of our set is equal to that of the length of the target array, we return true as we can mark all indeces
        return set.size() == target.length;
    }
}

/*
We are given a 2D array of integers and an array of integers

We are asked to return a boolean

Description:

We are given a 2D array of integers

Where triplets[ai, bi, ci] represents the ith triplet

We are also given an array of integers 

where target = [x, y, z] which is the triplet we want to obtain

To obtain this target, we want to apply these operations on the 2D array either 0 or more times

We choose two different triplets

triplets[i] and triplets[j]

We update triplets[j] to become [max(ai, aj), max(bi, bj), max(ci, cj)]

So for example:

if triplets[i] = [1, 3, 1] and triplets[j] = [2, 1, 2]

so for triplets[j] we update to [max(1, 2), max(3, 1), max(1, 2)]

where now triplets[j] is [2, 3, 2]

We want to return true if we can achieve target as an element of triplets

Example:

Input: triplets = [[1,2,3],[7,1,1]], target = [7,2,3]

We take triples[j] as [max(1, 7), max(2, 1), max(3, 1)]

Now triplets[j] = [7, 2, 3]

This is equal to our target so we return true

An Approach:

We note that any element that exceeds the target can never be brought back down, so we must ignore these

So for any triplet where [a, b, c] is a > target[0] or b > target[1] or c > target[2] being true, we ignore it

As this can never participate 

So throughout each triplet, we see if a target element can be met once

so we check for 

some triplet where a == target[0]

some triplet where b == target[1]

some triplet where c == target[2]

if all three are found, we can merge the triplets to reach the target

Only then can we return true

Another Approach:

We note any triplet with a element greater than that in the target must be ignored

All we will do is go through every triplet

We want to find if any of the target elements can be found in any of our triplets

If we can find all target elements within all our triplets, we return true
*/