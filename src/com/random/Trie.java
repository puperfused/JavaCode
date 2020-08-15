import java.util.*;

/** Implement a trie data structure with following methods
 *  1) addWord() -- adds the word in tree or dictionary
 *  2) searchWord() -- search for the word if it exist in dictionary
 * 
 */

 class TrieNode {

    TrieNode[] childs;
    boolean isLeafNode;
    
    TrieNode() {
        for(int i=0; i<26; i++) {
            this.childs = new TrieNode[26];
        }
    }
 }

 class TrieUtil {

     public static void addWord(TrieNode root, String str) {
        int len = str.length();
        TrieNode temp = root;
        for(int i=0; i<len ; i++) {
            int idx = str.charAt(i) - 'a';
            if(temp.childs[idx] == null) {
                temp.childs[idx] = new TrieNode();
            }
            temp = temp.childs[idx];
        }
        temp.isLeafNode = true;
     }

     public static boolean searchString(TrieNode root, String str) {
         int len = str.length();
         TrieNode temp = root;
         for(int i=0; i<len; i++) {
             int idx = str.charAt(i) - 'a';
             if(temp.childs[idx] == null) {
                 return false;
             }
             temp = temp.childs[idx];
         }
         return (temp != null && temp.isLeafNode);
     }
 }

 class Trie {
     public static void main(String args[]) {
         TrieNode root = new TrieNode();
         String[] arr = {"algo", "also", "all", "aloo"};
         for(String str : arr) {
             TrieUtil.addWord(root, str);
         }

         boolean found1 = TrieUtil.searchString(root, arr[0]);
         System.out.println("String " + arr[0] + " exists " + found1);

         boolean found2 = TrieUtil.searchString(root, arr[1]);
         System.out.println("String " + arr[1] + " exists " + found2);

         boolean found3 = TrieUtil.searchString(root, "dfh");
         System.out.println("String dfh exists " + found3);

         boolean found4 = TrieUtil.searchString(root, "alie");
         System.out.println("String alie exists " + found4);

         boolean found5 = TrieUtil.searchString(root, arr[2]);
         System.out.println("String " + arr[2] + " exists " + found5);
     }
 }