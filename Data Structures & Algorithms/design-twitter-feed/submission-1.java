class Twitter {

    // we have a time variable to help us note the most recent tweets
    private int time;

    // we have a map to help us map the user and the list of tweets that they have
    // posted
    // the key is the user and the value being the list of tweets where the tweet is
    // stored as the tweetid and the time stamp
    private Map<Integer, List<int[]>> tweets;

    // we have a map to maps the user to the set of users they are following
    // we have the following as a set to help us with fast look up to follow and
    // unfollow
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        // we set time as zero then decrement as will help keep track of how recent the
        // tweet is
        time = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // we need add the tweet the user has posted into the map with decreasing the
        // time with each time we tweet
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] { time--, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        // we use a minheap to help us retrieve the 10 most recent tweets from the user
        // and thier following
        // the minheap compares by the time stamp of the tweet
        List<Integer> recent = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // we must remember that it was said that the user is also following themself
        following.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : following.get(userId)) {
            if (tweets.containsKey(followeeId)) {
                List<int[]> tweet = tweets.get(followeeId);
                int index = tweet.size() - 1;
                int[] twe = tweet.get(index);
                minHeap.offer(new int[] { twe[0], twe[1], followeeId, index });
            }
        }

        while (!minHeap.isEmpty() && recent.size() < 10) {
            int[] currentTweet = minHeap.poll();
            recent.add(currentTweet[1]);
            int index = currentTweet[3];

            if (index > 0) {
                int[] tweet = tweets.get(currentTweet[2]).get(index - 1);
                minHeap.offer(new int[] { tweet[0], tweet[1], currentTweet[2], index - 1 });
            }
        }

        return recent;
    }

    public void follow(int followerId, int followeeId) {
        // we add the new following of the user if we haven't already hence the compute
        // if absent
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // if the person is following the followeeId then we do unfollow hence the
        // compute if present
        following.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */