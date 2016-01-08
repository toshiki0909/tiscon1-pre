package tiscon1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author kawasima
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("now", new Date());
        model.addAttribute("name", "kawasima2");
        return "index";
    }


    @RequestMapping("/a")
    public ModelAndView index2() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
