package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] vis = new boolean[v];

//        Will store that node in stack from which we cannot make further dfs calls because that will be the node which is visited at the end
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < v; i++) {
            if(!vis[i]){
                dfs(adj, i, stack, vis);
            }
        }

        int[] res = new int[v];

        for(int i = 0; i < v; i++){
            res[i] = stack.pop();
        }

        return res;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int node, Stack<Integer> stack, boolean[] vis){
        if(vis[node]) return;

        vis[node] = true;

        for(int neighbor : graph.get(node)){
            if(!vis[neighbor]){
                dfs(graph, neighbor, stack, vis);
            }
        }

        stack.push(node);
    }
}
