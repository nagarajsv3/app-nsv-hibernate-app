package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.inheritencetype.singletable.Cd;
import com.nsv.jsmbaba.hibernate.domain.inheritencetype.singletable.InternationalCd;
import com.nsv.jsmbaba.hibernate.domain.inheritencetype.singletable.SpecialCd;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class HibernateInheritanceSingleTableMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Cd cd = new Cd();
        cd.setTitle("How to play");
        cd.setArtist("Kohli");
        cd.setCost("200");
        cd.setPurchase_date(new Date());

        InternationalCd internationalCd = new InternationalCd();
        internationalCd.setLanguages("ENG");
        internationalCd.setRegion(614);
        internationalCd.setTitle("How to be cool");
        internationalCd.setArtist("Dhoni");
        internationalCd.setCost("200");
        internationalCd.setPurchase_date(new Date());

        SpecialCd specialCd = new SpecialCd();
        specialCd.setNewFeatures("Yorkers");
        specialCd.setTitle("How to bowl");
        specialCd.setArtist("Bumrah");
        specialCd.setPurchase_date(new Date());
        specialCd.setCost("200");

        Transaction transaction = session.beginTransaction();
        session.save(cd);
        session.save(internationalCd);
        session.save(specialCd);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
