package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

//    BFS solution -
        public boolean isBipartiteBFS(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];

            for(int i = 0; i < n; i++){
                if(color[i] == 1 || color[i] == -1) continue;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1;

                while(!queue.isEmpty()){
                    int curr = queue.poll();

                    for(int next : graph[curr]){
                        if(color[next] == 0){
                            color[next] = -color[curr];
                            queue.offer(next);
                        }

                        if(color[next] == color[curr]) return false;
                    }
                }
            }

            return true;
        }


//        DFS solution -

        public boolean isBipartiteDFS(int[][] graph) {
//         DFS solution -
            int length = graph.length;
            int[] colors = new int[length];

            for(int i = 0; i < length; i++){
                if(colors[i] == 0){
                    if(!helper(i, length, graph, 1, colors)){
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean helper(int currentNode, int v, int[][] graph, int colorForNextNode, int[] colors){
            if(colors[currentNode] != 0){
                return colors[currentNode] == colorForNextNode;
            }

            colors[currentNode] = colorForNextNode;

            for(int neighbor : graph[currentNode]){
                if(!helper(neighbor, v, graph, -colorForNextNode, colors)) return false;
            }

            return true;
        }

}
