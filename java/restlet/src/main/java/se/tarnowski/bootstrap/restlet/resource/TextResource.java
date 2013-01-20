package se.tarnowski.bootstrap.restlet.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TextResource extends ServerResource {

   @Get
   public String produceResponse() {
      return "A text response";
   }
}