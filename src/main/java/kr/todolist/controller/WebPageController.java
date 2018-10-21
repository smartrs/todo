package kr.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class WebPageController {

  @RequestMapping("/list")
  public ModelAndView listPage(
    @RequestParam(value = "page", required = false, defaultValue = "0") int page) {

    return new ModelAndView("list")
      .addObject("page", page);
  }

  @RequestMapping("/write")
  public ModelAndView writePage() {

    return new ModelAndView("write");
  }

  @RequestMapping("/rewrite")
  public ModelAndView reWritePage(@RequestParam("id") int id, @RequestParam("type") String type) {

    return new ModelAndView("edit")
      .addObject("id", id)
      .addObject("type", type);
  }

  @RequestMapping("/refwrite")
  public ModelAndView refWritePage(@RequestParam("id") int id) {
    return new ModelAndView("refWrite")
      .addObject("id", id);
  }
}
