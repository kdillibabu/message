package com.my.mainserver.contoller;

import java.io.DataInputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mainserver.model.addUser;

@Controller
@RequestMapping("/add")
public class AddingUserController 
{
	DataInputStream dis=new DataInputStream(System.in);

	@RequestMapping(value="/adduser/{imei}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object adduse(@PathVariable String imei)
	{
		//System.out.println("imei:"+imei);		
		addUser au=new addUser();
		au.checkUser(imei);
		return null;
	}

}
