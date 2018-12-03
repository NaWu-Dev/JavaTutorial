package com.nana.practice.listform.controller;

import com.nana.practice.listform.entity.Contact;
import com.nana.practice.listform.entity.ContactForm;
import org.springframework.stereotype.Controller;
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
    public ModelAndView get() {

        ContactForm contactForm = new ContactForm();
        contactForm.setContacts(contacts);

        return new ModelAndView("add_contact" , "contactForm", contactForm);
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
