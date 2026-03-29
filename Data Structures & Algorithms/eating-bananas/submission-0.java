class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we set our low value to 0 as cannot have a rate of 0 when eating bananas
        int low = 1, high = 0;
        // we find the greatest number in the pile as that wo;; be the max number of bananas we can eat in an hour
        for(int pile : piles) high = Math.max(high, pile);

        while(low < high){
            int middle = low + (high - low) / 2;
            // we check if we can eat within our set period of time all the bananas given our current rate
            // if we can then we adjust to find a smaller rate else we adjust to a higher rate
            if(canEat(piles, h, middle)) high = middle;
            else low = middle + 1;
        }

        return low;
    }

    // helper function to return if it is possible to eat all bananas in the pile at the rate k with h hours
    private boolean canEat(int[] piles, int h, int k){
        int hours = 0;
        
        for(int pile : piles){
            // (p + k - 1) / k
            // the above equation helps calculate the hours needed to eat the pile given the rate k as this equation will round up
            // we could also use Math.ceil((double) pile / k)
            hours += (pile + k - 1) / k;
            // if the time it takes to eat all the bananas at our current rate is greater then the time given, we return false
            if(hours > h) return false;
        }

        return true;
    }
}
