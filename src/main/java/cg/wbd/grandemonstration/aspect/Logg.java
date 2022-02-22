package cg.wbd.grandemonstration.aspect;

import cg.wbd.grandemonstration.model.FeedBack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import java.util.Date;

@Aspect
public class Logg {
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.controller.FeedBackController.create(..))&&args(comment)", throwing = "e")
    public void log(JoinPoint joinPoint, FeedBack comment,Exception e){
        System.out.println(new Date());
        System.out.println("author"+comment.getAuthor());
        System.out.println("invalid feedback: "+comment.getFeedback());
    }
}
