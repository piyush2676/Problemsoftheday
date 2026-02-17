class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
       for(int hour =0;hour<=11;hour++){
        for(int minutes = 0;minutes<=59;minutes++){
            if(Integer.bitCount(hour) + Integer.bitCount(minutes) == turnedOn){
                String hours = Integer.toString(hour);
                String minute = (minutes < 10 ? "0" : "") + Integer.toString(minutes);

                ans.add(hours + ":" + minute);
            }
        }
       }
       return ans;
    }
}