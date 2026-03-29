class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        double[][] pair = new double[n][2];
        // we add the values to our pair so that we know the position and remaining time to reach target
        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            // we calculate the time needed to reach the target 
            pair[i][1] = (double) (target - position[i]) / speed[i];
        }

        // we sort the cars based on their position based on those closest to their destination
        Arrays.sort(pair, (a, b) -> Double.compare(a[0], b[0]));

        int fleet = 0;
        double timeRemain = 0; 
        // we iterate from the closest to farthest to their destination
        for(int i = n - 1; i >= 0; i--){
            // if the current car time to reach their destination is less than the time remain from the car before it, then a new fleet is added as the car will never catch up to the other car(s)
            if(pair[i][1] > timeRemain){
                fleet++;
                // we update the current timeRemain such that it displays the time remaining of our current fleet
                timeRemain = pair[i][1];
            }
        }

        return fleet;
    }
}
