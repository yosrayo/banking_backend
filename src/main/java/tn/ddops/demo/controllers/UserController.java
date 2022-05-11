package tn.ddops.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.ddops.demo.entities.User;
import tn.ddops.demo.services.IUserService;
import tn.ddops.demo.services.MyUserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;

	@PostMapping("/addUser")
	@ResponseBody
	public String addUser(@RequestBody User user) {
		String msg = "";
		User userExists = userService.findByUsername(user.getUsername());
		
		if (userExists != null) {
			
			msg = "There is already a user registered with the user name provided";
		
		} else {
			
			userService.addUser(user);
			
			//update user id paiment as int with 10 digits (il suffit de l'enregistrer une autre fois pour le mettre a jour)
			user.setIdPaiement(user.getIdUser()+Math.pow(10,9));
			userService.addUser(user);
			msg = "user added succesfully !";

		}
		return msg;
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/findUser/{userId}")
	@ResponseBody
	public User getUserById(@PathVariable("userId") int userId) {

		System.out.println("user found succesfully !");
		return userService.getUserById(userId);
	}
	
	
	@PostMapping("/verifyUser/{userId}")
	@ResponseBody
	public String verifyUserById(@PathVariable("userId") int userId) {

		System.out.println("user found succesfully !");
		
		User user =  userService.getUserById(userId);
		user.setVerified(true);
		userService.addUser(user);
		
		return "User activated successfully";
	}

	
	@GetMapping("/login/{username}/{password}")
	@ResponseBody
	public UserDetails login(@PathVariable String username,@PathVariable String password) {

		System.out.println("user found succesfully !");
		return myUserDetailsService.loadUserByUsername(username);
	}
	
	


	@GetMapping("/authentify/{username}/{password}")
	@ResponseBody
	public User authentify(@PathVariable String username,@PathVariable String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = userService.findByUsername(username);

		System.out.println(user.getPwd());
		boolean isPasswordMatches = encoder.matches(password, user.getPwd());

		if ( isPasswordMatches  ) {
			return user;
		}else 
		{
			return user;
		}
		
		

		
	}
	
	@PostMapping("/updateProfile")
	@ResponseBody
	public User updateProfile(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}
	

	
	@PostMapping("/passwordForgettin/{username}/{new_password}")
	@ResponseBody
	public User updatePassword(@PathVariable String username,@PathVariable String new_password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = userService.findByUsername(username);
		user.setPwd(encoder.encode(new_password));
		userService.addUser(user);
		return user;
	}
	
    
	 @PutMapping("/updateUser/{username}")
	    public User updateUser(@PathVariable(value = "username") String username,  @RequestBody User userDetails) {

	        User user = userService.findByUsername(username);
	        user.setFirstName(userDetails.getFirstName());
	        user.setLastName(userDetails.getLastName());
	        user.setMail(userDetails.getMail());
	        user.setPhone(userDetails.getPhone()); 
	        user.setAddress(userDetails.getAddress());
	        user.setCity(userDetails.getCity());
	        user.setPwd(userDetails.getPwd());
	        user.setPhoto(userDetails.getPhoto());
	        
	        User updatedUser = userService.addUser(userDetails);
	        return updatedUser;
	    }
}
