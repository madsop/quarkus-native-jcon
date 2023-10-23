import jakarta.enterprise.context.Dependent
import java.time.LocalDate

@Dependent
class TDCService {
    fun aar() = LocalDate.now().year
}