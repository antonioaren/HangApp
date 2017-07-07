package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by eleonora on 24/05/2017.
 */

public class EspressoTest {


    @Rule
    public final ActivityTestRule<CategoryView> presenter = new ActivityTestRule<>(CategoryView.class);


    @Test
    public void testOnAddClickedFromMainScreen() {

        onView(withId(R.id.fButtonAddCategory)).perform(click());
        onView(withId(R.id.textPhoto)).check(matches(isDisplayed()));
        onView(withId(R.id.textName)).check(matches(isDisplayed()));
        onView(withId(R.id.radioGroup)).check(matches(isDisplayed()));
        onView(withId(R.id.content_name)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddCategory)).check(matches(isDisplayed()));
    }




    @Test
    public void testClickingAnItemAtSpecificPositionInRecyclerView() throws Exception {

        onView(withId(R.id.recycler))
                // Click item at position 0
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fButtonAddProduct)).check(matches(isDisplayed()));


    }

    @Test
    public void testGoToDetailScreenFromAParty() throws Exception {
        //test realizado en base a una fiesta creada personalmente desde mi dispositivo
        testClickingAnItemAtSpecificPositionInRecyclerView();
        onView(withText("fiesta")).check(matches(isDisplayed()));
        onView(withText("fiesta")).perform(click());
        onView(withText("fiesta")).check(matches(isDisplayed()));
        onView(withText("vispera del 4 julio"));
        onView(withId(R.id.headerPlace)).check(matches(isDisplayed()));
        onView(withId(R.id.headerDate)).check(matches(isDisplayed()));
        onView(withId(R.id.headerTimeInit)).check(matches(isDisplayed()));
        onView(withId(R.id.headerTimeEnd)).check(matches(isDisplayed()));

    }


    @Test
    public void testRemoveElementWhenApplicationStarted() throws Exception {

        onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(0, swipeLeft()));

        onView(withText("Astronomía")).check(matches(isDisplayed()));
        onView(withText("Automovilismo")).check(matches(isDisplayed()));
        onView(withText("Música")).check(matches(isDisplayed()));
        onView(withText("ULPGC")).check(matches(isDisplayed()));


    }


    @Test
    public void insertEventTestBeforeStartingApplication() {
        //creamos un test con un nombre ypara que se almacene en la memoria de nustro computador
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().inMemory().name("test-realm").build();

        Realm testRealm = Realm.getInstance(testConfig);
        final RealmOperation realmOperation = new RealmOperation();
        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realmOperation.insertEventCategory("jkhkih", "disco.jpg");

            }
        });
        //probando el test con todas las categorias
        Assert.assertEquals(6, realmOperation.getCategoryEvents().size());
    }

    @Test
    public void deleteEvent() {
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().inMemory().name("test-realm1").build();
        Realm testRealm = Realm.getInstance(testConfig);
        final RealmOperation realmOperation = new RealmOperation();
        testRealm.executeTransaction(new Realm.Transaction() {
                                         @Override
                                         public void execute(Realm realm) {
                                             realmOperation.insertEventCategory("jkhkih", "disco.jpg");
                                             realmOperation.insertEventCategory("jjh", "disco.jpg");
                                             String idLastElement = realmOperation.getId();
                                             realmOperation.deleteItemCategory(idLastElement);
                                         }
                                     }
        );
        //comprobacion del test con un metodo
        //probando el test con todas las categorias
        Assert.assertEquals(6, realmOperation.getCategoryEvents().size());

    }

    @Test
    public void testGetFirstElementName() {
        //probando el test cuando existen todas las categorias de la bd
        RealmOperation realm = new RealmOperation();
        Assert.assertEquals("Fiestas", realm.getCategoryEvents().first().getCategoryName());
    }

    @Test
    public void testGetLastElementName() {
        //probando el test cuando existen todas las categorias de la bd
        RealmOperation realm = new RealmOperation();
        Assert.assertEquals("Automovilismo", realm.getCategoryEvents().last().getCategoryName());
    }

}

