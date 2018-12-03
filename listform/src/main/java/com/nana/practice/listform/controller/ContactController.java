package com.nana.practice.listform.controller;

import com.nana.practice.listform.entity.Contact;
import com.nana.practice.listform.entity.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    private static List<Contact> contacts = new ArrayList<Contact>();

    static {
        contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));
        contacts.add(new Contact("George", "Bush", "george.b@whitehouse.com", "785-985-652"));
        contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));
        contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
    }

    @GetMapping("/get")
    public String get(Model theModel) {

        ContactForm contactForm = new ContactForm();
        contactForm.setContacts(contacts);

        theModel.addAttribute("contactForm", contactForm);

        return "add_contact";
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("contactForm") ContactForm contactForm) {
        System.out.println(contactForm);
        System.out.println(contactForm.getContacts());
        List<Contact> contacts = contactForm.getContacts();

        if(null != contacts && contacts.size() > 0) {
            ContactController.contacts = contacts;
            for (Contact contact : contacts) {
                System.out.printf("%s \t %s \n", contact.getFirstName(), contact.getLastName());
            }
        }

        return new ModelAndView("show_contact", "contactForm", contactForm);
    }


}
