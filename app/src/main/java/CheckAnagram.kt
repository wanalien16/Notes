fun main(){
    val str1 = "@nil"
    val str2 = "lin@"

    val result = checkAnagram(str1, str2)
    println(result)
}

fun checkAnagram(str1: String, str2: String) : Boolean{
    if (str1.length != str2.length)
        return false

    val array = IntArray(256)


    for(i in str1.indices){
        array[str1[i].code]++
        array[str2[i].code]--
    }

    for (i in array.indices){
        if (array[i]!=0){
            return false
        }
    }

    return true
}