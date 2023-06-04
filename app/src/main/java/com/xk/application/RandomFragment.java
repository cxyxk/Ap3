package com.xk.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RandomFragment extends Fragment implements RandomView {

    private RecyclerView recyclerView;

    private RandomPresenter presenter;

    private RandomAdapter adapter;

    public static RandomFragment newInstance() {
        return new RandomFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        presenter = new RandomPresenterImpl(requireContext(), this);

        adapter = new RandomAdapter(presenter.getData());
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.button);
        EditText seedEditText = view.findViewById(R.id.seed_edit_text);
        EditText rangeEditText = view.findViewById(R.id.range_edit_text);

        button.setOnClickListener(v -> {
            String seed = seedEditText.getText().toString();
            String range = rangeEditText.getText().toString();
            presenter.generateRandom(seed, range);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    @Override
    public void onGenerateRandom(int seed, int range) {
        adapter.notifyItemInserted(adapter.getItemCount() - 1);
    }

    @Override
    public void onSaveRandom(ArrayList<RandomItem> randomList) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onQueryRandom(ArrayList<RandomItem> dataList) {

    }

    @Override
    public void onShowQueryDialog() {

    }

    @Override
    public void onDismissQueryDialog() {

    }

}
