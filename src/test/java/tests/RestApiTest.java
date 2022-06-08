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
import org.testng.asserts.SoftAssert;
import utils.propertiesReader.ResponseBodyDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    @Test
    public void jsonPlaceholderTest() {

        Logger logger = LoggerFactory.getLogger("Test steps");
        logger.debug("Step 1");
        SoftAssert step1Assert = new SoftAssert();
        Response postsResponse = jsonPlaceholder.getListOfPostsResponse();
        step1Assert.assertEquals(postsResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        step1Assert.assertTrue(isBodyJson(postsResponse.body().toString()), "Response body is not json");
        List<Post> posts = getListOfPojo(postsResponse, Post[].class);
        IntStream.range(0, posts.size() - 1).forEach(x -> step1Assert.assertTrue(posts.get(x).getId() < posts.get(x + 1).getId(),
                "Posts are not sorted ascending"));
        step1Assert.assertAll();

        logger.debug("Step 2");
        SoftAssert step2Assert = new SoftAssert();
        Response postResponse = jsonPlaceholder.getPostByIdResponse(getTestDataReader().test2PostNumber());
        step2Assert.assertEquals(postResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        Post postToGetStep2 = getPojo(jsonPlaceholder.getPostByIdResponse(getTestDataReader().test2PostNumber()), Post.class);
        step2Assert.assertEquals(parseInt(postToGetStep2.getUserId().toString()), getTestDataReader().test2ExpectedUserId(), "User id does not match");
        step2Assert.assertEquals(parseInt(postToGetStep2.getId().toString()), getTestDataReader().test2PostNumber(), "Post id does not match");
        step2Assert.assertNotNull(postToGetStep2.getBody(), "Body is null");
        step2Assert.assertNotNull(postToGetStep2.getTitle(), "Title is null");
        step2Assert.assertAll();

        logger.debug("Step 3");
        SoftAssert step3Assert = new SoftAssert();
        Response postToGetStep3 = jsonPlaceholder.getPostByIdResponse(getTestDataReader().test3PostNumber());
        step3Assert.assertEquals(postToGetStep3.status(), HttpStatus.NOT_FOUND.value(), "Status code does not match");
        step3Assert.assertEquals(ResponseBodyDecoder.decode(postToGetStep3),
                getTestDataReader().test3ExpectedBody(),
                "Body is not empty");
        step3Assert.assertAll();

        logger.debug("Step 4");
        SoftAssert step4Assert = new SoftAssert();
        Post postToSend = Post
                .builder()
                .body(randomAlphabetic((int) (random() * 10)))
                .title(randomAlphabetic((int) (random() * 10)))
                .userId(getTestDataReader().test4UserId())
                .build();
        Post responsePost = getPojo(jsonPlaceholder.sendPost(postToSend), Post.class);
        step4Assert.assertEquals(responsePost.getTitle(), postToSend.getTitle(), "Sent Title does not match response");
        step4Assert.assertEquals(responsePost.getBody(), postToSend.getBody(), "Sent Body does not match response");
        step4Assert.assertEquals(responsePost.getUserId(), postToSend.getUserId(), "Sent UserId does not match response");
        step4Assert.assertNotNull(responsePost.getId(), "Response does not contain variable 'id'");
        step4Assert.assertAll();

        logger.debug("Step 5");
        SoftAssert step5Assert = new SoftAssert();
        Response listOfUsersResponse = jsonPlaceholder.getListOfUsersResponse();
        step5Assert.assertEquals(listOfUsersResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        step5Assert.assertTrue(isBodyJson(listOfUsersResponse.body().toString()), "Response body is not json");
        User userToCheck = getListOfPojo(jsonPlaceholder.getListOfUsersResponse(), User[].class).get(getTestDataReader().test5ExpectedId() - 1);
        User userToCheckWithFromList = getPojoFromFile(getTestDataReader().test5PathToUser5(), User.class);
        step5Assert.assertEquals(userToCheck, userToCheckWithFromList, "User 5's data does not match test data");
        step5Assert.assertAll();

        logger.debug("Step 6");
        SoftAssert step6Assert = new SoftAssert();
        Response userToCheckWithResponse = jsonPlaceholder.getUserByIdResponse(getTestDataReader().test5ExpectedId());
        step6Assert.assertEquals(userToCheckWithResponse.status(), HttpStatus.OK.value(), "Response status does not match");
        step6Assert.assertTrue(isBodyJson(userToCheckWithResponse.body().toString()), "Response body is not json");
        User userToCheckWith = getPojo(jsonPlaceholder.getUserByIdResponse(getTestDataReader().test5ExpectedId()), User.class);
        step6Assert.assertEquals(userToCheck, userToCheckWith, "User 5's data does not match test data");
        step6Assert.assertAll();
    }
}
