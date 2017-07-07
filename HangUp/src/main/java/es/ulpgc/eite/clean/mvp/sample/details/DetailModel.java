package es.ulpgc.eite.clean.mvp.sample.details;

import android.net.Uri;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class DetailModel extends GenericModel<Detail.ModelToPresenter>
        implements Detail.PresenterToModel {

    private static final String HEADER_PLACE = "Place";
    private static final String HEADER_DATE = "Date";
    private static final String HEADER_TIME_INIT = "Start";
    private static final String HEADER_TIME_END = "Finish";

    private ProductData itemSelected;


    @Override
    public void onCreate(Detail.ModelToPresenter presenter) {
        super.onCreate(presenter);



    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }

    @Override
    public void setItemSelected(ProductData itemSelected) {
        this.itemSelected = itemSelected;
    }

    @Override
    public ProductData getItemSelected() {
        return itemSelected;
    }

    @Override
    public String getHeaderPlaceLabel() {
        return HEADER_PLACE;
    }

    @Override
    public String getHeaderDateLabel() {
        return HEADER_DATE;
    }

    @Override
    public String getHeaderTimeInitLabel() {
        return HEADER_TIME_INIT;
    }

    @Override
    public String getHeaderTimeEndLabel() {
        return HEADER_TIME_END;
    }

    @Override
    public Uri getImage() {
        return uriloadImageFromStorage(itemSelected.getImage());
    }

    private Uri uriloadImageFromStorage(String path) {
        return Uri.parse(path);
    }


}
