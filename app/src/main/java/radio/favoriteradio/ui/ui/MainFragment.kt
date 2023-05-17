package radio.favoriteradio.ui.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import radio.favoriteradio.R
import radio.favoriteradio.databinding.FragmentMainBinding
import radio.favoriteradio.databinding.ItemNameRadioBinding
import radio.favoriteradio.ui.adapter.RadioAdapter
import radio.favoriteradio.ui.viewmodel.RadioViewModel

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var radioAdapter: RadioAdapter
    private val radioViewModel: RadioViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        radioViewModel.listRadio()
        radioViewModel.addListFavoriteRadio()

//        //для навигационной панели меню
//        toggle = ActionBarDrawerToggle(requireActivity(), binding.root, R.string.open, R.string.close)
//        binding.root.addDrawerListener(toggle)
//        toggle.syncState()
//        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        //AppCompatActivity().getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

//

//        radioViewModel.dataRadio.forEach { element->
//            if(element.isFavourite == true){
//                radioViewModel.addListFavoriteRadio(element)
//            }
//
//        }




        binding.radioRV.setHasFixedSize(true)
        binding.radioRV.setItemViewCacheSize(13)
        binding.radioRV.layoutManager = LinearLayoutManager(requireContext())
        radioAdapter = RadioAdapter(requireContext(),radioViewModel.dataRadio)
        binding.radioRV.adapter = radioAdapter
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