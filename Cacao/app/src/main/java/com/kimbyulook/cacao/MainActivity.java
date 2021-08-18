package com.kimbyulook.cacao;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kimbyulook.cacao.adapter.ChattAdapter;
import com.kimbyulook.cacao.adapter.service.FirebaseServiceImplV1;
import com.kimbyulook.cacao.model.Chatt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txt_msg;
    private AppCompatButton btn_send;

    private RecyclerView chat_list_view;
    private ChattAdapter chattAdapter;

    private List<Chatt> chattList;

    private DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);

        chattList = new ArrayList<>();

        chattAdapter = new ChattAdapter(chattList);

        chat_list_view.setAdapter(chattAdapter);

        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();

        dbRef = dbConn.getReference("chatting");

        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);


        dbRef.addChildEventListener(childEventListener);

        btn_send.setOnClickListener(view->{
            String msg = txt_msg.getText().toString();
            if(msg != null && !msg.isEmpty()){
                String toastMsg = String.format("메시지: %s", msg);

                Chatt chattVO = new Chatt();
                chattVO.setMsg(msg);
                chattVO.setName("하이룽");

                Log.d("클릭",chattVO.toString());

                dbRef.push().setValue(chattVO);
                txt_msg.setText("");
            }
        });

    }
}