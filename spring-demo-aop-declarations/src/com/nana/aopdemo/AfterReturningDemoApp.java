package com.nana.aopdemo;

import com.nana.aopdemo.dao.AccountDAO;
import com.nana.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] arg) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        List<Account> theAccounts = theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain program: AfterRetruningDemoApp");
        System.out.println("----------");
        System.out.println(theAccounts);
        System.out.println("\n");

        // close the context
        context.close();

    }

}
