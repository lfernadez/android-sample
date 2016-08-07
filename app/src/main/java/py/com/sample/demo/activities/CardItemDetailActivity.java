package py.com.sample.demo.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import py.com.sample.demo.R;

/**
 *
 */
public class CardItemDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME_DETAIL = "name_title";
    public static final String EXTRA_IMAGE_ID_RESOURCE = "image_resource_id";
    private ImageView backdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_item_detail);
        backdrop = (ImageView) findViewById(R.id.backdrop);

        Intent intent = getIntent();
        backdrop.setImageResource(intent.getIntExtra(EXTRA_IMAGE_ID_RESOURCE,R.drawable.bus_5));

        String title = intent.getStringExtra(EXTRA_NAME_DETAIL);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(title);
    }
}
