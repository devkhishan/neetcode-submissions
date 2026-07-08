class Twitter {
    record User(Set<Integer> followers, List<int[]> posts) {}
    
    private static Map<Integer, User> users;
    private static int time;
    public Twitter() {
        users = new HashMap<>();
    }
    public void createUserIfNotExists(int userId) {
        if (!users.containsKey(userId)) {
            Set<Integer> followers = new HashSet<>();
            List<int[]> posts = new ArrayList<>();
            users.put(userId, new User(followers, posts));
        }
    }
    public void postTweet(int userId, int tweetId) {
        createUserIfNotExists(userId);
        users.get(userId).posts().add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> temp = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        temp.addAll(users.get(userId).posts());
   
        for(int i : users.get(userId).followers()) {
            temp.addAll(users.get(i).posts());
        }
        
        int k = Math.min(10, temp.size()); 
        while (k-- > 0) res.add(temp.poll()[1]);

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        createUserIfNotExists(followerId);
        users.get(followerId).followers().add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        createUserIfNotExists(followerId);
        users.get(followerId).followers().remove(followeeId);
    }
}
