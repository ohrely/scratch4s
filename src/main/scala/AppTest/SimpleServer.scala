package AppTest

/**
  * Created by rely10 on 4/25/16.
  */

import org.http4s._
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder

import scalaz.concurrent.Task

object SimpleService {
  val service = HttpService {

    case GET -> Root / "wut" =>
      StaticFile.fromResource("/wut.js")
        .map(Task.now)
        .getOrElse(Ok("Yooooooo."))

    case GET -> Root =>
      StaticFile.fromResource("/index.html")
        .map(Task.now)
        .getOrElse(Ok("Nooooooo."))
  }
}

object SimpleServer {
  def main(args: Array[String]) = BlazeBuilder
    .bindHttp(8080)
    .mountService(SimpleService.service, "/")
    .run
    .awaitShutdown()
}
