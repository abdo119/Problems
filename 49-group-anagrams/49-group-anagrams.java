class Solution {
      static public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> times = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (String st :strs) {
            char [] c = st.toCharArray();
            Arrays.sort(c);
            String res = Arrays.toString(c);
            if(!times.containsKey(res)){
                List<String> word = new ArrayList<>();
                word.add(st);
                times.put(Arrays.toString(c),lists.size());
                lists.add(word);
            }else {
                lists.get(times.get(res)).add(st);
            }
        }

        return lists;
    }

}