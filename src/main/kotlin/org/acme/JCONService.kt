package org.acme

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class JCONService {

    fun hiJCON() = "JCON ${System.currentTimeMillis()}"
}
