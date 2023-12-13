import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);
 
    public static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static long lcm(long a, long b) {
        return (a/gcd(a, b)) * b;
    }

	public static void solve() throws IOException {
        String line;
        int n = 3;
        int ans = 0;
        int idx = 0;
        String dir = br.readLine();
        br.readLine();
        HashMap<String, String[]> map = new HashMap<>();
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(" ");
            map.put(temp[0], new String[]{temp[2].substring(1, 4), temp[3].substring(0, 3)});
            idx++;
        }
        ArrayList<Long> arr = new ArrayList<>();
        for(String curr : map.keySet()) {
            ans = 0;
            if(curr.charAt(2)=='A') {
                while(curr.charAt(2) != 'Z') {
                    if(dir.charAt(ans%dir.length())=='L') curr = map.get(curr)[0];
                    else curr = map.get(curr)[1];

                    ans++;
                }
                arr.add((long)ans);
            }
            
        }
        long y = arr.get(0);
        for(long x : arr) {
            y = lcm(y, x);
        }

        out.println(y);
        
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
