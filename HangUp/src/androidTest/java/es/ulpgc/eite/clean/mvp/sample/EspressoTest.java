package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
/**
 * Created by eleonora on 24/05/2017.
 */

public class EspressoTest  {

    @Rule public final ActivityTestRule<CategoryView> presenter= new ActivityTestRule<>(CategoryView.class);


//    @Test
//    public void testOnAddClickedFromMainScreen() {
//        onView(withId(R.id.buttonAdd)).perform(click());
//        //actualizando test
//        onView(withId(R.id.textPhoto)).check(matches(isDisplayed()));
//        onView(withId(R.id.textName)).check(matches(isDisplayed()));
//        onView(withId(R.id.radioGroup)).check(matches(isDisplayed()));
//        onView(withId(R.id.content_name)).check(matches(isDisplayed()));
//        onView(withId(R.id.buttonAdd2)).check(matches(isDisplayed()));
//    }

   /* @Test
    public void testOnAddClickeFromAddCategoryScreen() {
        //the test starts at main screen
        onView(withId(R.id.buttonAdd)).perform(click());
        onView(withId(R.id.buttonAdd2)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd2)).perform(click());
        //actualizando test

        onView(withId(R.id.recycler)).check(matches(isDisplayed()));

        onView(withId(R.id.buttonSearch)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd)).check(matches(isDisplayed()));
    }

    @Test
    public void testOnSearchCliked() throws Exception {
        onView(withId(R.id.buttonSearch)).perform(click());
        onView(withId(R.id.delete)).check(matches(isDisplayed()));
        onView(withId(R.id.deleteId)).check(matches(isDisplayed()));
        onView(withId(R.id.text)).check(matches(isDisplayed()));
        onView(withId(R.id.text2)).check(matches(isDisplayed()));
        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withId(R.id.editText2)).check(matches(isDisplayed()));

    }
    @Test
    public void testClickingAnItemAtSpecificPositionInRecyclerView() throws Exception {

        onView(withId(R.id.recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.buttonDelete)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd)).check(matches(isDisplayed()));
// Click item at position 3

    }

    @Test
    public void insertCategoryFromAddScreen() {


        onView(withId(R.id.buttonAdd)).perform(click());
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

        onView(withId(R.id.recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.buttonDelete)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd)).perform(click());
        onView(withId(R.id.name))
                // Types a message into a EditText element.
                .perform(typeText("anime convention"), closeSoftKeyboard());
        onView(withId(R.id.place))
                .perform(typeText("tokyo"), closeSoftKeyboard());
        onView(withId(R.id.date))
                .perform(typeText("4/07/2017"), closeSoftKeyboard());
        onView(withId(R.id.timeI))
                .perform(typeText("16:00"), closeSoftKeyboard());

        onView(withId(R.id.TimeF))
                .perform(typeText("21:00"), closeSoftKeyboard());

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.Add)).perform(click());
        onView(withText("anime convention")).check(matches(isDisplayed()));
        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.


    }






  @Test
    public void insertEventTestBeforeStartingApplication(){
    final  CategoryModel c= new CategoryModel();
      RealmConfiguration testConfig =
              new RealmConfiguration.Builder().
                      inMemory().
                      name("test-realm").build();

      Realm testRealm = Realm.getInstance(testConfig);

     testRealm.executeTransaction(new Realm.Transaction() {
         @Override
         public void execute(Realm realm) {
             c.insertEvent("Fiestas", R.drawable.astro);
         }
     });
  }

    @Test
    public void DeleteEventTest()throws Exception{
        final DeleteModel search = new DeleteModel();
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm").build();

        Realm testRealm = Realm.getInstance(testConfig);

        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                search.deteleEvent("Música");

            }
        });
    }

    @Test
    public void testDeleteEventByIdTest() throws Exception {
        final DeleteModel delete = new DeleteModel();
        RealmConfiguration testConfig = new RealmConfiguration.Builder().inMemory().name("test-deleteById").build();
        Realm testRealm = Realm.getInstance(testConfig);
        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                delete.deleteCategoryById("2");

            }
        });
    }*/

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

