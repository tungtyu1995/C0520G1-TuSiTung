package vn.codegym.library_manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.library_manage.exception.CommentException;
import vn.codegym.library_manage.model.Comment;
import vn.codegym.library_manage.service.CommentService;

@Controller
public class CommentController {
    Comment commentErr = new Comment();
    @Autowired
    CommentService commentService;

    @GetMapping("/home")
    public String home(@PageableDefault(value = 5) Pageable pageable, @RequestParam(name = "content", defaultValue = "") String content, Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.findAllByContentContaining(content,pageable));
        return "view";
    }

    @PostMapping("/home/comment")
    public String addNewCmt(@ModelAttribute Comment comment) throws CommentException {
        for (String value : commentService.getList().values()){
            if (comment.getContent().contains(value)){
                commentErr = comment;
                throw new CommentException();
            }
        }
        commentService.save(comment);
        return "redirect:/home";
    }


    @ExceptionHandler(CommentException.class)
    public ModelAndView showError(){
        return new ModelAndView("error","commentErr",commentErr);
    }


    @PostMapping("/home/like/{id}")
    public String updateLike(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Comment comment = commentService.findById(id);
        if (comment != null){
            comment.setTotalLike(comment.getTotalLike()+1);
            commentService.save(comment);

            model.addAttribute("comment", new Comment());
            model.addAttribute("commentList", commentService.findAll());
        } else {
            redirect.addFlashAttribute("message","Comment not found or deleted!!!");
        }

        return "redirect:/home";
    }
}
