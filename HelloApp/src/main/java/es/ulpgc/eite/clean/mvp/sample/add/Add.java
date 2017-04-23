package es.ulpgc.eite.clean.mvp.sample.add;


import android.content.Context;
import android.support.v7.widget.Toolbar;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by Luis on 12/11/16.
 */

public interface Add {


  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  interface AddToHangApp {

    boolean isTextVisible();

    Context getManagedContext();
  }

  interface ToAdd {
    void onScreenStarted();

    void setTextVisibility(boolean visible);
  }

  interface AddTo {
    Context getManagedContext();
    void destroyView();

    boolean isTextVisible();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Screen ////////////////////////////////////////////////////////////////////////

  /**
   * Methods offered to VIEW to communicate with PRESENTER
   */
  interface ViewToPresenter extends Presenter<PresenterToView> {
    void onPublishClicked();

    //void onStartingView();
  }

  /**
   * Required VIEW methods available to PRESENTER
   */
  interface PresenterToView extends ContextView {
    Toolbar getToolbar();



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
  }

  /**
   * Required PRESENTER methods available to MODEL
   */
  interface ModelToPresenter {

  }

  public interface DummyTo {
  }

  public interface SearchTo {
  }

  public interface ToHangApp {
  }



  interface HangAppTo {
    Context getManagedContext() ;


    void destroyView();
  }


}
