package com.nana.ajax.demo.controller;

import com.nana.ajax.demo.model.AjaxResponseBody;
import com.nana.ajax.demo.model.SearchCriteria;
import com.nana.ajax.demo.model.User;
import com.nana.ajax.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    @Autowired
    UserService userService;

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
            .collect(Collectors.joining()));

            return ResponseEntity.badRequest().body(result);

        }

        List<User> users = userService.findByUserNameOrEmail(search.getUsername());

        if (users.isEmpty()) {
            result.setMsg("No user found! ");
        } else {
            result.setMsg("Success! ");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }


}

