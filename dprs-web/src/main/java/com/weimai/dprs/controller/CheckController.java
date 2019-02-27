package com.weimai.dprs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
 * 应用状态检查   
 *  
 * @author qianlishui  
 * @date 2017年4月23日  
 */
@RestController  
public class CheckController {  
      
	
	
	@RequestMapping("/check")  
    public String check(){  
        return "true";  
    }  

} 
