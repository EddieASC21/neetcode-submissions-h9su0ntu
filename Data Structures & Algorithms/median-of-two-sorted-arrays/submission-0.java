class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int half = (x + y + 1) / 2;

        int left = 0, right = x;

        while(left <= right){
            int midpointX = left + (right - left) / 2;
            int midpointY = half - midpointX;

            int minXleft = midpointX > 0 ? nums1[midpointX - 1] : Integer.MIN_VALUE;
            int maxXright = midpointX < x ? nums1[midpointX] : Integer.MAX_VALUE;

            int minYleft = midpointY > 0 ? nums2[midpointY - 1] : Integer.MIN_VALUE;
            int maxYright = midpointY < y ? nums2[midpointY] : Integer.MAX_VALUE;

            if(minXleft <= maxYright && minYleft <= maxXright){
                if((x + y) % 2 != 0) return Math.max(minXleft, minYleft);
                return (Math.min(maxXright, maxYright) + Math.max(minXleft, minYleft)) / 2.0;
            } else if (minXleft > maxYright) right = midpointX - 1;
            else left = midpointX + 1;
        }

        return -1;
    }
}
