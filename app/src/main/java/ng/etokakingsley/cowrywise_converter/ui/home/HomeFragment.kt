package ng.etokakingsley.cowrywise_converter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import ng.etokakingsley.cowrywise_converter.R
import ng.etokakingsley.cowrywise_converter.databinding.FragmentHomeBinding
import ng.etokakingsley.cowrywise_converter.helper.SnackBarUtil

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private  val homeViewModel: HomeViewModel by viewModels()
    var binding : FragmentHomeBinding? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding?.apply {
            vm = homeViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        subscribeUI()
    }

    private fun subscribeUI(){
        homeViewModel.flashSuccessMessage.observe(viewLifecycleOwner){
            it?.getContentIfNotHandled()?.let {msg->
                binding?.let {
                    val snack = SnackBarUtil.successSnack(it.parentLayout,msg, requireContext() )
                    snack.show()
                }
            }
        }
        homeViewModel.flashErrorMessage.observe(viewLifecycleOwner){
            it?.getContentIfNotHandled()?.let {msg->
                binding?.let {
                    val snack = SnackBarUtil.errorSnack(view = it.parentLayout,msg = msg, requireContext() )
                    snack.show()
                }
            }
        }
    }

    /**
     * Null out the bindings to avoid memory leaks
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}