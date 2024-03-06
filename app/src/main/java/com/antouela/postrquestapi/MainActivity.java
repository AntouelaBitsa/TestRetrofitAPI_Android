package com.antouela.postrquestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView idTxt, fNameTxt, lNameTxt, proffTxt;
    private Doctor doctor;
    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting components
        idTxt = findViewById(R.id.idTextView);
        fNameTxt = findViewById(R.id.fNameTextView);
        lNameTxt = findViewById(R.id.lNameTextView);
        proffTxt = findViewById(R.id.proffTextView);

        //Calling inner method for Post Request Method
        Log.d("POST", "Calling runRetrofitPostRequest()");
//        runRetrofitPostRequest();

        //Calling inner method for Get Request Method
        Log.d("GET", "Calling runRetrofitGetRequest()");
        runRetrofitGetRequest();
    }

    private void runRetrofitGetRequest() {
        Log.d("MAIN ACTIVITY", "Get Request");
        Log.d("Main Activity", "Creating Retrofit Object");
        retrofitService = new RetrofitService();

        Log.d("Main Activity", "Creating docAPI");
        DocApi docAPI = retrofitService.getRetrofit().create(DocApi.class);

        Log.d("Main Activity", "Calling Endpoint with ENQUEUE");
        docAPI.getDoc(3).enqueue(new Callback<Doctor>() {
            @Override
            public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                Log.d("Main Activity", "inside callback and on response");

                if (!response.isSuccessful()) {
                    Log.d("Main Activity", "Inside the if for successful response");
                    Log.d("MAIN", "onResponse: " + response.code());
                    idTxt.setText(response.code());
                    fNameTxt.setText("onResponse");
                    lNameTxt.setText("onResponse");
                    proffTxt.setText("onResponse");
                    Log.d("Main Acivity on Response of POST request", response.message());
                }

                Log.d("Main Acctivity on Response", "Get the values from response in a doc object");
                Doctor docResponse = response.body();

                Log.d("On Response", "setting values in the variables");
                Integer id = docResponse.getId();
                String fName = docResponse.getfName();
                String lName = docResponse.getlName();
                String proffession = docResponse.getProff();


                Log.d("Main Acctivity on Response", "Set texts in components");
                idTxt.setText(String.valueOf(id));
                fNameTxt.setText(String.valueOf(fName));
                lNameTxt.setText(String.valueOf(lName));
                proffTxt.setText(String.valueOf(proffession));
            }

            @Override
            public void onFailure(Call<Doctor> call, Throwable t) {
                idTxt.setText(t.getMessage());
                fNameTxt.setText(call.toString());
                Log.d("On failure we get : ", t.getMessage());
                Log.d("FAILURE", call.toString());
            }
        });
    }

    private void runRetrofitPostRequest() {
        Log.d("MAIN ACTIVITY", "Get Request");

        Log.d("Main Activity", "Creating object of doctor");
        doctor = new Doctor("Antouela", "Bitsa", "Programmer");

        Log.d("Main Activity", "Creating Retrofit Object");
        retrofitService = new RetrofitService();

        Log.d("Main Activity", "Creating docAPI");
        DocApi docAPI = retrofitService.getRetrofit().create(DocApi.class);

        Log.d("Main Activity", "calling enqueue");
        docAPI.postDoc(doctor).enqueue(new Callback<Doctor>() {
            @Override
            public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                Log.d("Main Activity", "inside callback and on response");

                if (!response.isSuccessful()) {
                    Log.d("Main Activity", "Inside the if for successful response");
                    Log.d("MAIN", "onResponse: " + response.code());
                    idTxt.setText(response.code());
                    fNameTxt.setText("onResponse");
                    lNameTxt.setText("onResponse");
                    proffTxt.setText("onResponse");
                    Log.d("Main Acivity on Response of POST request", response.message());
                }

                Log.d("Main Acctivity on Response", "Get the values from response in a doc object");
                Doctor docResponse = response.body();

                Log.d("On Response", "setting values in the variables");
                Integer id = docResponse.getId();
                String fName = docResponse.getfName();
                String lName = docResponse.getlName();
                String proffession = docResponse.getProff();


                Log.d("Main Acctivity on Response", "Set texts in components");
                idTxt.setText(String.valueOf(id));
                fNameTxt.setText(String.valueOf(fName));
                lNameTxt.setText(String.valueOf(lName));
                proffTxt.setText(String.valueOf(proffession));

            }

            @Override
            public void onFailure(Call<Doctor> call, Throwable t) {
                idTxt.setText(t.getMessage());
                fNameTxt.setText(call.toString());
                Log.d("On failure we get : ", t.getMessage());
                Log.d("FAILURE", call.toString());
            }
        });
    }
}