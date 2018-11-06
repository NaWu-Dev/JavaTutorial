package com.nana.aopdemo;

import com.nana.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] arg) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        List<Account> theAccounts = null;

        try {
            // add a boolean flg to simulate exception
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println("\n\n Main program ... caught excpetion: " + ex);
        }

        // close the context
        context.close();

    }

}
