package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

@SuppressLint("ClickableViewAccessibility", "SetTextI18n", "ResourceAsColor")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var hasNatija = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btn0.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn0.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    if (binding.txtEkran.text != "0") {
                        binding.txtEkran.text = "${binding.txtEkran.text}0"
                    }
                    Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()

                    binding.btn0.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn1.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn1.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(1)

                    binding.btn1.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn2.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn2.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(2)

                    binding.btn2.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn3.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn3.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(3)

                    binding.btn3.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn4.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn4.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(4)

                    binding.btn4.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn5.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn5.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(5)

                    binding.btn5.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn6.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn6.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(6)

                    binding.btn6.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn7.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn7.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(7)

                    binding.btn7.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn8.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn8.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(8)

                    binding.btn8.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btn9.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btn9.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    raqamYozish(9)

                    binding.btn9.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })


        binding.btnNuqta.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnNuqta.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    val misol = binding.txtEkran.text.toString()
                    var amalIndex = -1
                    for (i in misol.indices) {
                        if (misol[i] == '+' || misol[i] == '-' || misol[i] == '*' || misol[i] == '/') {
                            amalIndex = i
                        }
                    }
                    if (amalIndex == -1) {
                        if (!binding.txtEkran.text.toString().contains('.')) {
                            binding.txtEkran.text = "${binding.txtEkran.text}."
                        }
                    } else {
                        val ekranLength = binding.txtEkran.text.length
                        val matn =
                            binding.txtEkran.text.toString().subSequence(amalIndex, ekranLength)
                        if (!matn.contains('.')) {
                            binding.txtEkran.text = "${binding.txtEkran.text}."
                        }
                    }

                    binding.btnNuqta.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnAc.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnAc.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    binding.txtEkran.text = "0"
                    hasNatija = false

                    binding.btnAc.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnDelete.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnDelete.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    val a = binding.txtEkran.text
                    if (a.length == 1 || a == "-") {
                        binding.txtEkran.text = "0"
                    } else
                        binding.txtEkran.text = a.subSequence(0, a.length - 1)

                    binding.btnDelete.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnQoshish.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnQoshish.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    amalYozish("+")

                    binding.btnQoshish.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnAyirish.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnAyirish.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    amalYozish("-")

                    binding.btnAyirish.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnKopaytirish.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnKopaytirish.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    amalYozish("*")

                    binding.btnKopaytirish.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnBolish.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnBolish.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    amalYozish("/")

                    binding.btnBolish.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.btnTeng.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.btnTeng.setShapeType(1)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {

                    if (!hasNatija) hisoblash()

                    binding.btnTeng.setShapeType(0)
                    return@OnTouchListener true
                }
            }
            false
        })

    }


    private fun raqamYozish(raqam: Int) {

        if (hasNatija) {
            binding.txtEkran.text = "$raqam"
            hasNatija = false
        } else {

            val r = raqam.toString()
            if (binding.txtEkran.text == "0") {
                binding.txtEkran.text = r
            } else {
                binding.txtEkran.text = "${binding.txtEkran.text}$r"
            }
        }
        binding.scrollView.scrollBy(100, 100)
    }

    private fun amalYozish(amalArg: String) {
        if (hasNatija) {
            val misol = binding.txtEkran.text.toString()
            for (i in misol.indices) {
                if (misol[i] == '=') {
                    binding.txtEkran.text = "${misol.subSequence(i + 1, misol.length)}$amalArg"
                    break
                }
            }
            hasNatija = false
        } else {
            binding.txtEkran.text = "${binding.txtEkran.text}$amalArg"
        }
        binding.scrollView.scrollBy(100, 100)
    }


    private fun hisoblash() {

        val sonlar = ArrayList<Double>()
        val amallar = ArrayList<Int>()

        val misol = binding.txtEkran.text.toString()

        var index1 = 0
        for (i in misol.indices) {
            if (amallar.isEmpty()) {
                when (misol[i]) {
                    '+' -> {
                        sonlar.add(misol.subSequence(index1, i).toString().toDouble())
                        amallar.add(0)
                        index1 = i
                    }
                    '-' -> {
                        sonlar.add(misol.subSequence(index1, i).toString().toDouble())
                        amallar.add(1)
                        index1 = i
                    }
                    '*' -> {
                        sonlar.add(misol.subSequence(index1, i).toString().toDouble())
                        amallar.add(2)
                        index1 = i
                    }
                    '/' -> {
                        sonlar.add(misol.subSequence(index1, i).toString().toDouble())
                        amallar.add(3)
                        index1 = i
                    }
                }
            } else {
                when (misol[i]) {
                    '+' -> {
                        sonlar.add(misol.subSequence(index1 + 1, i).toString().toDouble())
                        amallar.add(0)
                        index1 = i
                    }
                    '-' -> {
                        sonlar.add(misol.subSequence(index1 + 1, i).toString().toDouble())
                        amallar.add(1)
                        index1 = i
                    }
                    '*' -> {
                        sonlar.add(misol.subSequence(index1 + 1, i).toString().toDouble())
                        amallar.add(2)
                        index1 = i
                    }
                    '/' -> {
                        sonlar.add(misol.subSequence(index1 + 1, i).toString().toDouble())
                        amallar.add(3)
                        index1 = i
                    }
                }
            }
        }

        sonlar.add(misol.subSequence(index1 + 1, misol.length).toString().toDouble())

        var count = 0
        var natija = sonlar.first()
        while (count < amallar.size) {

            when (amallar[count]) {
                0 -> {
                    natija += sonlar[count + 1]
                }
                1 -> {
                    natija -= sonlar[count + 1]
                }
                2 -> {
                    natija *= sonlar[count + 1]
                }
                3 -> {
                    natija /= sonlar[count + 1]
                }
            }

            count++
        }

        val intNatija: Int = natija.toInt()
        if (natija / intNatija == 1.0) {
            binding.result.text = "$intNatija"
        } else {
            binding.result.text = "$natija"
        }
        hasNatija = true
        val maxScrollAmount = binding.scrollView.maxScrollAmount
        binding.scrollView.scrollBy(maxScrollAmount, maxScrollAmount)
        binding.scrollView.scrollBy(maxScrollAmount, maxScrollAmount)
        println(maxScrollAmount)
    }
}