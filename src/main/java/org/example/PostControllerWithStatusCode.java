package org.example;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import org.example.Post;
import org.example.posts.reponse.PostNotFoundResponse;
import org.example.posts.reponse.SavePostsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.*;

//@RestController
//@RequestMapping("posts")
public class PostControllerWithStatusCode {

    Map<Integer, Post> postDB = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){

        Collection<Post> values = postDB.values();

        // Creating an ArrayList of values
        ArrayList<Post> posts = new ArrayList<>(values);

        // Toujours 200
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostDetail(@PathVariable String id){

        if(postDB.containsKey(Integer.valueOf(id))){
            return ResponseEntity.ok(postDB.get(Integer.parseInt(id)));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PostNotFoundResponse(id, "Entity not found with the specified id"));
        }


    }


    @PostMapping
    public ResponseEntity<SavePostsResponse> savePost(@RequestBody Post post) throws URISyntaxException {

        post.setDate(new Date());

        Integer id = getNextId();
        postDB.put(getNextId(),post);

        return ResponseEntity.created(new URI("")).build();//SavePostsResponse.response("Insertion OK",""+id);
    }

    Integer getNextId(){

        return postDB.values().size();
    }

}
