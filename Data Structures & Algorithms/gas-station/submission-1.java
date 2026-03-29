class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // we keep track of the total, current gas, and start index we can possibly return 
        int total = 0, current = 0, start = 0;

        // we iterate through the array
        for(int i = 0; i < gas.length; i++){
            // we find the total level by subtracting cost from the amount of gas we obtained at this index
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];

            // if the total is negative, we update our candiate start and reset our total
            if(current < 0){
                current = 0;
                start = i + 1;
            }
        }

        // we check if total is negative at the end 
        // if it is we return -1
        // else we return the valid starting position 
        return total >= 0 ? start : -1;
    }
}

/*
We are given two array of integers

We are asked to return an integer

Description:

We have n gas stations along a circular route

We are given two integer arrays representing cost and gas where:

the element in gas is the amount of gas at this station's index

the element in cost is the amount of gas needed to travel from this index to the next index

We note that the last station is connected to the first station

We have a car that can store an unlimited amount of gas

We start the journey with an empty tank at one of the gas stations

We want to return the starting gas station's index such that we can travel around the circuit once

If we cannot, we return -1

We are guarenteed at most one solution exists

Example:

Input: gas = [1,2,3,4], cost = [2,2,4,1]

So we will try from index 0

We start with an empty tank and can fill up with 1 

Yet the cost to get to the next index is 2

so we cannot try this index

We continue like this until we get to try the last index

We start with an empty tank and fill it up to 4

The cost to go the the next station is 1 and at the next station we can fill up 1

Our tank is now 4

We can reach the next station with a cost of 2 and fill up the tank with 2

Our tank is now at 4

We can now fill up our tank with 3 while having a cost of 2 to go to the next index

We have a tank of 5 now

We can then travel the next index at cost of 4 and pick up 4

We now have a tank that is greater than a negative number and so it is possible to reach all indeces from this index

So we return 3

An Approach:

We will use a greedy approach:

We note:

if the total amount of gas is less than the total cost, it is impossible to travel the circuit fully and we return -1

if the total gas is greater than or equal to the total cost, then a solution exists and its unique

We will try starting from index 0 and keep track of the current fuel in the tank

If at any point the tank becomes negative, this would be an invalid start point 

So then the start point chosen up till that index would be an invlaid choice to start at

We would reset the start position to the next index and reset the tank

So we will loop through all stations

We will track the total gas and cost

We will also track the current fuel in our tank

if the tank becomes negative, we set start to be i + 1 and reset the tank

After the loop we will check

if total gas is greater than or equal to total cost, we return start

else we will return -1

Another Approach:

We will keep track of our current tank level

if we ever reach a negative total, we reset its value

We would take the first index where the total is positive as there is a unique solution
*/