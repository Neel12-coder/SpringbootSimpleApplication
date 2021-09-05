package com.example.bootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {
    
    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public ModelAndView Home()
    {
        System.out.println("Hie");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        return mv;
    }

    @RequestMapping("/addAlien")
    public ModelAndView addAlien(Alien alien)
    {
        repo.save(alien);
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",alien);
        mv.setViewName("home.jsp");
        return mv;
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid)
    {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        System.out.println(repo.findByTech("Python"));
        System.out.println(repo.findByTechSorted("Python"));
        mv.addObject(alien);
        return mv;
    }

    //content negotiation ... to give data in xml format only..,produces = {"application/xml"}
    @RequestMapping(path="/aliens")
    @ResponseBody
    public List<Alien> fetchAllAliens()
    {
        return repo.findAll();
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }

    @PutMapping(path="/alien",consumes = "application/json")
    public ModelAndView updateAlien(Alien alien)
    {
        repo.save(alien);
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",alien);
        mv.setViewName("home.jsp");
        return mv;
    }

    @PostMapping("/alien")
    public ModelAndView addingAlien(Alien alien)
    {
        repo.save(alien);
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",alien);
        mv.setViewName("home.jsp");
        return mv;
    }

    @GetMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> fetchAlien(@PathVariable("aid") int aid)
    {
       return repo.findById(aid);
    }
}

// to avoid adding responsebody annotation every time .. go for @RestController