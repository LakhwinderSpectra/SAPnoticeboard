package com.example.sapnoticeboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sapnoticeboard.adapters.PolicyAdapter
import com.example.sapnoticeboard.databinding.ActivityMainBinding
import com.example.sapnoticeboard.models.Policy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var policyAdapter: PolicyAdapter

    // Mock data for policies
    private val policies = listOf(
        Policy("Privacy Policy", "sample-1.pdf"),
        Policy("Terms and Conditions", "sample-2.pdf"),
        Policy("Refund Policy", "sample-3.pdf"),
        Policy("Security Policy", "sample-4.pdf"),
        Policy("Cookie Policy", "sample-5.pdf")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView for displaying policies
        setupRecyclerView()

        // Set app bar title
        supportActionBar?.title = "SAP Notice Board"
    }

    private fun setupRecyclerView() {
        // Initialize the PolicyAdapter with the list of policies and click listener
        policyAdapter = PolicyAdapter(policies) { selectedPolicy ->
            openPdfViewer(selectedPolicy)
        }

        // Bind the RecyclerView and set its layout manager and adapter
        binding.recyclerViewPolicies.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = policyAdapter
        }
    }

    private fun openPdfViewer(policy: Policy) {
        // Open the PdfViewerActivity with the selected policy file
        val intent = Intent(this, PdfViewerActivity::class.java).apply {
            putExtra("pdfFileName", policy.fileName)
        }
        startActivity(intent)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PolicyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_policy, parent, false)
        return PolicyViewHolder(view)
    }

}
