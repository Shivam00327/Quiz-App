package com.example.quizapp

object constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CORRECT_ANSWER:String="correct_answer"

    fun getQuestion():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val qu1=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1        )
        questionList.add(qu1)
        val qu2=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3        )
        questionList.add(qu2)
        val qu3=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4        )
        questionList.add(qu3)
        val qu4=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2        )
        questionList.add(qu4)
        val qu5=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3        )
        questionList.add(qu5)
        val qu6=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1        )
        questionList.add(qu6)
        val qu7=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3        )
        questionList.add(qu7)
        val qu8=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4        )
        questionList.add(qu8)
        val qu9=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2 )
        questionList.add(qu9)
        val qu10=Question(
            1,"What country does this flag belongs to?",R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1        )
        questionList.add(qu10)


        return questionList
    }
}