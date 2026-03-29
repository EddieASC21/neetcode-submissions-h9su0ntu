class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // we want to check if the length of array is divisble by the integer given
        if(hand.length % groupSize != 0) return false;

        // we will create a frequency map
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        // we will use min heap to keep track of the minimum value
        // the minimum value will be the starting value for the group
        // we add the keys of the map to the heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());

        // we will continue as long as the min heap is non empty
        while(!minHeap.isEmpty()){
            // we get the minimum value 
            int minVal = minHeap.peek();

            // we now see if we can create a group of size group size starting from our minVal
            for(int i = minVal; i < minVal + groupSize; i++){
                // we check if the value is in our hashmap
                if(!map.containsKey(i)) return false;
                // if available, we decrement its count in the hashmap
                map.put(i, map.get(i) - 1);
                // if the new count is 0, we must pop from min heap
                // we note though, if we try to pop this value and it is not the top, we return false
                if(map.get(i) == 0){
                    if(minHeap.peek() != i) return false;
                    // we then pop from the heap updating the minimum value
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}

/*
We are given an array of integers and an integer

We want to return a boolean

Description:

We are given an array of integers

Where each element in the array is the value of the card at this index

We are also given an integer group size

We want to rearrange the cards into groups so that each group is the size of group size

Where the cards values as well are consecutively increasing by 1

We want to return true if we can do so

Example:

Input: hand = [1,2,4,2,3,5,3,4], groupSize = 4

An Approach:

We check:

if the length of the given array modded by the integer given is not 0, then we are not able to divide the cards correctly into their needed groups

We will form the groups from the smallest available card to ensure a greedy approach

So for every smallest number, we will try to build a group such as x, x + 1, x + groupSize - 1

if any card is missing, we will return false

So the plan is:

We will count the frequency of each card using a frequency map or tree map

We will iterate from the smallest key to the largest one in ascending order

For each key, we will do two things

if it has a count/value greater than 0, we will try to form a group from this key

then from each index from 0 to groupsize - 1, we will check if key + 1 exists in our map

if yes, we subtract the count from that following index

if not, we return false

if at the end all cards can be grouped, we return true

Another Approach:

We keep track of the frequencies of the cards we have

We will always look at the minimum value available to us

From then we will see if we can make a group starting from that value

If we cannot create a group from this value, we return false

We also ensure that our array is divisble by our group size

So starting from the minimum value, we check if the next value exists in our map

If so, we use these values and decrement their count in the map 

From then we continue until the group size is met 

We can find the minimum values using a min heap

With adding the key values of our map to the min heap

Once a count of a key is 0, we pop that key from the min heap

The min heap will tell us the starting value of each new formed group

If the min heap is empty and can form the final group, we can return true

We can also use a tree map

We note that if we try to pop a value from the min heap that is not the top, we return false
*/