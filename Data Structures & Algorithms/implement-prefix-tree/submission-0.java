public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null) current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = helper(word);
        return node != null && node.endOfWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = helper(prefix);
        return node != null;
    }

    private TrieNode helper(String str){
        TrieNode current = root;
        for(char c : str.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null) return null;
            current = current.children[index];
        }

        return current;
    }
}
