package es.ulpgc.eite.clean.mvp.sample.information;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by eleonora on 21/04/2017.
 */

public class PartiesByCategoriesModel extends GenericModel<PartiesByCategories.ModelToPresenter>
        implements PartiesByCategories.PresenterToModel{
    String[] CulturalParties= new String[]{"Concierto de Vivaldi en Alfredo Kraus","Convencion de Anime en Triana"};
    String[] Concerts=new String[]{"Concierto de FallOutBoy en las Palmas a las 21:00"};
    String[]verbenas=new String[]{"Verbena en Tafira"};
    String[]cinema= new String[]{"Yelmo Cines estrena la nueva pelicula de los pitufos"};
    String []discotecas=new String[]{"Nueva discoteca en Maspalomas"};
    String[]defaultParty=  new String[]{"Party 1 soon..."};
    @Override
    public String[]getCulturalParties(){
    return CulturalParties;
     }

     @Override
     public String[]getConcerts(){
    return Concerts;
}
    @Override
    public String[]getVerbenas(){
        return verbenas;
    }
    @Override
    public String[]getcinemas(){
        return cinema;
    }
    @Override
    public String[]discotecas(){
        return discotecas;
    }
    @Override
    public String[]getDefaulParty(){
        return defaultParty;
    }

}
