class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        following = new HashMap<>(); 
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        following.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for(int followeeId : following.get(userId)){
            if(tweets.containsKey(followeeId)){
                List<int[]> tweet = tweets.get(followeeId);
                int index = tweet.size() - 1;
                int[] twe = tweet.get(index);
                minHeap.offer(new int[]{twe[0], twe[1], followeeId, index});
            }
        }

        while(!minHeap.isEmpty() && ans.size() < 10){
            int[] currentTweet = minHeap.poll();
            ans.add(currentTweet[1]);
            int index = currentTweet[3];

            if(index > 0){
                int[] tweet = tweets.get(currentTweet[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], currentTweet[2], index - 1});
            }
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        following.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
