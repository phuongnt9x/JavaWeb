package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("feedbacks")
public class FeedBackController {
    String[] listStars = {"1","2","3","4","5"};

    @Autowired
    private IFeedBackService iFeedBackService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<FeedBack> list= iFeedBackService.findAll();
        ModelAndView modelAndView=new  ModelAndView("index");
        modelAndView.addObject("stars",listStars);
        modelAndView.addObject("list",list);
        modelAndView.addObject("newFeedback",new FeedBack());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute FeedBack comment){
        comment.setNumberOfLike(0);
        comment.setTime(new Date());
        iFeedBackService.addFeedBack(comment);
        return new ModelAndView("redirect:/feedbacks");
    }
    @GetMapping("like")
    public ModelAndView like(@RequestParam Long id){
        FeedBack comment= iFeedBackService.getById(id);
        int likesAmount=comment.getNumberOfLike()+1;
        comment.setNumberOfLike(likesAmount);
        iFeedBackService.updateById(comment);
        return new ModelAndView("redirect:/feedbacks");
    }

}
