package com.example.rakesh.movietrailers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    ArrayList<Details> arrayList;
    MyAdapter1 m;
    Details details;

    public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder>{

        @NonNull
        @Override
        public MyAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.row,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter1.ViewHolder holder, int position) {
            Details details = arrayList.get(position);

            holder.textView1.setText("Name: "+details.getName());
            holder.textView2.setText("Director: "+details.getDirector());
            holder.textView3.setText("Artists: "+details.getArtists());
            holder.imageView.setImageResource(details.getPoster());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView1,textView2,textView3;
            public ImageView imageView;
            public LinearLayout layout;

            public ViewHolder(View itemView) {
                super(itemView);
                textView1 = itemView.findViewById(R.id.textView1);
                textView2 = itemView.findViewById(R.id.textView2);
                textView3 = itemView.findViewById(R.id.textView3);
                imageView = itemView.findViewById(R.id.imageView1);
                layout = itemView.findViewById(R.id.linearLayout);

                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = getAdapterPosition();
                        details = arrayList.get(pos);
                        Toast.makeText(MainActivity.this, details.getName()+": Trailer", Toast.LENGTH_SHORT).show();

                        goTOTrailer();
                    }
                });
            }
        }
    }


    private void goTOTrailer() {
        Intent intent = new Intent(this,Main2Activity.class);
        if (details.getName().equals("Avengers Infinity War")){
            intent.putExtra("movie","6ZfuNTqbHE8");
        }
        if (details.getName().equals("Thor-Ragnorak")){
            intent.putExtra("movie","ue80QwXMRHg");
        }
        if (details.getName().equals("Ant-man 2")){
            intent.putExtra("movie","UUkn-enk2RU");
        }
        if (details.getName().equals("Deadpool 2")){
            intent.putExtra("movie","D86RtevtfrA");
        }
        if (details.getName().equals("Jurassic world")){
            intent.putExtra("movie","1FJD7jZqZEk");
        }
        if (details.getName().equals("Mission Impossible Fallout")){
            intent.putExtra("movie","wb49-oV0F78");
        }
        if (details.getName().equals("Venom")){
            intent.putExtra("movie","u9Mv98Gr5pY");
        }
        if (details.getName().equals("Aquaman")){
            intent.putExtra("movie","WDkg3h8PCVU");
        }
        if (details.getName().equals("The predator")){
            intent.putExtra("movie","12-wsx1fjcg");
        }
        if (details.getName().equals("First Man")){
            intent.putExtra("movie","PSoRx87OO6k");
        }
        if (details.getName().equals("Slender Man")){
            intent.putExtra("movie","eRV-c3hs3vw");
        }
        if (details.getName().equals("Purge")){
            intent.putExtra("movie","UL29y0ah92w");
        }

        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isConnected(MainActivity.this)) buildDialog(MainActivity.this).show();

        recyclerView = findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        arrayList = new ArrayList <Details>();

        Details details1 = new Details(R.drawable.purge,"Purge","Gerard McMurray","Y'lan Noel, Y'lan Noel");
        Details details2 = new Details(R.drawable.slenderman,"Slender Man","Sylvain White","Joey King, Javier Botet");
        Details details3 = new Details(R.drawable.firstman,"First Man","Damien Chazelle","Ryan Gosling, Claire Foy");
        Details details4 = new Details(R.drawable.predator,"The predator","Shane Black","Boyd Holbrook, Olivia Munn");
        Details details5 = new Details(R.drawable.aquaman,"Aquaman","James Wan","Jason Momoa, Amber Heard");
        Details details6 = new Details(R.drawable.venom,"Venom","Ruben Fleischer","Tom Hardy");
        Details details7 = new Details(R.drawable.avengers,"Avengers Infinity War","Russo brothers","Robert Downy jr, Josh Brolin");
        Details details8 = new Details(R.drawable.thor,"Thor-Ragnorak","Taika Waititi","Cris Hemosworth, Mark Ruffalo");
        Details details9 = new Details(R.drawable.antman,"Ant-man 2","Peyton Reed","Paul roud, Evangeline Lilly");
        Details details10 = new Details(R.drawable.deadpool,"Deadpool 2","David Leitch","Ray Raynolds, Josh Brolin");
        Details details11 = new Details(R.drawable.jurassicpark,"Jurassic world","Colin Trevorrow","Cris Patt, Bryce Dallas Howard");
        Details details12 = new Details(R.drawable.missionimpossible,"Mission Impossible Fallout","Christopher McQuarrie","Tom cruise, Rebecca Ferguson");

        arrayList.add(details1);
        arrayList.add(details2);
        arrayList.add(details3);
        arrayList.add(details4);
        arrayList.add(details5);
        arrayList.add(details6);
        arrayList.add(details7);
        arrayList.add(details8);
        arrayList.add(details9);
        arrayList.add(details10);
        arrayList.add(details11);
        arrayList.add(details12);

        m = new MyAdapter1();

        recyclerView.setAdapter(m);
        recyclerView.setLayoutManager(manager);
    }

/**************************************************************************************/
    // internet connection
    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Please connect to the Internet. \nPress ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        return builder;
    }

}
