class TimeMap {

    // initialize a hashmap to store the keys and store a list of data pbjects that holds the value and the timestamp
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    // we check if the key isn't present in the hashmap to then add a new list to this key if needed
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        // if key is present we add the new data to the end of the array as that is done in constant time
        map.get(key).add(new Data(value, timestamp));
    }
    
    // we check if the key exists first and if not we return empty string
    // if the key does exist, we access the list of data objects and we use binary search to find the correct value for the given time stamp
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    // we conduct binary search to recieve the value as we set our pointers and narrow as we go, we return if we find the timestamp equal to the one passed but if not found we narrow down based off value and so if we don't find the exact value we return the closest value from it in the sense that 2 is closest to 4 compared to 5
    private String binarySearch(List<Data> list, int timestamp){
        int low = 0, high = list.size() - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(list.get(mid).timestamp == timestamp) return list.get(mid).value;
            else if(list.get(mid).timestamp < timestamp) low = mid + 1;
            else high = mid - 1;
        }

        return high >= 0 ? list.get(high).value : "";
    }

    class Data{
        String value;
        int timestamp;

        Data(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */