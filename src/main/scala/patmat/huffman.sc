package patmat
import Huffman._
object huffman {
  println("Enrique")                              //> Enrique
  Huffman.makeOrderedLeafList(Huffman.times(List('a', 'a', 'a', 'c', 'c', 'd', 'b', 'b', 'b', 'b')))
                                                  //> res0: List[patmat.Huffman.Leaf] = List(Leaf(d,1), Leaf(c,2), Leaf(a,3), Leaf
                                                  //| (b,4))

  combine(List(Leaf('h', 1), Leaf('g', 1), Leaf('f', 1), Leaf('e', 1), Leaf('d', 1), Leaf('c', 4), Leaf('b', 3), Leaf('b', 8)))
                                                  //> res1: List[patmat.Huffman.CodeTree] = List(Leaf(f,1), Leaf(e,1), Leaf(d,1), 
                                                  //| Fork(Leaf(h,1),Leaf(g,1),List(h, g),2), Leaf(c,4), Leaf(b,3), Leaf(b,8))

  Huffman.createCodeTree(List('a', 'a', 'a', 'c', 'c', 'd', 'b', 'b', 'b', 'b'))
                                                  //> res2: patmat.Huffman.CodeTree = Fork(Leaf(b,4),Fork(Fork(Leaf(d,1),Leaf(c,2)
                                                  //| ,List(d, c),3),Leaf(a,3),List(d, c, a),6),List(b, d, c, a),10)

  decodedSecret                                   //> res3: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  secret == encode(frenchCode)(decodedSecret)     //> res4: Boolean = true
  val a = ('a', List(1, 1, 1, 1))                 //> a  : (Char, List[Int]) = (a,List(1, 1, 1, 1))
  val b = ('b', List(1, 0, 1, 1))                 //> b  : (Char, List[Int]) = (b,List(1, 0, 1, 1))
  codeBits(a :: List(b))('b')                     //> res5: List[patmat.Huffman.Bit] = List(1, 0, 1, 1)

  convert(Fork(Leaf('h', 1), Leaf('g', 1), List('h', 'g'), 2))
                                                  //> res6: patmat.Huffman.CodeTable = List((g,List(1)), (h,List(0)))
  convert(frenchCode)                             //> res7: patmat.Huffman.CodeTable = List((a,List(1, 1, 1, 1)), (i,List(1, 1, 1,
                                                  //|  0)), (e,List(1, 1, 0)), (t,List(1, 0, 1, 1)), (n,List(1, 0, 1, 0)), (b,List
                                                  //| (1, 0, 0, 1, 1, 1, 1)), (g,List(1, 0, 0, 1, 1, 1, 0)), (v,List(1, 0, 0, 1, 1
                                                  //| , 0)), (c,List(1, 0, 0, 1, 0)), (r,List(1, 0, 0, 0)), (u,List(0, 1, 1, 1)), 
                                                  //| (p,List(0, 1, 1, 0, 1)), (m,List(0, 1, 1, 0, 0)), (l,List(0, 1, 0, 1)), (o,L
                                                  //| ist(0, 1, 0, 0)), (q,List(0, 0, 1, 1, 1, 1)), (h,List(0, 0, 1, 1, 1, 0, 1)),
                                                  //|  (y,List(0, 0, 1, 1, 1, 0, 0, 1)), (w,List(0, 0, 1, 1, 1, 0, 0, 0, 1, 1)), (
                                                  //| k,List(0, 0, 1, 1, 1, 0, 0, 0, 1, 0)), (z,List(0, 0, 1, 1, 1, 0, 0, 0, 0)), 
                                                  //| (f,List(0, 0, 1, 1, 0, 1)), (j,List(0, 0, 1, 1, 0, 0, 1)), (x,List(0, 0, 1, 
                                                  //| 1, 0, 0, 0)), (d,List(0, 0, 1, 0)), (s,List(0, 0, 0)))

  secret == quickEncode(frenchCode)(decodedSecret)//> res8: Boolean = true
}