//> using nativeVersion 0.5.6
//> using scala 3.5.2

// https://august.nagro.us/scala-for-loop.html
inline def loop[A](
  inline start: A,
  inline condition: A => Boolean,
  inline advance: A => A
)(inline loopBody: A => Any): Unit =
  var a = start
  while condition(a) do
    loopBody(a)
    a = advance(a)


@main def hello(u: Int) = 
  val r = scala.util.Random.nextInt(10_000)
  val a = Array.ofDim[Int](10_000)
  loop(0, _ < 10_000, _ + 1): i =>
    loop(0, _ < 100_000, _ + 1): j=>
      a(i) = a(i) + u
    a(i) += r
  println(a(r))
