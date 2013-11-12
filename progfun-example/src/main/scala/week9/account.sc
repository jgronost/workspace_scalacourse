package week9

object account {
  val acct = new BankAccount                      //> acct  : week9.BankAccount = week9.BankAccount@15a3d6b
  acct deposit(50)
  acct withdraw 20                                //> res0: Int = 30
  acct withdraw 20                                //> res1: Int = 10
  acct withdraw 20                                //> java.lang.Error: insufficient founds
                                                  //| 	at week9.BankAccount.withdraw(BankAccount.scala:14)
                                                  //| 	at week9.account$$anonfun$main$1.apply$mcV$sp(week9.account.scala:8)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week9.account$.main(week9.account.scala:3)
                                                  //| 	at week9.account.main(week9.account.scala)
}