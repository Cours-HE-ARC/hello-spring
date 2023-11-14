package org.example;

import org.example.posts.reponse.SavePostsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RestController
//@RequestMapping("posts")
public class PostController {

    List<Post> postDB = new ArrayList<Post>();

    @GetMapping
    public List<Post> getAllPosts(){

        return new ArrayList<>(postDB);
    }

    @GetMapping("/{id}")
    public @ResponseBody Post getPostDetail(@PathVariable String id){

        System.out.println("posts/id" + id);
        return postDB.get(Integer.parseInt(id));
    }




    @PostMapping
    public SavePostsResponse savePost(@RequestBody Post post){

        post.setDate(new Date());
        postDB.add(post);

        return SavePostsResponse.response("Insertion OK",getLastId());
    }

    String getLastId(){
        return "" + (postDB.size() -1);
    }

}
