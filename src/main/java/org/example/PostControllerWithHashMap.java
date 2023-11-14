package org.example;

import org.example.posts.reponse.DeletePostsResponse;
import org.example.posts.reponse.SavePostsResponse;
import org.example.posts.reponse.UpdatePostsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("posts")
public class PostControllerWithHashMap {

    Map<Integer,Post> postDB = new HashMap<>();

    @GetMapping
    public List<Post> getAllPosts(){

        return new ArrayList<>(postDB.values());
    }

    @GetMapping("/{id}")
    public @ResponseBody Post getPostDetail(@PathVariable String id){

        return postDB.get(Integer.parseInt(id));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody DeletePostsResponse deletePost(@PathVariable String id){

        System.out.println("put/id" + id);

        DeletePostsResponse response;

        //Si la cle existe
        if(postDB.containsKey(Integer.valueOf(id))){
            postDB.remove(Integer.valueOf(id));
            response = DeletePostsResponse.response("Post deleted", id);
        }else{
            response = DeletePostsResponse.response("Post not deleted, id not present", id);
        }

        return response;
    }
    @PutMapping("/{id}")
    public @ResponseBody UpdatePostsResponse updatePost(@PathVariable String id,@RequestBody Post post){

        System.out.println("put/id" + id);

        UpdatePostsResponse response;

        //Si la cle existe
        if(postDB.containsKey(Integer.valueOf(id))){
            postDB.put(Integer.valueOf(id),post);
            response = UpdatePostsResponse.response("Post updated", id);
        }else{
            response = UpdatePostsResponse.response("Post not updated, id not present", id);
        }

        return response;
    }
    @PostMapping
    public SavePostsResponse savePost(@RequestBody Post post){

        post.setDate(new Date());

        Integer id = getNextId();
        postDB.put(getNextId(),post);

        return SavePostsResponse.response("Insertion OK",""+id);
    }

    Integer getNextId(){

        return postDB.values().size();
    }

}
