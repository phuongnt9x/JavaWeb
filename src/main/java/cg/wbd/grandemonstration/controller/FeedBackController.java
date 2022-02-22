package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.service.FeedbackService;
import cg.wbd.grandemonstration.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("feedbacks")
public class FeedBackController {
    String[] listStars = {"1","2","3","4","5"};
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping("")
    public ModelAndView showAll(@PageableDefault(value = 5) Pageable pageable){
        Page<FeedBack> list=feedbackService.findAll(pageable);
        ModelAndView modelAndView=new  ModelAndView("index");
        modelAndView.addObject("stars",listStars);
        modelAndView.addObject("list",list);
        modelAndView.addObject("newFeedback",new FeedBack());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute FeedBack comment){
        comment.setNumberOfLike(0);
        feedbackService.save(comment);
        return new ModelAndView("redirect:/feedbacks");
    }
    @GetMapping("like")
    public ModelAndView like(@RequestParam Long id){
        FeedBack comment= feedbackService.findById(id);
        int likesAmount=comment.getNumberOfLike()+1;
        comment.setNumberOfLike(likesAmount);
        feedbackService.save(comment);
        return new ModelAndView("redirect:/feedbacks");
    }

}
