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
        int n = 784;
        String[][] temp = new String[n][3];
        while ((line = br.readLine()) != null) {
            temp[idx] = line.split(" ");
            idx++;
        }   

        ArrayList<long[]> path = new ArrayList<>();
        path.add(new long[]{0, 0});
        long len = 0;
        long[] curr = new long[]{0, 0};
        for(String[] x : temp) {
            String s = x[2].substring(1, 8);
            if(s.charAt(6) == '0') {
                curr[0] += Long.parseLong(s.substring(1, 6), 16);
                path.add(new long[]{curr[0], curr[1]});
            } else if(s.charAt(6) == '2') {
                curr[0] -= Long.parseLong(s.substring(1, 6), 16);
                path.add(new long[]{curr[0], curr[1]});
            } else if(s.charAt(6) == '3') {
                curr[1] -= Long.parseLong(s.substring(1, 6), 16);
                path.add(new long[]{curr[0], curr[1]});
            } else if(s.charAt(6) == '1') {
                curr[1] += Long.parseLong(s.substring(1, 6), 16);
                path.add(new long[]{curr[0], curr[1]});
            } 
            len += Long.parseLong(s.substring(1, 6), 16);
        }

        double area = 0;
        path.add(new long[]{0, 0});
        //shoelace
        for(int i = 0; i < path.size()-1; i++) {
            area += path.get(i)[0]*path.get(i+1)[1] - path.get(i+1)[0]*path.get(i)[1];
        }
        area /= 2.0;
        //picks
        out.println((long)(area+1-(len)/2.0 + len));
    }

	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}

