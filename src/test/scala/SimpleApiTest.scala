package demo.simple

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import apis._

class SimpleApiTest extends Simulation {
  
    val httpProtocol = http

    val scn = scenario("api.publicapis.org testing")
        .exec(Api.getDatas())
        .exitHereIfFailed
        .exec(Api.getUsers())

    setUp(
        scn.inject(
            atOnceUsers(1)
        )
        .protocols(
            httpProtocol
        )
    )
}
