package elmeniawy.eslam.tindermotionlayout.scenes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import elmeniawy.eslam.tindermotionlayout.R
import kotlinx.android.synthetic.main.activity_tinder_scene10.*

class TinderScene10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tinder_scene10)

        val viewModel = ViewModelProvider(this).get(TinderContactViewModel::class.java)

        viewModel.modelStream.observe(this, Observer {
            bindCard(it)
        })

        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenUnlike,
                    R.id.offScreenLike -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, R.id.detail)
                        viewModel.swipe()
                    }
                }
            }
        })

        likeFloating.setOnClickListener {
            motionLayout.transitionToState(R.id.like)
        }

        unlikeFloating.setOnClickListener {
            motionLayout.transitionToState(R.id.unlike)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindCard(model: TinderContactModel) {
        containerCardOne.setBackgroundColor(model.cardTop.backgroundColor)
        name.text = "${model.cardTop.name}, ${model.cardTop.age}"
        description.text = model.cardTop.description
        containerCardTwo.setBackgroundColor(model.cardBottom.backgroundColor)
    }
}