package com.tvz.os_hbp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_QUESTIONS: String = "correct_questions"
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1,"Koji dijelovi tijela rastu tijekom cijelog života?",
            R.drawable.que1,
            "Nos i uši",
            "Ruke i noge",
            "Prsti i vrat",
            "Mišići i tetive",
            1)
        questionsList.add(que1)
        val que2 = Question(2, "Koji je najdulji unutarnji organ ljudskog tijela?",
            R.drawable.que2,
            "Pluća",
            "Crijeva",
            "Mokraćni kanal",
            "Srce i žile",
            2
        )
        questionsList.add(que2)
        val que3 = Question(3, "Koji je najtvrđi dio ljuskog tijela?",
            R.drawable.que3,
            "Kost",
            "Mozak",
            "Nokat",
            "Mišić",
            1)
        questionsList.add(que3)

        val que4 = Question(4, "Čemu služi srce?",
            R.drawable.que4,
            "Da lakše vježbamo",
            "Spaja sve žile na tijelu",
            "Pumpanje krvi po cijelom tijelu",
            "Za bolje pamćenje",
            3)
        questionsList.add(que4)
        val que5 = Question(5, "Koji je organ 'kriv' za menstruaciju?",
            R.drawable.que5,
            "Bubreg",
            "Srce",
            "Slijepo crijevo",
            "Maternica",
            4)
        questionsList.add(que5)
        val que6 = Question(6, "Koji organ u tijelu služi kao sito za loše tvari?",
            R.drawable.que6,
            "Jetra",
            "Želudac",
            "Pluća",
            "Slijepo crijevo",
            1)
        questionsList.add(que6)
        val que7 = Question(7,"Preko kojeg organa vidimo?", R.drawable.que7,
            "Zjenica",
            "Trepavica",
            "Mozak",
            "Oko",
            4)
        questionsList.add(que7)
        val que8 = Question(8, "Koji je najosjetljiviji dio tijela na dodir?",
            R.drawable.que8,
            "Zubi",
            "Jezik",
            "Stopala",
            "Usne",
            4)
        questionsList.add(que8)
        val que9 = Question(9, "Gdje se nalazi najveći mišić u tijelu?",
            R.drawable.que9,
            "Leđa",
            "Noge",
            "Ruke",
            "Trbuh",
            1)
        questionsList.add(que9)
        val que10 = Question(10, "Koliko okusa osjećamo preko jezika?",
            R.drawable.que10,
            "10",
            "4",
            "3",
            "1",
            2)
        questionsList.add(que10)
        return(questionsList)
    }

}