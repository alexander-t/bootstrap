package se.tarnowski.bootstrap.restlet.resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import se.tarnowski.bootstrap.restlet.representation.SimpleResponse;
import se.tarnowski.bootstrap.restlet.request.SimpleRequest;

public class JsonResource extends ServerResource {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Get("json")
    public Representation produceResponse() {
        return new JacksonRepresentation<SimpleResponse>(new SimpleResponse());
    }

    // Gotcha: the Representation argument is crucial. Otherwise HTTP error code 415 will be returned.
    @Post("json")
    public Representation echoString(Representation representation) {
        try {
            SimpleRequest request = objectMapper.readValue(representation.getStream(), SimpleRequest.class);
            return new JacksonRepresentation<SimpleResponse>(new SimpleResponse(request.parameter));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
     }
}
