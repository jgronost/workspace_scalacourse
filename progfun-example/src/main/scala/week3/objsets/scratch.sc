package week3.objsets

object scratch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
    val set1 = new Empty                          //> set1  : week3.objsets.Empty = week3.objsets.Empty@1c1ea29
    val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : week3.objsets.TweetSet = week3.objsets.NonEmpty@4413ee
    val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : week3.objsets.TweetSet = week3.objsets.NonEmpty@6e3d60
    val c = new Tweet("c", "c body", 7)           //> c  : week3.objsets.Tweet = User: c
                                                  //| Text: c body [7]
    val d = new Tweet("d", "d body", 9)           //> d  : week3.objsets.Tweet = User: d
                                                  //| Text: d body [9]
    val set4c = set3.incl(c)                      //> set4c  : week3.objsets.TweetSet = week3.objsets.NonEmpty@17fa65e
    val set4d = set3.incl(d)                      //> set4d  : week3.objsets.TweetSet = week3.objsets.NonEmpty@18385e3
    val set5 = set4c.incl(d)                      //> set5  : week3.objsets.TweetSet = week3.objsets.NonEmpty@1cb25f1
  
  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }                                               //> asSet: (tweets: week3.objsets.TweetSet)Set[week3.objsets.Tweet]

  def size(set: TweetSet): Int = asSet(set).size  //> size: (set: week3.objsets.TweetSet)Int


   size(set1.filter(tw => tw.user == "a")) == 0   //> res0: Boolean = true
   size(set5.filter(tw => tw.user == "a")) == 1   //> res1: Boolean = true
   size(set5.filter(tw => tw.retweets == 20)) == 2//> res2: Boolean = true
   
   size(set4c.union(set4d)) == 4                  //> res3: Boolean = true
	 size(set5.union(set1)) == 4              //> res4: Boolean = true
	 size(set1.union(set5)) == 4              //> res5: Boolean = true
	 
	 val trends = set5.descendingByRetweet    //> trends  : week3.objsets.TweetList = week3.objsets.Cons@e3b895
   !trends.isEmpty                                //> res6: Boolean = true
   trends.head.user == "a" || trends.head.user == "b"
                                                  //> res7: Boolean = true
	 
	 
}