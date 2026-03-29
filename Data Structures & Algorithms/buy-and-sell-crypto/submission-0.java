class Solution {
    public int maxProfit(int[] prices) {
        // we set the minprice to be the max value that way when compared to a numerical value it will bet set to that, maxprice is 0 due to the edge case of returning 0 if no profit made
        int minprice = Integer.MAX_VALUE, maxprofit = 0;

        for(int price : prices){
            // we check to see if there is a cheaper price to buy and if there is then we update to that
            if(price < minprice) minprice = price;
            // we calculate the potential profit by taking the current price and subtracting it from our minprice
            int profit = price - minprice;
            // if that profit is now greater than our maxprofit, then we update our maxprofit to be our current profit
            if(profit > maxprofit) maxprofit = profit;
        }

        return maxprofit;
    }
}