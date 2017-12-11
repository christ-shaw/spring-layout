package com.ztev.springlayout.controller;

import com.ztev.springlayout.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ztev.springlayout.repository.TaskRepository;

import javax.annotation.PostConstruct;

/**
 * Standard Layout System with Fragment Expressions usage example
 */
@Controller
@Secured("ROLE_USER")
class TaskController {

    @Autowired
    private  TaskRepository taskRepository;

    @PostConstruct
    private void init() {
        taskRepository.save(new Task("Shopping", "Buy Milk and Butter...", "2017.01.01 13:22:42"));
        taskRepository.save(new Task("Books", "Read 'Lords of The Ring'", "2017.01.02 15:22:42"));
    }

    @ModelAttribute("module")
    public String module() {
        return "tasks";
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public String tasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "task/task-list";
    }

    @RequestMapping(value = "task/{id}", method = RequestMethod.GET)
    public String task(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskRepository.findOne(id));
        return "task/task";
    }
}
