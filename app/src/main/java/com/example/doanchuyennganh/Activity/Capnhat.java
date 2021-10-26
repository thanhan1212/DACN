package com.example.doanchuyennganh.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.model.Account;
import com.example.doanchuyennganh.model.Chinhsua;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Capnhat extends AppCompatActivity {

    EditText edthoten, edtngaythangnamsinh, edtgioitinh, edtsodienthoai, edtmail;
    Button btncapnhat;
    private Account account;
    private boolean isEnabled;

    public static final String url = "https://doanchuyennghanh.000webhostapp.com/update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhat);

        Intent intent = getIntent();
        account = new Account();
        account = (Account) intent.getSerializableExtra("login");

        AnhXa();
    }
    private void enableControl(){
        edtmail.setEnabled(isEnabled);
        edthoten.setEnabled(isEnabled);
        edtngaythangnamsinh.setEnabled(isEnabled);
        edtgioitinh.setEnabled(isEnabled);
        edtsodienthoai.setEnabled(isEnabled);
        edtmail.setEnabled(isEnabled);
    }

    private void AnhXa() {
        edthoten = (EditText) findViewById(R.id.edt_hovaten_cn);
        edtngaythangnamsinh = (EditText) findViewById(R.id.edt_ngaythangnamsinh_cn);
        edtgioitinh = (EditText) findViewById(R.id.edt_gioitinh_cn);
        edtsodienthoai = (EditText) findViewById(R.id.edt_sodienthoai_cn);
        edtmail = (EditText) findViewById(R.id.edt_mail_cn);
        btncapnhat = (Button) findViewById(R.id.btn_capnhat_cn);


        edthoten.setText(account.getHovaten());
        edtsodienthoai.setText(account.getSdt());
        edtmail.setText(account.getGmail());
        enableControl();
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEnabled = !isEnabled;
                enableControl();
                if (isEnabled){
                    btncapnhat.setText("Lưu");
                }
                else{
                    btncapnhat.setText("Cập nhật");
                }

                String hoten = edthoten.getText().toString().trim();
                String ngaythangnamsinh = edtngaythangnamsinh.getText().toString().trim();
                String gioitinh = edtgioitinh.getText().toString().trim();
                String sodienthoai = edtsodienthoai.getText().toString().trim();
                String mail = edtmail.getText().toString().trim();
                CapNhatTaiKhoan(url);
            }
        });
    }

    private void CapNhatTaiKhoan(final String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")){


                            // GetData(url);
                            Toast.makeText(Capnhat.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(Capnhat.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Capnhat.this, "Vui lòng thử lại", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("IDTK",account.getIdtk());
                params.put("Hovaten", edthoten.getText().toString().trim());
                params.put("ngaythangnamsinh", edtngaythangnamsinh.getText().toString().trim());
                params.put("gioitinh", edtgioitinh.getText().toString().trim());
                params.put("Sdt", edtsodienthoai.getText().toString().trim());
                params.put("Mail", edtmail.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
