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
        long ans = 0;
        int idx = 0;
        ArrayList<String> temp = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            idx = 0;
            temp = new ArrayList<>();
            while(line != null && !line.equals("")) {
                temp.add(line);
                idx++;
                line = br.readLine();
            }

            int m = temp.size();
            int n = temp.get(0).length();
            char[][] arr = new char[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = temp.get(i).charAt(j);
                }
            }
            boolean found = false;
            for(int i = 0; i < m-1 && !found; i++) {
                idx = 0;
                boolean curr = true;
                while(i-idx >= 0 && i+idx+1 < m && curr) {
                    for(int j = 0; j < n; j++) {
                        if(arr[i-idx][j] != arr[i+idx+1][j]) {
                            curr = false;
                            break;
                        }
                    }
                    idx++;
                }
                if(curr) {
                    ans += 100*(i+1);
                    found = true;
                }
            }
            if(found) continue;
            for(int j = 0; j < n-1; j++) {
                idx = 0;
                boolean curr = true;
                while(j-idx >= 0 && j+idx+1 < n && curr) {
                    for(int i = 0; i < m; i++) {
                        if(arr[i][j-idx] != arr[i][j+idx+1]) {
                            curr = false;
                            break;
                        }
                    }
                    idx++;
                }
                if(curr) {
                    ans += (j+1);
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
