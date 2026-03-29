class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // we want to ensure the end word is in the word list as this ensures a path
        // if it doesn't exist, we return 0
        if(!wordList.contains(endWord)) return 0;

        // adjacency list

        // we list out our  neighbors
        Map<String, List<String>> map = new HashMap<>();

        // we will add the begin word to the word list
        wordList.add(beginWord);

        // we build the adjacency list
        // we go through every word in the word list
        for(String word : wordList){
            // we go through every character in the word to find every pattern for the word
            for(int i = 0; i < word.length(); i++){
                // for each character, we want to replace it with a wildcard character
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                String pattern = sb.toString();

                // we then want to add the pattern and the word to the map
                if(!map.containsKey(pattern)){
                    List<String> lis = new ArrayList<>();
                    lis.add(word);
                    map.put(pattern, lis);
                }
                else map.get(pattern).add(word);
            }
        }

        // we will now run bfs

        // we don't want to visit same position twice so will use set
        // we start at the begin word so we add it to the set
        Set<String> set = new HashSet<>();

        set.add(beginWord);

        // we need a queue for bfs
        // we add begin word to queue as it is the first layer
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        // length of path
        int result = 0;

        // we carry out bfs as long as queue is not empty
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                // we through every node and pop it
                String word = queue.poll();

                // we check if the word in the queue is the end word
                // if so we return the length of the path
                if(word.equals(endWord)) return result + 1;

                // if it is not the end word, we will take the neighbor of the word and add it to the queue
                // to get the neighbor of the word, we must see all the patterns our current word falls into and get all the other words in the same pattern

                // we transform the current word to the pattern
                for(int j = 0; j < word.length(); j++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(j, '*');
                    String pattern = sb.toString();

                    // we will now get all the neighbors of the word given the pattern
                    for(String neighbor : map.get(pattern)){
                        // to ensure that we don't add the same word
                        // we check if it has been visited
                        if(!set.contains(neighbor)){
                            // we add to the visited set
                            set.add(neighbor);
                            // we add it to the queue;
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            // after we go through a layer, we increment our result
            result++;
        }

        return 0;
    }
}

/*
We are to return an int

We are given 2 strings and a list of strings

Description:

We have two words 

We have a begin word and an end word

We also have a list of words

All the words in our list and the end and begin word are the same length and all lowercase letters

We have a goal

We want to take our begin word and transform it to the end word

To transform it, we must:

we can transform the begin word to any word in our list given that only one character in any position is different

we can repeat this step with the new word we transformed to and we do this as many times needed

We want to then return the minimum number of words within the transformation sequence needed to obtain the end word

If there is no sequence that can reach the end word from the begin word, we return 0

Example:

Input: beginWord = "cat", endWord = "sag", wordList = ["bat","bag","sag","dag","dot"]

We start at cat and change one letter and so we get bat, then from there we go to bag and then sag which is the end word

we return 4 as the number of words in the transformation sequence

An Approach:

We will treat this problem like the short path problem with an unweighted graph

We will treat each word as a node

We have an edge between two words/nodes if the words differ by one character in any position

We start from the begin word and want to reach the end word with the minimum number of steps

We will be using bfs

So what we will do is add all of the words to a set

we note that if the end word is not in our set, we return 0

We will use a queue to traverse by levels, the begin word will be level 1

while the queue is not empty

for each word at the current level, we generate all the words possible that differ by one character in any position

if this new word is in the set, we add it to the queue and remove it from the set to prevent from revisiting it

if we can reach the end word with these steps then we return the current level

Now if bfs ends and the end word is not reached, we return 0

to help create all possible words that differ by one character in any position, we would replace every character with 'a' to 'z' and seeing if this new word is in the set

Another Approach:

We will create an adjacency list

the key is the pattern/wild card

the value is a list of words

the adjacency list will be built using a hashmap

we find all the patterns of a word and check the value of each pattern in the map

we will then run bfs on the adjacency list
*/