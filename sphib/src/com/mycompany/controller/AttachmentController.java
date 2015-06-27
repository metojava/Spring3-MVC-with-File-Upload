/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dao.AttachmentDao;
import com.mycompany.domain.Attachments;
import com.mycompany.domain.Upfile;

/**
 *
 * @author americano
 */
@Controller
public class AttachmentController {

    @Autowired
    private AttachmentDao attachmentDao;

    @RequestMapping("/attachment")
    public ModelAndView attachment() {
        ModelAndView mv = new ModelAndView("attachment");
        mv.addObject("upfile", new Upfile());
        
//        List<Attachments> ats =attachmentDao.findAll();
//        if(ats.size()>0)
//        mv.addObject("atts",ats);
//        
        return mv;
    }

    @RequestMapping("/upload")
    public ModelAndView upload(@ModelAttribute("upfile") Upfile upfile,BindingResult result
    		
           ) throws IOException {
    	
    	 Attachments attachment = new Attachments();
    	 MultipartFile mf = null;
    	 
        try {
        	mf=upfile.getMf();
           
            attachment.setName(mf.getOriginalFilename());
            
            byte[] ba = mf.getBytes();
            Date dt = new Date();
            attachment.setCreated(dt);
            attachment.setAttachment(ba);
            attachmentDao.save(attachment);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

      
        ModelAndView mv = new ModelAndView("listAttachments");
        mv.addObject("accachments", attachmentDao.findAllNames());

        return mv;
    }
    
    @RequestMapping("/listAttachments")
    public ModelAndView listAttachments()
    {
    	 ModelAndView mv = new ModelAndView("listAttachments");
         mv.addObject("accachments", attachmentDao.findAllNames());

         return mv;
    	
    }
    @RequestMapping(value = "/download/{aidi}",method = RequestMethod.GET)
    public ModelAndView download(@PathVariable("aidi")Integer aidi)
    {
    	
    	Attachments attachment = attachmentDao.load(aidi);
    	
    	ModelAndView  mv = new ModelAndView("attachm");
    	mv.addObject("attachment", attachment);
    	return mv;
    	
    }
    
    @RequestMapping("/remova/{cid}")
    public String listAttachments(@PathVariable("cid") Integer cid)
    {
    	attachmentDao.remove(cid);

         return "redirect:/listAttachments.htm";
    	
    }
}
