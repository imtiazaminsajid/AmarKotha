package com.example.imtiazaminsajid;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.imtiazaminsajid.Adapter.CustomAdapter;
import com.example.imtiazaminsajid.Helper.HttpDataHandler;
import com.example.imtiazaminsajid.Models.ChatModels;
import com.example.imtiazaminsajid.Models.SimsimiModels;
import com.google.gson.Gson;

import java.nio.channels.AsynchronousByteChannel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    List<ChatModels> list_chat = new ArrayList<>();
    FloatingActionButton floatingActionButton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_of_message);
        editText =  findViewById(R.id.user_message);
        floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                ChatModels model = new ChatModels(text, true);
                list_chat.add(model);
                new SimsimiAPI().execute(list_chat);

                editText.setText(" ");

            }
        });
    }

    public class SimsimiAPI extends AsyncTask<List<ChatModels>,Void,String>{

        String stream = null;
        List<ChatModels> models;
        String text  =  editText.getText().toString();


        @Override
        protected String doInBackground(List<ChatModels>[] lists) {
            String url = String.format("http://sandbox.api.simsimi.com/request.p?key=your_trial_key&lc=en&ft=1.0&text=hi", getString(R.string.simsimi_api),text);

            models = lists[0];
            HttpDataHandler httpDataHandler = new HttpDataHandler();
            stream = httpDataHandler.GetHTTPData(url);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            SimsimiModels response =  gson.fromJson(s, SimsimiModels.class);

            ChatModels chatModels = new ChatModels(response.getResponse(),false);
            models.add(chatModels);
            CustomAdapter adapter = new CustomAdapter(models,getApplicationContext());
            listView.setAdapter(adapter);

        }
    }


}
