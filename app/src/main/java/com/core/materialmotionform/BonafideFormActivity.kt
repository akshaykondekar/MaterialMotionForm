package com.core.materialmotionform

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.core.materialmotionform.databinding.ActivityBonafideFormBinding
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_bonafide_form.*


class BonafideFormActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBonafideFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        binding = ActivityBonafideFormBinding.inflate(layoutInflater)
        binding.constraint.transitionName = "shared_element_end_root"
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildContainerTransform()
        window.sharedElementReturnTransition = buildContainerTransform()
        setContentView(binding.constraint)
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.fabSubmit.setOnClickListener {
            if(tietReason.text.toString().isNotEmpty() ||
                tietSubject.text.toString().isNotEmpty()){
                val intent = Intent()
                intent.putExtra("subject", tietSubject.text.toString())
                intent.putExtra("reason", tietReason.text.toString())
                setResult(Activity.RESULT_OK, intent)
                onBackPressed()
            }
            else{
                onBackPressed()
            }
        }
    }

    private fun buildContainerTransform() =
        MaterialContainerTransform().apply {
            addTarget(binding.constraint)
            setAllContainerColors(MaterialColors.getColor(binding.root, R.attr.colorSurface))
            pathMotion = MaterialArcMotion()
            duration = 500
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                true
            }
        }
    }
}