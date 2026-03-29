public class TrieNode{
    // we create the children of the TrieNode in which is 26 as there are 26 lowercase letters
    // this helps with finding the children in constant time
    TrieNode[] children = new TrieNode[26];
    // we have end to help keep track what is the end of a word that is stored in a trie
    boolean end = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        // we initialize the root of our TrieNode as will extend to all 26 lowercase letters
        root = new TrieNode();
    }
    
    public void insert(String word) {
        // we start our current pointer at the top of our trie
        TrieNode current = root;
        // we now iterate over the word given to us as an array of characters as trie store words as characters
        for(char c : word.toCharArray()){
            // we would find the index of where this character would be in the array of children for example 'a' has an ASCII value of 80 and so c - 80 dependeing on what c is such as c being a would mean a - 'a' is 0, where now a is stored at the 0 index of the children array
            int index = c - 'a';
            // if at the moment there is no character at this index and it is null then we update it and instantiate a trienode to now store that character in the trie 
            if(current.children[index] == null) current.children[index] = new TrieNode();
            // we now update and move onto the next character in the word as we have already created a trienode for the previous one
            current = current.children[index];
        }

        // after we have iterated over all the words in the string, when we get to the final trienode that we will add to the trie, we mark it as true to display the end of the word
        current.end = true;
    }

    public boolean search(String word) {
        // we use a helper function
        TrieNode node = helper(word);
        // we return true that word can be found in the trie if the node is not null showing that a path of nodes exist in the trie creating the word and the node.end is used to determine if that node is the end of the word, showing that the word exists
        return node != null && node.end;
    }
    
    public boolean startsWith(String prefix) {
        // we use a helper function
        TrieNode node = helper(prefix);
        // we return true if the node is not null as there is a path of nodes that create a combination to find the prefix given
        return node != null;
    }
    
    // helper function
    private TrieNode helper(String string){
        // we start at the top of the trie
        TrieNode current = root;
        // we iterate over the string given as an array of characters to work on each character
        for(char c : string.toCharArray()){
            // we find the index as said by subtracting the ACSII value from the current character and as 'a' ASCII value is 80 if c is b then 81 - 80 is 1 and the letter b would be stored in the first index of the children array
            int index = c - 'a';
            // if the index in which a character should exist as it is in the word is not present or not a trienode in the trie, that means that this string does not exist in the trie and so we return null immediately
            if(current.children[index] == null) return null;
            // we update our current pointer to the next trienode based off the index given which is calculated from the character in the word
            current = current.children[index]; 
        }

        // we return current as it will return null or not as it will help determine if the node exists and so a path exists of this string in the trie
        return current;
    }
}
