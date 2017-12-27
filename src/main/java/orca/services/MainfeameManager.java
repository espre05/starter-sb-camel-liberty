package orca.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@ManagedResource(objectName = "jmxDemo:name=MyController")
public class MainfeameManager {
    private static final Logger log = LoggerFactory.getLogger(MainfeameManager.class);

    @ManagedOperation
    public void reloadPersonData() {
           log.info("\n\n Reload Person Data Called ..");
    }
}
