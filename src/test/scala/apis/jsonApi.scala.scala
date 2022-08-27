package apis

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object jsonApi {
  
    def getPosts() = {
        http("GetPosts")
            .get("https://jsonplaceholder.typicode.com/posts")
            .check(
                status.is(200)
            )
    }

    def getPost(id: String) = {
        http("GetPosts")
            .get(s"https://jsonplaceholder.typicode.com/posts/${id}")
            .check(
                status.is(200),
                jsonPath("$.id").find.saveAs("ids")
            )
    }

}
