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
        long ans = 0;
        int idx = 0;
        String[] temp = new String[n];
        while ((line = br.readLine()) != null) {
            temp[idx] = line;
            
            idx++;
        }
        int m = temp[0].length();
        char[][] grid = new char[n][m];
        ArrayList<Integer> gal = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = temp[i].charAt(j);
                if(grid[i][j]=='#') {
                    gal.add(i*m+j);
                }
            }
        }
        
        ArrayList<Integer> rEmpty = new ArrayList<>();
        ArrayList<Integer> cEmpty = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            boolean rEm = true;
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '#') rEm = false;
            }
            if(rEm) rEmpty.add(i);
        }
        for(int i = 0; i < m; i++) {
            boolean cEm = true;
            for(int j = 0; j < n; j++) {
                if(grid[j][i] == '#') cEm = false;
            }
            if(cEm) cEmpty.add(i);
        }
        
        int[] dir = new int[]{1, 0 , -1, 0, 1};
        for(Integer x : gal) {
            int sr = x/m;
            int sc = x%m;
            boolean[][] seen = new boolean[n][m];
            Queue<Integer> q = new LinkedList<>();
            q.add(x);
            seen[sr][sc] = true;
            int cnt = 0;
            long d = 0;
            while(cnt != gal.size()) {
                int size = q.size();
                while(size-->0) {
                    int r = q.peek()/m;
                    int c = q.remove()%m;
                    if(grid[r][c] == '#') {
                        ans += d;
                        cnt++;

                        for(int rr : rEmpty) {
                            if(Math.min(r, sr) < rr && rr < Math.max(r, sr)) {
                                ans+=999999l;
                            }
                        }
                        for(int cc : cEmpty) {
                            if(Math.min(c, sc) < cc && cc < Math.max(c, sc)) {
                                ans+=999999l;
                            }
                        }

                    }
                    for(int i = 0; i < 4; i++) {
                        int nr = r + dir[i];
                        int nc = c + dir[i+1];
                        if(nr >= 0 && nc >= 0 && nr < n && nc < m && !seen[nr][nc]) {
                            q.add(nr*m+nc);
                            seen[nr][nc] = true;
                        }
                    }
                }
                d++;
            }
        }

        out.println(ans/2);
    }


	public static void main (String[] args) throws IOException {
        /*int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            solve();
        }*/
        solve();
        out.close();
	}
}

