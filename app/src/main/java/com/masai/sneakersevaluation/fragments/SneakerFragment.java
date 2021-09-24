package com.masai.sneakersevaluation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masai.sneakersevaluation.Adapters.sneakerAdapter;
import com.masai.sneakersevaluation.Models.ResponseModel;
import com.masai.sneakersevaluation.Models.ResponseModelItem;
import com.masai.sneakersevaluation.Network.ApiService;
import com.masai.sneakersevaluation.Network.Network;
import com.masai.sneakersevaluation.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SneakerFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ResponseModelItem> modelList = new ArrayList<>();
    private sneakerAdapter sneakerAdapter;
    private ResponseModel responseModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        setRecyclerView();
        callApi();
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getSneakers().enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
              if(response.body().size()>0){

                List<ResponseModel> responseModels = new ArrayList<>(response.body());


              }

            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        sneakerAdapter = new sneakerAdapter(modelList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sneakerAdapter);


    }
}