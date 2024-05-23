package SplitWise.entities.Group;

import SplitWise.entities.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController(){
        groupList = new ArrayList<>();
    }

    public void createNewGroup(String id, String name, User createdByUser){
        Group group = new Group();
        group.setGroupName(name);
        group.setGroupId(id);
        group.addMember(createdByUser);
        groupList.add(group);
    }

    public Group getGroup(String groupId){

        for(Group group: groupList) {

            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }


}
