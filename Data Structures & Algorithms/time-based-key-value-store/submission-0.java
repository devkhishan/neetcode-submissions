class TimeMap {
    record Pair(int timestamp, String value){}
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> curr = map.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = curr.size()-1;
        String res = "";
        while (l<=r) {
            int mid = l + (r-l) / 2;
            if (curr.get(mid).timestamp() <= timestamp) {
                l = mid + 1;
                res = curr.get(mid).value();
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
