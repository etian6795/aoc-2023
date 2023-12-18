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
        ArrayList<int[]> path = new ArrayList<>();
        path.add(new int[]{0, 0});
        int len = 0;
        int[] curr = new int[]{0, 0};
        for(String[] x : temp) {
            if(x[0].equals("R")) {
                curr[0] += Integer.parseInt(x[1]);
                path.add(new int[]{curr[0], curr[1]});
            } else if(x[0].equals("L")) {
                curr[0] -= Integer.parseInt(x[1]);
                path.add(new int[]{curr[0], curr[1]});
            } else if(x[0].equals("U")) {
                curr[1] -= Integer.parseInt(x[1]);
                path.add(new int[]{curr[0], curr[1]});
            } else if(x[0].equals("D")) {
                curr[1] += Integer.parseInt(x[1]);
                path.add(new int[]{curr[0], curr[1]});
            } 
            len += Integer.parseInt(x[1]);
        }

        double area = 0;
        path.add(new int[]{0, 0});
        //shoelace
        for(int i = 0; i < path.size()-1; i++) {
            area += path.get(i)[0]*path.get(i+1)[1] - path.get(i+1)[0]*path.get(i)[1];
        }
        area /= 2.0;
        //picks
        out.println(area+1-(len)/2.0 + len);
    }

	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}

