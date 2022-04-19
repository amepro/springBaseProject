package amepro.example.gn.demo.controller;

import amepro.example.gn.demo.model.UserEntity;
import amepro.example.gn.demo.response.ResponseHandler;
import amepro.example.gn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //add
    // @PostMapping(value = "/users")
    /*public UserEntity Post(@RequestBody UserEntity params){
        return userService.Post(params);
    }*/
    @PostMapping(value = "/users")
    public ResponseEntity<Object> Post(@RequestBody UserEntity params) {
        try {
            UserEntity result = userService.Post(params);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }



    //Get All
   /* @GetMapping(value = "/users")
    public List<UserEntity> Get(){
        return userService.Get();
    }*/
    @GetMapping(value = "/users")
    public ResponseEntity<Object> Get() {
        try {
            List<UserEntity> result = userService.Get();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    //Get by id
   /* @GetMapping(value = "/users/{id}")
    public UserEntity Get(@PathVariable int id){
        return userService.Get(id);
    }*/
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            UserEntity result = userService.Get(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    //Update
   /* @PutMapping(value = "/users/{id}")
    public UserEntity Update(@PathVariable int id, @RequestBody UserEntity params){
        return userService.Upadate(params,id);
    }*/
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody UserEntity params) {
        try {
            UserEntity result = userService.Update(params, id);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    //Delete
    /*@DeleteMapping(value = "/users/{id}")
    public String Delete(@PathVariable int id){
        return userService.Delete(id);
    }*/
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Object> Delete(@PathVariable int id) {
        try {
            String result = userService.Delete(id);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


}
