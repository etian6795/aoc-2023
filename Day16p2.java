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
    public static ArrayList<HashSet<Character>> seenn;
	public static void solve() throws IOException {
        String line;
        int n = 100;
        long ans = 0;
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
        for(int i = 0; i < n; i++) {
            seenn = new ArrayList<>();
            for(int j = 0; j < m*n; j++) {
                seenn.add(new HashSet<>());
            }
            dfs(0, i, 'D', m, n);
            int cnt = 0;
            for(int j = 0; j < m*n; j++) {
                if(seenn.get(j).size()!=0) cnt++;
            }
            ans = Math.max(ans, cnt);

            seenn = new ArrayList<>();
            for(int j = 0; j < m*n; j++) {
                seenn.add(new HashSet<>());
            }
            dfs(m-1, i, 'U', m, n);
            cnt = 0;
            for(int j = 0; j < m*n; j++) {
                if(seenn.get(j).size()!=0) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        for(int j = 0; j < m; j++) {
            seenn = new ArrayList<>();
            for(int i = 0; i < m*n; i++) {
                seenn.add(new HashSet<>());
            }
            dfs(j, 0, 'R', m, n);
            int cnt = 0;
            for(int i = 0; i < m*n; i++) {
                if(seenn.get(i).size()!=0) cnt++;
            }
            ans = Math.max(ans, cnt);
            
            seenn = new ArrayList<>();
            for(int i = 0; i < m*n; i++) {
                seenn.add(new HashSet<>());
            }
            dfs(j, n-1, 'L', m, n);
            cnt = 0;
            for(int i = 0; i < m*n; i++) {
                if(seenn.get(i).size()!=0) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        
        out.println(ans);
    }

    public static void dfs(int r, int c, char dir, int m, int n) {
        if(r < 0 || c < 0 || r >= m || c >= n) return;
        if(seenn.get(hash(r, c, n)).contains(dir)) return;
        seenn.get(hash(r, c, n)).add(dir);

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

    public static int hash(int r, int c, int n) {
        return r*n+c;
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
