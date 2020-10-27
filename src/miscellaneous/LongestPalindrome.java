package miscellaneous;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (Character ch : s.toCharArray()) {
			hm.put(ch, hm.getOrDefault(ch, 0)+1);
		}
		int flag = 0;
		int leng = 0;
		for (Map.Entry ent : hm.entrySet()) {
			int val = (int) ent.getValue();
			if(val%2==0) {
				leng+=val;
			}else {
				leng+=val-1;
				flag=1;
			}
		}
		return leng+flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.longestPalindrome("abccccdd"));
	}

}
