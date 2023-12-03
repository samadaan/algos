package com.samadaan.demo;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        TrieNode node = insert(null,"abc", 0);
        insert(node,"abcd", 0);
        insert(node,"ef", 0);
        insert(node,"ghi", 0);
        deleteWord(node,"ghi",0,null);
        deleteWord(node,"abc",0,null);
        deleteWord(node,"abcd",0,null);
        System.out.println(wordSearch(node,"abc",0));
        System.out.println(wordSearch(node,"abcd",0));
        System.out.println(wordSearch(node,"ef",0));
        System.out.println(wordSearch(node,"ghi",0));
        System.out.println(wordSearch(node,"xyz",0));

    }

    public static class TrieNode{
        public Map<Character,TrieNode> children;
        public boolean endOfWord;

        public TrieNode(){
            children=new HashMap<>();
            endOfWord=false;
        }
    }
    public static TrieNode insert(TrieNode node, String str,Integer index){
        if(index==str.length()){
            node.endOfWord=true;
            return node;
        }
        char x=str.charAt(index);
        if(node==null){
            node=new TrieNode();
        }
        if(node.children.containsKey(x)){
            insert(node.children.get(x), str, index+1);
        }else{
            node.children.put(x, new TrieNode());
            insert(node.children.get(x), str, index+1);

        }
        return node;
    }
    public static boolean wordSearch(TrieNode node,  String str, Integer index){
        if(index==str.length()){
            if(node!=null && node.endOfWord){
                return true;
            }
            return false;
        }
        if(node.children.isEmpty()){
            return false;
        }
        char x=str.charAt(index);
        if(node.children.containsKey(x)){
            return wordSearch(node.children.get(x), str,index+1);
        }
        return false;
    }
    public static void deleteWord(TrieNode node, String str, Integer index, TrieNode parentNode){
        if(index==str.length()){
            if(node.children.isEmpty() && !parentNode.children.isEmpty()) {
                parentNode.children.remove(str.charAt(index - 1));
            }else{
                node.endOfWord=false;
            }
            return;
        }
        char x=str.charAt(index);
        if(node.children.containsKey(x)){
            deleteWord(node.children.get(x), str, index+1, node);
            if(node.children.isEmpty() && !parentNode.children.isEmpty()){
                parentNode.children.remove(str.charAt(index - 1));
            }
        }
        return;


    }
}
