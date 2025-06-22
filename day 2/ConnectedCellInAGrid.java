import java.io.*;
import java.util.*;

class Result {

    public static int connectedCell(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        boolean[][] visited = new boolean[n][m];
        int maxRegion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j, n, m);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }

        return maxRegion;
    }

    private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int x, int y, int n, int m) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int i = curr[0], j = curr[1];

            for (int d = 0; d < 8; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];

                if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                        matrix.get(ni).get(nj) == 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    stack.push(new int[]{ni, nj});
                    count++;
                }
            }
        }

        return count;
    }
}

// ✅ Class name changed to valid Java class name
public class ConnectedCellInAGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().trim().split(" ");
            List<Integer> row = new ArrayList<>();
            for (String item : matrixRowTempItems) {
                row.add(Integer.parseInt(item));
            }
            matrix.add(row);
        }

        int result = Result.connectedCell(matrix);
        System.out.println(result);
    }
}
