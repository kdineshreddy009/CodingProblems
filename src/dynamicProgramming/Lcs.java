package dynamicProgramming;
/*
https://www.interviewbit.com/problems/longest-common-subsequence/
*/


/*BackTracking + Memoization solution Approach:

public class Solution {
    HashMap<String,Integer> hm;
    public int solve(String A, String B) {
    For storing already calculated sequence
        hm = new HashMap<String,Integer>();
        return lcs(A,A.length()-1,B,B.length()-1);
    }

    private int lcs(String s1,int i,String s2,int j){
        Exit case
        if(i<0 || j<0){
            return 0;
        }

        if(hm.containsKey(i+"$"+j)){
            return hm.get(i+"$"+j);
        }
//If character at current index matches, we will add 1 to solution
        if(s1.charAt(i)==s2.charAt(j)){
            hm.put(i+"$"+j,1+lcs(s1,i-1,s2,j-1));
            return hm.get(i+"$"+j);
        }else{
//If Characters doesn't match, we'll recursively call 
            hm.put(i+"$"+j,Math.max(lcs(s1,i-1,s2,j),lcs(s1,i,s2,j-1)));
            return hm.get(i+"$"+j);
        }
    }
}
*/

//Converted Above to Tabulation solution
public class Lcs {
    public int solve(String A, String B) {
    	// Each cell represents max common sequence till the characters in string    	
        int dp[][]=new int[A.length()+1][B.length()+1];
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                	//If character at current index matches, we will add 1 to solution
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                	//If Characters doesn't match,we will store max sequence so far to current value
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
