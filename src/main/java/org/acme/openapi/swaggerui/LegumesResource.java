package org.acme.openapi.swaggerui;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LegumesResource {

    private Set<Legumes> legumes = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public LegumesResource() {
        legumes.add(new Legumes(1,"Apple", "Winter legume", "10"));
        legumes.add(new Legumes(2, "Pineapple", "Tropical legume", "10"));
    }

    @GET
    @Path("legumes")
    public Set<Legumes> list() {
        return legumes;
    }

    @POST
    public Set<Legumes> add(Legumes legume) {
        legumes.add(legume);
        return legumes;
    }

    @DELETE
    public Set<Legumes> delete(Legumes legume) {
        legumes.removeIf(existingLegumes -> existingLegumes.name.contentEquals(legume.name));
        return legumes;
    }
}