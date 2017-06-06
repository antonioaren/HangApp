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
    Button btnDeleteProduct;
    private TextView textTitleDelete;
    private EditText ediTextProduct;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteproduct);
        btnDeleteProduct = (Button) findViewById(R.id.btnDeleteProduct);
        btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onDeleteButtonClicked();

            }
        });
        textTitleDelete = (TextView) findViewById(R.id.textTitleDelete);
        ediTextProduct = (EditText) findViewById(R.id.editTextProduct);


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
        btnDeleteProduct.setText(txt);
    }



    @Override
    public String getTextFromEditText() {
        return ediTextProduct.getText().toString();
    }



}

