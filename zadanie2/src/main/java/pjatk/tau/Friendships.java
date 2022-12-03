package pjatk.tau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }

    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        List<String> person1List, person2List = new ArrayList<>();
        person1List = friendships.get(person1);
        person2List = friendships.get(person2);
        return person1List.contains(person2) && person2List.contains(person1);
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
        List<String> tempList = new ArrayList<>();
        if (friendships.containsKey(person)) {
            tempList = friendships.get(person);
            tempList.add(friend);
            friendships.replace(person, tempList);
        }
        else {
            tempList.add(friend);
            friendships.put(person, tempList);
        }
    }
}