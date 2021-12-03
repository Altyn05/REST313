package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import rest.exceptionHanding.NoSuchUserException;
import rest.model.Role;
import rest.model.User;
import rest.service.RoleService;
import rest.service.UserService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public MyRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/getAuthorizedUser")
    public ResponseEntity<User> getAuthorizedUser() {
        User authorizedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(authorizedUser);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<Iterable<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.upDateUser(user);
        return ResponseEntity.ok().body(user);
    }






















//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//    }
//
//
//    @GetMapping("users/{id}")
//    public ResponseEntity<User>  getUser(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        if (user == null) {
//            throw new NoSuchUserException("There is no employee with id = " + id + "in DataBase");
//        }
//        return ResponseEntity.ok().body(user);
//    }
//
//
//    @PostMapping("/users")
//    public ResponseEntity<User> addNewUser(@RequestBody User user) {
//        userService.add(user);
//        return ResponseEntity.ok().body(user);
//    }
//
//    @PutMapping("users/update")
//    public ResponseEntity<User> upDate(@RequestBody User user){
//        userService.upDateUser(user);
//        return ResponseEntity.ok().body(user);
//    }
//
//
//    @DeleteMapping("users/{id}")
//    public String deleteUser(@PathVariable Long id){
//        if(userService.getUserById(id)==null){
//            throw new NoSuchUserException("There is no user with is" + id +
//                    "in DataBase");
//        }
//        userService.delete(id);
//        return "User with id "+id+ "was deleted";
//    }
}
