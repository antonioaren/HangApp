package es.ulpgc.eite.clean.mvp.sample.details;

import android.graphics.Bitmap;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public interface Detail {
    public interface PresenterToView extends ContextView {

        void setHeaderPlace(String txt);

        void setHeaderDate(String txt);

        void setHeaderTimeInit(String txt);

        void setHeaderTimeEnd(String txt);

        void setEventName(String txt);

        void setDetail(String txt);

        void setPlace(String txt);

        void setDate(String txt);

        void setTimeInit(String txt);

        void setTimeEnd(String txt);

        void setImage(Bitmap image);
    }

    public interface ViewToPresenter {
    }

    public interface PresenterToModel {
        void setItemSelected(ProductData itemSelected);

        ProductData getItemSelected();

        String getHeaderPlaceLabel();

        String getHeaderDateLabel();

        String getHeaderTimeInitLabel();

        String getHeaderTimeEndLabel();

        Bitmap getImage();

    }

    public interface ModelToPresenter {
    }

    public interface ToDetail {
        void setItemSelected(ProductData itemSelected);

        void onScreenStarted();
    }

    public interface DetailTo {
    }
}
