package adapter;

import static constants.Endpoints.*;

import constants.Params;
import dao.Post;
import dao.User;
import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient
public interface JSONPlaceholder {

    @GetMapping(POSTS)
    Response getListOfPostsResponse();

    @GetMapping(POSTS)
    List<Post> getListOfPosts();

    @GetMapping(value = POSTS + ID)
    Response getPostByIdResponse(@PathVariable(Params.ID) int id);

    @GetMapping(value = POSTS + ID)
    Post getPostById(@PathVariable(Params.ID) int postId);

    @GetMapping(value = USERS)
    List<User> getListOfUsers();

    @GetMapping(value = USERS)
    Response getListOfUsersResponse();

    @GetMapping(value = USERS + ID)
    User getUserById(@PathVariable(Params.ID) int id);

    @GetMapping(value = USERS + ID)
    Response getUserByIdResponse(@PathVariable(Params.ID) int id);

    @PostMapping(
            value = POSTS,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Post sendPost(@RequestBody Post post);
}
