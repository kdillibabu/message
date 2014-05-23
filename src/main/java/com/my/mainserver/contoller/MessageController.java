package com.my.mainserver.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mainserver.model.messageDB;

@Controller
@RequestMapping("/user")
public class MessageController {

	
	@RequestMapping(value="/message",method=RequestMethod.GET,produces="application/json")
	public  String  message()
	{
		messageDB ad=new messageDB();
		ad.Message();
		return null;
	}
	@RequestMapping(value="/message/{imei}/{messageContent}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object messageContent(@PathVariable ("imei") String imei, @PathVariable ("messageContent") String messagecontent)
	{
		messageDB md=new messageDB();
		md.writeMessage(imei,messagecontent);
		return null;
	}

}
