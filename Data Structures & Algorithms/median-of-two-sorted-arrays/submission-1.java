class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we want to ensure that we are running binary search on the smaller of the two arrays
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;
        // find the midpoint of both combined arrays, total
        int half = (x + y + 1) / 2;
        
        // note that the pointers are set to run on the smaller array as we set to be nums1
        int left = 0, right = x;

        while(left <= right){
            // midpointX helps find the start of our left partion
            int midpointX = left + (right - left) / 2;
            // midpointY is set to be the remaining indices needed to complete our left partition
            // an example would be if our total was 13 and our half was 6, then the midpoint of our first array would be for example 2, these 3 indices (as array is 0 index based) would then fill up the 3 out of the 6 positions needed for the left half and then the other array that we didn't run binary search, we then would take the rest of the indices from that array to complete our left half
            int midpointY = half - midpointX;

            // these next 4 lines of code will help with edge casing
            // if the partition implies an empty subarray then it is then easy to compare the values if we set it to Integer.MIN_VALUE or Integer.MAX_VALUE as when comparing we would take the numerical value
            int minXleft = midpointX > 0 ? nums1[midpointX - 1] : Integer.MIN_VALUE;
            int maxXright = midpointX < x ? nums1[midpointX] : Integer.MAX_VALUE;

            int minYleft = midpointY > 0 ? nums2[midpointY - 1] : Integer.MIN_VALUE;
            int maxYright = midpointY < y ? nums2[midpointY] : Integer.MAX_VALUE;

            // we check for a valid partition
            // we check if the elements on the left side of the partition is either less than or equal to the right side of the partition for both arrays
            if(minXleft <= maxYright && minYleft <= maxXright){
                // we check if the total length is odd as that would imply that the median is the maximum of the two elements on the left side
                if((x + y) % 2 != 0) return Math.max(minXleft, minYleft);
                // else if the total length is even, the median is the average of the maximum of the two elements on the left side and the minimum of the two elements on the right side
                return (Math.min(maxXright, maxYright) + Math.max(minXleft, minYleft)) / 2.0; 
            } 
            // now if we don't have a correct partition, we then adjust our values to find the correct split
            else if(minXleft > maxYright) right = midpointX - 1;
            else left = midpointX + 1;
        }

        return -1;
    }
}