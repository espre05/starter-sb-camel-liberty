package orca.app.camel.routes;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import orca.app.util.StringTransformer;


@Component
public class TimeTriggeredRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period:5s}}")//for reach 3 secs?
            .routeId("timePingStream")
            .transform().simple("Camel Ping at ${date:now:yyyy-MM-dd HH:mm:ss}") //produce this TS string
            .transform().method(StringTransformer.class, "toUpper") //transform to UPPER ase with a bean
            .filter(simple("${body} contains 'foo'"))
                .to("log:foo")// ig orca.app has foo in bod
            .end()
            .to("stream:out"); //send to system out
    }

}