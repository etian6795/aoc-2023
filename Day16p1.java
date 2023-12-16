import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static char[][] grid;
    public static HashMap<Integer, HashSet<Character>> seen;
	public static void solve() throws IOException {
        String line;
        int n = 100;
        int idx = 0;
        ArrayList<String> temp = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            temp.add(line);
        }   
        int m = temp.size();
        n = temp.get(0).length();
        grid = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = temp.get(i).charAt(j);
            }
        }

        seen = new HashMap<>();
        dfs(0, 0, 'R', m, n);
        out.println(seen.size());
    }

    public static void dfs(int r, int c, char dir, int m, int n) {
        if(r < 0 || c < 0 || r >= m || c >= n) return;
        if(seen.containsKey(hash(r, c)) && seen.get(hash(r, c)).contains(dir)) return;
        if(!seen.containsKey(hash(r, c))) seen.put(hash(r, c), new HashSet<>());
        seen.get(hash(r, c)).add(dir);

        if(dir=='U') {
            if(grid[r][c] == '.' || grid[r][c] == '|') dfs(r-1, c, 'U', m, n);
            else if(grid[r][c] == '/') dfs(r, c+1, 'R', m, n);
            else if(grid[r][c] == '\\') dfs(r, c-1, 'L', m, n);
            else if(grid[r][c] == '-') {
                dfs(r, c-1, 'L', m, n);
                dfs(r, c+1, 'R', m, n);
            }
        } else if(dir == 'D') {
            if(grid[r][c] == '.' || grid[r][c] == '|') dfs(r+1, c, 'D', m, n);
            else if(grid[r][c] == '/') dfs(r, c-1, 'L', m, n);
            else if(grid[r][c] == '\\') dfs(r, c+1, 'R', m, n);
            else if(grid[r][c] == '-') {
                dfs(r, c-1, 'L', m, n);
                dfs(r, c+1, 'R', m, n);
            }
        } else if(dir == 'L') {
            if(grid[r][c] == '.' || grid[r][c] == '-') dfs(r, c-1, 'L', m, n);
            else if(grid[r][c] == '/') dfs(r+1, c, 'D', m, n);
            else if(grid[r][c] == '\\') dfs(r-1, c, 'U', m, n);
            else if(grid[r][c] == '|') {
                dfs(r-1, c, 'U', m, n);
                dfs(r+1, c, 'D', m, n);
            }
        } else if(dir == 'R') {
            if(grid[r][c] == '.' || grid[r][c] == '-') dfs(r, c+1, 'R', m, n);
            else if(grid[r][c] == '/') dfs(r-1, c, 'U', m, n);
            else if(grid[r][c] == '\\') dfs(r+1, c, 'D', m, n);
            else if(grid[r][c] == '|') {
                dfs(r-1, c, 'U', m, n);
                dfs(r+1, c, 'D', m, n);
            }
        }
    }

    public static int hash(int r, int c) {
        return r*10000+c;
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
