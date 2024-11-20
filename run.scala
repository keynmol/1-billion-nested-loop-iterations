@main def hello(u: Int) = 
  val r = scala.util.Random.nextInt(10_000)
  val a = Array.ofDim[Int](10_000)
  for i <- 0 until 10_000 do 
    for j <- 0 until 10_000 do 
      a(i) = a(i) + u
    a(i) += r
  println(a(r))
