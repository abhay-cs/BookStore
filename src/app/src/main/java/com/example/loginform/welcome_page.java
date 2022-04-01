package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.loginform.databinding.ActivityMainBinding;
import com.example.loginform.databinding.ActivityWelcomePageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class welcome_page extends AppCompatActivity {


    ActivityWelcomePageBinding binding;
//    BottomNavigationView bottomNavigationView = new BottomNavigationView(R.id.bottomNavigationView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());


        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){

                case R.id.homePage:

                    replaceFragment(new HomeFragment());

                    break;

                case R.id.cart:

                    replaceFragment(new CartFragment());
                    break;

                case R.id.watchList:
                    replaceFragment(new WatchListFragment());
                    break;

                case R.id.userProfile:
                    replaceFragment(new UserFragment());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}