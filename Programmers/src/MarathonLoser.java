import java.util.*;

public class MarathonLoser {
    public static HashMap<Integer, ArrayList<String>> completionMap = new HashMap<>();
    public static void main(String[] args) {
        String[] myArr = {"mislav", "stanko", "mislav", "ana"};
        String[] myArr2 = {"stanko", "ana", "mislav"};
        System.out.println(solution(myArr, myArr2));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        completionMap = makeHashMap(completion);
        answer = findLosers(participant);

        return answer;
    }

    //completion List로 HashMap 생성
    public static HashMap<Integer, ArrayList<String>> makeHashMap (String[] completion){
        HashMap<Integer, ArrayList<String>> tempCompletionMap = new HashMap<>();

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
}