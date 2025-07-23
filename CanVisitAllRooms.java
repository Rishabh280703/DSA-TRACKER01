import java.util.*;

public class CanVisitAllRooms {
    public void bfs(int i, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int ele : adj.get(front)) {
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(0, adj, vis);
        for (boolean ele : vis) {
            if (!ele) return false;
        }
        return true;
    }
}