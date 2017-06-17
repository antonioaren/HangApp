package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by eleonora on 24/05/2017.
 */

public class EspressoTest  {

    @Rule public final ActivityTestRule<CategoryView> presenter= new ActivityTestRule<>(CategoryView.class);


    @Test
    public void testOnAddClickedFromMainScreen() {

        onView(withId(R.id.fButtonAddCategory)).perform(click());

        onView(withId(R.id.textPhoto)).check(matches(isDisplayed()));
        onView(withId(R.id.textName)).check(matches(isDisplayed()));
        onView(withId(R.id.radioGroup)).check(matches(isDisplayed()));
        onView(withId(R.id.content_name)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd2)).check(matches(isDisplayed()));
    }

    @Test
    public void testOnAddClickeFromAddCategoryScreen() {
        //funciona
        //the test starts at main screen
        onView(withId(R.id.fButtonAddCategory)).perform(click());
        onView(withId(R.id.buttonAdd2)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd2)).perform(click());

        onView(withId(R.id.recycler)).check(matches(isDisplayed()));


    }


    @Test
    public void testClickingAnItemAtSpecificPositionInRecyclerView() throws Exception {
        //funciona
        onView(withId(R.id.recycler))
                // Click item at position 3
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.fButtonAddProduct)).check(matches(isDisplayed()));


    }

    @Test
    public void insertCategoryFromAddScreen() {
        //funciona

        onView(withId(R.id.fButtonAddCategory)).perform(click());
        // Types a message into a EditText element.
        onView(withId(R.id.content_name))
                .perform(typeText("Fiestas"), closeSoftKeyboard());

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.buttonAdd2)).perform(click());
        onView(withText("Fiestas")).check(matches(isDisplayed()));
        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.

    }
    @Test
    public void testInsertingANewPartyInACategory() throws Exception {
        //funciona
        onView(withId(R.id.recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));

        onView(withId(R.id.fButtonAddProduct)).perform(click());
        onView(withId(R.id.name))
                // Types a message into a EditText element.
                .perform(typeText("anime"), closeSoftKeyboard());
        onView(withId(R.id.place))
                .perform(typeText("tokyo"), closeSoftKeyboard());
//        onView(withId(R.id.date))
//                .perform(typeText("4 07 2017 "), closeSoftKeyboard());
        onView(withId(R.id.timeI))
                .perform(typeText("16:00"), closeSoftKeyboard());

        onView(withId(R.id.TimeF))
                .perform(typeText("21:00"), closeSoftKeyboard());

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.Add)).perform(click());
        onView(withText("anime")).check(matches(isDisplayed()));
        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.


    }






  @Test
    public void insertEventTestBeforeStartingApplication(){
      //funciona
      final CategoryModel c = new CategoryModel();
      c.CreateDatabaseTables();
      RealmConfiguration testConfig =
              new RealmConfiguration.Builder().
                      inMemory().
                      name("test-realm1").build();

      Realm testRealm = Realm.getInstance(testConfig);

     testRealm.executeTransaction(new Realm.Transaction() {
         @Override
         public void execute(Realm realm) {


             c.insertEvent("jkhkih", "disco.jpg");
             c.insertEvent("jjh", "disco.jpg");
         }
                                  }
     );
      //comprobacion del test con un metodo
      Assert.assertEquals(7, c.getNumberOfCategories());
  }

    @Test
    public void DeleteEventTest()throws Exception{
        //no funciona ,debo corregir
        final CategoryModel categoryModel = new CategoryModel();
        categoryModel.CreateDatabaseTables();
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm").build();

        Realm testRealm = Realm.getInstance(testConfig);

        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                categoryModel.deleteItemById("Fiestas");

            }
        });

        //comprobacion necesaria
        Assert.assertEquals(4, categoryModel.getNumberOfCategories());
    }


    @Test
    public void SearchEventTest() throws Exception {
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm").build();

        Realm testRealm = Realm.getInstance(testConfig);

        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<CategoryData> pups = realm.where(CategoryData.class)
                        .equalTo("CategoryName", "Música")
                        .equalTo("CategoryName", "Fiestas")
                        .equalTo("CategoryName", "Astronomía")
                        .equalTo("CategoryName", "ULPGC")
                        .findAll();


            }

        });
    }

}

