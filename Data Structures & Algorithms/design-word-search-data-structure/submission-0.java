// we are creating the class TrieNode to then create an object of the class
public class TrieNode{
    // we create the children of the TrieNode where it is set to 26 as there are 26 lower case characters that can be the child of the current child TrieNode
    TrieNode[] children = new TrieNode[26];
    // we mark the TrieNode that represents the end of the word as a boolean to represent that if the TrieNode is equal to true then that node is the end of the word
    boolean endOfWord = false;
}

class WordDictionary {

    // we instantiate the root of the TrieNode so that we may begin adding the words to the trie and please note the root holds no valud
    private TrieNode root;

    public WordDictionary() {
        // we instantiate an object of the TrieNode class
        root = new TrieNode();
    }

    public void addWord(String word) {
        // we now begin starting at the root to add the word into the trie
        TrieNode current = root;

        // we iterate over each character in the word
        for(char c : word.toCharArray()){
            // we grab the current index of the current character we find ourselves on
            // we can determine its index by the ACSII value
            int index = c - 'a';
            // we check if the character is a node in the trie
            // if it is not a node in our trie, then we create a new trienode for this index
            if(current.children[index] == null) current.children[index] = new TrieNode();
            // if a node exists for this index then we would just move our pointer to point at this node
            current = current.children[index];
        }

        // once we reach the last character in the word, we set that node as true to mark it as the end of the word
        current.endOfWord = true;

    }

    public boolean search(String word) {
        // we call our helper function to determine if the word exists in the trie and that including with a '.'
        return helper(word, 0, root);
    }

    // recursive helper function
    private boolean helper(String word, int j, TrieNode root){
        // we would initialize our current pointer to point at the root of thr trie
        TrieNode current = root;
        
        // we iterate over all the characters in the word
        for(int i = j; i < word.length(); i++){
            // we grab the current character we are currently to check if it is a character or '.'
            char c = word.charAt(i);
            // we check if the current we are on is a '.'
            if(c == '.'){
                // we now iterate over all of the children of the trie for the current character
                for(TrieNode child : current.children){
                    // we now would run a dfs and see if there is a possible combination that could be made to find the word in the trie while ensuring that no node we pass is null
                    if(child != null && helper(word, i + 1, child)) return true;
                }

                // as '.' is a wildcard and can point to any character it wants in the trie if it exists, then we return false if we could not find a combination to find the word in the trie
                return false;
            }
            // now if the current character is not a '.'
            else{
                // we now grab the current index in the children array based off the ACSII value of the current charater we are at in the word
                int index = c - 'a';
                // we now check if this node exists because if not we return false
                if(current.children[index] == null) return false;
                // if the node exists then we update our current pointer to point at this node and continue
                current = current.children[index];
            }
        }

        // if we have not returned false yet and have reached the last character in the word, we check if the node is marked as true as that will show the end of the word meaning the word exists in the trie
        return current.endOfWord;
    }
}
