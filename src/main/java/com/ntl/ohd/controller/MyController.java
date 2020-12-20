package com.ntl.ohd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ntl.ohd.model.Assignee;
import com.ntl.ohd.model.CreateRequestDetails;
import com.ntl.ohd.model.Facilities;
import com.ntl.ohd.model.Facility;
import com.ntl.ohd.model.LoginCredentials;
import com.ntl.ohd.model.Requestor;
import com.ntl.ohd.service.AssigneeService;
import com.ntl.ohd.service.FacilityService;
import com.ntl.ohd.service.RequestorService;

@Controller
public class MyController {

	
	@Autowired
	private RequestorService requestorService;
	
	@Autowired 
	private AssigneeService assigneeService;
	
	@Autowired
	private FacilityService facilityService;

	public RequestorService getRequestorService() {
		return requestorService;
	}

	public void setRequestorService(RequestorService requestorService) {
		this.requestorService = requestorService;
	}
	
	
	
	public AssigneeService getAssigneeService() {
		return assigneeService;
	}

	public void setAssigneeService(AssigneeService assigneeService) {
		this.assigneeService = assigneeService;
	}
	

	public FacilityService getFacilityService() {
		return facilityService;
	}

	public void setFacilityService(FacilityService facilityService) {
		this.facilityService = facilityService;
	}

	@RequestMapping(value ="/" ,method=RequestMethod.GET)
	public String homePage(){
		return "index";
	}
	
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("loginCredential", new LoginCredentials());
		return "login";
	}
	
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("loginCredential") LoginCredentials loginCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		Requestor requestor = getRequestorService().validateRequestorCredential(loginCredential.getUserId(), loginCredential.getPassword());
		if(requestor!= null){
			modelAndView.addObject("requestor", requestor);
			List<Facilities> facilities=getRequestorService().getFacilitiesFromDAO();
			modelAndView.addObject("facilities", facilities);
			return modelAndView;
			
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}
	@RequestMapping(value ="/AssigneeloginSuccess" ,method=RequestMethod.POST)
	public ModelAndView AssigneeloginSuccess(@Valid @ModelAttribute("loginCredential") LoginCredentials loginCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("welcomeassignee");
		Assignee assignee = getAssigneeService().validateAssigneeCredential(loginCredential.getUserId(), loginCredential.getPassword());
		if(assignee!= null){
			modelAndView.addObject("assignee", assignee);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}
	@RequestMapping(value ="/FacilityloginSuccess" ,method=RequestMethod.POST)
	public ModelAndView FacilityloginSuccess(@Valid @ModelAttribute("loginCredential") LoginCredentials loginCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		ModelAndView modelAndView = new ModelAndView("FacilityloginSuccess");
		Facility facility = getFacilityService().validateFacilityHeadCredential(loginCredential.getUserId(), loginCredential.getPassword());
		if(facility!= null){
			modelAndView.addObject("facility", facility);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}
		
	
	
	@RequestMapping(value ="/createRequest" ,method=RequestMethod.GET)
	public String createRequestPage(Model model){
		model.addAttribute("createRequestDetails", new CreateRequestDetails());
		List<Facilities> facilities=getRequestorService().getFacilitiesFromDAO();
		model.addAttribute("facilities", facilities);
		return "createRequest";
	}
	
	@RequestMapping(value ="/submitrequest" ,method=RequestMethod.POST)
	public ModelAndView submitRequest(@Valid @ModelAttribute("createRequestDetails") CreateRequestDetails createRequestDetails,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("createRequest");
		}
		ModelAndView modelAndView = new ModelAndView("myRequest");
		getRequestorService().createRequest(createRequestDetails.getRequestorId(), createRequestDetails.getFacility(),createRequestDetails.getSeveriety(), createRequestDetails.getDescription());
		return modelAndView;
		
	}
}
