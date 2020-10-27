package miscellaneous;
//import java.util.ArrayList;
//import java.util.HashMap;
//
///*
// * List of words = [cat, bat, sit, rat, hat, hit, git, kit, wit, bit]
// * 
// * 
// * 
// * word of same length(say)
// * 
// * n=3(length)
// * given 2 words w1 cat , w2 sit (part of list)
// * 
// * 
// * hop from one to other, if edit-dist. is 1
// * cat bat bit sit = 2
// * [cat, bat, sit, rat, hat, hit, git, kit, wit, bit]
// * cat sit
// * 
// * bat rat hat sat   sit
// * bat-rat bar hat sat
// * rat- 
// * 
// * cat bat bar bir sir sit 
// * cat sat sit 
// * cat hat hit sit 
// * 
// *
// * if 1 return 1
// * list with edit_dis word = []
// * 
// * list with edit_dis
// * 
// *  for(i=  0 to n-1){
// *  	
// *  	findMinPath()
// *  }
// * */
//public class SNow {
////	static HashMap<String, Integer> isVisited = new HashMap<>(); 
////	HashSet
//	static int result_hop=0;
//	private int findMinHops(ArrayList<String> list_of_words, String src, String des) {
//		
//		if(editDis(src,des)==1) {
//			return 1;
//		}
//		
//		ArrayList<String> travelList = getWordswithUnitDist(src, list_of_words);		
//		// copy string to hashmap with 0 as value(means not visited)
//		//isVisited - add src in hashset
//		for(int i=0;i<travelList.size();i++) {			
//			if(isVisited.contains(travelList.get(i)))
//				continue;
//			Math.min(result_hop, list_of_words, travelList.get(i),des);
//		}
//		return result_hop;
//	}
//// editDis
////	numberofWords * n
////	calling all nodes & not visitin
//	
////	n=3   ED=1 ED=2 ED=3
//	
////	
////	n, n-1, n-2...1  O(n^2)
////	if 1
//	private ArrayList<String> getWordswithUnitDist(String src, ArrayList<String> list_of_words) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//	}
//
//}
//
//
//
////Chat System - 
//
////->Communication
//// For each Client - TCP <communication> -> server-> dest. Client(may or may not online)
//// http - long polling -> checks avail. of Client
//
////->DeliveryApp
////->content-> text.
//
//// number of users - any 
//// User -  any
//
//// client, Content  
//// Content - date and Time, ReceivedFrom, SentTo
//
//Mapping
//2 tables
//// Client - Content
//// Content -
//
////3 ppl
////
////Akash, dinesh, Varun
////
////Grp:
////A -> hi
////dinesh (replies) > Hey
////
//
////1-1
////Varun (D)->Dinesh : Wassup 
////							
//								varchar      varchar    isGroup
////Content - date and Time, ReceivedFrom, SentTo-Dinesh   Y
//
////								Fstack
////								JSP Ang. InHouse 
////								D. not micro.
//								
//// Clients are unique
//// based on the time/date database
//// content  
//
//
////->Users 
////->Rooms - reaches all members
//// Check old messages
//
////->Exchange of messages
////->Data base Design
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
