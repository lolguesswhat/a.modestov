package tests;

import adapter.JSONPlaceholder;
import dao.User;
import feign.Feign;
import org.testng.annotations.Test;
import feign.gson.GsonDecoder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;

@SpringBootApplication
public class RestApiTest extends BaseTest{
    @Test
    public void JsonPlaceHolderTest() {

        //Step 1.
        List<User> posts = jsonPlaceholder.users();
        IntStream.range(0, posts.size() - 1).forEach(x -> assertTrue(posts.get(x).getId() < posts.get(x + 1).getId(), "Posts are not sorted ascending"));

        //Step 2.


        System.out.println("List all users\n");

        // get all users from JSONPlaceholder
        jsonPlaceholder.users().stream().forEach(user -> System.out.println(user.toString()));

        System.out.println("\nList all emails of users\n");

        // get all users email address only
        jsonPlaceholder.users().stream().forEach(user -> System.out.println(user.getEmail()));

        System.out.println("\nGet a particular user by using his/her id\n");

        // get a user by id
        User user = jsonPlaceholder.users(1);
        System.out.println(user.toString());

        System.out.println("\nGet all post titles of a user using userId\n");

        // get all post titles of a user using userId
        jsonPlaceholder.posts(9).stream().forEach(p -> System.out.println(p.getTitle()));
    }
}
