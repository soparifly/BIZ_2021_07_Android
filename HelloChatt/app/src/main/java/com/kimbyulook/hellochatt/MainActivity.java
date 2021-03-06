package com.kimbyulook.hellochatt;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kimbyulook.hellochatt.adpter.ChattAdapter;
import com.kimbyulook.hellochatt.model.Chatt;
import com.kimbyulook.hellochatt.service.FirebaseServiceImplV1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //  chatt메시지를 전달하는 view들
    private EditText txt_msg;
    private AppCompatButton btn_send;
    //  chatt메시지를 표현할 view들
    private RecyclerView chat_list_view;
    private ChattAdapter chattAdapter;
    private List<Chatt> chattList;
    //firebase와 연결하는 Connecntion 을 위한 객체 선언하기
    private DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        액티비티메인을 불러와서 화면전체에 불러온다
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chat_list_view);

        chattList = new ArrayList<>();

//     1. Adapter 객체를 생성할때 보여줄 데이터 객체를
//        생성자 매개변수로 주입해주어야한다
        chattAdapter = new ChattAdapter(chattList);

//     2. RecyclerView.Adapter와 RecylceView를 서로연결
        chat_list_view.setAdapter(chattAdapter);

//     3. RecyclerView의 데이터를 표현하는데 사용할
//         Layout매니저를 설정하기
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();

//        사용할 table(path)
//        realtimeDatabase에서는 table 을 path라는 개념으로 부른다
        dbRef = dbConn.getReference("chatting");

//        firebase로 부터 데이터 변화 이벤트가 전달되면
//        이벤트를 수신하여 할일을 지정하기

        ChildEventListener childEventListener
                =new FirebaseServiceImplV1(chattAdapter);
        dbRef.addChildEventListener(childEventListener);
        chattList = new ArrayList<Chatt>();
/*
        Chatt chatt = new Chatt();
        chatt.setName("홍길동");
        chatt.setMsg("반갑습니다");
        chattList.add(chatt);

        chatt = new Chatt();
        chatt.setName("성춘향");
        chatt.setMsg("안녕하세요");
        chattList.add(chatt);

        chatt = new Chatt();
        chatt.setName("이몽룡");
        chatt.setMsg("누구신지");
        chattList.add(chatt);
*/


      /*
        EditBox 에 메시지를 입력하고 Send버튼을 클릭했을때
        EditBox에 메시지를 입력하고 Send를 하면
        Firebase의 Realtime DataBase에 데이터를 insert하기

     */
        btn_send.setOnClickListener(view -> {
            //EditBox에 입력된 문자열을 추출하여 문자열 변수에 담기
            String msg = txt_msg.getText().toString();
            if (msg != null && !msg.isEmpty()) {

                String toastMsg = String.format("메시지: %s", msg);
                Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();


                Chatt chatVO = new Chatt();
                chatVO.setMsg(msg);
                chatVO.setName("홍길동");

                Log.d("클릭",chatVO.toString());
//                chattList.add(chatVO);
//                firebase의 realtime DB table 에 데이터를 insert하라
//                push하라
                dbRef.push().setValue(chatVO);
                txt_msg.setText("");
            }
        });
    }
}