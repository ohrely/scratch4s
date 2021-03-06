package appy

/**
  * Created by rely10 on 4/25/16.
  */

import FunkyUtil.beFunky

import org.http4s._
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder

import scalaz.concurrent.Task

object ScratchService {
  def fetchStatic(path: String, req: Request) = {
    StaticFile.fromResource(path, Some(req))
      .map(Task.now)
      .getOrElse(Ok("Nooooooo."))
    //  .getOrElse(NotFound())
  }

  val nongraph: String = "ceci n'est pas un graphique"

  def service = HttpService {
    case req @ GET -> Root =>
      println(System.getProperty("user.dir"))
      beFunky() // calls FunkyUtil, which in turn makes another request to this server (/dag)
      fetchStatic("/index.html", req)

    case req @ GET -> Root / "dag" =>
      println("So. It is down to you, and it is down to me.") // prints to terminal
      Ok(nongraph) // appears in browser

    case req @ GET -> path =>
      fetchStatic(path.toString, req)

//    case req @ GET -> path =>
//      fetchStatic("app/jvm/src/main/resources" + path.toString, req)

    //    case req @ GET -> Root / "slow-body" =>
    //      val resp = "Hello world!".map(_.toString())
    //      val body = awakeEvery(2.seconds).zipWith(Process.emitAll(resp))((_, c) => c)
    //      Ok(body)
  }
}

object ScratchServer {
  def main(args: Array[String]) = BlazeBuilder
    .bindHttp(8080)
    .mountService(ScratchService.service, "/")
    .run
    .awaitShutdown()
}
