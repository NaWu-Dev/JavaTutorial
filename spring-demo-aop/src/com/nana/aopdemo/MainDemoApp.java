package com.nana.aopdemo;

import com.nana.aopdemo.dao.AccountDAO;
import com.nana.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainDemoApp {

    public static void main(String[] arg) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account theAccount = new Account();
        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.doWork();

        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

        // close the context
        context.close();

    }

}
