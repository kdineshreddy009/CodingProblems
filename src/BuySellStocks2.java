//O(n)
//Explanation: 
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/208241/Explanation-for-the-dummy-like-me.
public class BuySellStocks2 {
 public int maxProfit(final int[] prices) {
     int i=0,buy=0,sell=0,profit=0;
     while(i<prices.length-1){
         while(i<prices.length-1 && prices[i+1]<=prices[i]){
             i++;
         }
         buy = prices[i];
         while(i<prices.length-1 && prices[i+1]>=prices[i]){
             i++;
         }
         sell=prices[i];
         profit+=sell-buy;
     }
     return profit;
 }
}
//Exponential solution using backtracking
//public class Solution {
//  public int maxProfit(final List<Integer> A) {
//      return getProfit(0,false,A,0);
//  }
//  private int getProfit(int val,boolean canSell,List<Integer> A,int i){
//      if(i>=A.size()){
//          return 0;
//      }
//      if(canSell){
//          return Math.max(A.get(i)-val+getProfit(0,false,A,i+1),
//                                       getProfit(val,true,A,i+1));
//      }else{
//          return Math.max(getProfit(A.get(i),true,A,i+1),
//                          getProfit(0,false,A,i+1));
//      }
//  }
//}

//Got TLE after memoization
//public class Solution {
//  static HashMap<String,Integer> hm;
//  public int maxProfit(final List<Integer> A) {
//      hm = new HashMap<String,Integer>();
//      return getProfit(0,false,A,0);
//  }
//  private int getProfit(int val,boolean canSell,List<Integer> A,int i){
//      if(i>=A.size()){
//          return 0;
//      }
//      if(hm.containsKey(val+""+canSell+""+i)){
//          return hm.get(val+""+canSell+""+i);
//      }
//      if(canSell){
//          hm.put(val+""+canSell+""+i, Math.max(A.get(i)-val+getProfit(0,false,A,i+1),
//                                       getProfit(val,true,A,i+1)));
//      }else{
//          hm.put(val+""+canSell+""+i, Math.max(getProfit(A.get(i),true,A,i+1),
//                          getProfit(0,false,A,i+1)));
//      }
//      return hm.get(val+""+canSell+""+i);
//  }
//}

