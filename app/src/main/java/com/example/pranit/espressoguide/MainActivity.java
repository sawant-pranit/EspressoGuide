package com.example.pranit.espressoguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recvHome;
    private String[] list = new String[]{"Basic", "Custom Matcher", "Data Adapter",
            "Idling Resource", "Intent Advanced", "Intent Basic", "Multi-Process", "Multi-window", "RecyclerView", "WebView"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recvHome = findViewById(R.id.recv_home);


    }

    public static class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder>{
        private OnItemClickListener listener;
        private String [] array;

        public HomeAdapter(String[] array, OnItemClickListener listener) {
            this.listener = listener;
            this.array = array;
        }

        @Override
        public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(HomeHolder holder, int position) {
            holder.bind(position, listener);
        }

        @Override
        public int getItemCount() {
            return array.length;
        }

        static class HomeHolder extends RecyclerView.ViewHolder {
            TextView lblTitle;

            public HomeHolder(View itemView) {
                super(itemView);
                lblTitle = itemView.findViewById(R.id.lbl_titles);
            }

            public void bind(final int position, final OnItemClickListener listener) {
                lblTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(position);
                    }
                });
            }
        }
    }
}
