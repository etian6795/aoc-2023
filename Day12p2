import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static HashMap<HashMap<Integer, Integer>, Long> memo = new HashMap<>();
    public static String s;
    public static ArrayList<Integer> nums;
	public static void solve() throws IOException {
        String line;
        int n = 1;
        long ans = 0;
        int idx = 0;
        
        while ((line = br.readLine()) != null) {
            memo = new HashMap<>();
            String[] temp = line.split(" ")[1].split(",");
            s = line.split(" ")[0]+'?'+line.split(" ")[0]+'?'+line.split(" ")[0]+'?'+line.split(" ")[0]+'?'+line.split(" ")[0];
            nums = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < temp.length*5; i++) {
                nums.add(Integer.parseInt(temp[i%temp.length]));
                sum += nums.get(i);
            }

            ans += dfs(0, 0, sum);
        }   
        

        out.println(ans);
    }

    public static long dfs(int sIdx, int numsIdx, int sum) {        
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(sIdx, numsIdx);
        if(memo.containsKey(temp)) return memo.get(temp);
        
        long ans = 0;
        if(numsIdx == nums.size()) {
            if(s.substring(sIdx).contains("#")) {
                return 0;
            } else {
                return 1;
            }
        }
        if(sIdx == s.length()) return 0;
        if(sum + nums.size()-numsIdx-1 > s.length()-sIdx) return 0;
        
        if(numsIdx == nums.size()-1 && nums.get(numsIdx) == s.length()-sIdx && !s.substring(sIdx).contains(".")) ans++;
        if(!s.substring(sIdx, sIdx + nums.get(numsIdx)).contains(".") && sIdx+nums.get(numsIdx) < s.length() && s.charAt(sIdx + nums.get(numsIdx)) != '#') ans += dfs(sIdx+nums.get(numsIdx)+1, numsIdx+1, sum-nums.get(numsIdx));
        if(s.charAt(sIdx) != '#') ans += dfs(sIdx+1, numsIdx, sum);

        memo.put(temp, ans);
        return ans;
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
