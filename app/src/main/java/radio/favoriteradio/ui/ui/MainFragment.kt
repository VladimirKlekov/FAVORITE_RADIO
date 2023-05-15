package radio.favoriteradio.ui.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import radio.favoriteradio.R
import radio.favoriteradio.databinding.FragmentMainBinding
import radio.favoriteradio.ui.adapter.RadioAdapter
import radio.favoriteradio.ui.dto.Radio
import radio.favoriteradio.ui.viewmodel.RadioViewModel

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var radioAdapter: RadioAdapter
    private val radioViewModel: RadioViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)


//        //для навигационной панели меню
//        toggle = ActionBarDrawerToggle(requireActivity(), binding.root, R.string.open, R.string.close)
//        binding.root.addDrawerListener(toggle)
//        toggle.syncState()
//        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        //AppCompatActivity().getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

//        val radio1 = Radio(1,"Русское радио",R.drawable.rusradio_icon)
//        val radio2 = Radio(2,"Новое радио",R.drawable.novoe_radio_icon)
//        val radio3 = Radio(3,"Ретро радио", R.drawable.retro_fm_icon)
//        val radio4 = Radio( 4,"Радио дача",R.drawable.radio_dacha_icon)
//        val radio5 = Radio(5,"Дорожное радио",R.drawable.dorojnoe_icon)
//        val radio6 = Radio(6,"Европа плюс", R.drawable.europa_plus_icon)
//
        val radioList = ArrayList<Radio>()
//        radioList.add(radio1)
//        radioList.add(radio2)
//        radioList.add(radio3)
//        radioList.add(radio4)
//        radioList.add(radio5)
//        radioList.add(radio6)



        binding.musicRV.setHasFixedSize(true)
        binding.musicRV.setItemViewCacheSize(13)
        binding.musicRV.layoutManager = LinearLayoutManager(requireContext())
        radioAdapter = RadioAdapter(requireContext(),radioList)
        binding.musicRV.adapter = radioAdapter
//        binding.totalSong.text =
//            "Total Song : " + musicAdapter.itemCount//список песен равен списку, пробелу или муз адаптеру
//    }

        binding.favouritesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_favouriteRadio)
        }

}


    /**для nav drawer */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    
}