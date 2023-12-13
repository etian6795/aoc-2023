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
        int n = 3;
        int ans = 0;
        int idx = 0;
        while ((line = br.readLine()) != null) {
            idx = 0;
            ArrayList<ArrayList<Long>> arr = new ArrayList<>();
            arr.add(new ArrayList<>());
            String[] t = line.split(" ");
            long[] temp = new long[t.length];
            for(int i = 0; i < temp.length; i++) {
                temp[i] = Long.parseLong(t[i]);
            }
            for(long x : temp) arr.get(idx).add(x);
            while(!allZero(arr.get(idx))) {
                arr.add(new ArrayList<>());
                for(int i = 0; i < arr.get(idx).size()-1; i++) {
                    arr.get(idx+1).add(arr.get(idx).get(i+1)-arr.get(idx).get(i));
                }
                
                idx++;
            }
            long prev = 0;
            for(int i = arr.size()-2; i >= 0; i--) {
                prev = arr.get(i).get(0)-prev;
            }
            ans += prev;
        }
        

        out.println(ans);
        
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}

