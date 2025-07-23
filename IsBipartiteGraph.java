import java.util.*;

public class IsBipartiteGraph {
    static boolean ans;

    public void bfs(int[][] adj, int i, int[] vis) {
        vis[i] = 0; // Start with color 0
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int front = q.poll();
            int color = vis[front];

            for (int ele : adj[front]) {
                if (vis[ele] == color) {
                    ans = false;
                    return;
                }
                if (vis[ele] == -1) {
                    vis[ele] = 1 - color; // Alternate color
                    q.add(ele);
                }
            }
        }
    }

    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1); // -1 means unvisited

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                bfs(adj, i, vis);
            }
        }

        return ans;
    }

    // Optional: main method to test
    public static void main(String[] args) {
        IsBipartiteGraph obj = new IsBipartiteGraph();
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        System.out.println(obj.isBipartite(graph)); // Output: true
    }
}