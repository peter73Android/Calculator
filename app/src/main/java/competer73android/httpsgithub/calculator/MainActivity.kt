package competer73android.httpsgithub.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = false

    fun numberEditing(view:View) {
        if (isNewOp) {
            Text.setText("")
            isNewOp=false
        }

        val buSelect = view as Button
        var buClickValue:String = Text.text.toString()
        when (buSelect.id) {
            buZero.id->{
                if (buClickValue.length > 0) {
                    buClickValue += "0"
                }
            }
            buOne.id->{
                buClickValue+="1"
            }
            buTwo.id->{
                buClickValue+="2"
            }
            buThree.id->{
                buClickValue+="3"
            }
            buFour.id->{
                buClickValue+="4"
            }
            buFive.id->{
                buClickValue+="5"
            }
            buSix.id->{
                buClickValue+="6"
            }
            buSeven.id->{
                buClickValue+="7"
            }
            buEight.id->{
                buClickValue+="8"
            }
            buNine.id->{
                buClickValue+="9"
            }
            buDot.id->{
                if (!buClickValue.contains('.')) {
                    if(buClickValue.length == 0) {
                        buClickValue += "0."
                    } else { buClickValue+="." }

                }
            }
            /*buAC.id->{
                buClickValue=""
            }*/
            buPluMin.id->{
                if (buClickValue.isNotEmpty()) {
                    if (buClickValue.contains('.')) {
                        buClickValue = (buClickValue.toDouble() * -1).toString()
                    } else {
                        buClickValue = (buClickValue.toInt() * -1).toString()
                    }
                }
            }

        }
        Text.setText(buClickValue)
    }

    fun operatorEvent(view:View) {
        var buSelect = view as Button
        when (buSelect.id) {
            buMult.id -> {
                op = "*"
                // Text.setText(Text.text.toString() + op)
            }
            buDev.id -> {
                op = "/"
                // Text.setText(Text.text.toString() + op)
            }
            buPlus.id -> {
                op = "+"
                // Text.setText(Text.text.toString() + op)
            }
            buSub.id -> {
                op = "-"
                // Text.setText(Text.text.toString() + op)
            }
        }
        oldNumber = Text.text.toString()
        isNewOp = true
    }

    fun equalPressed(view:View) {
        val newNumber = Text.text.toString()
        var finalNumber = 0.1
        //finalNumber = oldNumber.toDouble()
        when(op) {

            "*"->{
                finalNumber = oldNumber.toDouble() *newNumber.toDouble()
            }
            "/"->{
                finalNumber = oldNumber.toDouble() /newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() +newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() -newNumber.toDouble()
            }
        }
        isNewOp = true
        Text.setText(finalNumber.toString())
    }

    fun buPercent(view:View){
        val number:Double=Text.text.toString().toDouble()/100

        Text.setText(number.toString())
        isNewOp=true

    }

    fun buClean(view:View){
        Text.setText("0")
        isNewOp=true
    }
}
