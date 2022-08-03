class Solution {
   public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>();
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                pQueue.add(ints[j]);
            }
        }
        int size = pQueue.size();
        int num = 0;
        for (int i = 0; i < k; i++)
            num= pQueue.poll();
        
        return num;
    }
}