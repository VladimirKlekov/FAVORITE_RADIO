package radio.favoriteradio.ui.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import radio.favoriteradio.R
import radio.favoriteradio.databinding.FragmentMainBinding
import radio.favoriteradio.ui.adapter.RadioAdapter
import radio.favoriteradio.ui.dto.Radio

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var radioAdapter: RadioAdapter
    companion object {
        lateinit var RadioListMA: ArrayList<Radio>}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)


        //для навигационной панели меню
        toggle = ActionBarDrawerToggle(requireActivity(), binding.root, R.string.open, R.string.close)
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //AppCompatActivity().getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        val test = Radio(
            1,
            "Русское радио",
        R.drawable.rusradio_icon)
        val test1 = Radio(
            2,
            "Новое радио",
            R.drawable.novoe_radio_icon)

        val musicList = ArrayList<Radio>()//список музыки
        musicList.add(test)
        musicList.add(test1)
//        musicList.add("2 Song")
//        musicList.add("3 Song")
//        musicList.add("4 Song")
//        musicList.add("5 Song")
        binding.musicRV.setHasFixedSize(true)
        binding.musicRV.setItemViewCacheSize(13)//размер кэша для количества музыки
        binding.musicRV.layoutManager = LinearLayoutManager(requireContext())//привязка верстки
        radioAdapter = RadioAdapter(requireContext(),musicList)//передача списка музыки в адптер

        binding.musicRV.adapter = radioAdapter//приравнивание адаптеров
//        binding.totalSong.text =
//            "Total Song : " + musicAdapter.itemCount//список песен равен списку, пробелу или муз адаптеру
//    }



}



    /**для nav drawer */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

}