package demo.simple.json

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import apis._


class SimpleJsonApi extends Simulation {
  
    val httpProtocol = http

    val scn = scenario("jsonplaceholder.typicode.com testing")
        .exec(jsonApi.getPosts())
        .exitHereIfFailed
        .exec(jsonApi.getPost("1"))

    setUp(
        scn.inject(
            atOnceUsers(1)
        )
        .protocols(
            httpProtocol
        )
    )

}
