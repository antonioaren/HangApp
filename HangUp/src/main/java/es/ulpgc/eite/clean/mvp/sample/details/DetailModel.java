package es.ulpgc.eite.clean.mvp.sample.details;

import android.net.Uri;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class DetailModel extends GenericModel<Detail.ModelToPresenter>
        implements Detail.PresenterToModel {

    private String headerPlace;
    private String headerDate;
    private String headerTimeInit;
    private String headerTimeEnd;

    private ProductData itemSelected;


    @Override
    public void onCreate(Detail.ModelToPresenter presenter) {
        super.onCreate(presenter);

        headerPlace = "Place";
        headerDate = "Date";
        headerTimeInit = "Start";
        headerTimeEnd = "Finish";

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
        return headerPlace;
    }

    @Override
    public String getHeaderDateLabel() {
        return headerDate;
    }

    @Override
    public String getHeaderTimeInitLabel() {
        return headerTimeInit;
    }

    @Override
    public String getHeaderTimeEndLabel() {
        return headerTimeEnd;
    }

    @Override
    public Uri getImage() {
        return uriloadImageFromStorage(itemSelected.getImage());
    }

    private Uri uriloadImageFromStorage(String path) {
        return Uri.parse(path);
    }

//    private Bitmap loadImageFromStorage(String path) {
//        Bitmap b = null;
//        try {
//            File f = new File(path, "profile.jpg");
//            b = BitmapFactory.decodeStream(new FileInputStream(f));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return b;
//    }

}
