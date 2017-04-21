package es.ulpgc.eite.clean.mvp.sample.hangapp;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;


public class HangAppModel extends GenericModel<HangApp.ModelToPresenter>
        implements HangApp.PresenterToModel {

  private String HangAppText;
  private String HangAppButtonSearchLabel;
  private String HangAppButtonAddLabel;
  private int numOfTimes;
  private String msgText;

  String[]parties;
  int[]images;
  public HangAppModel(){
    this.parties= new String[]{"Concierto de FallOutBoy en Las Palmas a las 21:00","Convencion de Anime en Triana","YelmoCines estrena la nueva pelicula de los pitufos","Verbena en Tafira","Inauguracion de la disco en Maspalomas","Concierto de Vivaldi en Alfredo Kraus"};
     this.images=new int[]{R.drawable.hat,R.drawable.hat,R.drawable.hat,R.drawable.hat,R.drawable.hat,R.drawable.hat};
  }
  /**
   * Method that recovers a reference to the PRESENTER
   * You must ALWAYS call {@link super#onCreate(Object)} here
   *
   * @param presenter Presenter interface
   */
  @Override
  public void onCreate(HangApp.ModelToPresenter presenter) {
    super.onCreate(presenter);
    HangAppButtonAddLabel="AddOne";
    HangAppButtonSearchLabel = "SearchOne";
    HangAppText = "HangApp";
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
  public String getSearchLabel() {
    return HangAppButtonSearchLabel;
  }

  @Override
  public String getAddLabel(){
    return HangAppButtonAddLabel;
  }
  @Override
  public String[] getListParties() {
    return this.parties;
  }

  @Override
  public int[]getListImages(){
  return this.images;
}
}