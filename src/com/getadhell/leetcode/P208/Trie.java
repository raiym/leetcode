package com.getadhell.leetcode.P208;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        this.children = new TrieNode[27];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int letter = word.charAt(i) - 97;
            if (current.children[letter] == null) {
                current.children[letter] = new TrieNode();
            }
            current = current.children[letter];
        }
        current.children[26] = new TrieNode();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int letter = word.charAt(i) - 97;
            if (current.children[letter] == null) {
                return false;
            }
            current = current.children[letter];
        }
        return current.children[26] != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int letter = prefix.charAt(i) - 97;
            if (current.children[letter] == null) {
                return false;
            }
            current = current.children[letter];
        }
        return true;

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");