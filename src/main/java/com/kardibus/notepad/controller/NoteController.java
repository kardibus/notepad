package com.kardibus.notepad.controller;

import com.kardibus.notepad.domain.note.NoteDomain;
import com.kardibus.notepad.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class NoteController {


    private final DataService noteDataServiceImpl;

    public NoteController(DataService dataService){
        this.noteDataServiceImpl=dataService;
    }

    @GetMapping("/")
    public String index(){

        return "redirect:/index";
    }

    @GetMapping("/index")
    public String allNotes(Model model) {
        model.addAttribute("noteDomains", noteDataServiceImpl.allNote());
        return "index";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable(value = "id", required = false) Long id) {
        noteDataServiceImpl.deleteNote(id);
        return "redirect:/index";
    }

    @PostMapping("/addNote")
    public String addNote(@RequestParam(name = "title") String title,
                          @RequestParam(name = "text") String text) {

        noteDataServiceImpl.addNote(title, text);
        return "redirect:/index";
    }

    @PostMapping("/updateNote")
    public String updateNote(@RequestParam(name = "id") NoteDomain id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "text") String text) {

        noteDataServiceImpl.updateNote(id, title, text);
        return "redirect:/index";
    }

    @PostMapping("/searchNote")
    public String searchInTitleAndText(@RequestParam(name = "radio") String radio,
                                       @RequestParam(name = "search") String search, Model model) {

        if (!radio.isEmpty() && radio.equals("title")) {
            model.addAttribute("noteDomains", noteDataServiceImpl.searchInTitle(search));
        } else {
            model.addAttribute("noteDomains", noteDataServiceImpl.searchInText(search));
        }

        return "index";
    }
}
