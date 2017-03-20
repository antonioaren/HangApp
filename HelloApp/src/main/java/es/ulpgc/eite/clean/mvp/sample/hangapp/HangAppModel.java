package es.ulpgc.eite.clean.mvp.sample.hangapp;

import es.ulpgc.eite.clean.mvp.GenericModel;


public class HangAppModel extends GenericModel<HangApp.ModelToPresenter>
    implements HangApp.PresenterToModel {

  private String HangAppText;
  private String HangAppLabel;
  private int numOfTimes;
  private String msgText;

  /**
   * Method that recovers a reference to the PRESENTER
   * You must ALWAYS call {@link super#onCreate(Object)} here
   *
   * @param presenter Presenter interface
   */
  @Override
  public void onCreate(HangApp.ModelToPresenter presenter) {
    super.onCreate(presenter);

    HangAppLabel = "Click Me!";
    HangAppText = "Hello World!";
  }

  /**
   * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
   * Usefull for kill/stop activities that could be running on the background Threads
   *
   * @param isChangingConfiguration Informs that a change is occurring on the configuration
   */
  @Override
  public void onDestroy(boolean isChangingConfiguration) {

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To Model ////////////////////////////////////////////////////////////


  @Override
  public void onChangeMsgByBtnClicked() {
    msgText = HangAppText;
    if(numOfTimes > 0) {
      msgText += ", " + numOfTimes + " times";
    }
    numOfTimes++;
  }

  @Override
  public String getText() {
    return msgText;
  }

  @Override
  public String getLabel() {
    return HangAppLabel;
  }
}
