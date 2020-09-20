package dynamicProgramming;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Problem: https://leetcode.com/problems/minimum-number-of-refueling-stops/submissions/
public class MinFuelStops {
	/*
	 * Approach:-
	 * https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
	 * 
	 * i) Keep traveling with existing fuel & at each station insert Fuel into Max
	 * Priority Queue 
	 * ii) If running on insufficient fuel to reach next station/if target not reached- consume fuel from priority Queue 
	 */
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		Queue<Integer> fuelQueue = new PriorityQueue<>(Collections.reverseOrder());
		int index = 0;
		int stops = 0;
		while (true) {
			if (startFuel >= target) {
				return stops;
			}

			if (index < stations.length && startFuel < stations[index][0]) {
				if (fuelQueue.isEmpty()) {
					return -1;
				}
				startFuel += fuelQueue.poll();
				stops++;
			} else {
				if (index < stations.length) {
					fuelQueue.add(stations[index][1]);
					index++;
				} else {
					if (fuelQueue.isEmpty()) {
						return -1;
					}
					startFuel += fuelQueue.poll();
					stops++;
				}
			}
		}
	}

/*	Below is Recursion approach- choosing between approach; but exponential complexity & got TLE */
/*	
    HashSet<String> hm;
	int result;

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		hm = new HashSet<>();
		result = Integer.MAX_VALUE;
		reachTargetMinimum(startFuel, target, 0, stations, 0);
		if (result == Integer.MAX_VALUE)
			return -1;
		return result;
	}

	private void reachTargetMinimum(int distanceReached, int target, int index, int[][] stations, int stationedSoFar) {
		if (hm.contains(distanceReached + "-" + target + "-" + index)) {
			return;
		}
		if (distanceReached >= target) {
			result = Math.min(result, stationedSoFar);
			return;
		}

		if (index >= stations.length || distanceReached < stations[index][0]) {
			return;
		}

		if (distanceReached == stations[index][0]) {
			hm.add((distanceReached + stations[index][1]) + "-" + target + "-" + (index + 1));
			reachTargetMinimum(distanceReached + stations[index][1], target, index + 1, stations, stationedSoFar + 1);
			return;
		}

		if (distanceReached > stations[index][0]) {
			hm.add(distanceReached + "-" + target + "-" + (index + 1));
			reachTargetMinimum(distanceReached, target, index + 1, stations, stationedSoFar);
			hm.add((distanceReached + stations[index][1]) + "-" + target + "-" + (index + 1));
			reachTargetMinimum(distanceReached + stations[index][1], target, index + 1, stations, stationedSoFar + 1);
			return;
		}
	}
*/
	public static void main(String[] args) {
		MinFuelStops obj = new MinFuelStops();
		// test case - {[10,60],[20,30],[30,30],[60,40]}
		int[][] stas = new int[4][2];
		stas[0][0] = 10;
		stas[0][1] = 60;

		stas[1][0] = 20;
		stas[1][1] = 30;

		stas[2][0] = 30;
		stas[2][1] = 30;

		stas[3][0] = 60;
		stas[3][1] = 40;

		System.out.println(obj.minRefuelStops(100, 10, stas));
	}
}
