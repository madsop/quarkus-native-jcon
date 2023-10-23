import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@ApplicationScoped
@Path("/TDC")
class TDCResource(val service: TDCService) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hei() = "Hei, TDC i år ${service.aar()}"
}