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
        int n = 1000;
        String[][] hand = new String[n][2];
        long ans = 0;
        int idx = 0;
        while ((line = br.readLine()) != null) {
            hand[idx][0] = line.split(" ")[0];
            hand[idx][1] = line.split(" ")[1];
            idx++;
        }

        Arrays.sort(hand, new Comparator<>() {
            public int compare(String[] a, String[] b) {
                String h1 = a[0];
                String h2 = b[0];
                HashMap<Character, Integer> map1 = new HashMap<>();
                HashMap<Character, Integer> map2 = new HashMap<>();
                int num1 = 0;
                int num2 = 0;
                for(int i = 0; i < 5; i++) {
                    if(h1.charAt(i)=='J')num1++;
                    else map1.put(h1.charAt(i), map1.getOrDefault(h1.charAt(i), 0)+1);
                    if(h2.charAt(i)=='J')num2++;
                    else map2.put(h2.charAt(i), map2.getOrDefault(h2.charAt(i), 0)+1);
                }
                
                int max1 = 0;
                char c1 = 'J';
                for(char c : map1.keySet()) {
                    if(map1.get(c) > max1) {
                        max1 = map1.get(c);
                        c1 = c;
                    }
                }
                map1.put(c1, max1+num1);
                max1 = 0;
                c1 = 'J';
                for(char c : map2.keySet()) {
                    if(map2.get(c) > max1) {
                        max1 = map2.get(c);
                        c1 = c;
                    }
                }
                map2.put(c1, max1+num2);

                int type1 = 1;
                int type2 = 1;

                if(map1.size() == 1) type1 = 7;
                if(map1.size() == 2) {
                    if(map1.values().contains(4)) type1 = 6;
                    else type1 = 5;
                }
                if(map1.size() == 3) {
                    if(map1.values().contains(3)) type1 = 4;
                    else type1 = 3;
                }
                if(map1.size() == 4) type1 = 2;

                if(map2.size() == 1) type2 = 7;
                if(map2.size() == 2) {
                    if(map2.values().contains(4)) type2 = 6;
                    else type2 = 5;
                }
                if(map2.size() == 3) {
                    if(map2.values().contains(3)) type2 = 4;
                    else type2 = 3;
                }
                if(map2.size() == 4) type2 = 2;

                if(type1!=type2) return type1 - type2;
                int idx = 0;
                while(idx < 5 && h1.charAt(idx)==h2.charAt(idx)) idx++;
                if(idx==5) return 0;
                int x = 0;
                int y = 0;
                if(h1.charAt(idx)=='A') x = 14;
                else if(h1.charAt(idx)=='K') x = 13;
                else if(h1.charAt(idx)=='Q') x = 12;
                else if(h1.charAt(idx)=='J') x = 1;
                else if(h1.charAt(idx)=='T') x = 10;
                else x = Integer.parseInt(""+h1.charAt(idx));
                if(h2.charAt(idx)=='A') y = 14;
                else if(h2.charAt(idx)=='K') y = 13;
                else if(h2.charAt(idx)=='Q') y = 12;
                else if(h2.charAt(idx)=='J') y = 1;
                else if(h2.charAt(idx)=='T') y = 10;
                else y = Integer.parseInt(""+h2.charAt(idx));

                return x-y;
            }
        });
        for(int i = 0; i < n; i++) {
            ans += (i+1)*Long.parseLong(hand[i][1]);
            out.println(Arrays.toString(hand[i]));
        }
        out.println(ans);
        
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
