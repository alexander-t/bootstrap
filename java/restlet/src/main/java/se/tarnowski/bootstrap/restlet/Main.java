package se.tarnowski.bootstrap.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;
import se.tarnowski.bootstrap.restlet.resource.JsonResource;
import se.tarnowski.bootstrap.restlet.resource.TextResource;

public class Main {
    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);
        component.getDefaultHost().attach("/text", TextResource.class);
        component.getDefaultHost().attach("/json", JsonResource.class);
        component.start();
    }
}
