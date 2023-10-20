package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/TDC")
@ApplicationScoped
public class TDCResource {

    @Inject
    TDCService tdcService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String heiTDC() {
        return "Hei, TDC i" + tdcService.aar();
    }
}