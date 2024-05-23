package SplitwiseBasic.services;

import SplitwiseBasic.entity.User;

import java.util.Map;

public class SplitWiseService {

    private Map<String, User> userMap;

    public SplitWiseService(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }


    public void display(){
        for(Map.Entry<String,User>entry1 : userMap.entrySet()){
            User user = userMap.get(entry1.getKey());
            for(Map.Entry<User,Integer>entry : user.getBorrowedBy().entrySet()){
                String borrowedUserId = entry.getKey().getUserId();
                Integer money = entry.getValue();
                System.out.println(String.format("%s owes %s : %s", borrowedUserId, entry1.getKey(), money));
            }
        }
    }
    public void display(String userId){
        if(!userMap.containsKey(userId)){
            System.out.println("Invalid User ID");
            return;
        }
        User user = userMap.get(userId);
        for(Map.Entry<User,Integer>entry : user.getBorrowedBy().entrySet()){
            String borrowedUserId = entry.getKey().getUserId();
            Integer money = entry.getValue();
            System.out.println(String.format("%s owes %s : %s", borrowedUserId, userId, money));
        }
    }




}
