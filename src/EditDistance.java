//https://www.interviewbit.com/problems/edit-distance/

/*
Backtracking - got TLE
public class Solution {
    public int minDistance(String A, String B) {
        return solve(A,A.length()-1,B,B.length()-1);
    }
    
    private int solve(String s1,int i,String s2,int j){
        if(i<0&&j<0){
            return 0;
        }
        if(j<0){
            return i+1;
        }else if(i<0){
            return j+1;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return solve(s1,i-1,s2,j-1);
        }else{
            return 1+Math.min(solve(s1,i,s2,j-1),
                              Math.min(solve(s1,i-1,s2,j-1),solve(s1,i-1,s2,j)));
        }
    }
}
*/

/*
backtracing + memoization - Passed tests
public class Solution {
    HashMap<String,Integer> hm;
    public int minDistance(String A, String B) {
        hm = new HashMap<String,Integer>();
        return solve(A,A.length()-1,B,B.length()-1);
    }
    
    private int solve(String s1,int i,String s2,int j){
        if(hm.containsKey(i+"#"+j)){
            return hm.get(i+"#"+j);
        }
        if(i<0&&j<0){
            return 0;
        }
        if(i>=0 && j<0){
            return i+1;
        }else if(i<0 && j>=0){
            return j+1;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            hm.put(i+"#"+j, solve(s1,i-1,s2,j-1));
        }else{
// There can be 3 choices when character doesn't match of Source & destination string:
// i) insert a new char in source string & decrease destination pointer(as we have inserted it)
// ii) Replace current char with destination's current char & decrease both pointers
// iii) delete current char in source string & decrease pointer
// Keep counting the operations by adding 1 & store only the minimum path one 
            int insert_ = solve(s1,i,s2,j-1);
            int replace_ = solve(s1,i-1,s2,j-1);
            int delete_ = solve(s1,i-1,s2,j);
            hm.put(i+"#"+j, 1+Math.min(insert_,Math.min(replace_,delete_)));
        }
        // common return for if/else
        return hm.get(i+"#"+j);
    }
}
*/

// Converted Memoization to Tabulation
public class EditDistance {
    public int minDistance(String A, String B) {
        int[][] dp = new int[A.length()+1][B.length()+1];
        for(int i=1;i<B.length()+1;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<A.length()+1;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<A.length()+1;i++){
           for(int j=1;j<B.length()+1;j++){
             if(A.charAt(i-1)==B.charAt(j-1)){
                 dp[i][j] = dp[i-1][j-1];
             }else{            	 
                 dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
             }
           } 
        }
        return dp[A.length()][B.length()];
    }
}
