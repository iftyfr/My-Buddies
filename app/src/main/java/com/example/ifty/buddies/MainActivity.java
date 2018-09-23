package com.example.ifty.buddies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView buddyLv;
    RecyclerView buddyRv;
    ArrayList <Buddy>buddies;
    private RecyclerView.LayoutManager layoutManager;
    static int viewOption=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buddies=new ArrayList<>();
        buddies.add(new Buddy(R.drawable.faisal,"Faisal","+01700000000","faisaljamil@gmail.com","B+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.munna,"munna","+01700000000","munna@gmail.com","AB+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.ratul,"ratul","+01700000000","munna@gmail.com","O+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.nazib,"Nazib","+01700000000","nazib@gmail.com","B-","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.shihab,"shihab","+01700000000","shihab@gmail.com","A+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.galib,"Galib","+01700000000","galib@gmail.com","A-","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.faisal,"Faisal","+01700000000","faisaljamil@gmail.com","B+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.munna,"munna","+01700000000","munna@gmail.com","AB+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.ratul,"ratul","+01700000000","munna@gmail.com","O+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.nazib,"Nazib","+01700000000","nazib@gmail.com","B-","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.shihab,"shihab","+01700000000","shihab@gmail.com","A+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.galib,"Galib","+01700000000","galib@gmail.com","A-","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.faisal,"Faisal","+01700000000","faisaljamil@gmail.com","B+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.munna,"munna","+01700000000","munna@gmail.com","AB+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.ratul,"ratul","+01700000000","munna@gmail.com","O+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.nazib,"Nazib","+01700000000","nazib@gmail.com","B-","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.shihab,"shihab","+01700000000","shihab@gmail.com","A+","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));
        buddies.add(new Buddy(R.drawable.galib,"Galib","+01700000000","galib@gmail.com","A-","R# 17, Block# D, Mirpur-1 ,Dhaka 1216."));




        if (viewOption==0){
            buddyLv=findViewById(R.id.buddyLv);
            buddyLv.setVisibility(View.VISIBLE);
            BuddiesAdapter buddiesAdapter=new BuddiesAdapter(this,buddies);
            buddyLv.setAdapter(buddiesAdapter);
        }
        else {
            buddyRv=findViewById(R.id.buddyRv);
            buddyRv.setVisibility(View.VISIBLE);
            buddyRv.setHasFixedSize(true);
            buddyRv.setLayoutManager(new GridLayoutManager(this, 3));
            BuddiesRvAdapter buddiesRvAdapter=new BuddiesRvAdapter(this,buddies);
            buddyRv.setAdapter(buddiesRvAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_option_menu,menu);
        return true;
    }

    public void listVmenu(MenuItem item) {
        viewOption=0;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void gridVmenu(MenuItem item) {
        viewOption=1;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
