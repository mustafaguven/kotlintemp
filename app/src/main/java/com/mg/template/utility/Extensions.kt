package com.mg.template.utility


fun String.fromGenderToInt() = if (this.toLowerCase() == "erkek") 1 else 0
fun Boolean.toInt() = if (this) 1 else 0

fun String.cardNumberWithSpaces(): String {
  var word: String = this.trim()
  for (i in 4 until this.length step 5) {
    word = word.insert(" ", i)
  }
  return word
}

fun String.insert(newText: String, index: Int = 0): String {
  val first: String = this.take(index)
  val second: String = this.substring(index, this.length)
  return first.plus(newText).plus(second)
}