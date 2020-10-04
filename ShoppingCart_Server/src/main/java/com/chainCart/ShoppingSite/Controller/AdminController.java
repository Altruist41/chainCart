package com.SandhyaJoshi.ShoppingSite.Controller;
import com.SandhyaJoshi.ShoppingSite.Model.Product;
import com.SandhyaJoshi.ShoppingSite.Model.User;
import com.SandhyaJoshi.ShoppingSite.Service.ProductService;
import com.SandhyaJoshi.ShoppingSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    //api methods
    @PutMapping("/api/admin/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        if(userService.findUserByUsername(user.getUsername())!=null ){
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("/api/admin/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        User delUser = userService.findUserByUsername(user.getUsername());
        if(delUser!=null && delUser.getUser_id()==user.getUser_id()){
            userService.deleteUser(user.getUser_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/api/admin/listAllUsers")
    public ResponseEntity<?> findAllUsers(){
        return new ResponseEntity<>(userService.listAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/numberOfUsers")
    public ResponseEntity<?> numberOfUsers(){
        return new ResponseEntity<>(userService.numberOfUsers(), HttpStatus.OK);
    }

    @PostMapping("/api/admin/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product){  //@responsebody returns an object  and spring boot displays in in json format
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        //if it doesn't work, try removing the if condition and call directly

        if(productService.findProductByID(product.getProduct_ID()).equals(product.getProduct_ID())){
            return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("/api/admin/deleteProduct")
    public ResponseEntity<?> deleteProduct (@RequestBody Product product){
        productService.deleteProduct(product.getProduct_ID());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/listAllProducts")
    public ResponseEntity<?> listAllProducts(){
        return new ResponseEntity<>(productService.ListProduct(), HttpStatus.OK);
    }

    @GetMapping("/api/sdmin/numberOfProducts")
    public ResponseEntity<?> numberOfProducts(){
        return new ResponseEntity<>(productService.numberOfProduct(), HttpStatus.OK);
    }
}
