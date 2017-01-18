package com.pstaton


object App {


  def main(args : Array[String]) {
  }

  //1. Write a function that takes three sides of a triangle and answers if it's equilateral, isosceles, or scalene.

  object TriangleType extends Enumeration {
    val Equilateral, Isosceles, Scalene = Value
  }

  def getTriangleType(a: Double, b: Double, c: Double) : TriangleType.Value = {
    if ((a <= 0) || (b <= 0) || (c <= 0) || (a > b + c) || (b > a + c) || (c > a + b)) {
      throw new IllegalArgumentException("not a triangle")
    }

    if ((a == c) && (a == b)) {
      return TriangleType.Equilateral
    }

    if ((a == b) || (b == c) || (c == a)) {
      return TriangleType.Isosceles
    }

    TriangleType.Scalene
  }


  //2. For a single-linked (forward only) list write a function that returns 5th element from the end of the list. The list can only be walked once (reverse, length, or size of this list cannot be used).

  class Node {
    var next: Node = null
    var value: Int = 0
  }

  def get5thFromLast(node: Node) : Node = {

    val queue = new scala.collection.mutable.Queue[Node]

    var cur = node

    while(cur != null) {
      queue.enqueue(cur)

      if (queue.size > 5) {
        queue.dequeue()
      }

      cur = cur.next
    }

    if (queue.size < 5) {
      null
    } else {
      queue.dequeue()
    }

  }

  //3. Given two lists, write a function that answers if all elements of one list are in the other.

  def containsAll[T](a: List[T], b: List[T]) : Boolean = {
    (a != null) && (b != null) && a.forall(b.contains)
  }



}
