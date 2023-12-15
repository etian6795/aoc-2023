import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

	public static void solve() throws IOException {
        HashMap<Integer, ArrayList<ArrayList<Character>>> map = new HashMap<>();
        String line;
        int n = 100;
        long ans = 0;
        int idx = 0;
        ArrayList<String> temp = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            temp.add(line);
        }   
        int m = temp.get(0).length();
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            grid.add(new ArrayList<>());
            for(int j = 0; j < m; j++) {
                grid.get(i).add(temp.get(i).charAt(j));
            }
        }
        idx = 0;
        while(!map.containsValue(grid)) {
            ArrayList<ArrayList<Character>> x = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                x.add(new ArrayList<>());
                for(int j = 0; j < m; j++) {
                    x.get(i).add(grid.get(i).get(j));
                }
            }
            map.put(idx, x);
            idx++;
            
            for(int j = 0; j < m; j++) {
                int last = -1;
                for(int i = 0; i < n; i++) {
                    if(grid.get(i).get(j) == 'O') {
                        grid.get(i).set(j, '.');
                        grid.get(last+1).set(j, 'O');
                        last++;
                    } else if(grid.get(i).get(j) == '#') {
                        last = i;
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                int last = -1;
                for(int j = 0; j < m; j++) {
                    if(grid.get(i).get(j) == 'O') {
                        grid.get(i).set(j, '.');
                        grid.get(i).set(last+1, 'O');
                        last++;
                    } else if(grid.get(i).get(j) == '#') {
                        last = j;
                    }
                }
            }
            for(int j = 0; j < m; j++) {
                int last = n;
                for(int i = n-1; i >= 0; i--) {
                    if(grid.get(i).get(j) == 'O') {
                        grid.get(i).set(j, '.');
                        grid.get(last-1).set(j, 'O');
                        last--;
                    } else if(grid.get(i).get(j) == '#') {
                        last = i;
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                int last = m;
                for(int j = m-1; j >= 0; j--) {
                    if(grid.get(i).get(j) == 'O') {
                        grid.get(i).set(j, '.');
                        grid.get(i).set(last-1, 'O');
                        last--;
                    } else if(grid.get(i).get(j) == '#') {
                        last = j;

                    }
                }
            }
        }
        int other = 0;
        while(!map.get(other).equals(grid)) {
            other++;
        }
        out.println(other+" "+idx);
        grid = map.get((1000000000-other)%(idx-other)+other);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid.get(i).get(j)=='O') {
                    ans += n-i;
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
