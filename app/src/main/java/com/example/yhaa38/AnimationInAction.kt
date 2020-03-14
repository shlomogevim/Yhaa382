package com.example.yhaa38

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import android.widget.Toast
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.god_layout.*
import kotlinx.android.synthetic.main.helper_view_layout.*
import kotlinx.android.synthetic.main.man_layout.*
import java.util.*

class AnimationInAction(val context: Context) {
    val activity = context as Activity
    val pref = GetAndStoreData(context)
    private val helper = Helper(context)

    private var tv0: TextView? = null
    private var tv0A: TextView? = null
    private var tv2A: TextView? = null
    private var tv1: TextView? = null
    private var tv2: TextView? = null
    private var tv3: TextView? = null
    private var tv4: TextView? = null
    private var tv5: TextView? = null

    private var man0: TextView = activity.manSpeaking0
    private var man1: TextView = activity.manSpeaking1
    private var man2: TextView = activity.manSpeaking2
    private var man3: TextView = activity.manSpeaking3
    private var man4: TextView = activity.manSpeaking4
    private var man5: TextView = activity.manSpeaking5
    private var god0: TextView = activity.godSpeaking0
    private var god0A: TextView = activity.godSpeaking0A
    private var god2A: TextView = activity.godSpeaking2A
    private var god1: TextView = activity.godSpeaking1
    private var god2: TextView = activity.godSpeaking2
    private var god3: TextView = activity.godSpeaking3
    private var god4: TextView = activity.godSpeaking4
    private var god5: TextView = activity.godSpeaking5

   // var listOfTextview = arrayListOf<TextView?>()
    var listOfTextview = arrayListOf(tv0, tv1, tv2, tv3, tv4, tv5)
  /*  var listOfTextviewMul = arrayListOf<TextView?>()
    var listOfTextviewMul2 = arrayListOf<TextView?>()*/





    private fun styleTextViewTalk(tv: TextView, st: String, talker: Talker): TextView {
        val shape = GradientDrawable()
        shape.setCornerRadius(talker.radius)
        shape.setStroke(20, Color.parseColor(talker.borderColor))
        if (talker.colorBack == "none" || !talker.backExist) {
            shape.setColor(Color.TRANSPARENT)
            shape.setStroke(20, Color.TRANSPARENT)
        } else {
            try {
                shape.setColor(Color.parseColor(talker.colorBack))
                shape.setStroke(talker.borderWidth, Color.parseColor(talker.borderColor))
            } catch (e: Exception) {
                shape.setColor(Color.parseColor("#000000"))
            }
        }
        tv.background = shape

        try {
            tv.setTextColor(Color.parseColor(talker.colorText))
        } catch (e: Exception) {
            tv.setTextColor(Color.parseColor("#ffffff"))
        }

        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, talker.textSize)
        val font = pref.getFonts()
        tv.typeface = helper.getTypeFace(font)

        tv.setPadding(talker.padding[0], talker.padding[1], talker.padding[2], talker.padding[3])

     //   tv.setPadding(40, 40, 40, 40)
        tv.text = st.trim()

        return tv
    }

    private fun updateTitleTalkerSituation() {
        val talker = pref.currentTalk()
        val index = pref.getCurrentPage()
        with(talker) {
            val newTalkerDetails =
                "l=${takingArray.size}*sty=$styleNum*anim=$animNum*size=${textSize.toInt()}" +
                        "*bord=$borderWidth*dur=$dur sw=$swingRepeat"
            activity.tvAnimatinKind.text = newTalkerDetails
            activity.tvPage.text = index.toString()
            //  numTalker = index
        }
    }
   /* fun executeTalker( ) {
        updateTitleTalkerSituation()
       val talker=pref.currentTalk()
        helper.activateHowSpeaking()

        if (talker.whoSpeake == "man") {
            configManTextView(talker)

          // listOfTextview.clear()
           listOfTextview = arrayListOf(tv0, tv1, tv2, tv3, tv4, tv5)
            listOfTextview.removeAll(Collections.singleton(null))
        }

        if (talker.whoSpeake == "god") {
            configGodTextView(talker)
           // listOfTextview.clear()
           listOfTextview = arrayListOf(tv0, tv1, tv2, tv3, tv4, tv5)
           listOfTextview.removeAll(Collections.singleton(null))

           // listOfTextviewMul.clear()
            listOfTextviewMul = arrayListOf(tv0A)
           // listOfTextviewMul.removeAll(Collections.singleton(null))

           // listOfTextviewMul2.clear()
            listOfTextviewMul2 = arrayListOf(tv2A)
           // listOfTextviewMul2.removeAll(Collections.singleton(null))

        }

        letsMove(talker, listOfTextview, listOfTextviewMul, listOfTextviewMul2)

    }*/

     /*fun activateHowSpeaking(talker: Talker) {
        val anim = AnimatorInflater.loadAnimator(context, R.animator.alpha)

        if (showPosition) {
            if (talker.whoSpeake == "man") {
                activity.man_speaking_iv.visibility = View.VISIBLE
                activity.god_speaking_iv.visibility = View.INVISIBLE
                anim?.apply {
                    setTarget(activity.man_speaking_iv)
                    start()
                }
            } else {
                activity.god_speaking_iv.visibility = View.VISIBLE
                activity.man_speaking_iv.visibility = View.INVISIBLE
                anim?.apply {
                    setTarget(activity.god_speaking_iv)
                    start()
                }
            }
        } else {
            activity.god_speaking_iv.visibility = View.INVISIBLE
            activity.man_speaking_iv.visibility = View.INVISIBLE
        }
    }
    fun currentPage(): Int {
        var cu = pref.getCurrentPage()
        if (cu < 1 || cu >= talkList.size) {
            cu = 1
            pref.saveCurrentPage(cu)
        }
        return cu
    }*/

    private fun letsMove(
        talker: Talker, listOfTextview: ArrayList<TextView?>, listOfTextviewM: ArrayList<TextView?>,
        listOfTextviewM2: ArrayList<TextView?>
    ) {

        when (talker.animNum) {

            100,1000 -> Utile.moveScale110(talker, listOfTextview)

            10 -> Utile.move_swing(10, talker, listOfTextview)
            11 -> Utile.move_swing(11, talker, listOfTextview)
            12 -> Utile.move_swing(12, talker, listOfTextview)
            13 -> Utile.move_swing(13, talker, listOfTextview)
            14 -> Utile.move_swing(14, talker, listOfTextview)
            15 -> Utile.move_swing(15, talker, listOfTextview)

            20 -> Utile.scale_swing(20, talker, listOfTextview)
            21 -> Utile.scale_swing(21, talker, listOfTextview)
            22 -> Utile.scale_swing(22, talker, listOfTextview)
            23 -> Utile.scale_swing(23, talker, listOfTextview)
            24 -> Utile.scale_swing(24, talker, listOfTextview)
            25 -> Utile.scale_swing(25, talker, listOfTextview)

            30 -> Utile.move_scale(30, listOfTextview, talker.dur)
            31 -> Utile.move_scale(31, listOfTextview, talker.dur)
            32 -> Utile.move_scale(32, listOfTextview, talker.dur)
            33 -> Utile.move_scale(33, listOfTextview, talker.dur)
            34 -> Utile.move_scale(34, listOfTextview, talker.dur)
            35 -> Utile.move_scale(35, listOfTextview, talker.dur)


            40 -> Utile.move_scale_rotate(40, talker, listOfTextview)
            41 -> Utile.move_scale_rotate(41, talker, listOfTextview)
            42 -> Utile.move_scale_rotate(42, talker, listOfTextview)
            43 -> Utile.move_scale_rotate(43, talker, listOfTextview)
            44 -> Utile.move_scale_rotate(44, talker, listOfTextview)
            45 -> Utile.move_scale_rotate(45, talker, listOfTextview)
            46 -> Utile.move_scale_rotate(46, talker, listOfTextview)

            50 -> Utile.apeareOneAfterAnother(listOfTextview, talker)
            51 -> Utile.apeareOneAfterAnotherAndSwing(listOfTextview, talker)

             60 -> if (talker.whoSpeake == "god") {
                // Utile.godAppearFromTwoPlaces(0, listOfTextview, listOfTextviewM,talker.colorBack, dur)
                Utile.godAppearFromTwoPlaces(
                    0, talker, listOfTextview, listOfTextviewM, listOfTextviewM2
                )
            } else {
                Utile.move_swing(0, talker, listOfTextview)
                Toast.makeText(context, "Sorry It just for God", Toast.LENGTH_LONG).show()
            }
            61 -> if (talker.whoSpeake == "god") {
                Utile.godAppearFromTwoPlaces(
                    1,
                    talker,
                    listOfTextview,
                    listOfTextviewM,
                    listOfTextviewM2
                )
            }
            else -> Utile.move_swing(0, talker, listOfTextview)
        }
    }

    /*private fun operateBackgroundColor(talker: Talker) {
        if (talker.whoSpeake == "man") {
            var layout = R.layout.man_layout
        }
    }*/

    private fun configGodTextView(talker: Talker) {
        initTextview()
        initGodTextview(1)

        val arr = talker.takingArray
        val size = arr.size

        tv0 = styleTextViewTalk(god0, arr[0], talker)
        //  if (talker.animNum == 60) {
        tv0A = styleTextViewTalk(god0A, arr[0], talker)
        tv2A = styleTextViewTalk(god2A, arr[0], talker)
        //   } else {
        if (size > 1) tv1 = styleTextViewTalk(god1, arr[1], talker)
        if (size > 2) tv2 = styleTextViewTalk(god2, arr[2], talker)
        if (size > 3) tv3 = styleTextViewTalk(god3, arr[3], talker)
        if (size > 4) tv4 = styleTextViewTalk(god4, arr[4], talker)
        if (size > 5) tv5 = styleTextViewTalk(god5, arr[5], talker)
        //  }
        initManTextview(500)
    }

    private fun configManTextView(talker: Talker) {
        initTextview()
        initManTextview(1)
        /* val st = talker.taking
         val arr = st.split("\n")
         val size = talker.lines
 */
        val arr = talker.takingArray
        val size = arr.size
        if (size == 6) {
            tv0 = styleTextViewTalk(man0, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk(man1, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk(man2, arr[2], talker)
            if (size > 3) tv3 = styleTextViewTalk(man3, arr[3], talker)
            if (size > 4) tv4 = styleTextViewTalk(man4, arr[4], talker)
            if (size > 5) tv5 = styleTextViewTalk(man5, arr[5], talker)
        }
        if (size == 5) {
            tv0 = styleTextViewTalk(man1, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk(man2, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk(man3, arr[2], talker)
            if (size > 3) tv3 = styleTextViewTalk(man4, arr[3], talker)
            if (size > 4) tv4 = styleTextViewTalk(man5, arr[4], talker)
        }
        if (size == 4) {
            tv0 = styleTextViewTalk(man2, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk(man3, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk(man4, arr[2], talker)
            if (size > 3) tv3 = styleTextViewTalk(man5, arr[3], talker)
        }
        if (size == 3) {
            tv0 = styleTextViewTalk(man3, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk(man4, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk(man5, arr[2], talker)
        }
        if (size == 2) {
            tv0 = styleTextViewTalk(man4, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk(man5, arr[1], talker)
        }
        if (size == 1) {
            tv0 = styleTextViewTalk(man5, arr[0], talker)
        }
        initGodTextview(500)
    }

    private fun initGodTextview(dur: Long) {
        ViewAnimator
            .animate(god0, god2A, god0A, god1, god2, god3, god4, god5)
            .scale(0f)
            .duration(dur)
            .start()
    }

    private fun initManTextview(dur: Long) {
        ViewAnimator
            .animate(man0, man1, man2, man3, man4, man5)
            .scale(0f)
            .duration(dur)
            .start()
    }


    private fun initTextview() {
        tv0 = null
        tv0A = null
        tv2A = null
        tv1 = null
        tv2 = null
        tv3 = null
        tv4 = null
        tv5 = null
    }

    fun initAllTextview(dur: Long) {
        ViewAnimator
            .animate(man0, man1, man2, man3, man4, man5)
            .scale(0f)
            .duration(dur)
            .start()
        ViewAnimator
            .animate(god0, god0A, god2A, god1, god2, god3, god4, god5)
            .scale(0f)
            .duration(dur)
            .start()
    }

   /* private fun findStyleObject(index: Int): StyleObject {
        var style1 = StyleObject()
        var bo = true
        var i = 0
        while (bo && i < Helper.Page.styleArray.size) {

            if (Helper.Page.styleArray[i].numStyleObject == index) {
                style1 = Helper.Page.styleArray[i]
                bo = false
            }
            i++
        }
        if (bo) style1 = Helper.Page.styleArray[10]
        return style1
    }*/

    fun fadeDownAllMan(dur: Long) {

        ViewAnimator
            .animate(man0, man1, man2, man3, man4, man5)
            .scale(0f)
            .duration(dur)
            .start()
    }


    fun fadeDownAllGod(dur: Long) {
        ViewAnimator
            .animate(god0, god1, god0A, god2, god3, god4, god5)
            .scale(0f)
            .duration(dur)
            .start()
    }

}











