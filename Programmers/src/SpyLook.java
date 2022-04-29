import java.util.*;

public class SpyLook {
    public static HashMap<String, ArrayList<String>> spyClothMap = new HashMap<>();
    public static void main(String[] args) {
        String[][] myArr = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(myArr));
    }

    public static int solution(String[][] clothes) {
        int answer = 0;

        spyClothMap = makeHashMap(clothes);
        return getCount();
    }

    //cloth List로 HashMap 생성
    //key 옷구분
    //value 옷이름
    public static HashMap<String, ArrayList<String>> makeHashMap (String[][] clothes) {
        HashMap<String, ArrayList<String>> tempClothMap = new HashMap<>();

        //2차원 배열 이므로 2중 for loop로 hashMap 생성
        for (int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            ArrayList<String> tempArrayList = new ArrayList<>();
            if(tempClothMap.containsKey(type)){
                tempArrayList = tempClothMap.get(type);
            }
            tempArrayList.add(clothes[i][0]);
            tempClothMap.put(type,tempArrayList);
        }
        return tempClothMap;
    }

    public static Integer getCount(){
        int ans=1;
        for(String type : spyClothMap.keySet()){
            if(spyClothMap.size() == 1){
                return spyClothMap.get(type).size();
            }else{
                ans *= (spyClothMap.get(type).size()+1) ;
            }
        }
        return ans-1;
    }




/*
        for(String tempS : completion){
            int tempKey = tempS.hashCode();

            //만약 같은 키가 있다면
            // 1) 동명이인
            // 2) 우연히 value가 다르지만 키가 같음
            if(tempCompletionMap.containsKey(tempKey)){
                tempCompletionMap.get(tempKey).add(tempS);
            }else{
                ArrayList<String>tempArrayList = new ArrayList<>();
                tempArrayList.add(tempS);
                tempCompletionMap.put(tempKey,tempArrayList);
            }
        }
        return tempCompletionMap;
    }

    public static String findLosers(String[] participant){
        List<String> partArrayList = Arrays.asList(participant);
        String ans="";
        for(String tempS : participant){
            int tempKey = tempS.hashCode();
            if(!completionMap.containsKey(tempKey)){
                ans = tempS;
                break;
            }else{
                ArrayList<String>tempArrayList = completionMap.get(tempKey);
                //1. 우연히 키는 같았지만 없는경우
                if(!tempArrayList.contains(tempS)) {
                    ans = tempS;
                    break;
                }else{
                    //2. 동명이인인 경우
                    int cntB = Collections.frequency(tempArrayList, tempS);
                    int cntP = Collections.frequency(partArrayList, tempS);
                    if(cntB!=cntP) {
                        ans = tempS;
                        break;
                    }
                }
            }
        }
        return ans;
    }


 */
}