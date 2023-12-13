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
        int n = 1;
        long ans = 0;
        int idx = 0;
        
        while ((line = br.readLine()) != null) {
            char[] arr = line.split(" ")[0].toCharArray();
            String[] temp = line.split(" ")[1].split(",");
            int[] nums = new int[temp.length];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(temp[i]);
            }

            ans = dfs(arr, nums, 0, ans);
        }   
        

        out.println(ans);
    }

    public static long dfs(char[] arr, int[] nums, int idx, long ans) {        
        while(idx < arr.length && arr[idx] != '?') {
            idx++;
        }
        if(idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            int tempIdx = 0;
            while(tempIdx < arr.length) {
                int cnt = 0;
                while(tempIdx < arr.length && arr[tempIdx] == '#') {
                    tempIdx++;
                    cnt++;
                }
                if(cnt != 0) temp.add(cnt);
                cnt++;
                tempIdx++;
            }
            if(nums.length == temp.size()) {
                boolean equal = true;
                for(int i = 0; i < nums.length && equal; i++) {
                    if(nums[i]!=temp.get(i)) equal = false;
                }
                if(equal) ans++;
            }
        } else {
            arr[idx] = '#';
            ans = dfs(arr, nums, idx+1, ans);
            arr[idx] = '.';
            ans = dfs(arr, nums, idx+1, ans);
            arr[idx] = '?';
        }
        return ans;
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
