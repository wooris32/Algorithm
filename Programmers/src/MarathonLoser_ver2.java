import java.util.*;

public class MarathonLoser_ver2 {
    public static HashMap<String, Integer> participantMap = new HashMap<>();

    public static void main(String[] args) {
        String[] myArr = {"mislav", "stanko", "mislav", "ana"};
        String[] myArr2 = {"stanko", "ana", "mislav"};
        System.out.println(solution(myArr, myArr2));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        participantMap = makeHashMap(participant);
        return findLosers(completion);
    }

    //participant로 HashMap 생성
    public static HashMap<String, Integer> makeHashMap(String[] participant) {
        HashMap<String, Integer> tempParticipantMap = new HashMap<>();

        for (String tempS : participant) {
            if (tempParticipantMap.containsKey(tempS)) {
                tempParticipantMap.put(tempS, tempParticipantMap.get(tempS).intValue() + 1);
            } else {
                tempParticipantMap.putIfAbsent(tempS, 1);
            }
        }
        return tempParticipantMap;
    }

    public static String findLosers(String[] completion) {
        for (String tempS : completion) {
            participantMap.put(tempS, participantMap.get(tempS).intValue() - 1);
        }

        for (String tempS : participantMap.keySet()) {
            if (participantMap.get(tempS) == 1) {
                return tempS;
            }
        }
        return "";
    }
}



