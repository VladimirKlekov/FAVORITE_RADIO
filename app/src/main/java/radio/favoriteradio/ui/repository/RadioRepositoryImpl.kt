package radio.favoriteradio.ui.repository


import radio.favoriteradio.R
import radio.favoriteradio.ui.dto.Radio

class RadioRepositoryImpl() : RadioRepository {

    val radioList: ArrayList<Radio> = ArrayList()

    val test = radioList

    override fun allRadio(){
        val radio1 = Radio(1,"Русское радио", R.drawable.rusradio_icon)
        val radio2 = Radio(2,"Новое радио",R.drawable.novoe_radio_icon)
        val radio3 = Radio(3,"Ретро радио", R.drawable.retro_fm_icon)
        val radio4 = Radio( 4,"Радио дача",R.drawable.radio_dacha_icon)
        val radio5 = Radio(5,"Дорожное радио",R.drawable.dorojnoe_icon)
        val radio6 = Radio(6,"Европа плюс", R.drawable.europa_plus_icon)


        radioList.add(radio1)
        radioList.add(radio2)
        radioList.add(radio3)
        radioList.add(radio4)
        radioList.add(radio5)
        radioList.add(radio6)
    }


}


