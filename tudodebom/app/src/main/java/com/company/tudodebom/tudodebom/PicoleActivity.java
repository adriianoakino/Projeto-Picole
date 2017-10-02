package com.company.tudodebom.tudodebom;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import Model.CarrinhoComprasModel;

public class PicoleActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;

    private Button logout;

    private static ListView mListView;

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picole);

        mListView = (ListView) findViewById(R.id.listPicole);

        PicoleActivity.CustomAdaptador customAdaptador = new PicoleActivity.CustomAdaptador();
        mListView.setAdapter(customAdaptador);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PicoleActivity.this, " Set:" + position, Toast.LENGTH_SHORT).show();
                QuantidadePicoleActivity.idPicole = position;
                startActivity(new Intent(PicoleActivity.this, QuantidadePicoleActivity.class));

            }
        });



        //logout = (Button) findViewById(R.id.btnlogout);


       /* logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });*/
    }


    class CustomAdaptador extends BaseAdapter {

        CarrinhoComprasModel model = new CarrinhoComprasModel();
        @Override
        public int getCount() {
            return model.getImages().length;
        }

        @Override
        public Object getItem(int position) {

            return null;
        }

        @Override
        public long getItemId(int position) {

            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listview_picole, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.textName);
            imageView.setImageResource(model.getImages()[position]);
            textView.setText(model.getNomes()[position]);
            return view;
        }


    }


    private void logout() {

        progressDialog.setMessage("Saindo do Sistema");
        progressDialog.show();
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(PicoleActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
