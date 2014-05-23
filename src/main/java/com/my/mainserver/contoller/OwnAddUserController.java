package com.my.mainserver.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mainserver.model.addUser;
import com.my.mainserver.model.updateUser;


@Controller
@RequestMapping("/mainuser")
public class OwnAddUserController {

	@RequestMapping(value="/auth/{imei}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object auth(@PathVariable String imei)
	{
		addUser au=new addUser();
		au.justCheck(imei);
		return null;
		
	}
	
	@RequestMapping(value="/updateprofile/{imei}/{name}/{password}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object updateprofile(@PathVariable ("imei") String imei, @PathVariable ("name") String name, @PathVariable ("password") String password)
	{
		updateUser au=new updateUser();
		au.updateUserProfile(imei,name,password);
		return null;
	}


}
