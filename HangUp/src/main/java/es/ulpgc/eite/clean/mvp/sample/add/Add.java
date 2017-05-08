package es.ulpgc.eite.clean.mvp.sample.add;


import android.content.Context;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.app.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.InformationData;

/**
 * Created by Luis on 12/11/16.
 */

public interface Add {


  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  interface ToAdd {
    void onScreenStarted();

    void setTextVisibility(boolean visible);

      void setPlace(String place);

      void setDate(String date);

      void setHour(String hour);
  }


  interface AddTo {
    Context getManagedContext();
    String getPlaceOfTheParty();
    String getDateOfTheParty();
    String getHourOfParty();
    // boolean isTextInserted();
    List<CategoryData> getPartyAdded();

    List<InformationData> getPartyCreated();
    void destroyView();
  }


  ///////////////////////////////////////////////////////////////////////////////////
  // Screen ////////////////////////////////////////////////////////////////////////

  /**
   * Methods offered to VIEW to communicate with PRESENTER
   */

  interface ViewToPresenter extends Presenter<PresenterToView> {
    void onPublishClicked();

    //void destroyView();

    //void onStartingView();
  }

  /**
   * Required VIEW methods available to PRESENTER
   */

  interface PresenterToView extends ContextView {


    //captamos la hora del  String getHourOfInit();

    //captamos la hora del timePicker que indica el fin de la fiesta


    void finishScreen();
    void hideToolbar();



    void setPublishBtnLabel(String txt);


    void setTitleLabel(String txt);

    void setPlaceLabel(String txt);

    void setDateLabel(String txt);

    void setTimeInitLabel(String txt);

    void setTimeFinishLabel(String txt);

    void hideText();

    void setText(String txt);

    void setLabel(String txt);

    String getMonth();

    String getDay();

    int getYear();

    String getPlaceOfTheParty();

    int getHourOfInit();


    //captamos la hora del timePicker que indica el fin de la fiesta
    //@TargetApi(Build.VERSION_CODES.M)
    int getHourOfFinish();

    /*String getTitleFromEditText();

    String getPlaceFromEditText();

    String getHourInit();

    String getHourFinish();

    String getDateFromCalendar();*/
  }

  /**
   * Methods offered to MODEL to communicate with PRESENTER
   */

  interface PresenterToModel extends Model<ModelToPresenter> {

    String getPlaceLabel();


    String getPublishBtnLabel();

    String getDateLabel();

    String getTimeInitLabel();

    String getTimeFinishLabel();

    String getTitleLabel();


    void setPlaceLabel(String placeLabel);

    void setDateLabel(String dateLabel);

    void setTimeInitLabel(String timeInitLabel);

    void setTimeFinishLabel(String timeFinishLabel);

    void setPublishLabel(String publishLabel);

    void setTitleLabel(String titleLabel);

    String getPlaceOfTheParty();

    String getDateOfTheParty();

    String getHourOfParty();


    void setDay(String day);
    void setHourOfFinish(int hour);
    void setHourOfInit(int hour);
    void setMonth(String month);
    void setPlaceOfTheParty(String place);
    void setYear(int year);

    List<CategoryData> getPartyAdded();

    List<InformationData> getParty();
  }

  /**
   * Required PRESENTER methods available to MODEL
   */
  interface ModelToPresenter {

//    String getDay();
//
//    String getMonth();
//
//    int getInitTIme();
//    String getPlace();
//
//    int getYear();
//
//    int getFinishTime();

    /* public void SaveParty() {
         getView().getDay();
         getView().getMonth();
         getView().getYear();
         getView().getHourOfInit();
         getView().getHourOfFinish();
         getView().getPlaceOfTheParty();
     }*/

  }


}
