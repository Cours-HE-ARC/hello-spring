package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloControllerCorrige {

    @GetMapping(value = "/hello")
    //Equivalent à @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String helloWorld() {
        return "Hello World! Seb";
    }

    @GetMapping({"/hello2","/hello2/{nom}"})
    //Equivalent à @RequestMapping(value = {"/hello2","/hello2/{nom}"}, method = RequestMethod.GET)
    public @ResponseBody String helloWorld2(@PathVariable(required = false) String nom) {

        nom = defineName(nom);

        return "Hello World! " + nom;
    }


    @GetMapping(value = "/hello3")
    //Equivalent à @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public @ResponseBody String helloWorld3(@RequestParam(required = false) String nom) {

        nom = defineName(nom);

        return "Hello World! " + nom;
    }


    @GetMapping({"/hello4","/hello4/{nom}"})
    //Equivalent à @RequestMapping(value = {"/hello4","/hello4/{nom}"}, method = RequestMethod.GET)
    public @ResponseBody HelloWorld helloWorld4(@PathVariable(required = false) String nom) {

        nom = defineName(nom);

        return new HelloWorld(nom);
    }

    //Factorisation de la gestion du null
    private String defineName(String nom) {
        if(nom == null) {
            nom = "Inconnu!";
        }
        return nom;
    }
}
