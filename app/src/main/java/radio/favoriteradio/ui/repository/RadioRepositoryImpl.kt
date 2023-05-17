package radio.favoriteradio.ui.repository

import radio.favoriteradio.R
import radio.favoriteradio.ui.dto.Radio

class RadioRepositoryImpl() : RadioRepository {

    override val listFavoriteRadio: ArrayList<Radio> = ArrayList()
    override val listRadio: ArrayList<Radio> = ArrayList()

    override fun listRadio(){
        val radio1 = Radio(1,"Русское радио", R.drawable.rusradio_icon)
        val radio2 = Radio(2,"Новое радио",R.drawable.novoe_radio_icon)
        val radio3 = Radio(3,"Ретро радио", R.drawable.retro_fm_icon)
        val radio4 = Radio( 4,"Радио дача",R.drawable.radio_dacha_icon)
        val radio5 = Radio(5,"Дорожное радио",R.drawable.dorojnoe_icon)
        val radio6 = Radio(6,"Европа плюс", R.drawable.europa_plus_icon)

        listRadio.add(radio1)
        listRadio.add(radio2)
        listRadio.add(radio3)
        listRadio.add(radio4)
        listRadio.add(radio5)
        listRadio.add(radio6)
    }

    override fun addListFavouriteRadio() {

        val radio1 = Radio(1,"Русское радио", R.drawable.rusradio_icon)
//        listFavoriteRadio.add(radio1)
        listRadio.forEach { element->
            if(element.isFavourite ){
               listFavoriteRadio.add(element)

            }



    }



    }

    override fun getRadioById(id: Int): Radio {
        val test = listRadio[id]
        return test
    }
}


