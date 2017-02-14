package droidbottle.com.starsandnebulae;

/**
 * Created by gopikrishnan.an on 09-02-2017.
 */

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class NewMainActivity extends AppCompatActivity{

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;

    public static String[] gridViewStrings = {
            "Android",
            "Java",
            "GridView",
            "ListView",
            "Adapter",
            "Custom GridView",
            "Material",
            "XML",
            "Code",

    };
    public static int[] gridViewImages = {
            R.drawable.space_1,
            R.drawable.space_2,
            R.drawable.space_3,
            R.drawable.space_4,
            R.drawable.space_5,
            R.drawable.space_6,
            R.drawable.space_7,
            R.drawable.space_1,
            R.drawable.space_2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //
        gridView = (GridView) findViewById(R.id.grid);
        final CustomAndroidGridViewAdapter gridViewAdapter = new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(NewMainActivity.this, "You Clicked at " +gridViewStrings[+ position], Toast.LENGTH_SHORT).show();

            }
        });

        initInstances();
    }

    private void initInstances() {
        rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayoutAndroid.setTitle("Stars & Nebulae");
    }
    //Method to handle back button click in tool bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            System.out.println("------------########################--------------- ");
            Toast.makeText(this, "Back button clicked", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


}