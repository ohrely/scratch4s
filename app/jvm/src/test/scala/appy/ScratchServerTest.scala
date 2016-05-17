package appy

import org.scalatest.FunSuite
import org.http4s.{Method, Request, Response}
import org.http4s.Uri._
import org.http4s.Method._
import org.http4s.client.Client
import org.http4s.client.blaze.{defaultClient => client}

import scalaz.concurrent.{Future, Task}

/**
  * Created by rely10 on 5/11/16.
  */
class ScratchServerTest extends FunSuite {
  test("yes"){
    val testUri: String = "http://127.0.0.1:8080/dag"

    def stringResp(myUri: String): Task[String] = client.getAs[String](myUri)

    println(stringResp(testUri).run.mkString)
  }

}
