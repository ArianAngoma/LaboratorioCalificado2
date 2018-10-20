package com.angoma.arianpc.laboratoriocalificado.activities;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.angoma.arianpc.laboratoriocalificado.adapters.NoteAdapter;
import com.angoma.arianpc.laboratoriocalificado.models.Note;
import com.angoma.arianpc.laboratoriocalificado.repositories.FragmentExplore;
import com.angoma.arianpc.laboratoriocalificado.repositories.FragmentQuiz;
import com.angoma.arianpc.laboratoriocalificado.repositories.FragmentStore;
import com.angoma.arianpc.laboratoriocalificado.R;
import com.angoma.arianpc.laboratoriocalificado.adapters.ViewPagerAdapter;
import com.angoma.arianpc.laboratoriocalificado.repositories.NoteRepository;

import java.util.List;

public class FragmentsActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    FragmentQuiz notasFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        notasFrag  = new FragmentQuiz();
        adapter.AddFragment(notasFrag, "Notas");
        adapter.AddFragment(new FragmentExplore(), "Favoritos");
        adapter.AddFragment(new FragmentStore(), "Archivados");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void callRegisterForm(View view) {
        startActivityForResult(new Intent(this, AddActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        notasFrag.refreshList();
    }

}
