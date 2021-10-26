package com.example.doanchuyennganh.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.doanchuyennganh.Adapter.LoaispAdapter;
import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.model.Loaisp;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ArrayList mangloaisp;
    ImageView imageView;
    DrawerLayout drawerLayout;
    LoaispAdapter loaispAdapter;
    ListView listviewmanhinhchinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Anhxa();
        ActionBar();
        Menu();
    }

    private void Menu() {
        mangloaisp.add(new Loaisp(0,"NGƯỜI DÙNG"));
        mangloaisp.add(new Loaisp(0,"MUA GÓI THÀNH VIÊN"));
        mangloaisp.add(new Loaisp(0,"GÓP Ý"));
        mangloaisp.add(new Loaisp(0,"KHO VIDEO"));
        mangloaisp.add(new Loaisp(0,"CÀI ĐẶT"));
        mangloaisp.add(new Loaisp(0,"LIÊN HỆ"));
        mangloaisp.add(new Loaisp(0,"ĐĂNG XUẤT"));
    }

    private void Anhxa() {
        imageView = findViewById(R.id.img_caidat_home);
        drawerLayout = findViewById(R.id.drawerLayout);
        listviewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
        mangloaisp = new ArrayList();
        loaispAdapter = new LoaispAdapter(mangloaisp,getApplicationContext());
        listviewmanhinhchinh.setAdapter(loaispAdapter);
    }

    private void ActionBar() {

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

    }

}