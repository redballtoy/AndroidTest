package com.example.redballtoy.recyclerviewtestklimov_01

class CoteItem {

    val coteItemList:List<CoteItemOne> = arrayListOf<CoteItemOne>(
        CoteItemOne(R.drawable.cote_eight,R.string.cote_eight),
        CoteItemOne(R.drawable.cote_eightin,R.string.cote_eightin),
        CoteItemOne(R.drawable.cote_eleven,R.string.cote_eleven),
        CoteItemOne(R.drawable.cote_five,R.string.cote_five),
        CoteItemOne(R.drawable.cote_fortiyn,R.string.cote_fortiyn),
        CoteItemOne(R.drawable.cote_four,R.string.cote_four),
        CoteItemOne(R.drawable.cote_nine,R.string.cote_nine),
        CoteItemOne(R.drawable.cote_one,R.string.cote_one),
        CoteItemOne(R.drawable.cote_seven,R.string.cote_seven),
        CoteItemOne(R.drawable.cote_seventin,R.string.cote_seventin),
        CoteItemOne(R.drawable.cote_six,R.string.cote_six),
        CoteItemOne(R.drawable.cote_sixin,R.string.cote_sixin),
        CoteItemOne(R.drawable.cote_thirtiyn,R.string.cote_thirtiyn),
        CoteItemOne(R.drawable.cote_three,R.string.cote_three),
        CoteItemOne(R.drawable.cote_tventy,R.string.cote_twenty),
        CoteItemOne(R.drawable.cote_tventytwo,R.string.cote_twemtytwo),
        CoteItemOne(R.drawable.cote_twenty_four,R.string.cote_twentyfour),
        CoteItemOne(R.drawable.cote_twenty_three,R.string.cote_twentythree),
        CoteItemOne(R.drawable.cote_twentyone,R.string.cote_twentyone),
        CoteItemOne(R.drawable.cote_two,R.string.cote_two),
        CoteItemOne(R.drawable.cote_eightintwo,R.string.cote_kote_eightintwo)
    )


    fun getCoteList():List<CoteItemOne>{
        return coteItemList
    }

    data class CoteItemOne(private val imageId: Int, private val textId: Int){


        fun getFotoId():Int {
            return imageId
        }

        fun getTextId():Int {
            return textId
        }


    }


}
