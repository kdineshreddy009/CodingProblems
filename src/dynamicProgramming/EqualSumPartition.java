package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
 * knapsack-bounded
 * */
public class EqualSumPartition {
	static List<Integer> result;
	static List<Integer> return_result;

	boolean canPartitionStoreResult(int a[], int sum, int index) {
		if (sum == 0) {
			return_result = new ArrayList<>(result);
			return true;
		}

		if (index >= a.length || a.length == 0)
			return false;

		boolean inclusive = false;
		if (a[index] <= sum) {
			result.add(a[index]);
			inclusive = canPartitionStoreResult(a, sum - a[index], index + 1);
			result.remove(result.size() - 1);
		}
		boolean nonInclusive = canPartitionStoreResult(a, sum, index + 1);
		return inclusive || nonInclusive;
	}

	public static void main(String args[]) {
		int input[] = { 1, 1, 3, 4, 7 };
		int sum = 0;
		// if sum is odd, we can't really divide into 2 equal partitions		
		for (int i = 0; i < input.length; i++)
			sum += input[i];

		EqualSumPartition equalSumPartition = new EqualSumPartition();		
		result = new ArrayList<>();
		return_result = new ArrayList<>();
		if (sum % 2 == 0) {
			System.out.println(equalSumPartition.canPartitionStoreResult(input, sum / 2, 0));
			System.out.println(return_result);
			return;
		}
		System.out.println("False");
	}
}
