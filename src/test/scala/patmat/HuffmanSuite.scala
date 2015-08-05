package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("times a char in a List") {
    assert(times(List('a', 'b', 'a', 'a', 'b', 'b', 'c', 'c', 'd')) == List(('a', 3), ('b', 3), ('c', 2), ('d', 1)))
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }
  
  test("singleton long list"){
    assert(singleton(List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))===false)
  }
  
  test("singleton a list with one tree"){
    assert(singleton(List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3)))===true)
  }
  
  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))

    val leaflist2 = List(Leaf('e', 2), Leaf('t', 3), Leaf('x', 4))
    assert(combine(leaflist2) === List(Leaf('x', 4), Fork(Leaf('e', 2), Leaf('t', 3), List('e', 't'), 5)))

    val leaflist3 = List(Leaf('t', 1), Leaf('e', 2))
    assert(combine(leaflist3) === List(Fork(Leaf('t', 1), Leaf('e', 2), List('t', 'e'), 3)))

    val leaflist4 = List(Leaf('e', 2))
    assert(combine(leaflist4) === List(Leaf('e', 2)))
  }

  test("makeOrderedLeafList nil"){
    assert(makeOrderedLeafList(Nil) === Nil);
  }
  
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode a very long text should be identity") {
    assert(secret == encode(frenchCode)(decodedSecret) === true)
  }

  test("Code of bits") {
    val a = List(('a', List(1, 1, 1, 1)))
    val b = List(('b', List(1, 0, 1, 1)))

    assert(codeBits(a)('a') === a.head._2)
    assert(codeBits(a ::: b)('b') === b.head._2)
    assert(codeBits(a ::: b)('a') === a.head._2)
  }

  test("Quick Encode") {
    assert(secret == quickEncode(frenchCode)(decodedSecret) === true)
  }
}
