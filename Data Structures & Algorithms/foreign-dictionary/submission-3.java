class Solution {
    public String foreignDictionary(String[] words) {
        // we will create our graph as an adjacency list
        // for every character in our list of words, we will map it to a set 
        Map<Character, Set<Character>> map = new HashMap<>();

        for(String word : words){
            for (char c : word.toCharArray()) map.putIfAbsent(c, new HashSet<>()); 
        }

        // we will now iterate through every pair of words
        for(int i = 0; i < words.length - 1; i++){
            // we will get word A and word B for our pair
            String a = words[i], b = words[i + 1];

            // edge case
            // if b is longer than a and a is a substring of b
            // this is an invalid order
            // we return an empty string
            if(a.length() > b.length() && a.startsWith(b)) return "";

            // we go through every character within our pair
            for(int j = 0; j < Math.min(a.length(), b.length()); j++){
                // we want to find the first differing character
                if(a.charAt(j) != b.charAt(j)){
                    // we add this to our adjacency list
                    // the character in word 2 comes after the character in word 1
                    // the character of word 1 is the key and the character of word 2 is the value
                    map.get(a.charAt(j)).add(b.charAt(j));
                    // we break as we only need the first differing character
                    break;
                }
            }
        }

        // we keep track of visited nodes
        // we will use a hashmap
        // the key is the node
        // the value is either true or false if it has been visited or not and in current path
        Map<Character, Boolean> visited = new HashMap<>();

        // we will maintain the result as we visit the nodes
        StringBuilder res = new StringBuilder();

        // we call our helper function
        // we iterate through all characters in our graph
        for(Character ch : map.keySet()){
            // if this is true, we found a loop
            // if we find a loop, we return empty string
            if(helper(ch, map, visited, res)) return "";
        }

        // we return the result in reverse order
        return res.reverse().toString();
    }

    // recursive helper function to carry out post order dfs
    private boolean helper(Character node, Map<Character, Set<Character>> map, Map<Character, Boolean> visited, StringBuilder res){
        // we check if the current node has been visited
        // if it has been visited we return false
        // if the helper function returns true, we have detected a loop
        if(visited.containsKey(node)) return visited.get(node);

        // we then mark the character as visited
        visited.put(node, true);

        // we will now go through every neighbor of this node andd run dfs on it
        for(Character neighbor : map.get(node)){
            // if this returns true, we return true immediately as we have a loop
            if(helper(neighbor, map, visited, res)) return true;
        }

        // we then mark the character as false as would no longer be in the current path
        visited.put(node, false);

        // we now append this character to our result
        res.append(node);

        return false;
    }
}

/*
We are given an array of strings

We are asked to return a string

Description:

We are given a foreign language which uses the latin alphabet

But we note that the order among the letters is not that of the english language

We recieve a list of non-empty strings from the dictionary

where the words are sorted lexicographically based on the rules of the language

We want to derive the order of letters in this language

If the order is invalid, we return an empty string

If there are multiple valid order of letters, we can return any of them

A string is lexicographically smaller than another string if either of the following is true:

the first letter where they differ is smaller in the first string than in the second one

the first string is a prefix of the second one and the length of the first string is less than that of the second one

Example:

Input: ["z","o"]

The first and second string differ

The first letter they differ at we can see that the first string is smaller than the second one, z < o

So we would return zo 

An Approach:

We will use Kahn's Algorithm

We will build graph

We will treat each character as a node

We compare each pair of adjacent words

For the first different character between two words

We can:

Add a directed edge from the character in the first word to the character in the second word

This edge would mean that this character comes before the other character

We will keep track of the in degrees

We will have an in degree map to keep track of how many edges point to each character

We will use this to identify characters with 0 dependencies as these would be ready to be placed in the output

We will now use topological sort

We will use bfs amd so use a queue 

So we will add to the queue all the characters with an in degree of 0

For each character removed from the queue:

We add it to the result

We decrease the in degree of its neighbors

If the neighbors in degrees become 0, we add it to the queue

If we can't proccess all characters, then a cycle exists, and so we return ""

We must note

if the first word is longer than the second word and the first word is a prefix of the second word, this is invalid and so return ""

Another Approach:

As we iterate through all words

We compare adjacent words

For the first character they differ, we note that in the first word that character comes before that character in the second word

From creating these edges for which characters come before which, we can then see we have a graph, we then can traverse this graph

If there is a cycle in our graph, we return ""

We will use topological sort, but in the manner that it is post order dfs 

We then return the result in reverse

We will keep note if a node is in our path and visited nodes
*/