package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var hasNatija = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btn0.setOnClickListener(View.OnClickListener {
            if (binding.txtEkran.text != "0") {
                binding.txtEkran.text = "${binding.txtEkran.text}0"
            }

        })

        binding.btn1.setOnClickListener {
            raqamYozish(1)

        }

        binding.btn2.setOnClickListener {
            raqamYozish(2)

        }

        binding.btn3.setOnClickListener {
            raqamYozish(3)

        }

        binding.btn4.setOnClickListener {
            raqamYozish(4)
        }

        binding.btn5.setOnClickListener {
            raqamYozish(5)

        }

        binding.btn6.setOnClickListener {
            raqamYozish(6)

        }

        binding.btn7.setOnClickListener {
            raqamYozish(7)

        }

        binding.btn8.setOnClickListener {
            raqamYozish(8)

        }

        binding.btn9.setOnClickListener {
            raqamYozish(9)

        }


        binding.btnNuqta.setOnClickListener {
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
                val matn = binding.txtEkran.text.toString().subSequence(amalIndex, ekranLength)
                if (!matn.contains('.')) {
                    binding.txtEkran.text = "${binding.txtEkran.text}."
                }
            }
        }

        binding.btnAc.setOnClickListener {
            binding.txtEkran.text = "0"
            hasNatija = false

        }

        binding.btnDelete.setOnClickListener {
            val a = binding.txtEkran.text
            if (a.length == 1 || a == "-") {
                binding.txtEkran.text = "0"
            } else
                binding.txtEkran.text = a.subSequence(0, a.length - 1)
        }


        binding.btnQoshish.setOnClickListener {
            amalYozish("+")
        }

        binding.btnAyirish.setOnClickListener {
            amalYozish("-")
        }

        binding.btnKopaytirish.setOnClickListener {
            amalYozish("*")
        }

        binding.btnBolish.setOnClickListener {
            amalYozish("/")
        }

        binding.btnTeng.setOnClickListener {
            if (hasNatija == false) hisoblash()
        }
    }


    fun raqamYozish(raqam: Int) {

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

    fun amalYozish(amalArg: String) {
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


    fun hisoblash() {

        var sonlar = ArrayList<Double>()
        var amallar = ArrayList<Int>()

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