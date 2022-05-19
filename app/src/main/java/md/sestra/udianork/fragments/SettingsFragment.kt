package md.sestra.udianork.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import md.sestra.udianork.R
import md.sestra.udianork.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    var audioManager: AudioManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        audioManager = requireContext().getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val maxVolume = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val curValue = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)

        binding.seekBar.max = maxVolume
        binding.seekBar.progress = curValue
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.btSettingsBackToMenu.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.flContainerFragments, MenuFragment())
                ?.commit()
        }

        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(), R.array.languages,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceType")
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
            0 -> {
                binding.btSettingsBackToMenu.text = "Back to menu"
                binding.tvMusic.text = "Music"
                binding.tvLanguages.text = "Language"
            }
            1 -> {
                binding.btSettingsBackToMenu.text = "Назад в меню"
                binding.tvMusic.text = "Музыка"
                binding.tvLanguages.text = "Язык"
            }
        }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }
    }
}