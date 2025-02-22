package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.ProfileAdapter
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profileInfo = listOf(
            Info("John Doe", "john.doe@gmail.com", "123 Example Street, Example City, Example Postal Code 12345, Example Country"),
        )

        val profileAdapter = ProfileAdapter(profileInfo)

        binding.profileRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.profileRecyclerView.adapter = profileAdapter // ใช้ profileAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}