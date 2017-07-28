package com.example.phamm.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Fragment fragment,fragment1;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fragment phải
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         fragment = new fragment1();
        fragmentTransaction.add(R.id.frameLayout1,fragment);
        //fragment trái
        fragment1 =new fragment2();
        fragmentTransaction.add(R.id.frameLayout2,fragment1,"TAG");
        fragmentTransaction.addToBackStack("aaa");
        fragmentTransaction.commit();

    }
    public void addFragment(View view ){
        count +=1;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (count %2==0) {
            fragment = new fragment3();
            fragmentTransaction.replace(R.id.frameLayout1, fragment);
            fragmentTransaction.commit();

        }else {
            fragment1 = new fragment1();
            fragmentTransaction.replace(R.id.frameLayout1,fragment1);
            fragmentTransaction.commit();
        }

    }
    public void RemoveFragment(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment2 fragment = (fragment2) getFragmentManager().findFragmentByTag("TAG");
        if(fragment!=null){
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
        }else Toast.makeText(this, "FRAGMENT KHÔNG TỒN TẠI", Toast.LENGTH_SHORT).show();

    }

}
