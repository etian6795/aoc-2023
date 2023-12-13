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
        int ans = 0;
        int n = 140;
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int m = arr[0].length();

        String nums = "0123456789";
        for(int i = 0; i < n; i++) {
            int idx = 0;
            /*while(idx < m) {
                if(nums.contains(""+arr[i].charAt(idx))) {
                    String s = "";
                    while(idx < m && nums.contains(""+arr[i].charAt(idx))) {
                        s += arr[i].charAt(idx);
                        idx++;
                    }
                    if(can(arr, i, idx - s.length(), idx-1)) {
                        ans += Integer.parseInt(s);
                    }
                }
                idx++;
            }*/
            for(int j = 0; j < m; j++) {
                if(arr[i].charAt(j)=='*') {
                    ArrayList<Integer> temp = new ArrayList<>();
                    cann(temp, arr, i, j);
                    if(temp.size()==2) {
                        ans += temp.get(0) * temp.get(1);
                    }
                }
            }
        }

        out.println(ans);
    }
    public static void cann(ArrayList<Integer> temp, String[] arr, int r, int c) {
        String nums = "0123456789";
        if(c+1 < arr[0].length() && nums.contains(""+arr[r].charAt(c+1))) {
            String s = "";
            int idx = c+1;
            while(idx < arr[0].length() && nums.contains(""+arr[r].charAt(idx))) {
                s += arr[r].charAt(idx);
                idx++;
            }
            temp.add(Integer.parseInt(s));
        }
        if(c-1 >=0 && nums.contains(""+arr[r].charAt(c-1))) {
            String s = "";
            int idx = c-1;
            while(idx >= 0 && nums.contains(""+arr[r].charAt(idx))) {
                s = arr[r].charAt(idx)+s;
                idx--;
            }
            temp.add(Integer.parseInt(s));
        }
        
        if(r > 0) {
            if(arr[r-1].charAt(c)=='.') {
                if(nums.contains(""+arr[r-1].charAt(c+1))) {
                    String s = "";
                    int idx = c+1;
                    while(idx < arr[0].length() && nums.contains(""+arr[r-1].charAt(idx))) {
                        s += arr[r-1].charAt(idx);
                        idx++;
                    }
                    temp.add(Integer.parseInt(s));
                }
                if(nums.contains(""+arr[r-1].charAt(c-1))) {
                    String s = "";
                    int idx = c-1;
                    while(idx >= 0 && nums.contains(""+arr[r-1].charAt(idx))) {
                        s = arr[r-1].charAt(idx)+s;
                        idx--;
                    }
                    temp.add(Integer.parseInt(s));
                }
            } else {
                String s = "";
                int idx = c;
                while(idx < arr[0].length() && nums.contains(""+arr[r-1].charAt(idx))) {
                    s += arr[r-1].charAt(idx);
                    idx++;
                }
                idx = c-1;
                while(nums.contains(""+arr[r-1].charAt(idx))) {
                    s = arr[r-1].charAt(idx)+s;
                    idx--;
                }
                temp.add(Integer.parseInt(s));
            }
        }
        if(r < arr.length-1) {
            if(arr[r+1].charAt(c)=='.') {
                if(nums.contains(""+arr[r+1].charAt(c+1))) {
                    String s = "";
                    int idx = c+1;
                    while(idx < arr[0].length() && nums.contains(""+arr[r+1].charAt(idx))) {
                        s += arr[r+1].charAt(idx);
                        idx++;
                    }
                    temp.add(Integer.parseInt(s));
                }
                if(nums.contains(""+arr[r+1].charAt(c-1))) {
                    String s = "";
                    int idx = c-1;
                    while(idx>= 0&& nums.contains(""+arr[r+1].charAt(idx))) {
                        s = arr[r+1].charAt(idx)+s;
                        idx--;
                    }
                    temp.add(Integer.parseInt(s));
                }
            } else {
                String s = "";
                int idx = c;
                while(idx < arr[0].length() && nums.contains(""+arr[r+1].charAt(idx))) {
                    s += arr[r+1].charAt(idx);
                    idx++;
                }
                idx = c-1;
                while(nums.contains(""+arr[r+1].charAt(idx))) {
                    s = arr[r+1].charAt(idx)+s;
                    idx--;
                }
                temp.add(Integer.parseInt(s));
            }
        }
    }

    public static boolean can(String[] arr, int row, int left, int right) {
            for(int i = left-1; i <= right+1; i++) {
                if(row-1 >= 0 && i >= 0 && i < arr.length && arr[row-1].charAt(i) != '.') {
                    return true;
                }
            }
            for(int i = left-1; i <= right+1; i++) {
                if(row+1 < arr.length && i >= 0 && i < arr.length && arr[row+1].charAt(i) != '.') {
                    return true;
                }
            }

        if(left != 0) {
                if(arr[row].charAt(left-1) != '.') {
                    return true;
                }
        }
        if(right != arr[0].length()-1) {
                if(arr[row].charAt(right+1) != '.') {
                    return true;
                }
        }
        
        return false;
    }

	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
