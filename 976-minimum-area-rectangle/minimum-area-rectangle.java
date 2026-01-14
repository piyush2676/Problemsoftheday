class Solution {
    public int minAreaRect(int[][] points) {
       Map<Integer,Set<Integer>> map = new HashMap<>();
       for(int[] i : points){
          map.computeIfAbsent(i[0],k -> new HashSet<>()).add(i[1]);
       }
       int Minarea = Integer.MAX_VALUE;
       List<Integer> list = new ArrayList<>(map.keySet());
       for(int i = 0;i<list.size();i++){
        for(int j = i+1;j<list.size();j++){
            int x1 = list.get(i);
            int x2 = list.get(j);

            Set<Integer> s1 = map.get(x1);
            Set<Integer> s2 = map.get(x2);

            List<Integer> common_ele = new ArrayList<>();
            for(int present : s1){
                if(s2.contains(present)){
                    common_ele.add(present);
                }
            }
            Collections.sort(common_ele);
            for(int k = 1; k< common_ele.size();k++){
                int height = common_ele.get(k)-common_ele.get(k-1);
                int width = Math.abs(x1-x2);
                Minarea = Math.min(Minarea,height*width);
            }
        }
       }
       return Minarea ==  Integer.MAX_VALUE ? 0 : Minarea;
    }
}