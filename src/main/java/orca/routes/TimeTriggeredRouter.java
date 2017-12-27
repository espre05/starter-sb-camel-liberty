package orca.routes;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class TimeTriggeredRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("timer:orca?period={{timer.period:10s}}")//for reach 3 secs?
//            .routeId("timePingStream")
//            .transform().simple("Camel Ping at ${date:now:yyyy-MM-dd HH:mm:ss}") //produce this TS string
//            .transform().method(StringTransformer.class, "toUpper") //transform to UPPER ase with a bean
//            .filter(simple("${body} contains 'foo'"))
//                .to("log:foo")// ig failsafe.orca has foo in bod
//            .end()
//            .to("log:orca.routes.timer"); //send to system out
        
        from("direct:insuranceProcess")//
                .routeId("insuranceProcess")//
                .to("log:orca.insurance")
                .to("bean:municipalCodeRepository?method=findOne(${body})")
                .to("log:orca.insurance")
                ;
    }

}