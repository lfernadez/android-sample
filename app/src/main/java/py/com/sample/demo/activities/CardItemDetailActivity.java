package py.com.sample.demo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import py.com.sample.demo.R;

/**
 *
 */
public class CardItemDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME_DETAIL = "name_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_item_detail);
    }
}
