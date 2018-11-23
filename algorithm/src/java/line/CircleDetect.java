package line;

import java.util.Scanner;

public class CircleDetect {
    int[][] graph;
    int nNodes, nEdges;
    int[] color;
    boolean isDAG = true;
    void dfs(int i) {
        color[i] = 1;
        for (int j = 1; j <= nNodes; j++) {
            if (graph[i][j] != 0) {
                //these is a circle
                if (color[j] == 1) {
                    isDAG = false;
                    break;
                } else if (color[j] == -1) {
                    continue;
                } else {
                    dfs(j);
                }
            }
        }
        color[i] = -1;
    }

    void constructGraph() {
        Scanner sc = new Scanner(System.in);
        nNodes = sc.nextInt();
        nEdges = sc.nextInt();
        graph = new int[nNodes + 1][nNodes + 1];
        color = new int[nNodes + 1];
        //input edges
        for (int k = 1; k <= nEdges; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            graph[i][j] = 1;
        }
        //all notes are not visited
        for (int i = 1; i <= nNodes; i++) {
            color[i] = 0;
        }
    }

    public boolean isDAG() {
        for (int i = 1; i <= nNodes; i++) {
            if (color[i] == -1) continue;

            dfs(i);
            if (!isDAG) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CircleDetect demo = new CircleDetect();
        demo.constructGraph();
        System.out.println(!demo.isDAG());
    }
}
