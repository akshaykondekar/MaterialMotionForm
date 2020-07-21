package com.core.materialmotionform

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.core.materialmotionform.databinding.ActivityMainBinding
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val REQUEST_CODE = 0
    lateinit var bonafideAdapter : BonafideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setClickListeners()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        bonafideAdapter = BonafideAdapter(bonafides)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        binding.rvAppliedBonfides.layoutManager = linearLayoutManager
        binding.rvAppliedBonfides.adapter = bonafideAdapter
    }

    private fun setClickListeners() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, BonafideFormActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this@MainActivity,  binding.fabAdd,"shared_element_end_root")
            startActivityForResult(intent, REQUEST_CODE, options.toBundle())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val newBonafide = Bonafide(
                    id = 6,
                    status = false,
                    appliedDate = "10 July 2020",
                    subject = data?.getStringExtra("subject"),
                    reasonInDetail = data?.getStringExtra("reason")
                )
                bonafides.add(newBonafide)
                bonafideAdapter.notifyDataSetChanged()
                binding.rvAppliedBonfides.layoutManager?.scrollToPosition(bonafides.size-1)
            }
        }
    }
}