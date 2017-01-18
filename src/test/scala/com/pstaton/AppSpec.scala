package com.pstaton


import org.scalatest.FunSpec


class AppSpec extends FunSpec {

  describe("An App") {

    it("getTriangleType should work for Equilateral triangles") {

      assert(App.getTriangleType(1.0, 1.0, 1.0) == App.TriangleType.Equilateral)

    }
    it("getTriangleType should work for Isosceles triangles") {

      assert(App.getTriangleType(1.0, 1.0, 1.5) == App.TriangleType.Isosceles)

    }
    it("getTriangleType should work for Scalene triangles") {

      assert(App.getTriangleType(1.0, 1.1, 1.5) == App.TriangleType.Scalene)

    }
    it("getTriangleType should handle non-triangles") {

      assertThrows[IllegalArgumentException] {
        App.getTriangleType(1.0, 1.1, 20)
      }
    }
    it("getTriangleType should handle bad input") {

      assertThrows[IllegalArgumentException] {
        App.getTriangleType(-1.0, 1.1, 1.5)
      }
    }


    it("get5thFromLast should work for more than 5 items") {

      val head = new App.Node()
      var cur = head
      for (x <- 1 until 10) {
        cur.next = new App.Node()
        cur.next.value = x
        cur = cur.next
      }

      assert (App.get5thFromLast(head).value == 5)

    }

    it("get5thFromLast should work for less than 5 items") {

      val head = new App.Node()
      var cur = head
      for (x <- 1 until 3) {
        cur.next = new App.Node()
        cur.next.value = x
        cur = cur.next
      }

      assert (App.get5thFromLast(head) == null)

    }



    it("containsAll checks contains properly") {

      assert (App.containsAll(List(1, 2), List(1, 2)))

      assert (App.containsAll(List(1, 2), List(1, 2, 3)))

      assert (!App.containsAll(List(1, 2, 3), List(1, 2)))

      assert (!App.containsAll(List(1, 2, 3), List()))

      assert (App.containsAll(List(), List(1, 2)))

      assert (App.containsAll(List(), List()))

    }

    it("containsAll checks input properly") {
      assert (!App.containsAll(List(1, 2, 3), null))
      assert (!App.containsAll(null, List()))
      assert (!App.containsAll(null, null))

    }

  }
}
