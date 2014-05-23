package com.my.mainserver.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mainserver.model.DBclass;
import com.my.mainserver.model.changePwd;


@Controller
@RequestMapping("/account")
public class AccountController 
{
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

		

	@RequestMapping(value = "/serverstatus", method = RequestMethod.GET)
	public String serverStatus() 
	{
		logger.info("MTC Server status Check - Successful");
		return "/serverstatus";
	}
	
	@RequestMapping(value="/login/{imei}/{password}", method=RequestMethod.GET,produces = "application/json")
	public  @ResponseBody Object login(@PathVariable ("imei") String imei,@PathVariable ("password")  String password)
	{
		DBclass dc = new DBclass();
		dc.readDataBase();
		dc.validUser(imei,password);
		return dc;
		
	}
	@RequestMapping(value="/about",method=RequestMethod.GET,produces="application/json")
	public String about()
	{
		logger.info("developed by dinesh");
		return "/about";

	}

	@RequestMapping(value="/login/changepwd/{imei}/{old}/{new}", method=RequestMethod.GET,produces = "application/json")
	public  @ResponseBody Object changepwd(@PathVariable ("old") String oldpwd,@PathVariable ("imei") String imei,@PathVariable ("new")  String newpwd)
	{
		changePwd cp=new changePwd();
		cp.change(oldpwd,imei,newpwd);
		return null;
	}
	
	
		
}
