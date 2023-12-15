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
        int n = 100;
        long ans = 0;
        String[] arr = br.readLine().split(",");
        ArrayList<ArrayList<String[]>> boxes = new ArrayList<>();
        for(int i = 0; i < 256; i++) {
            boxes.add(new ArrayList<>());
        }
        for(String s : arr) {
            int box = 0;
            for(int i = 0; i < Math.max(s.indexOf("-"), s.indexOf("=")); i++) {
                char c = s.charAt(i);
                box += (int)c;
                box *= 17;
                box = box%256;
            }
            
            if(s.indexOf("-") != -1) {
                String label = s.substring(0, s.length()-1);
                int idx = 0;
                while(idx < boxes.get(box).size()) {
                    if(boxes.get(box).get(idx)[0].equals(label)) {
                        boxes.get(box).remove(idx);
                        break;
                    }
                    idx++;
                }
            } else {
                String label = s.split("=")[0];
                String focal = s.split("=")[1];
                int idx = 0;
                while(idx < boxes.get(box).size()) {
                    if(boxes.get(box).get(idx)[0].equals(label)) {
                        boxes.get(box).set(idx, new String[]{label, focal});
                        break;
                    }
                    idx++;
                }
                if(idx == boxes.get(box).size()) {
                    boxes.get(box).add(new String[]{label, focal});
                }
            }
        }
        
        for(int i = 0; i < boxes.size(); i++) {
            for(int j = 0; j < boxes.get(i).size(); j++) {
                ans += (i+1)*(j+1)*Long.parseLong(boxes.get(i).get(j)[1]);
            }
        }

        out.println(ans);
    }


	public static void main (String[] args) throws IOException {
        solve();
        out.close();
	}
}
