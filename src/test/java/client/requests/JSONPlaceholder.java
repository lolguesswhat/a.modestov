package client.requests;

import static constants.Endpoints.*;

import dao.Post;
import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient
public interface JSONPlaceholder {

    @GetMapping(POSTS)
    Response getListOfPostsResponse();

    @GetMapping(value = POSTS + "{id}/")
    Response getPostByIdResponse(@PathVariable("id") int id);

    @GetMapping(value = USERS)
    Response getListOfUsersResponse();

    @GetMapping(value = USERS + "{id}/")
    Response getUserByIdResponse(@PathVariable("id") int id);

    @PostMapping(
            value = POSTS,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Response sendPost(@RequestBody Post post);
}
