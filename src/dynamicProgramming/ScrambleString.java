package dynamicProgramming;

import java.util.HashMap;

// https://www.interviewbit.com/problems/scramble-string/

public class ScrambleString {

	HashMap<String, Integer> hm;

	public int isScramble(final String A, final String B) {
		hm = new HashMap<>();
		return isScrambled(A, B);
	}

	public int isScrambled(String A, String B) {
		if (hm.containsKey(A + "#" + B)) {
			return hm.get(A + "#" + B);
		}

		if (A.equals(B)) {
			hm.put(A + "#" + B, 1);
			return 1;
		}

		int n = A.length();

		int straight_match = 0, rev_match = 0;

		for (int i = 1; i < n; i++) {
			if ((isScrambled(A.substring(0, i), B.substring(n - i)) == 1
					&& isScrambled(A.substring(i), B.substring(0, n - i)) == 1)) {
				rev_match = 1;
				break;
			}

			if ((isScrambled(A.substring(0, i), B.substring(0, i)) == 1
					&& isScrambled(A.substring(i), B.substring(i)) == 1)) {
				straight_match = 1;
				break;
			}
		}

		if (rev_match == 1 || straight_match == 1) {
			hm.put(A + "#" + B, 1);
		} else {
			hm.put(A + "#" + B, 0);
		}
		return hm.getOrDefault(A + "#" + B, 0);
	}
}
/*
 * Got TLE for this
 * 
 * public class Solution { // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX.
 * IT IS READ ONLY public int isScramble(final String A, final String B) {
 * return isScrambled(A,B); }
 * 
 * public int isScrambled(String A, String B){ if(A.equals(B)){ return 1; } int
 * n=A.length(); if(n<=1){ return 0; } for(int i=1;i<=n;i++){
 * if((isScrambled(A.substring(0,i),B.substring(n-i,n))==1 &&
 * isScrambled(A.substring(i,n),B.substring(0,n-i))==1)) return 1;
 * 
 * if((isScrambled(A.substring(0, i), B.substring(0, i))==1 &&
 * isScrambled(A.substring(i, n), B.substring(i, n))==1)) return 1; } return 0;
 * } }
 */