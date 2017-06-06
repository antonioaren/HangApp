package es.ulpgc.eite.clean.mvp.sample.deleteProduct;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class DeleteProductView extends GenericActivity<DeleteProduct.PresenterToView, DeleteProduct.ViewToPresenter, DeleteProductPresenter>
        implements DeleteProduct.PresenterToView {

    // ActionBar ab;
    Button delete;
    TextView text;
    EditText ediText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onDeleteButtonClicked();

            }
        });
        text = (TextView) findViewById(R.id.text);
        ediText = (EditText) findViewById(R.id.editText);


    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
        super.onResume(DeleteProductPresenter.class, this);
      

    }

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void setDeleteBtnLabel(String txt) {
        delete.setText(txt);
    }



    @Override
    public String getTextFromEditText() {
        return ediText.getText().toString();
    }



}

