 package mydiary.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mydiary.business.EntryBusiness;
import mydiary.business.UserBusiness;
import mydiary.entities.Entry;
import mydiary.entities.User;

@Controller
public class HomeController {
	
	//Session
	@Autowired
	HttpSession session; 
	
	@Autowired
	private UserBusiness userBusiness;
	
	@Autowired
	private EntryBusiness entryBusiness;
	
	@RequestMapping("/home")
	public ModelAndView LoginForm() {
		ModelAndView model = new ModelAndView("homepage");
		
		return model;
	}
	@RequestMapping("/register")
	public ModelAndView RegisterForm() {
		ModelAndView model = new ModelAndView("registrationpage");
		
		return model;
	}
	
	//@RequestMapping(value="saveuser",method=RequestMethod.POST) this type is used to accept only post( not send data from url) to more secure 
	@RequestMapping(value="saveuser",method=RequestMethod.POST) 
	public ModelAndView SaveUser(@ModelAttribute("user") User user) {
		// code to save user data into database
		userBusiness.save(user);
		
		ModelAndView model = new ModelAndView("registrationsuccess");
		return model;
	}
	
	@RequestMapping(value="authuser",method=RequestMethod.POST) 
	public ModelAndView AuthenticateUser(@ModelAttribute("user") User user) {
	
		ModelAndView model = new ModelAndView("homepage");
		
		User user1 = userBusiness.findByUsername(user.getUsername());
		
		if(user1!=null && user.getPassword().equals(user1.getPassword())) {
			// User successfully loggined
			
			model.setViewName("userhomepage");
			model.addObject("user",user1);
			
			// To make user details accessable for all pages
			//or to pass 'user1' details for other pages
			session.setAttribute("user", user1);
			
			List<Entry> entries = null;
			
			try {
				entries = entryBusiness.findEntriesByUserId(user1.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addObject("entrieslist",entries);
			
		}
	
		return model;
	}
	
	@RequestMapping("addentry")
	public ModelAndView AddEntry() {
		ModelAndView model = new ModelAndView("addentrypage");
		return model;	
	}
	
	@RequestMapping("saveentry")
	public ModelAndView SaveEntry(@ModelAttribute("entry") Entry entry) {
		ModelAndView model = new ModelAndView("userhomepage");
		
		//saving entry to db
		entryBusiness.save(entry);
		
		//Getting user1 from 'authuser' through session
		User user1 = (User) session.getAttribute("user");
		
		// Shows Updated List of Entries
		List<Entry> entries = null;
		
		try {
			entries = entryBusiness.findEntriesByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries); 
		
		return model;
		
	}
	
	
	@RequestMapping("viewentry")
	public ModelAndView ViewEntry(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView("displayentrypage");
		
		Entry entry = entryBusiness.findByID(id);
	    
		model.addObject("entry",entry);
		
		//This code is to provide security
		//Getting user1 from 'authuser' through session
		User user1 = (User) session.getAttribute("user");
			    
	    if(user1==null) { // it is 'null' only when user not authenticated, so more secure
		   model.setViewName("home"); //if 'null' send to home page
	    }
			    
		return model;	
	}
	
	@RequestMapping("updateentrypage")
	public ModelAndView UpdateEntry(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView("displayupdateentrypage");
		
		Entry entry = entryBusiness.findByID(id);
		
		//Getting user1 from 'authuser' through session
	    User user1 = (User) session.getAttribute("user");
	    
	    if(user1==null) { // it is 'null' only when user not authenticated, so more secure
	    	model.setViewName("homepage"); //if 'null' send to home page
	    }
		
		model.addObject("entry",entry);
		return model;	
	}
	
	@RequestMapping("saveupdateentry")
	public ModelAndView SaveUpdateEntry(@RequestParam("userid") int uid, @RequestParam("id") int id, @RequestParam("description") String desc, @RequestParam("entrydate") Date date) {
		ModelAndView model = new ModelAndView("userhomepage");
		
		Entry entry = new Entry();
		entry.setId(id);
		entry.setEntrydate(date);
		entry.setDescription(desc);
		entry.setUserid(uid);
		//saving entry to db
		entryBusiness.update(entry);
		
		//Getting user1 from 'authuser' through session
		User user1 = (User) session.getAttribute("user");
		
		// Shows Updated List of Entries
		List<Entry> entries = null;
		
		try {
			entries = entryBusiness.findEntriesByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries); 
		
		return model;
		
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView DeleteEntry(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView("userhomepage");
		
		Entry entry = entryBusiness.findByID(id);
		
		
		//This code is to provide security
		//Getting user1 from 'authuser' through session
		User user1 = (User) session.getAttribute("user");
			    
	    if(user1==null) { // it is 'null' only when user not authenticated, so more secure
		   model.setViewName("homepage"); //if 'null' send to home page
	    }
	    else {
	    	entryBusiness.delete(entry);
	    }
		
	
		// Shows Updated List of Entries
		List<Entry> entries = null;
		
		try {
			entries = entryBusiness.findEntriesByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries); 
		return model;
	}
	
	
	@RequestMapping("backuserhome")
	public ModelAndView BackUserHome() {
		ModelAndView model = new ModelAndView("userhomepage");
		
		//Getting user1 from 'authuser' through session
				User user1 = (User) session.getAttribute("user");
				
				// Shows Updated List of Entries
				List<Entry> entries = null;
				
				try {
					entries = entryBusiness.findEntriesByUserId(user1.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				model.addObject("entrieslist",entries); 
				
				return model;
	}
	

	@RequestMapping("/pk")
	public ModelAndView PEntry(@ModelAttribute("entry") Entry entry, HttpSession session) {
		ModelAndView model = new ModelAndView("result");
		
		model.addObject("entry",entry);
		return model;	
	}
	
	@RequestMapping("signout")
	public ModelAndView SignOut() {
		ModelAndView model = new ModelAndView("homepage");
		
		session.invalidate();
	
		return model;	
	}
	
}
