class Solution {
    public int findDuplicate(int[] nums) {
        // we set our pointers to the beginning of the array as our range is 1 to n and so we set both to 0
        int slow = 0, fast = 0;

        // we now use Floyd's algorithm to find the intersection
        do{
            // this is another way of saying slow = slow.next and fast = fast.next.next if this were given as a linked list
            // we shift once
            slow = nums[slow];
            // we shift twice
            fast = nums[nums[fast]];
        // we continue until we detect the cycle and find the intersection where slow and fast point at the same index
        } while(slow != fast);

        // after finding the intersection, we set slow to point at the beginning
        slow = 0;
        do{
            // we then move fast as fast = fast.next or in other words fast is shifted by one and not by two
            // we shift both once as when having a pointer at the intersection and another pointer at the beginning as when we then shift by one, we will find fast and slow pointer will point at the same index which would be the beginning of the cycle or in other words the duplicate number
            slow = nums[slow];
            fast = nums[fast];
        } while(slow != fast);

        // as said now slow will point to where the cycle begins and so that is the duplicate number and what we have to return
        return slow;
    }
}