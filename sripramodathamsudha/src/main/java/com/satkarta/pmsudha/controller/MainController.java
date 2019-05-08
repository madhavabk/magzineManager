package com.satkarta.pmsudha.controller;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import com.satkarta.pmsudha.dao.AppUserDAO;
import com.satkarta.pmsudha.dao.CountryDAO;
import com.satkarta.pmsudha.formbean.AppUserForm;
import com.satkarta.pmsudha.model.AppUser;
import com.satkarta.pmsudha.model.City;
//import com.satkarta.pmsudha.model.Country;
import com.satkarta.pmsudha.model.State;
import com.satkarta.pmsudha.validator.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
public class MainController {
 
   @Autowired
   private AppUserDAO appUserDAO;
 
   @Autowired
   private CountryDAO countryDAO;
 
   @Autowired
   private AppUserValidator appUserValidator;
 
   // Set a form validator
   @InitBinder
   protected void initBinder(WebDataBinder dataBinder) {
      // Form target
      Object target = dataBinder.getTarget();
      if (target == null) {
         return;
      }
 
      if (target.getClass() == AppUserForm.class) {
         dataBinder.setValidator(appUserValidator);
      }
      // ...
   }
 
   @RequestMapping("/")
   public String viewHome(Model model) {
 
      return "welcomePage";
   }
 
   @RequestMapping("/members")
   public String viewMembers(Model model) throws IOException {
 
      List<AppUser> list = appUserDAO.getAppUsers();
	   //ArrayList<String> list = appUserDAO.getAppUsers();
 
      model.addAttribute("members", list);
 
      return "membersPage";
   }
 
   @RequestMapping("/registerSuccessful")
   public String viewRegisterSuccessful(Model model) {
 
      return "registerSuccessfulPage";
   }
 
   // Show Register page.
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public String viewRegister(Model model) {
 
      AppUserForm form = new AppUserForm();
      
      //Added : Pramodatma
      List<State> states = countryDAO.getStates();
      List<City> cities = countryDAO.getCities();
      List<Integer> subPeriod = new ArrayList<>(Arrays.asList(1,2,3));      
      
      //List<String> cities = countryDAO.getCities();
      
      //List<Country> countries = countryDAO.getCountries();
      
      
      model.addAttribute("appUserForm", form);
      //model.addAttribute("countries", countries);
      model.addAttribute("states", states);
      model.addAttribute("cities", cities);
      model.addAttribute("subscriptionPeriod", subPeriod);
      
 
      return "registerPage";
   }
 
   // This method is called to save the registration information.
   // @Validated: To ensure that this Form
   // has been Validated before this method is invoked.
   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public String saveRegister(Model model, //
         @ModelAttribute("appUserForm") @Validated AppUserForm appUserForm, //
         BindingResult result, //
         final RedirectAttributes redirectAttributes) {
 
      // Validate result
      if (result.hasErrors()) {
         List<State> countries = countryDAO.getStates();
         model.addAttribute("countries", countries);
         model.addAttribute("errors", result.getAllErrors());
         return "errorPage";
         //return "registerPage";
      }
      AppUser newUser= null;
      try {
    	 PrintController.print("Now sending it to create new appUser");
         newUser = appUserDAO.createAppUser(appUserForm);
      }
      // Other error!!
      catch (Exception e) {
         List<State> countries = countryDAO.getStates();
         model.addAttribute("countries", countries);
         model.addAttribute("errorMessage", "Error: " + e.getMessage());
         return "registerPage";
      }
 
      redirectAttributes.addFlashAttribute("flashUser", newUser);
       
      return "redirect:/registerSuccessful";
   }
 
}