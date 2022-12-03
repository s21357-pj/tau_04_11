import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pjatk.tau.Friendships;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FriendshipsTestAssertj {
    private Friendships temp;
    @BeforeEach
    public void setup() throws Exception {
        temp = new Friendships();
    }
    @Test
    public void testMakeFriends(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.areFriends("Ala", "Kot")).isTrue();
    }
    @Test
    public void testMakeFriendsReverse(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.areFriends("Kot", "Ala")).isTrue();
    }
    @Test
    public void testNotFriends(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.areFriends("Kot", "Kot")).isFalse();
    }
    @Test
    public void testMultipleFriends(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        assertThat(temp.getFriendsList("Ala")).contains("Kot", "Pies");
    }
    @Test
    public void testMultipleFriendsReverse(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        assertThat(temp.getFriendsList("Kot")).contains("Ala");
    }
    @Test
    public void testMultipleFriendsReverse2(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        assertThat(temp.getFriendsList("Pies")).contains("Ala");
    }
    @Test
    public void testMultiple2Friends(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        temp.makeFriends("Tomek", "Kot");
        assertThat(temp.getFriendsList("Kot")).contains("Ala");
        assertThat(temp.getFriendsList("Kot")).contains("Tomek");
        assertThat(temp.getFriendsList("Kot")).contains("Ala");
        assertThat(temp.getFriendsList("Pies")).doesNotContain("Tomek");
    }
    @Test
    public void testMultiple2FriendsReverse(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        temp.makeFriends("Tomek", "Kot");
        assertThat(temp.getFriendsList("Ala")).contains("Kot");
        assertThat(temp.getFriendsList("Ala")).contains("Pies");
        assertThat(temp.getFriendsList("Tomek")).contains("Kot");
        assertThat(temp.getFriendsList("Tomek")).doesNotContain("Pies");
    }
    @Test
    public void testMultiple2FriendsByFunction(){
        temp.makeFriends("Ala", "Kot");
        temp.makeFriends("Ala", "Pies");
        temp.makeFriends("Tomek", "Kot");
        assertThat(temp.areFriends("Ala", "Kot")).isTrue();
        assertThat(temp.areFriends("Ala", "Pies")).isTrue();
        assertThat(temp.areFriends("Tomek", "Kot")).isTrue();
        assertThat(temp.areFriends("Tomek", "Pies")).isFalse();
    }
    @Test
    public void testNotEmptyList(){
        temp.makeFriends("Ala", "Kot");
        assertThat(temp.getFriendsList("Ala")).isNotEmpty();
    }
    @Test
    public void testIsInstanceTemp(){
        assertThat(temp.getClass()).isInstanceOf(Class.class);
    }
    @AfterEach
    public void teardown() throws Exception {
        temp = null;
    }
}
