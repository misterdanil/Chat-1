package com.example.lovelychecker;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "MainActivity";
    RecyclerView prodList;
    MessageAdapter messageAdapter;

    ImageButton find;
    EditText finder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_window);



        View view = findViewById(R.id.button_gchat_send);
        view.setOnClickListener((e) -> {
            EditText messageEditText = (EditText)findViewById(R.id.edit_gchat_message);

            String text = messageEditText.getText().toString();

            interfaceAPI apiService = RetrofitClientInstance.getInstance();

            Call<Void> call = apiService.sendMessage("6435ce493572c97e7243c5cd", MultipartBody.Part.createFormData("text", text), null, RetrofitClientInstance.ACCESS_TOKEN);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()) {
                        messageEditText.setText("");
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Возникла ошибка, попробуйте позже",
                                Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Не удалось отправить сообщение, " +
                            "проверьте соединение с интернетом", Toast.LENGTH_LONG).show();
                }
            });
        });

        List<Message> item = new ArrayList<>();

//        Message message = new Message();
//        message.setText("Xiaomi note 5");
//        message.setUser(new User("6435cd643572c97e7243c5cb", "John", "Cena", "Star"));
//        item.add(message);
//
//        Message message1 = new Message();
//        message1.setText("Xiaomi note 5");
//        message1.setUser(new User("6435cd043572c97e7243c5c9", "John", "Cena", "Star"));
//        item.add(message1);
//
//        Message message3 = new Message();
//        message3.setText("Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5");
//        message3.setUser(new User("6435cd643572c97e7243c5cb", "John", "Cena", "Star"));
//        item.add(message3);
//
//        Message message4 = new Message();
//        message4.setText("Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5");
//        message4.setUser(new User("6435cd643572c97e7243c5cb", "John", "Cena", "Star"));
//        item.add(message4);
//
//        Message message5 = new Message();
//        message5.setText("Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5");
//        message5.setUser(new User("6435cd043572c97e7243c5c9", "John", "Cena", "Star"));
//        item.add(message5);
//
//        Message message6 = new Message();
//        message6.setText("Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5Xiaomi note 5" +
//                "Xiaomi note 5Xiaomi note 5");
//        message6.setUser(new User("6435cd043572c97e7243c5c9", "John", "Cena", "Star"));
//        item.add(message6);
//
//        setProductRecylder(item);

        interfaceAPI apiService = RetrofitClientInstance.getInstance();

        Call<List<Message>> call = apiService.getMessages("6435ce493572c97e7243c5cd");

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if(response.isSuccessful()) {
                    List<Message> messages = response.body();
                    messages.forEach(message2 -> {
                        item.add(message2);
                    });

                    setProductRecylder(item, "6435ce493572c97e7243c5cd");

                }
                else {
                    System.out.println(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                System.err.println("fail");
            }
        });
    }

    private void setProductRecylder(List<Message> item, String chatId) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        prodList = findViewById(R.id.prodList);
        prodList.setLayoutManager(layoutManager);

        messageAdapter = new MessageAdapter(this, item, prodList);

        messageAdapter.new RetrieveFeedTask(this, messageAdapter).execute(chatId);

        prodList.setAdapter(messageAdapter);

        prodList.scrollToPosition(item.size() - 1);
    }

    public void find(View view){
        String text = finder.getText().toString();
        //Вставить функцию поиска через сервер
    }
}
