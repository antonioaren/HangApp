package es.ulpgc.eite.clean.mvp.sample.information;

import es.ulpgc.eite.clean.mvp.Model;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class InformationModel implements Model<Information.ModelToPresenter> {


    @Override
    public void onCreate(Information.ModelToPresenter modelToPresenter) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    public String getDefaulParty() {
        return "";
    }
}
