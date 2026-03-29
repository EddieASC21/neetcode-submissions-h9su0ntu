class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
		int start = 0;
		int total = 0;
		
		for(int i = 0; i < gas.length; i++){
				int netGain = gas[i] - cost[i];
				curr += netGain;
				total += netGain;
				
				// check if we run out of gas at this point
				if(curr < 0){
						// reset starting point to the next station
						start = i + 1;
						// reset current gas to 0 because we're starting afresh
						curr = 0;
				}
		}
		
		// After one complete iteration, check if total gas is enough to cover total cost, if not return -1
		return total >= 0 ? start : -1;
    }
}
