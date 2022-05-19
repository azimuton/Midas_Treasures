package md.sestra.udianork.fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import md.sestra.udianork.R
import md.sestra.udianork.databinding.FragmentMenuBinding
import kotlin.coroutines.CoroutineContext


class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.btPlay.setOnClickListener {

          activity?.supportFragmentManager
              ?.beginTransaction()
              ?.replace(R.id.flContainerFragments, GameFragment())
              ?.commit()
      }
        binding.btExit.setOnClickListener {
           activity?.finishAffinity()
        }
        binding.btSettings.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.flContainerFragments,SettingsFragment())
                ?.commit()
        }
    }
}