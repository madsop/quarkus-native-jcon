import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.context.Dependent
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.config.inject.ConfigProperty

@ApplicationScoped
@Path("/oredev")
class OredevResource(val service: Service) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun sayHi() = "Hi from Øredev at year ${service.year}"
}

@Dependent
class Service(@ConfigProperty(name = "year", defaultValue = "2048") val year: Int)