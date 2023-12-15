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
        String[] arr = br.readLine().split(",");
        for(String s : arr) {
            long curr = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                curr += (int)c;
                curr *= 17;
                curr = curr%256;
            }
            ans += curr;
        }
        

        out.println(ans);
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
