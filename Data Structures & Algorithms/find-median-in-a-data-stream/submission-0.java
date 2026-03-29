class MedianFinder {
    // we have two heaps
    // small heap -> max heap
    // large heap -> min heap
    // heaps should be equal in size
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        // we initialize both our heaps
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());;
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // we always add num to the small heap/max heap
        maxHeap.offer(num);

        // order difference

        // we make sure that every num in max heap is less than equal to all elements in min heap
        // we ensure both heaps are not empty and if the value in the maxHeap is greater than that of the min
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() >= minHeap.peek()) {
            // if so we pop the max value of the maxHeap
            int value = maxHeap.poll();
            // and add it to the min heap
            minHeap.offer(value);
        }

        // size difference

        // we now check the sizes of the heaps, to ensure no difference of greater than 1
        if(maxHeap.size() > minHeap.size() + 1){
            // we pop from the max heap
            int value = maxHeap.poll();
            // and add it to the min heap
            minHeap.offer(value);
        }

        // we check the second case
        if(minHeap.size() > maxHeap.size() + 1){
            // we pop from the min heap
            int value = minHeap.poll();
            // and add it to the max heap
            maxHeap.offer(value);
        }
    }
    
    public double findMedian() {
        // we find the median
        // we check for odd length
        if(maxHeap.size() > minHeap.size()){
            // if max heap is greater in size then min heap that means they are not equal in size so odd length as one has 1 more
            // so we peek from the max heap, return the max
            return maxHeap.peek();
        }

        // now if the minHeap is greater in size
       if(minHeap.size() > maxHeap.size()){
            // we peak from the min heap, we get the min
            return minHeap.peek();
       }

       // if we have an even length what we do is
       // we get the max of max heap and min of min heap and add to then divide by 2
       return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/*
We will read the question

so we want to find the median 

we have three functions to implements

MedianFinder will create the object of the class

the second one does not return anything but it does add the numbers

the last function will be the find median where we get the median of our numbers so far
note for the find median function returns a double as if the length is even, then we return the mean of the middle two values with can be a decimal

so lets walk through the input

Input:
["MedianFinder", "addNum", "1", "findMedian", "addNum", "3" "findMedian", "addNum", "2", "findMedian"]

Output:
[null, null, 1.0, null, 2.0, null, 2.0]

what the first one does

what i note, the call MedianFinder is just to initialize the object

the addnum and the num begin one, means we the number 1 to the array having [1]

then when we have findMedian on this array we note the median from [1] is 1.0 which is the form of a double

then we addNum 3 which makes the arr [1, 3]

then we call the find median which 1 + 3 / 2 which is 2.0 and note we do / in java and not // as we want the decimal

we then addNum 2 which makes the arr = [1, 2, 3], note how the array sorts itself that is interesting 

we then call findMedian and thus giving us 2.0 as the median

how we should approach this problem as a thought:

We can use two heaps

one max heap for the left side of the array of numbers
one min Heap for the right side

so that way we can return the middle values faster

so the max heap would contain the smaller numbers and the min heap would have the larger numbers

So what we can do is add the number to one of the heaps

balance the heap in a way that the sizes are only different by one element

this so that the median of an even array is the average of both heaps top divided by 2
and the median of an odd length is the top of the max heap

note in java that we have min heaps at default

Here is an explanation to solve

Brute force

We can insert the elements in order

we want to maintain a list

everytime we have an add call, we insert in order
we make sure the array is always sorted as the median will always be in middle position

we can add 3 so we have [3]

so now if we we were to add 2, we have to do a shift to have [2,3] and this O(n) time to add a number

now if we add 1, we have to traverse the array to find the position to have [1, 2, 3]

to add 4, we search again and have [1, 2, 3, 4]

when we call find median we then take the 2 middle elements and find average of 2.5 which is O(1) time

We want to improve the add number function so that it is linear time for adding n times

so instead of one list of elements we will break it up to 2

we will have two subsets with elements seperated by values such as [1, 2] and [3,4]

noting that all elements in the left will be less than or equal to that of the right making it easy to find the median

We will use heaps instead of arrays

Optimized

We will have a min and max heap

the max heap will have elements less then or equal to that of the min heap

we also want to ensure that the heaps are equal in size or at least one off due to an odd length

If we have one heap greater in size by 2 or more then we know we must balance them

with a heap, adding a number will be a log(n) operation and so is removing rather than that of O(n)

finding the max of a max heap will be O(1) compared to O(n)

with a min heap, finding the min is O(1)

the small heap will be a max heap, as if we had 1 and 2 in the heap, we want 2 which is the max
so then the large heap is then a min heap so that 3 and 4, we want 3 which is the min
this will help with finding the median in O(1), the max of the small numbers and min of the large numbers

Ensure that the sizes are equal

now if the sizes are off by 1, that means we have an odd array and so we get the value from the max of the max heap
understand it that if we had a heap with [1, 2, 3] and [4,5] we take the max of first one as that is the median
if we had [1, 2] and [2, 3, 4], we would take the min of the min heap and so we take the top of the heap with greater size

so walk through

we have max and min heap

maxH []
min []

we add 3 
max[3]
min[]

we add 2 and by default we always add to the max heap, insertion is logn

max [3, 2]
min []

to then balance the heaps as sizes are difference of two
we add the max value of the max heap to the min heap 
we find the max in O(1) and remove it in logn and add to min heap is logn

max [2]
min [3]

we then do add 7

by default we add to small heap which is the max heap

max [2, 7]
min [3]

yet we must remember that every element in the max heap is less than or equal to that of the min heap

we find the max of the max heap which is 7 and find the min of the min heap which is 3
which 7 is not less than or equal to 3

so we must find the max in the max heap, remove it, and add it to the min heap

max [2]
min [3, 7]

now our condition is true

we add 4
by default we then add to max heap

max [2, 4]
min [3, 7]

our condition doesn't hold true as the max of the max heap is not less than or equal to the min of min heap
as 4 is not less than or equal to 3

so what we do is find the max in the max heap and remove it and add it to the min heap

max [2]
min [3, 4, 7]

we notice that the sizes are different by 2

so we find the min of the min heap and remove it and add it to the max heap

we then have 

max [2,3]
min [4, 7]

we now find the median which is O(1)

where as we have an even arrays so we get the min of the min heap and max of the max heap and add then divide by 2 
so we have the min 4 and max 3 whcih is 7 added and divided by 2 is 3.5
*/
