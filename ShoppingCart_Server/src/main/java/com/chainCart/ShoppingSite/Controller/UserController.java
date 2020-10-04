package com.SandhyaJoshi.ShoppingSite.Controller;

import com.SandhyaJoshi.ShoppingSite.Model.*;
import com.SandhyaJoshi.ShoppingSite.Service.*;
import com.SandhyaJoshi.ShoppingSite.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

//@CrossOrigin(origins = { "http://localhost:3000"})
@RestController //this will convert whatever is returned into json format in response
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BuyProductsService buyProductsService;

    @Autowired
    private ContractsService contractsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    //the API methods
    @PostMapping("api/user/signup")
    public ResponseEntity<?> RegisterUser(@RequestBody User user){
        if (userService.findUserByUsername(user.getUsername())!=null){  //if id not null already, send conflict
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.CUSTOMER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
    //added 8th june
    @PutMapping("/api/user/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        if(userService.findUserByUsername(user.getUsername())!=null ){
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findUserByUsername(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("api/user/products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.ListProduct(), HttpStatus.OK);
    }

    @GetMapping("api/user/purchasehistory/{user_id}")
    public ResponseEntity<?> getAllTransactionHash(@PathVariable("user_id") int user_id){
        return new ResponseEntity<>(buyProductsService.findByUserID(user_id), HttpStatus.OK);
    }

    @GetMapping("api/user/contracthistory/{user_id}")
    public ResponseEntity<?> getAllContractHash(@PathVariable("user_id") int user_id){
        return new ResponseEntity<>(contractsService.findByUserID(user_id), HttpStatus.OK);
    }


  //added june 27
  @PostMapping("api/user/savecontracts")
  public ResponseEntity<?> saveContracts(@RequestBody Contracts contracts){
      return new ResponseEntity<>(contractsService.saveContracts(contracts), HttpStatus.CREATED);
  }


  @PostMapping("/api/user/savetransaction")
  public ResponseEntity<?> buyProducts(@RequestBody BuyProducts buyProducts){
      buyProductsService.saveTransaction(buyProducts);
      //buyProducts.setPurchaseDate(LocalDateTime.now());
      return new ResponseEntity<>(buyProducts, HttpStatus.CREATED);
  }

  @PostMapping("/api/user/saveorder")
  public ResponseEntity<?> saveOrder(@RequestBody Order order){
      order.setOrder_Date(LocalDateTime.now());
      orderService.saveOrder(order);
      return new ResponseEntity<>(order,HttpStatus.CREATED);
  }

    //newly added 5-31-2020
   /* @PostMapping("/api/user/purchase")
    public ResponseEntity<?> saveTransaction(@RequestBody BuyProducts buyProducts Order order){
        buyProductsService.saveTransaction(buyProducts);

    }*/
}
