package com.example.vatlythpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class QuizActivity extends AppCompatActivity {

    RadioButton ansA, ansB, ansC, ansD;
    Button b_Check;
    TextView ques;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference docRef = db.collection("vatly12").document("121");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ques = findViewById(R.id.textView);
        ansA = findViewById(R.id.radioButton);
        ansB = findViewById(R.id.radioButton2);
        ansC = findViewById(R.id.radioButton3);
        ansD = findViewById(R.id.radioButton4);
        b_Check = findViewById(R.id.button_Check);

        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    ques.setText(document.getData().toString());
                }
            }
        });

    }
}