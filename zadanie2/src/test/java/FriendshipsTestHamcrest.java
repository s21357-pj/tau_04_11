import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pjatk.tau.Friendships;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FriendshipsTestHamcrest {
    private Friendships temp;
    @BeforeEach
    public void setup() throws Exception {
        temp = new Friendships();
    }
    @Test
    public void testMakeFriends(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.areFriends("Ala", "Kot"), is(true));
    }
    @Test
    public void testMakeFriendsReverse(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.areFriends("Kot", "Ala"), is(true));
    }
    @Test
    public void testNotFriends(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.areFriends("Kot", "Kot"), is(false));
    }
    @Test
    public void testMultipleFriends(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        assertThat(temp.getFriendsList("Ala"), contains("Kot", "Pies"));
    }
    @Test
    public void testMultipleFriendsReverse(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        assertThat(temp.getFriendsList("Kot"), contains("Ala"));
    }
    @Test
    public void testMultipleFriendsReverse2(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        assertThat(temp.getFriendsList("Pies"), contains("Ala"));
    }
    @Test
    public void testMultiple2Friends(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        temp.makeFriends("Tomek", "Kot");
        assertThat(temp.getFriendsList("Kot"), containsInAnyOrder("Ala", "Tomek"));
    }
    @Test
    public void testMultiple2FriendsReverse(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        temp.makeFriends("Tomek", "Kot");
        assertThat(temp.getFriendsList("Ala"), containsInAnyOrder("Kot", "Pies"));
        assertThat(temp.getFriendsList("Tomek"), contains("Kot"));
        assertThat(temp.getFriendsList("Tomek"), not("Pies"));
    }
    @Test
    public void testMultiple2FriendsByFunction(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        temp.makeFriends("Tomek", "Kot");
        assertThat(temp.areFriends("Ala", "Kot"), is(true));
        assertThat(temp.areFriends("Ala", "Pies"), is(true));
        assertThat(temp.areFriends("Tomek", "Kot"), is(true));
        assertThat(temp.areFriends("Tomek", "Pies"), is(false));
    }
    @Test
    public void testNotEmptyList(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.getFriendsList("Ala"), notNullValue());
    }
    @Test
    public void testIsInstanceTemp(){
        assertThat(temp.getClass(), instanceOf(Class.class));
    }
    @AfterEach
    public void teardown() throws Exception {
        temp = null;
    }
}
