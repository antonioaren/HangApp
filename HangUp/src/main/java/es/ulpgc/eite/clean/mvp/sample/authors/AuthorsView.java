package es.ulpgc.eite.clean.mvp.sample.authors;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by eleonora on 12/07/2017.
 */

public class AuthorsView extends GenericActivity<Authors.PresenterToView, Authors.ViewToPresenter, AuthorsPresenter>
        implements Authors.PresenterToView {


    private TextView text;
    private ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);
        text = (TextView) findViewById(R.id.textAuthors);
        image = (ImageView) findViewById(R.id.imageAuthors);

    }

    @Override
    protected void onResume() {
        super.onResume(AuthorsPresenter.class, this);

    }

    @Override
    public void setText(String txt) {
        text.setText(txt);
    }

    @Override
    public void setImage(int res) {
        image.setImageResource(res);
    }
}
