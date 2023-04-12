package Graphs;

import java.util.*;

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) return 0;

            Set<String> set = new HashSet<>(wordList);

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int levels = 1;

            Set<String> visited = new HashSet<>();

            while(!queue.isEmpty()){
                int size = queue.size();

                for(int j = 0; j < size; j++){
                    String word = queue.poll();
                    if(word.equals(endWord)) return levels;
                    visited.add(word);

                    for(int i = 0; i < word.length(); i++){
                        helper(i, word, set, queue, visited);
                    }
                }

                levels++;
            }

            return 0;
        }

        private void helper(int index, String word, Set<String> set, Queue<String> queue, Set<String> visited){
            char[] arr = word.toCharArray();
            for(int i = 0; i < 26; i++){
                arr[index] = (char) (97 + i);

                String currentWord = String.valueOf(arr);

                if(set.contains(currentWord) && !visited.contains(currentWord)){
                    queue.offer(currentWord);
                }
            }
        }
    }
}
