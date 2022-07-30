class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int [] res = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nums1[i];
        }
        int index  = nums1.length;
        for (int i = 0; i < nums2.length; i++) {
            res[index] = nums2[i];
            index++;
        }
        Arrays.sort(res);
        int size = res.length;
        if(size%2==0)
            return (res[size/2]+res[(size/2-1)])/2.0;
        else
            return  res[size / 2];
    }

}