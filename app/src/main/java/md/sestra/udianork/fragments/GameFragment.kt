package md.sestra.udianork.fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import md.sestra.udianork.R
import md.sestra.udianork.databinding.FragmentGameBinding
import java.util.*
import kotlin.coroutines.CoroutineContext

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    var res: Int? = null
    var count = 0
    var totalCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBackToMenu.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.flContainerFragments, MenuFragment())
                ?.commit()
        }
        binding.btStartStop.setOnClickListener {
            if(binding.btStartStop.text == "Start"){
                binding.btStartStop.text = "Stop"
                binding.ll100PointsLine.alpha = 1f
                setEnabledForView()
                binding.iv11.isEnabled = true
                binding.iv12.isEnabled = true
                binding.iv13.isEnabled = true
                binding.iv14.isEnabled = true

                binding.iv11.setOnClickListener {
                    if (getRandomImage100() == R.id.iv1_1) {
                        binding.iv11.setImageResource(R.drawable.coin)
                        binding.iv11.isEnabled = false
                        binding.iv12.visibility = View.INVISIBLE
                        binding.iv12.isEnabled = false
                        binding.iv13.visibility = View.INVISIBLE
                        binding.iv13.isEnabled = false
                        binding.iv14.visibility = View.INVISIBLE
                        binding.iv14.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 1f
                        binding.iv21.isEnabled = true
                        binding.iv22.isEnabled = true
                        binding.iv23.isEnabled = true
                        binding.iv24.isEnabled = true
                        count = 100
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv12.isEnabled = true
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv13.isEnabled = true
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv14.isEnabled = true
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv12.setOnClickListener {
                    if (getRandomImage100() == R.id.iv1_2) {
                        binding.iv12.setImageResource(R.drawable.coin)
                        binding.iv11.visibility = View.INVISIBLE
                        binding.iv11.isEnabled = false
                        binding.iv12.isEnabled = false
                        binding.iv13.visibility = View.INVISIBLE
                        binding.iv13.isEnabled = false
                        binding.iv14.visibility = View.INVISIBLE
                        binding.iv14.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 1f
                        binding.iv21.isEnabled = true
                        binding.iv22.isEnabled = true
                        binding.iv23.isEnabled = true
                        binding.iv24.isEnabled = true
                        count = 100
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv12.isEnabled = true
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv13.isEnabled = true
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv14.isEnabled = true
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv13.setOnClickListener {
                    if (getRandomImage100() == R.id.iv1_3) {
                        binding.iv13.setImageResource(R.drawable.coin)
                        binding.iv11.visibility = View.INVISIBLE
                        binding.iv11.isEnabled = false
                        binding.iv12.visibility = View.INVISIBLE
                        binding.iv12.isEnabled = false
                        binding.iv13.isEnabled = false
                        binding.iv14.visibility = View.INVISIBLE
                        binding.iv14.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 1f
                        binding.iv21.isEnabled = true
                        binding.iv22.isEnabled = true
                        binding.iv23.isEnabled = true
                        binding.iv24.isEnabled = true
                        count = 100
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv12.isEnabled = true
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv13.isEnabled = true
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv14.isEnabled = true
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv14.setOnClickListener {
                    if (getRandomImage100() == R.id.iv1_4) {
                        binding.iv14.setImageResource(R.drawable.coin)
                        binding.iv11.visibility = View.INVISIBLE
                        binding.iv11.isEnabled = false
                        binding.iv12.visibility = View.INVISIBLE
                        binding.iv12.isEnabled = false
                        binding.iv13.visibility = View.INVISIBLE
                        binding.iv13.isEnabled = false
                        binding.iv14.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 1f
                        binding.iv21.isEnabled = true
                        binding.iv22.isEnabled = true
                        binding.iv23.isEnabled = true
                        binding.iv24.isEnabled = true
                        count = 100
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv12.isEnabled = true
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv13.isEnabled = true
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv14.isEnabled = true
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }

                binding.iv21.setOnClickListener {
                    if (getRandomImage500() == R.id.iv2_1) {
                        binding.iv21.setImageResource(R.drawable.coin)
                        binding.iv21.isEnabled = false
                        binding.iv22.visibility = View.INVISIBLE
                        binding.iv22.isEnabled = false
                        binding.iv23.visibility = View.INVISIBLE
                        binding.iv23.isEnabled = false
                        binding.iv24.visibility = View.INVISIBLE
                        binding.iv24.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 1f
                        binding.iv31.isEnabled = true
                        binding.iv32.isEnabled = true
                        binding.iv33.isEnabled = true
                        binding.iv34.isEnabled = true
                        count = count + 500
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv22.setOnClickListener {
                    if (getRandomImage500() == R.id.iv2_2) {
                        binding.iv22.setImageResource(R.drawable.coin)
                        binding.iv21.visibility = View.INVISIBLE
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.visibility = View.INVISIBLE
                        binding.iv23.isEnabled = false
                        binding.iv24.visibility = View.INVISIBLE
                        binding.iv24.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 1f
                        binding.iv31.isEnabled = true
                        binding.iv32.isEnabled = true
                        binding.iv33.isEnabled = true
                        binding.iv34.isEnabled = true
                        count = count + 500
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv23.setOnClickListener {
                    if (getRandomImage500() == R.id.iv2_3) {
                        binding.iv23.setImageResource(R.drawable.coin)
                        binding.iv21.visibility = View.INVISIBLE
                        binding.iv21.isEnabled = false
                        binding.iv22.visibility = View.INVISIBLE
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.visibility = View.INVISIBLE
                        binding.iv24.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 1f
                        binding.iv31.isEnabled = true
                        binding.iv32.isEnabled = true
                        binding.iv33.isEnabled = true
                        binding.iv34.isEnabled = true
                        count = count + 500
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv24.setOnClickListener {
                    if (getRandomImage500() == R.id.iv2_4) {
                        binding.iv24.setImageResource(R.drawable.coin)
                        binding.iv21.visibility = View.INVISIBLE
                        binding.iv21.isEnabled = false
                        binding.iv22.visibility = View.INVISIBLE
                        binding.iv22.isEnabled = false
                        binding.iv23.visibility = View.INVISIBLE
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 1f
                        binding.iv31.isEnabled = true
                        binding.iv32.isEnabled = true
                        binding.iv33.isEnabled = true
                        binding.iv34.isEnabled = true
                        count = count + 500
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }

                binding.iv31.setOnClickListener {
                    if (getRandomImage2000() == R.id.iv3_1) {
                        binding.iv31.setImageResource(R.drawable.coin)
                        binding.iv31.isEnabled = false
                        binding.iv32.visibility = View.INVISIBLE
                        binding.iv32.isEnabled = false
                        binding.iv33.visibility = View.INVISIBLE
                        binding.iv33.isEnabled = false
                        binding.iv34.visibility = View.INVISIBLE
                        binding.iv34.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 1f
                        binding.iv41.isEnabled = true
                        binding.iv42.isEnabled = true
                        binding.iv43.isEnabled = true
                        binding.iv44.isEnabled = true
                        count = count + 2000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv32.setOnClickListener {
                    if (getRandomImage2000() == R.id.iv3_2) {
                        binding.iv32.setImageResource(R.drawable.coin)
                        binding.iv31.visibility = View.INVISIBLE
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.visibility = View.INVISIBLE
                        binding.iv33.isEnabled = false
                        binding.iv34.visibility = View.INVISIBLE
                        binding.iv34.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 1f
                        binding.iv41.isEnabled = true
                        binding.iv42.isEnabled = true
                        binding.iv43.isEnabled = true
                        binding.iv44.isEnabled = true
                        count = count + 2000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv33.setOnClickListener {
                    if (getRandomImage2000() == R.id.iv3_3) {
                        binding.iv33.setImageResource(R.drawable.coin)
                        binding.iv31.visibility = View.INVISIBLE
                        binding.iv31.isEnabled = false
                        binding.iv32.visibility = View.INVISIBLE
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.visibility = View.INVISIBLE
                        binding.iv34.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 1f
                        binding.iv41.isEnabled = true
                        binding.iv42.isEnabled = true
                        binding.iv43.isEnabled = true
                        binding.iv44.isEnabled = true
                        count = count + 2000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv34.setOnClickListener {
                    if (getRandomImage2000() == R.id.iv3_4) {
                        binding.iv34.setImageResource(R.drawable.coin)
                        binding.iv31.visibility = View.INVISIBLE
                        binding.iv31.isEnabled = false
                        binding.iv32.visibility = View.INVISIBLE
                        binding.iv32.isEnabled = false
                        binding.iv33.visibility = View.INVISIBLE
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 1f
                        binding.iv41.isEnabled = true
                        binding.iv42.isEnabled = true
                        binding.iv43.isEnabled = true
                        binding.iv44.isEnabled = true
                        count = count + 2000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }

                binding.iv41.setOnClickListener {
                    if (getRandomImage10000() == R.id.iv4_1) {
                        binding.iv41.setImageResource(R.drawable.coin)
                        binding.iv41.isEnabled = false
                        binding.iv42.visibility = View.INVISIBLE
                        binding.iv42.isEnabled = false
                        binding.iv43.visibility = View.INVISIBLE
                        binding.iv43.isEnabled = false
                        binding.iv44.visibility = View.INVISIBLE
                        binding.iv44.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 1f
                        binding.iv51.isEnabled = true
                        binding.iv52.isEnabled = true
                        binding.iv53.isEnabled = true
                        binding.iv54.isEnabled = true
                        count = count + 10000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv42.setOnClickListener {
                    if (getRandomImage10000() == R.id.iv4_2) {
                        binding.iv42.setImageResource(R.drawable.coin)
                        binding.iv41.visibility = View.INVISIBLE
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.visibility = View.INVISIBLE
                        binding.iv43.isEnabled = false
                        binding.iv44.visibility = View.INVISIBLE
                        binding.iv44.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 1f
                        binding.iv51.isEnabled = true
                        binding.iv52.isEnabled = true
                        binding.iv53.isEnabled = true
                        binding.iv54.isEnabled = true
                        count = count + 10000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv43.setOnClickListener {
                    if (getRandomImage10000() == R.id.iv4_3) {
                        binding.iv43.setImageResource(R.drawable.coin)
                        binding.iv41.visibility = View.INVISIBLE
                        binding.iv41.isEnabled = false
                        binding.iv42.visibility = View.INVISIBLE
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.visibility = View.INVISIBLE
                        binding.iv44.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 1f
                        binding.iv51.isEnabled = true
                        binding.iv52.isEnabled = true
                        binding.iv53.isEnabled = true
                        binding.iv54.isEnabled = true
                        count = count + 10000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv44.setOnClickListener {
                    if (getRandomImage10000() == R.id.iv4_4) {
                        binding.iv44.setImageResource(R.drawable.coin)
                        binding.iv41.visibility = View.INVISIBLE
                        binding.iv41.isEnabled = false
                        binding.iv42.visibility = View.INVISIBLE
                        binding.iv42.isEnabled = false
                        binding.iv43.visibility = View.INVISIBLE
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 1f
                        binding.iv51.isEnabled = true
                        binding.iv52.isEnabled = true
                        binding.iv53.isEnabled = true
                        binding.iv54.isEnabled = true
                        count = count + 10000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }

                binding.iv51.setOnClickListener {
                    if (getRandomImage50000() == R.id.iv5_1) {
                        binding.iv51.setImageResource(R.drawable.coin)
                        binding.iv51.isEnabled = false
                        binding.iv52.visibility = View.INVISIBLE
                        binding.iv52.isEnabled = false
                        binding.iv53.visibility = View.INVISIBLE
                        binding.iv53.isEnabled = false
                        binding.iv54.visibility = View.INVISIBLE
                        binding.iv54.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 1f
                        binding.iv61.isEnabled = true
                        binding.iv62.isEnabled = true
                        binding.iv63.isEnabled = true
                        binding.iv64.isEnabled = true
                        count = count + 50000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv52.setOnClickListener {
                    if (getRandomImage50000() == R.id.iv5_2) {
                        binding.iv52.setImageResource(R.drawable.coin)
                        binding.iv51.visibility = View.INVISIBLE
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.visibility = View.INVISIBLE
                        binding.iv53.isEnabled = false
                        binding.iv54.visibility = View.INVISIBLE
                        binding.iv54.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 1f
                        binding.iv61.isEnabled = true
                        binding.iv62.isEnabled = true
                        binding.iv63.isEnabled = true
                        binding.iv64.isEnabled = true
                        count = count + 50000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv53.setOnClickListener {
                    if (getRandomImage50000() == R.id.iv5_3) {
                        binding.iv53.setImageResource(R.drawable.coin)
                        binding.iv51.visibility = View.INVISIBLE
                        binding.iv51.isEnabled = false
                        binding.iv52.visibility = View.INVISIBLE
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.visibility = View.INVISIBLE
                        binding.iv54.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 1f
                        binding.iv61.isEnabled = true
                        binding.iv62.isEnabled = true
                        binding.iv63.isEnabled = true
                        binding.iv64.isEnabled = true
                        count = count + 50000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv54.setOnClickListener {
                    if (getRandomImage50000() == R.id.iv5_4) {
                        binding.iv54.setImageResource(R.drawable.coin)
                        binding.iv51.visibility = View.INVISIBLE
                        binding.iv51.isEnabled = false
                        binding.iv52.visibility = View.INVISIBLE
                        binding.iv52.isEnabled = false
                        binding.iv53.visibility = View.INVISIBLE
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 1f
                        binding.iv61.isEnabled = true
                        binding.iv62.isEnabled = true
                        binding.iv63.isEnabled = true
                        binding.iv64.isEnabled = true
                        count = count + 50000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }

                binding.iv61.setOnClickListener {
                    if (getRandomImage200000() == R.id.iv6_1) {
                        binding.iv61.setImageResource(R.drawable.coin)
                        binding.iv61.isEnabled = false
                        binding.iv62.visibility = View.INVISIBLE
                        binding.iv62.isEnabled = false
                        binding.iv63.visibility = View.INVISIBLE
                        binding.iv63.isEnabled = false
                        binding.iv64.visibility = View.INVISIBLE
                        binding.iv64.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        count = count + 200000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv51.visibility = View.VISIBLE
                        binding.iv52.visibility = View.VISIBLE
                        binding.iv53.visibility = View.VISIBLE
                        binding.iv54.visibility = View.VISIBLE
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv61.isEnabled = false
                        binding.iv62.isEnabled = false
                        binding.iv63.isEnabled = false
                        binding.iv64.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        binding.iv51.setImageResource(R.drawable.sunduk)
                        binding.iv52.setImageResource(R.drawable.sunduk)
                        binding.iv53.setImageResource(R.drawable.sunduk)
                        binding.iv54.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv62.setOnClickListener {
                    if (getRandomImage200000() == R.id.iv6_2) {
                        binding.iv62.setImageResource(R.drawable.coin)
                        binding.iv61.visibility = View.INVISIBLE
                        binding.iv61.isEnabled = false
                        binding.iv62.isEnabled = false
                        binding.iv63.visibility = View.INVISIBLE
                        binding.iv63.isEnabled = false
                        binding.iv64.visibility = View.INVISIBLE
                        binding.iv64.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        count = count + 200000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv51.visibility = View.VISIBLE
                        binding.iv52.visibility = View.VISIBLE
                        binding.iv53.visibility = View.VISIBLE
                        binding.iv54.visibility = View.VISIBLE
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv61.isEnabled = false
                        binding.iv62.isEnabled = false
                        binding.iv63.isEnabled = false
                        binding.iv64.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        binding.iv51.setImageResource(R.drawable.sunduk)
                        binding.iv52.setImageResource(R.drawable.sunduk)
                        binding.iv53.setImageResource(R.drawable.sunduk)
                        binding.iv54.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv63.setOnClickListener {
                    if (getRandomImage200000() == R.id.iv6_3) {
                        binding.iv63.setImageResource(R.drawable.coin)
                        binding.iv61.visibility = View.INVISIBLE
                        binding.iv61.isEnabled = false
                        binding.iv62.visibility = View.INVISIBLE
                        binding.iv62.isEnabled = false
                        binding.iv63.isEnabled = false
                        binding.iv64.visibility = View.INVISIBLE
                        binding.iv64.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        count = count + 200000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv51.visibility = View.VISIBLE
                        binding.iv52.visibility = View.VISIBLE
                        binding.iv53.visibility = View.VISIBLE
                        binding.iv54.visibility = View.VISIBLE
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv61.isEnabled = false
                        binding.iv62.isEnabled = false
                        binding.iv63.isEnabled = false
                        binding.iv64.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        binding.iv51.setImageResource(R.drawable.sunduk)
                        binding.iv52.setImageResource(R.drawable.sunduk)
                        binding.iv53.setImageResource(R.drawable.sunduk)
                        binding.iv54.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
                binding.iv64.setOnClickListener {
                    if (getRandomImage200000() == R.id.iv6_4) {
                        binding.iv64.setImageResource(R.drawable.coin)
                        binding.iv61.visibility = View.INVISIBLE
                        binding.iv61.isEnabled = false
                        binding.iv62.visibility = View.INVISIBLE
                        binding.iv62.isEnabled = false
                        binding.iv63.visibility = View.INVISIBLE
                        binding.iv63.isEnabled = false
                        binding.iv64.isEnabled = false
                        binding.ll100PointsLine.alpha = 0.5f
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        count = count + 200000
                        binding.tvScore.text = "Score: $count"
                    }
                    else {
                        binding.iv51.visibility = View.VISIBLE
                        binding.iv52.visibility = View.VISIBLE
                        binding.iv53.visibility = View.VISIBLE
                        binding.iv54.visibility = View.VISIBLE
                        binding.iv41.visibility = View.VISIBLE
                        binding.iv42.visibility = View.VISIBLE
                        binding.iv43.visibility = View.VISIBLE
                        binding.iv44.visibility = View.VISIBLE
                        binding.iv31.visibility = View.VISIBLE
                        binding.iv32.visibility = View.VISIBLE
                        binding.iv33.visibility = View.VISIBLE
                        binding.iv34.visibility = View.VISIBLE
                        binding.iv21.visibility = View.VISIBLE
                        binding.iv22.visibility = View.VISIBLE
                        binding.iv23.visibility = View.VISIBLE
                        binding.iv24.visibility = View.VISIBLE
                        binding.iv11.visibility = View.VISIBLE
                        binding.iv12.visibility = View.VISIBLE
                        binding.iv13.visibility = View.VISIBLE
                        binding.iv14.visibility = View.VISIBLE
                        binding.ll500PointsLine.alpha = 0.5f
                        binding.ll2000PointsLine.alpha = 0.5f
                        binding.ll10000PointsLine.alpha = 0.5f
                        binding.ll50000PointsLine.alpha = 0.5f
                        binding.ll200000PointsLine.alpha = 0.5f
                        binding.ll100PointsLine.alpha = 1f
                        binding.iv11.isEnabled = true
                        binding.iv12.isEnabled = true
                        binding.iv13.isEnabled = true
                        binding.iv14.isEnabled = true
                        binding.iv21.isEnabled = false
                        binding.iv22.isEnabled = false
                        binding.iv23.isEnabled = false
                        binding.iv24.isEnabled = false
                        binding.iv31.isEnabled = false
                        binding.iv32.isEnabled = false
                        binding.iv33.isEnabled = false
                        binding.iv34.isEnabled = false
                        binding.iv41.isEnabled = false
                        binding.iv42.isEnabled = false
                        binding.iv43.isEnabled = false
                        binding.iv44.isEnabled = false
                        binding.iv51.isEnabled = false
                        binding.iv52.isEnabled = false
                        binding.iv53.isEnabled = false
                        binding.iv54.isEnabled = false
                        binding.iv61.isEnabled = false
                        binding.iv62.isEnabled = false
                        binding.iv63.isEnabled = false
                        binding.iv64.isEnabled = false
                        binding.iv11.setImageResource(R.drawable.sunduk)
                        binding.iv12.setImageResource(R.drawable.sunduk)
                        binding.iv13.setImageResource(R.drawable.sunduk)
                        binding.iv14.setImageResource(R.drawable.sunduk)
                        binding.iv21.setImageResource(R.drawable.sunduk)
                        binding.iv22.setImageResource(R.drawable.sunduk)
                        binding.iv23.setImageResource(R.drawable.sunduk)
                        binding.iv24.setImageResource(R.drawable.sunduk)
                        binding.iv31.setImageResource(R.drawable.sunduk)
                        binding.iv32.setImageResource(R.drawable.sunduk)
                        binding.iv33.setImageResource(R.drawable.sunduk)
                        binding.iv34.setImageResource(R.drawable.sunduk)
                        binding.iv41.setImageResource(R.drawable.sunduk)
                        binding.iv42.setImageResource(R.drawable.sunduk)
                        binding.iv43.setImageResource(R.drawable.sunduk)
                        binding.iv44.setImageResource(R.drawable.sunduk)
                        binding.iv51.setImageResource(R.drawable.sunduk)
                        binding.iv52.setImageResource(R.drawable.sunduk)
                        binding.iv53.setImageResource(R.drawable.sunduk)
                        binding.iv54.setImageResource(R.drawable.sunduk)
                        count = 0
                        binding.tvScore.text = "Score: $count"
                    }
                }
            }
            else {
                if(binding.btStartStop.text == "Stop"){
                    binding.btStartStop.text = "Start"
                    setEnabledForView()
                    setImageResourceForView()
                    setVisibilityForView()
                    setAlphaForView()
                    binding.tvScore.text = "Score: 0"
                    totalCount = count
                    binding.tvTotalScore.text = "Total score: $totalCount"
                }
            }
        }
        val sharedPreference = activity?.getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val name = sharedPreference?.getString("222", "Total score: $totalCount")
        binding.tvTotalScore.text = name
    }
    private  fun save(){
        val sharedPreference = activity?.getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val editor = sharedPreference?.edit()
        editor?.putString("222", binding.tvTotalScore.text.toString())
        editor?.apply()
    }
    private fun getRandomImage100(): Int {
        val mImageResources: ArrayList<Int> = ArrayList()
        mImageResources.add(R.id.iv1_1)
        mImageResources.add(R.id.iv1_2)
        mImageResources.add(R.id.iv1_3)
        mImageResources.add(R.id.iv1_4)
        //val randomResource: Int = mRandom.nextInt(mImageResources.size)
        val randomResource = mImageResources.random()
        Log.d("log", "$randomResource")
        return randomResource
    }
    private fun getRandomImage500(): Int {
        val mImageResources: ArrayList<Int> = ArrayList()
        mImageResources.add(R.id.iv2_1)
        mImageResources.add(R.id.iv2_2)
        mImageResources.add(R.id.iv2_3)
        mImageResources.add(R.id.iv2_4)
        val randomResource = mImageResources.random()
        Log.d("log", "$randomResource")
        return randomResource
    }
    private fun getRandomImage2000(): Int {
        val mImageResources: ArrayList<Int> = ArrayList()
        mImageResources.add(R.id.iv3_1)
        mImageResources.add(R.id.iv3_2)
        mImageResources.add(R.id.iv3_3)
        mImageResources.add(R.id.iv3_4)
        val randomResource = mImageResources.random()
        Log.d("log", "$randomResource")
        return randomResource
    }
    private fun getRandomImage10000(): Int {
        val mImageResources: ArrayList<Int> = ArrayList()
        mImageResources.add(R.id.iv4_1)
        mImageResources.add(R.id.iv4_2)
        mImageResources.add(R.id.iv4_3)
        mImageResources.add(R.id.iv4_4)
        val randomResource = mImageResources.random()
        Log.d("log", "$randomResource")
        return randomResource
    }
    private fun getRandomImage50000(): Int {
        val mImageResources: ArrayList<Int> = ArrayList()
        mImageResources.add(R.id.iv5_1)
        mImageResources.add(R.id.iv5_2)
        mImageResources.add(R.id.iv5_3)
        mImageResources.add(R.id.iv5_4)
        val randomResource = mImageResources.random()
        Log.d("log", "$randomResource")
        return randomResource
    }
    private fun getRandomImage200000(): Int {
        val mImageResources: ArrayList<Int> = ArrayList()
        mImageResources.add(R.id.iv6_1)
        mImageResources.add(R.id.iv6_2)
        mImageResources.add(R.id.iv6_3)
        mImageResources.add(R.id.iv6_4)
        val randomResource = mImageResources.random()
        Log.d("log", "$randomResource")
        return randomResource
    }
    private fun setEnabledForView(){
        binding.iv11.isEnabled = false
        binding.iv12.isEnabled = false
        binding.iv13.isEnabled = false
        binding.iv14.isEnabled = false
        binding.iv21.isEnabled = false
        binding.iv22.isEnabled = false
        binding.iv23.isEnabled = false
        binding.iv24.isEnabled = false
        binding.iv31.isEnabled = false
        binding.iv32.isEnabled = false
        binding.iv33.isEnabled = false
        binding.iv34.isEnabled = false
        binding.iv41.isEnabled = false
        binding.iv42.isEnabled = false
        binding.iv43.isEnabled = false
        binding.iv44.isEnabled = false
        binding.iv51.isEnabled = false
        binding.iv52.isEnabled = false
        binding.iv53.isEnabled = false
        binding.iv54.isEnabled = false
        binding.iv61.isEnabled = false
        binding.iv62.isEnabled = false
        binding.iv63.isEnabled = false
        binding.iv64.isEnabled = false
    }
    private fun setImageResourceForView(){
        binding.iv11.setImageResource(R.drawable.sunduk)
        binding.iv12.setImageResource(R.drawable.sunduk)
        binding.iv13.setImageResource(R.drawable.sunduk)
        binding.iv14.setImageResource(R.drawable.sunduk)
        binding.iv21.setImageResource(R.drawable.sunduk)
        binding.iv22.setImageResource(R.drawable.sunduk)
        binding.iv23.setImageResource(R.drawable.sunduk)
        binding.iv24.setImageResource(R.drawable.sunduk)
        binding.iv31.setImageResource(R.drawable.sunduk)
        binding.iv32.setImageResource(R.drawable.sunduk)
        binding.iv33.setImageResource(R.drawable.sunduk)
        binding.iv34.setImageResource(R.drawable.sunduk)
        binding.iv41.setImageResource(R.drawable.sunduk)
        binding.iv42.setImageResource(R.drawable.sunduk)
        binding.iv43.setImageResource(R.drawable.sunduk)
        binding.iv44.setImageResource(R.drawable.sunduk)
        binding.iv51.setImageResource(R.drawable.sunduk)
        binding.iv52.setImageResource(R.drawable.sunduk)
        binding.iv53.setImageResource(R.drawable.sunduk)
        binding.iv54.setImageResource(R.drawable.sunduk)
        binding.iv61.setImageResource(R.drawable.sunduk)
        binding.iv62.setImageResource(R.drawable.sunduk)
        binding.iv63.setImageResource(R.drawable.sunduk)
        binding.iv64.setImageResource(R.drawable.sunduk)
    }
    private fun setVisibilityForView(){
        binding.iv11.visibility = View.VISIBLE
        binding.iv12.visibility = View.VISIBLE
        binding.iv13.visibility = View.VISIBLE
        binding.iv14.visibility = View.VISIBLE
        binding.iv21.visibility = View.VISIBLE
        binding.iv22.visibility = View.VISIBLE
        binding.iv23.visibility = View.VISIBLE
        binding.iv24.visibility = View.VISIBLE
        binding.iv31.visibility = View.VISIBLE
        binding.iv32.visibility = View.VISIBLE
        binding.iv33.visibility = View.VISIBLE
        binding.iv34.visibility = View.VISIBLE
        binding.iv41.visibility = View.VISIBLE
        binding.iv42.visibility = View.VISIBLE
        binding.iv43.visibility = View.VISIBLE
        binding.iv44.visibility = View.VISIBLE
        binding.iv51.visibility = View.VISIBLE
        binding.iv52.visibility = View.VISIBLE
        binding.iv53.visibility = View.VISIBLE
        binding.iv54.visibility = View.VISIBLE
        binding.iv61.visibility = View.VISIBLE
        binding.iv62.visibility = View.VISIBLE
        binding.iv63.visibility = View.VISIBLE
        binding.iv64.visibility = View.VISIBLE
    }
    private fun setAlphaForView(){
        binding.ll100PointsLine.alpha = 0.5f
        binding.ll500PointsLine.alpha = 0.5f
        binding.ll2000PointsLine.alpha = 0.5f
        binding.ll10000PointsLine.alpha = 0.5f
        binding.ll50000PointsLine.alpha = 0.5f
        binding.ll200000PointsLine.alpha = 0.5f
    }
    override fun onDetach() {
        super.onDetach()
        save()
        }
    }



