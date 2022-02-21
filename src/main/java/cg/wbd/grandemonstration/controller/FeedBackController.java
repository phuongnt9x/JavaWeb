package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("feedbacks")
public class FeedBackController {
    String[] listStars = {"1","2","3","4","5"};

    @Autowired
    private FeedBackService feedBackService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<FeedBack> list= feedBackService.findAll();
        ModelAndView modelAndView=new  ModelAndView("index");
        modelAndView.addObject("stars",listStars);
        modelAndView.addObject("list",list);
        modelAndView.addObject("newFeedback",new FeedBack());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute FeedBack comment){
        comment.setNumberOfLike(0);
        feedBackService.addFeedBack(comment);
        return new ModelAndView("redirect:/feedbacks");
    }
    @GetMapping("like")
    public ModelAndView like(@RequestParam Long id){
        FeedBack comment=feedBackService.getById(id);
        int likesAmount=comment.getNumberOfLike()+1;
        comment.setNumberOfLike(likesAmount);
        feedBackService.updateById(comment);
        return new ModelAndView("redirect:/feedbacks");
    }

}
