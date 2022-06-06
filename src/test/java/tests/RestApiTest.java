package tests;

import dao.Post;

import dao.User;
import feign.Response;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.random;
import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.testng.Assert.*;
import static utils.JsonUtils.*;
import static utils.propertiesReader.ReaderGetter.*;

@SpringBootApplication
@EnableFeignClients
public class RestApiTest extends BaseTest {

    @Test
    public void jsonPlaceholderTest() throws IOException {
        Logger logger = LoggerFactory.getLogger("Test steps");
        logger.debug("Step 1");
        Response postsResponse = jsonPlaceholder.getListOfPostsResponse();
        assertEquals(postsResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        assertTrue(isStringJson(postsResponse.body().toString()), "Response body is not json");
        List<Post> posts = jsonPlaceholder.getListOfPosts();
        IntStream.range(0, posts.size() - 1).forEach(x -> assertTrue(posts.get(x).getId() < posts.get(x + 1).getId(),
                "Posts are not sorted ascending"));

        logger.debug("Step 2");
        Response postResponse = jsonPlaceholder.getPostByIdResponse(getTestDataReader().test2ExpectedId());
        assertEquals(postResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        Post postToGetStep2 = jsonPlaceholder.getPostById(getTestDataReader().test2PostNumber());
        assertEquals(postToGetStep2.getUserId(), getTestDataReader().test2ExpectedUserId(),
                "User id does not match");
        assertEquals(postToGetStep2.getId(), getTestDataReader().test2ExpectedId(), "Post id does not match");
        assertNotNull(postToGetStep2.getBody(), "Body is null");
        assertNotNull(postToGetStep2.getTitle(), "Title is null");

        logger.debug("Step 3");
        Response postToGetStep3 = jsonPlaceholder.getPostByIdResponse(getTestDataReader().test3PostNumber());
        assertEquals(postToGetStep3.status(), HttpStatus.NOT_FOUND.value(), "Status code does not match");
        assertEquals(IOUtils.toString(postToGetStep3.body().asInputStream(), StandardCharsets.UTF_8),
                getTestDataReader().test3ExpectedBody(),
                "Body is not empty");

        logger.debug("Step 4");
        Post postToSend = new Post(
                null,
                getTestDataReader().test4UserId(),
                randomAlphabetic((int) (random() * 10)),
                randomAlphabetic((int) (random() * 10)));
        Post responsePost = jsonPlaceholder.sendPost(postToSend);
        assertEquals(responsePost.getTitle(), postToSend.getTitle(), "Sent Title does not match response");
        assertEquals(responsePost.getBody(), postToSend.getBody(), "Sent Body does not match response");
        assertEquals(responsePost.getUserId(), postToSend.getUserId(), "Sent UserId does not match response");
        assertNotNull(responsePost.getId(), "Response does not contain variable 'id'");

        logger.debug("Step 5");
        Response listOfUsersResponse = jsonPlaceholder.getListOfUsersResponse();
        assertEquals(listOfUsersResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        assertTrue(isStringJson(postsResponse.body().toString()), "Response body is not json");
        User userToCheck = jsonPlaceholder.getListOfUsers().get(getTestDataReader().test5ExpectedId() - 1);
        User userToCheckWithFromList = getUserFromJson(getTestDataReader().test5PathToUser5());
        assertEquals(userToCheck, userToCheckWithFromList, "User 5's data does not match test data");

        logger.debug("Step 6");
        Response userToCheckWithResponse = jsonPlaceholder.getUserByIdResponse(getTestDataReader().test5ExpectedId());
        assertEquals(userToCheckWithResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        assertTrue(isStringJson(userToCheckWithResponse.body().toString()), "Response body is not json");
        User userToCheckWith = jsonPlaceholder.getUserById(getTestDataReader().test5ExpectedId());
        assertEquals(userToCheck, userToCheckWith, "User 5's data does not match test data");
    }
}
