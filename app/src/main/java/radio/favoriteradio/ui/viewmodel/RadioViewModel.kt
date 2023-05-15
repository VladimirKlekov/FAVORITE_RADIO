package radio.favoriteradio.ui.viewmodel

import androidx.lifecycle.ViewModel
import radio.favoriteradio.ui.dto.Radio
import radio.favoriteradio.ui.repository.RadioRepository
import radio.favoriteradio.ui.repository.RadioRepositoryImpl


class RadioViewModel() : ViewModel() {
    private val radioRepository: RadioRepository = RadioRepositoryImpl()

//    val dataRadio: ArrayList<Radio>
//        get() = radioRepository.radioList

    fun addRadio(radio: Radio){

    }


}

