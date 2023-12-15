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
        int n = 100;
        long ans = 0;
        int idx = 0;
        String[] temp = new String[n];
        while ((line = br.readLine()) != null) {
            temp[idx] = line;
            idx++;
        }   
        int m = temp[0].length();
        char[][] grid = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = temp[i].charAt(j);
            }
        }

        for(int j = 0; j < m; j++) {
            int last = -1;
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == 'O') {
                    ans += n-last-1-cnt;
                    cnt++;
                } else if(grid[i][j] == '#') {
                    last = i;
                    cnt = 0;
                }
            }
        }

        out.println(ans);
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
