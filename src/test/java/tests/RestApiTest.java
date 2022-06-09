package tests;

import dao.Post;

import dao.User;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.asserts.SoftAssert;
import utils.propertiesReader.ResponseBodyDecoder;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.lang.Math.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static utils.JsonUtils.*;
import static utils.propertiesReader.ReaderGetter.*;

@SpringBootApplication
@EnableFeignClients
public class RestApiTest extends BaseTest {
    private SoftAssert softAssert;

    @Test
    public void jsonPlaceholderTest() {
        Logger logger = LoggerFactory.getLogger("Test steps");
        logger.debug("Step 1");
        softAssert = new SoftAssert();
        Response postsResponse = jsonPlaceholder.getListOfPostsResponse();
        softAssert.assertEquals(postsResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        softAssert.assertTrue(isBodyJson(postsResponse.body().toString()), "Response body is not json");
        List<Post> posts = getListOfPojo(postsResponse, Post[].class);
        IntStream.range(0, posts.size() - 1).forEach(x -> softAssert.assertTrue(posts.get(x).getId() < posts.get(x + 1).getId(),
                "Posts are not sorted ascending"));
        softAssert.assertAll();

        logger.debug("Step 2");
        softAssert = new SoftAssert();
        Response postResponse = jsonPlaceholder.getPostByIdResponse(getTestDataReader().test2PostNumber());
        softAssert.assertEquals(postResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        Post postToGetStep2 = getPojo(jsonPlaceholder.getPostByIdResponse(getTestDataReader().test2PostNumber()), Post.class);
        softAssert.assertEquals(parseInt(postToGetStep2.getUserId().toString()), getTestDataReader().test2ExpectedUserId(), "User id does not match");
        softAssert.assertEquals(parseInt(postToGetStep2.getId().toString()), getTestDataReader().test2PostNumber(), "Post id does not match");
        softAssert.assertNotNull(postToGetStep2.getBody(), "Body is null");
        softAssert.assertNotNull(postToGetStep2.getTitle(), "Title is null");
        softAssert.assertAll();

        logger.debug("Step 3");
        softAssert = new SoftAssert();
        Response postToGetStep3 = jsonPlaceholder.getPostByIdResponse(getTestDataReader().test3PostNumber());
        softAssert.assertEquals(postToGetStep3.status(), HttpStatus.NOT_FOUND.value(), "Status code does not match");
        softAssert.assertEquals(ResponseBodyDecoder.decode(postToGetStep3),
                getTestDataReader().test3ExpectedBody(),
                "Body is not empty");
        softAssert.assertAll();

        logger.debug("Step 4");
        softAssert = new SoftAssert();
        Post postToSend = Post
                .builder()
                .body(randomAlphabetic((int) (random() * 10)))
                .title(randomAlphabetic((int) (random() * 10)))
                .userId(getTestDataReader().test4UserId())
                .build();
        Post responsePost = getPojo(jsonPlaceholder.sendPost(postToSend), Post.class);
        softAssert.assertEquals(responsePost.getTitle(), postToSend.getTitle(), "Sent Title does not match response");
        softAssert.assertEquals(responsePost.getBody(), postToSend.getBody(), "Sent Body does not match response");
        softAssert.assertEquals(responsePost.getUserId(), postToSend.getUserId(), "Sent UserId does not match response");
        softAssert.assertNotNull(responsePost.getId(), "Response does not contain variable 'id'");
        softAssert.assertAll();

        logger.debug("Step 5");
        softAssert = new SoftAssert();
        Response listOfUsersResponse = jsonPlaceholder.getListOfUsersResponse();
        softAssert.assertEquals(listOfUsersResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        softAssert.assertTrue(isBodyJson(listOfUsersResponse.body().toString()), "Response body is not json");
        User userToCheck = getListOfPojo(jsonPlaceholder.getListOfUsersResponse(), User[].class).get(getTestDataReader().test5ExpectedId() - 1);
        User userToCheckWithFromList = getPojoFromFile(getTestDataReader().test5PathToUser5(), User.class);
        softAssert.assertEquals(userToCheck, userToCheckWithFromList, "User 5's data does not match test data");
        softAssert.assertAll();

        logger.debug("Step 6");
        softAssert = new SoftAssert();
        Response userToCheckWithResponse = jsonPlaceholder.getUserByIdResponse(getTestDataReader().test5ExpectedId());
        softAssert.assertEquals(userToCheckWithResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        softAssert.assertTrue(isBodyJson(userToCheckWithResponse.body().toString()), "Response body is not json");
        User userToCheckWith = getPojo(jsonPlaceholder.getUserByIdResponse(getTestDataReader().test5ExpectedId()), User.class);
        softAssert.assertEquals(userToCheck, userToCheckWith, "User 5's data does not match test data");
        softAssert.assertAll();
    }
}
