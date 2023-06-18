package com.mamoru.roulette7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // ルーレットの項目を保持するための配列やリストを定義する
    val items = mutableListOf("A", "B", "C", "D", "E")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI部品とプログラムを関連付ける
        val textView = findViewById<TextView>(R.id.textView)
        val playButton = findViewById<Button>(R.id.playButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val editText = findViewById<EditText>(R.id.editText)

        // 「Play」ボタンが押されたときに、ランダムなインデックスを生成して、配列やリストから対応する項目を取り出してTextViewに表示する処理を書く
        playButton.setOnClickListener {
            val randomIndex = (0 until items.size).random()
            val selectedItem = items[randomIndex]
            textView.text = selectedItem
        }

        // 項目を追加するための「Add」ボタンが押されたときに、テキストフィールドから入力された文字列を配列やリストに追加する処理を書く
        addButton.setOnClickListener {
            val inputText = editText.text.toString()
            if (inputText.isNotEmpty() && items.size < 10) {
                items.add(inputText)
                editText.text.clear()
                Toast.makeText(this, "Item added: $inputText", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Cannot add item", Toast.LENGTH_SHORT).show()
            }
        }

        // 項目を削除するための「Delete」ボタンが押されたときに、テキストフィールドから入力された文字列を配列やリストから削除する処理を書く
        deleteButton.setOnClickListener {
            val inputText = editText.text.toString()
            if (inputText.isNotEmpty() && items.contains(inputText)) {
                items.remove(inputText)
                editText.text.clear()
                Toast.makeText(this, "Item deleted: $inputText", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Cannot delete item", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
