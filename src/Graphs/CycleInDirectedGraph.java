package Graphs;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for(int i = 0; i< V; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, recursionStack)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] recursionStack){
        vis[v] = true;
        recursionStack[v] = true;

        for(Integer neighbor: adj.get(v)){
            if(!vis[neighbor]){
                if(dfs(neighbor, adj, vis, recursionStack)) return true;
            }
            else if(recursionStack[neighbor]) return true;
        }
        recursionStack[v] = false;
        return false;
    }
}
