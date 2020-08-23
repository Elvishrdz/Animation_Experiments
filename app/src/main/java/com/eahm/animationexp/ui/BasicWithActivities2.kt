package com.eahm.animationexp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eahm.animationexp.R
import kotlinx.android.synthetic.main.activity_basic_with_activities2.*

/**
 * @author elvishrdz
 */
class BasicWithActivities2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_with_activities2)

        /**
         * See BasicWithActivities1.kt to start with this example.
         */

        btnBA2GoBack.setOnClickListener{
            /**
             * Call finishAfterTransition() instead of finish() to run the exit
             * animation
             */
            finishAfterTransition()
        }

        btnBA2GoBack2.setOnClickListener{
            /**
             * Call finishAfterTransition() instead of finish() to run the exit
             * animation
             */
            finishAfterTransition()
        }
    }
}