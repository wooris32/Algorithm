import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        String[] myArr = {"119", "97674223", "1195524421"};
        System.out.println(solution(myArr));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        //phoneBookMap = makeHashMap(phone_book);
        answer = checkPrefix(phone_book);
        return answer;
    }
/*
    public static HashMap<String,Integer>makeHashMap(String[] phone_book){
        HashMap<String, Integer> tempBookHashMap = new HashMap<>();

        for(String tempPN : phone_book){
                tempBookHashMap.put(tempPN+"",0);
        }
        return tempBookHashMap;
    }
*/
    public static boolean checkPrefix(String[] phone_book){
        HashMap<String, Integer> phoneBookMap = new HashMap<>();

        for(String tempPN : phone_book){
            phoneBookMap.put(tempPN,0);
        }

        /* ver_1.0 : 효율성 3,4를 통과할 수가 없다.
        for(String key : phoneBookMap.keySet()) {
            int keyLenth = key.length();
            for(String number : phoneBookMap.keySet()) {
                if(keyLenth<=number.length()
                    && number.contains(key)
                    && !key.equals(number)
                    && number.substring(0, keyLenth).equals(key)){
                        return false;
                }
            }
        }
        */

        for(String key : phone_book){
            for(int i=0; i<key.length(); i++){
                String temp = key.substring(0,i);
                if (phoneBookMap.containsKey(temp))
                    return false;
            }
        }

        return true;
    }
}