class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] arr = new int[26];

            for(int i = 0; i < str.length(); i++){
                arr[str.charAt(i) - 'a']++;
            }

            String diff = Arrays.toString(arr);
            
            if(map.containsKey(diff)){
                List lis =  map.get(diff);
                lis.add(str);
                map.put(diff, lis);
            }
            else{
                List<String> lis = new ArrayList<>();
                lis.add(str);
                map.put(diff, lis);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for(String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}


/*
reference anagrams on how to solve this 

you use the array as the key but the array is not hashable so we use a string 

we convert the array into a string

so then we use that string as the key and then we would have that mapped onto the value which is the words in which that array/string corresponds to
*/