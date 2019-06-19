package com.nsv.jsmbaba.hibernate.interceptor;

import com.nsv.jsmbaba.hibernate.domain.Clerk;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class ClerkInterceptor extends EmptyInterceptor {

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Clerk){
            System.out.println(((Clerk)entity).getName()+" "+"is being deleted");
        }
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Clerk){
            System.out.println(((Clerk)entity).getName()+" "+"is being loaded");
        }
        return true;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Clerk){
            System.out.println(((Clerk)entity).getName()+" "+"is being saved");
        }
        return true;
    }
}
