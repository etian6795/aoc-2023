import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void printArr(long[] arr) {
        for(int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
    } //change array type as needed
 
    public static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static long lcm(long a, long b) {
        return (a/gcd(a, b)) * b;
    }
 
    public static void readArr(int[] arr) throws IOException {
        int n = arr.length;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void readArr(long[] arr) throws IOException {
        int n = arr.length;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

	public static void sort(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for(int i = 0; i < n; i++) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }

	public static void solve() throws IOException {
        /*StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());*/

        //AOC
        String line;
        int n = 204;
        long ans = 0;
        /*while ((line = br.readLine()) != null) {
            
        }*/
        String[] s = br.readLine().split(" ");
        Queue<long[]> q = new LinkedList<>();
        for(int i = 1; i < s.length; i+=2) {
            q.add(new long[]{Long.parseLong(s[i]), Long.parseLong(s[i+1])});
        }
        br.readLine();
        br.readLine();
        ArrayList<long[]> seedToSoil = new ArrayList<>();
        while(!(line=br.readLine()).equals("")) {
            String[] temp = line.split(" ");
                seedToSoil.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        br.readLine();
        ArrayList<long[]> soilToFert = new ArrayList<>();
        while(!(line=br.readLine()).equals("")) {
            String[] temp = line.split(" ");
            soilToFert.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        br.readLine();
        ArrayList<long[]> fertToWate = new ArrayList<>();
        while(!(line=br.readLine()).equals("")) {
            String[] temp = line.split(" ");
                fertToWate.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        br.readLine();
        ArrayList<long[]> wateToLigh = new ArrayList<>();
        while(!(line=br.readLine()).equals("")) {
            String[] temp = line.split(" ");
                wateToLigh.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        br.readLine();
        ArrayList<long[]> lighToTemp = new ArrayList<>();
        while(!(line=br.readLine()).equals("")) {
            String[] temp = line.split(" ");
                lighToTemp.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        br.readLine();
        ArrayList<long[]> tempToHumi = new ArrayList<>();
        while(!(line=br.readLine()).equals("")) {
            String[] temp = line.split(" ");
                tempToHumi.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        br.readLine();
        ArrayList<long[]> humiToLoca = new ArrayList<>();
        while((line=br.readLine()) != null) {
            String[] temp = line.split(" ");
                humiToLoca.add(new long[]{Long.parseLong(temp[0]), Long.parseLong(temp[1]), Long.parseLong(temp[2])});
        }
        ArrayList<ArrayList<long[]>> arr = new ArrayList<>();
        arr.add(seedToSoil);
        arr.add(soilToFert);
        arr.add(fertToWate);
        arr.add(wateToLigh);
        arr.add(lighToTemp);
        arr.add(tempToHumi);
        arr.add(humiToLoca);
        
        Queue<long[]> tempq = new LinkedList<>();
        for(ArrayList<long[]> y : arr) {
            while(!q.isEmpty()) {
                long[] curr = q.remove();
                if(curr[1]<=0) continue;
                long l = curr[0];
                long r = curr[0]+curr[1]-1;
                boolean canAdd = true;
                for(long[] x : y) {
                    long xl = x[1];
                    long xr = x[1]+x[2]-1;
                    if(xl <= l && r <= xr) {
                        tempq.add(new long[]{x[0]+l-xl, r-l+1});
                        canAdd = false;
                        break;
                    }

                    if(xl <= l && l <= xr && xr <= r) {
                        tempq.add(new long[]{x[0] + l-xl, xr-l+1});
                        l = xr+1;
                        if(l>r) {
                            canAdd = false; 
                            break;
                        }
                        
                    }

                    if(l <= xl && xl <= r && r <= xr) {
                        tempq.add(new long[]{x[0], r-xl+1});
                        r = xl-1;
                        if(l>r) {
                            canAdd = false; 
                            break;
                        }
                    }

                    if(l <= xl && xr <= r) {
                        tempq.add(new long[]{x[0], x[2]});
                        q.add(new long[]{l, xl-l});
                        q.add(new long[]{xr+1, r-xr});
                        canAdd = false;
                        break;
                    }
                }
                if(canAdd) tempq.add(new long[]{l, r-l+1});
            }
            while(!tempq.isEmpty()) {
                q.add(tempq.remove());
            }
        }

        ans = Long.MAX_VALUE;
        while(!q.isEmpty()) {
            ans = Math.min(ans, q.remove()[0]);
        }
        out.println(ans);
        /*long a = seeds[0];
        int b = (int)seeds[1];
        seeds = new long[b];
        for(int i = 0; i < b; i++) seeds[i] = a+i;
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : seedToSoil) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : soilToFert) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : fertToWate) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : wateToLigh) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : lighToTemp) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : tempToHumi) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        for(int i = 0; i < seeds.length; i++) {
            for(long[] x : humiToLoca) {
                if(seeds[i] >= x[1] && seeds[i] < x[1]+x[2]) {
                    seeds[i] = x[0] + seeds[i]-x[1];
                    break;
                }
            }
        }
        ans = Long.MAX_VALUE;
        for(long x : seeds) ans = Math.min(ans, x);
        out.println(ans);*/
        
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

