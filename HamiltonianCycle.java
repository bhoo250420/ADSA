
import java.util.*;

public class HamiltonianCycle {
    static int n;
    static int[][] graph;
    static int[] path;

    static boolean isSafe(int v, int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static boolean hamCycleUtil(int pos) {
        if (pos == n) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < n; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;

                if (hamCycleUtil(pos + 1))
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    static void hamCycle() {
        path = new int[n];

        Arrays.fill(path, -1);
        path[0] = 0;

        if (hamCycleUtil(1)) {
            System.out.println("Hamiltonian Cycle exists:");
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");

            System.out.println(path[0]);
        } else {
            System.out.println("No Hamiltonian Cycle exists");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        hamCycle();
        sc.close();
    }
}
