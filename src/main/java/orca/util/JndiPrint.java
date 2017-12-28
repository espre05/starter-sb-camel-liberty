package orca.util;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JndiPrint {
    private static Logger log = LoggerFactory.getLogger(JndiPrint.class);

//    public static void main(String[] args) throws Exception{
//        InitialContext ctx = new InitialContext();
////        NamingEnumeration<NameClassPair> list = ctx.list("");
////        while (list.hasMore()) {
////          System.out.println(list.next().getName());
////        }
//        toMap(ctx);
//
//    }
    
    public static Map toMap(Context ctx) throws NamingException {
        String namespace = ctx instanceof InitialContext ? ctx.getNameInNamespace() : "";
        HashMap<String, Object> map = new HashMap<String, Object>();
        log.info("> Listing namespace: " + namespace);
        NamingEnumeration<NameClassPair> list = ctx.list(namespace);
        while (list.hasMoreElements()) {
            NameClassPair next = list.next();
            String name = next.getName();
            String jndiPath = namespace + name;
            Object lookup;
            try {
                log.info("> Looking up name: " + jndiPath);
                Object tmp = ctx.lookup(jndiPath);
                if (tmp instanceof Context) {
                    lookup = toMap((Context) tmp);
                } else {
                    lookup = tmp.toString();
                }
            } catch (Throwable t) {
                lookup = t.getMessage();
            }
            map.put(name, lookup);

        }
        return map;
    }

}
