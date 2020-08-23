package com.eahm.animationexp.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import com.eahm.animationexp.R
import kotlinx.android.synthetic.main.activity_basic_with_activities1.*

/**
 * @author elvishrdz
 */
class BasicWithActivities1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* 2.1 You can enable content transition for shared element transitions at runtime
        * calling the windows request feature */
        //window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_basic_with_activities1)

        /**
         * Getting Started
         * Notice that we use the BasicWithActivities2.kt with this example.
         *
         * 1. Add to the activity_basic_with_activities1.xml some widgets
         *  1.1 Add to each view element in the layout the attribute 'transitionName'
         *      - This name must be unique.
         *      - set the same value to the corresponding view in the next activity
         *        BasicWithActivities 2 (See activity_basic_with_activities 2 .xml)
         *      - The id can be different but the transitionName must match with the 2
         *        views in transition.
         *
         * 2. Enable windowsContentTransition (available since API 21)
         *  2.1 You can enable this at runtime or define it in the code:
         *      In code:     Add the attribute in the styles.xml
         *      At runtime:  Set the values before adding content to the activity
         *                   window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
         *
         *
         * 3. Use ActivityOptionsCompat to pass the view that you want to have a transition.
         *
         * See below how to create those transitions.
         */

        btnBA1GoTo.setOnClickListener{
            // Basic Shared Element Transition
            val intent = Intent(this, BasicWithActivities2::class.java)
            val activityOptions : ActivityOptionsCompat?

            if(sBA1Select.isChecked){
                /* Multiple Shared Element Transition */
                activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair.create(tvBA1Title, tvBA1Title.transitionName),
                    Pair.create(btnBA1GoTo, btnBA1GoTo.transitionName),
                    Pair.create(ivBA1Image, ivBA1Image.transitionName),
                    Pair.create(sBA1Select, sBA1Select.transitionName),
                    Pair.create(pbBA1Loading, pbBA1Loading.transitionName)
                )
            }
            else {
                /* Single Shared Element Transition */
                activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    tvBA1Title,
                    tvBA1Title.transitionName
                )
            }

            startActivity(intent, activityOptions.toBundle())
        }

        btnBA1GoTo2.setOnClickListener{
            // Transition of views inside a NestedScrollView (Child views)

            val intent = Intent(this, BasicWithActivities2::class.java)
            val activityOptions: ActivityOptionsCompat?

            if(sBA1Select2.isChecked){
                // Transition with the elements on top of the layout
                activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair.create(tvBA1Title2, tvBA1Title2.transitionName),
                    Pair.create(btnBA1GoTo2, btnBA1GoTo2.transitionName),
                    Pair.create(ivBA1Image2, ivBA1Image2.transitionName),
                    Pair.create(sBA1Select2, sBA1Select2.transitionName),
                    Pair.create(pbBA1Loading2, pbBA1Loading2.transitionName),
                    Pair.create(rbBA1Rating, rbBA1Rating.transitionName)
                )
            }
            else {
                /* Transition with his corresponding views inside a nested scrollview in the other activity.
                   this IDs are assigned in the activity_basic_with_activities2.xml
                 */
                activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair.create(tvBA1Title2, "tvBATitle2"),
                    Pair.create(btnBA1GoTo2, "btnBAButton2"),
                    Pair.create(ivBA1Image2, "ivBAImage2"),
                    Pair.create(sBA1Select2, "sBASwitch2"),
                    Pair.create(pbBA1Loading2, "pbBAProgress2"),
                    Pair.create(rbBA1Rating, "rbBARating2")
                )
            }

            startActivity(intent, activityOptions.toBundle())
        }
    }
}