package miscellaneous;
//import java.util.HashMap;
//
//public class FreshWorks {
//	public static void main(String[] args) {
//
//	}}
//
////price static
//// parking lot -> multi. storeys (slots)
//// SUV slots
//// Other vehicles comes 
//
////* Big Trucks 3 slots
////* >SUV < Truck 2slots
////* 2Wheels - 2/4 bikes
//
////based on measures
//
//// entry of vehicle=> Allot the space
//// Types- electric/not
//
////->Vehicle enters
////->Estimated time from V.Owner
////floors  -5 to 2
////->assign slot address(from ) -> Mark that slot as occ.{- (reduce the slot, at respective floor)}
////->Total avail space
//
////->Up on Exit (check Estimate Vs actual exit time)
////->Add back the slot to parking floor & slot
////->new customer && out of space(we will give estimate)
//
////Vehicle
////ParkingLot(spaces)
////Floor
////Slot
////Person (Watchman, Customer)
//
//	Enum typeOfVehicle = { bike, big_bike, SUV, van, truck };
//
//	
//Interface Vehicle{
//	String numberPlate;
//	typeOfVehicle type;
//	Boolean isElectric;}
//
//Class ParkingLot{
//	String name;
//	List<Floor> listOFloors;
//	GateKeep gateKeeper;
//}
//
//class Floor{
//	int floor_num;
//	List<Slot> slotsInFloor;
//	int capacity;
//}
//
//class Slot{
//	int floor;
//	String slotAddress;
//	Boolean canCharge;
//	Boolean isOccupied;
//}
//
//class Person{
//	String name;
//}
//
//class GateKeep extends Person{
//	String id;
//}
//
//
////getAvailableSlot()
//
////floors & slots
//// Total hm= {floor:Number_of_slot}
//class ParkingLot{
////	private 
////	Single
////ListOfFloor	
//	 
//	public Floor getFloor(int floor_num){
//		if(floor_num <startFloor || floor_num> endFloor) {
//			throw Exception; 
//		}
//		
//		return listOFloors.get(floor_num);
//	}
//}
//
//private int[] getAvailableSlot(Enum typeOfVehicle,Boolean isElectric){
//	
//	
//	for(int i=1;i<listOFloors;i++) {
//		if(get(i).capacity) {
//			
//		}
//	}
//	
//}
//
////assignSlot()
////getEstimate()
////
////exit()
////collectCharge()
////fillback()
//
//
//
//
//
////A, B -
////A-Gxxgyydagdddaydga B-gda
//
////Hmap {g-1,d-1,a-1}
////cnt
////Start
////wehen cnt =0, end
////g at 0 =>{g-0,d-1,a-1}
//
//// new_start_index = 2
//
////Goodda
////Hmap {g-0,d-0,a-0}
////cnt = 3-> finished the B string or not 
////Start(0)
////new_start_index
////
//
////private String findMinSubString(String A, String B) {
////	HashMap<Character, Integer> hm = new HashMap<>();
////	for (int i = 0; i < B.length(); i++) {
////		hm.put(B.charAt(i), hm.getOrDefault(B.charAt(i), 0) + 1);
////	}
////	int new_index = 0;
////	int start = 0, end = 0, cnt = B.length();
////	while (new_index < A.length() && new_index + B.length() < A.length()) {
////		for (int i = new_index; i < A.length(); i++) {
////			if (hm.containsKey(A.charAt(i))) {
////				
////			}
////		}
////	}
////
////	return "";
////}