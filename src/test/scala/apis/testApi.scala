package apis

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object Api {
  
    def getDatas() = {
        http("getDatas")
            .get("https://api.publicapis.org/entries")
            .check(status.is(200))
    }

    def getUsers() = {
        http("getUsers")
            .get("https://randomuser.me/api/")
            .check(status.is(200))
    }
}
