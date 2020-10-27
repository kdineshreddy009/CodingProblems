package miscellaneous;
class MedianOfTwoSortedArrays {
   	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int x = nums1.length;
		int y = nums2.length;

		int low = 0, high = x;

		while (low <= high) {
			int xpar = (low + high) / 2;
			int ypar = (x + y + 1) / 2 - xpar;

			int XLP = (xpar == 0) ? Integer.MIN_VALUE : nums1[xpar - 1];
    		int XP = (xpar==x) ? Integer.MAX_VALUE : nums1[xpar];
    		
    		int YLP = (ypar == 0) ? Integer.MIN_VALUE : nums2[ypar - 1];
    		int YP = (ypar==y) ? Integer.MAX_VALUE : nums2[ypar];
    		
    		if(XLP<=YP && YLP<=XP) {
    			if((x+y)%2 == 1) {
    				return (double)Math.max(XLP, YLP);
    			}else{
                    return ((double)(Math.max(XLP,YLP)+Math.min(XP,YP))/2);
                }
    		}else if(XLP>YP) {
    			high--;
    		}else {
    			low++;
    		}
    		
		}
		return 0;
	}
}