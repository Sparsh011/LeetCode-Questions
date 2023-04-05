package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraph {
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] vis = new boolean[V];

            for(int i = 0; i < V; i++){ // Handle
                if(!vis[i]){
                    if(detectCycle(i, vis, adj)) return true;
                }
            }



            return false;
        }

        private boolean detectCycle(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
            Queue<Graph> queue = new LinkedList<>();
            queue.offer(new Graph(src, -1));
            vis[src] = true;

            while(!queue.isEmpty()){
                Graph currentNode = queue.poll();

                for(int neighbor : adj.get(currentNode.node)){
                    if(vis[neighbor] && currentNode.parent != neighbor) return true;
                    else if(!vis[neighbor]){
                        queue.offer(new Graph(neighbor, currentNode.node));
                        vis[neighbor] = true;
                    }
                }
            }

            return false;
        }
    }

    class Graph{
        int node;
        int parent;

        public Graph(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
}
