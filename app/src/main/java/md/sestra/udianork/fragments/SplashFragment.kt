package md.sestra.udianork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import md.sestra.udianork.R
import md.sestra.udianork.databinding.FragmentSplashBinding
import kotlin.coroutines.CoroutineContext


class SplashFragment() : Fragment(), CoroutineScope {
    private lateinit var binding: FragmentSplashBinding
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.flContainerFragments, MenuFragment())
                ?.commit()
        }
    }
}