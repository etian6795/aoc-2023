import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

	public static void solve() throws IOException {
        String line;
        int n = 140;
        int ans = 0;
        int idx = 0;
        String[] temp = new String[n];
        while ((line = br.readLine()) != null) {
            temp[idx] = line;
            
            idx++;
        }
        int m = temp[0].length();
        char[][] grid = new char[n][m];
        for(int i = 0; i < n; i++) {
            grid[i] = temp[i].toCharArray();
        }
        int rr = -1;
        int cc = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j]=='S') {
                    rr = i;
                    cc = j;
                    break;
                }
            }
            if(rr==i) break;
        }
        grid[rr][cc] = 'J';
        boolean[][] seen = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rr, cc, 0, 0});
        int dist = 0;
        while(q.peek()[0]!=rr || q.peek()[1] != cc || q.peek()[2] != 1) {
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];
            int dir = curr[3];
            if(grid[r][c] == 'L') {
                if(dir==0) {
                    q.add(new int[]{r, c+1, 1, 3});
                } else {
                    q.add(new int[]{r-1, c, 1, 2});
                }
            } else if(grid[r][c] == 'J') {
                if(dir==0) {
                    q.add(new int[]{r, c-1, 1, 1});
                } else {
                    q.add(new int[]{r-1, c, 1, 2});
                }
            } else if(grid[r][c] == '7') {
                if(dir==2) {
                    q.add(new int[]{r, c-1, 1, 1});
                } else {
                    q.add(new int[]{r+1, c, 1, 0});
                }
            } else if(grid[r][c] == 'F') {
                if(dir==2) {
                    q.add(new int[]{r, c+1, 1, 3});
                } else {
                    q.add(new int[]{r+1, c, 1, 0});
                }
            } else if(grid[r][c] == '-') {
                if(dir==1) {
                    q.add(new int[]{r, c-1, 1, 1});
                } else {
                    q.add(new int[]{r, c+1, 1, 3});
                }
            } else if(grid[r][c] == '|') {
                if(dir==0) {
                    q.add(new int[]{r+1, c, 1, 0});
                } else {
                    q.add(new int[]{r-1, c, 1, 2});
                }
            }
            dist++;
        }

        out.println(dist/2);
        
    }

    public static int dfs(char[][] grid, int r, int c, int d, int[] seen, char dir) {
        if(r == seen[0] && c == seen[1] && seen[2] == 1) return d;
        seen[2] = 1;
        if(grid[r][c] == 'L') {
            if(dir=='N') {
                return dfs(grid, r, c+1, d+1, seen, 'W');
            } else {
                return dfs(grid, r-1, c, d+1, seen, 'S');
            }
        } else if(grid[r][c] == 'J') {
            if(dir=='N') {
                return dfs(grid, r, c-1, d+1, seen, 'E');
            } else {
                return dfs(grid, r-1, c, d+1, seen, 'S');
            }
        } else if(grid[r][c] == '7') {
            if(dir=='S') {
                return dfs(grid, r, c-1, d+1, seen, 'E');
            } else {
                return dfs(grid, r+1, c, d+1, seen, 'N');
            }
        } else if(grid[r][c] == 'F') {
            if(dir=='S') {
                return dfs(grid, r, c+1, d+1, seen, 'W');
            } else {
                return dfs(grid, r+1, c, d+1, seen, 'N');
            }
        } else if(grid[r][c] == '-') {
            if(dir=='E') {
                return dfs(grid, r, c-1, d+1, seen, 'E');
            } else {
                return dfs(grid, r, c+1, d+1, seen, 'W');
            }
        } else if(grid[r][c] == '|') {
            if(dir=='N') {
                return dfs(grid, r+1, c, d+1, seen, 'N');
            } else {
                return dfs(grid, r-1, c, d+1, seen, 'S');
            }
        }
        return 0;
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
