package es.ulpgc.eite.clean.mvp.sample.information;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by eleonora on 21/04/2017.
 */

public class PartiesByCategoriesModel extends GenericModel<PartiesByCategories.ModelToPresenter>
        implements PartiesByCategories.PresenterToModel{
    String titleLabel;
 String[]CulturalParties,Concerts,verbenas,cinema,discotecas,defaultParty;
public PartiesByCategoriesModel(){
    defaultParty=  new String[]{"Party 1 soon...","Party 2 soon..."};
}
    @Override
    public void onCreate(PartiesByCategories.ModelToPresenter presenter) {
        super.onCreate(presenter);

       titleLabel="Parties of this category";
        CulturalParties= new String[]{"Concierto de Vivaldi en Alfredo Kraus","Convencion de Anime en Triana"};
         Concerts=new String[]{"Concierto de FallOutBoy en las Palmas a las 21:00"};
        verbenas=new String[]{"Verbena en Tafira"};
        cinema= new String[]{"Yelmo Cines estrena la nueva pelicula de los pitufos"};
        discotecas=new String[]{"Nueva discoteca en Maspalomas"};
        defaultParty=  new String[]{"Party 1 soon...","Party 2 soon..."};
    }
    @Override
    public String getTitleLabel(){
        return titleLabel;
    }
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
        System.out.println(defaultParty);
        return defaultParty;
    }

}
