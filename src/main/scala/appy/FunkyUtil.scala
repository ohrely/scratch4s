package appy

import org.http4s.client.blaze._

import scalaz.concurrent.Task
import org.http4s.client.blaze.{defaultClient => client}

/**
  * Created by rely10 on 5/12/16.
  */
object FunkyUtil {
  def beFunky() = {
    println("let's get funky")

    val funkyUri: String = "http://127.0.0.1:8080/dag"

    def stringResp(myUri: String): Task[String] = client.getAs[String](myUri)

    println(stringResp(funkyUri).run.mkString)
  }
}
